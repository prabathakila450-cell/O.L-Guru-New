package com.example

/**
 * 100% Complete Grade 10 & 11 Mathematics Syllabus - High-Yield O/L Speed MCQs
 * Standard 24 questions covering every core branch of O/L Mathematics
 * with verified step-by-step explanations.
 */

data class MathMcqItem(
    val id: String,
    val question: String,
    val grade: String,
    val topic: String,
    val options: List<String>,
    val correctIndex: Int,
    val explanation: String
)

object MathMcqChallengeData {

    val mcqQuestions = listOf(
        MathMcqItem(
            id = "mcq_1",
            question = "ත්‍රිකෝණයක අභ්‍යන්තර කෝණ දෙකක අගයන් 50° සහ 70° වේ නම්, ඉතිරි කෝණයේ අගය කොපමණද?",
            grade = "10 ශ්‍රේණිය",
            topic = "ජ්‍යාමිතිය",
            options = listOf("50°", "60°", "70°", "80°"),
            correctIndex = 1,
            explanation = "ත්‍රිකෝණයක අභ්‍යන්තර කෝණ තුනෙහි ඓක්‍යය 180° කි. 180° - (50° + 70°) = 180° - 120° = 60°."
        ),
        MathMcqItem(
            id = "mcq_2",
            question = "x² - 9 හි සාධක මොනවාද?",
            grade = "10 ශ්‍රේණිය",
            topic = "වීජ ගණිතය",
            options = listOf("(x - 3)²", "(x - 3)(x + 3)", "(x - 9)(x + 1)", "(x + 3)²"),
            correctIndex = 1,
            explanation = "වර්ග දෙකක අන්තරය සූත්‍රය: a² - b² = (a - b)(a + b) අනුව x² - 3² = (x - 3)(x + 3) වේ."
        ),
        MathMcqItem(
            id = "mcq_3",
            question = "වාර්ෂිකව 12% සුළු පොලියට රු. 5,000 ක මුදලක් වසර 2ක් සඳහා ණයට ගත් විට ගෙවිය යුතු මුළු පොලිය කීයද?",
            grade = "10 ශ්‍රේණිය",
            topic = "මූල්‍ය ගණිතය",
            options = listOf("රු. 600", "රු. 1,000", "රු. 1,200", "රු. 1,400"),
            correctIndex = 2,
            explanation = "I = (P × R × T) / 100 = (5000 × 12 × 2) / 100 = 50 × 24 = රු. 1,200."
        ),
        MathMcqItem(
            id = "mcq_4",
            question = "වෘත්තයක කේන්ද්‍රික කෝණය 180° වන කේන්ද්‍රික ඛණ්ඩයක අරය 7 cm නම් එහි චාප දිග කීයද? (π = 22/7)",
            grade = "10 ශ්‍රේණිය",
            topic = "මිනුම",
            options = listOf("11 cm", "22 cm", "44 cm", "14 cm"),
            correctIndex = 1,
            explanation = "චාප දිග s = (180/360) × 2πr = (1/2) × 2 × (22/7) × 7 = 22 cm (අර්ධ වෘත්තයක චාප දිග)."
        ),
        MathMcqItem(
            id = "mcq_5",
            question = "සාධාරණ දාදු කැටයක් එක් වරක් පෙරළූ විට 4ට වඩා වැඩි සංඛ්‍යාවක් ලැබීමේ සම්භාවිතාව කොපමණද?",
            grade = "10 ශ්‍රේණිය",
            topic = "සම්භාවිතාව",
            options = listOf("1/6", "2/6 (1/3)", "3/6 (1/2)", "4/6 (2/3)"),
            correctIndex = 1,
            explanation = "නියැදි අවකාශය {1, 2, 3, 4, 5, 6} (මුළු 6). 4ට වඩා වැඩි සංඛ්‍යා = {5, 6} (2ක්). සම්භාවිතාව = 2/6 = 1/3."
        ),
        MathMcqItem(
            id = "mcq_6",
            question = "සෘජුකෝණී ත්‍රිකෝණයක කර්ණය 13 cm සහ එක් පාදයක් 5 cm නම්, අනෙක් පාදයේ දිග කීයද?",
            grade = "10 ශ්‍රේණිය",
            topic = "ජ්‍යාමිතිය",
            options = listOf("8 cm", "10 cm", "12 cm", "15 cm"),
            correctIndex = 2,
            explanation = "පයිතගරස් ප්‍රමේයය අනුව: a² = 13² - 5² = 169 - 25 = 144. a = √144 = 12 cm."
        ),
        MathMcqItem(
            id = "mcq_7",
            question = "වෘත්ත චතුරස්‍රයක සම්මුඛ කෝණ යුගලයක එකතුව කොපමණද?",
            grade = "11 ශ්‍රේණිය",
            topic = "ජ්‍යාමිතිය",
            options = listOf("90°", "180°", "270°", "360°"),
            correctIndex = 1,
            explanation = "වෘත්ත චතුරස්‍රයක සම්මුඛ කෝණ එකිනෙකට පරිපූරක වේ (එකතුව 180° කි)."
        ),
        MathMcqItem(
            id = "mcq_8",
            question = "2x² - 5x - 3 = 0 වර්ගජ සමීකරණයේ මූල මොනවාද?",
            grade = "11 ශ්‍රේණිය",
            topic = "වීජ ගණිතය",
            options = listOf("x = 3 හෝ x = -1/2", "x = -3 හෝ x = 1/2", "x = 1 හෝ x = -3", "x = 2 හෝ x = 3"),
            correctIndex = 0,
            explanation = "2x² - 6x + x - 3 = 0 => 2x(x - 3) + 1(x - 3) = 0 => (2x + 1)(x - 3) = 0. එබැවින් x = 3 හෝ x = -1/2."
        ),
        MathMcqItem(
            id = "mcq_9",
            question = "y = (x - 3)² + 2 ප්‍රස්ථාරයේ අවම ලක්ෂ්‍යයේ ඛණ්ඩාංක මොනවාද?",
            grade = "11 ශ්‍රේණිය",
            topic = "වීජ ගණිතය",
            options = listOf("(-3, 2)", "(3, -2)", "(3, 2)", "(2, 3)"),
            correctIndex = 2,
            explanation = "y = a(x - h)² + k ප්‍රස්ථාරයේ හැරවුම් ලක්ෂ්‍යය (h, k) වේ. මෙහි h = 3, k = 2 බැවින් අවම ලක්ෂ්‍යය (3, 2) වේ."
        ),
        MathMcqItem(
            id = "mcq_10",
            question = "මාස 6කින් ගෙවා නිම කිරීමට ගත් ණයක මුළු මාස ඒකක ගණන කීයද?",
            grade = "11 ශ්‍රේණිය",
            topic = "මූල්‍ය ගණිතය",
            options = listOf("15", "21", "24", "36"),
            correctIndex = 1,
            explanation = "මාස ඒකක ගණන = [n(n + 1)] / 2 = [6 × 7] / 2 = 42 / 2 = 21."
        ),
        MathMcqItem(
            id = "mcq_11",
            question = "4, 7, 10, 13, ... සමාන්තර ශ්‍රේඪියේ 15 වන පදය කීයද?",
            grade = "11 ශ්‍රේණිය",
            topic = "ශ්‍රේඪි",
            options = listOf("42", "45", "46", "49"),
            correctIndex = 2,
            explanation = "a = 4, d = 3. T15 = a + (15 - 1)d = 4 + 14 × 3 = 4 + 42 = 46."
        ),
        MathMcqItem(
            id = "mcq_12",
            question = "lg 1000 හි අගය කොපමණද?",
            grade = "10 ශ්‍රේණිය",
            topic = "ලඝුගණක",
            options = listOf("1", "2", "3", "10"),
            correctIndex = 2,
            explanation = "1000 = 10^3 බැවින් lg 1000 = 3 වේ."
        ),
        MathMcqItem(
            id = "mcq_13",
            question = "කේන්ද්‍රික කෝණය 90° වන අර්ධ වෘත්තයක නොව, අර්ධ වෘත්තයක කෝණය (Angle in a semicircle) කොපමණද?",
            grade = "11 ශ්‍රේණිය",
            topic = "ජ්‍යාමිතිය",
            options = listOf("45°", "60°", "90°", "180°"),
            correctIndex = 2,
            explanation = "ප්‍රමේයය: අර්ධ වෘත්තයක කෝණය සෘජුකෝණයකි (90°)."
        ),
        MathMcqItem(
            id = "mcq_14",
            question = "n(A) = 15, n(B) = 20 සහ n(A ∩ B) = 5 නම් n(A ∪ B) හි අගය කීයද?",
            grade = "10 ශ්‍රේණිය",
            topic = "කුලක",
            options = listOf("25", "30", "35", "40"),
            correctIndex = 1,
            explanation = "n(A ∪ B) = n(A) + n(B) - n(A ∩ B) = 15 + 20 - 5 = 30."
        ),
        MathMcqItem(
            id = "mcq_15",
            question = "අරය 7 cm සහ උස 10 cm වන සෘජු සිලින්ඩරයක පරිමාව කොපමණද? (π = 22/7)",
            grade = "11 ශ්‍රේණිය",
            topic = "මිනුම",
            options = listOf("770 cm³", "1540 cm³", "3080 cm³", "440 cm³"),
            correctIndex = 1,
            explanation = "V = πr²h = (22/7) × 7² × 10 = 22 × 7 × 10 = 1540 cm³."
        ),
        MathMcqItem(
            id = "mcq_16",
            question = "sin 30° හි අගය කොපමණද?",
            grade = "10 ශ්‍රේණිය",
            topic = "ත්‍රිකෝණමිතිය",
            options = listOf("0", "1/2 (0.5)", "√3/2", "1"),
            correctIndex = 1,
            explanation = "සම්මත ත්‍රිකෝණමිතික අනුපාතය: sin 30° = 1/2 = 0.5 වේ."
        ),
        MathMcqItem(
            id = "mcq_17",
            question = "3, 6, 12, 24, ... ගුණෝත්තර ශ්‍රේඪියේ පොදු අනුපාතය (r) කීයද?",
            grade = "11 ශ්‍රේණිය",
            topic = "ශ්‍රේඪි",
            options = listOf("2", "3", "4", "6"),
            correctIndex = 0,
            explanation = "පොදු අනුපාතය r = T2 / T1 = 6 / 3 = 2."
        ),
        MathMcqItem(
            id = "mcq_18",
            question = "වෘත්තයක බාහිර ලක්ෂ්‍යයක සිට අඳින ලද ස්පර්ශක දෙක පිළිබඳ සත්‍ය ප්‍රකාශය කුමක්ද?",
            grade = "11 ශ්‍රේණිය",
            topic = "ජ්‍යාමිතිය",
            options = listOf("ඒවා එකිනෙකට ලම්බ වේ", "ඒවා දිගින් සමාන වේ", "ඒවා කේන්ද්‍රය හරහා යයි", "ඒවා සමාන්තර වේ"),
            correctIndex = 1,
            explanation = "ප්‍රමේයය: වෘත්තයකින් පිටත ලක්ෂ්‍යයක සිට අඳින ලද ස්පර්ශක ඛණ්ඩ දෙක දිගින් සමාන වේ."
        ),
        MathMcqItem(
            id = "mcq_19",
            question = "5, 8, 12, 12, 15, 18, 22 යන දත්ත සමූහයේ මධ්‍යස්ථය (Median) කීයද?",
            grade = "10 ශ්‍රේණිය",
            topic = "සංඛ්‍යානය",
            options = listOf("8", "12", "15", "18"),
            correctIndex = 1,
            explanation = "දත්ත 7ක් ආරෝහණ පිළිවෙළට ඇත. මධ්‍යස්ථය = (7+1)/2 = 4 වන පදය = 12 වේ."
        ),
        MathMcqItem(
            id = "mcq_20",
            question = "2x + y = 7 සහ x - y = 2 සමගාමී සමීකරණ විසඳූ විට x හි අගය කීයද?",
            grade = "10 ශ්‍රේණිය",
            topic = "වීජ ගණිතය",
            options = listOf("1", "2", "3", "4"),
            correctIndex = 2,
            explanation = "සමීකරණ දෙක එකතු කළ විට: (2x + y) + (x - y) = 7 + 2 => 3x = 9 => x = 3."
        ),
        MathMcqItem(
            id = "mcq_21",
            question = "වෘත්තයක කේන්ද්‍රයේ සිට ජ්‍යායකට අඳින ලද ලම්බකය මගින් ජ්‍යාය කුමක් කරයිද?",
            grade = "10 ශ්‍රේණිය",
            topic = "ජ්‍යාමිතිය",
            options = listOf("ත්‍රිච්ඡේදනය කරයි", "සමච්ඡේදනය කරයි", "ද්විගුණ කරයි", "වර්ග කරයි"),
            correctIndex = 1,
            explanation = "ප්‍රමේයය: කේන්ද්‍රයේ සිට ජ්‍යායකට අඳින ලද ලම්බකය මගින් එම ජ්‍යාය සමච්ඡේදනය වේ."
        ),
        MathMcqItem(
            id = "mcq_22",
            question = "වාර්ෂික තක්සේරු වටිනාකම රු. 40,000ක් වන නිවසක් සඳහා 6%ක වාරි බද්දක් අය කරන්නේ නම් වසරකට ගෙවිය යුතු බද්ද කීයද?",
            grade = "10 ශ්‍රේණිය",
            topic = "මූල්‍ය ගණිතය",
            options = listOf("රු. 1,200", "රු. 2,400", "රු. 3,600", "රු. 4,800"),
            correctIndex = 1,
            explanation = "වාර්ෂික බද්ද = 40,000 × (6 / 100) = 400 × 6 = රු. 2,400."
        ),
        MathMcqItem(
            id = "mcq_23",
            question = "කෝණමානයක් නොමැතිව කවකටුවෙන් 90° කෝණයක් සමච්ඡේදනය කළ විට ලැබෙන කෝණය කීයද?",
            grade = "10 ශ්‍රේණිය",
            topic = "ජ්‍යාමිතික නිර්මාණ",
            options = listOf("30°", "45°", "60°", "75°"),
            correctIndex = 1,
            explanation = "90° කෝණයක කෝණ සමච්ඡේදකයෙන් 90° / 2 = 45° ක කෝණ දෙකක් ලැබේ."
        ),
        MathMcqItem(
            id = "mcq_24",
            question = "අරය 3 cm සහ සිරස් උස 4 cm වන සෘජු වෘත්තාකාර කේතුවක ඇල උස (l) කීයද?",
            grade = "11 ශ්‍රේණිය",
            topic = "මිනුම",
            options = listOf("5 cm", "7 cm", "12 cm", "25 cm"),
            correctIndex = 0,
            explanation = "පයිතගරස් සබඳතාව l² = r² + h² අනුව l = √(3² + 4²) = √(9 + 16) = √25 = 5 cm."
        )
    )
}
