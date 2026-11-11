package com.example

/**
 * Sandu Theory 100-Pages PDF Content - Part 2 (Pages 26 to 50)
 * Covers Units 13 to 29
 */
object SanduTheoryPagesPart2 {

  val pages: List<SanduPdfPageItem> by lazy {
    listOf(
      // Page 26
      SanduPdfPageItem(
        pageNumber = 26,
        unitNumber = 13,
        unitTitleSinhala = "13 පෘෂ්ඨ වර්ගඵලය (සිලින්ඩරය)",
        isAnswerPage = false,
        pageHeader = "Sandu Theory • 13 සිලින්ඩරයක පෘෂ්ඨ වර්ගඵලය",
        pageSections = listOf(
          SanduPdfSection(
            heading = "සිලින්ඩරයක පෘෂ්ඨ වර්ගඵල සූත්‍ර",
            type = SanduSectionType.THEORY,
            items = listOf(
              "• වක්‍ර පෘෂ්ඨ වර්ගඵලය = 2πrh",
              "• පියනේ වර්ගඵලය = πr², පතුලේ වර්ගඵලය = πr²",
              "⭐ සංවෘත සිලින්ඩරයක මුළු පෘෂ්ඨ වර්ගඵලය = 2πr² + 2πrh = 2πr(r + h)",
              "උදා: r = 7 cm, h = 20 cm කුහර (දෙපස විවෘත) සිලින්ඩරයක වර්ගඵලය = 2πrh = 2 × 22/7 × 7 × 20 = 880 cm²"
            )
          )
        )
      ),

      // Page 27
      SanduPdfPageItem(
        pageNumber = 27,
        unitNumber = 14,
        unitTitleSinhala = "13 සිලින්ඩරය & 14 ත්‍රිකෝණාකාර හරස්කඩක් සහිත සෘජු ප්‍රිස්මය",
        isAnswerPage = false,
        pageHeader = "Sandu Theory • 13 සිලින්ඩරය & 14 ප්‍රිස්මය",
        pageSections = listOf(
          SanduPdfSection(
            heading = "01 & 02 සිලින්ඩර පෘෂ්ඨ වර්ගඵල පියවර",
            type = SanduSectionType.WORKED_EXAMPLE,
            items = listOf(
              "01. r = 7 cm, h = 20 cm සංවෘත සිලින්ඩරය:\n• පියනේ වර්ගඵලය = 22/7 × 7 × 7 = 154 cm²\n• පතුලේ වර්ගඵලය = 154 cm²\n• වක්‍ර පෘෂ්ඨ වර්ගඵලය = 2 × 22/7 × 7 × 20 = 880 cm²\n• මුළු වර්ගඵලය = 154 + 154 + 880 = 1188 cm²",
              "02. r = 14 cm, උස h = 14 × 2.5 = 35 cm:\n• වක්‍ර පෘෂ්ඨ වර්ගඵලය = 2 × 22/7 × 14 × 35 = 3080 cm²"
            )
          ),
          SanduPdfSection(
            heading = "14 පෘෂ්ඨ වර්ගඵලය - පයිතගරස් ප්‍රමේයය",
            type = SanduSectionType.THEORY,
            items = listOf(
              "⭐ පයිතගරස් ප්‍රමේයය:\nසෘජුකෝණී ත්‍රිකෝණයක කර්ණය මත වර්ගඵලය අනෙක් පාද දෙක මත වර්ගඵලවල එකතුවට සමාන වේ: a² = b² + c²",
              "උදා: b = 4 cm, c = 3 cm නම් a² = 4² + 3² = 16 + 9 = 25 -> a = 5 cm"
            )
          )
        )
      ),

      // Page 28
      SanduPdfPageItem(
        pageNumber = 28,
        unitNumber = 14,
        unitTitleSinhala = "14 සෘජු ප්‍රිස්මය (පයිතගරස් ප්‍රමේයය භාවිතය & මුහුණත්)",
        isAnswerPage = false,
        pageHeader = "Sandu Theory • 14 ප්‍රිස්ම පෘෂ්ඨ වර්ගඵලය",
        pageSections = listOf(
          SanduPdfSection(
            heading = "අභ්‍යාස : 1 (සෘජුකෝණී ත්‍රිකෝණ හඳුනාගැනීම)",
            type = SanduSectionType.EXERCISE,
            items = listOf(
              "• ABC: a = 5, b = 4, c = 3 -> 5² = 4² + 3² (25 = 25) -> සෘජුකෝණී වේ [✓]",
              "• DEF: a = 10, b = 8, c = 6 -> 10² = 8² + 6² (100 = 100) -> සෘජුකෝණී වේ [✓]",
              "• PQR: a = 15, b = 12, c = 9 -> 15² = 12² + 9² (225 = 225) -> සෘජුකෝණී වේ [✓]",
              "• XYZ: a = 13, b = 12, c = 5 -> 13² = 12² + 5² (169 = 169) -> සෘජුකෝණී වේ [✓]"
            )
          ),
          SanduPdfSection(
            heading = "ප්‍රිස්මයේ මුහුණත් සටහන්",
            type = SanduSectionType.THEORY,
            items = listOf(
              "සෘජු ත්‍රිකෝණාකාර ප්‍රිස්මයක මුහුණත් 5 කි:\n• ත්‍රිකෝණාකාර මුහුණත් 2 (හරස්කඩ)\n• සෘජුකෝණාස්‍රාකාර මුහුණත් 3"
            )
          )
        )
      ),

      // Page 29
      SanduPdfPageItem(
        pageNumber = 29,
        unitNumber = 15,
        unitTitleSinhala = "15 සිලින්ඩරයක පරිමාව (V = πr²h)",
        isAnswerPage = false,
        pageHeader = "Sandu Theory • 15 සිලින්ඩරයක පරිමාව",
        pageSections = listOf(
          SanduPdfSection(
            heading = "සිලින්ඩරයක පරිමාව සූත්‍රය & ආදර්ශ ගැටලු",
            type = SanduSectionType.THEORY,
            items = listOf(
              "⭐ සිලින්ඩර පරිමාව V = හරස්කඩ වර්ගඵලය × උස = πr²h",
              "උදා: r = 7 cm, h = 10 cm සිලින්ඩරයේ පරිමාව = 22/7 × 7 × 7 × 10 = 1540 cm³"
            )
          ),
          SanduPdfSection(
            heading = "අභ්‍යාස : 1 (වගුව සම්පූර්ණ කිරීම)",
            type = SanduSectionType.WORKED_EXAMPLE,
            items = listOf(
              "• r = 21 cm, h = 10 cm -> හරස්කඩ = 22/7 × 21² = 1386 cm², පරිමාව = 1386 × 10 = 13,860 cm³",
              "• r = 14 cm, h = 7 cm -> හරස්කඩ = 616 cm², පරිමාව = 616 × 7 = 4,312 cm³",
              "• r = 28 cm, h = 20 cm -> හරස්කඩ = 2464 cm², පරිමාව = 2464 × 20 = 49,280 cm³",
              "• r = 70 cm, h = 1 m (100 cm) -> හරස්කඩ = 15,400 cm², පරිමාව = 1,540,000 cm³"
            )
          )
        )
      ),

      // Page 30
      SanduPdfPageItem(
        pageNumber = 30,
        unitNumber = 15,
        unitTitleSinhala = "15 සිලින්ඩරයක පරිමාවෙන් උස හා අරය සෙවීම",
        isAnswerPage = false,
        pageHeader = "Sandu Theory • 15 උස සහ අරය සෙවීම",
        pageSections = listOf(
          SanduPdfSection(
            heading = "පරිමාව හා අරය දී ඇති විට උස සෙවීම",
            type = SanduSectionType.WORKED_EXAMPLE,
            items = listOf(
              "උදා: V = 6160 cm³, r = 14 cm:\n  6160 = 22/7 × 14 × 14 × h = 616h -> h = 10 cm",
              "අභ්‍යාස 2: (r=7, V=1540 -> h=10 cm) | (r=21, V=6930 -> h=5 cm) | (r=70, V=61600 -> h=4 cm)"
            )
          ),
          SanduPdfSection(
            heading = "පරිමාව හා උස දී ඇති විට අරය සෙවීම",
            type = SanduSectionType.WORKED_EXAMPLE,
            items = listOf(
              "උදා: V = 616 cm³, h = 4 cm:\n  616 = 22/7 × r² × 4 -> r² = (616 × 7) / 88 = 49 -> r = 7 cm"
            )
          )
        )
      ),

      // Page 31
      SanduPdfPageItem(
        pageNumber = 31,
        unitNumber = 16,
        unitTitleSinhala = "16 ත්‍රිකෝණාකාර හරස්කඩක් සහිත සෘජු ප්‍රිස්මය (පරිමාව)",
        isAnswerPage = false,
        pageHeader = "Sandu Theory • 16 ප්‍රිස්ම පරිමාව",
        pageSections = listOf(
          SanduPdfSection(
            heading = "15 සිලින්ඩර අභ්‍යාස 3",
            type = SanduSectionType.EXERCISE,
            items = listOf(
              "i. V = 1540, h = 10 -> r = 7 cm",
              "ii. V = 3080, h = 5 -> r = 14 cm",
              "iii. V = 2310, h = 15 -> r = 7 cm"
            )
          ),
          SanduPdfSection(
            heading = "16 ප්‍රිස්මයක පරිමාව සෙවීම (අභ්‍යාස : 1)",
            type = SanduSectionType.WORKED_EXAMPLE,
            items = listOf(
              "⭐ ප්‍රිස්මයක පරිමාව = හරස්කඩ වර්ගඵලය (A) × දිග (l)",
              "(i) A = 12 cm², l = 10 cm -> V = 12 × 10 = 120 cm³",
              "(ii) A = 50 cm², l = 0.5 m (50 cm) -> V = 50 × 50 = 2500 cm³ (හෝ 0.5m නම් 360 cm³ ආදර්ශ)",
              "(iii) A = 24 cm², l = 15 cm -> V = 24 × 15 = 360 cm³",
              "(iv) A = 20 cm², l = 1.5 m (150 cm) -> V = 20 × 150 = 3000 cm³"
            )
          )
        )
      ),

      // Page 32
      SanduPdfPageItem(
        pageNumber = 32,
        unitNumber = 17,
        unitTitleSinhala = "17 දුර හා කාලය (දුර-කාල ප්‍රස්ථාර)",
        isAnswerPage = false,
        pageHeader = "Sandu Theory • 17 දුර-කාල ප්‍රස්ථාර",
        pageSections = listOf(
          SanduPdfSection(
            heading = "බයිසිකල් ධාවන තරගය දුර-කාල ප්‍රස්ථාර ගැටලුව",
            type = SanduSectionType.WORKED_EXAMPLE,
            items = listOf(
              "i. තරගය ආරම්භ කළ ඒකාකාර වේගය = (120 - 40) / (5 - 1) = 80/4 = 20 km h⁻¹",
              "ii. ආබාධයෙන් පසු වේගය = (180 - 120) / (8 - 6) = 60/2 = 30 km h⁻¹",
              "iii. තරගයේ මුළු දුර = 180 - 40 = 140 km",
              "iv. බයිසිකලයේ මධ්‍යක වේගය = මුළු දුර / මුළු කාලය = 140 / 7 = 20 km h⁻¹",
              "v. තරගය නිම කළ වේලාව = පස්වරු 4.00 (8.00 සිට පැය 8 කට පසු)",
              "vi. වේගය වැඩි කරගත් ප්‍රමාණය = 30 - 20 = 10 km h⁻¹",
              "vii. තරගය නිමකළ ස්ථානයට නිවසේ සිට දුර = 180 km"
            )
          )
        )
      ),

      // Page 33
      SanduPdfPageItem(
        pageNumber = 33,
        unitNumber = 18,
        unitTitleSinhala = "18 ආරෝහණ කෝණය හා අවරෝහණ කෝණය",
        isAnswerPage = false,
        pageHeader = "Sandu Theory • 18 කෝණ හැඳින්වීම",
        pageSections = listOf(
          SanduPdfSection(
            heading = "කෝණයක් මැනීම හා ලකුණු කිරීම පිළිබඳ දැනුම",
            type = SanduSectionType.THEORY,
            items = listOf(
              "• ඇස් මට්ටම = නිරීක්ෂකයාගේ ඇස් මට්ටම ඔස්සේ වන තිරස් රේඛාව.",
              "• දෘෂ්ටි රේඛාව = නිරීක්ෂකයාගේ ඇසත් වස්තුවත් යා කරන සරල රේඛාව.",
              "⭐ ආරෝහණ කෝණය: තිරස් රේඛාවට (ඇස් මට්ටමට) ඉහළින් පිහිටි වස්තුවක් දෙස බැලීමේදී සෑදෙන කෝණය.",
              "⭐ අවරෝහණ කෝණය: තිරස් රේඛාවට පහළින් පිහිටි වස්තුවක් දෙස බැලීමේදී සෑදෙන කෝණය.",
              "a. ළමයාට මල පෙනෙන අවරෝහණ කෝණය b° වේ.",
              "b. ළමයාට කුරුල්ලා පෙනෙන ආරෝහණ කෝණය a° වේ."
            )
          )
        )
      ),

      // Page 34
      SanduPdfPageItem(
        pageNumber = 34,
        unitNumber = 18,
        unitTitleSinhala = "18 ආරෝහණ හා අවරෝහණ කෝණ ගැටලු",
        isAnswerPage = false,
        pageHeader = "Sandu Theory • 18 කෝණ අභ්‍යාස",
        pageSections = listOf(
          SanduPdfSection(
            heading = "ආරෝහණ & අවරෝහණ කෝණ අභ්‍යාස",
            type = SanduSectionType.EXERCISE,
            items = listOf(
              "01) A, B, C ලක්ෂ්‍ය: A සිට C හි ආරෝහණ කෝණය = 90° - 60° = 30°; C සිට A හි අවරෝහණ කෝණය = 30°",
              "02) P, Q, R ලක්ෂ්‍ය: P සිට R හි අවරෝහණ කෝණය = 90° - 40° = 50°; R සිට P හි ආරෝහණ කෝණය = 50°",
              "03) උඩුමහලේ කවුළුවකින් මෝටර් රථයක් දෙස බලන අවරෝහණ කෝණය 40° කි."
            )
          )
        )
      ),

      // Page 35
      SanduPdfPageItem(
        pageNumber = 35,
        unitNumber = 19,
        unitTitleSinhala = "19 ත්‍රිකෝණමිතික අනුපාත (Sin α & Cos α)",
        isAnswerPage = false,
        pageHeader = "Sandu Theory • 19 Sin හා Cos අනුපාත",
        pageSections = listOf(
          SanduPdfSection(
            heading = "Sin α = සම්මුඛ පාදය / කර්ණය",
            type = SanduSectionType.THEORY,
            items = listOf(
              "• ත්‍රිකෝණය ABC -> සම්මුඛ AB, කර්ණය AC -> Sin α = AB / AC",
              "• ත්‍රිකෝණය PQR -> සම්මුඛ PR, කර්ණය PQ -> Sin α = PR / PQ",
              "• ත්‍රිකෝණය XYZ -> සම්මුඛ YZ, කර්ණය XY -> Sin α = YZ / XY"
            )
          ),
          SanduPdfSection(
            heading = "Cos α = බද්ධ පාදය / කර්ණය",
            type = SanduSectionType.THEORY,
            items = listOf(
              "• ත්‍රිකෝණය ABC -> බද්ධ BC, කර්ණය AB -> Cos α = BC / AB",
              "• ත්‍රිකෝණය PQR -> බද්ධ QR, කර්ණය PR -> Cos α = QR / PR",
              "• ත්‍රිකෝණය STU -> බද්ධ SU, කර්ණය ST -> Cos α = SU / ST"
            )
          )
        )
      ),

      // Page 36
      SanduPdfPageItem(
        pageNumber = 36,
        unitNumber = 19,
        unitTitleSinhala = "19 ත්‍රිකෝණමිතික අනුපාත (Tan α සහ 30° කෝණය)",
        isAnswerPage = false,
        pageHeader = "Sandu Theory • 19 Tan අනුපාතය",
        pageSections = listOf(
          SanduPdfSection(
            heading = "Tan α = සම්මුඛ පාදය / බද්ධ පාදය",
            type = SanduSectionType.THEORY,
            items = listOf(
              "• ත්‍රිකෝණය ABC -> සම්මුඛ AC, බද්ධ BC -> Tan α = AC / BC",
              "• ත්‍රිකෝණය PQR -> සම්මුඛ QR, බද්ධ PR -> Tan α = QR / PR",
              "• ත්‍රිකෝණය KLM -> සම්මුඛ KM, බද්ධ LM -> Tan α = KM / LM",
              "01) Sin θ = 3/5 නම් Tan θ = 3/4 (පයිතගරස් 3, 4, 5)",
              "02) Tan θ = 5/3, Tan α = 5/7",
              "03) 30° කෝණයේ අනුපාත: Sin 30° = 1/2, Cos 30° = √3/2, Tan 30° = 1/√3"
            )
          )
        )
      ),

      // Page 37
      SanduPdfPageItem(
        pageNumber = 37,
        unitNumber = 20,
        unitTitleSinhala = "20 සාධක සෙවීම (x² + bx + c ආකාරය)",
        isAnswerPage = false,
        pageHeader = "Sandu Theory • 20 වර්ගජ ප්‍රකාශන සාධක",
        pageSections = listOf(
          SanduPdfSection(
            heading = "අභ්‍යාසය : 1 (ධන ලකුණු සහිත)",
            type = SanduSectionType.EXERCISE,
            items = listOf(
              "1. x² + 8x + 15 = (x + 3)(x + 5)",
              "2. x² + 7x + 12 = (x + 3)(x + 4)",
              "3. x² + 9x + 20 = (x + 4)(x + 5)",
              "4. x² + 2x + 1 = (x + 1)(x + 1)",
              "5. x² + 11x + 24 = (x + 3)(x + 8)",
              "6. x² + 8x + 12 = (x + 2)(x + 6)"
            )
          ),
          SanduPdfSection(
            heading = "අභ්‍යාසය : 2 (මැද සෘණ ලකුණු සහිත)",
            type = SanduSectionType.EXERCISE,
            items = listOf(
              "1. x² - 7x + 10 = (x - 2)(x - 5)",
              "2. x² - 11x + 24 = (x - 3)(x - 8)",
              "3. x² - 8x + 15 = (x - 3)(x - 5)",
              "4. x² - 9x + 20 = (x - 4)(x - 5)"
            )
          )
        )
      ),

      // Page 38
      SanduPdfPageItem(
        pageNumber = 38,
        unitNumber = 20,
        unitTitleSinhala = "20 සාධක සෙවීම (ax² + bx + c ආකාරය)",
        isAnswerPage = false,
        pageHeader = "Sandu Theory • 20 ax² + bx + c සාධක",
        pageSections = listOf(
          SanduPdfSection(
            heading = "අභ්‍යාසය : 3, 4, 5",
            type = SanduSectionType.EXERCISE,
            items = listOf(
              "අභ්‍යාස 3: x² + 4x - 21 = (x + 7)(x - 3) | x² + x - 12 = (x + 4)(x - 3) | x² + 5x - 24 = (x + 8)(x - 3) | x² - 4x - 12 = (x - 6)(x + 2)",
              "අභ්‍යාස 4: 2x² + 3x + 1 = (2x + 1)(x + 1) | 2m² + 7m + 3 = (2m + 1)(m + 3) | 3x² + 7x + 2 = (3x + 1)(x + 2) | 3x² + 16x + 5 = (3x + 1)(x + 5)",
              "අභ්‍යාස 5: 3p² - 16p + 5 = (3p - 1)(p - 5) | 3p² - 11p + 8 = (3p - 8)(p - 1) | 2x² - 3x + 1 = (2x - 1)(x - 1) | 2x² - 13x + 15 = (2x - 3)(x - 5)"
            )
          )
        )
      ),

      // Page 39
      SanduPdfPageItem(
        pageNumber = 39,
        unitNumber = 21,
        unitTitleSinhala = "21 වීජීය ප්‍රකාශන වල කුඩාම පොදු ගුණාකාරය (කු.පො.ගු.)",
        isAnswerPage = false,
        pageHeader = "Sandu Theory • 21 කුඩාම පොදු ගුණාකාරය",
        pageSections = listOf(
          SanduPdfSection(
            heading = "20 සාධක අභ්‍යාසය 6",
            type = SanduSectionType.EXERCISE,
            items = listOf(
              "1. 2x² + 9x - 18 = (2x - 3)(x + 6)",
              "2. 3p² + p - 2 = (3p - 2)(p + 1)",
              "3. 3x² + 5x - 2 = (3x - 1)(x + 2)",
              "4. 2a² + a - 6 = (2a - 3)(a + 2)",
              "5. 4m² + 11m - 3 = (4m - 1)(m + 3)",
              "6. 2x² - x - 15 = (2x + 5)(x - 3)"
            )
          ),
          SanduPdfSection(
            heading = "21 වීජීය කු.පො.ගු. සෙවීම",
            type = SanduSectionType.THEORY,
            items = listOf(
              "⭐ ක්‍රමය: ප්‍රථමක සාධකවල හෝ වීජීය පදයන්හි බලවල ගුණිතයක් ලෙස ලියා, සියලුම සාධකවල විශාලම බලවල ගුණිතය ලබා ගැනීම.",
              "1. a²b, ab -> කු.පො.ගු. = a²b",
              "2. a²b², ab² -> කු.පො.ගු. = a²b²",
              "3. x²y, xy² -> කු.පො.ගු. = x²y²",
              "4. 4x², 6y² -> 12x²y² | 6x²y, 12xy² -> 12x²y² | 12a²b, 18b² -> 36a²b² | 24a²b, 18ab² -> 72a²b²"
            )
          )
        )
      ),

      // Page 40
      SanduPdfPageItem(
        pageNumber = 40,
        unitNumber = 22,
        unitTitleSinhala = "22 වීජීය භාග එකතු කිරීම හා අඩු කිරීම (සම්බන්ධිත හර සහිත)",
        isAnswerPage = false,
        pageHeader = "Sandu Theory • 22 වීජීය භාග එකතු/අඩු",
        pageSections = listOf(
          SanduPdfSection(
            heading = "අභ්‍යාසය : 1 (එකතු කිරීම)",
            type = SanduSectionType.WORKED_EXAMPLE,
            items = listOf(
              "1. 1/a + 2/(3a) = 3/(3a) + 2/(3a) = 5/(3a)",
              "2. 5/(2a) + 1/(4a) = 10/(4a) + 1/(4a) = 11/(4a)",
              "3. 1/x + 1/(3x) = 3/(3x) + 1/(3x) = 4/(3x)",
              "4. 1/(2x) + 5/(6x) = 3/(6x) + 5/(6x) = 8/(6x) = 4/(3x)"
            )
          ),
          SanduPdfSection(
            heading = "අභ්‍යාසය : 2 (අඩු කිරීම)",
            type = SanduSectionType.WORKED_EXAMPLE,
            items = listOf(
              "1. 3/a - 1/(2a) = 6/(2a) - 1/(2a) = 5/(2a)",
              "2. 7/(3a) - 1/a = 7/(3a) - 3/(3a) = 4/(3a)",
              "3. 7/(8p) - 1/(2p) = 7/(8p) - 4/(8p) = 3/(8p)",
              "4. 7/(2x) - 3/(4x) = 14/(4x) - 3/(4x) = 11/(4x)"
            )
          )
        )
      ),

      // Page 41
      SanduPdfPageItem(
        pageNumber = 41,
        unitNumber = 23,
        unitTitleSinhala = "23 වීජීය භාග සහිත ඒකජ සමීකරණ විසඳීම",
        isAnswerPage = false,
        pageHeader = "Sandu Theory • 23 භාග සහිත ඒකජ සමීකරණ",
        pageSections = listOf(
          SanduPdfSection(
            heading = "22 ලවයේ වීජීය ප්‍රකාශන සහිත භාග",
            type = SanduSectionType.WORKED_EXAMPLE,
            items = listOf(
              "1. (x+3)/(9y) + 5/(3y) = (x + 3 + 15) / (9y) = (x + 18)/(9y)",
              "2. (m+3)/p + (m+1)/(2p) = (2m + 6 + m + 1)/(2p) = (3m + 7)/(2p)",
              "3. 1/(2a) + (x+4)/a = (1 + 2x + 8)/(2a) = (2x + 9)/(2a)",
              "4. 2/(5a) + (2x+1)/(10a) = (4 + 2x + 1)/(10a) = (2x + 5)/(10a)"
            )
          ),
          SanduPdfSection(
            heading = "23 සමීකරණ විසඳීම",
            type = SanduSectionType.EXERCISE,
            items = listOf(
              "1. x/5 = 2 -> x = 10",
              "2. x/8 + 3 = 9 -> x/8 = 6 -> x = 48",
              "3. -2x/3 = 4 -> x = -6",
              "4. 5 + 2x/5 = 1 -> 2x/5 = -4 -> x = -10",
              "5. 6x/9 - x/9 = 5 -> 5x/9 = 5 -> x = 9",
              "6. x/9 + x/3 = 4 -> 4x/9 = 4 -> x = 9",
              "7. 2m/3 - 3m/2 = -5 -> -5m/6 = -5 -> m = 6",
              "8. (x+4)/5 + (x+2)/5 = 12/5 -> 2x + 6 = 12 -> x = 3",
              "9. (x+1)/4 + (x-1)/8 = 2 -> 2(x+1) + x - 1 = 16 -> 3x + 1 = 16 -> x = 5",
              "11. 9/x - 2/x = 14 -> 7/x = 14 -> x = 1/2"
            )
          )
        )
      ),

      // Page 42
      SanduPdfPageItem(
        pageNumber = 42,
        unitNumber = 24,
        unitTitleSinhala = "24 සමගාමී සමීකරණ විසඳීම & වර්ගජ සමීකරණ",
        isAnswerPage = false,
        pageHeader = "Sandu Theory • 24 සමගාමී සමීකරණ",
        pageSections = listOf(
          SanduPdfSection(
            heading = "සමගාමී සමීකරණ විසඳීම",
            type = SanduSectionType.WORKED_EXAMPLE,
            items = listOf(
              "01. එකතු කිරීමෙන්: x + y = 2 සහ x - y = 8 -> 2x = 10 -> x = 5, y = -3",
              "02. අඩු කිරීමෙන්: 2x + y = 8 සහ x + y = 5 -> x = 3, y = 2",
              "03. 3x - y = 7 සහ x + y = 5 -> 4x = 12 -> x = 3",
              "04. x + 3y = 5, 2x + y = 5 -> x = 2 නම් y = 1",
              "05. 2a - 3b = 0, 2a - b = 4 -> 2b = 4 -> b = 2, a = 3 -> a - b = 1"
            )
          ),
          SanduPdfSection(
            heading = "වර්ගජ සමීකරණ විසඳීම",
            type = SanduSectionType.EXERCISE,
            items = listOf(
              "i. (x - 3)(x + 2) = 0 -> x = 3 හෝ x = -2",
              "ii. 2/3 x (x - 1/2) = 0 -> x = 0 හෝ x = 1/2",
              "iii. x² - 9 = 0 -> (x - 3)(x + 3) = 0 -> x = 3 හෝ x = -3",
              "iv. x(2x - 5) = x(x - 2) + 10 -> 2x² - 5x = x² - 2x + 10 -> x² - 3x - 10 = 0 -> (x - 5)(x + 2) = 0 -> x = 5 හෝ x = -2"
            )
          )
        )
      ),

      // Page 43
      SanduPdfPageItem(
        pageNumber = 43,
        unitNumber = 25,
        unitTitleSinhala = "25 අසමානතා විසඳීම හා විසඳුම් සංඛ්‍යා රේඛාවක නිරූපණය",
        isAnswerPage = false,
        pageHeader = "Sandu Theory • 25 අසමානතා සංඛ්‍යා රේඛාව",
        pageSections = listOf(
          SanduPdfSection(
            heading = "අසමානතාවක් සංඛ්‍යා රේඛාවක නිරූපණය කිරීම",
            type = SanduSectionType.THEORY,
            items = listOf(
              "උදා: x ≤ 3 තෘප්ත කරන ධන නිඛිලමය විසඳුම් කුලකය {1, 2, 3} වේ.",
              "01. x < 4 හි ධන නිඛිලමය කුලකය A = {1, 2, 3}",
              "02. x ≥ -2 හි සෘණ නිඛිලමය කුලකය B = {-2, -1}",
              "03. x > -5 හි සෘණ නිඛිලමය කුලකය C = {-4, -3, -2, -1}",
              "04. x ≤ 4 හා x > -2 හි විසඳුම් එකම සංඛ්‍යා රේඛාවක: -2 < x ≤ 4"
            )
          )
        )
      ),

      // Page 44
      SanduPdfPageItem(
        pageNumber = 44,
        unitNumber = 25,
        unitTitleSinhala = "25 අසමානතා අභ්‍යාස",
        isAnswerPage = false,
        pageHeader = "Sandu Theory • 25 අසමානතා අභ්‍යාස",
        pageSections = listOf(
          SanduPdfSection(
            heading = "අසමානතා විසඳීම",
            type = SanduSectionType.EXERCISE,
            items = listOf(
              "01. x + 5 < 10 -> x < 5; 2x + 3 ≤ 11 -> 2x ≤ 8 -> x ≤ 4. ධන නිඛිල: {1, 2, 3, 4}",
              "02. 4x - 5 ≥ 15 -> 4x ≥ 20 -> x ≥ 5. නිඛිල 3 ක්: 5, 6, 7",
              "03. (i) 3x - 6 ≤ 0 -> x ≤ 2 | (ii) 2x + 8 ≥ 14 -> x ≥ 3 | (iii) 4x + 2 > 14 -> x > 3",
              "04. 2x + 1 ≥ 6 -> 2x ≥ 5 -> x ≥ 2.5 -> අඩුතම නිඛිලය = 3",
              "05. 3x + 4 ≤ 10 -> 3x ≤ 6 -> x ≤ 2 -> වැඩිතම නිඛිලය = 2",
              "07. 2x - 3 > 5 -> 2x > 8 -> x > 4. [x > 4 හරි ✓]"
            )
          )
        )
      ),

      // Page 45
      SanduPdfPageItem(
        pageNumber = 45,
        unitNumber = 26,
        unitTitleSinhala = "26 y = mx + c ආකාරයේ සරල රේඛාවක අනුක්‍රමණය හා අන්තඃඛණ්ඩය",
        isAnswerPage = false,
        pageHeader = "Sandu Theory • 26 සරල රේඛාවේ සමීකරණය",
        pageSections = listOf(
          SanduPdfSection(
            heading = "අනුක්‍රමණය m හා අන්තඃඛණ්ඩය c සෙවීම",
            type = SanduSectionType.THEORY,
            items = listOf(
              "⭐ සූත්‍රය: m = (y₂ - y₁) / (x₂ - x₁), c = y අක්ෂය ඡේදනය වන ලක්ෂ්‍යයේ y ඛණ්ඩාංකය",
              "01. (2,1) සහ (5,3) -> m = (3 - 1)/(5 - 2) = 2/3",
              "02. වගුව:\n• (2,4) & (3,5) -> m = 1, c = 2 -> y = x + 2\n• (1,3) & (2,7) -> m = 4, c = -1 (හෝ c=1 -> y = 4x + 1)\n• (0,2) & (7,10) -> m = 8/7, c = 2 -> y = 8/7 x + 2\n• (5,1) & (2,7) -> m = -2, c = 11 -> y = -2x + 11",
              "03. c = 5 සහ (3,8) හරහා යන රේඛාව: 8 = m(3) + 5 -> m = 1 -> y = x + 5",
              "04. 2y = -3x + 1 -> y = -3/2 x + 1/2 -> m = -3/2, c = 1/2",
              "05. (0,0) සහ (3,6) හරහා යන රේඛාව: m = 2, c = 0 -> y = 2x"
            )
          )
        )
      ),

      // Page 46
      SanduPdfPageItem(
        pageNumber = 46,
        unitNumber = 27,
        unitTitleSinhala = "27 වීජීය භාග ගුණ කිරීම හා බෙදීම (පරස්පරය)",
        isAnswerPage = false,
        pageHeader = "Sandu Theory • 27 වීජීය භාග ගුණ/බෙදීම",
        pageSections = listOf(
          SanduPdfSection(
            heading = "අභ්‍යාස : 1 (ගුණ කිරීම)",
            type = SanduSectionType.WORKED_EXAMPLE,
            items = listOf(
              "1. x/4 × 8/x = 2",
              "2. 10/(3x) × 9x/(5y) = 6/y",
              "3. 2x²/(14y) × 7y/(4x) = x/4",
              "4. 2x²/(6y²) × 3y/(10x) = x/(10y)"
            )
          ),
          SanduPdfSection(
            heading = "පරස්පරය හැඳින්වීම",
            type = SanduSectionType.THEORY,
            items = listOf(
              "සංඛ්‍යා දෙකක ගුණිතය 1 ට සමාන වේ නම් එකක් අනෙකෙහි පරස්පරයයි.",
              "• 5/6 හි පරස්පරය = 6/5",
              "• x/y හි පරස්පරය = y/x",
              "• t හි පරස්පරය = 1/t"
            )
          )
        )
      ),

      // Page 47
      SanduPdfPageItem(
        pageNumber = 47,
        unitNumber = 27,
        unitTitleSinhala = "27 වීජීය භාග බෙදීම (අභ්‍යාස 2 & 3)",
        isAnswerPage = false,
        pageHeader = "Sandu Theory • 27 වීජීය භාග බෙදීම",
        pageSections = listOf(
          SanduPdfSection(
            heading = "අභ්‍යාස : 3 (බෙදීම)",
            type = SanduSectionType.EXERCISE,
            items = listOf(
              "1. x/5 ÷ x/2 = x/5 × 2/x = 2/5",
              "2. 2a/15 ÷ 9/(5b) = 2a/15 × 5b/9 = 2ab/27",
              "3. 4m/(5n) ÷ 2m/3 = 4m/(5n) × 3/(2m) = 6/(5n)",
              "4. x/5 ÷ 3/(xy) = x/5 × xy/3 = x²y/15",
              "5. m²n/10 ÷ m²n²/(5n) = m²n/10 × 5n/(m²n²) = 1/2",
              "6. 10x/(3y) ÷ 20x²/(4y) = 10x/(3y) × 4y/(20x²) = 2/(3x)"
            )
          )
        )
      ),

      // Page 48
      SanduPdfPageItem(
        pageNumber = 48,
        unitNumber = 28,
        unitTitleSinhala = "28 අසමානතා (ප්‍රාන්තර හා සංඛ්‍යා රේඛා)",
        isAnswerPage = false,
        pageHeader = "Sandu Theory • 28 අසමානතා ප්‍රාන්තර",
        pageSections = listOf(
          SanduPdfSection(
            heading = "අසමානතා විසඳීම හා සංඛ්‍යා රේඛාව",
            type = SanduSectionType.EXERCISE,
            items = listOf(
              "01. (i) 15x + 4 < 3x + 28 -> 12x < 24 -> x < 2",
              "(ii) 8x - 3 > 5x - 6 -> 3x > -3 -> x > -1",
              "(iii) 20x + 3 ≥ 3x + 37 -> 17x ≥ 34 -> x ≥ 2",
              "(iv) 3x - 5 < 4x - 2 -> -x < 3 -> x > -3",
              "02. i. 12x + 5 > 8x + 13 -> 4x > 8 -> x > 2 (අගයන්: 3, 4, 5)",
              "ii. 15x + 4 < 3x + 28 -> x < 2 (අගයන්: 1, 0, -1)",
              "iii. 8x - 3 > 5x - 6 -> x > -1 (කුඩාම නිඛිලය = 0)",
              "03. (i) 12x - 1 ≤ 3x + 8 -> 9x ≤ 9 -> x ≤ 1 | (ii) 18x - 8 ≤ 12x - 4 -> 6x ≤ 4 -> x ≤ 2/3 | (iii) 3x + 4 ≥ -8 + 7x -> -4x ≥ -12 -> x ≤ 3"
            )
          )
        )
      ),

      // Page 49
      SanduPdfPageItem(
        pageNumber = 49,
        unitNumber = 29,
        unitTitleSinhala = "29 න්‍යාස (න්‍යාස වර්ග සහ ගණය)",
        isAnswerPage = false,
        pageHeader = "Sandu Theory • 29 න්‍යාස වර්ග",
        pageSections = listOf(
          SanduPdfSection(
            heading = "න්‍යාස වර්ග",
            type = SanduSectionType.THEORY,
            items = listOf(
              "• තීර න්‍යාස: තීරයක් පමණක් ඇති න්‍යාස (උදා: [1, 2, 3]ᵀ - 3×1)",
              "• පේළි න්‍යාස: පේළියක් පමණක් ඇති න්‍යාස (උදා: [3, 4, 5] - 1×3)",
              "• සමචතුරස්‍ර න්‍යාස: පේළි ගණන හා තීර ගණන සමාන න්‍යාස (2×2, 3×3)",
              "• ඒකක න්‍යාස: ප්‍රධාන විකර්ණයේ අවයව 1 වන අතර අනෙක් අවයව 0 වේ.",
              "• සමමිතික න්‍යාස: ප්‍රධාන විකර්ණයට දෙපසින් අනුරූප අවයව සමාන වේ."
            )
          ),
          SanduPdfSection(
            heading = "අභ්‍යාස : 1",
            type = SanduSectionType.EXERCISE,
            items = listOf(
              "01. පේළි න්‍යාසයක තීර 3 කි. එහි ගණය = 1 × 3",
              "02. සමචතුරස්‍ර න්‍යාසයක පේළි 3 කි. එහි ගණය = 3 × 3",
              "03. a) [5, 4, 3] -> පේළි න්‍යාසයකි | b) [1, 2, 3]ᵀ -> තීර න්‍යාසයකි | c) I₂ -> ඒකක න්‍යාසයකි | d) 3×3 -> සමචතුරස්‍ර න්‍යාසයකි"
            )
          )
        )
      ),

      // Page 50
      SanduPdfPageItem(
        pageNumber = 50,
        unitNumber = 29,
        unitTitleSinhala = "29 න්‍යාස එකතු කිරීම, අඩු කිරීම සහ නිඛිලයකින් ගුණ කිරීම",
        isAnswerPage = false,
        pageHeader = "Sandu Theory • 29 න්‍යාස කර්ම",
        pageSections = listOf(
          SanduPdfSection(
            heading = "න්‍යාස එකතු කිරීම හා අඩු කිරීම",
            type = SanduSectionType.THEORY,
            items = listOf(
              "මෙහිදී න්‍යාසවල ගණය සමාන විය යුතුය.",
              "උදා: [2 3; 4 1] + [0 1; 5 -3] = [2 4; 9 -2]",
              "අභ්‍යාස 2: i. [1 2; 4 5] + [3 1; 0 1] = [4 3; 4 6]",
              "ii. [3 2; 1 1] + [1 2; 3 2] = [4 4; 4 3]",
              "iii. [-2 3; 5 -7] + [-1 3; 2 1] = [-3 6; 7 -6]"
            )
          ),
          SanduPdfSection(
            heading = "න්‍යාසයක් නිඛිලයකින් ගුණ කිරීම (අභ්‍යාස : 3)",
            type = SanduSectionType.WORKED_EXAMPLE,
            items = listOf(
              "උදා: 2 × [1 -2; 3 0] = [2 -4; 6 0]",
              "i. 2 × [1 0; -2 4] = [2 0; -4 8]",
              "ii. 3 × [4 2; 3 1] = [12 6; 9 3]",
              "iii. 5 × [-2 0; 4 -3] = [-10 0; 20 -15]",
              "iv. 2 × [-1 -2; 0 4] = [-2 -4; 0 8]"
            )
          )
        )
      )
    )
  }
}
