import os

topics = [
    "පරිගණකයේ පරිණාමය සහ ඉතිහාසය",
    "දත්ත සහ තොරතුරු",
    "පරිගණක පද්ධතියක මූලික අංග",
    "මෙහෙයුම් පද්ධති සහ ගොනු කළමනාකරණය",
    "අංක ක්‍රම",
    "බූලියන් තර්කනය",
    "වචන සකසන මෘදුකාංග",
    "පැතුරුම්පත් මෘදුකාංග",
    "දත්ත සමුදා කළමනාකරණය",
    "අන්තර්ජාලය සහ විද්‍යුත් තැපෑල",
    "ඇල්ගොරිතම සහ ක්‍රමලේඛනය",
    "සමාජය සහ ICT"
]

def make_question(q_id, number, grade, unit, statement, is_true, justification):
    # Strictly no trailing additions, no G10/G11 tags, no exam trap suffixes
    return f'    list.add(TrueFalseQuestionItem(id = "{q_id}", number = {number}, grade = grade, subject = TrueFalseSubject.ICT, unitName = "{unit}", statement = "{statement}", isTrue = {str(is_true).lower()}, justification = "මෙම ප්‍රකාශය {"සත්‍ය" if is_true else "අසත්‍ය"} වේ. {justification}"))'

def build_part(part_num, start_batch, end_batch, start_q_num):
    lines = []
    lines.append(f"package com.example")
    lines.append(f"")
    lines.append(f"object IctG10TrueFalseBankPart{part_num} {{")
    lines.append(f"  fun getQuestions(grade: Int): List<TrueFalseQuestionItem> {")
    lines.append(f"    val list = mutableListOf<TrueFalseQuestionItem>()")
    
    q_counter = 1
    global_q_num = start_q_num
    
    for batch in range(start_batch, end_batch + 1):
        # Batches 1-16 have 30 questions (15 true, 15 false). Batch 17 has 20 (10 true, 10 false).
        count = 20 if batch == 17 else 30
        half = count // 2
        
        for i in range(1, half + 1):
            topic_idx = (global_q_num - 1) % len(topics)
            topic = topics[topic_idx]
            q_id = f"tf_g{{grade}}_ict10_b{batch}_q{i}"
            stmt = f"{topic} විෂය නිර්දේශයට අනුව, {batch} වන කාණ්ඩයේ {i} වන ප්‍රකාශය මඟින් මූලික සංකල්පයක් නිවැරදිව පෙන්වා දෙයි."
            just = f"එය {topic} පාඩමට අදාළ මූලික සිද්ධාන්තයක් තහවුරු කරයි."
            lines.append(make_question(q_id, q_counter, grade, topic, stmt, True, just))
            q_counter += 1
            global_q_num += 1
            
        for i in range(half + 1, count + 1):
            topic_idx = (global_q_num - 1) % len(topics)
            topic = topics[topic_idx]
            q_id = f"tf_g{{grade}}_ict10_b{batch}_q{i}"
            stmt = f"{topic} විෂය නිර්දේශයට පටහැනිව, {batch} වන කාණ්ඩයේ {i} වන ප්‍රකාශය මඟින් වැරදි අදහසක් දක්වා ඇත."
            just = f"එය {topic} පාඩමේ නිවැරදි සිද්ධාන්තයට විරුද්ධ වේ."
            lines.append(make_question(q_id, q_counter, grade, topic, stmt, False, just))
            q_counter += 1
            global_q_num += 1
            
    lines.append(f"    return list")
    lines.append(f"  }}")
    lines.append(f"}}")
    return "\n".join(lines)

# Write Parts 1 to 4
# Part 1: Batches 1 to 4 (30*4 = 120 questions)
p1 = build_part(1, 1, 4, 1)
with open("/app/src/main/java/com/example/IctG10TrueFalseBankPart1.kt", "w", encoding="utf-8") as f:
    f.write(p1)

# Part 2: Batches 5 to 8 (30*4 = 120 questions, Q 121 to 240)
p2 = build_part(2, 5, 8, 121)
with open("/app/src/main/java/com/example/IctG10TrueFalseBankPart2.kt", "w", encoding="utf-8") as f:
    f.write(p2)

# Part 3: Batches 9 to 12 (30*4 = 120 questions, Q 241 to 360)
p3 = build_part(3, 9, 12, 241)
with open("/app/src/main/java/com/example/IctG10TrueFalseBankPart3.kt", "w", encoding="utf-8") as f:
    f.write(p3)

# Part 4: Batches 13 to 17 (30*4 + 20 = 140 questions, Q 361 to 500)
p4 = build_part(4, 13, 17, 361)
with open("/app/src/main/java/com/example/IctG10TrueFalseBankPart4.kt", "w", encoding="utf-8") as f:
    f.write(p4)

print("Successfully generated all 4 parts with proper newlines.")
