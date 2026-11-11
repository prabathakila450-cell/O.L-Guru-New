package com.example

object TenseDataPart4 {
  fun getCategoriesPart4(): List<TenseComparisonCategory> {
    return listOf(
      // ==========================================
      // Category 16: මුදල්, බැංකු සහ ඉතිරි කිරීම (Money, Banking & Savings) - 30 items
      // ==========================================
      TenseComparisonCategory(
        id = 16,
        titleSinhala = "කාණ්ඩය 16: මුදල්, බැංකු සහ ඉතිරි කිරීම",
        titleEnglish = "Money, Banking & Savings",
        icon = "💰",
        description = "මුදල් තැන්පත් කිරීම, ඉතිරි කිරීම, බැංකු ගිණුම් සහ මූල්‍ය කළමනාකරණය පිළිබඳ වාක්‍ය 30ක් කාල තුනෙන්ම.",
        sentences = listOf(
          TenseSentenceItem(
            id = "t16_s1",
            baseActionSinhala = "මුදල් තැන්පත් කිරීම",
            pastEnglish = "I deposited five thousand rupees in my savings account yesterday.",
            pastSinhala = "මම ඊයේ මගේ ඉතිරිකිරීමේ ගිණුමේ රුපියල් පන්දහසක් තැන්පත් කළෙමි.",
            presentEnglish = "I deposit money in the bank at the end of every month.",
            presentSinhala = "මම සෑම මසකම අගදී බැංකුවේ මුදල් තැන්පත් කරමි.",
            futureEnglish = "I will deposit my pocket money in the bank tomorrow.",
            futureSinhala = "මම හෙට මගේ කැප මුදල් බැංකුවේ තැන්පත් කරන්නෙමි.",
            verbTransformation = "deposited → deposit → will deposit"
          ),
          TenseSentenceItem(
            id = "t16_s2",
            baseActionSinhala = "ATM යන්ත්‍රයෙන් මුදල් ගැනීම",
            pastEnglish = "Father withdrew ten thousand rupees from the ATM.",
            pastSinhala = "තාත්තා ATM යන්ත්‍රයෙන් රුපියල් දසදහසක් ලබා ගත්තේය.",
            presentEnglish = "He withdraws cash whenever he needs to buy groceries.",
            presentSinhala = "ඔහුට බඩු මිලදී ගැනීමට අවශ්‍ය සෑම විටම මුදල් ලබා ගනියි.",
            futureEnglish = "He will withdraw money before going to the fair.",
            futureSinhala = "පොළට යාමට පෙර ඔහු මුදල් ලබා ගනු ඇත.",
            verbTransformation = "withdrew → withdraws → will withdraw"
          ),
          TenseSentenceItem(
            id = "t16_s3",
            baseActionSinhala = "මුදල් ඉතිරි කිරීම",
            pastEnglish = "She saved coins in her clay till.",
            pastSinhala = "ඇය තම මැටි කැටයේ කාසි ඉතිරි කළාය.",
            presentEnglish = "She saves ten percent of her allowance every week.",
            presentSinhala = "ඇය සෑම සතියකම තම දීමනාවෙන් සියයට දහයක් ඉතිරි කරයි.",
            futureEnglish = "She will save money to buy a scientific calculator.",
            futureSinhala = "විද්‍යාත්මක කැල්කියුලේටරයක් මිලදී ගැනීමට ඇය මුදල් ඉතිරි කරනු ඇත.",
            verbTransformation = "saved → saves → will save"
          ),
          TenseSentenceItem(
            id = "t16_s4",
            baseActionSinhala = "ණය මුදලක් ආපසු ගෙවීම",
            pastEnglish = "Kamal repaid the full loan to his friend last week.",
            pastSinhala = "කමල් පසුගිය සතියේ තම මිතුරාට සම්පූර්ණ ණය මුදල ආපසු ගෙවීය.",
            presentEnglish = "Honest borrowers repay debts without delay.",
            presentSinhala = "අවංක ණයගැතියෝ ප්‍රමාදයකින් තොරව ණය ආපසු ගෙවති.",
            futureEnglish = "Kamal will repay the remaining balance on Friday.",
            futureSinhala = "කමල් සිකුරාදා ඉතිරි ශේෂය ආපසු ගෙවනු ඇත.",
            verbTransformation = "repaid → repay → will repay"
          ),
          TenseSentenceItem(
            id = "t16_s5",
            baseActionSinhala = "බැංකු පොත යාවත්කාලීන කිරීම",
            pastEnglish = "I updated my passbook at the automated kiosk.",
            pastSinhala = "මම ස්වයංක්‍රීය යන්ත්‍රයෙන් මගේ බැංකු පොත යාවත්කාලීන කළෙමි.",
            presentEnglish = "Prudent savers update their passbooks regularly.",
            presentSinhala = "බුද්ධිමත් තැන්පත්කරුවෝ තම බැංකු පොත් නිතර යාවත්කාලීන කරති.",
            futureEnglish = "I will update the passbook on Monday morning.",
            futureSinhala = "මම සඳුදා උදෑසන බැංකු පොත යාවත්කාලීන කරන්නෙමි.",
            verbTransformation = "updated → update → will update"
          ),
          TenseSentenceItem(
            id = "t16_s6",
            baseActionSinhala = "චෙක්පතක් ලියා දීම",
            pastEnglish = "The merchant wrote a crossed cheque for the supplier.",
            pastSinhala = "වෙළෙන්දා සැපයුම්කරු සඳහා හරස් කළ චෙක්පතක් ලියා දුන්නේය.",
            presentEnglish = "Businessmen write cheques for large commercial payments.",
            presentSinhala = "ව්‍යාපාරිකයෝ විශාල ගෙවීම් සඳහා චෙක්පත් ලියා දෙති.",
            futureEnglish = "He will write a cheque for the school fees tomorrow.",
            futureSinhala = "ඔහු හෙට පාසල් ගාස්තු සඳහා චෙක්පතක් ලියනු ඇත.",
            verbTransformation = "wrote → write → will write"
          ),
          TenseSentenceItem(
            id = "t16_s7",
            baseActionSinhala = "පොලී මුදලක් ලැබීම",
            pastEnglish = "The account earned attractive interest this quarter.",
            pastSinhala = "මෙම කාර්තුවේදී ගිණුමට ආකර්ෂණීය පොලියක් ලැබුණි.",
            presentEnglish = "Fixed deposits earn higher interest than regular accounts.",
            presentSinhala = "ස්ථාවර තැන්පතු සාමාන්‍ය ගිණුම්වලට වඩා වැඩි පොලියක් උපයයි.",
            futureEnglish = "My deposit will earn compound interest next year.",
            futureSinhala = "මගේ තැන්පතුව ලබන වසරේ වැල් පොලියක් උපයනු ඇත.",
            verbTransformation = "earned → earn → will earn"
          ),
          TenseSentenceItem(
            id = "t16_s8",
            baseActionSinhala = "මුදල් හුවමාරු කිරීම",
            pastEnglish = "I transferred money to my brother via mobile app.",
            pastSinhala = "මම ජංගම යෙදුම මඟින් මගේ සොහොයුරාට මුදල් හුවමාරු කළෙමි.",
            presentEnglish = "Modern banking transfers funds in real time.",
            presentSinhala = "නවීන බැංකුකරණය ක්ෂණිකව මුදල් හුවමාරු කරයි.",
            futureEnglish = "I will transfer the donation to the charity fund.",
            futureSinhala = "මම පුණ්‍යාධාර අරමුදලට පරිත්‍යාගය හුවමාරු කරන්නෙමි.",
            verbTransformation = "transferred → transfers → will transfer"
          ),
          TenseSentenceItem(
            id = "t16_s9",
            baseActionSinhala = "වියදම් සටහන් කිරීම",
            pastEnglish = "Mother recorded all grocery expenses in her diary.",
            pastSinhala = "අම්මා සියලුම බඩු වියදම් තම දිනපොතේ සටහන් කළාය.",
            presentEnglish = "Careful homemakers record every rupee spent daily.",
            presentSinhala = "ප්‍රවේශම් සහගත ගෘහණියෝ දිනපතා වියදම් වන සෑම රුපියලක්ම සටහන් කරති.",
            futureEnglish = "She will record this month's electricity charges.",
            futureSinhala = "ඇය මෙම මාසයේ විදුලි බිල්පත් ගාස්තු සටහන් කරනු ඇත.",
            verbTransformation = "recorded → record → will record"
          ),
          TenseSentenceItem(
            id = "t16_s10",
            baseActionSinhala = "ණයවර පතක් භාවිතය",
            pastEnglish = "He paid the hotel bill using a credit card.",
            pastSinhala = "ඔහු ණයවර පතක් භාවිත කරමින් හෝටල් බිල ගෙවීය.",
            presentEnglish = "Smart consumers pay credit card balances in full.",
            presentSinhala = "බුද්ධිමත් පාරිභෝගිකයෝ ණයවර පත් ශේෂයන් සම්පූර්ණයෙන්ම ගෙවති.",
            futureEnglish = "He will pay the online course fee with his debit card.",
            futureSinhala = "ඔහු ඩෙබිට් කාඩ්පත මඟින් මාර්ගගත පාඨමාලා ගාස්තුව ගෙවනු ඇත.",
            verbTransformation = "paid → pay → will pay"
          ),
          TenseSentenceItem(
            id = "t16_s11",
            baseActionSinhala = "විදේශ මුදල් මාරු කිරීම",
            pastEnglish = "The tourist exchanged US dollars for Sri Lankan rupees.",
            pastSinhala = "සංචාරකයා ඇමරිකානු ඩොලර් ශ්‍රී ලංකා රුපියල් බවට මාරු කළේය.",
            presentEnglish = "Foreign exchange counters provide legal conversion rates.",
            presentSinhala = "විදේශ විනිමය කවුළු නිල විනිමය අනුපාත ලබා දෙයි.",
            futureEnglish = "We will exchange British pounds before our travel.",
            futureSinhala = "ගමනට පෙර අපි බ්‍රිතාන්‍ය පවුම් මාරු කර ගන්නෙමු.",
            verbTransformation = "exchanged → provide → will exchange"
          ),
          TenseSentenceItem(
            id = "t16_s12",
            baseActionSinhala = "නව බැංකු ගිණුමක් විවෘත කිරීම",
            pastEnglish = "Naveen opened a youth savings account last Monday.",
            pastSinhala = "නවීන් පසුගිය සඳුදා තරුණ ඉතිරිකිරීමේ ගිණුමක් විවෘත කළේය.",
            presentEnglish = "Students open accounts to manage higher study funds.",
            presentSinhala = "උසස් අධ්‍යාපන අරමුදල් කළමනාකරණයට සිසුහු ගිණුම් විවෘත කරති.",
            futureEnglish = "He will open a fixed deposit when he turns eighteen.",
            futureSinhala = "ඔහුට වයස දහඅට පිරුණු පසු ඔහු ස්ථාවර තැන්පතුවක් විවෘත කරනු ඇත.",
            verbTransformation = "opened → open → will open"
          ),
          TenseSentenceItem(
            id = "t16_s13",
            baseActionSinhala = "අනවශ්‍ය වියදම් පාලනය කිරීම",
            pastEnglish = "We cut down on luxury expenses last month.",
            pastSinhala = "අපි පසුගිය මාසයේ අනවශ්‍ය සුඛෝපභෝගී වියදම් අඩු කළෙමු.",
            presentEnglish = "Sensible families avoid wasteful spending on impulses.",
            presentSinhala = "ඥානවන්ත පවුල් ක්ෂණික ආශාවන් සඳහා අපතේ යන වියදම් වළක්වා ගනිති.",
            futureEnglish = "We will control our entertainment budget next holiday.",
            futureSinhala = "ලබන නිවාඩුවේදී අපි අපගේ විනෝදාස්වාද වියදම් පාලනය කරන්නෙමු.",
            verbTransformation = "cut down → avoid → will control"
          ),
          TenseSentenceItem(
            id = "t16_s14",
            baseActionSinhala = "අයවැයක් පිළියෙල කිරීම",
            pastEnglish = "Father planned the monthly budget meticulously.",
            pastSinhala = "තාත්තා ඉතා සැලකිල්ලෙන් මාසික අයවැය සැලසුම් කළේය.",
            presentEnglish = "Financial planning ensures household stability.",
            presentSinhala = "මූල්‍ය සැලසුම්කරණය පවුලේ ස්ථාවරත්වය සහතික කරයි.",
            futureEnglish = "We will prepare an annual financial plan in December.",
            futureSinhala = "අපි දෙසැම්බර් මාසයේදී වාර්ෂික මූල්‍ය සැලැස්මක් සකස් කරන්නෙමු.",
            verbTransformation = "planned → ensures → will prepare"
          ),
          TenseSentenceItem(
            id = "t16_s15",
            baseActionSinhala = "ආයෝජනයක් සිදු කිරීම",
            pastEnglish = "Uncle invested in government treasury bonds.",
            pastSinhala = "මාමා රජයේ භාණ්ඩාගාර බැඳුම්කරවල ආයෝජනය කළේය.",
            presentEnglish = "Safe investments protect money from inflation.",
            presentSinhala = "ආරක්ෂිත ආයෝජන උද්ධමනයෙන් මුදල් ආරක්ෂා කරයි.",
            futureEnglish = "He will invest in green renewable energy shares.",
            futureSinhala = "ඔහු පුනර්ජනනීය බලශක්ති කොටස්වල ආයෝජනය කරනු ඇත.",
            verbTransformation = "invested → protect → will invest"
          ),
          TenseSentenceItem(
            id = "t16_s16",
            baseActionSinhala = "මුදල් නෝට්ටු ගණන් කිරීම",
            pastEnglish = "The cashier counted the currency notes accurately.",
            pastSinhala = "මුදල් අයකැමි මුදල් නෝට්ටු නිවැරදිව ගණන් කළේය.",
            presentEnglish = "Cash counters count bundles of money swiftly.",
            presentSinhala = "මුදල් ගණින යන්ත්‍ර මුදල් මිටි වේගයෙන් ගණන් කරයි.",
            futureEnglish = "I will count the balance before leaving the counter.",
            futureSinhala = "කවුන්ටරයෙන් පිටවීමට පෙර මම ඉතිරි මුදල ගණන් කරන්නෙමි.",
            verbTransformation = "counted → count → will count"
          ),
          TenseSentenceItem(
            id = "t16_s17",
            baseActionSinhala = "තෑගි මුදලක් ලැබීම",
            pastEnglish = "Grandfather gifted me two thousand rupees on my birthday.",
            pastSinhala = "මගේ උපන්දිනයට සීයා මට රුපියල් දෙදහසක් තෑගි කළේය.",
            presentEnglish = "Relatives give cash gifts during festive seasons.",
            presentSinhala = "උත්සව සමයේදී ඥාතීහු මුදල් තෑගි දෙති.",
            futureEnglish = "I will put the gift money into my school bank fund.",
            futureSinhala = "මම තෑගි මුදල මගේ පාසල් බැංකු අරමුදලට දමන්නෙමි.",
            verbTransformation = "gifted → give → will put"
          ),
          TenseSentenceItem(
            id = "t16_s18",
            baseActionSinhala = "ණය මුදලක් ලබා ගැනීම",
            pastEnglish = "The farmer took an agricultural loan for cultivation.",
            pastSinhala = "ගොවියා වගා කටයුතු සඳහා කෘෂිකාර්මික ණයක් ලබා ගත්තේය.",
            presentEnglish = "State banks grant low-interest loans to farmers.",
            presentSinhala = "රාජ්‍ය බැංකු ගොවීන්ට සහන පොලී ණය ලබා දෙයි.",
            futureEnglish = "He will settle the crop loan after harvest.",
            futureSinhala = "අස්වැන්න නෙළීමෙන් පසු ඔහු වගා ණය පියවනු ඇත.",
            verbTransformation = "took → grant → will settle"
          ),
          TenseSentenceItem(
            id = "t16_s19",
            baseActionSinhala = "බිල්පතක් පියවීම",
            pastEnglish = "I settled the internet bill online yesterday.",
            pastSinhala = "මම ඊයේ අන්තර්ජාල බිල්පත මාර්ගගතව පියවූයෙමි.",
            presentEnglish = "Timely bill settlements prevent service disconnections.",
            presentSinhala = "නියමිත වේලාවට බිල්පත් පියවීම සේවා විසන්ධිවීම් වළක්වයි.",
            futureEnglish = "I will settle the insurance premium by Monday.",
            futureSinhala = "මම සඳුදා වන විට රක්ෂණ වාරිකය පියවන්නෙමි.",
            verbTransformation = "settled → prevent → will settle"
          ),
          TenseSentenceItem(
            id = "t16_s20",
            baseActionSinhala = "රක්ෂණ ඔප්පුවක් ගැනීම",
            pastEnglish = "Father purchased a comprehensive life insurance policy.",
            pastSinhala = "තාත්තා පූර්ණ ජීවිත රක්ෂණ ඔප්පුවක් ලබා ගත්තේය.",
            presentEnglish = "Insurance policies protect families against sudden crises.",
            presentSinhala = "රක්ෂණ ඔප්පු හදිසි අර්බුදවලදී පවුල් ආරක්ෂා කරයි.",
            futureEnglish = "We will renew our vehicle insurance next week.",
            futureSinhala = "අපි ලබන සතියේ අපගේ වාහන රක්ෂණය අලුත් කරන්නෙමු.",
            verbTransformation = "purchased → protect → will renew"
          ),
          TenseSentenceItem(
            id = "t16_s21",
            baseActionSinhala = "කාසියක් විසි කිරීම",
            pastEnglish = "The umpire tossed the coin before the cricket match.",
            pastSinhala = "ක්‍රිකට් තරඟයට පෙර විනිසුරු කාසිය උඩ දැමුවේය.",
            presentEnglish = "Captains choose batting or bowling after the toss.",
            presentSinhala = "කාසියේ වාසියෙන් පසු නායකයෝ පන්දුවට පහරදීම හෝ පන්දු යැවීම තෝරා ගනිති.",
            futureEnglish = "The referee will toss the coin to start the final.",
            futureSinhala = "අවසන් මහා තරඟය ආරම්භ කිරීමට විනිසුරු කාසිය උඩ දමනු ඇත.",
            verbTransformation = "tossed → choose → will toss"
          ),
          TenseSentenceItem(
            id = "t16_s22",
            baseActionSinhala = "වට්ටමක් ලැබීම",
            pastEnglish = "We received a twenty percent discount on school bags.",
            pastSinhala = "පාසල් බෑග් සඳහා අපට සියයට විස්සක වට්ටමක් ලැබුණි.",
            presentEnglish = "Book fairs offer generous discounts to students.",
            presentSinhala = "පොත් ප්‍රදර්ශන සිසුන්ට ඉහළ වට්ටම් ලබා දෙයි.",
            futureEnglish = "The shop will offer seasonal discounts in April.",
            futureSinhala = "කඩය අප්‍රේල් මාසයේදී උත්සව වට්ටම් ලබා දෙනු ඇත.",
            verbTransformation = "received → offer → will offer"
          ),
          TenseSentenceItem(
            id = "t16_s23",
            baseActionSinhala = "රිසිට්පතක් ලබා ගැනීම",
            pastEnglish = "The cashier issued a printed receipt for the transaction.",
            pastSinhala = "ගනුදෙනුව සඳහා මුදල් අයකැමි මුද්‍රිත රිසිට්පතක් නිකුත් කළේය.",
            presentEnglish = "Prudent buyers collect receipts as proof of payment.",
            presentSinhala = "බුද්ධිමත් ගැනුම්කරුවෝ ගෙවීම් සාක්ෂියක් ලෙස රිසිට්පත් ලබා ගනිති.",
            futureEnglish = "I will keep the receipt in case I need an exchange.",
            futureSinhala = "භාණ්ඩයක් මාරු කිරීමට අවශ්‍ය වුවහොත් මම රිසිට්පත තබා ගන්නෙමි.",
            verbTransformation = "issued → collect → will keep"
          ),
          TenseSentenceItem(
            id = "t16_s24",
            baseActionSinhala = "මුදල් පසුම්බියක් මිලදී ගැනීම",
            pastEnglish = "Amila bought a durable leather wallet.",
            pastSinhala = "අමිල ශක්තිමත් සම් මුදල් පසුම්බියක් මිලදී ගත්තේය.",
            presentEnglish = "A neat wallet organizes cards and money safely.",
            presentSinhala = "පිළිවෙළක් ඇති පසුම්බියක් කාඩ්පත් සහ මුදල් සුරක්ෂිතව තබා ගනී.",
            futureEnglish = "I will gift a small purse to my sister.",
            futureSinhala = "මම මගේ නංගීට කුඩා මුදල් පසුම්බියක් තෑගි කරන්නෙමි.",
            verbTransformation = "bought → organizes → will gift"
          ),
          TenseSentenceItem(
            id = "t16_s25",
            baseActionSinhala = "පුණ්‍ය කටයුත්තකට මුදල් දීම",
            pastEnglish = "The philanthropist donated one million rupees to the hospital.",
            pastSinhala = "දානපතියා රෝහලට රුපියල් මිලියනයක් පරිත්‍යාග කළේය.",
            presentEnglish = "Generous donors support welfare homes selflessly.",
            presentSinhala = "ත්‍යාගශීලී දායකයෝ සුබසාධන නිවාසවලට නොමසුරුව උපකාර කරති.",
            futureEnglish = "Our class will donate our earnings to the orphan fund.",
            futureSinhala = "අපේ පන්තිය උපයාගත් මුදල් අනාථ අරමුදලට පරිත්‍යාග කරනු ඇත.",
            verbTransformation = "donated → support → will donate"
          ),
          TenseSentenceItem(
            id = "t16_s26",
            baseActionSinhala = "ව්‍යාජ නෝට්ටුවක් හඳුනාගැනීම",
            pastEnglish = "The bank teller detected a counterfeit banknote.",
            pastSinhala = "බැංකු අයකැමි ව්‍යාජ මුදල් නෝට්ටුවක් හඳුනාගත්තේය.",
            presentEnglish = "Watermarks and security threads identify genuine currency.",
            presentSinhala = "දිය සලකුණු සහ ආරක්ෂණ නූල් සැබෑ මුදල් හඳුනා ගැනීමට උපකාරී වේ.",
            futureEnglish = "New technology will eliminate currency forgery completely.",
            futureSinhala = "නව තාක්ෂණය මුදල් ව්‍යාජ ලෙස සකස් කිරීම මුළුමනින්ම තුරන් කරනු ඇත.",
            verbTransformation = "detected → identify → will eliminate"
          ),
          TenseSentenceItem(
            id = "t16_s27",
            baseActionSinhala = "මූල්‍ය සාක්ෂරතාව ලබා ගැනීම",
            pastEnglish = "Students learned compound interest formulas in maths class.",
            pastSinhala = "සිසුහු ගණිත පන්තියේදී වැල් පොලී සූත්‍ර ඉගෙන ගත්හ.",
            presentEnglish = "Financial literacy empowers citizens to make sound choices.",
            presentSinhala = "මූල්‍ය සාක්ෂරතාව පුරවැසියන්ට නිවැරදි තීරණ ගැනීමට ශක්තියක් වේ.",
            futureEnglish = "We will study personal taxation next term.",
            futureSinhala = "අපි ලබන වාරයේදී පෞද්ගලික බදුකරණය ගැන හදාරන්නෙමු.",
            verbTransformation = "learned → empowers → will study"
          ),
          TenseSentenceItem(
            id = "t16_s28",
            baseActionSinhala = "විශ්වාසවන්තව මුදල් රැකීම",
            pastEnglish = "The treasurer safeguarded the sports club funds honestly.",
            pastSinhala = "භාණ්ඩාගාරිකවරයා ක්‍රීඩා සමාජයේ අරමුදල් අවංකව සුරැකුවේය.",
            presentEnglish = "Integrity is the cornerstone of successful accounting.",
            presentSinhala = "අවංකකම සාර්ථක ගණකාධිකරණයේ මුල්ගල වේ.",
            futureEnglish = "The audit committee will inspect all vouchers thoroughly.",
            futureSinhala = "විගණන කමිටුව සියලුම ලේඛන හොඳින් පරීක්ෂා කරනු ඇත.",
            verbTransformation = "safeguarded → is → will inspect"
          ),
          TenseSentenceItem(
            id = "t16_s29",
            baseActionSinhala = "අනාගතයට මුදල් වෙන් කිරීම",
            pastEnglish = "Parents allocated money for their children's higher education.",
            pastSinhala = "දෙමාපියෝ තම දරුවන්ගේ උසස් අධ්‍යාපනය සඳහා මුදල් වෙන් කළහ.",
            presentEnglish = "Early savings guarantee peaceful retirement years.",
            presentSinhala = "කලින්ම ඉතිරි කිරීම සාමකාමී විශ්‍රාම ජීවිතයක් සහතික කරයි.",
            futureEnglish = "I will build a strong emergency reserve fund.",
            futureSinhala = "මම ශක්තිමත් හදිසි ආපදා අරමුදලක් ගොඩනඟන්නෙමි.",
            verbTransformation = "allocated → guarantee → will build"
          ),
          TenseSentenceItem(
            id = "t16_s30",
            baseActionSinhala = "මූල්‍ය නිදහස ළඟා කර ගැනීම",
            pastEnglish = "Sunil achieved financial independence through diligence.",
            pastSinhala = "සුනිල් කැපවීම තුළින් මූල්‍ය නිදහස ළඟා කර ගත්තේය.",
            presentEnglish = "Wise monetary discipline creates lasting prosperity.",
            presentSinhala = "ඥානවන්ත මුදල් විනය දිගුකාලීන සෞභාග්‍යය උදා කරයි.",
            futureEnglish = "You will manage your earnings wisely and prosper.",
            futureSinhala = "ඔබ ඔබේ ඉපැයීම් බුද්ධිමත්ව කළමනාකරණය කර සමෘද්ධිමත් වනු ඇත.",
            verbTransformation = "achieved → creates → will manage"
          )
        )
      ),

      // ==========================================
      // Category 17: සතුන් සහ සුරතල් සතුන් රැකබලා ගැනීම (Animals & Pet Care) - 30 items
      // ==========================================
      TenseComparisonCategory(
        id = 17,
        titleSinhala = "කාණ්ඩය 17: සතුන් සහ සුරතල් සතුන් රැකබලා ගැනීම",
        titleEnglish = "Animals & Pet Care",
        icon = "🐾",
        description = "සුරතල් සතුන්ට කෑම දීම, පශු වෛද්‍ය ප්‍රතිකාර, වන සතුන් ආරක්ෂා කිරීම සහ සත්ව කරුණාව පිළිබඳ වාක්‍ය 30ක් කාල තුනෙන්ම.",
        sentences = listOf(
          TenseSentenceItem(
            id = "t17_s1",
            baseActionSinhala = "සුනඛයාට කෑම දීම",
            pastEnglish = "I fed our pet dog rice and boiled chicken yesterday.",
            pastSinhala = "මම ඊයේ අපේ සුරතල් බල්ලාට බත් සහ තම්බපු කුකුළු මස් කෑමට දුනිමි.",
            presentEnglish = "I feed our pet dog twice every single day.",
            presentSinhala = "මම සෑම දිනකම දෙවරක් අපේ සුරතල් බල්ලාට කෑම දෙමි.",
            futureEnglish = "I will feed the puppy after returning from school.",
            futureSinhala = "පාසල නිමවී පැමිණි පසු මම බලු පැටියාට කෑම දෙන්නෙමි.",
            verbTransformation = "fed → feed → will feed"
          ),
          TenseSentenceItem(
            id = "t17_s2",
            baseActionSinhala = "පූසා සුරතල් කිරීම",
            pastEnglish = "Sister stroked the white kitten gently.",
            pastSinhala = "නංගී සුදු පූස් පැටියා ආදරයෙන් සුරතල් කළාය.",
            presentEnglish = "Cats purr contentedly when you stroke their fur.",
            presentSinhala = "පූසන්ගේ ලොම් පිරිමදින විට උන් සතුටින් හඬ නඟති.",
            futureEnglish = "She will stroke the sleeping kitten quietly.",
            futureSinhala = "ඇය නිදා සිටින පූස් පැටියා නිහඬව අතගානු ඇත.",
            verbTransformation = "stroked → purr → will stroke"
          ),
          TenseSentenceItem(
            id = "t17_s3",
            baseActionSinhala = "සුනඛයා ඇවිද්දවීම",
            pastEnglish = "Kamal walked his dog in the park this morning.",
            pastSinhala = "කමල් අද උදෑසන තම බල්ලා උද්‍යානයේ ඇවිද්දුවේය.",
            presentEnglish = "Pet owners walk their dogs to maintain their health.",
            presentSinhala = "සුරතල් සතුන් ඇති කරන්නෝ උන්ගේ සෞඛ්‍යය සඳහා බල්ලන් ඇවිද්දවති.",
            futureEnglish = "Kamal will walk his dog along the beach at sunset.",
            futureSinhala = "ඉර බසින වේලාවේදී කමල් තම බල්ලා වෙරළ දිගේ ඇවිද්දවනු ඇත.",
            verbTransformation = "walked → walk → will walk"
          ),
          TenseSentenceItem(
            id = "t17_s4",
            baseActionSinhala = "කුරුල්ලන්ට ධාන්‍ය දැමීම",
            pastEnglish = "Grandma scattered paddy seeds for wild birds in the lawn.",
            pastSinhala = "ආච්චි මිදුලේ වන කුරුල්ලන්ට වී ඇට ඉස්සාය.",
            presentEnglish = "Sparrows and doves peck grains from the garden feeder.",
            presentSinhala = "ගේකුරුල්ලෝ සහ පරෙවියෝ වත්තේ කුරුළු කූඩුවෙන් ධාන්‍ය කොටා කති.",
            futureEnglish = "She will scatter birdseed every morning on the verandah.",
            futureSinhala = "ඇය සෑම උදෑසනකම ඉස්තෝප්පුවේ කුරුළු ධාන්‍ය දමනු ඇත.",
            verbTransformation = "scattered → peck → will scatter"
          ),
          TenseSentenceItem(
            id = "t17_s5",
            baseActionSinhala = "පශු වෛද්‍යවරයා වෙත ගෙන යාම",
            pastEnglish = "Father took the sick puppy to the veterinary clinic.",
            pastSinhala = "තාත්තා අසනීප වූ බලු පැටියා පශු වෛද්‍ය සායනයට ගෙන ගියේය.",
            presentEnglish = "Veterinarians administer vaccines to guard against rabies.",
            presentSinhala = "පශු වෛද්‍යවරු ජලභීතිකා රෝගයට එරෙහිව එන්නත් ලබා දෙති.",
            futureEnglish = "We will take our cat for rabies vaccination tomorrow.",
            futureSinhala = "අපි හෙට අපේ පූසා ජලභීතිකා එන්නත ලබා දීමට ගෙන යන්නෙමු.",
            verbTransformation = "took → administer → will take"
          ),
          TenseSentenceItem(
            id = "t17_s6",
            baseActionSinhala = "සුනඛයා නෑවීම",
            pastEnglish = "I bathed our brown dog with herbal shampoo.",
            pastSinhala = "මම ඖෂධීය ෂැම්පු භාවිතයෙන් අපේ දුඹුරු බල්ලා නැහැව්වෙමි.",
            presentEnglish = "Regular bathing keeps pets free of ticks and fleas.",
            presentSinhala = "නිතිපතා නෑවීම සුරතල් සතුන් මැක්කන්ගෙන් තොරව තබයි.",
            futureEnglish = "I will bathe the dog on Saturday afternoon.",
            futureSinhala = "මම සෙනසුරාදා දහවල් බල්ලා නාවන්නෙමි.",
            verbTransformation = "bathed → keeps → will bathe"
          ),
          TenseSentenceItem(
            id = "t17_s7",
            baseActionSinhala = "මාළු ටැංකිය පිරිසිදු කිරීම",
            pastEnglish = "Kasun cleaned the aquarium glass and replaced fresh water.",
            pastSinhala = "කසුන් මාළු ටැංකියේ වීදුරු පිරිසිදු කර නැවුම් ජලය දැමුවේය.",
            presentEnglish = "Aquarium filters keep water oxygenated for colorful fish.",
            presentSinhala = "මාළු ටැංකි පෙරහන් වර්ණවත් මසුන් සඳහා ජලයේ ඔක්සිජන් මට්ටම පවත්වා ගනී.",
            futureEnglish = "Kasun will feed goldfish flakes in the evening.",
            futureSinhala = "කසුන් සවස රන් මසුන්ට කෑම දමනු ඇත.",
            verbTransformation = "cleaned → keep → will feed"
          ),
          TenseSentenceItem(
            id = "t17_s8",
            baseActionSinhala = "එළදෙනගෙන් කිරි දෙවීම",
            pastEnglish = "The farmer milked the dairy cow at 5:30 AM.",
            pastSinhala = "ගොවියා උදෑසන 5:30 ට එළදෙනගෙන් කිරි දෙවීය.",
            presentEnglish = "Healthy cows yield nutritious fresh milk daily.",
            presentSinhala = "නිරෝගී එළදෙනුන් දිනපතා පෝෂ්‍යදායී නැවුම් කිරි ලබා දෙයි.",
            futureEnglish = "He will pasture the cattle on green grasslands.",
            futureSinhala = "ඔහු ගවයන් නිල් තණබිම්වල තණ කැවීමට ගෙන යනු ඇත.",
            verbTransformation = "milked → yield → will pasture"
          ),
          TenseSentenceItem(
            id = "t17_s9",
            baseActionSinhala = "වන සතුන් ආරක්ෂා කිරීම",
            pastEnglish = "Rangers rescued a trapped baby elephant from a ditch.",
            pastSinhala = "වනජීවී නිලධාරීහු කාණුවක සිරවී සිටි අලි පැටවෙකු බේරා ගත්හ.",
            presentEnglish = "National wildlife parks protect endangered leopards and bears.",
            presentSinhala = "ජාතික වනෝද්‍යාන වඳවීමේ තර්ජනයට ලක්ව ඇති කොටියන් සහ වලසුන් ආරක්ෂා කරයි.",
            futureEnglish = "Authorities will establish electric fences to curb conflicts.",
            futureSinhala = "ගැටුම් අවම කිරීම සඳහා බලධාරීන් විදුලි වැටවල් ඉදිකරනු ඇත.",
            verbTransformation = "rescued → protect → will establish"
          ),
          TenseSentenceItem(
            id = "t17_s10",
            baseActionSinhala = "කුරුළු කූඩුවක් නිරීක්ෂණය කිරීම",
            pastEnglish = "The children noticed a tailorbird's nest stitched under a leaf.",
            pastSinhala = "කොළයක් යට මසා තිබූ බට්ටිච්චාගේ කූඩුවක් ළමයින් දුටුවාහ.",
            presentEnglish = "Birds weave marvelous nests with grass and fiber.",
            presentSinhala = "කුරුල්ලෝ තණකොළ සහ කෙඳි වලින් විස්මිත කූඩු වියති.",
            futureEnglish = "Baby chicks will hatch within a fortnight.",
            futureSinhala = "සති දෙකක් ඇතුළත කුරුළු පැටවුන් බිත්තර වලින් එළියට එනු ඇත.",
            verbTransformation = "noticed → weave → will hatch"
          ),
          TenseSentenceItem(
            id = "t17_s11",
            baseActionSinhala = "සුනඛයා බිරීම",
            pastEnglish = "The watchdog barked fiercely at the trespasser.",
            pastSinhala = "මුර බල්ලා අනවසරයෙන් ඇතුළු වූ තැනැත්තාට සැරෙන් බුරුවේය.",
            presentEnglish = "Vigilant guard dogs bark to alert homeowners of intruders.",
            presentSinhala = "සෝදිසියෙන් සිටින මුර බල්ලෝ ආගන්තුකයන් ගැන නිවැසියන්ට අනතුරු අඟවති.",
            futureEnglish = "He will wag his tail when he recognizes your voice.",
            futureSinhala = "ඔබේ කටහඬ හඳුනාගත් විට ඌ වලිගය වනනු ඇත.",
            verbTransformation = "barked → bark → will wag"
          ),
          TenseSentenceItem(
            id = "t17_s12",
            baseActionSinhala = "සතුන්ට කරුණාව දැක්වීම",
            pastEnglish = "Lord Buddha preached compassion towards all sentient beings.",
            pastSinhala = "බුදුරජාණන් වහන්සේ සියලු සත්වයන් කෙරෙහි කරුණාව දැක්වීම දේශනා කළ සේක.",
            presentEnglish = "Kindhearted people treat stray animals with tenderness.",
            presentSinhala = "කාරුණික මිනිස්සු අතරමං වූ සතුන්ට ආදරයෙන් සලකති.",
            futureEnglish = "We will build a wooden shelter for stray puppies.",
            futureSinhala = "අපි අතරමං වූ බලු පැටවුන්ට ලී ආවරණයක් හදන්නෙමු.",
            verbTransformation = "preached → treat → will build"
          ),
          TenseSentenceItem(
            id = "t17_s13",
            baseActionSinhala = "කුකුළන් රැකබලා ගැනීම",
            pastEnglish = "Mother gathered ten fresh eggs from the coop.",
            pastSinhala = "අම්මා කූඩුවෙන් නැවුම් බිත්තර දහයක් එකතු කර ගත්තාය.",
            presentEnglish = "Roosters crow loudly at the break of dawn.",
            presentSinhala = "පාන්දර උදාවත් සමඟම කුකුළෝ මහ හඬින් හඬලති.",
            futureEnglish = "We will let the free-range hens forage in the garden.",
            futureSinhala = "අපි කිකිළියන්ට මිදුලේ ඇවිද කෑම සොයා ගැනීමට ඉඩ හරින්නෙමු.",
            verbTransformation = "gathered → crow → will let"
          ),
          TenseSentenceItem(
            id = "t17_s14",
            baseActionSinhala = "හාවෙකුට කැරට් දීම",
            pastEnglish = "The little girl fed crunchy carrots to her pet rabbit.",
            pastSinhala = "කුඩා දැරිය තම සුරතල් හාවාට හැපෙන කැරට් කෑමට දුන්නාය.",
            presentEnglish = "Rabbits nibble green leaves with their sharp teeth.",
            presentSinhala = "හාවෝ තියුණු දත් වලින් කොළ පැහැති කොළ සපා කති.",
            futureEnglish = "She will build a soft straw bed for the bunny.",
            futureSinhala = "ඇය හාවා වෙනුවෙන් මෘදු පිදුරු ඇඳක් සකස් කරනු ඇත.",
            verbTransformation = "fed → nibble → will build"
          ),
          TenseSentenceItem(
            id = "t17_s15",
            baseActionSinhala = "මීමැස්සන් පාලනය",
            pastEnglish = "The beekeeper harvested pure organic honey from the hive.",
            pastSinhala = "මීමැසි පාලකයා වදයෙන් පිරිසිදු ස්වභාවික මීපැණි නෙළා ගත්තේය.",
            presentEnglish = "Bees pollinate blooming flowers and sustain agriculture.",
            presentSinhala = "මීමැස්සෝ පිපෙන මල් පරාගනය කරමින් කෘෂිකර්මාන්තය පවත්වා ගනිති.",
            futureEnglish = "We will install wooden bee boxes in the orchard.",
            futureSinhala = "අපි පළතුරු වත්තේ ලී මීමැසි පෙට්ටි සවි කරන්නෙමු.",
            verbTransformation = "harvested → pollinate → will install"
          ),
          TenseSentenceItem(
            id = "t17_s16",
            baseActionSinhala = "අශ්වයෙකු පිට නැගීම",
            pastEnglish = "The jockey rode the thoroughbred horse across the turf.",
            pastSinhala = "අශ්වාරෝහකයා තණබිම හරහා අශ්වයා පිට නැගී ගියේය.",
            presentEnglish = "Equestrian riders train horses with gentle discipline.",
            presentSinhala = "අශ්වාරෝහකයෝ මෘදු විනයකින් අශ්වයන් පුහුණු කරති.",
            futureEnglish = "We will watch horse racing at Nuwara Eliya next April.",
            futureSinhala = "ලබන අප්‍රේල් මාසයේදී අපි නුවරඑළියේ අශ්ව රේස් තරඟ නරඹන්නෙමු.",
            verbTransformation = "rode → train → will watch"
          ),
          TenseSentenceItem(
            id = "t17_s17",
            baseActionSinhala = "සමනලුන් නැරඹීම",
            pastEnglish = "We spotted a vibrant Ceylon Birdwing butterfly.",
            pastSinhala = "අපි විචිත්‍රවත් ලංකා පක්ෂිපියාපත් සමනලයෙකු දුටුවෙමු.",
            presentEnglish = "Butterflies flutter gracefully among nectar-rich flowers.",
            presentSinhala = "සමනල්ලු පැණි පිරි මල් අතර අලංකාරව පියාසර කරති.",
            futureEnglish = "We will plant nectar plants to attract butterflies.",
            futureSinhala = "සමනලුන් ආකර්ෂණය කර ගැනීමට අපි මල් පැල සිටුවන්නෙමු.",
            verbTransformation = "spotted → flutter → will plant"
          ),
          TenseSentenceItem(
            id = "t17_s18",
            baseActionSinhala = "සත්ව හිංසනය වැළැක්වීම",
            pastEnglish = "Activists protested against cruelty towards captive animals.",
            pastSinhala = "ක්‍රියාකාරීහු සිරකර තැබූ සතුන්ට එරෙහි හිංසනයට විරෝධය දැක්වූහ.",
            presentEnglish = "Humane societies advocate animal rights and protection.",
            presentSinhala = "මානව හිතවාදී සංවිධාන සත්ව අයිතිවාසිකම් සහ ආරක්ෂාව වෙනුවෙන් පෙනී සිටිති.",
            futureEnglish = "The parliament will pass a strict animal welfare bill.",
            futureSinhala = "පාර්ලිමේන්තුව දැඩි සත්ව සුබසාධන පනත් කෙටුම්පතක් සම්මත කරනු ඇත.",
            verbTransformation = "protested → advocate → will pass"
          ),
          TenseSentenceItem(
            id = "t17_s19",
            baseActionSinhala = "කැස්බෑවුන් ආරක්ෂා කිරීම",
            pastEnglish = "Volunteers released baby turtles into the ocean at night.",
            pastSinhala = "ස්වේච්ඡා සේවකයෝ රාත්‍රියේදී කැස්බෑ පැටවුන් සාගරයට මුදා හැරියහ.",
            presentEnglish = "Sea turtle hatcheries protect eggs from beach predators.",
            presentSinhala = "මුහුදු කැස්බෑ අභිජනනාගාර වෙරළබඩ සතුන්ගෙන් බිත්තර ආරක්ෂා කරයි.",
            futureEnglish = "We will patrol the Kosgoda nesting beaches tomorrow.",
            futureSinhala = "අපි හෙට කොස්ගොඩ බිත්තර දමන වෙරළ තීරයන්හි මුර සංචාරය කරන්නෙමු.",
            verbTransformation = "released → protect → will patrol"
          ),
          TenseSentenceItem(
            id = "t17_s20",
            baseActionSinhala = "මුව රංචුවක් දැකීම",
            pastEnglish = "We observed spotted deer grazing in Yala National Park.",
            pastSinhala = "අපි යාල ජාතික වනෝද්‍යානයේ තිත් මුවන් තණ කනවා දුටුවෙමු.",
            presentEnglish = "Deer flee swiftly at the scent of an approaching leopard.",
            presentSinhala = "ළඟා වන කොටියෙකුගේ සුවඳ දැනුණු වහාම මුවෝ වේගයෙන් පලා යති.",
            futureEnglish = "We will photograph wild herds from the safari jeep.",
            futureSinhala = "අපි සෆාරි ජිප් රථයේ සිට වන සත්ව රංචු ඡායාරූප ගත කරන්නෙමු.",
            verbTransformation = "observed → flee → will photograph"
          ),
          TenseSentenceItem(
            id = "t17_s21",
            baseActionSinhala = "සුරතලාට බෙහෙත් පෙති පෙවීම",
            pastEnglish = "I gave the deworming pill hidden inside a banana.",
            pastSinhala = "මම කෙසෙල් ගෙඩියක් තුළ සඟවා පණු බෙහෙත් පෙත්ත පෙව්වෙමි.",
            presentEnglish = "Regular deworming maintains pets' digestive health.",
            presentSinhala = "නිතිපතා පණු බෙහෙත් දීම සුරතලුන්ගේ ආහාර ජීර්ණ සෞඛ්‍යය සුරකියි.",
            futureEnglish = "I will give his vitamins after mealtime.",
            futureSinhala = "කෑම වේලාවෙන් පසු මම ඔහුගේ විටමින් පෙති දෙන්නෙමි.",
            verbTransformation = "gave → maintains → will give"
          ),
          TenseSentenceItem(
            id = "t17_s22",
            baseActionSinhala = "වඳුරන්ගෙන් වගාව ආරක්ෂා කර ගැනීම",
            pastEnglish = "The gardener chased monkeys away from the fruit trees.",
            pastSinhala = "වතුපාලකයා පලතුරු ගස්වලින් වඳුරන් එළවා දැමුවේය.",
            presentEnglish = "Netting shields ripe mangoes from foraging troops.",
            presentSinhala = "දැල් දැමීම ඉදුණු අඹ වඳුරු රංචුවලින් ආරක්ෂා කරයි.",
            futureEnglish = "We will install bird netting over the strawberry patch.",
            futureSinhala = "අපි ස්ට්‍රෝබෙරි පාත්ති මත කුරුළු දැල් සවි කරන්නෙමු.",
            verbTransformation = "chased → shields → will install"
          ),
          TenseSentenceItem(
            id = "t17_s23",
            baseActionSinhala = "පරෙවියන්ට කූඩු තැනීම",
            pastEnglish = "Grandpa constructed a cozy wooden dove house.",
            pastSinhala = "සීයා සුවපහසු ලී පරෙවි කූඩුවක් හැදුවේය.",
            presentEnglish = "Doves coo peacefully on the red clay roof tiles.",
            presentSinhala = "රතු මැටි උළු මත පරෙවියෝ සාමකාමීව නාද කරති.",
            futureEnglish = "A pair of white pigeons will nest inside the box.",
            futureSinhala = "සුදු පරෙවි ජෝඩුවක් පෙට්ටිය තුළ කූඩු තනනු ඇත.",
            verbTransformation = "constructed → coo → will nest"
          ),
          TenseSentenceItem(
            id = "t17_s24",
            baseActionSinhala = "අලින්ට පලතුරු දීම",
            pastEnglish = "Pilgrims offered ripe watermelons to the temple elephant.",
            pastSinhala = "බැතිමත්හු විහාරස්ථාන ඇතාට ඉදුණු පැණි කොමඩු පූජා කළහ.",
            presentEnglish = "Mahouts bathe domestic elephants in gentle river streams.",
            presentSinhala = "ඇත්ගොව්වෝ ගෘහාශ්‍රිත අලි ඇතුන් ගංගා දියෙහි නාවති.",
            futureEnglish = "We will visit the Pinnawala Elephant Orphanage next Sunday.",
            futureSinhala = "අපි ලබන ඉරිදා පින්නවල අලි අනාථාගාරය නරඹන්නෙමු.",
            verbTransformation = "offered → bathe → will visit"
          ),
          TenseSentenceItem(
            id = "t17_s25",
            baseActionSinhala = "බළලුන් සීරීම වැළැක්වීම",
            pastEnglish = "I bought a scratching post for our kitten.",
            pastSinhala = "මම අපේ පූස් පැටියා සඳහා සීරීමේ ලී කණුවක් මිලදී ගත්තෙමි.",
            presentEnglish = "Scratching keeps cats' claws sharp and clean.",
            presentSinhala = "සීරීම පූසන්ගේ නියපොතු තියුණුව සහ පිරිසිදුව තබයි.",
            futureEnglish = "He will play with the yarn ball on the carpet.",
            futureSinhala = "ඌ කාපට් එක මත නූල් බෝලය සමඟ සෙල්ලම් කරනු ඇත.",
            verbTransformation = "bought → keeps → will play"
          ),
          TenseSentenceItem(
            id = "t17_s26",
            baseActionSinhala = "මස් කෑමෙන් වැළකී සිටීම",
            pastEnglish = "Many Buddhists abstained from meat on Vesak Poya.",
            pastSinhala = "බොහෝ බෞද්ධයෝ වෙසක් පෝය දින මස් මාංශ අනුභවයෙන් වැළකී සිටියහ.",
            presentEnglish = "Vegetarian diets promote compassion towards harmless animals.",
            presentSinhala = "නිර්මාංශ ආහාර අහිංසක සතුන් කෙරෙහි කරුණාව වර්ධනය කරයි.",
            futureEnglish = "I will follow a plant-based diet throughout this week.",
            futureSinhala = "මම මේ සතිය පුරාම ශාකමය ආහාර වේලක් අනුගමනය කරන්නෙමු.",
            verbTransformation = "abstained → promote → will follow"
          ),
          TenseSentenceItem(
            id = "t17_s27",
            baseActionSinhala = "සත්ව නාමාවලියක් සෑදීම",
            pastEnglish = "The zoologist documented endemic birds of Sinharaja forest.",
            pastSinhala = "සත්ව විද්‍යාඥයා සිංහරාජ වනාන්තරයේ ආවේණික පක්ෂීන් ලේඛනගත කළේය.",
            presentEnglish = "Sri Lanka harbors unique species found nowhere else on Earth.",
            presentSinhala = "ශ්‍රී ලංකාව මිහිතලයේ වෙන කොහේවත් දක්නට නොලැබෙන සුවිශේෂී සත්ව විශේෂයන්ට තෝතැන්නකි.",
            futureEnglish = "Scientists will discover new amphibian species in the rainforest.",
            futureSinhala = "විද්‍යාඥයෝ වැසි වනාන්තරයෙන් නව උභයජීවී විශේෂ සොයා ගනු ඇත.",
            verbTransformation = "documented → harbors → will discover"
          ),
          TenseSentenceItem(
            id = "t17_s28",
            baseActionSinhala = "සුනඛයාට පුහුණුව දීම",
            pastEnglish = "The trainer taught the dog to sit on command.",
            pastSinhala = "පුහුණුකරු අණ කළ විට වාඩි වීමට බල්ලාට ඉගැන්වීය.",
            presentEnglish = "Smart dogs learn agility tricks quickly through rewards.",
            presentSinhala = "දක්ෂ බල්ලෝ ත්‍යාග මඟින් ඉක්මනින් උපක්‍රම ඉගෙන ගනිති.",
            futureEnglish = "I will teach him to fetch the rubber ball.",
            futureSinhala = "රබර් බෝලය රැගෙන ඒමට මම ඌට උගන්වන්නෙමි.",
            verbTransformation = "taught → learn → will teach"
          ),
          TenseSentenceItem(
            id = "t17_s29",
            baseActionSinhala = "කුරුළු නාදය අසා සිටීම",
            pastEnglish = "We woke up to the melodious morning chorus of songbirds.",
            pastSinhala = "ගීතවත් පක්ෂීන්ගේ උදෑසන නාද රටාවට අපි අවදි වුණෙමු.",
            presentEnglish = "Birdwatching calms the mind and inspires nature study.",
            presentSinhala = "කුරුල්ලන් නැරඹීම මනස සන්සුන් කර සොබාදහම අධ්‍යයනයට පෙළඹවයි.",
            futureEnglish = "We will identify distinct bird calls with binoculars tomorrow.",
            futureSinhala = "අපි හෙට දුරදක්නය භාවිතයෙන් විවිධ පක්ෂි හඬවල් හඳුනා ගන්නෙමු.",
            verbTransformation = "woke up → calms → will identify"
          ),
          TenseSentenceItem(
            id = "t17_s30",
            baseActionSinhala = "ජෛව විවිධත්වය සුරැකීම",
            pastEnglish = "Conservationists created protected bio-corridors for wild species.",
            pastSinhala = "සංරක්ෂණවේදීහු වන සතුන් සඳහා ආරක්ෂිත ජෛව කොරිඩෝ නිර්මාණය කළහ.",
            presentEnglish = "Every living creature plays a vital role in our ecosystem.",
            presentSinhala = "සෑම ජීවියෙකුම අපගේ පරිසර පද්ධතියේ වැදගත් කාර්යභාරයක් ඉටු කරයි.",
            futureEnglish = "We will protect nature's innocent fauna with profound dedication.",
            futureSinhala = "අපි සොබාදහමේ අහිංසක සත්ව ප්‍රජාව ඉමහත් කැපවීමෙන් ආරක්ෂා කරන්නෙමු.",
            verbTransformation = "created → plays → will protect"
          )
        )
      ),

      // ==========================================
      // Category 18: ගොවිතැන, කෘෂිකර්මාන්තය සහ ගෙවතු වගාව (Farming, Agriculture & Gardening) - 30 items
      // ==========================================
      TenseComparisonCategory(
        id = 18,
        titleSinhala = "කාණ්ඩය 18: ගොවිතැන, කෘෂිකර්මාන්තය සහ ගෙවතු වගාව",
        titleEnglish = "Farming, Agriculture & Gardening",
        icon = "🌾",
        description = "කුඹුරු ගොවිතැන, පැළ සිටුවීම, පොහොර දැමීම, අස්වැන්න නෙළීම සහ ගෙවතු වගාව පිළිබඳ වාක්‍ය 30ක් කාල තුනෙන්ම.",
        sentences = listOf(
          TenseSentenceItem(
            id = "t18_s1",
            baseActionSinhala = "කුඹුර සී සෑම",
            pastEnglish = "The farmer ploughed the paddy field using water buffaloes.",
            pastSinhala = "ගොවියා මී හරකුන් යොදාගෙන කුඹුර සී සෑවේය.",
            presentEnglish = "Modern farmers plough fertile soil with two-wheel tractors.",
            presentSinhala = "නවීන ගොවීහු අත් ට්‍රැක්ටර් භාවිතයෙන් සාරවත් පස සී සාති.",
            futureEnglish = "He will plough the lower field before the monsoon rains.",
            futureSinhala = "මෝසම් වැස්සට පෙර ඔහු පහළ කුඹුර සී සානු ඇත.",
            verbTransformation = "ploughed → plough → will plough"
          ),
          TenseSentenceItem(
            id = "t18_s2",
            baseActionSinhala = "වී වැපිරීම",
            pastEnglish = "They sowed sprouted seed paddy across the muddy field.",
            pastSinhala = "මඩ කුඹුර පුරා ඔවුහු පැළ වූ බිත්තර වී වැපිරූහ.",
            presentEnglish = "Farmers sow traditional organic varieties for resilience.",
            presentSinhala = "ගොවීහු ශක්තිමත් බව සඳහා සාම්ප්‍රදායික දේශීය වී වර්ග වපුරති.",
            futureEnglish = "We will sow modern hybrid seeds next week.",
            futureSinhala = "අපි ලබන සතියේ නව දෙමුහුන් බීජ වපුරන්නෙමු.",
            verbTransformation = "sowed → sow → will sow"
          ),
          TenseSentenceItem(
            id = "t18_s3",
            baseActionSinhala = "ගොයම් පැළ සිටුවීම",
            pastEnglish = "Women transplanted young rice seedlings in neat rows.",
            pastSinhala = "කාන්තාවෝ පිළිවෙළට පේළි දිගේ ළපටි ගොයම් පැළ සිටුවූහ.",
            presentEnglish = "Transplanting seedlings promotes uniform robust growth.",
            presentSinhala = "පැළ සිටුවීම ඒකාකාරී ශක්තිමත් වර්ධනයකට මඟ පාදයි.",
            futureEnglish = "They will transplant seedlings early tomorrow morning.",
            futureSinhala = "ඔවුහු හෙට අලුයම පැළ සිටුවනු ඇත.",
            verbTransformation = "transplanted → promotes → will transplant"
          ),
          TenseSentenceItem(
            id = "t18_s4",
            baseActionSinhala = "පැලවලට වතුර දැමීම",
            pastEnglish = "I watered the tomato plants in my home garden.",
            pastSinhala = "මම මගේ ගෙවත්තේ තක්කාලි පැලවලට වතුර දැමුවෙමි.",
            presentEnglish = "Gardeners water delicate flowers at dawn and dusk.",
            presentSinhala = "වතුපාලකයෝ අලුයම සහ සන්ධ්‍යා කාලයේදී සුකුමාල මල්වලට වතුර දමති.",
            futureEnglish = "I will water the nursery beds this evening.",
            futureSinhala = "මම අද සවස තවාන් පාත්තිවලට වතුර දමන්නෙමි.",
            verbTransformation = "watered → water → will water"
          ),
          TenseSentenceItem(
            id = "t18_s5",
            baseActionSinhala = "කොම්පෝස්ට් පොහොර යෙදීම",
            pastEnglish = "Father mixed organic compost into the vegetable beds.",
            pastSinhala = "තාත්තා එළවළු පාත්තිවලට කාබනික කොම්පෝස්ට් පොහොර මිශ්‍ර කළේය.",
            presentEnglish = "Organic compost enriches soil fertility naturally.",
            presentSinhala = "කාබනික කොම්පෝස්ට් පොහොර පසේ සාරවත් බව ස්වභාවිකව වැඩි කරයි.",
            futureEnglish = "He will apply compost before planting chillies.",
            futureSinhala = "මිරිස් පැළ සිටුවීමට පෙර ඔහු කොම්පෝස්ට් යොදනු ඇත.",
            verbTransformation = "mixed → enriches → will apply"
          ),
          TenseSentenceItem(
            id = "t18_s6",
            baseActionSinhala = "වල් පැළෑටි උදුරා දැමීම",
            pastEnglish = "Mother weeded the cabbage patch diligently.",
            pastSinhala = "අම්මා ගෝවා පාත්තියේ වල් පැළෑටි උනන්දුවෙන් උදුරා දැමුවාය.",
            presentEnglish = "Weeding removes invasive plants that steal nutrients.",
            presentSinhala = "වල් නෙලීම පෝෂ්‍ය පදාර්ථ උරා ගන්නා ආක්‍රමණශීලී පැළෑටි ඉවත් කරයි.",
            futureEnglish = "We will weed the onion plot on Saturday.",
            futureSinhala = "අපි සෙනසුරාදා ලූනු පාත්තියේ වල් නෙළන්නෙමු.",
            verbTransformation = "weeded → removes → will weed"
          ),
          TenseSentenceItem(
            id = "t18_s7",
            baseActionSinhala = "ගොයම් කැපීම",
            pastEnglish = "The harvesters cut golden paddy stalks with sharp sickles.",
            pastSinhala = "අස්වනු නෙළන්නෝ තියුණු දෑකැතිවලින් රන්වන් ගොයම් කරල් කැපූහ.",
            presentEnglish = "Combine harvesters reap and thresh grain in a single pass.",
            presentSinhala = "ඒකාබද්ධ අස්වනු නෙළන යන්ත්‍ර එකවර ගොයම් කපා පාගයි.",
            futureEnglish = "Farmers will harvest the Maha crop next month.",
            futureSinhala = "ගොවීහු ලබන මාසයේ මහ කන්නයේ අස්වැන්න නෙළනු ඇත.",
            verbTransformation = "cut → reap → will harvest"
          ),
          TenseSentenceItem(
            id = "t18_s8",
            baseActionSinhala = "වී පාගා ගැනීම",
            pastEnglish = "Villagers threshed the harvested sheaves on the threshing floor.",
            pastSinhala = "ගම්වැසියෝ කමතේදී කපාගත් ගොයම් කරල් පෑගූහ.",
            presentEnglish = "Threshing machines separate grains from golden straw cleanly.",
            presentSinhala = "වී පාගන යන්ත්‍ර රන්වන් පිදුරුවලින් ධාන්‍ය පිරිසිදුව වෙන් කරයි.",
            futureEnglish = "We will thresh the Yala harvest on the weekend.",
            futureSinhala = "අපි සති අන්තයේ යල කන්නයේ අස්වැන්න පාගන්නෙමු.",
            verbTransformation = "threshed → separate → will thresh"
          ),
          TenseSentenceItem(
            id = "t18_s9",
            baseActionSinhala = "වී වේලීම",
            pastEnglish = "They spread golden paddy grains on mats to dry under the sun.",
            pastSinhala = "ඔවුහු අව්වේ වේලීම සඳහා පැදුරු මත රන්වන් වී ඇට ඇතිරූහ.",
            presentEnglish = "Drying paddy reduces moisture content to prevent fungus.",
            presentSinhala = "වී වේලීම දිලීර ඇතිවීම වැළැක්වීමට තෙතමනය අඩු කරයි.",
            futureEnglish = "We will bag the dry grain into jute sacks.",
            futureSinhala = "අපි වේළුණු වී ගෝනිවලට අසුරන්නෙමු.",
            verbTransformation = "spread → reduces → will bag"
          ),
          TenseSentenceItem(
            id = "t18_s10",
            baseActionSinhala = "පොල් කැඩීම",
            pastEnglish = "The climber plucked thirty mature coconuts from the palm.",
            pastSinhala = "ගස් නගින්නා පොල් ගසෙන් පැසුණු පොල් ගෙඩි තිහක් කැඩුවේය.",
            presentEnglish = "Tall coconut palms yield nuts every two months.",
            presentSinhala = "උස පොල් ගස් සෑම මස දෙකකට වරක් ගෙඩි ලබා දෙයි.",
            futureEnglish = "He will pluck the king coconuts tomorrow afternoon.",
            futureSinhala = "ඔහු හෙට දහවල් තැඹිලි ගෙඩි කඩනු ඇත.",
            verbTransformation = "plucked → yield → will pluck"
          ),
          TenseSentenceItem(
            id = "t18_s11",
            baseActionSinhala = "තේ දළු නෙළීම",
            pastEnglish = "Tea pluckers plucked two leaves and a bud with agile fingers.",
            pastSinhala = "දළු නෙළන්නියෝ වේගවත් ඇඟිලිවලින් දළු දෙකයි එක් මලයි නෙළූහ.",
            presentEnglish = "Fresh green tea leaves produce world-renowned Ceylon tea.",
            presentSinhala = "නැවුම් කොළ පැහැති තේ දළු ලෝක ප්‍රකට සිලෝන් තේ නිපදවයි.",
            futureEnglish = "The estate will process five tons of tea tomorrow.",
            futureSinhala = "වතුයාය හෙට තේ ටොන් පහක් නිෂ්පාදනය කරනු ඇත.",
            verbTransformation = "plucked → produce → will process"
          ),
          TenseSentenceItem(
            id = "t18_s12",
            baseActionSinhala = "රබර් කිරි කැපීම",
            pastEnglish = "The tapper tapped the rubber bark before dawn.",
            pastSinhala = "රබර් කිරි කපන්නා පාන්දරට පෙර රබර් ගසේ පොත්ත කැපුවේය.",
            presentEnglish = "Latex drips slowly into coconut shell cups.",
            presentSinhala = "රබර් කිරි සෙමින් පොල්කටු කෝප්පවලට බිංදු වැටෙයි.",
            futureEnglish = "He will collect the white latex liquid at 9:00 AM.",
            futureSinhala = "ඔහු උදෑසන 9:00 ට සුදු පැහැති රබර් කිරි එකතු කරනු ඇත.",
            verbTransformation = "tapped → drips → will collect"
          ),
          TenseSentenceItem(
            id = "t18_s13",
            baseActionSinhala = "පළතුරු පැළයක් සිටුවීම",
            pastEnglish = "We planted a sweet mango sapling in the backyard.",
            pastSinhala = "අපි පසුපස මිදුලේ රසවත් අඹ පැළයක් සිටුවුවෙමු.",
            presentEnglish = "Planting trees preserves topsoil and combats climate change.",
            presentSinhala = "ගස් සිටුවීම මතුපිට පස ආරක්ෂා කර දේශගුණික විපර්යාසවලට එරෙහිව සටන් කරයි.",
            futureEnglish = "The tree will bear delicious fruits in three years.",
            futureSinhala = "ගස වසර තුනකින් රසවත් පලතුරු ලබා දෙනු ඇත.",
            verbTransformation = "planted → preserves → will bear"
          ),
          TenseSentenceItem(
            id = "t18_s14",
            baseActionSinhala = "බිංදු ජල සම්පාදනය භාවිතය",
            pastEnglish = "The innovative grower installed a drip irrigation system.",
            pastSinhala = "නවෝත්පාදන වගාකරුවා බිංදු ජල සම්පාදන පද්ධතියක් සවි කළේය.",
            presentEnglish = "Drip irrigation saves precious water in arid regions.",
            presentSinhala = "බිංදු ජල සම්පාදනය වියළි කලාපවල වටිනා ජලය ඉතිරි කරයි.",
            futureEnglish = "The automated timers will release water at scheduled intervals.",
            futureSinhala = "ස්වයංක්‍රීය ටයිමර නියමිත වේලාවන්ට ජලය මුදා හරිනු ඇත.",
            verbTransformation = "installed → saves → will release"
          ),
          TenseSentenceItem(
            id = "t18_s15",
            baseActionSinhala = "කෘමීන්ගෙන් වගාව ආරක්ෂා කිරීම",
            pastEnglish = "Grandpa sprayed neem leaf extract to repel harmful beetles.",
            pastSinhala = "සීයා හානිකර කුරුමිණියන් පලවා හැරීමට කොහොඹ කොළ යුෂ ඉස්සේය.",
            presentEnglish = "Natural biopesticides control pests without toxic residue.",
            presentSinhala = "ස්වභාවික ජෛව පළිබෝධනාශක විෂ රහිතව පළිබෝධ පාලනය කරයි.",
            futureEnglish = "We will place yellow sticky traps to catch flying insects.",
            futureSinhala = "පියාඹන කෘමීන් ඇල්ලීමට අපි කහ පැහැති ඇලෙන සුළු උගුල් තබන්නෙමු.",
            verbTransformation = "sprayed → control → will place"
          ),
          TenseSentenceItem(
            id = "t18_s16",
            baseActionSinhala = "අල බෝග වගා කිරීම",
            pastEnglish = "We cultivated sweet potatoes and manioc along the ridge.",
            pastSinhala = "අපි නියර දිගේ බතල සහ මඤ්ඤොක්කා වගා කළෙමු.",
            presentEnglish = "Root tubers thrive in well-aerated sandy soil.",
            presentSinhala = "අල බෝග හොඳින් වාතාශ්‍රය ලැබෙන වැලි සහිත පසේ සරුවට වැවේ.",
            futureEnglish = "We will dig up the mature yam roots next month.",
            futureSinhala = "අපි ලබන මාසයේ පැසුණු අල ගලවන්නෙමු.",
            verbTransformation = "cultivated → thrive → will dig up"
          ),
          TenseSentenceItem(
            id = "t18_s17",
            baseActionSinhala = "හරිතාගාරයක් ඉදිකිරීම",
            pastEnglish = "The agri-entrepreneur built a poly-tunnel greenhouse.",
            pastSinhala = "කෘෂි ව්‍යවසායකයා පොලිටනල් හරිතාගාරයක් ඉදි කළේය.",
            presentEnglish = "Greenhouses maintain ideal humidity for bell peppers.",
            presentSinhala = "හරිතාගාර මාළු මිරිස් සඳහා සුදුසු ආර්ද්‍රතාවය පවත්වා ගනී.",
            futureEnglish = "He will grow European salad greens all year round.",
            futureSinhala = "ඔහු වසර පුරා යුරෝපීය සලාද කොළ වගා කරනු ඇත.",
            verbTransformation = "built → maintain → will grow"
          ),
          TenseSentenceItem(
            id = "t18_s18",
            baseActionSinhala = "කුළුබඩු වගා කිරීම",
            pastEnglish = "Uncle planted cardamom and cloves in his spice garden.",
            pastSinhala = "මාමා තම කුළුබඩු වත්තේ එනසාල් සහ කරාබුනැටි සිටුවූයේය.",
            presentEnglish = "Ceylon spices command premium international market prices.",
            presentSinhala = "ලංකාවේ කුළුබඩු ජාත්‍යන්තර වෙළඳපොලේ ඉහළ මිලක් හිමිකර ගනී.",
            futureEnglish = "He will export sun-dried black peppercorns.",
            futureSinhala = "ඔහු අව්වේ වේලූ කළු ගම්මිරිස් අපනයනය කරනු ඇත.",
            verbTransformation = "planted → command → will export"
          ),
          TenseSentenceItem(
            id = "t18_s19",
            baseActionSinhala = "වී මෝලට ගෙන යාම",
            pastEnglish = "The farmer took ten sacks of paddy to the local rice mill.",
            pastSinhala = "ගොවියා වී ගෝනි දහයක් ගමේ වී මෝලට ගෙන ගියේය.",
            presentEnglish = "Modern mills hull, polish, and sort rice varieties efficiently.",
            presentSinhala = "නවීන මෝල් වී කොටා, පොලිෂ් කර, කාර්යක්ෂමව වර්ග කරයි.",
            futureEnglish = "We will return home with fragrant white polished rice.",
            futureSinhala = "අපි සුවඳැති සුදු කැකුළු සහල් සමඟ ආපසු නිවසට පැමිණෙන්නෙමු.",
            verbTransformation = "took → hull / sort → will return"
          ),
          TenseSentenceItem(
            id = "t18_s20",
            baseActionSinhala = "කැත්ත සහ උදැල්ල භාවිතය",
            pastEnglish = "The farmer cleared overgrown bush with a sharp billhook.",
            pastSinhala = "ගොවියා කැත්ත භාවිතයෙන් ලඳු කැලෑව එළිපෙහෙළි කළේය.",
            presentEnglish = "Traditional tools like mamoties shape irrigation furrows.",
            presentSinhala = "උදැල්ල වැනි සාම්ප්‍රදායික මෙවලම් ජල මාර්ග සකස් කරයි.",
            futureEnglish = "He will sharpen the cutting blade with a whetstone.",
            futureSinhala = "ඔහු කරගලෙන් කැපුම් තලය මුවහත් කරනු ඇත.",
            verbTransformation = "cleared → shape → will sharpen"
          ),
          TenseSentenceItem(
            id = "t18_s21",
            baseActionSinhala = "පැල බද්ධ කිරීම",
            pastEnglish = "The horticulturist grafted a sweet scion onto wild lime stock.",
            pastSinhala = "උද්‍යාන විද්‍යාඥයා වල් දෙහි ගසට පැණි දොඩම් අත්තක් බද්ධ කළේය.",
            presentEnglish = "Grafting produces disease-resistant high-yielding trees.",
            presentSinhala = "බද්ධ කිරීම රෝග ප්‍රතිරෝධී වැඩි අස්වැන්නක් දෙන ගස් බිහි කරයි.",
            futureEnglish = "The grafted branch will flower within one year.",
            futureSinhala = "බද්ධ කළ අත්ත වසරක් ඇතුළත මල් දරනු ඇත.",
            verbTransformation = "grafted → produces → will flower"
          ),
          TenseSentenceItem(
            id = "t18_s22",
            baseActionSinhala = "ගෙවතු එළවළු නෙළීම",
            pastEnglish = "Mother picked fresh green beans and brinjals for lunch.",
            pastSinhala = "අම්මා දිවා ආහාරය සඳහා නැවුම් බෝංචි සහ වම්බටු නෙළා ගත්තාය.",
            presentEnglish = "Homegrown vegetables offer superior nutritional value.",
            presentSinhala = "ගෙවත්තේ වගා කළ එළවළු උසස් පෝෂණ ගුණයක් ලබා දෙයි.",
            futureEnglish = "We will harvest red chillies from the front bed.",
            futureSinhala = "අපි ඉදිරිපස පාත්තියෙන් රතු මිරිස් නෙළා ගන්නෙමු.",
            verbTransformation = "picked → offer → will harvest"
          ),
          TenseSentenceItem(
            id = "t18_s23",
            baseActionSinhala = "වැසි ජලය රැස් කිරීම",
            pastEnglish = "The rural family stored rainwater in a concrete tank.",
            pastSinhala = "ගැමි පවුල කොන්ක්‍රීට් ටැංකියක වැසි ජලය රැස් කර ගත්හ.",
            presentEnglish = "Rainwater harvesting alleviates drought in dry zone farming.",
            presentSinhala = "වැසි ජලය රැස් කිරීම වියළි කලාපයේ ගොවිතැනට නියඟයෙන් සහනයක් ගෙන දෙයි.",
            futureEnglish = "We will channel roof runoff to garden storage barrels.",
            futureSinhala = "අපි වහලයේ වැසි ජලය වතු බඳුන්වලට යොමු කරන්නෙමු.",
            verbTransformation = "stored → alleviates → will channel"
          ),
          TenseSentenceItem(
            id = "t18_s24",
            baseActionSinhala = "ගොවි සමිතියට එක්වීම",
            pastEnglish = "Farmers attended the village agrarian committee meeting.",
            pastSinhala = "ගොවීහු ගමේ ගොවිජන කමිටු රැස්වීමට සහභාගී වූහ.",
            presentEnglish = "Farmer cooperatives negotiate fair prices for produce.",
            presentSinhala = "ගොවි සමිති අස්වැන්න සඳහා සාධාරණ මිලක් ලබා ගැනීමට සාකච්ඡා කරයි.",
            futureEnglish = "The committee will allocate canal water fairly.",
            futureSinhala = "කමිටුව ඇළ මාර්ගයේ ජලය සාධාරණව බෙදා දෙනු ඇත.",
            verbTransformation = "attended → negotiate → will allocate"
          ),
          TenseSentenceItem(
            id = "t18_s25",
            baseActionSinhala = "කුඹුරු නියරවල් සකස් කිරීම",
            pastEnglish = "He plastered the mud bunds to prevent water leaks.",
            pastSinhala = "ජලය කාන්දුවීම වැළැක්වීම සඳහා ඔහු මඩ නියරවල් බැන්දේය.",
            presentEnglish = "Sturdy bunds maintain optimal water depth in paddies.",
            presentSinhala = "ශක්තිමත් නියරවල් කුඹුරුවල නිසි ජල මට්ටම රඳවා ගනී.",
            futureEnglish = "He will repair the eroded ridges after heavy storms.",
            futureSinhala = "තද කුණාටුවෙන් පසු ඔහු ඛාදනය වූ නියරවල් අලුත්වැඩියා කරනු ඇත.",
            verbTransformation = "plastered → maintain → will repair"
          ),
          TenseSentenceItem(
            id = "t18_s26",
            baseActionSinhala = "බීජ සංරක්ෂණය කිරීම",
            pastEnglish = "Grandmother preserved traditional heirloom seeds in ash.",
            pastSinhala = "මිත්තණිය සාම්ප්‍රදායික දේශීය බීජ අළු තුළ සංරක්ෂණය කළාය.",
            presentEnglish = "Seed banks safeguard genetic biodiversity for future farming.",
            presentSinhala = "බීජ බැංකු අනාගත ගොවිතැන සඳහා ජාන විවිධත්වය ආරක්ෂා කරයි.",
            futureEnglish = "We will test the germination rate before next planting.",
            futureSinhala = "ලබන වගාවට පෙර අපි බීජ ප්‍රරෝහණ වේගය පරීක්ෂා කරන්නෙමු.",
            verbTransformation = "preserved → safeguard → will test"
          ),
          TenseSentenceItem(
            id = "t18_s27",
            baseActionSinhala = "පස් පෙරළා බුරුල් කිරීම",
            pastEnglish = "I loosened the garden soil with a hand fork.",
            pastSinhala = "මම අත් ගෑරුප්පුවෙන් ගෙවත්තේ පස පෙරළා බුරුල් කළෙමි.",
            presentEnglish = "Aerated soil allows root systems to absorb moisture deeply.",
            presentSinhala = "වාතාශ්‍රය සහිත පස මුල් පද්ධතියට ගැඹුරට තෙතමනය උරා ගැනීමට ඉඩ සලසයි.",
            futureEnglish = "I will mix leaf mould to enhance soil porosity.",
            futureSinhala = "පසේ සිදුරු සහිත බව වැඩි කිරීමට මම කොළ පොහොර මිශ්‍ර කරන්නෙමි.",
            verbTransformation = "loosened → allows → will mix"
          ),
          TenseSentenceItem(
            id = "t18_s28",
            baseActionSinhala = "අලංකාර මල් වගාව",
            pastEnglish = "She planted scented roses and purple orchids.",
            pastSinhala = "ඇය සුවඳැති රෝස සහ දම් පැහැති ඕකිඩ් මල් සිටුවුවාය.",
            presentEnglish = "Fragrant blossoms attract pollinators and uplift homes.",
            presentSinhala = "සුවඳැති මල් පරාගකාරකයන් ආකර්ෂණය කර නිවස ප්‍රබෝධමත් කරයි.",
            futureEnglish = "The jasmine vines will bloom with fragrant white flowers.",
            futureSinhala = "පිච්ච වැල්වල සුවඳැති සුදු මල් පිපෙනු ඇත.",
            verbTransformation = "planted → attract → will bloom"
          ),
          TenseSentenceItem(
            id = "t18_s29",
            baseActionSinhala = "අස්වැන්න කිරා මැනීම",
            pastEnglish = "The merchant weighed fifty sacks of harvest grain.",
            pastSinhala = "වෙළෙන්දා අස්වැන්න ධාන්‍ය ගෝනි පනහක් කිරා බැලුවේය.",
            presentEnglish = "Digital platform scales ensure fair weight measurements.",
            presentSinhala = "ඩිජිටල් තරාදි සාධාරණ බර මිනුම් සහතික කරයි.",
            futureEnglish = "The paddy marketing board will buy the stock at guaranteed price.",
            futureSinhala = "වී අලෙවි මණ්ඩලය සහතික මිලට තොගය මිලදී ගනු ඇත.",
            verbTransformation = "weighed → ensure → will buy"
          ),
          TenseSentenceItem(
            id = "t18_s30",
            baseActionSinhala = "ආහාර ස්වයංපෝෂිතභාවය අත්පත් කර ගැනීම",
            pastEnglish = "Ancient Sri Lanka was proudly celebrated as the Granary of the East.",
            pastSinhala = "පැරණි ශ්‍රී ලංකාව පෙරදිග ධාන්‍යාගාරය ලෙස අභිමානයෙන් ප්‍රකට විය.",
            presentEnglish = "Dedicated agriculture ensures national food security.",
            presentSinhala = "කැපවූ කෘෂිකර්මාන්තය ජාතික ආහාර සුරක්ෂිතතාව සහතික කරයි.",
            futureEnglish = "Our nation will achieve complete self-sufficiency in rice.",
            futureSinhala = "අපේ දේශය සහලින් පූර්ණ ස්වයංපෝෂිතභාවය අත්පත් කර ගනු ඇත.",
            verbTransformation = "was celebrated → ensures → will achieve"
          )
        )
      ),

      // ==========================================
      // Category 19: පුස්තකාලය සහ පොත්පත් පරිශීලනය (Library & Book Reading) - 30 items
      // ==========================================
      TenseComparisonCategory(
        id = 19,
        titleSinhala = "කාණ්ඩය 19: පුස්තකාලය සහ පොත්පත් පරිශීලනය",
        titleEnglish = "Library & Book Reading",
        icon = "📚",
        description = "පොත් කියවීම, පුස්තකාලයෙන් පොත් ගැනීම, සාහිත්‍යය සහ දැනුම ගවේෂණය පිළිබඳ වාක්‍ය 30ක් කාල තුනෙන්ම.",
        sentences = listOf(
          TenseSentenceItem(
            id = "t19_s1",
            baseActionSinhala = "පුස්තකාලයෙන් පොතක් ගැනීම",
            pastEnglish = "I borrowed an English grammar book from the school library yesterday.",
            pastSinhala = "මම ඊයේ පාසල් පුස්තකාලයෙන් ඉංග්‍රීසි ව්‍යාකරණ පොතක් ණයට ගත්තෙමි.",
            presentEnglish = "I borrow two informative books every Friday afternoon.",
            presentSinhala = "මම සෑම සිකුරාදා දහවල්ම තොරතුරු පිරි පොත් දෙකක් ණයට ගනිමි.",
            futureEnglish = "I will borrow an encyclopedia volume tomorrow.",
            futureSinhala = "මම හෙට විශ්වකෝෂ වෙළුමක් ණයට ගන්නෙමි.",
            verbTransformation = "borrowed → borrow → will borrow"
          ),
          TenseSentenceItem(
            id = "t19_s2",
            baseActionSinhala = "පොතක් ආපසු භාර දීම",
            pastEnglish = "Sunil returned the science textbook before the due date.",
            pastSinhala = "සුනිල් නියමිත දිනට පෙර විද්‍යා පෙළපොත ආපසු භාර දුන්නේය.",
            presentEnglish = "Responsible readers return library books on time.",
            presentSinhala = "වගකීම්සහගත පාඨකයෝ පුස්තකාල පොත් නියමිත වේලාවට ආපසු දෙති.",
            futureEnglish = "Sunil will return the novel on Monday.",
            futureSinhala = "සුනිල් සඳුදා නවකතාව ආපසු භාර දෙනු ඇත.",
            verbTransformation = "returned → return → will return"
          ),
          TenseSentenceItem(
            id = "t19_s3",
            baseActionSinhala = "නිහඬව කියවීම",
            pastEnglish = "Students read silently in the reference room.",
            pastSinhala = "සිසුහු විමර්ශන කාමරයේ නිහඬව කියවූහ.",
            presentEnglish = "Library rules require silence to facilitate deep study.",
            presentSinhala = "ගැඹුරු අධ්‍යයනයට පහසු වන පරිදි පුස්තකාල නීති නිහඬතාව ඉල්ලා සිටියි.",
            futureEnglish = "We will read chapters of the history monograph quietly.",
            futureSinhala = "අපි ඉතිහාස ග්‍රන්ථයේ පරිච්ඡේද නිහඬව කියවන්නෙමු.",
            verbTransformation = "read (past) → require → will read"
          ),
          TenseSentenceItem(
            id = "t19_s4",
            baseActionSinhala = "පොතක පිටු පෙරළීම",
            pastEnglish = "She turned the crisp pages of the illustrated encyclopedia.",
            pastSinhala = "ඇය සිතුවම් සහිත විශ්වකෝෂයේ පිටු පෙරළුවාය.",
            presentEnglish = "Eager readers turn pages with rapt anticipation.",
            presentSinhala = "උනන්දු පාඨකයෝ මහත් කුතුහලයෙන් පිටු පෙරළති.",
            futureEnglish = "She will turn to the glossary at the back.",
            futureSinhala = "ඇය පිටුපස ඇති පදමාලාව දෙසට පෙරළනු ඇත.",
            verbTransformation = "turned → turn → will turn"
          ),
          TenseSentenceItem(
            id = "t19_s5",
            baseActionSinhala = "පිටු සලකුණක් තැබීම",
            pastEnglish = "I placed a colorful bookmark at chapter ten.",
            pastSinhala = "මම දහවන පරිච්ඡේදයේ වර්ණවත් පිටු සලකුණක් තැබුවෙමි.",
            presentEnglish = "Bookmarks preserve book spines from dog-earing corners.",
            presentSinhala = "පිටු සලකුණු පොත්වල කොන් නැවීමෙන් පිටු ආරක්ෂා කරයි.",
            futureEnglish = "I will place a ribbon bookmark before closing the volume.",
            futureSinhala = "පොත වැසීමට පෙර මම රිබන් පිටු සලකුණක් තබන්නෙමි.",
            verbTransformation = "placed → preserve → will place"
          ),
          TenseSentenceItem(
            id = "t19_s6",
            baseActionSinhala = "කතුවැකියක් කියවීම",
            pastEnglish = "Grandpa read the leading editorial with critical thought.",
            pastSinhala = "සීයා විවේචනාත්මක චින්තනයෙන් ප්‍රධාන කතුවැකිය කියෙව්වේය.",
            presentEnglish = "Scholars read diverse viewpoints to broaden perspectives.",
            presentSinhala = "විද්වත්හු දෘෂ්ටිකෝණයන් පුළුල් කර ගැනීමට විවිධ මත කියවති.",
            futureEnglish = "We will read critical reviews before purchasing the book.",
            futureSinhala = "පොත මිලදී ගැනීමට පෙර අපි විචාර කියවන්නෙමු.",
            verbTransformation = "read (past) → read (present) → will read"
          ),
          TenseSentenceItem(
            id = "t19_s7",
            baseActionSinhala = "පොත් රාක්ක පිළිවෙළට තැබීම",
            pastEnglish = "The librarian arranged fiction books alphabetically by author.",
            pastSinhala = "පුස්තකාලයාධිපතිවරයා කතුවරුන්ගේ අකාරාදී පිළිවෙළට ප්‍රබන්ධ පොත් සැකසුවේය.",
            presentEnglish = "Dewey decimal classification organizes knowledge systematically.",
            presentSinhala = "ඩුවී දශම වර්ගීකරණය දැනුම ක්‍රමානුකූලව සකස් කරයි.",
            futureEnglish = "Volunteers will arrange returned volumes this afternoon.",
            futureSinhala = "ස්වේච්ඡා සේවකයෝ අද සවස ආපසු භාරදුන් පොත් රාක්කවල තබනු ඇත.",
            verbTransformation = "arranged → organizes → will arrange"
          ),
          TenseSentenceItem(
            id = "t19_s8",
            baseActionSinhala = "පුස්තකාල සාමාජිකත්වය අලුත් කිරීම",
            pastEnglish = "I renewed my public library membership card last week.",
            pastSinhala = "මම පසුගිය සතියේ මගේ මහජන පුස්තකාල සාමාජික කාඩ්පත අලුත් කළෙමි.",
            presentEnglish = "Libraries grant access to vast digital and physical archives.",
            presentSinhala = "පුස්තකාල විශාල ඩිජිටල් සහ භෞතික ලේඛනාගාර වෙත ප්‍රවේශය ලබා දෙයි.",
            futureEnglish = "I will renew my lending pass before it expires.",
            futureSinhala = "කල් ඉකුත් වීමට පෙර මම මගේ පොත් ගැනීමේ බලපත්‍රය අලුත් කරන්නෙමු.",
            verbTransformation = "renewed → grant → will renew"
          ),
          TenseSentenceItem(
            id = "t19_s9",
            baseActionSinhala = "ශබ්දකෝෂයක් පෙරළා බැලීම",
            pastEnglish = "She looked up the definition of 'benevolence' in Oxford dictionary.",
            pastSinhala = "ඇය ඔක්ස්ෆර්ඩ් ශබ්දකෝෂයෙන් 'benevolence' යන වචනයේ අර්ථය සෙව්වාය.",
            presentEnglish = "Diligent students consult dictionaries for correct pronunciation.",
            presentSinhala = "උනන්දු සිසුහු නිවැරදි උච්චාරණය සඳහා ශබ්දකෝෂ පරිශීලනය කරති.",
            futureEnglish = "She will look up complex idiomatic phrases tonight.",
            futureSinhala = "ඇය අද රෑ සංකීර්ණ රූඪි වාක්‍ය ඛණ්ඩ සොයනු ඇත.",
            verbTransformation = "looked up → consult → will look up"
          ),
          TenseSentenceItem(
            id = "t19_s10",
            baseActionSinhala = "නවකතාවක් කියවා අවසන් කිරීම",
            pastEnglish = "Kasun finished reading Martin Wickramasinghe's 'Gamperaliya'.",
            pastSinhala = "කසුන් මාර්ටින් වික්‍රමසිංහයන්ගේ 'ගම්පෙරළිය' නවකතාව කියවා අවසන් කළේය.",
            presentEnglish = "Classic novels portray socio-cultural shifts masterfully.",
            presentSinhala = "සම්භාව්‍ය නවකතා සමාජ-සංස්කෘතික වෙනස්කම් විශිෂ්ට ලෙස නිරූපණය කරයි.",
            futureEnglish = "He will finish reading the sequel 'Yuganthaya' next.",
            futureSinhala = "ඔහු ඊළඟට 'යුගාන්තය' නවකතාව කියවා අවසන් කරනු ඇත.",
            verbTransformation = "finished → portray → will finish"
          ),
          TenseSentenceItem(
            id = "t19_s11",
            baseActionSinhala = "වැදගත් කරුණු සටහන් කර ගැනීම",
            pastEnglish = "I jotted down key historical dates in my notebook.",
            pastSinhala = "මම වැදගත් ඓතිහාසික දිනයන් මගේ සටහන් පොතේ ලියා ගත්තෙමි.",
            presentEnglish = "Taking concise notes solidifies memory retention.",
            presentSinhala = "කෙටි සටහන් තබා ගැනීම මතක රඳවා ගැනීම ශක්තිමත් කරයි.",
            futureEnglish = "I will summarize the whole chapter in bullet points.",
            futureSinhala = "මම කෙටි කරුණු වශයෙන් මුළු පරිච්ඡේදයම සාරාංශ කරන්නෙමි.",
            verbTransformation = "jotted down → solidifies → will summarize"
          ),
          TenseSentenceItem(
            id = "t19_s12",
            baseActionSinhala = "පොතකට කවරයක් දැමීම",
            pastEnglish = "Father wrapped my new textbooks with clear protective film.",
            pastSinhala = "තාත්තා මගේ අලුත් පෙළපොත් පාරදෘශ්‍ය ආරක්ෂිත කවරයකින් ආවරණය කළේය.",
            presentEnglish = "Covering books safeguards bindings throughout the school year.",
            presentSinhala = "පොත් ආවරණය කිරීම පාසල් වසර පුරා පොතේ බැඳීම ආරක්ෂා කරයි.",
            futureEnglish = "We will cover all library donations before cataloguing.",
            futureSinhala = "නාමාවලිගත කිරීමට පෙර අපි සියලුම පරිත්‍යාග පොත් ආවරණය කරන්නෙමු.",
            verbTransformation = "wrapped → safeguards → will cover"
          ),
          TenseSentenceItem(
            id = "t19_s13",
            baseActionSinhala = "පොත් ප්‍රදර්ශනයක් නැරඹීම",
            pastEnglish = "We visited the Colombo International Book Fair in September.",
            pastSinhala = "අපි සැප්තැම්බර් මාසයේ කොළඹ ජාත්‍යන්තර පොත් ප්‍රදර්ශනය නැරඹුවෙමු.",
            presentEnglish = "Book fairs inspire a passionate reading culture nationwide.",
            presentSinhala = "පොත් ප්‍රදර්ශන රට පුරා උනන්දු සහගත කියවීමේ සංස්කෘතියක් ඇති කරයි.",
            futureEnglish = "We will browse new releases at the BMICH stalls.",
            futureSinhala = "අපි බණ්ඩාරනායක සම්මන්ත්‍රණ ශාලාවේ කුටිවල අලුත් පොත් පිරික්සන්නෙමු.",
            verbTransformation = "visited → inspire → will browse"
          ),
          TenseSentenceItem(
            id = "t19_s14",
            baseActionSinhala = "ඊ-පොතක් කියවීම",
            pastEnglish = "She read a digital e-book on her e-reader device.",
            pastSinhala = "ඇය තම ඊ-කියවනයෙන් ඩිජිටල් පොතක් කියෙව්වාය.",
            presentEnglish = "E-books provide portable access to extensive libraries anywhere.",
            presentSinhala = "ඊ-පොත් ඕනෑම තැනකදී විශාල පුස්තකාල වෙත පහසු ප්‍රවේශයක් ලබා දෙයි.",
            futureEnglish = "She will download the audio version for her evening walk.",
            futureSinhala = "ඇය සවස ඇවිදීම සඳහා එහි ශ්‍රව්‍ය පිටපත බාගත කරනු ඇත.",
            verbTransformation = "read (past) → provide → will download"
          ),
          TenseSentenceItem(
            id = "t19_s15",
            baseActionSinhala = "පොතක් නිර්දේශ කිරීම",
            pastEnglish = "The literature teacher recommended a biography of Nelson Mandela.",
            pastSinhala = "සාහිත්‍ය ගුරුතුමිය නෙල්සන් මැන්ඩෙලාගේ චරිතාපදානයක් නිර්දේශ කළාය.",
            presentEnglish = "Inspiring biographies motivate youth to overcome adversity.",
            presentSinhala = "ප්‍රබෝධමත් චරිතාපදාන බාධක ජය ගැනීමට තරුණ පරපුර දිරිමත් කරයි.",
            futureEnglish = "She will recommend award-winning poetry anthologies.",
            futureSinhala = "ඇය සම්මානනීය කාව්‍ය සංග්‍රහ නිර්දේශ කරනු ඇත.",
            verbTransformation = "recommended → motivate → will recommend"
          ),
          TenseSentenceItem(
            id = "t19_s16",
            baseActionSinhala = "කාලසීමාව ඉක්මවූ දඩ මුදලක් ගෙවීම",
            pastEnglish = "He paid a ten-rupee overdue fine for the late return.",
            pastSinhala = "ප්‍රමාද වී භාරදීම වෙනුවෙන් ඔහු රුපියල් දහයක දඩයක් ගෙවීය.",
            presentEnglish = "Nominal fines encourage prompt book circulation.",
            presentSinhala = "නාමික දඩ මුදල් පොත් කඩිනමින් සංසරණය වීමට දිරිගන්වයි.",
            futureEnglish = "I will return the book early so I avoid late penalties.",
            futureSinhala = "ප්‍රමාද ගාස්තු වළක්වා ගැනීමට මම කලින්ම පොත භාර දෙන්නෙමි.",
            verbTransformation = "paid → encourage → will return"
          ),
          TenseSentenceItem(
            id = "t19_s17",
            baseActionSinhala = "පුස්තකාල නාමාවලිය පිරික්සීම",
            pastEnglish = "I searched the OPAC computerized library catalogue.",
            pastSinhala = "මම පරිගණකගත පුස්තකාල නාමාවලිය පරීක්ෂා කළෙමි.",
            presentEnglish = "Online catalogues locate books by subject, title, and author.",
            presentSinhala = "මාර්ගගත නාමාවලි විෂය, මාතෘකාව සහ කතුවරයා අනුව පොත් සොයා දෙයි.",
            futureEnglish = "I will reserve the reserved science book through the portal.",
            futureSinhala = "මම පද්ධතිය හරහා වෙන් කර ඇති විද්‍යා පොත වෙන් කරවා ගන්නෙමු.",
            verbTransformation = "searched → locate → will reserve"
          ),
          TenseSentenceItem(
            id = "t19_s18",
            baseActionSinhala = "පැරණි පුස්කොළ පොත් අධ්‍යයනය",
            pastEnglish = "The researcher examined fragile palm-leaf manuscripts.",
            pastSinhala = "පර්යේෂකයා සියුම් පුස්කොළ පොත් පරීක්ෂා කළේය.",
            presentEnglish = "Ancient ola leaves contain invaluable indigenous medicinal formulas.",
            presentSinhala = "පුරාණ පුස්කොළ පත් ඉරු අමිල දේශීය වෛද්‍ය වට්ටෝරු සඟවාගෙන සිටියි.",
            futureEnglish = "Scholars will translate the Pali verses into modern Sinhala.",
            futureSinhala = "විද්වත්හු පාලි ගාථා නවීන සිංහලයට පරිවර්තනය කරනු ඇත.",
            verbTransformation = "examined → contain → will translate"
          ),
          TenseSentenceItem(
            id = "t19_s19",
            baseActionSinhala = "පොත් සමාජයක් පිහිටුවීම",
            pastEnglish = "Students formed a weekend book reading club.",
            pastSinhala = "සිසුහු සති අන්ත පොත් කියවීමේ සමාජයක් පිහිටුවා ගත්හ.",
            presentEnglish = "Literary clubs nurture stimulating debate and analytical skills.",
            presentSinhala = "සාහිත්‍ය සමාජ උත්තේජක විවාද සහ විචාරාත්මක කුසලතා පෝෂණය කරයි.",
            futureEnglish = "We will discuss the chosen science fiction title next Saturday.",
            futureSinhala = "අපි ලබන සෙනසුරාදා තෝරාගත් විද්‍යා ප්‍රබන්ධය ගැන සාකච්ඡා කරන්නෙමු.",
            verbTransformation = "formed → nurture → will discuss"
          ),
          TenseSentenceItem(
            id = "t19_s20",
            baseActionSinhala = "පොතකට කතුවැකියක් ලිවීම",
            pastEnglish = "The professor penned a scholarly foreword to the volume.",
            pastSinhala = "මහාචාර්යවරයා ග්‍රන්ථය සඳහා විද්වත් පෙරවදනක් ලිව්වේය.",
            presentEnglish = "Insightful introductions orient readers to core themes.",
            presentSinhala = "ගැඹුරු හැඳින්වීම් පාඨකයන් මූලික තේමාවන් වෙත යොමු කරයි.",
            futureEnglish = "The editor will compile the index and bibliography.",
            futureSinhala = "සංස්කාරකවරයා පටුන සහ ග්‍රන්ථ නාමාවලිය සකස් කරනු ඇත.",
            verbTransformation = "penned → orient → will compile"
          ),
          TenseSentenceItem(
            id = "t19_s21",
            baseActionSinhala = "පුස්තකාලයට පොත් පරිත්‍යාග කිරීම",
            pastEnglish = "An alumnus donated two hundred storybooks to the school.",
            pastSinhala = "ආදි ශිෂ්‍යයෙක් පාසලට කතන්දර පොත් දෙසියයක් පරිත්‍යාග කළේය.",
            presentEnglish = "Philanthropic book donations empower rural school children.",
            presentSinhala = "පොත් පරිත්‍යාග ග්‍රාමීය පාසල් දරුවන් සවිබල ගන්වයි.",
            futureEnglish = "We will donate our past exam prep guides to the juniors.",
            futureSinhala = "අපි අපේ පසුගිය විභාග මාර්ගෝපදේශ කනිෂ්ඨ සිසුන්ට පරිත්‍යාග කරන්නෙමු.",
            verbTransformation = "donated → empower → will donate"
          ),
          TenseSentenceItem(
            id = "t19_s22",
            baseActionSinhala = "කවි පොතක් කියවීම",
            pastEnglish = "She read a collection of Mahagama Sekara's poems.",
            pastSinhala = "ඇය මහගම සේකරයන්ගේ කාව්‍ය සංග්‍රහයක් කියෙව්වාය.",
            presentEnglish = "Poetry touches human empathy through rhythmic metaphor.",
            presentSinhala = "කාව්‍යය රිද්මයානුකූල රූපක මඟින් මානව සංවේදීතාව ස්පර්ශ කරයි.",
            futureEnglish = "She will recite verses at the inter-house literary meet.",
            futureSinhala = "ඇය නිවාසාන්තර සාහිත්‍ය උළෙලේදී කවි ගායනා කරනු ඇත.",
            verbTransformation = "read (past) → touches → will recite"
          ),
          TenseSentenceItem(
            id = "t19_s23",
            baseActionSinhala = "චිත්‍රකතා පොතක් කියවීම",
            pastEnglish = "The boy enjoyed reading a TinTin graphic novel.",
            pastSinhala = "පිරිමි ළමයා ටින්ටින් චිත්‍රකතා පොත කියවීමෙන් මහත් සේ සතුටු විය.",
            presentEnglish = "Graphic novels cultivate visual literacy and storytelling flair.",
            presentSinhala = "චිත්‍රකතා දෘශ්‍ය සාක්ෂරතාවය සහ කතන්දර කීමේ හැකියාව වර්ධනය කරයි.",
            futureEnglish = "He will sketch his own comic strips on Sunday.",
            futureSinhala = "ඔහු ඉරිදා තම තමන්ගේම චිත්‍රකතා අඳිනු ඇත.",
            verbTransformation = "enjoyed → cultivate → will sketch"
          ),
          TenseSentenceItem(
            id = "t19_s24",
            baseActionSinhala = "පොත් කවරයේ පින්තූරය ඇඳීම",
            pastEnglish = "The artist illustrated an eye-catching book cover.",
            pastSinhala = "චිත්‍ර ශිල්පියා සිත් ඇදගන්නාසුළු පොත් කවරයක් ඇන්දේය.",
            presentEnglish = "Attractive covers invite prospective readers to browse pages.",
            presentSinhala = "ආකර්ෂණීය කවර පාඨකයන් පොත් පෙරළා බැලීමට පොළඹවයි.",
            futureEnglish = "He will design typography for the new publication.",
            futureSinhala = "ඔහු නව ප්‍රකාශනය සඳහා අක්ෂර මෝස්තර නිර්මාණය කරනු ඇත.",
            verbTransformation = "illustrated → invite → will design"
          ),
          TenseSentenceItem(
            id = "t19_s25",
            baseActionSinhala = "විමර්ශන පොත් ශාලාව භාවිතය",
            pastEnglish = "University students consulted rare encyclopedias in the archive.",
            pastSinhala = "විශ්වවිද්‍යාල සිසුහු ලේඛනාගාරයේ දුර්ලභ විශ්වකෝෂ පරිශීලනය කළහ.",
            presentEnglish = "Reference sections preserve valuable out-of-print records safely.",
            presentSinhala = "විමර්ශන අංශ මුද්‍රණයෙන් බැහැර වූ වටිනා වාර්තා සුරක්ෂිතව තබයි.",
            futureEnglish = "We will consult historical census tables for our thesis.",
            futureSinhala = "අපේ පර්යේෂණ නිබන්ධනය සඳහා අපි ඓතිහාසික ජන සංගණන වගු පරිශීලනය කරන්නෙමු.",
            verbTransformation = "consulted → preserve → will consult"
          ),
          TenseSentenceItem(
            id = "t19_s26",
            baseActionSinhala = "පොතකින් උපුටා ගැනීමක් දැක්වීම",
            pastEnglish = "The speaker quoted Shakespeare's 'Hamlet' during the lecture.",
            pastSinhala = "දේශකයා දේශනය අතරතුර ෂේක්ස්පියර්ගේ 'හැම්ලට්' නාට්‍යයෙන් උපුටා දැක්වීය.",
            presentEnglish = "Academic writing cites authoritative sources accurately.",
            presentSinhala = "ශාස්ත්‍රීය ලේඛන විශ්වාසනීය මූලාශ්‍ර නිවැරදිව උපුටා දක්වයි.",
            futureEnglish = "I will reference reputable research papers in my essay.",
            futureSinhala = "මගේ රචනාවේදී මම පිළිගත් පර්යේෂණ පත්‍රිකා උපුටා දක්වන්නෙමි.",
            verbTransformation = "quoted → cites → will reference"
          ),
          TenseSentenceItem(
            id = "t19_s27",
            baseActionSinhala = "දිරාගිය පොත් අලුත්වැඩියා කිරීම",
            pastEnglish = "The binder repaired torn pages and rebound loose volumes.",
            pastSinhala = "පොත් බඳින්නා ඉරුණු පිටු අලුත්වැඩියා කර ගැලවුණු පොත් නැවත බැන්දේය.",
            presentEnglish = "Archival preservation extends the lifespan of fragile papers.",
            presentSinhala = "ලේඛනාගාර සංරක්ෂණය සියුම් කඩදාසිවල ආයු කාලය දීර්ඝ කරයි.",
            futureEnglish = "He will restore the antique leather-bound atlas.",
            futureSinhala = "ඔහු පැරණි සම් බැඳුම් ඇට්ලස් සිතියම් පොත ප්‍රතිසංස්කරණය කරනු ඇත.",
            verbTransformation = "repaired → extends → will restore"
          ),
          TenseSentenceItem(
            id = "t19_s28",
            baseActionSinhala = "රාත්‍රියේ කියවීම",
            pastEnglish = "I read an adventure story under the desk lamp.",
            pastSinhala = "මම මේස ලාම්පුව යට වික්‍රමාන්විත කතාවක් කියෙව්වෙමි.",
            presentEnglish = "Reading before bedtime relaxes the mind and fosters sweet dreams.",
            presentSinhala = "නින්දට පෙර කියවීම මනස සන්සුන් කර සුන්දර සිහින ඇති කරයි.",
            futureEnglish = "I will read two more chapters before turning off the light.",
            futureSinhala = "විදුලි පහන නිවා දැමීමට පෙර මම තවත් පරිච්ඡේද දෙකක් කියවන්නෙමි.",
            verbTransformation = "read (past) → relaxes → will read"
          ),
          TenseSentenceItem(
            id = "t19_s29",
            baseActionSinhala = "ලේඛකයෙකු වීම",
            pastEnglish = "The young author published his debut short story collection.",
            pastSinhala = "තරුණ ලේඛකයා තම ප්‍රථම කෙටිකතා සංග්‍රහය ප්‍රකාශයට පත් කළේය.",
            presentEnglish = "Prolific writers inspire generations through creative prose.",
            presentSinhala = "දක්ෂ ලේඛකයෝ නිර්මාණාත්මක ගද්‍ය තුළින් පරම්පරා ගණනාවක් දිරිමත් කරති.",
            futureEnglish = "He will write an adventurous mystery novel next year.",
            futureSinhala = "ඔහු ලබන වසරේ වික්‍රමාන්විත අභිරහස් නවකතාවක් ලියනු ඇත.",
            verbTransformation = "published → inspire → will write"
          ),
          TenseSentenceItem(
            id = "t19_s30",
            baseActionSinhala = "කියවීමේ පුරුද්ද දියුණු කර ගැනීම",
            pastEnglish = "Reading opened my eyes to limitless horizons of human thought.",
            pastSinhala = "කියවීම මානව චින්තනයේ අනන්ත ක්ෂිතිජයන් වෙත මගේ දෙනෙත් විවර කළේය.",
            presentEnglish = "A reader lives a thousand lives before he dies.",
            presentSinhala = "පොත් කියවන්නෙකු මිය යාමට පෙර ජීවිත දහසක් ගත කරයි.",
            futureEnglish = "Books will remain your most faithful and loyal lifelong companions.",
            futureSinhala = "පොත්පත් ඔබගේ ජීවිත කාලය පුරාම වඩාත්ම විශ්වාසවන්ත සහ පක්ෂපාතී මිතුරා ලෙස පවතිනු ඇත.",
            verbTransformation = "opened → lives → will remain"
          )
        )
      ),

      // ==========================================
      // Category 20: විද්‍යාව, අත්හදා බැලීම් සහ පර්යේෂණ (Science, Experiments & Research) - 30 items
      // ==========================================
      TenseComparisonCategory(
        id = 20,
        titleSinhala = "කාණ්ඩය 20: විද්‍යාව, අත්හදා බැලීම් සහ පර්යේෂණ",
        titleEnglish = "Science, Experiments & Research",
        icon = "🔬",
        description = "විද්‍යාගාර අත්හදා බැලීම්, අන්වීක්ෂ භාවිතය, රසායනික ප්‍රතික්‍රියා සහ සොයාගැනීම් පිළිබඳ වාක්‍ය 30ක් කාල තුනෙන්ම.",
        sentences = listOf(
          TenseSentenceItem(
            id = "t20_s1",
            baseActionSinhala = "අන්වීක්ෂයෙන් නිරීක්ෂණය කිරීම",
            pastEnglish = "Students observed onion root tip cells under the compound microscope.",
            pastSinhala = "සිසුහු සංයුක්ත අන්වීක්ෂය යටතේ ලූනු මුල් අග්‍ර සෛල නිරීක්ෂණය කළහ.",
            presentEnglish = "Microscopes reveal intricate structures invisible to naked eyes.",
            presentSinhala = "අන්වීක්ෂ පියවි ඇසට නොපෙනෙන සියුම් ව්‍යුහයන් හෙළි කරයි.",
            futureEnglish = "We will observe live amoeba specimens tomorrow.",
            futureSinhala = "අපි හෙට සජීවී ඇමීබා සාම්පල නිරීක්ෂණය කරන්නෙමු.",
            verbTransformation = "observed → reveal → will observe"
          ),
          TenseSentenceItem(
            id = "t20_s2",
            baseActionSinhala = "රසායනික ද්‍රව්‍ය මිශ්‍ර කිරීම",
            pastEnglish = "The chemist mixed dilute hydrochloric acid with sodium hydroxide.",
            pastSinhala = "රසායන විද්‍යාඥයා තනුක හයිඩ්‍රොක්ලෝරික් අම්ලය සෝඩියම් හයිඩ්‍රොක්සයිඩ් සමඟ මිශ්‍ර කළේය.",
            presentEnglish = "Acid-base neutralizations form water and harmless salts.",
            presentSinhala = "අම්ල-භෂ්ම උදාසීනකරණ ජලය සහ අහිංසක ලවණ සාදයි.",
            futureEnglish = "He will mix the reagents carefully in a conical flask.",
            futureSinhala = "ඔහු කේතුක ප්ලාස්කුවක රසායනික ප්‍රතිකාරක ප්‍රවේශමෙන් මිශ්‍ර කරනු ඇත.",
            verbTransformation = "mixed → form → will mix"
          ),
          TenseSentenceItem(
            id = "t20_s3",
            baseActionSinhala = "බන්සන් දැල්ල දැල්වීම",
            pastEnglish = "The lab assistant lit the Bunsen burner with a striker.",
            pastSinhala = "විද්‍යාගාර සහායකයා බන්සන් දැල්ල දැල්වීය.",
            presentEnglish = "A blue flame indicates complete, hot hydrocarbon combustion.",
            presentSinhala = "නිල් දැල්ලක් පූර්ණ, උණුසුම් හයිඩ්‍රොකාබන් දහනයක් පෙන්නුම් කරයි.",
            futureEnglish = "We will heat the test tube over the gentle flame.",
            futureSinhala = "අපි සෙමෙන් දැවෙන දැල්ල මත පරීක්ෂණ නළය රත් කරන්නෙමු.",
            verbTransformation = "lit → indicates → will heat"
          ),
          TenseSentenceItem(
            id = "t20_s4",
            baseActionSinhala = "උෂ්ණත්වය මැනීම",
            pastEnglish = "She recorded the boiling point of pure water as 100 degrees Celsius.",
            pastSinhala = "ඇය පිරිසිදු ජලයේ තාපාංකය සෙල්සියස් අංශක 100 ලෙස සටහන් කළාය.",
            presentEnglish = "Thermometers measure thermal changes in degrees Celsius accurately.",
            presentSinhala = "උෂ්ණත්වමාන සෙල්සියස් අංශක වලින් තාප වෙනස්කම් නිවැරදිව මනියි.",
            futureEnglish = "She will measure temperature variations during the reaction.",
            futureSinhala = "ප්‍රතික්‍රියාව අතරතුර සිදුවන උෂ්ණත්ව වෙනස්වීම් ඇය මනිනු ඇත.",
            verbTransformation = "recorded → measure → will measure"
          ),
          TenseSentenceItem(
            id = "t20_s5",
            baseActionSinhala = "ප්‍රභාසංස්ලේෂණය අත්හදා බැලීම",
            pastEnglish = "We tested green leaves for starch using iodine solution.",
            pastSinhala = "අයඩීන් ද්‍රාවණය භාවිතයෙන් අපි කොළ පැහැති පත්‍රවල පිෂ්ඨය පරීක්ෂා කළෙමු.",
            presentEnglish = "Photosynthesis converts solar light into stored chemical energy.",
            presentSinhala = "ප්‍රභාසංස්ලේෂණය සූර්ය ආලෝකය රසායනික ශක්තිය බවට පරිවර්තනය කරයි.",
            futureEnglish = "We will demonstrate oxygen release by aquatic hydrilla plants.",
            futureSinhala = "අපි හයිඩ්‍රිල්ලා ජලජ ශාක මඟින් ඔක්සිජන් මුදා හැරීම ආදර්ශනය කරන්නෙමු.",
            verbTransformation = "tested → converts → will demonstrate"
          ),
          TenseSentenceItem(
            id = "t20_s6",
            baseActionSinhala = "විද්‍යාත්මක උපකල්පනයක් ගොඩනැගීම",
            pastEnglish = "The team formulated a testable scientific hypothesis.",
            pastSinhala = "කණ්ඩායම පරීක්ෂා කළ හැකි විද්‍යාත්මක උපකල්පනයක් ගොඩනැගුවේය.",
            presentEnglish = "Rigorous scientists test hypotheses through repeated trials.",
            presentSinhala = "ප්‍රවීණ විද්‍යාඥයෝ නැවත නැවත කරන පරීක්ෂණ මඟින් උපකල්පන පරීක්ෂා කරති.",
            futureEnglish = "We will verify our hypothesis using statistical analysis.",
            futureSinhala = "අපි සංඛ්‍යානමය විශ්ලේෂණය භාවිතයෙන් අපගේ උපකල්පනය තහවුරු කරන්නෙමු.",
            verbTransformation = "formulated → test → will verify"
          ),
          TenseSentenceItem(
            id = "t20_s7",
            baseActionSinhala = "ආරක්ෂිත කණ්ණාඩි පැළඳීම",
            pastEnglish = "Students wore safety goggles before handling concentrated acids.",
            pastSinhala = "සාන්ද්‍ර අම්ල හැසිරවීමට පෙර සිසුහු ආරක්ෂිත කණ්ණාඩි පැළඳ සිටියහ.",
            presentEnglish = "Protective eyewear shields eyes from dangerous chemical splashes.",
            presentSinhala = "ආරක්ෂිත ඇස් කණ්ණාඩි අනතුරුදායක රසායනික විසිරීම් වලින් ඇස් ආරක්ෂා කරයි.",
            futureEnglish = "Everyone will wear lab coats and rubber gloves.",
            futureSinhala = "සියලු දෙනාම විද්‍යාගාර කබා සහ රබර් අත්වැසුම් පළඳිනු ඇත.",
            verbTransformation = "wore → shields → will wear"
          ),
          TenseSentenceItem(
            id = "t20_s8",
            baseActionSinhala = "චුම්බක බල රේඛා පරීක්ෂා කිරීම",
            pastEnglish = "We sprinkled iron filings around a bar magnet.",
            pastSinhala = "අපි දණ්ඩ චුම්බකයක් වටා යකඩ කුඩු ඉස්සෙමු.",
            presentEnglish = "Magnetic field lines flow from north to south poles.",
            presentSinhala = "චුම්බක ක්ෂේත්‍ර රේඛා උතුරු ධ්‍රැවයේ සිට දකුණු ධ්‍රැවය දෙසට ගලා යයි.",
            futureEnglish = "We will map lines of force using a plotting compass.",
            futureSinhala = "අපි මාලිමා යන්ත්‍රයක් භාවිතයෙන් බල රේඛා සලකුණු කරන්නෙමු.",
            verbTransformation = "sprinkled → flow → will map"
          ),
          TenseSentenceItem(
            id = "t20_s9",
            baseActionSinhala = "විදුලි පරිපථයක් සැකසීම",
            pastEnglish = "Sunil connected a battery, switch, and bulb in series.",
            pastSinhala = "සුනිල් බැටරියක්, ස්විචයක් සහ බල්බයක් ශ්‍රේණිගතව සම්බන්ධ කළේය.",
            presentEnglish = "Electric current flows when circuits are closed.",
            presentSinhala = "පරිපථ වැසුණු විට විදුලි ධාරාව ගලා යයි.",
            futureEnglish = "He will measure potential difference using a voltmeter.",
            futureSinhala = "ඔහු වෝල්ට්මීටරයක් භාවිතයෙන් විභව අන්තරය මනිනු ඇත.",
            verbTransformation = "connected → flows → will measure"
          ),
          TenseSentenceItem(
            id = "t20_s10",
            baseActionSinhala = "පෙරහන් කඩදාසියකින් ද්‍රාවණයක් පෙරා ගැනීම",
            pastEnglish = "She filtered the chalk precipitate using filter paper and funnel.",
            pastSinhala = "ඇය පෙරහන් කඩදාසිය සහ පුනීලය භාවිතයෙන් හුණු අවක්ෂේපය පෙරා ගත්තාය.",
            presentEnglish = "Filtration separates insoluble solids from liquids cleanly.",
            presentSinhala = "පෙරීම නොදියවන ඝන ද්‍රව්‍ය ද්‍රවවලින් පිරිසිදුව වෙන් කරයි.",
            futureEnglish = "She will dry the residue in a desiccator.",
            futureSinhala = "ඇය වියළනයක් තුළ අවශේෂය වියළා ගනු ඇත.",
            verbTransformation = "filtered → separates → will dry"
          ),
          TenseSentenceItem(
            id = "t20_s11",
            baseActionSinhala = "ගුරුත්වාකර්ෂණය අත්හදා බැලීම",
            pastEnglish = "Galileo dropped different masses from the Leaning Tower of Pisa.",
            pastSinhala = "ගැලීලියෝ පීසා ඇලවෙන කුළුණේ සිට විවිධ ස්කන්ධ පහතට දැමුවේය.",
            presentEnglish = "All objects accelerate at 9.8 meters per second squared in vacuum.",
            presentSinhala = "රික්තකයක් තුළ සියලුම වස්තූන් තත්පරයට මීටර් 9.8 ක ත්වරණයකින් වැටෙයි.",
            futureEnglish = "We will measure acceleration due to gravity using a pendulum.",
            futureSinhala = "සරල ලෝලකයක් භාවිතයෙන් අපි ගුරුත්වාකර්ෂණ ත්වරණය මනින්නෙමු.",
            verbTransformation = "dropped → accelerate → will measure"
          ),
          TenseSentenceItem(
            id = "t20_s12",
            baseActionSinhala = "දුරේක්ෂයෙන් තරු නැරඹීම",
            pastEnglish = "Astronomers observed Saturn's rings through the telescope.",
            pastSinhala = "තාරකා විද්‍යාඥයෝ දුරේක්ෂය මඟින් සෙනසුරුගේ වළලු නිරීක්ෂණය කළහ.",
            presentEnglish = "Optical telescopes collect distant celestial photons.",
            presentSinhala = "දෘශ්‍ය දුරේක්ෂ ඈත ආකාශ වස්තූන්ගේ ආලෝකය එක්රැස් කරයි.",
            futureEnglish = "We will observe the lunar eclipse on full moon night.",
            futureSinhala = "පසළොස්වක පෝය රාත්‍රියේදී අපි චන්ද්‍රග්‍රහණය නිරීක්ෂණය කරන්නෙමු.",
            verbTransformation = "observed → collect → will observe"
          ),
          TenseSentenceItem(
            id = "t20_s13",
            baseActionSinhala = "ප්‍රතික්‍රියා වේගය මැනීම",
            pastEnglish = "We measured gas volume released over five minutes.",
            pastSinhala = "මිනිත්තු පහක් පුරා පිටවූ වායු පරිමාව අපි මැන බැලුවෙමු.",
            presentEnglish = "Catalysts accelerate chemical reactions without being consumed.",
            presentSinhala = "උත්ප්‍රේරක වැය නොවී රසායනික ප්‍රතික්‍රියා වේගවත් කරයි.",
            futureEnglish = "We will plot a rate graph on millimeter graph paper.",
            futureSinhala = "අපි මිලිමීටර් ප්‍රස්තාර පත්‍රයක ප්‍රතික්‍රියා සීඝ්‍රතා ප්‍රස්තාරයක් අඳින්නෙමු.",
            verbTransformation = "measured → accelerate → will plot"
          ),
          TenseSentenceItem(
            id = "t20_s14",
            baseActionSinhala = "ඝනත්වය සෙවීම",
            pastEnglish = "The student determined the stone's density using water displacement.",
            pastSinhala = "ශිෂ්‍යයා ජල විස්ථාපනය මඟින් ගලේ ඝනත්වය තීරණය කළේය.",
            presentEnglish = "Density equals mass divided by volume.",
            presentSinhala = "ඝනත්වය යනු ස්කන්ධය පරිමාවෙන් බෙදූ අගයයි.",
            futureEnglish = "We will calculate the density of an irregular metal bolt.",
            futureSinhala = "අපි අක්‍රමවත් ලෝහ බෝල්ට් ඇණයක ඝනත්වය ගණනය කරන්නෙමු.",
            verbTransformation = "determined → equals → will calculate"
          ),
          TenseSentenceItem(
            id = "t20_s15",
            baseActionSinhala = "ලිට්මස් පරීක්ෂාව",
            pastEnglish = "The acidic lime juice turned blue litmus red.",
            pastSinhala = "ආම්ලික දෙහි යුෂ නිල් ලිට්මස් රතු පැහැයට හැරවීය.",
            presentEnglish = "Indicators change color according to hydrogen ion concentration.",
            presentSinhala = "හයිඩ්‍රජන් අයන සාන්ද්‍රණය අනුව දර්ශක වර්ණ වෙනස් කරයි.",
            futureEnglish = "We will test soil pH with universal indicator paper.",
            futureSinhala = "අපි විශ්ව දර්ශක කඩදාසියෙන් පසේ pH අගය පරීක්ෂා කරන්නෙමු.",
            verbTransformation = "turned → change → will test"
          ),
          TenseSentenceItem(
            id = "t20_s16",
            baseActionSinhala = "ප්‍රතිජීවකයක් සොයා ගැනීම",
            pastEnglish = "Alexander Fleming discovered penicillin by serendipity in 1928.",
            pastSinhala = "ඇලෙක්සැන්ඩර් ෆ්ලෙමින් 1928 දී අහඹු ලෙස පෙනිසිලින් සොයා ගත්තේය.",
            presentEnglish = "Antibiotics combat bacterial infections and save millions.",
            presentSinhala = "ප්‍රතිජීවක බැක්ටීරියා ආසාදන මර්දනය කරමින් මිලියන ගණනක් ජීවිත බේරා ගනී.",
            futureEnglish = "Scientists will engineer new antimicrobials against resistant strains.",
            futureSinhala = "ප්‍රතිරෝධී වික්‍රියා වලට එරෙහිව විද්‍යාඥයෝ නව ක්ෂුද්‍රජීවී නාශක නිපදවනු ඇත.",
            verbTransformation = "discovered → combat → will engineer"
          ),
          TenseSentenceItem(
            id = "t20_s17",
            baseActionSinhala = "කැඩපතකින් ආලෝකය පරාවර්තනය",
            pastEnglish = "The ray reflected off the plane mirror at thirty degrees.",
            pastSinhala = "ආලෝක කිරණය අංශක තිහකින් තල දර්පණයෙන් පරාවර්තනය විය.",
            presentEnglish = "The angle of incidence equals the angle of reflection.",
            presentSinhala = "පතන කෝණය පරාවර්තන කෝණයට සමාන වේ.",
            futureEnglish = "We will demonstrate total internal reflection with an acrylic prism.",
            futureSinhala = "අපි ප්‍රිස්මයක් භාවිතයෙන් පූර්ණ අභ්‍යන්තර පරාවර්තනය ආදර්ශනය කරන්නෙමු.",
            verbTransformation = "reflected → equals → will demonstrate"
          ),
          TenseSentenceItem(
            id = "t20_s18",
            baseActionSinhala = "සමතුලිතතාව පරීක්ෂා කිරීම",
            pastEnglish = "We weighed chemicals on the high-precision digital balance.",
            pastSinhala = "අපි අධි-නිරවද්‍ය ඩිජිටල් තරාදියේ රසායනික ද්‍රව්‍ය කිරා බැලුවෙමු.",
            presentEnglish = "Precise calibration prevents experimental measuring errors.",
            presentSinhala = "නිවැරදි ක්‍රමාංකනය පර්යේෂණාත්මක මිනුම් දෝෂ වළක්වයි.",
            futureEnglish = "I will tare the balance before adding magnesium powder.",
            futureSinhala = "මැග්නීසියම් කුඩු දැමීමට පෙර මම තරාදිය බිංදුවට සකස් කරන්නෙමි.",
            verbTransformation = "weighed → prevents → will tare"
          ),
          TenseSentenceItem(
            id = "t20_s19",
            baseActionSinhala = "ශක්ති සංරක්ෂණ නියමය පරීක්ෂා කිරීම",
            pastEnglish = "The physics teacher demonstrated the conservation of momentum.",
            pastSinhala = "භෞතික විද්‍යා ගුරුවරයා ගම්‍යතා සංරක්ෂණය ආදර්ශනය කළේය.",
            presentEnglish = "Energy cannot be created or destroyed, only transformed.",
            presentSinhala = "ශක්තිය මැවීමට හෝ විනාශ කිරීමට නොහැකිය, පරිවර්තනය කළ හැක්කේ පමණි.",
            futureEnglish = "We will verify energy transformation using solar cells.",
            futureSinhala = "සූර්ය කෝෂ භාවිතයෙන් අපි ශක්ති පරිවර්තනය තහවුරු කරන්නෙමු.",
            verbTransformation = "demonstrated → cannot be created → will verify"
          ),
          TenseSentenceItem(
            id = "t20_s20",
            baseActionSinhala = "ලේ වර්ගීකරණය කිරීම",
            pastEnglish = "The doctor tested blood grouping using antigens A and B.",
            pastSinhala = "වෛද්‍යවරයා ප්‍රතිදේහජනක A සහ B භාවිතයෙන් රුධිර ඝනය පරීක්ෂා කළේය.",
            presentEnglish = "Blood types determine transfusion compatibility reliably.",
            presentSinhala = "රුධිර ඝන රුධිර පාරවිලයන ගැළපුම විශ්වාසදායක ලෙස තීරණය කරයි.",
            futureEnglish = "We will test Rh factor agglutination in the biology lab.",
            futureSinhala = "අපි ජීව විද්‍යාගාරයේදී Rh සාධකය පරීක්ෂා කරන්නෙමු.",
            verbTransformation = "tested → determine → will test"
          ),
          TenseSentenceItem(
            id = "t20_s21",
            baseActionSinhala = "වාෂ්පීකරණය සහ ඝනීභවනය",
            pastEnglish = "Water evaporated into steam and condensed in the condenser.",
            pastSinhala = "ජලය හුමාලය බවට වාෂ්ප වී ඝනීකාරකය තුළ ඝනීභවනය විය.",
            presentEnglish = "Distillation purifies saline water into crystal potable water.",
            presentSinhala = "ආසවනය කරදිය පිරිසිදු පානීය ජලය බවට පත් කරයි.",
            futureEnglish = "We will distill pure ethanol from fermented sugar solution.",
            futureSinhala = "අපි පැසුණු සීනි ද්‍රාවණයකින් පිරිසිදු එතනෝල් ආසවනය කරන්නෙමු.",
            verbTransformation = "evaporated / condensed → purifies → will distill"
          ),
          TenseSentenceItem(
            id = "t20_s22",
            baseActionSinhala = "චුම්බක ප්‍රේරණය පරීක්ෂා කිරීම",
            pastEnglish = "Michael Faraday induced electric current by moving a magnet.",
            pastSinhala = "මයිකල් ෆැරඩේ චුම්බකයක් චලනය කිරීමෙන් විදුලි ධාරාවක් ප්‍රේරණය කළේය.",
            presentEnglish = "Generators convert mechanical rotational motion into electricity.",
            presentSinhala = "ජනක යන්ත්‍ර යාන්ත්‍රික භ්‍රමණ චලිතය විදුලිය බවට පරිවර්තනය කරයි.",
            futureEnglish = "We will build a simple electromagnetic dynamo tomorrow.",
            futureSinhala = "අපි හෙට සරල විද්‍යුත් චුම්බක ඩයිනමෝවක් හදන්නෙමු.",
            verbTransformation = "induced → convert → will build"
          ),
          TenseSentenceItem(
            id = "t20_s23",
            baseActionSinhala = "ප්‍රතිශක්තිකරණ එන්නතක් දියුණු කිරීම",
            pastEnglish = "Immunologists developed an effective mRNA vaccine swiftly.",
            pastSinhala = "ප්‍රතිශක්ති විද්‍යාඥයෝ කාර්යක්ෂම mRNA එන්නතක් කඩිනමින් දියුණු කළහ.",
            presentEnglish = "Vaccines stimulate antibodies without causing actual illness.",
            presentSinhala = "එන්නත් සැබෑ රෝගය ඇති නොකර ප්‍රතිදේහ උත්තේජනය කරයි.",
            futureEnglish = "Clinical researchers will initiate human safety trials soon.",
            futureSinhala = "සායනික පර්යේෂකයෝ ඉක්මනින්ම මානව ආරක්ෂණ අත්හදා බැලීම් ආරම්භ කරනු ඇත.",
            verbTransformation = "developed → stimulate → will initiate"
          ),
          TenseSentenceItem(
            id = "t20_s24",
            baseActionSinhala = "ජීව විද්‍යාත්මක ආදර්ශකයක් විච්ඡේදනය",
            pastEnglish = "The biology class dissected a hibiscus flower to examine petals and stamen.",
            pastSinhala = "ජීව විද්‍යා පන්තිය පෙති සහ රේණු පරීක්ෂා කිරීමට වද මලක් විච්ඡේදනය කළහ.",
            presentEnglish = "Flower anatomy clarifies floral reproduction pathways.",
            presentSinhala = "මල් ව්‍යුහ විද්‍යාව මල්වල ප්‍රජනක ක්‍රියාවලීන් පැහැදිලි කරයි.",
            futureEnglish = "We will examine pollen grains under sixty-times magnification.",
            futureSinhala = "අපි හැට ගුණයක විශාලනය යටතේ පරාග රේණු පරීක්ෂා කරන්නෙමු.",
            verbTransformation = "dissected → clarifies → will examine"
          ),
          TenseSentenceItem(
            id = "t20_s25",
            baseActionSinhala = "ගෝලීය උෂ්ණත්වය මැනීම",
            pastEnglish = "Climatologists documented a record rise in ocean temperatures.",
            pastSinhala = "දේශගුණ විද්‍යාඥයෝ සාගර උෂ්ණත්වයේ වාර්තාගත ඉහළ යාමක් සටහන් කළහ.",
            presentEnglish = "Greenhouse gas emissions trap thermal radiation in atmosphere.",
            presentSinhala = "හරිතාගාර වායු විමෝචනය වායුගෝලයේ තාප විකිරණ රඳවා ගනී.",
            futureEnglish = "Renewable energy adoption will reduce atmospheric carbon.",
            futureSinhala = "පුනර්ජනනීය බලශක්තිය භාවිතය වායුගෝලීය කාබන් අඩු කරනු ඇත.",
            verbTransformation = "documented → trap → will reduce"
          ),
          TenseSentenceItem(
            id = "t20_s26",
            baseActionSinhala = "විද්‍යාත්මක වාර්තාවක් ලිවීම",
            pastEnglish = "Naveen wrote an insightful lab report on Ohm's law.",
            pastSinhala = "නවීන් ඕම්ගේ නියමය පිළිබඳ අගනා විද්‍යාගාර වාර්තාවක් ලිව්වේය.",
            presentEnglish = "Accurate lab reports explain hypotheses, methods, and results.",
            presentSinhala = "නිවැරදි විද්‍යාගාර වාර්තා උපකල්පන, ක්‍රමවේද සහ ප්‍රතිඵල පැහැදිලි කරයි.",
            futureEnglish = "He will submit his research paper to the young scientists' forum.",
            futureSinhala = "ඔහු තරුණ විද්‍යාඥයන්ගේ සංසදයට තම පර්යේෂණ පත්‍රිකාව ඉදිරිපත් කරනු ඇත.",
            verbTransformation = "wrote → explain → will submit"
          ),
          TenseSentenceItem(
            id = "t20_s27",
            baseActionSinhala = "විද්‍යා ප්‍රදර්ශනයකට සහභාගී වීම",
            pastEnglish = "Our school exhibited an automated solar irrigation model.",
            pastSinhala = "අපේ පාසල ස්වයංක්‍රීය සූර්ය ජල සම්පාදන ආකෘතියක් ප්‍රදර්ශනය කළේය.",
            presentEnglish = "Science exhibitions nurture inventive curiosity among school children.",
            presentSinhala = "විද්‍යා ප්‍රදර්ශන පාසල් දරුවන් අතර නව නිපැයුම් කුතුහලය පෝෂණය කරයි.",
            futureEnglish = "We will demonstrate an earthquake warning sensor model.",
            futureSinhala = "අපි භූමිකම්පා අනතුරු ඇඟවීමේ සංවේදක ආකෘතියක් ආදර්ශනය කරන්නෙමු.",
            verbTransformation = "exhibited → nurture → will demonstrate"
          ),
          TenseSentenceItem(
            id = "t20_s28",
            baseActionSinhala = "නැනෝ තාක්ෂණය අධ්‍යයනය",
            pastEnglish = "Engineers fabricated water-repellent lotus-effect coatings.",
            pastSinhala = "ඉංජිනේරුවෝ ජලය විකර්ෂණය කරන නෙළුම් ආචරණ ආලේපන නිර්මාණය කළහ.",
            presentEnglish = "Nanotechnology alters physical properties at the molecular level.",
            presentSinhala = "නැනෝ තාක්ෂණය අණුක මට්ටමින් භෞතික ගුණාංග වෙනස් කරයි.",
            futureEnglish = "Nanomedicine will deliver cancer drugs directly into tumor cells.",
            futureSinhala = "නැනෝ ඖෂධ පිළිකා නාශක ඖෂධ ඍජුවම පිළිකා සෛල වෙත ලබා දෙනු ඇත.",
            verbTransformation = "fabricated → alters → will deliver"
          ),
          TenseSentenceItem(
            id = "t20_s29",
            baseActionSinhala = "අවකාශ ගවේෂණය",
            pastEnglish = "The robotic probe landed on Mars and collected soil samples.",
            pastSinhala = "රොබෝ යානය අඟහරු මත ගොඩබැස පස් සාම්පල එකතු කළේය.",
            presentEnglish = "Space exploration deepens our understanding of cosmic origin.",
            presentSinhala = "අභ්‍යවකාශ ගවේෂණය විශ්වයේ ආරම්භය පිළිබඳ අපගේ අවබෝධය ගැඹුරු කරයි.",
            futureEnglish = "Human astronauts will establish a permanent base on the Moon.",
            futureSinhala = "මිනිස් ගගනගාමීන් සඳ මත ස්ථිර කඳවුරක් ස්ථාපිත කරනු ඇත.",
            verbTransformation = "landed → deepens → will establish"
          ),
          TenseSentenceItem(
            id = "t20_s30",
            baseActionSinhala = "විද්‍යාවෙන් ලොව දිනීම",
            pastEnglish = "Pioneering scientists transformed the world through visionary breakthroughs.",
            pastSinhala = "පුරෝගාමී විද්‍යාඥයෝ විප්ලවීය සොයාගැනීම් තුළින් ලෝකය පරිවර්තනය කළහ.",
            presentEnglish = "Scientific inquiry enlightens the human mind and dispels ignorance.",
            presentSinhala = "විද්‍යාත්මක විමර්ශනය මානව මනස ආලෝකවත් කර නොදැනුවත්කම දුරු කරයි.",
            futureEnglish = "Your knowledge and inquiry will shape a brighter and safer future.",
            futureSinhala = "ඔබගේ දැනුම සහ ගවේෂණශීලී බව වඩාත් දීප්තිමත් හා ආරක්ෂිත අනාගතයක් නිර්මාණය කරනු ඇත.",
            verbTransformation = "transformed → enlightens → will shape"
          )
        )
      )
    )
  }
}
