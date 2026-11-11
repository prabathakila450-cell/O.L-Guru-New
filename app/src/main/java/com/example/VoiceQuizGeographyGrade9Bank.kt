package com.example

/**
 * 🌍 Grade 9 Geography Bank (භූගෝල විද්‍යාව - 9 ශ්‍රේණිය)
 * Contains 200 distinct, syllabus-aligned oral exam questions across 10 sets of 20 questions each.
 * All questions are strictly short, factual, direct, non-formula, non-explanatory, and non-repeating.
 */
object VoiceQuizGeographyGrade9Bank {

  fun getQuestion(setNum: Int, qIndex: Int, theme: String): Quintuple<String, String, List<String>, String, String> {
    return when (setNum) {
      // Set 1: සිතියම් මූලිකාංග & පරිමාණය
      1 -> when (qIndex) {
        1 -> Quintuple("සිතියමක ප්‍රධාන දිශා 4 මොනවාද?", "Four cardinal directions on a map?", listOf("උතුර දකුණ නැගෙනහිර බටහිර", "උතුර", "දකුණ"), "උතුර, දකුණ, නැගෙනහිර සහ බටහිර වේ.", "උතුර, දකුණ, නැගෙනහිර, බටහිරයි.")
        2 -> Quintuple("සිතියමක සාමාන්‍යයෙන් උතුරු දිශාව දක්වන්නේ කුමන පැත්තේද?", "Which side of map usually indicates North?", listOf("ඉහළින්", "උඩින්", "Top"), "සිතියමේ ඉහළින්ය.", "ඉහළින්ය.")
        3 -> Quintuple("සිතියමක සැබෑ දුර හා සිතියම් දුර අතර අනුපාතය කුමක්ද?", "Ratio between map distance and real ground distance?", listOf("පරිමාණය", "Scale"), "පරිමාණය (Scale) වේ.", "පරිමාණයයි.")
        4 -> Quintuple("ප්‍රකාශන පරිමාණයකට උදාහරණයක් පවසන්න.", "Example of a statement scale?", listOf("සෙන්ටිමීටර 1න් කිලෝමීටර 1ක්", "සෙ.මී. 1 කි.මී. 1"), "සෙන්ටිමීටර 1න් කිලෝමීටර 1ක් දැක්වීමයි.", "සෙ.මී. 1න් කි.මී. 1යි.")
        5 -> Quintuple("නිරූපක භාගයක ලවය සෑමවිටම කීයද?", "What is always the numerator in a representative fraction?", listOf("1", "එකයි", "1ක්"), "සෑමවිටම 1 වේ (උදා: 1/50,000).", "1 වේ.")
        6 -> Quintuple("සිතියමක විස්තර තේරුම් ගැනීමට පහළින් දක්වන විස්තරය කුමක්ද?", "List explaining symbols on a map?", listOf("සූචිය", "යතුර", "Legend"), "සිතියම් සූචිය හෙවත් සංකේත යතුර වේ.", "සූචියයි.")
        7 -> Quintuple("සිතියමක ජල මාර්ග දක්වන්නේ කුමන වර්ණයෙන්ද?", "Color showing water bodies on maps?", listOf("නිල්", "Blue"), "නිල් පැහැයෙනි.", "නිල් පාටයි.")
        8 -> Quintuple("සිතියමක වගා බිම් සහ වනාන්තර දක්වන්නේ කුමන වර්ණයෙන්ද?", "Color showing vegetation and forests?", listOf("කොළ", "Green"), "කොළ පැහැයෙනි.", "කොළ පාටයි.")
        9 -> Quintuple("සිතියමක කඳු සහ උස්බිම් දක්වන්නේ කුමන වර්ණයෙන්ද?", "Color showing hills and mountains?", listOf("දුඹුරු", "Brown"), "දුඹුරු පැහැයෙනි.", "දුඹුරු පාටයි.")
        10 -> Quintuple("සිතියමක නගර සහ ප්‍රධාන මංමාවත් දක්වන්නේ කුමන වර්ණයෙන්ද?", "Color showing roads and urban centers?", listOf("රතු", "කළු", "Red"), "රතු හෝ කළු පැහැයෙනි.", "රතු පැහැයයි.")
        11 -> Quintuple("රේඛීය පරිමාණයක වාසිය කුමක්ද?", "Advantage of a linear scale?", listOf("සිතියම විශාල කළත් මැනිය හැක", "දුර කෙළින්ම මැනිය හැක"), "සිතියම විශාල හෝ කුඩා කළද නිවැරදිව දුර මැනිය හැකිවීමයි.", "කෙළින්ම මැනිය හැකියි.")
        12 -> Quintuple("ප්‍රධාන අනුදිශා 4 මොනවාද?", "Four ordinal intercardinal directions?", listOf("ඊසාන ගිනිකොන නිරිත වයඹ"), "ඊසාන, ගිනිකොන, නිරිත සහ වයඹ වේ.", "ඊසාන, ගිනිකොන, නිරිත, වයඹයි.")
        13 -> Quintuple("උතුර සහ නැගෙනහිර අතර පිහිටි අනුදිශාව කුමක්ද?", "Direction between North and East?", listOf("ඊසාන", "NE"), "ඊසාන දිශාව වේ.", "ඊසානයි.")
        14 -> Quintuple("දකුණ සහ බටහිර අතර පිහිටි අනුදිශාව කුමක්ද?", "Direction between South and West?", listOf("නිරිත", "SW"), "නිරිත දිශාව වේ.", "නිරිතයි.")
        15 -> Quintuple("දිශාව නිවැරදිව හඳුනාගැනීමට නාවිකයන් භාවිත කරන උපකරණය කුමක්ද?", "Instrument used to find directions by navigators?", listOf("මාලිමාව", "චුම්භක මාලිමාව", "Compass"), "චුම්භක මාලිමාව (Compass) වේ.", "මාලිමාවයි.")
        16 -> Quintuple("මාලිමාවේ දර්ශක තුඩ සෑමවිටම යොමුවන්නේ කුමන දිශාවටද?", "Which direction does compass needle point?", listOf("උතුරට", "චුම්භක උතුර"), "චුම්භක උතුරු දිශාවටය.", "උතුරටයි.")
        17 -> Quintuple("පෘථිවියේ ගෝලාකාර ස්වභාවය පෙන්වන කුඩා ආකෘතිය කුමක්ද?", "Spherical model representing Earth?", listOf("පෘථිවි ගෝලය", "Globe"), "පෘථිවි ගෝලය (Globe) වේ.", "පෘථිවි ගෝලයයි.")
        18 -> Quintuple("සිතියමක මායිම් දැක්වීමට අඳින රේඛාව කුමක්ද?", "Line drawn around map edge?", listOf("රාමුව", "සිතියම් රාමුව"), "සිතියම් රාමුව (Border) වේ.", "රාමුවයි.")
        19 -> Quintuple("සිතියමක් යනු කුමක්දැයි හඳුන්වන ප්‍රධාන මාතෘකාව කුමක්ද?", "Component naming what the map is about?", listOf("සිතියමේ නම", "මාතෘකාව", "Title"), "සිතියම් මාතෘකාව (Title) වේ.", "මාතෘකාවයි.")
        20 -> Quintuple("සිතියම් මූලිකාංග 5 අතුරින් 3ක් නම් කරන්න.", "Name 3 of 5 basic map essentials.", listOf("මාතෘකාව පරිමාණය දිශාව සූචිය රාමුව", "මාතෘකාව", "පරිමාණය", "දිශාව"), "මාතෘකාව, පරිමාණය, දිශාව, සූචිය සහ රාමුව වේ.", "මාතෘකාව, පරිමාණය, දිශාවයි.")
        else -> Quintuple("සිතියමකින් ප්‍රදේශයක භූගෝලීය තොරතුරු ලබාගත හැකිද?", "Can geographic info be obtained from map?", listOf("ඔව්", "එසේය"), "ඔව්, තොරතුරු රැසක් ලැබේ.", "ඔව් වේ.")
      }

      // Set 2: පෘථිවියේ පිහිටීම & ග්‍රහ මණ්ඩලය
      2 -> when (qIndex) {
        1 -> Quintuple("පෘථිවිය අයත් වන සෞරග්‍රහ මණ්ඩලයේ කේන්ද්‍රය කුමක්ද?", "Center of our solar system?", listOf("සූර්යයා", "Sun"), "සූර්යයා (Sun) වේ.", "සූර්යයායි.")
        2 -> Quintuple("සූර්යයාගේ සිට පෘථිවිය පිහිටා ඇත්තේ කීවන ග්‍රහලෝකය ලෙසද?", "Earth is which planet in order from the Sun?", listOf("3", "3 වන", "තුන්වන"), "තෙවන (3 වන) ග්‍රහලෝකය ලෙසය.", "3 වන ග්‍රහලෝකයයි.")
        3 -> Quintuple("සෞරග්‍රහ මණ්ඩලයේ සූර්යයාට ළඟින්ම පිහිටි ග්‍රහලෝකය කුමක්ද?", "Closest planet to Sun?", listOf("බුධ", "Mercury"), "බුධ (Mercury) ග්‍රහයා වේ.", "බුධ ග්‍රහයායි.")
        4 -> Quintuple("සෞරග්‍රහ මණ්ඩලයේ විශාලතම ග්‍රහලෝකය කුමක්ද?", "Largest planet in solar system?", listOf("බ්‍රහස්පති", "Jupiter"), "බ්‍රහස්පති (Jupiter) ග්‍රහයා වේ.", "බ්‍රහස්පති ග්‍රහයායි.")
        5 -> Quintuple("රතු ග්‍රහයා ලෙස හඳුන්වන්නේ කුමන ග්‍රහලෝකයද?", "Planet known as Red Planet?", listOf("අඟහරු", "Mars"), "අඟහරු (Mars) ග්‍රහයා වේ.", "අඟහරු ග්‍රහයායි.")
        6 -> Quintuple("පෘථිවියේ එකම ස්වභාවික උපග්‍රහයා කුමක්ද?", "Only natural satellite of Earth?", listOf("චන්ද්‍රයා", "හඳ", "Moon"), "චන්ද්‍රයා (Moon) වේ.", "චන්ද්‍රයායි.")
        7 -> Quintuple("ජීවීන් වාසය කරන අප දන්නා එකම ග්‍රහලෝකය කුමක්ද?", "Only known planet harboring life?", listOf("පෘථිවිය", "Earth"), "පෘථිවිය (Earth) වේ.", "පෘථිවියයි.")
        8 -> Quintuple("පෘථිවියේ සැබෑ හැඩය හඳුන්වන්නේ කුමක් නමින්ද?", "True shape of Earth?", listOf("ජියොයිඩ්", "Geoid"), "ජියොයිඩ් (Geoid) හැඩය නමිනි.", "ජියොයිඩ් හැඩයයි.")
        9 -> Quintuple("පෘථිවිය තමන්ගේ අක්ෂය වටා භ්‍රමණය වන්නේ කුමන දිශාවේ සිටද?", "Direction of Earth rotation on its axis?", listOf("බටහිර සිට නැගෙනහිරට", "බටහිරින් නැගෙනහිරට"), "බටහිර සිට නැගෙනහිරටය.", "බටහිර සිට නැගෙනහිරටයි.")
        10 -> Quintuple("පෘථිවිය භ්‍රමණය වීමට ගතවන කාලය කොපමණද?", "Time taken for one Earth rotation?", listOf("පැය 24", "දින 1", "24 hours"), "පැය 24කි (දින 1කි).", "පැය 24කි.")
        11 -> Quintuple("පෘථිවි භ්‍රමණය නිසා ඇතිවන ප්‍රධාන සිදුවීම කුමක්ද?", "Main consequence of Earth's rotation?", listOf("දිවා රෑ ඇතිවීම", "දිවා සහ රාත්‍රිය"), "දිවා සහ රාත්‍රිය ඇතිවීමයි.", "දිවා රෑ ඇතිවීමයි.")
        12 -> Quintuple("පෘථිවිය සූර්යයා වටා පරිභ්‍රමණය වීමට දින කීයක් ගතවේද?", "Days taken for Earth to orbit Sun?", listOf("365 1/4", "365", "දින 365"), "දින 365 1/4 (වසර 1ක්) ගතවේ.", "දින 365 1/4කි.")
        13 -> Quintuple("පෘථිවියේ අක්ෂය කක්ෂ තලයට අංශක කීයක් ඇලවී තිබේද?", "Tilt of Earth's axis to orbital plane?", listOf("66 1/2", "23 1/2", "අංශක 23.5"), "සිරස් තලයට අංශක 23 1/2ක් (කක්ෂ තලයට 66 1/2ක්) ඇලවී ඇත.", "අංශක 23 1/2කි.")
        14 -> Quintuple("අධික අවුරුද්දක පෙබරවාරි මාසයට දින කීයක් තිබේද?", "Days in February during a leap year?", listOf("29", "දින 29", "29ක්"), "දින 29කි.", "දින 29කි.")
        15 -> Quintuple("අධික අවුරුද්දක් පැමිණෙන්නේ වසර කීයකට වරක්ද?", "How often does a leap year occur?", listOf("වසර 4කට වරක්", "4", "හතරකට වරක්"), "වසර 4කට වරකි.", "වසර 4කට වරකි.")
        16 -> Quintuple("පෘථිවිය මධ්‍යයෙන් බෙදන 0° අක්ෂාංශය කුමක්ද?", "0 degree latitude dividing Earth?", listOf("සමකය", "Equator"), "සමකය (Equator) වේ.", "සමකයයි.")
        17 -> Quintuple("පෘථිවියේ උතුරු කෙළවර ලක්ෂ්‍යය කුමක්ද?", "Northernmost point of Earth?", listOf("උතුරු ධ්‍රැවය", "North Pole"), "උතුරු ධ්‍රැවය (90° N) වේ.", "උතුරු ධ්‍රැවයයි.")
        18 -> Quintuple("පෘථිවියේ දකුණු කෙළවර ලක්ෂ්‍යය කුමක්ද?", "Southernmost point of Earth?", listOf("දකුණු ධ්‍රැවය", "South Pole"), "දකුණු ධ්‍රැවය (90° S) වේ.", "දකුණු ධ්‍රැවයයි.")
        19 -> Quintuple("පෘථිවි වායුගෝලයේ වැඩිම ප්‍රතිශතයක් ඇති වායුව කුමක්ද?", "Most abundant gas in Earth's atmosphere?", listOf("නයිට්‍රජන්", "Nitrogen"), "නයිට්‍රජන් වායුව (78%ක් පමණ) වේ.", "නයිට්‍රජන්ය.")
        20 -> Quintuple("ජීවීන්ගේ ශ්වසනයට අත්‍යවශ්‍ය වායුගෝලීය වායුව කුමක්ද?", "Gas essential for respiration of living beings?", listOf("ඔක්සිජන්", "Oxygen", "O2"), "ඔක්සිජන් වායුව (21%ක් පමණ) වේ.", "ඔක්සිජන්ය.")
        else -> Quintuple("පෘථිවිය ගෝලාකාර ආකාශ වස්තුවක්ද?", "Is Earth a spherical celestial body?", listOf("ඔව්", "එසේය"), "ඔව්, ගෝලාකාරය.", "ඔව් වේ.")
      }

      // Set 3: ශ්‍රී ලංකාවේ ප්‍රධාන භූ විෂමතාව
      3 -> when (qIndex) {
        1 -> Quintuple("ශ්‍රී ලංකාවේ භූ විෂමතාව ප්‍රධාන තලා කීයකට බෙදා ඇත්ද?", "How many relief zones in Sri Lanka?", listOf("3", "3ක්", "තුනකි"), "තලා 3කටය (පහතරට, මැදරට, උඩරට).", "තලා 3කි.")
        2 -> Quintuple("ශ්‍රී ලංකාවේ උසම කඳු මුදුන කුමක්ද?", "Highest mountain peak in Sri Lanka?", listOf("පිදුරුතලාගල", "Pidurutalagala"), "පිදුරුතලාගල කන්ද (මීටර් 2,524) වේ.", "පිදුරුතලාගලයි.")
        3 -> Quintuple("පිදුරුතලාගල කන්ද පිහිටි දිස්ත්‍රික්කය කුමක්ද?", "District where Pidurutalagala is situated?", listOf("නුවරඑළිය", "Nuwara Eliya"), "නුවරඑළිය දිස්ත්‍රික්කය වේ.", "නුවරඑළියයි.")
        4 -> Quintuple("ශ්‍රී ලංකාවේ දෙවන උසම කන්ද කුමක්ද?", "Second highest mountain in Sri Lanka?", listOf("කිරගල්පොත්ත", "Kirigalpotta"), "කිරගල්පොත්ත කන්ද වේ.", "කිරගල්පොත්තයි.")
        5 -> Quintuple("ශ්‍රී ලංකාවේ තෙවන උසම කන්ද කුමක්ද?", "Third highest mountain in Sri Lanka?", listOf("තොටුපොළ", "තොටුපොළ කන්ද"), "තොටුපොළ කන්ද වේ.", "තොටුපොළයි.")
        6 -> Quintuple("සමනල කන්ද හෙවත් ශ්‍රී පාද කන්ද පිහිටි දිස්ත්‍රික්කය කුමක්ද?", "District of Sri Pada / Adam's Peak?", listOf("රත්නපුර", "රත්නපුරය"), "රත්නපුර දිස්ත්‍රික්කය වේ.", "රත්නපුරයයි.")
        7 -> Quintuple("ලෝකාන්තය (World's End) පිහිටා ඇත්තේ කුමන ජාතික වනෝද්‍යානයේදීද?", "National park where World's End precipice is situated?", listOf("හෝටන්තැන්න", "හෝර්ටන් තැන්න"), "හෝටන් තැන්න ජාතික වනෝද්‍යානයේදීය.", "හෝටන්තැන්නයි.")
        8 -> Quintuple("දුම්බර කඳු වැටිය ලෙස හඳුන්වන්නේ කුමන කඳු පන්තියද?", "Mountain range known as Dumbara range?", listOf("නකල්ස්", "Knuckles"), "නකල්ස් (Knuckles) කඳු පන්තිය වේ.", "නකල්ස් කඳු පන්තියයි.")
        9 -> Quintuple("ශ්‍රී ලංකාවේ පහතරට තැන්න මුහුදු මට්ටමේ සිට මීටර් කීයක් දක්වාද?", "Low country elevation limit in meters?", listOf("300", "මීටර් 300"), "මීටර් 0 සිට 300 දක්වා වේ.", "මීටර් 300 දක්වායි.")
        10 -> Quintuple("ශ්‍රී ලංකාවේ භූමියෙන් වැඩිම ප්‍රතිශතයක් අයත් වන්නේ පහතරට තැන්නටද?", "Does lowland plain cover largest area of Sri Lanka?", listOf("ඔව්", "එසේය"), "ඔව්, භූමියෙන් 75%ක් පමණ පහතරට තැන්නයි.", "ඔව් වේ.")
        11 -> Quintuple("තැනිතලාව මැද හුදකලාව පිහිටි ශේෂ කන්දකට උදාහරණයක් පවසන්න.", "Example of an inselberg rock on plain?", listOf("සීගිරිය", "මිහින්තලේ", "දිඹුලාගල"), "සීගිරිය, මිහින්තලේ හෝ දිඹුලාගල වේ.", "සීගිරිය / මිහින්තලේයි.")
        12 -> Quintuple("සීගිරිය පර්වතය පිහිටා ඇත්තේ කුමන දිස්ත්‍රික්කයේද?", "District of Sigiriya rock?", listOf("මාතලේ", "මාතලේ දිස්ත්‍රික්කය"), "මාතලේ දිස්ත්‍රික්කයේ වේ.", "මාතලේයි.")
        13 -> Quintuple("ශ්‍රී ලංකාවේ කඳුකරයේ සිට ගංගා ගලා බසින්නේ කුමන රටාවටද?", "Radial river pattern flowing from highlands?", listOf("අරීය", "අරීය රටාව"), "අරීය රටාවට (මධ්‍යම කඳුකරයේ සිට සතර දෙසට) වේ.", "අරීය රටාවයි.")
        14 -> Quintuple("ශ්‍රී ලංකාවේ විශාලතම ස්වභාවික වරාය කුමක්ද?", "Largest natural harbor in Sri Lanka?", listOf("ත්‍රිකුණාමලය", "ත්‍රිකුණාමල වරාය"), "ත්‍රිකුණාමලය වරාය වේ.", "ත්‍රිකුණාමලයයි.")
        15 -> Quintuple("කොළඹ වරාය යනු කෘත්‍රිම වරායක්ද?", "Is Colombo harbor an artificial harbor?", listOf("ඔව්", "එසේය"), "ඔව්, දියකඩන බැඳ සාදන ලද්දකි.", "ඔව් වේ.")
        16 -> Quintuple("ශ්‍රී ලංකාවේ වෙරළබඩ කලපුවක් නම් කරන්න.", "Name a coastal lagoon in Sri Lanka.", listOf("මීගමුව", "පුත්තලම", "මඩකලපුව"), "මීගමුව, පුත්තලම හෝ මඩකලපුව වේ.", "මීගමුව / පුත්තලමයි.")
        17 -> Quintuple("කඳුකර බෑවුම්වල පස් තට්ටු පහළට කඩා වැටීම කුමක්ද?", "Downward sliding of slope soil and rocks?", listOf("නායයෑම්", "නාය යෑම"), "නායයෑම් (Landslides) වේ.", "නායයෑම් වේ.")
        18 -> Quintuple("නායයෑම් අවම කිරීමට කළ හැකි හොඳම පිළියමක් පවසන්න.", "Best measure to mitigate landslides?", listOf("ගස් වැවීම", "කානු සකස් කිරීම", "ආරක්ෂිත බැමි"), "බෑවුම්වල ගස් වැවීම හා ජල බැසයාම් කානු සැකසීමයි.", "ගස් වැවීමයි.")
        19 -> Quintuple("ශ්‍රී ලංකාවේ ප්‍රධාන දූපතක් නම් කරන්න.", "Name an offshore island of Sri Lanka.", listOf("ඩෙල්ෆ්", "මන්නාරම", "කච්චතිව්"), "ඩෙල්ෆ්, මන්නාරම හෝ කච්චතිව් දූපත වේ.", "ඩෙල්ෆ් / මන්නාරමයි.")
        20 -> Quintuple("ශ්‍රී ලංකාවේ මධ්‍යම කඳුකරය පිහිටා ඇත්තේ රටේ කුමන ප්‍රදේශයේද?", "Where are the central highlands situated in Sri Lanka?", listOf("මධ්‍යයේ", "දකුණු මැද"), "දකුණු මධ්‍යම ප්‍රදේශයේය.", "දකුණු මැදය.")
        else -> Quintuple("ශ්‍රී ලංකාවේ භූ විෂමතාව විවිධත්වයකින් යුක්තද?", "Is Sri Lanka's topography diverse?", listOf("ඔව්", "එසේය"), "ඔව්, විවිධ උස මට්ටම් පවතී.", "ඔව් වේ.")
      }

      // Set 4: ශ්‍රී ලංකාවේ ගංගා & වැව් පද්ධතිය
      4 -> when (qIndex) {
        1 -> Quintuple("ශ්‍රී ලංකාවේ දිගම ගංගාව කුමක්ද?", "Longest river in Sri Lanka?", listOf("මහවැලි", "මහවැලි ගඟ", "Mahaweli"), "මහවැලි ගඟ වේ.", "මහවැලි ගඟයි.")
        2 -> Quintuple("මහවැලි ගඟේ මුළු දිග කිලෝමීටර කීයද?", "Length of Mahaweli river in km?", listOf("335", "335km"), "කිලෝමීටර 335 කි.", "335 km වේ.")
        3 -> Quintuple("මහවැලි ගඟ මුහුදට වැටෙන්නේ කුමන නගරය අසලින්ද?", "City where Mahaweli meets the sea?", listOf("ත්‍රිකුණාමලය", "කොඩ්ඩියාර් බොක්ක"), "ත්‍රිකුණාමලයේ කොඩ්ඩියාර් බොක්කෙනි.", "ත්‍රිකුණාමලයෙනි.")
        4 -> Quintuple("ශ්‍රී ලංකාවේ දෙවන දිගම ගංගාව කුමක්ද?", "Second longest river in Sri Lanka?", listOf("මල්වතු ඔය", "මල්වතු"), "මල්වතු ඔය (කිලෝමීටර් 164) වේ.", "මල්වතු ඔයයි.")
        5 -> Quintuple("කොළඹ නගරය අසලින් මුහුදට වැටෙන ප්‍රධාන ගංගාව කුමක්ද?", "River entering sea near Colombo?", listOf("කැළණි ගඟ", "කැළණි"), "කැළණි ගඟ වේ.", "කැළණි ගඟයි.")
        6 -> Quintuple("ශ්‍රී ලංකාවේ වැඩිම ජල කඳක් රැගෙන යන ගංගාව කුමක්ද?", "River carrying highest annual water volume?", listOf("කළු ගඟ", "කළු"), "කළු ගඟ වේ.", "කළු ගඟයි.")
        7 -> Quintuple("කළුතර නගරයෙන් මුහුදට වැටෙන ගංගාව කුමක්ද?", "River meeting sea at Kalutara?", listOf("කළු ගඟ", "කළු"), "කළු ගඟ වේ.", "කළු ගඟයි.")
        8 -> Quintuple("හම්බන්තොටින් මුහුදට වැටෙන ප්‍රධාන ගංගාව කුමක්ද?", "River meeting sea at Hambantota?", listOf("වලවේ ගඟ", "වලවේ"), "වලවේ ගඟ වේ.", "වලවේ ගඟයි.")
        9 -> Quintuple("ශ්‍රී ලංකාවේ උසම දියඇල්ල කුමක්ද?", "Highest waterfall in Sri Lanka?", listOf("බඹරකන්ද", "බඹරකන්ද ඇල්ල"), "බඹරකන්ද දියඇල්ල (මීටර් 263) වේ.", "බඹරකන්දයි.")
        10 -> Quintuple("බඹරකන්ද දියඇල්ල පිහිටා ඇති දිස්ත්‍රික්කය කුමක්ද?", "District of Bambarakanda falls?", listOf("බදුල්ල", "බදුල්ල දිස්ත්‍රික්කය"), "බදුල්ල දිස්ත්‍රික්කය වේ.", "බදුල්ලයි.")
        11 -> Quintuple("දුන්හිඳ දියඇල්ල පිහිටා ඇත්තේ කුමන නගරය අසලද?", "Town near Dunhinda falls?", listOf("බදුල්ල", "බදුල්ල නගරය"), "බදුල්ල නගරය අසලය.", "බදුල්ල අසලයි.")
        12 -> Quintuple("ශ්‍රී ලංකාවේ දෙවන උසම දියඇල්ල කුමක්ද?", "Second highest waterfall in Sri Lanka?", listOf("දියලුම", "දියලුම ඇල්ල"), "දියලුම දියඇල්ල (කොස්ලන්ද) වේ.", "දියලුමයි.")
        13 -> Quintuple("මහසෙන් රජු කරවූ ප්‍රකට දැවැන්ත වැව කුමක්ද?", "Famous giant reservoir built by King Mahasen?", listOf("මින්නේරිය වැව", "මින්නේරිය"), "මින්නේරිය වැව වේ.", "මින්නේරිය වැවයි.")
        14 -> Quintuple("ධාතුසේන රජු විසින් කරවන ලද ප්‍රකට වැව කුමක්ද?", "Famous reservoir built by King Dhatusena?", listOf("කලා වැව", "කලාවැව"), "කලා වැව වේ.", "කලා වැවයි.")
        15 -> Quintuple("මහා පරාක්‍රමබාහු රජු පොළොන්නරුවේ කරවූ දැවැන්ත වැව කුමක්ද?", "Giant reservoir built by King Parakramabahu in Polonnaruwa?", listOf("පරාක්‍රම සමුද්‍රය"), "පරාක්‍රම සමුද්‍රය වේ.", "පරාක්‍රම සමුද්‍රයයි.")
        16 -> Quintuple("කලා වැවේ සිට තිසා වැව දක්වා ජලය ගෙනගිය ඓතිහාසික ඇළ මාර්ගය කුමක්ද?", "Ancient canal carrying water from Kala Wewa to Tissa Wewa?", listOf("ජය ගඟ", "යෝධ ඇළ"), "ජය ගඟ හෙවත් යෝධ ඇළ වේ.", "යෝධ ඇළයි.")
        17 -> Quintuple("පැරණි වැවක ජල පීඩනය පාලනය කරමින් පිටතට ජලය මුදාහැරීමට තිබූ අංගය කුමක්ද?", "Ancient sluice gate controlling water release in tank?", listOf("බිසෝකොටුව", "බිසෝ කොටුව"), "බිසෝකොටුව වේ.", "බිසෝකොටුවයි.")
        18 -> Quintuple("වැවක අධික ජලය පිටතට ගලා යාමට සකසන කොටස කුමක්ද?", "Spillway releasing excess water from tank?", listOf("පිටවාන", "වාන"), "පිටවාන (Spill) වේ.", "පිටවානයි.")
        19 -> Quintuple("වැවක් ඉදිරිපසින් පස් බැඳ තනන ශක්තිමත් බැම්ම කුමක්ද?", "Earthen embankment damming a tank?", listOf("වැව් බැම්ම", "බැම්ම"), "වැව් බැම්ම (Bund) වේ.", "වැව් බැම්මයි.")
        20 -> Quintuple("ශ්‍රී ලංකාවේ මුළු ගංගා ද්‍රෝණි ගණන කීයද?", "Total number of river basins in Sri Lanka?", listOf("103", "103ක්"), "ගංගා ද්‍රෝණි 103කි.", "103කි.")
        else -> Quintuple("ශ්‍රී ලංකාව පෙරදිග ධාන්‍යාගාරය ලෙස හැඳින්වූයේ වාරි ශිෂ්ටාචාරය නිසාද?", "Was Sri Lanka called Granary of the East due to irrigation?", listOf("ඔව්", "එසේය"), "ඔව්, සරුසාර වී ගොවිතැන නිසාය.", "ඔව් වේ.")
      }

      // Set 5: ශ්‍රී ලංකාවේ කාලගුණය & මෝසම්
      5 -> when (qIndex) {
        1 -> Quintuple("ශ්‍රී ලංකාව අයත් වන්නේ කුමන ප්‍රධාන දේශගුණ කලාපයටද?", "Main climatic zone Sri Lanka belongs to?", listOf("නිවර්තන", "Tropical"), "නිවර්තන කලාපය (Tropical zone) වේ.", "නිවර්තන කලාපයයි.")
        2 -> Quintuple("ශ්‍රී ලංකාවට බලපාන ප්‍රධාන මෝසම් සුළං 2 මොනවාද?", "Two main monsoons affecting Sri Lanka?", listOf("නිරිතදිග හා ඊසානදිග", "නිරිතදිග", "ඊසානදිග"), "නිරිතදිග සහ ඊසානදිග මෝසම් සුළං වේ.", "නිරිතදිග හා ඊසානදිගයි.")
        3 -> Quintuple("නිරිතදිග මෝසම් සුළං හමන්නේ කුමන මාසවලදීද?", "Months of South-West monsoon?", listOf("මැයි සිට සැප්තැම්බර්", "මැයි - සැප්තැම්බර්"), "මැයි සිට සැප්තැම්බර් දක්වාය.", "මැයි සිට සැප්තැම්බර් දක්වායි.")
        4 -> Quintuple("ඊසානදිග මෝසම් සුළං හමන්නේ කුමන මාසවලදීද?", "Months of North-East monsoon?", listOf("දෙසැම්බර් සිට පෙබරවාරි", "දෙසැම්බර් - පෙබරවාරි"), "දෙසැම්බර් සිට පෙබරවාරි දක්වාය.", "දෙසැම්බර් සිට පෙබරවාරි දක්වායි.")
        5 -> Quintuple("ශ්‍රී ලංකාවේ ප්‍රධාන වර්ෂාපතන කලාප 3 මොනවාද?", "Three rainfall zones of Sri Lanka?", listOf("තෙත් වියළි අතරමැදි", "තෙත්", "වියළි", "අතරමැදි"), "තෙත්, වියළි සහ අතරමැදි කලාප වේ.", "තෙත්, වියළි, අතරමැදියි.")
        6 -> Quintuple("තෙත් සහ වියළි කලාප වෙන් කරන වාර්ෂික සමවර්ෂා රේඛාව කීයද?", "Annual isohyet separating wet and dry zones?", listOf("2000", "මිලිමීටර් 2000", "2000mm"), "මිලිමීටර් 2000 (2000 mm) සමවර්ෂා රේඛාවයි.", "2000 mm වේ.")
        7 -> Quintuple("ශ්‍රී ලංකාවේ සිසිල්ම දේශගුණයක් ඇති නගරය කුමක්ද?", "Coolest climate city in Sri Lanka?", listOf("නුවරඑළිය", "Nuwara Eliya"), "නුවරඑළිය නගරය වේ.", "නුවරඑළියයි.")
        8 -> Quintuple("නුවරඑළියේ වාර්ෂික සාමාන්‍ය උෂ්ණත්වය සෙල්සියස් කීයද?", "Average temperature in Nuwara Eliya?", listOf("15", "16", "15°C - 16°C"), "සෙල්සියස් අංශක 15°C - 16°C පමණ වේ.", "15°C - 16°C වේ.")
        9 -> Quintuple("ශ්‍රී ලංකාවේ පහතරට වාර්ෂික සාමාන්‍ය උෂ්ණත්වය සෙල්සියස් කීයද?", "Average lowland temperature in Sri Lanka?", listOf("27", "28", "27°C - 28°C"), "සෙල්සියස් අංශක 27°C - 28°C පමණ වේ.", "27°C - 28°C වේ.")
        10 -> Quintuple("වායුගෝලයේ උෂ්ණත්වය මනින සම්මත උපකරණය කුමක්ද?", "Standard instrument measuring air temperature?", listOf("උෂ්ණත්වමානය", "Thermometer"), "උෂ්ණත්වමානය (Thermometer) වේ.", "උෂ්ණත්වමානයයි.")
        11 -> Quintuple("වර්ෂාපතනය මනින උපකරණය කුමක්ද?", "Instrument measuring rainfall?", listOf("වර්ෂාමානය", "Rain gauge"), "වර්ෂාමානය (Rain gauge) වේ.", "වර්ෂාමානයයි.")
        12 -> Quintuple("සුළඟේ දිශාව පෙන්වන උපකරණය කුමක්ද?", "Instrument showing wind direction?", listOf("සුළං දිශා දර්ශකය", "Wind vane"), "සුළං දිශා දර්ශකය (Wind Vane) වේ.", "සුළං දිශා දර්ශකයයි.")
        13 -> Quintuple("සුළඟේ වේගය මනින උපකරණය කුමක්ද?", "Instrument measuring wind speed?", listOf("ඇනිමෝමීටරය", "Anemometer"), "ඇනිමෝමීටරය (Anemometer) වේ.", "ඇනිමෝමීටරයයි.")
        14 -> Quintuple("වායුගෝලීය පීඩනය මනින උපකරණය කුමක්ද?", "Instrument measuring atmospheric pressure?", listOf("බැරෝමීටරය", "Barometer"), "බැරෝමීටරය (Barometer) වේ.", "බැරෝමීටරයයි.")
        15 -> Quintuple("වාතයේ ආර්ද්‍රතාවය (තෙතමනය) මනින උපකරණය කුමක්ද?", "Instrument measuring humidity?", listOf("හයිග්‍රෝමීටරය", "Hygrometer"), "හයිග්‍රෝමීටරය (Hygrometer) වේ.", "හයිග්‍රෝමීටරයයි.")
        16 -> Quintuple("අප්‍රේල්-මැයි මාසවල සවස් වරුවේ අකුණු සමඟ ලැබෙන වැසි කුමක්ද?", "Afternoon thunderstorm rains in April-May?", listOf("සංවහන වැසි", "සංවහන"), "සංවහන වැසි (Convectional rain) වේ.", "සංවහන වැසියි.")
        17 -> Quintuple("කඳුකර බෑවුමක සුළං හැපී ඉහළ නැඟ ලැබෙන වැසි මොනවාද?", "Rain formed by winds rising over hills?", listOf("භූ විෂමතා වැසි", "Orographic rain"), "භූ විෂමතා වැසි (Orographic rain) වේ.", "භූ විෂමතා වැසියි.")
        18 -> Quintuple("ශ්‍රී ලංකාවේ වියළිම ප්‍රදේශයක් නම් කරන්න.", "Name one of the driest places in Sri Lanka.", listOf("මන්නාරම", "හම්බන්තොට"), "මන්නාරම හෝ හම්බන්තොට වේ.", "මන්නාරම / හම්බන්තොටයි.")
        19 -> Quintuple("නිරිතදිග මෝසමෙන් වැඩිම වැසි ලබන්නේ තෙත් කලාපයද වියළි කලාපයද?", "Which zone gets most rain from SW monsoon?", listOf("තෙත් කලාපය", "තෙත්"), "තෙත් කලාපය (නිරිතදිග ප්‍රදේශ) වේ.", "තෙත් කලාපයයි.")
        20 -> Quintuple("ඊසානදිග මෝසමෙන් වැඩිම වැසි ලබන්නේ රටේ කුමන ප්‍රදේශද?", "Which parts receive most rain from NE monsoon?", listOf("උතුර සහ නැගෙනහිර", "උතුරු", "නැගෙනහිර"), "උතුරු, උතුරුමැද සහ නැගෙනහිර පළාත් වේ.", "උතුර හා නැගෙනහිරයි.")
        else -> Quintuple("කාලගුණය යනු දිනපතා සිදුවන වෙනස්වීම්ද?", "Is weather the daily atmospheric state?", listOf("ඔව්", "එසේය"), "ඔව්, කෙටි කාලීන වෙනස්වීම්ය.", "ඔව් වේ.")
      }

      // Set 6: ලංකාවේ ස්වභාවික සම්පත්
      6 -> when (qIndex) {
        1 -> Quintuple("ශ්‍රී ලංකාවේ පිහිටි ලෝක උරුම වැසි වනාන්තරය කුමක්ද?", "World Heritage rainforest in Sri Lanka?", listOf("සිංහරාජය", "සිංහරාජ වනය", "Sinharaja"), "සිංහරාජ වැසි වනාන්තරය වේ.", "සිංහරාජයයි.")
        2 -> Quintuple("ශ්‍රී ලංකාවේ ජාතික වෘක්ෂය කුමක්ද?", "National tree of Sri Lanka?", listOf("නා ගස", "නා", "Ironwood"), "නා ගස (Ironwood) වේ.", "නා ගසයි.")
        3 -> Quintuple("ශ්‍රී ලංකාවේ ජාතික පුෂ්පය කුමක්ද?", "National flower of Sri Lanka?", listOf("නිල් මහනෙල්", "මහනෙල්"), "නිල් මහනෙල් මල වේ.", "නිල් මහනෙල් මලයි.")
        4 -> Quintuple("ශ්‍රී ලංකාවේ ජාතික පක්ෂියා කුමක්ද?", "National bird of Sri Lanka?", listOf("වලිකුකුළා", "ශ්‍රී ලංකා වලි කුකුළා"), "ශ්‍රී ලංකා වලි කුකුළා වේ.", "වලිකුකුළායි.")
        5 -> Quintuple("ශ්‍රී ලංකාවේ ප්‍රධාන ජාතික වනෝද්‍යානයක් නම් කරන්න.", "Name a major national park in Sri Lanka.", listOf("යාල", "විල්පත්තුව", "මින්නේරිය"), "යාල, විල්පත්තුව හෝ මින්නේරිය වේ.", "යාල / විල්පත්තුවයි.")
        6 -> Quintuple("අපේ රටට පමණක් සීමා වූ ශාක හා සතුන් හඳුන්වන්නේ කෙසේද?", "Species restricted only to Sri Lanka?", listOf("ආවේණික", "ආවේණික විශේෂ", "Endemic"), "ආවේණික විශේෂ (Endemic species) නමිනි.", "ආවේණික විශේෂයි.")
        7 -> Quintuple("ශ්‍රී ලංකාවේ මැණික් සම්පතට ප්‍රසිද්ධ ප්‍රධාන නගරය කුමක්ද?", "Main city famous for gemstones?", listOf("රත්නපුර", "රත්නපුරය", "Ratnapura"), "රත්නපුර (මැණික්පුර) වේ.", "රත්නපුරයයි.")
        8 -> Quintuple("ලොව ප්‍රකට නිල් මැණික (Blue Sapphire) ලංකාවේ හමුවේද?", "Is world-famous Blue Sapphire found in Sri Lanka?", listOf("ඔව්", "එසේය"), "ඔව්, ලංකාවේ ප්‍රධාන අනන්‍යතාවකි.", "ඔව් වේ.")
        9 -> Quintuple("ශ්‍රී ලංකාවේ උසස් තත්ත්වයේ මිනිරන් හමුවන පතලක් නම් කරන්න.", "Name a high grade graphite mine in Sri Lanka.", listOf("බෝගල", "කහටගහ", "Bogala"), "බෝගල හෝ කහටගහ මිනිරන් පතල වේ.", "බෝගල පතලයි.")
        10 -> Quintuple("පුල්මොඩේ ප්‍රදේශයෙන් ලබාගන්නා ප්‍රධාන ඛනිජය කුමක්ද?", "Main mineral from Pulmoddai?", listOf("ඛනිජ වැලි", "ඉල්මනයිට්"), "ඛනිජ වැලි (ඉල්මනයිට්, රුටයිල්) වේ.", "ඛනිජ වැලියි.")
        11 -> Quintuple("එප්පාවල ප්‍රදේශයෙන් ලබාගන්නේ කුමන ඛනිජ සම්පතද?", "Mineral deposit at Eppawala?", listOf("පොස්ෆේට්", "අපටයිට්", "Phosphate"), "පොස්ෆේට් (අපටයිට්) නිධිය වේ.", "පොස්ෆේට් නිධියයි.")
        12 -> Quintuple("කන්කසන්තුරේ ප්‍රදේශයෙන් සිමෙන්ති සෑදීමට ලබාගන්නේ මොනවාද?", "Mineral from Kankesanthurai for cement?", listOf("හුණුගල්", "Limestone"), "හුණුගල් (Limestone) වේ.", "හුණුගල් වේ.")
        13 -> Quintuple("ශ්‍රී ලංකාවේ විශාලතම ජල විදුලි බලාගාරය කුමක්ද?", "Largest hydro power station in Sri Lanka?", listOf("වික්ටෝරියා", "Victoria"), "වික්ටෝරියා ජලාශ බලාගාරය වේ.", "වික්ටෝරියා බලාගාරයයි.")
        14 -> Quintuple("සුළං බලයෙන් විදුලිය නිපදවන මන්නාරමේ විශාල බලාගාරය කුමක්ද?", "Large wind power plant in Mannar?", listOf("තම්බපවනි", "සුළං බලාගාරය"), "තම්බපවනි සුළං බලාගාරය වේ.", "තම්බපවනි බලාගාරයයි.")
        15 -> Quintuple("ලුණු නිෂ්පාදනය සඳහා මුහුදු ජලය රඳවන ස්ථානය කුමක්ද?", "Place for seawater evaporation for salt?", listOf("ලවණ ලේවාය", "ලේවාය", "Saltern"), "ලවණ ලේවාය (Saltern) නමිනි.", "ලේවායයි.")
        16 -> Quintuple("ශ්‍රී ලංකාවේ ප්‍රධාන ලුණු ලේවායක් පිහිටි දිස්ත්‍රික්කයක් නම් කරන්න.", "District with major saltern in Sri Lanka?", listOf("හම්බන්තොට", "පුත්තලම"), "හම්බන්තොට හෝ පුත්තලම වේ.", "හම්බන්තොට / පුත්තලමයි.")
        17 -> Quintuple("ජලය සහ සූර්යාලෝකය යනු පුනර්ජනනීය සම්පත්ද?", "Are water and sunlight renewable resources?", listOf("ඔව්", "එසේය"), "ඔව්, පුනර්ජනනීය බලශක්ති සම්පත්ය.", "ඔව් වේ.")
        18 -> Quintuple("වන විනාශය නිසා සිදුවන ප්‍රධාන පාරිසරික හානිය කුමක්ද?", "Main environmental damage from deforestation?", listOf("පාංශු ඛාදනය", "ජල උල්පත් සිඳියාම"), "පාංශු ඛාදනය සහ ජල උල්පත් සිඳී යාමයි.", "පාංශු ඛාදනයයි.")
        19 -> Quintuple("ශ්‍රී ලංකාවේ කුරුළු පාරාදීසය ලෙස ප්‍රකට අභයභූමිය කුමක්ද?", "Famous bird sanctuary in Sri Lanka?", listOf("කුමන", "බූන්දල"), "කුමන හෝ බූන්දල පක්ෂි අභයභූමිය වේ.", "කුමන / බූන්දලයි.")
        20 -> Quintuple("ස්වභාවික සම්පත් අරපිරිමැස්මෙන් භාවිත කිරීම වැදගත්ද?", "Is conserving natural resources important?", listOf("ඔව්", "එසේය"), "ඔව්, අනාගත පරපුර උදෙසා අත්‍යවශ්‍යයි.", "ඔව් වේ.")
        else -> Quintuple("ශ්‍රී ලංකාව ස්වභාවික සම්පත්වලින් පොහොසත් රටක්ද?", "Is Sri Lanka rich in natural resources?", listOf("ඔව්", "එසේය"), "ඔව්, වටිනා සම්පත් පවතී.", "ඔව් වේ.")
      }

      // Set 7: ජනගහන ඝනත්වය & ව්‍යාප්තිය
      7 -> when (qIndex) {
        1 -> Quintuple("ශ්‍රී ලංකාවේ වත්මන් ජනගහනය දළ වශයෙන් කෝටි කීයක්ද?", "Sri Lanka's current population in crores/millions?", listOf("කෝටි 2.2", "මිලියන 22", "කෝටි 2ක්"), "කෝටි 2.2ක් (මිලියන 22ක් පමණ) වේ.", "කෝටි 2.2ක් පමණයි.")
        2 -> Quintuple("ශ්‍රී ලංකාවේ ජනගහනය වැඩිම දිස්ත්‍රික්කය කුමක්ද?", "Most populated district in Sri Lanka?", listOf("ගම්පහ", "කොළඹ"), "ගම්පහ (හෝ කොළඹ) දිස්ත්‍රික්කය වේ.", "ගම්පහ / කොළඹයි.")
        3 -> Quintuple("ශ්‍රී ලංකාවේ ජනගහන ඝනත්වය අධිකම දිස්ත්‍රික්කය කුමක්ද?", "Most densely populated district?", listOf("කොළඹ", "කොළඹ දිස්ත්‍රික්කය"), "කොළඹ දිස්ත්‍රික්කය වේ.", "කොළඹ දිස්ත්‍රික්කයයි.")
        4 -> Quintuple("ශ්‍රී ලංකාවේ ජනගහන ඝනත්වය ඉතා අඩු දිස්ත්‍රික්කයක් නම් කරන්න.", "District with low population density?", listOf("මුලතිව්", "මොනරාගල", "වවුනියාව"), "මුලතිව් හෝ මොනරාගල දිස්ත්‍රික්කය වේ.", "මුලතිව් / මොනරාගලයි.")
        5 -> Quintuple("ජන ඝනත්වය යනු කුමක්ද?", "What is population density?", listOf("වර්ග කිලෝමීටරයක වෙසෙන ජන සංඛ්‍යාව", "වර්ග කි.මී. ජන සංඛ්‍යාව"), "වර්ග කිලෝමීටරයක වෙසෙන සාමාන්‍ය ජන සංඛ්‍යාවයි.", "වර්ග කි.මී. ජන ගණනයි.")
        6 -> Quintuple("ශ්‍රී ලංකාවේ ජනගහනයෙන් බහුතරයක් වෙසෙන්නේ නගරබඩද ගම්බදද?", "Do majority of Sri Lankans live in rural or urban areas?", listOf("ගම්බද", "ග්‍රාමීය", "Rural"), "ග්‍රාමීය ප්‍රදේශවලය (75%කට වැඩි).", "ග්‍රාමීය ප්‍රදේශවලය.")
        7 -> Quintuple("ශ්‍රී ලංකාවේ ප්‍රධාන ජාතීන් කීයක් සහජීවනයෙන් වෙසේද?", "Main ethnic communities in Sri Lanka?", listOf("සිංහල දෙමළ මුස්ලිම් බර්ගර්", "4ක්", "සිංහල"), "සිංහල, දෙමළ, මුස්ලිම්, බර්ගර් ආදී ප්‍රජාවන්ය.", "සිංහල, දෙමළ, මුස්ලිම්ය.")
        8 -> Quintuple("ශ්‍රී ලංකාවේ වැඩිම ජනගහන ප්‍රතිශතයක් නියෝජනය කරන ජාතිය කුමක්ද?", "Majority ethnic group in Sri Lanka?", listOf("සිංහල", "Sinhala"), "සිංහල ජනතාව වේ (74%ක් පමණ).", "සිංහල ජනතාවයි.")
        9 -> Quintuple("ජන සංගණනයක් පවත්වන්නේ සාමාන්‍යයෙන් වසර කීයකට වරක්ද?", "How often is a national census usually conducted?", listOf("වසර 10", "10", "දහයකට වරක්"), "වසර 10කට වරකි.", "වසර 10කට වරකි.")
        10 -> Quintuple("ශ්‍රී ලංකාවේ ජන හා සංඛ්‍යාලේඛන දෙපාර්තමේන්තුව ජන සංගණන පවත්වයිද?", "Does Dept of Census and Statistics conduct censuses?", listOf("ඔව්", "එසේය"), "ඔව්, නිල සංගණන පවත්වයි.", "ඔව් වේ.")
        11 -> Quintuple("මිනිසුන් රැකියා සොයා නගරවලට සංක්‍රමණය වීම කුමක්ද?", "Moving to cities for employment?", listOf("නාගරීකරණය", "ග්‍රාම-නාගරික සංක්‍රමණය"), "ග්‍රාම-නාගරික සංක්‍රමණය හෙවත් නාගරීකරණයයි.", "නාගරීකරණයයි.")
        12 -> Quintuple("ශ්‍රී ලංකාවේ ප්‍රධාන වාණිජ අගනගරය කුමක්ද?", "Commercial capital of Sri Lanka?", listOf("කොළඹ", "Colombo"), "කොළඹ නගරය වේ.", "කොළඹයි.")
        13 -> Quintuple("ශ්‍රී ලංකාවේ පරිපාලන අගනුවර කුමක්ද?", "Administrative capital of Sri Lanka?", listOf("ශ්‍රී ජයවර්ධනපුර කෝට්ටේ", "කෝට්ටේ"), "ශ්‍රී ජයවර්ධනපුර කෝට්ටේ වේ.", "ශ්‍රී ජයවර්ධනපුර කෝට්ටේයි.")
        14 -> Quintuple("මධ්‍යම පළාතේ අගනගරය කුමක්ද?", "Capital city of Central Province?", listOf("මහනුවර", "Kandy"), "මහනුවර නගරය වේ.", "මහනුවරයි.")
        15 -> Quintuple("දකුණු පළාතේ අගනගරය කුමක්ද?", "Capital city of Southern Province?", listOf("ගාල්ල", "Galle"), "ගාල්ල නගරය වේ.", "ගාල්ලයි.")
        16 -> Quintuple("උතුරු පළාතේ ප්‍රධාන නගරය කුමක්ද?", "Main city of Northern Province?", listOf("යාපනය", "Jaffna"), "යාපනය නගරය වේ.", "යාපනයයි.")
        17 -> Quintuple("නැගෙනහිර පළාතේ ප්‍රධාන වරාය නගරය කුමක්ද?", "Main port city of Eastern Province?", listOf("ත්‍රිකුණාමලය", "Trincomalee"), "ත්‍රිකුණාමලය වේ.", "ත්‍රිකුණාමලයයි.")
        18 -> Quintuple("වයඹ පළාතේ ප්‍රධාන නගරය කුමක්ද?", "Main city of North-Western Province?", listOf("කුරුණෑගල", "Kurunegala"), "කුරුණෑගල වේ.", "කුරුණෑගලයි.")
        19 -> Quintuple("සබරගමුව පළාතේ අගනගරය කුමක්ද?", "Capital city of Sabaragamuwa Province?", listOf("රත්නපුර", "Ratnapura"), "රත්නපුර වේ.", "රත්නපුරයයි.")
        20 -> Quintuple("ඌව පළාතේ අගනගරය කුමක්ද?", "Capital city of Uva Province?", listOf("බදුල්ල", "Badulla"), "බදුල්ල වේ.", "බදුල්ලයි.")
        else -> Quintuple("ශ්‍රී ලංකාවේ පළාත් 9ක් තිබේද?", "Are there 9 provinces in Sri Lanka?", listOf("ඔව්", "එසේය"), "ඔව්, පළාත් නවයකි.", "ඔව් වේ.")
      }

      // Set 8: ප්‍රවාහන මාර්ග & සන්නිවේදනය
      8 -> when (qIndex) {
        1 -> Quintuple("ශ්‍රී ලංකාවේ ගොඩබිම් ප්‍රවාහනයේ ප්‍රධාන මාර්ග 2 මොනවාද?", "Two main land transport modes in Sri Lanka?", listOf("මහාමාර්ග හා දුම්රිය මාර්ග", "මහාමාර්ග", "දුම්රිය"), "මහාමාර්ග සහ දුම්රිය මාර්ග වේ.", "මහාමාර්ග සහ දුම්රියයි.")
        2 -> Quintuple("ශ්‍රී ලංකාවේ ප්‍රථම දුම්රිය මාර්ගය ඉදිකළේ කොළඹ සිට කොතෙක් දක්වාද?", "Where did the first railway line run from Colombo?", listOf("අඹේපුස්ස", "අඹේපුස්ස දක්වා"), "කොළඹ සිට අඹේපුස්ස දක්වාය (1864 දී).", "අඹේපුස්ස දක්වායි.")
        3 -> Quintuple("ලංකාවේ ප්‍රථම දුම්රිය මාර්ගය ඉදිකළ ප්‍රධාන අරමුණ කුමක්ද?", "Primary purpose of constructing first railway?", listOf("කෝපි ප්‍රවාහනය", "තේ ප්‍රවාහනය"), "උඩරට වැවිලි බෝග (කෝපි/තේ) කොළඹට ගෙන ඒමටය.", "වැවිලි බෝග ප්‍රවාහනයටයි.")
        4 -> Quintuple("ශ්‍රී ලංකාවේ මුහුදුබඩ දුම්රිය මාර්ගය දිවෙන්නේ කොළඹ සිට කොතෙක් දක්වාද?", "Coastal railway line runs from Colombo to where?", listOf("මාතර", "බෙලිඅත්ත"), "මාතර හරහා බෙලිඅත්ත දක්වාය.", "මාතර / බෙලිඅත්තටයි.")
        5 -> Quintuple("ශ්‍රී ලංකාවේ උතුරු දුම්රිය මාර්ගයේ අවසන් නැවතුම කුමක්ද?", "Terminus of Northern railway line?", listOf("කන්කසන්තුරේ", "KKS"), "කන්කසන්තුරේ (KKS) වේ.", "කන්කසන්තුරේයි.")
        6 -> Quintuple("ශ්‍රී ලංකාවේ ප්‍රධාන ජාත්‍යන්තර ගුවන් තොටුපළ කුමක්ද?", "Main international airport of Sri Lanka?", listOf("කටුනායක", "බණ්ඩාරනායක ජාත්‍යන්තර"), "බණ්ඩාරනායක ජාත්‍යන්තර ගුවන් තොටුපළ (කටුනායක) වේ.", "කටුනායක ගුවන්තොටුපළයි.")
        7 -> Quintuple("දකුණු පළාතේ පිහිටි ජාත්‍යන්තර ගුවන් තොටුපළ කුමක්ද?", "International airport in Southern Province?", listOf("මත්තල", "මත්තල රාජපක්ෂ"), "මත්තල ජාත්‍යන්තර ගුවන් තොටුපළ වේ.", "මත්තල ගුවන්තොටුපළයි.")
        8 -> Quintuple("ශ්‍රී ලංකාවේ ප්‍රධානතම ජාත්‍යන්තර බහලුම් වරාය කුමක්ද?", "Primary international container port of Sri Lanka?", listOf("කොළඹ වරාය", "කොළඹ"), "කොළඹ වරාය වේ.", "කොළඹ වරායයි.")
        9 -> Quintuple("දකුණු පළාතේ පිහිටි නවීන ගැඹුරු මුහුදු වරාය කුමක්ද?", "Deep-sea port in Southern Province?", listOf("හම්බන්තොට වරාය", "මාගම්පුර"), "හම්බන්තොට මාගම්පුර ජාත්‍යන්තර වරාය වේ.", "හම්බන්තොට වරායයි.")
        10 -> Quintuple("ශ්‍රී ලංකාවේ ප්‍රථම අධිවේගී මාර්ගය කුමක්ද?", "First expressway in Sri Lanka?", listOf("දක්ෂිණ අධිවේගී මාර්ගය", "E01"), "දක්ෂිණ අධිවේගී මාර්ගය (E01) වේ.", "දක්ෂිණ අධිවේගී මාර්ගයයි.")
        11 -> Quintuple("කොළඹ සහ කටුනායක ගුවන් තොටුපළ යා කරන අධිවේගී මාර්ගය කුමක්ද?", "Expressway linking Colombo and Katunayake airport?", listOf("කොළඹ කටුනායක අධිවේගී", "E03"), "කොළඹ-කටුනායක අධිවේගී මාර්ගය (E03) වේ.", "කටුනායක අධිවේගී මාර්ගයයි.")
        12 -> Quintuple("මධ්‍යම අධිවේගී මාර්ගය (E02/E04) සැලසුම් කර ඇත්තේ කුමන නගරය කරාද?", "Central expressway connects Colombo towards which historic city?", listOf("මහනුවර", "කුරුණෑගල"), "කුරුණෑගල හා මහනුවර කරාය.", "මහනුවර කරාය.")
        13 -> Quintuple("ශ්‍රී ලංකාවේ මාර්ග අනතුරු අවම කරගැනීමට පදිකයන් භාවිත කළ යුත්තේ මොනවාද?", "Pedestrian crossing used for road safety?", listOf("කහ ඉර", "පදික මාරුව"), "පදික මාරුව (කහ ඉර) සහ ගුවන් පාලම්ය.", "කහ ඉරයි.")
        14 -> Quintuple("ශ්‍රී ලංකාවේ රථවාහන ධාවනය කරන්නේ පාරේ කුමන පැත්තෙන්ද?", "Which side of road do vehicles drive in Sri Lanka?", listOf("වම් පැත්තෙන්", "වමෙන්"), "වම් පසිනි (Left side).", "වම් පැත්තෙනි.")
        15 -> Quintuple("අන්තර්ජාලය සහ ජංගම දුරකථන සන්නිවේදනය රටේ ආර්ථිකයට වැදගත්ද?", "Are internet and mobile telecom vital for economy?", listOf("ඔව්", "එසේය"), "ඔව්, ක්ෂණික සන්නිවේදනයට අත්‍යවශ්‍යයි.", "ඔව් වේ.")
        16 -> Quintuple("තොරතුරු සන්නිවේදනයේදී පරිගණක භාවිතයෙන් යවන ලිපි මොනවාද?", "Electronic messages sent via computer networks?", listOf("විද්‍යුත් තැපෑල", "ඊමේල්", "Email"), "විද්‍යුත් තැපෑල (E-mail) වේ.", "ඊමේල් වේ.")
        17 -> Quintuple("ශ්‍රී ලංකාවේ ප්‍රධාන රූපවාහිනී හා ගුවන්විදුලි සේවා පවතීද?", "Do major TV and radio services operate in Sri Lanka?", listOf("ඔව්", "එසේය"), "ඔව්, රාජ්‍ය හා පෞද්ගලික නාලිකා පවතී.", "ඔව් වේ.")
        18 -> Quintuple("පොදු ප්‍රවාහන සේවා භාවිත කිරීමෙන් පරිසර දූෂණය හා තදබදය අඩුවේද?", "Does public transport reduce congestion and pollution?", listOf("ඔව්", "එසේය"), "ඔව්, ඉන්ධන හා පරිසර හානි අවම වේ.", "ඔව් වේ.")
        19 -> Quintuple("ශ්‍රී ලංකා ගමනාගමන මණ්ඩලය (ශ්‍රීලංගම) පවත්වාගෙන යන්නේ බස් සේවාවද?", "Does SLTB operate national bus service?", listOf("ඔව්", "එසේය"), "ඔව්, ලංගම බස් සේවාවයි.", "ඔව් වේ.")
        20 -> Quintuple("ශ්‍රී ලංකා දුම්රිය දෙපාර්තමේන්තුව රාජ්‍ය ආයතනයක්ද?", "Is Sri Lanka Railways a government department?", listOf("ඔව්", "එසේය"), "ඔව්, ප්‍රවාහන අමාත්‍යාංශය යටතේ පවතී.", "ඔව් වේ.")
        else -> Quintuple("ප්‍රවාහනය රටක ආර්ථිකයේ රුධිර නාලය වැනිද?", "Is transport like the bloodstream of an economy?", listOf("ඔව්", "එසේය"), "ඔව්, භාණ්ඩ හා මගී ප්‍රවාහනයට අත්‍යවශ්‍යයි.", "ඔව් වේ.")
      }

      // Set 9: පරිසර පද්ධති & සංරක්ෂණය
      9 -> when (qIndex) {
        1 -> Quintuple("පරිසර පද්ධතියක අඩංගු ප්‍රධාන සංරචක 2 මොනවාද?", "Two main components of an ecosystem?", listOf("ජෛව හා අජෛව", "ජීවී සහ අජීවී"), "ජෛව (ජීවී) සහ අජෛව (අජීවී) සාධක වේ.", "ජීවී සහ අජීවී සාධකයි.")
        2 -> Quintuple("ශාක තම ආහාර තමන් විසින්ම නිපදවන නිසා හඳුන්වන්නේ කෙසේද?", "Plants produce their own food, hence called?", listOf("ස්වයංපෝෂීන්", "නිෂ්පාදකයෝ", "Producers"), "නිෂ්පාදකයන් හෙවත් ස්වයංපෝෂීන් නමිනි.", "නිෂ්පාදකයන් නමිනි.")
        3 -> Quintuple("ආහාර සඳහා වෙනත් ජීවීන් මත යැපෙන සතුන් හඳුන්වන්නේ කෙසේද?", "Organisms depending on others for food?", listOf("පාරභෝජකයන්", "විෂමපෝෂීන්", "Consumers"), "පාරභෝජකයන් (Consumers) නමිනි.", "පාරභෝජකයන් නමිනි.")
        4 -> Quintuple("මියගිය ශාක හා සත්ත්ව කොටස් දිරාපත් කරන ක්ෂුද්‍රජීවීන් කවුද?", "Microorganisms breaking down dead matter?", listOf("විඝටකයන්", "Decomposers"), "විඝටකයන් (Decomposers) වේ.", "විඝටකයන් වේ.")
        5 -> Quintuple("ආහාර දාමයක ආරම්භ වන්නේ කවුරුන්ගෙන්ද?", "Food chain always begins with whom?", listOf("නිෂ්පාදකයන්ගෙන්", "ශාක වලින්", "කොළ පැහැ ශාක"), "ශාක හෙවත් නිෂ්පාදකයන්ගෙනි.", "ශාක වලිනි.")
        6 -> Quintuple("ආහාර දාම කිහිපයක් එකිනෙක බැඳී සෑදෙන ජාලය කුමක්ද?", "Network of interconnected food chains?", listOf("ආහාර ජාලය", "Food web"), "ආහාර ජාලය (Food web) වේ.", "ආහාර ජාලයයි.")
        7 -> Quintuple("ශ්‍රී ලංකාවේ වටිනා තෙත්බිම් පරිසර පද්ධතියක් නම් කරන්න.", "Name a wetland ecosystem in Sri Lanka.", listOf("මුතුරාජවෙල", "බූන්දල"), "මුතුරාජවෙල හෝ බූන්දල වේ.", "මුතුරාජවෙලයි.")
        8 -> Quintuple("මුතුරාජවෙල තෙත්බිම පිහිටා ඇත්තේ කුමන දිස්ත්‍රික්කයේද?", "District of Muthurajawela wetland?", listOf("ගම්පහ", "ගම්පහ දිස්ත්‍රික්කය"), "ගම්පහ දිස්ත්‍රික්කයේ වේ.", "ගම්පහයි.")
        9 -> Quintuple("මුහුදු ඛාදනය වැළැක්වීමට වෙරළේ වැවෙන ප්‍රයෝජනවත් ශාක මොනවාද?", "Plants protecting coast from sea erosion?", listOf("කඩොලාන", "මුහුදු බඩවැල්", "වෙරළ ශාක"), "කඩොලාන ශාක සහ මුහුදු බඩවැල් වේ.", "කඩොලාන ශාකයි.")
        10 -> Quintuple("ලංකාවේ කොරල්පර බහුලව දැකිය හැකි දකුණු වෙරළබඩ නගරයක් නම් කරන්න.", "Southern town famous for coral reefs?", listOf("හික්කඩුව", "Hikkaduwa"), "හික්කඩුව (Hikkaduwa) වේ.", "හික්කඩුවයි.")
        11 -> Quintuple("කොරල්පර විනාශ වීමට ප්‍රධාන මිනිස් ක්‍රියාකාරකමක් පවසන්න.", "Human activity destroying coral reefs?", listOf("හුණු පුළුස්සන්න කොරල් කැඩීම", "ඩයිනමයිට් ගැසීම"), "හුණු සඳහා කොරල් කැඩීම හා ඩයිනමයිට් යෙදීමයි.", "කොරල් කැඩීමයි.")
        12 -> Quintuple("ප්ලාස්ටික් හා පොලිතීන් නොදිරන අපද්‍රව්‍ය ලෙස පරිසරයට හානි කරයිද?", "Do plastics pollute as non-biodegradable waste?", listOf("ඔව්", "එසේය"), "ඔව්, පසට හා ජලයට දැඩි හානි සිදුකරයි.", "ඔව් වේ.")
        13 -> Quintuple("ශ්‍රී ලංකාවේ වනාන්තර රැකගැනීම සඳහා වන සංරක්ෂණ දෙපාර්තමේන්තුව පිහිටුවා ඇත්ද?", "Is Forest Department established to protect forests?", listOf("ඔව්", "එසේය"), "ඔව්, වන රක්ෂිත ආරක්ෂා කරයි.", "ඔව් වේ.")
        14 -> Quintuple("වනජීවීන් ආරක්ෂා කිරීමට පනවා ඇති නීතිය කුමක්ද?", "Legislation protecting wildlife in Sri Lanka?", listOf("වනසත්ත්ව හා වෘක්ෂලතා ආරක්ෂක ආඥාපනත"), "වනසත්ත්ව හා වෘක්ෂලතා ආරක්ෂක ආඥාපනත වේ.", "වනජීවී ආඥාපනතයි.")
        15 -> Quintuple("ලෝක පරිසර දිනය සමරන්නේ කුමන දිනයේද?", "World Environment Day date?", listOf("ජූනි 5", "ජුනි 5"), "ජූනි 05 වනදාය.", "ජූනි 5යි.")
        16 -> Quintuple("ලෝක ජල දිනය සමරන්නේ කුමන දිනයේද?", "World Water Day date?", listOf("මාර්තු 22", "මාර්තු 22 වනදා"), "මාර්තු 22 වනදාය.", "මාර්තු 22යි.")
        17 -> Quintuple("ලෝක තෙත්බිම් දිනය සමරන්නේ කුමන දිනයේද?", "World Wetlands Day date?", listOf("පෙබරවාරි 2", "පෙබරවාරි 2 වනදා"), "පෙබරවාරි 02 වනදාය.", "පෙබරවාරි 2යි.")
        18 -> Quintuple("පාසල්වල පරිසරය සුරැකීමට පිහිටුවා ඇති ශිෂ්‍ය සමිතිය කුමක්ද?", "School society for environmental conservation?", listOf("පරිසර නියමු භට කණ්ඩායම", "පරිසර සමිතිය"), "පරිසර නියමු භට කණ්ඩායම (Environmental Pioneer) වේ.", "පරිසර සමිතියයි.")
        19 -> Quintuple("නිවසේ අපද්‍රව්‍ය භාවිතයෙන් කොම්පෝස්ට් පොහොර සෑදිය හැකිද?", "Can compost fertilizer be made from kitchen waste?", listOf("ඔව්", "එසේය"), "ඔව්, කාබනික පොහොර සාදාගත හැකිය.", "ඔව් වේ.")
        20 -> Quintuple("පරිසරය රැකගැනීම සෑම ශ්‍රී ලාංකිකයෙකුගේම යුතුකමක්ද?", "Is environmental conservation everyone's duty?", listOf("ඔව්", "එසේය"), "ඔව්, ආණ්ඩුක්‍රම ව්‍යවස්ථාවෙන්ද දැක්වෙන යුතුකමකි.", "ඔව් වේ.")
        else -> Quintuple("ජෛව විවිධත්වය සුරැකීම අනාගත පැවැත්මට අත්‍යවශ්‍යද?", "Is biodiversity vital for future survival?", listOf("ඔව්", "එසේය"), "ඔව්, සමතුලිතතාවට අත්‍යවශ්‍යයි.", "ඔව් වේ.")
      }

      // Set 10: ස්වභාවික ආපදා & පෙරසූදානම
      else -> when (qIndex) {
        1 -> Quintuple("ශ්‍රී ලංකාවේ බහුලවම සිදුවන කාලගුණික ආපදාව කුමක්ද?", "Most common weather hazard in Sri Lanka?", listOf("ගංවතුර", "ජලගැලීම්", "Floods"), "ගංවතුර (Floods) ආපදාව වේ.", "ගංවතුරයි.")
        2 -> Quintuple("අධික වර්ෂාවකදී කැලණි හා කළු ගංගා පිටාර ගැලීමෙන් ගංවතුර ඇතිවේද?", "Do Kelani/Kalu rivers cause floods during heavy rain?", listOf("ඔව්", "එසේය"), "ඔව්, පහත්බිම් යටවේ.", "ඔව් වේ.")
        3 -> Quintuple("දීර්ඝ කාලයක් වැසි නොලැබී යාමෙන් ඇතිවන ආපදාව කුමක්ද?", "Disaster caused by prolonged absence of rain?", listOf("නියඟය", "Drought"), "නියඟය (Drought) වේ.", "නියඟයයි.")
        4 -> Quintuple("ශ්‍රී ලංකාවේ නියඟය වැඩිපුරම බලපාන්නේ තෙත් කලාපයටද වියළි කලාපයටද?", "Does drought affect dry or wet zone most?", listOf("වියළි කලාපයට", "වියළි"), "වියළි කලාපයේ දිස්ත්‍රික්කවලටය.", "වියළි කලාපයටයි.")
        5 -> Quintuple("කඳුකර බෑවුම්වල සිදුවන භූ විද්‍යාත්මක ආපදාව කුමක්ද?", "Geological hazard on hill slopes?", listOf("නායයෑම්", "නාය යෑම", "Landslide"), "නායයෑම් (Landslides) වේ.", "නායයෑම් වේ.")
        6 -> Quintuple("ශ්‍රී ලංකාවේ නායයෑම් අවදානම් අධ්‍යයනය කරන රාජ්‍ය ආයතනය කුමක්ද?", "National agency assessing landslides in Sri Lanka?", listOf("NBRO", "ජාතික ගොඩනැගිලි පර්යේෂණ සංවිධානය"), "ජාතික ගොඩනැගිලි පර්යේෂණ සංවිධානය (NBRO) වේ.", "NBRO ආයතනයයි.")
        7 -> Quintuple("සාගර පත්ලේ භූමිකම්පාවක් නිසා ඇතිවන දැවැන්ත සාගර රළ කුමක්ද?", "Giant ocean wave triggered by underwater earthquake?", listOf("සුනාමි", "Tsunami"), "සුනාමි (Tsunami) රළ වේ.", "සුනාමි රළයි.")
        8 -> Quintuple("ශ්‍රී ලංකාවට සුනාමි ආපදාව බලපෑවේ කුමන වර්ෂයේදීද?", "Which year did tsunami disaster strike Sri Lanka?", listOf("2004", "2004 දී"), "2004 දෙසැම්බර් 26 වනදාය.", "2004 වසරේදීය.")
        9 -> Quintuple("සුනාමි අනතුරු ඇඟවීමක් දුන් වහාම වෙරළබඩ ජනතාව කළ යුත්තේ කුමක්ද?", "What should coastal public do upon tsunami warning?", listOf("උස් බිම්වලට යාම", "වෙරළෙන් ඈත්වීම"), "වහාම වෙරළෙන් ඈත්ව උස් බිම් කරා යාමයි.", "උස් බිම්වලට යාමයි.")
        10 -> Quintuple("අකුණු සැර අනතුරුවලින් ආරක්ෂා වීමට ගොඩනැගිලිවල සවිකරන්නේ මොනවාද?", "Device installed on buildings against lightning?", listOf("අකුණු සන්නායක", "අකුණු සන්නායකය"), "අකුණු සන්නායක (Lightning conductors) වේ.", "අකුණු සන්නායකයි.")
        11 -> Quintuple("ගිගුරුම් සහිත වැසි ඇති විට විවෘත එළිමහනේ සිටීම සුදුසුද?", "Is it safe to stay in open field during thunderstorms?", listOf("නැත", "නුසුදුසුයි"), "නැත, ආරක්ෂිත ගොඩනැගිල්ලක් තුළට යා යුතුය.", "නැත, අනතුරුදායකයි.")
        12 -> Quintuple("සුළි සුළඟක් එන බවට අනතුරු ඇඟවූ විට කළ යුතු ආරක්ෂිත පියවරක් පවසන්න.", "Safety measure upon cyclone warning?", listOf("නිවෙස් තුළ ආරක්ෂිතව සිටීම", "ගස් අතු කැපීම"), "නිවෙස් තුළ රැඳී සිටීම හා අවදානම් ගස් අතු කපා ඉවත් කිරීමයි.", "ආරක්ෂිතව සිටීමයි.")
        13 -> Quintuple("ශ්‍රී ලංකාවේ ආපදා කළමනාකරණය කරන ප්‍රධාන මධ්‍යස්ථානය කුමක්ද?", "Apex disaster management agency in Sri Lanka?", listOf("ආපදා කළමනාකරණ මධ්‍යස්ථානය", "DMC"), "ආපදා කළමනාකරණ මධ්‍යස්ථානය (DMC) වේ.", "ආපදා කළමනාකරණ මධ්‍යස්ථානයයි.")
        14 -> Quintuple("හදිසි ආපදා අවස්ථාවකදී ඇමතිය හැකි කෙටි දුරකථන අංකය කුමක්ද?", "Emergency disaster hotline number in Sri Lanka?", listOf("117", "අංක 117"), "117 ක්ෂණික දුරකථන අංකයයි.", "117 අංකයයි.")
        15 -> Quintuple("ගංවතුර අවස්ථාවකදී පානීය ජලය උණුකර නිවා පානය කළ යුතුද?", "Should drinking water be boiled during floods?", listOf("ඔව්", "එසේය"), "ඔව්, ජලයෙන් බෝවන රෝග වළක්වා ගැනීමටය.", "ඔව් වේ.")
        16 -> Quintuple("ආපදාවකට මුහුණදීමට පෙර සූදානම් කරගත යුතු හදිසි මල්ල කුමක්ද?", "Emergency kit prepared before disasters?", listOf("හදිසි ආපදා මල්ල", "Emergency bag"), "හදිසි ආපදා මල්ල (Emergency kit) වේ.", "හදිසි ආපදා මල්ලයි.")
        17 -> Quintuple("හදිසි මල්ලක තිබිය යුතු අත්‍යවශ්‍ය දෙයක් නම් කරන්න.", "Item essential in emergency bag?", listOf("පළමු ආධාර පෙට්ටිය", "විදුලි පන්දම", "වතුර බෝතලය"), "ප්‍රථමාධාර, විදුලි පන්දම, වතුර හෝ වියළි ආහාර වේ.", "විදුලි පන්දම / ප්‍රථමාධාරයි.")
        18 -> Quintuple("නියඟයෙන් පීඩිත ජනතාවට බවුසර් මඟින් පිරිසිදු පානීය ජලය බෙදාහරීද?", "Is drinking water distributed by bowsers in droughts?", listOf("ඔව්", "එසේය"), "ඔව්, ප්‍රාදේශීය ලේකම් කාර්යාල මඟිනි.", "ඔව් වේ.")
        19 -> Quintuple("ආපදාවකින් පසු විපතට පත් ජනතාවට සහන සැලසීම හඳුන්වන්නේ කෙසේද?", "Relief provided to victims after a disaster?", listOf("ආපදා සහන", "සහන සැලසීම"), "ආපදා සහන සේවා (Disaster relief) නමිනි.", "ආපදා සහනයි.")
        20 -> Quintuple("ආපදා පෙරසූදානම මඟින් මිනිස් ජීවිත හා දේපළ හානි අවම කරගත හැකිද?", "Does disaster preparedness minimize loss of life and property?", listOf("ඔව්", "එසේය"), "ඔව්, ජීවිත හා දේපළ ආරක්ෂා වේ.", "ඔව් වේ.")
        else -> Quintuple("ස්වභාවික විපත්වලදී අනෙකාට පිහිටවීම මනුෂ්‍ය ධර්මයක්ද?", "Is helping others in natural disasters human virtue?", listOf("ඔව්", "එසේය"), "ඔව්, අප සැමගේ යුතුකමකි.", "ඔව් වේ.")
      }
    }
  }
}
