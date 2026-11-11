package com.example

/**
 * 📐 Voice Quiz Bank for Mathematics (ගණිතය)
 * 200 strictly simple, direct, non-formula, non-explanatory oral math questions.
 * 10 distinct sets of 20 questions each.
 */
object VoiceQuizMathBank {

  fun getQuestion(grade: String, setNum: Int, qIndex: Int, theme: String): Quintuple<String, String, List<String>, String, String> {
    if (grade == "11") {
      return getGrade11Question(setNum, qIndex, theme)
    }
    return when (setNum) {
      // Set 1: ප්‍රථමක සංඛ්‍යා, සාධක & ගුණාකාර
      1 -> when (qIndex) {
        1 -> Quintuple("කුඩාම ප්‍රථමක සංඛ්‍යාව කුමක්ද?", "Smallest prime number?", listOf("2", "දෙක"), "2 (දෙක) වේ.", "කුඩාම ප්‍රථමකය 2යි.")
        2 -> Quintuple("යුගල සංඛ්‍යාවක් වන එකම ප්‍රථමක සංඛ්‍යාව කුමක්ද?", "Only even prime number?", listOf("2", "දෙක"), "2 (දෙක) පමණි.", "යුගල ප්‍රථමකය 2යි.")
        3 -> Quintuple("1 සහ 10 අතර ඇති ප්‍රථමක සංඛ්‍යා කීයක් තිබේද?", "How many prime numbers between 1 and 10?", listOf("4", "4ක්", "හතරක්"), "4කි (2, 3, 5, 7).", "2, 3, 5, 7 වේ.")
        4 -> Quintuple("12 හි සාධකයක් සඳහා සරල උදාහරණයක් පවසන්න.", "Example of factor of 12?", listOf("1", "2", "3", "4", "6", "12"), "1, 2, 3, 4, 6 හෝ 12 වේ.", "12 බෙදිය හැකි සංඛ්‍යාවකි.")
        5 -> Quintuple("9 යනු ප්‍රථමක සංඛ්‍යාවක්ද නැතහොත් සංයුක්ත සංඛ්‍යාවක්ද?", "Is 9 prime or composite?", listOf("සංයුක්ත", "සංයුක්ත සංඛ්‍යාවක්"), "සංයුක්ත සංඛ්‍යාවකි (3න් බෙදේ).", "3න් බෙදිය හැකිය.")
        6 -> Quintuple("1 සංඛ්‍යාව ප්‍රථමක සංඛ්‍යාවක් ලෙස සලකනු ලබයිද?", "Is 1 considered a prime number?", listOf("නැත", "නැහැ", "නැතැයි"), "නැත, 1 ප්‍රථමක හෝ සංයුක්ත නොවේ.", "සාධක දෙකක් නැත.")
        7 -> Quintuple("5 හි පළමු ගුණාකාර තුනෙන් එකක් පවසන්න.", "One of first 3 multiples of 5?", listOf("5", "10", "15"), "5, 10 හෝ 15 වේ.", "5, 10, 15 වේ.")
        8 -> Quintuple("ඕනෑම සංඛ්‍යාවක කුඩාම ධන සාධකය කුමක්ද?", "Smallest positive factor of any number?", listOf("1", "එක"), "1 (එක) වේ.", "පිළිතුර 1 වේ.")
        9 -> Quintuple("2 සහ 3 යන දෙකෙන්ම බෙදෙන කුඩාම පොදු ගුණාකාරය කීයද?", "LCM of 2 and 3?", listOf("6", "හය"), "6 (හය) වේ.", "2 × 3 = 6.")
        10 -> Quintuple("10ට අඩු විශාලතම ප්‍රථමක සංඛ්‍යාව කුමක්ද?", "Largest prime less than 10?", listOf("7", "හත"), "7 (හත) වේ.", "7 වේ.")
        11 -> Quintuple("20 හි ප්‍රථමක සාධක දෙක මොනවාද?", "Two prime factors of 20?", listOf("2 සහ 5", "2, 5", "2", "5"), "2 සහ 5 වේ.", "2 × 2 × 5 = 20.")
        12 -> Quintuple("සංඛ්‍යාවක අග අංකය 0 හෝ 5 නම් එය බෙදෙන්නේ කුමන අංකයෙන්ද?", "Divisible by what if last digit is 0 or 5?", listOf("5", "පහ", "5න්"), "5න් (පහෙන්) බෙදේ.", "5න් බෙදීමේ ලක්ෂණයයි.")
        13 -> Quintuple("සංඛ්‍යාවක් 2න් බෙදීමට නම් එහි අග අංකය කෙබඳු විය යුතුද?", "Last digit to be divisible by 2?", listOf("යුගල", "ඉරට්ටේ", "0, 2, 4, 6, 8"), "යුගල (ඉරට්ටේ) අංකයක් විය යුතුය.", "0, 2, 4, 6, 8 වේ.")
        14 -> Quintuple("3 සහ 5 අතර පිහිටි එකම ප්‍රථමක සංඛ්‍යාව නැත, 5 සහ 7 අතර පිහිටි එකම යුගල සංඛ්‍යාව කුමක්ද?", "Even number between 5 and 7?", listOf("6", "හය"), "6 (හය) වේ.", "6 වේ.")
        15 -> Quintuple("15 සහ 20 හි මහා පොදු සාධකය (ම.පො.සා.) කීයද?", "HCF of 15 and 20?", listOf("5", "පහ"), "5 (පහ) වේ.", "පොදු සාධකය 5යි.")
        16 -> Quintuple("4 සහ 6 හි කුඩාම පොදු ගුණාකාරය (කු.පො.ගු.) කීයද?", "LCM of 4 and 6?", listOf("12", "දොළහ"), "12 (දොළහ) වේ.", "12 වේ.")
        17 -> Quintuple("11 යනු ප්‍රථමක සංඛ්‍යාවක්ද?", "Is 11 a prime number?", listOf("ඔව්", "එසේය", "ප්‍රථමක"), "ඔව්, ප්‍රථමක සංඛ්‍යාවකි.", "11 ප්‍රථමකයකි.")
        18 -> Quintuple("100 හි සියලුම සාධක අතරින් විශාලතම සාධකය කුමක්ද?", "Largest factor of 100?", listOf("100", "සියය"), "100ම වේ.", "සංඛ්‍යාවමය වේ.")
        19 -> Quintuple("13 න් පසු එන ඊළඟ ප්‍රථමක සංඛ්‍යාව කුමක්ද?", "Next prime after 13?", listOf("17", "දසහත"), "17 (දසහත) වේ.", "17 වේ.")
        20 -> Quintuple("25 හි සාධක කීයක් තිබේද?", "How many factors does 25 have?", listOf("3", "3ක්", "තුනක්"), "3කි (1, 5, 25).", "1, 5, 25 වේ.")
        else -> Quintuple("කුඩාම ධන නිඛිලය කුමක්ද?", "Smallest positive integer?", listOf("1", "එක"), "1 (එක) වේ.", "1 වේ.")
      }

      // Set 2: භාග, දශම & ප්‍රතිශත
      2 -> when (qIndex) {
        1 -> Quintuple("හතරෙන් එකක් (1/4) ප්‍රතිශතයක් ලෙස කීයද?", "1/4 as percentage?", listOf("25%", "25", "සියයට විසිපහ"), "25% වේ.", "25% වේ.")
        2 -> Quintuple("දෙකෙන් එකක් (1/2) දශම සංඛ්‍යාවක් ලෙස ලියන්නේ කෙසේද?", "1/2 as decimal?", listOf("0.5", "ශුන්‍යයි දශම පහ"), "0.5 වේ.", "0.5 වේ.")
        3 -> Quintuple("සියයට පනහක් (50%) භාගයක් ලෙස සරල කළ විට කීයද?", "50% as a simplified fraction?", listOf("1/2", "දෙකෙන් එක"), "1/2 (දෙකෙන් එක) වේ.", "1/2 වේ.")
        4 -> Quintuple("0.75 භාගයක් ලෙස ලියූ විට කීයද?", "0.75 as fraction?", listOf("3/4", "හතරෙන් තුන"), "3/4 (හතරෙන් තුන) වේ.", "3/4 වේ.")
        5 -> Quintuple("1/3 සහ 2/3 එකතු කළ විට ලැබෙන පිළිතුර කීයද?", "1/3 + 2/3?", listOf("1", "එක"), "1 (එක) වේ.", "3/3 = 1.")
        6 -> Quintuple("100න් 10%ක් කීයද?", "10% of 100?", listOf("10", "දහය"), "10 (දහය) වේ.", "10 වේ.")
        7 -> Quintuple("1/2න් අඩක් කීයද?", "Half of 1/2?", listOf("1/4", "හතරෙන් එක"), "1/4 (හතරෙන් එක) වේ.", "1/4 වේ.")
        8 -> Quintuple("භාගයක උඩින් ඇති සංඛ්‍යාව හඳුන්වන්නේ කෙසේද?", "Top number of fraction?", listOf("හරය", "ලවය"), "ලවය වේ.", "ලවය වේ.")
        9 -> Quintuple("භාගයක යටින් ඇති සංඛ්‍යාව හඳුන්වන්නේ කෙසේද?", "Bottom number of fraction?", listOf("හරය"), "හරය වේ.", "හරය වේ.")
        10 -> Quintuple("ලවය හරයට වඩා විශාල භාග හඳුන්වන්නේ කෙසේද?", "Fraction with numerator greater than denominator?", listOf("විෂම භාග", "විෂම"), "විෂම භාග නමිනි.", "විෂම භාගයි.")
        11 -> Quintuple("පූර්ණ සංඛ්‍යාවක් සහ ප්‍රථමක/ක්‍රමවත් භාගයක් එකතුවන භාග හඳුන්වන්නේ කෙසේද?", "Mixed fraction name?", listOf("මිශ්‍ර භාග", "මිශ්‍ර"), "මිශ්‍ර භාග නමිනි.", "මිශ්‍ර භාගයි.")
        12 -> Quintuple("100න් 20%ක් කීයද?", "20% of 100?", listOf("20", "විස්ස"), "20 (විස්ස) වේ.", "20 වේ.")
        13 -> Quintuple("0.1 භාගයක් ලෙස ලියන්නේ කෙසේද?", "0.1 as a fraction?", listOf("1/10", "දහයෙන් එක"), "1/10 (දහයෙන් එක) වේ.", "1/10 වේ.")
        14 -> Quintuple("50න් 50%ක් කීයද?", "50% of 50?", listOf("25", "විසිපහ"), "25 (විසිපහ) වේ.", "25 වේ.")
        15 -> Quintuple("3/5 හි හරය කීයද?", "Denominator of 3/5?", listOf("5", "පහ"), "5 (පහ) වේ.", "හරය 5යි.")
        16 -> Quintuple("4/7 හි ලවය කීයද?", "Numerator of 4/7?", listOf("4", "හතර"), "4 (හතර) වේ.", "ලවය 4යි.")
        17 -> Quintuple("10න් 0.5ක් කීයද?", "0.5 of 10?", listOf("5", "පහ"), "5 (පහ) වේ.", "10න් අඩ 5යි.")
        18 -> Quintuple("සම්පූර්ණ ප්‍රමාණය ප්‍රතිශතයක් ලෙස දක්වන්නේ කීයෙන්ද?", "Whole amount as percentage?", listOf("100%", "100", "සියයට සියය"), "100% (සියයට සියය) මඟිනි.", "100% වේ.")
        19 -> Quintuple("1/4 සහ 1/4 එකතු කළ විට කීයද?", "1/4 + 1/4?", listOf("1/2", "දෙකෙන් එක", "2/4"), "1/2 (දෙකෙන් එක) වේ.", "1/2 වේ.")
        20 -> Quintuple("0.25 ප්‍රතිශතයක් ලෙස කීයද?", "0.25 as percentage?", listOf("25%", "25"), "25% වේ.", "25% වේ.")
        else -> Quintuple("1න් අඩක් කීයද?", "Half of 1?", listOf("0.5", "1/2"), "0.5 හෝ 1/2 වේ.", "අඩකි.")
      }

      // Set 3: කෝණ හා ජ්‍යාමිතික මූලිකාංග
      3 -> when (qIndex) {
        1 -> Quintuple("සෘජුකෝණයක අගය අංශක කීයද?", "Value of a right angle?", listOf("90", "90ක්", "අංශක 90"), "අංශක 90 කි.", "අංශක 90 වේ.")
        2 -> Quintuple("සරල රේඛාවක කෝණය අංශක කීයද?", "Angle on a straight line?", listOf("180", "180ක්", "අංශක 180"), "අංශක 180 කි.", "අංශක 180 වේ.")
        3 -> Quintuple("ලක්ෂ්‍යයක් වටා කෝණවල එකතුව අංශක කීයද?", "Sum of angles around a point?", listOf("360", "360ක්", "අංශක 360"), "අංශක 360 කි.", "අංශක 360 වේ.")
        4 -> Quintuple("අංශක 90ට වඩා අඩු කෝණයක් හඳුන්වන්නේ කෙසේද?", "Angle less than 90 degrees?", listOf("සුළු කෝණය", "සුළු"), "සුළු කෝණයක් (Acute angle) නමිනි.", "සුළු කෝණයයි.")
        5 -> Quintuple("අංශක 90ට වැඩි සහ 180ට අඩු කෝණයක් හඳුන්වන්නේ කෙසේද?", "Angle between 90 and 180 degrees?", listOf("මහා කෝණය", "මහා"), "මහා කෝණයක් (Obtuse angle) නමිනි.", "මහා කෝණයයි.")
        6 -> Quintuple("අංශක 180ට වැඩි සහ 360ට අඩු කෝණයක් හඳුන්වන්නේ කෙසේද?", "Angle between 180 and 360 degrees?", listOf("ප්‍රත්‍යාවර්ත කෝණය", "ප්‍රත්‍යාවර්ත"), "ප්‍රත්‍යාවර්ත කෝණයක් (Reflex angle) නමිනි.", "ප්‍රත්‍යාවර්ත කෝණයයි.")
        7 -> Quintuple("කෝණ දෙකක එකතුව අංශක 90ක් නම් එම කෝණ හඳුන්වන්නේ කෙසේද?", "Two angles summing to 90 degrees?", listOf("පූරක කෝණ", "පූරක"), "පූරක කෝණ (Complementary angles) නමිනි.", "පූරක කෝණ වේ.")
        8 -> Quintuple("කෝණ දෙකක එකතුව අංශක 180ක් නම් එම කෝණ හඳුන්වන්නේ කෙසේද?", "Two angles summing to 180 degrees?", listOf("පරිපූරක කෝණ", "පරිපූරක"), "පරිපූරක කෝණ (Supplementary angles) නමිනි.", "පරිපූරක කෝණ වේ.")
        9 -> Quintuple("රේඛා දෙකක් ඡේදනය වීමේදී මුහුණට මුහුණ පිහිටන කෝණ හඳුන්වන්නේ කෙසේද?", "Opposite angles when two lines intersect?", listOf("ප්‍රතිමුඛ කෝණ", "ප්‍රතිමුඛ"), "ප්‍රතිමුඛ කෝණ (Vertically opposite) නමිනි.", "ප්‍රතිමුඛ කෝණ සමානයි.")
        10 -> Quintuple("ප්‍රතිමුඛ කෝණ යුගලයක කෝණ එකිනෙකට සමානද?", "Are vertically opposite angles equal?", listOf("ඔව්", "සමානයි"), "ඔව්, එකිනෙකට සමාන වේ.", "සමාන වේ.")
        11 -> Quintuple("අංශක 40 කෝණයක පූරක කෝණයේ අගය අංශක කීයද?", "Complement of 40 degrees?", listOf("50", "50ක්", "අංශක 50"), "අංශක 50 කි (90 - 40 = 50).", "90න් 40ක් අඩු කරන්න.")
        12 -> Quintuple("අංශක 100 කෝණයක පරිපූරක කෝණයේ අගය අංශක කීයද?", "Supplement of 100 degrees?", listOf("80", "80ක්", "අංශක 80"), "අංශක 80 කි (180 - 100 = 80).", "180න් 100ක් අඩු කරන්න.")
        13 -> Quintuple("කෝණ මැනීමට භාවිත කරන ජ්‍යාමිතික උපකරණය කුමක්ද?", "Instrument used to measure angles?", listOf("කෝණමානය", "protractor"), "කෝණමානය (Protractor) වේ.", "කෝණමානය වේ.")
        14 -> Quintuple("කෝණ මනින සම්මත ඒකකය කුමක්ද?", "Standard unit for measuring angles?", listOf("අංශක", "degrees"), "අංශක (Degrees - °) වේ.", "අංශක වේ.")
        15 -> Quintuple("අංශක 45 කෝණයක් යනු සුළු කෝණයක්ද මහා කෝණයක්ද?", "Is 45 degrees acute or obtuse?", listOf("සුළු කෝණයක්", "සුළු"), "සුළු කෝණයකි.", "90ට අඩුයි.")
        16 -> Quintuple("අංශක 120 කෝණයක් යනු සුළු කෝණයක්ද මහා කෝණයක්ද?", "Is 120 degrees acute or obtuse?", listOf("මහා කෝණයක්", "මහා"), "මහා කෝණයකි.", "90ට වැඩියි.")
        17 -> Quintuple("සෘජුකෝණ 2ක එකතුව අංශක කීයද?", "Sum of 2 right angles?", listOf("180", "180ක්", "අංශක 180"), "අංශක 180 කි.", "90 + 90 = 180.")
        18 -> Quintuple("සෘජුකෝණ 4ක එකතුව අංශක කීයද?", "Sum of 4 right angles?", listOf("360", "360ක්", "අංශක 360"), "අංශක 360 කි.", "90 × 4 = 360.")
        19 -> Quintuple("සමාන්තර රේඛා දෙකක් කිසිවිටෙක එකිනෙක ඡේදනය වේද?", "Do parallel lines ever intersect?", listOf("නැත", "නැහැ"), "නැත, කිසිවිටෙක ඡේදනය නොවේ.", "ඡේදනය නොවේ.")
        20 -> Quintuple("ලම්බක රේඛා දෙකක් අතර කෝණය අංශක කීයද?", "Angle between perpendicular lines?", listOf("90", "90ක්", "අංශක 90"), "අංශක 90 කි.", "සෘජුකෝණයකි.")
        else -> Quintuple("කෝණයක් නිර්මාණය වීමට අවම වශයෙන් කිරණ කීයක් අවශ්‍යද?", "Rays needed to form an angle?", listOf("2", "දෙකක්"), "කිරණ 2කි.", "කිරණ 2කි.")
      }

      // Set 4: ත්‍රිකෝණ & චතුරස්‍ර
      4 -> when (qIndex) {
        1 -> Quintuple("ත්‍රිකෝණයක අභ්‍යන්තර කෝණවල එකතුව අංශක කීයද?", "Sum of angles in triangle?", listOf("180", "180ක්", "අංශක 180"), "අංශක 180 කි.", "180 කි.")
        2 -> Quintuple("ත්‍රිකෝණයකට පාද කීයක් තිබේද?", "How many sides in triangle?", listOf("3", "3ක්", "තුනක්"), "පාද 3කි.", "තුනකි.")
        3 -> Quintuple("සමපාද ත්‍රිකෝණයක පාද කීයක් එකිනෙකට සමානද?", "Equal sides in equilateral triangle?", listOf("3", "තුනම", "3ක්"), "පාද 3ම සමාන වේ.", "තුනම සමානයි.")
        4 -> Quintuple("සමපාද ත්‍රිකෝණයක එක් කෝණයක අගය අංශක කීයද?", "Each angle of equilateral triangle?", listOf("60", "60ක්", "අංශක 60"), "අංශක 60 කි.", "60 බැගින් වේ.")
        5 -> Quintuple("පාද දෙකක් පමණක් සමාන වන ත්‍රිකෝණය හඳුන්වන්නේ කෙසේද?", "Triangle with 2 equal sides?", listOf("සමද්වීපාද", "සමද්විපාද"), "සමද්වීපාද ත්‍රිකෝණය නමිනි.", "සමද්වීපාද වේ.")
        6 -> Quintuple("එක් කෝණයක් අංශක 90ක් වන ත්‍රිකෝණය කුමක්ද?", "Triangle with one 90 degree angle?", listOf("සෘජුකෝණී ත්‍රිකෝණය", "සෘජුකෝණී"), "සෘජුකෝණී ත්‍රිකෝණය වේ.", "සෘජුකෝණී වේ.")
        7 -> Quintuple("චතුරස්‍රයක අභ්‍යන්තර කෝණවල එකතුව අංශක කීයද?", "Sum of angles in quadrilateral?", listOf("360", "360ක්", "අංශක 360"), "අංශක 360 කි.", "360 කි.")
        8 -> Quintuple("චතුරස්‍රයකට පාද කීයක් තිබේද?", "Sides in quadrilateral?", listOf("4", "4ක්", "හතරක්"), "පාද 4කි.", "හතරකි.")
        9 -> Quintuple("සමචතුරස්‍රයක සමාන පාද කීයක් තිබේද?", "Equal sides in square?", listOf("4", "4ම", "හතරම"), "පාද 4ම සමාන වේ.", "හතරම සමානයි.")
        10 -> Quintuple("සමචතුරස්‍රයක සෑම අභ්‍යන්තර කෝණයක්ම අංශක කීයද?", "Each interior angle of square?", listOf("90", "90ක්", "අංශක 90"), "අංශක 90 බැගින් වේ.", "90 බැගින් වේ.")
        11 -> Quintuple("සෘජුකෝණාස්‍රයක සම්මුඛ පාද එකිනෙකට සමානද?", "Opposite sides of rectangle equal?", listOf("ඔව්", "සමානයි"), "ඔව්, එකිනෙකට සමාන වේ.", "සමාන වේ.")
        12 -> Quintuple("රොම්බසයක පාද 4ම එකිනෙකට සමානද?", "Are all 4 sides of rhombus equal?", listOf("ඔව්", "සමානයි"), "ඔව්, පාද 4ම සමාන වේ.", "සමාන වේ.")
        13 -> Quintuple("ත්‍රිකෝණයක කෝණ දෙකක් 50° සහ 60° නම් තෙවන කෝණය කීයද?", "Third angle if two are 50 and 60?", listOf("70", "70ක්", "අංශක 70"), "අංශක 70 කි (180 - 110 = 70).", "180න් අඩු කරන්න.")
        14 -> Quintuple("සමකෝණී ත්‍රිකෝණයක කෝණ තුනම එකිනෙකට සමානද?", "Are all angles equal in equiangular triangle?", listOf("ඔව්", "සමානයි"), "ඔව්, අංශක 60 බැගින් සමාන වේ.", "සමාන වේ.")
        15 -> Quintuple("ත්‍රිකෝණයක ශීර්ෂ කීයක් තිබේද?", "Vertices in triangle?", listOf("3", "3ක්", "තුනක්"), "ශීර්ෂ 3කි.", "තුනකි.")
        16 -> Quintuple("චතුරස්‍රයක විකර්ණ කීයක් තිබේද?", "Diagonals in quadrilateral?", listOf("2", "2ක්", "දෙකක්"), "විකර්ණ 2කි.", "දෙකකි.")
        17 -> Quintuple("පාද 5ක් ඇති බහුඅස්‍රය හඳුන්වන්නේ කෙසේද?", "Polygon with 5 sides?", listOf("පංචඅස්‍රය", "පංචාස්‍රය"), "පංචඅස්‍රය (Pentagon) නමිනි.", "පංචඅස්‍රයයි.")
        18 -> Quintuple("පාද 6ක් ඇති බහුඅස්‍රය හඳුන්වන්නේ කෙසේද?", "Polygon with 6 sides?", listOf("ෂඩස්‍රය"), "ෂඩස්‍රය (Hexagon) නමිනි.", "ෂඩස්‍රයයි.")
        19 -> Quintuple("පාද 8ක් ඇති බහුඅස්‍රය හඳුන්වන්නේ කෙසේද?", "Polygon with 8 sides?", listOf("අෂ්ටාස්‍රය", "අෂ්ටඅස්‍රය"), "අෂ්ටාස්‍රය (Octagon) නමිනි.", "අෂ්ටාස්‍රයයි.")
        20 -> Quintuple("සමාන්තරාස්‍රයක සම්මුඛ කෝණ එකිනෙකට සමානද?", "Opposite angles of parallelogram equal?", listOf("ඔව්", "සමානයි"), "ඔව්, සම්මුඛ කෝණ සමාන වේ.", "සමාන වේ.")
        else -> Quintuple("ත්‍රිකෝණයකට විකර්ණ අඳින්න පුළුවන්ද?", "Can a triangle have diagonals?", listOf("බැහැ", "නැත", "නැහැ"), "නැත, ත්‍රිකෝණයකට විකර්ණ නැත.", "නැත.")
      }

      // Set 5: පරිමිතිය, දිග & මිනුම් ඒකක
      5 -> when (qIndex) {
        1 -> Quintuple("මීටර 1ක සෙන්ටිමීටර කීයක් තිබේද?", "Centimeters in 1 meter?", listOf("100", "100ක්", "සියයක්"), "100ක් (සෙන්ටිමීටර 100) තිබේ.", "100කි.")
        2 -> Quintuple("කිලෝමීටර 1ක මීටර කීයක් තිබේද?", "Meters in 1 kilometer?", listOf("1000", "1000ක්", "දහසක්"), "1000ක් (මීටර 1000) තිබේ.", "1000කි.")
        3 -> Quintuple("සෙන්ටිමීටර 1ක මිලිමීටර කීයක් තිබේද?", "Millimeters in 1 centimeter?", listOf("10", "10ක්", "දහයක්"), "10ක් (මිලිමීටර 10) තිබේ.", "10කි.")
        4 -> Quintuple("කිලෝග්‍රෑම් 1ක ග්‍රෑම් කීයක් තිබේද?", "Grams in 1 kilogram?", listOf("1000", "1000ක්", "දහසක්"), "1000ක් (ග්‍රෑම් 1000) තිබේ.", "1000කි.")
        5 -> Quintuple("ලීටර 1ක මිලිලීටර කීයක් තිබේද?", "Milliliters in 1 liter?", listOf("1000", "1000ක්", "දහසක්"), "1000ක් (මිලිලීටර 1000) තිබේ.", "1000කි.")
        6 -> Quintuple("පැය 1ක මිනිත්තු කීයක් තිබේද?", "Minutes in 1 hour?", listOf("60", "60ක්", "හැටක්"), "මිනිත්තු 60කි.", "60කි.")
        7 -> Quintuple("මිනිත්තු 1ක තත්පර කීයක් තිබේද?", "Seconds in 1 minute?", listOf("60", "60ක්", "හැටක්"), "තත්පර 60කි.", "60කි.")
        8 -> Quintuple("දින 1කට පැය කීයක් තිබේද?", "Hours in 1 day?", listOf("24", "24ක්", "විසිහතරක්"), "පැය 24කි.", "24කි.")
        9 -> Quintuple("පාදයක දිග 5cm වන සමචතුරස්‍රයක පරිමිතිය කීයද?", "Perimeter of square with side 5cm?", listOf("20", "20cm", "විස්සයි"), "20cm (5 × 4 = 20) වේ.", "5 × 4 = 20.")
        10 -> Quintuple("පාදයක දිග 3cm වන සමපාද ත්‍රිකෝණයක පරිමිතිය කීයද?", "Perimeter of equilateral triangle with side 3cm?", listOf("9", "9cm", "නවයයි"), "9cm (3 × 3 = 9) වේ.", "3 × 3 = 9.")
        11 -> Quintuple("දිග 4cm සහ පළල 2cm වන සෘජුකෝණාස්‍රයක පරිමිතිය කීයද?", "Perimeter of rectangle 4cm by 2cm?", listOf("12", "12cm", "දොළහයි"), "12cm (4+2+4+2 = 12) වේ.", "වටේ එකතුව 12යි.")
        12 -> Quintuple("තල රූපයක වටේ දිග හඳුන්වන වචනය කුමක්ද?", "Boundary length of flat shape?", listOf("පරිමිතිය"), "පරිමිතිය වේ.", "පරිමිතිය වේ.")
        13 -> Quintuple("වෘත්තයක වටේ දිග හඳුන්වන්නේ කෙසේද?", "Boundary of circle?", listOf("පරිධිය"), "පරිධිය (Circumference) නමිනි.", "පරිධිය වේ.")
        14 -> Quintuple("වෘත්තයක කේන්ද්‍රයේ සිට පරිධියට ඇති දුර කුමක්ද?", "Distance from center to circumference?", listOf("අරය", "radius"), "අරය (Radius) වේ.", "අරය වේ.")
        15 -> Quintuple("වෘත්තයක විෂ්කම්භය අරය මෙන් කී ගුණයක්ද?", "Diameter is how many times radius?", listOf("2", "දෙගුණයක්", "දෙකක්"), "2 ගුණයක් (දෙගුණයක්) වේ.", "දෙගුණයකි.")
        16 -> Quintuple("අරය 7cm වන වෘත්තයක විෂ්කම්භය කීයද?", "Diameter of circle with radius 7cm?", listOf("14", "14cm", "දාහතරයි"), "14cm වේ.", "7 × 2 = 14.")
        17 -> Quintuple("විෂ්කම්භය 10cm වන වෘත්තයක අරය කීයද?", "Radius of circle with diameter 10cm?", listOf("5", "5cm", "පහයි"), "5cm වේ.", "10න් අඩ 5යි.")
        18 -> Quintuple("දිග මනින අන්තර්ජාතික (SI) සම්මත ඒකකය කුමක්ද?", "SI unit of length?", listOf("මීටර", "මීටරය", "m"), "මීටරය (m) වේ.", "මීටරය වේ.")
        19 -> Quintuple("ස්කන්ධය මනින සම්මත SI ඒකකය කුමක්ද?", "SI unit of mass?", listOf("කිලෝග්‍රෑම්", "kg"), "කිලෝග්‍රෑමය (kg) වේ.", "කිලෝග්‍රෑමය වේ.")
        20 -> Quintuple("කාලය මනින සම්මත SI ඒකකය කුමක්ද?", "SI unit of time?", listOf("තත්පර", "තත්පරය", "s"), "තත්පරය (s) වේ.", "තත්පරය වේ.")
        else -> Quintuple("පරිමිතිය මනින්නේ වර්ග ඒකක වලින්ද දිග ඒකක වලින්ද?", "Is perimeter in length or area units?", listOf("දිග", "දිග ඒකක"), "දිග ඒකක (cm, m) මඟිනි.", "දිග ඒකකයකි.")
      }

      // Set 6: සෘජුකෝණී ත්‍රිකෝණ & පයිතගරස් මූලිකාංග
      6 -> when (qIndex) {
        1 -> Quintuple("සෘජුකෝණී ත්‍රිකෝණයක සෘජුකෝණයට ඉදිරියෙන් ඇති දිගම පාදය කුමක්ද?", "Longest side opposite right angle?", listOf("කර්ණය", "hypotenuse"), "කර්ණය (Hypotenuse) වේ.", "කර්ණය වේ.")
        2 -> Quintuple("පාද 3cm සහ 4cm වන සෘජුකෝණී ත්‍රිකෝණයක කර්ණයේ දිග කීයද?", "Hypotenuse when sides are 3cm and 4cm?", listOf("5", "5cm", "පහයි"), "5cm වේ (3² + 4² = 5²).", "5 වේ.")
        3 -> Quintuple("පයිතගරස් ත්‍රිත්වයක් සඳහා සරලම උදාහරණය කුමක්ද?", "Simplest Pythagorean triple?", listOf("3, 4, 5", "3 4 5", "3,4,5"), "3, 4, 5 වේ.", "3, 4, 5 වේ.")
        4 -> Quintuple("සෘජුකෝණී ත්‍රිකෝණයක දිගම පාදය කර්ණයද?", "Is hypotenuse the longest side?", listOf("ඔව්", "එසේය"), "ඔව්, දිගම පාදය කර්ණයයි.", "ඔව් වේ.")
        5 -> Quintuple("කර්ණය 10cm සහ එක් පාදයක් 6cm නම් අනෙක් පාදය කීයද?", "Other side if hypotenuse is 10 and one side 6?", listOf("8", "8cm", "අටයි"), "8cm වේ (6, 8, 10 ත්‍රිත්වය).", "8 වේ.")
        6 -> Quintuple("සෘජුකෝණී ත්‍රිකෝණයකට සෘජුකෝණ කීයක් තිබිය හැකිද?", "How many right angles in right triangle?", listOf("1", "1ක්", "එකක්"), "1ක් පමණි.", "එකකි.")
        7 -> Quintuple("සෘජුකෝණී ත්‍රිකෝණයක අනෙක් කෝණ දෙක අනිවාර්යයෙන්ම සුළු කෝණද?", "Are other two angles acute?", listOf("ඔව්", "එසේය"), "ඔව්, අනෙක් කෝණ 2ක එකතුව 90°කි.", "ඔව් වේ.")
        8 -> Quintuple("සෘජුකෝණී ත්‍රිකෝණයක එක් සුළු කෝණයක් 30° නම් අනෙක් කෝණය කීයද?", "Other acute angle if one is 30?", listOf("60", "60ක්", "අංශක 60"), "අංශක 60 කි (90 - 30 = 60).", "60 කි.")
        9 -> Quintuple("සෘජුකෝණී ත්‍රිකෝණයක සුළු කෝණ දෙක සමාන නම් ඒවායේ අගය කීයද?", "Equal acute angles in right triangle?", listOf("45", "45ක්", "අංශක 45"), "අංශක 45 බැගින් වේ.", "45 බැගින් වේ.")
        10 -> Quintuple("5, 12, 13 යනු පයිතගරස් ත්‍රිත්වයක්ද?", "Is 5, 12, 13 a Pythagorean triple?", listOf("ඔව්", "එසේය"), "ඔව්, පයිතගරස් ත්‍රිත්වයකි.", "ඔව් වේ.")
        11 -> Quintuple("3හි වර්ගය කීයද?", "Square of 3?", listOf("9", "නවය"), "9 වේ (3 × 3 = 9).", "9 වේ.")
        12 -> Quintuple("4හි වර්ගය කීයද?", "Square of 4?", listOf("16", "දහසය"), "16 වේ (4 × 4 = 16).", "16 වේ.")
        13 -> Quintuple("5හි වර්ගය කීයද?", "Square of 5?", listOf("25", "විසිපහ"), "25 වේ (5 × 5 = 25).", "25 වේ.")
        14 -> Quintuple("6හි වර්ගය කීයද?", "Square of 6?", listOf("36", "තිස්හය"), "36 වේ (6 × 6 = 36).", "36 වේ.")
        15 -> Quintuple("10හි වර්ගය කීයද?", "Square of 10?", listOf("100", "සියය"), "100 වේ (10 × 10 = 100).", "100 වේ.")
        16 -> Quintuple("කර්ණය සොයන්නේ පාද දෙකේ වර්ග එකතු කිරීමෙන්ද අඩු කිරීමෙන්ද?", "Hypotenuse found by adding or subtracting squares?", listOf("එකතු කිරීමෙන්", "එකතු"), "වර්ග එකතු කිරීමෙනි.", "එකතු කිරීමෙනි.")
        17 -> Quintuple("ත්‍රිකෝණයේ වර්ගඵලය සොයන්නේ ආධාරකය සහ ලම්බ උස ගුණ කර කීයෙන් බෙදීමෙන්ද?", "Area by multiplying base and height divided by what?", listOf("2", "දෙකෙන්", "2න්"), "2න් (දෙකෙන්) බෙදීමෙනි.", "2න් බෙදයි.")
        18 -> Quintuple("ආධාරකය 6cm සහ ලම්බ උස 4cm වන ත්‍රිකෝණයක වර්ගඵලය කීයද?", "Area of triangle with base 6cm and height 4cm?", listOf("12", "12cm²", "දොළහයි"), "12 cm² වේ (6 × 4 / 2 = 12).", "12 වේ.")
        19 -> Quintuple("සෘජුකෝණී ත්‍රිකෝණයක ලම්බ උස යනු එක් පාදයක්මද?", "Is perpendicular height one of the sides in right triangle?", listOf("ඔව්", "එසේය"), "ඔව්, සෘජුකෝණය සාදන පාදයකි.", "ඔව් වේ.")
        20 -> Quintuple("පයිතගරස් ප්‍රමේයය අදාළ වන්නේ කුමන ත්‍රිකෝණ සඳහා පමණද?", "Pythagoras theorem applies to which triangles?", listOf("සෘජුකෝණී", "සෘජුකෝණී ත්‍රිකෝණ"), "සෘජුකෝණී ත්‍රිකෝණ සඳහා පමණි.", "සෘජුකෝණී වේ.")
        else -> Quintuple("කර්ණය සෑමවිටම අනික් පාද දෙකට වඩා දිගින් වැඩියිද?", "Is hypotenuse always longer than other sides?", listOf("ඔව්", "එසේය"), "ඔව්, දිගම පාදයයි.", "ඔව් වේ.")
      }

      // Set 7: ඝන වස්තු, මුහුණත් & දාර
      7 -> when (qIndex) {
        1 -> Quintuple("ඝනකයකට මුහුණත් කීයක් තිබේද?", "Faces in a cube?", listOf("6", "6ක්", "හයක්"), "මුහුණත් 6කි.", "6කි.")
        2 -> Quintuple("ඝනකයකට ශීර්ෂ කීයක් තිබේද?", "Vertices in a cube?", listOf("8", "8ක්", "අටක්"), "ශීර්ෂ 8කි.", "8කි.")
        3 -> Quintuple("ඝනකයකට දාර කීයක් තිබේද?", "Edges in a cube?", listOf("12", "12ක්", "දොළහක්"), "දාර 12කි.", "12කි.")
        4 -> Quintuple("ඝනකාභයකට මුහුණත් කීයක් තිබේද?", "Faces in a cuboid?", listOf("6", "6ක්", "හයක්"), "මුහුණත් 6කි.", "6කි.")
        5 -> Quintuple("ගෝලයකට පැතලි මුහුණත් තිබේද?", "Does a sphere have flat faces?", listOf("නැත", "නැහැ"), "නැත, වක්‍ර පෘෂ්ඨයක් පමණි.", "නැත.")
        6 -> Quintuple("සිලින්ඩරයකට පැතලි වෘත්තාකාර මුහුණත් කීයක් තිබේද?", "Flat circular faces in cylinder?", listOf("2", "2ක්", "දෙකක්"), "මුහුණත් 2කි (උඩ සහ යට).", "2කි.")
        7 -> Quintuple("කේතුවකට උල් වූ ශීර්ෂ කීයක් තිබේද?", "Pointed apex in cone?", listOf("1", "1ක්", "එකක්"), "ශීර්ෂ 1කි.", "1කි.")
        8 -> Quintuple("කේතුවක අඩිය කුමන හැඩයක් ගනීද?", "Base shape of cone?", listOf("වෘත්තාකාර", "වෘත්තයක්", "රවුම්"), "වෘත්තාකාර හැඩයක් ගනී.", "වෘත්තයකි.")
        9 -> Quintuple("ත්‍රිකෝණාස්‍ර ප්‍රිස්මයකට ත්‍රිකෝණාකාර මුහුණත් කීයක් තිබේද?", "Triangular faces in triangular prism?", listOf("2", "2ක්", "දෙකක්"), "මුහුණත් 2කි.", "2කි.")
        10 -> Quintuple("ත්‍රිකෝණාස්‍ර ප්‍රිස්මයකට සෘජුකෝණාස්‍රාකාර මුහුණත් කීයක් තිබේද?", "Rectangular faces in triangular prism?", listOf("3", "3ක්", "තුනක්"), "මුහුණත් 3කි.", "3කි.")
        11 -> Quintuple("ත්‍රිකෝණාස්‍ර ප්‍රිස්මයක මුළු මුහුණත් ගණන කීයද?", "Total faces in triangular prism?", listOf("5", "5ක්", "පහක්"), "මුහුණත් 5කි (2 + 3 = 5).", "5කි.")
        12 -> Quintuple("චතුරස්‍රාකාර පිරමිඩයක අඩිය කුමන හැඩයක්ද?", "Base shape of square pyramid?", listOf("සමචතුරස්‍ර", "සමචතුරස්‍රයක්"), "සමචතුරස්‍රාකාර වේ.", "සමචතුරස්‍රයකි.")
        13 -> Quintuple("ඝනකයක සියලුම මුහුණත් එකම ප්‍රමාණයේ සමචතුරස්‍රද?", "Are all cube faces identical squares?", listOf("ඔව්", "එසේය"), "ඔව්, සමාන සමචතුරස්‍ර 6කි.", "ඔව් වේ.")
        14 -> Quintuple("ඔයිලර්ගේ සම්බන්ධතාවයට අනුව මුහුණත් (F) සහ ශීර්ෂ (V) එකතුවෙන් දාර (E) අඩු කළ විට ලැබෙන අගය කීයද?", "Euler's formula F + V - E?", listOf("2", "දෙක"), "2 (දෙක) ලැබේ (F + V - E = 2).", "2 වේ.")
        15 -> Quintuple("පාදයක දිග 2cm වන ඝනකයක පරිමාව කීයද?", "Volume of cube with side 2cm?", listOf("8", "8cm³", "අටයි"), "8 cm³ වේ (2 × 2 × 2 = 8).", "8 වේ.")
        16 -> Quintuple("දිග 3cm, පළල 2cm, උස 1cm වන ඝනකාභයක පරිමාව කීයද?", "Volume of cuboid 3cm by 2cm by 1cm?", listOf("6", "6cm³", "හයයි"), "6 cm³ වේ (3 × 2 × 1 = 6).", "6 වේ.")
        17 -> Quintuple("පරිමාව මනින සම්මත ඒකකයකට උදාහරණයක් පවසන්න.", "Example unit of volume?", listOf("cm³", "m³", "ඝන සෙන්ටිමීටර", "ලීටර"), "ඝන සෙන්ටිමීටර (cm³) හෝ ලීටර වේ.", "cm³ වේ.")
        18 -> Quintuple("ඝන වස්තුවක සියලුම මුහුණත්වල වර්ගඵල එකතුව හඳුන්වන්නේ කෙසේද?", "Sum of all faces' areas?", listOf("පෘෂ්ඨ වර්ගඵලය", "වර්ගඵලය"), "පෘෂ්ඨ වර්ගඵලය (Surface area) නමිනි.", "පෘෂ්ඨ වර්ගඵලයයි.")
        19 -> Quintuple("පාදයක දිග 1cm වන ඝනකයක පෘෂ්ඨ වර්ගඵලය කීයද?", "Surface area of cube with side 1cm?", listOf("6", "6cm²", "හයයි"), "6 cm² වේ (1 × 1 × 6 = 6).", "6 වේ.")
        20 -> Quintuple("ක්‍රිකට් බෝලයක් අයත් වන ඝන වස්තු හැඩය කුමක්ද?", "Shape of cricket ball?", listOf("ගෝලය", "ගෝලයක්", "Sphere"), "ගෝලය (Sphere) වේ.", "ගෝලයකි.")
        else -> Quintuple("ඝනකයක සියලු දාර දිගින් සමානද?", "Are all cube edges equal?", listOf("ඔව්", "එසේය"), "ඔව්, සියලු දාර සමාන වේ.", "ඔව් වේ.")
      }

      // Set 8: වර්ගමූල, ඝනමූල & දර්ශක
      8 -> when (qIndex) {
        1 -> Quintuple("4 හි වර්ගමූලය (√4) කීයද?", "Square root of 4?", listOf("2", "දෙක"), "2 වේ.", "2 වේ.")
        2 -> Quintuple("9 හි වර්ගමූලය (√9) කීයද?", "Square root of 9?", listOf("3", "තුන"), "3 වේ.", "3 වේ.")
        3 -> Quintuple("16 හි වර්ගමූලය (√16) කීයද?", "Square root of 16?", listOf("4", "හතර"), "4 වේ.", "4 වේ.")
        4 -> Quintuple("25 හි වර්ගමූලය (√25) කීයද?", "Square root of 25?", listOf("5", "පහ"), "5 වේ.", "5 වේ.")
        5 -> Quintuple("36 හි වර්ගමූලය (√36) කීයද?", "Square root of 36?", listOf("6", "හය"), "6 වේ.", "6 වේ.")
        6 -> Quintuple("49 හි වර්ගමූලය (√49) කීයද?", "Square root of 49?", listOf("7", "හත"), "7 වේ.", "7 වේ.")
        7 -> Quintuple("64 හි වර්ගමූලය (√64) කීයද?", "Square root of 64?", listOf("8", "අට"), "8 වේ.", "8 වේ.")
        8 -> Quintuple("81 හි වර්ගමූලය (√81) කීයද?", "Square root of 81?", listOf("9", "නවය"), "9 වේ.", "9 වේ.")
        9 -> Quintuple("100 හි වර්ගමූලය (√100) කීයද?", "Square root of 100?", listOf("10", "දහය"), "10 වේ.", "10 වේ.")
        10 -> Quintuple("දෙකෙහි දෙවන බලය (2²) කීයද?", "2 to power 2?", listOf("4", "හතර"), "4 වේ.", "4 වේ.")
        11 -> Quintuple("දෙකෙහි තුන්වන බලය හෙවත් ඝනය (2³) කීයද?", "2 cubed (2³)?", listOf("8", "අට"), "8 වේ (2 × 2 × 2 = 8).", "8 වේ.")
        12 -> Quintuple("දෙකෙහි හතරවන බලය (2⁴) කීයද?", "2 to power 4?", listOf("16", "දහසය"), "16 වේ.", "16 වේ.")
        13 -> Quintuple("තුනෙහි දෙවන බලය (3²) කීයද?", "3 squared?", listOf("9", "නවය"), "9 වේ.", "9 වේ.")
        14 -> Quintuple("තුනෙහි තුන්වන බලය හෙවත් ඝනය (3³) කීයද?", "3 cubed?", listOf("27", "විසිහත"), "27 වේ (3 × 3 × 3 = 27).", "27 වේ.")
        15 -> Quintuple("ඕනෑම ශුන්‍ය නොවන සංඛ්‍යාවක ශුන්‍ය වන බලයේ (a⁰) අගය කීයද?", "Any non-zero number to power 0?", listOf("1", "එක"), "1 (එක) වේ.", "1 වේ.")
        16 -> Quintuple("10 හි පළමු බලය (10¹) කීයද?", "10 to power 1?", listOf("10", "දහය"), "10 වේ.", "10 වේ.")
        17 -> Quintuple("10 හි දෙවන බලය (10²) කීයද?", "10 squared?", listOf("100", "සියය"), "100 වේ.", "100 වේ.")
        18 -> Quintuple("10 හි තුන්වන බලය (10³) කීයද?", "10 cubed?", listOf("1000", "දහස"), "1000 වේ.", "1000 වේ.")
        19 -> Quintuple("8 හි ඝනමූලය (∛8) කීයද?", "Cube root of 8?", listOf("2", "දෙක"), "2 වේ.", "2 වේ.")
        20 -> Quintuple("27 හි ඝනමූලය (∛27) කීයද?", "Cube root of 27?", listOf("3", "තුන"), "3 වේ.", "3 වේ.")
        else -> Quintuple("1 හි වර්ගමූලය කීයද?", "Square root of 1?", listOf("1", "එක"), "1 වේ.", "1 වේ.")
      }

      // Set 9: සංඛ්‍යානය & දත්ත
      9 -> when (qIndex) {
        1 -> Quintuple("දත්ත සමූහයක නිතරම හමුවන (වැඩිම වාර ගණනක් ඇති) අගය කුමක්ද?", "Most frequent value in data set?", listOf("මාතය", "mode"), "මාතය (Mode) වේ.", "මාතය වේ.")
        2 -> Quintuple("දත්ත ආරෝහණ පිළිවෙලට සැකසූ විට හරි මැද පිහිටන අගය කුමක්ද?", "Middle value when sorted?", listOf("මධ්‍යස්ථය", "median"), "මධ්‍යස්ථය (Median) වේ.", "මධ්‍යස්ථය වේ.")
        3 -> Quintuple("දත්තවල එකතුව දත්ත සංඛ්‍යාවෙන් බෙදූ විට ලැබෙන අගය කුමක්ද?", "Sum divided by count?", listOf("මධ්‍යන්‍යය", "mean", "සාමාන්‍යය"), "මධ්‍යන්‍යය (Mean / Average) වේ.", "මධ්‍යන්‍යයයි.")
        4 -> Quintuple("විශාලතම අගය සහ කුඩාම අගය අතර වෙනස හඳුන්වන්නේ කෙසේද?", "Difference between maximum and minimum?", listOf("පරාසය", "range"), "පරාසය (Range) නමිනි.", "පරාසය වේ.")
        5 -> Quintuple("2, 3, 3, 5, 7 හි මාතය කීයද?", "Mode of 2, 3, 3, 5, 7?", listOf("3", "තුන"), "3 (වැඩිම වාර ගණනක් ඇත).", "3 වේ.")
        6 -> Quintuple("1, 3, 5, 7, 9 හි මධ්‍යස්ථය කීයද?", "Median of 1, 3, 5, 7, 9?", listOf("5", "පහ"), "5 (මැද අගය) වේ.", "5 වේ.")
        7 -> Quintuple("2, 4, 6 හි මධ්‍යන්‍යය (සාමාන්‍යය) කීයද?", "Mean of 2, 4, 6?", listOf("4", "හතර"), "4 වේ (12 / 3 = 4).", "4 වේ.")
        8 -> Quintuple("විශාලතම අගය 15 සහ කුඩාම අගය 5 නම් පරාසය කීයද?", "Range if max is 15 and min is 5?", listOf("10", "දහය"), "10 වේ (15 - 5 = 10).", "10 වේ.")
        9 -> Quintuple("දත්තයක් සිදුවූ වාර ගණන හඳුන්වන්නේ කෙසේද?", "Count of occurrences of a data item?", listOf("සංඛ්‍යාතය", "frequency"), "සංඛ්‍යාතය (Frequency) නමිනි.", "සංඛ්‍යාතය වේ.")
        10 -> Quintuple("සංඛ්‍යාත සටහන් කරගැනීමට භාවිත කරන ඉරි සලකුණු හඳුන්වන්නේ කෙසේද?", "Tally marks used for counts?", listOf("ප්‍රගණන ලකුණු", "tally"), "ප්‍රගණන ලකුණු (Tally marks) නමිනි.", "ප්‍රගණන ලකුණුයි.")
        11 -> Quintuple("ප්‍රගණන ලකුණු කණ්ඩායම් කරන්නේ කීයේ කාණ්ඩ ලෙසද?", "Tally marks grouped in sets of what?", listOf("5", "5ක්", "පහක්"), "5 බැගින් වූ කාණ්ඩ ලෙසය.", "5 බැගිනි.")
        12 -> Quintuple("වටකුරු තැටියක කෝණික ඛණ්ඩ මඟින් දත්ත පෙන්වන ප්‍රස්ථාරය කුමක්ද?", "Circular graph with angle sectors?", listOf("වට ප්‍රස්ථාරය", "pie chart"), "වට ප්‍රස්ථාරය (Pie chart) වේ.", "වට ප්‍රස්ථාරයයි.")
        13 -> Quintuple("වට ප්‍රස්ථාරයක මුළු කෝණ එකතුව අංශක කීයද?", "Total angles in pie chart?", listOf("360", "360ක්", "අංශක 360"), "අංශක 360 කි.", "360 කි.")
        14 -> Quintuple("වට ප්‍රස්ථාරයක අඩක් (50%) නිරූපණය කරන කෝණය අංශක කීයද?", "Angle for 50% in pie chart?", listOf("180", "180ක්", "අංශක 180"), "අංශක 180 කි.", "180 කි.")
        15 -> Quintuple("වට ප්‍රස්ථාරයක 25%ක් නිරූපණය කරන කෝණය අංශක කීයද?", "Angle for 25% in pie chart?", listOf("90", "90ක්", "අංශක 90"), "අංශක 90 කි.", "90 කි.")
        16 -> Quintuple("තීරු මඟින් දත්ත සංසන්දනය කරන ප්‍රස්ථාරය කුමක්ද?", "Chart with bars?", listOf("තීරු ප්‍රස්ථාරය", "bar chart"), "තීරු ප්‍රස්ථාරය (Bar chart) වේ.", "තීරු ප්‍රස්ථාරයයි.")
        17 -> Quintuple("දත්ත ආරෝහණ පිළිවෙලට සකසනවා යනු කුඩා අගයේ සිටද විශාල අගයේ සිටද?", "Ascending order means from small to large or large to small?", listOf("කුඩා අගයේ සිට", "කුඩා සිට විශාල", "small to large"), "කුඩා අගයේ සිට විශාල අගය දක්වාය.", "කුඩා සිට විශාලයි.")
        18 -> Quintuple("දත්ත අවරෝහණ පිළිවෙලට සකසනවා යනු විශාල අගයේ සිට කුඩා අගය දක්වාද?", "Descending order from large to small?", listOf("ඔව්", "එසේය"), "ඔව්, විශාල අගයේ සිට කුඩා අගය දක්වාය.", "ඔව් වේ.")
        19 -> Quintuple("3 සහ 7 හි මධ්‍යන්‍යය කීයද?", "Mean of 3 and 7?", listOf("5", "පහ"), "5 වේ (10 / 2 = 5).", "5 වේ.")
        20 -> Quintuple("සෑම දත්තයක්ම එක් වරක් පමණක් ඇත්නම් මාතයක් තිබේද?", "Is there a mode if each value appears once?", listOf("නැත", "නැහැ"), "නැත, මාතයක් නැත.", "නැත.")
        else -> Quintuple("දත්ත රැස්කිරීම සංඛ්‍යානයේ ආරම්භක පියවරද?", "Is data collection first step in statistics?", listOf("ඔව්", "එසේය"), "ඔව්, මුල්ම පියවරයි.", "ඔව් වේ.")
      }

      // Set 10: සම්භාවිතාව & කුලක
      10 -> when (qIndex) {
        1 -> Quintuple("කාසියක් උඩ දැමූ විට 'සිරස' ලැබීමේ සම්භාවිතාව කීයද?", "Probability of heads when flipping a coin?", listOf("1/2", "දෙකෙන් එක", "0.5"), "1/2 (දෙකෙන් එක) වේ.", "1/2 වේ.")
        2 -> Quintuple("අනිවාර්යයෙන්ම සිදුවන සිද්ධියක සම්භාවිතාව කීයද?", "Probability of a certain event?", listOf("1", "එක"), "1 (එක) වේ.", "1 වේ.")
        3 -> Quintuple("කිසිසේත්ම සිදුවිය නොහැකි සිද්ධියක සම්භාවිතාව කීයද?", "Probability of impossible event?", listOf("0", "බිංදුව"), "0 (ශුන්‍යය) වේ.", "0 වේ.")
        4 -> Quintuple("සාමාන්‍ය දාදු කැටයක මුහුණත් කීයක් තිබේද?", "Faces on a standard die?", listOf("6", "6ක්", "හයක්"), "මුහුණත් 6කි (1 සිට 6 දක්වා).", "6කි.")
        5 -> Quintuple("සාමාන්‍ය දාදු කැටයක් දැමූ විට අංක 6 ලැබීමේ සම්භාවිතාව කීයද?", "Probability of rolling a 6?", listOf("1/6", "හයෙන් එක"), "1/6 (හයෙන් එක) වේ.", "1/6 වේ.")
        6 -> Quintuple("දාදු කැටයක ඇති ඉරට්ටේ සංඛ්‍යා ගණන කීයද?", "Even numbers on a die?", listOf("3", "3ක්", "තුනක්"), "3කි (2, 4, 6).", "3කි.")
        7 -> Quintuple("සම්භාවිතාව සෑමවිටම 0 සහ කුමන අගය අතර පවතීද?", "Probability is between 0 and what value?", listOf("1", "එක"), "1 (එක) අතර වේ (0 ≤ P ≤ 1).", "1 වේ.")
        8 -> Quintuple("කිසිදු මූලද්‍රව්‍යයක් නැති කුලකය හඳුන්වන්නේ කෙසේද?", "Set with no elements?", listOf("හිස් කුලකය", "ශුන්‍ය කුලකය"), "හිස් කුලකය (Null / Empty set) නමිනි.", "හිස් කුලකයයි.")
        9 -> Quintuple("හිස් කුලකයේ මූලද්‍රව්‍ය ගණන කීයද?", "Number of elements in null set?", listOf("0", "බිංදුව"), "0 (ශුන්‍යය) වේ.", "0 වේ.")
        10 -> Quintuple("කුලක දෙකකම ඇති පොදු මූලද්‍රව්‍ය වලින් සෑදෙන කුලකය කුමක්ද?", "Set of common elements?", listOf("ඡේදනය", "Intersection"), "ඡේදනය (Intersection - ∩) වේ.", "ඡේදනයයි.")
        11 -> Quintuple("කුලක දෙකේම සියලුම මූලද්‍රව්‍ය එක්කර සෑදෙන කුලකය කුමක්ද?", "Set of all elements combined?", listOf("මේලය", "Union"), "මේලය (Union - ∪) වේ.", "මේලයයි.")
        12 -> Quintuple("කුලක නිරූපණය කිරීමට අඳින රූප සටහන් හඳුන්වන්නේ කෙසේද?", "Diagrams used to represent sets?", listOf("වෙන් රූප", "Venn diagrams"), "වෙන් රූප සටහන් (Venn diagrams) නමිනි.", "වෙන් රූපයි.")
        13 -> Quintuple("සියලුම උපකුලක අයත් වන ප්‍රධාන කුලකය කුමක්ද?", "Main set containing all elements?", listOf("සර්වත්‍ර කුලකය", "Universal set"), "සර්වත්‍ර කුලකය (Universal set - ε) වේ.", "සර්වත්‍ර කුලකයයි.")
        14 -> Quintuple("සර්වත්‍ර කුලකය වෙන් රූපවල නිරූපණය කරන්නේ කුමන හැඩයෙන්ද?", "Shape representing universal set?", listOf("සෘජුකෝණාස්‍ර", "සෘජුකෝණාස්‍රය"), "සෘජුකෝණාස්‍රයකිනි.", "සෘජුකෝණාස්‍රයකි.")
        15 -> Quintuple("කාසියක් උඩ දැමූ විට ලැබිය හැකි සමස්ත ප්‍රතිඵල ගණන කීයද?", "Total possible outcomes when flipping coin?", listOf("2", "දෙකක්"), "2කි (සිරස හෝ අගය).", "2කි.")
        16 -> Quintuple("දාදු කැටයක් දැමූ විට ලැබිය හැකි සමස්ත ප්‍රතිඵල ගණන කීයද?", "Total outcomes rolling a die?", listOf("6", "හයක්"), "6කි (1, 2, 3, 4, 5, 6).", "6කි.")
        17 -> Quintuple("සම්භාවිතාව සෘණ අගයක් විය හැකිද?", "Can probability be negative?", listOf("නැත", "නැහැ"), "නැත, කිසිවිටෙක සෘණ විය නොහැක.", "නැත.")
        18 -> Quintuple("සම්භාවිතාව 1ට වඩා වැඩි විය හැකිද?", "Can probability be greater than 1?", listOf("නැත", "නැහැ"), "නැත, 1ට වඩා වැඩි විය නොහැක.", "නැත.")
        19 -> Quintuple("සිද්ධියක් සිදුවීමේ සම්භාවිතාව 0.4 නම් එය සිදුනොවීමේ සම්භාවිතාව කීයද?", "If P(E) = 0.4, what is P(not E)?", listOf("0.6", "ශුන්‍යයි දශම හය"), "0.6 වේ (1 - 0.4 = 0.6).", "0.6 වේ.")
        20 -> Quintuple("A = {1, 2} හි මූලද්‍රව්‍ය ගණන (n(A)) කීයද?", "Number of elements in A = {1, 2}?", listOf("2", "දෙක"), "2 (දෙක) වේ.", "2 වේ.")
        else -> Quintuple("හිස් කුලකයේ සංකේතය කුමක්ද?", "Symbol for null set?", listOf("∅", "{}"), "∅ හෝ {} වේ.", "හිස් ලකුණයි.")
      }
      else -> when (qIndex) {
        1 -> Quintuple("ඕනෑම සංඛ්‍යාවක් බිංදුවෙන් ගුණ කළ විට ලැබෙන අගය කීයද?", "What is result of multiplying any number by zero?", listOf("0", "බිංදුව"), "0 (ශුන්‍යය) වේ.", "0 වේ.")
        else -> Quintuple("ඕනෑම සංඛ්‍යාවක ශුන්‍ය වෙනි බලය (a⁰) කීයද?", "Any number to power zero?", listOf("1", "එක"), "1 (එක) වේ.", "1 වේ.")
      }
    }
  }

  // ==============================================================================
  // GRADE 11 O/L MATH BANK (100% GRADE 11 SYLLABUS - SIMPLE, DIRECT & NO FORMULA CRAMMING)
  // ==============================================================================
  private fun getGrade11Question(setNum: Int, qIndex: Int, theme: String): Quintuple<String, String, List<String>, String, String> {
    return when (setNum) {
      // Set 1: දර්ශක හා ලඝුගණක නීති
      1 -> when (qIndex) {
        1 -> Quintuple("ඕනෑම ශුන්‍ය නොවන සංඛ්‍යාවක ශුන්‍ය වෙනි බලයේ (a⁰) අගය කීයද?", "What is value of any non-zero number to power 0 (a^0)?", listOf("1", "එක"), "1 (එක) වේ.", "a⁰ = 1 වේ.")
        2 -> Quintuple("දර්ශක ආකාරයෙන් 2³ හි අගය කීයද?", "What is 2 cubed (2^3)?", listOf("8", "අට"), "8 (අට) වේ (2 × 2 × 2 = 8).", "8 වේ.")
        3 -> Quintuple("පාදය 10 වූ ලඝුගණකයේ lg 10 හි අගය කීයද?", "What is log base 10 of 10 (lg 10)?", listOf("1", "එක"), "1 (එක) වේ.", "lg 10 = 1.")
        4 -> Quintuple("පාදය 10 වූ ලඝුගණකයේ lg 100 හි අගය කීයද?", "What is log base 10 of 100 (lg 100)?", listOf("2", "දෙක"), "2 (දෙක) වේ (10² = 100).", "lg 100 = 2.")
        else -> Quintuple("lg (xy) සමාන වන්නේ lg x සහ lg y හි කුමන ගණිත කර්මයටද?", "lg(xy) is equal to sum of lg x and lg y?", listOf("එකතුව", "එකතු කිරීමට", "lg x + lg y"), "එකතුවට වේ (lg x + lg y).", "ලඝුගණක එකතුවයි.")
      }

      // Set 2: වර්ගජ සමීකරණ
      2 -> when (qIndex) {
        1 -> Quintuple("වර්ගජ සමීකරණයක විචල්‍යයේ ඉහළම බලය (දර්ශකය) කීයද?", "Highest power of variable in quadratic equation?", listOf("2", "දෙක"), "2 (දෙක) වේ (ax²).", "වර්ගයයි.")
        2 -> Quintuple("වර්ගජ සමීකරණයකට උපරිම වශයෙන් ලැබිය හැකි මූල (විසඳුම්) ගණන කීයද?", "Maximum number of roots for quadratic equation?", listOf("2", "දෙකක්", "2ක්"), "විසඳුම් 2කි.", "මූල 2කි.")
        3 -> Quintuple("ax² + bx + c = 0 සමීකරණයේ විවේචකය හඳුන්වන ප්‍රකාශනය කුමක්ද?", "Discriminant expression of quadratic equation?", listOf("b² - 4ac", "b^2 - 4ac"), "b² - 4ac (ඩෙල්ටා Δ) වේ.", "විවේචකයයි.")
        else -> Quintuple("විවේචකය b² - 4ac = 0 නම් මූලවල ස්වභාවය කෙබඳුද?", "Nature of roots if discriminant is 0?", listOf("සමාන", "මූල සමපාත", "සමාන තාත්වික"), "තාත්වික හා එකිනෙකට සමාන (සමපාත) වේ.", "සමාන මූල 2කි.")
      }

      // Set 3: වෘත්තයක ජ්‍යාමිතික ප්‍රමේයයන්
      3 -> when (qIndex) {
        1 -> Quintuple("අර්ධ වෘත්තයක කෝණය අංශක කීයද?", "Angle in a semicircle in degrees?", listOf("90", "90°", "සෘජුකෝණයක්"), "අංශක 90කි (සෘජුකෝණයකි).", "90° වේ.")
        2 -> Quintuple("වෘත්තයක කේන්ද්‍ර කෝණය පරිධි කෝණය මෙන් කී ගුණයක්ද?", "Angle subtended at center is how many times angle at circumference?", listOf("දෙගුණයක්", "2 ගුණයක්", "2"), "දෙගුණයක් වේ.", "දෙගුණයකි.")
        3 -> Quintuple("එකම වෘත්ත ඛණ්ඩයේ කෝණ එකිනෙකට සමානද?", "Are angles in the same segment of a circle equal?", listOf("ඔව්", "සමානයි"), "ඔව්, එකිනෙකට සමාන වේ.", "සමානයි.")
        4 -> Quintuple("චක්‍රීය චතුරස්‍රයක සම්මුඛ කෝණවල එකතුව අංශක කීයද?", "Sum of opposite angles of a cyclic quadrilateral?", listOf("180", "180°", "අංශක 180"), "අංශක 180කි (පරිපූරක වේ).", "180° වේ.")
        else -> Quintuple("වෘත්තයක ස්පර්ශකය සහ ස්පර්ශ ලක්ෂ්‍යයේ අරය අතර කෝණය අංශක කීයද?", "Angle between tangent and radius at point of contact?", listOf("90", "90°", "සෘජුකෝණයක්"), "අංශක 90කි (සෘජුකෝණී වේ).", "90° වේ.")
      }

      // Set 4: ත්‍රිකෝණමිතිය
      4 -> when (qIndex) {
        1 -> Quintuple("ත්‍රිකෝණමිතියේ මූලික අනුපාත 3න් එකක් නම් කරන්න.", "Name one of the 3 basic trig ratios.", listOf("sin", "cos", "tan", "සයින්", "කොස්", "ටෑන්"), "sin, cos හෝ tan වේ.", "sin, cos, tan.")
        2 -> Quintuple("සෘජුකෝණී ත්‍රිකෝණයක tan අනුපාතය යනු සම්මුඛ පාදය බෙදීම කුමන පාදයද?", "tan ratio is opposite side divided by what side?", listOf("බද්ධ පාදය", "බද්ධ"), "බද්ධ පාදය වේ (සම්මුඛ / බද්ධ).", "බද්ධ පාදයයි.")
        3 -> Quintuple("තිරස් රේඛාවට ඉහළින් පිහිටි වස්තුවක් දෙස බැලීමේදී සෑදෙන කෝණය කුමක්ද?", "Angle looking upward above horizontal line?", listOf("ආරෝහණ කෝණය", "Elevation"), "ආරෝහණ කෝණය (Angle of elevation) වේ.", "ඉහළ බලන කෝණයයි.")
        else -> Quintuple("තිරස් රේඛාවට පහළින් පිහිටි වස්තුවක් දෙස බැලීමේදී සෑදෙන කෝණය කුමක්ද?", "Angle looking downward below horizontal line?", listOf("අවරෝහණ කෝණය", "Depression"), "අවරෝහණ කෝණය (Angle of depression) වේ.", "පහළ බලන කෝණයයි.")
      }

      // Set 5: සමාන්තර හා ගුණෝත්තර ශ්‍රේඪි
      5 -> when (qIndex) {
        1 -> Quintuple("2, 4, 6, 8... යන සමාන්තර ශ්‍රේඪියේ පොදු අන්තරය (d) කීයද?", "Common difference of 2, 4, 6, 8...?", listOf("2", "දෙක"), "2 (දෙක) වේ.", "4 - 2 = 2.")
        2 -> Quintuple("1, 3, 9, 27... යන ගුණෝත්තර ශ්‍රේඪියේ පොදු අනුපාතය (r) කීයද?", "Common ratio of 1, 3, 9, 27...?", listOf("3", "තුන"), "3 (තුන) වේ.", "3 / 1 = 3.")
        else -> Quintuple("ශ්‍රේඪියක පළමු පදය සාමාන්‍යයෙන් හඳුන්වන ඉංග්‍රීසි අකුර කුමක්ද?", "Standard letter for first term in progression?", listOf("a", "A"), "a අකුර වේ.", "a වේ.")
      }

      // Set 6: ඝන වස්තුවල වර්ගඵලය & පරිමාව
      6 -> when (qIndex) {
        1 -> Quintuple("සිලින්ඩරයක පාදමේ හැඩය කුමක්ද?", "Shape of cylinder base?", listOf("වෘත්තයක්", "වෘත්තාකාර", "Circle"), "වෘත්තයක් (Circle) වේ.", "වෘත්තයකි.")
        2 -> Quintuple("ඝනකයක (Cube) මුහුණත් ගණන කීයද?", "Number of faces on a cube?", listOf("6", "6ක්", "හයක්"), "මුහුණත් 6කි.", "6කි.")
        else -> Quintuple("ගෝලයක මධ්‍යයේ සිට පෘෂ්ඨය මත ලක්ෂ්‍යයකට ඇති දුර කුමක්ද?", "Distance from sphere center to surface point?", listOf("අරය", "Radius", "r"), "අරය (Radius) වේ.", "අරයයි.")
      }

      // Set 7: සමුච්චිත සංඛ්‍යාත වක්‍රය
      7 -> when (qIndex) {
        1 -> Quintuple("සමුච්චිත සංඛ්‍යාත වක්‍රයේ 50% ලක්ෂ්‍යයෙන් නිරූපණය වන්නේ කුමක්ද?", "What is represented at 50% on cumulative frequency curve?", listOf("මධ්‍යස්ථය", "Median"), "මධ්‍යස්ථය (Median) වේ.", "මැද අගයයි.")
        2 -> Quintuple("පහළ චතුර්ථකය (Q1) මඟින් නිරූපණය වන ප්‍රතිශතය කීයද?", "Percentage for lower quartile (Q1)?", listOf("25%", "25", "සියයට 25"), "25% (සියයට විසිපහ) වේ.", "25% වේ.")
        else -> Quintuple("ඉහළ චතුර්ථකය (Q3) මඟින් නිරූපණය වන ප්‍රතිශතය කීයද?", "Percentage for upper quartile (Q3)?", listOf("75%", "75", "සියයට 75"), "75% (සියයට හැත්තෑපහ) වේ.", "75% වේ.")
      }

      // Set 8: සම්භාවිතාව (ගස් සටහන් & දැලිස්)
      8 -> when (qIndex) {
        1 -> Quintuple("එකිනෙකට බහිෂ්කාර සිදුවීම් 2ක් එකවර සිදුවිය හැකිද?", "Can two mutually exclusive events occur simultaneously?", listOf("නොහැක", "නැත", "බැහැ"), "නැත, එකවර සිදුවිය නොහැක.", "බහිෂ්කාරයි.")
        2 -> Quintuple("සම්භාවිතා ගැටලු නිරූපණය කිරීමට අඳින අතු බෙදුණු සටහන කුමක්ද?", "Branching diagram for probability problems?", listOf("ගස් සටහන", "Tree diagram"), "ගස් සටහන (Tree diagram) වේ.", "ගස් සටහනයි.")
        else -> Quintuple("ගස් සටහනක එක් ලක්ෂ්‍යයකින් පිටවන සියලු අතුවල සම්භාවිතාවල එකතුව කීයද?", "Sum of probabilities of all branches from a single node?", listOf("1", "එක"), "1 (එක) වේ.", "1 වේ.")
      }

      // Set 9: න්‍යාස (Matrices)
      9 -> when (qIndex) {
        1 -> Quintuple("න්‍යාසයක තිරස් අතට ඇති පේළි හඳුන්වන්නේ කෙසේද?", "Horizontal lines in matrix?", listOf("පේළි", "Rows"), "පේළි (Rows) නමිනි.", "පේළි වේ.")
        2 -> Quintuple("න්‍යාසයක සිරස් අතට ඇති තීරු හඳුන්වන්නේ කෙසේද?", "Vertical lines in matrix?", listOf("තීරු", "Columns"), "තීරු (Columns) නමිනි.", "තීරු වේ.")
        else -> Quintuple("ප්‍රධාන විකර්ණයේ මූලද්‍රව්‍ය 1 ද අනෙක් සියල්ල 0 ද වන න්‍යාසය කුමක්ද?", "Matrix with 1s on main diagonal and 0s elsewhere?", listOf("ඒකක න්‍යාසය", "Identity matrix", "I"), "ඒකක න්‍යාසය (Identity matrix - I) වේ.", "ඒකක න්‍යාසයයි.")
      }

      // Set 10: අසමානතා
      else -> when (qIndex) {
        1 -> Quintuple("අසමානතාවක් සෘණ සංඛ්‍යාවකින් ගුණ කළ විට අසමානතා ලකුණ කුමක් වේද?", "What happens to inequality sign when multiplied by negative number?", listOf("පෙරළේ", "මාරු වේ", "වෙනස් වේ"), "අසමානතා ලකුණ අනෙක් පැත්තට පෙරළේ (මාරු වේ).", "දිශාව මාරු වේ.")
        2 -> Quintuple("x > 2 නම් x හි අගය 2 විය හැකිද?", "If x > 2, can x be equal to 2?", listOf("නැත", "නොහැක"), "නැත, 2ට වඩා වැඩි විය යුතුය.", "2ට වැඩියි.")
        else -> Quintuple("අසමානතාවල විසඳුම් ප්‍රදේශ ප්‍රස්ථාරයක නිරූපණය කරන්නේ කුමන ක්‍රමයෙන්ද?", "How are inequality solution regions shown on graph?", listOf("අඳුරු කිරීමෙන්", "ඉරි ගැසීමෙන්", "Shading"), "අදාළ පෙදෙස අඳුරු කිරීමෙන් (ඉරි ගැසීමෙන්) වේ.", "කඩඉම් ඉර සහ අඳුරු කිරීමයි.")
      }
    }
  }
}

