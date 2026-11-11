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

print("Writing short answer generation engine...")
