package com.example

/**
 * G.C.E. O/L Commerce & Accounting (ව්‍යාපාර හා ගිණුම්කරණ අධ්‍යයනය)
 * 200 Batches of 10 Double Entries (ද්විත්ව සටහන් දහයේ කාණ්ඩ 200ක් - ප්‍රශ්න 2,000ක්)
 */

data class DoubleEntryBatchInfo(
  val batchNumber: Int,
  val title: String,
  val category: String,
  val challenges: List<DoubleEntryChallenge>
)

object CommerceDoubleEntryRepository {
  const val TOTAL_BATCHES = 200
  const val ITEMS_PER_BATCH = 10
  const val TOTAL_QUESTIONS = TOTAL_BATCHES * ITEMS_PER_BATCH

  // The 20 core accounting themes (10 batches per theme = 200 batches)
  private val themeTitles = listOf(
    "ව්‍යාපාර ආරම්භය සහ ප්‍රාග්ධන යෙදවීම් (Business Start & Capital)",
    "බැංකු ගිණුම්, තැන්පතු සහ ආපසු ගැනීම් (Bank Transactions & Cash)",
    "තොග ගැනුම් ගනුදෙනු - මුදලට සහ ණයට (Purchases: Cash & Credit)",
    "තොග විකුණුම් ගනුදෙනු - මුදලට සහ ණයට (Sales: Cash & Credit)",
    "ගැනුම් ආපසු / පිට ආපසු යැවීම් (Purchases Returns / Outwards)",
    "විකුණුම් ආපසු / ඇතුළට ආපසු ලැබීම් (Sales Returns / Inwards)",
    "මෙහෙයුම් වියදම් ගෙවීම් (Operating Expenses: Rent, Salaries, Bills)",
    "ව්‍යාපාර මෙහෙයුම් ආදායම් ලැබීම් (Operating Incomes: Rent, Commission)",
    "ස්ථාවර වත්කම් මුදලට මිලදී ගැනීම් (Fixed Assets Cash Purchases)",
    "ස්ථාවර වත්කම් ණයට මිලදී ගැනීම් (Fixed Assets Credit Purchases)",
    "ස්ථාවර වත්කම් මුදලට හා ණයට විකිණීම් (Fixed Asset Sales & Disposals)",
    "ණයහිමියන්ට ගෙවීම් සහ ලැබුණු වට්ටම් (Creditors & Discounts Received)",
    "ණයගැතියන්ගෙන් ලැබීම් සහ දුන් වට්ටම් (Debtors & Discounts Allowed)",
    "අයිතිකරුගේ මුදල් සහ භාණ්ඩ ගැනිලි (Drawings of Cash & Goods)",
    "බැංකු ණය, ණය ආපසු ගෙවීම් සහ පොලී (Bank Loans & Loan Interest)",
    "බැංකු අයිරා, බැංකු ගාස්තු සහ අයිරා පොලී (Overdrafts & Bank Charges)",
    "අයකරගත නොහැකි ණය සහ නැවත අයවීම් (Bad Debts & Recoveries)",
    "උපචිත (ගෙවිය යුතු) සහ පෙරගෙවුම් වියදම් (Accrued & Prepaid Expenses)",
    "උපචිත (ලැබිය යුතු) සහ පෙරලැබුණු ආදායම් (Accrued & Advance Incomes)",
    "සුළු මුදල්, අගරු චෙක්පත් සහ දෝෂ නිවැරදි කිරීම් (Petty Cash & Journal Adjustments)"
  )

  fun getBatchTitle(batchNumber: Int): String {
    val bNum = batchNumber.coerceIn(1, TOTAL_BATCHES)
    val themeIdx = (bNum - 1) / 10
    val subIdx = ((bNum - 1) % 10) + 1
    val baseTheme = themeTitles.getOrElse(themeIdx) { "ගිණුම්කරණ ද්විත්ව සටහන් පුහුණුව" }
    return "කාණ්ඩය $bNum: $baseTheme (කොටස $subIdx)"
  }

  fun getBatchCategory(batchNumber: Int): String {
    val bNum = batchNumber.coerceIn(1, TOTAL_BATCHES)
    val themeIdx = (bNum - 1) / 10
    return themeTitles.getOrElse(themeIdx) { "ද්විත්ව සටහන් පුහුණුව" }
  }

  // Pre-cached or generated on demand
  fun getBatch(batchNumber: Int): DoubleEntryBatchInfo {
    val bNum = batchNumber.coerceIn(1, TOTAL_BATCHES)
    val title = getBatchTitle(bNum)
    val category = getBatchCategory(bNum)
    val items = generateBatchItems(bNum)
    return DoubleEntryBatchInfo(
      batchNumber = bNum,
      title = title,
      category = category,
      challenges = items
    )
  }

  private val partyNames = listOf(
    "අමල්", "කමල්", "නිමල්", "සුනිල්", "නයන", "රොහාන්", "සමන්", "පියල්", 
    "ප්‍රියන්ත", "බන්දුල", "ජයන්ත", "අනුර", "සරත්", "තිළිණ", "කුමාර", "රුවන්",
    "නිශාන්ත", "කුෂාන්", "මහේෂ්", "ප්‍රසන්න", "දිලුම්", "අසංක", "මාලිංග", "සනත්",
    "ලක්ෂ්මන්", "කසුන්", "විරාජ්", "චාමර", "ධනුෂ්ක", "දිනේෂ්"
  )

  private val companyNames = listOf(
    "ලංකා ට්‍රේඩර්ස්", "සමන් එන්ටර්ප්‍රයිසස්", "සෙන්ට්‍රල් ස්ටෝර්ස්", "සිනර්ජි හෝල්ඩින්ග්ස්",
    "ABC සමාගම", "ජයලත් වෙළෙන්දෝ", "රත්න ස්ටෝර්ස්", "මැලිබන් ඒජන්සි", "කැන්ඩි ෆාර්මසි",
    "විජය ප්‍රකාශකයෝ", "සිංගර් සමාගම", "අබාන්ස් පීඑල්සී", "ඩම්‍රෝ සමාගම", "හන්ටර්ස් හෝල්ඩින්ග්ස්"
  )

  private val banks = listOf(
    "ලංකා බැංකුව", "මහජන බැංකුව", "සම්පත් බැංකුව", "හැටන් නැෂනල් බැංකුව", "කොමර්ෂල් බැංකුව", "සෙලාන් බැංකුව"
  )

  private val assetNames = listOf(
    Pair("කාර්යාල පරිගණක", "Computer Equipment A/C"),
    Pair("බෙදාහැරීමේ ලොරි රථයක්", "Delivery Lorry A/C"),
    Pair("කාර්යාල ගෘහ භාණ්ඩ", "Furniture A/C"),
    Pair("නිෂ්පාදන යන්ත්‍ර සූත්‍ර", "Plant & Machinery A/C"),
    Pair("කාර්යාල වායුසමීකරණ යන්ත්‍ර", "A/C Equipment A/C"),
    Pair("කාර්යාල ගොඩනැගිල්ලක්", "Buildings A/C"),
    Pair("ව්‍යාපාරික ඉඩමක්", "Land A/C"),
    Pair("ඡායා පිටපත් යන්ත්‍රයක්", "Photocopier Machine A/C"),
    Pair("වෙළඳසැල් රාක්ක හා කවුන්ටර", "Fittings & Fixtures A/C"),
    Pair("කාර්යාල ආරක්ෂක CCTV පද්ධතියක්", "Security System A/C")
  )

  private val expenseTypes = listOf(
    Pair("ගොඩනැගිලි කුලිය", "Rent Expense A/C"),
    Pair("සේවක වැටුප් හා වේතන", "Salaries & Wages A/C"),
    Pair("විදුලි ගාස්තු බිල්පත", "Electricity Expense A/C"),
    Pair("ජල ගාස්තු බිල්පත", "Water Bills A/C"),
    Pair("දුරකථන හා අන්තර්ජාල ගාස්තු", "Telephone & Internet A/C"),
    Pair("ප්‍රචාරණ හා දැන්වීම් ගාස්තු", "Advertising Expense A/C"),
    Pair("ගිනි හා සොරකම් රක්ෂණ වාරික", "Insurance Expense A/C"),
    Pair("කාර්යාල ලිපිද්‍රව්‍ය වියදම්", "Stationery Expense A/C"),
    Pair("මෝටර් රථ නඩත්තු හා ඉන්ධන", "Vehicle Maintenance A/C"),
    Pair("නගර සභා වරිපනම් බදු", "Municipal Rates A/C")
  )

  private val incomeTypes = listOf(
    Pair("ගොඩනැගිලි කුලී ආදායම", "Rent Income A/C"),
    Pair("අතරමැදි කොමිස් ආදායම", "Commission Income A/C"),
    Pair("බැංකු ඉතිරි කිරීමේ පොලී ආදායම", "Interest Income A/C"),
    Pair("කොටස් ආයෝජන ලාභාංශ ආදායම", "Dividend Income A/C"),
    Pair("ඉවතලන ඇසුරුම් විකුණුම් ආදායම", "Scrap Sales Income A/C")
  )

  private fun formatAmount(amount: Int): String {
    return "%,d".format(amount)
  }

  private fun generateBatchItems(batchNumber: Int): List<DoubleEntryChallenge> {
    val themeIdx = (batchNumber - 1) / 10 // 0..19
    val subIdx = (batchNumber - 1) % 10    // 0..9
    val seed = batchNumber * 37 + 101

    return (1..10).map { itemIdx ->
      val globalNum = (batchNumber - 1) * 10 + itemIdx
      val person = partyNames[(seed + itemIdx * 3) % partyNames.size]
      val person2 = partyNames[(seed + itemIdx * 5 + 7) % partyNames.size]
      val comp = companyNames[(seed + itemIdx * 2) % companyNames.size]
      val bank = banks[(seed + itemIdx) % banks.size]
      val asset = assetNames[(seed + itemIdx) % assetNames.size]
      val exp = expenseTypes[(seed + itemIdx) % expenseTypes.size]
      val inc = incomeTypes[(seed + itemIdx) % incomeTypes.size]

      when (themeIdx) {
        // Theme 0: Business Start & Capital
        0 -> {
          val amt = 50000 + ((seed * 13 + itemIdx * 17000) % 200000)
          val amtStr = formatAmount(amt)
          when (itemIdx % 5) {
            1 -> DoubleEntryChallenge(
              transaction = "$itemIdx. අයිතිකරු විසින් රු. $amtStr ක මුදලක් යොදවා ව්‍යාපාරයක් ආරම්භ කිරීම.",
              debitAccount = "මුදල් ගිණුම (Cash A/C) - හර",
              creditAccount = "ප්‍රාග්ධන ගිණුම (Capital A/C) - බැර",
              explanation = "වත්කම් (මුදල්) වැඩිවීම හර වේ; හිමිකම (ප්‍රාග්ධනය) වැඩිවීම බැර වේ."
            )
            2 -> DoubleEntryChallenge(
              transaction = "$itemIdx. අයිතිකරු විසින් රු. $amtStr ක මුදලක් $bank ගිණුමේ තැන්පත් කර ව්‍යාපාරයට ප්‍රාග්ධනය යෙදවීම.",
              debitAccount = "බැංකු ගිණුම ($bank A/C) - හර",
              creditAccount = "ප්‍රාග්ධන ගිණුම (Capital A/C) - බැර",
              explanation = "වත්කම් (බැංකු ශේෂය) වැඩිවීම හර වේ; හිමිකම (ප්‍රාග්ධනය) වැඩිවීම බැර වේ."
            )
            3 -> DoubleEntryChallenge(
              transaction = "$itemIdx. අයිතිකරුගේ පෞද්ගලික රු. $amtStr ක් වටිනා ${asset.first} ව්‍යාපාරයට ප්‍රාග්ධනය ලෙස පැවරීම.",
              debitAccount = "${asset.first} ගිණුම (${asset.second}) - හර",
              creditAccount = "ප්‍රාග්ධන ගිණුම (Capital A/C) - බැර",
              explanation = "වත්කම් (${asset.first}) වැඩිවීම හර වේ; හිමිකම (ප්‍රාග්ධනය) වැඩිවීම බැර වේ."
            )
            4 -> DoubleEntryChallenge(
              transaction = "$itemIdx. අයිතිකරුගේ පෞද්ගලික රු. $amtStr ක වෙළඳ තොගයක් ව්‍යාපාරයට ආරම්භක ප්‍රාග්ධනය ලෙස යෙදවීම.",
              debitAccount = "වෙළඳ තොග / ආරම්භක තොග ගිණුම (Inventory A/C) - හර",
              creditAccount = "ප්‍රාග්ධන ගිණුම (Capital A/C) - බැර",
              explanation = "වත්කම් (වෙළඳ තොග) වැඩිවීම හර වේ; හිමිකම (ප්‍රාග්ධනය) වැඩිවීම බැර වේ."
            )
            else -> DoubleEntryChallenge(
              transaction = "$itemIdx. අයිතිකරු විසින් ව්‍යාපාරයේ අමතර ප්‍රසාරණය සඳහා අමතර ප්‍රාග්ධනය ලෙස රු. $amtStr ක් මුදලින් යෙදවීම.",
              debitAccount = "මුදල් ගිණුම (Cash A/C) - හර",
              creditAccount = "ප්‍රාග්ධන ගිණුම (Capital A/C) - බැර",
              explanation = "වත්කම් (මුදල්) වැඩිවීම හර වේ; අයිතිකරුගේ හිමිකම (ප්‍රාග්ධනය) වැඩිවීම බැර වේ."
            )
          }
        }

        // Theme 1: Bank Transactions & Cash
        1 -> {
          val amt = 10000 + ((seed * 7 + itemIdx * 9000) % 80000)
          val amtStr = formatAmount(amt)
          when (itemIdx % 4) {
            1 -> DoubleEntryChallenge(
              transaction = "$itemIdx. ව්‍යාපාරයේ තිබූ අතිරික්ත මුදලින් රු. $amtStr ක් $bank ජංගම ගිණුමේ තැන්පත් කිරීම.",
              debitAccount = "බැංකු ගිණුම ($bank A/C) - හර",
              creditAccount = "මුදල් ගිණුම (Cash A/C) - බැර",
              explanation = "වත්කම් (බැංකු ශේෂය) වැඩිවීම හර වේ; වත්කම් (අතැති මුදල්) අඩුවීම බැර වේ."
            )
            2 -> DoubleEntryChallenge(
              transaction = "$itemIdx. කාර්යාලීය භාවිතය සඳහා $bank ගිණුමෙන් රු. $amtStr ක මුදලක් චෙක්පතකින් ආපසු ගැනීම.",
              debitAccount = "මුදල් ගිණුම (Cash A/C) - හර",
              creditAccount = "බැංකු ගිණුම ($bank A/C) - බැර",
              explanation = "වත්කම් (අතැති මුදල්) වැඩිවීම හර වේ; වත්කම් (බැංකු ශේෂය) අඩුවීම බැර වේ."
            )
            3 -> DoubleEntryChallenge(
              transaction = "$itemIdx. $bank ඉතිරි කිරීමේ ගිණුමෙන් ජංගම ගිණුමට රු. $amtStr ක අරමුදල් මාරු කිරීම.",
              debitAccount = "ජංගම ගිණුම (Current A/C) - හර",
              creditAccount = "ඉතිරි කිරීමේ ගිණුම (Savings A/C) - බැර",
              explanation = "එක් බැංකු වත්කමක් වැඩිවීම හර වේ; අනෙක් බැංකු වත්කම අඩුවීම බැර වේ."
            )
            else -> DoubleEntryChallenge(
              transaction = "$itemIdx. පාරිභෝගිකයෙකු විසින් රු. $amtStr ක මුදලක් සෘජුවම ව්‍යාපාරයේ $bank ගිණුමට තැන්පත් කර තිබීම.",
              debitAccount = "බැංකු ගිණුම ($bank A/C) - හර",
              creditAccount = "විකුණුම් ගිණුම / ණයගැති ගිණුම - බැර",
              explanation = "වත්කම් (බැංකු ශේෂය) වැඩිවීම හර වේ; ආදායම වැඩිවීම හෝ ණයගැති වත්කම අඩුවීම බැර වේ."
            )
          }
        }

        // Theme 2: Purchases (Cash & Credit)
        2 -> {
          val amt = 15000 + ((seed * 11 + itemIdx * 12000) % 95000)
          val amtStr = formatAmount(amt)
          if (itemIdx % 2 == 1) {
            DoubleEntryChallenge(
              transaction = "$itemIdx. $comp ගෙන් රු. $amtStr ක වෙළඳ භාණ්ඩ තොගයක් ණයට මිලදී ගැනීම.",
              debitAccount = "ගැනුම් ගිණුම (Purchases A/C) - හර",
              creditAccount = "$comp (ණයහිමි) ගිණුම (Creditor A/C) - බැර",
              explanation = "වියදම් (ගැනුම්) වැඩිවීම හර වේ; වගකීම් ($comp ණයහිමියා) වැඩිවීම බැර වේ."
            )
          } else {
            DoubleEntryChallenge(
              transaction = "$itemIdx. වෙළඳ භාණ්ඩ තොගයක් රු. $amtStr ක මුදලකට අත්පිට මුදලින් මිලදී ගැනීම.",
              debitAccount = "ගැනුම් ගිණුම (Purchases A/C) - හර",
              creditAccount = "මුදල් ගිණුම (Cash A/C) - බැර",
              explanation = "වියදම් (ගැනුම්) වැඩිවීම හර වේ; වත්කම් (අතැති මුදල්) අඩුවීම බැර වේ."
            )
          }
        }

        // Theme 3: Sales (Cash & Credit)
        3 -> {
          val amt = 18000 + ((seed * 9 + itemIdx * 14000) % 110000)
          val amtStr = formatAmount(amt)
          if (itemIdx % 2 == 1) {
            DoubleEntryChallenge(
              transaction = "$itemIdx. $person ට රු. $amtStr ක වෙළඳ භාණ්ඩ ණයට විකිණීම.",
              debitAccount = "$person ගේ (ණයගැති) ගිණුම (Debtor A/C) - හර",
              creditAccount = "විකුණුම් ගිණුම (Sales A/C) - බැර",
              explanation = "වත්කම් ($person ණයගැතියා) වැඩිවීම හර වේ; ආදායම් (විකුණුම්) වැඩිවීම බැර වේ."
            )
          } else {
            DoubleEntryChallenge(
              transaction = "$itemIdx. රු. $amtStr ක වෙළඳ භාණ්ඩ අත්පිට මුදලට විකිණීම.",
              debitAccount = "මුදල් ගිණුම (Cash A/C) - හර",
              creditAccount = "විකුණුම් ගිණුම (Sales A/C) - බැර",
              explanation = "වත්කම් (මුදල්) වැඩිවීම හර වේ; ආදායම් (විකුණුම්) වැඩිවීම බැර වේ."
            )
          }
        }

        // Theme 4: Purchases Returns / Outwards
        4 -> {
          val amt = 2000 + ((seed * 5 + itemIdx * 3500) % 25000)
          val amtStr = formatAmount(amt)
          DoubleEntryChallenge(
            transaction = "$itemIdx. $comp ගෙන් ණයට ගෙන තිබූ හානි වූ රු. $amtStr ක භාණ්ඩ ආපසු යැවීම (පිට ආපසු).",
            debitAccount = "$comp (ණයහිමි) ගිණුම (Creditor A/C) - හර",
            creditAccount = "පිට ආපසු / ගැනුම් ආපසු ගිණුම (Returns Outward A/C) - බැර",
            explanation = "වගකීම් ($comp ණයහිමියා) අඩුවීම හර වේ; ගැනුම් වියදම අඩුවීම (පිට ආපසු) බැර වේ."
          )
        }

        // Theme 5: Sales Returns / Inwards
        5 -> {
          val amt = 2500 + ((seed * 7 + itemIdx * 4000) % 28000)
          val amtStr = formatAmount(amt)
          DoubleEntryChallenge(
            transaction = "$itemIdx. $person ට ණයට විකුණූ රු. $amtStr ක භාණ්ඩ ඇණවුමට නොගැලපීම නිසා ඔහුගෙන් ආපසු ලැබීම (ඇතුළට ආපසු).",
            debitAccount = "ඇතුළට ආපසු / විකුණුම් ආපසු ගිණුම (Returns Inward A/C) - හර",
            creditAccount = "$person ගේ (ණයගැති) ගිණුම (Debtor A/C) - බැර",
            explanation = "විකුණුම් ආදායම අඩුවීම (ඇතුළට ආපසු) හර වේ; වත්කම් ($person ණයගැතියා) අඩුවීම බැර වේ."
          )
        }

        // Theme 6: Operating Expenses
        6 -> {
          val amt = 4000 + ((seed * 17 + itemIdx * 6500) % 45000)
          val amtStr = formatAmount(amt)
          val isCheque = itemIdx % 2 == 0
          DoubleEntryChallenge(
            transaction = "$itemIdx. ${exp.first} රු. $amtStr ක් ${if (isCheque) "$bank චෙක්පතකින්" else "අත්පිට මුදලින්"} ගෙවීම.",
            debitAccount = "${exp.first} ගිණුම (${exp.second}) - හර",
            creditAccount = if (isCheque) "බැංකු ගිණුම ($bank A/C) - බැර" else "මුදල් ගිණුම (Cash A/C) - බැර",
            explanation = "වියදම් (${exp.first}) වැඩිවීම හර වේ; වත්කම් (${if (isCheque) "බැංකු ශේෂය" else "අතැති මුදල්"}) අඩුවීම බැර වේ."
          )
        }

        // Theme 7: Operating Incomes
        7 -> {
          val amt = 5000 + ((seed * 19 + itemIdx * 7000) % 55000)
          val amtStr = formatAmount(amt)
          val isCheque = itemIdx % 2 == 1
          DoubleEntryChallenge(
            transaction = "$itemIdx. ${inc.first} රු. $amtStr ක් ${if (isCheque) "චෙක්පතකින් ලැබී බැංකුවේ තැන්පත් වීම" else "මුදලින් ලැබීම"}.",
            debitAccount = if (isCheque) "බැංකු ගිණුම ($bank A/C) - හර" else "මුදල් ගිණුම (Cash A/C) - හර",
            creditAccount = "${inc.first} ගිණුම (${inc.second}) - බැර",
            explanation = "වත්කම් (${if (isCheque) "බැංකු ශේෂය" else "මුදල්"}) වැඩිවීම හර වේ; ආදායම් (${inc.first}) වැඩිවීම බැර වේ."
          )
        }

        // Theme 8: Fixed Assets Cash Purchases
        8 -> {
          val amt = 35000 + ((seed * 23 + itemIdx * 25000) % 350000)
          val amtStr = formatAmount(amt)
          val isCheque = itemIdx % 2 == 1
          DoubleEntryChallenge(
            transaction = "$itemIdx. ව්‍යාපාරික භාවිතය සඳහා රු. $amtStr ක් වටිනා ${asset.first} ${if (isCheque) "$bank චෙක්පතකින්" else "මුදලින්"} මිලදී ගැනීම.",
            debitAccount = "${asset.first} ගිණුම (${asset.second}) - හර",
            creditAccount = if (isCheque) "බැංකු ගිණුම ($bank A/C) - බැර" else "මුදල් ගිණුම (Cash A/C) - බැර",
            explanation = "ස්ථාවර වත්කම් (${asset.first}) වැඩිවීම හර වේ; වත්කම් (${if (isCheque) "බැංකු ශේෂය" else "මුදල්"}) අඩුවීම බැර වේ."
          )
        }

        // Theme 9: Fixed Assets Credit Purchases
        9 -> {
          val amt = 40000 + ((seed * 29 + itemIdx * 30000) % 400000)
          val amtStr = formatAmount(amt)
          DoubleEntryChallenge(
            transaction = "$itemIdx. $comp ගෙන් රු. $amtStr ක් වටිනා ${asset.first} ණයට මිලදී ගැනීම.",
            debitAccount = "${asset.first} ගිණුම (${asset.second}) - හර",
            creditAccount = "$comp (විවිධ ණයහිමි) ගිණුම (Other Creditor A/C) - බැර",
            explanation = "ස්ථාවර වත්කම් (${asset.first}) වැඩිවීම හර වේ; වගකීම් ($comp විවිධ ණයහිමියා) වැඩිවීම බැර වේ."
          )
        }

        // Theme 10: Fixed Asset Sales & Disposals
        10 -> {
          val amt = 20000 + ((seed * 31 + itemIdx * 15000) % 180000)
          val amtStr = formatAmount(amt)
          if (itemIdx % 2 == 1) {
            DoubleEntryChallenge(
              transaction = "$itemIdx. පොත් අගය රු. $amtStr ක් වූ පැරණි ${asset.first} මුදලට විකිණීම.",
              debitAccount = "මුදල් ගිණුම (Cash A/C) - හර",
              creditAccount = "${asset.first} ගිණුම (${asset.second}) - බැර",
              explanation = "වත්කම් (මුදල්) වැඩිවීම හර වේ; ස්ථාවර වත්කම් (${asset.first}) අඩුවීම බැර වේ."
            )
          } else {
            DoubleEntryChallenge(
              transaction = "$itemIdx. භාවිත කළ පැරණි ${asset.first} රු. $amtStr කට $person ට ණයට විකිණීම.",
              debitAccount = "$person (විවිධ ණයගැති) ගිණුම (Other Debtor A/C) - හර",
              creditAccount = "${asset.first} ගිණුම (${asset.second}) - බැර",
              explanation = "වත්කම් ($person විවිධ ණයගැතියා) වැඩිවීම හර වේ; ස්ථාවර වත්කම් (${asset.first}) අඩුවීම බැර වේ."
            )
          }
        }

        // Theme 11: Creditors & Discounts Received
        11 -> {
          val totalDue = 15000 + ((seed * 11 + itemIdx * 5000) % 60000)
          val discount = (totalDue * 0.05).toInt()
          val paidAmt = totalDue - discount
          val totalDueStr = formatAmount(totalDue)
          val discountStr = formatAmount(discount)
          val paidAmtStr = formatAmount(paidAmt)

          DoubleEntryChallenge(
            transaction = "$itemIdx. ණයහිමි $comp ට අයවිය යුතු රු. $totalDueStr ක ණය මුදලින් රු. $discountStr ක වට්ටමක් ලැබී ඉතිරිය රු. $paidAmtStr ක් චෙක්පතකින් ගෙවා පියවීම.",
            debitAccount = "$comp (ණයහිමි) ගිණුම - රු. $totalDueStr හර",
            creditAccount = "බැංකු ගිණුම - රු. $paidAmtStr බැර සහ ලැබුණු වට්ටම් ගිණුම - රු. $discountStr බැර",
            explanation = "වගකීම් ($comp ණයහිමියා) රු. $totalDueStr කින් අඩුවීම හර වේ; වත්කම් (බැංකුව) රු. $paidAmtStr කින් අඩුවීම බැර වේ; ආදායම් (ලැබුණු වට්ටම්) රු. $discountStr කින් වැඩිවීම බැර වේ."
          )
        }

        // Theme 12: Debtors & Discounts Allowed
        12 -> {
          val totalDue = 18000 + ((seed * 13 + itemIdx * 6000) % 70000)
          val discount = (totalDue * 0.05).toInt()
          val recAmt = totalDue - discount
          val totalDueStr = formatAmount(totalDue)
          val discountStr = formatAmount(discount)
          val recAmtStr = formatAmount(recAmt)

          DoubleEntryChallenge(
            transaction = "$itemIdx. ණයගැති $person ගෙන් අයවිය යුතු රු. $totalDueStr ක මුදලින් රු. $discountStr ක මුදල් වට්ටමක් ලබාදී ඉතිරි රු. $recAmtStr මුදලින් ලැබී ණය පියවීම.",
            debitAccount = "මුදල් ගිණුම - රු. $recAmtStr හර සහ දුන් වට්ටම් ගිණුම - රු. $discountStr හර",
            creditAccount = "$person ගේ (ණයගැති) ගිණුම - රු. $totalDueStr බැර",
            explanation = "වත්කම් (මුදල්) රු. $recAmtStr කින් වැඩිවීම හර වේ; වියදම් (දුන් වට්ටම්) රු. $discountStr කින් වැඩිවීම හර වේ; වත්කම් ($person ණයගැතියා) රු. $totalDueStr කින් අඩුවීම බැර වේ."
          )
        }

        // Theme 13: Drawings of Cash & Goods
        13 -> {
          val amt = 3000 + ((seed * 17 + itemIdx * 4500) % 35000)
          val amtStr = formatAmount(amt)
          when (itemIdx % 3) {
            1 -> DoubleEntryChallenge(
              transaction = "$itemIdx. අයිතිකරුගේ පෞද්ගලික පරිහරණය සඳහා ව්‍යාපාර අරමුදලින් රු. $amtStr ක මුදලක් ගැනීම.",
              debitAccount = "ගැනිලි ගිණුම (Drawings A/C) - හර",
              creditAccount = "මුදල් ගිණුම (Cash A/C) - බැර",
              explanation = "හිමිකම අඩුවීම (ගැනිලි) හර වේ; වත්කම් (මුදල්) අඩුවීම බැර වේ."
            )
            2 -> DoubleEntryChallenge(
              transaction = "$itemIdx. අයිතිකරුගේ නිවසේ ප්‍රයෝජනය සඳහා ගැනුම් මිල රු. $amtStr ක් වූ වෙළඳ භාණ්ඩ තොග ලබාගැනීම.",
              debitAccount = "ගැනිලි ගිණුම (Drawings A/C) - හර",
              creditAccount = "ගැනුම් ගිණුම (Purchases A/C) - බැර",
              explanation = "හිමිකම අඩුවීම (ගැනිලි) හර වේ; වෙළඳ තොග ගැනුම් පිරිවැය අඩුවීම (ගැනුම් ගිණුම) බැර වේ."
            )
            else -> DoubleEntryChallenge(
              transaction = "$itemIdx. අයිතිකරුගේ පෞද්ගලික ජීවිත රක්ෂණ වාරිකය රු. $amtStr ක් ව්‍යාපාරයේ $bank චෙක්පතකින් ගෙවීම.",
              debitAccount = "ගැනිලි ගිණුම (Drawings A/C) - හර",
              creditAccount = "බැංකු ගිණුම ($bank A/C) - බැර",
              explanation = "අයිතිකරුගේ පෞද්ගලික වියදමක් බැවින් හිමිකම අඩුවීම (ගැනිලි) හර වේ; වත්කම් (බැංකු ශේෂය) අඩුවීම බැර වේ."
            )
          }
        }

        // Theme 14: Bank Loans & Loan Interest
        14 -> {
          val amt = 50000 + ((seed * 19 + itemIdx * 25000) % 300000)
          val amtStr = formatAmount(amt)
          val interest = 2500 + ((seed * 3 + itemIdx * 1200) % 15000)
          val intStr = formatAmount(interest)

          when (itemIdx % 3) {
            1 -> DoubleEntryChallenge(
              transaction = "$itemIdx. $bank න් රු. $amtStr ක ව්‍යාපාරික ණයක් ලබාගෙන ජංගම ගිණුමේ තැන්පත් කිරීම.",
              debitAccount = "බැංකු ගිණුම ($bank A/C) - හර",
              creditAccount = "$bank ණය ගිණුම (Bank Loan A/C) - බැර",
              explanation = "වත්කම් (බැංකු ශේෂය) වැඩිවීම හර වේ; වගකීම් ($bank ණය) වැඩිවීම බැර වේ."
            )
            2 -> DoubleEntryChallenge(
              transaction = "$itemIdx. $bank ණය වාරිකයක් සඳහා රු. $amtStr ක මුදලක් චෙක්පතකින් ආපසු ගෙවීම.",
              debitAccount = "$bank ණය ගිණුම (Bank Loan A/C) - හර",
              creditAccount = "බැංකු ගිණුම ($bank A/C) - බැර",
              explanation = "වගකීම් ($bank ණය) අඩුවීම හර වේ; වත්කම් (බැංකු ශේෂය) අඩුවීම බැර වේ."
            )
            else -> DoubleEntryChallenge(
              transaction = "$itemIdx. $bank ණය වෙනුවෙන් රු. $intStr ක පොලියක් බැංකු ගිණුමෙන් ගෙවීම.",
              debitAccount = "ණය පොලී වියදම් ගිණුම (Loan Interest Expense A/C) - හර",
              creditAccount = "බැංකු ගිණුම ($bank A/C) - බැර",
              explanation = "මූල්‍ය වියදම් (ණය පොලිය) වැඩිවීම හර වේ; වත්කම් (බැංකු ශේෂය) අඩුවීම බැර වේ."
            )
          }
        }

        // Theme 15: Overdrafts & Bank Charges
        15 -> {
          val amt = 1500 + ((seed * 7 + itemIdx * 1800) % 12000)
          val amtStr = formatAmount(amt)
          when (itemIdx % 3) {
            1 -> DoubleEntryChallenge(
              transaction = "$itemIdx. බැංකුව විසින් රු. $amtStr ක මාසික බැංකු ගාස්තු (Bank Charges) ජංගම ගිණුමට හර කිරීම.",
              debitAccount = "බැංකු ගාස්තු ගිණුම (Bank Charges A/C) - හර",
              creditAccount = "බැංකු ගිණුම (Bank A/C) - බැර",
              explanation = "වියදම් (බැංකු ගාස්තු) වැඩිවීම හර වේ; වත්කම් (බැංකු ශේෂය) අඩුවීම බැර වේ."
            )
            2 -> DoubleEntryChallenge(
              transaction = "$itemIdx. බැංකු අයිරාව වෙනුවෙන් බැංකුව විසින් රු. $amtStr ක අයිරා පොලියක් අය කිරීම.",
              debitAccount = "අයිරා පොලී වියදම් ගිණුම (Overdraft Interest A/C) - හර",
              creditAccount = "බැංකු ගිණුම (Bank A/C) - බැර",
              explanation = "මූල්‍ය වියදම් (අයිරා පොලිය) වැඩිවීම හර වේ; බැංකු වගකීම වැඩිවීම (හෝ බැංකු ශේෂය අඩුවීම) බැර වේ."
            )
            else -> DoubleEntryChallenge(
              transaction = "$itemIdx. බැංකු අයිරාව පියවීම සඳහා මුදල් රු. $amtStr ක් බැංකුවේ තැන්පත් කිරීම.",
              debitAccount = "බැංකු ගිණුම (Bank A/C) - හර",
              creditAccount = "මුදල් ගිණුම (Cash A/C) - බැර",
              explanation = "බැංකු අයිරා වගකීම අඩුවීම (බැංකු ගිණුම) හර වේ; වත්කම් (මුදල්) අඩුවීම බැර වේ."
            )
          }
        }

        // Theme 16: Bad Debts & Recoveries
        16 -> {
          val amt = 3500 + ((seed * 11 + itemIdx * 2500) % 25000)
          val amtStr = formatAmount(amt)
          if (itemIdx % 2 == 1) {
            DoubleEntryChallenge(
              transaction = "$itemIdx. ණයගැති $person බංකොලොත් වීම නිසා ඔහුගෙන් අයවිය යුතු රු. $amtStr ක ණය මුදල අයකරගත නොහැකි ණයක් ලෙස කපාහැරීම.",
              debitAccount = "අයකරගත නොහැකි ණය ගිණුම (Bad Debts A/C) - හර",
              creditAccount = "$person ගේ (ණයගැති) ගිණුම (Debtor A/C) - බැර",
              explanation = "අලාභය / වියදම (අයකරගත නොහැකි ණය) වැඩිවීම හර වේ; වත්කම් ($person ණයගැතියා) අඩුවීම බැර වේ."
            )
          } else {
            DoubleEntryChallenge(
              transaction = "$itemIdx. පසුගිය වර්ෂයේ අයකරගත නොහැකි ණයක් ලෙස කපාහරින ලද $person2 ගෙන් රු. $amtStr ක මුදලක් අනපේක්ෂිතව මුදලින් ලැබීම.",
              debitAccount = "මුදල් ගිණුම (Cash A/C) - හර",
              creditAccount = "නැවත අයවූ අයකරගත නොහැකි ණය ගිණුම (Bad Debts Recovered A/C) - බැර",
              explanation = "වත්කම් (මුදල්) වැඩිවීම හර වේ; වෙනත් ආදායම් (නැවත අයවූ අයකරගත නොහැකි ණය) වැඩිවීම බැර වේ."
            )
          }
        }

        // Theme 17: Accrued & Prepaid Expenses
        17 -> {
          val amt = 2500 + ((seed * 13 + itemIdx * 3500) % 30000)
          val amtStr = formatAmount(amt)
          if (itemIdx % 2 == 1) {
            DoubleEntryChallenge(
              transaction = "$itemIdx. වර්ෂය අවසානයේ ගෙවීමට ඉතිරිව ඇති ${exp.first} (උපචිත වියදම) රු. $amtStr කි.",
              debitAccount = "${exp.first} ගිණුම (${exp.second}) - හර",
              creditAccount = "ගෙවිය යුතු (උපචිත) ${exp.first} ගිණුම (Accrued Expense A/C) - බැර",
              explanation = "අදාළ වර්ෂයේ වියදම (${exp.first}) සම්පූර්ණ කිරීම සඳහා වැඩිවීම හර වේ; වගකීම් (ගෙවිය යුතු වියදම්) වැඩිවීම බැර වේ."
            )
          } else {
            DoubleEntryChallenge(
              transaction = "$itemIdx. මීළඟ මූල්‍ය වර්ෂය සඳහා කලින් ගෙවන ලද ${exp.first} (පෙරගෙවුම් වියදම) රු. $amtStr කි.",
              debitAccount = "කලින් ගෙවූ (පෙරගෙවුම්) ${exp.first} ගිණුම (Prepaid Expense A/C) - හර",
              creditAccount = "${exp.first} ගිණුම (${exp.second}) - බැර",
              explanation = "වත්කම් (කලින් ගෙවූ වියදම්) වැඩිවීම හර වේ; මෙම වර්ෂයේ වියදම අඩුකිරීම සඳහා (${exp.first}) බැර වේ."
            )
          }
        }

        // Theme 18: Accrued & Advance Incomes
        18 -> {
          val amt = 3000 + ((seed * 17 + itemIdx * 4000) % 35000)
          val amtStr = formatAmount(amt)
          if (itemIdx % 2 == 1) {
            DoubleEntryChallenge(
              transaction = "$itemIdx. වර්ෂය තුළ උපයා ඇති නමුත් ලැබීමට නියමිත (උපචිත) ${inc.first} රු. $amtStr කි.",
              debitAccount = "ලැබිය යුතු (උපචිත) ${inc.first} ගිණුම (Accrued Income A/C) - හර",
              creditAccount = "${inc.first} ගිණුම (${inc.second}) - බැර",
              explanation = "වත්කම් (ලැබිය යුතු ආදායම) වැඩිවීම හර වේ; අදාළ වර්ෂයේ ආදායම වැඩිවීම (${inc.first}) බැර වේ."
            )
          } else {
            DoubleEntryChallenge(
              transaction = "$itemIdx. ඉදිරි වර්ෂය සඳහා ගනුදෙනුකරුවෙකුගෙන් කලින් ලැබුණු (පෙරලැබුණු) ${inc.first} රු. $amtStr කි.",
              debitAccount = "${inc.first} ගිණුම (${inc.second}) - හර",
              creditAccount = "කලින් ලැබුණු (පෙරලැබුණු) ${inc.first} ගිණුම (Income in Advance A/C) - බැර",
              explanation = "මෙම වර්ෂයට අදාළ නොවන බැවින් ආදායම අඩුකිරීම සඳහා හර වේ; වගකීම් (කලින් ලැබුණු ආදායම්) වැඩිවීම බැර වේ."
            )
          }
        }

        // Theme 19: Petty Cash, Dishonoured Cheques & Adjustments
        else -> {
          val amt = 1200 + ((seed * 19 + itemIdx * 1500) % 20000)
          val amtStr = formatAmount(amt)
          when (itemIdx % 4) {
            1 -> DoubleEntryChallenge(
              transaction = "$itemIdx. සුළු මුදල් අග්‍රදායක ක්‍රමය සඳහා ප්‍රධාන මුදල් අයකැමි විසින් සුළු මුදල් භාරකරුට රු. $amtStr ක චෙක්පතක් නිකුත් කිරීම.",
              debitAccount = "සුළු මුදල් ගිණුම (Petty Cash A/C) - හර",
              creditAccount = "බැංකු ගිණුම (Bank A/C) - බැර",
              explanation = "වත්කම් (සුළු මුදල් ශේෂය) වැඩිවීම හර වේ; වත්කම් (බැංකු ශේෂය) අඩුවීම බැර වේ."
            )
            2 -> DoubleEntryChallenge(
              transaction = "$itemIdx. සුළු මුදල් භාරකරු විසින් තැපැල් හා ලිපිද්‍රව්‍ය සඳහා රු. $amtStr ක් සුළු මුදලින් ගෙවීම.",
              debitAccount = "තැපැල් හා ලිපිද්‍රව්‍ය වියදම් ගිණුම - හර",
              creditAccount = "සුළු මුදල් ගිණුම (Petty Cash A/C) - බැර",
              explanation = "වියදම් වැඩිවීම හර වේ; වත්කම් (සුළු මුදල්) අඩුවීම බැර වේ."
            )
            3 -> DoubleEntryChallenge(
              transaction = "$itemIdx. ණයගැති $person ගෙන් ලැබී බැංකුවේ තැන්පත් කළ රු. $amtStr ක චෙක්පතක් අගරු වී (Dishonoured) ආපසු පැමිණීම.",
              debitAccount = "$person ගේ (ණයගැති) ගිණුම (Debtor A/C) - හර",
              creditAccount = "බැංකු ගිණුම (Bank A/C) - බැර",
              explanation = "ණයගැති වත්කම නැවත වැඩිවීම ($person) හර වේ; වත්කම් (බැංකු ශේෂය) අඩුවීම බැර වේ."
            )
            else -> DoubleEntryChallenge(
              transaction = "$itemIdx. රු. $amtStr ක් වටිනා වෙළඳ භාණ්ඩ ආයතනයේ ප්‍රචාරණ කටයුතු වෙනුවෙන් නොමිලේ සාම්පල ලෙස බෙදාහැරීම.",
              debitAccount = "දැන්වීම් / ප්‍රචාරණ වියදම් ගිණුම (Advertising A/C) - හර",
              creditAccount = "ගැනුම් ගිණුම (Purchases A/C) - බැර",
              explanation = "වියදම් (ප්‍රචාරණය) වැඩිවීම හර වේ; වෙළඳ තොග පිරිවැය අඩුවීම (ගැනුම් ගිණුම) බැර වේ."
            )
          }
        }
      }
    }
  }

  fun search(query: String): List<Pair<Int, DoubleEntryChallenge>> {
    val q = query.trim().lowercase()
    if (q.isBlank()) return emptyList()

    val results = mutableListOf<Pair<Int, DoubleEntryChallenge>>()
    for (b in 1..TOTAL_BATCHES) {
      val batch = getBatch(b)
      for (item in batch.challenges) {
        if (item.transaction.lowercase().contains(q) ||
          item.debitAccount.lowercase().contains(q) ||
          item.creditAccount.lowercase().contains(q) ||
          item.explanation.lowercase().contains(q)
        ) {
          results.add(Pair(b, item))
          if (results.size >= 50) return results
        }
      }
    }
    return results
  }
}
