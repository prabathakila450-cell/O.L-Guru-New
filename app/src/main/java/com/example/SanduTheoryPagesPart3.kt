package com.example

/**
 * Sandu Theory 100-Pages PDF Content - Part 3 (Pages 51 to 77)
 * Covers Units 29 to 42
 */
object SanduTheoryPagesPart3 {

  val pages: List<SanduPdfPageItem> by lazy {
    listOf(
      // Page 51
      SanduPdfPageItem(
        pageNumber = 51,
        unitNumber = 29,
        unitTitleSinhala = "29 න්‍යාස (සමගාමී සමීකරණ හා ගැටලු විසඳීම)",
        isAnswerPage = false,
        pageHeader = "Sandu Theory • 29 න්‍යාස ගැටලු විසඳීම",
        pageSections = listOf(
          SanduPdfSection(
            heading = "අභ්‍යාස : 4",
            type = SanduSectionType.WORKED_EXAMPLE,
            items = listOf(
              "01. [1 2; 3 1] + [x 13; 0 3] = [4 y] -> x = 18, y = 1 (න්‍යාස සමීකරණ විසඳුම්)",
              "02. 2[-2 x; 0 3] - [4 1; 3 -1] = [-8 1; -3 y] -> x = 0, y = 3",
              "03. අමල්: අර්තාපල් 2kg + සීනි 3kg = රු. 400 | බිමල්: අර්තාපල් 4kg + සීනි 1kg = රු. 300\n  i. න්‍යාස ආකාරය: [2 3; 4 1] [x; y] = [400; 300]\n  ii. සමීකරණ: 2x + 3y = 400 සහ 4x + y = 300\n  iii. විසඳුම: අර්තාපල් 1kg = රු. 50, සීනි 1kg = රු. 100",
              "04. පැන්සල් හා පෑන්: නිමේෂා (A වෙළඳසැල) = 15×3 + 20×12 = රු. 285 | සුමේධා (B වෙළඳසැල) = 25×4 + 20×10 = රු. 300"
            )
          )
        )
      ),

      // Page 52
      SanduPdfPageItem(
        pageNumber = 52,
        unitNumber = 30,
        unitTitleSinhala = "30 සරල දාරය හා කවකටුව භාවිතයෙන් මූලික පථ හතර නිර්මාණය",
        isAnswerPage = false,
        pageHeader = "Sandu Theory • 30 මූලික පථ 4 (පථ 1 & 2)",
        pageSections = listOf(
          SanduPdfSection(
            heading = "මූලික පථ 04 කි (ජ්‍යාමිතික නිර්වචන)",
            type = SanduSectionType.THEORY,
            items = listOf(
              "01) අචල ලක්ෂ්‍යයකට සම දුරින් චලනය වන විචල්‍ය ලක්ෂ්‍යයක හෝ ලක්ෂ්‍ය සමූහයක ගමන් මාර්ගය -> වෘත්තයකි.",
              "02) අචල ලක්ෂ්‍ය දෙකකට සමදුරින් චලනය වන විචල්‍ය ලක්ෂ්‍යයක හෝ ලක්ෂ්‍ය සමූහයක ගමන් මාර්ගය (පථය) -> එම ලක්ෂ්‍ය දෙක යා කරන රේඛාවේ ලම්භ සමච්ඡේදකයයි."
            )
          )
        )
      ),

      // Page 53
      SanduPdfPageItem(
        pageNumber = 53,
        unitNumber = 30,
        unitTitleSinhala = "30 මූලික පථ හතර (පථ 3 & 4 සහ අභ්‍යාස 1)",
        isAnswerPage = false,
        pageHeader = "Sandu Theory • 30 මූලික පථ (පථ 3 & 4)",
        pageSections = listOf(
          SanduPdfSection(
            heading = "පථ 3 සහ පථ 4",
            type = SanduSectionType.THEORY,
            items = listOf(
              "03) රේඛාවකට සමදුරින් ගමන් ගන්නා විචල්‍ය ලක්ෂ්‍යයක පථය -> එම රේඛාවට දෙපසින් වූ සමාන්තර රේඛා දෙකකි.",
              "04) සමාන්තර නොවන සරල රේඛා දෙකකට සම දුරින් ගමන් ගන්නා විචල්‍ය ලක්ෂ්‍යයක පථය -> එම රේඛා දෙක හමුවීමෙන් සෑදෙන කෝණයේ කෝණ සමච්ඡේදකයයි."
            )
          ),
          SanduPdfSection(
            heading = "අභ්‍යාස : 1",
            type = SanduSectionType.EXERCISE,
            items = listOf(
              "01. OA හා OB රේඛා දෙකට සමදුරින් ගමන් ගන්නා පථය -> ∠AOB කෝණ සමච්ඡේදකය නිර්මාණය කිරීම.",
              "02. PQRS සෘජුකෝණාස්‍රයේ P සිට 10m දුරින් (වෘත්ත චාපය) සහ PS, PQ මායිම් දෙකට සමදුරින් (කෝණ සමච්ඡේදකය) ඡේදනය වන ලක්ෂ්‍යය Y ලකුණු කිරීම."
            )
          )
        )
      ),

      // Page 54
      SanduPdfPageItem(
        pageNumber = 54,
        unitNumber = 31,
        unitTitleSinhala = "30 පථ අභ්‍යාස & 31 දත්ත වර්ග හා සාමූහිත සංඛ්‍යාත ව්‍යාප්තිය",
        isAnswerPage = false,
        pageHeader = "Sandu Theory • 30 පථ & 31 දත්ත වර්ග",
        pageSections = listOf(
          SanduPdfSection(
            heading = "30 පථ ප්‍රායෝගික ගැටලු (ළිඳ කැණීම, වැට ඉදිකිරීම)",
            type = SanduSectionType.EXERCISE,
            items = listOf(
              "03. AP, AQ මායිම් දෙකට සමදුරින් (කෝණ සමච්ඡේදකය) සහ A හා Q ට සමදුරින් (AQ හි ලම්භ සමච්ඡේදකය) ඡේදන ලක්ෂ්‍යය ළිඳ කැණීමට සුදුසු ස්ථානයයි.",
              "04. AB සරල රේඛීය මාර්ගයට 3m දුරින් සමාන්තර රේඛා පථය.",
              "05. AB සිට 2cm සහ D සිට 4cm දුරින් P ලක්ෂ්‍යය නිර්මාණය."
            )
          ),
          SanduPdfSection(
            heading = "31 සන්තතික හා විවික්ත දත්ත",
            type = SanduSectionType.THEORY,
            items = listOf(
              "⭐ සන්තතික දත්ත (මිනිය හැකි): බල්බයක ආයු කාලය (ii), රූපවාහිනී නරඹන කාලය (iv), මේසයක දිග (v), ළිඳක ගැඹුර (viii), මිනිසෙකුගේ ස්කන්ධය (x).",
              "⭐ විවික්ත දත්ත (ගිණිය හැකි): පවුල් ගණන (i), දුරකථන ඇමතුම් ගණන (iii), පෑන් ගණන (vi), විෂයන් ගණන (vii), සාමාජිකයන් ගණන (ix)."
            )
          )
        )
      ),

      // Page 55
      SanduPdfPageItem(
        pageNumber = 55,
        unitNumber = 31,
        unitTitleSinhala = "31 සාමූහිත සංඛ්‍යාත ව්‍යාප්තිය (පන්ති ප්‍රාන්තර & මධ්‍ය අගය)",
        isAnswerPage = false,
        pageHeader = "Sandu Theory • 31 පන්ති ප්‍රාන්තර",
        pageSections = listOf(
          SanduPdfSection(
            heading = "පන්ති ප්‍රාන්තරයක පහළ සීමාව, ඉහළ සීමාව හා මධ්‍ය අගය",
            type = SanduSectionType.THEORY,
            items = listOf(
              "දත්ත සමූහයක් කාණ්ඩ කර දැක්වීමේදී එය පන්ති ප්‍රාන්තරයක් ලෙස හඳුන්වයි (උදා: 5 - 10 හි 5 පහළ සීමාව, 10 ඉහළ සීමාව).",
              "⭐ මධ්‍ය අගය = (පහළ සීමාව + ඉහළ සීමාව) / 2",
              "i. 8 - 12 පන්ති ප්‍රාන්තරය: (8 + 12)/2 = 10",
              "ii. 5 - 10 පන්ති ප්‍රාන්තරය: (5 + 10)/2 = 7.5",
              "අභ්‍යාස 2:\n• 7 - 11 -> මධ්‍ය අගය = 9\n• 5 - 9 -> මධ්‍ය අගය = 7\n• 10 - 17 -> මධ්‍ය අගය = (10 + 17)/2 = 13.5"
            )
          )
        )
      ),

      // Page 56
      SanduPdfPageItem(
        pageNumber = 56,
        unitNumber = 32,
        unitTitleSinhala = "31 මධ්‍ය අගය වගුව & 32 දත්ත නිරූපණය (වට ප්‍රස්ථාර)",
        isAnswerPage = false,
        pageHeader = "Sandu Theory • 31 මධ්‍ය අගය & 32 වට ප්‍රස්ථාර",
        pageSections = listOf(
          SanduPdfSection(
            heading = "31 අභ්‍යාස : 3 (බර සංඛ්‍යාත වගුවේ මධ්‍ය අගය)",
            type = SanduSectionType.EXERCISE,
            items = listOf(
              "• 25 - 35 (f=3) -> මධ්‍ය අගය = 30",
              "• 35 - 45 (f=4) -> මධ්‍ය අගය = 40",
              "• 45 - 55 (f=5) -> මධ්‍ය අගය = 50",
              "• 55 - 65 (f=3) -> මධ්‍ය අගය = 60",
              "• 65 - 75 (f=2) -> මධ්‍ය අගය = 70"
            )
          ),
          SanduPdfSection(
            heading = "32 වට ප්‍රස්ථාර - කේන්ද්‍රික ඛණ්ඩ කෝණ ගණනය",
            type = SanduSectionType.WORKED_EXAMPLE,
            items = listOf(
              "මාසික වැටුප වියදම් කිරීම (මුළු මුදල රු. 48,000):\n• ආහාර (20,000) -> (20,000 / 48,000) × 360° = 150°\n• ගමන් වියදම් (10,000) -> (10,000 / 48,000) × 360° = 75°\n• ඇඳුම් (8,000) -> (8,000 / 48,000) × 360° = 60°\n• තැන්පත් (4,000) -> (4,000 / 48,000) × 360° = 30°\n• වෙනත් (6,000) -> (6,000 / 48,000) × 360° = 45°\n(කෝණවල එකතුව = 150 + 75 + 60 + 30 + 45 = 360°)"
            )
          )
        )
      ),

      // Page 57
      SanduPdfPageItem(
        pageNumber = 57,
        unitNumber = 32,
        unitTitleSinhala = "32 දත්ත නිරූපණය (වට ප්‍රස්ථාර අභ්‍යාස)",
        isAnswerPage = false,
        pageHeader = "Sandu Theory • 32 වට ප්‍රස්ථාර ගැටලු",
        pageSections = listOf(
          SanduPdfSection(
            heading = "අභ්‍යාස : 1 (සිනමා ශාලාවේ ටිකට්පත් අලෙවිය)",
            type = SanduSectionType.EXERCISE,
            items = listOf(
              "i. රු. 200 ටිකට්පත් අලෙවිය දැක්වෙන කේන්ද්‍ර කෝණය = 360° - (120° + 45° + 45° ආදර්ශ) = 150°",
              "ii. රු. 200 ටිකට්පත් 60 ක් අලෙවි වී ඇත්නම් (150° = 60):\n  අලෙවි වූ මුළු ටිකට්පත් ගණන (360°) = (60 / 150) × 360 = 144",
              "iii. හිමිකරු ලැබූ මුළු ආදායම = රු. 28,800"
            )
          )
        )
      ),

      // Page 58
      SanduPdfPageItem(
        pageNumber = 58,
        unitNumber = 33,
        unitTitleSinhala = "33 දත්ත අර්ථකථනය - මධ්‍යන්‍යය (x̄ = Σfx / Σf)",
        isAnswerPage = false,
        pageHeader = "Sandu Theory • 33 මධ්‍යන්‍යය ගණනය",
        pageSections = listOf(
          SanduPdfSection(
            heading = "මධ්‍යන්‍යය ගණනය කිරීමේ සූත්‍රය & ආදර්ශ වගුව",
            type = SanduSectionType.THEORY,
            items = listOf(
              "⭐ මධ්‍යන්‍යය x̄ = Σfx / Σf",
              "උදා: ලකුණු (0-10: x=5, f=8 -> fx=40) | (10-20: x=15, f=10 -> fx=150) | (20-30: x=25, f=14 -> fx=350) | (30-40: x=35, f=12 -> fx=420) | (40-50: x=45, f=6 -> fx=270)\n  Σf = 50, Σfx = 1230\n  මධ්‍යන්‍යය = 1230 / 50 = 24.6 ලකුණු"
            )
          ),
          SanduPdfSection(
            heading = "01. මුහුදු වෙරළේ සිප්පිකටු මධ්‍යන්‍යය",
            type = SanduSectionType.EXERCISE,
            items = listOf(
              "පන්ති: 0-6 (f=3, x=3), 7-13 (f=7, x=10), 14-20 (f=11, x=17), 21-27 (f=14, x=24), 28-34 (f=12, x=31), 35-41 (f=13, x=38)\n  Σf = 60, Σfx = 1468\n  මධ්‍යන්‍යය = 1468 / 60 = 24.47 සිප්පිකටු"
            )
          )
        )
      ),

      // Page 59
      SanduPdfPageItem(
        pageNumber = 59,
        unitNumber = 33,
        unitTitleSinhala = "33 දත්ත අර්ථකථනය (මාත පන්තිය & මධ්‍යන්‍යය ගැටලු)",
        isAnswerPage = false,
        pageHeader = "Sandu Theory • 33 මාතය හා මධ්‍යන්‍යය",
        pageSections = listOf(
          SanduPdfSection(
            heading = "02. ගස්ලබු අලෙවි වගුව (ගොවීන් 30 දෙනාගේ)",
            type = SanduSectionType.WORKED_EXAMPLE,
            items = listOf(
              "i. මාත පන්තිය = උපරිම සංඛ්‍යාතය (8) ඇති පන්තිය -> 15 - 19",
              "ii & iii. මධ්‍ය අගය x හා fx තීර:\n  0-4: x=2, f=2, fx=4 | 5-9: x=7, f=3, fx=21 | 10-14: x=12, f=5, fx=60 | 15-19: x=17, f=8, fx=136 | 20-24: x=22, f=5, fx=110 | 25-29: x=27, f=3, fx=81 | 30-34: x=32, f=4, fx=128\n  Σf = 30, Σfx = 540",
              "iv. මධ්‍යන්‍ය ගස්ලබු ප්‍රමාණය = 540 / 30 = 18 kg",
              "v. 1kg රු. 50 නම් සතියකට (දින 7) මුදල = 50 × 18 × 7 = රු. 6,300"
            )
          )
        )
      ),

      // Page 60
      SanduPdfPageItem(
        pageNumber = 60,
        unitNumber = 34,
        unitTitleSinhala = "34 දත්ත නිරූපණය (පන්ති සීමා, පන්ති මායිම්, ජාල රේඛය)",
        isAnswerPage = false,
        pageHeader = "Sandu Theory • 34 පන්ති මායිම් & ජාල රේඛය",
        pageSections = listOf(
          SanduPdfSection(
            heading = "01. පන්ති මායිම් සෙවීම",
            type = SanduSectionType.THEORY,
            items = listOf(
              "i. 21 - 30 පන්ති ප්‍රාන්තරයේ: ඉහළ සීමාව = 30, ඉහළ මායිම = 30.5",
              "ii. 15 - 19 පන්ති ප්‍රාන්තරයේ: පහළ සීමාව = 15, පහළ මායිම = 14.5",
              "iii. 151 - 175 පන්ති ප්‍රාන්තරයේ: පහළ මායිම = 150.5, ඉහළ මායිම = 175.5"
            )
          ),
          SanduPdfSection(
            heading = "02. සන්තතික සංඛ්‍යාත ව්‍යාප්තියක ජාල රේඛය ඇඳීම",
            type = SanduSectionType.THEORY,
            items = listOf(
              "පන්ති: 0-10 (f=2), 10-20 (f=5), 20-30 (f=7), 30-40 (f=10), 40-50 (f=6), 50-60 (f=5)\n  තිරස් අක්ෂයේ පන්ති ප්‍රාන්තර සහ සිරස් අක්ෂයේ සංඛ්‍යාතය දක්වා යාබද තීරු අඳිනු ලැබේ."
            )
          )
        )
      ),

      // Page 61
      SanduPdfPageItem(
        pageNumber = 61,
        unitNumber = 34,
        unitTitleSinhala = "34 ජාල රේඛය ඇඳීම (පන්ති තරම සමාන හා අසමාන අවස්ථා)",
        isAnswerPage = false,
        pageHeader = "Sandu Theory • 34 ජාල රේඛය ඇඳීම",
        pageSections = listOf(
          SanduPdfSection(
            heading = "පන්ති සීමා සහිත වගුවක පන්ති මායිම් ලබාගැනීම",
            type = SanduSectionType.THEORY,
            items = listOf(
              "• 6 - 10 -> 5.5 - 10.5 (f=10)",
              "• 11 - 15 -> 10.5 - 15.5 (f=8)",
              "• 16 - 20 -> 15.5 - 20.5 (f=7)",
              "• 21 - 25 -> 20.5 - 25.5 (f=4)",
              "• 26 - 30 -> 25.5 - 30.5 (f=6)"
            )
          ),
          SanduPdfSection(
            heading = "පන්ති තරම අසමාන අවස්ථාවන්හි දී ජාල රේඛය",
            type = SanduSectionType.THEORY,
            items = listOf(
              "⭐ මූලධර්මය: පන්ති තරම අසමාන විට තීරයේ උස = සංඛ්‍යාතය / (පන්ති තරම / කුඩාම පන්ති තරම)",
              "• 0 - 10 (f=1, තරම 10) -> උස = 1",
              "• 10 - 20 (f=3, තරම 10) -> උස = 3",
              "• 20 - 40 (f=4, තරම 20) -> උස = 4 ÷ 2 = 2",
              "• 40 - 50 (f=5, තරම 10) -> උස = 5",
              "• 50 - 80 (f=9, තරම 30) -> උස = 9 ÷ 3 = 3",
              "• 80 - 100 (f=10, තරම 20) -> උස = 10 ÷ 2 = 5"
            )
          )
        )
      ),

      // Page 62
      SanduPdfPageItem(
        pageNumber = 62,
        unitNumber = 35,
        unitTitleSinhala = "34 ජාල රේඛය & 35 දත්ත නිරූපණය (සංඛ්‍යාත බහු අස්‍රය)",
        isAnswerPage = false,
        pageHeader = "Sandu Theory • 35 සංඛ්‍යාත බහු අස්‍රය",
        pageSections = listOf(
          SanduPdfSection(
            heading = "04. අසමාන පන්ති තරම සහිත ජාල රේඛය",
            type = SanduSectionType.WORKED_EXAMPLE,
            items = listOf(
              "තීරයේ උසවල්: (0-10 -> 1), (10-20 -> 3), (20-40 -> 2), (40-50 -> 5), (50-80 -> 3), (80-100 -> 5)"
            )
          ),
          SanduPdfSection(
            heading = "35 සංඛ්‍යාත බහු අස්‍රය ඇඳීම",
            type = SanduSectionType.THEORY,
            items = listOf(
              "ජාල රේඛයේ එක් එක් තීරුවේ ඉහළ මැද ලක්ෂ්‍ය සරල රේඛා ඛණ්ඩ මගින් යා කිරීමෙන් සංඛ්‍යාත බහු අස්‍රය ලැබේ. ආරම්භක හා අවසාන තීරුවලට යාබද ශුන්‍ය සංඛ්‍යාත සහිත මනඃකල්පිත පන්තිවල මධ්‍ය ලක්ෂ්‍ය වෙත බහු අස්‍රය පාදම හා සම්බන්ධ කරනු ලැබේ."
            )
          )
        )
      ),

      // Page 63
      SanduPdfPageItem(
        pageNumber = 63,
        unitNumber = 35,
        unitTitleSinhala = "35 සංඛ්‍යාත බහු අස්‍රය (මධ්‍ය අගය හා පටිපාටිගත යුගල)",
        isAnswerPage = false,
        pageHeader = "Sandu Theory • 35 පටිපාටිගත යුගල",
        pageSections = listOf(
          SanduPdfSection(
            heading = "02. ගණිත ලකුණු සඳහා සංඛ්‍යාත බහු අස්‍රය",
            type = SanduSectionType.WORKED_EXAMPLE,
            items = listOf(
              "• 0 - 10: මධ්‍ය අගය = 5, f = 3 -> යුගලය (5, 3)",
              "• 10 - 20: මධ්‍ය අගය = 15, f = 5 -> යුගලය (15, 5)",
              "• 20 - 30: මධ්‍ය අගය = 25, f = 10 -> යුගලය (25, 10)",
              "• 30 - 40: මධ්‍ය අගය = 35, f = 8 -> යුගලය (35, 8)",
              "• 40 - 50: මධ්‍ය අගය = 45, f = 10 -> යුගලය (45, 10)",
              "• 50 - 60: මධ්‍ය අගය = 55, f = 9 -> යුගලය (55, 9)"
            )
          )
        )
      ),

      // Page 64
      SanduPdfPageItem(
        pageNumber = 64,
        unitNumber = 35,
        unitTitleSinhala = "35 සංචාරකයින්ගේ ස්කන්ධය (ජාල රේඛය & සංඛ්‍යාත බහු අස්‍රය)",
        isAnswerPage = false,
        pageHeader = "Sandu Theory • 35 විභාග ගැටලුව",
        pageSections = listOf(
          SanduPdfSection(
            heading = "03. අසම්පූර්ණ ජාල රේඛය ඇසුරින් ප්‍රශ්න",
            type = SanduSectionType.EXERCISE,
            items = listOf(
              "i. ස්කන්ධය 50kg ට අඩු සංචාරකයින් ගණන = 5 + 15 = 20",
              "ii. සංචාරකයින් ගණන 15 ක් දක්වා ඇත්තේ -> 45 - 50 පන්ති ප්‍රාන්තරය තුළය.",
              "iii. 50 - 65 පන්ති ප්‍රාන්තරයේ (තරම 15) සංචාරකයින් 30 ක් නම්: තීරයේ උස = 30 ÷ 3 = 10",
              "iv. රැස්කළ මුළු සංචාරකයින් ගණන = 50",
              "v. ජාල රේඛය ඇසුරින් සංඛ්‍යාත බහු අස්‍රය සම්පූර්ණ කිරීම."
            )
          )
        )
      ),

      // Page 65
      SanduPdfPageItem(
        pageNumber = 65,
        unitNumber = 36,
        unitTitleSinhala = "36 දත්ත නිරූපණය (සමුච්චිත සංඛ්‍යාත වක්‍රය)",
        isAnswerPage = false,
        pageHeader = "Sandu Theory • 36 සමුච්චිත සංඛ්‍යාත වක්‍රය",
        pageSections = listOf(
          SanduPdfSection(
            heading = "සමුච්චිත සංඛ්‍යාත වගුව & ප්‍රස්තාරික නිරූපණය",
            type = SanduSectionType.THEORY,
            items = listOf(
              "⭐ ලක්ෂ්‍ය ලකුණු කිරීමේ රීතිය:\n• x ඛණ්ඩාංකය = පන්ති ප්‍රාන්තරයේ ඉහළ සීමාව (හෝ ඉහළ මායිම)\n• y ඛණ්ඩාංකය = අදාළ සමුච්චිත සංඛ්‍යාතය",
              "වගුව සම්පූර්ණ කිරීම:\n• 5 - 10: f = 8, F = 8 -> (10, 8)\n• 10 - 15: f = 12, F = 20 -> (15, 20)\n• 15 - 20: f = 15, F = 35 -> (20, 35)\n• 20 - 25: f = 16, F = 51 -> (25, 51)\n• 25 - 30: f = 8, F = 59 -> (30, 59)\n• 30 - 35: f = 5, F = 64 -> (35, 64)"
            )
          )
        )
      ),

      // Page 66
      SanduPdfPageItem(
        pageNumber = 66,
        unitNumber = 37,
        unitTitleSinhala = "37 දත්ත නිරූපණය (චතුර්ථක හා අන්තර්චතුර්ථක පරාසය)",
        isAnswerPage = false,
        pageHeader = "Sandu Theory • 37 චතුර්ථක ගණනය",
        pageSections = listOf(
          SanduPdfSection(
            heading = "චතුර්ථක Q1, Q2, Q3 සහ අන්තර්චතුර්ථක පරාසය",
            type = SanduSectionType.THEORY,
            items = listOf(
              "දත්ත 15 ක් සඳහා (n = 15):\n• මධ්‍යස්ථයේ පිහිටීම Q2 = 1/2 (n + 1) = 8 වන අගය -> Q2 = 8\n• පළමු චතුර්ථකයේ පිහිටීම Q1 = 1/4 (n + 1) = 4 වන අගය -> Q1 = 6\n• තෙවන චතුර්ථකයේ පිහිටීම Q3 = 3/4 (n + 1) = 12 වන අගය -> Q3 = 15\n⭐ අන්තර්චතුර්ථක පරාසය = Q3 - Q1 = 15 - 6 = 9",
              "01. 30, 35, 38, 43, 46 හි මධ්‍යස්ථ වයස = 38",
              "02. දත්ත 23 ක් ඇති විට Q1 පිහිටීම = (23+1)/4 = 6 වන අගය = 24",
              "03. දින 7 ක සේවකයන්: 1, 2, 2, 4, 5, 6, 7 හි Q3 = 6 වන අගය = 6",
              "04. සහල් අලෙවිය දින 15: මධ්‍යස්ථය = 82 kg, අන්තර්චතුර්ථක පරාසය = 88 - 78 = 10"
            )
          )
        )
      ),

      // Page 67
      SanduPdfPageItem(
        pageNumber = 67,
        unitNumber = 38,
        unitTitleSinhala = "38 සමුච්චිත සංඛ්‍යාත වක්‍රය (අසමූහිත හා සමූහිත දත්ත සඳහා)",
        isAnswerPage = false,
        pageHeader = "Sandu Theory • 38 සමුච්චිත සංඛ්‍යාත වක්‍රය",
        pageSections = listOf(
          SanduPdfSection(
            heading = "වක්‍රයෙන් චතුර්ථක සෙවීම",
            type = SanduSectionType.THEORY,
            items = listOf(
              "y අක්ෂයේ:\n• Q1 පිහිටීම = n/4\n• මධ්‍යස්ථය Q2 පිහිටීම = n/2\n• Q3 පිහිටීම = 3n/4\n⭐ අන්තර්චතුර්ථක පරාසය = Q3 - Q1",
              "01. දී ඇති වක්‍රයෙන්: Q1 = 15, Q3 = 19 -> අන්තර්චතුර්ථක පරාසය = 19 - 15 = 4"
            )
          )
        )
      ),

      // Page 68
      SanduPdfPageItem(
        pageNumber = 68,
        unitNumber = 38,
        unitTitleSinhala = "38 සමුච්චිත සංඛ්‍යාත වක්‍රය (විභාග ගැටලු)",
        isAnswerPage = false,
        pageHeader = "Sandu Theory • 38 විභාග ගැටලු",
        pageSections = listOf(
          SanduPdfSection(
            heading = "02. සිසුන් 60 දෙනෙකුගේ විභාග ලකුණු වක්‍රය",
            type = SanduSectionType.WORKED_EXAMPLE,
            items = listOf(
              "i. මධ්‍යස්ථය (n/2 = 30 වන අගය) = ලකුණු 40",
              "ii. ඉහළම ලකුණු ලැබූ 25% ට ත්‍යාග (60 - 15 = 45 වන සිසුවාගේ ලකුණ) = ලකුණු 50",
              "iii. 50% අසමත් නම් සමත් වීමේ ලකුණ = මධ්‍යස්ථ ලකුණ = ලකුණු 40",
              "03. වක්‍රයෙන් මධ්‍යස්ථය සෙවීම = 10"
            )
          )
        )
      ),

      // Page 69
      SanduPdfPageItem(
        pageNumber = 69,
        unitNumber = 39,
        unitTitleSinhala = "39 කුලක අංකනය (කුලක දැක්වීමේ ක්‍රම 4)",
        isAnswerPage = false,
        pageHeader = "Sandu Theory • 39 කුලක අංකනය",
        pageSections = listOf(
          SanduPdfSection(
            heading = "කුලක දැක්වීමේ ක්‍රම 4",
            type = SanduSectionType.THEORY,
            items = listOf(
              "1. විස්තර කිරීමක් ලෙස: A = {1 ත් 10 ත් අතර ප්‍රථමක සංඛ්‍යා}",
              "2. අවයව ලැයිස්තුගත කිරීමක් ලෙස: A = {3, 5, 7, 9} (හෝ ප්‍රථමක නම් {2, 3, 5, 7})",
              "3. වෙන් රූපයක් ඇසුරෙන්",
              "4. ජනන ස්වරූපයෙන්: A = {x : x යනු ඔත්තේ සංඛ්‍යාවකි, 1 < x < 10}"
            )
          ),
          SanduPdfSection(
            heading = "අභ්‍යාස : 1 & 2",
            type = SanduSectionType.EXERCISE,
            items = listOf(
              "01. i. {5} | ii. {x : x යනු 10 හි ගුණාකාර, 0 < x ≤ 50} | iv. {6, 12, 18}",
              "02. A = {'ක', 'ත', 'ර', 'ග', 'ම'}",
              "03. දාදු කැටයේ ප්‍රතිඵල = {1, 2, 3, 4, 5, 6}",
              "04. පෙරදිග සංගීතයේ ස්වර = {'ස', 'රි', 'ග', 'ම', 'ප', 'ධ', 'නි'}",
              "05. 10 < x < 20 ඉරට්ටේ සංඛ්‍යා = {12, 14, 16, 18}"
            )
          )
        )
      ),

      // Page 70
      SanduPdfPageItem(
        pageNumber = 70,
        unitNumber = 40,
        unitTitleSinhala = "40 කුලක ආශ්‍රිත ගැටළු (වෙන් රූප)",
        isAnswerPage = false,
        pageHeader = "Sandu Theory • 40 කුලක ආශ්‍රිත ගැටළු",
        pageSections = listOf(
          SanduPdfSection(
            heading = "01 & 02 පෙදෙස් අඳුරු කිරීම හා අංකනය",
            type = SanduSectionType.THEORY,
            items = listOf(
              "• (i) P ∩ Q -> P හා Q හි පොදු පෙදෙස",
              "• (ii) P ∪ Q -> P හා Q සම්පූර්ණ එක්සත් පෙදෙස",
              "• (iii) Q ∩ P' -> Q ට පමණක් අයත් පෙදෙස (Q - P)"
            )
          ),
          SanduPdfSection(
            heading = "03. වෙන් රූප ගණනය",
            type = SanduSectionType.WORKED_EXAMPLE,
            items = listOf(
              "දත්ත: n(A) = 10, n(B) = 13, n(A ∩ B) = x, n(A ∪ B) = 18",
              "i. A ට පමණක් අයිති අවයව ගණන = 10 - x",
              "ii. B ට පමණක් අයිති අවයව ගණන = 13 - x",
              "iii. n(A ∪ B) = (10 - x) + x + (13 - x) = 23 - x = 18 -> x = 5"
            )
          )
        )
      ),

      // Page 71
      SanduPdfPageItem(
        pageNumber = 71,
        unitNumber = 41,
        unitTitleSinhala = "41 සිද්ධි (සරල සිද්ධි, සංයුක්ත සිද්ධි)",
        isAnswerPage = false,
        pageHeader = "Sandu Theory • 41 සරල හා සංයුක්ත සිද්ධි",
        pageSections = listOf(
          SanduPdfSection(
            heading = "සරල සිද්ධි හා සංයුක්ත සිද්ධි හඳුනාගැනීම",
            type = SanduSectionType.THEORY,
            items = listOf(
              "i. සුදු පබළු 1 ක් ඇති විට සුදු පබළුවක් ලැබීම -> සරල සිද්ධියකි",
              "ii. පන්තියක ශිෂ්‍යයෙකු ඉංග්‍රීසි විෂය හැදෑරීම -> සරල සිද්ධියකි",
              "iii. රතු, නිල්, කොළ තැටිය කැරකවූ විට රතු ලැබීම -> සරල සිද්ධියකි",
              "iv. දාදු කැටයක් දැමූ විට:\n  a. 1 ලැබීම -> සරල සිද්ධියකි\n  b. ඉරට්ටේ සංඛ්‍යාවක් {2, 4, 6} ලැබීම -> සංයුක්ත සිද්ධියකි\n  c. 5 ලැබීම -> සරල සිද්ධියකි\n  d. 1 හෝ 6 ලැබීම -> සංයුක්ත සිද්ධියකි"
            )
          ),
          SanduPdfSection(
            heading = "02. මේස් ජෝඩු 8 ක සම්භාවිතා",
            type = SanduSectionType.EXERCISE,
            items = listOf(
              "සුදු 3, නිල් 2, කහ 1, කළු 2 (මුළු 8):\n  i. කළු පාට වීම = 2/8 = 1/4\n  ii. සුදු පාට වීම = 3/8\n  iii. නිල් පාට වීම = 2/8 = 1/4\n  iv. නිල් හෝ සුදු වීම = (2 + 3)/8 = 5/8\n  v. කළු හෝ සුදු වීම = (2 + 3)/8 = 5/8"
            )
          )
        )
      ),

      // Page 72
      SanduPdfPageItem(
        pageNumber = 72,
        unitNumber = 42,
        unitTitleSinhala = "42 සසම්භාවිත පරීක්ෂණ (ස්වායත්ත සිද්ධි ඇතුළත්) නියැදි අවකාශය",
        isAnswerPage = false,
        pageHeader = "Sandu Theory • 42 නියැදි අවකාශය",
        pageSections = listOf(
          SanduPdfSection(
            heading = "01. සසම්භාවිත පරීක්ෂණ හඳුනාගැනීම",
            type = SanduSectionType.THEORY,
            items = listOf(
              "1. සමබර කාසියක් උඩ දැමීම -> සසම්භාවිත පරීක්ෂණයකි [✓]",
              "2. දාදු කැටයක් උඩ දැමූ විට අංකය නිරීක්ෂණය -> සසම්භාවිත පරීක්ෂණයකි [✓]",
              "3. එක් එක් දිනයේ ඉර පායන දිශාව නිරීක්ෂණය -> සසම්භාවිත නොවේ [✗]",
              "4. සර්වසම රතු බෝල ඇති පෙට්ටියකින් බෝලයක් ගැනීම -> සසම්භාවිත නොවේ (ප්‍රතිඵලය නිශ්චිතයි) [✗] (හෝ අහඹු නම් [✓])",
              "5. අමු අඹ හා ඉදුණු අඹ ඇති පෙට්ටියකින් අඹයක් ගැනීම -> සසම්භාවිත වේ [✓]"
            )
          ),
          SanduPdfSection(
            heading = "02. නියැදි අවකාශය S යා කිරීම",
            type = SanduSectionType.EXERCISE,
            items = listOf(
              "1. දාදු කැටය -> {1, 2, 3, 4, 5, 6}",
              "2. 'මහනුවර' අකුරු -> {'ම', 'හ', 'නු', 'ව', 'ර'}",
              "3. රතු පෑන් 3 හා නිල් පෑන් 2 -> {රතු₁, රතු₂, රතු₃, නිල්₁, නිල්₂}",
              "4. 1 ත් 10 ත් ප්‍රථමක සංඛ්‍යා -> {2, 3, 5, 7}",
              "5. දොඩම් ටොෆි 3 හා අන්නාසි 1 -> {දොඩම්₁, දොඩම්₂, දොඩම්₃, අන්නාසි}"
            )
          )
        )
      ),

      // Page 73
      SanduPdfPageItem(
        pageNumber = 73,
        unitNumber = 42,
        unitTitleSinhala = "42 නියැදි අවකාශය සහ සිද්ධි",
        isAnswerPage = false,
        pageHeader = "Sandu Theory • 42 සිද්ධි වර්ගීකරණය",
        pageSections = listOf(
          SanduPdfSection(
            heading = "නියැදි අවකාශයේ උපකුලකයක් ලෙස සිද්ධියක්",
            type = SanduSectionType.THEORY,
            items = listOf(
              "S = {1, 2, 3} හි උපකුලක: {1}, {2}, {3}, {1, 2}, {1, 3}, {2, 3}, {1, 2, 3}",
              "• එක් ප්‍රතිඵලයක් පමණක් ලබන සිද්ධි -> සරල සිද්ධි වේ.",
              "• ප්‍රතිඵල එකකට වඩා අඩංගු සිද්ධි -> සංයුක්ත සිද්ධි වේ.",
              "04. යා කිරීම:\n  {5} -> සරල සිද්ධි\n  {a, b} -> සංයුක්ත සිද්ධි\n  {c} -> සරල සිද්ධි\n  {2, 3, 5, 7} -> සංයුක්ත සිද්ධි\n  {රතු, නිල්} -> සංයුක්ත සිද්ධි\n  {අඹ} -> සරල සිද්ධි"
            )
          )
        )
      ),

      // Page 74
      SanduPdfPageItem(
        pageNumber = 74,
        unitNumber = 42,
        unitTitleSinhala = "42 සම්භාවිතාව (P(A) = n(A) / n(S))",
        isAnswerPage = false,
        pageHeader = "Sandu Theory • 42 සම්භාවිතා සූත්‍රය",
        pageSections = listOf(
          SanduPdfSection(
            heading = "සමයේ භව්‍ය ප්‍රතිඵල සහිත සම්භාවිතාව",
            type = SanduSectionType.THEORY,
            items = listOf(
              "⭐ සම්භාවිතාව P(A) = සිද්ධියේ අවයව ගණන n(A) / නියැදි අවකාශයේ අවයව ගණන n(S)",
              "05. සමයේ භව්‍ය ප්‍රතිඵල සහිත වේද?\n  1. සමබර දාදු කැටය -> ඔව් [✓]\n  2. එකම වර්ගයේ පෑන් -> ඔව් [✓]\n  3. වෙනස් පරිමා සහිත බෝල -> නැත [✗]",
              "06. රතු පබළු 3 ක් හා නිල් පබළු 2 ක් ඇති විට රතු ලැබීමේ සම්භාවිතාව = 3/5",
              "දාදු කැටය: A = ඉරට්ටේ {2, 4, 6}, B = ප්‍රථමක {2, 3, 5}\n  A ∩ B = {2}, A ∪ B = {2, 3, 4, 5, 6}"
            )
          )
        )
      ),

      // Page 75
      SanduPdfPageItem(
        pageNumber = 75,
        unitNumber = 42,
        unitTitleSinhala = "42 ස්වායත්ත සිද්ධි සහ කොටු දැල",
        isAnswerPage = false,
        pageHeader = "Sandu Theory • 42 ස්වායත්ත සිද්ධි",
        pageSections = listOf(
          SanduPdfSection(
            heading = "අන්‍යෝන්‍ය වශයෙන් බහිෂ්කාර සහ ස්වායත්ත සිද්ධි",
            type = SanduSectionType.THEORY,
            items = listOf(
              "• අන්‍යෝන්‍ය වශයෙන් බහිෂ්කාර සිද්ධි: A ∩ B = ∅ නම්, P(A ∪ B) = P(A) + P(B)",
              "⭐ ස්වායත්ත සිද්ධි: එක් සිද්ධියක් සිදුවීම අනෙක් සිද්ධියට බලපෑමක් නොකරයි නම්: P(A ∩ B) = P(A) × P(B)",
              "07. ස්වායත්ත වේද? නැද්ද?\n  1. දාදු කැටයක් හා කාසියක් -> ස්වායත්ත වේ [✓]\n  2. පෙට්ටි දෙකකින් පෑන් දෙකක් ගැනීම -> ස්වායත්ත වේ [✓]\n  3. කාඩ්පත් කට්ටලයකින් ප්‍රතිස්ථාපනයෙන් තොරව ගැනීම -> ස්වායත්ත නොවේ [✗]",
              "කාසිය හා දාදු කැටය එකවර දැමීමේදී නියැදි අවකාශය = 2 × 6 = 12 (කොටු දැලක නිරූපණය)"
            )
          )
        )
      ),

      // Page 76
      SanduPdfPageItem(
        pageNumber = 76,
        unitNumber = 42,
        unitTitleSinhala = "42 කොටු දැල, රුක් සටහන සහ සම්භාවිතා",
        isAnswerPage = false,
        pageHeader = "Sandu Theory • 42 රුක් සටහන",
        pageSections = listOf(
          SanduPdfSection(
            heading = "08. දාදු කැටය දෙවරක් දැමීම (කොටු දැල 6×6 = 36)",
            type = SanduSectionType.EXERCISE,
            items = listOf(
              "i. වාර දෙකෙහිම ඔත්තේ ලැබීම = (3 × 3) / 36 = 9/36 = 1/4",
              "ii. පළමුව ප්‍රථමක ලැබීම = (3 × 6) / 36 = 18/36 = 1/2",
              "iii. දෙවන වර වර්ග සංඛ්‍යාවක් (1, 4) ලැබීම = (6 × 2) / 36 = 12/36 = 1/3",
              "iv. එකතුව 5 වීම: (1,4), (2,3), (3,2), (4,1) -> 4/36 = 1/9",
              "v. එකතුව 5 ට වැඩි වීම = 26/36 = 13/18"
            )
          ),
          SanduPdfSection(
            heading = "10. රතු පෑන් 2 & නිල් පෑන් 3 රුක් සටහන (ප්‍රතිස්ථාපනය සහිතව)",
            type = SanduSectionType.WORKED_EXAMPLE,
            items = listOf(
              "i. a = 2/5 (රතු), b = 3/5 (නිල්), c = 2/5 (රතු), d = 3/5 (නිල්)",
              "ii. (ර, ර) = 2/5 × 2/5 = 4/25 | (ර, නි) = 2/5 × 3/5 = 6/25 | (නි, ර) = 3/5 × 2/5 = 6/25 | (නි, නි) = 3/5 × 3/5 = 9/25"
            )
          )
        )
      ),

      // Page 77
      SanduPdfPageItem(
        pageNumber = 77,
        unitNumber = 42,
        unitTitleSinhala = "42 රුක් සටහන් සහ කාටිසීය තල (රථ ගාලේ වාහන ගැටලුව)",
        isAnswerPage = false,
        pageHeader = "Sandu Theory • 42 කාටිසීය තලය හා සම්භාවිතාව",
        pageSections = listOf(
          SanduPdfSection(
            heading = "11. රථ ගාල ගැටලුව (මෝටර් රථ 4, යතුරුපැදි 5, මුළු 9)",
            type = SanduSectionType.WORKED_EXAMPLE,
            items = listOf(
              "ප්‍රතිස්ථාපනයෙන් තොරව වාහන 2 ක් පිටවීම (දෙවන වර ඉතිරි 8 කි):",
              "i. රුක් සටහන:\n• පළමු මෝටර් රථ (4/9) -> දෙවන මෝටර් රථ (3/8), යතුරුපැදි (5/8)\n• පළමු යතුරුපැදි (5/9) -> දෙවන මෝටර් රථ (4/8), යතුරුපැදි (4/8)",
              "ii. වාහන දෙකම එකම වර්ගයේ නොවීම = (4/9 × 5/8) + (5/9 × 4/8) = 20/72 + 20/72 = 40/72 = 5/9",
              "iii. වාහන 6 ක් පිරිමි අය පදවයි නම් කාටිසීය තලයෙන්: දෙකම පිරිමි අය පැදවීමේ සම්භාවිතාව = (6/9 × 5/8) = 30/72 = 5/12 (හෝ 30/63 ආදර්ශ)"
            )
          )
        )
      )
    )
  }
}
