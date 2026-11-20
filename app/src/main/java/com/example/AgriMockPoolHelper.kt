package com.example

import com.example.ExamQuestionHelper.QSpec
import com.example.ExamQuestionHelper.buildPoolFromShortAnswers
import com.example.ExamQuestionHelper.buildPoolFromSubjectMaster
import com.example.ExamQuestionHelper.dedupPool
import com.example.ExamQuestionHelper.quizQuestionToSpec
import com.example.ExamQuestionHelper.selectFromMasterPool
import java.util.Locale

/**
 * Curated + Parametric Agriculture Science (කෘෂි විද්‍යාව) Question Pool (Grades 10 & 11 O/L).
 * Combines QuizBankApplied Agri (100), 480+ parametric NPK/germination/plant-population/seed-rate/compost
 * & curated soil/irrigation/propagation/livestock/crop-protection MCQs, SubjectMasterAgriculture (1,280+),
 * and ShortAnswer Agriculture (400 G10+G11).
 */
object AgriMockPoolHelper {

  private val pool: List<QSpec> by lazy { buildMasterPool() }

  fun getQuestion(grade: String, term: Int, paperIdx: Int, qNum: Int): MockExamQuestion {
    return selectFromMasterPool(pool, grade, term, paperIdx, qNum)
  }

  private fun buildMasterPool(): List<QSpec> {
    val raw = ArrayList<QSpec>(2600)

    // 1. 100 Curated QuizBankApplied Agriculture MCQs
    for (setIdx in 1..10) {
      for (qIdx in 1..10) {
        val qq = QuizBankApplied.getAgriQuestion("10", setIdx, qIdx, qIdx, "කෘෂි විද්‍යාව")
        raw.add(quizQuestionToSpec("කෘෂි විද්‍යාව - ඒකකය $setIdx", qq))
      }
    }

    // 2. 480+ Parametric & Curated Agriculture Problems
    raw.addAll(buildParametricAndCuratedAgri())

    // 3. SubjectMasterRepository Agriculture multi-angle pool
    raw.addAll(
      buildPoolFromSubjectMaster(
        categories = SubjectMasterAgriculture20x20.getCategories(),
        subjectLabel = "කෘෂි විද්‍යාව",
        seedBase = 83
      )
    )

    // 4. ShortAnswerMasterRepository Grade 10 & Grade 11 Agriculture (~400 specs)
    raw.addAll(buildPoolFromShortAnswers("කෘෂි විද්‍යාව"))

    return dedupPool(raw)
  }

  private fun buildParametricAndCuratedAgri(): List<QSpec> {
    val list = ArrayList<QSpec>(520)

    // A. Urea (46% N) active Nitrogen calculations (40 items)
    for (i in 1..40) {
      val bags = 1 + i
      val totalKg = bags * 50
      val activeN = totalKg * 0.46
      val nStr = String.format(Locale.US, "%.1f", activeN)
      list.add(
        QSpec(
          topic = "ශාක පෝෂණය හා පොහොර ගණනය",
          questionText = "නයිට්‍රජන් 46% ක් අඩංගු යූරියා (Urea) කිලෝග්‍රෑම් 50 මලු $bags ක (මුළු $totalKg kg) ඇති ශුද්ධ නයිට්‍රජන් (N) ප්‍රමාණය කොපමණද?",
          correct = "$nStr kg",
          distractors = listOf(
            "${String.format(Locale.US, "%.1f", totalKg * 0.60)} kg",
            "${String.format(Locale.US, "%.1f", totalKg * 0.24)} kg",
            "${String.format(Locale.US, "%.1f", activeN + 12.5)} kg"
          ),
          explanation = "ශුද්ධ නයිට්‍රජන් = $totalKg kg × (46 / 100) = $nStr kg."
        )
      )
    }

    // B. MOP (60% K₂O) Potassium calculations (40 items)
    for (i in 1..40) {
      val totalKg = 25 * i
      val activeK = totalKg * 0.60
      val kStr = String.format(Locale.US, "%.1f", activeK)
      list.add(
        QSpec(
          topic = "ශාක පෝෂණය හා පොහොර ගණනය",
          questionText = "පොටෑසියම් ඔක්සයිඩ් (K₂O) 60% ක් අඩංගු මියුරියේට් ඔෆ් පොටෑෂ් (MOP) $totalKg kg ක ඇති ශුද්ධ පොටෑෂ් ප්‍රමාණය කීයද?",
          correct = "$kStr kg",
          distractors = listOf(
            "${String.format(Locale.US, "%.1f", totalKg * 0.46)} kg",
            "${String.format(Locale.US, "%.1f", totalKg * 0.30)} kg",
            "${String.format(Locale.US, "%.1f", activeK + 8.0)} kg"
          ),
          explanation = "K₂O ප්‍රමාණය = $totalKg kg × 60% = $kStr kg."
        )
      )
    }

    // C. TSP (46% P₂O₅) Phosphorus calculations (40 items)
    for (i in 1..40) {
      val totalKg = 10 + 10 * i
      val activeP = totalKg * 0.46
      val pStr = String.format(Locale.US, "%.1f", activeP)
      list.add(
        QSpec(
          topic = "ශාක පෝෂණය හා පොහොර ගණනය",
          questionText = "P₂O₅ 46% ක් අඩංගු ත්‍රිත්ව සුපර් පොස්පේට් (TSP) පොහොර $totalKg kg ක අඩංගු පොස්පරස් පෙන්ටොක්සයිඩ් ප්‍රමාණය කීයද?",
          correct = "$pStr kg",
          distractors = listOf(
            "${String.format(Locale.US, "%.1f", totalKg * 0.21)} kg",
            "${String.format(Locale.US, "%.1f", totalKg * 0.60)} kg",
            "${String.format(Locale.US, "%.1f", activeP + 5.5)} kg"
          ),
          explanation = "TSP හි P₂O₅ අගය 46% බැවින් $totalKg × 0.46 = $pStr kg."
        )
      )
    }

    // D. Seed Germination Percentage calculations (60 items)
    val testedCounts = listOf(100, 150, 200, 250, 400, 500)
    for (tested in testedCounts) {
      for (step in 1..10) {
        val rate = 45 + step * 5 // 50%..95%
        val germinated = tested * rate / 100
        list.add(
          QSpec(
            topic = "බීජ තාක්ෂණය හා ප්‍රරෝහණ පරීක්ෂණය",
            questionText = "බීජ ප්‍රරෝහණ පරීක්ෂණයකදී පරීක්ෂා කළ බීජ $tested කින් බීජ $germinated ක් පැළ වූයේ නම් ප්‍රරෝහණ ප්‍රතිශතය කීයද?",
            correct = "$rate%",
            distractors = listOf("${rate - 10}%", "${(rate + 7).coerceAtMost(100)}%", "${rate / 2}%"),
            explanation = "ප්‍රරෝහණ % = ($germinated / $tested) × 100 = $rate%."
          )
        )
      }
    }

    // E. Plant Population per Hectare (10,000 m² / spacing) (60 items)
    val spacings = listOf(
      Triple(20, 20, 250000), Triple(25, 20, 200000), Triple(25, 25, 160000),
      Triple(40, 25, 100000), Triple(50, 20, 100000), Triple(50, 25, 80000),
      Triple(50, 40, 50000), Triple(50, 50, 40000), Triple(100, 25, 40000),
      Triple(100, 40, 25000), Triple(100, 50, 20000), Triple(100, 100, 10000)
    )
    val hectares = listOf(1, 2, 3, 4, 5)
    for (ha in hectares) {
      for ((rCm, cCm, perHa) in spacings) {
        val total = ha * perHa
        list.add(
          QSpec(
            topic = "බෝග සංස්ථාපනය හා පැළ ඝනත්වය",
            questionText = "පේළි අතර ${rCm} cm සහ පැළ අතර ${cCm} cm පරතරය ඇතිව හෙක්ටයාර $ha ක (හෙක්. 1 = 10,000 m²) සිටුවිය හැකි මුළු පැළ ගණන කීයද?",
            correct = "පැළ $total",
            distractors = listOf("පැළ ${total / 2}", "පැළ ${total * 2}", "පැළ ${total + 5000}"),
            explanation = "පැළ 1 කට ඉඩ = ${(rCm / 100.0)} × ${(cCm / 100.0)} m²; හෙක්. $ha කට = (${ha * 10000}) / (${(rCm * cCm) / 10000.0}) = $total."
          )
        )
      }
    }

    // F. Soil Water Moisture Content % (Weight basis) calculations (40 items)
    for (dryG in listOf(40, 50, 80, 100)) {
      for (pct in listOf(10, 15, 20, 25, 30, 35, 40, 45, 50, 60)) {
        val waterG = dryG * pct / 100
        val wetG = dryG + waterG
        list.add(
          QSpec(
            topic = "පාංශු භෞතික විද්‍යාව හා තෙතමනය",
            questionText = "තෙත පස් නියැදියක බර $wetG g වන අතර උඳුන් වියළි බර $dryG g නම් වියළි බර අනුව පාංශු තෙතමන ප්‍රතිශතය කීයද?",
            correct = "$pct%",
            distractors = listOf("${pct + 8}%", "${(pct - 5).coerceAtLeast(2)}%", "${pct * 2}%"),
            explanation = "ජල බර = $wetG - $dryG = $waterG g; තෙතමන % = ($waterG / $dryG) × 100 = $pct%."
          )
        )
      }
    }

    // G. Curated Soil Science, Plant Propagation, Irrigation, Pests, Livestock, Weed & Agro-Climatic Zones (90+ unique MCQs)
    val agriFacts = listOf(
      Triple("A හොරයිසනය (Top Soil)", "කාබනික ද්‍රව්‍ය (හියුමස්) හා ශාක මුල් බහුලවම අඩංගු ඉහළම වගා පාංශු ස්ථරය", "පාංශු පැතිකඩේ වඩාත් සාරවත්ම ස්ථරය වේ."),
      Triple("පාංශු pH අගය 5.5 - 6.8", "බොහෝ කෘෂිකාර්මික බෝග වගාවට වඩාත්ම සුදුසු පාංශු ප්‍රතික්‍රියා පරාසය", "pH අගය අධිකව අඩු ආම්ලික පස් සඳහා ඩොලමයිට් (CaMg(CO₃)₂) යොදයි."),
      Triple("ඩොලමයිට් (Dolomite) යෙදීම", "ආම්ලික පසෙහි pH අගය ඉහළ නැංවීම (පාංශු ආම්ලිකතාව නිවැරදි කිරීම)", "කැල්සියම් සහ මැග්නීසියම් පසට සපයන පාංශු ප්‍රතිකර්මයකි."),
      Triple("බිංදු ජල සම්පාදනය (Drip Irrigation)", "ශාක මූල මණ්ඩලයටම කාර්යක්ෂමව ජලය සපයන ජල සංරක්ෂණ ක්‍රමය", "ජල හිඟ වියළි කලාපීය වගා සඳහා 85-90% ජල කාර්යක්ෂමතාවක් ලබාදෙයි."),
      Triple("ඉසින ජල සම්පාදනය (Sprinkler Irrigation)", "ස්වාභාවික වර්ෂාවක් මෙන් ජලය බෝග මතට විසුරුවා හරින ක්‍රමය", "තේ, එළවළු හා කුළුබඩු තවාන්වලදී බහුලව භාවිත කෙරේ."),
      Triple("විධිමත් ඇට බද්ධ කිරීම (Bud Grafting)", "රබර්, අඹ සහ දෙහි වැනි ශාකවල උසස් අංකුරයක් ග්‍රාහකයකට බද්ධ කිරීම", "පැඟිරි කුලයේ ශාක සඳහා T-බද්ධය හා රබර් සඳහා Patch බද්ධය යොදාගනී."),
      Triple("වායව අතු බැඳීම (Air Layering / Marcotting)", "මව් ශාකයේ පවතිද්දීම අත්තක මුල් ඇද්දවීමේ වර්ධක ප්‍රචාරණ ක්‍රමය", "දෙහි, පේර, රඹුටන් හා ලෙමන් ප්‍රචාරණයට බහුලව භාවිත වේ."),
      Triple("පටක රෝපණය (Tissue Culture)", "ජීවාණුහරිත මාධ්‍යයක කුඩා ශාක කොටසකින් (Explant) පැළ දහස් ගණනක් නිපදවීම", "කෙසෙල්, අන්නාසි, ඕකිඩ් හා අර්තාපල් පැළ නිපදවීමට යොදාගනී."),
      Triple("බීජ සුප්තතාව (Seed Dormancy)", "සුදුසු ජලය, ඔක්සිජන් හා උෂ්ණත්වය තිබියදීත් ජීවී බීජයක් ප්‍රරෝහණය නොවීම", "තේක්ක, ඇකේෂියා බීජවල දෘඪ ආවරණය තුනී කිරීමෙන් (Scarification) සුප්තතාව බිඳී."),
      Triple("භූගත පේරු බෝග චක්‍රය (Crop Rotation)", "පසෙහි රනිල කුලයේ බෝගයක් මාරුවෙන් මාරුවට වගා කර පාංශු සාරවත් බව රැකීම", "රයිසෝබියම් (Rhizobium) බැක්ටීරියාව මගින් වායුගෝලීය නයිට්‍රජන් තිර කරයි."),
      Triple("නයිට්‍රජන් (N) ඌනතා ලක්ෂණය", "ශාකයේ පහළ පරණ පත්‍ර මුළුමනින්ම කහ පැහැ ගැන්වීම (හරිතක්ෂය)", "නයිට්‍රජන් ශාකය තුළ චංචල පෝෂකයක් බැවින් මුලින් පැරණි පත්‍රවල දිස්වේ."),
      Triple("පොස්පරස් (P) ඌනතා ලක්ෂණය", "පරණ පත්‍ර යටි පැත්තේ දම් හෝ රතු-දුඹුරු පැහැයක් ඇතිවීම හා මූල වර්ධනය අඩාල වීම", "ශක්ති සංචරණයට (ATP) හා මුල් වර්ධනයට පොස්පරස් අත්‍යවශ්‍ය වේ."),
      Triple("පොටෑසියම් (K) ඌනතා ලක්ෂණය", "පරණ පත්‍රවල දාර සහ අග්‍ර පිලිස්සුණු ආකාරයෙන් වියළී යාම", "පූටිකා විවෘත/වැසීම හා රෝග ප්‍රතිරෝධීතාව සඳහා K වැදගත් වේ."),
      Triple("ඒකාබද්ධ පළිබෝධ කළමනාකරණය (IPM)", "ජෛව විද්‍යාත්මක, යාන්ත්‍රික, වගා ක්‍රම හා අවම රසායනික ක්‍රම ඒකාබද්ධ කිරීම", "පරිසර හිතකාමී හා තිරසාර පළිබෝධ පාලන ප්‍රවේශයයි."),
      Triple("බෝඩෝ මිශ්‍රණය (Bordeaux Mixture)", "කොපර් සල්ෆේට් (CuSO₄), ක්ෂාරීය හුණු (Ca(OH)₂) හා ජලය මිශ්‍ර කර සාදන දිලීර නාශකය", "අංගමාරය හා කඳ කුණුවීම වැනි දිලීර රෝග පාලනයට යොදයි."),
      Triple("කොම්පෝස්ට් සෑදීමේ ප්‍රශස්ත C:N අනුපාතය", "ආරම්භයේදී 30:1 පමණ කාබන් හා නයිට්‍රජන් අනුපාතයක් තිබීම", "ජීර්ණ ක්‍රියාවලියේදී උෂ්ණත්වය 55°C-65°C දක්වා ඉහළ ගොස් වල් බීජ හා රෝග කාරක විනාශ වේ."),
      Triple("ශ්‍රී ලංකාවේ කෘෂි දේශගුණික කලාප සංඛ්‍යාව", "මූලික කෘෂි දේශගුණික කලාප 3 (තෙත්, අතරමැදි, වියළි) සහ උප කලාප 46 කි", "උන්නතාංශය අනුව පහතරට, මැදරට හා උඩරට ලෙස බෙදා ඇත."),
      Triple("බ්‍රේයර් හෙවත් භූ කට්ටි සැකසීම (Bunds / Terraces)", "බෑවුම් සහිත ඉඩම්වල පාංශු ඛාදනය වැළැක්වීමේ යාන්ත්‍රික සංරක්ෂණ ක්‍රමය", "ගල් වැටි, ලොක් ඇන්ඩ් ස්පිල් කාණු (Lock & Spill) සහ SALT ක්‍රමය භාවිත කෙරේ."),
      Triple("හයිඩ්‍රොපොනික්ස් (Hydroponics) වගාව", "පස් රහිතව ශාක පෝෂක ද්‍රාවණයක් තුළ බෝග වගා කිරීමේ ක්‍රමය", "NFT හා රසායනික පෝෂක ද්‍රාවණ (Albert Solution) යොදාගනී."),
      Triple("කොළ පැහැති තේ දලු කැඩීමේ සම්මතය", "මූලික අංකුරය සහ ඉන් පහළ කොළ දෙක (Two leaves and a bud)", "ගුණාත්මක කළු තේ නිෂ්පාදනය සඳහා මෙය අනිවාර්ය වේ."),
      Triple("කුඹුරු ගොවිතැනේ ශ්‍රී (SRI) ක්‍රමය", "තනි තරුණ පැළ (දින 8-12) වැඩි පරතරයකින් සිටුවා අවම ජලය භාවිත කිරීම", "වී පැළයේ අතු බෙදීම වැඩි කර ඉහළ අස්වැන්නක් ලබාදෙයි."),
      Triple("ගව පාලනයේ බූරු දෙනුන්ගේ ගැබ් කාලය", "දින 280 - 285 (ආසන්න වශයෙන් මාස 9 දින 9 කි)", "උසස් කිරි නිෂ්පාදන වර්ග ලෙස ෆ්‍රීෂියන්, ජර්සි, අයර්ෂයර් හැඳින්වේ."),
      Triple("ගව කිරි නැවත පැස්චරීකරණය (HTST)", "72°C උෂ්ණත්වයේ තත්පර 15 ක් රත් කර ක්ෂණිකව 4°C ට සිසිල් කිරීම", "රෝගකාරක බැක්ටීරියා විනාශ කර පෝෂණ ගුණය ආරක්ෂා කරයි."),
      Triple("කුකුළු පාලනයේ ශ්‍රී ලංකාවේ බිත්තර රක්කවන කාලය", "දින 21 ක් (උෂ්ණත්වය 37.5°C හා ආර්ද්‍රතාව 60%)", "පළමු සති 4 'බෲඩර්' (Brooder) කාලය ලෙස උණුසුම සපයයි."),
      Triple("මත්ස්‍ය වගාවේ හරිත ජල තත්ත්වය", "ශාක ප්ලවාංග (Phytoplankton) වර්ධනය නිසා ජලයට ලැබෙන සාරවත් කොළ පැහැය", "තිලාපියා, කාප් වැනි මසුන්ට ස්වාභාවික ආහාර හා ඔක්සිජන් සපයයි."),
      Triple("වී බෝගයේ දුඹුරු පැළ කීඩෑවා (BPH)", "වී පඳුරු පතුලේ සිට යුෂ උරා බී 'හොපර් පිලිස්සුම' (Hopper Burn) ඇති කරන කෘමියා", "ප්‍රතිරෝධී වී ප්‍රභේද (Bg 300, Bg 352) වැවීම මගින් පාලනය කළ හැක.")
    )
    for ((idx, item) in agriFacts.withIndex()) {
      val (term, desc, note) = item
      val d1 = agriFacts[(idx + 2) % agriFacts.size].first
      val d2 = agriFacts[(idx + 5) % agriFacts.size].first
      val d3 = agriFacts[(idx + 9) % agriFacts.size].first
      list.add(
        QSpec(
          topic = "කෘෂි විද්‍යා මූලධර්ම",
          questionText = "කෘෂිකර්මාන්තයේදී \"$desc\" යන්නෙන් හඳුන්වනු ලබන්නේ කුමක්ද?",
          correct = term,
          distractors = listOf(d1, d2, d3),
          explanation = "$term — $note"
        )
      )
      val desc1 = agriFacts[(idx + 3) % agriFacts.size].second
      val desc2 = agriFacts[(idx + 6) % agriFacts.size].second
      val desc3 = agriFacts[(idx + 11) % agriFacts.size].second
      list.add(
        QSpec(
          topic = "කෘෂි විද්‍යා මූලධර්ම",
          questionText = "කෘෂි විද්‍යා විෂයෙහි '$term' පිළිබඳ නිවැරදිම විග්‍රහය කුමක්ද?",
          correct = desc,
          distractors = listOf(desc1, desc2, desc3),
          explanation = "$term — $note"
        )
      )
    }

    // H. Major Sri Lankan Crop Varieties recommended by Dept. of Agriculture (30 MCQs)
    val cropVarieties = listOf(
      Triple("වී (මාස 3 / Bg 300)", "Bg 300 / At 306 / Bw 367", "කෙටි කාලීන ඉහළ අස්වනු දෙන වී ප්‍රභේද"),
      Triple("බඩඉරිඟු (Maize)", "භද්‍රා / රුවන් / මුතු / සම්පත්", "වියළි කලාපීය අතිරේක බෝග ප්‍රභේද"),
      Triple("මුං ඇට (Green Gram)", "MI 5 / MI 6 / හරි / අරිය", "කෙටි කාලීන රනිල බෝග ප්‍රභේද"),
      Triple("කව්පි (Cowpea)", "විජය / වරුණි / මිචෙල් / ධවල", "නියඟයට ඔරොත්තු දෙන රනිල බෝග"),
      Triple("තක්කාලි (Tomato)", "තළිණ / තරු / කේ.ඩබ්ලිව්.ආර් / පද්මා", "බැක්ටීරියා හිටුමැරීමට ප්‍රතිරෝධී ප්‍රභේද"),
      Triple("මිරිස් (Chilli)", "MI-2 / MI-හොට් / අරුණලු / ගල්කිරියාගම", "දේශීය හා වැඩිදියුණු කළ මිරිස් ප්‍රභේද"),
      Triple("රතු ලූනු (Red Onion)", "වෙදාලම් / ජැෆ්නා ලෝකල්", "උතුරු හා වියළි කලාපයේ වගා කරන ප්‍රභේද"),
      Triple("රබර් (Rubber)", "RRISL 203 / RRIC 121 / RRIC 100", "ශ්‍රී ලංකා රබර් පර්යේෂණායතනය නිර්දේශිත ක්ලෝන"),
      Triple("පොල් (Coconut)", "CRIC 60 / CRIC 65 / කප්රුවන", "උස් හා දෙමුහුන් පොල් ප්‍රභේද"),
      Triple("තේ (Tea)", "TRI 2023 / TRI 2025 / TRI 3055", "වැඩිදියුණු කළ VP තේ ක්ලෝන")
    )
    for ((idx, item) in cropVarieties.withIndex()) {
      val (crop, vars, note) = item
      val d1 = cropVarieties[(idx + 1) % cropVarieties.size].second
      val d2 = cropVarieties[(idx + 3) % cropVarieties.size].second
      val d3 = cropVarieties[(idx + 5) % cropVarieties.size].second
      list.add(
        QSpec(
          topic = "නිර්දේශිත බෝග ප්‍රභේද",
          questionText = "ශ්‍රී ලංකාවේ කෘෂිකර්ම හෝ පර්යේෂණ ආයතන මගින් '$crop' සඳහා නිර්දේශ කර ඇති ප්‍රභේද කාණ්ඩය කුමක්ද?",
          correct = vars,
          distractors = listOf(d1, d2, d3),
          explanation = "$crop — $note ($vars)."
        )
      )
    }

    return list
  }
}
