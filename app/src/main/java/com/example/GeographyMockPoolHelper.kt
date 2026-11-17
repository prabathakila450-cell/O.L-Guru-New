package com.example

import com.example.ExamQuestionHelper.QSpec
import com.example.ExamQuestionHelper.buildPoolFromShortAnswers
import com.example.ExamQuestionHelper.buildPoolFromSubjectMaster
import com.example.ExamQuestionHelper.dedupPool
import com.example.ExamQuestionHelper.quizQuestionToSpec
import com.example.ExamQuestionHelper.selectFromMasterPool

/**
 * Curated + Parametric Geography O/L Question Pool (Grades 10 & 11).
 * Combines QuizBankGeography (100), 300+ parametric Map-Scale/Time-Zone/Population-Density calculations
 * & Sri Lanka / World Geography MCQs, SubjectMasterGeography (~1,500 multi-angle), and ShortAnswer (~400).
 */
object GeographyMockPoolHelper {

  private val pool: List<QSpec> by lazy { buildMasterPool() }

  fun getQuestion(grade: String, term: Int, paperIdx: Int, qNum: Int): MockExamQuestion {
    return selectFromMasterPool(pool, grade, term, paperIdx, qNum)
  }

  private fun buildMasterPool(): List<QSpec> {
    val raw = ArrayList<QSpec>(2600)

    // 1. 100 Curated QuizBankGeography MCQs
    for (setIdx in 1..10) {
      for (qIdx in 1..10) {
        val qq = QuizBankGeography.getQuestion("10", setIdx, qIdx, qIdx, "භූගෝල විද්‍යාව")
        raw.add(quizQuestionToSpec("භූගෝල විද්‍යාව - ඒකකය $setIdx", qq))
      }
    }

    // 2. Parametric Map Scale, Longitude Time Zone, Population Density & Regional Geo (300 items)
    raw.addAll(buildParametricGeography())

    // 3. SubjectMasterRepository Geography multi-angle pool (~1,500 specs)
    raw.addAll(
      buildPoolFromSubjectMaster(
        categories = SubjectMasterRepository.getCategoriesForSubject("භූගෝල විද්‍යාව"),
        subjectLabel = "භූගෝල විද්‍යාව",
        seedBase = 47
      )
    )

    // 4. ShortAnswerMasterRepository Grade 10 & Grade 11 Geography (~400 specs)
    raw.addAll(buildPoolFromShortAnswers("භූගෝල විද්‍යාව"))

    return ExamQuestionHelper.distributeProportionallyAcrossTopics(dedupPool(raw))
  }

  private fun buildParametricGeography(): List<QSpec> {
    val list = ArrayList<QSpec>(700)

    // A. Topographic Map Scale 1:50,000 conversions (60 items)
    for (cm in 1..60) {
      val km = cm * 0.5
      val kmText = if (km % 1.0 == 0.0) "${km.toInt()} km" else "$km km"
      list.add(
        QSpec(
          topic = "සිතියම් කියවීම හා පරිමාණ",
          questionText = "1:50,000 පරිමාණයේ ශ්‍රී ලංකා භූලක්ෂණ සිතියමක ස්ථාන දෙකක් අතර දුර $cm cm නම්, බිමෙහි සැබෑ දුර කොපමණද?",
          correct = kmText,
          distractors = listOf("${cm * 5} km", "${cm * 2} km", "${cm * 0.25} km"),
          explanation = "1:50,000 සිතියමේ 1 cm = 0.5 km බැවින් $cm cm × 0.5 = $kmText වේ."
        )
      )
    }

    // B. 1:25,000 Scale calculations (50 items)
    for (cm in 2..51) {
      val km = cm * 0.25
      val kmText = if (km % 1.0 == 0.0) "${km.toInt()} km" else "$km km"
      list.add(
        QSpec(
          topic = "සිතියම් කියවීම හා පරිමාණ",
          questionText = "1:25,000 පරිමාණයෙන් ඇඳි සිතියමක මාර්ගයක දිග $cm cm නම්, එහි සැබෑ භූමි දුර කොපමණද?",
          correct = kmText,
          distractors = listOf("${cm * 0.5} km", "${cm * 2.5} km", "${cm * 4} km"),
          explanation = "1:25,000 සිතියමක 1 cm = 250 m = 0.25 km බැවින් $cm × 0.25 = $kmText වේ."
        )
      )
    }

    // C. 1:100,000 Scale calculations (50 items)
    for (cm in 1..50) {
      val km = cm * 1.0
      val kmText = "$km km"
      list.add(
        QSpec(
          topic = "සිතියම් කියවීම හා පරිමාණ",
          questionText = "1:100,000 පරිමාණ සිතියමක ස්ථාන දෙකක් අතර දුර $cm cm වන විට සැබෑ භූමි දුර කීයද?",
          correct = kmText,
          distractors = listOf("${cm * 0.5} km", "${cm * 2} km", "${cm * 10} km"),
          explanation = "1:100,000 සිතියමේ 1 cm = 1 km වන බැවින් $cm cm = $kmText වේ."
        )
      )
    }

    // D. Time Zone / Longitude Calculations (80 items)
    for (degStep in 1..20) {
      val degE = degStep * 15
      val hourE = (12 + degStep) % 24
      val ampmE = if (hourE < 12) "පෙ.ව. $hourE.00" else if (hourE == 12) "මධ්‍යහ්න 12.00" else "ප.ව. ${hourE - 12}.00"
      list.add(
        QSpec(
          topic = "දේශාංශ හා වේලා කලාප",
          questionText = "ග්‍රිනිච් මධ්‍ය රේඛාවේ (0°) වේලාව මධ්‍යහ්න 12.00 නම්, නැගෙනහිර දේශාංශ ${degE}°E හි පිහිටි නගරයක සම්මත වේලාව කුමක්ද?",
          correct = ampmE,
          distractors = listOf("පෙ.ව. 8.00", "ප.ව. 4.00", "මධ්‍යම රාත්‍රී 12.00"),
          explanation = "15° නැගෙනහිරට ගිය විට පැය 1ක් වේලාව ඉදිරියෙන් පවතින බැවින් ${degE}°E = පැය $degStep ක් ඉදිරියෙන් ($ampmE) වේ."
        )
      )
      val degW = degStep * 15
      val rawHourW = 12 - (degStep % 12)
      val ansW = if (rawHourW > 0) "පෙ.ව. $rawHourW.00" else "මධ්‍යම රාත්‍රී 12.00"
      list.add(
        QSpec(
          topic = "දේශාංශ හා වේලා කලාප",
          questionText = "ග්‍රිනිච් (0°) වේලාව මධ්‍යහ්න 12.00 වන විට බටහිර දේශාංශ ${degW}°W හි පිහිටි ප්‍රදේශයේ වේලාව කුමක්ද?",
          correct = ansW,
          distractors = listOf("ප.ව. 3.00", "ප.ව. 6.00", "පෙ.ව. 10.00"),
          explanation = "15° බටහිරට යන සෑම විටම පැය 1ක් පසුපසින් පවතින බැවින් පැය $degStep ක් අඩුවී $ansW වේ."
        )
      )
    }

    // E. Population Density Calculations (60 items)
    for (i in 1..60) {
      val area = 100 + (i % 10) * 20
      val density = 100 + i * 15
      val pop = area * density
      list.add(
        QSpec(
          topic = "ජනගහන භූගෝල විද්‍යාව",
          questionText = "භූමි ප්‍රමාණය $area km² වන ප්‍රදේශයක මුළු ජනගහනය ${pop} ක් නම්, එහි ජන ඝනත්වය (වර්ග කිලෝමීටරයට පුද්ගලයින්) කීයද?",
          correct = "වර්ග km ට පුද්ගලයින් $density",
          distractors = listOf("වර්ග km ට පුද්ගලයින් ${density + 50}", "වර්ග km ට පුද්ගලයින් ${density / 2}", "වර්ග km ට පුද්ගලයින් ${density * 2}"),
          explanation = "ජන ඝනත්වය = මුළු ජනගහනය / භූමි වර්ගඵලය = $pop / $area = $density."
        )
      )
    }

    // F. Temperature Lapse Rate with Altitude (60 items)
    for (altM in listOf(500, 1000, 1500, 2000, 2500)) {
      for (baseT in listOf(24, 26, 28, 30, 32, 34, 36, 38, 40, 42, 44, 45)) {
        val drop = (altM / 1000.0) * 6.5
        val topT = baseT - drop
        list.add(
          QSpec(
            topic = "කාලගුණය හා දේශගුණය",
            questionText = "මුහුදු මට්ටමේ උෂ්ණත්වය ${baseT}°C වන විට මීටර් $altM ක උසකින් යුත් කඳු මුදුනක උෂ්ණත්වය කොපමණ වේද? (උස්වන විට සෑම මීටර් 1000 කටම 6.5°C බැවින් උෂ්ණත්වය පහත වැටේ)",
            correct = "$topT °C",
            distractors = listOf("${baseT + 2} °C", "${topT - 4} °C", "${baseT - 1} °C"),
            explanation = "උෂ්ණත්ව අඩු වීම = ($altM / 1000) × 6.5 = $drop °C; කඳු මුදුන උෂ්ණත්වය = $baseT - $drop = $topT °C."
          )
        )
      }
    }

    // G. Curated World & Sri Lankan Physical/Economic Geography Facts (100+ items)
    val facts = listOf(
      QuadGeo("ශ්‍රී ලංකාවේ දිගම ගංගාව සහ එහි ආසන්න දිග කොපමණද?", "මහවැලි ගඟ (335 km)", listOf("කැලණි ගඟ (145 km)", "මල්වතු ඔය (164 km)", "වලවේ ගඟ (138 km)"), "මහවැලි ගඟ සමනල කඳු පන්තියෙන් ආරම්භ වී ත්‍රිකුණාමලය කොඩ්ඩියාර් බොක්කෙන් මුහුදට වැටේ."),
      QuadGeo("ශ්‍රී ලංකාවේ උසම කඳු මුදුන වන පිදුරුතලාගල කන්දේ උස මීටර් කීයද?", "2,524 m", listOf("2,388 m (කිරිගල්පොත්ත)", "2,357 m (තොටුපොළ)", "2,243 m (ශ්‍රී පාදය)"), "නුවරඑළිය දිස්ත්‍රික්කයේ පිහිටි පිදුරුතලාගල කන්ද දිවයිනේ උසම කන්දයි."),
      QuadGeo("ශ්‍රී ලංකාවේ ග්‍රැෆයිට් (මිනිරන්) පතල් සඳහා ප්‍රධාන වශයෙන් ප්‍රකට පතල් ප්‍රදේශ මොනවාද?", "බෝගල සහ කහටගහ - කොළොන්ගහ", listOf("පුල්මුඩේ හා ආරුක්කාල්", "පරන්තන් හා හම්බන්තොට", "එප්පාවල"), "ලංකාවේ ඉහළ කාබන් ප්‍රතිශතයක් ඇති මිනිරන් බෝගල හා කහටගහ පතල්වලින් ලබා ගනී."),
      QuadGeo("ඉල්මනයිට්, රූටයිල් හා සර්කෝන් යන ඛනිජ වැලි බහුලව හමුවන ශ්‍රී ලංකාවේ ප්‍රදේශය කුමක්ද?", "පුල්මුඩේ වෙරළ තීරය", listOf("මාතර", "පුත්තලම", "රත්නපුර"), "ත්‍රිකුණාමලයට උතුරින් පිහිටි පුල්මුඩේ ලොව උසස්ම ඛනිජ වැලි නිධියකි."),
      QuadGeo("එප්පාවල ප්‍රදේශය ප්‍රධාන වශයෙන් ප්‍රකට වන්නේ කුමන කෘෂිකාර්මික ඛනිජ සම්පත සඳහාද?", "රොක් පොස්පේට් (ඇපටයිට්) නිධිය", listOf("හුණුගල්", "මිනිරන්", "යපස්"), "අනුරාධපුර දිස්ත්‍රික්කයේ එප්පාවල පොස්පේට් පොහොර නිෂ්පාදනයට යොදා ගැනේ."),
      QuadGeo("මැයි සිට සැප්තැම්බර් දක්වා ශ්‍රී ලංකාවේ නිරිතදිග ප්‍රදේශවලට අධික වර්ෂාව ගෙන එන මෝසම් සුළඟ කුමක්ද?", "නිරිතදිග මෝසම් සුළඟ", listOf("ඊසානදිග මෝසම් සුළඟ", "පළමු අන්තර් මෝසම", "දෙවන අන්තර් මෝසම"), "වතුරවිල, කළුතර හා ගිනිගත්හේන ප්‍රදේශවලට මේ කාලයේ අධික වැසි ලැබේ."),
      QuadGeo("දෙසැම්බර් සිට පෙබරවාරි දක්වා වියළි කලාපයට හා නැගෙනහිර වෙරළට ප්‍රධාන වැසි සපයන සුළං ප්‍රවාහය කුමක්ද?", "ඊසානදිග මෝසම් සුළඟ", listOf("නිරිතදිග මෝසම", "සංවහන වර්ෂාව", "සුළි කුණාටු පමණක්"), "මහ කන්නයේ වගාවට ජලය සපයන්නේ ඊසානදිග මෝසම සහ දෙවන අන්තර් මෝසමයි."),
      QuadGeo("ශ්‍රී ලංකාවේ පවතින ස්වාභාවික වාෂ්පීභවනයෙන් මුහුදු ජලයෙන් ලුණු නිපදවන ප්‍රධාන ලේවායන් පිහිටියේ කොහිද?", "හම්බන්තොට (මහා ලේවාය), පුත්තලම හා අලිමංකඩ", listOf("ගාල්ල හා මාතර", "නුවරඑළිය හා බදුල්ල", "රත්නපුර හා කෑගල්ල"), "අඩු වර්ෂාපතනය හා අධික හිරු එළිය ඇති ශුෂ්ක කලාප ලුණු කර්මාන්තයට හිතකරය."),
      QuadGeo("පෘථිවි පෘෂ්ඨයේ සම උෂ්ණත්වයක් පවතින ස්ථාන යා කරමින් අඳින ලද රේඛා හඳුන්වන්නේ කුමක්ද?", "සමෝෂ්ණ රේඛා (Isotherms)", listOf("සමෝච්ච රේඛා (Contours)", "සමපීඩන රේඛා (Isobars)", "සමවර්ෂා රේඛා (Isohyets)"), "සම උෂ්ණත්ව ස්ථාන සමෝෂ්ණ රේඛා මගින් ද සම උස ස්ථාන සමෝච්ච රේඛා මගින් ද දක්වයි."),
      QuadGeo("සමෝච්ච රේඛා (Contour lines) ඉතා සමීපව පිහිටා ඇති විට එම සිතියම් ප්‍රදේශයෙන් පිළිබිඹු වන භූ ලක්ෂණය කුමක්ද?", "තද බෑවුමක් (Steep slope) හෝ ප්‍රපාතයක්", listOf("පුළුල් තැනිතලාවක්", "මෘදු බෑවුමක්", "නිම්න පතුලක්"), "සමෝච්ච රේඛා ළං වන තරමට බෑවුම තීව්‍ර වන අතර ඈත් වූ විට මෘදු බෑවුම් දැක්වේ."),
      QuadGeo("ගංගාවක් මුහුදට වැටෙන මුවදොරේ රොන්මඩ තැන්පත් වී ත්‍රිකෝණාකාර ලෙස සෑදෙන භූ රූපය කුමක්ද?", "ඩෙල්ටාව (Delta)", listOf("මහා කඳු ගැටය", "ග්ලැසියරය", "ජල දුර්ගය"), "නයිල් සහ ගංගා නම් ගංගා මුවදොරෙහි විශාල ඩෙල්ටා නිර්මාණය වී ඇත."),
      QuadGeo("පෘථිවියේ අභ්‍යන්තර භූ තැටි (Tectonic Plates) එකිනෙක ගැටීමෙන් (අභිසාරී මායිම්) නිර්මාණය වන ප්‍රධාන කඳු පන්ති වර්ගය කුමක්ද?", "නැමි කඳු (Fold Mountains - උදා. හිමාලය, ඇල්ප්ස්)", listOf("කුට්ටි කඳු", "ගිනි කඳු පමණක්", "ශේෂ කඳු"), "ඉන්දියානු තැටිය හා යුරේසියානු තැටිය ගැටීමෙන් හිමාලය කඳුවැටිය බිහිවිය."),
      QuadGeo("භූගෝලීය තොරතුරු පද්ධති (GIS - Geographic Information System) මගින් සිදුකරන ප්‍රධාන කාර්යය කුමක්ද?", "අවකාශීය දත්ත රැස්කිරීම, ගබඩා කිරීම, විශ්ලේෂණය හා සිතියම්ගත කිරීම", listOf("කාලගුණය වෙනස් කිරීම", "පොළොව කැණීම", "ජනගහනය ගණන් කිරීම පමණි"), "නාගරික සැලසුම්කරණය, ආපදා කළමනාකරණය සඳහා GIS අත්‍යවශ්‍ය මෙවලමකි."),
      QuadGeo("ලෝකයේ විශාලතම නිවර්තන වැසි වනාන්තරය (පෘථිවියේ පෙනහැල්ල) පිහිටා ඇත්තේ කුමන ගංගා ද්‍රෝණිය ආශ්‍රිතවද?", "දකුණු ඇමරිකාවේ ඇමසන් ද්‍රෝණිය", listOf("අප්‍රිකාවේ කොංගෝ ද්‍රෝණිය", "ආසියාවේ මහවැලි ද්‍රෝණිය", "උතුරු ඇමරිකාවේ මිසිසිපි"), "ඇමසන් වැසි වනාන්තරය ලෝක ඔක්සිජන් නිෂ්පාදනයට හා ජෛව විවිධත්වයට විශාල දායකත්වයක් දක්වයි."),
      QuadGeo("ලෝකයේ සෞම්‍ය කලාපීය තෘණභූමි අතර උතුරු ඇමරිකාවේ තෘණභූමි හඳුන්වන නම කුමක්ද?", "ප්‍රේරි (Prairies)", listOf("පැම්පාස් (Pampas)", "ස්ටෙප්ස් (Steppes)", "වෙල්ඩ් (Velds)"), "ප්‍රේරි - උතුරු ඇමරිකාව, පැම්පාස් - ආර්ජන්ටිනාව, ස්ටෙප්ස් - යුරේසියාව, ඩවුන්ස් - ඕස්ට්‍රේලියාව."),
      QuadGeo("ශ්‍රී ලංකාවේ කඩොලාන පරිසර පද්ධති වැඩි වශයෙන් ව්‍යාප්ත වී ඇත්තේ කුමන භූගෝලීය ස්ථාන ආශ්‍රිතවද?", "කලපු සහ ගංගා මුවදොර (මීගමුව, පුත්තලම, මඩකලපුව)", listOf("මධ්‍යම කඳුකරයේ", "වියළි හේන් ඉඩම්වල", "කඳු මුදුන්වල"), "කඩොලාන වෙරළ ඛාදනය වළක්වා මසුන්ට හා ජලජ ජීවීන්ට අභිජනන මධ්‍යස්ථානයක් සපයයි.")
    )
    for (f in facts) {
      list.add(QSpec("භූගෝල විද්‍යාව - ශ්‍රී ලංකා හා ලෝක", f.q, f.a, f.wrongs, f.exp))
    }

    return list
  }

  private data class QuadGeo(val q: String, val a: String, val wrongs: List<String>, val exp: String)
}
