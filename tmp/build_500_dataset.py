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

# 1. Extract SubjectMasterHistoryPart1 points (200 points)
with open("app/src/main/java/com/example/SubjectMasterHistoryPart1.kt", "r", encoding="utf-8") as f:
    text1 = f.read()
# 2. Extract SubjectMasterHistoryPart2 points (200 points)
with open("app/src/main/java/com/example/SubjectMasterHistoryPart2.kt", "r", encoding="utf-8") as f:
    text2 = f.read()
# 3. Extract VoiceQuizHistoryBank questions (275 questions)
with open("app/src/main/java/com/example/VoiceQuizHistoryBank.kt", "r", encoding="utf-8") as f:
    text_vq = f.read()

pattern_cat = re.compile(r"titleSinhala\s*=\s*\"([^\"]+)\".*?points\s*=\s*listOf\((.*?)\)\s*\)", re.DOTALL)
pattern_pt = re.compile(r"SubjectFactPoint\(\s*\d+,\s*\"([^\"]+)\",\s*\"([^\"]+)\",\s*\"([^\"]+)\"\s*\)")

categories = []
for m in pattern_cat.finditer(text1 + "\n" + text2):
    cat_title = m.group(1).strip()
    pts = pattern_pt.findall(m.group(2))
    categories.append((cat_title, pts))

print("Total categories:", len(categories))
total_pts = sum(len(pts) for _, pts in categories)
print("Total points across categories:", total_pts)

pattern_vq = re.compile(r"Quintuple\(\s*\"([^\"]+)\",\s*\"([^\"]+)\",\s*listOf\([^)]+\),\s*\"([^\"]+)\",\s*\"([^\"]+)\"\s*\)")
vq_items = pattern_vq.findall(text_vq)
print("VoiceQuiz items:", len(vq_items))
