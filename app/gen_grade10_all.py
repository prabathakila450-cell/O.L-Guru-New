#!/usr/bin/env python3
# -*- coding: utf-8 -*-

import re
import os

def render_q(q):
    kp = ', '.join([f'"{p}"' for p in q['keyPoints']])
    syn_groups = []
    for g in q.get('synonyms', []):
        items = ', '.join([f'"{item}"' for item in g])
        syn_groups.append(f'        listOf({items})')
    syn_str = ',\n'.join(syn_groups)
    ms = q['markingScheme'].replace('\\', '\\\\').replace('"', '\\"').replace('\n', '\\n')
    ans = q['idealAnswer'].replace('\\', '\\\\').replace('"', '\\"')
    quest = q['question'].replace('\\', '\\\\').replace('"', '\\"')
    
    return f"""    ShortAnswerQuestion(
      id = {q['id']},
      grade = "{q['grade']}",
      setNumber = {q['setNumber']},
      subject = "{q['subject']}",
      topic = "{q['topic']}",
      question = "{quest}",
      keyPoints = listOf({kp}),
      synonyms = listOf(
{syn_str}
      ),
      officialMarkingScheme = "{ms}",
      sampleIdealAnswer = "{ans}"
    )"""

# 1. First, create ShortAnswerGrade10Sets1To10.kt from ShortAnswerGrade10Data.kt
with open("app/src/main/java/com/example/ShortAnswerGrade10Data.kt", "r", encoding="utf-8") as f:
    orig = f.read()

s1_10 = orig.replace("object ShortAnswerGrade10Data", "object ShortAnswerGrade10Sets1To10")
for old_s in range(11, 21):
    new_s = old_s - 10
    s1_10 = s1_10.replace(f'QuestionSetInfo({old_s}, "10", "කාණ්ඩය {old_s}:', f'QuestionSetInfo({new_s}, "10", "කාණ්ඩය {new_s}:')
    s1_10 = re.sub(rf'// SET {old_s}:', f'// SET {new_s}:', s1_10)
    s1_10 = re.sub(rf'setNumber\s*=\s*{old_s}\b', f'setNumber = {new_s}', s1_10)

with open("app/src/main/java/com/example/ShortAnswerGrade10Sets1To10.kt", "w", encoding="utf-8") as f:
    f.write(s1_10)

print("Generated ShortAnswerGrade10Sets1To10.kt")
