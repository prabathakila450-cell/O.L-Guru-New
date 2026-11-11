package com.example

/**
 * 🌍 Grade 11 O/L Geography Bank (භූගෝල විද්‍යාව - 11 ශ්‍රේණිය)
 * Contains 200 distinct, syllabus-aligned oral exam questions across 10 sets of 20 questions each.
 * All questions are strictly short, factual, direct, non-formula, non-explanatory, and non-repeating.
 */
object VoiceQuizGeographyGrade11Bank {

  fun getQuestion(setNum: Int, qIndex: Int, theme: String): Quintuple<String, String, List<String>, String, String> {
    return when (setNum) {
      // Set 1: 1:50,000 භූලක්ෂණ සිතියම් කියවීම & සමෝච්ච රේඛා
      1 -> when (qIndex) {
        1 -> Quintuple("1:50,000 භූලක්ෂණ සිතියමක සම්මත සමෝච්ච අන්තරය මීටර් කීයද?", "Standard contour interval on 1:50,000 topographical map in meters?", listOf("20", "මීටර් 20", "20m"), "මීටර් 20කි (20 m).", "මීටර් 20යි.")
        2 -> Quintuple("සිතියමක සමෝච්ච රේඛා එකිනෙකට ඉතා ළඟින් පිහිටා තිබීමෙන් දැක්වෙන්නේ කුමන බෑවුමක්ද?", "Closely spaced contours indicate what slope?", listOf("දැඩි බෑවුම", "කಡಿದු බෑවුම", "Steep"), "දැඩි හෙවත් කಡಿದු බෑවුමකි.", "දැඩි බෑවුමයි.")
        3 -> Quintuple("සමෝච්ච රේඛා එකිනෙකට ඈතින් පිහිටා තිබීමෙන් දැක්වෙන්නේ කුමන බෑවුමක්ද?", "Widely spaced contours indicate what slope?", listOf("මෘදු බෑවුම", "මඳ බෑවුම", "Gentle"), "මෘදු හෙවත් මඳ බෑවුමකි.", "මෘදු බෑවුමයි.")
        4 -> Quintuple("සිතියමක නිශ්චිත උස ලක්ෂ්‍යයක් දක්වන ත්‍රිකෝණාකාර සංකේතය කුමක්ද?", "Triangular symbol marking precise trigonometrical station?", listOf("ත්‍රිකෝණමිතික ලක්ෂ්‍යය", "Trig point"), "ත්‍රිකෝණමිතික ලක්ෂ්‍යය (Trig Station) වේ.", "උස ලක්ෂ්‍යයයි.")
        5 -> Quintuple("සිතියම් නිර්මාණය කරන ශ්‍රී ලංකාවේ ප්‍රධාන රාජ්‍ය ආයතනය කුමක්ද?", "National survey authority creating maps in Sri Lanka?", listOf("මිනින්දෝරු දෙපාර්තමේන්තුව", "Survey Department"), "ශ්‍රී ලංකා මිනින්දෝරු දෙපාර්තමේන්තුව වේ.", "මිනින්දෝරු දෙපාර්තමේන්තුවයි.")
        6 -> Quintuple("1:50,000 සිතියමක සෙන්ටිමීටර 1කින් නියෝජනය වන භූමියේ සැබෑ දුර මීටර් කීයද?", "Actual distance represented by 1 cm on 1:50,000 map in meters?", listOf("500", "මීටර් 500", "500m"), "මීටර් 500ක් (කි.මී. 0.5ක්) වේ.", "මීටර් 500කි.")
        7 -> Quintuple("1:50,000 සිතියමක සෙන්ටිමීටර 2කින් දැක්වෙන භූමියේ සැබෑ දුර කිලෝමීටර කීයද?", "Actual ground distance represented by 2 cm on 1:50,000 map?", listOf("1", "කිලෝමීටර 1", "1km"), "කිලෝමීටර 1කි (1 km).", "කිලෝමීටර 1කි.")
        8 -> Quintuple("මුහුදු මට්ටමේ සිට සමාන උසකින් පිහිටි ලක්ෂ්‍ය යා කර අඳින රේඛා මොනවාද?", "Lines joining points of equal height above sea level?", listOf("සමෝච්ච රේඛා", "සමෝච්ච", "Contours"), "සමෝච්ච රේඛා (Contour lines) වේ.", "සමෝච්ච රේඛායි.")
        9 -> Quintuple("ගංගාවක නිම්නයක් හරහා සමෝච්ච රේඛා ගමන් කරන්නේ කුමන හැඩයටද?", "Shape of contour lines crossing a river valley?", listOf("V හැඩය", "V අකුරේ හැඩය"), "V හැඩයටය (උඩුගං දෙසට උල්ව).", "V හැඩයයි.")
        10 -> Quintuple("කඳුවැටියක් හෝ බෑවුමක් දිගේ සමෝච්ච රේඛා පිහිටන්නේ කුමන හැඩයටද?", "Shape of contours along a ridge or spur?", listOf("U හැඩය", "U අකුරේ හැඩය"), "U හැඩයටය (පහළ බෑවුම දෙසට).", "U හැඩයයි.")
        11 -> Quintuple("සමෝච්ච රේඛා කේන්ද්‍රගතව ඇතුළත රේඛාවල අගය වැඩි වන විට දැක්වෙන්නේ කුමක්ද?", "Concentric contours with values increasing towards center indicate?", listOf("කන්දක්", "කඳු මුදුනක්", "Hill"), "කන්දක් හෙවත් කඳු මුදුනකි.", "කඳු මුදුනකි.")
        12 -> Quintuple("සමෝච්ච රේඛා කේන්ද්‍රගතව ඇතුළත රේඛාවල අගය අඩු වන විට දැක්වෙන්නේ කුමක්ද?", "Concentric contours with values decreasing towards center indicate?", listOf("අවපාතයක්", "පල්ලමක්", "Depression"), "අවපාතයක් (Depression) වේ.", "අවපාතයකි.")
        13 -> Quintuple("සිතියමක ජල මාර්ග හා ජලාශ සාමාන්‍යයෙන් දක්වන්නේ කුමන වර්ණයෙන්ද?", "Color used to show water bodies on maps?", listOf("නිල්", "නිල් පැහැය", "Blue"), "නිල් පැහැයෙනි.", "නිල් පාටයි.")
        14 -> Quintuple("සිතියමක වනාන්තර සහ වගාවන් දක්වන්නේ කුමන වර්ණයෙන්ද?", "Color showing vegetation and forests?", listOf("කොළ", "කොළ පැහැය", "Green"), "කොළ පැහැයෙනි.", "කොළ පාටයි.")
        15 -> Quintuple("සිතියමක ප්‍රධාන මාර්ග සහ ගොඩනැගිලි දක්වන්නේ කුමන වර්ණයෙන්ද?", "Color showing roads and built-up areas?", listOf("රතු", "කළු", "Red"), "රතු හෝ කළු පැහැයෙනි.", "රතු පැහැයයි.")
        16 -> Quintuple("1:50,000 සිතියමක සම්මත කොටු දැලක එක් පැත්තක සැබෑ දුර කිලෝමීටර කීයද?", "Grid square side length on 1:50,000 map in km?", listOf("1", "කිලෝමීටර 1", "1km"), "කිලෝමීටර 1කි (1 km).", "කිලෝමීටර 1කි.")
        17 -> Quintuple("සිතියමක නිශ්චිත ස්ථානයක් හඳුනාගැනීමට දෙන ඉලක්කම් 6ක අගය කුමක්ද?", "Six figure coordinate identifying a map point?", listOf("ෂඩ් අංක ඛණ්ඩාංකය", "ෂඩ් අංකය"), "ෂඩ් අංක ඛණ්ඩාංකය (Six-figure grid reference) වේ.", "ෂඩ් අංකයයි.")
        18 -> Quintuple("සිතියමක සිරස්ව ඇති ජාල රේඛා හඳුන්වන්නේ කුමක් නමින්ද?", "Vertical grid lines on a map?", listOf("නැගෙනහිර රේඛා", "Eastings"), "නැගෙනහිර රේඛා (Eastings) නමිනි.", "නැගෙනහිර රේඛායි.")
        19 -> Quintuple("සිතියමක තිරස්ව ඇති ජාල රේඛා හඳුන්වන්නේ කුමක් නමින්ද?", "Horizontal grid lines on a map?", listOf("උතුරු රේඛා", "Northings"), "උතුරු රේඛා (Northings) නමිනි.", "උතුරු රේඛායි.")
        20 -> Quintuple("භූමියේ දැඩි බෑවුම් සහිත ගල් පර්වත සමෝච්ච සිතියමක දක්වන්නේ කෙසේද?", "Feature showing steep rock cliff on contour map?", listOf("ප්‍රපාත සංකේතය", "ප්‍රපාතය", "Cliff"), "ප්‍රපාත සංකේතය (Cliff) මඟිනි.", "ප්‍රපාතයයි.")
        else -> Quintuple("සමෝච්ච රේඛා එකිනෙක ඡේදනය නොවේද?", "Do contour lines not cross each other?", listOf("ඔව්", "එසේය"), "ඔව්, ප්‍රපාතයකදී හැර ඡේදනය නොවේ.", "ඔව් වේ.")
      }

      // Set 2: ලෝක සිතියම, දේශාංශ & සම්මත වේලා කලාප
      2 -> when (qIndex) {
        1 -> Quintuple("පෘථිවියේ ප්‍රධාන මධ්‍යහ්න රේඛාව (0° දේශාංශය) ගමන් කරන්නේ කුමන නගරය හරහාද?", "Through which city does the Prime Meridian (0° longitude) pass?", listOf("ග්‍රිනිච්", "ලන්ඩන්", "Greenwich"), "එංගලන්තයේ ග්‍රිනිච් (Greenwich) නගරය හරහාය.", "ග්‍රිනිච් නගරයයි.")
        2 -> Quintuple("දේශාංශ අංශක 15ක් අතර පවතින කාල වෙනස පැය කීයද?", "Time difference between 15 degrees of longitude?", listOf("පැය 1", "පැය එකයි", "1"), "පැය එකකි (පැය 1කි).", "පැය 1කි.")
        3 -> Quintuple("ජාත්‍යන්තර දින රේඛාව (IDL) පිහිටා ඇත්තේ කුමන දේශාංශයේද?", "At what longitude is the International Date Line located?", listOf("180", "180° දේශාංශය", "අංශක 180"), "අංශක 180 (180°) දේශාංශයේය.", "අංශක 180යි.")
        4 -> Quintuple("ශ්‍රී ලංකාවේ සම්මත වේලාව ග්‍රිනිච් වේලාවට (GMT) වඩා කොපමණ පෙරටුව තිබේද?", "How far ahead is Sri Lanka Standard Time compared to GMT?", listOf("පැය 5යි මිනිත්තු 30", "+5:30", "පැය පහමාරක්"), "පැය 5යි මිනිත්තු 30ක් (+5:30) පෙරටුව තිබේ.", "පැය පහමාරකි.")
        5 -> Quintuple("පෘථිවිය සම්පූර්ණ වේලා කලාප කීයකට බෙදා ඇත්ද?", "How many standard time zones is the Earth divided into?", listOf("24", "24ක්", "විසි හතරයි"), "සම්මත වේලා කලාප 24කටය.", "කලාප 24කි.")
        6 -> Quintuple("දේශාංශ අංශක 1ක් භ්‍රමණය වීමට පෘථිවියට ගතවන කාලය මිනිත්තු කීයද?", "Minutes taken by Earth to rotate 1 degree longitude?", listOf("මිනිත්තු 4", "4", "4ක්"), "මිනිත්තු 4කි (4 minutes).", "මිනිත්තු 4කි.")
        7 -> Quintuple("ග්‍රිනිච් රේඛාවෙන් නැගෙනහිරට ගමන් කරන විට වේලාව කුමක් කළ යුතුද?", "When moving east of Greenwich meridian, is time added or subtracted?", listOf("එකතු කළ යුතුය", "ඉදිරියට", "වැඩි වේ"), "වේලාව එකතු කළ යුතුය (වේලාව ඉදිරියෙනි).", "එකතු කළ යුතුය.")
        8 -> Quintuple("ග්‍රිනිච් රේඛාවෙන් බටහිරට ගමන් කරන විට වේලාව කුමක් කළ යුතුද?", "When moving west of Greenwich meridian, is time added or subtracted?", listOf("අඩු කළ යුතුය", "පසුපසට", "අඩු වේ"), "වේලාව අඩු කළ යුතුය (වේලාව පසුපසිනි).", "අඩු කළ යුතුය.")
        9 -> Quintuple("ලෝකයේ වැඩිම වේලා කලාප ගණනක් ඇති භූමි ප්‍රමාණයෙන් විශාල රට කුමක්ද?", "Country with largest number of time zones spanning its land?", listOf("රුසියාව", "Russia"), "රුසියාව (Russia - කලාප 11ක්) වේ.", "රුසියාවයි.")
        10 -> Quintuple("ජාත්‍යන්තර දින රේඛාව කෙළින් නොවී වක් වී ඇත්තේ ඇයි?", "Why is the International Date Line zigzagged?", listOf("දින පටලැවිලි වැළැක්වීමට", "එකම රටකට එකම දිනය"), "එකම දූපත් රටක දින පටලැවිලි වීම වැළැක්වීමටය.", "දින පටලැවිලි නොවීමටයි.")
        11 -> Quintuple("පෘථිවියේ අඳින ලද සම්පූර්ණ දේශාංශ රේඛා ගණන කීයද?", "Total number of longitude lines around Earth?", listOf("360", "360ක්"), "දේශාංශ රේඛා 360කි.", "360කි.")
        12 -> Quintuple("දේශාංශ රේඛා එකිනෙක හමුවන්නේ කුමන ස්ථානවලදීද?", "Where do longitude lines converge?", listOf("ධ්‍රැවවලදී", "උතුරු හා දකුණු ධ්‍රැව"), "උතුරු සහ දකුණු ධ්‍රැවවලදීය.", "ධ්‍රැවවලදීය.")
        13 -> Quintuple("රතු මුහුද සහ මධ්‍යධරණී මුහුද යා කරන මිනිසා හැදූ ඇළ මාර්ගය කුමක්ද?", "Man-made canal linking Red Sea and Mediterranean Sea?", listOf("සූවස් ඇළ", "Suez"), "සූවස් ඇළ (Suez Canal) වේ.", "සූවස් ඇළයි.")
        14 -> Quintuple("අත්ලාන්තික් සහ ශාන්තිකර සාගර යා කරන ප්‍රධාන ඇළ මාර්ගය කුමක්ද?", "Canal linking Atlantic and Pacific Oceans?", listOf("පැනමා ඇළ", "Panama"), "පැනමා ඇළ (Panama Canal) වේ.", "පැනමා ඇළයි.")
        15 -> Quintuple("මැලේසියාව සහ සුමාත්‍රා අතර ඇති ප්‍රධාන සමුද්‍ර සන්ධිය කුමක්ද?", "Major strait between Malaysia and Sumatra?", listOf("මලක්කා", "මලක්කා සමුද්‍ර සන්ධිය"), "මලක්කා සමුද්‍ර සන්ධිය (Strait of Malacca) වේ.", "මලක්කා සන්ධියයි.")
        16 -> Quintuple("මධ්‍යධරණී මුහුද සහ අත්ලාන්තික් සාගරය යා කරන සමුද්‍ර සන්ධිය කුමක්ද?", "Strait connecting Mediterranean Sea and Atlantic Ocean?", listOf("ජිබ්‍රෝල්ටා", "Gibraltar"), "ජිබ්‍රෝල්ටා සමුද්‍ර සන්ධිය වේ.", "ජිබ්‍රෝල්ටා සන්ධියයි.")
        17 -> Quintuple("ශ්‍රී ලංකාවේ සම්මත වේලාව තීරණය කර ඇත්තේ කුමන දේශාංශයට අනුවද?", "Longitude determining Sri Lanka Standard Time?", listOf("82.5", "82.5° නැගෙනහිර", "අංශක 82.5"), "නැගෙනහිර අංශක 82.5 දේශාංශයට අනුවය.", "82.5° E වේ.")
        18 -> Quintuple("ලෝක සිතියමක ප්‍රක්ෂේපණයක් යනු කුමක්ද?", "What is a map projection?", listOf("ගෝලාකාර පෘථිවිය තලයකට ගැනීම", "ප්‍රක්ෂේපණය"), "ගෝලාකාර පෘථිවිය තල සිතියමකට නිරූපණය කිරීමයි.", "තලයකට ඇඳීමයි.")
        19 -> Quintuple("නැව් යාත්‍රා කිරීමට බහුලව භාවිත කරන සිතියම් ප්‍රක්ෂේපණය කුමක්ද?", "Map projection widely used for navigation?", listOf("මර්කේටර්", "Mercator"), "මර්කේටර් ප්‍රක්ෂේපණය (Mercator projection) වේ.", "මර්කේටර් ක්‍රමයයි.")
        20 -> Quintuple("ලෝක සිතියමක අක්ෂාංශ හා දේශාංශ මඟින් සාදන දැල හඳුන්වන්නේ කෙසේද?", "Grid formed by latitudes and longitudes on map?", listOf("ඛණ්ඩාංක ජාලය", "ග්‍රැටිකියුලය"), "ඛණ්ඩාංක ජාලය හෙවත් ග්‍රැටිකියුලය නමිනි.", "ඛණ්ඩාංක ජාලයයි.")
        else -> Quintuple("දේශාංශ රේඛා අර්ධ වෘත්තාකාරද?", "Are longitude lines semi-circles?", listOf("ඔව්", "එසේය"), "ඔව්, ධ්‍රැවයේ සිට ධ්‍රැවයට අර්ධ වෘත්ත වේ.", "ඔව් වේ.")
      }

      // Set 3: ලෝකයේ ප්‍රධාන දේශගුණික කලාප
      3 -> when (qIndex) {
        1 -> Quintuple("වසර පුරාම ඉහළ උෂ්ණත්වයක් හා සෑම දිනකම පාහේ සංවහන වැසි ලැබෙන දේශගුණය කුමක්ද?", "Climate with high temp year-round and convectional rain almost daily?", listOf("සමක", "සමක දේශගුණය", "Equatorial"), "සමක දේශගුණය (Equatorial climate) වේ.", "සමක දේශගුණයයි.")
        2 -> Quintuple("ශීත ඍතුවේදී වැසි ලැබෙන අතර ගිම්හානය වියළි වන ප්‍රකට දේශගුණය කුමක්ද?", "Climate with mild wet winters and hot dry summers?", listOf("මධ්‍යධරණී", "මධ්‍යධරණී දේශගුණය", "Mediterranean"), "මධ්‍යධරණී දේශගුණය (Mediterranean climate) වේ.", "මධ්‍යධරණී දේශගුණයයි.")
        3 -> Quintuple("වසරේ වැඩි කාලයක් අයිස් හා හිමෙන් වැසුණු අතිශය ශීතල ධ්‍රැවාසන්න දේශගුණය කුමක්ද?", "Extremely cold polar climate covered in snow most of the year?", listOf("ටුන්ඩ්‍රා", "Tundra"), "ටුන්ඩ්‍රා දේශගුණය (Tundra climate) වේ.", "ටුන්ඩ්‍රා දේශගුණයයි.")
        4 -> Quintuple("මෝසම් සුළං මඟින් ප්‍රධාන වශයෙන් වැසි ලබන ලෝක කලාපය කුමක්ද?", "World region mainly receiving rain from monsoon winds?", listOf("දකුණු ආසියාව", "ආසියාව", "South Asia"), "දකුණු හා අග්නිදිග ආසියාව වේ.", "දකුණු ආසියාවයි.")
        5 -> Quintuple("ලෝකයේ විශාලතම උණුසුම් කාන්තාර දේශගුණය ඇත්තේ කුමන මහාද්වීපයේද?", "Continent having the largest hot desert climate?", listOf("අප්‍රිකාව", "Africa"), "අප්‍රිකා මහාද්වීපයේ (සහරා) වේ.", "අප්‍රිකාවේය.")
        6 -> Quintuple("සමක දේශගුණ කලාපයේ සාමාන්‍ය වාර්ෂික උෂ්ණත්වය සෙල්සියස් කීයද?", "Average annual temperature in equatorial climate?", listOf("27", "27°C", "28°C"), "සෙල්සියස් අංශක 27°C පමණ වේ.", "27°C පමණ වේ.")
        7 -> Quintuple("සමක දේශගුණ කලාපයේ වාර්ෂික උෂ්ණත්ව පරාසය විශාලද කුඩාද?", "Is annual temperature range large or small in equatorial zone?", listOf("කුඩා", "ඉතා කුඩා", "Small"), "ඉතා කුඩා වේ (සෙල්සියස් 2°C - 3°C පමණ).", "කුඩා වේ.")
        8 -> Quintuple("උණුසුම් කාන්තාරවල දහවල් සහ රාත්‍රී උෂ්ණත්ව පරාසය විශාලද?", "Is diurnal temperature range high in hot deserts?", listOf("ඔව්", "විශාලයි", "විශාල වේ"), "ඔව්, දහවල දැඩි රස්නයක්ද රාත්‍රිය ශීතලද වේ.", "විශාල වේ.")
        9 -> Quintuple("මධ්‍යධරණී දේශගුණය තුළ බහුලව හැදෙන පලතුරු විශේෂයක් නම් කරන්න.", "Fruit crop typical of Mediterranean climate?", listOf("මිදි", "ඔලිව්", "දොඩම්", "ලෙමන්"), "මිදි, ඔලිව්, දොඩම් හෝ අත්තික්කා වේ.", "මිදි / ඔලිව් වේ.")
        10 -> Quintuple("ලෝකයේ වාර්තාගත අඩුම ස්වභාවික උෂ්ණත්වය වාර්තා වන මහාද්වීපය කුමක්ද?", "Continent with lowest recorded natural temperature?", listOf("ඇන්ටාක්ටිකාව", "Antarctica"), "ඇන්ටාක්ටිකාව (Antarctica - වොස්ටොක්) වේ.", "ඇන්ටාක්ටිකාවයි.")
        11 -> Quintuple("උෂ්ණ කලාපීය සුළි සුළං බටහිර ඉන්දීය කොදෙව් දූපත්වල හඳුන්වන්නේ කෙසේද?", "Tropical cyclones called in West Indies and Caribbean?", listOf("හරිකේන්", "Hurricane"), "හරිකේන් (Hurricane) නමිනි.", "හරිකේන් වේ.")
        12 -> Quintuple("පැසිෆික් සාගරයේ සහ නැගෙනහිර ආසියාවේ හටගන්නා සුළි සුළං කුමක්ද?", "Tropical cyclones in NW Pacific and East Asia?", listOf("ටයිෆූන්", "Typhoon"), "ටයිෆූන් (Typhoon) නමිනි.", "ටයිෆූන් වේ.")
        13 -> Quintuple("ඕස්ට්‍රේලියාව අවට සාගරයේ ඇතිවන සුළි සුළං හඳුන්වන්නේ කෙසේද?", "Tropical cyclones around Australia?", listOf("විලී විලී", "Willy willy"), "විලී විලී (Willy-willy) නමිනි.", "විලී විලී නමිනි.")
        14 -> Quintuple("ඇමරිකාවේ ගොඩබිම හරහා හමන ප්‍රචණ්ඩ පුනීල හැඩැති සුළි සුළඟ කුමක්ද?", "Violent funnel-shaped windstorm on US mainland?", listOf("ටෝනාඩෝ", "Tornado"), "ටෝනාඩෝ (Tornado) සුළි සුළඟ වේ.", "ටෝනාඩෝ වේ.")
        15 -> Quintuple("බටහිර යුරෝපයට ලැබෙන්නේ කුමන ආකාරයේ දේශගුණයක්ද?", "Climate type experienced in Western Europe?", listOf("සෞම්‍ය බටහිර වෙරළ", "සෞම්‍ය දේශගුණය"), "සෞම්‍ය බටහිර වෙරළබඩ දේශගුණය වේ.", "සෞම්‍ය දේශගුණයයි.")
        16 -> Quintuple("ලෝක දේශගුණ වර්ගීකරණයක් ඉදිරිපත් කළ සුප්‍රකට ජර්මානු විද්‍යාඥයා කවුද?", "German climatologist who devised world climate classification?", listOf("කොපන්", "ව්ලැදිමීර් කොපන්", "Köppen"), "ව්ලැදිමීර් කොපන් (Wladimir Köppen) වේ.", "කොපන් වේ.")
        17 -> Quintuple("වසරේ මාස 6ක් අඛණ්ඩව දිවා කාලය පවතින කලාපය කුමක්ද?", "Region having 6 months continuous daylight?", listOf("ධ්‍රැවීය කලාපය", "ධ්‍රැව ප්‍රදේශ"), "ධ්‍රැවීය කලාපය (Polar region) වේ.", "ධ්‍රැවීය කලාපයයි.")
        18 -> Quintuple("පැසිෆික් සාගර ජලය අසාමාන්‍ය ලෙස රත්වීම නිසා කාලගුණය වෙනස් වන සංසිද්ධිය කුමක්ද?", "Abnormal warming of Pacific waters altering global weather?", listOf("එල්නිනෝ", "El Nino"), "එල්නිනෝ (El Niño) සංසිද්ධිය වේ.", "එල්නිනෝයි.")
        19 -> Quintuple("පැසිෆික් සාගර ජලය අධික ලෙස සිසිල් වීම නිසා ඇතිවන සංසිද්ධිය කුමක්ද?", "Abnormal cooling of Pacific waters?", listOf("ලානිනා", "La Nina"), "ලානිනා (La Niña) සංසිද්ධිය වේ.", "ලානිනායි.")
        20 -> Quintuple("ලෝකයේ වැඩිම වාර්ෂික වර්ෂාපතනයක් ලබන ඉන්දියාවේ ප්‍රදේශය කුමක්ද?", "Place with highest annual rainfall in India?", listOf("මවුසින්රාම්", "Mawsynram", "චෙරපුංජි"), "මවුසින්රාම් (Mawsynram) වේ.", "මවුසින්රාම් වේ.")
        else -> Quintuple("දේශගුණය යනු වසර 30ක පමණ කාලගුණයේ සාමාන්‍ය තත්ත්වයද?", "Is climate the 30-year average of weather?", listOf("ඔව්", "එසේය"), "ඔව්, වසර 30කට වැඩි සාමාන්‍යයයි.", "ඔව් වේ.")
      }

      // Set 4: ලෝක ස්වභාවික වෘක්ෂලතා
      4 -> when (qIndex) {
        1 -> Quintuple("ඇමසන් නිම්නයේ පිහිටි ඝන නිවර්තන වැසි වනාන්තර හඳුන්වන විශේෂ නම කුමක්ද?", "Special name for Amazon equatorial rainforests?", listOf("සෙල්වා", "Selvas"), "සෙල්වා (Selvas) වනාන්තර නමිනි.", "සෙල්වා වනාන්තරයි.")
        2 -> Quintuple("උත්තර අර්ධගෝලයේ දැව කර්මාන්තයට සුදුසු කේතුධර සදාහරිත වනාන්තර හඳුන්වන්නේ කෙසේද?", "Boreal coniferous evergreen forest in northern hemisphere?", listOf("ටයිගා", "Taiga"), "ටයිගා (Taiga / Boreal Forest) නමිනි.", "ටයිගා වනාන්තරයි.")
        3 -> Quintuple("අප්‍රිකාවේ පිහිටි උස තෘණ සහිත නිවර්තන තෘණභූමි හඳුන්වන්නේ කෙසේද?", "Tropical grasslands with tall grass in Africa?", listOf("සැවානා", "Savanna"), "සැවානා (Savanna) තෘණභූමි නමිනි.", "සැවානාවයි.")
        4 -> Quintuple("උතුරු ඇමරිකාවේ පිහිටි සෞම්‍ය කලාපීය තෘණභූමි හඳුන්වන්නේ කෙසේද?", "Temperate grasslands of North America?", listOf("ප්‍රෙයාරී", "Prairies"), "ප්‍රෙයාරී (Prairies) තෘණභූමි නමිනි.", "ප්‍රෙයාරී තෘණභූමියි.")
        5 -> Quintuple("යුරේසියාවේ (රුසියාව/යුක්‍රේනය) පිහිටි සෞම්‍ය තෘණභූමි හඳුන්වන්නේ කෙසේද?", "Temperate grasslands in Eurasia?", listOf("ස්ටෙප්ස්", "Steppes"), "ස්ටෙප්ස් (Steppes) තෘණභූමි නමිනි.", "ස්ටෙප්ස් තෘණභූමියි.")
        6 -> Quintuple("දකුණු ඇමරිකාවේ ආර්ජන්ටිනාවේ පිහිටි සෞම්‍ය තෘණභූමි හඳුන්වන්නේ කෙසේද?", "Temperate grasslands in Argentina, South America?", listOf("පම්පාස්", "Pampas"), "පම්පාස් (Pampas) තෘණභූමි නමිනි.", "පම්පාස් තෘණභූමියි.")
        7 -> Quintuple("දකුණු අප්‍රිකාවේ සෞම්‍ය තෘණභූමි හඳුන්වන නම කුමක්ද?", "Temperate grasslands in South Africa?", listOf("වෙල්ඩ්", "Veld"), "වෙල්ඩ් (Veld) තෘණභූමි නමිනි.", "වෙල්ඩ් තෘණභූමියි.")
        8 -> Quintuple("ඕස්ට්‍රේලියාවේ පිහිටි සෞම්‍ය තෘණභූමි හඳුන්වන්නේ කෙසේද?", "Temperate grasslands of Australia?", listOf("ඩවුන්ස්", "Downs"), "ඩවුන්ස් (Downs) තෘණභූමි නමිනි.", "ඩවුන්ස් තෘණභූමියි.")
        9 -> Quintuple("කේතුධර වනාන්තරවල වැඩෙන ප්‍රධාන දැවමය ශාකයක් නම් කරන්න.", "Main softwood tree in coniferous forests?", listOf("පයින්", "ෆර්", "ස්පෲස්", "Pine"), "පයින් (Pine), ෆර් හෝ ස්පෲස් ගස වේ.", "පයින් ගසයි.")
        10 -> Quintuple("නිවර්තන වැසි වනාන්තරවල ගස්වල ස්වභාවය කුමක්ද?", "Characteristics of trees in tropical rainforests?", listOf("සදාහරිත", "වියන් ස්ථර", "දැවමය"), "සදාහරිත, දැවමය හා බහු ස්ථර වියන් සහිතය.", "සදාහරිත හා ඝනයි.")
        11 -> Quintuple("කඩොලාන වනාන්තර ස්වභාවිකව පිහිටන්නේ කුමන පරිසරයේද?", "Where do mangrove forests naturally grow?", listOf("කලපු", "වෙරළබඩ", "මෝය ආශ්‍රිතව"), "කරදිය හා මිරිදිය මුසුවන වෙරළබඩ කලපුවලයි.", "කලපු ආශ්‍රිතවයි.")
        12 -> Quintuple("කාන්තාර ශාකවල ජලය වාෂ්පීභවනය අවම කරගැනීමට ඇති අනුවර්තනයක් කුමක්ද?", "Adaptation of desert plants to reduce water loss?", listOf("පත්‍ර කටු බවට පත්වීම", "කටු", "ඉටි ස්ථරය"), "පත්‍ර කටු බවට පත්වීම හෝ ඉටි ස්ථරයක් පැවතීමයි.", "පත්‍ර කටු වීමයි.")
        13 -> Quintuple("පතොක් ශාකය කුමන දේශගුණික පරිසරයකට අනුවර්තනය වූ ශාකයක්ද?", "Cactus is adapted to which climate?", listOf("කාන්තාර", "වියළි කලාපය", "Desert"), "උණුසුම් කාන්තාර පරිසරයටය.", "කාන්තාරයටයි.")
        14 -> Quintuple("ටුන්ඩ්‍රා ප්‍රදේශයේ දැකිය හැකි ශාක විශේෂ මොනවාද?", "Vegetation found in frozen Tundra?", listOf("ලයිකන", "පාසි", "Mosses", "Lichens"), "ලයිකන සහ පාසි (Mosses and Lichens) වේ.", "ලයිකන සහ පාසියි.")
        15 -> Quintuple("ලෝකයේ ඔක්සිජන් නිෂ්පාදනයට විශාල දායකත්වයක් දෙන ඇමසන් වනය හඳුන්වන්නේ කෙසේද?", "Amazon forest is famously referred to as what?", listOf("පෘථිවියේ පෙණහලු", "Lungs of the earth"), "පෘථිවියේ පෙණහලු (Lungs of the Earth) නමිනි.", "පෘථිවියේ පෙණහලුයි.")
        16 -> Quintuple("සැවානා තෘණභූමිවල බහුලව වෙසෙන විශාල සත්ත්වයෙකු නම් කරන්න.", "Large animal common in African savanna?", listOf("සීබ්‍රා", "ජිරාෆ්", "සිංහයා", "අලියා"), "සීබ්‍රා, ජිරාෆ්, සිංහයා හෝ අලියා වේ.", "සීබ්‍රා / ජිරාෆ් වේ.")
        17 -> Quintuple("කේතුධර වනාන්තරවල දැව කපා කඩදාසි සෑදීම හඳුන්වන්නේ කුමක් නමින්ද?", "Industry using softwoods to make paper?", listOf("දැව පල්ප කර්මාන්තය", "කඩදාසි කර්මාන්තය"), "දැව පල්ප හා කඩදාසි කර්මාන්තයයි.", "දැව පල්ප කර්මාන්තයයි.")
        18 -> Quintuple("ශීත ඍතුවේදී පත්‍ර හැලෙන සෞම්‍ය වනාන්තර හඳුන්වන්නේ කෙසේද?", "Forests that shed leaves in winter?", listOf("පතනශීලී වනාන්තර", "Deciduous"), "පතනශීලී වනාන්තර (Deciduous forests) නමිනි.", "පතනශීලී වනාන්තරයි.")
        19 -> Quintuple("යුකැලිප්ටස් ශාකය බහුලව ස්වභාවිකව වැඩෙන්නේ කුමන මහාද්වීපයේද?", "Continent where Eucalyptus is native and abundant?", listOf("ඕස්ට්‍රේලියාව", "Australia"), "ඕස්ට්‍රේලියා මහාද්වීපයේය.", "ඕස්ට්‍රේලියාවේය.")
        20 -> Quintuple("වන විනාශය නිසා ලෝකයේ ජෛව විවිධත්වය අහිමි වේද?", "Does deforestation cause biodiversity loss?", listOf("ඔව්", "එසේය"), "ඔව්, සත්ත්ව හා ශාක විශේෂ වඳ වී යයි.", "ඔව් වේ.")
        else -> Quintuple("ස්වභාවික වෘක්ෂලතා දේශගුණය මත තීරණය වේද?", "Is natural vegetation determined by climate?", listOf("ඔව්", "එසේය"), "ඔව්, උෂ්ණත්වය හා වැසි මත තීරණය වේ.", "ඔව් වේ.")
      }

      // Set 5: ලෝක කෘෂිකර්මාන්තය & ධාන්‍ය
      5 -> when (qIndex) {
        1 -> Quintuple("ලෝකයේ ප්‍රධානතම ආහාර බෝග දෙක මොනවාද?", "Two primary staple food crops of the world?", listOf("වී සහ තිරිඟු", "සහල් සහ තිරිඟු", "Rice and Wheat"), "වී (සහල්) සහ තිරිඟු වේ.", "වී සහ තිරිඟුයි.")
        2 -> Quintuple("ලෝකයේ වැඩිම සහල් නිෂ්පාදනය කරන රට කුමක්ද?", "Largest rice producing country?", listOf("චීනය", "China"), "චීනය (සහ ඉන්දියාව) වේ.", "චීනයයි.")
        3 -> Quintuple("උතුරු ඇමරිකාවේ 'ලෝකයේ පාන් බඳුන' ලෙස හඳුන්වන්නේ කුමන කලාපයද?", "Region known as 'Breadbasket of the World'?", listOf("ප්‍රෙයාරී", "ප්‍රෙයාරී තිරිඟු කලාපය"), "ප්‍රෙයාරී තිරිඟු කලාපයයි.", "ප්‍රෙයාරී කලාපයයි.")
        4 -> Quintuple("විශාල ඉඩම්වල තනි බෝගයක් වාණිජව වගා කිරීම හඳුන්වන්නේ කෙසේද?", "Cultivation of single cash crop on large estates?", listOf("වැවිලි කෘෂිකර්මාන්තය", "Plantation"), "වැවිලි කෘෂිකර්මාන්තය (Plantation agriculture) නමිනි.", "වැවිලි ගොවිතැනයි.")
        5 -> Quintuple("තිරිඟු වගාවට වඩාත්ම සුදුසු දේශගුණය කුමක්ද?", "Climate most suitable for wheat cultivation?", listOf("සෞම්‍ය දේශගුණය", "සෞම්‍ය කලාපීය"), "සෞම්‍ය කලාපීය දේශගුණය වේ.", "සෞම්‍ය දේශගුණයයි.")
        6 -> Quintuple("වී වගාවට අවශ්‍ය ප්‍රධාන පස් වර්ගය කුමක්ද?", "Soil type essential for paddy farming?", listOf("මැටි පස", "ඇලූවියල් පස", "කුඹුරු මැටි"), "මැටි සහිත ඇලූවියල් පස වේ.", "මැටි පසයි.")
        7 -> Quintuple("ලෝකයේ වැඩිම තේ නිෂ්පාදනය කරන රට කුමක්ද?", "Largest tea producing country in the world?", listOf("චීනය", "China"), "චීනය (China) වේ.", "චීනයයි.")
        8 -> Quintuple("කළු තේ (Black Tea) අපනයනයෙන් ලොව පෙරමුණ ගත් රටක් නම් කරන්න.", "Leading black tea exporting country?", listOf("ශ්‍රී ලංකාව", "කෙන්යාව", "Sri Lanka"), "ශ්‍රී ලංකාව හෝ කෙන්යාව වේ.", "ශ්‍රී ලංකාව / කෙන්යාවයි.")
        9 -> Quintuple("ලෝකයේ වැඩිම කෝපි නිෂ්පාදනය කරන රට කුමක්ද?", "Largest coffee producing country in the world?", listOf("බ්‍රසීලය", "Brazil"), "බ්‍රසීලය (Brazil) වේ.", "බ්‍රසීලයයි.")
        10 -> Quintuple("ලෝකයේ වැඩිම උක් (සීනි) නිෂ්පාදනය කරන රට කුමක්ද?", "Largest sugarcane producing country?", listOf("බ්‍රසීලය", "ඉන්දියාව", "Brazil"), "බ්‍රසීලය (සහ ඉන්දියාව) වේ.", "බ්‍රසීලයයි.")
        11 -> Quintuple("ස්වභාවික රබර් වැඩිම ප්‍රමාණයක් නිපදවන ප්‍රමුඛ රටක් නම් කරන්න.", "Leading natural rubber producing country?", listOf("තායිලන්තය", "ඉන්දුනීසියාව", "Thailand"), "තායිලන්තය හෝ ඉන්දුනීසියාව වේ.", "තායිලන්තයයි.")
        12 -> Quintuple("පාම් තෙල් (Palm Oil) නිෂ්පාදනයෙන් ලොව මුල් තැන ගත් රට කුමක්ද?", "Leading palm oil producing country?", listOf("ඉන්දුනීසියාව", "මැලේසියාව", "Indonesia"), "ඉන්දුනීසියාව (සහ මැලේසියාව) වේ.", "ඉන්දුනීසියාවයි.")
        13 -> Quintuple("තමන්ගේ පරිභෝජනය සඳහා පමණක් ගොවිතැන් කිරීම හඳුන්වන්නේ කෙසේද?", "Farming solely for household consumption?", listOf("යැපුම් කෘෂිකර්මාන්තය", "යැපුම් ගොවිතැන"), "යැපුම් කෘෂිකර්මාන්තය (Subsistence farming) නමිනි.", "යැපුම් ගොවිතැනයි.")
        14 -> Quintuple("ලාභ ඉපැයීමේ අරමුණින් වෙළඳපොළ ඉලක්ක කරගත් ගොවිතැන කුමක්ද?", "Farming aimed at market profit on large scale?", listOf("වාණිජ කෘෂිකර්මාන්තය", "වාණිජ ගොවිතැන"), "වාණිජ කෘෂිකර්මාන්තය (Commercial farming) නමිනි.", "වාණිජ ගොවිතැනයි.")
        15 -> Quintuple("සතුන් ඇති කිරීම සහ බෝග වගාව එකවර කිරීම හඳුන්වන්නේ කෙසේද?", "Farming combining crop cultivation and livestock?", listOf("මිශ්‍ර ගොවිතැන", "Mixed farming"), "මිශ්‍ර ගොවිතැන (Mixed farming) නමිනි.", "මිශ්‍ර ගොවිතැනයි.")
        16 -> Quintuple("ගොවිපළේ බෝග මාරු කරමින් වගා කිරීම හඳුන්වන්නේ කෙසේද?", "Growing different crops sequentially on same land?", listOf("බෝග මාරුව", "Crop rotation"), "බෝග මාරුව (Crop rotation) නමිනි.", "බෝග මාරුවයි.")
        17 -> Quintuple("1960 දශකයේ නව බීජ හඳුන්වාදී ආහාර නිෂ්පාදනය වැඩි කළ ක්‍රියාවලිය කුමක්ද?", "1960s agricultural leap using high-yield seeds?", listOf("හරිත විප්ලවය", "Green Revolution"), "හරිත විප්ලවය (Green Revolution) වේ.", "හරිත විප්ලවයයි.")
        18 -> Quintuple("හරිත විප්ලවයේ පියා ලෙස සැලකෙන සම්මානනීය විද්‍යාඥයා කවුද?", "Scientist known as the father of Green Revolution?", listOf("නෝමන් බෝලොග්", "Norman Borlaug"), "නෝමන් බෝලොග් (Norman Borlaug) වේ.", "නෝමන් බෝලොග්ය.")
        19 -> Quintuple("පස නැතිව ජලීය පෝෂක ද්‍රාවණ මඟින් ශාක වගා කිරීම හඳුන්වන්නේ කෙසේද?", "Growing plants without soil using nutrient water?", listOf("හයිඩ්‍රොපොනික්ස්", "Hydroponics"), "හයිඩ්‍රොපොනික්ස් (Hydroponics) නමිනි.", "හයිඩ්‍රොපොනික්ස් වේ.")
        20 -> Quintuple("කෘමිනාශක හා රසායනික පොහොර භාවිත නොකරන වගාව කුමක්ද?", "Agriculture without chemical fertilizers or pesticides?", listOf("කාබනික ගොවිතැන", "කාබනික කෘෂිකර්මය"), "කාබනික ගොවිතැන (Organic farming) වේ.", "කාබනික ගොවිතැනයි.")
        else -> Quintuple("කෘෂිකර්මාන්තය ලෝකයේ මුල්ම ශිෂ්ටාචාර බිහිවීමට මුල් වූවාද?", "Did agriculture lead to early civilizations?", listOf("ඔව්", "එසේය"), "ඔව්, ගංගා නිම්න ශිෂ්ටාචාර බිහිවිය.", "ඔව් වේ.")
      }

      // Set 6: ලෝක ඛනිජ තෙල් & බලශක්ති
      6 -> when (qIndex) {
        1 -> Quintuple("ලෝකයේ ඛනිජ තෙල් අපනයනය කරන රටවල සංවිධානය කුමක්ද?", "Organization of Petroleum Exporting Countries?", listOf("OPEC", "ඔපෙක්"), "OPEC (ඔපෙක් සංවිධානය) වේ.", "OPEC සංවිධානයයි.")
        2 -> Quintuple("ලෝකයේ විශාලතම ඛනිජ තෙල් සංචිත පිහිටි කලාපය කුමක්ද?", "World region with the largest crude oil reserves?", listOf("මැදපෙරදිග", "Middle East"), "මැදපෙරදිග කලාපය වේ.", "මැදපෙරදිග කලාපයයි.")
        3 -> Quintuple("මැදපෙරදිග වැඩිම ඛනිජ තෙල් නිපදවන ප්‍රධාන රටක් නම් කරන්න.", "Leading oil producing country in the Middle East?", listOf("සෞදි අරාබිය", "Saudi Arabia"), "සෞදි අරාබිය (Saudi Arabia) වේ.", "සෞදි අරාබියයි.")
        4 -> Quintuple("බොරතෙල් පිරිපහදු කිරීමේදී ලැබෙන ප්‍රධාන ඉන්ධන මොනවාද?", "Main refined fuel products from crude oil?", listOf("පෙට්‍රල් ඩීසල්", "පෙට්‍රල්", "ඩීසල්", "භූමිතෙල්"), "පෙට්‍රල්, ඩීසල්, භූමිතෙල් සහ දැවිතෙල් වේ.", "පෙට්‍රල් සහ ඩීසල්ය.")
        5 -> Quintuple("ලෝකයේ ප්‍රධාන ගල් අඟුරු නිධි පිහිටි රටක් නම් කරන්න.", "Major coal producing country in the world?", listOf("චීනය", "ඇමරිකාව", "ඉන්දියාව", "China"), "චීනය, ඇමරිකාව හෝ ඉන්දියාව වේ.", "චීනය / ඇමරිකාවයි.")
        6 -> Quintuple("න්‍යෂ්ටික බලශක්තිය නිපදවීමට ගන්නා ප්‍රධාන විකිරණශීලී ඛනිජය කුමක්ද?", "Radioactive mineral used for nuclear power?", listOf("යුරේනියම්", "Uranium"), "යුරේනියම් (Uranium) වේ.", "යුරේනියම් වේ.")
        7 -> Quintuple("පෘථිවි අභ්‍යන්තර තාපයෙන් නිපදවන පිරිසිදු විදුලිය කුමක්ද?", "Electricity produced from Earth's internal heat?", listOf("භූතාපජ විදුලිය", "භූතාප ශක්තිය", "Geothermal"), "භූතාපජ විදුලිය (Geothermal power) වේ.", "භූතාපජ විදුලියයි.")
        8 -> Quintuple("මුහුදු රළ හා වඩදිය බාදිය මඟින් නිපදවන බලශක්තිය කුමක්ද?", "Energy harnessed from ocean tides?", listOf("උදම් බලශක්තිය", "Tidal energy"), "උදම් බලශක්තිය (Tidal power) වේ.", "උදම් බලශක්තියයි.")
        9 -> Quintuple("සූර්ය කෝෂ මඟින් සෘජුවම විදුලිය නිපදවීම හඳුන්වන්නේ කෙසේද?", "Generating electricity directly from sunlight cells?", listOf("සූර්ය ප්‍රකාශ වෝල්ටීයතා", "Solar PV"), "සූර්ය ප්‍රකාශ වෝල්ටීයතා (Solar PV) පද්ධති නමිනි.", "සූර්ය කෝෂ මඟිනි.")
        10 -> Quintuple("ස්වභාවික වායුවල ප්‍රධාන වශයෙන් අඩංගු හයිඩ්‍රොකාබන් වායුව කුමක්ද?", "Main hydrocarbon gas present in natural gas?", listOf("මීතේන්", "Methane", "CH4"), "මීතේන් (CH₄) වායුව වේ.", "මීතේන් වායුවයි.")
        11 -> Quintuple("තෙල් ප්‍රවාහනය සඳහා සාගරයේ භාවිත කරන දැවැන්ත නෞකා මොනවාද?", "Giant ships transporting crude oil across oceans?", listOf("තෙල් නැව්", "Oil Tankers", "ටැංකි නැව්"), "තෙල් ටැංකි නෞකා (Oil Tankers) වේ.", "තෙල් ටැංකි නැව්ය.")
        12 -> Quintuple("ගොඩබිම හරහා තෙල් සහ ගෑස් ප්‍රවාහනය කරන පද්ධති මොනවාද?", "Overland conduit systems carrying oil and gas?", listOf("නල මාර්ග", "Pipelines"), "නල මාර්ග (Pipelines) වේ.", "නල මාර්ගයි.")
        13 -> Quintuple("හෝමුස් සමුද්‍ර සන්ධිය තෙල් ප්‍රවාහනයට ලෝකයේ වැදගත්ම සමුද්‍ර සන්ධියක්ද?", "Is Strait of Hormuz a vital world oil chokepoint?", listOf("ඔව්", "එසේය"), "ඔව්, පර්සියානු බොක්කේ තෙල් පිටවන මාවතයි.", "ඔව් වේ.")
        14 -> Quintuple("ඛනිජ තෙල් යනු ඉක්මනින් අවසන් විය හැකි පුනර්ජනනීය නොවන බලශක්තියක්ද?", "Is petroleum a non-renewable finite energy source?", listOf("ඔව්", "එසේය"), "ඔව්, සීමිත පොසිල ඉන්ධනයකි.", "ඔව් වේ.")
        15 -> Quintuple("විදුලි වාහන (EV) භාවිතය මඟින් තෙල් පරිභෝජනය අඩු කළ හැකිද?", "Does electric vehicle use reduce oil consumption?", listOf("ඔව්", "එසේය"), "ඔව්, ඛනිජ තෙල් පරිභෝජනය අවම වේ.", "ඔව් වේ.")
        16 -> Quintuple("ලෝකයේ විශාලතම ජල විදුලි වේල්ල කුමක්ද?", "World's largest hydroelectric dam project?", listOf("තුන් දුර්ග වේල්ල", "Three Gorges Dam"), "චීනයේ තුන් දුර්ග වේල්ල (Three Gorges Dam) වේ.", "තුන් දුර්ග වේල්ලයි.")
        17 -> Quintuple("සුළං බලයෙන් වැඩිම විදුලිය නිපදවන ලෝකයේ ප්‍රමුඛ රටක් නම් කරන්න.", "Leading country in wind energy generation?", listOf("චීනය", "ඩෙන්මාර්කය", "ඇමරිකාව", "China"), "චීනය, ඩෙන්මාර්කය හෝ ඇමරිකාව වේ.", "චීනය / ඩෙන්මාර්කයයි.")
        18 -> Quintuple("ජීව වායුව (Biogas) නිපදවීමට ප්‍රධාන වශයෙන් යොදාගන්නේ මොනවාද?", "Primary inputs used to produce biogas?", listOf("සත්ත්ව අපද්‍රව්‍ය", "ගොම", "කාබනික අපද්‍රව්‍ය"), "ගව ගොම සහ කාබනික අපද්‍රව්‍ය වේ.", "සත්ත්ව අපද්‍රව්‍යයි.")
        19 -> Quintuple("පොසිල ඉන්ධන දහනය නිසා වායුගෝලයට එකතු වන ප්‍රධාන වායුව කුමක්ද?", "Main gas emitted from burning fossil fuels?", listOf("කාබන් ඩයොක්සයිඩ්", "CO2"), "කාබන් ඩයොක්සයිඩ් (CO₂) වායුව වේ.", "කාබන් ඩයොක්සයිඩ්ය.")
        20 -> Quintuple("හරිත හයිඩ්‍රජන් යනු ශුන්‍ය විමෝචනයක් සහිත පිරිසිදු අනාගත ඉන්ධනයක්ද?", "Is green hydrogen a zero-emission clean future fuel?", listOf("ඔව්", "එසේය"), "ඔව්, පිරිසිදු බලශක්ති ප්‍රභවයකි.", "ඔව් වේ.")
        else -> Quintuple("සූර්ය ශක්තිය නොමිලේ ලැබෙන අසීමිත සම්පතක්ද?", "Is solar energy a free infinite resource?", listOf("ඔව්", "එසේය"), "ඔව්, අසීමිත පුනර්ජනනීය සම්පතකි.", "ඔව් වේ.")
      }

      // Set 7: ලෝක කාර්මික කලාප & ප්‍රධාන කර්මාන්ත
      7 -> when (qIndex) {
        1 -> Quintuple("ජර්මනියේ පිහිටි ලෝප්‍රකට යකඩ හා වානේ කාර්මික නිම්නය කුමක්ද?", "World-famous coal and steel industrial basin in Germany?", listOf("රූර් නිම්නය", "Ruhr"), "රූර් නිම්නය (Ruhr Valley) වේ.", "රූර් නිම්නයයි.")
        2 -> Quintuple("මෝටර් රථ කර්මාන්තයට ප්‍රකට ඇමරිකාවේ ඩිට්‍රොයිට් නගරය පිහිටියේ කුමන කලාපයේද?", "Region of US where Detroit motor city is located?", listOf("මහා විල් කලාපය", "Great Lakes"), "මහා විල් (Great Lakes) කාර්මික කලාපයේය.", "මහා විල් කලාපයයි.")
        3 -> Quintuple("ඇමරිකාවේ තොරතුරු තාක්ෂණ හා පරිගණක සමාගම් පිරි ප්‍රකට නිම්නය කුමක්ද?", "World famous high-tech computing valley in California?", listOf("සිලිකන් නිම්නය", "Silicon Valley"), "සිලිකන් නිම්නය (Silicon Valley) වේ.", "සිලිකන් නිම්නයයි.")
        4 -> Quintuple("ජපානයේ ප්‍රධානතම කාර්මික කලාපයක් නම් කරන්න.", "Major industrial region in Japan?", listOf("කන්ටෝ", "කින්කි", "ටෝකියෝ", "Kanto"), "කන්ටෝ (ටෝකියෝ) හෝ කින්කි (ඔසාකා) වේ.", "කන්ටෝ කලාපයයි.")
        5 -> Quintuple("ලෝකයේ ඇඟලුම් නිෂ්පාදනයේ ප්‍රමුඛ ආසියානු රටක් නම් කරන්න.", "Leading Asian ready-made garment exporting country?", listOf("බංග්ලාදේශය", "වියට්නාමය", "චීනය", "Bangladesh"), "බංග්ලාදේශය, වියට්නාමය හෝ චීනය වේ.", "බංග්ලාදේශයයි.")
        6 -> Quintuple("කර්මාන්ත ශාලාවක් පිහිටුවීමට බලපාන මූලික ආර්ථික සාධකයක් පවසන්න.", "Key economic factor in locating a factory?", listOf("අමුද්‍රව්‍ය", "ශ්‍රමය", "වෙළඳපොළ", "ප්‍රවාහනය"), "අමුද්‍රව්‍ය, ශ්‍රමය, වෙළඳපොළ හෝ ප්‍රවාහනය වේ.", "අමුද්‍රව්‍ය / ශ්‍රමයයි.")
        7 -> Quintuple("අමුද්‍රව්‍ය බරින් වැඩි කර්මාන්ත පිහිටුවන්නේ අමුද්‍රව්‍ය අසලද නැතහොත් වෙළඳපොළ අසලද?", "Heavy raw material industries locate near materials or market?", listOf("අමුද්‍රව්‍ය අසල", "අමුද්‍රව්‍ය නිධිය අසල"), "අමුද්‍රව්‍ය නිධියට ආසන්නවය (ප්‍රවාහන වියදම අවම කිරීමට).", "අමුද්‍රව්‍ය අසලයි.")
        8 -> Quintuple("සැහැල්ලු ඉලෙක්ට්‍රොනික කර්මාන්ත පිහිටුවන්නේ ගුවන් තොටුපළ හෝ වෙළඳපොළ සමීපවද?", "Light electronics factories locate near airports/markets?", listOf("ඔව්", "එසේය"), "ඔව්, ප්‍රවාහන පහසුව සහ වෙළඳපොළ ආසන්නවය.", "ඔව් වේ.")
        9 -> Quintuple("කර්මාන්ත සඳහා විදේශ ආයෝජන ආකර්ෂණයට පිහිටුවන විශේෂ කලාප මොනවාද?", "Special industrial zones attracting FDI?", listOf("නිදහස් වෙළඳ කලාප", "FTZ", "ආයෝජන කලාප"), "නිදහස් වෙළඳ කලාප (FTZ / EPZ) වේ.", "නිදහස් වෙළඳ කලාපයි.")
        10 -> Quintuple("ශ්‍රී ලංකාවේ ප්‍රථම නිදහස් වෙළඳ කලාපය පිහිටියේ කොහේද?", "Where was Sri Lanka's first Free Trade Zone established?", listOf("කටුනායක", "කටුනායකදී"), "කටුනායකදීය (1978).", "කටුනායකයි.")
        11 -> Quintuple("වානේ නිෂ්පාදනයට අවශ්‍ය ප්‍රධාන ඛනිජ අමුද්‍රව්‍ය 2 මොනවාද?", "Two primary mineral raw materials for steel making?", listOf("යකඩ යපස් ගල් අඟුරු", "යකඩ යපස්", "ගල් අඟුරු"), "යකඩ යපස් සහ ගල් අඟුරු (කොක්ස්) වේ.", "යකඩ සහ ගල් අඟුරුයි.")
        12 -> Quintuple("ඇලුමිනියම් නිස්සාරණය කරන්නේ කුමන ඛනිජයෙන්ද?", "Mineral from which aluminum is extracted?", listOf("බොක්සයිට්", "Bauxite"), "බොක්සයිට් (Bauxite) ඛනිජයෙනි.", "බොක්සයිට් වලිනි.")
        13 -> Quintuple("රසායනික පොහොර හා ප්ලාස්ටික් නිපදවන කර්මාන්ත හඳුන්වන්නේ කෙසේද?", "Industries deriving plastics and fertilizers from oil/gas?", listOf("ඛනිජ රසායනික කර්මාන්ත", "Petrochemicals"), "ඛනිජ රසායනික කර්මාන්ත (Petrochemical industries) නමිනි.", "ඛනිජ රසායන කර්මාන්තයි.")
        14 -> Quintuple("ලෝකයේ නැව් තැනීමේ කර්මාන්තයෙන් ඉදිරියෙන්ම සිටින රටක් නම් කරන්න.", "Leading shipbuilding nation in the world?", listOf("දකුණු කොරියාව", "චීනය", "ජපානය", "Korea"), "දකුණු කොරියාව හෝ චීනය වේ.", "දකුණු කොරියාවයි.")
        15 -> Quintuple("වාණිජ ගුවන් යානා නිෂ්පාදනයේ ප්‍රමුඛ ලෝක සමාගම් දෙක මොනවාද?", "Two premier commercial aircraft makers in the world?", listOf("බෝයිං සහ එයාර්බස්", "Boeing", "Airbus"), "බෝයිං (Boeing) සහ එයාර්බස් (Airbus) වේ.", "බෝයිං සහ එයාර්බස්ය.")
        16 -> Quintuple("චීනය 'ලෝකයේ කර්මාන්ත ශාලාව' ලෙස හඳුන්වන්නේ ඇයි?", "Why is China called 'Factory of the World'?", listOf("වැඩිම භාණ්ඩ නිපදවීම", "නිෂ්පාදන පරිමාව"), "ලොව කාර්මික භාණ්ඩවලින් වැඩිම ප්‍රතිශතයක් නිපදවන බැවිනි.", "වැඩිම භාණ්ඩ නිපදවයි.")
        17 -> Quintuple("කර්මාන්ත ශාලාවලින් බැහැර කරන සල්ෆර් හා නයිට්‍රජන් වායු නිසා ඇතිවන වැසි මොනවාද?", "Rain caused by industrial sulfur and nitrogen emissions?", listOf("අම්ල වැසි", "Acid rain"), "අම්ල වැසි (Acid rain) වේ.", "අම්ල වැසියි.")
        18 -> Quintuple("කර්මාන්ත අපද්‍රව්‍ය ජලයට මුදාහැරීමෙන් සිදුවන්නේ කුමක්ද?", "Consequence of dumping untreated industrial waste into rivers?", listOf("ජල දූෂණය", "ජලය දූෂණය වීම"), "ජල දූෂණය සහ ජලජ ජීවීන් විනාශ වීමයි.", "ජල දූෂණයයි.")
        19 -> Quintuple("පරිසර හිතකාමී හරිත කර්මාන්ත ශාලා සංකල්පය කුමක්ද?", "What is green industrial factory concept?", listOf("අපද්‍රව්‍ය අවම", "බලශක්ති පිරිමැසුම්", "Green factory"), "අපද්‍රව්‍ය අවම, පුනර්ජනනීය බලය භාවිත කරන ක්‍රමයයි.", "හරිත නිෂ්පාදනයයි.")
        20 -> Quintuple("කාර්මික සංවර්ධනය රටක ජාතික ආදායම වැඩි කිරීමට හේතු වේද?", "Does industrial growth boost national income?", listOf("ඔව්", "එසේය"), "ඔව්, රැකියා සහ අපනයන ආදායම ඉහළ යයි.", "ඔව් වේ.")
        else -> Quintuple("කාර්මික විප්ලවය ආරම්භ වූයේ බ්‍රිතාන්‍යයේද?", "Did Industrial Revolution start in Britain?", listOf("ඔව්", "එසේය"), "ඔව්, 18 වන සියවසේදී බ්‍රිතාන්‍යයේය.", "ඔව් වේ.")
      }

      // Set 8: ලෝක ජනගහනය, නාගරීකරණය & මෙගා නගර
      8 -> when (qIndex) {
        1 -> Quintuple("ලෝකයේ විශාලතම ජනගහනයක් සහිත මෙගා නගරය (Megacity) කුමක්ද?", "World's most populous megacity?", listOf("ටෝකියෝ", "Tokyo"), "ජපානයේ ටෝකියෝ නගරය වේ (මිලියන 37කට අධිකයි).", "ටෝකියෝ නගරයයි.")
        2 -> Quintuple("ග්‍රාමීය ජනතාව නගර කරා සංක්‍රමණය වීම හඳුන්වන්නේ කෙසේද?", "Migration of rural population to urban centers?", listOf("නාගරීකරණය", "Urbanization"), "නාගරීකරණය (Urbanization) නමිනි.", "නාගරීකරණයයි.")
        3 -> Quintuple("ලෝක ජනගහන දිනය සමරන්නේ කුමන දිනයේද?", "World Population Day date?", listOf("ජූලි 11", "ජුලි 11"), "ජූලි 11 වනදාය.", "ජූලි 11යි.")
        4 -> Quintuple("ජනගහනය මිලියන 10 ඉක්මවූ දැවැන්ත නගරයක් හඳුන්වන්නේ කෙසේද?", "City with population exceeding 10 million?", listOf("මෙගා නගරයක්", "Megacity"), "මෙගා නගරයක් (Megacity) නමිනි.", "මෙගා නගරයක් නමිනි.")
        5 -> Quintuple("ලෝකයේ වත්මන් ජනගහනය දළ වශයෙන් බිලියන කීයක් ඉක්මවා ඇත්ද?", "Current world population exceeds approximately how many billions?", listOf("8", "බිලියන 8", "8ක්"), "බිලියන 8ක් (8 Billion) ඉක්මවා ඇත.", "බිලියන 8කි.")
        6 -> Quintuple("වර්ග කිලෝමීටරයක වෙසෙන ජන සංඛ්‍යාව හඳුන්වන්නේ කෙසේද?", "Number of people living per square kilometer?", listOf("ජන ඝනත්වය", "Population Density"), "ජන ඝනත්වය (Population Density) නමිනි.", "ජන ඝනත්වයයි.")
        7 -> Quintuple("ලෝකයේ ජනගහන ඝනත්වය අධිකම කුඩා රාජ්‍යයක් නම් කරන්න.", "Extremely dense sovereign microstate?", listOf("මොනාකෝ", "සිංගප්පූරුව", "Monaco", "Singapore"), "මොනාකෝ හෝ සිංගප්පූරුව වේ.", "මොනාකෝ / සිංගප්පූරුවයි.")
        8 -> Quintuple("ලෝකයේ ජනගහන ඝනත්වය ඉතා අඩු රටක් නම් කරන්න.", "Country with very low population density?", listOf("මොංගෝලියාව", "ඕස්ට්‍රේලියාව", "කැනඩාව"), "මොංගෝලියාව, ඕස්ට්‍රේලියාව හෝ කැනඩාව වේ.", "මොංගෝලියාවයි.")
        9 -> Quintuple("උපත් අනුපාතිකය මරණ අනුපාතිකයට වඩා වැඩි වීමෙන් සිදුවන්නේ කුමක්ද?", "Result when birth rate exceeds death rate?", listOf("ස්වභාවික ජනගහන වර්ධනය", "ජනගහනය වැඩිවීම"), "ස්වභාවික ජනගහන වර්ධනයයි.", "ජනගහනය වැඩිවීමයි.")
        10 -> Quintuple("මිනිසුන් උපන් රට අතහැර වෙනත් රටක ස්ථිරව පදිංචියට යාම කුමක්ද?", "Moving permanently to settle in another country?", listOf("විගමනය", "සංක්‍රමණය", "Emigration"), "විගමනය හෙවත් විදේශගත සංක්‍රමණයයි.", "සංක්‍රමණයයි.")
        11 -> Quintuple("නගරවල ජනගහනය අධික වීමෙන් ඇතිවන ප්‍රධාන ගැටලුවක් පවසන්න.", "Major problem caused by excessive urban population?", listOf("රථවාහන තදබදය", "නිවාස හිඟය", "මුඩුක්කු", "දූෂණය"), "රථවාහන තදබදය, නිවාස හිඟය හෝ අපද්‍රව්‍ය ගැටලු වේ.", "රථවාහන තදබදය / නිවාස හිඟයයි.")
        12 -> Quintuple("වේගවත් නාගරීකරණය නිසා නගර ආශ්‍රිතව සෑදෙන අනවසර පැල්පත් නිවාස මොනවාද?", "Informal squatter settlements around cities?", listOf("මුඩුක්කු", "පැල්පත්", "Slums"), "මුඩුක්කු සහ පැල්පත් නිවාස (Slums) වේ.", "මුඩුක්කු නිවාසයි.")
        13 -> Quintuple("ජනගහනයේ වයස් සහ ස්ත්‍රී-පුරුෂ ව්‍යුහය දක්වන විශේෂ ප්‍රස්ථාරය කුමක්ද?", "Graphical chart depicting age and sex structure?", listOf("ජනගහන පිරමිඩය", "Population pyramid"), "ජනගහන පිරමිඩය (Population pyramid) වේ.", "ජනගහන පිරමිඩයයි.")
        14 -> Quintuple("ජපානය සහ යුරෝපා රටවල වැඩිහිටි ජනගහනය වැඩිවීම හඳුන්වන්නේ කෙසේද?", "Phenomenon of rising elderly proportion in Europe/Japan?", listOf("ජනගහනය වයස්ගත වීම", "Aging population"), "ජනගහනය වයස්ගත වීම (Aging population) නමිනි.", "වයස්ගත වීමයි.")
        15 -> Quintuple("සංවර්ධනය වෙමින් පවතින රටවල ළමා හා තරුණ ජනගහන ප්‍රතිශතය ඉහළද?", "Is child/youth dependency proportion high in developing nations?", listOf("ඔව්", "එසේය"), "ඔව්, තරුණ ජනගහන අනුපාතය ඉහළය.", "ඔව් වේ.")
        16 -> Quintuple("ලෝකයේ වැඩිම ජනගහනයක් වෙසෙන මහාද්වීපය කුමක්ද?", "Most populous continent in the world?", listOf("ආසියාව", "ආසියා මහාද්වීපය", "Asia"), "ආසියා මහාද්වීපය වේ (ලෝක ජනගහනයෙන් 60%කට වැඩි).", "ආසියාවයි.")
        17 -> Quintuple("ලෝකයේ ස්ථිර ජනාවාස නොමැති එකම මහාද්වීපය කුමක්ද?", "Only continent without permanent human population?", listOf("ඇන්ටාක්ටිකාව", "Antarctica"), "ඇන්ටාක්ටිකාව (Antarctica) වේ.", "ඇන්ටාක්ටිකාවයි.")
        18 -> Quintuple("මිනිසුන් නගර කරා ආකර්ෂණය වීමට බලපාන ප්‍රධාන සාධකයක් පවසන්න.", "Pull factor attracting rural people to cities?", listOf("රැකියා අවස්ථා", "උසස් අධ්‍යාපනය", "පහසුකම්"), "රැකියා අවස්ථා, උසස් අධ්‍යාපනය හෝ සෞඛ්‍ය පහසුකම්ය.", "රැකියා අවස්ථායි.")
        19 -> Quintuple("මිනිසුන් ගම්බිම් අතහැර යාමට බලපාන විකර්ෂණ සාධකයක් පවසන්න.", "Push factor driving people away from villages?", listOf("රැකියා නොමැතිකම", "නියඟය", "දුප්පත්කම"), "රැකියා විරහිත බව, නියඟය හෝ දරිද්‍රතාවය වේ.", "රැකියා විරහිත බවයි.")
        20 -> Quintuple("නවීන තාක්ෂණයෙන් යුත් ස්මාර්ට් නගර (Smart Cities) බිහිකිරීම අනාගත විසඳුමක්ද?", "Are modern tech-driven smart cities a solution?", listOf("ඔව්", "එසේය"), "ඔව්, කාර්යක්ෂම තිරසාර නාගරික දිවියකට මඟකි.", "ඔව් වේ.")
        else -> Quintuple("ජන විද්‍යාව යනු ජනගහනය පිළිබඳ විද්‍යාත්මක අධ්‍යයනයද?", "Is demography the scientific study of population?", listOf("ඔව්", "එසේය"), "ඔව්, ජනගහන සංඛ්‍යාන අධ්‍යයනයයි.", "ඔව් වේ.")
      }

      // Set 9: ගෝලීය දේශගුණික විපර්යාස & ඕසෝන් වියන
      9 -> when (qIndex) {
        1 -> Quintuple("ගෝලීය හරිතාගාර වායු විමෝචනය අවම කිරීමට 1997 දී අත්සන් කළ ගිවිසුම කුමක්ද?", "1997 treaty to reduce greenhouse gases?", listOf("කියෝතෝ සම්මුතිය", "කියෝතෝ ප්‍රොටෝකෝලය", "Kyoto"), "කියෝතෝ ප්‍රොටෝකෝලය (Kyoto Protocol) වේ.", "කියෝතෝ ප්‍රොටෝකෝලයයි.")
        2 -> Quintuple("ගෝලීය උෂ්ණත්වය ඉහළ යාම 1.5°C ට සීමා කිරීමට 2015 දී ඇතිකරගත් ගිවිසුම කුමක්ද?", "2015 international agreement capping warming to 1.5°C?", listOf("පැරිස් ගිවිසුම", "Paris Agreement"), "පැරිස් දේශගුණික සම්මුතිය (Paris Agreement) වේ.", "පැරිස් ගිවිසුමයි.")
        3 -> Quintuple("ධ්‍රැවීය අයිස් දියවීමෙන් වඩාත්ම තර්ජනයට ලක්වන්නේ කුමන ආකාරයේ රටවල්ද?", "Countries most endangered by sea level rise?", listOf("කුඩා දූපත් රාජ්‍යයන්", "මාලදිවයින", "දූපත්"), "මාලදිවයින වැනි පහත් කුඩා දූපත් රාජ්‍යයන්ය.", "පහත් දූපත් රටවල්ය.")
        4 -> Quintuple("ඕසෝන් ස්ථරය ආරක්ෂා කිරීම සඳහා ඇතිකරගත් ජාත්‍යන්තර සම්මුතිය කුමක්ද?", "International treaty preserving ozone layer?", listOf("මොන්ට්‍රියල් ප්‍රොටෝකෝලය", "මොන්ට්‍රියල්", "Montreal"), "මොන්ට්‍රියල් ප්‍රොටෝකෝලය (1987) වේ.", "මොන්ට්‍රියල් ගිවිසුමයි.")
        5 -> Quintuple("වායුගෝලයේ ඕසෝන් වියන පිහිටා ඇත්තේ කුමන වායුගෝලීය ස්ථරයේද?", "Atmospheric layer where ozone layer resides?", listOf("ස්ට්‍රැටෝස්ෆියරය", "ස්ට්‍රැටොස්ෆියරය", "Stratosphere"), "ස්ට්‍රැටෝස්ෆියරය (Stratosphere) තුළය.", "ස්ට්‍රැටෝස්ෆියරයේය.")
        6 -> Quintuple("ඕසෝන් අණුවක් සෑදී ඇත්තේ ඔක්සිජන් පරමාණු කීයකින්ද?", "How many oxygen atoms in an ozone molecule?", listOf("3", "3ක්", "තුනකින්"), "ඔක්සිජන් පරමාණු 3කිනි (O₃).", "පරමාණු 3කිනි.")
        7 -> Quintuple("ඕසෝන් වියන විනාශ කිරීමට ප්‍රධාන වශයෙන් බලපෑ වායුව කුමක්ද?", "Primary gas that caused ozone layer depletion?", listOf("CFC", "ක්ලෝරෝෆ්ලෝරෝකාබන්"), "CFC (ක්ලෝරෝෆ්ලෝරෝකාබන්) වායුව වේ.", "CFC වායුවයි.")
        8 -> Quintuple("මිනිස් ක්‍රියාකාරකම් මඟින් වායුගෝලයට එකතු වන ප්‍රධාන හරිතාගාර වායුව කුමක්ද?", "Major anthropogenic greenhouse gas in atmosphere?", listOf("කාබන් ඩයොක්සයිඩ්", "CO2"), "කාබන් ඩයොක්සයිඩ් (CO₂) වායුව වේ.", "කාබන් ඩයොක්සයිඩ්ය.")
        9 -> Quintuple("සත්ත්ව පාලනය හා කුඹුරු වගාවෙන් පිටවන තවත් ප්‍රබල හරිතාගාර වායුව කුමක්ද?", "Potent greenhouse gas from paddy cultivation and livestock?", listOf("මීතේන්", "CH4", "Methane"), "මීතේන් (CH₄) වායුව වේ.", "මීතේන් වායුවයි.")
        10 -> Quintuple("පෘථිවි සාමාන්‍ය උෂ්ණත්වය ක්‍රමයෙන් ඉහළ යාම හඳුන්වන්නේ කෙසේද?", "Gradual rise in average global temperature?", listOf("ගෝලීය උණුසුම", "Global warming"), "ගෝලීය උණුසුම (Global Warming) නමිනි.", "ගෝලීය උණුසුමයි.")
        11 -> Quintuple("වායුගෝලයේ වැඩි වන CO₂ සාගර ජලයේ දියවීමෙන් ඇතිවන ගැටලුව කුමක්ද?", "Effect of increasing CO2 dissolving into ocean waters?", listOf("සාගර ආම්ලිකකරණය", "ආම්ලිකතාව වැඩිවීම"), "සාගර ආම්ලිකකරණය (Ocean acidification) වේ.", "සාගර ආම්ලිකකරණයයි.")
        12 -> Quintuple("මුහුදු ජලයේ උෂ්ණත්වය වැඩිවීමෙන් කොරල්පර විනාශ වී සුදුමැලි වීම කුමක්ද?", "Thermal stress causing coral reefs to bleach and die?", listOf("කොරල් විරංජනය", "Coral bleaching"), "කොරල් විරංජනය (Coral bleaching) නමිනි.", "කොරල් විරංජනයයි.")
        13 -> Quintuple("ඕසෝන් වියන හායනය වීමෙන් මිනිස් සමට ඇතිවිය හැකි බරපතල රෝගය කුමක්ද?", "Severe skin disease linked to UV exposure through depleted ozone?", listOf("සමේ පිළිකා", "පිළිකා", "Skin cancer"), "සමේ පිළිකා (Skin cancer) තත්ත්වයන්ය.", "සමේ පිළිකායි.")
        14 -> Quintuple("ලෝක ඕසෝන් දිනය සමරන්නේ කුමන දිනයේද?", "World Ozone Day date?", listOf("සැප්තැම්බර් 16", "සැප්තැම්බර් 16 වනදා"), "සැප්තැම්බර් 16 වනදාය.", "සැප්තැම්බර් 16යි.")
        15 -> Quintuple("දීර්ඝ නියඟය හා පාංශු හායනය නිසා සරු බිම් වියළී යාම කුමක්ද?", "Degradation of dry lands into desert-like conditions?", listOf("කාන්තාරකරණය", "Desertification"), "කාන්තාරකරණය (Desertification) නමිනි.", "කාන්තාරකරණයයි.")
        16 -> Quintuple("ගස් වැවීම හෙවත් වන වගාව මඟින් වායුගෝලයේ CO₂ උරාගත හැකිද?", "Does reforestation sequester atmospheric CO2?", listOf("ඔව්", "එසේය"), "ඔව්, ශාක ප්‍රභාසංස්ලේෂණයේදී CO₂ උරාගනී.", "ඔව් වේ.")
        17 -> Quintuple("ධ්‍රැවීය අයිස් දියවීමෙන් මුහුදු මට්ටම ඉහළ යාම සිදුවේද?", "Does melting polar ice raise sea levels?", listOf("ඔව්", "එසේය"), "ඔව්, වෙරළබඩ නගර ජලයෙන් යටවීමේ අවදානමක් ඇත.", "ඔව් වේ.")
        18 -> Quintuple("පුද්ගලයෙකු හෝ ආයතනයක් පරිසරයට මුදාහරින හරිතාගාර වායු ප්‍රමාණය කුමක්ද?", "Total amount of greenhouse gases generated by individual/entity?", listOf("කාබන් පා සටහන", "Carbon footprint"), "කාබන් පා සටහන (Carbon footprint) නමිනි.", "කාබන් පා සටහනයි.")
        19 -> Quintuple("පුනර්ජනනීය බලශක්තිය භාවිතය මඟින් ගෝලීය විමෝචනය අඩු කළ හැකිද?", "Does renewable energy transition curb global emissions?", listOf("ඔව්", "එසේය"), "ඔව්, පොසිල ඉන්ධන භාවිතය අඩුවේ.", "ඔව් වේ.")
        20 -> Quintuple("දේශගුණ විපර්යාස පිළිබඳ වාර්ෂික එක්සත් ජාතීන්ගේ සමුළුව හඳුන්වන්නේ කෙසේද?", "Annual UN climate change summit acronym?", listOf("COP", "COP සමුළුව"), "COP (Conference of the Parties) සමුළුව නමිනි.", "COP සමුළුවයි.")
        else -> Quintuple("පෘථිවි උෂ්ණත්වය පාලනය කිරීම මතු පරපුරට අත්‍යවශ්‍යද?", "Is climate action vital for future generations?", listOf("ඔව්", "එසේය"), "ඔව්, සමස්ත ජීවයේ පැවැත්මට අත්‍යවශ්‍යයි.", "ඔව් වේ.")
      }

      // Set 10: තිරසාර සංවර්ධනය & ශ්‍රී ලංකාවේ අනාගතය
      else -> when (qIndex) {
        1 -> Quintuple("එක්සත් ජාතීන්ගේ සංවිධානය ප්‍රකාශයට පත් කළ තිරසාර සංවර්ධන අරමුණු (SDGs) ගණන කීයද?", "How many Sustainable Development Goals (SDGs)?", listOf("17", "17ක්", "දහහතක්"), "තිරසාර අරමුණු 17කි (Goals 17).", "අරමුණු 17කි.")
        2 -> Quintuple("තිරසාර සංවර්ධන අරමුණු ළඟා කරගත යුතු ඉලක්කගත වර්ෂය කුමක්ද?", "Target year for Agenda 2030 SDGs?", listOf("2030", "2030 වර්ෂය"), "2030 වර්ෂයයි (Agenda 2030).", "2030 වසරයි.")
        3 -> Quintuple("අනාගත පරපුරේ අවශ්‍යතා කැප නොකර වත්මන් අවශ්‍යතා සපුරා ගැනීම හඳුන්වන්නේ කෙසේද?", "Meeting current needs without sacrificing future generations?", listOf("තිරසාර සංවර්ධනය", "Sustainable Development"), "තිරසාර සංවර්ධනය (Sustainable Development) නමිනි.", "තිරසාර සංවර්ධනයයි.")
        4 -> Quintuple("පළමු වන තිරසාර සංවර්ධන අරමුණ (SDG 1) කුමක්ද?", "What is SDG 1?", listOf("දුප්පත්කම පිටුදැකීම", "දිළිඳුකම පිටුදැකීම", "No Poverty"), "සියලු ආකාරයේ දිළිඳුකම පිටුදැකීමයි.", "දුප්පත්කම පිටුදැකීමයි.")
        5 -> Quintuple("දෙවන තිරසාර සංවර්ධන අරමුණ (SDG 2) කුමක්ද?", "What is SDG 2?", listOf("කුසගින්න නිමා කිරීම", "Zero Hunger"), "කුසගින්න නිමා කිරීම (Zero Hunger) වේ.", "කුසගින්න නැති කිරීමයි.")
        6 -> Quintuple("හතරවන තිරසාර සංවර්ධන අරමුණ (SDG 4) කුමක්ද?", "What is SDG 4?", listOf("ගුණාත්මක අධ්‍යාපනය", "Quality Education"), "ගුණාත්මක අධ්‍යාපනය (Quality Education) වේ.", "ගුණාත්මක අධ්‍යාපනයයි.")
        7 -> Quintuple("හයවන තිරසාර සංවර්ධන අරමුණ (SDG 6) කුමක්ද?", "What is SDG 6?", listOf("පිරිසිදු ජලය", "සනීපාරක්ෂාව", "Clean water"), "පිරිසිදු ජලය සහ සනීපාරක්ෂාව වේ.", "පිරිසිදු ජලයයි.")
        8 -> Quintuple("දහතුන්වන තිරසාර සංවර්ධන අරමුණ (SDG 13) කුමක්ද?", "What is SDG 13?", listOf("දේශගුණික ක්‍රියාමාර්ග", "Climate Action"), "දේශගුණික ක්‍රියාමාර්ග (Climate Action) වේ.", "දේශගුණ ක්‍රියාමාර්ගයි.")
        9 -> Quintuple("ශ්‍රී ලංකාවේ ආර්ථිකයේ ප්‍රධාන අංශ 3 මොනවාද?", "Three main sectors of Sri Lankan economy?", listOf("කෘෂිකර්මාන්තය කර්මාන්ත සේවා", "කෘෂි", "කර්මාන්ත", "සේවා"), "කෘෂිකාර්මික, කාර්මික සහ සේවා අංශය වේ.", "කෘෂිකර්ම, කර්මාන්ත, සේවාවයි.")
        10 -> Quintuple("ශ්‍රී ලංකාවේ දළ දේශීය නිෂ්පාදිතයට (GDP) වැඩිම දායකත්වයක් දෙන්නේ කුමන අංශයද?", "Sector contributing largest share to Sri Lanka's GDP?", listOf("සේවා අංශය", "සේවා", "Services"), "සේවා අංශයයි (60%කට ආසන්නයි).", "සේවා අංශයයි.")
        11 -> Quintuple("ශ්‍රී ලංකාවට විදේශ විනිමය ගෙනෙන ප්‍රධාන ක්ෂේත්‍රයක් පවසන්න.", "Key source of foreign exchange for Sri Lanka?", listOf("විදේශ රැකියා", "සංචාරක ව්‍යාපාරය", "තේ", "ඇඟලුම්"), "විදේශ රැකියා, සංචාරක ව්‍යාපාරය, තේ හෝ ඇඟලුම් වේ.", "විදේශ රැකියා / තේ / සංචාරකයි.")
        12 -> Quintuple("ශ්‍රී ලංකාවේ දක්ෂිණ අධිවේගී මාර්ගය හඳුන්වන නිල අංකය කුමක්ද?", "Official route code of Southern Expressway?", listOf("E01", "E-01"), "E01 වේ.", "E01 වේ.")
        13 -> Quintuple("කොළඹ වරාය නගරය (Port City) ඉදිකර ඇත්තේ කුමක් ගොඩකිරීමෙන්ද?", "How was Colombo Port City land reclaimed?", listOf("මුහුද ගොඩකිරීමෙන්", "මුහුද"), "මුහුද ගොඩකිරීම මඟිනි.", "මුහුද ගොඩකිරීමෙනි.")
        14 -> Quintuple("ශ්‍රී ලංකාවේ වැඩිහිටි සාක්ෂරතා අනුපාතිකය සියයට කීයකට වඩා ඉහළද?", "Sri Lanka adult literacy rate exceeds what percent?", listOf("92%", "90%", "92"), "92% කට වඩා ඉහළය.", "92% කට වඩා වැඩියි.")
        15 -> Quintuple("ශ්‍රී ලංකාවේ ජනතාවට රජයෙන් නොමිලේ ලබාදෙන ප්‍රධාන සමාජ සුභසාධන දෙක මොනවාද?", "Two primary universal free welfare services in Sri Lanka?", listOf("නිදහස් අධ්‍යාපනය හා සෞඛ්‍යය", "අධ්‍යාපනය", "සෞඛ්‍යය"), "නිදහස් අධ්‍යාපනය සහ නිදහස් සෞඛ්‍ය සේවයයි.", "අධ්‍යාපනය හා සෞඛ්‍යයි.")
        16 -> Quintuple("ශ්‍රී ලංකාවේ තිරසාර කෘෂිකර්මාන්තය සඳහා නවීන තාක්ෂණය භාවිත කළ හැකිද?", "Can modern tech advance sustainable farming in Sri Lanka?", listOf("ඔව්", "එසේය"), "ඔව්, බිංදු ජල සම්පාදනය සහ හරිතාගාර මඟිනි.", "ඔව් වේ.")
        17 -> Quintuple("ඝන අපද්‍රව්‍ය කළමනාකරණයේ 3R සංකල්පයේ අංග 3 මොනවාද?", "Three components of 3R waste hierarchy?", listOf("අඩු කිරීම නැවත භාවිතය ප්‍රතිචක්‍රීකරණය", "Reduce", "Reuse", "Recycle"), "Reduce (අඩු කිරීම), Reuse (නැවත භාවිතය), Recycle (ප්‍රතිචක්‍රීකරණය) වේ.", "අඩු කිරීම, නැවත භාවිතය, ප්‍රතිචක්‍රීකරණයයි.")
        18 -> Quintuple("ශ්‍රී ලංකාවේ පරිසරය සුරැකීමට නීති ක්‍රියාත්මක කරන ප්‍රධාන රාජ්‍ය ආයතනය කුමක්ද?", "Apex environmental regulatory authority in Sri Lanka?", listOf("මධ්‍යම පරිසර අධිකාරිය", "CEA"), "මධ්‍යම පරිසර අධිකාරිය (CEA) වේ.", "මධ්‍යම පරිසර අධිකාරියයි.")
        19 -> Quintuple("ස්වභාවධර්මයට හානි නොවන සංචාරක ව්‍යාපාරය හඳුන්වන්නේ කෙසේද?", "Nature-friendly responsible tourism?", listOf("පාරිසරික සංචාරක ව්‍යාපාරය", "Ecotourism"), "පාරිසරික සංචාරක ව්‍යාපාරය (Ecotourism) නමිනි.", "පාරිසරික සංචාරකයි.")
        20 -> Quintuple("ශ්‍රී ලංකාව තිරසාර සංවර්ධිත දේශයක් බවට පත්කිරීමට සෑම පුරවැසියෙකුටම වගකීමක් තිබේද?", "Does every citizen have a role in sustainable nation building?", listOf("ඔව්", "එසේය"), "ඔව්, පරිසරය සහ සම්පත් අරපිරිමැස්මෙන් සුරැකිය යුතුය.", "ඔව් වේ.")
        else -> Quintuple("තිරසාර සංවර්ධනය අනාගත පරපුරට සුරක්ෂිත ලොවක් දායාද කරයිද?", "Does sustainable development secure the future for next generation?", listOf("ඔව්", "එසේය"), "ඔව්, අනාගතය සුරක්ෂිත වේ.", "ඔව් වේ.")
      }
    }
  }
}
