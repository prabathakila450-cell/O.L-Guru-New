package com.example

/**
 * 🌍 Voice Quiz Bank for Geography (භූගෝල විද්‍යාව)
 * 200 strictly simple, direct, factual, non-formula, non-explanatory geography questions.
 * 10 distinct sets of 20 questions each.
 */
object VoiceQuizGeographyBank {

  fun getQuestion(grade: String, setNum: Int, qIndex: Int, theme: String): Quintuple<String, String, List<String>, String, String> {
    if (grade == "11") {
      return VoiceQuizGeographyGrade11Bank.getQuestion(setNum, qIndex, theme)
    }
    if (grade == "9") {
      return VoiceQuizGeographyGrade9Bank.getQuestion(setNum, qIndex, theme)
    }
    return when (setNum) {
      // Set 1: පෘථිවිය, අක්ෂාංශ & දේශාංශ
      1 -> when (qIndex) {
        1 -> Quintuple("පෘථිවියේ සැබෑ හැඩය හඳුන්වන විශේෂ නම කුමක්ද?", "Special name for true shape of Earth?", listOf("ජියොයිඩ්", "Geoid"), "ජියොයිඩ් (Geoid) හැඩය වේ.", "ජියොයිඩ් වේ.")
        2 -> Quintuple("පෘථිවිය උතුරු සහ දකුණු අර්ධගෝල දෙකට වෙන් කරන 0° අක්ෂාංශ රේඛාව කුමක්ද?", "0 degree latitude dividing Earth into North and South?", listOf("සමකය", "Equator"), "සමකය (Equator) වේ.", "සමකයයි.")
        3 -> Quintuple("පෘථිවියේ 0° දේශාංශ රේඛාව හඳුන්වන්නේ කෙසේද?", "0 degree longitude line?", listOf("ග්‍රිනිච් රේඛාව", "Greenwich", "ප්‍රධාන මධ්‍යහ්න රේඛාව"), "ප්‍රධාන මධ්‍යහ්න රේඛාව හෙවත් ග්‍රිනිච් රේඛාව වේ.", "ග්‍රිනිච් රේඛාවයි.")
        4 -> Quintuple("උතුරු ධ්‍රැවයේ අක්ෂාංශ අගය අංශක කීයද?", "Latitude of North Pole?", listOf("90", "90° උතුර", "අංශක 90"), "උතුරු අංශක 90 (90° N) වේ.", "90° N වේ.")
        5 -> Quintuple("දකුණු ධ්‍රැවයේ අක්ෂාංශ අගය අංශක කීයද?", "Latitude of South Pole?", listOf("90", "90° දකුණ", "අංශක 90"), "දකුණු අංශක 90 (90° S) වේ.", "90° S වේ.")
        6 -> Quintuple("අංශක 23 1/2 උතුරු අක්ෂාංශය හඳුන්වන නම කුමක්ද?", "Name of 23.5° North latitude?", listOf("කර්කටක නිවර්තනය", "කර්කටක"), "කර්කටක නිවර්තනය (Tropic of Cancer) වේ.", "කර්කටක නිවර්තනයයි.")
        7 -> Quintuple("අංශක 23 1/2 දකුණු අක්ෂාංශය හඳුන්වන නම කුමක්ද?", "Name of 23.5° South latitude?", listOf("මකර නිවර්තනය", "මකර"), "මකර නිවර්තනය (Tropic of Capricorn) වේ.", "මකර නිවර්තනයයි.")
        8 -> Quintuple("පෘථිවියේ පිටතම ඝන පාෂාණ ස්ථරය කුමක්ද?", "Outermost solid rock layer of Earth?", listOf("භූ කබොල", "කබොල", "Crust"), "භූ කබොල (Earth's Crust) වේ.", "භූ කබොලයි.")
        9 -> Quintuple("පෘථිවියේ කබොලට යටින් පිහිටි මැද ස්ථරය කුමක්ද?", "Middle layer beneath crust?", listOf("ප්‍රාවරණය", "Mantle"), "ප්‍රාවරණය (Mantle) වේ.", "ප්‍රාවරණයයි.")
        10 -> Quintuple("පෘථිවියේ මධ්‍යයේම පිහිටි අභ්‍යන්තරම කොටස කුමක්ද?", "Innermost center layer of Earth?", listOf("න්‍යෂ්ටිය", "Core"), "භූ න්‍යෂ්ටිය (Core) වේ.", "න්‍යෂ්ටියයි.")
        11 -> Quintuple("පෘථිවිය තමන් වටා භ්‍රමණය වීමට ගතවන කාලය පැය කීයද?", "Hours for Earth to rotate on its axis?", listOf("24", "පැය 24", "24ක්"), "පැය 24කි (දින 1කි).", "පැය 24කි.")
        12 -> Quintuple("පෘථිවිය තමන් වටා භ්‍රමණය වීම නිසා ඇතිවන ප්‍රධාන සංසිද්ධිය කුමක්ද?", "Main phenomenon caused by rotation?", listOf("දිවා රෑ", "රෑ දවල්"), "දිවා සහ රාත්‍රිය ඇතිවීමයි.", "දිවා රෑ ඇතිවීමයි.")
        13 -> Quintuple("පෘථිවිය සූර්යයා වටා එක් වටයක් පරිභ්‍රමණය වීමට දින කීයක් ගතවේද?", "Days for Earth to orbit the Sun?", listOf("365", "365 1/4", "දින 365"), "දින 365 1/4 (වසර 1ක්) ගතවේ.", "දින 365 1/4කි.")
        14 -> Quintuple("පෘථිවියේ පරිභ්‍රමණය සහ අක්ෂයේ ඇලවීම නිසා ඇතිවන්නේ මොනවාද?", "Caused by revolution and tilted axis?", listOf("සෘතු", "ඍතු", "Seasons"), "සෘතු (Seasons) ඇතිවීමයි.", "සෘතු ඇතිවේ.")
        15 -> Quintuple("පෘථිවිය භ්‍රමණය වන්නේ බටහිර සිට කුමන දිශාවටද?", "Earth rotates from west to which direction?", listOf("නැගෙනහිරට", "නැගෙනහිර"), "නැගෙනහිර දෙසටය.", "නැගෙනහිරටයි.")
        16 -> Quintuple("ජාත්‍යන්තර දින රේඛාව පිහිටා ඇත්තේ කීවන දේශාංශයේද?", "Longitude of International Date Line?", listOf("180", "180°", "අංශක 180"), "අංශක 180 (180°) දේශාංශයේය.", "180° වේ.")
        17 -> Quintuple("පෘථිවි පෘෂ්ඨයෙන් වැඩිම ප්‍රතිශතයක් ආවරණය වන්නේ ගොඩබිමෙන්ද සාගරයෙන්ද?", "Is Earth covered more by ocean or land?", listOf("සාගරයෙන්", "ජලයෙන්", "මුහුදෙන්"), "සාගරයෙන් (ජලයෙන් - 71%ක් පමණ) වේ.", "සාගරයෙනි.")
        18 -> Quintuple("පෘථිවියේ ගොඩබිම් ප්‍රතිශතය දළ වශයෙන් සියයට කීයද?", "Percentage of land on Earth?", listOf("29%", "29", "සියයට 29"), "29% ක් පමණ වේ.", "29% කි.")
        19 -> Quintuple("සිතියමක උතුරු දිශාව සාමාන්‍යයෙන් දක්වන්නේ කුමන පැත්තෙන්ද?", "North is usually indicated at top or bottom?", listOf("ඉහළින්", "උඩින්", "Top"), "සිතියමේ ඉහළින් (උඩින්) වේ.", "ඉහළින් වේ.")
        20 -> Quintuple("සිතියමක දුර සැබෑ දුර සමඟ සසඳන අනුපාතය කුමක්ද?", "Ratio comparing map distance to actual ground distance?", listOf("පරිමාණය", "Scale"), "පරිමාණය (Scale) වේ.", "පරිමාණයයි.")
        else -> Quintuple("සමකය අංශක බිංදුවේ අක්ෂාංශයද?", "Is equator 0 degree latitude?", listOf("ඔව්", "එසේය"), "ඔව්, 0° අක්ෂාංශයයි.", "ඔව් වේ.")
      }

      // Set 2: භූ තල චලන, ගිනිකඳු & භූමිකම්පා
      2 -> when (qIndex) {
        1 -> Quintuple("භූ කබොල සෑදී ඇති විශාල පාෂාණමය කොටස් හඳුන්වන්නේ කෙසේද?", "Large rock slabs making up Earth's crust?", listOf("භූ තල", "ටෙක්ටොනික් තල", "Plates"), "භූ තල (Tectonic Plates) නමිනි.", "භූ තලයි.")
        2 -> Quintuple("භූ තල එකිනෙක ගැටීම හෝ ඈත් වීම හඳුන්වන්නේ කුමක් නමින්ද?", "Movement of tectonic plates?", listOf("භූ තල චලන", "තල චලන"), "භූ තල චලන නමිනි.", "භූ තල චලන වේ.")
        3 -> Quintuple("පෘථිවි අභ්‍යන්තරයේ හදිසියේ සිදුවන කම්පනය කුමක්ද?", "Sudden shaking of Earth's interior?", listOf("භූමිකම්පාව", "භූකම්පනය"), "භූමිකම්පාව (Earthquake) වේ.", "භූමිකම්පාවයි.")
        4 -> Quintuple("භූමිකම්පාවක ප්‍රබලතාව මනින ප්‍රධාන පරිමාණය කුමක්ද?", "Scale measuring earthquake magnitude?", listOf("රික්ටර්", "රිච්ටර්", "Richter"), "රික්ටර් පරිමාණය (Richter scale) වේ.", "රික්ටර් පරිමාණයයි.")
        5 -> Quintuple("භූමිකම්පා තරංග සටහන් කරගන්නා විද්‍යාත්මක උපකරණය කුමක්ද?", "Instrument recording earthquake waves?", listOf("භූකම්පන මානය", "භූකම්පන ලේඛය", "Seismograph"), "භූකම්පන ලේඛය (Seismograph) වේ.", "භූකම්පන ලේඛයයි.")
        6 -> Quintuple("භූමිකම්පාව ආරම්භ වන පෘථිවි අභ්‍යන්තර ලක්ෂ්‍යය කුමක්ද?", "Point inside Earth where earthquake starts?", listOf("නාභිය", "Focus"), "නාභිය (Focus) වේ.", "නාභියයි.")
        7 -> Quintuple("නාභියට සිරස්ව ඉහළින් පිහිටි පෘථිවි මතුපිට ලක්ෂ්‍යය කුමක්ද?", "Point on Earth surface directly above focus?", listOf("අපි කේන්ද්‍රය", "Epicenter"), "අපිකේන්ද්‍රය (Epicenter) වේ.", "අපිකේන්ද්‍රයයි.")
        8 -> Quintuple("සාගර පත්ලේ භූමිකම්පාවක් නිසා ඇතිවන දැවැන්ත රළ මාලාව කුමක්ද?", "Giant ocean waves caused by underwater earthquake?", listOf("සුනාමි", "Tsunami"), "සුනාමි (Tsunami) රළ වේ.", "සුනාමි වේ.")
        9 -> Quintuple("ශ්‍රී ලංකාවට සුනාමි ආපදාව බලපෑවේ කුමන වර්ෂයේද?", "Which year did tsunami hit Sri Lanka?", listOf("2004", "2004 දී"), "2004 දෙසැම්බර් 26 වනදාය.", "2004 වසරේදීය.")
        10 -> Quintuple("පෘථිවි අභ්‍යන්තරයේ ඇති උණුසුම් උණු වූ පාෂාණ ද්‍රව්‍ය හඳුන්වන්නේ කෙසේද?", "Molten hot rock beneath Earth surface?", listOf("මැග්මා", "Magma"), "මැග්මා (Magma) නමිනි.", "මැග්මා වේ.")
        11 -> Quintuple("මැග්මා පෘථිවි මතුපිටට පැමිණ ගලායන විට හඳුන්වන්නේ කෙසේද?", "Magma flowing on Earth's surface?", listOf("ලාවා", "Lava"), "ලාවා (Lava) නමිනි.", "ලාවා වේ.")
        12 -> Quintuple("ලාවා සහ දුමාරය පිටතට විදින භූමියේ සිදුරු හඳුන්වන්නේ කෙසේද?", "Openings spewing lava and ash?", listOf("ගිනිකඳු", "ගිනිකන්ද", "Volcano"), "ගිනිකඳු (Volcanoes) නමිනි.", "ගිනිකඳු වේ.")
        13 -> Quintuple("ලොව වැඩිම ගිනිකඳු සහ භූමිකම්පා සංඛ්‍යාවක් ඇති ශාන්තිකර සාගර කලාපය කුමක්ද?", "Pacific zone with most volcanoes and earthquakes?", listOf("ගිනි වළල්ල", "Ring of fire"), "පැසිෆික් ගිනි වළල්ල (Pacific Ring of Fire) වේ.", "ගිනි වළල්ලයි.")
        14 -> Quintuple("ජපානයේ පිහිටි සුප්‍රකට ගිනිකන්ද කුමක්ද?", "Famous volcano in Japan?", listOf("ෆුජි", "ෆුජියාමා", "Fuji"), "ෆුජි කන්ද (Mount Fuji) වේ.", "ෆුජි කන්දයි.")
        15 -> Quintuple("හිමාලය කඳු පන්තිය නිර්මාණය වූයේ භූ තල එකිනෙක ගැටීමෙන්ද?", "Did Himalayas form by plate collision?", listOf("ඔව්", "එසේය"), "ඔව්, ඉන්දු හා යුරේසියානු තල ගැටීමෙනි.", "ඔව් වේ.")
        16 -> Quintuple("ලෝකයේ උසම කඳු පන්තිය කුමක්ද?", "Highest mountain range in world?", listOf("හිමාලය", "Himalayas"), "හිමාලය කඳු පන්තිය වේ.", "හිමාලයයි.")
        17 -> Quintuple("ශ්‍රී ලංකාව පිහිටා ඇත්තේ භූ තලයක මධ්‍යයේද නැතහොත් දාරයකද?", "Is Sri Lanka in middle or edge of tectonic plate?", listOf("මධ්‍යයේ", "මැද"), "ඉන්දු-ඕස්ට්‍රේලියානු තලයේ මධ්‍යයේය.", "මධ්‍යයේය.")
        18 -> Quintuple("ශ්‍රී ලංකාවේ සක්‍රිය ගිනිකඳු තිබේද?", "Are there active volcanoes in Sri Lanka?", listOf("නැත", "නැහැ"), "නැත, සක්‍රිය ගිනිකඳු නැත.", "නැත.")
        19 -> Quintuple("භූමිකම්පාවකදී ගොඩනැගිල්ලක් තුළ සිටී නම් ආරක්ෂිත විය හැකි ක්‍රමයක් පවසන්න.", "Safety measure inside during earthquake?", listOf("මේසයක් යටට යාම", "ආවරණය වීම"), "ශක්තිමත් මේසයක් යටට වී හිස ආවරණය කරගැනීමයි.", "මේසයක් යටට යාමයි.")
        20 -> Quintuple("සුනාමි අනතුරු ඇඟවීමක් ලැබුණු වහාම කළ යුත්තේ කුමක්ද?", "What to do upon tsunami warning?", listOf("උස් බිමකට යාම", "වෙරළෙන් ඈත්වීම"), "වෙරළෙන් ඈත්ව කඩිනමින් උස් බිමකට යාමයි.", "උස් බිමකට යාමයි.")
        else -> Quintuple("සුනාමි රළ ඇතිවන්නේ සාගරයේද?", "Do tsunamis occur in the ocean?", listOf("ඔව්", "එසේය"), "ඔව්, සාගරයේය.", "ඔව් වේ.")
      }

      // Set 3: ශ්‍රී ලංකාවේ පිහිටීම & දේශසීමා
      3 -> when (qIndex) {
        1 -> Quintuple("ශ්‍රී ලංකාව පිහිටා ඇත්තේ කුමන සාගරයේද?", "Which ocean is Sri Lanka located in?", listOf("ඉන්දියන් සාගරය", "ඉන්දියන්"), "ඉන්දියන් සාගරයේ වේ.", "ඉන්දියන් සාගරයයි.")
        2 -> Quintuple("ශ්‍රී ලංකාවට ආසන්නතම අසල්වැසි රට කුමක්ද?", "Closest neighbor country to Sri Lanka?", listOf("ඉන්දියාව", "India"), "ඉන්දියාව (India) වේ.", "ඉන්දියාවයි.")
        3 -> Quintuple("ශ්‍රී ලංකාව සහ ඉන්දියාව වෙන් කරන මුහුදු සමුද්‍ර සන්ධිය කුමක්ද?", "Strait separating Sri Lanka and India?", listOf("පෝක් සමුද්‍ර සන්ධිය", "පෝක්"), "පෝක් සමුද්‍ර සන්ධිය (Palk Strait) වේ.", "පෝක් සමුද්‍ර සන්ධියයි.")
        4 -> Quintuple("ශ්‍රී ලංකාව සහ ඉන්දියාව අතර පිහිටි මුහුදු බොක්ක කුමක්ද?", "Gulf between Sri Lanka and India?", listOf("මන්නාරම් බොක්ක", "මන්නාරම"), "මන්නාරම් බොක්ක වේ.", "මන්නාරම් බොක්කයි.")
        5 -> Quintuple("ශ්‍රී ලංකාවේ මුළු භූමි ප්‍රමාණය වර්ග කිලෝමීටර කීයද?", "Total land area of Sri Lanka in sq km?", listOf("65,610", "65610"), "වර්ග කිලෝමීටර 65,610 කි.", "65,610 කි.")
        6 -> Quintuple("ශ්‍රී ලංකාවේ උතුරේ සිට දකුණට උපරිම දිග කිලෝමීටර කීයද?", "Maximum north to south length of Sri Lanka?", listOf("432", "432km", "430"), "කිලෝමීටර 432ක් පමණ වේ.", "432 km වේ.")
        7 -> Quintuple("ශ්‍රී ලංකාවේ බටහිර සිට නැගෙනහිරට උපරිම පළල කිලෝමීටර කීයද?", "Maximum west to east width of Sri Lanka?", listOf("224", "224km", "225"), "කිලෝමීටර 224ක් පමණ වේ.", "224 km වේ.")
        8 -> Quintuple("ශ්‍රී ලංකාවේ උතුරු කෙළවර කුමක්ද?", "Northernmost point of Sri Lanka?", listOf("පේදුරු තුඩුව", "පේදුරුතුඩුව"), "පේදුරු තුඩුව (Point Pedro) වේ.", "පේදුරු තුඩුවයි.")
        9 -> Quintuple("ශ්‍රී ලංකාවේ දකුණු කෙළවර කුමක්ද?", "Southernmost point of Sri Lanka?", listOf("දෙවුන්දර තුඩුව", "දෙවුන්දර"), "දෙවුන්දර තුඩුව (Dondra Head) වේ.", "දෙවුන්දර තුඩුවයි.")
        10 -> Quintuple("ශ්‍රී ලංකාවේ බටහිර කෙළවර කුමක්ද?", "Westernmost point of Sri Lanka?", listOf("කච්චතිව්", "මන්නාරම තුඩුව"), "කච්චතිව් දූපත හෝ මන්නාරම් තුඩුව වේ.", "කච්චතිව් වේ.")
        11 -> Quintuple("ශ්‍රී ලංකාවේ නැගෙනහිර කෙළවර කුමක්ද?", "Easternmost point of Sri Lanka?", listOf("සංගමන්කන්ද", "සංගමන්කන්ද තුඩුව"), "සංගමන්කන්ද තුඩුව වේ.", "සංගමන්කන්දයි.")
        12 -> Quintuple("ශ්‍රී ලංකාවේ වාණිජ අගනගරය කුමක්ද?", "Commercial capital of Sri Lanka?", listOf("කොළඹ", "Colombo"), "කොළඹ නගරය වේ.", "කොළඹයි.")
        13 -> Quintuple("ශ්‍රී ලංකාවේ පරිපාලන අගනගරය කුමක්ද?", "Administrative capital of Sri Lanka?", listOf("ශ්‍රී ජයවර්ධනපුර කෝට්ටේ", "කෝට්ටේ"), "ශ්‍රී ජයවර්ධනපුර කෝට්ටේ වේ.", "ශ්‍රී ජයවර්ධනපුර කෝට්ටේයි.")
        14 -> Quintuple("ශ්‍රී ලංකාවේ පළාත් කීයක් තිබේද?", "How many provinces in Sri Lanka?", listOf("9", "9ක්", "නවයක්"), "පළාත් 9කි.", "පළාත් 9කි.")
        15 -> Quintuple("ශ්‍රී ලංකාවේ පරිපාලන දිස්ත්‍රික්ක කීයක් තිබේද?", "How many administrative districts in Sri Lanka?", listOf("25", "25ක්", "විසිපහක්"), "දිස්ත්‍රික්ක 25කි.", "දිස්ත්‍රික්ක 25කි.")
        16 -> Quintuple("ශ්‍රී ලංකාව සම්පූර්ණයෙන්ම පිහිටා ඇත්තේ උතුරු අර්ධගෝලයේද?", "Is Sri Lanka entirely in Northern Hemisphere?", listOf("ඔව්", "එසේය"), "ඔව්, සමකයට උතුරින් පිහිටයි.", "ඔව් වේ.")
        17 -> Quintuple("ශ්‍රී ලංකාව අයත් වන්නේ ආසියා මහාද්වීපයටද?", "Does Sri Lanka belong to Asia continent?", listOf("ඔව්", "එසේය"), "ඔව්, දකුණු ආසියාවට අයත් වේ.", "ඔව් වේ.")
        18 -> Quintuple("ශ්‍රී ලංකාව දූපතක් ලෙස හඳුන්වන්නේ ඇයි?", "Why is Sri Lanka called an island?", listOf("වටේටම මුහුද", "ජලයෙන් වටවී"), "සතර දෙසින්ම මුහුදෙන් වටවී ඇති බැවිනි.", "වටේම මුහුදයි.")
        19 -> Quintuple("ශ්‍රී ලංකාවේ විශාලතම දිස්ත්‍රික්කය කුමක්ද?", "Largest district by land area in Sri Lanka?", listOf("අනුරාධපුරය", "අනුරාධපුර"), "අනුරාධපුර දිස්ත්‍රික්කය වේ.", "අනුරාධපුරයයි.")
        20 -> Quintuple("ශ්‍රී ලංකාවේ කුඩාම දිස්ත්‍රික්කය කුමක්ද?", "Smallest district in Sri Lanka?", listOf("කොළඹ", "කොළඹ දිස්ත්‍රික්කය"), "කොළඹ දිස්ත්‍රික්කය වේ.", "කොළඹයි.")
        else -> Quintuple("ශ්‍රී ලංකාව ඉන්දියන් සාගරයේ මුතු ඇටය නමින් හඳුන්වයිද?", "Is Sri Lanka called Pearl of Indian Ocean?", listOf("ඔව්", "එසේය"), "ඔව්, එසේ හඳුන්වයි.", "ඔව් වේ.")
      }

      // Set 4: ශ්‍රී ලංකාවේ භූ විෂමතාව & කඳු
      4 -> when (qIndex) {
        1 -> Quintuple("ශ්‍රී ලංකාවේ භූ විෂමතා තලා කීයකට බෙදා ඇත්ද?", "How many relief zones in Sri Lanka?", listOf("3", "3ක්", "තුනකට"), "තලා 3කටය (පහතරට, මැදරට, උඩරට).", "තලා 3කි.")
        2 -> Quintuple("ශ්‍රී ලංකාවේ උසම කන්ද කුමක්ද?", "Highest mountain in Sri Lanka?", listOf("පිදුරුතලාගල", "Pidurutalagala"), "පිදුරුතලාගල කන්ද (මීටර් 2,524) වේ.", "පිදුරුතලාගලයි.")
        3 -> Quintuple("පිදුරුතලාගල කන්ද පිහිටි දිස්ත්‍රික්කය කුමක්ද?", "District where Pidurutalagala is located?", listOf("නුවරඑළිය", "Nuwara Eliya"), "නුවරඑළිය දිස්ත්‍රික්කය වේ.", "නුවරඑළියයි.")
        4 -> Quintuple("ශ්‍රී ලංකාවේ දෙවන උසම කන්ද කුමක්ද?", "Second highest mountain in Sri Lanka?", listOf("කිරගල්පොත්ත", "Kirigalpotta"), "කිරගල්පොත්ත කන්ද වේ.", "කිරගල්පොත්තයි.")
        5 -> Quintuple("ශ්‍රී ලංකාවේ තෙවන උසම කන්ද කුමක්ද?", "Third highest mountain in Sri Lanka?", listOf("තොටුපොළ", "තොටුපොළ කන්ද"), "තොටුපොළ කන්ද වේ.", "තොටුපොළයි.")
        6 -> Quintuple("ශ්‍රී පාද කන්ද හෙවත් සමනල කන්ද පිහිටි දිස්ත්‍රික්කය කුමක්ද?", "District of Sri Pada / Adam's Peak?", listOf("රත්නපුර", "රත්නපුරය"), "රත්නපුර දිස්ත්‍රික්කය වේ.", "රත්නපුරයයි.")
        7 -> Quintuple("ලෝකාන්තය (World's End) පිහිටා ඇත්තේ කුමන ජාතික වනෝද්‍යානයේදීද?", "National park where World's End is located?", listOf("හෝටන්තැන්න", "හෝර්ටන් තැන්න", "Horton Plains"), "හෝටන් තැන්න ජාතික වනෝද්‍යානයේදීය.", "හෝටන්තැන්නයි.")
        8 -> Quintuple("නකල්ස් (Knuckles) කඳු පන්තිය හඳුන්වන සිංහල නම කුමක්ද?", "Sinhala name for Knuckles range?", listOf("දුම්බර", "දුම්බර මිටියාවත"), "දුම්බර කඳු පන්තිය වේ.", "දුම්බර කඳුයි.")
        9 -> Quintuple("ශ්‍රී ලංකාවේ පහතරට තැන්න මුහුදු මට්ටමේ සිට මීටර් කීයක් දක්වාද?", "Low country plain height up to what meters?", listOf("300", "මීටර් 300"), "මීටර් 0 සිට 300 දක්වා වේ.", "මීටර් 300 දක්වායි.")
        10 -> Quintuple("ශ්‍රී ලංකාවේ මැදරට තැන්න මීටර් කීයේ සිට කීය දක්වාද?", "Mid country height range?", listOf("300 සිට 900", "300 - 900"), "මීටර් 300 සිට 900 දක්වා වේ.", "මීටර් 300 සිට 900යි.")
        11 -> Quintuple("ශ්‍රී ලංකාවේ උඩරට (මධ්‍යම කඳුකරය) මීටර් කීයට වඩා උස්ද?", "Highlands elevation above what meters?", listOf("900", "මීටර් 900"), "මීටර් 900ට වඩා උස් ප්‍රදේශ වේ.", "මීටර් 900ට වැඩියි.")
        12 -> Quintuple("ශ්‍රී ලංකාවේ භූමි ප්‍රමාණයෙන් වැඩිම කොටසක් අයත් වන්නේ පහතරට තැන්නටද?", "Does low country cover majority of Sri Lanka?", listOf("ඔව්", "එසේය"), "ඔව්, භූමියෙන් 75%ක් පමණ පහතරට තැන්නයි.", "ඔව් වේ.")
        13 -> Quintuple("තැනිතලාව මැද හුදකලාව ඉහළට නැඟී ඇති ශේෂ කන්දකට උදාහරණයක් පවසන්න.", "Example of isolated inselberg rock in plain?", listOf("සීගිරිය", "මිහින්තලේ", "දිඹුලාගල", "Sigiriya"), "සීගිරිය, මිහින්තලේ හෝ දිඹුලාගල වේ.", "සීගිරිය වේ.")
        14 -> Quintuple("සීගිරිය පර්වතය පිහිටා ඇත්තේ කුමන දිස්ත්‍රික්කයේද?", "District where Sigiriya is located?", listOf("මාතලේ", "මාතලේ දිස්ත්‍රික්කය"), "මාතලේ දිස්ත්‍රික්කයේ වේ.", "මාතලේයි.")
        15 -> Quintuple("ශ්‍රී ලංකාවේ කඳුකරයේ සිට ගංගා ගලා බසින්නේ කුමන රටාවටද?", "Drainage pattern radiating from central hills?", listOf("අරීය", "අරීය රටාව", "Radial"), "අරීය රටාවට (මධ්‍යම කඳුකරයෙන් සතර දෙසට) වේ.", "අරීය රටාවයි.")
        16 -> Quintuple("ශ්‍රී ලංකාවේ වෙරළබඩ කලපු සඳහා උදාහරණයක් පවසන්න.", "Example of coastal lagoon in Sri Lanka?", listOf("මඩකලපුව", "පුත්තලම කලපුව", "මීගමුව කලපුව"), "මඩකලපුව, පුත්තලම හෝ මීගමුව කලපුව වේ.", "මඩකලපුව / මීගමුවයි.")
        17 -> Quintuple("ගාල්ල කොටුව ඉදිකර ඇත්තේ ස්වභාවික අර්ධද්වීපයකද?", "Is Galle Fort built on a natural peninsula?", listOf("ඔව්", "එසේය"), "ඔව්, මුහුදට නෙරා ගිය තුඩුවකය.", "ඔව් වේ.")
        18 -> Quintuple("ශ්‍රී ලංකාවේ විශාලතම ස්වභාවික වරාය කුමක්ද?", "Largest natural harbor in Sri Lanka?", listOf("ත්‍රිකුණාමලය", "ත්‍රිකුණාමල වරාය"), "ත්‍රිකුණාමලය වරාය වේ.", "ත්‍රිකුණාමලයයි.")
        19 -> Quintuple("කොළඹ වරාය යනු කෘත්‍රිමව ඉදිකළ වරායක්ද?", "Is Colombo harbor an artificial constructed harbor?", listOf("ඔව්", "එසේය"), "ඔව්, දියකඩන බැඳ සාදන ලද වරායකි.", "ඔව් වේ.")
        20 -> Quintuple("කඳුකරයේ බෑවුම්වල සිදුවන ප්‍රධාන ස්වභාවික ආපදාව කුමක්ද?", "Main natural disaster on hill slopes?", listOf("නායයෑම්", "නාය යෑම"), "නායයෑම් (Landslides) වේ.", "නායයෑම් වේ.")
        else -> Quintuple("පිදුරුතලාගල කන්ද පිහිටියේ මධ්‍යම කඳුකරයේද?", "Is Pidurutalagala in central highlands?", listOf("ඔව්", "එසේය"), "ඔව්, මධ්‍යම කඳුකරයේය.", "ඔව් වේ.")
      }

      // Set 5: ගංගා පද්ධතිය & දියඇලි
      5 -> when (qIndex) {
        1 -> Quintuple("ශ්‍රී ලංකාවේ දිගම ගංගාව කුමක්ද?", "Longest river in Sri Lanka?", listOf("මහවැලි", "මහවැලි ගඟ", "Mahaweli"), "මහවැලි ගඟ වේ.", "මහවැලි ගඟයි.")
        2 -> Quintuple("මහවැලි ගඟේ මුළු දිග කිලෝමීටර කීයද?", "Total length of Mahaweli river in km?", listOf("335", "335km"), "කිලෝමීටර 335 කි.", "335 km වේ.")
        3 -> Quintuple("මහවැලි ගඟ මුහුදට වැටෙන්නේ කුමන ප්‍රදේශයෙන්ද?", "Where does Mahaweli river enter the sea?", listOf("ත්‍රිකුණාමලය", "කොඩ්ඩියාර් බොක්ක"), "ත්‍රිකුණාමලයේ කොඩ්ඩියාර් බොක්කෙනි.", "ත්‍රිකුණාමලයෙනි.")
        4 -> Quintuple("ශ්‍රී ලංකාවේ දෙවන දිගම ගංගාව කුමක්ද?", "Second longest river in Sri Lanka?", listOf("මල්වතු ඔය", "මල්වතු"), "මල්වතු ඔය (කිලෝමීටර් 164) වේ.", "මල්වතු ඔයයි.")
        5 -> Quintuple("කොළඹ නගරය අසලින් මුහුදට වැටෙන ප්‍රධාන ගංගාව කුමක්ද?", "Main river entering sea near Colombo?", listOf("කැළණි ගඟ", "කැළණි"), "කැළණි ගඟ වේ.", "කැළණි ගඟයි.")
        6 -> Quintuple("ශ්‍රී ලංකාවේ වැඩිම ජල කඳක් රැගෙන යන ගංගාව කුමක්ද?", "River carrying largest volume of water to sea?", listOf("කළු ගඟ", "කළු"), "කළු ගඟ වේ.", "කළු ගඟයි.")
        7 -> Quintuple("කළුතර නගරයෙන් මුහුදට වැටෙන ගංගාව කුමක්ද?", "River entering sea at Kalutara?", listOf("කළු ගඟ", "කළු"), "කළු ගඟ වේ.", "කළු ගඟයි.")
        8 -> Quintuple("හම්බන්තොටින් මුහුදට වැටෙන ප්‍රධාන ගංගාව කුමක්ද?", "River entering sea at Hambantota?", listOf("වලවේ ගඟ", "වලවේ"), "වලවේ ගඟ වේ.", "වලවේ ගඟයි.")
        9 -> Quintuple("ශ්‍රී ලංකාවේ උසම දියඇල්ල කුමක්ද?", "Highest waterfall in Sri Lanka?", listOf("බඹරකන්ද", "බඹරකන්ද ඇල්ල"), "බඹරකන්ද දියඇල්ල (මීටර් 263) වේ.", "බඹරකන්දයි.")
        10 -> Quintuple("බඹරකන්ද දියඇල්ල පිහිටා ඇති දිස්ත්‍රික්කය කුමක්ද?", "District where Bambarakanda falls is located?", listOf("බදුල්ල", "බදුල්ල දිස්ත්‍රික්කය"), "බදුල්ල (කළුපහන) වේ.", "බදුල්ලයි.")
        11 -> Quintuple("බදුල්ල නගරය අසල පිහිටි ප්‍රසිද්ධ දියඇල්ල කුමක්ද?", "Famous waterfall near Badulla town?", listOf("දුන්හිඳ", "දුන්හිඳ ඇල්ල"), "දුන්හිඳ දියඇල්ල වේ.", "දුන්හිඳයි.")
        12 -> Quintuple("නුවරඑළිය දිස්ත්‍රික්කයේ පිහිටි සුප්‍රකට නිවුන් දියඇල්ල කුමක්ද?", "Famous twin waterfall in Nuwara Eliya district?", listOf("සෙන්ට් ක්ලෙයාර්", "St. Clair"), "සෙන්ට් ක්ලෙයාර් දියඇල්ල වේ.", "සෙන්ට් ක්ලෙයාර් වේ.")
        13 -> Quintuple("තලවාකැලේ අසල පිහිටි සුන්දර දියඇල්ල කුමක්ද?", "Beautiful waterfall near Talawakele?", listOf("ඩෙවෝන්", "ඩෙවොන්", "Devon"), "ඩෙවෝන් දියඇල්ල වේ.", "ඩෙවෝන් වේ.")
        14 -> Quintuple("ශ්‍රී ලංකාවේ දෙවන උසම දියඇල්ල කුමක්ද?", "Second highest waterfall in Sri Lanka?", listOf("දියලුම", "දියලුම ඇල්ල"), "දියලුම දියඇල්ල (කොස්ලන්ද) වේ.", "දියලුමයි.")
        15 -> Quintuple("මහවැලි ගඟ ආරම්භ වන්නේ කුමන කඳුකර ප්‍රදේශයෙන්ද?", "Starting region of Mahaweli river?", listOf("ශ්‍රී පාද", "සමනල කන්ද", "හෝටන්තැන්න"), "ශ්‍රී පාද අඩවියෙන් හා හෝටන්තැන්නෙනි.", "ශ්‍රී පාද අඩවියෙනි.")
        16 -> Quintuple("අනුරාධපුර නගරය මැදින් ගලා බසින්නේ මල්වතු ඔයද?", "Does Malwathu Oya flow through Anuradhapura?", listOf("ඔව්", "එසේය"), "ඔව්, මල්වතු ඔයයි.", "ඔව් වේ.")
        17 -> Quintuple("ශ්‍රී ලංකාවේ ගංගා 103ක් පමණ මුහුදට ගලා බසීද?", "Do around 103 river basins exist in Sri Lanka?", listOf("ඔව්", "එසේය", "103ක්"), "ඔව්, ගංගා ද්‍රෝණි 103ක් පමණ ඇත.", "ඔව් වේ.")
        18 -> Quintuple("වැසි කාලයට කැලණි සහ කළු ගංගා පිටාර ගැලීමෙන් ඇතිවන ආපදාව කුමක්ද?", "Disaster caused by Kelani/Kalu rivers overflowing?", listOf("ගංවතුර", "ජලගැලීම්"), "ගංවතුර (Floods) ආපදාව වේ.", "ගංවතුරයි.")
        19 -> Quintuple("ගංගාවක් මුහුදට එක්වන ස්ථානය හඳුන්වන්නේ කෙසේද?", "Place where river meets sea?", listOf("මෝය", "මෝය කට", "Estuary"), "මෝය (මෝයකට) නමිනි.", "මෝයයි.")
        20 -> Quintuple("ගඟක ඉහළ ප්‍රදේශයේ ජල ධාරා එකතු වන ප්‍රදේශය හඳුන්වන්නේ කුමක් නමින්ද?", "Area where river collects headwaters?", listOf("ජලාධාර ප්‍රදේශය", "Catchment area"), "ජලාධාර ප්‍රදේශය (Catchment area) නමිනි.", "ජලාධාර ප්‍රදේශයයි.")
        else -> Quintuple("මහවැලි ගඟෙන් විදුලිය නිපදවයිද?", "Is hydroelectricity generated from Mahaweli?", listOf("ඔව්", "එසේය"), "ඔව්, වික්ටෝරියා, කොත්මලේ ආදී බලාගාර ඇත.", "ඔව් වේ.")
      }

      // Set 6: දේශගුණය & මෝසම් සුළං
      6 -> when (qIndex) {
        1 -> Quintuple("ශ්‍රී ලංකාව අයත් වන ප්‍රධාන දේශගුණික කලාපය කුමක්ද?", "Main climatic zone Sri Lanka belongs to?", listOf("නිවර්තන", "උණුසුම් නිවර්තන", "Tropical"), "නිවර්තන (Tropical) දේශගුණ කලාපය වේ.", "නිවර්තන වේ.")
        2 -> Quintuple("මැයි සිට සැප්තැම්බර් දක්වා හමන ප්‍රධාන මෝසම් සුළඟ කුමක්ද?", "Monsoon from May to September?", listOf("නිරිතදිග මෝසම", "නිරිතදිග"), "නිරිතදිග මෝසම් සුළඟ වේ.", "නිරිතදිග මෝසමයි.")
        3 -> Quintuple("දෙසැම්බර් සිට පෙබරවාරි දක්වා හමන මෝසම් සුළඟ කුමක්ද?", "Monsoon from December to February?", listOf("ඊසානදිග මෝසම", "ඊසානදිග"), "ඊසානදිග මෝසම් සුළඟ වේ.", "ඊසානදිග මෝසමයි.")
        4 -> Quintuple("ශ්‍රී ලංකාවේ ප්‍රධාන වර්ෂාපතන කලාප 3 මොනවාද?", "Three main rainfall zones of Sri Lanka?", listOf("තෙත් වියළි අතරමැදි", "තෙත් කලාපය", "වියළි කලාපය"), "තෙත්, වියළි සහ අතරමැදි කලාප වේ.", "තෙත්, වියළි, අතරමැදියි.")
        5 -> Quintuple("තෙත් සහ වියළි කලාප වෙන් කරන වාර්ෂික සමවර්ෂා රේඛාව කීයද?", "Isohyet line separating wet and dry zones?", listOf("මිලිමීටර් 2000", "2000mm", "2000"), "වාර්ෂික වර්ෂාපතන මිලිමීටර් 2000 රේඛාවයි.", "2000 mm වේ.")
        6 -> Quintuple("ශ්‍රී ලංකාවේ වැඩිම වර්ෂාපතනයක් ලබන ස්ථානය කුමක්ද?", "Place receiving highest rainfall in Sri Lanka?", listOf("කෙන්ෆීල්ඩ්", "ගිගිරියන්කන්ද", "නාවලපිටිය"), "කෙන්ෆීල්ඩ් හෝ ගිගිරියන්කන්ද (මි.මී. 5000ට වැඩි).", "කෙන්ෆීල්ඩ් වතුයායයි.")
        7 -> Quintuple("ශ්‍රී ලංකාවේ අඩුම වර්ෂාපතනයක් ලබන වියළිම ප්‍රදේශයක් නම් කරන්න.", "Name one of the driest places with lowest rainfall.", listOf("හම්බන්තොට", "මන්නාරම"), "මන්නාරම හෝ හම්බන්තොට වේ.", "මන්නාරම / හම්බන්තොටයි.")
        8 -> Quintuple("අප්‍රේල්-මැයි මාසවල සවස් වරුවේ අකුණු සහිතව ලැබෙන වැසි කුමක්ද?", "Afternoon thunderstorms in April-May?", listOf("සංවහන වැසි", "සංවහන"), "සංවහන වැසි (Convectional rain) වේ.", "සංවහන වැසියි.")
        9 -> Quintuple("කඳුකර බෑවුමක හැපී ඉහළ නැඟ ලැබෙන වැසි හඳුන්වන්නේ කෙසේද?", "Rain caused by winds rising over mountains?", listOf("භූ විෂමතා වැසි", "භූවිෂමතා"), "භූ විෂමතා වැසි (Orographic rain) නමිනි.", "භූ විෂමතා වැසියි.")
        10 -> Quintuple("ශ්‍රී ලංකාවේ සිසිල්ම දේශගුණයක් ඇති නගරය කුමක්ද?", "Coolest city with lowest temperature in Sri Lanka?", listOf("නුවරඑළිය", "Nuwara Eliya"), "නුවරඑළිය නගරය වේ.", "නුවරඑළියයි.")
        11 -> Quintuple("නුවරඑළියේ වාර්ෂික සාමාන්‍ය උෂ්ණත්වය සෙල්සියස් අංශක කීයද?", "Average annual temperature in Nuwara Eliya?", listOf("15", "16", "අංශක 16"), "සෙල්සියස් අංශක 15°C - 16°C පමණ වේ.", "15°C - 16°C වේ.")
        12 -> Quintuple("ශ්‍රී ලංකාවේ පහතරට වාර්ෂික සාමාන්‍ය උෂ්ණත්වය සෙල්සියස් කීයද?", "Average lowland temperature in Sri Lanka?", listOf("27", "28", "අංශක 27"), "සෙල්සියස් අංශක 27°C - 28°C පමණ වේ.", "27°C - 28°C වේ.")
        13 -> Quintuple("වායුගෝලයේ උෂ්ණත්වය මනින උපකරණය කුමක්ද?", "Instrument measuring air temperature?", listOf("උෂ්ණත්වමානය", "Thermometer"), "උෂ්ණත්වමානය (Thermometer) වේ.", "උෂ්ණත්වමානයයි.")
        14 -> Quintuple("වර්ෂාපතනය මනින උපකරණය කුමක්ද?", "Instrument measuring rainfall?", listOf("වර්ෂාමානය", "Rain gauge"), "වර්ෂාමානය (Rain gauge) වේ.", "වර්ෂාමානයයි.")
        15 -> Quintuple("සුළඟේ දිශාව දැනගැනීමට භාවිත කරන උපකරණය කුමක්ද?", "Instrument showing wind direction?", listOf("සුළං දිශා දර්ශකය", "Wind vane"), "සුළං දිශා දර්ශකය (Wind Vane) වේ.", "සුළං දිශා දර්ශකයයි.")
        16 -> Quintuple("සුළඟේ වේගය මනින උපකරණය කුමක්ද?", "Instrument measuring wind speed?", listOf("ඇනිමෝමීටරය", "Anemometer"), "ඇනිමෝමීටරය (Anemometer) වේ.", "ඇනිමෝමීටරයයි.")
        17 -> Quintuple("වායුගෝලීය පීඩනය මනින උපකරණය කුමක්ද?", "Instrument measuring atmospheric pressure?", listOf("බැරෝමීටරය", "Barometer"), "බැරෝමීටරය (Barometer) වේ.", "බැරෝමීටරයයි.")
        18 -> Quintuple("වායුගෝලයේ ආර්ද්‍රතාවය (තෙතමනය) මනින උපකරණය කුමක්ද?", "Instrument measuring humidity?", listOf("හයිග්‍රෝමීටරය", "Hygrometer"), "හයිග්‍රෝමීටරය (Hygrometer) වේ.", "හයිග්‍රෝමීටරයයි.")
        19 -> Quintuple("ශ්‍රී ලංකාවට වසර පුරාම සූර්යාලෝකය හොඳින් ලැබේවිද?", "Does Sri Lanka receive sunlight throughout the year?", listOf("ඔව්", "එසේය"), "ඔව්, සමකයට ආසන්න නිසා හොඳින් ලැබේ.", "ඔව් වේ.")
        20 -> Quintuple("වියළි කලාපයේ දීර්ඝ කාලයක් වැසි නොලැබී යාමෙන් ඇතිවන ආපදාව කුමක්ද?", "Disaster caused by prolonged lack of rain in dry zone?", listOf("නියඟය", "Drought"), "නියඟය (Drought) වේ.", "නියඟයයි.")
        else -> Quintuple("ශ්‍රී ලංකාවේ මෝසම් සුළං ප්‍රධාන වශයෙන් දෙකක්ද?", "Are there two main monsoons in Sri Lanka?", listOf("ඔව්", "එසේය"), "ඔව්, නිරිතදිග හා ඊසානදිග වේ.", "ඔව් වේ.")
      }

      // Set 7: වනාන්තර & වනජීවී
      7 -> when (qIndex) {
        1 -> Quintuple("ශ්‍රී ලංකාවේ පිහිටි ලෝක උරුම නිවර්තන වැසි වනාන්තරය කුමක්ද?", "World Heritage tropical rainforest in Sri Lanka?", listOf("සිංහරාජය", "සිංහරාජ වනය", "Sinharaja"), "සිංහරාජ වැසි වනාන්තරය වේ.", "සිංහරාජයයි.")
        2 -> Quintuple("සිංහරාජ වනාන්තරය යුනෙස්කෝ (UNESCO) ලෝක උරුමයක් ලෙස නම් කර තිබේද?", "Is Sinharaja declared a UNESCO World Heritage site?", listOf("ඔව්", "එසේය"), "ඔව්, ස්වභාවික ලෝක උරුමයකි.", "ඔව් වේ.")
        3 -> Quintuple("ශ්‍රී ලංකාවේ ජාතික වෘක්ෂය කුමක්ද?", "National tree of Sri Lanka?", listOf("නා ගස", "නා"), "නා ගස (Ironwood) වේ.", "නා ගසයි.")
        4 -> Quintuple("ශ්‍රී ලංකාවේ ජාතික පුෂ්පය කුමක්ද?", "National flower of Sri Lanka?", listOf("නිල් මහනෙල්", "මහනෙල්"), "නිල් මහනෙල් මල වේ.", "නිල් මහනෙල් වේ.")
        5 -> Quintuple("ශ්‍රී ලංකාවේ ජාතික පක්ෂියා කුමක්ද?", "National bird of Sri Lanka?", listOf("වලිකුකුළා", "ශ්‍රී ලංකා වලි කුකුළා"), "ශ්‍රී ලංකා වලි කුකුළා (Ceylon Junglefowl) වේ.", "වලිකුකුළා වේ.")
        6 -> Quintuple("ශ්‍රී ලංකාවේ පැරණිතම සහ ප්‍රධානම ජාතික වනෝද්‍යානයක් නම් කරන්න.", "Name a famous large national park in Sri Lanka.", listOf("යාල", "විල්පත්තුව", "Yala", "Wilpattu"), "යාල හෝ විල්පත්තුව ජාතික වනෝද්‍යානය වේ.", "යාල / විල්පත්තුවයි.")
        7 -> Quintuple("විල් හෙවත් ස්වභාවික වැව් බහුලව ඇති ජාතික වනෝද්‍යානය කුමක්ද?", "National park famous for natural lake basins (villus)?", listOf("විල්පත්තුව", "Wilpattu"), "විල්පත්තුව ජාතික වනෝද්‍යානය වේ.", "විල්පත්තුවයි.")
        8 -> Quintuple("ශ්‍රී ලංකාවේ කොටියන් (Leopards) වැඩි ඝනත්වයකින් දැකිය හැකි වනෝද්‍යානය කුමක්ද?", "Park with high leopard density?", listOf("යාල", "යාල වනෝද්‍යානය"), "යාල ජාතික වනෝද්‍යානය වේ.", "යාලයි.")
        9 -> Quintuple("අලි ඇතුන් එකතුවීම (Elephant Gathering) ප්‍රසිද්ධ ජාතික වනෝද්‍යානය කුමක්ද?", "Park famous for seasonal elephant gathering?", listOf("මින්නේරිය", "මින්නේරිය වනෝද්‍යානය"), "මින්නේරිය ජාතික වනෝද්‍යානය වේ.", "මින්නේරියයි.")
        10 -> Quintuple("ලොව වෙනත් කිසිම රටක නොමැති, අපේ රටට පමණක් ආවේණික ජීවීන් හඳුන්වන්නේ කෙසේද?", "Species found only in Sri Lanka?", listOf("ආවේණික", "ආවේණික ජීවීන්", "Endemic"), "ආවේණික (Endemic) විශේෂ නමිනි.", "ආවේණික විශේෂයි.")
        11 -> Quintuple("වෙරළබඩ ලවණ සහිත කලපු ආශ්‍රිතව වැඩෙන ශාක ප්‍රජාව කුමක්ද?", "Coastal saline vegetation community?", listOf("කඩොලාන", "Mangroves"), "කඩොලාන (Mangroves) පරිසර පද්ධතිය වේ.", "කඩොලානයි.")
        12 -> Quintuple("කඩොලාන ශාකවල මුල් හඳුන්වන විශේෂ නමක් පවසන්න.", "Special name for mangrove roots?", listOf("ශ්වසන මුල්", "කරු මුල්"), "ශ්වසන මුල් හෝ කරු මුල් වේ.", "ශ්වසන මුල්ය.")
        13 -> Quintuple("වියළි කලාපයේ දක්නට ලැබෙන කටු සහිත පඳුරු සහිත වෘක්ෂලතා මොනවාද?", "Thorny scrub vegetation found in dry zone?", listOf("කටු පඳුරු", "දඹ", "පළු වීර"), "කටු පඳුරු සහ ලඳු කැලෑ වේ.", "කටු පඳුරුයි.")
        14 -> Quintuple("කඳුකර තෙත් තෘණ භූමි හඳුන්වන්නේ කුමක් නමින්ද?", "Wet montane grasslands name?", listOf("පතන", "පතන්"), "පතන (Wet Patana) නමිනි.", "පතනයි.")
        15 -> Quintuple("වියළි කලාපයේ තෘණ භූමි හඳුන්වන්නේ කෙසේද?", "Dry zone grasslands name?", listOf("දමන", "තැන්න"), "දමන සහ විල්ලු නමිනි.", "දමනයි.")
        16 -> Quintuple("වන විනාශය නිසා පස සේදී යාම හඳුන්වන්නේ කෙසේද?", "Soil washing away due to deforestation?", listOf("පාංශු ඛාදනය", "ඛාදනය"), "පාංශු ඛාදනය (Soil erosion) නමිනි.", "පාංශු ඛාදනයයි.")
        17 -> Quintuple("ශ්‍රී ලංකාවේ වනාන්තර ප්‍රතිශතය රැකගැනීමට ගස් කැපීම තහනම් කර තිබේද?", "Is illegal tree logging banned to protect forest cover?", listOf("ඔව්", "එසේය"), "ඔව්, රක්ෂිත වනාන්තර නීතියෙන් ආරක්ෂිතයි.", "ඔව් වේ.")
        18 -> Quintuple("ශ්‍රී ලංකාවේ කුරුළු පාරාදීසය ලෙස ප්‍රසිද්ධ අභයභූමිය කුමක්ද?", "Famous bird sanctuary in Sri Lanka?", listOf("කුමන", "බූන්දල"), "කුමන හෝ බූන්දල කුරුළු අභයභූමිය වේ.", "කුමන / බූන්දලයි.")
        19 -> Quintuple("බූන්දල ජාතික වනෝද්‍යානය රැම්සා (Ramsar) තෙත්බිමක්ද?", "Is Bundala a Ramsar wetland?", listOf("ඔව්", "එසේය"), "ඔව්, ජාත්‍යන්තර රැම්සා තෙත්බිමකි.", "ඔව් වේ.")
        20 -> Quintuple("අලින් සහ මිනිසුන් අතර ඇතිවන ගැටුම හඳුන්වන්නේ කෙසේද?", "Conflict between elephants and humans?", listOf("අලි මිනිස් ගැටුම"), "අලි-මිනිස් ගැටුම (Human-Elephant Conflict) නමිනි.", "අලි මිනිස් ගැටුමයි.")
        else -> Quintuple("සිංහරාජය තෙත් කලාපයේ පිහිටා තිබේද?", "Is Sinharaja in the wet zone?", listOf("ඔව්", "එසේය"), "ඔව්, තෙත් කලාපයේය.", "ඔව් වේ.")
      }

      // Set 8: පාංශු & කෘෂිකාර්මික වැවිලි බෝග
      8 -> when (qIndex) {
        1 -> Quintuple("ශ්‍රී ලංකාවේ තෙත් කලාපයේ බහුලවම හමුවන පස කුමක්ද?", "Most common soil in Sri Lanka's wet zone?", listOf("රතු කහ පොඩ්සොලික්", "පොඩ්සොලික්"), "රතු කහ පොඩ්සොලික් පස (Red-Yellow Podzolic) වේ.", "රතු කහ පොඩ්සොලික් වේ.")
        2 -> Quintuple("ශ්‍රී ලංකාවේ වියළි කලාපයේ බහුලවම හමුවන පස කුමක්ද?", "Most common soil in Sri Lanka's dry zone?", listOf("රතු දුඹුරු පස", "රතු දුඹුරු"), "රතු දුඹුරු පස (Reddish Brown Earth) වේ.", "රතු දුඹුරු පසයි.")
        3 -> Quintuple("ශ්‍රී ලංකාවේ ප්‍රධාන අපනයන වැවිලි බෝග 3 මොනවාද?", "Three main export plantation crops?", listOf("තේ රබර් පොල්", "තේ", "රබර්", "පොල්"), "තේ, රබර් සහ පොල් වේ.", "තේ, රබර්, පොල් වේ.")
        4 -> Quintuple("තේ වගාව වඩාත්ම සාර්ථකව වැඩෙන්නේ කඳුකරයේද පහතරටද?", "Tea grows best in hill country or low country?", listOf("කඳුකරයේ", "මධ්‍යම කඳුකරය"), "මධ්‍යම කඳුකර ප්‍රදේශවලය.", "කඳුකරයේය.")
        5 -> Quintuple("ලංකාවේ ප්‍රථමයෙන් වාණිජමය වශයෙන් තේ වගා කළ ජේම්ස් ටේලර්ගේ වතුයාය කුමක්ද?", "Estate where James Taylor first grew commercial tea?", listOf("ලූල්කඳුර", "ලූල්කන්දර"), "ලූල්කඳුර වතුයාය (හේවාහැට) වේ.", "ලූල්කඳුරයි.")
        6 -> Quintuple("රබර් වගාවට වඩාත්ම සුදුසු වන්නේ තෙත් පහතරට ප්‍රදේශද?", "Is wet low country best for rubber cultivation?", listOf("ඔව්", "එසේය"), "ඔව්, කෑගල්ල, රත්නපුර, කළුතර ප්‍රධාන වේ.", "ඔව් වේ.")
        7 -> Quintuple("පොල් ත්‍රිකෝණයට අයත් ප්‍රධාන දිස්ත්‍රික්ක 3 මොනවාද?", "Three districts in Coconut Triangle?", listOf("කුරුණෑගල පුත්තලම කොළඹ", "කුරුණෑගල", "පුත්තලම", "ගම්පහ"), "කුරුණෑගල, පුත්තලම සහ ගම්පහ (හෝ කොළඹ) වේ.", "කුරුණෑගල, පුත්තලම, ගම්පහයි.")
        8 -> Quintuple("ශ්‍රී ලාංකිකයන්ගේ ප්‍රධාන ආහාර බෝගය කුමක්ද?", "Staple food crop of Sri Lankans?", listOf("වී", "බත්", "වී ගොවිතැන"), "වී (සහල් / බත්) වේ.", "වී ගොවිතැනයි.")
        9 -> Quintuple("වී වගාව කරන ප්‍රධාන කන්න 2 මොනවාද?", "Two main paddy cultivation seasons?", listOf("යල සහ මහ", "යල මහ"), "යල කන්නය සහ මහ කන්නය වේ.", "යල සහ මහයි.")
        10 -> Quintuple("මහ කන්නයේ වගාවට වැසි ජලය ලැබෙන්නේ කුමන මෝසමෙන්ද?", "Which monsoon brings rain for Maha season?", listOf("ඊසානදිග", "ඊසානදිග මෝසම"), "ඊසානදිග මෝසම් වැස්සෙනි.", "ඊසානදිග මෝසමයි.")
        11 -> Quintuple("යල කන්නයේ වගාවට ජලය ලැබෙන්නේ කුමන මෝසමෙන්ද?", "Which monsoon brings rain for Yala season?", listOf("නිරිතදිග", "නිරිතදිග මෝසම"), "නිරිතදිග මෝසම් වැස්සෙනි.", "නිරිතදිග මෝසමයි.")
        12 -> Quintuple("කුළුබඩු බෝගයක් සඳහා ප්‍රධාන උදාහරණයක් පවසන්න.", "Example of a spice crop?", listOf("කුරුඳු", "කරාබුනැටි", "ගම්මිරිස්", "එනසාල්"), "කුරුඳු, ගම්මිරිස්, කරාබුනැටි හෝ එනසාල් වේ.", "කුරුඳු / ගම්මිරිස් වේ.")
        13 -> Quintuple("ලෝකයේ හොඳම කුරුඳු (True Cinnamon) නිපදවන්නේ කුමන රටේද?", "Which country produces the world's best true cinnamon?", listOf("ශ්‍රී ලංකාව", "ලංකාව"), "ශ්‍රී ලංකාව (Ceylon Cinnamon) වේ.", "ශ්‍රී ලංකාවයි.")
        14 -> Quintuple("වියළි කලාපයේ හේන් වගාවේ වගා කරන ධාන්‍ය බෝගයක් නම් කරන්න.", "Grain crop grown in chena cultivation?", listOf("කුරක්කන්", "ඉරිඟු"), "කුරක්කන්, ඉරිඟු හෝ තල වේ.", "කුරක්කන් / ඉරිඟුයි.")
        15 -> Quintuple("උඩරට එළවළු සඳහා ප්‍රසිද්ධ දිස්ත්‍රික්කයක් නම් කරන්න.", "District famous for upcountry vegetables?", listOf("නුවරඑළිය", "බදුල්ල"), "නුවරඑළිය හෝ බදුල්ල වේ.", "නුවරඑළියයි.")
        16 -> Quintuple("උඩරට වගා කරන එළවළුවකට උදාහරණයක් පවසන්න.", "Example of upcountry vegetable?", listOf("කැරට්", "ලීක්ස්", "ගෝවා", "බීට්රූට්"), "කැරට්, ලීක්ස්, ගෝවා හෝ බීට්රූට් වේ.", "කැරට් / ලීක්ස් වේ.")
        17 -> Quintuple("පහතරට වගා කරන එළවළුවකට උදාහරණයක් පවසන්න.", "Example of low country vegetable?", listOf("බණ්ඩක්කා", "වම්බටු", "කරවිල", "පතෝල"), "බණ්ඩක්කා, වම්බටු, කරවිල හෝ පතෝල වේ.", "බණ්ඩක්කා / වම්බටුයි.")
        18 -> Quintuple("වියළි කලාපයේ ගොවිතැනට ජලය ලබාදෙන ප්‍රධාන ක්‍රමය කුමක්ද?", "Main method providing water for dry zone farming?", listOf("වැව්", "වාරිමාර්ග", "ඇළ මාර්ග"), "වැව් සහ වාරි ඇළ මාර්ග වේ.", "වැව් ක්‍රමයයි.")
        19 -> Quintuple("ශ්‍රී ලංකාවේ විශාලතම බහුකාර්ය වාරි ව්‍යාපාරය කුමක්ද?", "Largest multipurpose irrigation project in Sri Lanka?", listOf("මහවැලි සංවර්ධන ව්‍යාපාරය", "මහවැලි"), "මහවැලි සංවර්ධන ව්‍යාපාරය වේ.", "මහවැලි ව්‍යාපාරයයි.")
        20 -> Quintuple("පස සරුසාර කිරීමට යොදන ස්වභාවික පොහොර කුමක්ද?", "Natural fertilizer used to enrich soil?", listOf("කොම්පෝස්ට්", "කාබනික පොහොර"), "කොම්පෝස්ට් හෝ කාබනික පොහොර වේ.", "කොම්පෝස්ට් වේ.")
        else -> Quintuple("ශ්‍රී ලංකාවේ වී ගොවිතැන ප්‍රධාන ජීවනෝපායක්ද?", "Is paddy farming a main livelihood in Sri Lanka?", listOf("ඔව්", "එසේය"), "ඔව්, ප්‍රධාන ගොවිතැනයි.", "ඔව් වේ.")
      }

      // Set 9: ඛනිජ සම්පත් & බලශක්ති
      9 -> when (qIndex) {
        1 -> Quintuple("ශ්‍රී ලංකාවේ රත්නපුර දිස්ත්‍රික්කය ප්‍රසිද්ධ කුමන ඛනිජ සම්පතටද?", "Ratnapura district is famous for which mineral?", listOf("මැණික්", "Gems"), "මැණික් (Gemstones) සඳහාය.", "මැණික් වේ.")
        2 -> Quintuple("ලොව ප්‍රකට නිල් මැණික (Blue Sapphire) ශ්‍රී ලංකාවේ හමුවේද?", "Is world famous Blue Sapphire found in Sri Lanka?", listOf("ඔව්", "එසේය"), "ඔව්, ලංකාවේ ප්‍රධාන නිල් මැණික වේ.", "ඔව් වේ.")
        3 -> Quintuple("ශ්‍රී ලංකාවේ ඉහළම සංශුද්ධතාවයකින් යුත් මිනිරන් (Graphite) හමුවන පතලක් නම් කරන්න.", "Name a high purity graphite mine in Sri Lanka.", listOf("බෝගල", "කහටගහ", "Bogala", "Kahatagaha"), "බෝගල හෝ කහටගහ මිනිරන් පතල වේ.", "බෝගල / කහටගහයි.")
        4 -> Quintuple("පුල්මොඩේ (Pulmoddai) ප්‍රදේශයේ හමුවන ප්‍රධාන ඛනිජ සම්පත කුමක්ද?", "Main mineral resource found at Pulmoddai?", listOf("ඛනිජ වැලි", "ඉල්මනයිට්", "රුටයිල්"), "ඛනිජ වැලි (ඉල්මනයිට්, රුටයිල්, සර්කෝන්) වේ.", "ඛනිජ වැලියි.")
        5 -> Quintuple("එප්පාවල ප්‍රදේශයේ හමුවන පොස්ෆේට් නිධිය භාවිත කරන්නේ කුමන නිෂ්පාදනයටද?", "Eppawala phosphate deposit is used for what?", listOf("පොහොර", "පොස්පරස් පොහොර"), "පොස්ෆේට් පොහොර නිෂ්පාදනයටය.", "පොහොර සඳහාය.")
        6 -> Quintuple("සිමෙන්ති නිෂ්පාදනය සඳහා කන්කසන්තුරේදී ලබාගන්නා ඛනිජය කුමක්ද?", "Mineral extracted at Kankesanthurai for cement?", listOf("හුණුගල්", "Limestone"), "හුණුගල් (Limestone) වේ.", "හුණුගල් වේ.")
        7 -> Quintuple("ගඩොල් සහ උළු සෑදීමට භාවිත කරන මැටි වර්ගය කුමක්ද?", "Clay used for bricks and roof tiles?", listOf("අල්ලූවියල් මැටි", "මැටි", "කුඹුරු මැටි"), "අලූවියල් මැටි වේ.", "මැටි වේ.")
        8 -> Quintuple("පිඟන් භාණ්ඩ සෑදීමට මීටියාගොඩින් ලබාගන්නා ඛනිජය කුමක්ද?", "Mineral from Meetiyagoda for ceramic production?", listOf("කිරිමැටි", "කඔලින්", "Kaolin"), "කඔලින් හෙවත් කිරිමැටි (Kaolin) වේ.", "කිරිමැටියි.")
        9 -> Quintuple("ශ්‍රී ලංකාවේ ප්‍රධාන ජල විදුලි බලාගාරයකට උදාහරණයක් පවසන්න.", "Example of major hydroelectric power station in Sri Lanka?", listOf("වික්ටෝරියා", "කොත්මලේ", "රන්දෙනිගල", "ලක්ෂපාන"), "වික්ටෝරියා, කොත්මලේ හෝ ලක්ෂපාන වේ.", "වික්ටෝරියා / ලක්ෂපානයි.")
        10 -> Quintuple("ශ්‍රී ලංකාවේ විශාලතම ජල විදුලි බලාගාරය කුමක්ද?", "Largest hydroelectric plant in Sri Lanka?", listOf("වික්ටෝරියා", "Victoria"), "වික්ටෝරියා බලාගාරය වේ.", "වික්ටෝරියා වේ.")
        11 -> Quintuple("නොරොච්චෝලේ පිහිටා ඇති බලාගාරය ක්‍රියාත්මක වන්නේ කුමන ඉන්ධනයෙන්ද?", "Norochcholai power plant runs on what fuel?", listOf("ගල් අඟුරු", "Coal"), "ගල් අඟුරු (Coal) මඟිනි.", "ගල් අඟුරුයි.")
        12 -> Quintuple("මන්නාරමේ පිහිටුවා ඇති නවීන විදුලි බලාගාරය කුමක්ද?", "Modern power plant set up in Mannar?", listOf("සුළං විදුලි", "සුළං බලාගාරය", "තම්බපවනි"), "සුළං විදුලි බලාගාරය (තම්බපවනි) වේ.", "සුළං විදුලියයි.")
        13 -> Quintuple("සූර්යාලෝකයෙන් විදුලිය නිපදවන පැනල හඳුන්වන්නේ කෙසේද?", "Panels generating electricity from sunlight?", listOf("සූර්ය පැනල", "Solar panels"), "සූර්ය පැනල (Solar panels) නමිනි.", "සූර්ය පැනලයි.")
        14 -> Quintuple("ජලය, සූර්යාලෝකය සහ සුළඟ යනු පුනර්ජනනීය බලශක්ති ප්‍රභවද?", "Are water, solar and wind renewable energy sources?", listOf("ඔව්", "එසේය"), "ඔව්, පුනර්ජනනීය බලශක්ති වේ.", "ඔව් වේ.")
        15 -> Quintuple("ඛනිජ තෙල් සහ ගල් අඟුරු දහනයෙන් පරිසර දූෂණය සිදුවේද?", "Does burning petroleum and coal cause pollution?", listOf("ඔව්", "එසේය"), "ඔව්, වායු දූෂණය සහ උෂ්ණත්වය ඉහළ යයි.", "ඔව් වේ.")
        16 -> Quintuple("ශ්‍රී ලංකාවේ මුහුදු පතුලේ ඛනිජ තෙල් ගවේෂණය කර ඇත්තේ කුමන ප්‍රදේශයේද?", "Where is petroleum explored in Sri Lankan seabed?", listOf("මන්නාරම් ද්‍රෝණිය", "මන්නාරම"), "මන්නාරම් ද්‍රෝණියේ (Mannar Basin) වේ.", "මන්නාරම් ද්‍රෝණියයි.")
        17 -> Quintuple("ලුණු නිෂ්පාදනය සඳහා මුහුදු ජලය රඳවා තබන ස්ථානය කුමක්ද?", "Place where seawater is evaporated for salt?", listOf("ලවණ ලේවාය", "ලේවාය", "Saltern"), "ලවණ ලේවාය (Saltern) නමිනි.", "ලේවායයි.")
        18 -> Quintuple("ශ්‍රී ලංකාවේ ප්‍රධාන ලුණු ලේවායක් පිහිටි නගරයක් නම් කරන්න.", "Name a town with major saltern in Sri Lanka.", listOf("හම්බන්තොට", "පුත්තලම"), "හම්බන්තොට හෝ පුත්තලම වේ.", "හම්බන්තොට / පුත්තලමයි.")
        19 -> Quintuple("විදුලිය අරපිරිමැස්මෙන් භාවිත කිරීම රටේ ආර්ථිකයට වැදගත්ද?", "Is conserving electricity important for country's economy?", listOf("ඔව්", "එසේය"), "ඔව්, විදේශ විනිමය ඉතිරි වේ.", "ඔව් වේ.")
        20 -> Quintuple("LED බල්බ භාවිතයෙන් විදුලි පරිභෝජනය අඩු කරගත හැකිද?", "Does using LED bulbs reduce electricity usage?", listOf("ඔව්", "එසේය"), "ඔව්, විදුලිය පිරිමැසේ.", "ඔව් වේ.")
        else -> Quintuple("මිනිරන් විද්‍යුතය සන්නයනය කරයිද?", "Does graphite conduct electricity?", listOf("ඔව්", "එසේය"), "ඔව්, සන්නායකයකි.", "ඔව් වේ.")
      }

      // Set 10: ලෝක භූගෝලය & ගෝලීය පරිසරය
      10 -> when (qIndex) {
        1 -> Quintuple("ලෝකයේ මහාද්වීප කීයක් තිබේද?", "How many continents in the world?", listOf("7", "7ක්", "හතක්"), "මහාද්වීප 7කි.", "7කි.")
        2 -> Quintuple("ලෝකයේ විශාලතම මහාද්වීපය කුමක්ද?", "Largest continent in the world?", listOf("ආසියාව", "Asia"), "ආසියා මහාද්වීපය වේ.", "ආසියාවයි.")
        3 -> Quintuple("ලෝකයේ කුඩාම මහාද්වීපය කුමක්ද?", "Smallest continent in the world?", listOf("ඕස්ට්‍රේලියාව", "Australia"), "ඕස්ට්‍රේලියාව වේ.", "ඕස්ට්‍රේලියාවයි.")
        4 -> Quintuple("ලෝකයේ ප්‍රධාන සාගර කීයක් තිබේද?", "How many major oceans in the world?", listOf("5", "5ක්", "පහක්"), "සාගර 5කි.", "5කි.")
        5 -> Quintuple("ලෝකයේ විශාලතම සහ ගැඹුරුම සාගරය කුමක්ද?", "Largest and deepest ocean in the world?", listOf("ශාන්තිකර සාගරය", "පැසිෆික්", "Pacific"), "ශාන්තිකර සාගරය (Pacific Ocean) වේ.", "ශාන්තිකර සාගරයයි.")
        6 -> Quintuple("ලෝකයේ උසම කන්ද කුමක්ද?", "Highest mountain in the world?", listOf("එවරස්ට්", "එවරස්ට් කන්ද", "Everest"), "එවරස්ට් කන්ද (මීටර් 8,848) වේ.", "එවරස්ට් කන්දයි.")
        7 -> Quintuple("එවරස්ට් කන්ද පිහිටි කඳු පන්තිය කුමක්ද?", "Mountain range where Everest is located?", listOf("හිමාලය", "Himalayas"), "හිමාලය කඳු පන්තිය වේ.", "හිමාලයයි.")
        8 -> Quintuple("ලෝකයේ දිගම ගංගාව කුමක්ද?", "Longest river in the world?", listOf("නයිල්", "නයිල් ගඟ", "Nile"), "නයිල් ගඟ (අප්‍රිකාව) වේ.", "නයිල් ගඟයි.")
        9 -> Quintuple("ලෝකයේ වැඩිම ජල කඳක් ගලා යන විශාලතම ගංගාව කුමක්ද?", "Largest river by water discharge volume?", listOf("ඇමසන්", "ඇමසන් ගඟ", "Amazon"), "ඇමසන් ගඟ (දකුණු ඇමරිකාව) වේ.", "ඇමසන් ගඟයි.")
        10 -> Quintuple("ලෝකයේ විශාලතම නිවර්තන වැසි වනාන්තරය කුමක්ද?", "Largest tropical rainforest in the world?", listOf("ඇමසන් වනාන්තරය", "ඇමසන්"), "ඇමසන් වැසි වනාන්තරය වේ.", "ඇමසන් වනාන්තරයයි.")
        11 -> Quintuple("ලෝකයේ විශාලතම උණුසුම් කාන්තාරය කුමක්ද?", "Largest hot desert in the world?", listOf("සහරා", "සහරා කාන්තාරය", "Sahara"), "සහරා කාන්තාරය (අප්‍රිකාව) වේ.", "සහරා කාන්තාරයයි.")
        12 -> Quintuple("සම්පූර්ණයෙන්ම අයිස්වලින් වැසී ඇති දකුණු ධ්‍රැව මහාද්වීපය කුමක්ද?", "Ice covered continent at South Pole?", listOf("ඇන්ටාක්ටිකාව", "Antarctica"), "ඇන්ටාක්ටිකාව (Antarctica) වේ.", "ඇන්ටාක්ටිකාවයි.")
        13 -> Quintuple("ලෝකයේ වැඩිම ජනගහනයක් වෙසෙන රට කුමක්ද?", "Most populous country in the world?", listOf("ඉන්දියාව", "චීනය", "India"), "ඉන්දියාව (හෝ චීනය) වේ.", "ඉන්දියාවයි.")
        14 -> Quintuple("ලෝකයේ භූමි ප්‍රමාණයෙන් විශාලතම රට කුමක්ද?", "Largest country by land area?", listOf("රුසියාව", "Russia"), "රුසියාව (Russia) වේ.", "රුසියාවයි.")
        15 -> Quintuple("ගෝලීය උණුසුම ඉහළ යාමට ප්‍රධාන හේතුව කුමක්ද?", "Main cause of global warming?", listOf("හරිතාගාර වායු", "කාබන් ඩයොක්සයිඩ්", "Greenhouse"), "හරිතාගාර වායු (CO₂) වැඩිවීමයි.", "හරිතාගාර වායුයි.")
        16 -> Quintuple("සූර්යයාගේ අහිතකර පාරජම්බුල (UV) කිරණවලින් පෘථිවිය ආරක්ෂා කරන වායු ස්ථරය කුමක්ද?", "Atmospheric layer protecting from harmful UV rays?", listOf("ඕසෝන් ස්ථරය", "ඕසෝන්", "Ozone"), "ඕසෝන් ස්ථරය (Ozone layer) වේ.", "ඕසෝන් ස්ථරයයි.")
        17 -> Quintuple("ඕසෝන් වියන විනාශ කිරීමට බලපාන ප්‍රධාන වායුව කුමක්ද?", "Gas responsible for ozone depletion?", listOf("CFC", "ක්ලෝරෝෆ්ලෝරෝකාබන්"), "CFC (ක්ලෝරෝෆ්ලෝරෝකාබන්) වායුව වේ.", "CFC වායුවයි.")
        18 -> Quintuple("ධ්‍රැවාසන්න අයිස් දියවීම නිසා සාගර ජල මට්ටම ඉහළ යයිද?", "Does polar ice melting cause sea levels to rise?", listOf("ඔව්", "එසේය"), "ඔව්, මුහුදු මට්ටම ඉහළ යයි.", "ඔව් වේ.")
        19 -> Quintuple("පොලිතීන් සහ ප්ලාස්ටික් පරිසරයට බැහැර කිරීම නිසා සාගර දූෂණය වේද?", "Does polythene and plastic waste cause ocean pollution?", listOf("ඔව්", "එසේය"), "ඔව්, සාගර ජීවීන්ට දැඩි හානි සිදුවේ.", "ඔව් වේ.")
        20 -> Quintuple("ලෝක පරිසර දිනය සමරන්නේ කුමන දිනයේද?", "World Environment Day date?", listOf("ජූනි 5", "ජුනි 5"), "ජූනි 05 වනදාය.", "ජූනි 5යි.")
        else -> Quintuple("පෘථිවිය රැකගැනීම මිනිසාගේ යුතුකමක්ද?", "Is protecting the Earth human responsibility?", listOf("ඔව්", "එසේය"), "ඔව්, අප සැමගේ යුතුකමකි.", "ඔව් වේ.")
      }
      else -> when (qIndex) {
        1 -> Quintuple("පෘථිවියේ සැබෑ හැඩය හඳුන්වන විශේෂ නම කුමක්ද?", "Special name for true shape of Earth?", listOf("ජියොයිඩ්", "Geoid"), "ජියොයිඩ් (Geoid) හැඩය වේ.", "ජියොයිඩ් වේ.")
        else -> Quintuple("සමකය අංශක බිංදුවේ (0°) අක්ෂාංශයද?", "Is equator 0 degree latitude?", listOf("ඔව්", "එසේය"), "ඔව්, 0° අක්ෂාංශයයි.", "ඔව් වේ.")
      }
    }
  }

}


