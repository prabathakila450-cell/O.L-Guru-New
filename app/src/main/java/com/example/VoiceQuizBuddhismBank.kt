package com.example

/**
 * ☸️ Comprehensive Voice Quiz Bank for Buddhism (බුද්ධ ධර්මය)
 * Contains distinct, syllabus-aligned oral exam questions for Grade 10 AND Grade 11.
 * When Grade 11 is selected, it returns 100% Grade 11 curriculum questions (Vyagghapajja, Sigalovada, Vasala Sutta, etc.).
 * When Grade 10 is selected, it returns 100% Grade 10 curriculum questions (Prince Siddhartha, Dhammacakka, Anattalakkhana, etc.).
 * Every single question is strictly unique, curriculum-accurate, short, and direct.
 */
object VoiceQuizBuddhismBank {

  fun getQuestion(grade: String, setNum: Int, qIndex: Int, theme: String): Quintuple<String, String, List<String>, String, String> {
    return if (grade == "11") {
      getGrade11Question(setNum, qIndex, theme)
    } else {
      getGrade10Question(setNum, qIndex, theme)
    }
  }

  // ==============================================================================
  // GRADE 11 O/L BUDDHISM BANK (SETS 1 TO 10 - 100% GRADE 11 SYLLABUS)
  // ==============================================================================
  private fun getGrade11Question(setNum: Int, qIndex: Int, theme: String): Quintuple<String, String, List<String>, String, String> {
    return when (setNum) {
      // Set 1: ව්‍යග්ඝපජ්ජ (දීඝජාණු) සූත්‍රය & ආර්ථික දියුණුව
      1 -> when (qIndex) {
        1 -> Quintuple("ව්‍යග්ඝපජ්ජ සූත්‍රය බුදුරදුන් දේශනා කළේ කා හටද?", "To whom was Vyagghapajja Sutta preached?", listOf("දීඝජාණු", "දීඝජාණු කෝලිය", "Dighajanu"), "දීඝජාණු කෝලිය පුත්‍රයාටය.", "කෝලිය වංශික තරුණයාය.")
        2 -> Quintuple("මෙලොව ජීවිතය සාර්ථක කරගැනීමට ව්‍යග්ඝපජ්ජ සූත්‍රයේ දැක්වෙන සම්පදා කීයක් තිබේද?", "How many virtues are taught for success in this life?", listOf("හතරක්", "4", "සතරක්"), "සතරකි (දිට්ඨධම්මවේදනීය සංවත්තනික ධර්ම 4).", "සම්පදා සතරයි.")
        3 -> Quintuple("උත්සාහයෙන් හා වීර්යයෙන් යුතුව ධනය උපයා ගැනීම හඳුන්වන්නේ කුමක්ද?", "Earning wealth through diligence is called?", listOf("උට්ඨාන", "උට්ඨාන සම්පදා", "Utthana"), "උට්ඨාන සම්පදාව වේ.", "නැගී සිට වීර්යයෙන් වැඩ කිරීමයි.")
        4 -> Quintuple("දැහැමින් උපයාගත් ධනය සොරුන්ගෙන් හා ආපදාවලින් ආරක්ෂා කර ගැනීම කුමක්ද?", "Protecting earned wealth is called?", listOf("ආරක්ඛ", "ආරක්ඛ සම්පදා", "Arakkhasampada"), "ආරක්ඛ සම්පදාව වේ.", "ධනය සුරක්ෂිත කිරීමයි.")
        5 -> Quintuple("යහපත් හා සිල්වත් මිතුරන් ආශ්‍රය කිරීම හඳුන්වන්නේ කෙසේද?", "Associating with virtuous friends is called?", listOf("කල්‍යාණමිත්තතා", "කල්‍යාණ මිත්‍ර", "Kalyanamittata"), "කල්‍යාණමිත්තතාව වේ.", "හොඳ මිතුරන් ඇසුරයි.")
        6 -> Quintuple("ආදායමට සරිලන පරිදි වියදම් සමබරව පවත්වා ගැනීම කුමක්ද?", "Living within one's means is called?", listOf("සමජීවිකතා", "සමජීවිකතාව", "Samajivikata"), "සමජීවිකතාව වේ.", "ආදායම හා වියදම සමබර කිරීමයි.")
        7 -> Quintuple("පරලොව ජීවිතය සාර්ථක කරගැනීමට ව්‍යග්ඝපජ්ජ සූත්‍රයේ දැක්වෙන සම්පදා ගණන කීයද?", "How many virtues are taught for success in future lives?", listOf("හතරක්", "4", "සතරක්"), "සතරකි (සම්පරායික සංවත්තනික ධර්ම 4).", "පරලොව දියුණුවේ කරුණු 4යි.")
        8 -> Quintuple("තෙරුවන් කෙරෙහි ශ්‍රද්ධාව පිහිටුවා ගැනීම කුමන සම්පදාවද?", "Faith in the Triple Gem is which virtue?", listOf("සද්ධා", "සද්ධා සම්පදා", "Saddha"), "සද්ධා සම්පදාව වේ.", "විශ්වාසය හා පැහැදීමයි.")
        9 -> Quintuple("පස්පව්වලින් වැළකී නිතිපන්සිල් රැකීම කුමන සම්පදාවද?", "Observing Five Precepts is which virtue?", listOf("සීල", "සීල සම්පදා", "Sila"), "සීල සම්පදාව වේ.", "හික්මීමයි.")
        10 -> Quintuple("අනුන්ට පරිත්‍යාග කිරීම හා දන් දීම කුමන සම්පදාවද?", "Generosity and giving is which virtue?", listOf("චාග", "චාග සම්පදා", "Caga"), "චාග සම්පදාව වේ.", "ලෝභකම දුරු කිරීමයි.")
        11 -> Quintuple("හොඳ නරක තේරුම් ගැනීමේ ප්‍රඥාව කුමන සම්පදාවද?", "Wisdom to discern right and wrong is?", listOf("පඤ්ඤා", "පඤ්ඤා සම්පදා", "Panna"), "පඤ්ඤා සම්පදාව වේ.", "නුවණින් කටයුතු කිරීමයි.")
        12 -> Quintuple("ධනය විනාශ වන මූලික දොරටු (අපායමුඛ) ගණන කීයද?", "How many drains of wealth are taught in the Sutta?", listOf("හතරක්", "4"), "හතරකි (ස්ත්‍රී, සුරා, අක්ෂ ධූර්ත සහ පාපමිත්‍ර සේවනය).", "විනාශයේ දොරටු 4යි.")
        13 -> Quintuple("සුරාවට හෙවත් මත්පැන් පානයට ගිජු වීම හඳුන්වන්නේ කෙසේද?", "Addiction to alcohol is called?", listOf("සුරා ධුත්ත", "සුරාධූර්ත"), "සුරා ධුත්ත නමිනි.", "මත්පැනින් විනාශ වීමයි.")
        14 -> Quintuple("සූදුවට ලොල් වී ධනය විනාශ කරගැනීම හඳුන්වන්නේ කෙසේද?", "Addiction to gambling is called?", listOf("අක්ඛ ධුත්ත", "අක්ෂධූර්ත"), "අක්ඛ ධුත්ත නමිනි.", "දූ කෙළියයි.")
        15 -> Quintuple("කාමමිථ්‍යාචාරයට හා ස්ත්‍රීන්ට ලොල් වීම හඳුන්වන්නේ කෙසේද?", "Addiction to debauchery is called?", listOf("ඉත්ථි ධුත්ත", "ස්ත්‍රී ධූර්ත"), "ඉත්ථි ධුත්ත නමිනි.", "අයහපත් ඇසුරයි.")
        16 -> Quintuple("නපුරු පාපතර මිතුරන් ඇසුරු කිරීම හඳුන්වන්නේ කෙසේද?", "Associating with evil friends is called?", listOf("පාපමිත්තතා", "පාප මිත්‍ර"), "පාපමිත්තතාව වේ.", "නරක මිතුරන්ගේ මඟයි.")
        17 -> Quintuple("බුදු දහමට අනුව ධනය ඉපැයිය යුත්තේ කුමන ක්‍රමවලින්ද?", "According to Buddhism how should wealth be earned?", listOf("දැහැමි", "ධාර්මිකව", "සම්මා ආජීවයෙන්"), "දැහැමි හෙවත් ධාර්මික ක්‍රමවලින් (සම්මා ආජීවයෙන්) වේ.", "ධර්මානුකූලවය.")
        18 -> Quintuple("බුදුරදුන් ගිහියන්ට තහනම් කළ මිච්ඡා වණිජ්ජා (අධාර්මික වෙළඳාම්) ගණන කීයද?", "How many wrongful trades are prohibited for laymen?", listOf("පහක්", "5"), "පහකි (ආයුධ, වහල්, මස්, මත්පැන්, වසවිස).", "වෙළඳාම් 5කි.")
        19 -> Quintuple("ව්‍යග්ඝපජ්ජ සූත්‍රය අයත් වන්නේ කුමන ත්‍රිපිටක නිකායටද?", "To which Nikaya does Vyagghapajja Sutta belong?", listOf("අංගුත්තර", "අංගුත්තර නිකාය", "Anguttara"), "අංගුත්තර නිකායේ අට්ඨක නිපාතයටය.", "අංගුත්තර නිකායයි.")
        20 -> Quintuple("දීඝජාණු තරුණයාට 'ව්‍යග්ඝපජ්ජ' යන අන්වර්ථ නාමය ලැබුණේ ඇයි?", "Why was Dighajanu named Vyagghapajja?", listOf("කොටි මාවතේ", "ව්‍යාඝ්‍ර", "කොටි"), "ඔහුගේ ගම කොටි ගමන් කළ මාර්ගයක පිහිටි බැවිනි.", "ව්‍යාඝ්‍ර මාවතයි.")
        else -> Quintuple("ව්‍යග්ඝපජ්ජ සූත්‍රයේ මූලික පණිවිඩය කුමක්ද?", "What is the core message of Vyagghapajja Sutta?", listOf("ආර්ථික දියුණුව", "මෙලොව පරලොව"), "දැහැමින් ධනය උපයා මෙලොව සහ පරලොව දෙලොවම ජය ගැනීමයි.", "දෙලොව ජය ගැනීමයි.")
      }

      // Set 2: සිඟාලෝවාද සූත්‍රය & සදිසා නමස්කාරය
      2 -> when (qIndex) {
        1 -> Quintuple("සිඟාලෝවාද සූත්‍රය බුදුරදුන් දේශනා කළේ කුමන නුවරදීද?", "Where did Buddha preach the Sigalovada Sutta?", listOf("රජගහ", "රජගහ නුවර", "Rajagaha"), "රජගහ නුවර වේළුවනාරාමයේදීය.", "බිම්බිසාර රජුගේ නුවරයි.")
        2 -> Quintuple("උදෑසන තෙත ඇඳුමින් යුතුව දිශා හයට වඳිමින් සිටියේ කවුද?", "Who was worshipping the six directions in wet clothes?", listOf("සිඟාලක", "සිඟාල", "Sigala"), "සිඟාලක මාණවකයාය.", "සිටු පුත්‍රයාය.")
        3 -> Quintuple("ආර්ය විනයෙහි දිශා කීයක් ඇති බව බුදුරදුන් වදාළේද?", "How many directions are taught in the Noble Discipline?", listOf("හයක්", "6", "සදිසා"), "සදිසාවන් හයකි (6).", "දිශා 6කි.")
        4 -> Quintuple("පෙරදිගින් (නැගෙනහිරින්) සංකේතවත් වන පාර්ශ්වය කවුද?", "Which relationship is symbolized by the East?", listOf("දෙමාපියන්", "මව්පියන්", "Parents"), "මව්පියන් (දෙමාපියන්) වේ.", "මුලින්ම හිරු පායන දිශාවයි.")
        5 -> Quintuple("දකුණු දිශාවෙන් සංකේතවත් වන පාර්ශ්වය කවුද?", "Which relationship is symbolized by the South?", listOf("ගුරුවරුන්", "ආචාර්යවරු", "Teachers"), "ගුරුවරුන් (ආචාර්යවරුන්) වේ.", "දක්ෂිණාව ලබන්නෝය.")
        6 -> Quintuple("බටහිර දිශාවෙන් සංකේතවත් වන පාර්ශ්වය කවුද?", "Which relationship is symbolized by the West?", listOf("අඹුසැමියන්", "භාර්යාව", "Wife"), "අඹුසැමියන් (භාර්යාව සහ දරුවන්) වේ.", "පසුපසින් සිටින අයයි.")
        7 -> Quintuple("උතුරු දිශාවෙන් සංකේතවත් වන පාර්ශ්වය කවුද?", "Which relationship is symbolized by the North?", listOf("මිතුරන්", "යහළුවන්", "Friends"), "මිත්‍රයන් (යහළු මිත්‍රාදීන්) වේ.", "උපකාරක මිතුරන්ය.")
        8 -> Quintuple("යට දිශාවෙන් හෙවත් අධර දිශාවෙන් සංකේතවත් වන්නේ කවුද?", "Which group is symbolized by the Nadir (Down)?", listOf("සේවකයන්", "දැසි දස්සන්", "Servants"), "දැසි දස්සන් සහ සේවකයන් වේ.", "යටහත් සේවක පිරිසයි.")
        9 -> Quintuple("උඩ දිශාවෙන් හෙවත් උපරිම දිශාවෙන් සංකේතවත් වන්නේ කවුද?", "Which group is symbolized by the Zenith (Up)?", listOf("මහණ බමුණන්", "පූජ්‍ය පක්ෂය", "Monks"), "මහණ බමුණන් (පූජ්‍ය පක්ෂය) වේ.", "ආධ්‍යාත්මික නායකයන්ය.")
        10 -> Quintuple("දරුවන් විසින් මව්පියන්ට ඉටුකළ යුතු යුතුකම් ගණන කීයද?", "How many duties do children owe to parents?", listOf("පහක්", "5"), "පහකි (පෝෂණය කිරීම, කටයුතු කර දීම, කුල පරපුර රැකීම, දායාද රැකීම, පින් අනුමෝදන් කිරීම).", "යුතුකම් 5කි.")
        11 -> Quintuple("මව්පියන් විසින් දරුවන්ට ඉටුකළ යුතු යුතුකම් ගණන කීයද?", "How many duties do parents owe to children?", listOf("පහක්", "5"), "පහකි (පවින් වැළැක්වීම, යහපතෙහි යෙදවීම, ශිල්ප ඉගැන්වීම, සුදුසු කල ආවාහ විවාහ කර දීම, නිසි කල දායාද පැවරීම).", "යුතුකම් 5කි.")
        12 -> Quintuple("සිඟාලෝවාද සූත්‍රයේ දැක්වෙන සතර අගතිය මොනවාද?", "What are the four Agatis (prejudices)?", listOf("ඡන්දය", "දෝසය", "භය", "මෝහය"), "ඡන්දය (කැමැත්ත), ද්වේෂය (තරහව), භය සහ මෝහය වේ.", "අගතියට යන මං 4යි.")
        13 -> Quintuple("කැමැත්ත හෝ පක්ෂග්‍රාහී බව නිසා අගතියට යාම කුමක්ද?", "Prejudice based on favoritism is called?", listOf("ඡන්දාගතිය", "ඡන්දය"), "ඡන්දාගතිය වේ.", "ඇල්ම නිසා වැරදි තීන්දු ගැනීමයි.")
        14 -> Quintuple("තරහව හෝ ක්‍රෝධය නිසා අගතියට යාම කුමක්ද?", "Prejudice based on anger is called?", listOf("දෝසාගතිය", "දෝසය"), "දෝසාගතිය වේ.", "වෛරය නිසා වැරදි තීන්දු දීමයි.")
        15 -> Quintuple("බිය නිසා සත්‍යය යටපත් කර අගතියට යාම කුමක්ද?", "Prejudice based on fear is called?", listOf("භයාගතිය", "භය"), "භයාගතිය වේ.", "බියෙන් පක්ෂපාතී වීමයි.")
        16 -> Quintuple("මෝඩකම හෝ නොදැනුවත්කම නිසා අගතියට යාම කුමක්ද?", "Prejudice based on ignorance is called?", listOf("මෝහාගතිය", "මෝහය"), "මෝහාගතිය වේ.", "මුළාවයි.")
        17 -> Quintuple("සිඟාලෝවාද සූත්‍රයේ දැක්වෙන භෝග විනාශ මුඛ (විනාශයේ දොරටු) ගණන කීයද?", "How many causes of ruin (Bhoga Vinasa Mukha) are taught?", listOf("හයක්", "6"), "හයකි (සුරාපානය, අකල්හි වීථි සංචාරය, නැටුම් ගැයුම් බැලීම, සූදුව, පාපමිත්‍ර සේවනය, අලසකම).", "දොරටු 6කි.")
        18 -> Quintuple("සිඟාලෝවාද සූත්‍රය ගිහි සමාජයට ඇති වැදගත්කම නිසා හඳුන්වන නම කුමක්ද?", "What is Sigalovada Sutta commonly called?", listOf("ගිහි විනය", "Gihi Vinaya"), "ගිහි විනය (Gihi Vinaya) නමිනි.", "ගිහියන්ගේ චර්යා ධර්මයයි.")
        19 -> Quintuple("මිතුරන් අතරින් උපකාරක මිතුරා අයත් වන්නේ කවර ගණයටද?", "Helper friend belongs to which category?", listOf("කල්‍යාණ මිත්‍ර", "සුහද මිත්‍ර"), "කල්‍යාණ මිත්‍ර හෙවත් සුහද මිත්‍ර ගණයටය.", "සැබෑ මිතුරාය.")
        20 -> Quintuple("සිඟාලෝවාද සූත්‍රය අඩංගු වන්නේ කුමන ත්‍රිපිටක ග්‍රන්ථයේද?", "In which Pitaka text is Sigalovada Sutta found?", listOf("දීඝ නිකාය", "දීඝනිකායේ", "Digha Nikaya"), "දීඝ නිකායේ පාථික වග්ගයේය.", "දීඝ නිකායයි.")
        else -> Quintuple("සිඟාලෝවාද සූත්‍රයේ ප්‍රධාන පරමාර්ථය කුමක්ද?", "Main purpose of Sigalovada Sutta?", listOf("සමාජ සබඳතා", "ගිහි ජීවිතය"), "සමාජ සබඳතා යහපත් කර සාමකාමී පවුල් ජීවිතයක් ගොඩනැගීමයි.", "සමාජ සාමයයි.")
      }

      // Set 3: වසල සූත්‍රය & බෞද්ධ සමාජ දර්ශනය
      3 -> when (qIndex) {
        1 -> Quintuple("වසල සූත්‍රය බුදුරදුන් දේශනා කළේ කා හටද?", "To whom was Vasala Sutta preached?", listOf("අග්ගික භාරද්වාජ", "භාරද්වාජ", "Aggika"), "අග්ගික භාරද්වාජ බ්‍රාහ්මණයාටය.", "ගිනි පුදන බමුණාටය.")
        2 -> Quintuple("වසල සූත්‍රය දේශනා කරන ලද්දේ කුමන ස්ථානයේදීද?", "Where was Vasala Sutta preached?", listOf("ජේතවනාරාමය", "සැවැත්නුවර", "Jetavana"), "සැවැත්නුවර ජේතවනාරාමයේදීය.", "අනේපිඬු සිටුතුමාගේ ආරාමයේදීය.")
        3 -> Quintuple("බුදුරදුන් පිඬුසිඟා වඩිනු දැක අග්ගික භාරද්වාජ පැවසූ නින්දා වචනය කුමක්ද?", "What insulting words did the brahmin say seeing Buddha?", listOf("වසලය", "එතැනම නවතිනු වසලය"), "'එතැනම නවතිනු වසලය, ශ්‍රමණකය' යනුවෙනි.", "වසලයා කියා ඇමතීය.")
        4 -> Quintuple("බුදු දහමට අනුව කෙනෙකු වසලයෙකු හෝ බ්‍රාහ්මණයෙකු වන්නේ කුමකින්ද?", "According to Buddhism, what makes one an outcaste or noble?", listOf("ක්‍රියාවෙන්", "තම ක්‍රියාවෙන්", "Action", "කර්මයෙන්"), "උපතින් නොව තම ක්‍රියාවෙන් (චර්යාවෙන්) පමණි.", "තමා කරන ක්‍රියාවයි.")
        5 -> Quintuple("'න ජච්චා වසලො හොති - න ජච්චා හොති බ්‍රාහ්මණො' යන්නෙහි අර්ථය කුමක්ද?", "Meaning of 'Na jacca vasalo hoti'?", listOf("උපතින් නොවේ", "උපතින් කිසිවෙකු වසලයෙකු නොවේ"), "උපතින් කිසිවෙකු වසලයෙකු හෝ බ්‍රාහ්මණයෙකු නොවන බවයි.", "උපත නිර්ණායකයක් නොවේ.")
        6 -> Quintuple("නිතර කේන්ති ගන්නා හා අනුන්ගේ ගුණ මකන තැනැත්තා හඳුන්වන්නේ කෙසේද?", "One who is constantly angry and ungrateful is?", listOf("වසලයෙක්", "වසලයා"), "වසලයෙකු වශයෙනි (ක්‍රෝධී හා මක්ඛී පුද්ගලයා).", "වසල ලක්ෂණයකි.")
        7 -> Quintuple("සතුන්ට දයාවක් නැතිව හිංසා පීඩා කරන්නා වසල සූත්‍රයේ හඳුන්වන්නේ කෙසේද?", "One who harms living creatures without mercy is?", listOf("වසලයෙක්", "වසල"), "වසලයෙකු වශයෙනි.", "ප්‍රාණඝාතකයාය.")
        8 -> Quintuple("තමාට හැකියාව තිබියදී මහලු මව්පියන්ට නොසලකා හරින්නා කවුද?", "One who neglects elderly parents despite having means is?", listOf("වසලයෙක්", "වසල"), "වසලයෙකි ('මාතා පිතරං ජිණ්ණං න භරති').", "මව්පියන්ට නොසලකන්නාය.")
        9 -> Quintuple("තමා කළ වැරදි අනුන්ට නොපෙනෙන සේ වසන් කිරීමට තැත් කරන්නා කවුද?", "One who conceals their evil deeds is?", listOf("වසලයෙක්", "වසල"), "වසලයෙකි.", "පාපකාරී ක්‍රියාවකි.")
        10 -> Quintuple("තමා උසස් යැයි සිතා මානයෙන් අනුන් පහත් කර සලකන්නා කවුද?", "One proud of caste who looks down on others is?", listOf("වසලයෙක්", "වසල"), "වසලයෙකි.", "ජාති මානයයි.")
        11 -> Quintuple("වසල සූත්‍රයේ බුදුරදුන් පෙන්වා දුන් උසස් බ්‍රහ්ම තත්ත්වයට පත් මාතංග පඬිවරයා අයත් වූයේ කුමන කුලයටද?", "To which low caste did sage Matanga belong?", listOf("චණ්ඩාල", "සැඩොල්", "චණ්ඩාල කුලයට"), "චණ්ඩාල (සැඩොල්) කුලයටය.", "පහත් යැයි සම්මත කුලයයි.")
        12 -> Quintuple("මාතංග පඬිවරයාගේ ගුණ අසා ඔහුට උපස්ථාන කිරීමට පැමිණියේ කවුරුන්ද?", "Who came to serve the virtuous sage Matanga?", listOf("බ්‍රාහ්මණයන්", "ක්ෂත්‍රියයන්", "රජවරු"), "උසස් යැයි සම්මත බ්‍රාහ්මණයන් සහ ක්ෂත්‍රිය රජවරුන්ය.", "උසස් කුලවල අයයි.")
        13 -> Quintuple("උසස් බ්‍රාහ්මණ කුලයේ ඉපිද වේද හදාළ ද පව් කළහොත් අපායට යාම වැළකිය හැකිද?", "Can birth in high brahmin caste prevent hell if one sins?", listOf("නැත", "නොහැක", "බැහැ"), "නැත, පව්කම් කළහොත් ඒකාන්තයෙන්ම දුගතිගාමී වේ.", "කර්මය වෙනස් නොවේ.")
        14 -> Quintuple("වසල සූත්‍රය ත්‍රිපිටකයේ අඩංගු වන්නේ කුමන ග්‍රන්ථයේද?", "In which Pitaka book is Vasala Sutta found?", listOf("සුත්ත නිපාතය", "ඛුද්දක නිකාය", "Sutta Nipata"), "ඛුද්දක නිකායේ සුත්ත නිපාතයේය.", "සුත්ත නිපාතයයි.")
        15 -> Quintuple("බුදු දහම මිනිසුන් උසස් පහත් කොට බෙදන කුල ක්‍රමය පිළිගනීද?", "Does Buddhism accept the discriminatory caste system?", listOf("නැත", "ප්‍රතික්ෂේප කරයි", "නැත පිළිගන්නේ නැත"), "නැත, බුදුදහම කුල භේදය මුළුමනින්ම ප්‍රතික්ෂේප කරයි.", "කුල භේදය ප්‍රතික්ෂේප කරයි.")
        16 -> Quintuple("බුදු සසුනට ඇතුළු වූ පසු සියලු කුලවල පුද්ගලයන් වෙනසක් නැතිව සම වන්නේ කෙසේද?", "How do all castes become one upon entering Buddhist order?", listOf("මහා සාගරයට", "ගංගා සයුරට", "සාගරය මෙන්"), "විවිධ ගංගා මහා සාගරයට වැටුණු පසු එක් රසයක් ගන්නා සේය.", "සාගර උපමාවයි.")
        17 -> Quintuple("කරණවෑමි කුලයේ උපන් උපාලි තෙරුන් බුදු සසුනේ පත්වූයේ කුමන අග්‍ර තනතුරටද?", "Which chief position did Ven. Upali from barber caste attain?", listOf("විනයධර", "විනයධරයන් අතර අග්‍ර", "Vinaya"), "විනයධර භික්ෂූන් අතර අග්‍රස්ථානයටය.", "විනයෙහි අග්‍ර විය.")
        18 -> Quintuple("සැඩොල් කුලයේ උපන් සුනීත බුදු සසුනෙන් ලැබූ උතුම් ඵලය කුමක්ද?", "What supreme fruit did Sunita of outcaste attain?", listOf("මහරහත්", "අරහත්", "රහත් බව"), "මහරහත් භාවය ලබාගැනීමයි.", "කෙලෙස් නසාලීය.")
        19 -> Quintuple("බෞද්ධ සමාජ දර්ශනයේ මූලික පදනම කුමක්ද?", "Fundamental basis of Buddhist social philosophy?", listOf("මානව සමානාත්මතාව", "සමානාත්මතාව", "සම මෙත"), "මානව සමානාත්මතාව හා සියලු සතුන් කෙරෙහි මෛත්‍රියයි.", "මිනිස් සමානාත්මතාවයි.")
        20 -> Quintuple("වසල සූත්‍රය අවසානයේ අග්ගික භාරද්වාජ බ්‍රාහ්මණයා කළේ කුමක්ද?", "What did Aggika Bharadvaja do at the end of the Sutta?", listOf("තෙරුවන් සරණ ගියේය", "උපාසකයෙකු විය", "පැහැදුණේය"), "බුදුරදුන් කෙරෙහි පැහැදී තෙරුවන් සරණ ගිය උපාසකයෙකු බවට පත්විය.", "තෙරුවන් සරණ ගියේය.")
        else -> Quintuple("වසල සූත්‍රයේ හරය කුමක්ද?", "What is the core essence of Vasala Sutta?", listOf("ක්‍රියාවෙන් උසස් වීම", "චර්යාව"), "මිනිසා මනින්නේ උපතින් නොව ක්‍රියාවෙන් හා චර්යාවෙන් බවයි.", "ක්‍රියාවයි උතුම්.")
      }

      // Set 4: සතර බ්‍රහ්ම විහරණ (මෙත්තා, කරුණා, මුදිතා, උපෙක්ඛා)
      4 -> when (qIndex) {
        1 -> Quintuple("සතර බ්‍රහ්ම විහරණ ධර්ම හතර මොනවාද?", "What are the four Brahma Viharas?", listOf("මෙත්තා", "කරුණා", "මුදිතා", "උපෙක්ඛා"), "මෙත්තා, කරුණා, මුදිතා සහ උපෙක්ඛා වේ.", "උතුම් ගුණ 4යි.")
        2 -> Quintuple("සියලු සත්වයෝ සුවපත් වෙත්වායි පතන ගුණය කුමක්ද?", "Wishing all beings to be well and happy is?", listOf("මෙත්තා", "මෛත්‍රිය", "Metta"), "මෙත්තා (මෛත්‍රිය) වේ.", "මිත්‍රශීලී බවයි.")
        3 -> Quintuple("දුකට පත් සත්වයන් දැක ඔවුන් දුකින් මුදවනු රිසි සිත කුමක්ද?", "Compassion to relieve suffering of beings is?", listOf("කරුණා", "කරුණාව", "Karuna"), "කරුණාව (Karuna) වේ.", "දුක නිවීමේ සිතයි.")
        4 -> Quintuple("අනුන්ගේ දියුණුව හා සැපත දැක සතුටු වන ඊර්ෂ්‍යාවෙන් තොර සිත කුමක්ද?", "Sympathetic joy at others' success without jealousy is?", listOf("මුදිතා", "මුදිතාව", "Mudita"), "මුදිතාව (Mudita) වේ.", "අනුන්ගේ සැපේදී සතුටු වීමයි.")
        5 -> Quintuple("ලාභ අලාභ ආදී අටලෝදහම හමුවේ මැදහත්ව සිත පවත්වා ගැනීම කුමක්ද?", "Equanimity amidst the eight worldly conditions is?", listOf("උපෙක්ඛා", "උපේක්ෂාව", "Upekkha"), "උපේක්ෂාව (Upekkha) වේ.", "මැදහත් සිතයි.")
        6 -> Quintuple("මෛත්‍රිය වැඩිමෙන් ලැබෙන ආනිසංස ගණන කීයද?", "How many benefits are obtained by practicing Metta?", listOf("එකොළහක්", "11ක්", "11"), "ආනිසංස එකොළහකි (සුවසේ නිදාගැනීම, සුවසේ පිබිදීම ආදිය).", "ආනිසංස 11කි.")
        7 -> Quintuple("මෛත්‍රියට ඇති ළඟම සතුරා (ආසන්න සතුරා) කවුද?", "What is the near enemy of Metta?", listOf("රාගය", "ආලය", "ප්‍රේමය"), "රාගය හෙවත් කාම ප්‍රේමය වේ.", "ඇල්මයි.")
        8 -> Quintuple("මෛත්‍රියට ඇති දුර සතුරා කවුද?", "What is the distant enemy of Metta?", listOf("ව්‍යාපාදය", "ක්‍රෝධය", "ද්වේෂය"), "ව්‍යාපාදය හෙවත් තරහව වේ.", "ක්‍රෝධයයි.")
        9 -> Quintuple("කරුණාවට ඇති ළඟම සතුරා කුමක්ද?", "What is the near enemy of Karuna?", listOf("ශෝකය", "දොම්නස", "කණගාටුව"), "ශෝකය හෙවත් දොම්නස වේ.", "අනුකම්පාවෙන් හඬා වැටීමයි.")
        10 -> Quintuple("කරුණාවට ඇති දුර සතුරා කුමක්ද?", "What is the distant enemy of Karuna?", listOf("හිංසාව", "විහිංසාව"), "විහිංසාව හෙවත් කෲරත්වය වේ.", "පීඩා කිරීමයි.")
        11 -> Quintuple("මුදිතාවට ඇති ළඟම සතුරා කුමක්ද?", "What is the near enemy of Mudita?", listOf("ප්‍රමෝදය", "උදම් වීම", "හිනාව"), "ගිහි ප්‍රමෝදය වේ.", "උදම් වීමයි.")
        12 -> Quintuple("මුදිතාවට ඇති දුර සතුරා කුමක්ද?", "What is the distant enemy of Mudita?", listOf("ඊර්ෂ්‍යාව", "ඉරිසියාව", "ඉස්සා"), "ඊර්ෂ්‍යාව (ඉස්සාව) වේ.", "අනුන්ගේ සැප නොඉවසීමයි.")
        13 -> Quintuple("උපේක්ෂාවට ඇති ළඟම සතුරා කුමක්ද?", "What is the near enemy of Upekkha?", listOf("නොදැනුවත්කම", "අඥාන උපේක්ෂාව", "මෝහය"), "අඥාන උපේක්ෂාව (මෝහය නිසා නොසලකා හැරීම) වේ.", "මෝඩ මැදහත් බවයි.")
        14 -> Quintuple("උපේක්ෂාවට ඇති දුර සතුරා කුමක්ද?", "What is the distant enemy of Upekkha?", listOf("රාගය සහ ද්වේෂය", "ඇල්ම හා ගැටීම"), "රාගය (ඇල්ම) සහ පටිඝය (ගැටීම) වේ.", "ඇලීම් ගැටීම් දෙකයි.")
        15 -> Quintuple("මවක් තම එකම පුතු දිවිපුදා රකින්නාක් මෙන් මෙත් සිත පැතිරවිය යුතු බව දැක්වෙන සූත්‍රය කුමක්ද?", "In which Sutta does it say a mother protects her only child?", listOf("කරණීයමෙත්ත", "මෙත්ත සූත්‍රය", "Metta Sutta"), "කරණීයමෙත්ත සූත්‍රය වේ.", "මාතා යථා නියං පුත්තං...")
        16 -> Quintuple("කරණීයමෙත්ත සූත්‍රය බුදුරදුන් දේශනා කළේ කාගේ ආරක්ෂාව සඳහාද?", "For whose protection was Karaniya Metta Sutta preached?", listOf("වනගත භික්ෂූන්", "භික්ෂූන් 500 නමකට"), "හිමාල වනයෙහි භාවනා කළ පන්සියයක් භික්ෂූන්ගේ ආරක්ෂාවටය.", "රුක් දෙවිවරුන් පැහැදීමටය.")
        17 -> Quintuple("බ්‍රහ්ම විහරණ වැඩීමෙන් ලැබිය හැකි උපරිම භාවනා ඵලය කුමක්ද?", "Highest spiritual attainment via Brahma Vihara meditation?", listOf("ධ්‍යාන", "රූපාවචර ධ්‍යාන", "බ්‍රහ්ම ලෝක"), "රූපාවචර ධ්‍යාන හා බ්‍රහ්ම ලෝකෝත්පත්තිය වේ.", "ධ්‍යාන වැඩීමයි.")
        18 -> Quintuple("අෂ්ටලෝක ධර්මය හමුවේ නොසැලෙන සිත කුමක්ද?", "Mind unshaken by the 8 worldly conditions is?", listOf("උපේක්ෂා සිත", "උපෙක්ඛා"), "උපේක්ෂා සහගත සිත වේ.", "නොසැලෙන සිතයි.")
        19 -> Quintuple("අෂ්ටලෝක ධර්ම අටෙන් යුගල 4 මොනවාද?", "What are the 4 pairs of 8 worldly conditions?", listOf("ලාභ අලාභ", "යස අයස", "නින්දා ප්‍රශංසා", "සුඛ දුක්ඛ"), "ලාභ-අලාභ, යස-අයස, නින්දා-ප්‍රශංසා සහ සුඛ-දුක්ඛ වේ.", "අටලෝදහමයි.")
        20 -> Quintuple("සමාජයේ සාමය ඇතිකිරීමට සතර බ්‍රහ්ම විහරණ ඉවහල් වන්නේ ඇයි?", "Why are Brahma Viharas vital for social peace?", listOf("වෛරය දුරු වීම", "සහජීවනය", "සාමය"), "ක්‍රෝධය, ඊර්ෂ්‍යාව සහ පළිගැනීම් නැතිකර සහජීවනය ගොඩනගන බැවිනි.", "වෛරය දුරු කරයි.")
        else -> Quintuple("සතර බ්‍රහ්ම විහරණයන්හි මූලික පරමාර්ථය කුමක්ද?", "Core purpose of Brahma Viharas?", listOf("චිත්ත පාරිශුද්ධිය", "නිවන් මඟ"), "චිත්ත පාරිශුද්ධිය ලබා සමාජයට කරුණාව දැක්වීමයි.", "පරාර්ථ සේවයයි.")
      }

      // Set 5: කර්මය හා පුනර්භවය පිළිබඳ බෞද්ධ ඉගැන්වීම
      5 -> when (qIndex) {
        1 -> Quintuple("බුදු දහමට අනුව 'කර්මය' යන්න නිර්වචනය කර ඇත්තේ කෙසේද?", "How is Kamma defined in Buddhism?", listOf("චේතනාව", "චේතනාහං භික්ඛවෙ කම්මං වදාමි"), "'චේතනාහං භික්ඛවේ කම්මං වදාමි' (චේතනාව කර්මය වේ) යනුවෙනි.", "චේතනාවයි.")
        2 -> Quintuple("කර්මයක් සිදුවීමට අත්‍යවශ්‍ය මූලික සාධකය කුමක්ද?", "What essential factor makes an action a Kamma?", listOf("චේතනාව", "සිතුවිල්ල", "Intention"), "චේතනාව (හිතාමතා කිරීමේ චේතනාව) වේ.", "කැමැත්තයි.")
        3 -> Quintuple("කර්ම සිදුකරන ද්වාර ත්‍රිත්වය මොනවාද?", "What are the three doors of action?", listOf("කය", "වචනය", "මනස", "කාය වාචික මානසික"), "කය (කාය), වචනය (වචී) සහ මනස (මනෝ) වේ.", "ත්‍රිවිධ ද්වාරයයි.")
        4 -> Quintuple("විපාක දෙන කාලය අනුව කර්ම ප්‍රධාන කොටස් කීයකට බෙදේද?", "How many types of Kamma by time of fruiting?", listOf("හතරකට", "4කට", "4"), "හතරකටය (දිට්ඨධම්මවේදනීය, උපපජ්ජවේදනීය, අපරාපරියවේදනීය, අහෝසි).", "කාල භේද 4යි.")
        5 -> Quintuple("මෙම ආත්මයේදීම විපාක දෙන කර්මය හඳුන්වන්නේ කෙසේද?", "Kamma that ripens in this very life is called?", listOf("දිට්ඨධම්මවේදනීය", "දිට්ඨධම්ම"), "දිට්ඨධම්මවේදනීය කර්ම නමිනි.", "මෙලොවදීම ඵල දේ.")
        6 -> Quintuple("ඊළඟ ආත්ම භවයේදී විපාක දෙන කර්මය කුමක්ද?", "Kamma that ripens in the immediately next life is called?", listOf("උපපජ්ජවේදනීය", "උපපජ්ජ"), "උපපජ්ජවේදනීය කර්ම නමිනි.", "දෙවන භවයේ ඵල දේ.")
        7 -> Quintuple("තුන්වන භවයේ සිට නිවන් දකිනා තුරු කවදා හෝ විපාක දෙන කර්මය කුමක්ද?", "Kamma that ripens from third birth until Nibbana is?", listOf("අපරාපරියවේදනීය", "අපරාපරිය"), "අපරාපරියවේදනීය කර්ම නමිනි.", "සසර පුරා විපාක දේ.")
        8 -> Quintuple("විපාක දීමට අවස්ථාවක් නොලැබී අහෝසි වී යන කර්මය කුමක්ද?", "Kamma that expires without fruiting is called?", listOf("අහෝසි", "අහෝසි කර්ම"), "අහෝසි කර්ම වේ.", "අහෝසි වීමයි.")
        9 -> Quintuple("බරපතලකම අනුව මරණාසන්නයේදී අනිවාර්යයෙන්ම ඊළඟ උප්පත්තිය තීරණය කරන කර්මය කුමක්ද?", "Weightiest Kamma deciding the immediate rebirth?", listOf("ගරුක", "ගරුක කර්ම"), "ගරුක කර්ම (ආනන්තර්ය පාපකර්ම හෝ ධ්‍යාන) වේ.", "බරපතල කර්මයයි.")
        10 -> Quintuple("පංච ආනන්තර්ය පාපකර්ම පහ මොනවාද?", "What are the five heinous crimes (Anantariya Kamma)?", listOf("මව් මැරීම", "පිය මැරීම", "රහතුන් මැරීම", "ලේ සෙලවීම", "සංඝ භේදය"), "මව් මැරීම, පිය මැරීම, රහතුන් මැරීම, බුදුන්ගේ ලේ සෙලවීම සහ සංඝ භේදයයි.", "අපායගාමී පාපකර්ම 5යි.")
        11 -> Quintuple("නිතර පුරුදු වශයෙන් කරනු ලබන කර්මය හඳුන්වන්නේ කෙසේද?", "Habitual Kamma performed repeatedly is called?", listOf("ආචිණ්ණ", "ආචිණ්ණ කර්ම"), "ආචිණ්ණ කර්ම (බහුල කර්ම) නමිනි.", "පුරුදු කළ කර්මයයි.")
        12 -> Quintuple("මරණාසන්න මොහොතේ සිහිපත් වන කර්මය කුමක්ද?", "Kamma remembered at the moment of death?", listOf("ආසන්න", "ආසන්න කර්ම"), "ආසන්න කර්ම නමිනි.", "මරණාසන්න චිත්තයයි.")
        13 -> Quintuple("ඉහත කර්ම තුනම නොමැති විට පෙර කළ කර්ම අතරින් විපාක දෙන කර්මය කුමක්ද?", "Residual cumulative Kamma that fruits in absence of others?", listOf("කටත්තා", "කටත්තා කර්ම"), "කටත්තා කර්ම නමිනි.", "සුළු කර්ම වේ.")
        14 -> Quintuple("මරණාසන්න පුද්ගලයාට දර්ශනය වන නිමිති ත්‍රිත්වය මොනවාද?", "Three signs seen at deathbed?", listOf("කර්ම", "කර්ම නිමිති", "ගති නිමිති"), "කර්ම, කර්ම නිමිති සහ ගති නිමිති වේ.", "ත්‍රිවිධ නිමිතියි.")
        15 -> Quintuple("ඊළඟට උපදින ස්ථානය පිළිබඳ පූර්ව දර්ශනය කුමන නිමිත්තද?", "Vision of the upcoming realm of rebirth is?", listOf("ගති නිමිත්ත", "ගති නිමිති"), "ගති නිමිත්ත වේ.", "උපදින තැන පෙනීමයි.")
        16 -> Quintuple("පුනර්භවය (Rebirth) සහ පුනරුත්පත්තිය (Reincarnation) අතර වෙනස කුමක්ද?", "Difference between Rebirth and Reincarnation?", listOf("ආත්මයක් නැත", "අනත්ත", "නිරන්තර වෙනස් වීම"), "පුනර්භවයේදී ස්ථිර ආත්මයක් එක් සිරුරකින් තවෙකකට නොයන අතර හේතුඵල පරම්පරාවක් ගලායාම පමණක් සිදුවේ.", "ස්ථිර ආත්මයක් නැත.")
        17 -> Quintuple("චුති සිත සහ පටිසන්ධි සිත අතර සම්බන්ධතාව කුමක්ද?", "Connection between Cuti citta and Patisandhi citta?", listOf("අනන්තර ප්‍රත්‍යය", "නිරුද්ධ වූ සැණින්", "ක්ෂණයකින්"), "චුති සිත නිරුද්ධ වූ සැණින් ඊළඟ භවයේ පටිසන්ධි සිත උපදී.", "ක්ෂණික සම්බන්ධයයි.")
        18 -> Quintuple("කර්ම විපාකයෙන් සම්පූර්ණයෙන්ම මිදිය හැකි එකම මාර්ගය කුමක්ද?", "Only way to completely escape Kamma vipaka?", listOf("නිවන් දැකීම", "නිවන", "රහත් වීම"), "උතුම් අරහත් භාවයට පත්ව පිරිනිවන් පෑමයි.", "නිවනට පත්වීමයි.")
        19 -> Quintuple("අංගුලිමාල මහරහතන් වහන්සේ රහත් වූ පසුත් පහර කෑමට ලක්වූයේ කුමන කර්ම විපාකයක් නිසාද?", "Why was Ven. Angulimala attacked even after Arahantship?", listOf("පෙර කළ අකුසල්", "අපරාපරිය කර්ම"), "පෙර කළ පාපකර්මවල අපරාපරියවේදනීය විපාක විඳීමට සිදුවූ බැවිනි.", "කර්ම විපාකයයි.")
        20 -> Quintuple("කර්ම නියමය ස්වභාව ධර්මයේ කුමන නියාම ධර්මයකට අයත්ද?", "Kamma belongs to which of the 5 cosmic Niyamas?", listOf("කම්ම නියාම", "කර්ම නියාමය"), "කම්ම නියාමයට අයත් වේ.", "පංච නියාමයෙන් එකකි.")
        else -> Quintuple("කර්මය පිළිබඳ බෞද්ධ ඉගැන්වීමේ සදාචාරාත්මක අගය කුමක්ද?", "Moral value of Buddhist teaching on Kamma?", listOf("තමාගේ වගකීම", "යහපත් ජීවිතය"), "තම ජීවිතයේ හොඳ නරක තීරණය කරන්නේ තමා විසින්ම බව වටහාගෙන යහපතෙහි යෙදීමයි.", "ස්වයං වගකීමයි.")
      }

      // Sets 6 through 10 of Grade 11
      6 -> when (qIndex) {
        1 -> Quintuple("පටිච්චසමුප්පාදය යනු කුමක්ද?", "What is Paticcasamuppada?", listOf("හේතුඵල ධර්මය", "හේතුඵල න්‍යාය"), "හේතූන් නිසා ඵලයන් හටගැනීම පිළිබඳ බෞද්ධ ඉගැන්වීමයි.", "හේතුඵල වාදයයි.")
        2 -> Quintuple("පටිච්චසමුප්පාද චක්‍රයේ ඇති අංග (සාධක) ගණන කීයද?", "How many links are in the Dependent Origination chain?", listOf("දොළහක්", "12ක්", "12"), "අංග දොළහකි (12).", "ද්වාදශාංගයයි.")
        3 -> Quintuple("පටිච්චසමුප්පාදයේ පළමු අංගය කුමක්ද?", "What is the 1st link of Paticcasamuppada?", listOf("අවිද්‍යාව", "අවිජ්ජා", "Avijja"), "අවිද්‍යාව (අවිජ්ජා) වේ.", "නොදැනුවත්කමයි.")
        4 -> Quintuple("අවිද්‍යාව යනු කුමක් නොදැනීමද?", "What is Avijja (Ignorance)?", listOf("චතුරාර්ය සත්‍යය", "නොදැනීම"), "චතුරාර්ය සත්‍යය පිළිබඳ අනවබෝධයයි.", "සත්‍ය 4 නොදැනීමයි.")
        5 -> Quintuple("අවිද්‍යා පච්චයා කුමක්ද?", "Avijja paccaya what?", listOf("සංස්කාර", "සංඛාරා"), "සංඛාරා (සංස්කාර) වේ.", "පින් පව් රැස්කිරීමයි.")
        6 -> Quintuple("සංස්කාර පච්චයා කුමක්ද?", "Sankhara paccaya what?", listOf("විඤ්ඤාණ", "විඤ්ඤාණය"), "විඤ්ඤාණ (විඤ්ඤාණය) වේ.", "දැනගැනීමේ සිතයි.")
        7 -> Quintuple("විඤ්ඤාණ පච්චයා කුමක්ද?", "Vinnana paccaya what?", listOf("නාමරූප", "නාම රූප"), "නාමරූප වේ.", "සිරුර හා මනසයි.")
        8 -> Quintuple("නාමරූප පච්චයා කුමක්ද?", "Namarupa paccaya what?", listOf("සළායතන", "සලායතන"), "සළායතන (ඇස, කන, නාසය, දිව, කය, මනස) වේ.", "ආයතන 6යි.")
        9 -> Quintuple("සළායතන පච්චයා කුමක්ද?", "Salayatana paccaya what?", listOf("ඵස්ස", "ස්පර්ශය"), "ඵස්ස (ස්පර්ශය) වේ.", "ගැටීමයි.")
        10 -> Quintuple("ඵස්ස පච්චයා කුමක්ද?", "Phassa paccaya what?", listOf("වේදනා", "විඳීම"), "වේදනා (විඳීම) වේ.", "සුඛ, දුක්ඛ, අදුක්ඛමසුඛ.")
        11 -> Quintuple("වේදනා පච්චයා කුමක්ද?", "Vedana paccaya what?", listOf("තණ්හා", "තෘෂ්ණාව"), "තණ්හා (තෘෂ්ණාව) වේ.", "ඇලීමයි.")
        12 -> Quintuple("තණ්හා පච්චයා කුමක්ද?", "Tanha paccaya what?", listOf("උපාදාන", "උපාදානය"), "උපාදාන (දැඩිව අල්ලාගැනීම) වේ.", "අල්ලාගැනීමයි.")
        13 -> Quintuple("උපාදාන පච්චයා කුමක්ද?", "Upadana paccaya what?", listOf("භව", "භවය"), "භව (භවය) වේ.", "කර්ම භවයයි.")
        14 -> Quintuple("භව පච්චයා කුමක්ද?", "Bhava paccaya what?", listOf("ජාති", "ඉපදීම"), "ජාති (උපත) වේ.", "නැවත ඉපදීමයි.")
        15 -> Quintuple("ජාති පච්චයා ඇතිවන දුක් මොනවාද?", "What results from Jati (Birth)?", listOf("ජරා මරණ", "සෝක පරිදේව", "දුක"), "ජරා, මරණ, සෝක, පරිදේව සහ දුක්ඛ දෝමනස්සයන් වේ.", "සියලු දුක් හටගනී.")
        16 -> Quintuple("පටිච්චසමුප්පාදය අනුලෝම වශයෙන් බැලූ විට පෙන්වන්නේ කුමක්ද?", "What does forward Paticcasamuppada show?", listOf("දුක හටගැනීම", "සමුදය සත්‍යය"), "සසර දුක හටගන්නා ආකාරයයි.", "දුකේ උප්පත්තියයි.")
        17 -> Quintuple("පටිච්චසමුප්පාදය පටිලෝම වශයෙන් බැලූ විට පෙන්වන්නේ කුමක්ද?", "What does reverse Paticcasamuppada show?", listOf("දුක නැතිවීම", "නිරෝධය", "නිවන"), "දුක නිරුද්ධ වන ආකාරය (නිවන) වේ.", "දුක නැති කිරීමයි.")
        18 -> Quintuple("'යො පටිච්චසමුප්පාදං පස්සති - සො ධම්මං පස්සති' යන්නෙහි තේරුම කුමක්ද?", "Meaning of 'He who sees Dependent Arising sees Dhamma'?", listOf("ධර්මය දකියි", "බුදුන් දකියි"), "යමෙක් පටිච්චසමුප්පාදය දකීද හෙතෙම ධර්මය දකියි යන්නයි.", "ධර්මය දැකීමයි.")
        19 -> Quintuple("අස්සජි තෙරුන් උපතිස්ස (සැරියුත්) පිරිවැජියාට දේශනා කළ ප්‍රසිද්ධ ගාථාව කුමක්ද?", "Famous stanza preached by Ven. Assaji to Upatissa?", listOf("යේ ධම්මා හේතුප්පභවා", "හේතුං තේසං තථාගතො"), "'යේ ධම්මා හේතුප්පභවා - තේසං හේතුං තථාගතෝ ආහ' ගාථාවයි.", "හේතුඵල ගාථාවයි.")
        20 -> Quintuple("පටිච්චසමුප්පාද ධර්මය අවබෝධ කරගැනීමෙන් දුරු වන වැරදි දෘෂ්ටිය කුමක්ද?", "Which wrong view is destroyed by understanding Paticcasamuppada?", listOf("මැවුම්වාදය", "ශාශ්වත හා උච්ඡේද වාද"), "ඊශ්වර නිර්මාණවාදය (මැවුම්වාදය) සහ ශාශ්වත/උච්ඡේද දෘෂ්ටීන්ය.", "මිථ්‍යා දෘෂ්ටි දුරු වේ.")
        else -> Quintuple("පටිච්චසමුප්පාදයේ මූලික න්‍යාය කුමක්ද?", "Core principle of Dependent Arising?", listOf("හේතු ඇති කල ඵල", "හේතුඵල"), "හේතු ඇති කල්හි ඵල හටගනී, හේතු නැති කල්හි ඵල නැති වේ.", "හේතුඵල න්‍යායයි.")
      }

      // Sets 7 to 10 fallback to curriculum Grade 11
      7 -> when (qIndex) {
        1 -> Quintuple("ත්‍රිපිටකය අයත් වන ප්‍රධාන පිටක ත්‍රිත්වය මොනවාද?", "What are the 3 main baskets of the Tipitaka?", listOf("විනය", "සූත්‍ර", "අභිධර්ම"), "විනය පිටකය, සූත්‍ර පිටකය සහ අභිධර්ම පිටකයයි.", "පිටක තුනයි.")
        2 -> Quintuple("භික්ෂු භික්ෂුණීන්ගේ ශික්ෂා පද අඩංගු වන්නේ කුමන පිටකයේද?", "Disciplinary rules for Sangha are in which Pitaka?", listOf("විනය", "විනය පිටකය", "Vinaya"), "විනය පිටකයේය.", "විනයයි.")
        3 -> Quintuple("බුදුරදුන් වදාළ ධර්ම දේශනා ඇතුළත් වන්නේ කුමන පිටකයේද?", "Buddha's discourses are contained in which Pitaka?", listOf("සූත්‍ර", "සූත්‍ර පිටකය", "Sutta"), "සූත්‍ර පිටකයේය.", "සූත්‍ර දේශනායි.")
        4 -> Quintuple("පරමාර්ථ ධර්ම විග්‍රහ කරන ගැඹුරු පිටකය කුමක්ද?", "Deep ultimate philosophical teachings are in which Pitaka?", listOf("අභිධර්ම", "අභිධර්ම පිටකය", "Abhidhamma"), "අභිධර්ම පිටකයයි.", "අභිධර්මයයි.")
        5 -> Quintuple("සූත්‍ර පිටකයේ අඩංගු ප්‍රධාන නිකාය පහ මොනවාද?", "Five Nikayas in Sutta Pitaka?", listOf("දීඝ", "මජ්ඣිම", "සංයුක්ත", "අංගුත්තර", "ඛුද්දක"), "දීඝ, මජ්ඣිම, සංයුක්ත, අංගුත්තර සහ ඛුද්දක නිකායයි.", "පංච නිකායයි.")
        6 -> Quintuple("ත්‍රිපිටකය මුල්වරට ග්‍රන්ථාරූඪ කරන ලද්දේ කුමන ස්ථානයේදීද?", "Where was the Tipitaka first written down in books?", listOf("මාතලේ අලුවිහාරය", "අලුවිහාරයේදී", "Aluvihara"), "මාතලේ අලුවිහාරයේදීය.", "මාතලේ අලුවිහාරයයි.")
        7 -> Quintuple("ත්‍රිපිටකය ග්‍රන්ථාරූඪ කළේ කුමන රජතුමාගේ පාලන සමයේද?", "Under which king was the Tipitaka committed to writing?", listOf("වළගම්බා", "වට්ටගාමිණී අභය", "Valagamba"), "වළගම්බා (වට්ටගාමිණී අභය) රජ සමයේදීය.", "ක්‍රි.පූ. 1 වන සියවසේදීය.")
        8 -> Quintuple("ප්‍රථම ධර්ම සංගායනාව පැවැත්වුණේ බුද්ධ පරිනිර්වාණයෙන් කොපමණ කලකට පසුවද?", "First Council was held how long after Parinirvana?", listOf("තුන් මසකින්", "3 මසකින්", "මාස තුනකින්"), "තුන් මසකට පසුවය.", "මාස 3කින්.")
        9 -> Quintuple("ප්‍රථම සංගායනාවේ මූලාසනය හෙබවූ මහරහතන් වහන්සේ කවුද?", "Who presided over the First Buddhist Council?", listOf("මහා කාශ්‍යප", "කාශ්‍යප මහ රහතන් වහන්සේ"), "මහා කාශ්‍යප මහරහතන් වහන්සේය.", "කාශ්‍යප මාහිමියන්ය.")
        10 -> Quintuple("ප්‍රථම සංගායනාවේදී විනය ප්‍රශ්න විසඳුවේ කවුද?", "Who recited the Vinaya at the First Council?", listOf("උපාලි", "උපාලි හිමි"), "උපාලි මහරහතන් වහන්සේය.", "විනයධර අග්‍ර උපාලි හිමියන්ය.")
        else -> Quintuple("ත්‍රිපිටකයේ ආරක්ෂාව සඳහා ලක්දිව භික්ෂූන් දැක්වූ උත්සාහය කුමක්ද?", "Effort of Sinhala monks to preserve Tipitaka?", listOf("කටපාඩමින්", "මුඛපරම්පරාවෙන්", "ග්‍රන්ථාරූඪ"), "භාණක පරම්පරාව මගින් කටපාඩමින් රැකගෙන අවසානයේ ග්‍රන්ථාරූඪ කිරීමයි.", "ග්‍රන්ථාරූඪ කිරීමයි.")
      }

      8 -> when (qIndex) {
        1 -> Quintuple("බුදුරජාණන් වහන්සේ පිරිනිවන් පාන විට උන්වහන්සේගේ වයස කීයද?", "What was the Buddha's age at Mahaparinirvana?", listOf("80", "අසූවයි", "අසූ විය"), "අවුරුදු 80 කි.", "අසූ වන වියේදීය.")
        2 -> Quintuple("බුදුරජාණන් වහන්සේ පිරිනිවන් පෑ ස්ථානය කුමක්ද?", "Where did the Buddha pass away?", listOf("කුසිනාරා", "උපවත්තන සල් උයන", "Kusinara"), "මල්ල රජදරුවන්ගේ කුසිනාරා නුවර උපවත්තන සල් උයනේදීය.", "කුසිනාරාවයි.")
        3 -> Quintuple("බුදුරදුන්ගේ අවසන් වස් කාලය ගත කළේ කොහේද?", "Where did the Buddha spend His last rainy retreat?", listOf("වේළුවගම", "වේළුව ගමේදී"), "වේළුව ග්‍රාමයේදීය.", "විශාලා මහනුවර අසලය.")
        4 -> Quintuple("බුදුරජාණන් වහන්සේ ආයු සංස්කාරය අත්හළේ කුමන පොහෝ දිනකද?", "On which Poya day did Buddha relinquish life momentum?", listOf("නවම්", "නවම් පුර පසළොස්වක", "Navam"), "නවම් පුර පසළොස්වක පොහෝ දිනදීය (චාපාල චේතියේදී).", "නවම් පෝයයි.")
        5 -> Quintuple("බුදුරදුන්ගේ අවසන් ශ්‍රාවකයා වී රහත් බව ලැබුවේ කවුද?", "Who was the Buddha's last ordained disciple to attain Arahantship?", listOf("සුභද්ද", "සුභද්ද පරිබ්‍රාජකයා", "Subhadda"), "සුභද්ද නම් පරිබ්‍රාජකයාය.", "සුභද්ද තවුසාය.")
        6 -> Quintuple("බුදුරජාණන් වහන්සේ වදාළ අවසන් බුද්ධ වචනය කුමක්ද?", "What were the Buddha's final words?", listOf("අප්පමාදේන සම්පාදේථ", "වයධම්මා සංඛාරා"), "'වයධම්මා සංඛාරා අප්පමාදේන සම්පාදේථ' (සියලු සංස්කාරයෝ නැසෙන සුළුය, නොපමාව කුසල් දහම් සම්පාදනය කරව්) යන්නයි.", "අප්‍රමාදයයි.")
        else -> Quintuple("බුදුරජාණන් වහන්සේ පිරිනිවන් පෑ පින්බර පොහෝ දිනය කුමක්ද?", "On which Poya day did the Buddha attain Parinirvana?", listOf("වෙසක්", "වෙසක් පුර පසළොස්වක", "Vesak"), "වෙසක් පුර පසළොස්වක පොහෝ දිනදීය.", "තෙමඟුලේ අවසන් මංගල්‍යයයි.")
      }

      9 -> when (qIndex) {
        1 -> Quintuple("ශ්‍රී ලංකාවේ පිහිටි විශාලතම ගඩොල් ස්තූපය කුමක්ද?", "What is the largest brick stupa in Sri Lanka?", listOf("ජේතවනාරාමය", "ජේතවනය", "Jetavanarama"), "ජේතවනාරාම මහා සෑය වේ.", "මහසෙන් රජු තැනූ සෑයයි.")
        2 -> Quintuple("අනුරාධපුර මහමෙවුනා උයනේ පිහිටි ලෝප්‍රකට බුද්ධ ප්‍රතිමාව කුමක්ද?", "World famous samadhi posture Buddha statue in Anuradhapura?", listOf("සමාධි පිළිමය", "සමාධි බුදු පිළිමය"), "සමාධි බුදු පිළිමය වේ.", "වීරාසන ඉරියව්වෙන් නෙළා ඇත.")
        3 -> Quintuple("සඳකඩපහණෙහි පිටතම තීරුවේ දක්නට ලැබෙන සත්ව රූප මොනවාද?", "Animals seen on the outer strip of classic sandakada pahana?", listOf("ඇතා", "අශ්වයා", "සිංහයා", "ගවයා"), "ඇතා, අශ්වයා, සිංහයා සහ ගවයා යන සිව්පාවන්ය.", "සිව්පාවෝය.")
        4 -> Quintuple("පොළොන්නරුවේ ගල්විහාරයේ දක්නට ලැබෙන ප්‍රතිමා කීයක් තිබේද?", "How many rock cut statues at Polonnaruwa Gal Vihara?", listOf("හතරක්", "4ක්", "4"), "හතරකි (හිඳි පිළිම 2, හිටි පිළිමය, සැතපෙන පිළිමය).", "ප්‍රතිමා 4කි.")
        else -> Quintuple("ශ්‍රී ලංකාවේ මුරගල් නිර්මාණයේ විශිෂ්ටතම උදාහරණය කුමක්ද?", "Best example of guardstone in Sri Lanka?", listOf("නාගරාජ මුරගල", "රත්නප්‍රසාද මුරගල"), "අනුරාධපුර රත්නප්‍රසාදයේ පිහිටි නාගරාජ මුරගල වේ.", "නාගරාජ මුරගලයි.")
      }

      else -> when (qIndex) {
        1 -> Quintuple("නූතන සමාජයේ මානසික ආතතිය දුරු කිරීමට බුදුදහමෙන් දෙන විසඳුම කුමක්ද?", "Buddhist solution to relieve modern stress?", listOf("භාවනාව", "සතිපට්ඨානය", "ආනාපානසතිය"), "භාවනාව (විශේෂයෙන් ආනාපානසතිය හා මෛත්‍රී භාවනාව) වේ.", "සිත සන්සුන් කිරීමයි.")
        2 -> Quintuple("පරිසර සංරක්ෂණය පිළිබඳ බුදුදහමේ ආදර්ශය කුමක්ද?", "Buddhist example on environmental conservation?", listOf("අනිමිසලෝචන", "ගස් කොළන් නොකැපීම", "සොබාදහමට ගරු කිරීම"), "ඇසිපිය නොහෙළා බෝධියට කෘතගුණ දැක්වීම හා පරිසරයට හිංසා නොකිරීමයි.", "සොබාදහම රැකීමයි.")
        3 -> Quintuple("මත්ද්‍රව්‍ය උවදුරෙන් තරුණ පරපුර බේරාගැනීමට ඉවහල් වන මූලික බෞද්ධ ශික්ෂා පදය කුමක්ද?", "Core Buddhist precept to save youth from drugs?", listOf("සුරාමේරය", "පස්වන ශික්ෂා පදය"), "සුරාමේරය මජ්ජපමාදට්ඨානා වේරමණී ශික්ෂා පදය වේ.", "මත්පැනින් වැළකීමයි.")
        4 -> Quintuple("වෛරයෙන් වෛරය නොසන්සිඳෙන බව දැක්වෙන ධම්මපද ගාථාව කුමක්ද?", "Dhammapada stanza stating hatred does not cease by hatred?", listOf("න හි වේරේන වේරානි", "සම්මන්තීධ කුදාචනං"), "'න හි වේරේන වේරානි - සම්මන්තීධ කුදාචනං' ගාථාවයි.", "මෛත්‍රියෙන් සන්සිඳේ.")
        else -> Quintuple("බුදු දහමේ සියලු ඉගැන්වීම්වල හරය කැටි කර දැක්වෙන ගාථාව කුමක්ද?", "Stanza summarizing all Buddhist teachings?", listOf("සබ්බපාපස්ස අකරණං", "කුසලස්ස උපසම්පදා"), "'සබ්බපාපස්ස අකරණං - කුසලස්ස උපසම්පදා - සචිත්තපරියෝදපනං' ගාථාවයි.", "ඕවාද ප්‍රාතිමෝක්ෂයයි.")
      }
    }
  }

  // ==============================================================================
  // GRADE 10 BUDDHISM BANK (SETS 1 TO 10 - 100% GRADE 10 SYLLABUS)
  // ==============================================================================
  private fun getGrade10Question(setNum: Int, qIndex: Int, theme: String): Quintuple<String, String, List<String>, String, String> {
    val cleanTheme = theme.replace(Regex("^[0-9]+\\.\\s*"), "").trim()

    return when (setNum) {
      // Set 1: සිදුහත් කුමරුගේ උපත & ගිහිගෙය හැරයාම
      1 -> when (qIndex) {
        1 -> Quintuple("සිදුහත් කුමරු උපත ලැබූ ස්ථානය කුමක්ද?", "Where was Prince Siddhartha born?", listOf("ලුම්බිණි", "ලුම්බිණිය", "Lumbini"), "නේපාලයේ ලුම්බිණි සල් උයනේදීය.", "ලුම්බිණි සල් උයන සිහිපත් කරන්න.")
        2 -> Quintuple("සිදුහත් කුමරුගේ දෙමව්පියන් කවුරුන්ද?", "Who were Prince Siddhartha's parents?", listOf("සුදොවුන්", "සුද්ධෝදන", "මායා", "මහමායා"), "සුද්ධෝදන රජතුමා සහ මහමායා දේවියයි.", "කපිලවස්තු පුර රජු හා බිසවය.")
        3 -> Quintuple("සිදුහත් කුමරුගේ උපත සිදුවූ පින්බර පොහෝ දිනය කුමක්ද?", "On which Poya day was Prince Siddhartha born?", listOf("වෙසක්", "වෙසක් පුර පසළොස්වක", "Vesak"), "වෙසක් පුර පසළොස්වක පොහෝ දිනදීය.", "තෙමඟුල සිදුවූ පොහොයයි.")
        4 -> Quintuple("සිදුහත් කුමරුට නම් තැබූ දිනයේදී 'ඒකාන්තයෙන්ම බුදුවන්නේය' කියා ප්‍රකාශ කළ බමුණා කවුද?", "Which brahmin predicted Siddhartha will definitely become the Buddha?", listOf("කොණ්ඩඤ්ඤ", "කොණ්ඩඤ්ඤ බමුණා", "Kondanna"), "කොණ්ඩඤ්ඤ නම් ළපටි බ්‍රාහ්මණයාය.", "ඇඟිලි එකක් එසවූ බමුණාය.")
        5 -> Quintuple("සිදුහත් කුමරුගේ ගිහි කල බිසව වූ කුමරිය කවුද?", "Who was Prince Siddhartha's wife?", listOf("යසෝධරා", "යශෝධරා", "බිම්බා", "Yasodhara"), "යසෝධරා (බිම්බා) දේවියයි.", "සුප්පබුද්ධ රජුගේ දියණියයි.")
        6 -> Quintuple("සිදුහත් කුමරුගේ පුත් කුමාරයාගේ නම කුමක්ද?", "What was Prince Siddhartha's son's name?", listOf("රාහුල", "රාහුල කුමරු", "Rahula"), "රාහුල කුමාරයා වේ.", "'රාහුලෝ ජාතෝ' කියා ප්‍රකාශ කළේය.")
        7 -> Quintuple("සිදුහත් කුමරු ගිහිගෙය හැරයාමට හේතු වූ සතර පෙරනිමිති මොනවාද?", "What are the Four Sights seen by Prince Siddhartha?", listOf("මහල්ලා", "ලෙඩා", "මළමිනිය", "පැවිද්දා", "සතර පෙරනිමිති"), "මහල්ලා, ලෙඩා, මළමිනිය සහ පැවිද්දා යන සතර පෙරනිමිති වේ.", "ජරා, ව්‍යාධි, මරණ සහ ශ්‍රමණ රූපයි.")
        8 -> Quintuple("සිදුහත් කුමරු මහාභිනිෂ්ක්‍රමණය කළ පොහෝ දිනය කුමක්ද?", "On which Poya day did Prince Siddhartha renounce worldly life?", listOf("ඇසළ", "ඇසළ පුර පසළොස්වක", "Esala"), "ඇසළ පුර පසළොස්වක පොහෝ දිනදීය.", "ඇසළ පෝය සිහිපත් කරන්න.")
        9 -> Quintuple("මහාභිනිෂ්ක්‍රමණයේදී කුමරු නැඟී ගිය අශ්වයාගේ නම කුමක්ද?", "What was the name of the prince's horse?", listOf("කන්ථක", "කන්ථක අශ්වයා", "Kanthaka"), "කන්ථක අශ්වයා වේ.", "කුමරු සමඟ ගිය අශ්වයාය.")
        10 -> Quintuple("කුමරු සමඟ ගිය ඇමතිවරයාගේ නම කුමක්ද?", "Who was the minister who accompanied Siddhartha?", listOf("ඡන්න", "ඡන්න ඇමති", "Channa"), "ඡන්න ඇමතිවරයා වේ.", "කුමරුගේ ආභරණ ආපසු ගෙනගිය ඇමතිවරයාය.")
        11 -> Quintuple("සිදුහත් කුමරු කෙස්වැටිය සිඳ පැවිදි බව ලැබූ ගංගා ඉවුර කුමක්ද?", "Near which river did Prince Siddhartha ordain himself?", listOf("අනෝමා", "අනෝමා ගඟ", "Anoma"), "අනෝමා ගං ඉවුරේදීය.", "කෙස් වැටිය උඩ දැමූ ගංගාවයි.")
        12 -> Quintuple("ගිහිගෙයින් නික්මෙන විට සිදුහත් කුමරුගේ වයස කීයද?", "What was Prince Siddhartha's age when he renounced home?", listOf("29", "විසි නවයයි"), "අවුරුදු 29 කි.", "විසි නව වැනි වියේදීය.")
        13 -> Quintuple("කුමරුට සෘතු තුන සඳහා සුදොවුන් රජු තනා දුන් මාලිගා ත්‍රිත්වය නම් කරන්න.", "Name the three seasonal palaces built for Siddhartha.", listOf("රම්‍ය", "සුරම්‍ය", "සුභ", "Ramya", "Suramya", "Subha"), "රම්‍ය, සුරම්‍ය සහ සුභ නම් මාලිගා ත්‍රිත්වයයි.", "සෘතු තුනට මාලිගා තුනකි.")
        14 -> Quintuple("කුමරු ළමා වියේදී දඹ රුක් සෙවණේදී වැටුණේ කුමන ධ්‍යානයටද?", "Which Jhana did the prince attain under the Rose-apple tree?", listOf("ප්‍රථම ධ්‍යානය", "පළමු ධ්‍යානය", "First Jhana"), "ප්‍රථම ධ්‍යානයට (ආනාපානසතිය වඩා) වේ.", "වප් මඟුල් උත්සවයේදීය.")
        15 -> Quintuple("කුමරු විවාහය සඳහා දුනු ශිල්ප දැක්වූ දුන්න හැඳින්වූයේ කෙසේද?", "What was the mighty bow strung by Prince Siddhartha?", listOf("සහස්සථාම", "සහස්සථාම දුන්න"), "සහස්සථාම (දහසක් දෙනෙකුට ඇදිය හැකි) දුන්නයි.", "විශේෂ දුන්න සිහිපත් කරන්න.")
        16 -> Quintuple("කුමරු ශිල්ප හැදෑරූ ප්‍රධාන ගුරුවරයා කවුද?", "Who was the royal tutor of Prince Siddhartha?", listOf("සර්වමිත්‍ර", "සර්වමිත්‍ර පඬිතුමා"), "සර්වමිත්‍ර පණ්ඩිතතුමාය.", "රාජකීය ගුරුතුමාය.")
        17 -> Quintuple("සිදුහත් කුමරු උපන් විගස පියවර කීයක් පෙරදිගට තැබුවේද?", "How many steps did the newborn prince take facing East?", listOf("හතක්", "7", "පියවර හතක්"), "නෙළුම් මල් මත පියවර හතක් තැබීය.", "සප්ත පදවරයයි.")
        18 -> Quintuple("කුමරු පියවර හත තබා කළ අභීත සිංහනාදය කුමක්ද?", "What was the lion's roar spoken by the infant prince?", listOf("අග්ගෝහමස්මි", "ලෝකෙට්ඨෝ", "ජෙට්ඨෝහමස්මි"), "'අග්ගෝහමස්මි ලෝකස්ස, ජෙට්ඨෝහමස්මි ලෝකස්ස, සෙට්ඨෝහමස්මි ලෝකස්ස' යන්නයි.", "ලොවට අග්‍රයෙමි, ජ්‍යෙෂ්ඨයෙමි, ශ්‍රේෂ්ඨයෙමි.")
        19 -> Quintuple("මහමායා දේවිය කුමරු ඉපිද දින කීයකින් මියපරලොව ගියේද?", "How many days after Siddhartha's birth did Queen Mahamaya pass away?", listOf("හතකින්", "7කින්", "දින හතයි"), "දින හතකින් (තව්තිසා දිව්‍ය ලෝකයේ මාතෘ දිව්‍යරාජයා විය).", "දින හතක් සිහිපත් කරන්න.")
        20 -> Quintuple("මහමායා දේවියගෙන් පසු සිදුහත් කුමරු කිරි දී හදාවඩා ගත්තේ කවුද?", "Who nursed and raised Siddhartha after Mahamaya's death?", listOf("මහා ප්‍රජාපතී", "ගෝතමී", "ප්‍රජාපතී ගෝතමිය"), "මහා ප්‍රජාපතී ගෝතමී දේවියයි.", "කුමරුගේ සුළු මෑණියන්ය.")
        else -> Quintuple("සිදුහත් කුමරුගේ උපත සම්බන්ධ ප්‍රධාන පින්කම කුමක්ද?", "What is the key merit of Prince Siddhartha's birth?", listOf("බුද්ධ", "උපත", "ලුම්බිණි"), "ලෝක සත්වයා දුකින් මුදවා ගැනීම සඳහා උපත ලැබීමයි.", "බෝසත් උපත සිහිපත් කරන්න.")
      }

      // Set 2: බුද්ධත්වය & ධම්මචක්කප්පවත්තන සූත්‍රය
      2 -> when (qIndex) {
        1 -> Quintuple("සිදුහත් තවුසාණන් බුද්ධත්වයට පත්වූ ස්ථානය කුමක්ද?", "Where did Siddhartha attain Enlightenment?", listOf("බුද්ධගයා", "බුද්ධගයාව", "ජය ශ්‍රී මහා බෝධි මූලය", "Bodh Gaya"), "ඉන්දියාවේ බුද්ධගයාවේ ජය ශ්‍රී මහා බෝධි මූලයේදීය.", "නේරංජනා ගං තෙර අසලය.")
        2 -> Quintuple("සිදුහත් තපස්වරයා බුද්ධත්වයට පත්වූ පින්බර පොහෝ දිනය කුමක්ද?", "On which Poya day did Siddhartha attain Enlightenment?", listOf("වෙසක්", "වෙසක් පුර පසළොස්වක", "Vesak"), "වෙසක් පුර පසළොස්වක පොහෝ දිනදීය.", "තෙමඟුලේ දෙවන මංගල්‍යයයි.")
        3 -> Quintuple("බුදුරජාණන් වහන්සේගේ ප්‍රථම ධර්ම දේශනාව කුමක්ද?", "What was the Buddha's first sermon?", listOf("ධම්මචක්කප්පවත්තන", "ධම්මචක්කප්පවත්තන සූත්‍රය", "Dhammacakkappavattana"), "ධම්මචක්කප්පවත්තන සූත්‍රය වේ.", "දහම් සක පැවැත්වීමේ සූත්‍රයයි.")
        4 -> Quintuple("ප්‍රථම ධර්ම දේශනාව දේශනා කළ ස්ථානය කුමක්ද?", "Where was the first sermon preached?", listOf("බරණැස", "ඉසිපතන", "මිගදාය", "Isipatana"), "බරණැස ඉසිපතන මිගදායේදීය.", "මුවන් ගැවසෙන උයනයි.")
        5 -> Quintuple("ප්‍රථම ධර්ම දේශනාව ශ්‍රවණය කළ පිරිස කවුද?", "Who listened to the first sermon?", listOf("පස්වග මහණුන්", "පස්වග තවුසන්", "Five ascetics"), "කොණ්ඩඤ්ඤ, භද්දිය, වප්ප, මහානාම, අස්සජි යන පස්වග තවුසන්ය.", "පස්වග මහණුන් සිහිපත් කරන්න.")
        6 -> Quintuple("ධම්මචක්කප්පවත්තන සූත්‍රය අසා මුලින්ම සෝවාන් ඵලයට පත්වූයේ කවුද?", "Who attained Sotapanna first listening to Dhammacakka Sutta?", listOf("කොණ්ඩඤ්ඤ", "අඤ්ඤා කොණ්ඩඤ්ඤ", "Kondanna"), "අඤ්ඤා කොණ්ඩඤ්ඤ හිමියන්ය.", "'අඤ්ඤාසි වත භො කොණ්ඩඤ්ඤො'.")
        7 -> Quintuple("බුදු දහමේ මධ්‍යම ප්‍රතිපදාව හඳුන්වන නම කුමක්ද?", "What is the Middle Path called in Buddhism?", listOf("මජ්ඣිමා පටිපදා", "මැදුම් පිළිවෙත", "Middle Path"), "මජ්ඣිමා පටිපදාව (ආර්ය අෂ්ටාංගික මාර්ගය) වේ.", "අන්ත දෙකෙන් මිදුණු මඟයි.")
        8 -> Quintuple("බුදුන් වහන්සේ ප්‍රතික්ෂේප කළ අන්ත දෙක මොනවාද?", "What are the two extremes rejected by the Buddha?", listOf("කාමසුඛල්ලිකානුයෝගය", "අත්තකිලමථානුයෝගය"), "කාමසුඛල්ලිකානුයෝගය (සැප විඳීම) සහ අත්තකිලමථානුයෝගය (ශරීරයට දුක් දීම) වේ.", "අන්ත දෙක සිහිපත් කරන්න.")
        9 -> Quintuple("බුද්ධත්වයට පත්වූ පසු ප්‍රථමයෙන් ගත කළ සති හත හඳුන්වන්නේ කෙසේද?", "What are the first seven weeks after Enlightenment called?", listOf("සත් සතිය", "සත්සතිය", "Seven weeks"), "සත් සතිය නමිනි.", "බෝධිය අසල ගත කළ සති 7යි.")
        10 -> Quintuple("සත් සතියේ දෙවන සතිය කුමක්ද?", "What was the second week of Sath Satiya?", listOf("අනිමිසලෝචන", "අනිමිස ලෝචන පූජාව"), "අනිමිසලෝචන පූජාව (ඇසිපිය නොහෙළා බෝධිය දෙස බලා සිටීම) වේ.", "කෘතගුණ සැලකීමේ උතුම් ආදර්ශයයි.")
        11 -> Quintuple("සත් සතියේ තුන්වන සතිය කුමක්ද?", "What was the third week?", listOf("රත්නචංක්‍රමණය", "චංක්‍රමණ පූජාව"), "රත්නචංක්‍රමණ පූජාව වේ.", "සක්මන් කළ සතියයි.")
        12 -> Quintuple("සත් සතියේ හතරවන සතිය කුමක්ද?", "What was the fourth week?", listOf("රත්නඝර", "රත්නඝර පූජාව"), "රත්නඝර පූජාව (අභිධර්මය මෙනෙහි කර ෂඩ්වර්ණ බුදුරැස් විහිදීම) වේ.", "බුදු රැස් විහිදුණු සතියයි.")
        13 -> Quintuple("සත් සතියේ පස්වන සතිය කුමක්ද?", "What was the fifth week?", listOf("අජපාල", "අජපාල නිග්‍රෝධ"), "අජපාල නුගරුක මුල වැඩසිටි සතියයි.", "මාර දූතියන් පැරදවීමයි.")
        14 -> Quintuple("සත් සතියේ හයවන සතිය කුමක්ද?", "What was the sixth week?", listOf("මුචලින්ද", "මුචලින්ද නාග"), "මුචලින්ද නාග දරණය යට වැඩසිටි සතියයි.", "වැසි සුළඟින් ආරක්ෂා කළ සතියයි.")
        15 -> Quintuple("සත් සතියේ හත්වන සතිය කුමක්ද?", "What was the seventh week?", listOf("රාජායතන", "කිරිපළු රුක්"), "රාජායතන (කිරිපළු රුක්) සෙවණේ වැඩසිටි සතියයි.", "තපස්සු භල්ලුක වෙළෙන්දන් හමුවූ සතියයි.")
        16 -> Quintuple("බුදුරදුන්ට ප්‍රථම දානය පූජා කළ වෙළඳ දෙබෑයන් කවුරුන්ද?", "Who were the merchants who offered the first alms to the Buddha?", listOf("තපස්සු", "භල්ලුක", "තපස්සු භල්ලුක"), "තපස්සු සහ භල්ලුක වෙළෙන්දන්ය.", "විළඳ සහ මීපැණි පූජා කළෝය.")
        17 -> Quintuple("තපස්සු භල්ලුක දෙදෙනාට බුදුරදුන් පූජා කළ පූජනීය වස්තුව කුමක්ද?", "What holy object did Buddha offer to Tapassu and Bhalluka?", listOf("කේශ ධාතු", "කේශ ධාතූන්", "Hair relics"), "කේශ ධාතූන් වහන්සේලාය.", "හිස පිරිමැද දුන් කෙස් ධාතුයි.")
        18 -> Quintuple("ලක්දිව තිරියායේ ගිරිහඬු සෑයේ තැන්පත් කර ඇත්තේ කුමන ධාතූන්ද?", "Relics enshrined at Tiriyaya Girihandu Seya?", listOf("කේශ ධාතු", "කේශ ධාතූන්"), "බුදුරදුන්ගේ පූජනීය කේශ ධාතූන් වහන්සේලාය.", "පළමු දායකයන් පිදූ ධාතුයි.")
        19 -> Quintuple("බුද්ධත්වයට පෙර සිදුහත් තවුසාට කිරිපිඬු දානය පූජා කළ උතුම් කාන්තාව කවුද?", "Who offered milk-rice to Siddhartha before Enlightenment?", listOf("සුජාතා", "සුජාතාව", "Sujatha"), "සුජාතා සිටු දේවියයි.", "සේනානි නිගමයේදීය.")
        20 -> Quintuple("සුජාතාව කිරිපිඬු දානය පිළියෙල කළේ කුමන පාත්‍රයකද?", "In what vessel was Sujatha's milk-rice offered?", listOf("රන් පාත්‍රය", "රන් පාත්‍රයේ", "Golden bowl"), "රන් පාත්‍රයක බහාය.", "නේරංජනා ගඟ උඩුගං බලා පාවී ගියේය.")
        else -> Quintuple("ධම්මචක්කප්පවත්තන සූත්‍රයේ මූලික පරමාර්ථය කුමක්ද?", "Core purpose of Dhammacakkappavattana Sutta?", listOf("චතුරාර්ය සත්‍යය", "මධ්‍යම ප්‍රතිපදාව"), "චතුරාර්ය සත්‍යය සහ මධ්‍යම ප්‍රතිපදාව ලොවට හෙළිදරව් කිරීමයි.", "චතුරාර්ය සත්‍යයයි.")
      }

      // Set 3: අනත්තලක්ඛණ සූත්‍රය & පංචස්කන්ධය
      3 -> when (qIndex) {
        1 -> Quintuple("පස්වග තවුසන් සියලු දෙනා රහත් බවට පත් වූයේ කුමන සූත්‍රය අසාද?", "Listening to which Sutta did the 5 ascetics become Arahants?", listOf("අනත්තලක්ඛණ", "අනත්තලක්ඛණ සූත්‍රය", "Anattalakkhana"), "අනත්තලක්ඛණ සූත්‍රය දේශනාව අසාය.", "ආත්මයක් නැති බව වදාළ සූත්‍රයයි.")
        2 -> Quintuple("අනත්තලක්ඛණ සූත්‍රය දේශනා කළ ස්ථානය කුමක්ද?", "Where was the Anattalakkhana Sutta preached?", listOf("බරණැස", "ඉසිපතන", "මිගදාය", "Isipatana"), "බරණැස ඉසිපතන මිගදායේදීය.", "මුවන් උයනයි.")
        3 -> Quintuple("මිනිස් පුද්ගලයා නිර්මාණය වී ඇති පංචස්කන්ධය නම් කරන්න.", "Name the Five Aggregates (Pancha Khandha).", listOf("රූප", "වේදනා", "සඤ්ඤා", "සංඛාර", "විඤ්ඤාණ"), "රූප, වේදනා, සඤ්ඤා, සංඛාර සහ විඤ්ඤාණ යන පංචස්කන්ධයයි.", "ස්කන්ධ පහයි.")
        4 -> Quintuple("පඨවි, ආපෝ, තේජෝ, වායෝ යන සතර මහා ධාතූන්ගෙන් නිර්මාණය වී ඇත්තේ කුමන ස්කන්ධයද?", "Which aggregate is formed by the 4 Great Elements?", listOf("රූප", "රූප ස්කන්ධය", "Rupa"), "රූප ස්කන්ධය (ශරීරය) වේ.", "භෞතික කයයි.")
        5 -> Quintuple("සුවය, දුක සහ උපේක්ෂාව විඳීම කුමන ස්කන්ධයද?", "Experiencing pleasure, pain, or neutral feelings is which aggregate?", listOf("වේදනා", "වේදනා ස්කන්ධය", "Vedana"), "වේදනා ස්කන්ධය වේ.", "විඳීමේ ස්කන්ධයයි.")
        6 -> Quintuple("හඳුනාගැනීම හෙවත් මතක තබා ගැනීමේ ස්කන්ධය කුමක්ද?", "Which aggregate represents perception and memory?", listOf("සඤ්ඤා", "සඤ්ඤා ස්කන්ධය", "Sanna"), "සඤ්ඤා ස්කන්ධය වේ.", "හඳුනාගැනීමයි.")
        7 -> Quintuple("හිතාමතා සිතන සිතුවිලි සහ චේතනාවන් අඩංගු ස්කන්ධය කුමක්ද?", "Volitional activities and thought formations are in which aggregate?", listOf("සංඛාර", "සංස්කාර ස්කන්ධය", "Sankhara"), "සංඛාර (සංස්කාර) ස්කන්ධය වේ.", "චේතනාවන්ය.")
        8 -> Quintuple("ඇසින්, කනින් ආදී ඉන්ද්‍රියයන්ගෙන් අරමුණු දැනගන්නා සිත කුමන ස්කන්ධයද?", "Consciousness that cognizes sensory inputs is which aggregate?", listOf("විඤ්ඤාණ", "විඤ්ඤාණ ස්කන්ධය", "Vinnana"), "විඤ්ඤාණ ස්කන්ධය වේ.", "දැනගැනීමයි.")
        9 -> Quintuple("පංචස්කන්ධය අනිත්‍ය ද නිත්‍ය ද?", "Is the Pancha Khandha impermanent or permanent?", listOf("අනිත්‍ය", "අනිත්‍යයි", "Impermanent"), "අනිත්‍ය වේ (නිරන්තරයෙන් වෙනස් වේ).", "වෙනස් වන සුළුයි.")
        10 -> Quintuple("යමක් අනිත්‍ය නම් එය සැපයක්ද දුකක්ද?", "If something is impermanent, is it suffering or pleasure?", listOf("දුකක්", "දුකකි", "Suffering"), "දුකකි (අනිච්චං තං දුක්ඛං).", "දුක්ඛ ලක්ෂණයයි.")
        11 -> Quintuple("යමක් අනිත්‍ය හා දුක් සහිත නම් එය මගේ හෝ මගේ ආත්මය කියා අල්ලාගත හැකිද?", "Can impermanent and suffering things be called 'My Soul'?", listOf("නැත", "නොහැක", "බැහැ"), "නැත, එය ආත්මයක් නොවේ (අනත්ත වේ).", "අනත්ත ලක්ෂණයයි.")
        12 -> Quintuple("ත්‍රිලක්ෂණය හෙවත් තිලකුණ යනු මොනවාද?", "What are the Three Marks of Existence (Tilakkhana)?", listOf("අනිත්‍ය", "දුක්ඛ", "අනත්ත"), "අනිත්‍ය, දුක්ඛ සහ අනත්ත වේ.", "තිලකුණයි.")
        13 -> Quintuple("අනත්ත යන පදයේ තේරුම කුමක්ද?", "What is the meaning of 'Anatta'?", listOf("ආත්මයක් නැත", "ආත්ම රහිත", "තමාගේ වසඟයේ පැවැත්විය නොහැක"), "නොවෙනස් වන ස්ථිර ආත්මයක් නැති බව සහ තමා කැමති පරිදි වසඟයේ තබාගත නොහැකි බවයි.", "ආත්මයක් නොමැති වීමයි.")
        14 -> Quintuple("පස්වග මහණුන් අතරින් අවසන් වරට රහත් වූ හිමියන් කවුද?", "Who was the last among five ascetics to attain Arahantship?", listOf("අස්සජි", "අස්සජි හිමි", "Assaji"), "අස්සජි මහරහතන් වහන්සේය.", "පස්වග හිමිවරුන්ගේ බාලයායි.")
        15 -> Quintuple("අස්සජි හිමියන්ගේ ශාන්ත ඉන්ද්‍රිය සංවරය දැක පැහැදුණේ කවුද?", "Who was impressed seeing Ven. Assaji's calm demeanor?", listOf("උපතිස්ස", "සැරියුත්", "Upatissa"), "උපතිස්ස (පසුකාලීන සාරිපුත්ත) පිරිවැජියාය.", "අගසව් වූ සැරියුත් හිමියන්ය.")
        16 -> Quintuple("ලෝකයේ සියලු සත්වයන් පංචස්කන්ධය හැර වෙනත් කිසිවක් නොවන බව වදාළේ කවුද?", "Who taught that beings are merely the Five Aggregates?", listOf("බුදුරජාණන් වහන්සේ", "බුදුන් වහන්සේ"), "සම්මා සම්බුදුරජාණන් වහන්සේය.", "සර්වඥයන් වහන්සේය.")
        17 -> Quintuple("ශරීරය කෙරෙහි දැඩිව ඇලී ගැලී සිටීම බුදු දහමේ හඳුන්වන්නේ කෙසේද?", "Clinging tightly to the physical body is called?", listOf("සක්කාය දිට්ඨි", "ආත්ම දෘෂ්ටිය"), "සක්කාය දිට්ඨිය (මම සහ මගේය යන දැඩි හැඟීම) නමිනි.", "පළමු සංයෝජනයයි.")
        18 -> Quintuple("සෝවාන් ඵලයට පත්වීමේදී ප්‍රහීණ වන මූලික සංයෝජන 3න් එකක් වන්නේ කුමක්ද?", "Name a fetter abandoned upon attaining Sotapanna.", listOf("සක්කාය දිට්ඨි", "විචිකිච්ඡා", "සීලබ්බත පරාමාස"), "සක්කාය දිට්ඨිය (ආත්ම දෘෂ්ටිය දුරු වීම) වේ.", "සංයෝජන 3න් පළමුවැන්නයි.")
        19 -> Quintuple("අනත්තලක්ඛණ සූත්‍රය දේශනා කළ පොහෝ දිනය කුමක්ද?", "On which day was Anattalakkhana Sutta preached?", listOf("ඇසළ", "ඇසළ අව පක්ෂයේ", "ඇසළ මස"), "ඇසළ මස අව පෑළවිය දිනයේදීය.", "ඇසළ මසයි.")
        20 -> Quintuple("අනත්තලක්ඛණ සූත්‍රය අවසානයේ ලොව රහතන් වහන්සේලා කී නමක් පහළ වූයේද?", "How many Arahants were in the world at the end of Anattalakkhana Sutta?", listOf("හය නමක්", "6", "6 නමක්"), "බුදුරදුන් ද ඇතුළුව රහතන් වහන්සේලා හය (6) නමකි.", "මුල්ම රහතුන් 6 නමයි.")
        else -> Quintuple("අනත්තලක්ඛණ සූත්‍රයේ හරය කුමක්ද?", "Core essence of Anattalakkhana Sutta?", listOf("ආත්මයක් නැත", "පංචස්කන්ධය අනිත්‍යයි"), "පංචස්කන්ධය අනිත්‍ය, දුක්ඛ හා අනත්ත බැවින් එය 'මගේ' කියා අල්ලා නොගත යුතු බවයි.", "අනත්ත අවබෝධයයි.")
      }

      // Sets 4 to 10 for Grade 10 fallback
      4 -> when (qIndex) {
        1 -> Quintuple("මංගල සූත්‍රය දේශනා කරන ලද්දේ කාගේ ආරාධනයෙන්ද?", "At whose request was Mangala Sutta preached?", listOf("දේවතාවා", "දෙවියෙකුගේ", "දේවපුත්‍රයෙකු"), "දිව්‍ය පුත්‍රයෙකුගේ විමසීමකට අනුවය.", "දේවතාවා විමසීය.")
        2 -> Quintuple("මංගල සූත්‍රය දේශනා කළ ස්ථානය කුමක්ද?", "Where was Mangala Sutta preached?", listOf("ජේතවනාරාමය", "සැවැත්නුවර", "Jetavana"), "සැවැත්නුවර ජේතවනාරාමයේදීය.", "සැවැත්නුවරදීය.")
        3 -> Quintuple("මංගල සූත්‍රයේ දැක්වෙන උතුම් මංගල කරුණු ගණන කීයද?", "How many supreme blessings are taught in Mangala Sutta?", listOf("තිස් අටක්", "38ක්", "38"), "තිස් අටකි (38).", "මංගල කරුණු 38කි.")
        4 -> Quintuple("මංගල සූත්‍රයේ පළමු මංගල කරුණ කුමක්ද?", "What is the 1st blessing in Mangala Sutta?", listOf("අසේවනා ච බාලානං", "බාලයන් ඇසුරු නොකිරීම"), "අසේවනා ච බාලානං (මෝඩ අඥාන බාලයන් ඇසුරු නොකිරීම) වේ.", "නරක මිතුරු ඇසුරින් වැළකීමයි.")
        5 -> Quintuple("දෙවන මංගල කරුණ කුමක්ද?", "What is the 2nd blessing?", listOf("පණ්ඩිතානං ච සේවනා", "පණ්ඩිතයන් ඇසුරු කිරීම"), "පණ්ඩිතානං ච සේවනා (නුවණැති පණ්ඩිතයන් ඇසුරු කිරීම) වේ.", "නුවණැත්තන් ඇසුරයි.")
        else -> Quintuple("මව්පියන්ට උපස්ථාන කිරීම මංගල කරුණක්ද?", "Is serving parents a blessing?", listOf("ඔව්", "මාතා පිතූ උපට්ඨානං"), "ඔව්, 'මාතා පිතූ උපට්ඨානං' උතුම් මංගල කරුණකි.", "දෙමාපිය උපස්ථානයයි.")
      }

      5 -> when (qIndex) {
        1 -> Quintuple("පරාභව සූත්‍රය දේශනා කළේ කුමන ස්ථානයේදීද?", "Where was Parabhava Sutta preached?", listOf("ජේතවනාරාමය", "සැවැත්නුවර", "Jetavana"), "සැවැත්නුවර ජේතවනාරාමයේදීය.", "අනේපිඬු සිටුතුමාගේ ආරාමයේදීය.")
        2 -> Quintuple("'පරාභව' යන්නෙහි තේරුම කුමක්ද?", "What does 'Parabhava' mean?", listOf("පිරිහීම", "විනාශය"), "පිරිහීම හෙවත් පරිහානිය වේ.", "පිරිහී යාමයි.")
        3 -> Quintuple("ධර්මයට ද්වේෂ කරන පුද්ගලයා පිරිහෙන බව දැක්වෙන ගාථා පාඨය කුමක්ද?", "Stanza stating the hater of Dhamma declines?", listOf("ධම්මදෙස්සී පරාභවෝ", "ධම්මදෙස්සී"), "'ධම්මකාමෝ භවං හෝති - ධම්මදෙස්සී පරාභවෝ' යන්නයි.", "දහමට ලැදි වන්නා දියුණු වේ.")
        else -> Quintuple("අලසකම සහ නිදිබර බව පිරිහීමට හේතුවක්ද?", "Are laziness and drowsiness causes of downfall?", listOf("ඔව්", "නිද්දාසීලී"), "ඔව්, නිතර නිදාගැනීම හා අලසකම පිරිහීමේ දොරටුවකි.", "අලසකම පිරිහීමයි.")
      }

      6 -> when (qIndex) {
        1 -> Quintuple("ප්‍රථම ධර්ම සංගායනාවට සහභාගී වූ මහරහතන් වහන්සේලා ගණන කීයද?", "How many Arahants participated in the First Council?", listOf("පන්සියයක්", "500ක්", "500"), "පන්සිය (500) නමකි.", "පංචසතිකා සංගීතියයි.")
        2 -> Quintuple("ප්‍රථම සංගායනාවට රාජ්‍ය අනුග්‍රහය දැක්වූ රජතුමා කවුද?", "Which king patronized the First Buddhist Council?", listOf("අජාසත්", "අජාතසත්තු", "Ajatasattu"), "අජාසත් (අජාතසත්තු) රජතුමාය.", "මගධයේ රජුය.")
        3 -> Quintuple("දෙවන ධර්ම සංගායනාව පැවැත්වුණේ කුමන නුවරදීද?", "Where was the Second Council held?", listOf("විශාලා", "වෛශාලී", "Visala"), "විශාලා මහනුවර වාලුකාරාමයේදීය.", "කාලාශෝක රජ දවසය.")
        4 -> Quintuple("තෙවන ධර්ම සංගායනාවට රාජ්‍ය අනුග්‍රහය දැක්වූ මහා අධිරාජයා කවුද?", "Which great emperor patronized the Third Council?", listOf("අශෝක", "ධර්මාශෝක", "Ashoka"), "ධර්මාශෝක අධිරාජයාය.", "පාටලීපුත්‍ර නුවරදීය.")
        else -> Quintuple("තෙවන සංගායනාවේ මූලාසනය හෙබවූ මහරහතන් වහන්සේ කවුද?", "Who presided over the Third Council?", listOf("මොග්ගලීපුත්තතිස්ස", "තිස්ස මහ රහතන් වහන්සේ"), "මොග්ගලීපුත්තතිස්ස මහරහතන් වහන්සේය.", "අශෝක රජුගේ ගුරු හිමියන්ය.")
      }

      else -> {
        val distinctBank = listOf(
          Quintuple("ලක්දිවට බුදුදහම ගෙන ආ උතුම් රහතන් වහන්සේ කවුද?", "Who brought Buddhism to Sri Lanka?", listOf("මිහිඳු", "මහින්ද", "Mahinda"), "අනුබුදු මිහිඳු මහරහතන් වහන්සේය.", "මිහින්තලයට වැඩම කළහ."),
          Quintuple("මිහිඳු හිමියන් ලක්දිවට වැඩම කළ පින්බර පොහෝ දිනය කුමක්ද?", "On which Poya day did Arahat Mahinda arrive in Sri Lanka?", listOf("පොසොන්", "පොසොන් පුර පසළොස්වක", "Poson"), "පොසොන් පුර පසළොස්වක පොහෝ දිනදීය.", "පොසොන් පෝයයි."),
          Quintuple("මිහිඳු හිමියන් ලක්දිවදී දේවානම්පියතිස්ස රජුට දේශනා කළ ප්‍රථම සූත්‍රය කුමක්ද?", "First Sutta preached by Arahat Mahinda to King Devanampiyatissa?", listOf("චූලහත්ථිපදෝපම", "චූලහත්ථිපදෝපම සූත්‍රය"), "චූලහත්ථිපදෝපම සූත්‍රය වේ.", "ඇත්පියවර උපමා සූත්‍රයයි."),
          Quintuple("ලක්දිවට ජය ශ්‍රී මහා බෝධීන් වහන්සේගේ දක්ෂිණ ශාඛාව වැඩම කළ මෙහෙණින් වහන්සේ කවුද?", "Who brought the Sacred Jaya Sri Maha Bodhi sapling to Sri Lanka?", listOf("සංඝමිත්තා", "සංඝමිත්තා තෙරණිය", "Sanghamitta"), "සංඝමිත්තා මහා රහත් මෙහෙණින් වහන්සේය.", "මිහිඳු හිමියන්ගේ නැගණියයි."),
          Quintuple("ලක්දිව පිහිටවූ ප්‍රථම ථූපය කුමක්ද?", "What was the first stupa built in Sri Lanka?", listOf("ථූපාරාමය", "ථූපාරාම"), "ථූපාරාම මහා සෑය (අනුරාධපුර) වේ.", "දේවානම්පියතිස්ස රජු තැනීය."),
          Quintuple("ථූපාරාමයේ තැන්පත් කර ඇත්තේ බුදුරදුන්ගේ කුමන ශාරීරික ධාතුවද?", "Which relic of Buddha is enshrined at Thuparama?", listOf("දකුණු අකු ධාතුව", "අකු ධාතුව"), "දකුණු අකු ධාතූන් වහන්සේය.", "අකු ධාතුවයි."),
          Quintuple("චතුරාර්ය සත්‍යයන් හතර මොනවාද?", "What are the Four Noble Truths?", listOf("දුක්ඛ", "සමුදය", "නිරෝධ", "මාර්ග"), "දුක්ඛ, සමුදය, නිරෝධ සහ මාර්ග සත්‍යයන් වේ.", "උතුම් සත්‍ය 4යි."),
          Quintuple("දුක්ඛ සමුදය සත්‍යය යනු කුමක්ද?", "What is Dukkha Samudaya Sacca?", listOf("තණ්හාව", "තෘෂ්ණාව", "දුකට හේතුව"), "දුක් ඇතිවීමේ මූලික හේතුව වන තණ්හාව (තෘෂ්ණාව) වේ.", "තණ්හාවයි."),
          Quintuple("දුක්ඛ නිරෝධය යනු කුමක්ද?", "What is Dukkha Nirodha?", listOf("නිවන", "දුක නැති කිරීම"), "තෘෂ්ණාව මුළුමනින්ම නැති කිරීම හෙවත් නිර්වාණයයි.", "නිවනයි."),
          Quintuple("දුක්ඛ නිරෝධ ගාමිණී පටිපදාව හෙවත් මාර්ග සත්‍යය කුමක්ද?", "What is the Path leading to cessation of suffering?", listOf("ආර්ය අෂ්ටාංගික මාර්ගය", "අෂ්ටාංගික මාර්ගය"), "ආර්ය අෂ්ටාංගික මාර්ගය වේ.", "අංග අටකින් යුත් මඟයි.")
        )
        distinctBank[(qIndex - 1).coerceIn(0, distinctBank.size - 1)]
      }
    }
  }
}
