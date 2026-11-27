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
    return text.replace('\\', '\\\\').replace('"', '\\"').replace('$', '\\$').replace('\n', ' ')

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

print(f"Extracted {len(category_points)} category points and {len(vq_points)} voice quiz items")
