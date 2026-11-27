# -*- coding: utf-8 -*-
import re
import os

MASK_30 = [
    True, False, True, True, False, False, True, False, True, False,
    False, True, True, False, False, True, False, True, True, False,
    True, False, False, True, True, False, False, True, False, True
]

MASK_20 = [
    True, False, True, False, False, True, True, False, True, False,
    False, True, True, False, False, True, True, False, False, True
]

def is_question_true(batch_idx, topic_idx):
    if batch_idx < 16:
        offset = (batch_idx * 7 + 3) % 30
        return MASK_30[(topic_idx + offset) % 30]
    else:
        offset = (batch_idx * 3 + 1) % 20
        return MASK_20[(topic_idx + offset) % 20]

def escape_kt(text):
    return text.replace('\\', '\\\\').replace('"', '\\"').replace('$', '\\$').replace('\n', ' ').strip()

# 1. Read files
with open("app/src/main/java/com/example/SubjectMasterHistoryPart1.kt", "r", encoding="utf-8") as f:
    text1 = f.read()
with open("app/src/main/java/com/example/SubjectMasterHistoryPart2.kt", "r", encoding="utf-8") as f:
    text2 = f.read()
with open("app/src/main/java/com/example/VoiceQuizHistoryBank.kt", "r", encoding="utf-8") as f:
    text_vq = f.read()

pattern_cat = re.compile(r"titleSinhala\s*=\s*\"([^\"]+)\".*?points\s*=\s*listOf\((.*?)\)\s*\)", re.DOTALL)
pattern_pt = re.compile(r"SubjectFactPoint\(\s*\d+,\s*\"([^\"]+)\",\s*\"([^\"]+)\",\s*\"([^\"]+)\"\s*\)")

category_points = []
for m in pattern_cat.finditer(text1 + "\n" + text2):
    cat_title = m.group(1).replace("කාණ්ඩය", "").strip()
    cat_title = re.sub(r"^\d+:\s*", "", cat_title).strip()
    pts = pattern_pt.findall(m.group(2))
    for pt in pts:
        category_points.append({
            "unit": cat_title,
            "title": pt[0].strip(),
            "detail": pt[1].strip(),
            "tip": pt[2].strip()
        })

pattern_vq = re.compile(r"Quintuple\(\s*\"([^\"]+)\",\s*\"([^\"]+)\",\s*listOf\([^)]+\),\s*\"([^\"]+)\",\s*\"([^\"]+)\"\s*\)")
vq_items = pattern_vq.findall(text_vq)
vq_points = []
for q, eng, ans, note in vq_items:
    vq_points.append({
        "question": q.strip(),
        "answer": ans.strip(),
        "note": note.strip()
    })

print(f"Loaded {len(category_points)} category points and {len(vq_points)} vq points")

# Pairs for authentic natural false inversion
REPLACEMENTS = [
    ("පළමුවන විජයබාහු", "පළමුවන පරාක්‍රමබාහු"),
    ("මහා පරාක්‍රමබාහු", "නිශ්ශංකමල්ල"),
    ("නිශ්ශංකමල්ල", "මහා පරාක්‍රමබාහු"),
    ("දුටුගැමුණු", "එළාර"),
    ("එළාර", "දුටුගැමුණු"),
    ("දේවානම්පියතිස්ස", "පණ්ඩුකාභය"),
    ("පණ්ඩුකාභය", "විජය කුමරු"),
    ("ධාතුසේන", "කාශ්‍යප"),
    ("කාශ්‍යප", "ධාතුසේන"),
    ("පළමුවන විමලධර්මසූරිය", "දෙවන රාජසිංහ"),
    ("දෙවන රාජසිංහ", "පළමුවන රාජසිංහ"),
    ("පළමුවන රාජසිංහ", "මායාදුන්නේ"),
    ("කීර්ති ශ්‍රී රාජසිංහ", "ශ්‍රී වික්‍රම රාජසිංහ"),
    ("ශ්‍රී වික්‍රම රාජසිංහ", "කීර්ති ශ්‍රී රාජසිංහ"),
    ("අනුරාධපුර", "පොළොන්නරු"),
    ("පොළොන්නරු", "අනුරාධපුර"),
    ("මහනුවර", "කෝට්ටේ"),
    ("කෝට්ටේ", "මහනුවර"),
    ("සීතාවක", "මහනුවර"),
    ("පෘතුගීසි", "ලන්දේසි"),
    ("ලන්දේසි", "බ්‍රිතාන්‍ය"),
    ("බ්‍රිතාන්‍ය", "පෘතුගීසි"),
    ("වී ගොවිතැන", "මසුන් ඇල්ලීම"),
    ("සෙල්ලිපි", "කාසි"),
    ("ගල් ආයුධ", "යකඩ ආයුධ"),
    ("යකඩ ආයුධ", "ගල් ආයුධ"),
    ("ක්‍රි.පූ. 3 වන", "ක්‍රි.ව. 12 වන"),
    ("ක්‍රි.ව. 5 වන", "ක්‍රි.පූ. 5 වන"),
    ("1815", "1848"),
    ("1848", "1818"),
    ("1818", "1815"),
    ("1505", "1796"),
    ("1796", "1815"),
    ("1638", "1766"),
    ("1766", "1638")
]

def make_false(statement):
    for orig, rep in REPLACEMENTS:
        if orig in statement:
            return statement.replace(orig, rep, 1)
    
    # grammatical suffix replacements
    repls = [
        (" වේ.", " නොවේ."),
        ("වේ.", " නොවේ."),
        (" පවතී.", " නොපවතී."),
        (" කරයි.", " නොකරයි."),
        ("කරයි.", " නොකරයි."),
        (" විය.", " නොවීය."),
        ("විය.", " නොවීය."),
        (" අයත් වේ.", " අයත් නොවේ."),
        (" සාදන ලදී.", " සාදන ලද්දක් නොවේ."),
        (" ඉදි කළේය.", " ඉදි නොකළේය."),
        (" ඉදි කරන ලදී.", " ඉදි කරන ලද්දක් නොවේ."),
        (" පරාජය කළේය.", " පරාජය කිරීමට අපොහොසත් විය."),
        (" අත්සන් කරන ලදී.", " ප්‍රතික්ෂේප කරන ලදී."),
        (" ග්‍රන්ථාරූඪ කරන ලදී.", " ග්‍රන්ථාරූඪ කිරීමට නොහැකි විය."),
        (" වැඩම කළහ.", " වැඩම නොකළහ."),
        (" භාවිත කළහ.", " භාවිත නොකළහ.")
    ]
    for orig, rep in repls:
        if statement.endswith(orig):
            return statement[:-len(orig)] + rep
        if orig in statement:
            return statement.replace(orig, rep, 1)
            
    return statement.rstrip(".") + " බවට ඓතිහාසික සාක්ෂි නොමැත."

items = []
seen_statements = set()

# First, process category points (380 points)
for cp in category_points:
    unit = cp["unit"]
    detail = cp["detail"].strip().rstrip(".")
    title = cp["title"].strip()
    tip = cp["tip"].strip()
    
    true_stmt = detail + "." if len(detail) > 25 else f"{title}: {detail}."
    false_stmt = make_false(true_stmt)
    
    items.append({
        "unit": unit,
        "title": title,
        "detail": detail,
        "tip": tip,
        "true_stmt": true_stmt,
        "false_stmt": false_stmt
    })

# Next, process voice quiz items to reach 500
vq_idx = 0
while len(items) < 500 and vq_idx < len(vq_points):
    vp = vq_points[vq_idx]
    vq_idx += 1
    q = vp["question"].strip()
    ans = vp["answer"].strip()
    note = vp["note"].strip()
    
    # Form a natural declarative sentence from question and answer
    # e.g. "ලංකාවේ දැනට ඇති පැරණිතම වංශකතාව කුමක්ද?" -> "ලංකාවේ දැනට ඇති පැරණිතම වංශකතාව දීපවංශය වේ."
    clean_q = q.replace("කුමක්ද?", "").replace("කවුද?", "").replace("කොහේද?", "").replace("කෙසේද?", "").replace("කුමන රටේ සිටද?", "").replace("කුමක් නිසාද?", "").strip()
    true_stmt = f"{clean_q} {ans}".strip()
    if not true_stmt.endswith("."):
        true_stmt += "."
    false_stmt = make_false(true_stmt)
    
    items.append({
        "unit": "ඓතිහාසික කරුණු හා මූලාශ්‍ර",
        "title": clean_q[:40],
        "detail": f"{clean_q} {ans}",
        "tip": note if note else "O/L විභාග ප්‍රශ්න පත්‍රවල නිතර අසන ප්‍රධාන විෂය කරුණකි.",
        "true_stmt": true_stmt,
        "false_stmt": false_stmt
    })

print(f"Total items assembled: {len(items)}")

# Build final 500 questions adhering to mask
final_questions = []
for i in range(500):
    q_num = i + 1
    batch_idx = i // 30
    topic_idx = i % 30
    should_be_true = is_question_true(batch_idx, topic_idx)
    
    raw = items[i]
    stmt = raw["true_stmt"] if should_be_true else raw["false_stmt"]
    
    # Guarantee absolute uniqueness
    if stmt in seen_statements:
        stmt = f"{raw['title']}: {stmt}"
    if stmt in seen_statements:
        stmt = f"{raw['unit']} - {stmt}"
    seen_statements.add(stmt)
    
    if should_be_true:
        just = f"මෙම ප්‍රකාශය සත්‍ය වේ. {raw['detail']}."
        exam = raw['tip'] if raw['tip'] else "O/L විභාගයේ අනිවාර්ය කරුණකි."
    else:
        just = f"මෙම ප්‍රකාශය අසත්‍ය වේ. සැබෑ ඓතිහාසික කරුණ: {raw['detail']}."
        exam = f"විභාග අනතුරු ඇඟවීම: {raw['title']} පිළිබඳ නිවැරදි කරුණු මතක තබාගන්න."
        
    final_questions.append({
        "number": q_num,
        "unit": raw["unit"],
        "statement": stmt,
        "is_true": should_be_true,
        "justification": just,
        "exam_trap": exam
    })

print(f"Built {len(final_questions)} final questions.")
print(f"Unique statements count: {len(seen_statements)}")

# Verify mask
batch_counts = {}
for q in final_questions:
    b = (q["number"] - 1) // 30
    if b not in batch_counts:
        batch_counts[b] = {"true": 0, "false": 0}
    if q["is_true"]:
        batch_counts[b]["true"] += 1
    else:
        batch_counts[b]["false"] += 1

print("Batch balance check:")
for b in sorted(batch_counts.keys()):
    print(f"Batch {b}: True={batch_counts[b]['true']}, False={batch_counts[b]['false']}")

# Write 4 Kotlin files
chunks = [
    (1, 125, "HistoryTrueFalseBankPart1"),
    (126, 250, "HistoryTrueFalseBankPart2"),
    (251, 375, "HistoryTrueFalseBankPart3"),
    (376, 500, "HistoryTrueFalseBankPart4"),
]

for start_q, end_q, class_name in chunks:
    chunk_questions = final_questions[start_q - 1 : end_q]
    lines = []
    lines.append("package com.example")
    lines.append("")
    lines.append(f"object {class_name} {{")
    lines.append("  fun getQuestions(grade: Int): List<TrueFalseQuestionItem> {")
    lines.append("    return listOf(")
    for q in chunk_questions:
        q_num = q["number"]
        unit_str = escape_kt(q["unit"])
        stmt_str = escape_kt(q["statement"])
        just_str = escape_kt(q["justification"])
        trap_str = escape_kt(q["exam_trap"])
        b_str = "true" if q["is_true"] else "false"
        
        lines.append("      TrueFalseQuestionItem(")
        lines.append(f'        id = "tf_g${{grade}}_hist_q{q_num}",')
        lines.append(f'        number = {q_num},')
        lines.append(f'        grade = grade,')
        lines.append(f'        subject = TrueFalseSubject.HISTORY,')
        lines.append(f'        unitName = "{unit_str}",')
        lines.append(f'        statement = "{stmt_str}",')
        lines.append(f'        isTrue = {b_str},')
        lines.append(f'        justification = "{just_str}",')
        lines.append(f'        examTrapOrFact = "{trap_str}"')
        lines.append("      ),")
    lines.append("    )")
    lines.append("  }")
    lines.append("}")
    lines.append("")
    
    out_path = f"app/src/main/java/com/example/{class_name}.kt"
    with open(out_path, "w", encoding="utf-8") as out_f:
        out_f.write("\n".join(lines))
    print(f"Wrote {out_path} ({len(chunk_questions)} questions)")

# Write HistoryTrueFalseCuratedBank.kt
curated_code = """package com.example

object HistoryTrueFalseCuratedBank {
  fun get500Questions(grade: Int): List<TrueFalseQuestionItem> {
    return HistoryTrueFalseBankPart1.getQuestions(grade) +
           HistoryTrueFalseBankPart2.getQuestions(grade) +
           HistoryTrueFalseBankPart3.getQuestions(grade) +
           HistoryTrueFalseBankPart4.getQuestions(grade)
  }
}
"""
with open("app/src/main/java/com/example/HistoryTrueFalseCuratedBank.kt", "w", encoding="utf-8") as f:
    f.write(curated_code)
print("Wrote HistoryTrueFalseCuratedBank.kt")
