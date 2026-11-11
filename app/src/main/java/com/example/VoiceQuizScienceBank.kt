package com.example

/**
 * 🔬 Comprehensive Voice Quiz Bank for Science (විද්‍යාව)
 * Contains 200 distinct, syllabus-aligned oral exam questions across 10 sets of 20 questions each.
 * Every single question is short, direct, curriculum-accurate, non-formula, non-explanatory, and non-repeating.
 */
object VoiceQuizScienceBank {

  fun getQuestion(grade: String, setNum: Int, qIndex: Int, theme: String): Quintuple<String, String, List<String>, String, String> {
    if (grade == "11") {
      return getGrade11Question(setNum, qIndex, theme)
    }
    val cleanTheme = theme.replace(Regex("^[0-9]+\\.\\s*"), "").trim()

    return when (setNum) {
      // Set 1: ජීවයේ රසායනික පදනම (ජෛව අණු)
      1 -> when (qIndex) {
        1 -> Quintuple("කාබෝහයිඩ්‍රේටවල මූලික තැනුම් ඒකකය කුමක්ද?", "Basic building block of carbohydrates?", listOf("ග්ලූකෝස්", "මොනොසැකරයිඩ", "glucose"), "ග්ලූකෝස් හෙවත් මොනොසැකරයිඩ වේ.", "සරල සීනි වර්ගයකි.")
        2 -> Quintuple("ග්ලූකෝස් හඳුනාගැනීම සඳහා භාවිත කරන ප්‍රතිකාරකය කුමක්ද?", "Reagent used to test glucose?", listOf("බෙනඩික්ට්", "බෙනඩික්ට් ද්‍රාවණය", "Benedict"), "බෙනඩික්ට් ප්‍රතිකාරකය වේ (රතු-දුඹුරු අවක්ෂේපයක් ලැබේ).", "රත් කළ යුතු නිල් ද්‍රාවණයකි.")
        3 -> Quintuple("ප්‍රෝටීන තැනී ඇති මූලික තැනුම් ඒකකය කුමක්ද?", "Basic building block of proteins?", listOf("ඇමයිනෝ අම්ල", "amino acids"), "ඇමයිනෝ අම්ල (Amino acids) වේ.", "පෙප්ටයිඩ බන්ධනවලින් බැඳේ.")
        4 -> Quintuple("ප්‍රෝටීන හඳුනාගැනීමට සිදුකරන ප්‍රධාන පරීක්ෂාව කුමක්ද?", "Test used to identify proteins?", listOf("බයියුරෙට්", "බයිරෙට්", "Biuret"), "බයියුරෙට් පරීක්ෂාව (Biuret test) වේ.", "දම් හෝ රෝස පැහැයක් ලැබේ.")
        5 -> Quintuple("ලිපිඩ හඳුනාගැනීමට භාවිත කරන ප්‍රධාන රසායනික ප්‍රතිකාරකය කුමක්ද?", "Reagent used to identify lipids?", listOf("සුඩාන්", "සුඩාන් III", "Sudan III"), "සුඩාන් III ද්‍රාවණය වේ.", "රතු පැහැ තෙල් බිඳිති සාදයි.")
        6 -> Quintuple("පිෂ්ඨය හඳුනාගැනීමට භාවිත කරන ද්‍රාවණය කුමක්ද?", "Solution used to test starch?", listOf("අයඩින්", "අයඩින් ද්‍රාවණය", "Iodine"), "අයඩින් ද්‍රාවණය (තද නිල් පැහැයක් ලැබේ).", "අයඩින් බිංදු කිහිපයක් එක්කරයි.")
        7 -> Quintuple("විදුරුමස් වලින් ලේ ගැලීම (ස්කර්වි) ඇතිවන්නේ කුමන විටමින් ඌනතාව නිසාද?", "Scurvy is caused by deficiency of which vitamin?", listOf("විටමින් C", "Vitamin C", "ඇස්කෝබික්"), "විටමින් C (ඇස්කෝබික් අම්ලය) ඌනතාවෙනි.", "දෙහි, දොඩම්, නෙල්ලිවල බහුලයි.")
        8 -> Quintuple("රාත්‍රී අන්ධභාවය (රැයෙහි නොපෙනීම) ඇතිවන්නේ කුමන විටමින් ඌනතාව නිසාද?", "Night blindness is caused by lack of which vitamin?", listOf("විටමින් A", "Vitamin A", "රෙටිනෝල්"), "විටමින් A ඌනතාවය නිසාය.", "කැරට්, කහ පැහැති පලතුරුවල ඇත.")
        9 -> Quintuple("ළමුන්ගේ අස්ථි දුර්වල වන රිකට්ස් රෝගය ඇතිවන්නේ කුමන විටමින් ඌනතාව නිසාද?", "Rickets is caused by lack of which vitamin?", listOf("විටමින් D", "Vitamin D"), "විටමින් D ඌනතාවය නිසාය.", "හිරු එළියෙන් සමේ නිපදවේ.")
        10 -> Quintuple("රුධිරය කැටි ගැසීම ප්‍රමාද වන්නේ කුමන විටමින් වර්ගය ඌන වීමෙන්ද?", "Delayed blood clotting is due to lack of which vitamin?", listOf("විටමින් K", "Vitamin K"), "විටමින් K ඌනතාවය නිසාය.", "රුධිර කැටිගැසීමට අත්‍යවශ්‍යයි.")
        11 -> Quintuple("රුධිරයේ හිමොග්ලොබින් සෑදීමට අත්‍යවශ්‍ය ප්‍රධාන ඛනිජ ලවණය කුමක්ද?", "Mineral essential for hemoglobin?", listOf("යකඩ", "Fe", "Iron"), "යකඩ (Fe) වේ.", "ඌන වූ විට රක්තහීනතාව ඇතිවේ.")
        12 -> Quintuple("තයිරොක්සින් හෝමෝනය නිපදවීමට අත්‍යවශ්‍ය මූලද්‍රව්‍යය කුමක්ද?", "Element needed to synthesize thyroxine?", listOf("අයඩින්", "Iodine", "I"), "අයඩින් (Iodine) වේ.", "ගලගණ්ඩය වැළැක්වීමට ලුණු සමඟ ගනී.")
        13 -> Quintuple("අස්ථි හා දත් වර්ධනයට අවශ්‍ය ප්‍රධාන ඛනිජ ලවණය කුමක්ද?", "Primary mineral for bones and teeth?", listOf("කැල්සියම්", "Ca", "පොස්පරස්", "Calcium"), "කැල්සියම් (Ca) වේ.", "කිරි, හාල්මැස්සන්ගේ බහුලයි.")
        14 -> Quintuple("DNA අණුවක ඇති නයිට්‍රජනීය භෂ්ම 4 මොනවාද?", "Four nitrogenous bases in DNA?", listOf("ඇඩිනින්", "තයිමින්", "ගුවැනින්", "සයිටොසීන්", "A T G C"), "ඇඩිනින් (A), තයිමින් (T), ගුවැනින් (G) සහ සයිටොසීන් (C) වේ.", "A, T, G, C අකුරු 4යි.")
        15 -> Quintuple("DNA අණුවේ ද්විත්ව හෙලික්ස ආකෘතිය සොයාගත් විද්‍යාඥයන් දෙදෙනා කවුද?", "Who discovered the double helix DNA structure?", listOf("වොට්සන්", "ක්‍රික්", "Watson", "Crick"), "ජේම්ස් වොට්සන් සහ ෆ්‍රැන්සිස් ක්‍රික් (Watson & Crick) වේ.", "1953 දී සොයාගන්නා ලදී.")
        16 -> Quintuple("RNA අණුවක තයිමින් (T) වෙනුවට පිහිටන භෂ්මය කුමක්ද?", "Base replacing Thymine in RNA?", listOf("යුරැසිල්", "Uracil", "U"), "යුරැසිල් (Uracil) වේ.", "RNA හි පමණක් දක්නට ලැබේ.")
        17 -> Quintuple("ජීවී සිරුරේ ජෛව රසායනික ප්‍රතික්‍රියා උත්ප්‍රේරණය කරන ප්‍රෝටීන මොනවාද?", "Proteins that catalyze biochemical reactions?", listOf("එන්සයිම", "ජෛව උත්ප්‍රේරක", "Enzymes"), "එන්සයිම (Enzymes) හෙවත් ජෛව උත්ප්‍රේරක වේ.", "ආහාර ජීර්ණයට අත්‍යවශ්‍යයි.")
        18 -> Quintuple("කිරිවල අඩංගු ප්‍රධාන ඩයිසැකරයිඩ සීනි වර්ගය කුමක්ද?", "Disaccharide sugar found in milk?", listOf("ලැක්ටෝස්", "Lactose"), "ලැක්ටෝස් (Lactose) වේ.", "ග්ලූකෝස් සහ ගැලැක්ටෝස් එකතුවකි.")
        19 -> Quintuple("පළතුරු සහ මීපැණිවල අඩංගු මිහිරිම මොනොසැකරයිඩය කුමක්ද?", "Sweetest monosaccharide in fruits and honey?", listOf("ෆෲක්ටෝස්", "Fructose"), "ෆෲක්ටෝස් (Fructose) වේ.", "පළතුරු සීනි නමිනි.")
        20 -> Quintuple("ජලයේ ඉහළ විශිෂ්ට තාප ධාරිතාව ජීවීන්ට වැදගත් වන්නේ ඇයි?", "Why is water's high specific heat capacity vital for life?", listOf("දේහ උෂ්ණත්වය පාලනය", "උෂ්ණත්වය ස්ථාවරව", "සමතුලිතතාව"), "ජීවී දේහ උෂ්ණත්වය ක්ෂණිකව වෙනස් නොවී ස්ථාවරව පවත්වා ගැනීමටය.", "තාප සමතුලිතතාව රකී.")
        else -> Quintuple("ජෛව අණුවල ප්‍රධාන කාණ්ඩ 4 මොනවාද?", "Four main groups of biomolecules?", listOf("කාබෝහයිඩ්‍රේට", "ප්‍රෝටීන", "ලිපිඩ", "නියුක්ලික්"), "කාබෝහයිඩ්‍රේට, ප්‍රෝටීන, ලිපිඩ සහ නියුක්ලික් අම්ල වේ.", "ජීවයේ රසායනික පදනමයි.")
      }

      // Set 2: පදාර්ථයේ ව්‍යුහය & ආවර්තිතා වගුව
      2 -> when (qIndex) {
        1 -> Quintuple("පරමාණුවක න්‍යෂ්ටිය තුළ පිහිටන උප පරමාණුක අංශු 2 මොනවාද?", "Subatomic particles in atomic nucleus?", listOf("ප්‍රෝටෝන", "නියුට්‍රෝන", "protons", "neutrons"), "ප්‍රෝටෝන සහ නියුට්‍රෝන වේ.", "න්‍යෂ්ටික අංශු දෙකයි.")
        2 -> Quintuple("සෘණ ආරෝපිත උප පරමාණුක අංශුව කුමක්ද?", "Negatively charged subatomic particle?", listOf("ඉලෙක්ට්‍රෝනය", "ඉලෙක්ට්‍රෝන", "electron"), "ඉලෙක්ට්‍රෝනය (Electron) වේ.", "න්‍යෂ්ටිය වටා ශක්ති මට්ටම්වල භ්‍රමණය වේ.")
        3 -> Quintuple("පරමාණුක ක්‍රමාංකය (Z) මඟින් දක්වන්නේ කුමක්ද?", "What is represented by Atomic Number?", listOf("ප්‍රෝටෝන සංඛ්‍යාව", "ප්‍රෝටෝන ගණන"), "න්‍යෂ්ටියේ ඇති ප්‍රෝටෝන සංඛ්‍යාවයි.", "මූලද්‍රව්‍යයේ අනන්‍යතාවයි.")
        4 -> Quintuple("ස්කන්ධ ක්‍රමාංකය (A) යනු කුමක්ද?", "What is Mass Number?", listOf("ප්‍රෝටෝන සහ නියුට්‍රෝන එකතුව", "ප්‍රෝටෝන + නියුට්‍රෝන"), "න්‍යෂ්ටියේ ඇති ප්‍රෝටෝන සහ නියුට්‍රෝන සංඛ්‍යාවල එකතුවයි.", "A = p + n වේ.")
        5 -> Quintuple("නූතන ආවර්තිතා වගුව සකස් කර ඇත්තේ කුමන ගුණය වැඩිවන පිළිවෙලටද?", "Modern periodic table is arranged by increasing what?", listOf("පරමාණුක ක්‍රමාංකය", "ප්‍රෝටෝන සංඛ්‍යාව"), "පරමාණුක ක්‍රමාංකය වැඩිවන පිළිවෙලටය.", "මෙන්ඩලීව්ට පසු මෝස්ලි විසින් සකස් කළේය.")
        6 -> Quintuple("ආවර්තිතා වගුවේ තිරස් පේළි හඳුන්වන්නේ කෙසේද?", "Horizontal rows in periodic table are called?", listOf("ආවර්ත", "Periods"), "ආවර්ත (Periods) නමිනි.", "ආවර්ත 7ක් පවතී.")
        7 -> Quintuple("ආවර්තිතා වගුවේ සිරස් තීරු හඳුන්වන්නේ කෙසේද?", "Vertical columns in periodic table are called?", listOf("කාණ්ඩ", "Groups"), "කාණ්ඩ (Groups) නමිනි.", "කාණ්ඩ 1 සිට 8 (හෝ 18) දක්වා ඇත.")
        8 -> Quintuple("ආවර්තිතා වගුවේ 1 වන කාණ්ඩයේ ලෝහ හඳුන්වන විශේෂ නම කුමක්ද?", "Group 1 metals are called?", listOf("ක්ෂාර ලෝහ", "Alkali metals"), "ක්ෂාර ලෝහ (Alkali metals) නමිනි.", "Li, Na, K අයත් වේ.")
        9 -> Quintuple("ආවර්තිතා වගුවේ 7 වන කාණ්ඩයේ මූලද්‍රව්‍ය හඳුන්වන්නේ කෙසේද?", "Group 7 elements are called?", listOf("හැලජන", "Halogens"), "හැලජන (Halogens) නමිනි.", "F, Cl, Br, I අයත් වේ.")
        10 -> Quintuple("අටවන කාණ්ඩයේ (VIII) උච්ච වායුවක් සඳහා උදාහරණයක් පවසන්න.", "Example of a noble gas in Group 8?", listOf("හීලියම්", "නියොන්", "ආගන්", "Helium", "Neon", "Argon"), "හීලියම් (He), නියොන් (Ne) හෝ ආගන් (Ar) වේ.", "අක්‍රිය වායුවකි.")
        11 -> Quintuple("සෝඩියම් (Na - පරමාණුක ක්‍රමාංකය 11) හි ඉලෙක්ට්‍රොනික වින්‍යාසය කුමක්ද?", "Electronic configuration of Sodium (Na-11)?", listOf("2, 8, 1", "2,8,1"), "2, 8, 1 වේ.", "කවච 3ක පිහිටයි.")
        12 -> Quintuple("ක්ලෝරීන් (Cl - පරමාණුක ක්‍රමාංකය 17) හි ඉලෙක්ට්‍රොනික වින්‍යාසය කුමක්ද?", "Electronic configuration of Chlorine (Cl-17)?", listOf("2, 8, 7", "2,8,7"), "2, 8, 7 වේ.", "සංයුජතා ඉලෙක්ට්‍රෝන 7කි.")
        13 -> Quintuple("ප්‍රෝටෝන සංඛ්‍යාව සමාන නමුත් නියුට්‍රෝන සංඛ්‍යාව වෙනස් පරමාණු හඳුන්වන්නේ කෙසේද?", "Atoms with same protons but different neutrons are called?", listOf("සමස්ථානික", "Isotopes"), "සමස්ථානික (Isotopes) නමිනි.", "හයිඩ්‍රජන් සමස්ථානික: ප්‍රෝටියම්, ඩියුටීරියම්, ට්‍රිටියම්.")
        14 -> Quintuple("කාබන්-12 සමස්ථානිකය රසායන විද්‍යාවේදී වැදගත් වන්නේ ඇයි?", "Why is Carbon-12 standard in chemistry?", listOf("සාපේක්ෂ පරමාණුක ස්කන්ධය", "සම්මතය"), "සාපේක්ෂ පරමාණුක ස්කන්ධ ඒකකය මැනීමේ ජාත්‍යන්තර සම්මතය ලෙස භාවිත වන බැවිනි.", "ස්කන්ධ සම්මතයයි.")
        15 -> Quintuple("ඉලෙක්ට්‍රෝනයක් පිට කර ධන ආරෝපිත වන අයනයක් හඳුන්වන්නේ කෙසේද?", "Positively charged ion formed by losing electrons?", listOf("කැටායනය", "ධන අයනය", "Cation"), "කැටායනය (Cation) නමිනි.", "ලෝහ පරමාණු සාදයි.")
        16 -> Quintuple("ඉලෙක්ට්‍රෝන ලබාගෙන සෘණ ආරෝපිත වන අයනය හඳුන්වන්නේ කෙසේද?", "Negatively charged ion formed by gaining electrons?", listOf("ඇනායනය", "සෘණ අයනය", "Anion"), "ඇනායනය (Anion) නමිනි.", "අලෝහ පරමාණු සාදයි.")
        17 -> Quintuple("පළමු ශක්ති මට්ටමට (n=1) ඇතුළත් විය හැකි උපරිම ඉලෙක්ට්‍රෝන ගණන කීයද?", "Maximum electrons in 1st energy level (n=1)?", listOf("2", "දෙකයි", "2ක්"), "ඉලෙක්ට්‍රෝන 2කි.", "2ක් පමණි.")
        18 -> Quintuple("දෙවන ශක්ති මට්ටමට (n=2) ඇතුළත් විය හැකි උපරිම ඉලෙක්ට්‍රෝන ගණන කීයද?", "Maximum electrons in 2nd energy level (n=2)?", listOf("8", "අටයි", "8ක්"), "ඉලෙක්ට්‍රෝන 8කි.", "අටක් ඇතුළත් වේ.")
        19 -> Quintuple("ලෝහමය ගුණය සහ අලෝහමය ගුණය යන දෙකම පෙන්වන මූලද්‍රව්‍ය හඳුන්වන්නේ කෙසේද?", "Elements showing both metallic and nonmetallic traits are called?", listOf("උභයගුණී", "ලෝහාලෝහ", "Metalloids"), "ලෝහාලෝහ (Metalloids) හෙවත් අර්ධ ලෝහ නමිනි.", "සිලිකන් (Si), බෝරෝන් (B) උදාහරණයි.")
        20 -> Quintuple("කාමර උෂ්ණත්වයේදී ද්‍රවයක් ලෙස පවතින එකම ලෝහය කුමක්ද?", "Only metal liquid at room temperature?", listOf("රසදිය", "Hg", "Mercury"), "රසදිය (Hg / Mercury) වේ.", "උෂ්ණත්වමානවල භාවිත වේ.")
        else -> Quintuple("ආවර්තිතා වගුවේ මුල්ම මූලද්‍රව්‍යය කුමක්ද?", "First element in periodic table?", listOf("හයිඩ්‍රජන්", "H"), "හයිඩ්‍රජන් (H) වේ.", "පරමාණුක ක්‍රමාංකය 1යි.")
      }

      // Set 3: සෛලය ජීවයේ මූලික ව්‍යුහමය ඒකකය
      3 -> when (qIndex) {
        1 -> Quintuple("සෛල වාදය ඉදිරිපත් කළ විද්‍යාඥයන් දෙදෙනා කවුරුන්ද?", "Who proposed cell theory?", listOf("ශ්ලයිඩන්", "ශ්වාන්", "Schleiden", "Schwann"), "මතියස් ශ්ලයිඩන් සහ තියඩෝර් ශ්වාන් (Schleiden & Schwann) වේ.", "ජර්මානු විද්‍යාඥයන් දෙදෙනෙකි.")
        2 -> Quintuple("ශාක සෛල බිත්තිය සෑදී ඇති ප්‍රධාන රසායනික සංඝටකය කුමක්ද?", "What is the main chemical in plant cell walls?", listOf("සෙලියුලෝස්", "cellulose"), "සෙලියුලෝස් (Cellulose) වේ.", "ශාකවලට දෘඪතාව දෙන බහුඅවයවිකයකි.")
        3 -> Quintuple("සෛලයේ ශක්ති නිෂ්පාදනාගාරය හෙවත් බලගාරය කුමන ඉන්ද්‍රියිකාවද?", "What is the powerhouse of the cell?", listOf("මයිටොකොන්ඩ්‍රියා", "mitochondria"), "මයිටොකොන්ඩ්‍රියා (Mitochondria) වේ.", "සෛලීය ශ්වසනයෙන් ATP නිපදවයි.")
        4 -> Quintuple("ප්‍රභාසංස්ලේෂණය සිදු කරනු ලබන ඉන්ද්‍රියිකාව කුමක්ද?", "Which organelle carries out photosynthesis?", listOf("හරිතලව", "chloroplast"), "හරිතලව (Chloroplast) වේ.", "ක්ලෝරොෆිල් අඩංගු ඉන්ද්‍රියිකාවයි.")
        5 -> Quintuple("සෛලයේ සියලු ජීව ක්‍රියා පාලනය කරන ප්‍රධාන මධ්‍යස්ථානය කුමක්ද?", "What is the control center of the cell?", listOf("න්‍යෂ්ටිය", "nucleus"), "න්‍යෂ්ටිය (Nucleus) වේ.", "වර්ණදේහ හා DNA දරන කොටසයි.")
        6 -> Quintuple("ප්‍රෝටීන සංස්ලේෂණය සිදු කරනු ලබන කැටිතිමය ඉන්ද්‍රියිකාව කුමක්ද?", "Which organelle synthesizes proteins?", listOf("රයිබොසෝම", "ribosomes"), "රයිබොසෝම (Ribosomes) වේ.", "අන්තප්ලාස්මීය ජාලිකා මතද පිහිටයි.")
        7 -> Quintuple("ශාක සෛලයක මධ්‍යයේ විශාලව පිහිටන ඉන්ද්‍රියිකාව කුමක්ද?", "Which organelle occupies the center of a plant cell?", listOf("මධ්‍ය රික්තකය", "රික්තකය", "vacuole"), "මධ්‍ය රික්තකය (Central vacuole) වේ.", "සෛල යුෂයෙන් පිරී ඇත.")
        8 -> Quintuple("සෛලයට ද්‍රව්‍ය ඇතුළුවීම පාලනය කරන අර්ධ පාරගම්‍ය පටලය කුමක්ද?", "What semi-permeable membrane controls cell transport?", listOf("ප්ලාස්ම පටලය", "සෛල පටලය", "plasma membrane"), "ප්ලාස්ම පටලය හෙවත් සෛල පටලය වේ.", "පොස්පොලිපිඩ ද්විත්ව ස්ථරයකි.")
        9 -> Quintuple("සෛලීය ස්‍රාව නිපදවීම හා ඇසුරුම් කිරීම කරන ඉන්ද්‍රියිකාව කුමක්ද?", "Which organelle packages and secretes materials?", listOf("ගොල්ගි දේහ", "ගොල්ගි", "golgi"), "ගොල්ගි දේහ හෙවත් ගොල්ගි සංකීර්ණය වේ.", "කැමිලෝ ගොල්ගි සොයාගත් ඉන්ද්‍රියිකාවයි.")
        10 -> Quintuple("ජලවිච්ඡේදක එන්සයිම අඩංගු සෛල කොටස් ජීර්ණය කරන ඉන්ද්‍රියිකාව කුමක්ද?", "Which organelle contains hydrolytic digestive enzymes?", listOf("ලයිසොසෝම", "lysosomes"), "ලයිසොසෝම (Lysosomes) වේ.", "සත්ත්ව සෛලවල ප්‍රධානයි.")
        11 -> Quintuple("න්‍යෂ්ටික පටලයක් නොමැති ප්‍රාග්න්‍යෂ්ටික සෛල සඳහා උදාහරණයක් පවසන්න.", "Give an example of a prokaryotic cell.", listOf("බැක්ටීරියා", "bacteria"), "බැක්ටීරියා (Bacteria) හෝ සයනොබැක්ටීරියා වේ.", "ක්ෂුද්‍ර ඒකසෛලික ජීවියෙකි.")
        12 -> Quintuple("සත්ත්ව සෛල විභාජනයේදී තර්කුව සෑදීමට උපකාරී වන ඉන්ද්‍රියිකාව කුමක්ද?", "Which organelle forms the spindle in animal cell division?", listOf("කේන්ද්‍රදේහය", "කේන්ද්‍රිකා", "centrosome"), "කේන්ද්‍රදේහය හෙවත් කේන්ද්‍රිකා (Centrosome) වේ.", "ශාක සෛලවල දක්නට නැත.")
        13 -> Quintuple("සෛල වාදයට අයත් නොවන සෛලීය නොවන ආසාදිත අංශුව කුමක්ද?", "Which non-cellular infectious particle is an exception to cell theory?", listOf("වෛරස", "virus"), "වෛරස (Viruses) වේ.", "ජීවී සෛල තුළ පමණක් බෝවේ.")
        14 -> Quintuple("සෛලයක ඉන්ද්‍රියිකා ගිලී පවතින ජෙලි වැනි තරලමය මාධ්‍යය කුමක්ද?", "What is the jelly-like fluid where organelles are suspended?", listOf("සෛල ප්ලාස්මය", "cytoplasm"), "සෛල ප්ලාස්මය (Cytoplasm) වේ.", "ප්ලාස්ම පටලයෙන් වටවූ තරලයයි.")
        15 -> Quintuple("ශාකවල ජලය හා ඛනිජ ලවණ පරිවහනය කරන අජීවී සනාල පටකය කුමක්ද?", "Which non-living vascular tissue transports water in plants?", listOf("ශෛලම", "xylem"), "ශෛලම පටකය (Xylem) වේ.", "වාහිනී හා වාහිනිකා අඩංගුයි.")
        16 -> Quintuple("ශාකවල නිපදවන ආහාර පරිවහනය කරන ජීවී සනාල පටකය කුමක්ද?", "Which living vascular tissue transports food in plants?", listOf("ෆ්ලෝයම", "phloem"), "ෆ්ලෝයම පටකය (Phloem) වේ.", "පෙනේර නල අඩංගු පටකයයි.")
        17 -> Quintuple("මිනිස් දේහයේ දිගම සෛලය හඳුන්වන නම කුමක්ද?", "What is the longest cell in the human body?", listOf("ස්නායු සෛලය", "නියුරෝනය", "neuron"), "ස්නායු සෛලය හෙවත් නියුරෝනය වේ.", "ආවේග ගෙනයන සෛලයයි.")
        18 -> Quintuple("මිනිස් රුධිරයේ ඔක්සිජන් ප්‍රවාහනය කරන න්‍යෂ්ටියක් රහිත සෛලය කුමක්ද?", "Which enucleated blood cell transports oxygen?", listOf("රතු රුධිරාණු", "RBC", "red blood cell"), "රතු රුධිරාණුව (Erythrocyte) වේ.", "හිමොග්ලොබින් අඩංගු සෛලයයි.")
        19 -> Quintuple("සෛලයක ප්‍රවේණික තොරතුරු පරම්පරාවට ගෙන යන ප්‍රධාන අණුව කුමක්ද?", "Which molecule carries hereditary traits in cells?", listOf("DNA", "නියුක්ලික් අම්ල"), "DNA අණුව (ඩිඔක්සිරයිබෝනියුක්ලික් අම්ලය) වේ.", "න්‍යෂ්ටිය තුළ පිහිටයි.")
        20 -> Quintuple("ශාක සෛල බිත්ති අතර සෛල ප්ලාස්මය සම්බන්ධ කරන පාලම් මොනවාද?", "What microscopic channels connect adjacent plant cells?", listOf("ප්ලාස්මබන්ධ", "plasmodesmata"), "ප්ලාස්මබන්ධ (Plasmodesmata) වේ.", "සෛල අතර ද්‍රව්‍ය හුවමාරු කරයි.")
        else -> Quintuple("සෛලයේ මූලික ජීව ව්‍යුහය කුමක්ද?", "What is the fundamental unit of life?", listOf("සෛලය", "cell"), "සෛලය ජීවයේ මූලික ව්‍යුහමය හා ක්‍රියාකාරී ඒකකයයි.", "සෛල වාදය සිහිපත් කරන්න.")
      }

      // Set 4: බලය, නිව්ටන් නියම & ඝූර්ණය
      4 -> when (qIndex) {
        1 -> Quintuple("බලය මනින සම්මත SI ඒකකය කුමක්ද?", "Standard SI unit of Force?", listOf("නිව්ටන්", "N", "Newton"), "නිව්ටන් (N) වේ.", "බලයේ ඒකකයයි.")
        2 -> Quintuple("වස්තුවක ස්කන්ධය මනින සම්මත SI ඒකකය කුමක්ද?", "Standard SI unit of Mass?", listOf("කිලෝග්‍රෑම්", "kg", "Kilogram"), "කිලෝග්‍රෑම් (kg) වේ.", "ස්කන්ධයේ ඒකකයයි.")
        3 -> Quintuple("පෘථිවි ගුරුත්වාකර්ෂණ ත්වරණයේ (g) ආසන්න අගය කීයද?", "Approximate value of gravitational acceleration (g)?", listOf("10", "10 m s-2", "9.8"), "තත්පර වර්ගයට මීටර 10ක් (10 m s⁻²) වේ.", "ආසන්න වශයෙන් 10යි.")
        4 -> Quintuple("චලිතයට විරුද්ධව ස්පර්ශ පෘෂ්ඨ අතර ඇතිවන බලය කුමක්ද?", "Force opposing motion between surfaces?", listOf("ඝර්ෂණය", "ඝර්ෂණ බලය", "Friction"), "ඝර්ෂණ බලය (Friction) වේ.", "චලිතය වළකයි.")
        5 -> Quintuple("නිව්ටන්ගේ පළමු චලිත නියමය හඳුන්වන වෙනත් නම කුමක්ද?", "Another name for Newton's First Law?", listOf("නිෂ්ක්‍රීයතා නියමය", "නිෂ්ක්‍රීයතාව", "Inertia"), "නිෂ්ක්‍රීයතා නියමය (Law of Inertia) නමිනි.", "අසමතුලිත බලයක් නැතිවිට චලිතය නොමාරු වේ.")
        6 -> Quintuple("නිව්ටන්ගේ තුන්වන නියමයට අනුව සෑම ක්‍රියාවකටම කුමක් පවතීද?", "What exists for every action according to Newton's 3rd law?", listOf("ප්‍රතික්‍රියාවක්", "සමාන ප්‍රතිවිරුද්ධ ප්‍රතික්‍රියාවක්"), "විශාලත්වයෙන් සමාන, දිශාවෙන් ප්‍රතිවිරුද්ධ ප්‍රතික්‍රියාවකි.", "ක්‍රියාව = ප්‍රතික්‍රියාව.")
        7 -> Quintuple("බලය සහ ලම්බ දුර අතර ගුණිතය හඳුන්වන්නේ කෙසේද?", "Product of force and perpendicular distance?", listOf("ඝූර්ණය", "බලයේ ඝූර්ණය", "Moment"), "බලයේ ඝූර්ණය (Moment of Force) නමිනි.", "භ්‍රමණ බලපෑමයි.")
        8 -> Quintuple("බලයක ඝූර්ණය මනින ඒකකය කුමක්ද?", "Unit of moment of force?", listOf("නිව්ටන් මීටර", "N m", "Nm"), "නිව්ටන් මීටර (N m) වේ.", "බලය × දුරයි.")
        9 -> Quintuple("ඝූර්ණය උපයෝගී වන සරල මෙවලමක් නම් කරන්න.", "Tool that uses moment of force?", listOf("ස්පැනරය", "කරකැවුම් යතුර", "කතුර", "Spanner"), "කරකැවුම් යතුර (ස්පැනරය) හෝ අඬුව වේ.", "ඇණ තද කිරීමට භාවිත කරයි.")
        10 -> Quintuple("වස්තුවක මුළු ස්කන්ධයම ක්‍රියාත්මක වන ලක්ෂ්‍යය කුමක්ද?", "Point where entire mass of body is concentrated?", listOf("ගුරුත්වාකර්ෂණ කේන්ද්‍රය", "Center of gravity"), "ගුරුත්වාකර්ෂණ කේන්ද්‍රය (Center of Gravity) වේ.", "ස්කන්ධ කේන්ද්‍රයයි.")
        11 -> Quintuple("සමතුලිතතාව වඩාත් ස්ථායී වීමට ගුරුත්වාකර්ෂණ කේන්ද්‍රය පිහිටිය යුත්තේ කොහේද?", "Where should center of gravity be for maximum stability?", listOf("පහළින්", "හැකිතාක් පහළින්", "පහතින්"), "හැකිතාක් පහළින් පිහිටිය යුතුය.", "පහළට වන්නටය.")
        12 -> Quintuple("සමතුලිතතාව වඩාත් ස්ථායී වීමට පාදමේ වර්ගඵලය කෙබඳු විය යුතුද?", "How should base area be for high stability?", listOf("විශාල විය යුතුයි", "විශාල", "පළල්"), "හැකිතාක් විශාල (පළල්) විය යුතුය.", "විශාල පාදමකි.")
        13 -> Quintuple("විශ්ව ගුරුත්වාකර්ෂණ නියමය සොයාගත් විද්‍යාඥයා කවුද?", "Scientist who formulated Universal Gravitation?", listOf("නිව්ටන්", "අයිසැක් නිව්ටන්", "Isaac Newton"), "ශ්‍රීමත් අයිසැක් නිව්ටන් වේ.", "ඇපල් ගෙඩිය වැටීම මුල් විය.")
        14 -> Quintuple("ස්කන්ධය 1 kg වූ වස්තුවක බර පෘථිවියේදී නිව්ටන් කීයද?", "Weight of 1 kg mass on Earth?", listOf("10", "10 N", "නිව්ටන් 10"), "නිව්ටන් 10ක් (10 N) වේ.", "W = mg අනුව 10යි.")
        15 -> Quintuple("විශ්වයේ කොතැනකදීවත් වෙනස් නොවන්නේ ස්කන්ධයද නැතහොත් බරද?", "Which remains unchanged anywhere in universe: mass or weight?", listOf("ස්කන්ධය", "ස්කන්ධයයි", "Mass"), "ස්කන්ධය වේ (බර ගුරුත්වය අනුව වෙනස් වේ).", "ස්කන්ධය නියතයි.")
        16 -> Quintuple("වස්තුවක බර මැනීමට විද්‍යාගාරයේ භාවිත කරන උපකරණය කුමක්ද?", "Lab instrument to measure weight?", listOf("දුනු තුලාව", "Spring balance"), "දුනු තුලාව වේ.", "නිව්ටන් අගය මනියි.")
        17 -> Quintuple("වස්තුවක ස්කන්ධය මැනීමට භාවිත කරන උපකරණය කුමක්ද?", "Instrument used to measure mass?", listOf("රසායනික තුලාව", "තුලාව", "ත්‍රිදණ්ඩ තුලාව"), "රසායනික තුලාව හෝ ත්‍රිදණ්ඩ තුලාව වේ.", "කිලෝග්‍රෑම් හෝ ග්‍රෑම් මනියි.")
        18 -> Quintuple("යන්ත්‍රවල ඝර්ෂණය අඩු කිරීමට යොදන ද්‍රව්‍යයක් නම් කරන්න.", "Substance used to reduce friction in machines?", listOf("ලිහිසි තෙල්", "ග්‍රීස්", "Lubricant"), "ලිහිසි තෙල් හෝ ග්‍රීස් වේ.", "ලිහිසි ද්‍රව්‍යයි.")
        19 -> Quintuple("පාපැදි රෝදවල ඝර්ෂණය අඩු කිරීමට යොදන ලෝහ බෝල කොටස් මොනවාද?", "Components with metal balls reducing friction in cycles?", listOf("බෝල බෙයාරිං", "බෙයාරිං", "Ball bearings"), "බෝල බෙයාරිං (Ball bearings) වේ.", "පෙරළෙන ඝර්ෂණය හදයි.")
        20 -> Quintuple("රොකට්ටුවක් අහසට එසවෙන්නේ නිව්ටන්ගේ කුමන නියමයට අනුවද?", "Which Newton's law explains rocket propulsion?", listOf("තුන්වන නියමය", "තුන්වැනි නියමය", "3rd law"), "නිව්ටන්ගේ තුන්වන චලිත නියමයටය.", "වායු විදීම ක්‍රියාවයි, රොකට්ටුව එසවීම ප්‍රතික්‍රියාවයි.")
        else -> Quintuple("බලයේ මූලික ඒකකය කුමක්ද?", "Basic unit of force?", listOf("නිව්ටන්", "N"), "නිව්ටන් වේ.", "බලයේ ඒකකයයි.")
      }

      // Set 5: ඝනත්වය, පීඩනය & ආකිමිඩීස් මූලධර්මය
      5 -> when (qIndex) {
        1 -> Quintuple("පීඩනය මනින සම්මත SI ඒකකය කුමක්ද?", "SI unit of Pressure?", listOf("පැස්කල්", "Pa", "Pascal"), "පැස්කල් (Pa) වේ.", "වර්ග මීටරයට නිව්ටන්ය.")
        2 -> Quintuple("ඝනත්වය මනින සම්මත SI ඒකකය කුමක්ද?", "SI unit of Density?", listOf("kg m-3", "කිලෝග්‍රෑම් ඝන මීටරයට"), "කිලෝග්‍රෑම් ඝන මීටරයට (kg m⁻³) වේ.", "ස්කන්ධය බෙදීම පරිමාවයි.")
        3 -> Quintuple("පිරිසිදු ජලයේ ඝනත්වය ඝන මීටරයට කිලෝග්‍රෑම් කීයද?", "Density of pure water in kg/m³?", listOf("1000", "1000ක්", "දෙදහසක් නොව දහසක්"), "1000 kg m⁻³ වේ.", "ජලයේ සම්මත ඝනත්වයයි.")
        4 -> Quintuple("වායුගෝලීය පීඩනය මැනීමට භාවිත කරන උපකරණය කුමක්ද?", "Instrument to measure atmospheric pressure?", listOf("බැරෝමීටරය", "Barometer"), "බැරෝමීටරය (Barometer) වේ.", "ටොරිසෙලි සොයාගත්තේය.")
        5 -> Quintuple("සම්මත සාමාන්‍ය වායුගෝලීය පීඩනය රසදිය මිලිමීටර කීයද?", "Standard atmospheric pressure in mmHg?", listOf("760", "760 mm", "760 mmHg"), "රසදිය මිලිමීටර 760ක් (760 mmHg) වේ.", "සම්මත වායුගෝල පීඩනයයි.")
        6 -> Quintuple("ද්‍රවයක ගැඹුරට යත්ම ද්‍රව පීඩනය වැඩිවේද අඩුවේද?", "Does liquid pressure increase or decrease with depth?", listOf("වැඩිවේ", "වැඩි වෙනවා", "increase"), "වැඩිවේ (ගැඹුර වැඩිවන විට පීඩනය වැඩිවේ).", "ගැඹුර සමඟ වැඩිවේ.")
        7 -> Quintuple("ද්‍රවයක ගිල්වූ වස්තුවක් මත ඉහළට යෙදෙන තෙරපුම කුමක්ද?", "Upward force exerted by liquid on submerged object?", listOf("උඩුකුරු තෙරපුම", "Upthrust"), "උඩුකුරු තෙරපුම (Upthrust) වේ.", "වස්තුව සැහැල්ලු කරයි.")
        8 -> Quintuple("ආකිමිඩීස් මූලධර්මයට අනුව උඩුකුරු තෙරපුම සමාන වන්නේ කුමකටද?", "According to Archimedes, upthrust equals what?", listOf("විස්ථාපිත ද්‍රවයේ බර", "ද්‍රවයේ බරට"), "විස්ථාපිත ද්‍රවයේ බරට සමාන වේ.", "ආකිමිඩීස් නීතියයි.")
        9 -> Quintuple("ද්‍රවයක ඝනත්වය සෘජුවම මැනීමට භාවිත කරන උපකරණය කුමක්ද?", "Instrument measuring liquid density directly?", listOf("ද්‍රවමානය", "හයිඩ්‍රෝමීටරය", "Hydrometer"), "ද්‍රවමානය (හයිඩ්‍රෝමීටරය) වේ.", "ද්‍රවයේ පාවෙයි.")
        10 -> Quintuple("කිරිවල සංශුද්ධතාව මැනීමට භාවිත කරන විශේෂ ද්‍රවමානය කුමක්ද?", "Hydrometer used to test milk purity?", listOf("ලැක්ටෝමීටරය", "Lactometer"), "ලැක්ටෝමීටරය (Lactometer) වේ.", "කිරිවල ඝනත්වය මනියි.")
        11 -> Quintuple("වාහන එසවීමට ගරාජවල භාවිත කරන ද්‍රව පීඩන උපකරණය කුමක්ද?", "Hydraulic lifting machine in garages?", listOf("හයිඩ්‍රොලික් ජැක්කිය", "ද්‍රාව බල එසවුම", "Hydraulic jack"), "හයිඩ්‍රොලික් ජැක්කිය (ද්‍රාව බල එසවුම) වේ.", "පැස්කල් මූලධර්මයයි.")
        12 -> Quintuple("හයිඩ්‍රොලික් යන්ත්‍ර ක්‍රියාත්මක වන්නේ කුමන විද්‍යාඥයාගේ මූලධර්මයට අනුවද?", "Whose principle governs hydraulic systems?", listOf("පැස්කල්", "බ්ලේස් පැස්කල්", "Pascal"), "බ්ලේස් පැස්කල්ගේ මූලධර්මයට අනුවය.", "සංවෘත ද්‍රව පීඩනයයි.")
        13 -> Quintuple("පිහියක මුවහත තියුණු කරන්නේ පීඩනය වැඩි කිරීමටද අඩු කිරීමටද?", "Is knife sharpened to increase or decrease pressure?", listOf("වැඩි කිරීමට", "වැඩි වෙන්න", "increase"), "පීඩනය වැඩි කිරීමටය (ස්පර්ශ වර්ගඵලය අඩු කර).", "පීඩනය වැඩි කරයි.")
        14 -> Quintuple("හිම මත ලිස්සා යන පුවරු පළල්ව තනා ඇත්තේ ඇයි?", "Why are skis made wide?", listOf("පීඩනය අඩු කිරීමට", "ගිලී යාම වැළැක්වීමට"), "පීඩනය අඩු කර හිමෙහි ගිලී යාම වැළැක්වීමටය.", "වර්ගඵලය වැඩි කිරීමෙනි.")
        15 -> Quintuple("මුහුදු ජලයේ ඝනත්වය සාමාන්‍ය ගංගා ජලයට වඩා වැඩියිද අඩුයිද?", "Is sea water denser than river water?", listOf("වැඩියි", "වැඩි වේ", "higher"), "වැඩිය (ලවණ දියවී ඇති බැවින්).", "ලවණතාව නිසා වැඩිය.")
        16 -> Quintuple("මිනිස් සිරුරේ රුධිර පීඩනය මැනීමට භාවිත කරන වෛද්‍ය උපකරණය කුමක්ද?", "Medical tool used to measure blood pressure?", listOf("ස්ෆිග්මෝමනෝමීටරය", "BP මීටරය", "Sphygmomanometer"), "ස්ෆිග්මෝමනෝමීටරය (Sphygmomanometer) වේ.", "රුධිර පීඩන මානයයි.")
        17 -> Quintuple("නැවක් ජලයේ පාවෙන්නේ එහි බරට සමාන කුමක් ලැබෙන නිසාද?", "Why does a ship float in water?", listOf("උඩුකුරු තෙරපුම", "උඩුකුරු තෙරපුමක්"), "නැවේ බරට සමාන උඩුකුරු තෙරපුමක් ලැබෙන නිසාය.", "පා පාවීමේ නීතියයි.")
        18 -> Quintuple("උඩුකුරු තෙරපුම වස්තුවේ බරට වඩා අඩු වූ විට වස්තුවට කුමක් සිදුවේද?", "What happens if upthrust is less than body's weight?", listOf("ගිලෙයි", "ගිලී යනවා", "sink"), "වස්තුව ද්‍රවයේ ගිලී යයි.", "පතුලට බසියි.")
        19 -> Quintuple("දිය යට කිමිදෙන සබ්මැරීනයක් මතුපිටට එන්නේ කෙසේද?", "How does a submarine surface from underwater?", listOf("ජලය බැහැර කර", "වාතය පුරවා", "බැලස්ට් ටැංකි"), "බැලස්ට් ටැංකිවල ඇති ජලය සම්පීඩිත වාතයෙන් පිටතට තල්ලු කරමිනි.", "ඝනත්වය අඩු කරගනියි.")
        20 -> Quintuple("වායුගෝලීය පීඩනය කඳු මුදුන්වලදී මුහුදු මට්ටමට වඩා වැඩියිද අඩුයිද?", "Is atmospheric pressure lower or higher on mountains?", listOf("අඩුයි", "අඩු වේ", "lower"), "අඩුය (වායු ස්ථම්භයේ උස අඩුවන නිසා).", "උසට යත්ම පීඩනය බසියි.")
        else -> Quintuple("පීඩනය යනු කුමක්ද?", "What is pressure?", listOf("වර්ගඵලයට බලය", "F/A"), "ඒකක වර්ගඵලයකට ලම්බකව යෙදෙන බලයයි.", "පීඩනය = බලය / වර්ගඵලය.")
      }

      // Set 6: රසායනික බන්ධන & සංයෝග
      6 -> when (qIndex) {
        1 -> Quintuple("ඉලෙක්ට්‍රෝන හුවමාරුවෙන් (දීමෙන් හා ගැනීමෙන්) සෑදෙන බන්ධනය කුමක්ද?", "Bond formed by electron transfer?", listOf("අයනික", "අයනික බන්ධනය", "Ionic"), "අයනික බන්ධනය (Ionic bond) වේ.", "කැටායන හා ඇනායන අතරයි.")
        2 -> Quintuple("පරමාණු අතර ඉලෙක්ට්‍රෝන හවුලේ තබාගැනීමෙන් සෑදෙන බන්ධනය කුමක්ද?", "Bond formed by sharing electron pairs?", listOf("සහසංයුජ", "සහසංයුජ බන්ධනය", "Covalent"), "සහසංයුජ බන්ධනය (Covalent bond) වේ.", "අලෝහ පරමාණු අතරයි.")
        3 -> Quintuple("සෝඩියම් ක්ලෝරයිඩ් (කෑම ලුණු) වල ඇති රසායනික බන්ධන වර්ගය කුමක්ද?", "Type of bond in Sodium Chloride (NaCl)?", listOf("අයනික", "අයනික බන්ධන", "Ionic"), "අයනික බන්ධනය වේ.", "Na⁺ සහ Cl⁻ අතරයි.")
        4 -> Quintuple("ජලය (H₂O) අණුවේ අඩංගු මූලද්‍රව්‍ය දෙක මොනවාද?", "Two elements in water molecule?", listOf("හයිඩ්‍රජන් සහ ඔක්සිජන්", "හයිඩ්‍රජන්", "ඔක්සිජන්"), "හයිඩ්‍රජන් (H) සහ ඔක්සිජන් (O) වේ.", "H₂O වේ.")
        5 -> Quintuple("ජල අණුවේ පරමාණු අතර පවතින්නේ අයනිකද සහසංයුජද?", "Are bonds in water ionic or covalent?", listOf("සහසංයුජ", "සහසංයුජ බන්ධන", "Covalent"), "සහසංයුජ බන්ධන වේ.", "ඉලෙක්ට්‍රෝන හවුලේ තබයි.")
        6 -> Quintuple("ඔක්සිජන් වායු (O₂) අණුවක පරමාණු අතර ඇති සහසංයුජ බන්ධන ගණන කීයද?", "Number of bonds in Oxygen molecule (O2)?", listOf("දෙකක්", "ද්විත්ව බන්ධනයක්", "2"), "ද්විත්ව බන්ධනයකි (බන්ධන 2ක්).", "ඉලෙක්ට්‍රෝන යුගල 2ක් හවුලේ තබයි.")
        7 -> Quintuple("නයිට්‍රජන් වායු (N₂) අණුවේ පරමාණු අතර ඇති බන්ධන ගණන කීයද?", "Number of bonds in Nitrogen molecule (N2)?", listOf("තුනක්", "ත්‍රිත්ව බන්ධනයක්", "3"), "ත්‍රිත්ව බන්ධනයකි (බන්ධන 3ක්).", "ඉලෙක්ට්‍රෝන යුගල 3කි.")
        8 -> Quintuple("කාමර උෂ්ණත්වයේදී ඝන ස්ඵටික ලෙස පවතින සංයෝග වර්ගය කුමක්ද?", "Type of compounds existing as solid crystals at room temp?", listOf("අයනික සංයෝග", "අයනික", "Ionic"), "අයනික සංයෝග වේ.", "ශක්තිමත් ජාලක ව්‍යුහයකි.")
        9 -> Quintuple("ජලයේ දියවූ විට විදුලිය සන්නයනය කරන්නේ අයනිකද සහසංයුජද?", "Which conducts electricity when dissolved: ionic or covalent?", listOf("අයනික", "අයනික සංයෝග", "Ionic"), "අයනික සංයෝග වේ (නිදහස් අයන ඇති නිසා).", "අයන මඟින් විදුලිය ගෙනයයි.")
        10 -> Quintuple("කාබන්ඩයොක්සයිඩ් (CO₂) අණුවක ඇති ඔක්සිජන් පරමාණු ගණන කීයද?", "Number of oxygen atoms in CO2?", listOf("2ක්", "දෙකක්", "2"), "පරමාණු 2කි.", "කාබන් 1යි ඔක්සිජන් 2යි.")
        11 -> Quintuple("මීතේන් (CH₄) වායුවේ අඩංගු හයිඩ්‍රජන් පරමාණු ගණන කීයද?", "Number of hydrogen atoms in Methane (CH4)?", listOf("4ක්", "හතරක්", "4"), "හයිඩ්‍රජන් පරමාණු 4කි.", "CH₄ අණුවයි.")
        12 -> Quintuple("අයනික සංයෝගවල ද්‍රවාංක සහ තාපාංක සාමාන්‍යයෙන් ඉහළද පහළද?", "Are melting and boiling points of ionic compounds high or low?", listOf("ඉහළයි", "ඉහළ වේ", "High"), "ඉහළ අගයක් ගනී.", "ශක්තිමත් බන්ධනයි.")
        13 -> Quintuple("සහසංයුජ සංයෝගවල ද්‍රවාංක සහ තාපාංක සාමාන්‍යයෙන් ඉහළද පහළද?", "Are melting points of covalent compounds high or low?", listOf("පහළයි", "පහළ වේ", "Low"), "පහළ අගයක් ගනී.", "දුබල අන්තර් අණුක බලයි.")
        14 -> Quintuple("සෝඩියම් පරමාණුව කැටායනයක් වන විට පිට කරන ඉලෙක්ට්‍රෝන ගණන කීයද?", "Electrons lost by Sodium to form cation?", listOf("එකක්", "1", "1ක්"), "ඉලෙක්ට්‍රෝන 1කි (Na⁺ සාදයි).", "සංයුජතා ඉලෙක්ට්‍රෝනයයි.")
        15 -> Quintuple("ක්ලෝරීන් පරමාණුව ඇනායනයක් වන විට ලබාගන්නා ඉලෙක්ට්‍රෝන ගණන කීයද?", "Electrons gained by Chlorine to form anion?", listOf("එකක්", "1", "1ක්"), "ඉලෙක්ට්‍රෝන 1කි (Cl⁻ සාදයි).", "අෂ්ටකය සම්පූර්ණ කරයි.")
        16 -> Quintuple("කාබන් පරමාණුවේ සංයුජතාව කීයද?", "Valency of Carbon?", listOf("4", "හතරයි", "හතරක්"), "හතරයි (4).", "සංයුජතා ඉලෙක්ට්‍රෝන 4කි.")
        17 -> Quintuple("හයිඩ්‍රජන් පරමාණුවේ සංයුජතාව කීයද?", "Valency of Hydrogen?", listOf("1", "එකයි", "එකක්"), "එකයි (1).", "සරලම මූලද්‍රව්‍යයයි.")
        18 -> Quintuple("ඔක්සිජන් පරමාණුවේ සංයුජතාව කීයද?", "Valency of Oxygen?", listOf("2", "දෙකයි", "දෙකක්"), "දෙකයි (2).", "ඉලෙක්ට්‍රෝන 2ක් ලබාගනී.")
        19 -> Quintuple("ලෝහ පරමාණු අතර පවතින විශේෂ බන්ධනය කුමක්ද?", "Special bonding existing between metal atoms?", listOf("ලෝහක බන්ධනය", "ලෝහක", "Metallic"), "ලෝහක බන්ධනය (Metallic bond) වේ.", "ඉලෙක්ට්‍රෝන මුහුදයි.")
        20 -> Quintuple("ලෝහ විදුලිය හොඳින් සන්නයනය කරන්නේ කුමක් නිසාද?", "Why do metals conduct electricity well?", listOf("නිදහස් ඉලෙක්ට්‍රෝන", "චල්‍ය ඉලෙක්ට්‍රෝන"), "නිදහස් ඉලෙක්ට්‍රෝන (චල්‍ය ඉලෙක්ට්‍රෝන) පවතින බැවිනි.", "ඉලෙක්ට්‍රෝන ගලා යයි.")
        else -> Quintuple("රසායනික බන්ධන සෑදීමේ මූලික අරමුණ කුමක්ද?", "Primary goal of forming chemical bonds?", listOf("ස්ථාවර ඉලෙක්ට්‍රොනික වින්‍යාසය", "ස්ථාවර වීම"), "උච්ච වායුවක බඳු ස්ථාවර ඉලෙක්ට්‍රොනික වින්‍යාසයක් ලබාගැනීමයි.", "ස්ථාවරත්වයට පත්වීමයි.")
      }

      // Set 7: ශාක හා සත්ත්ව පටක සංවිධානය
      7 -> when (qIndex) {
        1 -> Quintuple("එකම කාර්යයක් ඉටු කරන සෛල සමූහයක් හඳුන්වන්නේ කෙසේද?", "A group of similar cells performing a function?", listOf("පටකයක්", "පටක", "Tissue"), "පටකයක් (Tissue) නමිනි.", "සෛල එකතුවකි.")
        2 -> Quintuple("ශාකවල අඛණ්ඩව සෛල විභාජනය වන පටකය කුමක්ද?", "Plant tissue undergoing continuous cell division?", listOf("විභාජක පටකය", "විභාජක", "Meristem"), "විභාජක පටකය (Meristematic tissue) වේ.", "වර්ධනයට හේතු වේ.")
        3 -> Quintuple("ශාක කඳේ හා මුලේ අග්‍රයේ පිහිටන විභාජක පටකය කුමක්ද?", "Meristem located at growing tips of stem and root?", listOf("අග්‍රස්ථ විභාජකය", "අග්‍රස්ථ"), "අග්‍රස්ථ විභාජක පටකය වේ.", "උස යාමට උපකාරී වේ.")
        4 -> Quintuple("ශාකවල ආහාර නිපදවීම හා ගබඩා කරන ප්‍රධාන සරල පටකය කුමක්ද?", "Simple plant tissue storing and synthesizing food?", listOf("මෘදුස්තර පටකය", "පැරන්කිමාව", "Parenchyma"), "මෘදුස්තර පටකය (Parenchyma) වේ.", "සජීවී සෛලයි.")
        5 -> Quintuple("ශාකයේ ලපටි කොටස්වලට නම්‍යශීලී බව හා ශක්තිය දෙන පටකය කුමක්ද?", "Plant tissue giving flexibility and support to young parts?", listOf("ස්ථූලකෝණාස්තර", "කොලන්කිමාව", "Collenchyma"), "ස්ථූලකෝණාස්තර පටකය (Collenchyma) වේ.", "නැමිය හැකි ශක්තිය දෙයි.")
        6 -> Quintuple("පොල් කට්ටේ සහ පෙයාර්ස් පලතුරේ ඇති දෘඪ ශාක පටකය කුමක්ද?", "Hard mechanical plant tissue found in coconut shell?", listOf("දෘඪස්තර", "ස්ක්ලෙරන්කිමාව", "Sclerenchyma"), "දෘඪස්තර පටකය (Sclerenchyma) වේ.", "දෘඪතාව ලබාදෙයි.")
        7 -> Quintuple("ශාක පත්‍රයේ හා කඳේ බාහිරින්ම පිහිටා ආරක්ෂාව දෙන පටකය කුමක්ද?", "Outermost protective plant tissue layer?", listOf("අපිචර්මය", "අපිචර්ම පටකය", "Epidermis"), "අපිචර්ම පටකය (Epidermis) වේ.", "කියුටිකලයක් දරයි.")
        8 -> Quintuple("ශාක පත්‍රවල වායු හුවමාරුව සිදුකරන කුඩා සිදුරු මොනවාද?", "Microscopic pores for gas exchange in leaves?", listOf("පත්‍ර රන්ධ්‍ර", "රන්ධ්‍ර", "Stomata"), "පත්‍ර රන්ධ්‍ර (Stomata) වේ.", "වායු හා ජල වාෂ්ප හුවමාරු කරයි.")
        9 -> Quintuple("පත්‍ර රන්ධ්‍ර විවෘත වීම හා වැසීම පාලනය කරන සෛල මොනවාද?", "Cells that regulate opening and closing of stomata?", listOf("පාලක සෛල", "Guard cells"), "පාලක සෛල (Guard cells) වේ.", "වකුගඩු හැඩැති සෛල දෙකකි.")
        10 -> Quintuple("සත්ත්ව දේහය ආවරණය කරමින් බාහිර ආරක්ෂාව සපයන පටකය කුමක්ද?", "Tissue covering animal body and lining cavities?", listOf("අපිච්ඡද පටකය", "අපිච්ඡද", "Epithelial"), "අපිච්ඡද පටකය (Epithelial tissue) වේ.", "සමේ පිටතින් පිහිටයි.")
        11 -> Quintuple("මිනිස් සිරුරේ අස්ථි සහ පේශි එකිනෙකට සම්බන්ධ කරන පටකය කුමක්ද?", "Tissue connecting muscles to bones?", listOf("කණ්ඩරා", "Tendons"), "කණ්ඩරා (Tendons) වේ.", "සුදු තන්තුමය පටකයකි.")
        12 -> Quintuple("අස්ථි දෙකක් සන්ධිවලදී එකිනෙකට සම්බන්ධ කර තබන පටකය කුමක්ද?", "Tissue connecting two bones at a joint?", listOf("බන්ධනී", "Ligaments"), "බන්ධනී (Ligaments) වේ.", "කහ ප්‍රත්‍යාස්ථ තන්තුයි.")
        13 -> Quintuple("අපගේ කැමැත්තෙන් චලනය කළ හැකි සවිඥානික පේශි මොනවාද?", "Voluntary muscles under conscious control?", listOf("කංකාල පේශි", "රේඛීය පේශි", "Skeletal"), "කංකාල පේශි (රේඛීය පේශි) වේ.", "අස්ථි සමඟ බැඳී ඇත.")
        14 -> Quintuple("ආමාශයේ සහ රුධිර නාලවල පිහිටන අපේ කැමැත්තෙන් තොර පේශි මොනවාද?", "Involuntary muscles in stomach and blood vessels?", listOf("සිනිඳු පේශි", "අවිඥානික පේශි", "Smooth"), "සිනිඳු පේශි (අවිඥානික පේශි) වේ.", "ස්වයංක්‍රීයව ක්‍රියා කරයි.")
        15 -> Quintuple("හෘදයේ පමණක් පිහිටන විඩාවට පත්නොවන පේශි පටකය කුමක්ද?", "Non-fatiguing muscle tissue found only in heart?", listOf("හෘද පේශි", "හෘද පේශි පටකය", "Cardiac"), "හෘද පේශි පටකය (Cardiac muscle) වේ.", "නොනැවතී ස්පන්දනය වේ.")
        16 -> Quintuple("මිනිස් සිරුරේ ස්නායු ආවේග සම්ප්‍රේෂණය කරන පටකය කුමක්ද?", "Tissue transmitting nervous impulses?", listOf("ස්නායු පටකය", "Nervous tissue"), "ස්නායු පටකය වේ.", "නියුරෝනවලින් සෑදී ඇත.")
        17 -> Quintuple("ද්‍රවමය පූරකයක් සහිත සිරුරේ ඇති සම්බන්ධක පටකය කුමක්ද?", "Fluid connective tissue in human body?", listOf("රුධිරය", "Blood"), "රුධිරය (Blood) වේ.", "ප්ලාස්මාව හා රුධිරාණු අඩංගුයි.")
        18 -> Quintuple("රතු රුධිරාණු නිපදවෙන්නේ අස්ථිවල කුමන ස්ථානයේදීද?", "Where are red blood cells produced?", listOf("රතු ඇට මිදුළු", "ඇට මිදුළු", "Bone marrow"), "රතු ඇට මිදුළු (Red bone marrow) තුළය.", "දිගු අස්ථි අභ්‍යන්තරයේය.")
        19 -> Quintuple("කැල්සියම් තැන්පත් වී සෑදුණු දේහයට ආධාරක වන දෘඪ පටකය කුමක්ද?", "Hard calcified tissue supporting body skeleton?", listOf("අස්ථි පටකය", "අස්ථි", "Bone"), "අස්ථි පටකය (Bone tissue) වේ.", "දේහ කංකාලය සාදයි.")
        20 -> Quintuple("කන් පෙත්තේ සහ නාසයේ අග පිහිටි නම්‍යශීලී පටකය කුමක්ද?", "Flexible skeletal tissue in ear pinna and nose tip?", listOf("කාටිලේජ", "කෝමලාස්ථි", "Cartilage"), "කාටිලේජ හෙවත් කෝමලාස්ථි වේ.", "අස්ථිවලට වඩා නම්‍යශීලීයි.")
        else -> Quintuple("මිනිස් සිරුරේ ප්‍රධාන පටක වර්ග 4 මොනවාද?", "Four primary animal tissues?", listOf("අපිච්ඡද", "සම්බන්ධක", "පේශි", "ස්නායු"), "අපිච්ඡද, සම්බන්ධක, පේශි සහ ස්නායු පටක වේ.", "පටක වර්ග 4කි.")
      }

      // Set 8: චලිතය, ප්‍රවේගය & ත්වරණය
      8 -> when (qIndex) {
        1 -> Quintuple("වේගය මනින සම්මත SI ඒකකය කුමක්ද?", "Standard SI unit of Speed?", listOf("m s-1", "m/s", "තත්පරයට මීටර"), "තත්පරයට මීටර (m s⁻¹) වේ.", "වේගයේ ඒකකයයි.")
        2 -> Quintuple("ත්වරණය මනින සම්මත SI ඒකකය කුමක්ද?", "Standard SI unit of Acceleration?", listOf("m s-2", "m/s2", "තත්පර වර්ගයට මීටර"), "තත්පර වර්ගයට මීටර (m s⁻²) වේ.", "ත්වරණයේ ඒකකයයි.")
        3 -> Quintuple("ගමන් කළ මුළු දුර ගත් කාලයෙන් බෙදූ විට ලැබෙන්නේ කුමක්ද?", "Distance divided by time gives what?", listOf("වේගය", "සාමාන්‍ය වේගය", "Speed"), "සාමාන්‍ය වේගය (Speed) වේ.", "වේගය = දුර / කාලය.")
        4 -> Quintuple("විශාලත්වයක් පමණක් ඇති භෞතික රාශි හඳුන්වන්නේ කෙසේද?", "Quantities with magnitude only?", listOf("අදිශ", "අදිශ රාශි", "Scalars"), "අදිශ රාශි (Scalars) නමිනි.", "දිශාවක් නැත.")
        5 -> Quintuple("විශාලත්වයක් මෙන්ම දිශාවක්ද ඇති රාශි හඳුන්වන්නේ කෙසේද?", "Quantities with both magnitude and direction?", listOf("සදිශ", "සදිශ රාශි", "Vectors"), "සදිශ රාශි (Vectors) නමිනි.", "දිශාවක් සහිතයි.")
        6 -> Quintuple("දුර යනු අදිශ රාශියක්ද सදිශ රාශියක්ද?", "Is distance scalar or vector?", listOf("අදිශ", "අදිශ රාශියක්", "Scalar"), "අදිශ රාශියකි.", "දිශාවක් නැත.")
        7 -> Quintuple("විස්ථාපනය යනු අදිශ රාශියක්ද සදිශ රාශියක්ද?", "Is displacement scalar or vector?", listOf("සදිශ", "සදිශ රාශියක්", "Vector"), "සදිශ රාශියකි (ආරම්භයේ සිට අවසානයට කෙටිම දුරයි).", "දිශාව සහිතයි.")
        8 -> Quintuple("ප්‍රවේගය යනු අදිශ රාශියක්ද සදිශ රාශියක්ද?", "Is velocity scalar or vector?", listOf("සදිශ", "සදිශ රාශියක්", "Vector"), "සදිශ රාශියකි (විස්ථාපනය බෙදීම කාලය).", "දිශාවක් සහිත වේගයයි.")
        9 -> Quintuple("ප්‍රවේගය වෙනස්වීමේ ශීඝ්‍රතාව හඳුන්වන්නේ කෙසේද?", "Rate of change of velocity?", listOf("ත්වරණය", "Acceleration"), "ත්වරණය (Acceleration) නමිනි.", "ප්‍රවේගය වැඩිවීමයි.")
        10 -> Quintuple("කාලයත් සමඟ ප්‍රවේගය අඩුවීම හඳුන්වන්නේ කෙසේද?", "Deceleration or negative acceleration is called?", listOf("මන්දනය", "සෘණ ත්වරණය", "Deceleration"), "මන්දනය (Deceleration / Retardation) නමිනි.", "වේගය බිඳවැටීමයි.")
        11 -> Quintuple("වාහනයක ක්ෂණික වේගය රියදුරුට පෙන්වන මීටරය කුමක්ද?", "Meter showing instantaneous speed in vehicles?", listOf("වේගමානය", "ස්පීඩෝමීටරය", "Speedometer"), "වේගමානය (Speedometer) වේ.", "km/h වලින් පෙන්වයි.")
        12 -> Quintuple("වාහනයක් ගමන් කළ මුළු දුර ප්‍රමාණය පෙන්වන මීටරය කුමක්ද?", "Meter recording total distance traveled by vehicle?", listOf("ඔඩෝමීටරය", "Odometer"), "ඔඩෝමීටරය (Odometer) වේ.", "කිලෝමීටර ගණනය කරයි.")
        13 -> Quintuple("නිශ්චලතාවයේ සිට ගමන් අරඹන වස්තුවක ආරම්භක ප්‍රවේගය කීයද?", "Initial velocity of a body starting from rest?", listOf("0", "ශුන්‍යයි", "බිංදුවයි"), "ශුන්‍යයයි (0 m s⁻¹).", "චලනය නොවී තිබුණි.")
        14 -> Quintuple("ප්‍රවේග-කාල ප්‍රස්ථාරයක බෑවුමෙන් (අනුක්‍රමණයෙන්) ලැබෙන්නේ කුමක්ද?", "Slope of a velocity-time graph represents what?", listOf("ත්වරණය", "Acceleration"), "ත්වරණය නිරූපණය වේ.", "අනුක්‍රමණය ත්වරණයයි.")
        15 -> Quintuple("ප්‍රවේග-කාල ප්‍රස්ථාරයකින් වටවූ වර්ගඵලයෙන් ලැබෙන්නේ කුමක්ද?", "Area under velocity-time graph represents what?", listOf("විස්ථාපනය", "ගමන් කළ දුර", "Displacement"), "ගමන් කළ දුර හෙවත් විස්ථාපනයයි.", "වර්ගඵලය දුරයි.")
        16 -> Quintuple("සිරස්ව උඩට විසිකළ ගලක් උපරිම උසට ගිය මොහොතේ ප්‍රවේගය කීයද?", "Velocity of a vertically thrown stone at peak height?", listOf("0", "ශුන්‍යයි", "බිංදුවයි"), "ශුන්‍යයයි (0 m s⁻¹).", "ක්ෂණිකව නතර වේ.")
        17 -> Quintuple("නිදහසේ පොළොවට වැටෙන වස්තුවක් මත ක්‍රියාකරන ත්වරණය කුමක්ද?", "Acceleration acting on a freely falling body?", listOf("ගුරුත්වාකර්ෂණ ත්වරණය", "g", "Gravity"), "ගුරුත්වාකර්ෂණ ත්වරණය (g) වේ.", "පොළොව දෙසටයි.")
        18 -> Quintuple("වස්තුවක් සමාන කාලවලදී සමාන දුරවල් ගමන් කරයි නම් එහි වේගය කුමක්ද?", "Motion covering equal distances in equal times?", listOf("ඒකාකාර වේගය", "Uniform speed"), "ඒකාකාර වේගය (Uniform speed) වේ.", "නියත වේගයකි.")
        19 -> Quintuple("වෘත්තාකාර මාර්ගයක නියත වේගයෙන් යන වාහනයක ප්‍රවේගය නියතද?", "Is velocity constant for a car moving at constant speed in circle?", listOf("නැත", "වෙනස් වේ", "නැහැ"), "නැත, දිශාව නිරතුරුව වෙනස් වන බැවින් ප්‍රවේගය වෙනස් වේ.", "දිශාව වෙනස් වේ.")
        20 -> Quintuple("කිලෝමීටර පැයට (km/h) තත්පරයට මීටර (m/s) කිරීමට බෙදන්නේ කීයෙන්ද?", "Divide km/h by what number to get m/s?", listOf("3.6", "3.6න්"), "3.6 න් බෙදනු ලැබේ.", "1000/3600 අනුපාතයයි.")
        else -> Quintuple("ත්වරණය යනු කුමක්ද?", "What is acceleration?", listOf("ප්‍රවේග වෙනස්වීම", "a = v-u/t"), "ඒකක කාලයකදී සිදුවන ප්‍රවේග වෙනස්වීමයි.", "ප්‍රවේගය වැඩිවීමේ ශීඝ්‍රතාවයි.")
      }

      // Set 9: අම්ල, භෂ්ම, ලවණ & pH පරිමාණය
      9 -> when (qIndex) {
        1 -> Quintuple("උදාසීන පිරිසිදු ජලයේ pH අගය කීයද?", "What is the pH value of neutral pure water?", listOf("7", "හතයි", "7.0"), "7 (හත) වේ.", "උදාසීන ලක්ෂ්‍යයයි.")
        2 -> Quintuple("අම්ල ද්‍රාවණයක pH අගය පවතින්නේ කුමන පරාසයේද?", "pH range of acidic solutions?", listOf("7ට අඩු", "හතට අඩු", "0 සිට 7 දක්වා"), "7ට වඩා අඩු අගයකි (0 සිට 7 දක්වා).", "හතට අඩුයි.")
        3 -> Quintuple("භෂ්ම ද්‍රාවණයක pH අගය පවතින්නේ කුමන පරාසයේද?", "pH range of basic solutions?", listOf("7ට වැඩි", "හතට වැඩි", "7 සිට 14 දක්වා"), "7ට වඩා වැඩි අගයකි (7 සිට 14 දක්වා).", "හතට වැඩියි.")
        4 -> Quintuple("නිල් ලිට්මස් රතු පැහැයට හරවන්නේ අම්ලද නැතහොත් භෂ්මද?", "Does acid or base turn blue litmus red?", listOf("අම්ල", "අම්ලය", "Acid"), "අම්ල (Acids) මඟිනි.", "නිල් ලිට්මස් රතු වේ.")
        5 -> Quintuple("රතු ලිට්මස් නිල් පැහැයට හරවන්නේ අම්ලද භෂ්මද?", "Does acid or base turn red litmus blue?", listOf("භෂ්ම", "භෂ්මය", "Base"), "භෂ්ම (Bases) මඟිනි.", "රතු ලිට්මස් නිල් වේ.")
        6 -> Quintuple("දෙහි සහ දොඩම්වල අඩංගු ස්වභාවික අම්ලය කුමක්ද?", "Natural acid in lime and oranges?", listOf("සිට්‍රික් අම්ලය", "සිට්‍රික්", "Citric acid"), "සිට්‍රික් අම්ලය (Citric acid) වේ.", "පැඟිරි කුලයේ පලතුරුයි.")
        7 -> Quintuple("විනාකිරිවල අඩංගු ප්‍රධාන කාබනික අම්ලය කුමක්ද?", "Main organic acid present in vinegar?", listOf("ඇසිටික් අම්ලය", "එතනොයික් අම්ලය", "Acetic acid"), "ඇසිටික් අම්ලය හෙවත් එතනොයික් අම්ලයයි.", "විනාකිරි සුවඳයි.")
        8 -> Quintuple("කිරි සහ මුදවපු කිරිවල අඩංගු අම්ලය කුමක්ද?", "Acid present in sour milk and curd?", listOf("ලැක්ටික් අම්ලය", "ලැක්ටික්", "Lactic acid"), "ලැක්ටෝස් සීනි ජීර්ණයෙන් සෑදෙන ලැක්ටික් අම්ලයයි.", "කිරි අම්ලයයි.")
        9 -> Quintuple("මිනිස් ආමාශයේ ආහාර ජීර්ණයට නිපදවෙන අම්ලය කුමක්ද?", "Acid secreted in human stomach?", listOf("හයිඩ්‍රොක්ලෝරික්", "HCl", "Hydrochloric acid"), "හයිඩ්‍රොක්ලෝරික් අම්ලය (HCl) වේ.", "පෙප්සින් සක්‍රිය කරයි.")
        10 -> Quintuple("මෝටර් රථ බැටරිවල භාවිත කරන අම්ලය කුමක්ද?", "Acid used in car batteries?", listOf("සල්ෆියුරික්", "සල්ෆියුරික් අම්ලය", "H2SO4"), "සල්ෆියුරික් අම්ලය (H₂SO₄) වේ.", "බැටරි අම්ලයයි.")
        11 -> Quintuple("රසායනාගාරයේ ප්‍රබල භෂ්මයකට ප්‍රධාන උදාහරණය කුමක්ද?", "Key example of a strong base in laboratory?", listOf("සෝඩියම් හයිඩ්‍රොක්සයිඩ්", "NaOH", "Sodium hydroxide"), "සෝඩියම් හයිඩ්‍රොක්සයිඩ් (NaOH) වේ.", "කොස්ටික් සෝඩා නමිනි.")
        12 -> Quintuple("හුණු දියරවල අඩංගු රසායනික භෂ්මය කුමක්ද?", "Chemical base present in lime water?", listOf("කැල්සියම් හයිඩ්‍රොක්සයිඩ්", "Ca(OH)2"), "කැල්සියම් හයිඩ්‍රොක්සයිඩ් (Ca(OH)₂) වේ.", "හුණු දියරයි.")
        13 -> Quintuple("අම්ලයක් සහ භෂ්මයක් ප්‍රතික්‍රියා කර ලවණ සහ ජලය සෑදීම කුමක්ද?", "Reaction between acid and base forming salt and water?", listOf("උදාසීනීකරණය", "Neutralization"), "උදාසීනීකරණ ප්‍රතික්‍රියාව (Neutralization) වේ.", "ලවණ හා ජලය ලැබේ.")
        14 -> Quintuple("සබන් නිෂ්පාදනය සඳහා තෙල් සමඟ මිශ්‍ර කරන භෂ්මය කුමක්ද?", "Base mixed with fats to make soap?", listOf("සෝඩියම් හයිඩ්‍රොක්සයිඩ්", "NaOH", "කොස්ටික් සෝඩා"), "සෝඩියම් හයිඩ්‍රොක්සයිඩ් (කොස්ටික් සෝඩා) වේ.", "සබන්කරණයයි.")
        15 -> Quintuple("පසේ ආම්ලිකතාවය අඩු කිරීමට ගොවීන් පසට එක්කරන්නේ මොනවාද?", "Substance added by farmers to reduce soil acidity?", listOf("හුණු", "ඩොලමයිට්", "කෘෂිකාර්මික හුණු"), "කෘෂිකාර්මික හුණු හෝ ඩොලමයිට් වේ.", "පසේ pH වැඩි කරයි.")
        16 -> Quintuple("කුහුඹු හෝ කඩි දෂ්ට කළ විට ශරීරයට ඇතුල්වන අම්ලය කුමක්ද?", "Acid injected during ant or wasp bites?", listOf("ෆෝමික් අම්ලය", "මෙතනොයික් අම්ලය", "Formic acid"), "ෆෝමික් අම්ලය (මෙතනොයික් අම්ලය) වේ.", "දැවිල්ල ඇතිකරයි.")
        17 -> Quintuple("කඩි විෂ සමනය කිරීමට බාහිරින් ගාන්නේ අම්ලයක්ද භෂ්මයක්ද?", "Is acid or base applied to soothe ant sting?", listOf("භෂ්මයක්", "භෂ්ම", "හුණු", "සබන්"), "දුබල භෂ්මයක් (හුණු, සබන් දියර) වේ.", "උදාසීන කරයි.")
        18 -> Quintuple("ජලීය ද්‍රාවණවල H⁺ හයිඩ්‍රජන් අයන නිදහස් කරන්නේ අම්ලද භෂ්මද?", "Substance releasing H+ ions in aqueous solutions?", listOf("අම්ල", "අම්ලය", "Acids"), "අම්ල (Acids) වේ.", "ආරේනියස් වාදයයි.")
        19 -> Quintuple("ජලීය ද්‍රාවණවල OH⁻ හයිඩ්‍රොක්සයිඩ් අයන නිදහස් කරන්නේ අම්ලද භෂ්මද?", "Substance releasing OH- ions in water?", listOf("භෂ්ම", "භෂ්මය", "Bases"), "භෂ්ම (Bases) වේ.", "හයිඩ්‍රොක්සයිඩ් අයනයි.")
        20 -> Quintuple("ද්‍රාවණයක pH අගය නිවැරදිවම මැනීමට භාවිත කරන ඩිජිටල් උපකරණය කුමක්ද?", "Digital instrument to accurately measure pH?", listOf("pH මීටරය", "pH meter"), "pH මීටරය (pH meter) වේ.", "ඩිජිටල් කියවීම් ලබාදෙයි.")
        else -> Quintuple("උදාසීන ද්‍රාවණයක pH අගය කීයද?", "pH of neutral solution?", listOf("7", "හතයි"), "7 වේ.", "පිරිසිදු ජලයයි.")
      }

      // Set 10: මිනිසාගේ ආහාර ජීර්ණ පද්ධතිය & එන්සයිම
      10 -> when (qIndex) {
        1 -> Quintuple("මිනිසාගේ ආහාර ජීර්ණ ක්‍රියාවලිය ආරම්භ වන්නේ කුමන ස්ථානයෙන්ද?", "Where does human digestion begin?", listOf("මුඛය", "මුඛයෙන්", "Mouth"), "මුඛයෙන් (ඛේටය සමඟ මිශ්‍ර වීමෙන්) වේ.", "මුඛ කුහරයයි.")
        2 -> Quintuple("ඛේටයේ (කෙළවල) අඩංගු පිෂ්ඨය ජීර්ණය කරන එන්සයිමය කුමක්ද?", "Starch-digesting enzyme in human saliva?", listOf("ඇමයිලේස්", "ටයිලින්", "ඛේටමය ඇමයිලේස්"), "ඛේටමය ඇමයිලේස් (ටයිලින්) වේ.", "පිෂ්ඨය මෝල්ටෝස් බවට පත්කරයි.")
        3 -> Quintuple("ආහාර ගුලිය මුඛයේ සිට ආමාශයට ගෙන යන නළය කුමක්ද?", "Tube carrying food bolus from mouth to stomach?", listOf("අන්නස්‍රෝතය", "Esophagus"), "අන්නස්‍රෝතය (Esophagus) වේ.", "මාංශපේෂි නළයකි.")
        4 -> Quintuple("ආහාර මාර්ගය ඔස්සේ ආහාර පහළට තල්ලු වන තරංගාකාර චලනය කුමක්ද?", "Wave-like muscular contraction moving food along gut?", listOf("ක්‍රමාකුංචනය", "Peristalsis"), "ක්‍රමාකුංචනය (Peristalsis) නමිනි.", "පේශි හැකිළීම හා ලිහිල්වීමයි.")
        5 -> Quintuple("ආමාශයික යුෂයේ අඩංගු ප්‍රෝටීන ජීර්ණය කරන ප්‍රධාන එන්සයිමය කුමක්ද?", "Main protein digesting enzyme in gastric juice?", listOf("පෙප්සින්", "Pepsin"), "පෙප්සින් (Pepsin) එන්සයිමය වේ.", "ප්‍රෝටීන පොලිපෙප්ටයිඩ කරයි.")
        6 -> Quintuple("පෙප්සින් සක්‍රිය කිරීමට ආමාශයේ ශ්‍රාවය වන අම්ලය කුමක්ද?", "Acid in stomach that activates pepsin?", listOf("හයිඩ්‍රොක්ලෝරික්", "HCl"), "හයිඩ්‍රොක්ලෝරික් අම්ලය (HCl) වේ.", "විෂබීජද නසයි.")
        7 -> Quintuple("මිනිස් සිරුරේ ඇති විශාලතම ග්‍රන්ථිය කුමක්ද?", "Largest internal gland in human body?", listOf("අක්මාව", "Liver"), "අක්මාව (Liver) වේ.", "පිත නිපදවයි.")
        8 -> Quintuple("අක්මාව මඟින් නිපදවන ආහාර ජීර්ණ තරලය කුමක්ද?", "Digestive juice produced by the liver?", listOf("පිත", "Bile"), "පිත (Bile) වේ.", "මේදය දිරවීමට උපකාරී වේ.")
        9 -> Quintuple("අක්මාවෙන් නිපදවන පිත තාවකාලිකව ගබඩා කරන්නේ කොහේද?", "Where is bile stored temporarily?", listOf("පිත්තාශය", "පිත්තාශයේ", "Gallbladder"), "පිත්තාශය (Gallbladder) තුළය.", "කොළ-කහ පැහැති තරලයකි.")
        10 -> Quintuple("පිත මඟින් ලිපිඩ කුඩා බිඳිති බවට පත්කිරීම හඳුන්වන්නේ කෙසේද?", "Breakdown of fat into tiny droplets by bile?", listOf("තෛලෝදකරණය", "Emulsification"), "තෛලෝදකරණය (Emulsification) නමිනි.", "වර්ගඵලය වැඩි කරයි.")
        11 -> Quintuple("ආහාර ජීර්ණය සහ අවශෝෂණය සම්පූර්ණ වන ප්‍රධානතම ඉන්ද්‍රිය කුමක්ද?", "Organ where digestion and absorption are completed?", listOf("කුඩා බඩවැල", "ක්ෂුද්‍රාන්තය", "Small intestine"), "කුඩා බඩවැල (ක්ෂුද්‍රාන්තය) වේ.", "දිගම කොටසයි.")
        12 -> Quintuple("කුඩා බඩවැලේ අවශෝෂණ වර්ගඵලය වැඩි කරන ඇඟිලි වැනි නෙරුම් මොනවාද?", "Finger-like projections increasing absorption area in small intestine?", listOf("අංගුලිකා", "Villi"), "අංගුලිකා (Villi) වේ.", "පෝෂක රුධිරයට උරාගනියි.")
        13 -> Quintuple("අංගුලිකාවක් තුළ ඇති මේදය අවශෝෂණය කරන වසා නාලය කුමක්ද?", "Lymph vessel inside a villus absorbing fats?", listOf("කිරිවාහිනිය", "Lacteal"), "කිරිවාහිනිය (Lacteal) වේ.", "මේද අම්ල හා ග්ලිසරෝල් උරාගනී.")
        14 -> Quintuple("ග්ලූකෝස් මට්ටම පාලනය කරන ඉන්සියුලින් නිපදවන ග්‍රන්ථිය කුමක්ද?", "Gland producing insulin to regulate glucose?", listOf("අග්න්‍යාශය", "Pancreas"), "අග්න්‍යාශය (Pancreas) වේ.", "මිශ්‍ර ග්‍රන්ථියකි.")
        15 -> Quintuple("ජීර්ණය නොවූ මල ද්‍රව්‍යවලින් ජලය නැවත අවශෝෂණය කරන්නේ කුමන කොටසින්ද?", "Part of gut that reabsorbs water from indigestible waste?", listOf("මහා බඩවැල", "මහාන්ත්‍රය", "Large intestine"), "මහා බඩවැල (මහාන්ත්‍රය / Colon) මඟිනි.", "ජලය ඉතිරි කරයි.")
        16 -> Quintuple("අසූචි පිටවීමට පෙර තාවකාලිකව ගබඩා කර තබන කොටස කුමක්ද?", "Part where feces are stored temporarily before excretion?", listOf("ගුද මාර්ගය", "Rectum"), "ගුද මාර්ගය (Rectum) වේ.", "අසූචි රඳවා තබයි.")
        17 -> Quintuple("මිනිසාගේ මුඛයේ ඇති මුළු ස්ථිර දත් ගණන කීයද?", "Total number of permanent teeth in adult human?", listOf("32ක්", "තිස් දෙකයි", "32"), "දත් 32කි (තිස් දෙකකි).", "හනුවකට 16 බැගිනි.")
        18 -> Quintuple("ආහාර සපා ඇඹරීම සඳහා වඩාත් යෝග්‍ය දත් වර්ගය කුමක්ද?", "Teeth best adapted for crushing and grinding food?", listOf("චාර්වක", "පුරස්චාර්වක", "Molars"), "චාර්වක සහ පුරස්චාර්වක දත් වේ.", "පළල් හකු දත්ය.")
        19 -> Quintuple("ආහාර ඉරාගැනීමට උපකාරී වන උල් දත් වර්ගය කුමක්ද?", "Pointed teeth used for tearing food?", listOf("රදනක", "Canines"), "රදනක දත් (Canines) වේ.", "මාංශභක්ෂකයින්ගේ විශාලයි.")
        20 -> Quintuple("දතක බාහිරින්ම ඇති සිරුරේ දෘඪතම ද්‍රව්‍යය කුමක්ද?", "Hardest substance in human body coating teeth?", listOf("එනමලය", "Enamel"), "එනමලය (Tooth enamel) වේ.", "කැල්සියම් පොස්පේට්වලින් සෑදී ඇත.")
        else -> Quintuple("ආහාර ජීර්ණ පද්ධතියේ ප්‍රධාන කාර්යය කුමක්ද?", "Primary role of digestive system?", listOf("ආහාර ජීර්ණය", "පෝෂක අවශෝෂණය"), "ආහාර ජීර්ණය කර පෝෂක සිරුරට අවශෝෂණය කරගැනීමයි.", "පෝෂණය සැපයීමයි.")
      }

      // Default fallback
      else -> {
        val distinctScience = listOf(
          Quintuple("ප්‍රභාසංස්ලේෂණය සඳහා ශාක අවශෝෂණය කරන ප්‍රධාන වායුව කුමක්ද?", "Gas absorbed by plants for photosynthesis?", listOf("කාබන්ඩයොක්සයිඩ්", "CO2"), "කාබන්ඩයොක්සයිඩ් (CO₂) වායුවයි.", "ප්‍රභාසංස්ලේෂණයට අවශ්‍ය වායුවයි."),
          Quintuple("ප්‍රභාසංස්ලේෂණයේදී අතුරු ඵලයක් ලෙස පරිසරයට මුදාහරින වායුව කුමක්ද?", "Gas released as byproduct of photosynthesis?", listOf("ඔක්සිජන්", "O2"), "ඔක්සිජන් (O₂) වායුවයි.", "ශ්වසනයට උපකාරී වේ."),
          Quintuple("ශාකවල හරිත වර්ණකය හඳුන්වන්නේ කෙසේද?", "Green pigment in plants?", listOf("ක්ලෝරොෆිල්", "හරිතප්‍රද"), "ක්ලෝරොෆිල් (Chlorophyll) නමිනි.", "හිරු එළිය උරාගනී."),
          Quintuple("මිනිස් සිරුරේ සාමාන්‍ය නිරෝගී උෂ්ණත්වය සෙල්සියස් අංශක කීයද?", "Normal human body temperature in Celsius?", listOf("37", "37 C", "අංශක 37"), "සෙල්සියස් අංශක 37ක් (37 °C) වේ.", "සාමාන්‍ය දේහ උෂ්ණත්වයයි."),
          Quintuple("ජලය වාෂ්ප බවට පත්වන තාපාංකය සෙල්සියස් අංශක කීයද?", "Boiling point of water in Celsius?", listOf("100", "100 C", "අංශක 100"), "සෙල්සියස් අංශක 100ක් (100 °C) වේ.", "ජලයේ තාපාංකයයි."),
          Quintuple("ජලය අයිස් බවට පත්වන හිමාංකය සෙල්සියස් අංශක කීයද?", "Freezing point of water in Celsius?", listOf("0", "0 C", "අංශක බිංදුව"), "සෙල්සියස් අංශක 0ක් (0 °C) වේ.", "ජලයේ හිමාංකයයි."),
          Quintuple("ශබ්දය ගමන් කිරීමට මාධ්‍යයක් අවශ්‍යද නැද්ද?", "Does sound require a medium to travel?", listOf("අවශ්‍යයි", "ඔව්"), "ඔව්, මාධ්‍යයක් අවශ්‍ය වේ (රික්තකයක් තුළ ශබ්දය නොයයි).", "මාධ්‍යයක් අත්‍යවශ්‍යයි."),
          Quintuple("ආලෝකය රික්තකයක් තුළ ගමන් කළ හැකිද?", "Can light travel through a vacuum?", listOf("පුළුවන්", "ඔව්", "හැකියි"), "ඔව්, ආලෝකය විද්‍යුත් චුම්භක තරංගයක් බැවින් රික්තකය තුළ ගමන් කළ හැකිය.", "තත්පරයට කි.මී. 300,000කි."),
          Quintuple("විදුලි ධාරාව මනින සම්මත ඒකකය කුමක්ද?", "SI unit of electric current?", listOf("ඇම්පියර්", "A", "Ampere"), "ඇම්පියර් (A) වේ.", "ධාරාවේ ඒකකයයි."),
          Quintuple("විද්‍යුත් විභව අන්තරය මනින ඒකකය කුමක්ද?", "Unit of potential difference?", listOf("වෝල්ට්", "V", "Volt"), "වෝල්ට් (V) වේ.", "වෝල්ටීයතාවයි."),
          Quintuple("විද්‍යුත් ප්‍රතිරෝධය මනින ඒකකය කුමක්ද?", "Unit of electrical resistance?", listOf("ඕම්", "Ohm", "Ω"), "ඕම් (Ω) වේ.", "ප්‍රතිරෝධයේ ඒකකයයි."),
          Quintuple("ශක්තිය හෝ කාර්යය මනින සම්මත SI ඒකකය කුමක්ද?", "SI unit of energy or work?", listOf("ජූල්", "J", "Joule"), "ජූල් (J) වේ.", "ශක්ති ඒකකයයි."),
          Quintuple("ක්ෂමතාවය (බලශක්ති භාවිත ශීඝ්‍රතාව) මනින ඒකකය කුමක්ද?", "Unit of Power?", listOf("වොට්", "W", "Watt"), "වොට් (W) වේ.", "තත්පරයට ජූල්ය."),
          Quintuple("මිනිස් හදවතේ කුටීර ගණන කීයද?", "How many chambers in human heart?", listOf("4ක්", "හතරයි", "4"), "කුටීර 4කි (කර්ණිකා 2ක් සහ කෝෂිකා 2ක්).", "හෘද කුටීර 4යි."),
          Quintuple("රුධිරය කැටි ගැසීමට උපකාරී වන රුධිර සෛල කැබලි මොනවාද?", "Blood cell fragments aiding clotting?", listOf("පට්ටිකා", "Platelets"), "රුධිර පට්ටිකා (Platelets) වේ.", "තුවාලයකදී ලේ වහනය නවත්වයි."),
          Quintuple("ශරීරයේ විෂබීජ නසා රෝගවලින් ආරක්ෂා කරන රුධිර සෛල මොනවාද?", "Blood cells defending against pathogens?", listOf("සුදු රුධිරාණු", "WBC"), "සුදු රුධිරාණු (Leukocytes) වේ.", "ප්‍රතිශක්තිය ලබාදෙයි."),
          Quintuple("පිරිසිදු ඔක්සිජනීකෘත රුධිරය හෘදයේ සිට ශරීරයට ගෙන යන ප්‍රධාන ධමනිය කුමක්ද?", "Main artery carrying oxygenated blood from heart?", listOf("මහා ධමනිය", "Aorta"), "මහා ධමනිය (Aorta) වේ.", "වම් කෝෂිකාවෙන් පිටවේ."),
          Quintuple("ශ්වසනයේදී පෙණහලුවල වායු හුවමාරුව සිදුවන කුඩා වායු කෝෂ මොනවාද?", "Air sacs where gas exchange occurs in lungs?", listOf("ඇල්වියෝලයි", "ගර්ත", "Alveoli"), "වායු කෝෂ හෙවත් ගර්ත (Alveoli) වේ.", "දැල් සහිත වායු කෝෂයි."),
          Quintuple("මිනිස් සිරුරේ බහිස්ස්‍රාවී ප්‍රධාන ඉන්ද්‍රිය කුමක්ද?", "Primary excretory organ in human body?", listOf("වකුගඩු", "Kidneys"), "වකුගඩු යුගලය වේ.", "මුත්‍රා පෙරයි."),
          Quintuple("වකුගඩුවක මූලික ක්‍රියාකාරී හා ව්‍යුහමය ඒකකය කුමක්ද?", "Basic functional unit of kidney?", listOf("නෙප්‍රෝනය", "Nephron"), "නෙප්‍රෝනය (Nephron) වේ.", "රුධිරය පිරිසිදු කරන ඒකකයයි.")
        )
        distinctScience[(qIndex - 1).coerceIn(0, distinctScience.size - 1)]
      }
    }
  }

  // ==============================================================================
  // GRADE 11 O/L SCIENCE BANK (100% GRADE 11 SYLLABUS - SHORT, ACCURATE & DIRECT)
  // ==============================================================================
  private fun getGrade11Question(setNum: Int, qIndex: Int, theme: String): Quintuple<String, String, List<String>, String, String> {
    return when (setNum) {
      // Set 1: ප්‍රභාසංස්ලේෂණය
      1 -> when (qIndex) {
        1 -> Quintuple("ප්‍රභාසංස්ලේෂණය සිදුවන ශාක සෛල ඉන්ද්‍රයිකාව කුමක්ද?", "Organelle where photosynthesis occurs?", listOf("හරිතලව", "හරිතලවය", "Chloroplast"), "හරිතලවය (Chloroplast) වේ.", "හරිතප්‍රද අඩංගු ඉන්ද්‍රයිකාවයි.")
        2 -> Quintuple("ප්‍රභාසංස්ලේෂණයේ ආලෝක ප්‍රතික්‍රියාව සිදුවන්නේ හරිතලවයේ කුමන කොටස තුළද?", "Where does light-dependent reaction occur in chloroplast?", listOf("තයිලකොයිඩ", "ග්‍රානා", "Thylakoid"), "තයිලකොයිඩ පටල හෙවත් ග්‍රානා තුළය.", "තයිලකොයිඩ පටලයයි.")
        3 -> Quintuple("ආලෝකයෙන් ස්වායත්ත (අඳුරු) ප්‍රතික්‍රියාව සිදුවන්නේ හරිතලවයේ කුමන කොටස තුළද?", "Where does Calvin cycle occur in chloroplast?", listOf("ස්ට්‍රෝමාව", "ස්ට්‍රෝමා", "Stroma"), "ස්ට්‍රෝමාව (Stroma) තුළය.", "ජෙලි වැනි පූරකයයි.")
        4 -> Quintuple("ප්‍රභාසංස්ලේෂණයේදී ජල අණුව ආලෝකය හමුවේ බිඳවැටීම හඳුන්වන්නේ කෙසේද?", "Splitting of water by light in photosynthesis?", listOf("ප්‍රකාශ විච්ඡේදනය", "Photolysis"), "ජලයේ ප්‍රකාශ විච්ඡේදනය (Photolysis) නමිනි.", "ආලෝකයෙන් ජලය බිඳීමයි.")
        5 -> Quintuple("ප්‍රභාසංස්ලේෂණයේදී පිටවන ඔක්සිජන් වායුවේ ප්‍රභවය කුමක්ද?", "Source of oxygen released in photosynthesis?", listOf("ජලය", "H2O", "Water"), "ජලය (H₂O) අණුව වේ.", "ජලය බිඳවැටීමෙන් ලැබේ.")
        6 -> Quintuple("ශාක පත්‍රවල වායු හුවමාරුව හා උත්ස්වේදනය සිදුවන ක්ෂුද්‍ර සිදුරු මොනවාද?", "Pores on leaves for gas exchange and transpiration?", listOf("පත්‍ර රන්ධ්‍ර", "ස්ටෝමාටා", "Stomata"), "පත්‍ර රන්ධ්‍ර (Stomata) වේ.", "පාලක සෛල මඟින් පාලනය වේ.")
        7 -> Quintuple("පත්‍ර රන්ධ්‍ර විවෘත වීම සහ වැසීම පාලනය කරන සෛල යුගලය කුමක්ද?", "Cell pair regulating opening of stomata?", listOf("පාලක සෛල", "Guard cells"), "පාලක සෛල (Guard cells) වේ.", "වකුගඩු හැඩැති සෛලයි.")
        else -> Quintuple("ප්‍රභාසංස්ලේෂණයේ ප්‍රධාන සංස්ලේෂිත ඵලය කුමක්ද?", "Primary synthesized product of photosynthesis?", listOf("ග්ලූකෝස්", "සීනි", "Glucose"), "ග්ලූකෝස් (C₆H₁₂O₆) වේ.", "සරල සීනි අණුවයි.")
      }

      // Set 2: සෛලීය ශ්වසනය & ATP
      2 -> when (qIndex) {
        1 -> Quintuple("සෛලීය ශ්වසනයේදී ශක්තිය ගබඩා වන රසායනික අණුව කුමක්ද?", "Energy currency molecule of cell?", listOf("ATP", "ඇඩිනොසින් ට්‍රයිපොස්පේට්"), "ATP (ඇඩිනොසින් ට්‍රයිපොස්පේට්) වේ.", "ශක්ති මුදලයි.")
        2 -> Quintuple("වායුගෝලීය ශ්වසනය ප්‍රධාන වශයෙන් සිදුවන සෛල ඉන්ද්‍රයිකාව කුමක්ද?", "Powerhouse organelle for aerobic respiration?", listOf("මයිටොකොන්ඩ්‍රියා", "මයිටොකොන්ඩ්‍රියම", "Mitochondria"), "මයිටොකොන්ඩ්‍රියම (Mitochondria) වේ.", "සෛලයේ බලාගාරයයි.")
        3 -> Quintuple("ශ්වසනයේ පළමු පියවර වන ග්ලයිකොලිසිය සිදුවන්නේ සෛලයේ කොහේද?", "Where does glycolysis occur in cell?", listOf("සෛල ප්ලාස්මය", "සයිටොසෝලය", "Cytoplasm"), "සෛල ප්ලාස්මය (Cytosol) තුළය.", "සෛල ද්‍රවයයි.")
        4 -> Quintuple("මාංශ පේශි දැඩිව වෙහෙස වන විට නිර්වායු ශ්වසනයෙන් සෑදෙන අම්ලය කුමක්ද?", "Acid formed by anaerobic respiration in tired muscles?", listOf("ලැක්ටික් අම්ලය", "Lactic acid"), "ලැක්ටික් අම්ලය (Lactic acid) වේ.", "කෙණ්ඩා පෙරළීමට හේතු වේ.")
        5 -> Quintuple("යීස්ට් සෛලවල නිර්වායු ශ්වසනය (පැසවීම) මඟින් නිපදවෙන මධ්‍යසාරය කුමක්ද?", "Alcohol produced by yeast fermentation?", listOf("එතනෝල්", "එතිල් මධ්‍යසාරය", "Ethanol"), "එතනෝල් (එතිල් මධ්‍යසාරය) වේ.", "මද්‍යසාරයයි.")
        else -> Quintuple("වායුගෝලීය ශ්වසනය සඳහා අත්‍යවශ්‍ය වන වායුව කුමක්ද?", "Gas essential for aerobic respiration?", listOf("ඔක්සිජන්", "O2"), "ඔක්සිජන් (O₂) වායුවයි.", "ශ්වසන වායුවයි.")
      }

      // Set 3: ප්‍රවේණිය & පාරම්පරික ලක්ෂණ
      3 -> when (qIndex) {
        1 -> Quintuple("ප්‍රවේණි විද්‍යාවේ පියා ලෙස සලකනු ලබන්නේ කවුද?", "Father of modern genetics?", listOf("මෙන්ඩල්", "ග්‍රෙගර් මෙන්ඩල්", "Gregor Mendel"), "ග්‍රෙගර් මෙන්ඩල් (Gregor Mendel) තුමාය.", "මෑ ඇට පැළ පරීක්ෂා කළේය.")
        2 -> Quintuple("මෙන්ඩල් සිය ප්‍රවේණි පරීක්ෂණ සඳහා තෝරාගත් ශාකය කුමක්ද?", "Plant chosen by Mendel for genetic experiments?", listOf("මෑ ශාකය", "ගෙවතු මෑ", "Pea plant"), "ගෙවතු මෑ ශාකය (Pisum sativum) වේ.", "මෑ පැළයයි.")
        3 -> Quintuple("DNA අණුවක නිශ්චිත ප්‍රෝටීනයක් තැනීමට තොරතුරු දරන ඛණ්ඩයක් හඳුන්වන්නේ කෙසේද?", "Segment of DNA coding for a specific protein?", listOf("ජානය", "ජාන", "Gene"), "ජානය (Gene) නමිනි.", "ප්‍රවේණියේ මූලික ඒකකයයි.")
        4 -> Quintuple("එකම ජානයක පවතින විකල්ප ආකාර හඳුන්වන්නේ කෙසේද?", "Alternative forms of a gene are called?", listOf("ඇලිල", "ඇලීල", "Alleles"), "ඇලිල (Alleles) නමිනි.", "යුගල ජානයි.")
        5 -> Quintuple("මිනිස් දේහ සෛලයක ඇති මුළු වර්ණදේහ සංඛ්‍යාව කීයද?", "Total number of chromosomes in human body cell?", listOf("46ක්", "46", "යුගල 23ක්"), "වර්ණදේහ 46කි (යුගල 23කි).", "යුගල 23කි.")
        6 -> Quintuple("මිනිස් ලිංගික සෛලයක (ශුක්‍රාණුවක හෝ ඩිම්බයක) ඇති වර්ණදේහ ගණන කීයද?", "Number of chromosomes in human gamete?", listOf("23ක්", "23"), "වර්ණදේහ 23කි (ඒකගුණ n).", "දේහ සෛලයෙන් අඩකි.")
        7 -> Quintuple("පිරිමියෙකු තීරණය කරන ලිංගික වර්ණදේහ යුගලය කුමක්ද?", "Sex chromosome pair of a male human?", listOf("XY", "X සහ Y"), "XY වර්ණදේහ යුගලයයි.", "Y වර්ණදේහය පිරිමි බව දක්වයි.")
        8 -> Quintuple("කාන්තාවකගේ ලිංගික වර්ණදේහ යුගලය කුමක්ද?", "Sex chromosome pair of a female human?", listOf("XX", "X සහ X"), "XX වර්ණදේහ යුගලයයි.", "සමලිංගික යුගලයයි.")
        else -> Quintuple("මෙන්ඩල්ගේ ඒක මුහුම් පරීක්ෂණයේ F2 පරම්පරාවේ ප්‍රමුඛ:නිලීන රූපකාර්ය අනුපාතය කුමක්ද?", "Mendel's monohybrid F2 phenotypic ratio?", listOf("3:1", "3 ට 1"), "3:1 (තුනට එක) අනුපාතය වේ.", "3ට 1යි.")
      }

      // Set 4: ධාරා විද්‍යුතය & ඕම් නියමය
      4 -> when (qIndex) {
        1 -> Quintuple("ඕම් නියමයට අදාළ මූලික සමීකරණය කුමක්ද?", "Formula for Ohm's Law?", listOf("V = IR", "V=IR", "V equals IR"), "V = IR වේ (විභව අන්තරය = ධාරාව x ප්‍රතිරෝධය).", "V = IR වේ.")
        2 -> Quintuple("විද්‍යුත් ධාරාව මැනීමට පරිපථයකට ශ්‍රේණිගතව සම්බන්ධ කරන උපකරණය කුමක්ද?", "Device connected in series to measure electric current?", listOf("ඇමීටරය", "Ammeter"), "ඇමීටරය (Ammeter) වේ.", "ධාරාව මනියි.")
        3 -> Quintuple("විභව අන්තරය මැනීමට පරිපථයකට සමාන්තරගතව සම්බන්ධ කරන උපකරණය කුමක්ද?", "Device connected in parallel to measure potential difference?", listOf("වෝල්ට්මීටරය", "Voltmeter"), "වෝල්ට්මීටරය (Voltmeter) වේ.", "වෝල්ටීයතාව මනියි.")
        4 -> Quintuple("ප්‍රතිරෝධක 2ක් ශ්‍රේණිගතව සම්බන්ධ කළ විට සමක ප්‍රතිරෝධය කුමක්ද?", "Equivalent resistance of two resistors in series?", listOf("R1 + R2", "එකතුව"), "ප්‍රතිරෝධයන්ගේ එකතුව වේ (R = R₁ + R₂).", "එකතු වේ.")
        else -> Quintuple("විදුලි සැර වැදීම වැළැක්වීමට නිවෙස්වල භාවිත කරන ආරක්ෂිත ස්විචය කුමක්ද?", "Residual current device protecting against electric shock?", listOf("RCCB", "RCD", "ට්‍රිප් ස්විචය"), "RCCB (Residual Current Circuit Breaker) හෙවත් ට්‍රිප් ස්විචයයි.", "ට්‍රිප් ස්විචයයි.")
      }

      // Set 5: රසායනික ගණනය & මවුල සංකල්පය
      5 -> when (qIndex) {
        1 -> Quintuple("ඕනෑම ද්‍රව්‍යයක මවුල එකක අඩංගු අංශු සංඛ්‍යාව හඳුන්වන නම කුමක්ද?", "Constant representing number of particles in 1 mole?", listOf("ඇවගාඩ්රෝ නියතය", "Avogadro"), "ඇවගාඩ්රෝ නියතය (L හෝ N_A) වේ.", "6.022 x 10^23.")
        2 -> Quintuple("ඇවගාඩ්රෝ නියතයේ ආසන්න අගය කුමක්ද?", "Approximate value of Avogadro's constant?", listOf("6.022 x 10^23", "6.023", "10^23"), "6.022 × 10²³ mol⁻¹ වේ.", "දහයේ 23 බලයයි.")
        3 -> Quintuple("ජල අණුවක (H2O) මවුලික ස්කන්ධය ග්‍රෑම් කීයද?", "Molar mass of water (H2O) in grams?", listOf("18", "18 g/mol", "18g"), "18 g mol⁻¹ වේ (H=1, O=16).", "18 ග්‍රෑම් වේ.")
        else -> Quintuple("ද්‍රාවණයක සාන්ද්‍රණය මනින සම්මත ඒකකය කුමක්ද?", "Standard unit for molar concentration?", listOf("mol dm-3", "මවුල ඝන ඩෙසිමීටරයට"), "mol dm⁻³ (මවුල ඝන ඩෙසිමීටරයට) වේ.", "මවුලිකතාවයි.")
      }

      // Set 6: විද්‍යුත් චුම්භක ප්‍රේරණය & ජනක යන්ත්‍ර
      6 -> when (qIndex) {
        1 -> Quintuple("විද්‍යුත් චුම්භක ප්‍රේරණ සංසිද්ධිය සොයාගත් විද්‍යාඥයා කවුද?", "Scientist who discovered electromagnetic induction?", listOf("ෆැරඩේ", "මයිකල් ෆැරඩේ", "Michael Faraday"), "මයිකල් ෆැරඩේ (Michael Faraday) තුමාය.", "ඩයිනමෝවේ නිර්මාතෘය.")
        2 -> Quintuple("යාන්ත්‍රික ශක්තිය විද්‍යුත් ශක්තිය බවට පත්කරන උපකරණය කුමක්ද?", "Device converting mechanical energy into electrical energy?", listOf("ජනකය", "ඩයිනමෝව", "Generator"), "විදුලි ජනකය (Generator) හෙවත් ඩයිනමෝව වේ.", "විදුලිය නිපදවයි.")
        else -> Quintuple("ප්‍රත්‍යාවර්ත වෝල්ටීයතාවක් වැඩි කිරීමට හෝ අඩු කිරීමට භාවිත කරන උපකරණය කුමක්ද?", "Device used to step up or step down AC voltage?", listOf("ට්‍රාන්ස්ෆෝමරය", "පරිණාමකය", "Transformer"), "ට්‍රාන්ස්ෆෝමරය (පරිණාමකය) වේ.", "AC සඳහා පමණි.")
      }

      // Set 7: අන්තරාසර්ග පද්ධතිය & හෝමෝන
      7 -> when (qIndex) {
        1 -> Quintuple("මිනිස් සිරුරේ ප්‍රධාන අන්තරාසර්ග ග්‍රන්ථිය හෙවත් අධිපති ග්‍රන්ථිය කුමක්ද?", "Master endocrine gland of human body?", listOf("පිටියුටරිය", "පිටියුටරි ග්‍රන්ථිය", "Pituitary"), "පිටියුටරි ග්‍රන්ථිය (Pituitary gland) වේ.", "මොළය පාමුල පිහිටයි.")
        2 -> Quintuple("රුධිරයේ ග්ලූකෝස් මට්ටම වැඩි වූ විට එය අඩු කරන හෝමෝනය කුමක්ද?", "Hormone lowering elevated blood glucose?", listOf("ඉන්සියුලින්", "Insulin"), "ඉන්සියුලින් (Insulin) හෝමෝනයයි.", "අග්න්‍යාශයෙන් ශ්‍රාවය වේ.")
        3 -> Quintuple("රුධිරයේ ග්ලූකෝස් මට්ටම අඩු වූ විට එය නැවත නංවන හෝමෝනය කුමක්ද?", "Hormone raising low blood glucose?", listOf("ග්ලූකගන්", "Glucagon"), "ග්ලූකගන් (Glucagon) හෝමෝනයයි.", "ග්ලයිකොජන් ග්ලූකෝස් කරයි.")
        else -> Quintuple("හදිසි අවස්ථාවකදී 'සටන් හෝ පලායන' ප්‍රතිචාරය ඇතිකරන හෝමෝනය කුමක්ද?", "Fight-or-flight hormone in emergency?", listOf("ඇඩ්‍රිනලින්", "Adrenaline"), "ඇඩ්‍රිනලින් (Adrenaline) හෝමෝනයයි.", "අධිවෘක්ක ග්‍රන්ථියෙන් ශ්‍රාවය වේ.")
      }

      // Set 8: තාපය & විශිෂ්ට තාප ධාරිතාව
      8 -> when (qIndex) {
        1 -> Quintuple("තාපය හුවමාරු වන මූලික ක්‍රම 3 මොනවාද?", "Three modes of heat transfer?", listOf("සන්නයනය", "සංවහනය", "විකිරණය"), "සන්නයනය, සංවහනය සහ විකිරණය වේ.", "ක්‍රම 3කි.")
        2 -> Quintuple("ඝන ද්‍රව්‍ය ඔස්සේ තාපය ගමන් කරන ප්‍රධාන ක්‍රමය කුමක්ද?", "Main method of heat transfer through solids?", listOf("සන්නයනය", "තාප සන්නයනය", "Conduction"), "තාප සන්නයනය (Conduction) වේ.", "අංශු කම්පනයෙනි.")
        3 -> Quintuple("ද්‍රව සහ වායු (ද්‍රවශීලී) ඔස්සේ තාපය ගමන් කරන්නේ කුමන ක්‍රමයෙන්ද?", "Heat transfer through fluids (liquids and gases)?", listOf("සංවහනය", "Convection"), "තාප සංවහනය (Convection) මඟිනි.", "සංවහන ධාරා මඟිනි.")
        else -> Quintuple("රික්තකයක් හරහා සූර්ය තාපය පෘථිවියට ළඟාවන ක්‍රමය කුමක්ද?", "How does solar heat reach Earth across vacuum?", listOf("විකිරණය", "තාප විකිරණය", "Radiation"), "තාප විකිරණය (Radiation) මඟිනි.", "විද්‍යුත් චුම්භක තරංගයකි.")
      }

      // Set 9: ඉලෙක්ට්‍රෝන විද්‍යාව (p-n සන්ධි ඩයෝඩය, LED, ට්‍රාන්සිස්ටරය)
      9 -> when (qIndex) {
        1 -> Quintuple("විද්‍යුත් ධාරාව එක් දිශාවකට පමණක් ගමන් කිරීමට ඉඩ දෙන අර්ධ සන්නායක උපාංගය කුමක්ද?", "Semiconductor device allowing current in only one direction?", listOf("ඩයෝඩය", "p-n සන්ධි ඩයෝඩය", "Diode"), "p-n සන්ධි ඩයෝඩය (Diode) වේ.", "එක් දිශාවකට ධාරාව යවයි.")
        2 -> Quintuple("ඉදිරි නැඹුරු කළ විට ආලෝකය නිකුත් කරන ඩයෝඩ වර්ගය කුමක්ද?", "Diode that emits light when forward biased?", listOf("LED", "ආලෝක විමෝචක ඩයෝඩය"), "LED (ආලෝක විමෝචක ඩයෝඩය) වේ.", "ආලෝකය දෙන ඩයෝඩයයි.")
        3 -> Quintuple("ප්‍රත්‍යාවර්ත ධාරාවක් (AC) සරල ධාරාවක් (DC) බවට හැරවීම හඳුන්වන්නේ කෙසේද?", "Converting AC to DC is called?", listOf("සෘජුකරණය", "Rectification"), "සෘජුකරණය (Rectification) නමිනි.", "ඩයෝඩ මඟින් සිදුකරයි.")
        else -> Quintuple("වර්ධකයක් හෝ ස්විචයක් ලෙස භාවිත කරන අග්‍ර 3ක් සහිත ඉලෙක්ට්‍රොනික උපාංගය කුමක්ද?", "3-terminal electronic device used as amplifier or switch?", listOf("ට්‍රාන්සිස්ටරය", "Transistor"), "ට්‍රාන්සිස්ටරය (Transistor) වේ.", "පාදම, එකතුකය, විමෝචකය ඇත.")
      }

      // Set 10: ලෝහ විද්‍යාව & විඛාදනය
      else -> when (qIndex) {
        1 -> Quintuple("යකඩ මලබැඳීම සඳහා අත්‍යවශ්‍ය සාධක දෙක මොනවාද?", "Two essential conditions for rusting of iron?", listOf("ජලය සහ ඔක්සිජන්", "තෙතමනය සහ වාතය"), "ජලය (තෙතමනය) සහ ඔක්සිජන් (වාතය) වේ.", "ජලය හා ඔක්සිජන්ය.")
        2 -> Quintuple("යකඩ මලකඩවල රසායනික සූත්‍රය කුමක්ද?", "Chemical formula of rust?", listOf("Fe2O3", "ජලීය ෆෙරික් ඔක්සයිඩ්"), "ජලීය ෆෙරික් ඔක්සයිඩ් (Fe₂O₃·xH₂O) වේ.", "යකඩ ඔක්සයිඩ්ය.")
        3 -> Quintuple("යකඩ මත සින්ක් (Zn) ලෝහ ආලේප කිරීම හඳුන්වන නම කුමක්ද?", "Coating iron with Zinc is called?", listOf("ගැල්වනයිස් කිරීම", "Galvanizing"), "ගැල්වනයිස් කිරීම (Galvanizing) නමිනි.", "සින්ක් ආලේපයයි.")
        else -> Quintuple("විඛාදනය වැළැක්වීම සඳහා වඩා ක්‍රියාකාරී ලෝහයක් සම්බන්ධ කිරීම හඳුන්වන්නේ කෙසේද?", "Sacrificial protection using more reactive metal?", listOf("කැතෝඩික ආරක්ෂණය", "කැපකිරීමේ ඇනෝඩය"), "කැතෝඩික ආරක්ෂණය (කැපකිරීමේ ආරක්ෂණය) නමිනි.", "නැව් පතුල් ආරක්ෂා කරයි.")
      }
    }
  }
}

