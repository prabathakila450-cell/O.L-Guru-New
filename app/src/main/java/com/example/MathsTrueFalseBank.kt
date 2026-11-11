package com.example

object MathsTrueFalseBank {
  fun getMathsQuestion(grade: Int, number: Int, batchIndex: Int, topicIndex: Int): TrueFalseTopicContent {
    val items = listOf(
      TrueFalseTopicContent(
        unitName = "භාග හා ප්‍රතිශත",
        statement = if (batchIndex % 2 == 0) "භාග දෙකක් බෙදීමේදී දෙවන භාගයේ පරස්පරයෙන් පළමු භාගය ගුණ කරනු ලැබේ."
                    else "25% යනු භාගයක් ලෙස ලියූ විට 1/4 ට සමාන වේ.",
        isTrue = true,
        justification = "(a/b) ÷ (c/d) = (a/b) × (d/c). එසේම 25/100 සරල කළ විට 1/4 වේ.",
        examTrap = "ප්‍රතිශතයක් දශමයක් කිරීමට 100 න් බෙදිය යුතුය."
      ),
      TrueFalseTopicContent(
        unitName = "වීජීය ප්‍රකාශන හා සාධක",
        statement = if (batchIndex % 2 == 0) "වර්ග දෙකක අන්තරය: a² - b² = (a - b)(a + b) වේ."
                    else "(x + y)² ප්‍රසාරණය කළ විට x² + y² ලැබේ.",
        isTrue = batchIndex % 2 == 0,
        justification = if (batchIndex % 2 == 0) "වර්ග දෙකක අන්තරය සාධක දෙකක ගුණිතයක් ලෙස ලිවිය හැක."
                        else "(x + y)² = x² + 2xy + y² වේ. මධ්‍ය පදය (+2xy) අමතක නොකළ යුතුය.",
        examTrap = "(a + b)² ≠ a² + b² යනු සිසුන් නිතරම කරන විභාග වැරැද්දකි."
      ),
      TrueFalseTopicContent(
        unitName = "වර්ගජ සමීකරණ හා සූත්‍රය",
        statement = if (batchIndex % 2 == 0) "ax² + bx + c = 0 වර්ගජ සමීකරණයේ මූල x = (-b ± √(b² - 4ac)) / 2a වේ."
                    else "වර්ගජ සමීකරණයක විවේචකය Δ = b² - 4ac < 0 වූ විට ඊට තාත්වික මූල පවතී.",
        isTrue = batchIndex % 2 == 0,
        justification = if (batchIndex % 2 == 0) "සම්මත වර්ගජ සූත්‍රය මගින් ඕනෑම වර්ගජ සමීකරණයක මූල සොයාගත හැක."
                        else "විවේචකය ඍණ (Δ < 0) වන විට වර්ගමූලය තුළ ඍණ අගයක් ලැබෙන බැවින් තාත්වික මූල නොපවතී.",
        examTrap = "Δ = 0 වන විට සමාන තාත්වික මූල දෙකක් ලැබේ."
      ),
      TrueFalseTopicContent(
        unitName = "සමාන්තර ශ්‍රේඪි",
        statement = if (batchIndex % 2 == 0) "මුල් පදය a සහ පොදු අන්තරය d වන සමාන්තර ශ්‍රේඪියක n වන පදය Tn = a + (n - 1)d වේ."
                    else "සමාන්තර ශ්‍රේඪියක පළමු පද n වල එකතුව Sn = (n/2)[2a + (n - 1)d] වේ.",
        isTrue = true,
        justification = "සමාන්තර ශ්‍රේඪියක අනුයාත පද දෙකක වෙනස නියතයක් (d) වේ. සූත්‍ර දෙකම සම්මත වේ.",
        examTrap = "Tn සූත්‍රයේ (n-1) වෙනුවට n යෙදීමෙන් වළකින්න."
      ),
      TrueFalseTopicContent(
        unitName = "ගුණෝත්තර ශ්‍රේඪි",
        statement = if (batchIndex % 2 == 0) "පොදු අනුපාතය r වන ගුණෝත්තර ශ්‍රේඪියක n වන පදය Tn = arⁿ⁻¹ වේ."
                    else "ගුණෝත්තර ශ්‍රේඪියක අනුයාත පද දෙකක වෙනස නියත අගයකි.",
        isTrue = batchIndex % 2 == 0,
        justification = if (batchIndex % 2 == 0) "පළමු පදය a සහ පොදු අනුපාතය r වන විට Tn = arⁿ⁻¹ වේ."
                        else "අනුයාත පද අතර වෙනස නියත වන්නේ සමාන්තර ශ්‍රේඪිවලය. ගුණෝත්තර ශ්‍රේඪිවල පද අතර අනුපාතය (Tn / Tn-1) නියත වේ.",
        examTrap = "2, 6, 18, 54... යනු r = 3 වූ ගුණෝත්තර ශ්‍රේඪියකි."
      ),
      TrueFalseTopicContent(
        unitName = "පයිතගරස් ප්‍රමේයය",
        statement = if (batchIndex % 2 == 0) "ඍජුකෝණී ත්‍රිකෝණයක කර්ණයේ වර්ගය අනෙක් පාද දෙකේ වර්ගවල එකතුවට සමාන වේ (c² = a² + b²)."
                    else "පාද 3 cm, 4 cm සහ 6 cm වන ත්‍රිකෝණයක් ඍජුකෝණී ත්‍රිකෝණයක් වේ.",
        isTrue = batchIndex % 2 == 0,
        justification = if (batchIndex % 2 == 0) "පයිතගරස් ප්‍රමේයය: ඍජුකෝණයට ඉදිරියෙන් ඇති කර්ණය c නම් c² = a² + b² වේ."
                        else "3² + 4² = 9 + 16 = 25. නමුත් 6² = 36. 25 ≠ 36 බැවින් එය ඍජුකෝණී නොවේ (කර්ණය 5 විය යුතුය).",
        examTrap = "(3, 4, 5), (5, 12, 13), (7, 24, 25), (8, 15, 17) සම්මත පයිතගරස් ත්‍රිත්ව වේ."
      ),
      TrueFalseTopicContent(
        unitName = "ත්‍රිකෝණමිතිය",
        statement = if (batchIndex % 2 == 0) "ඍජුකෝණී ත්‍රිකෝණයක tan θ = සම්මුඛ පාදය / බද්ධ පාදය වේ."
                    else "sin²θ + cos²θ = 1 සර්වසාම්‍යය ඕනෑම කෝණයක් සඳහා සත්‍ය වේ.",
        isTrue = true,
        justification = "sin θ = සම්මුඛ/කර්ණය, cos θ = බද්ධ/කර්ණය, tan θ = sin θ / cos θ = සම්මුඛ/බද්ධ වේ.",
        examTrap = "tan 45° = 1, sin 30° = 1/2, cos 60° = 1/2 බව මතක තබා ගන්න."
      ),
      TrueFalseTopicContent(
        unitName = "ජ්‍යාමිතික ප්‍රමේය - කෝණ හා සමාන්තර රේඛා",
        statement = if (batchIndex % 2 == 0) "ඕනෑම ත්‍රිකෝණයක අභ්‍යන්තර කෝණ තුනෙහි ඓක්‍යය 180° කි."
                    else "සමාන්තර රේඛා දෙකක් තිරික්කයකින් ඡේදනය කළ විට සෑදෙන මිත්‍ර කෝණ යුගල එකිනෙකට සමාන වේ.",
        isTrue = batchIndex % 2 == 0,
        justification = if (batchIndex % 2 == 0) "ත්‍රිකෝණයක කෝණ එකතුව 180° වේ."
                        else "මිත්‍ර කෝණ යුගල එකිනෙකට සමාන නොවේ; ඒවායේ එකතුව 180° (පරිපූරක) වේ. එකිනෙකට සමාන වන්නේ ඒකාන්තර හා අනුරූප කෝණයි.",
        examTrap = "ඒකාන්තර (Z හැඩය) සමාන වේ, මිත්‍ර (C හෝ U හැඩය) එකතුව 180° වේ."
      ),
      TrueFalseTopicContent(
        unitName = "වෘත්ත ප්‍රමේය - ජ්‍යා",
        statement = if (batchIndex % 2 == 0) "වෘත්තයක කේන්ද්‍රයේ සිට ජ්‍යායකට අඳින ලද ලම්භය මඟින් එම ජ්‍යාය සමච්ඡේද වේ."
                    else "කේන්ද්‍රයේ සිට සමාන දුරින් පිහිටි ජ්‍යා එකිනෙකට දිගින් සමාන වේ.",
        isTrue = true,
        justification = "කේන්ද්‍රයේ සිට ලම්භය ජ්‍යාය දෙකට බෙදන අතර, සමාන ජ්‍යා කේන්ද්‍රයේ සිට සමාන දුරින් පිහිටයි.",
        examTrap = "ජ්‍යා ප්‍රමේය විභාගයේදී පයිතගරස් ප්‍රමේය සමඟ ඒකාබද්ධව නිතර ගැටලු වලට යොදා ගැනේ."
      ),
      TrueFalseTopicContent(
        unitName = "වෘත්ත ප්‍රමේය - කෝණ",
        statement = if (batchIndex % 2 == 0) "වෘත්තයක චාපයකින් කේන්ද්‍රයෙහි ගොඩනගන කෝණය එම චාපයෙන්ම පරිධිය මත පිහිටි ලක්ෂ්‍යයක ආපාතනය කරන කෝණය මෙන් දෙගුණයකි."
                    else "අර්ධ වෘත්තයක කෝණය 180° කි.",
        isTrue = batchIndex % 2 == 0,
        justification = if (batchIndex % 2 == 0) "කේන්ද්‍රීය කෝණය = 2 × පරිධියේ කෝණය."
                        else "අර්ධ වෘත්තයක කෝණය සෘජුකෝණයකි (90°). 180° නොවේ.",
        examTrap = "එකම ඛණ්ඩයේ කෝණ එකිනෙකට සමාන වේ."
      ),
      TrueFalseTopicContent(
        unitName = "චක්‍රීය චතුරස්‍ර",
        statement = if (batchIndex % 2 == 0) "චක්‍රීය චතුරස්‍රයක සම්මුඛ කෝණවල ඓක්‍යය 180° (පරිපූරක) වේ."
                    else "චක්‍රීය චතුරස්‍රයක පාදයක් දික්කිරීමෙන් සෑදෙන බාහිර කෝණය එහි අභ්‍යන්තර සම්මුඛ කෝණයට සමාන වේ.",
        isTrue = true,
        justification = "ශීර්ෂ හතරම වෘත්ත පරිධිය මත පිහිටන චතුරස්‍ර චක්‍රීය චතුරස්‍ර නම් වේ.",
        examTrap = "සම්මුඛ කෝණ එකිනෙකට සමාන නොවේ, ඒවායේ එකතුව 180° වේ."
      ),
      TrueFalseTopicContent(
        unitName = "ස්පර්ශක ප්‍රමේය",
        statement = if (batchIndex % 2 == 0) "වෘත්තයක ස්පර්ශ ලක්ෂ්‍යයට අඳින ලද අරය ස්පර්ශකයට ලම්භක වේ."
                    else "වෘත්තයකින් බාහිර ලක්ෂ්‍යයක සිට අඳින ලද ස්පර්ශක ඛණ්ඩ දෙක දිගින් අසමාන වේ.",
        isTrue = batchIndex % 2 == 0,
        justification = if (batchIndex % 2 == 0) "ස්පර්ශ ලක්ෂ්‍යයේදී අරය සහ ස්පර්ශකය අතර කෝණය 90° කි."
                        else "බාහිර ලක්ෂ්‍යයක සිට වෘත්තයට අඳින ලද ස්පර්ශක දෙක දිගින් එකිනෙකට සමාන වේ.",
        examTrap = "ඒකාන්තර ඛණ්ඩ ප්‍රමේයය: ස්පර්ශකය සහ ජ්‍යාය අතර කෝණය ඒකාන්තර ඛණ්ඩයේ කෝණයට සමාන වේ."
      ),
      TrueFalseTopicContent(
        unitName = "වර්ගඵලය හා පරිමාව",
        statement = if (batchIndex % 2 == 0) "අරය r සහ උස h වන සිලින්ඩරයක පරිමාව V = πr²h වේ."
                    else "අරය r වන ගෝලයක පරිමාව V = 4πr² වේ.",
        isTrue = batchIndex % 2 == 0,
        justification = if (batchIndex % 2 == 0) "සිලින්ඩරයක පරිමාව = හරස්කඩ වර්ගඵලය × උස = πr²h."
                        else "ගෝලයක පරිමාව V = (4/3)πr³ වේ. 4πr² යනු ගෝලයේ මතුපිට වර්ගඵලයයි.",
        examTrap = "කේතුවක පරිමාව සිලින්ඩරයකින් තුනෙන් එකකි: V = (1/3)πr²h."
      ),
      TrueFalseTopicContent(
        unitName = "සම්භාවිතාව",
        statement = if (batchIndex % 2 == 0) "සාධාරණ දාදු කැටයක් එක්වරක් දැමූ විට ඉරට්ටේ සංඛ්‍යාවක් ලැබීමේ සම්භාවිතාව 1/2 කි."
                    else "කිසියම් සිදුවීමක සම්භාවිතාව 1 ට වඩා වැඩි අගයක් විය හැක.",
        isTrue = batchIndex % 2 == 0,
        justification = if (batchIndex % 2 == 0) "ඉරට්ටේ සංඛ්‍යා = {2, 4, 6}. මුළු ප්‍රතිඵල = 6. සම්භාවිතාව = 3/6 = 1/2."
                        else "ඕනෑම සිදුවීමක සම්භාවිතාව 0 සහ 1 අතර (0 ≤ P(A) ≤ 1) පමණක් පවතී.",
        examTrap = "අනිවාර්ය සිදුවීමක සම්භාවිතාව 1 වන අතර අසම්භව්‍ය සිදුවීමක සම්භාවිතාව 0 වේ."
      ),
      TrueFalseTopicContent(
        unitName = "සංඛ්‍යානය හා මධ්‍යස්ථය",
        statement = if (batchIndex % 2 == 0) "දත්ත සමූහයක ආරෝහණ පිළිවෙළට සකස් කළ පසු මධ්‍යයේ පිහිටන අගය මධ්‍යස්ථය (Median) වේ."
                    else "දත්ත සමූහයක වැඩිම වාර ගණනක් පුනරාවර්තනය වන අගය මධ්‍යන්‍යය (Mean) වේ.",
        isTrue = batchIndex % 2 == 0,
        justification = if (batchIndex % 2 == 0) "මධ්‍යස්ථය දත්ත 50% බැගින් සමාන කොටස් දෙකකට වෙන් කරයි."
                        else "වැඩිම වාර ගණනක් ඇති අගය මාතය (Mode) වේ. මධ්‍යන්‍යය යනු සාමාන්‍යයයි (ඓක්‍යය / සංඛ්‍යාව).",
        examTrap = "විභාගයේදී මාතය, මධ්‍යස්ථය සහ මධ්‍යන්‍යය වෙන්කොට හඳුනාගන්න."
      )
    )

    val gradeOffset = when (grade) {
      9 -> 0
      10 -> 5
      11 -> 10
      else -> 0
    }
    val safeIndex = (number - 1 + gradeOffset) % items.size
    val base = items[safeIndex]
    val isAlt = ((number - 1) / items.size) % 2 == 1
    if (!isAlt) return base
    return TrueFalseTopicContent(
      unitName = base.unitName,
      statement = "ප්‍රශ්න අංක ${number}: ${base.unitName} - ${base.statement}",
      isTrue = base.isTrue,
      justification = base.justification,
      examTrap = base.examTrap
    )
  }
}
