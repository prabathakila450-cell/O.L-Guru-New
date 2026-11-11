package com.example

/**
 * 🏛️ Comprehensive Voice Quiz Bank for History (ඉතිහාසය)
 * Contains 200 distinct, syllabus-aligned oral exam questions across 10 sets of 20 questions each.
 * Every single question is short, direct, curriculum-accurate, non-formula, non-explanatory, and non-repeating.
 */
object VoiceQuizHistoryBank {

  fun getQuestion(grade: String, setNum: Int, qIndex: Int, theme: String): Quintuple<String, String, List<String>, String, String> {
    if (grade == "11") {
      return getGrade11Question(setNum, qIndex, theme)
    }
    val cleanTheme = theme.replace(Regex("^[0-9]+\\.\\s*"), "").trim()

    return when (setNum) {
      // Set 1: ඉතිහාසය හැදෑරීමේ මූලාශ්‍ර
      1 -> when (qIndex) {
        1 -> Quintuple("ලංකාවේ ඉතිහාසය හැදෑරීමට ඇති ප්‍රධානම වංශකතාව කුමක්ද?", "Main chronicle for Sri Lankan history?", listOf("මහාවංශය", "Mahavamsa"), "මහාවංශය වේ.", "ශ්‍රේෂ්ඨතම වංශකතාවයි.")
        2 -> Quintuple("මහාවංශය රචනා කළ මහා තෙරුන් වහන්සේ කවුද?", "Who authored the Mahavamsa?", listOf("මහානාම", "මහානාම හිමි", "Mahanama"), "මහානාම හිමියන්ය.", "දික්සඳ සෙනවියා පිරිවෙනේ වැඩසිටි සේක.")
        3 -> Quintuple("ලංකාවේ දැනට ඇති පැරණිතම වංශකතාව කුමක්ද?", "Oldest extant chronicle in Sri Lanka?", listOf("දීපවංශය", "Deepavamsa"), "දීපවංශය වේ.", "මහාවංශයට පෙර ලියැවුණි.")
        4 -> Quintuple("ගල් ලෙනක කටාරම යට කොටන ලද සෙල්ලිපි හඳුන්වන්නේ කෙසේද?", "Inscriptions carved under cave drip-ledges?", listOf("ලෙන් ලිපි", "බ්‍රාහ්මී ලෙන් ලිපි", "කේව් ඉන්ස්ක්‍රිප්ෂන්"), "ලෙන් ලිපි (බ්‍රාහ්මී ලෙන් ලිපි) නමිනි.", "කටාරම් ලිපි වේ.")
        5 -> Quintuple("මට්ටම් කළ ගල් පුවරුවක ලියන ලද සෙල්ලිපි හඳුන්වන්නේ කෙසේද?", "Inscriptions carved on flat rock slabs?", listOf("පුවරු ලිපි", "පුවරු සෙල්ලිපි", "Slab"), "පුවරු ලිපි (Slab inscriptions) නමිනි.", "මිහින්තලා පුවරු ලිපි උදාහරණයි.")
        6 -> Quintuple("සෘජුකෝණාස්‍රාකාර ගල් කණුවල ලියන ලද සෙල්ලිපි හඳුන්වන්නේ කෙසේද?", "Inscriptions on stone pillars?", listOf("ටැම් ලිපි", "ටැම් සෙල්ලිපි", "Pillar"), "ටැම් ලිපි (Pillar inscriptions) නමිනි.", "බදුලු ටැම් ලිපිය උදාහරණයි.")
        7 -> Quintuple("ශ්‍රී ලංකාවේ මුල්ම සෙල්ලිපි ලියා ඇති අක්ෂර මාලාව කුමක්ද?", "Script used in earliest inscriptions?", listOf("මුල් බ්‍රාහ්මී", "බ්‍රාහ්මී", "Brahmi"), "මුල් බ්‍රාහ්මී අක්ෂර මාලාවයි.", "අශෝක අක්ෂරවලට සමානයි.")
        8 -> Quintuple("වෙළඳ නීති ඇතුළත් ප්‍රකට බදුලු ටැම් ලිපිය පිහිටවූ රජතුමා කවුද?", "Which king erected Badulla pillar inscription?", listOf("උදය", "හතරවන උදය", "Udaya IV"), "හතරවන උදය රජතුමාය.", "බදුල්ලේ හොපිටිගමු වෙළඳපොළ නීතියයි.")
        9 -> Quintuple("ලංකාවේ හමුවන පැරණිතම දේශීය කාසි වර්ගය කුමක්ද?", "Oldest indigenous coins found in Sri Lanka?", listOf("කහවණු", "ඇත් රුව සහිත කාසි", "කහවනු"), "කහවණු (ඇත් රුව සහ ස්වස්තික කාසි) වේ.", "පුරාණ ලක්දිව කාසියකි.")
        10 -> Quintuple("මෙරටට පැමිණි ප්‍රකට මොරොක්කෝ ජාතික දේශාටකයා කවුද?", "Famous Moroccan traveler who visited Ceylon?", listOf("ඉබන් බතූතා", "ඉබ්න් බතූතා", "Ibn Battuta"), "ඉබන් බතූතා (Ibn Battuta) වේ.", "සිරිපා වන්දනාවේ පැමිණියේය.")
        11 -> Quintuple("රොබට් නොක්ස් සිරකරුවෙකුව සිට මෙරට ගැන ලියූ කෘතිය කුමක්ද?", "Robert Knox's book about Sri Lanka?", listOf("එදා හෙළදිව", "Historical Relation"), "එදා හෙළදිව (An Historical Relation of Ceylon) වේ.", "සෙංකඩගල සිරවී සිට ලිවීය.")
        12 -> Quintuple("මහාවංශයේ අර්ථ විවරණය කළ මහාවංශ ටීකාව හඳුන්වන නම කුමක්ද?", "Commentary on Mahavamsa?", listOf("වංසත්ථප්පකාසිනී", "වංසත්ථප්පකාසිනිය"), "වංසත්ථප්පකාසිනිය නමිනි.", "මහාවංශ ටීකාවයි.")
        13 -> Quintuple("සීගිරි කැටපත් පවුරේ ලියා ඇති ගී හඳුන්වන්නේ කෙසේද?", "Verses written on Sigiriya Mirror Wall?", listOf("කුරුටු ගී", "සීගිරි කුරුටු ගී"), "සීගිරි කුරුටු ගී නමිනි.", "පැරණි සිංහල කාව්‍යයයි.")
        14 -> Quintuple("සීගිරි කුරුටු ගී කියවා අර්ථ දැක්වූ ශ්‍රේෂ්ඨ පුරාවිද්‍යාඥයා කවුද?", "Archaeologist who deciphered Sigiri graffiti?", listOf("සෙනරත් පරණවිතාන", "පරණවිතාන"), "මහාචාර්ය සෙනරත් පරණවිතාන මහතාය.", "පුරාවිද්‍යා කොමසාරිස්වරයාය.")
        15 -> Quintuple("පැරණි රජවරුන් ඉඩම් ප්‍රදානය කිරීමේදී ලබාදුන් ලෝහමය ලේඛනය කුමක්ද?", "Metal plate records granting land by kings?", listOf("තඹ සන්නස්", "සන්නස", "සන්නස්"), "තඹ සන්නස් (තඹ පත් ඉරු) වේ.", "රාජකීය ලියවිල්ලකි.")
        16 -> Quintuple("දඹදෙණි යුගයේ පූජාවලිය ග්‍රන්ථය රචනා කළ හිමියන් කවුද?", "Author of Pujavaliya in Dambadeniya era?", listOf("මයුරපාද", "බුද්ධපුත්‍ර", "මයුරපාද බුද්ධපුත්‍ර"), "මයුරපාද පරිවේණාධිපති බුද්ධපුත්‍ර හිමියන්ය.", "දෙවන පරාක්‍රමබාහු රජ දවසය.")
        17 -> Quintuple("විජය කුමරුගේ සිට සෙංකඩගල දක්වා රජ පෙළපත දැක්වෙන කෘතිය කුමක්ද?", "Chronicle detailing kings from Vijaya to Kandy?", listOf("රාජාවලිය", "Rajavaliya"), "රාජාවලිය ග්‍රන්ථය වේ.", "ඓතිහාසික ලේඛනයකි.")
        18 -> Quintuple("පැරණි කාසි පිළිබඳ විද්‍යාත්මකව හැදෑරීම හඳුන්වන්නේ කෙසේද?", "Study of ancient coins?", listOf("නාණක විද්‍යාව", "Numismatics"), "නාණක විද්‍යාව (Numismatics) නමිනි.", "කාසි අධ්‍යයනයයි.")
        19 -> Quintuple("පාහියන් හිමියන් ලංකාවට පැමිණියේ කුමන රටේ සිටද?", "From which country did Monk Faxian arrive?", listOf("චීනය", "චීනයේ සිට", "China"), "චීන දේශයේ සිටය.", "අභයගිරියේ වැඩසිටියේය.")
        20 -> Quintuple("පෘතුගීසි යුගයේ ලංකාව පිළිබඳ තොරතුරු ලියූ පෘතුගීසි ලේඛකයා කවුද?", "Portuguese historian who wrote about Ceylon?", listOf("ක්වේරෝස්", "ෆර්නාවෝ ඩි ක්වේරෝස්"), "ෆර්නාවෝ ඩි ක්වේරෝස් පියතුමාය.", "පෘතුගීසි ආක්‍රමණ විස්තර කළේය.")
        else -> Quintuple("ඉතිහාසය හැදෑරීමේ ප්‍රධාන මූලාශ්‍ර වර්ග 2 මොනවාද?", "Two main types of historical sources?", listOf("සාහිත්‍ය", "පුරාවිද්‍යා", "සාහිත්‍ය හා පුරාවිද්‍යා"), "සාහිත්‍ය මූලාශ්‍ර සහ පුරාවිද්‍යා මූලාශ්‍ර වේ.", "මූලාශ්‍ර වර්ග දෙකයි.")
      }

      // Set 2: ප්‍රාග් ඓතිහාසික හා මූල ඓතිහාසික යුගය
      2 -> when (qIndex) {
        1 -> Quintuple("ලංකාවේ විසූ ප්‍රාග් ඓතිහාසික මානවයා හඳුන්වන නම කුමක්ද?", "Prehistoric human of Sri Lanka?", listOf("බලංගොඩ මානවයා", "Balangoda man"), "බලංගොඩ මානවයා (Homo sapiens balangodensis) වේ.", "ආදි මානවයාය.")
        2 -> Quintuple("බලංගොඩ මානවයාගේ පැරණිතම ඇටසැකිලි හමුවූ කළුතර දිස්ත්‍රික්කයේ ලෙන කුමක්ද?", "Cave in Kalutara where Balangoda man was found?", listOf("පාහියන්ගල", "පාහියන් ලෙන", "Fa-hien"), "පාහියන්ගල ලෙන (බුලත්සිංහල) වේ.", "විශාලතම ස්වභාවික ලෙනයි.")
        3 -> Quintuple("ලංකාවේ ප්‍රාග් මානවයා භාවිත කළ ප්‍රධාන ගල් මෙවලම් මොනවාද?", "Stone tools used by prehistoric humans?", listOf("ක්ෂුද්‍ර ශිලා", "ක්ෂුද්‍ර ශිලා මෙවලම්", "Microliths"), "ක්ෂුද්‍ර ශිලා මෙවලම් (Microliths) වේ.", "කුඩා තියුණු ගල් ආයුධයි.")
        4 -> Quintuple("ලංකාවේ ප්‍රකට මහා ශිලා සුසාන භූමිය පිහිටා ඇත්තේ කොහේද?", "Famous megalithic burial site in Sri Lanka?", listOf("ඉබ්බන්කටුව", "Ibbankatuwa"), "ඉබ්බන්කටුව (දඹුල්ල අසල) වේ.", "මහා ශිලා සුසාන භූමියයි.")
        5 -> Quintuple("ඉබ්බන්කටුව සුසාන භූමිය පිහිටා ඇත්තේ කුමන දිස්ත්‍රික්කයේද?", "Which district is Ibbankatuwa located in?", listOf("මාතලේ", "මාතලේ දිස්ත්‍රික්කය"), "මාතලේ දිස්ත්‍රික්කයේය.", "දඹුල්ල නගරය ආසන්නයේය.")
        6 -> Quintuple("ප්‍රාග් මානවයා සිරුරු මිහිදන් කළ මැටි බඳුන් හඳුන්වන්නේ කෙසේද?", "Clay burial urns of protohistoric era?", listOf("මිනී වළං", "මැටි මිනී වළං", "Burial urns"), "මැටි මිනී වළං (Cist burials) නමිනි.", "අඟුරු හා අස්ථි තැන්පත් කළ වළංය.")
        7 -> Quintuple("ප්‍රාග් මානවයා ගින්දර නිපදවා ගැනීමට එකිනෙක ගැටූ ගල් වර්ගය කුමක්ද?", "Stone used to produce fire by striking?", listOf("චර්ට්", "ක්වාර්ට්ස්", "චර්ට් හා ක්වාර්ට්ස්"), "චර්ට් සහ ක්වාර්ට්ස් (තිරිවාණ) ගල් වේ.", "ගිනි ගල්ය.")
        8 -> Quintuple("බලංගොඩ මානවයාගේ විද්‍යාත්මක නාමය කුමක්ද?", "Scientific name of Balangoda man?", listOf("Homo sapiens", "හෝමෝ සේපියන්ස්"), "හෝමෝ සේපියන්ස් බලංගොඩෙන්සිස් වේ.", "නූතන මිනිසාට අයත්ය.")
        9 -> Quintuple("ලංකාවේ එළිමහන් ප්‍රාග් ඓතිහාසික වාසස්ථානයක් හමුවූ ස්ථානය කුමක්ද?", "Open-air prehistoric habitat site?", listOf("බෙල්ලන්බැඳිපැලැස්ස", "Bellanbandipalassa"), "බෙල්ලන්බැඳිපැලැස්ස (ඇඹිලිපිටිය අසල) වේ.", "එළිමහන් ජනාවාසයකි.")
        10 -> Quintuple("ලංකාවේ මුල්ම යකඩ තාක්ෂණය ආරම්භ වූ යුගය කුමක්ද?", "Era when iron technology began in Sri Lanka?", listOf("මුල් යකඩ යුගය", "යකඩ යුගය", "Early Iron Age"), "මුල් යකඩ යුගය (ක්‍රි.පූ. 1000 - 900 පමණ) වේ.", "ලෝහ යුගයයි.")
        11 -> Quintuple("හෝර්ටන් තැන්නෙන් ලැබුණු පරාග සාධක මඟින් තහවුරු වන්නේ කුමක්ද?", "What do Horton Plains pollen samples prove?", listOf("වගා කිරීම", "ධාන්‍ය වගාව", "ඕට්ස්"), "ප්‍රාග් මානවයා ධාන්‍ය (ඕට්ස්, බාර්ලි) වගා කළ බවයි.", "කෘෂිකාර්මික ආරම්භයයි.")
        12 -> Quintuple("ප්‍රාග් මානවයා ආභරණ ලෙස භාවිත කළේ මොනවාද?", "Jewelry used by prehistoric humans?", listOf("බෙලි කටු", "සත්ත්ව දත්", "ඇටකටු"), "මුහුදු බෙලි කටු සහ සත්ත්ව දත්-ඇටකටු වේ.", "ස්වභාවික ආභරණයි.")
        13 -> Quintuple("කූරගල ප්‍රාග් ඓතිහාසික ලෙන් පිහිටියේ කුමන දිස්ත්‍රික්කයේද?", "Kuragala prehistoric cave district?", listOf("රත්නපුර", "රත්නපුරය"), "රත්නපුර දිස්ත්‍රික්කයේ (බලංගොඩ) ය.", "කූරගල ලෙනයි.")
        14 -> Quintuple("මෝසම් සුළං භාවිත කර යකඩ උණු කළ පාරම්පරික උදුන් හමුවූයේ කොහෙන්ද?", "Wind-powered iron smelting furnaces site?", listOf("සමනලවැව", "Samanalawewa"), "සමනලවැව ප්‍රදේශයෙනි.", "ස්වභාවික සුළං බලය යෙදූ උදුන්ය.")
        15 -> Quintuple("මූල ඓතිහාසික යුගයේ දී භාවිත කළ ද්විවර්ණ මැටි බඳුන් මොනවාද?", "Two-color pottery of protohistoric era?", listOf("කළු සහ රතු", "BRW", "Black and red"), "කළු සහ රතු මැටි බඳුන් (Black and Red Ware) වේ.", "විශේෂ පිලිස්සුම් තාක්ෂණයකි.")
        16 -> Quintuple("අනුරාධපුර ඇතුළු නුවරින් පැරණි බ්‍රාහ්මී අක්ෂර සාධක සොයාගත් පුරාවිද්‍යාඥයා කවුද?", "Archaeologist who found early Brahmi in Anuradhapura?", listOf("සිරාන් දැරණියගල", "දැරණියගල"), "ආචාර්ය සිරාන් දැරණියගල මහතාය.", "ක්‍රි.පූ. 5 වන සියවසට අයත්ය.")
        17 -> Quintuple("කෑගල්ල වරකාපොළ පිහිටි ප්‍රාග් ඓතිහාසික ලෙන කුමක්ද?", "Prehistoric cave in Warakapola Kegalle?", listOf("දොරවකලෙන", "දොරවක ලෙන"), "දොරවකලෙන (දොරවක කන්ද) වේ.", "පැරණි ලෙන් වාසස්ථානයකි.")
        18 -> Quintuple("බලංගොඩ මානවයා තම මියගිය අයගේ සිරුරු මත ආලේප කළේ කුමක්ද?", "Substance smeared on dead bodies by Balangoda man?", listOf("ගුරුගල්", "රතු ගුරුගල්", "Red ochre"), "රතු ගුරුගල් (Red ochre) වේ.", "ආගමික විශ්වාසයක් ලෙසය.")
        19 -> Quintuple("ලංකාවේ ප්‍රාග් ඓතිහාසික යුගයේ ප්‍රධාන යැපුම් මාර්ගය කුමක්ද?", "Main livelihood of prehistoric era?", listOf("දඩයම් කිරීම", "අල බතල සෙවීම", "දඩයම"), "සතුන් දඩයම් කිරීම සහ අල-පලවැල එක්රැස් කිරීමයි.", "දඩයම් යුගයයි.")
        20 -> Quintuple("බටදොඹලෙන පිහිටා ඇත්තේ කුමන නගරය ආසන්නයේද?", "Batadombalena cave near which town?", listOf("කුරුවිට", "රත්නපුර", "Kuruwita"), "කුරුවිට (රත්නපුර) ආසන්නයේය.", "ප්‍රකට ප්‍රාග් ඓතිහාසික ලෙනකි.")
        else -> Quintuple("බලංගොඩ මානවයාගේ ප්‍රධාන වාසස්ථානය කුමක්ද?", "Primary habitat of Balangoda man?", listOf("ගල් ලෙන්", "ලෙන්"), "ස්වභාවික ගල් ලෙන් වේ.", "ලෙන් වාසස්ථානයි.")
      }

      // Set 3: ජනාවාස ව්‍යාප්තිය & මුල්කාලීන ග්‍රාමීය සමාජය
      3 -> when (qIndex) {
        1 -> Quintuple("විජය කුමරු ලක්දිවට සම්ප්‍රාප්ත වූ ස්ථානය කුමක්ද?", "Where did Prince Vijaya land in Sri Lanka?", listOf("තම්බපණ්ණි", "තම්බපණ්ණිය", "Tambapanni"), "තම්බපණ්ණිය (මන්නාරම ආසන්නයේ) වේ.", "තඹවන් අත්ල පිහිටි වෙරළයි.")
        2 -> Quintuple("විජය කුමරුට ලක්දිවදී මුණගැසුණු යක්ෂ ගෝත්‍රික කුමරිය කවුද?", "Yakkha princess met by Vijaya?", listOf("කුවේණි", "කුවේණිය", "Kuveni"), "කුවේණි කුමරියයි.", "කපු කටිමින් සිටියාය.")
        3 -> Quintuple("මුල්ම ආර්ය ජනාවාස ගොඩනැඟුණේ කුමන ගංගා නිම්නය ආශ්‍රිතවද?", "River valley where earliest Aryan settlements arose?", listOf("මල්වතු ඔය", "දැදුරු ඔය", "කලා ඔය"), "මල්වතු ඔය නිම්නය ආශ්‍රිතවය.", "ජලය හා සරු පස නිසාවෙනි.")
        4 -> Quintuple("අනුරාධ ඇමතිවරයා පිහිටවූ මුල්ම ග්‍රාමය කුමක්ද?", "Earliest village established by minister Anuradha?", listOf("අනුරාධගාම", "අනුරාධගාමය"), "අනුරාධගාමය වේ.", "පසු කලෙක අනුරාධපුරය විය.")
        5 -> Quintuple("උපතිස්ස ඇමතිවරයා පිහිටවූ මුල්ම ග්‍රාමය කුමක්ද?", "Village established by minister Upatissa?", listOf("උපතිස්සගාම", "උපතිස්සගාමය"), "උපතිස්සගාමය වේ.", "මල්වතු ඔය අසලය.")
        6 -> Quintuple("මුල්කාලීන සෙල්ලිපිවල සඳහන් වන ගමේ නායකයා හැඳින්වූයේ කෙසේද?", "Village chieftain title in early inscriptions?", listOf("ගාමණී", "ගමිණි", "Gamani"), "ගාමණී (ගමිණි) නමිනි.", "ගමේ ප්‍රධානියාය.")
        7 -> Quintuple("මුල් යුගයේ ගෝත්‍රික නායකයන් හැඳින්වූ ගෞරව නාමය කුමක්ද?", "Honorific title for tribal elites in early era?", listOf("පරුමක", "ප්‍රමුඛ", "Parumaka"), "පරුමක (ප්‍රමුඛ) නමිනි.", "සෙල්ලිපිවල බහුලව දක්නට ලැබේ.")
        8 -> Quintuple("වියළි කලාපයේ කුඩා වැව් දාමයක් එකිනෙක සම්බන්ධ වූ පද්ධතිය කුමක්ද?", "Interconnected cascading tank system in dry zone?", listOf("එල්ලංගා පද්ධතිය", "එල්ලංගාව", "Cascade"), "එල්ලංගා වැව් පද්ධතිය (Cascade system) වේ.", "ජල කළමනාකරණ විස්මයකි.")
        9 -> Quintuple("එල්ලංගා පද්ධතියේ රොන්මඩ පෙරීමට ඉහළින් තැනූ කුඩා වැව කුමක්ද?", "Small uppermost silt trap tank in cascade?", listOf("කුළු වැව", "කුළුවැව"), "කුළු වැව නමිනි.", "රොන්මඩ පහළට ඒම වළකයි.")
        10 -> Quintuple("පැරණි ගැමි සමාජයේ ප්‍රධාන ජීවනෝපාය වූයේ කුමක්ද?", "Main livelihood of ancient rural society?", listOf("වී ගොවිතැන", "ගොවිතැන", "කෘෂිකර්මය"), "වී ගොවිතැන (කුඹුරු ගොවිතැන) වේ.", "ප්‍රධාන ආහාර බෝගයයි.")
        11 -> Quintuple("ගැමියන් එකිනෙකාට උදව් කරගනිමින් කුඹුරු වැඩ කළ ක්‍රමය කුමක්ද?", "Mutual labour sharing system in farming?", listOf("කයිය", "අත්තම", "අත්තම ක්‍රමය"), "කයිය හෙවත් අත්තම ක්‍රමයයි.", "සාමූහික ශ්‍රම හුවමාරුවයි.")
        12 -> Quintuple("වැවෙන් ජලය නිකුත් කරන ප්‍රධාන තාක්ෂණික දොරටුව කුමක්ද?", "Main sluice gate releasing water from tank?", listOf("සොරොව්ව", "Sluice"), "සොරොව්ව (ගොඩ සොරොව්ව / මඩ සොරොව්ව) වේ.", "ජලය කුඹුරුවලට මුදාහරියි.")
        13 -> Quintuple("වැව අධික වැස්සෙන් පිරීගිය විට පිටාර ජලය බැසයන ස්ථානය කුමක්ද?", "Spillway where excess water overflows?", listOf("පිටවාන", "Spill"), "පිටවාන (Spillway) වේ.", "වැව් බැම්ම කැඩීයාම වළකයි.")
        14 -> Quintuple("වැව් බැම්ම රළ පහරින් සේදීයාම වැළැක්වීමට ඇල්ලූ ගල් තට්ටුව කුමක්ද?", "Stone pitching protecting bund from wave action?", listOf("රළපනාව", "Ralapanawa"), "රළපනාව නමිනි.", "ගල් අතුරා කළ ආරක්ෂාවයි.")
        15 -> Quintuple("වැවෙන් ජලය ගැනීම වෙනුවෙන් පුරාණයේ අය කළ බද්ද කුමක්ද?", "Ancient water tax charged for tank water?", listOf("දියබදු", "දකපති", "දිය බද්ද"), "දකපති හෙවත් දියබදු වේ.", "ජල බද්දයි.")
        16 -> Quintuple("ඉඩම් භුක්තිය වෙනුවෙන් අය කළ බද්ද හඳුන්වන්නේ කෙසේද?", "Tax charged for land tenure?", listOf("බොජකපති", "භෝජකපති"), "බොජකපති (භෝජකපති) නමිනි.", "ඉඩම් බද්දයි.")
        17 -> Quintuple("පැරණි ගමේ ආරවුල් විසඳූ පරිපාලන ආයතනය කුමක්ද?", "Ancient village dispute resolving assembly?", listOf("ගම් සභාව", "ගම්සභාව"), "ගම් සභාව වේ.", "ගම්වැසියන්ගේ සභාවයි.")
        18 -> Quintuple("වී ගබඩා කිරීමට ගැමියන් නිවෙස්වල තනාගත් ව්‍යුහය කුමක්ද?", "Traditional paddy storage structure?", listOf("බිස්ස", "වී බිස්ස"), "වී බිස්ස වේ.", "අස්වැන්න කෘමීන්ගෙන් සුරකියි.")
        19 -> Quintuple("පැරණි ගැමි සමාජයේ ආගමික හා අධ්‍යාපනික කේන්ද්‍රස්ථානය කුමක්ද?", "Religious and educational center in ancient village?", listOf("පන්සල", "ගමේ පන්සල", "විහාරය"), "ගමේ පන්සල (විහාරස්ථානය) වේ.", "ගමේ පහන් ටැඹයි.")
        20 -> Quintuple("ශ්‍රී ලාංකික බෞද්ධ සංස්කෘතිය හැඳින්වෙන ජනප්‍රිය කියමන කුමක්ද?", "Famous saying describing Sri Lankan hydraulic civilization?", listOf("වැවයි දාගැබයි", "ගමයි පන්සලයි"), "'වැවයි දාගැබයි - ගමයි පන්සලයි' යන්නයි.", "අපේ උරුමයයි.")
        else -> Quintuple("මුල්කාලීන ලක්දිව ග්‍රාමීය සමාජයේ පදනම කුමක්ද?", "Foundation of early rural society?", listOf("කෘෂිකර්මය", "වැව"), "වැව මුල් කරගත් කෘෂිකර්මාන්තයයි.", "වාරි ශිෂ්ටාචාරයයි.")
      }

      // Set 4: මුල් ඓතිහාසික යුගයේ දේශපාලන සංවිධානය (පණ්ඩුකාභය රජු)
      4 -> when (qIndex) {
        1 -> Quintuple("අනුරාධපුරය ලංකාවේ අගනුවර බවට පත්කළ ප්‍රථම රජතුමා කවුද?", "First king to make Anuradhapura the capital?", listOf("පණ්ඩුකාභය", "පණ්ඩුකාභය රජු", "Pandukabhaya"), "පණ්ඩුකාභය රජතුමාය.", "නගර සැලසුම් කළ රජුය.")
        2 -> Quintuple("පණ්ඩුකාභය කුමරුගේ දෙමව්පියන් කවුරුන්ද?", "Who were Prince Pandukabhaya's parents?", listOf("දීඝගාමිණී", "උන්මාද චිත්‍රා"), "දීඝගාමිණී කුමරු සහ උන්මාද චිත්‍රා කුමරියයි.", "පණ්ඩුවාසදේව රජුගේ මුණුබුරාය.")
        3 -> Quintuple("උන්මාද චිත්‍රා කුමරිය වාසය කිරීමට එක්ටැම් ගෙයක් තැනවූයේ ඇයි?", "Why was Unmada Chitra kept in a one-pillar chamber?", listOf("මාමාවරුන් මරන බවට අනාවැකිය", "අනාවැකිය"), "ඇයට උපදින පුතා මාමාවරුන් මරා රජවන බවට කළ අනාවැකිය නිසාය.", "රාජකීය අනාවැකියයි.")
        4 -> Quintuple("පණ්ඩුකාභය කුමරු කුඩා කල සැඟවී හැදී වැඩුණු ග්‍රාමය කුමක්ද?", "Village where child Pandukabhaya grew up in hiding?", listOf("දොරමඩලාව", "දොරමඩලාව ගම"), "දොරමඩලාව ගමේදීය.", "ගවයන් බලාගන්නා ගොපල්ලන් සමඟය.")
        5 -> Quintuple("පණ්ඩුකාභය කුමරුට ශිල්ප ශාස්ත්‍ර හා ධනය ලබාදුන් ධනවත් බ්‍රාහ්මණයා කවුද?", "Wealthy Brahmin tutor of Pandukabhaya?", listOf("පණ්ඩුල", "පණ්ඩුල බමුණා", "Pandula"), "පණ්ඩුල බ්‍රාහ්මණයාය.", "කුමරුට යුද ශිල්ප ඉගැන්වීය.")
        6 -> Quintuple("පණ්ඩුල බමුණාගේ පුත් පණ්ඩුකාභයගේ මිතුරා වූයේ කවුද?", "Pandula Brahmin's son and Pandukabhaya's friend?", listOf("චන්ද්‍ර", "චන්ද්‍ර කුමරු", "Chandra"), "චන්ද්‍ර කුමරු (පසු කලෙක පුරෝහිත) වේ.", "කුමරුගේ ප්‍රධාන සගයාය.")
        7 -> Quintuple("පණ්ඩුකාභය කුමරු කුඹුරකදී හමුවී විවාහ කරගත් කුමරිය කවුද?", "Princess whom Pandukabhaya married?", listOf("ස්වර්ණපාලී", "ස්වර්ණපාලි", "Swarnapali"), "ස්වර්ණපාලී කුමරියයි.", "ගිරිකණ්ඩශිවගේ දියණියයි.")
        8 -> Quintuple("පණ්ඩුකාභය රජු අනුරාධපුරයේ ඉදිකළ පැරණිතම ඓතිහාසික වැව කුමක්ද?", "Oldest historical reservoir built by Pandukabhaya in Anuradhapura?", listOf("බසවක්කුලම", "අභය වැව", "Basawakkulama"), "බසවක්කුලම වැව (අභය වැව) වේ.", "නගර වැවයි.")
        9 -> Quintuple("අනුරාධපුර නගර පාලනය සඳහා පණ්ඩුකාභය රජු ඇතිකළ තනතුර කුමක්ද?", "City administration post created by Pandukabhaya?", listOf("නගර ගුත්තික", "නගරගුත්තික", "Nagara guttika"), "නගර ගුත්තික (නගරාධිපති) තනතුරයි.", "මුල්ම නගරාධිපති තනතුරයි.")
        10 -> Quintuple("නගර ගුත්තික තනතුර පණ්ඩුකාභය රජු මුලින්ම පිරිනැමුවේ කාටද?", "Whom did Pandukabhaya appoint as the first Nagara Guttika?", listOf("අභය", "අභය කුමරු", "Abhaya"), "අභය ජ්‍යෙෂ්ඨ මාමා කුමරුටය.", "තමාට දයාව දැක්වූ මාමාටය.")
        11 -> Quintuple("අනුරාධපුර නගරයේ සනීපාරක්ෂාව සඳහා රජු යෙදවූ පිරිස කීයක්ද?", "Sanitation workforce employed in ancient Anuradhapura?", listOf("500", "පන්සියයක්", "500ක්"), "චණ්ඩාලයන් පන්සියයක් (500ක්) යෙදවීය.", "පිරිසිදු කිරීමේ සේවයයි.")
        12 -> Quintuple("පණ්ඩුකාභය රජු තම මාමාවරුන් සමඟ තීරණාත්මක සටන කළ ස්ථානය කුමක්ද?", "Battlefield where Pandukabhaya defeated his uncles?", listOf("ලබුනෝරුව", "ලබුනෝරුව කඳවුර"), "ලබුනෝරුව කඳවුරේදීය.", "කහඹිලියා සටනයි.")
        13 -> Quintuple("ලංකාවේ ගම්වල සීමා මායිම් මුලින්ම නීත්‍යානුකූලව ලකුණු කළ රජු කවුද?", "King who first demarcated village boundaries in Sri Lanka?", listOf("පණ්ඩුකාභය", "පණ්ඩුකාභය රජු"), "පණ්ඩුකාභය රජතුමාය.", "පරිපාලන විප්ලවයකි.")
        14 -> Quintuple("පණ්ඩුකාභය රජු ඉදිකළ තවත් ප්‍රකට වැවක් නම් කරන්න.", "Another reservoir built by Pandukabhaya?", listOf("ජය වැව", "ගාමිණී වැව"), "ජය වැව (හෝ ගාමිණී වැව) වේ.", "නගර ජලාශයකි.")
        15 -> Quintuple("පණ්ඩුකාභය රජු අනුරාධපුරය පාලනය කළ වසර ගණන කීයද?", "How many years did Pandukabhaya rule?", listOf("70ක්", "අවුරුදු 70", "70"), "වසර 70ක් (අවුරුදු හැත්තෑවක්) රජකම් කළේය.", "දීර්ඝ පාලන කාලයකි.")
        16 -> Quintuple("අනුරාධපුරය ලංකාවේ අගනුවර ලෙස වසර කීයක් පැවතුනේද?", "How many years was Anuradhapura the capital?", listOf("1400", "1400කට වැඩි", "1500"), "වසර 1400කට අධික කාලයක් පැවතුනි.", "දීර්ඝතම අගනුවරයි.")
        17 -> Quintuple("පණ්ඩුකාභය රජුගෙන් පසු රජවූ ඔහුගේ පුත් කුමරු කවුද?", "Pandukabhaya's son who succeeded him as king?", listOf("මුටසීව", "මුටසීව රජු", "Mutasiva"), "මුටසීව රජතුමාය.", "මහමෙවුනා උයන කරවූ රජුය.")
        18 -> Quintuple("මුටසීව රජු ඉදිකළ රාජකීය උයන කුමක්ද?", "Royal pleasure park created by King Mutasiva?", listOf("මහමෙවුනා", "මහාමේඝවන", "Mahamevnawa"), "මහමෙවුනා උයන (මහාමේඝවන) වේ.", "මිහිඳු හිමියන්ට පූජා කළ උයනයි.")
        19 -> Quintuple("පණ්ඩුකාභය රජු සටනේදී නැඟී ගිය සුදු වෙළඹගේ නම කුමක්ද?", "Mare ridden by Pandukabhaya in battle?", listOf("චේතිය", "චේතියා", "Chethiya"), "චේතියා වෙළඹ (චේතෝරූපී යක්ෂණිය) ය.", "සුදු වෙළඹකි.")
        20 -> Quintuple("අනුරාධපුර නගරයේ සිව් දිශාවට දොරටු සතරක් මුලින්ම ඉදිකළේ කවුද?", "Who built four gates in four directions of Anuradhapura?", listOf("පණ්ඩුකාභය", "පණ්ඩුකාභය රජු"), "පණ්ඩුකාභය රජතුමාය.", "විධිමත් නගර සැලසුම්කරණයයි.")
        else -> Quintuple("පණ්ඩුකාභය රජුගේ ප්‍රධාන මෙහෙවර කුමක්ද?", "Main legacy of King Pandukabhaya?", listOf("අනුරාධපුරය අගනුවර කිරීම", "නගර සැලසුම්"), "අනුරාධපුරය සැලසුම්සහගත අගනුවරක් බවට පත්කිරීමයි.", "රාජ්‍ය සංවිධායකයාය.")
      }

      // Sets 5 & 6 (already filled in detail)
      5 -> when (qIndex) {
        1 -> Quintuple("ශ්‍රී ලංකාවට බුදුදහම නිල වශයෙන් හඳුන්වා දුන් රජතුමා කවුද?", "Which king officially received Buddhism in Sri Lanka?", listOf("දේවානම්පියතිස්ස", "තිස්ස රජු", "Devanampiyatissa"), "දේවානම්පියතිස්ස රජතුමාය.", "අශෝක අධිරාජ්‍යයාගේ කල්‍යාණ මිත්‍රයාය.")
        2 -> Quintuple("මිහිඳු මහ රහතන් වහන්සේ ලක්දිවට වැඩම කළ ඓතිහාසික ස්ථානය කුමක්ද?", "Where did Arhat Mahinda arrive in Sri Lanka?", listOf("මිහින්තලය", "මිහින්තලා", "අම්බස්ථලය", "Mihintale"), "මිහින්තලා පව්ව (අම්බස්ථලය) වේ.", "පොසොන් පොහෝ දින වැඩම කළ ස්ථානයයි.")
        3 -> Quintuple("ලංකාවේ ඉදිකළ ප්‍රථම ඓතිහාසික ධාතු ස්තූපය කුමක්ද?", "What was the first historical stupa built in Sri Lanka?", listOf("ථූපාරාමය", "Thuparama"), "ථූපාරාම චෛත්‍යය වේ.", "දකුණු අකුධාතුව තැන්පත් කර ඇත.")
        4 -> Quintuple("දේවානම්පියතිස්ස රජුගේ දෙවන අභිෂේකය සඳහා රාජකීය භාණ්ඩ එවන ලද්දේ කා විසින්ද?", "Who sent royal regalia for Devanampiyatissa's second coronation?", listOf("අශෝක", "ධර්මාශෝක", "Asoka"), "ධර්මාශෝක අධිරාජ්‍යයා විසිනි.", "මෞර්ය අධිරාජ්‍යයාය.")
        5 -> Quintuple("ශ්‍රී මහා බෝධීන් වහන්සේ ලක්දිවට වැඩම කරවූයේ කවුරුන්ද?", "Who brought the Sri Maha Bodhi to Sri Lanka?", listOf("සංඝමිත්තා", "සංඝමිත්තා තෙරණිය", "Sanghamitta"), "සංඝමිත්තා මහා රහත් තෙරණියයි.", "මිහිඳු හිමියන්ගේ නැගණියයි.")
        6 -> Quintuple("ලක්දිව භික්ෂුණී ශාසනය ආරම්භ කරමින් මුලින්ම පැවිදි වූ කාන්තාව කවුද?", "First Sri Lankan woman ordained as Buddhist nun?", listOf("අනුලා", "අනුලා බිසව", "Anula"), "අනුලා බිසව (අනුලා දේවිය) වේ.", "මහානාග යුවරජුගේ බිසවයි.")
        7 -> Quintuple("දේවානම්පියතිස්ස රජු මහා විහාරය පිහිටුවීම සඳහා පූජා කළ රාජකීය උයන කුමක්ද?", "Which royal pleasure garden was donated to establish Mahavihara?", listOf("මහමෙවුනා", "මහමෙවුනාව", "Mahamevnawa"), "මහමෙවුනා උයන (මහාමේඝවන) වේ.", "අනුරාධපුර මහා විහාර භූමියයි.")
        8 -> Quintuple("මිහිඳු හිමියන් ලක්දිවදී දේශනා කළ ප්‍රථම සූත්‍ර දේශනාව කුමක්ද?", "What was the first sermon preached by Mihindu Thero in Sri Lanka?", listOf("චූලහත්ථිපදෝපම", "චූලහත්ථිපදෝපම සූත්‍රය"), "චූලහත්ථිපදෝපම සූත්‍රය වේ.", "ඇත් පාදයේ උපමාවයි.")
        9 -> Quintuple("මිහිඳු හිමියන් රජුගේ ඥාන ශක්තිය පරීක්ෂා කිරීමට ඇසූ ප්‍රසිද්ධ පැනය කුමක් ආශ්‍රිතද?", "Riddle asked by Mihindu Thero to test the king's intellect?", listOf("අඹ ගස", "අඹ", "Mango"), "අඹ ගස හා ඥාතීන් පිළිබඳ ප්‍රශ්නාවලියයි.", "අඹ ප්‍රශ්නයයි.")
        10 -> Quintuple("ථූපාරාම දාගැබේ තැන්පත් කර ඇති බුදුරදුන්ගේ ශාරීරික ධාතුව කුමක්ද?", "Which bodily relic is enshrined in Thuparama?", listOf("දකුණු අකුධාතුව", "අකුධාතුව"), "දකුණු අකුධාතූන් වහන්සේය.", "සුමන සාමණේරයන් වැඩම කළ සේක.")
        11 -> Quintuple("සංඝමිත්තා තෙරණිය සමඟ මෙරටට සම්ප්‍රාප්ත වූ කාර්මික හා ශිල්පීය කුල ගණන කීයද?", "How many artisan guilds arrived with Sanghamitta?", listOf("18ක්", "අටළොස් කුලය", "18"), "අටළොස් කුලයක ශිල්පීන් පිරිසකි.", "ලංකාවේ කලාව හා කර්මාන්ත දියුණු කළහ.")
        12 -> Quintuple("දේවානම්පියතිස්ස රජු මිහින්තලයේ භික්ෂූන් උදෙසා සකස් කළ ලෙන් සංඛ්‍යාව කීයද?", "Number of caves prepared by the king at Mihintale?", listOf("68", "හැට අටක්", "අටසැට ලෙන්"), "අටසැට ලෙන් (ලෙන් 68ක්) වේ.", "කණ්ඨක චෛත්‍යය අසල ලෙන්ය.")
        13 -> Quintuple("ශ්‍රී මහා බෝධීන් වහන්සේ වැඩමවූ නැව ගොඩබට ඓතිහාසික වරාය කුමක්ද?", "Port where the ship carrying Bodhi sapling landed?", listOf("දඹකොළපටුන", "දඹකොළ පටුන", "Jambukola"), "දඹකොළපටුන වරාය (ජම්බුකෝලපට්ටන) වේ.", "යාපනය අර්ධද්වීපයේ පිහිටා ඇත.")
        14 -> Quintuple("දේවානම්පියතිස්ස රජු තම දූත පිරිසේ ප්‍රධානියා ලෙස අශෝක රජු වෙත යැවූ ඇමති කවුද?", "Chief envoy sent to King Asoka by Devanampiyatissa?", listOf("අරිට්ඨ", "අරිට්ඨ මහා ඇමති", "Arittha"), "අරිට්ඨ මහා ඇමතිවරයාය.", "පසු කලෙක පැවිදි විය.")
        15 -> Quintuple("මිහිඳු හිමියන් රජුට පැවසූ පාලකයා පිළිබඳ ශ්‍රේෂ්ඨ සංකල්පය කුමක්ද?", "Great concept of kingship declared by Mihindu Thero?", listOf("භාරකරු", "ධර්ම භාරකරු", "පාලකයා භාරකරුවෙකි"), "'ඔබ මේ පොළොවේ අයිතිකරු නොව භාරකරු පමණි' යන භාරකාරත්ව සංකල්පයයි.", "පාලකයා යනු භාරකරුවෙකි.")
        16 -> Quintuple("ලක්දිවදී ප්‍රථමයෙන්ම පැවිදි බව ලැබූ තැනැත්තා කවුද?", "First person ordained in Sri Lanka?", listOf("භණ්ඩුක", "භණ්ඩුක උපාසක"), "භණ්ඩුක උපාසකතුමා (භණ්ඩුක හිමි) වේ.", "මිහින්තලයේදී පැවිදි විය.")
        17 -> Quintuple("ලක්දිව සසුන මුල් බැසගත් බව සනාථ කිරීමට අරිට්ඨ හිමියන් කළේ කුමක්ද?", "What proved Buddhism was rooted in Sri Lanka?", listOf("විනය දේශනා කිරීම", "විනය පිටකය"), "ලාංකික භික්ෂුවක් ලෙස ථූපාරාමයේදී විනය පිටකය දේශනා කිරීමයි.", "විනය සංගායනාවයි.")
        18 -> Quintuple("දේවානම්පියතිස්ස රජුගේ පාලන කාලයේ අගනුවර වූයේ කුමන නගරයද?", "Capital during Devanampiyatissa's reign?", listOf("අනුරාධපුරය", "අනුරාධපුර", "Anuradhapura"), "අනුරාධපුර නගරයයි.", "ලංකාවේ ප්‍රථම අගනුවරයි.")
        19 -> Quintuple("දේවානම්පියතිස්ස රජු විසින් ඉදිකළ ප්‍රසිද්ධ වැවක් නම් කරන්න.", "A famous reservoir built by Devanampiyatissa?", listOf("තිස්ස වැව", "තිසා වැව", "Tissa Wewa"), "තිස්ස වැව වේ.", "අනුරාධපුරයේ පිහිටා ඇත.")
        20 -> Quintuple("දේවානම්පියතිස්ස රජුගේ පියාණන් වූයේ කවුරුන්ද?", "Who was King Devanampiyatissa's father?", listOf("මුටසීව", "මුටසීව රජු", "Mutasiva"), "මුටසීව රජතුමාය.", "මහමෙවුනා උයන නිර්මාණය කළ රජුය.")
        else -> Quintuple("දේවානම්පියතිස්ස රජුගේ ප්‍රධාන මෙහෙවර කුමක්ද?", "Main historic contribution of Devanampiyatissa?", listOf("බුදුදහම හඳුන්වා දීම", "ශාසනය"), "ලක්දිවට බුදුදහම පිළිගෙන ශාසනය ස්ථාපිත කිරීමට පහසුකම් සැලසීමයි.", "මහින්දාගමනය පිළිගැනීමයි.")
      }

      6 -> when (qIndex) {
        1 -> Quintuple("දුටුගැමුණු කුමරුගේ දෙමව්පියන් කවුරුන්ද?", "Who were King Dutugemunu's parents?", listOf("කාවන්තිස්ස", "විහාරමහා දේවිය", "Kavantissa", "Viharamahadevi"), "කාවන්තිස්ස රජු සහ විහාරමහා දේවියයි.", "රුහුණ පාලනය කළ රජු හා බිසව සිහිපත් කරන්න.")
        2 -> Quintuple("දුටුගැමුණු කුමරු කුඩා කල හැඳින්වූ මුල් නම කුමක්ද?", "What was prince Dutugemunu's childhood name?", listOf("ගැමුණු", "ගැමුණු කුමරු", "Gamani"), "ගැමුණු කුමරු (ගාමිණී අභය) නමිනි.", "දුෂ්ට යන නාමය එකතු වීමට පෙර නමයි.")
        3 -> Quintuple("ගැමුණු කුමරු තම පියාට ස්ත්‍රී ආභරණ යැවීමට හේතුව කුමක්ද?", "Why did prince Gamani send female jewelry to his father?", listOf("එළාර", "සටන", "යුද්ධයට අවසර නොදීම", "බියගුලු"), "එළාර සමඟ යුද්ධ කිරීමට පිය රජු අවසර නොදීම හේතුවෙනි.", "පිය රජුගේ බියගුලු බව හැඟවීමට කළ ක්‍රියාවකි.")
        4 -> Quintuple("දුටුගැමුණු රජු අනුරාධපුරය එක්සේසත් කර පාලනය කළ වකවානුව කුමක්ද?", "What era did King Dutugemunu rule after unifying Anuradhapura?", listOf("ක්‍රි.පූ. 161", "ක්‍රි.පූ. 2 වන සියවස", "දෙවන සියවස", "BC 161"), "ක්‍රිස්තු පූර්ව දෙවන සියවස (ක්‍රි.පූ. 161 - 137 පමණ) වේ.", "ක්‍රිස්තු පූර්ව දෙවන සියවස සිහිපත් කරන්න.")
        5 -> Quintuple("දුටුගැමුණු රජුගේ ප්‍රධාන මඟුල් ඇතුගේ නම කුමක්ද?", "What was the name of King Dutugemunu's state elephant?", listOf("කණ්ඩුල", "කණ්ඩුල ඇතා", "Kandula"), "කණ්ඩුල ඇතා වේ.", "විජිතපුර සටනේ දොරටු බිඳ දැමූ ඇතාය.")
        6 -> Quintuple("දුටුගැමුණු රජු සතුව සිටි බලසම්පන්න සෙන්පතියන් පිරිස හැඳින්වූයේ කෙසේද?", "What were Dutugemunu's ten great warriors called?", listOf("දසමහා යෝධයන්", "දස මහා යෝධයෝ", "Giant warriors"), "දසමහා යෝධයන් නමිනි.", "යෝධයන් දසදෙනා සිහිපත් කරන්න.")
        7 -> Quintuple("දසමහා යෝධයන් අතර සිටි ප්‍රධානම සෙන්පතියා කවුද?", "Who was the chief general among the ten giants?", listOf("නන්දිමිත්‍ර", "Nandimithra"), "නන්දිමිත්‍ර සෙන්පතියාය.", "මිත්‍ර නම් යෝධයා සිහිපත් කරන්න.")
        8 -> Quintuple("දුටුගැමුණු රජු සහ එළාර රජු අතර තීරණාත්මක බලකොටු සටන පැවතියේ කොහේද?", "Where was the decisive fortress battle fought between Dutugemunu and Elara?", listOf("විජිතපුර", "විජිතපුරය", "Vijithapura"), "විජිතපුර බලකොටුවේදීය.", "කණ්ඩුල ඇතා ලෝහ දොරටු බිඳ දැමූ බලකොටුවයි.")
        9 -> Quintuple("දුටුගැමුණු රජු අනුරාධපුරයේ ඉදිකළ උසම මහා සෑය කුමක්ද?", "What was the tallest stupa built by King Dutugemunu?", listOf("රුවන්වැලි", "මහථූපය", "රුවන්වැලිසෑය", "Ruwanwelisaya"), "රුවන්වැලි මහා සෑය (මහථූපය / රත්නමාලී චෛත්‍යය) වේ.", "ස්වර්ණමාලී මහා සෑයයි.")
        10 -> Quintuple("සඟසතු කර දුටුගැමුණු රජු ඉදිකළ නවමහල් ප්‍රාසාදය කුමක්ද?", "What was the nine-story palace built by King Dutugemunu for monks?", listOf("ලෝවාමහාපාය", "ලෝහ ප්‍රාසාදය", "Lovamahapaya"), "ලෝවාමහාපාය (ලෝහ ප්‍රාසාදය) වේ.", "තඹ උළු සෙවිලි කළ නවමහල් මන්දිරයයි.")
        11 -> Quintuple("සටන ආරම්භයේදී දුටුගැමුණු රජු කළ ඓතිහාසික ප්‍රකාශය කුමක්ද?", "What historic statement did Dutugemunu make before the war?", listOf("සම්බුද්ධ ශාසනයේ", "රජ සැප පිණිස නොව", "ශාසනය"), "'මාගේ මේ ව්‍යායාමය රජ සැප පිණිස නොව සම්බුද්ධ ශාසනයේ චිරස්ථිතිය පිණිසය' යන්නයි.", "බුද්ධ ශාසනයේ ආරක්ෂාව වෙනුවෙන් කළ ප්‍රකාශයයි.")
        12 -> Quintuple("එළාර රජු යුද්ධයේදී නැඟී සිටි ඇතුගේ නම කුමක්ද?", "What was the name of King Elara's elephant in battle?", listOf("මහාපබ්බත", "මහාපබ්බත ඇතා", "Mahapabbata"), "මහාපබ්බත ඇතා වේ.", "පර්වතයක් වැනි විශාල ඇතාය.")
        13 -> Quintuple("දුටුගැමුණු රජුගේ සොහොයුරා වූ දීඝවාපිය පාලනය කළ කුමරු කවුද?", "Who was Dutugemunu's brother who governed Dighavapi?", listOf("සද්ධාතිස්ස", "සද්ධාතිස්ස කුමරු", "Saddhatissa"), "සද්ධාතිස්ස කුමරුය.", "පසු කලෙක රජ බවට පත් සහෝදරයාය.")
        14 -> Quintuple("දුටුගැමුණු රජු විසින් කරවන ලද තවත් ප්‍රධාන චෛත්‍යයක් නම් කරන්න.", "Name another famous stupa built by King Dutugemunu.", listOf("මිරිසවැටිය", "මිරිසවැටි", "Mirisawetiya"), "මිරිසවැටිය චෛත්‍යය වේ.", "සඟුන්ට නොදී මිරිස් ව්‍යංජනයක් අනුභව කිරීම නිමිත්තෙනි.")
        15 -> Quintuple("විජිතපුර සටනේදී කණ්ඩුල ඇතා පිට නැගී උණු තාරවලින් බේරී දොරටුව බිඳ දැමූ යෝධයා කවුද?", "Which giant broke the iron gate with elephant Kandula in Vijithapura?", listOf("නන්දිමිත්‍ර", "සුරනිමල", "Nandimithra"), "නන්දිමිත්‍ර (සහ සුරනිමල) සෙන්පතියාය.", "දසමහා යෝධයන්ගේ නායකයාය.")
        16 -> Quintuple("රුවන්වැලි සෑයේ ධාතු නිධානෝත්සවය පිළිබඳ තොරතුරු අඩංගු ප්‍රධාන මූලාශ්‍රය කුමක්ද?", "Which chronicle details the enshrinement of relics in Ruwanwelisaya?", listOf("මහාවංශය", "Mahavamsa"), "මහාවංශය (Mahavamsa) වේ.", "ලක්දිව ශ්‍රේෂ්ඨතම ඓතිහාසික වංශකතාවයි.")
        17 -> Quintuple("දුටුගැමුණු රජු තම සටන් ජය කොන්තයේ තැන්පත් කර තිබුණේ මොනවාද?", "What was enshrined in King Dutugemunu's scepter?", listOf("සර්වඥ ධාතූන්", "ධාතුන් වහන්සේලා", "Relics"), "බුදුරජාණන් වහන්සේගේ සර්වඥ ධාතූන් වහන්සේලාය.", "ශාසනික ආශිර්වාදය උදෙසා තැන්පත් කළ ධාතූන්ය.")
        18 -> Quintuple("එළාර රජුගේ මරණයෙන් පසු දුටුගැමුණු රජු ඔහුට දැක්වූ ගෞරවය කුමක්ද?", "How did Dutugemunu honor King Elara after defeating him?", listOf("එළාර සොහොන", "වාද්‍ය භාණ්ඩ නිහඬ", "සොහොනක්"), "එළාර සොහොන ඉදිකර ඒ අසලින් යන විට වාද්‍ය භාණ්ඩ නිහඬ කරන ලෙස නියෝග කිරීමයි.", "රාජකීය ගෞරව සහිතව සොහොනක් තැනීය.")
        19 -> Quintuple("දුටුගැමුණු කුමරු කුඩා කල යහනේ හැකිළී නිදාගැනීමට දැක්වූ හේතුව කුමක්ද?", "Why did prince Gamani curl up in bed as a child?", listOf("උතුරෙන් එළාර", "දකුණෙන් මුහුද", "අතපය දිගහැර"), "'උතුරෙන් එළාරගේ දෙමළුන්ය, දකුණෙන් මහ මුහුදය, මා කෙසේ අතපය දිගහැර නිදන්නද' කියා පැවසීමයි.", "දෙපසින් සිරවී සිටින බව ප්‍රකාශ කිරීමයි.")
        20 -> Quintuple("දුටුගැමුණු රජුගේ පුත් සාලිය කුමරු විවාහ කරගත් කුලහීන තරුණිය කවුද?", "Whom did Prince Saliya marry, forfeiting the throne?", listOf("අශෝකමාලා", "අසෝකමාලා", "Asokamala"), "අශෝකමාලා තරුණියයි.", "රජකම පසෙකලා විවාහ කරගත් රූමත් තරුණියයි.")
        else -> Quintuple("දුටුගැමුණු රජුගේ ඓතිහාසික මෙහෙවර කුමක්ද?", "What was Dutugemunu's historic mission?", listOf("රට එක්සේසත් කිරීම", "ශාසන ආරක්ෂාව"), "රට එක්සේසත් කර සම්බුද්ධ ශාසනය සුරක්ෂිත කිරීමයි.", "ලක්දිව එක්සේසත් කළ රජුය.")
      }

      // Set 7: වළගම්බා රජු & ත්‍රිපිටකය ග්‍රන්ථාරූඪ කිරීම
      7 -> when (qIndex) {
        1 -> Quintuple("වළගම්බා රජු හැඳින්වූ අනෙක් රාජකීය නාමය කුමක්ද?", "Another name of King Valagamba?", listOf("වට්ටගාමිණී අභය", "වට්ටගාමිණී"), "වට්ටගාමිණී අභය රජතුමා නමිනි.", "සද්ධාතිස්ස රජුගේ පුතෙකි.")
        2 -> Quintuple("වළගම්බා රජු පළමුවර රජවී මාස 5කින් පළාගියේ කාගේ ආක්‍රමණය නිසාද?", "Why did Valagamba flee after 5 months of rule?", listOf("ද්‍රවිඩ ආක්‍රමණිකයන්", "දෙමළ ආක්‍රමණිකයන්", "ආක්‍රමණිකයන්"), "ද්‍රවිඩ ආක්‍රමණිකයන් සත්දෙනෙකුගේ ආක්‍රමණය නිසාය.", "අනුරාධපුරයට පහර දුන්හ.")
        3 -> Quintuple("කරත්තයේ බර අඩු කිරීමට ස්වේච්ඡාවෙන් බැසගිය වළගම්බා රජුගේ බිසව කවුද?", "Which queen voluntarily stepped down from the chariot?", listOf("සෝමා දේවිය", "සෝමා", "Somadevi"), "සෝමා දේවියයි.", "රජුගේ ජීවිතය බේරාගැනීමටය.")
        4 -> Quintuple("සෝමා දේවිය සැඟවුණු ස්ථානයේ පසුව රජු ඉදිකළ සෑය කුමක්ද?", "Stupa built where Somadevi hid?", listOf("සෝමාවතී", "සෝමාවතිය", "Somawathiya"), "සෝමාවතී චෛත්‍යය වේ.", "දකුණු දළදා වහන්සේ වැඩසිටින සෑයයි.")
        5 -> Quintuple("පලායන රජු දැක 'මහා කළු සිංහලයා පලායයි' කියා කෑගැසූ තීර්ථකයා කවුද?", "Jain ascetic who mocked fleeing Valagamba?", listOf("ගිරි නිගණ්ඨයා", "ගිරි", "Giri"), "ගිරි නිගණ්ඨයා (Giri) වේ.", "ආරාමයේ සිට නින්දා කළේය.")
        6 -> Quintuple("ගිරි නිගණ්ඨයාගේ ආරාමය කඩා වළගම්බා රජු ඉදිකළ මහා විහාරය කුමක්ද?", "Great monastery built by Valagamba demolishing Giri's hermitage?", listOf("අභයගිරිය", "අභයගිරි විහාරය", "Abhayagiri"), "අභයගිරි විහාරය වේ.", "අභය සහ ගිරි නම් එක්කර තැනීය.")
        7 -> Quintuple("අභයගිරි විහාරය වළගම්බා රජු පූජා කළේ කුමන හිමියන්ටද?", "To which monk did the king offer Abhayagiri?", listOf("කුපික්කල මහාතිස්ස", "මහාතිස්ස හිමි"), "කුපික්කල මහාතිස්ස මහරහතන් වහන්සේටය.", "තමාට රැකවරණය දුන් හිමියන්ටය.")
        8 -> Quintuple("අභයගිරිය තනි පුද්ගල හිමිනමකට පූජා කිරීම නිසා ඇතිවූ ශාසනික භේදය කුමක්ද?", "Sect formed at Abhayagiri breaking from Mahavihara?", listOf("ධම්මරුචි", "ධම්මරුචි නිකාය"), "ධම්මරුචි නිකාය බිහිවීමයි.", "ලංකාවේ පළමු නිකාය භේදයයි.")
        9 -> Quintuple("වළගම්බා රජු සඟවාගෙන රැකවරණය දුන් ප්‍රකට ලෙන් විහාරය කුමක්ද?", "Famous cave temple that sheltered King Valagamba?", listOf("දඹුල්ල", "දඹුලු රජමහා විහාරය", "Dambulla"), "දඹුල්ල රජමහා විහාරය වේ.", "පසුව රන්ගිරි දඹුල්ල විය.")
        10 -> Quintuple("වළගම්බා රජ දවස ලක්දිව ඇතිවූ මහා සාගතය කුමක්ද?", "Great famine during Valagamba's reign?", listOf("බැමිනිතියා සාය", "බැමිණිතියා"), "බැමිනිතියා සාය (බැමිණිතියා මහා සාගතය) වේ.", "වසර 12ක් පැවති දරුණු නියඟයකි.")
        11 -> Quintuple("කටපාඩමින් රැගෙන ආ ත්‍රිපිටක ධර්මය ග්‍රන්ථාරූඪ කළේ කොහේද?", "Where was the Tripitaka committed to writing?", listOf("මාතලේ අලුවිහාරය", "අලුවිහාරය", "Aluvihara"), "මාතලේ අලුවිහාරයේදීය.", "ඓතිහාසික ලේඛනගත කිරීමයි.")
        12 -> Quintuple("ත්‍රිපිටකය ග්‍රන්ථාරූඪ කළේ කුමන ද්‍රව්‍ය මතද?", "On what material was the Tripitaka written?", listOf("පුස්කොළ", "තල්පත්", "තල්පත්වල"), "පුස්කොළ (තල්පත්) මත උල්කටුවෙන් ලියාය.", "පුස්කොළ පොත්වලය.")
        13 -> Quintuple("ත්‍රිපිටකය ග්‍රන්ථාරූඪ කිරීමට සහභාගී වූ රහතන් වහන්සේලා ගණන කීයද?", "How many Arahants participated in writing the Tripitaka?", listOf("500", "පන්සියයක්", "500ක්"), "මහරහතන් වහන්සේලා පන්සිය නමක් (500ක්) සහභාගී වූහ.", "පන්සියයක් රහතන් වහන්සේලාය.")
        14 -> Quintuple("ත්‍රිපිටකය ලේඛනගත කිරීමට මූලික වූ මහ තෙරුන් වහන්සේ කවුද?", "Head Thero who led writing the Tripitaka?", listOf("කුන්තගත්තතිස්ස", "කුන්තගත්ත තිස්ස"), "කුන්තගත්තතිස්ස මහරහතන් වහන්සේය.", "අලුවිහාරයේ වැඩසිටි සේක.")
        15 -> Quintuple("වළගම්බා රජු වසර කීයක් සැඟවී සිට සේනාව සංවිධානය කළේද?", "How many years did Valagamba stay in hiding?", listOf("14ක්", "අවුරුදු 14", "14"), "වසර 14ක් සැඟවී සිටියේය.", "නැවත අනුරාධපුරය දිනාගත්තේය.")
        16 -> Quintuple("වළගම්බා රජු ඉදිකළ විශාලතම චෛත්‍යය කුමක්ද?", "Great stupa built by Valagamba?", listOf("අභයගිරිය", "අභයගිරි සෑය", "Abhayagiri"), "අභයගිරි මහා සෑය වේ.", "ලෝකයේ දෙවන උසම ගඩොල් ස්තූපයයි.")
        17 -> Quintuple("අභයගිරි දාගැබේ තැන්පත් කර ඇත්තේ බුදුරදුන්ගේ කුමන ධාතුවද?", "Relic enshrined in Abhayagiri?", listOf("සිරිපතුල් ධාතුව", "සිරිපතුල"), "බුදුරදුන්ගේ සිරිපතුල් සලකුණයි.", "සිරිපතුල් ධාතුව වේ.")
        18 -> Quintuple("බැමිනිතියා සාගතයේදී භික්ෂූන් ධර්මය රැකගත්තේ කෙසේද?", "How did monks protect Dhamma during the great famine?", listOf("වැලි මත වැතිර", "කටපාඩමින්", "ධර්මය කටපාඩමින්"), "උගුර වියලෙද්දී වැලි තලා මත වැතිර කටපාඩමින් දහම් කොටස් පවත්වාගනිමිනි.", "පරපුරෙන් පරපුරට රැකගත්හ.")
        19 -> Quintuple("දඹුල්ල විහාරයේ විශාල සැතපෙන බුදුපිළිමය කරවූ රජු කවුද?", "King who crafted the large reclining Buddha at Dambulla?", listOf("වළගම්බා", "වළගම්බා රජු"), "වළගම්බා රජතුමාය.", "ප්‍රධාන ගල් ලෙන තුළය.")
        20 -> Quintuple("ත්‍රිපිටකය ග්‍රන්ථාරූඪ කිරීම ලෝක බෞද්ධ ඉතිහාසයේ වැදගත් වන්නේ ඇයි?", "Why is writing Tripitaka vital in world Buddhist history?", listOf("ධර්මය අද දක්වා සුරක්ෂිත වීම", "සුරක්ෂිත වීම"), "ථෙරවාද බුදුදහමේ මූලික දේශනා අද දක්වා නොනැසී ලෝකයට ඉතිරි වූ බැවිනි.", "ශාසනය සුරැකුණි.")
        else -> Quintuple("වළගම්බා රජුගේ ශ්‍රේෂ්ඨතම ශාසනික සේවය කුමක්ද?", "Valagamba's greatest service?", listOf("ත්‍රිපිටකය ග්‍රන්ථාරූඪ කිරීම", "අභයගිරිය"), "ත්‍රිපිටකය ග්‍රන්ථාරූඪ කිරීමට පහසුකම් සලසා අභයගිරිය තැනීමයි.", "ත්‍රිපිටකය ලියවීමයි.")
      }

      // Set 8: වසභ, ගජබාහු හා ධාතුසේන රජවරු
      8 -> when (qIndex) {
        1 -> Quintuple("ලංකාවේ ලම්බකර්ණ වංශය ආරම්භ කළ රජතුමා කවුද?", "King who founded the Lambakarna dynasty?", listOf("වසභ", "වසභ රජු", "Vasabha"), "වසභ රජතුමාය.", "ක්‍රි.ව. 67 දී පමණ රජවිය.")
        2 -> Quintuple("වසභ රජු වසර කීයක් පමණක් ජීවත් වන බවට අනාවැකියක් තිබුණේද?", "Prophecy said Vasabha will live only how many years?", listOf("12ක්", "අවුරුදු 12", "12"), "අවුරුදු 12ක් පමණි.", "ජ්‍යෝතිෂ අනාවැකියකි.")
        3 -> Quintuple("ආයුෂ වැඩි කරගැනීමට වසභ රජු කළ ධාර්මික ක්‍රියාව කුමක්ද?", "Pious acts of Vasabha to prolong his life?", listOf("වෙහෙර විහාර කරවීම", "පහන් පූජා", "දන් දීම"), "වෙහෙර විහාර කරවීම, පහන් පූජා පැවැත්වීම හා සිල්වතුන්ට උපස්ථානයයි.", "වසර 44ක් රජකම් කළේය.")
        4 -> Quintuple("වසභ රජු ඉදිකළ වැව් සංඛ්‍යාව කීයද?", "Number of reservoirs built by Vasabha?", listOf("11ක්", "වැව් 11", "11"), "මහා වැව් 11ක් ඉදිකළේය.", "අලහොර වැව ප්‍රධානයි.")
        5 -> Quintuple("ලංකාවේ මුල්ම වතාවට වටදාගෙයක් ඉදිකළ රජු කවුද?", "King who built the first Vatadage?", listOf("වසභ", "වසභ රජු"), "වසභ රජතුමාය (ථූපාරාමයට).", "දාගැබ් ආවරණයයි.")
        6 -> Quintuple("සොළී රටට ගොස් සිංහල සිරකරුවන් 12,000ක් බේරාගත් රජු කවුද?", "King who rescued 12,000 Sinhala captives from Chola?", listOf("ගජබාහු", "පළමුවන ගජබාහු", "Gajabahu I"), "පළමුවන ගජබාහු රජතුමාය.", "ගජබාහු රජුගේ වික්‍රමයයි.")
        7 -> Quintuple("ගජබාහු රජු සමඟ මුහුද දෙබෑ කරමින් ඉන්දියාවට ගිය යෝධයා කවුද?", "Mighty giant who accompanied King Gajabahu?", listOf("නීල මහා යෝධයා", "නීල යෝධයා", "Neela"), "නීල මහා යෝධයා වේ.", "යගදාවෙන් මුහුදට පහර දුන්නේය.")
        8 -> Quintuple("ගජබාහු රජු සොළී රටින් ගෙනා පූජනීය වස්තුව හා ඇදහිල්ල කුමක්ද?", "Relic and worship brought from Chola by Gajabahu?", listOf("පත්තිනි සළඹ", "පත්තිනි ඇදහිල්ල", "පාත්‍රා ධාතුව"), "පත්තිනි දේවියගේ රන් සළඹ සහ බුදුන්ගේ පාත්‍රා ධාතුවයි.", "පත්තිනි දේව ඇදහිල්ලයි.")
        9 -> Quintuple("ඇසළ පෙරහැර ආරම්භ කිරීමට මූලික වූ රජෙක් ලෙස සැලකෙන්නේ කවුද?", "King credited with initiating Esala Perahera?", listOf("ගජබාහු", "පළමුවන ගජබාහු"), "පළමුවන ගජබාහු රජතුමාය.", "දෙවිවරුන් උදෙසා පෙරහැර කළේය.")
        10 -> Quintuple("කලාවැව ඉදිකළ මොරිය වංශික ශ්‍රේෂ්ඨ රජතුමා කවුද?", "Great Moriya king who built Kala Wewa?", listOf("ධාතුසේන", "ධාතුසේන රජු", "Dhatusena"), "ධාතුසේන රජතුමාය.", "අනුරාධපුරයේ ශ්‍රේෂ්ඨ වාරි රජෙකි.")
        11 -> Quintuple("කලාවැවේ සිට අනුරාධපුර තිස්ස වැවට ජලය ගෙනගිය සැතපුම් 54ක ඇළ කුමක්ද?", "54-mile canal carrying water from Kala Wewa to Tissa Wewa?", listOf("යෝධ ඇළ", "ජය ගඟ", "Yoda Ela"), "ජය ගඟ හෙවත් යෝධ ඇළ වේ.", "විස්මිත වාරි තාක්ෂණයකි.")
        12 -> Quintuple("යෝධ ඇළේ බැස්ම සැතපුමකට අඟල් කීයද?", "Gradient of Yoda Ela per mile?", listOf("අඟල් 6ක්", "අඟල් 6", "6 inches"), "සැතපුමකට අඟල් 6ක් පමණි.", "අතිශය සියුම් බෑවුමකි.")
        13 -> Quintuple("ධාතුසේන රජු සතුව තිබූ එකම ධනය ලෙස පෙන්වූයේ කුමක්ද?", "What single wealth did Dhatusena show his captors?", listOf("කලාවැවේ දිය දෝතක්", "කලාවැවේ වතුර", "දිය දෝත"), "කලාවැවේ දිය දෝතක් තම දෑතට ගෙන පෙන්වීමයි.", "'මා සතු එකම ධනය මෙයයි'.")
        14 -> Quintuple("ධාතුසේන රජුගේ මහා සෙන්පතියා වූ ඔහුගේ බෑනා කවුද?", "Dhatusena's general and son-in-law?", listOf("මිගාර", "මිගාර සෙන්පති"), "මිගාර සෙන්පතියාය.", "කාශ්‍යප කුමරු රවටා කැරලි ගැස්වීය.")
        15 -> Quintuple("ධාතුසේන රජුගේ පුතුන් දෙදෙනා කවුරුන්ද?", "Who were King Dhatusena's two sons?", listOf("කාශ්‍යප සහ මුගලන්", "කාශ්‍යප", "මුගලන්"), "කාශ්‍යප කුමරු සහ මුගලන් (මොග්ගල්ලාන) කුමරුය.", "සොහොයුරන් දෙදෙනෙකි.")
        16 -> Quintuple("සීගිරිය මහා බලකොටුවක් හා චිත්‍ර කලාගාරයක් බවට පත්කළ රජු කවුද?", "King who transformed Sigiriya into a fortress and art palace?", listOf("කාශ්‍යප", "පළමුවන කාශ්‍යප", "Kassapa I"), "පළමුවන කාශ්‍යප රජතුමාය.", "ක්‍රි.ව. 5 වන සියවසේදීය.")
        17 -> Quintuple("සීගිරි පර්වතයේ අඳින ලද සුප්‍රකට සිතුවම් මොනවාද?", "World-famous frescoes painted at Sigiriya?", listOf("සීගිරි බිතුසිතුවම්", "සීගිරි අප්සරාවන්"), "සීගිරි අප්සරාවන්ගේ බිතුසිතුවම් වේ.", "ලෝක උරුම සිතුවම්ය.")
        18 -> Quintuple("කාශ්‍යප රජු සීගිරි මාලිගයේ සිංහ පාමුල ඉදිකළ ප්‍රවේශය කුමක්ද?", "Lion entrance built at Sigiriya palace base?", listOf("සිංහ මුඛය", "සිංහ පාදය", "Lion Gate"), "සිංහ පාද දොරටුව (Lion Gate) වේ.", "සිංහයෙකුගේ මුඛයෙන් ඇතුල්වීමයි.")
        19 -> Quintuple("කාශ්‍යප රජු පරාජය කර අනුරාධපුරයේ නැවත රජවූ සොහොයුරා කවුද?", "Brother who defeated Kassapa to become king?", listOf("මුගලන්", "මොග්ගල්ලාන", "Moggallana"), "මුගලන් (පළමුවන මොග්ගල්ලාන) රජතුමාය.", "ඉන්දියාවෙන් සේනාවක් ගෙන ආවේය.")
        20 -> Quintuple("අවුකන බුදුපිළිමය නිර්මාණය කළ රජු ලෙස ජනප්‍රවාදයේ එන්නේ කවුද?", "King traditionally associated with Avukana statue?", listOf("ධාතුසේන", "ධාතුසේන රජු"), "ධාතුසේන රජතුමාය.", "කලාවැව අසල පිහිටි ශෛලමය පිළිමයයි.")
        else -> Quintuple("කලාවැව ඉදිකිරීමේ ප්‍රධාන ප්‍රතිඵලය කුමක්ද?", "Main result of building Kala Wewa?", listOf("අනුරාධපුරයට ජලය", "කෘෂිකර්මය"), "අනුරාධපුර නගරයට හා කුඹුරුවලට ජලය නොකඩවා සැපයීමයි.", "වාරි ශිෂ්ටාචාරයේ උච්චතම අවස්ථාවයි.")
      }

      // Set 9: මහා පරාක්‍රමබාහු රජු & පොළොන්නරු යුගය
      9 -> when (qIndex) {
        1 -> Quintuple("පොළොන්නරුවේ ස්වර්ණමය යුගය බිහිකළ ශ්‍රේෂ්ඨ රජතුමා කවුද?", "Great king who brought golden era to Polonnaruwa?", listOf("මහා පරාක්‍රමබාහු", "පරාක්‍රමබාහු රජු", "Parakramabahu I"), "මහා පරාක්‍රමබාහු රජතුමාය.", "ක්‍රි.ව. 1153 - 1186 පාලනය කළේය.")
        2 -> Quintuple("මහා පරාක්‍රමබාහු රජු කළ සුප්‍රකට ජල ප්‍රතිපත්තිය කුමක්ද?", "Famous water conservation pledge of Parakramabahu?", listOf("අහසින් වැටෙන එකදු දිය බිඳක්වත්", "දිය බිඳක්වත් මුහුදට"), "'අහසින් වැටෙන එකදු දිය බිඳක්වත් මිනිසාගේ ප්‍රයෝජනයට නොගෙන මුහුදට ගලා යාමට ඉඩ නොදිය යුතුය' යන්නයි.", "ජල සංරක්ෂණ ප්‍රතිපත්තියයි.")
        3 -> Quintuple("පරාක්‍රමබාහු රජු ඉදිකළ විශාලතම මහා වැව කුමක්ද?", "Largest reservoir constructed by Parakramabahu?", listOf("පරාක්‍රම සමුද්‍රය", "Parakrama Samudra"), "පරාක්‍රම සමුද්‍රය වේ.", "මුහුදක් බඳු මහා වැවකි.")
        4 -> Quintuple("පරාක්‍රම සමුද්‍රය සෑදීමට එකතු කළ පැරණි වැව් තුන මොනවාද?", "Three ancient tanks merged to create Parakrama Samudra?", listOf("තෝපා", "දුඹුටු", "එරබදු"), "තෝපා වැව, දුඹුටු වැව සහ එරබදු වැවයි.", "වැව් තුනක් එක්කළේය.")
        5 -> Quintuple("මහා පරාක්‍රමබාහු රජුගේ සත් මහල් මාලිගය හැඳින්වූයේ කෙසේද?", "Seven-story royal palace of Parakramabahu?", listOf("වෛජයන්ත ප්‍රාසාදය", "සත්මහල් ප්‍රාසාදය"), "වෛජයන්ත ප්‍රාසාදය නමිනි.", "කාමර දහසකින් යුත් මන්දිරයකි.")
        6 -> Quintuple("පොළොන්නරුවේ ඉදිකළ නෙළුම් මලක හැඩැති විසිතුරු පොකුණ කුමක්ද?", "Lotus-shaped decorative pond in Polonnaruwa?", listOf("නෙළුම් පොකුණ", "Lotus pond"), "නෙළුම් පොකුණ වේ.", "ගල් පියලි නෙළුම් පෙති සේ සකසා ඇත.")
        7 -> Quintuple("මහා පරාක්‍රමබාහු රජුගේ ප්‍රධාන අගමෙහෙසිය වූයේ කවුද?", "Chief Queen of King Parakramabahu I?", listOf("රූපාවතී", "රූපාවතී දේවිය", "Rupavati"), "රූපාවතී දේවියයි.", "පොළොන්නරුවේ චෛත්‍ය කරවූවාය.")
        8 -> Quintuple("පොළොන්නරුව ගල් විහාරයේ ඇති ශෛලමය බුදුපිළිම ගණන කීයද?", "Number of rock-hewn Buddha statues at Gal Vihara?", listOf("4ක්", "හතරක්", "4"), "ප්‍රතිමා 4කි (හිඳි, හිටි, සැතපෙන හා විද්‍යාධර ගුහාවේ පිළිමය).", "උත්තරාරාමය නමිනි.")
        9 -> Quintuple("තුන් නිකාය සමගි කර පරාක්‍රමබාහු රජු ඇතිකළ ශාසන නීති මාලාව කුමක්ද?", "Monastic code established by Parakramabahu?", listOf("පොළොන්නරු කතිකාවත", "කතිකාවත"), "පොළොන්නරු කතිකාවත වේ.", "ශාසන ශෝධනයක් කළේය.")
        10 -> Quintuple("පොළොන්නරු කතිකාවත සම්පාදනය කිරීමට මූලික වූ මහ තෙරුන් වහන්සේ කවුද?", "Head monk who led the Polonnaruwa Katikavata?", listOf("දිඹුලාගල මහා කාශ්‍යප", "මහා කාශ්‍යප හිමි"), "දිඹුලාගල මහා කාශ්‍යප මහරහතන් වහන්සේය.", "ආරණ්‍යවාසී සංඝ නායකයාය.")
        11 -> Quintuple("ලංකාවේ වෙළඳුන්ට හිරිහැර කළ නිසා පරාක්‍රමබාහු රජු හමුදා යැවූ විදේශ රට කුමක්ද?", "Foreign land attacked by Parakramabahu's navy?", listOf("බුරුමය", "රාමඤ්ඤ දේශය", "Burma"), "බුරුමය (රාමඤ්ඤ දේශය) වේ.", "නාවික හමුදාවක් පිටත් කළේය.")
        12 -> Quintuple("පරාක්‍රමබාහු රජු ඉන්දියාවේ පාණ්ඩ්‍ය දේශයට යැවූ මහා සෙන්පතියා කවුද?", "General sent to Pandya kingdom by Parakramabahu?", listOf("ලංකාපුර", "ලංකාපුර සෙන්පති"), "ආදිපාද ලංකාපුර සෙන්පතියාය.", "පාණ්ඩ්‍ය රට ජයගත්තේය.")
        13 -> Quintuple("පොළොන්නරුවේ ලංකාතිලක පිළිමගෙය කරවූ රජතුමා කවුද?", "King who built Lankatilaka image house in Polonnaruwa?", listOf("මහා පරාක්‍රමබාහු", "පරාක්‍රමබාහු රජු"), "මහා පරාක්‍රමබාහු රජතුමාය.", "විශාල ගඩොල් පිළිමගෙයකි.")
        14 -> Quintuple("පොළොන්නරු යුගයේ අගනුවර හා දළදා වහන්සේ රැකවල් කළ කුලී හමුදාව කවුද?", "Mercenary guards of Tooth Relic and capital in Polonnaruwa?", listOf("වේලක්කාර", "වේලක්කාර හමුදාව", "Velakkara"), "වේලක්කාර හමුදාව වේ.", "දෙමළ සෙබළුන් පිරිසකි.")
        15 -> Quintuple("මහා පරාක්‍රමබාහු රජුගේ උපන් ස්ථානය පිහිටියේ කොහේද?", "Birthplace of King Parakramabahu I?", listOf("දැදිගම", "පුංඛගාම", "Dädigama"), "දක්ෂිණ දේශයේ දැදිගම (කොටවෙහෙර) ආසන්නයේය.", "දැදිගම සූතිඝර චෛත්‍යය තැනීය.")
        16 -> Quintuple("පරාක්‍රමබාහු රජුට පෙර පොළොන්නරුව සොළී ග්‍රහණයෙන් මුදාගත් රජු කවුද?", "King who liberated Polonnaruwa from Cholas before Parakramabahu?", listOf("විජයබාහු", "පළමුවන විජයබාහු", "Vijayabahu I"), "පළමුවන විජයබාහු රජතුමාය.", "වසර 77ක සොළී පාලනය අවසන් කළේය.")
        17 -> Quintuple("පළමුවන විජයබාහු රජු තම රාජාභිෂේකය පැවැත්වූයේ කුමන නගරයේදීද?", "City where Vijayabahu I celebrated his coronation?", listOf("අනුරාධපුරය", "අනුරාධපුර"), "අනුරාධපුර නගරයේදීය.", "පැරණි අගනුවරට ගෞරව පිණිසය.")
        18 -> Quintuple("පොළොන්නරුවේ ආලාහණ පිරිවෙන් සංකීර්ණය ඉදිකළ රජු කවුද?", "King who built Alahana Pirivena monastic complex?", listOf("මහා පරාක්‍රමබාහු", "පරාක්‍රමබාහු රජු"), "මහා පරාක්‍රමබාහු රජතුමාය.", "විශාල විශ්වවිද්‍යාලයකි.")
        19 -> Quintuple("පරාක්‍රමබාහු රජු රෝගීන් වෙනුවෙන් පොළොන්නරුවේ තැනූ විශේෂ ස්ථානය කුමක්ද?", "Special facility built for patients by Parakramabahu?", listOf("ආරෝග්‍යශාලාව", "රෝහල", "Hospital"), "වෛද්‍යවරුන් හා ඖෂධ සහිත මහා ආරෝග්‍යශාලාවයි.", "පුරාණ රෝහල් සංකීර්ණයකි.")
        20 -> Quintuple("මහා පරාක්‍රමබාහු රජු රජකම් කළ වසර ගණන කීයද?", "How many years did Parakramabahu I reign?", listOf("33ක්", "අවුරුදු 33", "33"), "වසර 33ක් (අවුරුදු තිස් තුනක්) රජකම් කළේය.", "ස්වර්ණමය යුගයයි.")
        else -> Quintuple("මහා පරාක්‍රමබාහු රජුගේ ප්‍රධාන මෙහෙවර කුමක්ද?", "Main legacy of Parakramabahu I?", listOf("පරාක්‍රම සමුද්‍රය", "රට ස්වයංපෝෂිත කිරීම"), "රට එක්සේසත් කර වාරිමාර්ග හා කෘෂිකර්මාන්තයෙන් ස්වයංපෝෂිත කිරීමයි.", "ශ්‍රේෂ්ඨ වාරි රජෙකි.")
      }

      // Set 10: නිශ්ශංකමල්ල රජු සහ පසුකාලීන රාජධානි
      10 -> when (qIndex) {
        1 -> Quintuple("පොළොන්නරුවේ දිගම සෙල්ලිපිය වන 'ගල්පොත සෙල්ලිපිය' පිහිටවූ රජු කවුද?", "King who inscribed Gal Potha in Polonnaruwa?", listOf("නිශ්ශංකමල්ල", "කීර්ති ශ්‍රී නිශ්ශංකමල්ල", "Nissankamalla"), "කීර්ති ශ්‍රී නිශ්ශංකමල්ල රජතුමාය.", "තම වීරක්‍රියා සටහන් කළේය.")
        2 -> Quintuple("පොළොන්නරුවේ නෙළුම් දඬු හැඩැති කුළුණු සහිත 'නිශ්ශංක ලතා මණ්ඩපය' තැනවූයේ කවුද?", "Who built Nissanka Latha Mandapaya?", listOf("නිශ්ශංකමල්ල", "නිශ්ශංකමල්ල රජු"), "නිශ්ශංකමල්ල රජතුමාය.", "පිරිත් ශ්‍රවණය කළ මණ්ඩපයකි.")
        3 -> Quintuple("දඹුලු විහාරය රනින් ආලේප කර 'ස්වර්ණගිරි ගුහා' නම තැබූ රජු කවුද?", "King who gilded Dambulla caves naming it Swarnagiri Guha?", listOf("නිශ්ශංකමල්ල", "නිශ්ශංකමල්ල රජු"), "නිශ්ශංකමල්ල රජතුමාය.", "බුදුපිළිම හැත්තෑ තුනක් රන් ආලේප කළේය.")
        4 -> Quintuple("නිශ්ශංකමල්ල රජුගෙන් පසු පොළොන්නරුව ආක්‍රමණය කළ කෲර ආක්‍රමණිකයා කවුද?", "Ruthless invader who sacked Polonnaruwa after Nissankamalla?", listOf("මාඝ", "කාලිංග මාඝ", "Kalinga Magha"), "කාලිංග මාඝ (Kalinga Magha) වේ.", "මහා විනාශයක් කළේය.")
        5 -> Quintuple("කාලිංග මාඝගේ ආක්‍රමණය නිසා ලක්දිව ජනතාව කළේ කුමක්ද?", "What did people do due to Magha's invasion?", listOf("නිරිතදිගට සංක්‍රමණය වීම", "පළායාම"), "පොළොන්නරුව හැරදමා නිරිතදිග කඳුකර ප්‍රදේශවලට සංක්‍රමණය වීමයි.", "රාජධානි නිරිතදිගට මාරු විය.")
        6 -> Quintuple("දඹදෙණි රාජධානිය ආරම්භ කළ රජතුමා කවුද?", "King who founded Dambadeniya kingdom?", listOf("විජයබාහු", "තුන්වන විජයබාහු", "Vijayabahu III"), "තුන්වන විජයබාහු රජතුමාය.", "දඹදෙණි පර්වතය අගනුවර කළේය.")
        7 -> Quintuple("දඹදෙණියේ 'කලිකාල සාහිත්‍ය සර්වඥ පණ්ඩිත' නමින් හැඳින්වූ රජු කවුද?", "King honored as Kalikala Sahitya Sarvajna Panditha?", listOf("පරාක්‍රමබාහු", "දෙවන පරාක්‍රමබාහු", "Parakramabahu II"), "දෙවන පරාක්‍රමබාහු රජතුමාය.", "මහා පඬිරුවනකි.")
        8 -> Quintuple("දෙවන පරාක්‍රමබාහු රජු රචනා කළ විශිෂ්ට කාව්‍ය ග්‍රන්ථය කුමක්ද?", "Great Sinhala poetic work by Parakramabahu II?", listOf("කව්සිළුමිණ", "Kawsilumina"), "කව්සිළුමිණ (කුස දාවත) වේ.", "සිංහල කාව්‍යයේ කිරුළයි.")
        9 -> Quintuple("යාපහුව පර්වතය අගනුවර කරගත් රජතුමා කවුද?", "King who made Yapahuwa his capital?", listOf("බුවනෙකබාහු", "පළමුවන බුවනෙකබාහු", "Bhuvanekabahu I"), "පළමුවන බුවනෙකබාහු රජතුමාය.", "දළදා වහන්සේ යාපහුවට ගෙනගියේය.")
        10 -> Quintuple("යාපහුවේ අද දක්නට ලැබෙන ලෝක ප්‍රකට වාස්තු විද්‍යාත්මක අංගය කුමක්ද?", "World-famous architectural feature at Yapahuwa?", listOf("ගල් පියගැටපෙළ", "පියගැටපෙළ", "සිංහ රූ"), "විසිතුරු ශෛලමය පියගැටපෙළ සහ සිංහ රූප වේ.", "චීන ආභාෂය සහිත කැටයම්ය.")
        11 -> Quintuple("කුරුණෑගල (හස්තිශෛලපුර) රාජධානිය ආරම්භ කළ රජතුමා කවුද?", "King who founded Kurunegala kingdom?", listOf("දෙවන බුවනෙකබාහු", "බුවනෙකබාහු"), "දෙවන බුවනෙකබාහු රජතුමාය.", "ඇතුගල්පුර අගනුවරයි.")
        12 -> Quintuple("ගම්පොළ යුගයේ ඉදිකළ සුප්‍රකට ලී කැටයම් සහිත දේවාලය කුමක්ද?", "Famous wooden carving temple of Gampola era?", listOf("ඇම්බැක්ක", "ඇම්බැක්කේ දේවාලය", "Embekke"), "ඇම්බැක්ක දේවාලය වේ.", "ලී කැටයම් කලාවේ උච්චතම නිර්මාණයයි.")
        13 -> Quintuple("ගම්පොළ යුගයේ ඉදිකළ විශිෂ්ට ගල් විහාර දෙක මොනවාද?", "Two magnificent stone temples of Gampola era?", listOf("ගඩලාදෙණිය", "ලංකාතිලක"), "ගඩලාදෙණිය සහ ලංකාතිලක විහාර වේ.", "දකුණු ඉන්දීය ආභාෂය සහිතයි.")
        14 -> Quintuple("කෝට්ටේ (ජයවර්ධනපුර) බලකොටුවක් ලෙස මුලින්ම ඉදිකළ ප්‍රභූවරයා කවුද?", "Chieftain who originally fortified Kotte?", listOf("අලගක්කෝනාර", "නිශ්ශංක අලගක්කෝනාර", "Alakeshwara"), "නිශ්ශංක අලගක්කෝනාර (අලකේශ්වර) ප්‍රභූවරයාය.", "දිය අගල් සහිත බලකොටුවකි.")
        15 -> Quintuple("කෝට්ටේ යුගයේ මුළු ලංකාවම එක්සේසත් කළ ශ්‍රේෂ්ඨ රජතුමා කවුද?", "Great king who unified Sri Lanka from Kotte?", listOf("හයවන පරාක්‍රමබාහු", "පරාක්‍රමබාහු VI", "Parakramabahu VI"), "හයවන පරාක්‍රමබාහු රජතුමාය.", "වසර 55ක් රජකම් කළේය.")
        16 -> Quintuple("හයවන පරාක්‍රමබාහු රජ දවස කෝට්ටේ යුගයේ දියුණු වූ සාහිත්‍ය අංගය කුමක්ද?", "Poetic genre that flourished in Kotte under Parakramabahu VI?", listOf("සංදේශ කාව්‍ය", "සන්දේශ", "Sandesha"), "සංදේශ කාව්‍ය කලාව (සැළලිහිණි, පරවි, හංස, ගිරා, කෝකිල) වේ.", "පණිවිඩ කාව්‍යයි.")
        17 -> Quintuple("සැළලිහිණි සංදේශය සහ කාව්‍යශේඛරය රචනා කළ මහා පඬි රුවන කවුද?", "Author of Salalihini Sandeshaya?", listOf("තොටගමුවේ ශ්‍රී රාහුල", "රාහුල හිමි", "Sri Rahula"), "තොටගමුවේ විජයබා පිරිවෙන්පති ශ්‍රී රාහුල හිමියන්ය.", "ෂඩ්භාෂා පරමේශ්වරය.")
        18 -> Quintuple("පෘතුගීසීන් ලංකාවට පැමිණියේ කුමන වර්ෂයේදීද?", "In which year did the Portuguese arrive in Sri Lanka?", listOf("1505", "1505 දී", "ක්‍රි.ව. 1505"), "ක්‍රිස්තු වර්ෂ 1505 දී (ක්‍රි.ව. 1505) වේ.", "කොළඹ වරායට ගොඩබටහ.")
        19 -> Quintuple("පෘතුගීසි නාවික කණ්ඩායමේ නායකයා වූයේ කවුරුන්ද?", "Leader of the first Portuguese fleet to Ceylon?", listOf("ලොරෙන්සෝ ද අල්මේදා", "ද අල්මේදා", "Almeida"), "ලොරෙන්සෝ ද අල්මේදා (Lourenço de Almeida) වේ.", "කුණාටුවකට හසුව පැමිණියේය.")
        20 -> Quintuple("ශ්‍රී ලංකාවේ අවසාන ස්වාධීන සිංහල රාජධානිය කුමක්ද?", "Last independent Sinhala kingdom in Sri Lanka?", listOf("මහනුවර", "සෙංකඩගල", "කන්ද උඩරට", "Kandy"), "මහනුවර (කන්ද උඩරට / සෙංකඩගල) රාජධානියයි.", "1815 දී ඉංග්‍රීසීන්ට යටත් විය.")
        else -> Quintuple("කෝට්ටේ යුගයේ ශ්‍රේෂ්ඨතම රජතුමා කවුද?", "Greatest king of Kotte era?", listOf("හයවන පරාක්‍රමබාහු", "පරාක්‍රමබාහු"), "හයවන පරාක්‍රමබාහු රජතුමාය.", "මුළු ලංකාවම එක්සේසත් කළේය.")
      }

      // Default fallback
      else -> {
        val distinctHistory = listOf(
          Quintuple("ලංකාවේ ඉතිහාසය හැදෑරීමට ඇති ප්‍රධානම වංශකතාව කුමක්ද?", "Main chronicle for Sri Lanka?", listOf("මහාවංශය", "Mahavamsa"), "මහාවංශය වේ.", "මහානාම හිමියන් රචනා කළ සේක."),
          Quintuple("ශ්‍රී ලංකාවේ මුල්ම අගනුවර වූයේ කුමන නගරයද?", "First capital of Sri Lanka?", listOf("අනුරාධපුරය", "Anuradhapura"), "අනුරාධපුර නගරයයි.", "පණ්ඩුකාභය රජු අගනුවර කළේය."),
          Quintuple("ලංකාවේ දෙවන ඓතිහාසික අගනුවර වූයේ කුමන නගරයද?", "Second ancient capital?", listOf("පොළොන්නරුව", "Polonnaruwa"), "පොළොන්නරුව නගරයයි.", "විජයබාහු හා පරාක්‍රමබාහු රජවරුන්ගේ යුගයයි."),
          Quintuple("ලංකාවේ අවසාන රාජධානිය වූයේ කුමක්ද?", "Last kingdom of Sri Lanka?", listOf("මහනුවර", "සෙංකඩගල", "Kandy"), "මහනුවර රාජධානියයි.", "1815 දක්වා පැවතුනි."),
          Quintuple("රුවන්වැලි මහා සෑය ඉදිකළ ශ්‍රේෂ්ඨ රජතුමා කවුද?", "King who built Ruwanwelisaya?", listOf("දුටුගැමුණු", "දුටුගැමුණු රජු"), "දුටුගැමුණු රජතුමාය.", "මහථූපය නමිනි."),
          Quintuple("සීගිරිය මාලිගයක් හා බලකොටුවක් කළ රජු කවුද?", "King who made Sigiriya a palace?", listOf("කාශ්‍යප", "කාශ්‍යප රජු"), "පළමුවන කාශ්‍යප රජතුමාය.", "අප්සරාවන්ගේ සිතුවම් කරවීය."),
          Quintuple("පරාක්‍රම සමුද්‍රය ඉදිකළ රජතුමා කවුද?", "King who built Parakrama Samudra?", listOf("පරාක්‍රමබාහු", "මහා පරාක්‍රමබාහු"), "මහා පරාක්‍රමබාහු රජතුමාය.", "පොළොන්නරුවේ පිහිටා ඇත."),
          Quintuple("ශ්‍රී ලංකාවට බුදුදහම ගෙනා මහරහතන් වහන්සේ කවුද?", "Who brought Buddhism to Sri Lanka?", listOf("මිහිඳු හිමි", "මහින්ද මහරහතන්"), "මිහිඳු මහරහතන් වහන්සේය.", "දේවානම්පියතිස්ස රජ දවසය."),
          Quintuple("ජය ශ්‍රී මහා බෝධිය ලක්දිවට වැඩම කළ මෙහෙණින් වහන්සේ කවුද?", "Who brought the sacred Bodhi tree?", listOf("සංඝමිත්තා", "සංඝමිත්තා තෙරණිය"), "සංඝමිත්තා රහත් තෙරණියයි.", "අනුරාධපුරයේ රෝපණය කළහ."),
          Quintuple("ත්‍රිපිටකය ග්‍රන්ථාරූඪ කළේ කුමන ස්ථානයේදීද?", "Where was Tripitaka written down?", listOf("මාතලේ අලුවිහාරය", "අලුවිහාරය"), "මාතලේ අලුවිහාරයේදීය.", "වළගම්බා රජ දවසය."),
          Quintuple("කලාවැව ඉදිකළ රජතුමා කවුද?", "Who built Kala Wewa?", listOf("ධාතුසේන", "ධාතුසේන රජු"), "ධාතුසේන රජතුමාය.", "යෝධ ඇළ නිර්මාණය කළේය."),
          Quintuple("සොළී රටින් සිංහල සිරකරුවන් බේරාගත් රජු කවුද?", "King who rescued captives from Chola?", listOf("ගජබාහු", "ගජබාහු රජු"), "පළමුවන ගජබාහු රජතුමාය.", "නීල යෝධයා සමඟ ගියේය."),
          Quintuple("පෘතුගීසීන් ලංකාවට ආවේ කුමන වර්ෂයේදීද?", "When did Portuguese arrive?", listOf("1505", "1505 දී"), "ක්‍රි.ව. 1505 දී වේ.", "කොළඹට ගොඩබටහ."),
          Quintuple("ලන්දේසීන් ලංකාවට මුලින්ම ආවේ කුමන වර්ෂයේදීද?", "When did the Dutch arrive?", listOf("1602", "1602 දී"), "ක්‍රි.ව. 1602 දී ජෝරිස් වැන් ස්පිල්බර්ගන් විසිනි.", "මඩකලපුවට පැමිණියේය."),
          Quintuple("ඉංග්‍රීසීන් මුහුදුබඩ ප්‍රදේශ අත්පත් කරගත්තේ කුමන වර්ෂයේදීද?", "When did British capture maritime areas?", listOf("1796", "1796 දී"), "ක්‍රි.ව. 1796 දී වේ.", "ලන්දේසීන්ගෙන් අත්පත් කරගත්හ."),
          Quintuple("උඩරට ගිවිසුම අත්සන් කර මුළු ලංකාවම ඉංග්‍රීසීන්ට යටත් වූයේ කවදාද?", "When was the Kandyan Convention signed?", listOf("1815", "1815 දී"), "ක්‍රි.ව. 1815 මාර්තු 02 දිනදීය.", "මහනුවර මඟුල් මඩුවේදීය."),
          Quintuple("1818 ඌව වෙල්ලස්ස නිදහස් අරගලයේ නායකයා කවුද?", "Leader of 1818 Uva-Wellassa rebellion?", listOf("කැප්පෙටිපොළ", "මොණරවිල කැප්පෙටිපොළ"), "මොණරවිල කැප්පෙටිපොළ දිසාවය.", "ජාතික වීරයෙකි."),
          Quintuple("1848 මාතලේ නිදහස් සටනේ නායකත්වය දැරුවේ කවුද?", "Leader of 1848 Matale rebellion?", listOf("වීර පුරන් අප්පු", "පුරන් අප්පු", "ගොංගාලේගොඩ බණ්ඩා"), "වීර පුරන් අප්පු සහ ගොංගාලේගොඩ බණ්ඩාය.", "බ්‍රිතාන්‍ය බදු විරෝධී සටනකි."),
          Quintuple("ශ්‍රී ලංකාවට බ්‍රිතාන්‍යයන්ගෙන් නිදහස ලැබුණේ කුමන දිනයේදීද?", "Independence Day of Sri Lanka?", listOf("1948 පෙබරවාරි 4", "පෙබරවාරි 4", "1948"), "1948 පෙබරවාරි මස 04 වන දිනදීය.", "නිදහස් දින සමරනු ලබයි."),
          Quintuple("නිදහස් ශ්‍රී ලංකාවේ ප්‍රථම අග්‍රාමාත්‍යවරයා කවුද?", "First Prime Minister of independent Sri Lanka?", listOf("ඩී. එස්. සේනානායක", "සේනානායක"), "ඩී. එස්. සේනානායක මැතිතුමාය.", "ජාතියේ පියා ලෙස ගෞරව ලබයි.")
        )
        distinctHistory[(qIndex - 1).coerceIn(0, distinctHistory.size - 1)]
      }
    }
  }

  // ==============================================================================
  // GRADE 11 O/L HISTORY BANK (100% GRADE 11 SYLLABUS - SHORT, ACCURATE & DIRECT)
  // ==============================================================================
  private fun getGrade11Question(setNum: Int, qIndex: Int, theme: String): Quintuple<String, String, List<String>, String, String> {
    return when (setNum) {
      // Set 1: කෝල්බෲක්-කැමරන් ප්‍රතිසංස්කරණ (1833)
      1 -> when (qIndex) {
        1 -> Quintuple("කෝල්බෲක් සහ කැමරන් කොමිසම ලංකාවට පැමිණියේ කුමන වර්ෂයේදීද?", "When did Colebrooke-Cameron Commission arrive in Ceylon?", listOf("1829", "1829 දී"), "ක්‍රි.ව. 1829 දී වේ.", "1829 සිහිපත් කරන්න.")
        2 -> Quintuple("කෝල්බෲක් ප්‍රතිසංස්කරණ ක්‍රියාත්මක කළ වර්ෂය කුමක්ද?", "When were Colebrooke reforms implemented?", listOf("1833", "1833 දී"), "ක්‍රි.ව. 1833 දී වේ.", "1833 වසරයි.")
        3 -> Quintuple("1833 දී මුළු ලංකාවම බෙදා වෙන් කළ ප්‍රධාන පළාත් සංඛ්‍යාව කීයද?", "How many provinces was Ceylon divided into in 1833?", listOf("5ක්", "පහයි", "5"), "පළාත් පහකි (උතුර, දකුණ, නැගෙනහිර, බස්නාහිර, මධ්‍යම).", "පළාත් 5කි.")
        4 -> Quintuple("1833 දී ස්ථාපිත කළ ව්‍යවස්ථාදායක සභාවේ නිල නොලත් සභිකයන් ගණන කීයද?", "Number of unofficial members in 1833 Legislative Council?", listOf("6ක්", "හයයි", "6"), "සභිකයන් හය (6) දෙනෙකි.", "නිල නොලත් 6යි.")
        5 -> Quintuple("රාජකාරි ක්‍රමය අහෝසි කරන ලද්දේ කුමන ප්‍රතිසංස්කරණය මඟින්ද?", "Which reforms abolished the Rajakariya system?", listOf("කෝල්බෲක්", "කෝල්බෲක් ප්‍රතිසංස්කරණ"), "කෝල්බෲක් ප්‍රතිසංස්කරණ මඟිනි (1833).", "රාජකාරි ක්‍රමය නැති කළේය.")
        else -> Quintuple("කැමරන් මහතාගේ නිර්දේශ මත පිහිටුවූ ඉහළම අධිකරණය කුමක්ද?", "Highest court established on Cameron's recommendation?", listOf("ශ්‍රේෂ්ඨාධිකරණය", "Supreme Court"), "ශ්‍රේෂ්ඨාධිකරණය (Supreme Court) වේ.", "නඩු විභාග කළ උසාවියයි.")
      }

      // Set 2: වතු වගාවේ ව්‍යාප්තිය & ආර්ථික පරිවර්තනය
      2 -> when (qIndex) {
        1 -> Quintuple("ශ්‍රී ලංකාවේ මුල්ම වාණිජ වැවිලි බෝගය කුමක්ද?", "First commercial plantation crop in Ceylon?", listOf("කෝපි", "කෝපි වගාව", "Coffee"), "කෝපි වගාව වේ.", "කඳුකරයේ වගා කළේය.")
        2 -> Quintuple("කෝපි වගාව මුළුමනින්ම විනාශ කළ දිලීර කොළ රෝගය කුමක්ද?", "Fungal leaf disease that destroyed coffee?", listOf("හේමිලියා වැස්ටාට්‍රික්ස්", "කොළ රෝගය"), "හේමිලියා වැස්ටාට්‍රික්ස් (Hemileia vastatrix) කොළ රෝගයයි.", "කොළ විනාශ කළ දිලීරයයි.")
        3 -> Quintuple("ලංකාවේ තේ වගාවේ පියා ලෙස සැලකෙන්නේ කවුද?", "Father of Ceylon Tea?", listOf("ජේම්ස් ටේලර්", "James Taylor"), "ජේම්ස් ටේලර් (James Taylor) මහතාය.", "ලූල්කඳුර වත්තේ තේ වැවීය.")
        4 -> Quintuple("ජේම්ස් ටේලර් මුල්ම තේ වගාව ආරම්භ කළ වතුයාය කුමක්ද?", "Estate where James Taylor started first tea plantation?", listOf("ලූල්කඳුර", "ලූල්කඳුර වත්ත", "Loolecondera"), "මහනුවර ලූල්කඳුර වතුයායේදීය.", "1867 දී ආරම්භ කළේය.")
        5 -> Quintuple("කොළඹ සිට මහනුවර දක්වා ප්‍රථම දුම්රිය ධාවනය ආරම්භ කළ වර්ෂය කුමක්ද?", "When did first train run from Colombo to Kandy?", listOf("1867", "1867 දී"), "ක්‍රි.ව. 1867 දී වේ.", "කෝපි ප්‍රවාහනයට තැනීය.")
        else -> Quintuple("වතු වගාව සඳහා බ්‍රිතාන්‍යයන් විසින් මෙරටට ගෙනා කම්කරු ජනතාව කවුද?", "Laborers brought by British for plantations?", listOf("දකුණු ඉන්දීය", "ඉන්දියානු දමිළ", "දෙමළ"), "දකුණු ඉන්දියානු දෙමළ කම්කරුවන්ය.", "ඉන්දියාවෙන් ගෙනාවෝය.")
      }

      // Set 3: ජාතික හා ආගමික පුනරුදය
      3 -> when (qIndex) {
        1 -> Quintuple("1873 දී පැවති ඓතිහාසික පානදුරාවාදයේදී බෞද්ධ පාර්ශ්වය මෙහෙයවූ හිමියන් කවුද?", "Who led the Buddhist side in 1873 Panadura Debate?", listOf("මිගෙට්ටුවත්තේ ගුණානන්ද", "ගුණානන්ද හිමි"), "මිගෙට්ටුවත්තේ ගුණානන්ද හිමියන්ය.", "වාදීභසිංහ නමිනි.")
        2 -> Quintuple("පානදුරාවාදය පිළිබඳ වාර්තාව කියවා ලක්දිවට පැමිණි ඇමරිකානු ජාතිකයා කවුද?", "American who arrived after reading Panadura Debate?", listOf("හෙන්රි ස්ටීල් ඕල්කට්", "කර්නල් ඕල්කට්", "Olcott"), "කර්නල් හෙන්රි ස්ටීල් ඕල්කට් (Col. Henry Steel Olcott) තුමාය.", "පරමවිඥානාර්ථ බෞද්ධ සංගමය පිහිටුවීය.")
        3 -> Quintuple("ශ්‍රී ලංකාවේ බෞද්ධ පුනරුදයේ නායකත්වය ගත් අනගාරික ධර්මපාලතුමාගේ ගිහි නම කුමක්ද?", "Lay name of Anagarika Dharmapala?", listOf("දොන් ඩේවිඩ් හේවාවිතාරණ", "ඩේවිඩ් හේවාවිතාරණ"), "දොන් ඩේවිඩ් හේවාවිතාරණ වේ.", "මාතෘභූමිය අවදි කළ නායකයාය.")
        4 -> Quintuple("බුද්ධගයාව බෞද්ධයන්ට නැවත ලබාගැනීමට ධර්මපාලතුමා පිහිටුවූ සංගමය කුමක්ද?", "Society founded by Dharmapala to reclaim Bodh Gaya?", listOf("මහාබෝධි", "මහාබෝධි සමාගම", "Maha Bodhi Society"), "මහාබෝධි සමාගම වේ.", "1891 දී පිහිටුවීය.")
        else -> Quintuple("හින්දු ආගමික පුනරුදයේ පුරෝගාමී නායකයා වූයේ කවුද?", "Pioneer of Hindu revival in Sri Lanka?", listOf("ආරුමුග නාවලර්", "නාවලර්"), "ශ්‍රීමත් ආරුමුග නාවලර් තුමාය.", "යාපනයේ හින්දු විදුහල් ඇරඹීය.")
      }

      // Set 4: 1931 ඩොනමෝර් ආණ්ඩුක්‍රමය & සර්වජන ඡන්ද බලය
      4 -> when (qIndex) {
        1 -> Quintuple("ශ්‍රී ලංකාවට සර්වජන ඡන්ද බලය හිමි වූයේ කුමන වර්ෂයේදීද?", "When was Universal Franchise granted to Sri Lanka?", listOf("1931", "1931 දී"), "ක්‍රි.ව. 1931 දී (ඩොනමෝර් ආණ්ඩුක්‍රමය යටතේ) වේ.", "1931 වසරයි.")
        2 -> Quintuple("1931 දී සර්වජන ඡන්දය හිමිවූ අවම වයස් සීමාව කුමක්ද?", "Minimum voting age under 1931 Donoughmore constitution?", listOf("21", "අවුරුදු 21"), "අවුරුදු 21 සම්පූර්ණ වීමයි.", "වයස 21යි.")
        3 -> Quintuple("ඩොනමෝර් ආණ්ඩුක්‍රමය යටතේ ස්ථාපිත කළ ව්‍යවස්ථාදායක සභාව කුමක්ද?", "Legislature established under Donoughmore constitution?", listOf("රාජ්‍ය මන්ත්‍රණ සභාව", "State Council"), "රාජ්‍ය මන්ත්‍රණ සභාව (State Council) වේ.", "මන්ත්‍රණ සභාවයි.")
        4 -> Quintuple("රාජ්‍ය මන්ත්‍රණ සභාව තුළ ක්‍රියාත්මක වූ විශේෂ පාලන ක්‍රමය කුමක්ද?", "Unique committee system in State Council?", listOf("විධායක කාරක සභා", "කාරක සභා ක්‍රමය"), "විධායක කාරක සභා (Executive Committees) 7 ක්‍රමයයි.", "කාරක සභා 7යි.")
        else -> Quintuple("ඩොනමෝර් කොමිසමේ සභාපතිවරයා වූයේ කවුද?", "Chairman of the Donoughmore Commission?", listOf("ඩොනමෝර් සාමි", "Lord Donoughmore"), "ඩොනමෝර් සාමිවරයා (Lord Donoughmore) ය.", "කොමිසමේ නායකයාය.")
      }

      // Set 5: සෝල්බරි ආණ්ඩුක්‍රමය & 1948 නිදහස
      5 -> when (qIndex) {
        1 -> Quintuple("ශ්‍රී ලංකාවට බ්‍රිතාන්‍යයන්ගෙන් නිදහස හිමිවූ දිනය කුමක්ද?", "Independence Day of Sri Lanka?", listOf("1948 පෙබරවාරි 4", "1948 පෙබරවාරි 04"), "1948 පෙබරවාරි මස 04 වන දිනදීය.", "පෙබරවාරි 4යි.")
        2 -> Quintuple("නිදහස් ලංකාවේ ප්‍රථම අග්‍රාමාත්‍යවරයා බවට පත්වූයේ කවුද?", "First Prime Minister of Ceylon?", listOf("ඩී. එස්. සේනානායක", "සේනානායක", "D. S. Senanayake"), "ගරු ඩී. එස්. සේනානායක මැතිතුමාය.", "ජාතියේ පියාය.")
        3 -> Quintuple("සෝල්බරි ආණ්ඩුක්‍රමය යටතේ පාර්ලිමේන්තුවේ සභා දෙක මොනවාද?", "Two houses of parliament under Soulbury Constitution?", listOf("නියෝජිත මන්ත්‍රී මණ්ඩලය", "සෙනෙට් සභාව"), "නියෝජිත මන්ත්‍රී මණ්ඩලය සහ සෙනෙට් සභාව (ද්වි මණ්ඩල ක්‍රමය) වේ.", "ද්විමණ්ඩලයයි.")
        else -> Quintuple("සෝල්බරි ආණ්ඩුක්‍රමයේ සුළුතර ජාතීන්ගේ අයිතිවාසිකම් රැකීමට තිබූ වගන්තිය කුමක්ද?", "Section protecting minority rights in Soulbury Constitution?", listOf("29 වන වගන්තිය", "29", "Section 29"), "29 (2) වගන්තිය වේ.", "29 වැනි වගන්තියයි.")
      }

      // Set 6: 1972 සහ 1978 ආණ්ඩුක්‍රම ව්‍යවස්ථා
      6 -> when (qIndex) {
        1 -> Quintuple("ශ්‍රී ලංකාව නිදහස් ස්වෛරී ජනරජයක් බවට පත් වූයේ කුමන වර්ෂයේදීද?", "When did Sri Lanka become a Republic?", listOf("1972", "1972 දී", "1972 මැයි 22"), "1972 මැයි 22 වන දිනදීය.", "1972 ජනරජ ව්‍යවස්ථාවයි.")
        2 -> Quintuple("1972 ජනරජ ව්‍යවස්ථාව සම්පාදනය කළ අග්‍රාමාත්‍යවරිය කවුද?", "Prime Minister who introduced 1972 Constitution?", listOf("සිරිමාවෝ බණ්ඩාරනායක", "සිරිමාවෝ"), "සිරිමාවෝ බණ්ඩාරනායක මැතිණියයි.", "ලොව ප්‍රථම අගමැතිනියයි.")
        3 -> Quintuple("1978 ආණ්ඩුක්‍රම ව්‍යවස්ථාව මඟින් හඳුන්වා දුන් ප්‍රධාන පාලන තනතුර කුමක්ද?", "Key executive post created by 1978 Constitution?", listOf("විධායක ජනාධිපති", "විධායක ජනාධිපති ධුරය"), "විධායක ජනාධිපති ධුරය වේ.", "රාජ්‍ය නායකයාය.")
        else -> Quintuple("ශ්‍රී ලංකාවේ ප්‍රථම විධායක ජනාධිපතිවරයා කවුද?", "First Executive President of Sri Lanka?", listOf("ජේ. ආර්. ජයවර්ධන", "ජයවර්ධන", "J. R. Jayewardene"), "ජේ. ආර්. ජයවර්ධන මැතිතුමාය.", "1978 දී පත්විය.")
      }

      // Set 7: කාර්මික විප්ලවය & යුරෝපයේ පිබිදීම
      7 -> when (qIndex) {
        1 -> Quintuple("කාර්මික විප්ලවය ප්‍රථමයෙන්ම ආරම්භ වූ රට කුමක්ද?", "Country where Industrial Revolution began?", listOf("එංගලන්තය", "බ්‍රිතාන්‍යය", "England"), "එංගලන්තය (බ්‍රිතාන්‍යය) වේ.", "යුරෝපයේය.")
        2 -> Quintuple("කාර්මික විප්ලවයේදී වාෂ්ප එන්ජිම වැඩිදියුණු කළ නව නිපැයුම්කරු කවුද?", "Inventor who perfected steam engine?", listOf("ජේම්ස් වොට්", "James Watt"), "ජේම්ස් වොට් (James Watt) මහතාය.", "වාෂ්ප බලයයි.")
        else -> Quintuple("කාර්මික විප්ලවයේ ප්‍රථමයෙන්ම යාන්ත්‍රීකරණය වූ කර්මාන්තය කුමක්ද?", "First industry mechanized in Industrial Revolution?", listOf("රෙදිපිළි", "රෙදිපිළි කර්මාන්තය", "Textile"), "රෙදිපිළි (කපු ඇඟලුම්) කර්මාන්තය වේ.", "රෙදි විවීමයි.")
      }

      // Set 8: පළමු හා දෙවන ලෝක යුද්ධ
      8 -> when (qIndex) {
        1 -> Quintuple("පළමු ලෝක යුද්ධය පැවති කාලසීමාව කුමක්ද?", "Years of the First World War?", listOf("1914 - 1918", "1914 සිට 1918", "1914"), "ක්‍රි.ව. 1914 සිට 1918 දක්වාය.", "1914-1918.")
        2 -> Quintuple("දෙවන ලෝක යුද්ධය පැවති කාලසීමාව කුමක්ද?", "Years of the Second World War?", listOf("1939 - 1945", "1939 සිට 1945", "1939"), "ක්‍රි.ව. 1939 සිට 1945 දක්වාය.", "1939-1945.")
        3 -> Quintuple("දෙවන ලෝක යුද්ධයේදී ඇමරිකාව පරමාණු බෝම්බ හෙළූ ජපාන නගර 2 මොනවාද?", "Two Japanese cities hit by atomic bombs in WWII?", listOf("හිරෝෂිමා සහ නාගසාකි", "හිරෝෂිමා", "නාගසාකි"), "හිරෝෂිමා සහ නාගසාකි නගර වේ.", "1945 අගෝස්තු මසදීය.")
        else -> Quintuple("දෙවන ලෝක යුද්ධයේදී නාසි ජර්මනියේ නායකයා වූයේ කවුද?", "Leader of Nazi Germany in WWII?", listOf("හිට්ලර්", "ඇඩොල්ෆ් හිට්ලර්", "Hitler"), "ඇඩොල්ෆ් හිට්ලර් (Adolf Hitler) ය.", "නාසි නායකයාය.")
      }

      // Set 9: එක්සත් ජාතීන්ගේ සංවිධානය (UN)
      9 -> when (qIndex) {
        1 -> Quintuple("එක්සත් ජාතීන්ගේ සංවිධානය (UN) පිහිටවූ දිනය කුමක්ද?", "United Nations Charter date?", listOf("1945 ඔක්තෝබර් 24", "1945", "ඔක්තෝබර් 24"), "1945 ඔක්තෝබර් 24 වන දිනදීය.", "UN දිනයයි.")
        2 -> Quintuple("එක්සත් ජාතීන්ගේ සංවිධානයේ මූලස්ථානය පිහිටා ඇත්තේ කොහේද?", "Headquarters of the United Nations?", listOf("නිව්යෝර්ක්", "New York", "ඇමරිකාව"), "ඇමරිකාවේ නිව්යෝර්ක් නුවරය.", "නිව්යෝර්ක් නුවරයි.")
        3 -> Quintuple("එක්සත් ජාතීන්ගේ ආරක්ෂක මණ්ඩලයේ ස්ථිර සාමාජික රටවල් ගණන කීයද?", "Number of permanent members in UN Security Council?", listOf("5ක්", "පහයි", "5"), "රටවල් පහකි (ඇමරිකාව, බ්‍රිතාන්‍යය, ප්‍රංශය, රුසියාව, චීනය).", "නිශේධ බලය හිමි 5යි.")
        else -> Quintuple("ශ්‍රී ලංකාවට එක්සත් ජාතීන්ගේ සාමාජිකත්වය ලැබුණේ කුමන වර්ෂයේදීද?", "When did Sri Lanka join the UN?", listOf("1955", "1955 දී"), "ක්‍රි.ව. 1955 දෙසැම්බර් මසදීය.", "1955 වසරයි.")
      }

      // Set 10: නිදහසින් පසු ශ්‍රී ලංකාවේ ආර්ථිකය
      else -> when (qIndex) {
        1 -> Quintuple("නිදහසින් පසු ශ්‍රී ලංකාවේ ආරම්භ කළ ප්‍රථම දැවැන්ත බහුකාර්ය ව්‍යාපාරය කුමක්ද?", "First major multipurpose project in independent Sri Lanka?", listOf("ගල්ඔය", "ගල්ඔය ව්‍යාපාරය", "Gal Oya"), "ගල්ඔය සංවර්ධන ව්‍යාපාරය වේ.", "සේනානායක සමුද්‍රයයි.")
        2 -> Quintuple("ශ්‍රී ලංකා මහ බැංකුව ආරම්භ කළ වර්ෂය කුමක්ද?", "When was the Central Bank of Sri Lanka established?", listOf("1950", "1950 දී"), "ක්‍රි.ව. 1950 දී වේ.", "1950 වසරයි.")
        3 -> Quintuple("ලංකාවේ දීර්ඝතම ගංගාව වන මහවැලි ගඟ ආශ්‍රිත දැවැන්ත සංවර්ධන ව්‍යාපාරය කුමක්ද?", "Massive development project along Mahaweli river?", listOf("මහවැලි ව්‍යාපාරය", "කඩිනම් මහවැලි", "Mahaweli"), "කඩිනම් මහවැලි සංවර්ධන ව්‍යාපාරය වේ.", "විදුලිය හා ජලය ලබාදුණි.")
        else -> Quintuple("ශ්‍රී ලංකාවට නිදහස් අධ්‍යාපන පනත හඳුන්වා දුන් 'නිදහස් අධ්‍යාපනයේ පියා' කවුද?", "Father of Free Education in Sri Lanka?", listOf("සී. ඩබ්. ඩබ්. කන්නන්ගර", "කන්නන්ගර", "Kannangara"), "ආචාර්ය සී. ඩබ්. ඩබ්. කන්නන්ගර මැතිතුමාය.", "1945 දී නිදහස් අධ්‍යාපනය ලබාදුන්නේය.")
      }
    }
  }
}

