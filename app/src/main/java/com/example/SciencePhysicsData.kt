package com.example

/**
 * 100% Complete Grade 10 & 11 Science Syllabus - Physics Formulas & Numerical Problem Solvers
 * Covers every unit: Equations of motion, Newton's laws, Momentum, Work, energy & power,
 * Ohm's law, Series/parallel, Moments & levers, Hydrostatic pressure, Heat & Latent heat,
 * Electricity units & costs, Wave mechanics, Lenses & optics, Transformers, Electronics & Logic gates.
 */
object SciencePhysicsData {
  val items = listOf(
    // ==========================================
    // GRADE 10 PHYSICS
    // ==========================================
    SciencePhysicsItem(
      id = "phy_10_01",
      grade = "10",
      unitName = "චලිත සමීකරණ (Equations of Motion)",
      formula = "v = u + at  |  s = ut + ½at²  |  v² = u² + 2as  |  s = ½(u + v)t",
      formulaExplanation = "v = අවසාන ප්‍රවේගය (m s⁻¹), u = ආරම්භක ප්‍රවේගය (m s⁻¹), a = ත්වරණය (m s⁻²), t = කාලය (s), s = විස්ථාපනය (m)",
      problemText = "නිශ්චලතාවයෙන් ගමන් ආරම්භ කරන මෝටර් රථයක් 2 m s⁻² ඒකාකාර ත්වරණයකින් තත්පර 5ක් ගමන් කරයි. රථය ලබාගන්නා අවසාන ප්‍රවේගය සහ ගමන් කළ දුර සොයන්න.",
      stepByStepSolution = listOf(
        "දත්ත: u = 0, a = 2 m s⁻², t = 5 s",
        "1. අවසාන ප්‍රවේගය (v): v = u + at ➔ v = 0 + (2 × 5) = 10 m s⁻¹",
        "2. ගමන් කළ දුර (s): s = ut + ½at² ➔ s = (0 × 5) + ½ × 2 × (5)² = 25 m"
      ),
      finalAnswer = "ප්‍රවේගය = 10 m s⁻¹, දුර = 25 m",
      units = "m s⁻¹ සහ m",
      examTip = "නිශ්චලතාවයෙන් අරඹයි කී විට u = 0 ද, තිරිංග යොදා නතර කළා කී විට v = 0 ද වේ."
    ),
    SciencePhysicsItem(
      id = "phy_10_02",
      grade = "10",
      unitName = "නිව්ටන්ගේ දෙවන නියමය (Newton's 2nd Law)",
      formula = "F = ma",
      formulaExplanation = "F = සම්ප්‍රයුක්ත බලය (N), m = ස්කන්ධය (kg), a = ත්වරණය (m s⁻²)",
      problemText = "ස්කන්ධය 1200 kg වූ මෝටර් රථයකට තත්පර 4ක් තුළ ප්‍රවේගය 10 m s⁻¹ සිට 30 m s⁻¹ දක්වා වැඩි කිරීමට එන්ජිම මඟින් යෙදිය යුතු බලය ගණනය කරන්න.",
      stepByStepSolution = listOf(
        "1. ත්වරණය සෙවීම: a = (v - u) / t = (30 - 10) / 4 = 20 / 4 = 5 m s⁻²",
        "2. බලය සෙවීම: F = ma ➔ F = 1200 kg × 5 m s⁻² = 6000 N"
      ),
      finalAnswer = "යෙදිය යුතු බලය = 6000 N (6 kN)",
      units = "Newton (N)",
      examTip = "ස්කන්ධය ග්‍රෑම් (g) වලින් දුනහොත් 1000න් බෙදා kg බවට පරිවර්තනය කරන්න."
    ),
    SciencePhysicsItem(
      id = "phy_10_03",
      grade = "10",
      unitName = "කාර්යය, ශක්තිය හා ක්ෂමතාව (Work, Energy & Power)",
      formula = "W = F × s  |  Ek = ½mv²  |  Ep = mgh  |  P = W / t",
      formulaExplanation = "W = කාර්යය (J), Ek = චාලක ශක්තිය, Ep = විභව ශක්තිය, P = ක්ෂමතාව (Watt), h = උස (m)",
      problemText = "ස්කන්ධය 50 kg වූ ළමයෙකු 10 m උස පඩිපෙළක් තත්පර 20කදී නගියි. 1. ඔහු කළ කාර්යය 2. ඔහුගේ ක්ෂමතාව සොයන්න. (g = 10 m s⁻²)",
      stepByStepSolution = listOf(
        "1. කළ කාර්යය (W = mgh): W = 50 kg × 10 m s⁻² × 10 m = 5000 J",
        "2. ක්ෂමතාව (P = W / t): P = 5000 J / 20 s = 250 W"
      ),
      finalAnswer = "කාර්යය = 5000 J, ක්ෂමතාව = 250 W",
      units = "Joule (J) සහ Watt (W)",
      examTip = "කාර්යය සිදුකරන ශීඝ්‍රතාව ක්ෂමතාව වේ (1 W = 1 J s⁻¹)."
    ),
    SciencePhysicsItem(
      id = "phy_10_04",
      grade = "10",
      unitName = "චාලක ශක්තිය (Kinetic Energy)",
      formula = "Ek = ½mv²",
      formulaExplanation = "Ek = චාලක ශක්තිය (J), m = ස්කන්ධය (kg), v = ප්‍රවේගය (m s⁻¹)",
      problemText = "ස්කන්ධය 800 kg වූ මෝටර් රථයක් 20 m s⁻¹ ප්‍රවේගයෙන් ගමන් කරයි. රථයේ චාලක ශක්තිය ගණනය කරන්න.",
      stepByStepSolution = listOf(
        "දත්ත: m = 800 kg, v = 20 m s⁻¹",
        "Ek = ½mv² = ½ × 800 × (20)² = 400 × 400 = 160,000 J (160 kJ)"
      ),
      finalAnswer = "චාලක ශක්තිය = 160,000 J (160 kJ)",
      units = "Joule (J)",
      examTip = "ප්‍රවේගය දෙගුණ වුවහොත් චාලක ශක්තිය 4 ගුණයක් වේ (v² සමානුපාතික නිසා)."
    ),
    SciencePhysicsItem(
      id = "phy_10_05",
      grade = "10",
      unitName = "ඕම්ගේ නියමය (Ohm's Law)",
      formula = "V = IR  ➔  I = V / R  ➔  R = V / I",
      formulaExplanation = "V = විභව අන්තරය (V), I = ධාරාව (A), R = ප්‍රතිරෝධය (Ω)",
      problemText = "12 V මෝටර් බැටරියකට සම්බන්ධ කළ බල්බයක් හරහා 1.5 A ධාරාවක් ගලා යයි. බල්බයේ ප්‍රතිරෝධය සොයන්න.",
      stepByStepSolution = listOf(
        "දත්ත: V = 12 V, I = 1.5 A",
        "R = V / I ➔ R = 12 / 1.5 = 8 Ω"
      ),
      finalAnswer = "ප්‍රතිරෝධය = 8 Ω",
      units = "Ohm (Ω)",
      examTip = "නියත උෂ්ණත්වයේ පවතින සන්නායකයක ධාරාව විභව අන්තරයට අනුලෝමව සමානුපාතික වේ."
    ),
    SciencePhysicsItem(
      id = "phy_10_06",
      grade = "10",
      unitName = "ප්‍රතිරෝධක ශ්‍රේණිගත හා සමාන්තරගත",
      formula = "ශ්‍රේණිගත: R = R₁ + R₂  |  සමාන්තරගත: 1/R = 1/R₁ + 1/R₂",
      formulaExplanation = "ශ්‍රේණිගත විට ප්‍රතිරෝධ සෘජුව එකතු වේ; සමාන්තරගත විට සමක ප්‍රතිරෝධය අඩු වේ.",
      problemText = "3 Ω සහ 6 Ω ප්‍රතිරෝධක දෙකක් 1. ශ්‍රේණිගතව 2. සමාන්තරගතව සම්බන්ධ කළ විට සමක ප්‍රතිරෝධයන් සොයන්න.",
      stepByStepSolution = listOf(
        "1. ශ්‍රේණිගත: R = 3 + 6 = 9 Ω",
        "2. සමාන්තරගත: 1/R = 1/3 + 1/6 = 2/6 + 1/6 = 3/6 = 1/2 ➔ R = 2 Ω"
      ),
      finalAnswer = "ශ්‍රේණිගත = 9 Ω, සමාන්තරගත = 2 Ω",
      units = "Ohm (Ω)",
      examTip = "සමාන්තරගත පරිපථයක සමක ප්‍රතිරෝධය එහි ඇති කුඩාම ප්‍රතිරෝධයටත් වඩා අඩුය."
    ),
    SciencePhysicsItem(
      id = "phy_10_07",
      grade = "10",
      unitName = "ගම්‍යතාව සහ ගම්‍යතා සංස්ථිතිය",
      formula = "p = mv  |  m₁u₁ + m₂u₂ = m₁v₁ + m₂v₂",
      formulaExplanation = "p = ගම්‍යතාව (kg m s⁻¹), m = ස්කන්ධය (kg), v = ප්‍රවේගය (m s⁻¹)",
      problemText = "ස්කන්ධය 0.5 kg වූ බෝලයක් 10 m s⁻¹ ප්‍රවේගයෙන් ගමන් කර නිශ්චලව තිබූ 1.5 kg බෝලයක ගැටී දෙකම එකට ඇලී ගමන් කරයි. ගැටුමෙන් පසු පොදු ප්‍රවේගය සොයන්න.",
      stepByStepSolution = listOf(
        "ගැටුමට පෙර මුළු ගම්‍යතාව = (m₁u₁) + (m₂u₂) = (0.5 × 10) + (1.5 × 0) = 5 kg m s⁻¹",
        "ගැටුමෙන් පසු මුළු ගම්‍යතාව = (m₁ + m₂)V = (0.5 + 1.5)V = 2V",
        "ගම්‍යතා සංස්ථිති නියමයෙන්: 2V = 5 ➔ V = 5 / 2 = 2.5 m s⁻¹"
      ),
      finalAnswer = "පොදු ප්‍රවේගය = 2.5 m s⁻¹",
      units = "m s⁻¹",
      examTip = "බාහිර අසමතුලිත බලයක් ක්‍රියා නොකරන සංවෘත පද්ධතියක මුළු ගම්‍යතාව නියතව පවතී."
    ),
    SciencePhysicsItem(
      id = "phy_10_08",
      grade = "10",
      unitName = "බල ඝූර්ණය සහ ලීවර මූලධර්මය",
      formula = "M = F × d  |  වාමාවර්ත ඝූර්ණ එකතුව = දක්ෂිණාවර්ත ඝූර්ණ එකතුව",
      formulaExplanation = "M = බල ඝූර්ණය (N m), F = බලය (N), d = භ්‍රමණ අක්ෂයේ සිට බලයේ ක්‍රියා රේඛාවට ලම්භ දුර (m)",
      problemText = "ආධාරකයේ සිට 2 m දුරින් 300 N බරක් ඇති විට, ආධාරකයේ අනෙක් පස 3 m දුරින් යෙදිය යුතු බලය කොපමණද?",
      stepByStepSolution = listOf(
        "සමතුලිතතාවයේදී: F₁ × d₁ = F₂ × d₂",
        "300 N × 2 m = F₂ × 3 m",
        "600 = 3 F₂ ➔ F₂ = 600 / 3 = 200 N"
      ),
      finalAnswer = "යෙදිය යුතු බලය = 200 N",
      units = "Newton (N)",
      examTip = "දොර අගුලක් විවෘත කිරීමේදී අත රඳවනය කෙළවරේ තැබීමෙන් d වැඩි වී අවශ්‍ය බලය F අඩු කරගත හැක."
    ),
    SciencePhysicsItem(
      id = "phy_10_09",
      grade = "10",
      unitName = "සරල යන්ත්‍ර - යාන්ත්‍රික වාසිය හා කාර්යක්ෂමතාව",
      formula = "MA = W / L  |  VR = dL / dW  |  η = (MA / VR) × 100%",
      formulaExplanation = "MA = යාන්ත්‍රික වාසිය (Mechanical Advantage), VR = ප්‍රවේග අනුපාතය, W = භාරය, L = ආයාසය, η = කාර්යක්ෂමතාව",
      problemText = "ප්‍රවේග අනුපාතය 4ක් වූ කප්පි පද්ධතියක් මඟින් 600 N භාරයක් එසවීමට 200 N ආයාසයක් යොදයි. 1. යාන්ත්‍රික වාසිය 2. කාර්යක්ෂමතාව සොයන්න.",
      stepByStepSolution = listOf(
        "1. යාන්ත්‍රික වාසිය (MA) = භාරය / ආයාසය = 600 N / 200 N = 3",
        "2. කාර්යක්ෂමතාව (η) = (MA / VR) × 100% = (3 / 4) × 100% = 75%"
      ),
      finalAnswer = "MA = 3 (ඒකක රහිත), කාර්යක්ෂමතාව = 75%",
      units = "MA ඒකක රහිතය, කාර්යක්ෂමතාව %",
      examTip = "ඝර්ෂණය නිසා කිසිම සැබෑ යන්ත්‍රයක කාර්යක්ෂමතාව 100% විය නොහැක (සැමවිටම MA < VR වේ)."
    ),
    SciencePhysicsItem(
      id = "phy_10_10",
      grade = "10",
      unitName = "විද්‍යුත් ධාරාවේ තාප ඵලය (ජූල් නියමය)",
      formula = "H = I²Rt = VIt = (V² / R)t",
      formulaExplanation = "H = ජනනය වන තාප ශක්තිය (J), I = ධාරාව (A), R = ප්‍රතිරෝධය (Ω), t = කාලය (s), V = විභව අන්තරය",
      problemText = "50 Ω ප්‍රතිරෝධකයක් හරහා 2 A ධාරාවක් තත්පර 30ක් ගලා යයි. ජනනය වන තාප ශක්තිය ගණනය කරන්න.",
      stepByStepSolution = listOf(
        "දත්ත: R = 50 Ω, I = 2 A, t = 30 s",
        "H = I²Rt = (2)² × 50 × 30 = 4 × 50 × 30 = 6000 J (6 kJ)"
      ),
      finalAnswer = "ජනනය වන තාපය = 6000 J (6 kJ)",
      units = "Joule (J)",
      examTip = "විදුලි ඉස්ත්‍රික්කය, ගීසරය සහ විදුලි උඳුන ක්‍රියා කරන්නේ ජූල් තාපනය මූලධර්මයෙනි."
    ),
    SciencePhysicsItem(
      id = "phy_10_11",
      grade = "10",
      unitName = "ඝර්ෂණ බලය සහ සීමාකාරී ඝර්ෂණය",
      formula = "F = μR  |  R = mg (තිරස් තලයකදී)",
      formulaExplanation = "F = සීමාකාරී ඝර්ෂණ බලය (N), μ = ඝර්ෂණ සංගුණකය, R = අභිලම්බ ප්‍රතික්‍රියාව (N)",
      problemText = "ස්කන්ධය 20 kg වූ ලී කුට්ටියක් තිරස් මේසයක් මත තබා ඇත. ඝර්ෂණ සංගුණකය μ = 0.3 නම්, කුට්ටිය චලනය වීමට පටන් ගැනීමට යෙදිය යුතු අවම බලය සොයන්න. (g = 10 m s⁻²)",
      stepByStepSolution = listOf(
        "1. අභිලම්බ ප්‍රතික්‍රියාව R = mg = 20 kg × 10 m s⁻² = 200 N",
        "2. සීමාකාරී ඝර්ෂණ බලය F = μR = 0.3 × 200 N = 60 N"
      ),
      finalAnswer = "අවම යෙදිය යුතු බලය = 60 N",
      units = "Newton (N)",
      examTip = "චලිතය ආරම්භ කිරීමට පෙර සීමාකාරී ඝර්ෂණයට වඩා වැඩි බලයක් යෙදිය යුතුය."
    ),
    SciencePhysicsItem(
      id = "phy_10_12",
      grade = "10",
      unitName = "විද්‍යුත් ආරෝපණය සහ ධාරාව",
      formula = "Q = It  ➔  I = Q / t",
      formulaExplanation = "Q = විද්‍යුත් ආරෝපණය (Coulomb - C), I = ධාරාව (Ampere - A), t = කාලය (Seconds - s)",
      problemText = "පරිපථයක් හරහා විනාඩි 2ක් තුළ 240 C ආරෝපණයක් ගලා යයි. පරිපථයේ ධාරාව සොයන්න.",
      stepByStepSolution = listOf(
        "කාලය තත්පර බවට පරිවර්තනය: t = 2 × 60 s = 120 s",
        "I = Q / t = 240 C / 120 s = 2 A"
      ),
      finalAnswer = "ධාරාව = 2 A",
      units = "Ampere (A)",
      examTip = "විනාඩි වලින් දුනහොත් අනිවාර්යයෙන්ම තත්පර (s) බවට 60න් ගුණ කරගන්න."
    ),

    // ==========================================
    // GRADE 11 PHYSICS
    // ==========================================
    SciencePhysicsItem(
      id = "phy_11_01",
      grade = "11",
      unitName = "පීඩනය සහ ද්‍රව පීඩනය (Pressure & Hydrostatic)",
      formula = "P = F / A  |  දියර පීඩනය P = hρg",
      formulaExplanation = "P = පීඩනය (Pa හෙවත් N m⁻²), h = ගැඹුර (m), ρ = ඝනත්වය (kg m⁻³), g = 10 m s⁻²",
      problemText = "ඝනත්වය 1000 kg m⁻³ වූ ජල ටැංකියක 4 m ගැඹුරින් පිහිටි ලක්ෂ්‍යයක ද්‍රව පීඩනය ගණනය කරන්න.",
      stepByStepSolution = listOf(
        "දත්ත: h = 4 m, ρ = 1000 kg m⁻³, g = 10 m s⁻²",
        "P = hρg = 4 × 1000 × 10 = 40,000 Pa (40 kPa)"
      ),
      finalAnswer = "ද්‍රව පීඩනය = 40,000 Pa (40 kPa)",
      units = "Pa (Pascal) / N m⁻²",
      examTip = "මුළු පීඩනය ඇසුවහොත් වායුගෝල පීඩනය (100 kPa) එකතු කළ යුතුය (P_total = P_atm + hρg)."
    ),
    SciencePhysicsItem(
      id = "phy_11_02",
      grade = "11",
      unitName = "තාප ප්‍රමාණය සහ විශිෂ්ට තාප ධාරිතාව",
      formula = "Q = mcΔθ  |  Q = mL (ගුප්ත තාපය)",
      formulaExplanation = "Q = තාප ප්‍රමාණය (J), m = ස්කන්ධය (kg), c = විශිෂ්ට තාප ධාරිතාව (J kg⁻¹ °C⁻¹), Δθ = උෂ්ණත්ව වෙනස",
      problemText = "ස්කන්ධය 2 kg වූ ජලයේ උෂ්ණත්වය 30 °C සිට 80 °C දක්වා ඉහළ නැංවීමට අවශ්‍ය තාප ප්‍රමාණය සොයන්න. (ජලයේ c = 4200 J kg⁻¹ °C⁻¹)",
      stepByStepSolution = listOf(
        "දත්ත: m = 2 kg, c = 4200 J kg⁻¹ °C⁻¹, Δθ = (80 - 30) = 50 °C",
        "Q = mcΔθ = 2 × 4200 × 50 = 420,000 J (420 kJ)"
      ),
      finalAnswer = "අවශ්‍ය තාපය = 420,000 J (420 kJ)",
      units = "Joule (J)",
      examTip = "ජලයට ඉතා ඉහළ විශිෂ්ට තාප ධාරිතාවක් ඇති බැවින් මෝටර් රථ රේඩියේටර්වල සිසිලනකාරකයක් ලෙස යොදාගනී."
    ),
    SciencePhysicsItem(
      id = "phy_11_03",
      grade = "11",
      unitName = "විද්‍යුත් ක්ෂමතාව සහ විදුලි බිල (Units)",
      formula = "P = VI = I²R = V²/R  |  විදුලි ඒකක = (P(W) × t(h)) / 1000",
      formulaExplanation = "P = ක්ෂමතාව (Watt), 1 Unit = 1 kWh (කිලෝවොට් පැය = 3.6 × 10⁶ J)",
      problemText = "1500 W විදුලි උඳුනක් දිනකට පැය 2ක් මාසයක් (දින 30ක්) ක්‍රියාත්මක කළ විට වැයවන විදුලි ඒකක ගණන කොපමණද?",
      stepByStepSolution = listOf(
        "මාසයක මුළු පැය ගණන = 2 × 30 = 60 h",
        "විදුලි ඒකක = (1500 W × 60 h) / 1000 = 90,000 / 1000 = 90 Units"
      ),
      finalAnswer = "වැයවන ඒකක = 90 kWh (Units)",
      units = "kWh (Units)",
      examTip = "1 Unit යනු 1000 W (1 kW) උපකරණයක් පැයක් (1 h) ක්‍රියාත්මක කිරීමේදී වැයවන විදුලි ශක්තියයි."
    ),
    SciencePhysicsItem(
      id = "phy_11_04",
      grade = "11",
      unitName = "ට්‍රාන්ස්ෆෝමර් සමීකරණය (Transformers)",
      formula = "Vp / Vs = Np / Ns = Is / Ip",
      formulaExplanation = "Vp/Vs = ප්‍රාථමික/ද්විතීයික වෝල්ටීයතාව, Np/Ns = පොට ගණන, Ip/Is = ධාරාව",
      problemText = "ප්‍රාථමිකයේ පොට 500ක් හා ද්විතීයිකයේ පොට 100ක් ඇති අපචායක ට්‍රාන්ස්ෆෝමරයකට 230 V ලබාදුන් විට ලැබෙන ප්‍රතිදාන වෝල්ටීයතාව සොයන්න.",
      stepByStepSolution = listOf(
        "දත්ත: Np = 500, Ns = 100, Vp = 230 V",
        "Vp / Vs = Np / Ns ➔ 230 / Vs = 500 / 100 = 5",
        "Vs = 230 / 5 = 46 V"
      ),
      finalAnswer = "ද්විතීයික වෝල්ටීයතාව = 46 V",
      units = "Volt (V)",
      examTip = "Ns > Np නම් උපචායකද, Ns < Np නම් අපචායකද වේ. ක්‍රියාකරන්නේ ප්‍රත්‍යාවර්ත ධාරාවට (AC) පමණි."
    ),
    SciencePhysicsItem(
      id = "phy_11_05",
      grade = "11",
      unitName = "තරංග චලිතය සහ ශබ්දය",
      formula = "v = fλ  |  f = 1 / T",
      formulaExplanation = "v = තරංග ප්‍රවේගය (m s⁻¹), f = සංඛ්‍යාතය (Hz), λ = තරංග ආයාමය (m), T = ආවර්ත කාලය (s)",
      problemText = "සංඛ්‍යාතය 250 Hz වූ ශබ්ද තරංගයක වාතයේ ප්‍රවේගය 340 m s⁻¹ වේ නම් එහි තරංග ආයාමය සොයන්න.",
      stepByStepSolution = listOf(
        "v = fλ ➔ 340 = 250 × λ",
        "λ = 340 / 250 = 1.36 m"
      ),
      finalAnswer = "තරංග ආයාමය = 1.36 m",
      units = "Meter (m)",
      examTip = "මාධ්‍යය වෙනස් වන විට සංඛ්‍යාතය (f) නොවෙනස්ව පවතින අතර v සහ λ වෙනස් වේ."
    ),
    SciencePhysicsItem(
      id = "phy_11_06",
      grade = "11",
      unitName = "කාච සූත්‍රය සහ රේඛීය විශාලනය",
      formula = "1/f = 1/v + 1/u  |  m = v / u = hi / ho",
      formulaExplanation = "f = නාභීය දුර, u = වස්තු දුර, v = ප්‍රතිබිම්බ දුර, m = රේඛීය විශාලනය",
      problemText = "නාභීය දුර 10 cm වූ උත්තල කාචයක සිට 15 cm ඈතින් තැබූ වස්තුවක ප්‍රතිබිම්බය සෑදෙන දුර සහ විශාලනය සොයන්න.",
      stepByStepSolution = listOf(
        "1/f = 1/v + 1/u ➔ 1/10 = 1/v + 1/15",
        "1/v = 1/10 - 1/15 = (3 - 2)/30 = 1/30 ➔ v = 30 cm",
        "විශාලනය m = v / u = 30 / 15 = 2"
      ),
      finalAnswer = "ප්‍රතිබිම්බ දුර = 30 cm, විශාලනය = 2",
      units = "cm සහ විශාලනය ඒකක රහිතය",
      examTip = "සත්‍ය ප්‍රතිබිම්බ සඳහා v ධන වන අතර තාත්වික නොවන අතාත්වික ප්‍රතිබිම්බ සඳහා සෘණ වේ."
    ),
    SciencePhysicsItem(
      id = "phy_11_07",
      grade = "11",
      unitName = "ස්නෙල්ගේ නියමය සහ වර්තනාංකය",
      formula = "n = sin i / sin r = c / v",
      formulaExplanation = "n = නිරපේක්ෂ වර්තනාංකය, i = පතන කෝණය, r = වර්තන කෝණය, c = ආලෝකයේ රික්ත ප්‍රවේගය (3 × 10⁸ m s⁻¹)",
      problemText = "ආලෝක කිරණයක් වාතයේ සිට වීදුරු කුට්ටියකට 45° ක කෝණයකින් පතනය වී 30° කෝණයකින් වර්තනය වේ නම් වීදුරුවේ වර්තනාංකය සොයන්න. (sin 45° = 0.707, sin 30° = 0.5)",
      stepByStepSolution = listOf(
        "ස්නෙල්ගේ නියමයෙන්: n = sin i / sin r",
        "n = sin 45° / sin 30° = 0.707 / 0.5 = 1.414"
      ),
      finalAnswer = "වර්තනාංකය n ≈ 1.41",
      units = "වර්තනාංකය ඒකක රහිතය",
      examTip = "වඩා ඝන මාධ්‍යයකට ඇතුළු වන විට ආලෝක කිරණය අභිලම්බය දෙසට නැමෙයි."
    ),
    SciencePhysicsItem(
      id = "phy_11_08",
      grade = "11",
      unitName = "පූර්ණ අභ්‍යන්තර පරාවර්තනය සහ අවධි කෝණය",
      formula = "sin C = 1 / n  ➔  n = 1 / sin C",
      formulaExplanation = "C = අවධි කෝණය (Critical Angle), n = මාධ්‍යයේ වර්තනාංකය",
      problemText = "වර්තනාංකය 2.0 ක් වූ මාධ්‍යයක අවධි කෝණය ගණනය කරන්න. (sin 30° = 0.5)",
      stepByStepSolution = listOf(
        "sin C = 1 / n = 1 / 2.0 = 0.5",
        "sin C = 0.5 බැවින් C = 30° වේ."
      ),
      finalAnswer = "අවධි කෝණය C = 30°",
      units = "අංශක (°)",
      examTip = "පූර්ණ අභ්‍යන්තර පරාවර්තනය වීමට: 1. ආලෝකය ප්‍රකාශ ඝන මාධ්‍යයේ සිට විරල මාධ්‍යයට යා යුතුය. 2. පතන කෝණය > අවධි කෝණය විය යුතුය."
    ),
    SciencePhysicsItem(
      id = "phy_11_09",
      grade = "11",
      unitName = "විශිෂ්ට ගුප්ත තාපය (Latent Heat)",
      formula = "Q = mL",
      formulaExplanation = "Q = තාප ප්‍රමාණය (J), m = ස්කන්ධය (kg), L = විශිෂ්ට ගුප්ත තාපය (J kg⁻¹)",
      problemText = "0 °C හි පවතින 0.5 kg අයිස් සම්පූර්ණයෙන් 0 °C ජලය බවට පත්කිරීමට අවශ්‍ය තාපය සොයන්න. (අයිස් විලයනයේ විශිෂ්ට ගුප්ත තාපය Lf = 3.36 × 10⁵ J kg⁻¹)",
      stepByStepSolution = listOf(
        "දත්ත: m = 0.5 kg, Lf = 336,000 J kg⁻¹",
        "Q = mLf = 0.5 kg × 336,000 J kg⁻¹ = 168,000 J (168 kJ)"
      ),
      finalAnswer = "අවශ්‍ය තාපය = 168,000 J (168 kJ)",
      units = "Joule (J)",
      examTip = "අවස්ථා විපර්යාසයේදී (ඝන ➔ ද්‍රව හෝ ද්‍රව ➔ වායු) උෂ්ණත්වය වෙනස් නොවේ; ගුප්ත තාපය පමණක් අවශෝෂණය වේ."
    ),
    SciencePhysicsItem(
      id = "phy_11_10",
      grade = "11",
      unitName = "ආකිමිඩීස් මූලධර්මය සහ උත්ප්ලාවකතාව",
      formula = "U = V × ρ × g  |  පාවෙන විට U = W (වස්තුවේ බර)",
      formulaExplanation = "U = උත්ප්ලාවකතා බලය (N), V = ගිලී ඇති පරිමාව (m³), ρ = ද්‍රවයේ ඝනත්වය (kg m⁻³), g = 10 m s⁻²",
      problemText = "පරිමාව 0.002 m³ වූ ලෝහ කුට්ටියක් ජලයේ (ඝනත්වය 1000 kg m⁻³) සම්පූර්ණයෙන් ගිල්වූ විට ඒ මත යෙදෙන උත්ප්ලාවකතා බලය සොයන්න.",
      stepByStepSolution = listOf(
        "දත්ත: V = 0.002 m³, ρ = 1000 kg m⁻³, g = 10 m s⁻²",
        "U = Vρg = 0.002 × 1000 × 10 = 2 × 10 = 20 N"
      ),
      finalAnswer = "උත්ප්ලාවකතා බලය = 20 N",
      units = "Newton (N)",
      examTip = "වස්තුවක් ද්‍රවයක ගිල්වූ විට එහි බරෙහි අඩුවීම හරියටම විස්ථාපනය වූ ද්‍රවයේ බරට සමාන වේ."
    ),
    SciencePhysicsItem(
      id = "phy_11_11",
      grade = "11",
      unitName = "ට්‍රාන්සිස්ටර ධාරා ලාභය සහ සූත්‍ර",
      formula = "Ie = Ib + Ic  |  β = Ic / Ib",
      formulaExplanation = "Ie = විමෝචක ධාරාව, Ib = පාදම ධාරාව (μA), Ic = සංග්‍රාහක ධාරාව (mA), β = ධාරා ලාභය",
      problemText = "ට්‍රාන්සිස්ටරයක පාදම ධාරාව Ib = 50 μA (0.05 mA) වන විට සංග්‍රාහක ධාරාව Ic = 5 mA වේ. 1. ධාරා ලාභය (β) 2. විමෝචක ධාරාව (Ie) සොයන්න.",
      stepByStepSolution = listOf(
        "1. ධාරා ලාභය β = Ic / Ib = 5 mA / 0.05 mA = 100",
        "2. විමෝචක ධාරාව Ie = Ib + Ic = 0.05 mA + 5 mA = 5.05 mA"
      ),
      finalAnswer = "ධාරා ලාභය β = 100 (ඒකක රහිත), Ie = 5.05 mA",
      units = "β ඒකක රහිතය, Ie mA",
      examTip = "ට්‍රාන්සිස්ටරයක් ධාරා වර්ධකයක් ලෙස හෝ ඉලෙක්ට්‍රොනික ස්විචයක් ලෙස යොදාගනී."
    ),
    SciencePhysicsItem(
      id = "phy_11_12",
      grade = "11",
      unitName = "තර්ක ද්වාර බූලීය වීජ ගණිතය (Logic Gates)",
      formula = "AND: Y = A · B  |  OR: Y = A + B  |  NOT: Y = A'  |  NAND: Y = (A · B)'",
      formulaExplanation = "A, B = ආදාන (0 හෝ 1), Y = ප්‍රතිදානය (0 හෝ 1). 1 = ඉහළ විභවය (ON), 0 = බිංදු විභවය (OFF)",
      problemText = "A = 1 සහ B = 0 වන අවස්ථාවේදී: 1. AND ද්වාරයක 2. OR ද්වාරයක 3. NAND ද්වාරයක ප්‍රතිදානයන් සොයන්න.",
      stepByStepSolution = listOf(
        "1. AND: Y = A · B = 1 · 0 = 0",
        "2. OR: Y = A + B = 1 + 0 = 1",
        "3. NAND: Y = (A · B)' = (1 · 0)' = 0' = 1"
      ),
      finalAnswer = "AND = 0, OR = 1, NAND = 1",
      units = "ද්විමය තත්ත්ව (0 / 1)",
      examTip = "AND ද්වාරයක ප්‍රතිදානය 1 වීමට සියලු ආදාන 1 විය යුතුය. OR ද්වාරයක එක් ආදානයක් හෝ 1 නම් ප්‍රතිදානය 1 වේ."
    )
  )
}
