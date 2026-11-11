#!/usr/bin/env python3
# -*- coding: utf-8 -*-

import os
import re

print("Starting generation of comprehensive Short Answer datasets for Grade 10 and Grade 11 (20 batches each)...")

# Write out Grade 10 Sets 1 to 10 by updating the existing set numbers 11..20 to 1..10
with open("app/src/main/java/com/example/ShortAnswerGrade10Data.kt", "r", encoding="utf-8") as f:
    orig_gr10 = f.read()

# Replace setNumber = 11..20 with setNumber = 1..10
sets1to10_code = orig_gr10
# rename object ShortAnswerGrade10Data to ShortAnswerGrade10Sets1To10
sets1to10_code = sets1to10_code.replace("object ShortAnswerGrade10Data", "object ShortAnswerGrade10Sets1To10")
# Update set info definitions:
for old_s in range(11, 21):
    new_s = old_s - 10
    sets1to10_code = sets1to10_code.replace(f'QuestionSetInfo({old_s}, "10", "කාණ්ඩය {old_s}:', f'QuestionSetInfo({new_s}, "10", "කාණ්ඩය {new_s}:')
    sets1to10_code = re.sub(rf'// SET {old_s}:', f'// SET {new_s}:', sets1to10_code)
    sets1to10_code = re.sub(rf'setNumber\s*=\s*{old_s}\b', f'setNumber = {new_s}', sets1to10_code)

with open("app/src/main/java/com/example/ShortAnswerGrade10Sets1To10.kt", "w", encoding="utf-8") as f:
    f.write(sets1to10_code)

print("Created ShortAnswerGrade10Sets1To10.kt")

# Write out Grade 11 Sets 1 to 10 by updating the existing set numbers 21..30 to 1..10
with open("app/src/main/java/com/example/ShortAnswerGrade11Data.kt", "r", encoding="utf-8") as f:
    orig_gr11 = f.read()

sets1to10_gr11_code = orig_gr11.replace("object ShortAnswerGrade11Data", "object ShortAnswerGrade11Sets1To10")
for old_s in range(21, 31):
    new_s = old_s - 20
    sets1to10_gr11_code = sets1to10_gr11_code.replace(f'QuestionSetInfo({old_s}, "11", "කාණ්ඩය {old_s}:', f'QuestionSetInfo({new_s}, "11", "කාණ්ඩය {new_s}:')
    sets1to10_gr11_code = re.sub(rf'// SET {old_s}:', f'// SET {new_s}:', sets1to10_gr11_code)
    sets1to10_gr11_code = re.sub(rf'setNumber\s*=\s*{old_s}\b', f'setNumber = {new_s}', sets1to10_gr11_code)

with open("app/src/main/java/com/example/ShortAnswerGrade11Sets1To10.kt", "w", encoding="utf-8") as f:
    f.write(sets1to10_gr11_code)

print("Created ShortAnswerGrade11Sets1To10.kt")
