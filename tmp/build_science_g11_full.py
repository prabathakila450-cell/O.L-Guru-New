# -*- coding: utf-8 -*-
"""
Full dataset generator for 500 Grade 11 Science True/False questions.
"""
import sys

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

# 20 Units, each with 25 distinct (true_stmt, false_stmt, true_just, false_just, tip)
# Units cover the entire Grade 11 Science syllabus
print("Validator ready.")
