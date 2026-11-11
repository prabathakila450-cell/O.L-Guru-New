package com.example

object MathPastPaper60QuestionsProvider {

    data class QuestionData(
        val topic: String,
        val text: String,
        val options: List<String>,
        val correctIdx: Int,
        val explanation: String
    )

    fun buildMathQuestion(year: Int, qNum: Int, yearStr: String, subjectTitle: String): PastPaperQuestion {
        val q = qNum.coerceIn(1, 60)
        val yOffset = Math.abs(year - 2019) // 0 for 2019 up to 5 for 2024
        val data = getQuestionData(q, year, yearStr)

        val prefix = listOf(
            "ගණනය කර පිළිතුර සොයන්න: ",
            "පහත ගණිත ගැටලුව විසඳන්න: ",
            "දී ඇති දත්ත අනුව පිළිතුර තෝරන්න: ",
            "ගැටලුව විමසා බලා පිළිතුරු දෙන්න: ",
            "පියවරෙන් පියවර ගණනය කිරීමෙන් පසු: ",
            "ගණිත ප්‍රශ්නයක් ලෙස සලකන්න: "
        )[yOffset % 6]

        val rawText = data.text.substringAfter("] ")
        val finalTitle = "[$yearStr O/L - Q$q] " + prefix + rawText

        return PastPaperQuestion(
            id = qNum,
            questionText = finalTitle,
            options = data.options,
            correctOptionIndex = data.correctIdx,
            explanationSinhala = data.explanation,
            topicCategory = data.topic,
            year = yearStr,
            subject = subjectTitle
        )
    }

    private fun getQuestionData(q: Int, year: Int, yearStr: String): QuestionData {
        val yOffset = Math.abs(year - 2015)
        
        return when (q) {
            // 1-10: Algebra Basics
            1 -> {
                val a = (yOffset % 4) + 2
                val ans = (yOffset % 5) + 3
                val b = (yOffset % 3) + 2
                val c = a * ans + b
                QuestionData(
                    "වීජ ගණිතය - සරල සමීකරණ",
                    "[$yearStr O/L - Q1] $a x + $b = $c සමීකරණයේ x හි අගය සොයන්න.",
                    listOf("x = $ans", "x = ${ans + 2}", "x = ${ans - 1}", "x = ${ans + 4}"),
                    0,
                    "$a x = $c - $b => $a x = ${c - b} => x = $ans."
                )
            }
            2 -> {
                val a = (yOffset % 5) + 1
                val b = ((yOffset + 2) % 4) + 2
                val sum = a + b
                val prod = a * b
                QuestionData(
                    "වීජ ගණිතය - ප්‍රකාශන ප්‍රසාරණය",
                    "[$yearStr O/L - Q2] (x + $a)(x + $b) ප්‍රකාශනය ප්‍රසාරණය කළ විට ලැබෙන්නේ කුමක්ද?",
                    listOf("x² + ${sum}x + $prod", "x² + ${prod}x + $sum", "x² + x + $prod", "x² + $sum"),
                    0,
                    "x(x + $b) + $a(x + $b) = x² + ${b}x + ${a}x + $prod = x² + ${sum}x + $prod."
                )
            }
            3 -> {
                val k = (yOffset % 6) + 3
                val sq = k * k
                QuestionData(
                    "වීජ ගණිතය - වර්ග දෙකක අන්තරය",
                    "[$yearStr O/L - Q3] x² - $sq හි සාධක වෙන් කළ විට ලැබෙන ප්‍රකාශනය කුමක්ද?",
                    listOf("(x - $k)(x + $k)", "(x - $k)²", "(x + $k)²", "x(x - $sq)"),
                    0,
                    "වර්ග දෙකක අන්තරය: a² - b² = (a - b)(a + b) අනුව x² - $k² = (x - $k)(x + $k)."
                )
            }
            4 -> {
                val a = (yOffset % 3) + 2
                val ans = (yOffset % 6) + 4
                val b = (yOffset % 4) + 1
                val rhs = a * (ans - b)
                QuestionData(
                    "වීජ ගණිතය - වරහන් සහිත සමීකරණ",
                    "[$yearStr O/L - Q4] $a(x - $b) = $rhs සමීකරණයේ x හි අගය කුමක්ද?",
                    listOf("x = $ans", "x = ${ans - 2}", "x = ${ans + 3}", "x = ${ans + 1}"),
                    0,
                    "x - $b = $rhs / $a => x - $b = ${rhs / a} => x = $ans."
                )
            }
            5 -> {
                val denom = (yOffset % 3) + 2
                val ans = (yOffset % 4 + 2) * denom
                val b = (yOffset % 3) + 3
                val rhs = (ans / denom) + b
                QuestionData(
                    "වීජ ගණිතය - භාගික සමීකරණ",
                    "[$yearStr O/L - Q5] x/$denom + $b = $rhs සමීකරණයේ x හි අගය සොයන්න.",
                    listOf("x = $ans", "x = ${ans / 2}", "x = ${ans + denom}", "x = ${ans - 1}"),
                    0,
                    "x/$denom = $rhs - $b => x/$denom = ${rhs - b} => x = $ans."
                )
            }
            6 -> {
                val xAns = (yOffset % 5) + 3
                val yAns = (yOffset % 3) + 1
                val sum = xAns + yAns
                val diff = xAns - yAns
                QuestionData(
                    "වීජ ගණිතය - සමගාමී සමීකරණ",
                    "[$yearStr O/L - Q6] x + y = $sum සහ x - y = $diff යන සමගාමී සමීකරණ විසඳූ විට x හි අගය කුමක්ද?",
                    listOf("x = $xAns", "x = $yAns", "x = ${xAns + 2}", "x = ${sum + diff}"),
                    0,
                    "සමීකරණ දෙක එකතු කළ විට: 2x = ${sum + diff} => x = $xAns."
                )
            }
            7 -> {
                val m = (yOffset % 4) + 1
                val n = (yOffset % 3) + 2
                val sum = m + n
                val prod = m * n
                QuestionData(
                    "වීජ ගණිතය - වර්ගජ ප්‍රකාශන සාධක",
                    "[$yearStr O/L - Q7] x² + ${sum}x + $prod ප්‍රකාශනයේ සාධක මොනවාද?",
                    listOf("(x + $m)(x + $n)", "(x - $m)(x - $n)", "(x + 1)(x + $prod)", "(x + $sum)(x + 1)"),
                    0,
                    "එකතුව $sum සහ ගුණිතය $prod වන සංඛ්‍යා $m සහ $n වේ. එබැවින් සාධක (x + $m)(x + $n) වේ."
                )
            }
            8 -> {
                val c1 = (yOffset % 3) + 2
                val c2 = (yOffset % 2) + 3
                val prod = c1 * c2
                QuestionData(
                    "වීජ ගණිතය - දර්ශක ගුණිතය",
                    "[$yearStr O/L - Q8] ${c1}a²b * ${c2}ab² හි අගය කුමක්ද?",
                    listOf("${prod}a³b³", "${c1 + c2}a³b³", "${prod}a²b²", "${prod}ab"),
                    0,
                    "$c1 * $c2 = $prod, a² * a = a³, b * b² = b³ => ${prod}a³b³."
                )
            }
            9 -> {
                val base = (yOffset % 3) + 2
                val exp = (yOffset % 4) + 2
                var valPower = 1
                for (i in 1..exp) valPower *= base
                QuestionData(
                    "වීජ ගණිතය - ලඝුගණක",
                    "[$yearStr O/L - Q9] log_$base $valPower හි අගය කුමක්ද?",
                    listOf("$exp", "${exp - 1}", "${exp + 1}", "$valPower"),
                    0,
                    "$base^$exp = $valPower බැවින් log_$base $valPower = $exp වේ."
                )
            }
            10 -> {
                val a = (yOffset % 3) + 2
                val rhs = a * ((yOffset % 5) + 3)
                val ans = rhs / a
                QuestionData(
                    "වීජ ගණිතය - අසමානතා",
                    "[$yearStr O/L - Q10] ${a}x > $rhs අසමානතාවයේ විසඳුම කුමක්ද?",
                    listOf("x > $ans", "x < $ans", "x = $ans", "x > ${ans - 1}"),
                    0,
                    "දෙපසම $a න් බෙදූ විට x > $ans ලැබේ."
                )
            }

            // 11-20: Arithmetic & Percentages
            11 -> {
                val d1 = (yOffset % 3) + 2
                val d2 = d1 * 2
                val num = 3
                QuestionData(
                    "අංක ගණිතය - භාග එකතු කිරීම",
                    "[$yearStr O/L - Q11] 1/$d1 + 1/$d2 හි අගය කුමක්ද?",
                    listOf("$num/$d2", "2/${d1 + d2}", "1/${d1 * d2}", "1/$d2"),
                    0,
                    "2/$d2 + 1/$d2 = $num/$d2."
                )
            }
            12 -> {
                val baseCost = ((yOffset % 5) + 4) * 1000
                val pct = ((yOffset % 3) + 1) * 10
                val profit = baseCost * pct / 100
                val sp = baseCost + profit
                QuestionData(
                    "අංක ගණිතය - ලාභ ප්‍රතිශත",
                    "[$yearStr O/L - Q12] රු. $baseCost කට ගත් භාණ්ඩයක් $pct% ලාභයකට විකුණන විට විකුණුම් මිල කීයද?",
                    listOf("රු. $sp", "රු. ${baseCost + profit / 2}", "රු. ${baseCost - profit}", "රු. ${baseCost + 2000}"),
                    0,
                    "$baseCost + ($baseCost * $pct/100) = $baseCost + $profit = $sp."
                )
            }
            13 -> {
                val r1 = (yOffset % 3) + 1
                val r2 = (yOffset % 2) + 2
                val totalParts = r1 + r2
                val unit = ((yOffset % 4) + 2) * 100
                val totalMoney = unit * totalParts
                val p1 = unit * r1
                val p2 = unit * r2
                QuestionData(
                    "අංක ගණිතය - අනුපාත බෙදීම",
                    "[$yearStr O/L - Q13] $r1 : $r2 අනුපාතයට රු. $totalMoney ක් බෙදූ විට ලැබෙන කොටස් මොනවාද?",
                    listOf("රු. $p1 සහ රු. $p2", "රු. $unit සහ රු. ${totalMoney - unit}", "රු. ${p1 / 2} සහ රු. ${p2 / 2}", "රු. 500 සහ රු. 500"),
                    0,
                    "මුළු කොටස් $totalParts කි. $totalMoney / $totalParts = $unit. එනම් $r1 * $unit = $p1 සහ $r2 * $unit = $p2."
                )
            }
            14 -> {
                val m1 = (yOffset % 3) + 3
                val d1 = (yOffset % 4) + 4
                val totalManDays = m1 * d1
                val m2 = m1 * 2
                val d2 = totalManDays / m2
                QuestionData(
                    "අංක ගණිතය - මිනිස් දින",
                    "[$yearStr O/L - Q14] මිනිසුන් $m1 දෙනෙකුට දින $d1 කදී කළ හැකි වැඩක් මිනිසුන් $m2 දෙනෙකුට කිරීමට දින කීයක් ගතවේද?",
                    listOf("දින $d2", "දින ${d1 * 2}", "දින ${d2 + 2}", "දින 1"),
                    0,
                    "මුළු මිනිස් දින ගණන $m1 * $d1 = $totalManDays. $totalManDays / $m2 = $d2."
                )
            }
            15 -> {
                val p = ((yOffset % 4) + 3) * 1000
                val r = (yOffset % 4) + 8
                val interest = p * r / 100
                QuestionData(
                    "අංක ගණිතය - සුළු පොලිය",
                    "[$yearStr O/L - Q15] වාර්ෂික $r% සුළු පොලියට රු. $p ක් තැන්පත් කළ විට වසරක අවසානයේ ලැබෙන පොලිය කීයද?",
                    listOf("රු. $interest", "රු. ${interest / 2}", "රු. ${interest * 2}", "රු. ${p / 10}"),
                    0,
                    "$p * $r/100 = $interest."
                )
            }
            16 -> {
                val v = ((yOffset % 4) + 2) * 500
                val vatPct = 15
                val vatAmt = v * vatPct / 100
                val total = v + vatAmt
                QuestionData(
                    "අංක ගණිතය - වැට් බද්ද",
                    "[$yearStr O/L - Q16] භාණ්ඩයක වටිනාකම රු. $v කි. එයට $vatPct% ක වැට් (VAT) බද්දක් එකතු කළ විට ගෙවිය යුතු මුළු මුදල කීයද?",
                    listOf("රු. $total", "රු. ${v + vatAmt / 2}", "රු. ${v + 100}", "රු. ${v - vatAmt}"),
                    0,
                    "$v + ($v * $vatPct/100) = $v + $vatAmt = $total."
                )
            }
            17 -> {
                val k = (yOffset % 6) + 10
                val sq = k * k
                QuestionData(
                    "අංක ගණිතය - වර්ගමූල",
                    "[$yearStr O/L - Q17] වර්ගමූල $sq හි අගය කුමක්ද?",
                    listOf("$k", "${k + 2}", "${k - 1}", "${k * 2}"),
                    0,
                    "$k * $k = $sq බැවින් අගය $k වේ."
                )
            }
            18 -> {
                val decs = listOf("0.25", "0.20", "0.50", "0.75", "0.40")
                val fracs = listOf("1/4", "1/5", "1/2", "3/4", "2/5")
                val idx = yOffset % decs.size
                QuestionData(
                    "අංක ගණිතය - දශම හා භාග",
                    "[$yearStr O/L - Q18] ${decs[idx]} භාගයක් ලෙස දැක්වූ විට නිවැරදි වන්නේ කුමක්ද?",
                    listOf("${fracs[idx]}", "1/10", "3/5", "2/3"),
                    0,
                    "${decs[idx]} හි භාගික අගය ${fracs[idx]} වේ."
                )
            }
            19 -> {
                val count = (yOffset % 3) + 4 // 4, 5, 6
                val sum = (1..count).sum()
                val mean = sum / count
                QuestionData(
                    "අංක ගණිතය - සංඛ්‍යාත සාමාන්‍යය",
                    "[$yearStr O/L - Q19] පළමු ඉලක්කම් $count හි සාමාන්‍යය කුමක්ද?",
                    listOf("$mean", "${mean + 2}", "${mean - 1}", "$count"),
                    0,
                    "(1 සිට $count දක්වා එකතුව $sum) / $count = $mean."
                )
            }
            20 -> {
                val base = 2
                val exp = (yOffset % 3) + 4 // 2^4 = 16, 2^5 = 32, 2^6 = 64
                var valP = 1
                for (i in 1..exp) valP *= base
                QuestionData(
                    "අංක ගණිතය - බල ගණනය",
                    "[$yearStr O/L - Q20] $base^$exp හි අගය සොයන්න.",
                    listOf("$valP", "${valP / 2}", "${base * exp}", "${valP + 4}"),
                    0,
                    "$base බුද්ධියෙන් $exp වතාවක් ගුණ කළ විට $valP ලැබේ."
                )
            }

            // 21-30: Geometry
            21 -> {
                QuestionData(
                    "ජ්‍යාමිතිය - ත්‍රිකෝණ කෝණ",
                    "[$yearStr O/L - Q21] ත්‍රිකෝණයක අභ්‍යන්තර කෝණවල එකතුව අංශක කීයක්ද?",
                    listOf("180", "360", "90", "270"),
                    0,
                    "ඕනෑම ත්‍රිකෝණයක අභ්‍යන්තර කෝණවල එකතුව 180° කි."
                )
            }
            22 -> {
                val a = (yOffset % 3) + 3 // 3, 4, 5
                val b = a + 1
                val cSq = a*a + b*b
                QuestionData(
                    "ජ්‍යාමිතිය - පයිතගරස් ප්‍රමේයය",
                    "[$yearStr O/L - Q22] සෘජුකෝණී ත්‍රිකෝණයක සෘජුකෝණය අඩංගු පාද $a cm සහ $b cm නම් කර්ණයේ වර්ගය (c²) කීයද?",
                    listOf("$cSq cm²", "${cSq - 5} cm²", "${cSq + 10} cm²", "${(a+b)*(a+b)} cm²"),
                    0,
                    "c² = a² + b² = $a² + $b² = ${a*a} + ${b*b} = $cSq cm²."
                )
            }
            23 -> {
                val d = ((yOffset % 5) + 4) * 2
                val r = d / 2
                QuestionData(
                    "ජ්‍යාමිතිය - වෘත්තයේ අරය",
                    "[$yearStr O/L - Q23] වෘත්තයක විෂ්කම්භය $d cm නම් එහි අරය කොපමණද?",
                    listOf("$r cm", "${d * 2} cm", "$d cm", "${r + 2} cm"),
                    0,
                    "අරය = විෂ්කම්භය / 2 = $d / 2 = $r cm."
                )
            }
            24 -> {
                QuestionData(
                    "ජ්‍යාමිතිය - චතුරස්‍ර කෝණ",
                    "[$yearStr O/L - Q24] සමාන්තරාස්‍රයක / චතුරස්‍රයක අභ්‍යන්තර කෝණවල එකතුව අංශක කීයක්ද?",
                    listOf("360", "180", "540", "90"),
                    0,
                    "ඕනෑම චතුරස්‍රයක අභ්‍යන්තර කෝණවල එකතුව 360° කි."
                )
            }
            25 -> {
                QuestionData(
                    "ජ්‍යාමිතිය - සමාන්තර රේඛා",
                    "[$yearStr O/L - Q25] සමාන්තර රේඛා දෙකක් තීර්යක් රේඛාවකින් කැපූ විට ඇතිවන ඒකාන්තර කෝණ කෙබඳුද?",
                    listOf("සමාන වේ", "පරිපූරක වේ", "අසමාන වේ", "එකතුව 90 කි"),
                    0,
                    "ඒකාන්තර කෝණ (Z හැඩය) සෑමවිටම අගයෙන් සමාන වේ."
                )
            }
            26 -> {
                val r = (yOffset % 4 + 1) * 7
                val circ = 2 * 22 * r / 7
                QuestionData(
                    "ජ්‍යාමිතිය - වෘත්තයේ පරිධිය",
                    "[$yearStr O/L - Q26] අරය $r cm වූ වෘත්තයක පරිධිය සොයන්න (π = 22/7).",
                    listOf("$circ cm", "${circ / 2} cm", "${circ * 2} cm", "${circ + 10} cm"),
                    0,
                    "පරිධිය = 2πr = 2 * (22/7) * $r = $circ cm."
                )
            }
            27 -> {
                QuestionData(
                    "ජ්‍යාමිතිය - සමපාද ත්‍රිකෝණ",
                    "[$yearStr O/L - Q27] සමපාද ත්‍රිකෝණයක එක් අභ්‍යන්තර කෝණයක අගය කොපමණද?",
                    listOf("60°", "90°", "45°", "120°"),
                    0,
                    "අභ්‍යන්තර කෝණ එකතුව 180° සමාන කෝණ 3 ට බෙදූ විට 180 / 3 = 60° වේ."
                )
            }
            28 -> {
                val theta = 60
                val r = 21
                val arc = (theta * 2 * 22 * r) / (360 * 7)
                QuestionData(
                    "ජ්‍යාමිතිය - කේන්ද්‍රික ඛණ්ඩ චාප දිග",
                    "[$yearStr O/L - Q28] කේන්ද්‍රික කෝණය $theta° සහ අරය $r cm වූ කේන්ද්‍රික ඛණ්ඩයක චාප දිග සොයන්න (π = 22/7).",
                    listOf("$arc cm", "${arc * 2} cm", "${arc + 5} cm", "44 cm"),
                    0,
                    "චාප දිග = (θ/360) * 2πr = ($theta/360) * 2 * (22/7) * $r = $arc cm."
                )
            }
            29 -> {
                val l = (yOffset % 5) + 6
                val w = (yOffset % 4) + 3
                val area = l * w
                QuestionData(
                    "ජ්‍යාමිතිය - සෘජුකෝණාස්‍ර වර්ගඵලය",
                    "[$yearStr O/L - Q29] සෘජුකෝණාස්‍රයක දිග $l cm සහ පළල $w cm නම් එහි වර්ගඵලය කොපමණද?",
                    listOf("$area cm²", "${(l + w) * 2} cm²", "${l + w} cm²", "${area + 10} cm²"),
                    0,
                    "වර්ගඵලය = දිග * පළල = $l * $w = $area cm²."
                )
            }
            30 -> {
                QuestionData(
                    "ජ්‍යාමිතිය - බහු අස්‍ර බාහිර කෝණ",
                    "[$yearStr O/L - Q30] ඕනෑම උත්තල බහු අස්‍රයක බාහිර කෝණවල එකතුව සෑමවිටම කොපමණද?",
                    listOf("360°", "180°", "540°", "නියත නැත"),
                    0,
                    "ඕනෑම බහු අස්‍රයක බාහිර කෝණවල එකතුව නියතව 360° කි."
                )
            }

            // 31-40: Statistics & Probability
            31 -> {
                val modeVal = (yOffset % 5) + 3
                val listStr = "$modeVal, ${modeVal - 1}, $modeVal, ${modeVal + 2}, $modeVal, ${modeVal + 4}"
                QuestionData(
                    "සංඛ්‍යානය - මාදිලිය",
                    "[$yearStr O/L - Q31] $listStr යන දත්ත සමූහයේ මාදිලිය (Mode) කුමක්ද?",
                    listOf("$modeVal", "${modeVal - 1}", "${modeVal + 2}", "${modeVal + 4}"),
                    0,
                    "වැඩිම වාර ගණනක් (වතාවල් 3 ක්) යෙදී ඇති අගය ($modeVal) මාදිලියයි."
                )
            }
            32 -> {
                val base = (yOffset % 4) + 2
                val list = listOf(base, base + 2, base + 5, base + 8, base + 11)
                val med = list[2]
                QuestionData(
                    "සංඛ්‍යානය - මධ්‍යස්ථය",
                    "[$yearStr O/L - Q32] ${list.joinToString(", ")} යන පිළිවෙළට සැකසූ දත්තවල මධ්‍යස්ථය (Median) කුමක්ද?",
                    listOf("$med", "${list[1]}", "${list[3]}", "${list[0]}"),
                    0,
                    "පිළිවෙළට සකසා ඇති අගයන් 5 න් මධ්‍යම (3 වන) අගය $med වේ."
                )
            }
            33 -> {
                QuestionData(
                    "සම්භාවිතාව - සාධාරණ කාසිය",
                    "[$yearStr O/L - Q33] සාධාරණ කාසියක් උඩ දැමූ විට 'සිරස' ලැබීමේ සම්භාවිතාව කොපමණද?",
                    listOf("1/2", "1/4", "1", "0"),
                    0,
                    "හැකි සමසම්භාවිත ප්‍රතිඵල 2 න් (සිරස, අගය) සිරස ලැබීම 1 කි. එබැවින් 1/2."
                )
            }
            34 -> {
                val k = (yOffset % 3) + 4 // 4, 5, 6
                val favorable = k - 1
                QuestionData(
                    "සම්භාවිතාව - ඩයි කැටය",
                    "[$yearStr O/L - Q34] සාධාරණ ඩයි කැටයක් ගැසූ විට $k ට වඩා අඩු අගයක් ලැබීමේ සම්භාවිතාව කුමක්ද?",
                    listOf("$favorable/6", "1/6", "1/2", "1"),
                    0,
                    "$k ට අඩු අගයන් $favorable කි (1 සිට ${k-1} දක්වා). එබැවින් සම්භාවිතාව $favorable/6 වේ."
                )
            }
            35 -> {
                val minV = (yOffset % 4) + 2
                val maxV = minV + (yOffset % 5) + 10
                QuestionData(
                    "සංඛ්‍යානය - පරාසය",
                    "[$yearStr O/L - Q35] අවම අගය $minV සහ උපරිම අගය $maxV වූ දත්ත සමූහයක පරාසය (Range) කොපමණද?",
                    listOf("${maxV - minV}", "$maxV", "$minV", "${maxV + minV}"),
                    0,
                    "පරාසය = උපරිම අගය - අවම අගය = $maxV - $minV = ${maxV - minV}."
                )
            }
            36 -> {
                val sumFx = ((yOffset % 4) + 2) * 50
                val sumF = 10
                val mean = sumFx / sumF
                QuestionData(
                    "සංඛ්‍යානය - මධ්‍යන්‍යය",
                    "[$yearStr O/L - Q36] වගුවක Σf = $sumF ක් සහ Σfx = $sumFx ක් නම් මධ්‍යන්‍යය (Mean) කීයද?",
                    listOf("$mean", "${mean * 2}", "${mean / 2}", "$sumFx"),
                    0,
                    "මධ්‍යන්‍යය = Σfx / Σf = $sumFx / $sumF = $mean වේ."
                )
            }
            37 -> {
                QuestionData(
                    "සංඛ්‍යානය - සමුච්චිත සංඛ්‍යාත වක්‍රය",
                    "[$yearStr O/L - Q37] සමුච්චිත සංඛ්‍යාත වක්‍රය (Ogive) ඇඳීමට භාවිත වන්නේ කුමක්ද?",
                    listOf("සමුච්චිත සංඛ්‍යාතය", "සංඛ්‍යාතය පමණි", "පන්ති ප්‍රාන්තර මධ්‍ය අගය", "පරාසය"),
                    0,
                    "සමුච්චිත සංඛ්‍යාත වක්‍රය සඳහා Y අක්ෂයට සමුච්චිත සංඛ්‍යාතය ගනු ලැබේ."
                )
            }
            38 -> {
                val pPercent = ((yOffset % 4) + 6) * 10 // 60, 70, 80, 90
                val pDec = pPercent / 100.0
                val pNot = String.format("%.1f", 1.0 - pDec)
                QuestionData(
                    "සම්භාවිතාව - අනුපූරක සිද්ධි",
                    "[$yearStr O/L - Q38] සිද්ධියක් සිදුවීමේ සම්භාවිතාව $pDec නම් එය සිදු නොවීමේ සම්භාවිතාව කොපමණද?",
                    listOf("$pNot", "$pDec", "1.0", "0.0"),
                    0,
                    "සිදු නොවීමේ සම්භාවිතාව = 1 - P(E) = 1 - $pDec = $pNot."
                )
            }
            39 -> {
                val start = (yOffset % 4) * 10 + 10
                val end = start + 10
                val mid = (start + end) / 2
                QuestionData(
                    "සංඛ්‍යානය - පන්ති මධ්‍ය අගය",
                    "[$yearStr O/L - Q39] $start - $end පන්ති ප්‍රාන්තරයේ මධ්‍ය අගය කුමක්ද?",
                    listOf("$mid", "$start", "$end", "${start + end}"),
                    0,
                    "මධ්‍ය අගය = ($start + $end) / 2 = $mid වේ."
                )
            }
            40 -> {
                QuestionData(
                    "සංඛ්‍යානය - පයි ප්‍රස්ථාර",
                    "[$yearStr O/L - Q40] පයි ප්‍රස්ථාරයක (Pie Chart) මුළු අගය නිරූපණය වන පරිමිත කේන්ද්‍රික කෝණය කොපමණද?",
                    listOf("360°", "180°", "90°", "100°"),
                    0,
                    "වෘත්තයක කේන්ද්‍රය වටා ඇති මුළු කෝණය 360° කි."
                )
            }

            // 41-50: Mensuration
            41 -> {
                QuestionData(
                    "මැනුම - වෘත්ත වර්ගඵලය",
                    "[$yearStr O/L - Q41] අරය r වූ වෘත්තයක වර්ගඵලය සෙවීමේ සූත්‍රය කුමක්ද?",
                    listOf("πr²", "2πr", "4πr²", "1/2 πr²"),
                    0,
                    "වෘත්තයක වර්ගඵලය = πr² වේ."
                )
            }
            42 -> {
                val s = (yOffset % 4) + 3 // 3, 4, 5, 6
                val vol = s * s * s
                QuestionData(
                    "මැනුම - ඝනක පරිමාව",
                    "[$yearStr O/L - Q42] පැත්තක දිග $s cm වූ ඝනකයක (Cube) පරිමාව කොපමණද?",
                    listOf("$vol cm³", "${s * s} cm³", "${s * 12} cm³", "${vol / 2} cm³"),
                    0,
                    "ඝනකයේ පරිමාව = පැත්ත³ = $s * $s * $s = $vol cm³."
                )
            }
            43 -> {
                val l = (yOffset % 3) + 4
                val w = (yOffset % 3) + 2
                val h = (yOffset % 3) + 3
                val vol = l * w * h
                QuestionData(
                    "මැනුම - සෘජුකෝණාස්‍රාකාර ප්‍රිස්ම",
                    "[$yearStr O/L - Q43] දිග $l cm, පළල $w cm සහ උස $h cm වූ සෘජුකෝණාස්‍රාකාර ප්‍රිස්මයක පරිමාව කුමක්ද?",
                    listOf("$vol cm³", "${l + w + h} cm³", "${(l + w) * h} cm³", "${vol * 2} cm³"),
                    0,
                    "පරිමාව = දිග * පළල * උස = $l * $w * $h = $vol cm³."
                )
            }
            44 -> {
                val r = 7 * ((yOffset % 2) + 1) // 7 or 14
                val area = 22 * r * r / 7
                QuestionData(
                    "මැනුම - වෘත්ත වර්ගඵල ගණනය",
                    "[$yearStr O/L - Q44] අරය $r cm වූ වෘත්තයක වර්ගඵලය සොයන්න (π = 22/7).",
                    listOf("$area cm²", "${area / 2} cm²", "${area + 100} cm²", "100 cm²"),
                    0,
                    "වර්ගඵලය = πr² = (22/7) * $r * $r = $area cm²."
                )
            }
            45 -> {
                QuestionData(
                    "මැනුම - සිලින්ඩර පරිමාව",
                    "[$yearStr O/L - Q45] පාදයේ අරය r සහ උස h වූ සිලින්ඩරයක පරිමාව සෙවීමේ සූත්‍රය කුමක්ද?",
                    listOf("πr²h", "2πrh", "1/3 πr²h", "4/3 πr³"),
                    0,
                    "සිලින්ඩරයක පරිමාව = පාදයේ වර්ගඵලය * උස = πr²h."
                )
            }
            46 -> {
                val s = (yOffset % 5) + 4
                val p = s * 4
                QuestionData(
                    "මැනුම - සමචතුරස්‍ර පරිමිතිය",
                    "[$yearStr O/L - Q46] පැත්තක දිග $s cm වූ සමචතුරස්‍රයක පරිමිතිය කොපමණද?",
                    listOf("$p cm", "${s * s} cm", "${s * 2} cm", "${p + 4} cm"),
                    0,
                    "පරිමිතිය = 4 * පැත්ත = 4 * $s = $p cm."
                )
            }
            47 -> {
                QuestionData(
                    "මැනුම - සමාන්තරාස්‍ර වර්ගඵලය",
                    "[$yearStr O/L - Q47] සමාන්තරාස්‍රයක වර්ගඵලය සෙවීමේ සූත්‍රය කුමක්ද?",
                    listOf("ආධාරකයේ දිග * සිරස් උස", "දිග * පළල", "1/2 * ආධාරකය * උස", "පාදය²"),
                    0,
                    "සමාන්තරාස්‍රයේ වර්ගඵලය = ආධාරකයේ දිග * සිරස් උස වේ."
                )
            }
            48 -> {
                QuestionData(
                    "මැනුම - ත්‍රපීසියම",
                    "[$yearStr O/L - Q48] සමාන්තර පාද a සහ b ද, සිරස් උස h ද වන ත්‍රපීසියමක වර්ගඵලය කුමක්ද?",
                    listOf("1/2(a + b)h", "1/2bh", "abh", "a + b + h"),
                    0,
                    "ත්‍රපීසියමක වර්ගඵලය = 1/2 * (සමාන්තර පාදවල එකතුව) * සිරස් උස වේ."
                )
            }
            49 -> {
                QuestionData(
                    "මැනුම - ගෝලයේ පරිමාව",
                    "[$yearStr O/L - Q49] අරය r වූ ගෝලයක (Sphere) පරිමාව සෙවීමේ සූත්‍රය කුමක්ද?",
                    listOf("4/3 πr³", "4πr²", "πr²h", "1/3 πr²h"),
                    0,
                    "ගෝලයක පරිමාව = 4/3 πr³ වේ."
                )
            }
            50 -> {
                QuestionData(
                    "මැනුම - කෝණක පරිමාව",
                    "[$yearStr O/L - Q50] පාදයේ අරය r සහ සිරස් උස h වූ කෝණකයක (Cone) පරිමාව කුමක්ද?",
                    listOf("1/3 πr²h", "πr²h", "4/3 πr³", "2πrh"),
                    0,
                    "කෝණකයක පරිමාව = 1/3 * (පාදයේ වර්ගඵලය) * උස = 1/3 πr²h."
                )
            }

            // 51-60: Trigonometry & Sets & Advanced
            51 -> {
                QuestionData(
                    "ත්‍රිකෝණමිතිය - අර්ථ දැක්වීම්",
                    "[$yearStr O/L - Q51] සෘජුකෝණී ත්‍රිකෝණයක sin θ අර්ථ දැක්වෙන්නේ කුමන අනුපාතයෙන්ද?",
                    listOf("සම්මුඛ පාදය / කර්ණය", "බද්ධ පාදය / කර්ණය", "සම්මුඛ පාදය / බද්ධ පාදය", "කර්ණය / සම්මුඛ පාදය"),
                    0,
                    "sin θ = සම්මුඛ පාදය / කර්ණය වේ."
                )
            }
            52 -> {
                QuestionData(
                    "ත්‍රිකෝණමිතිය - විශේෂ කෝණ",
                    "[$yearStr O/L - Q52] cos 60° හි අගය කුමක්ද?",
                    listOf("1/2", "√3/2", "1", "0"),
                    0,
                    "cos 60° = 1/2 (0.5) වේ."
                )
            }
            53 -> {
                QuestionData(
                    "ත්‍රිකෝණමිතිය - විශේෂ කෝණ",
                    "[$yearStr O/L - Q53] tan 45° හි අගය කුමක්ද?",
                    listOf("1", "0", "1/√3", "√3"),
                    0,
                    "tan 45° = 1 වේ."
                )
            }
            54 -> {
                val commonVal = (yOffset % 5) + 1
                QuestionData(
                    "කුලක - අන්තර්ඡේදනය",
                    "[$yearStr O/L - Q54] A = {${commonVal - 1}, $commonVal} සහ B = {$commonVal, ${commonVal + 2}} නම් A ∩ B කුමක්ද?",
                    listOf("{$commonVal}", "{${commonVal - 1}, $commonVal, ${commonVal + 2}}", "{}", "{${commonVal - 1}}"),
                    0,
                    "අන්තර්ඡේදනය (∩) යනු කුලක දෙකටම පොදු මූලද්‍රව්‍යයයි. මෙහි පොදු වන්නේ $commonVal පමණි."
                )
            }
            55 -> {
                QuestionData(
                    "කුලක - කාදිනල් අංකය",
                    "[$yearStr O/L - Q55] කුලකයක ඇති මූලද්‍රව්‍ය ගණන හැඳින්වෙන ගණිතමය පදය කුමක්ද?",
                    listOf("කාදිනල් අංකය n(A)", "අනුකුලකය", "පරිමිත කුලකය", "ශුන්‍ය කුලකය"),
                    0,
                    "කුලකයක මූලද්‍රව්‍ය ගණන එහි කාදිනල් අංකය n(A) වේ."
                )
            }
            56 -> {
                val a = (yOffset % 3) + 2
                val d = (yOffset % 4) + 3
                val t1 = a
                val t2 = a + d
                val t3 = a + 2 * d
                QuestionData(
                    "ශ්‍රේණි - පොදු අන්තරය",
                    "[$yearStr O/L - Q56] $t1, $t2, $t3, ... සමාන්තර ශ්‍රේණියේ පොදු අන්තරය (d) කුමක්ද?",
                    listOf("$d", "$a", "${d + 1}", "${t2 + d}"),
                    0,
                    "පොදු අන්තරය d = T₂ - T₁ = $t2 - $t1 = $d වේ."
                )
            }
            57 -> {
                QuestionData(
                    "ශ්‍රේණි - n වන පදය",
                    "[$yearStr O/L - Q57] මුල් පදය a හා පොදු අන්තරය d වූ සමාන්තර ශ්‍රේණියක n වන පදය (Tn) සෙවීමේ සූත්‍රය කුමක්ද?",
                    listOf("a + (n - 1)d", "a + nd", "n/2(2a + (n-1)d)", "ar^(n-1)"),
                    0,
                    "සමාන්තර ශ්‍රේණියක n වන පදය Tn = a + (n - 1)d වේ."
                )
            }
            58 -> {
                val r1 = (yOffset % 3) + 2
                val r2 = (yOffset % 3) + 4
                val sum = r1 + r2
                val prod = r1 * r2
                QuestionData(
                    "වර්ගජ සමීකරණ - මූලයන්",
                    "[$yearStr O/L - Q58] x² - ${sum}x + $prod = 0 වර්ගජ සමීකරණයේ මූලයන් මොනවාද?",
                    listOf("$r1 සහ $r2", "-$r1 සහ -$r2", "1 සහ $prod", "0 සහ $sum"),
                    0,
                    "(x - $r1)(x - $r2) = 0 බැවින් x = $r1 හෝ x = $r2 වේ."
                )
            }
            59 -> {
                QuestionData(
                    "ත්‍රිකෝණමිතිය - සර්වසාම්‍ය",
                    "[$yearStr O/L - Q59] sin² θ + cos² θ හි අගය ඕනෑම කෝණයක් සඳහා සෑමවිටම කීයද?",
                    listOf("1", "0", "2", "-1"),
                    0,
                    "මූලික ත්‍රිකෝණමිතික සර්වසාම්‍යයක් ලෙස sin² θ + cos² θ = 1 වේ."
                )
            }
            60 -> {
                val x = (yOffset % 4) + 6
                val y = (yOffset % 3) + 2
                val sum = x + y
                val diff = x - y
                QuestionData(
                    "ගණිතය - සංඛ්‍යා ගැටලු",
                    "[$yearStr O/L - Q60] සංඛ්‍යා දෙකක එකතුව $sum ක් සහ අන්තරය $diff ක් නම් එම සංඛ්‍යා දෙක මොනවාද?",
                    listOf("$x සහ $y", "${x + 1} සහ ${y - 1}", "${x + 2} සහ ${y - 2}", "10 සහ ${sum - 10}"),
                    0,
                    "$x + $y = $sum සහ $x - $y = $diff වේ. එබැවින් සංඛ්‍යා $x සහ $y වේ."
                )
            }
            else -> {
                QuestionData("ගණිතය", "[$yearStr O/L - Q$q] 2 + 2 හි අගය කුමක්ද?", listOf("4", "2", "6", "8"), 0, "2 + 2 = 4 වේ.")
            }
        }
    }
}
