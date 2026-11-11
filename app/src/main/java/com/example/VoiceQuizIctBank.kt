package com.example

/**
 * 💻 Voice Quiz Bank for ICT (තොරතුරු හා සන්නිවේදන තාක්ෂණය)
 * 200 strictly simple, direct, non-formula, non-explanatory ICT questions.
 * 10 distinct sets of 20 questions each.
 */
object VoiceQuizIctBank {

  fun getQuestion(grade: String, setNum: Int, qIndex: Int, theme: String): Quintuple<String, String, List<String>, String, String> {
    if (grade == "11") {
      return getGrade11Question(setNum, qIndex, theme)
    }
    return when (setNum) {
      // Set 1: පරිගණක පද්ධතිය & ප්‍රධාන දෘඩාංග
      1 -> when (qIndex) {
        1 -> Quintuple("පරිගණකයක ප්‍රධාන සැකසුම් ඒකකය හඳුන්වන කෙටි නම කුමක්ද?", "Main processing unit abbreviation?", listOf("CPU", "ප්‍රොසෙසරය"), "CPU (Central Processing Unit) වේ.", "පරිගණකයේ මොළයයි.")
        2 -> Quintuple("පරිගණකයක මොළය ලෙස හඳුන්වන්නේ කුමන උපාංගයද?", "Which device is called the brain of computer?", listOf("CPU", "ප්‍රොසෙසරය"), "මධ්‍ය සැකසුම් ඒකකය (CPU) වේ.", "CPU වේ.")
        3 -> Quintuple("CPU තුළ ඇති ගණිත හා තාර්කික ඒකකයේ කෙටි නම කුමක්ද?", "Arithmetic Logic Unit abbreviation?", listOf("ALU"), "ALU (Arithmetic Logic Unit) වේ.", "ALU වේ.")
        4 -> Quintuple("CPU හි සියලුම ක්‍රියාකාරකම් පාලනය කරන ඒකකය කුමක්ද?", "Unit controlling all CPU operations?", listOf("පාලන ඒකකය", "CU", "Control Unit"), "පාලන ඒකකය (Control Unit / CU) වේ.", "පාලන ඒකකයයි.")
        5 -> Quintuple("CPU තුළ ඇති වේගවත්ම තාවකාලික මතක රඳවන කුමක්ද?", "Fastest temporary registers inside CPU?", listOf("රෙජිස්ටර", "Registers"), "රෙජිස්ටර (Registers) වේ.", "රෙජිස්ටරයි.")
        6 -> Quintuple("පරිගණකයක වේගය හෙවත් සංඛ්‍යාතය මනින ඒකකය කුමක්ද?", "Unit of processor clock speed?", listOf("හර්ට්ස්", "GHz", "MHz", "Hertz"), "හර්ට්ස් (Hz / GHz) වේ.", "GHz වේ.")
        7 -> Quintuple("සියලුම අභ්‍යන්තර උපාංග සම්බන්ධ වන ප්‍රධාන පරිපථ පුවරුව කුමක්ද?", "Main circuit board connecting all parts?", listOf("මව් පුවරුව", "Motherboard"), "මව් පුවරුව (Motherboard) වේ.", "මව් පුවරුවයි.")
        8 -> Quintuple("අතින් ඇල්ලිය හැකි පරිගණක කොටස් හඳුන්වන්නේ දෘඩාංග ලෙසද මෘදුකාංග ලෙසද?", "Physical touchable parts called hardware or software?", listOf("දෘඩාංග", "hardware"), "දෘඩාංග (Hardware) නමිනි.", "දෘඩාංගයි.")
        9 -> Quintuple("පරිගණකයට විදුලි බලය සපයන උපාංගය කුමක්ද?", "Power supply unit?", listOf("SMPS", "Power supply", "විදුලි සැපයුම"), "විදුලි සැපයුම් ඒකකය (Power Supply / SMPS) වේ.", "විදුලි සැපයුමයි.")
        10 -> Quintuple("විදුලිය විසන්ධි වූ විට පරිගණකයට තාවකාලික බලය ලබාදෙන උපකරණය කුමක්ද?", "Backup power device during outages?", listOf("UPS"), "UPS (Uninterruptible Power Supply) වේ.", "UPS යන්ත්‍රයයි.")
        11 -> Quintuple("පරිගණකයක් ආරම්භ කිරීම හඳුන්වන වචනය කුමක්ද?", "Starting a computer is called?", listOf("බූට් කිරීම", "Booting", "Boot"), "බූට් වීම (Booting) නමිනි.", "Booting වේ.")
        12 -> Quintuple("පරිගණක පද්ධතියක මූලික ක්‍රියාවලි 3 නම් ආදානය, සැකසීම සහ අනෙක කුමක්ද?", "Input, Processing and what else?", listOf("ප්‍රතිදානය", "output"), "ප්‍රතිදානය (Output) වේ.", "ප්‍රතිදානයයි.")
        13 -> Quintuple("පරිගණකයට ලබාදෙන අමු දත්ත හඳුන්වන්නේ කුමක් නමින්ද?", "Raw facts given to computer?", listOf("දත්ත", "data"), "දත්ත (Data) නමිනි.", "දත්ත වේ.")
        14 -> Quintuple("දත්ත සකස් කළ පසු ලැබෙන ඵලය හඳුන්වන්නේ කෙසේද?", "Processed data is called?", listOf("තොරතුරු", "information"), "තොරතුරු (Information) නමිනි.", "තොරතුරු වේ.")
        15 -> Quintuple("CPU හි වේගය 3.0 GHz නම් 'GHz' යන්නෙහි තේරුම කුමක්ද?", "What does GHz mean?", listOf("ගිගාහර්ට්ස්", "Gigahertz"), "ගිගාහර්ට්ස් (Gigahertz) වේ.", "ගිගාහර්ට්ස් වේ.")
        16 -> Quintuple("පරිගණකයක් නිවා දැමීම හඳුන්වන ඉංග්‍රීසි වචනය කුමක්ද?", "Word for turning off computer?", listOf("Shutdown", "Shut down"), "Shutdown වේ.", "Shutdown වේ.")
        17 -> Quintuple("පරිගණකයේ ස්පීකර් සඳහා ශබ්ද සංඥා සපයන කාඩ්පත කුමක්ද?", "Card providing sound signals?", listOf("Sound card", "ශබ්ද කාඩ්පත"), "ශබ්ද කාඩ්පත (Sound card) වේ.", "Sound card වේ.")
        18 -> Quintuple("තිරයට දර්ශන සංඥා සපයන පරිපථ කාඩ්පත කුමක්ද?", "Card providing display signals?", listOf("VGA", "Graphics card", "වීඩියෝ කාඩ්පත"), "ග්‍රැෆික්ස් කාඩ්පත (VGA / Graphics card) වේ.", "Graphics card වේ.")
        19 -> Quintuple("CPU අධිකව රත් වීම වැළැක්වීමට සවිකර ඇති උපාංගය කුමක්ද?", "Component to prevent CPU overheating?", listOf("සිසිලන පංකාව", "Heat sink", "Fan"), "සිසිලන පංකාව (Cooling fan / Heat sink) වේ.", "සිසිලන පංකාවයි.")
        20 -> Quintuple("මව් පුවරුවේ වේලාව සහ දිනය පවත්වා ගැනීමට ඇති කුඩා බැටරිය කුමක්ද?", "Small battery keeping time on motherboard?", listOf("CMOS", "CMOS බැටරිය"), "CMOS බැටරිය වේ.", "CMOS බැටරියයි.")
        else -> Quintuple("පරිගණකයක් යනු ඉලෙක්ට්‍රොනික උපකරණයක්ද?", "Is computer an electronic device?", listOf("ඔව්", "එසේය"), "ඔව්, ඉලෙක්ට්‍රොනික උපාංගයකි.", "ඔව් වේ.")
      }

      // Set 2: ආදාන උපාංග (Input Devices)
      2 -> when (qIndex) {
        1 -> Quintuple("අකුරු සහ ඉලක්කම් ඇතුළත් කිරීමට භාවිත කරන ප්‍රධාන ආදාන උපාංගය කුමක්ද?", "Main input device to type text?", listOf("යතුරුපුවරුව", "Keyboard"), "යතුරුපුවරුව (Keyboard) වේ.", "යතුරුපුවරුවයි.")
        2 -> Quintuple("තිරයේ ඇති අයිතම ක්ලික් කර තේරීමට භාවිත කරන පොයින්ටරය කුමක්ද?", "Pointing device to click and select?", listOf("මූසිකය", "Mouse"), "මූසිකය (Mouse) වේ.", "මූසිකයයි.")
        3 -> Quintuple("මුද්‍රිත ලේඛන පරිගණකයට ඩිජිටල් රූප ලෙස ඇතුළත් කරන උපාංගය කුමක්ද?", "Device digitizing printed documents?", listOf("ස්කෑනරය", "Scanner"), "ස්කෑනරය (Scanner) වේ.", "ස්කෑනරයයි.")
        4 -> Quintuple("ශබ්දය පරිගණකයට ඇතුළත් කිරීමට භාවිත කරන උපකරණය කුමක්ද?", "Device to input voice or audio?", listOf("මයික්‍රෆෝනය", "Microphone", "මයික්"), "මයික්‍රෆෝනය (Microphone) වේ.", "මයික්‍රෆෝනයයි.")
        5 -> Quintuple("වෙළඳසැල්වල භාණ්ඩ මිල කේත කියවීමට භාවිත කරන උපාංගය කුමක්ද?", "Device to read product price codes?", listOf("බාර්කෝඩ් රීඩර්", "Barcode reader"), "බාර්කෝඩ් කියවනය (Barcode Reader) වේ.", "බාර්කෝඩ් කියවනයයි.")
        6 -> Quintuple("පරිගණක ක්‍රීඩා (Games) ක්‍රීඩා කිරීමට බහුලව භාවිත වන ලීවර උපාංගය කුමක්ද?", "Lever device used for computer gaming?", listOf("ජොයිස්ටික්", "Joystick"), "ජොයිස්ටික් (Joystick) හෝ Gamepad වේ.", "ජොයිස්ටික් වේ.")
        7 -> Quintuple("ඇඟිල්ලෙන් ස්පර්ශ කර දත්ත ඇතුළත් කරන තිරය හඳුන්වන්නේ කෙසේද?", "Screen operated by touching finger?", listOf("ස්පර්ශ තිරය", "Touchscreen"), "ස්පර්ශ තිරය (Touchscreen) නමිනි.", "ස්පර්ශ තිරයයි.")
        8 -> Quintuple("විභාග බහුවරණ ලකුණු පත්‍ර ස්වයංක්‍රියව පරීක්ෂා කරන තාක්ෂණය කුමක්ද?", "Technology checking MCQ answer sheets?", listOf("OMR", "Optical Mark Recognition"), "OMR (Optical Mark Recognition) වේ.", "OMR වේ.")
        9 -> Quintuple("බැංකු චෙක්පත්වල අංක කියවීමට භාවිත කරන තාක්ෂණය කුමක්ද?", "Technology reading bank cheque numbers?", listOf("MICR"), "MICR වේ.", "MICR වේ.")
        10 -> Quintuple("සජීවී වීඩියෝ පරිගණකයට ඇතුළත් කරන කුඩා කැමරාව කුමක්ද?", "Camera for live video calling?", listOf("වෙබ් කැමරාව", "Webcam"), "වෙබ් කැමරාව (Webcam) වේ.", "Webcam වේ.")
        11 -> Quintuple("ඩිජිටල් චිත්‍ර ඇඳීමට භාවිත කරන පෑන සහ පුවරුව කුමක්ද?", "Stylus and tablet for drawing?", listOf("Graphic tablet", "ඩිජිටල් පුවරුව"), "ග්‍රැෆික් ටැබ්ලට් (Graphics tablet) වේ.", "Graphics tablet වේ.")
        12 -> Quintuple("ලැප්ටොප් පරිගණකවල මූසිකය වෙනුවට ඇඟිල්ලෙන් ස්පර්ශ කරන කොටස කුමක්ද?", "Touch sensitive pad on laptop?", listOf("Touchpad", "ස්පර්ශ පුවරුව"), "Touchpad (ටච්පෑඩ්) වේ.", "Touchpad වේ.")
        13 -> Quintuple("QR කේත පරිලෝකනය කිරීමට භාවිත කරන උපාංගය කුමක්ද?", "Device to scan QR codes?", listOf("QR Scanner", "කැමරාව"), "QR ස්කෑනරය හෝ කැමරාව වේ.", "QR scanner වේ.")
        14 -> Quintuple("යතුරුපුවරුවේ දිගම යතුර කුමක්ද?", "Longest key on keyboard?", listOf("Spacebar", "ස්පේස්"), "ස්පේස් බාර් (Spacebar) යතුරයි.", "Spacebar වේ.")
        15 -> Quintuple("යතුරුපුවරුවේ ඊළඟ පේළියට යාමට ඔබන යතුර කුමක්ද?", "Key pressed to go to next line?", listOf("Enter", "එන්ටර්"), "Enter යතුරයි.", "Enter වේ.")
        16 -> Quintuple("කර්සරයට වම් පසින් ඇති අකුරක් මකා දැමීමට ඔබන යතුර කුමක්ද?", "Key deleting character to left?", listOf("Backspace", "බැක්ස්පේස්"), "Backspace යතුරයි.", "Backspace වේ.")
        17 -> Quintuple("කර්සරයට දකුණු පසින් ඇති අකුරක් මකා දැමීමට ඔබන යතුර කුමක්ද?", "Key deleting character to right?", listOf("Delete", "ඩිලීට්"), "Delete යතුරයි.", "Delete වේ.")
        18 -> Quintuple("ඉංග්‍රීසි අකුරු සියල්ල කැපිටල් කිරීමට ඔබන යතුර කුමක්ද?", "Key locking all letters to capital?", listOf("Caps Lock", "කැප්ස් ලොක්"), "Caps Lock යතුරයි.", "Caps Lock වේ.")
        19 -> Quintuple("යතුරුපුවරුවේ F1 සිට F12 දක්වා යතුරු හඳුන්වන්නේ කෙසේද?", "F1 to F12 keys called what?", listOf("Function keys", "ක්‍රියාකාරී යතුරු"), "Function Keys (ක්‍රියාකාරී යතුරු) නමිනි.", "Function keys වේ.")
        20 -> Quintuple("ඇඟිලි සලකුණු ලබාගැනීමට භාවිත කරන උපාංගය ආදාන උපාංගයක්ද?", "Is fingerprint reader an input device?", listOf("ඔව්", "එසේය"), "ඔව්, ආදාන උපාංගයකි.", "ඔව් වේ.")
        else -> Quintuple("මූසිකයේ සාමාන්‍යයෙන් බොත්තම් කීයක් තිබේද?", "Buttons on standard mouse?", listOf("2", "දෙකක්"), "බොත්තම් 2ක් හෝ 3ක් වේ.", "2ක් හෝ 3කි.")
      }

      // Set 3: ප්‍රතිදාන උපාංග (Output Devices)
      3 -> when (qIndex) {
        1 -> Quintuple("පරිගණකයේ තොරතුරු තිරයේ දෘශ්‍ය ලෙස පෙන්වන ප්‍රධාන උපාංගය කුමක්ද?", "Main device showing visual info on screen?", listOf("මොනිටරය", "Monitor"), "මොනිටරය (Monitor) වේ.", "මොනිටරයයි.")
        2 -> Quintuple("ඩිජිටල් තොරතුරු කඩදාසිවල මුද්‍රණය කර ලබාදෙන උපාංගය කුමක්ද?", "Device printing digital info on paper?", listOf("මුද්‍රණ යන්ත්‍රය", "Printer"), "මුද්‍රණ යන්ත්‍රය (Printer) වේ.", "මුද්‍රණ යන්ත්‍රයයි.")
        3 -> Quintuple("පරිගණකයෙන් ශබ්ද ප්‍රතිදානය ලබාදෙන ප්‍රධාන උපාංගය කුමක්ද?", "Device giving sound output?", listOf("ස්පීකර්", "Speaker", "ශබ්ද විකාශකය"), "ස්පීකර් (Speakers) වේ.", "ස්පීකර් වේ.")
        4 -> Quintuple("විශාල තිරයකට හෝ බිත්තියකට දර්ශනය ප්‍රක්ෂේපණය කරන උපාංගය කුමක්ද?", "Device projecting display to large screen?", listOf("ප්‍රොජෙක්ටරය", "Projector"), "ප්‍රොජෙක්ටරය (Projector) වේ.", "ප්‍රොජෙක්ටරයයි.")
        5 -> Quintuple("තනි පුද්ගලයෙකුට පමණක් ශබ්දය ඇසීමට කනේ පළඳින උපාංගය කුමක්ද?", "Device worn on ears for personal sound?", listOf("හෙඩ්ෆෝන්", "Headphones"), "හෙඩ්ෆෝන් (Headphones / Earphones) වේ.", "හෙඩ්ෆෝන් වේ.")
        6 -> Quintuple("විශාල ගෘහ නිර්මාණ සැලසුම් මුද්‍රණය කිරීමට භාවිත කරන විශාල මුද්‍රණ යන්ත්‍රය කුමක්ද?", "Large printer used for architectural blueprints?", listOf("ප්ලොටරය", "Plotter"), "ප්ලොටරය (Plotter) වේ.", "ප්ලොටරයයි.")
        7 -> Quintuple("තිරයක රූපයක් සෑදෙන කුඩාම ලක්ෂ්‍යය හඳුන්වන්නේ කෙසේද?", "Smallest element forming image on screen?", listOf("පික්සලය", "Pixel"), "පික්සලයක් (Pixel) නමිනි.", "පික්සලය වේ.")
        8 -> Quintuple("තිරයක පැහැදිලි බව හෙවත් තිර විභේදනය මනින ඒකකය කුමක්ද?", "Measure of screen clarity?", listOf("Resolution", "විභේදනය", "Pixels"), "විභේදනය (Resolution / Pixels) වේ.", "Resolution වේ.")
        9 -> Quintuple("ටෝනර් (Toner) කුඩු භාවිත කර අධිවේගයෙන් මුද්‍රණය කරන ප්‍රින්ටර් වර්ගය කුමක්ද?", "Printer using toner powder?", listOf("ලේසර්", "Laser printer"), "ලේසර් මුද්‍රණ යන්ත්‍ර (Laser Printer) වේ.", "ලේසර් ප්‍රින්ටර් වේ.")
        10 -> Quintuple("ද්‍රව තීන්ත බිඳිති විදීමෙන් මුද්‍රණය කරන මුද්‍රණ යන්ත්‍ර වර්ගය කුමක්ද?", "Printer spraying liquid ink droplets?", listOf("ඉන්ක්ජෙට්", "Inkjet printer"), "ඉන්ක්ජෙට් (Inkjet) මුද්‍රණ යන්ත්‍ර වේ.", "Inkjet වේ.")
        11 -> Quintuple("රිබන් පටියකට තට්ටු කරමින් මුද්‍රණය කරන පැරණි මුද්‍රණ යන්ත්‍ර වර්ගය කුමක්ද?", "Printer striking ribbon pins?", listOf("Dot Matrix", "ඩොට් මැට්‍රික්ස්"), "ඩොට් මැට්‍රික්ස් (Dot Matrix) වේ.", "Dot matrix වේ.")
        12 -> Quintuple("කඩදාසියක මුද්‍රිත පිටපතක් හඳුන්වන්නේ Hard copy ලෙසද Soft copy ලෙසද?", "Printed paper copy called Hard or Soft copy?", listOf("Hard copy", "හාඩ් කොපි"), "Hard copy (දෘඪ පිටපතක්) නමිනි.", "Hard copy වේ.")
        13 -> Quintuple("පරිගණක තිරයේ දකින ඩිජිටල් ගොනුවක් හඳුන්වන්නේ Hard copy ද Soft copy ද?", "Digital file on screen called Hard or Soft copy?", listOf("Soft copy", "සොෆ්ට් කොපි"), "Soft copy (මෘදු පිටපතක්) නමිනි.", "Soft copy වේ.")
        14 -> Quintuple("මුද්‍රණ යන්ත්‍රයක මුද්‍රණ වේගය මනින ඒකකය කුමක්ද?", "Unit of printer speed?", listOf("PPM", "Pages per minute"), "PPM (Pages Per Minute) වේ.", "PPM වේ.")
        15 -> Quintuple("ප්‍රින්ටරයක මුද්‍රණ ගුණාත්මකභාවය මනින ඒකකය කුමක්ද?", "Unit of print quality?", listOf("DPI", "Dots per inch"), "DPI (Dots Per Inch) වේ.", "DPI වේ.")
        16 -> Quintuple("LCD යන්නෙහි සම්පූර්ණ නම කුමක්ද?", "What does LCD stand for?", listOf("Liquid Crystal Display"), "Liquid Crystal Display වේ.", "LCD වේ.")
        17 -> Quintuple("LED යන්නෙහි සම්පූර්ණ නම කුමක්ද?", "What does LED stand for?", listOf("Light Emitting Diode"), "Light Emitting Diode වේ.", "LED වේ.")
        18 -> Quintuple("වර්ණ මොනිටරයක මූලික ආලෝක වර්ණ 3 මොනවාද?", "Three primary light colors in monitor?", listOf("RGB", "රතු කොළ නිල්", "Red Green Blue"), "රතු, කොළ, නිල් (RGB) වේ.", "RGB වේ.")
        19 -> Quintuple("ස්පර්ශ තිරය (Touchscreen) ආදාන මෙන්ම ප්‍රතිදාන උපාංගයක්ද?", "Is touchscreen both input and output?", listOf("ඔව්", "එසේය"), "ඔව්, ආදාන සහ ප්‍රතිදාන දෙකම වේ.", "දෙකම වේ.")
        20 -> Quintuple("පරිගණක මොනිටරයක ප්‍රමාණය මනින්නේ විකර්ණවද තිරස්වද?", "Is monitor screen measured diagonally or horizontally?", listOf("විකර්ණව", "diagonally"), "විකර්ණව අඟල් (Inches) වලිනි.", "විකර්ණව වේ.")
        else -> Quintuple("ස්පීකර් යනු ප්‍රතිදාන උපාංගයක්ද?", "Is speaker an output device?", listOf("ඔව්", "එසේය"), "ඔව්, ප්‍රතිදාන උපාංගයකි.", "ඔව් වේ.")
      }

      // Set 4: මතකය & දත්ත ආචයනය
      4 -> when (qIndex) {
        1 -> Quintuple("පරිගණකයේ ප්‍රධාන තාවකාලික මතකය කුමක්ද?", "Primary temporary volatile memory?", listOf("RAM", "රැම්"), "RAM (Random Access Memory) වේ.", "RAM වේ.")
        2 -> Quintuple("පරිගණකය නිවා දැමූ පසු RAM හි දත්ත මැකී යයිද?", "Are RAM contents erased when power is off?", listOf("ඔව්", "මැකී යයි", "එසේය"), "ඔව්, එය නශ්වර (Volatile) මතකයකි.", "මැකී යයි.")
        3 -> Quintuple("පරිගණකය පණගන්වන මූලික උපදෙස් ස්ථිරව ගබඩා කර ඇති මතකය කුමක්ද?", "Permanent memory storing startup boot instructions?", listOf("ROM", "රොම්"), "ROM (Read Only Memory) වේ.", "ROM වේ.")
        4 -> Quintuple("ROM හි දත්ත විදුලිය විසන්ධි වූ විට මැකී යයිද?", "Are ROM contents lost when power is off?", listOf("නැත", "නැහැ"), "නැත, එය අනශ්වර (Non-volatile) මතකයකි.", "නැත.")
        5 -> Quintuple("පරිගණකයක ධාරිතාව මනින කුඩාම ඒකකය කුමක්ද?", "Smallest unit of computer storage?", listOf("බිටුව", "බිට්", "Bit"), "බිටුව (Bit - 0 හෝ 1) වේ.", "Bit වේ.")
        6 -> Quintuple("බිටු (Bits) 8ක් එකතු වූ විට සෑදෙන ඒකකය කුමක්ද?", "What is 8 bits?", listOf("බයිට්", "බයිටයක්", "Byte"), "බයිටයක් (1 Byte) වේ.", "Byte වේ.")
        7 -> Quintuple("කිලෝබයිට් (1 KB) එකක බයිට් කීයක් තිබේද?", "Bytes in 1 Kilobyte?", listOf("1024", "1024ක්"), "බයිට් 1024කි.", "1024කි.")
        8 -> Quintuple("මෙගාබයිට් (1 MB) එකක කිලෝබයිට් (KB) කීයක් තිබේද?", "Kilobytes in 1 Megabyte?", listOf("1024", "1024ක්"), "කිලෝබයිට් 1024කි.", "1024කි.")
        9 -> Quintuple("ගිගාබයිට් (1 GB) එකක මෙගාබයිට් (MB) කීයක් තිබේද?", "Megabytes in 1 Gigabyte?", listOf("1024", "1024ක්"), "මෙගාබයිට් 1024කි.", "1024කි.")
        10 -> Quintuple("ටෙරාබයිට් (1 TB) එකක ගිගාබයිට් (GB) කීයක් තිබේද?", "Gigabytes in 1 Terabyte?", listOf("1024", "1024ක්"), "ගිගාබයිට් 1024කි.", "1024කි.")
        11 -> Quintuple("පරිගණකයේ විශාල දත්ත ස්ථිරව ගබඩා කරන ප්‍රධාන චුම්භක තැටිය කුමක්ද?", "Main magnetic permanent storage disk?", listOf("දෘඪ තැටිය", "Hard Disk", "HDD"), "දෘඪ තැටිය (Hard Disk Drive / HDD) වේ.", "Hard disk වේ.")
        12 -> Quintuple("සාම්ප්‍රදායික Hard disk එකට වඩා වේගවත් නවීන ආචයන තැටිය කුමක්ද?", "Faster modern solid-state storage drive?", listOf("SSD", "Solid State Drive"), "SSD (Solid State Drive) වේ.", "SSD වේ.")
        13 -> Quintuple("සාමාන්‍ය CD තැටියක සම්මත ධාරිතාව මෙගාබයිට් කීයක් පමණද?", "Standard capacity of a CD?", listOf("700", "700MB", "700ක්"), "700 MB පමණ වේ.", "700 MB වේ.")
        14 -> Quintuple("සාමාන්‍ය DVD තැටියක සම්මත ධාරිතාව ගිගාබයිට් කීයක් පමණද?", "Standard capacity of a DVD?", listOf("4.7", "4.7GB"), "4.7 GB පමණ වේ.", "4.7 GB වේ.")
        15 -> Quintuple("USB පෝට් එකට සවිකර දත්ත ගෙනයන කුඩා මතක උපාංගය කුමක්ද?", "Portable small memory device plugged into USB?", listOf("පෙන් ඩ්‍රයිව්", "Pen drive", "Flash drive"), "පෙන් ඩ්‍රයිව් (Flash Drive / Pen Drive) වේ.", "Pen drive වේ.")
        16 -> Quintuple("කැමරා සහ ජංගම දුරකථනවල දත්ත ගබඩා කරන කුඩා කාඩ්පත කුමක්ද?", "Small memory card used in phones and cameras?", listOf("SD Card", "මතක කාඩ්පත", "Memory card"), "මතක කාඩ්පත (SD / Memory Card) වේ.", "SD card වේ.")
        17 -> Quintuple("CPU සහ ප්‍රධාන මතකය අතර වේගය පාලනය කරන අධිවේගී මතකය කුමක්ද?", "High speed memory between CPU and RAM?", listOf("කෑෂ් මතකය", "Cache memory"), "කෑෂ් මතකය (Cache memory) වේ.", "Cache memory වේ.")
        18 -> Quintuple("අන්තර්ජාලය හරහා දුරස්ථ සර්වරවල දත්ත ගබඩා කිරීම හඳුන්වන්නේ කෙසේද?", "Storing data on remote internet servers?", listOf("ක්ලවුඩ් ආචයනය", "Cloud storage", "Cloud"), "ක්ලවුඩ් ආචයනය (Cloud Storage) නමිනි.", "Cloud storage වේ.")
        19 -> Quintuple("ගූගල් ඩ්‍රයිව් (Google Drive) යනු ක්ලවුඩ් ආචයන සේවාවක්ද?", "Is Google Drive a cloud storage service?", listOf("ඔව්", "එසේය"), "ඔව්, ක්ලවුඩ් ආචයන සේවාවකි.", "ඔව් වේ.")
        20 -> Quintuple("CD, DVD අයත් වන්නේ ප්‍රකාශ (Optical) ආචයන මාධ්‍ය වලටද?", "Are CD and DVD optical storage media?", listOf("ඔව්", "එසේය"), "ඔව්, ප්‍රකාශ (Optical) ආචයන මාධ්‍ය වේ.", "ඔව් වේ.")
        else -> Quintuple("1 Byte යනු බිටු කීයක්ද?", "How many bits in 1 byte?", listOf("8", "අටක්"), "බිටු 8කි.", "8කි.")
      }

      // Set 5: සංඛ්‍යා පද්ධති (Number Systems)
      5 -> when (qIndex) {
        1 -> Quintuple("ද්විමය (Binary) සංඛ්‍යා පද්ධතියේ පාදය කීයද?", "Base of binary number system?", listOf("2", "දෙක"), "2 (දෙක) වේ.", "පාදය 2යි.")
        2 -> Quintuple("ද්විමය සංඛ්‍යා පද්ධතියේ භාවිත වන සංකේත 2 මොනවාද?", "Two symbols used in binary?", listOf("0 සහ 1", "0, 1"), "0 සහ 1 වේ.", "0 සහ 1යි.")
        3 -> Quintuple("දශම (Decimal) සංඛ්‍යා පද්ධතියේ පාදය කීයද?", "Base of decimal number system?", listOf("10", "දහය"), "10 (දහය) වේ.", "පාදය 10යි.")
        4 -> Quintuple("අෂ්ටමය (Octal) සංඛ්‍යා පද්ධතියේ පාදය කීයද?", "Base of octal number system?", listOf("8", "අට"), "8 (අට) වේ.", "පාදය 8යි.")
        5 -> Quintuple("ෂඩ්දශමය (Hexadecimal) සංඛ්‍යා පද්ධතියේ පාදය කීයද?", "Base of hexadecimal system?", listOf("16", "දහසය"), "16 (දහසය) වේ.", "පාදය 16යි.")
        6 -> Quintuple("දශම සංඛ්‍යා 2 හි ද්විමය (Binary) අගය කුමක්ද?", "Binary of decimal 2?", listOf("10", "එකයි බිංදුව"), "10 වේ.", "10 වේ.")
        7 -> Quintuple("දශම සංඛ්‍යා 3 හි ද්විමය (Binary) අගය කුමක්ද?", "Binary of decimal 3?", listOf("11", "එකයි එක"), "11 වේ.", "11 වේ.")
        8 -> Quintuple("දශම සංඛ්‍යා 4 හි ද්විමය (Binary) අගය කුමක්ද?", "Binary of decimal 4?", listOf("100", "එකයි බිංදු දෙක"), "100 වේ.", "100 වේ.")
        9 -> Quintuple("ද්විමය 101 හි දශම අගය කීයද?", "Decimal of binary 101?", listOf("5", "පහ"), "5 (පහ) වේ (4 + 0 + 1 = 5).", "5 වේ.")
        10 -> Quintuple("ෂඩ්දශම සංඛ්‍යා පද්ධතියේ අංක 10 නිරූපණය කරන ඉංග්‍රීසි අකුර කුමක්ද?", "Letter representing 10 in hexadecimal?", listOf("A", "ඒ"), "A අකුර වේ.", "A වේ.")
        11 -> Quintuple("ෂඩ්දශම සංඛ්‍යා පද්ධතියේ අංක 15 නිරූපණය කරන ඉංග්‍රීසි අකුර කුමක්ද?", "Letter representing 15 in hexadecimal?", listOf("F", "එෆ්"), "F අකුර වේ.", "F වේ.")
        12 -> Quintuple("පරිගණකයේ අභ්‍යන්තර පරිපථ තේරුම් ගන්නා එකම භාෂාව කුමක්ද?", "Machine language understood by circuits?", listOf("ද්විමය", "මැෂින් භාෂාව", "Binary"), "ද්විමය භාෂාව (Machine language) වේ.", "ද්විමය වේ.")
        13 -> Quintuple("ද්විමය 1 + 1 එකතු කළ විට පිළිතුර කීයද?", "Binary 1 + 1?", listOf("10", "එකයි බිංදුව"), "10 (දශම අගය 2) වේ.", "10 වේ.")
        14 -> Quintuple("ද්විමය 1 + 0 එකතු කළ විට පිළිතුර කීයද?", "Binary 1 + 0?", listOf("1", "එක"), "1 (එක) වේ.", "1 වේ.")
        15 -> Quintuple("ASCII යනු අක්ෂර කේතන ක්‍රමයක්ද?", "Is ASCII a character encoding standard?", listOf("ඔව්", "එසේය"), "ඔව්, සම්මත කේතනයකි.", "ඔව් වේ.")
        16 -> Quintuple("යූනිකෝඩ් (Unicode) මඟින් සිංහල අකුරු පරිගණකයට කේතනය කළ හැකිද?", "Can Unicode encode Sinhala characters?", listOf("ඔව්", "පුළුවන්", "එසේය"), "ඔව්, ඕනෑම භාෂාවක අකුරු කේතනය කරයි.", "ඔව් වේ.")
        17 -> Quintuple("බිටු 4ක එකතුවක් හඳුන්වන්නේ කෙසේද?", "What is a 4-bit group called?", listOf("නිබලය", "Nibble"), "නිබලයක් (Nibble) නමිනි.", "Nibble වේ.")
        18 -> Quintuple("1 Byte එකක නිබල (Nibbles) කීයක් තිබේද?", "How many nibbles in 1 byte?", listOf("2", "දෙකක්"), "නිබල 2කි.", "2කි.")
        19 -> Quintuple("අෂ්ටම පද්ධතියේ භාවිත වන උපරිම ඉලක්කම කීයද?", "Largest single digit in octal?", listOf("7", "හත"), "7 (හත) වේ.", "7 වේ.")
        20 -> Quintuple("දශම පද්ධතියේ භාවිත වන උපරිම ඉලක්කම කීයද?", "Largest single digit in decimal?", listOf("9", "නවය"), "9 (නවය) වේ.", "9 වේ.")
        else -> Quintuple("ද්විමය පද්ධතියේ පාදය කීයද?", "Base of binary?", listOf("2", "දෙක"), "2 වේ.", "2 වේ.")
      }

      // Set 6: තාර්කික ද්වාර (Logic Gates)
      6 -> when (qIndex) {
        1 -> Quintuple("මූලික තාර්කික ද්වාර 3න් එකක් නම් කරන්න.", "Name one of the 3 basic logic gates.", listOf("AND", "OR", "NOT"), "AND, OR හෝ NOT ද්වාරය වේ.", "AND, OR, NOT වේ.")
        2 -> Quintuple("ආදාන සියල්ලම 1 වූ විට පමණක් ප්‍රතිදානය 1 වන ද්වාරය කුමක්ද?", "Gate outputting 1 only when all inputs are 1?", listOf("AND", "ඇන්ඩ්"), "AND ද්වාරය වේ.", "AND ද්වාරයයි.")
        3 -> Quintuple("ඕනෑම එක් ආදානයක් 1 වූ විට ප්‍රතිදානය 1 වන ද්වාරය කුමක්ද?", "Gate outputting 1 if any input is 1?", listOf("OR", "ඕර්"), "OR ද්වාරය වේ.", "OR ද්වාරයයි.")
        4 -> Quintuple("ආදානය ප්‍රතිලෝම (1 දුන් විට 0 ද, 0 දුන් විට 1 ද) කරන ද්වාරය කුමක්ද?", "Inverter gate flipping input?", listOf("NOT", "නොට්", "ඉන්වර්ටරය"), "NOT ද්වාරය (Inverter) වේ.", "NOT ද්වාරයයි.")
        5 -> Quintuple("NOT ද්වාරයකට ආදාන (Inputs) කීයක් තිබේද?", "How many inputs in a NOT gate?", listOf("1", "1ක්", "එකක්"), "1ක් පමණි.", "1ක් පමණි.")
        6 -> Quintuple("AND ද්වාරයකට 1 සහ 0 ආදාන කළ විට ප්‍රතිදානය කීයද?", "Output of AND gate for 1 and 0?", listOf("0", "බිංදුව"), "0 (ශුන්‍යය) වේ.", "0 වේ.")
        7 -> Quintuple("OR ද්වාරයකට 1 සහ 0 ආදාන කළ විට ප්‍රතිදානය කීයද?", "Output of OR gate for 1 and 0?", listOf("1", "එක"), "1 (එක) වේ.", "1 වේ.")
        8 -> Quintuple("AND ද්වාරයක් ඉදිරියට NOT ද්වාරයක් සම්බන්ධ කළ විට සෑදෙන ද්වාරය කුමක්ද?", "AND gate combined with NOT gate?", listOf("NAND", "නෑන්ඩ්"), "NAND ද්වාරය වේ.", "NAND වේ.")
        9 -> Quintuple("OR ද්වාරයක් ඉදිරියට NOT ද්වාරයක් සම්බන්ධ කළ විට සෑදෙන ද්වාරය කුමක්ද?", "OR gate combined with NOT gate?", listOf("NOR", "නෝර්"), "NOR ද්වාරය වේ.", "NOR වේ.")
        10 -> Quintuple("ද්වාරයක ආදාන සහ ප්‍රතිදාන පෙන්වන වගුව හඳුන්වන්නේ කෙසේද?", "Table showing gate inputs and outputs?", listOf("සත්‍යතා වගුව", "Truth table"), "සත්‍යතා වගුව (Truth Table) නමිනි.", "සත්‍යතා වගුවයි.")
        11 -> Quintuple("සාර්වත්‍ර (Universal) ද්වාර ලෙස හඳුන්වන ද්වාර දෙක මොනවාද?", "Two universal gates?", listOf("NAND සහ NOR", "NAND, NOR"), "NAND සහ NOR ද්වාර වේ.", "NAND සහ NOR වේ.")
        12 -> Quintuple("NOT ද්වාරයකට 0 දුන් විට ලැබෙන ප්‍රතිදානය කීයද?", "Output of NOT gate for 0?", listOf("1", "එක"), "1 (එක) වේ.", "1 වේ.")
        13 -> Quintuple("NOT ද්වාරයකට 1 දුන් විට ලැබෙන ප්‍රතිදානය කීයද?", "Output of NOT gate for 1?", listOf("0", "බිංදුව"), "0 (ශුන්‍යය) වේ.", "0 වේ.")
        14 -> Quintuple("AND ද්වාරයකට 1 සහ 1 ආදාන කළ විට ප්‍රතිදානය කීයද?", "AND gate for 1 and 1?", listOf("1", "එක"), "1 වේ.", "1 වේ.")
        15 -> Quintuple("OR ද්වාරයකට 0 සහ 0 ආදාන කළ විට ප්‍රතිදානය කීයද?", "OR gate for 0 and 0?", listOf("0", "බිංදුව"), "0 වේ.", "0 වේ.")
        16 -> Quintuple("තාර්කික අගයන්හි 1 මඟින් සත්‍ය (True) නිරූපණය වේද?", "Does 1 represent True?", listOf("ඔව්", "එසේය"), "ඔව්, 1 යනු True වේ.", "ඔව් වේ.")
        17 -> Quintuple("තාර්කික අගයන්හි 0 මඟින් අසත්‍ය (False) නිරූපණය වේද?", "Does 0 represent False?", listOf("ඔව්", "එසේය"), "ඔව්, 0 යනු False වේ.", "ඔව් වේ.")
        18 -> Quintuple("තාර්කික ද්වාර තැනීමට යොදාගන්නා මූලික ඉලෙක්ට්‍රොනික උපාංගය කුමක්ද?", "Electronic component building logic gates?", listOf("ට්‍රාන්සිස්ටරය", "Transistor"), "ට්‍රාන්සිස්ටරය (Transistor) වේ.", "ට්‍රාන්සිස්ටරයයි.")
        19 -> Quintuple("NAND ද්වාරයකට 1 සහ 1 ආදාන කළ විට ලැබෙන ප්‍රතිදානය කීයද?", "NAND gate for 1 and 1?", listOf("0", "බිංදුව"), "0 වේ (AND ප්‍රතිලෝම වේ).", "0 වේ.")
        20 -> Quintuple("NOR ද්වාරයකට 0 සහ 0 ආදාන කළ විට ලැබෙන ප්‍රතිදානය කීයද?", "NOR gate for 0 and 0?", listOf("1", "එක"), "1 වේ (OR ප්‍රතිලෝම වේ).", "1 වේ.")
        else -> Quintuple("මූලික ද්වාර සංඛ්‍යාව කීයද?", "How many basic gates?", listOf("3", "තුනයි"), "3කි (AND, OR, NOT).", "3කි.")
      }

      // Set 7: මෙහෙයුම් පද්ධති & මෘදුකාංග
      7 -> when (qIndex) {
        1 -> Quintuple("පරිගණක දෘඩාංග සහ පරිශීලකයා අතර පාලනය සලසන ප්‍රධාන මෘදුකාංගය කුමක්ද?", "Main software controlling hardware and user?", listOf("මෙහෙයුම් පද්ධතිය", "Operating System", "OS"), "මෙහෙයුම් පද්ධතිය (Operating System / OS) වේ.", "OS වේ.")
        2 -> Quintuple("ලොව වඩාත්ම ජනප්‍රිය ඩෙස්ක්ටොප් මෙහෙයුම් පද්ධතිය කුමක්ද?", "Most popular desktop OS?", listOf("Windows", "වින්ඩෝස්"), "Microsoft Windows වේ.", "Windows වේ.")
        3 -> Quintuple("ස්මාර්ට්ෆෝන් සඳහා ලොව වැඩිපුරම භාවිත වන නිදහස් මෙහෙයුම් පද්ධතිය කුමක්ද?", "Most popular mobile OS?", listOf("Android", "ඇන්ඩ්‍රොයිඩ්"), "Android (ඇන්ඩ්‍රොයිඩ්) වේ.", "Android වේ.")
        4 -> Quintuple("Apple සමාගමේ පරිගණක සඳහා භාවිත වන මෙහෙයුම් පද්ධතිය කුමක්ද?", "Apple computer operating system?", listOf("macOS", "Mac OS"), "macOS වේ.", "macOS වේ.")
        5 -> Quintuple("විවෘත හා නොමිලේ ලබාගත හැකි (Open Source) මෙහෙයුම් පද්ධතියක් නම් කරන්න.", "Name an open-source OS.", listOf("Linux", "Ubuntu", "ලිනක්ස්"), "Linux (ලිනක්ස්) හෝ Ubuntu වේ.", "Linux වේ.")
        6 -> Quintuple("GUI යන්නෙහි සම්පූර්ණ තේරුම කුමක්ද?", "What does GUI stand for?", listOf("Graphical User Interface"), "Graphical User Interface (චිත්‍රක පරිශීලක අතුරුමුහුණත) වේ.", "GUI වේ.")
        7 -> Quintuple("CLI යනු විධාන මඟින් ක්‍රියාකරන අතුරුමුහුණතක්ද?", "Is CLI command-line interface?", listOf("ඔව්", "එසේය"), "ඔව්, Command Line Interface වේ.", "ඔව් වේ.")
        8 -> Quintuple("යම් නිශ්චිත කාර්යයක් සඳහා භාවිත කරන මෘදුකාංග හඳුන්වන්නේ කෙසේද?", "Software for a specific task?", listOf("යෙදුම් මෘදුකාංග", "Application software"), "යෙදුම් මෘදුකාංග (Application Software) නමිනි.", "යෙදුම් මෘදුකාංගයි.")
        9 -> Quintuple("පරිගණකයේ ආරක්ෂාව සහ නඩත්තුව සඳහා ඇති මෘදුකාංග හඳුන්වන්නේ කෙසේද?", "Software for system maintenance and safety?", listOf("උපයෝගීතා මෘදුකාංග", "Utility software"), "උපයෝගීතා මෘදුකාංග (Utility Software) නමිනි.", "Utility software වේ.")
        10 -> Quintuple("පරිගණක දෘඩාංගයක් මෙහෙයුම් පද්ධතියට හඳුන්වා දෙන කුඩා මෘදුකාංගය කුමක්ද?", "Software linking hardware to OS?", listOf("Driver", "උපාංග ධාවකය", "Device driver"), "උපාංග ධාවකය (Device Driver) වේ.", "Driver වේ.")
        11 -> Quintuple("පරිගණකයක එකවර වැඩසටහන් කිහිපයක් ධාවනය කිරීම හඳුන්වන්නේ කෙසේද?", "Running multiple programs at once?", listOf("Multitasking", "බහුකාර්ය"), "Multitasking (බහුකාර්යතාව) නමිනි.", "Multitasking වේ.")
        12 -> Quintuple("මුදල් නොගෙවා නොමිලේ භාවිත කළ හැකි මෘදුකාංග හඳුන්වන්නේ කෙසේද?", "Software free to use?", listOf("Freeware", "නොමිලේ", "Open source"), "Freeware හෝ විවෘත කේත මෘදුකාංග නමිනි.", "Freeware වේ.")
        13 -> Quintuple("අත්හදා බැලීමට කෙටි කලකට නොමිලේ දෙන මෘදුකාංග හඳුන්වන්නේ කෙසේද?", "Trial software free for short time?", listOf("Shareware", "ට්‍රයල්", "Trial"), "Shareware (ට්‍රයල් මෘදුකාංග) නමිනි.", "Shareware වේ.")
        14 -> Quintuple("පරිගණකයේ ගොනු කළමනාකරණය කරන්නේ මෙහෙයුම් පද්ධතිය මඟින්ද?", "Does OS manage computer files?", listOf("ඔව්", "එසේය"), "ඔව්, ගොනු පද්ධතිය මෙහෙයුම් පද්ධතිය පාලනය කරයි.", "ඔව් වේ.")
        15 -> Quintuple("iPhone දුරකථනවල ධාවනය වන මෙහෙයුම් පද්ධතිය කුමක්ද?", "OS running on iPhones?", listOf("iOS"), "iOS වේ.", "iOS වේ.")
        16 -> Quintuple("පරිගණකයේ තිරයේ ඇති පසුබිම් රූපය හඳුන්වන්නේ කෙසේද?", "Background image on screen?", listOf("Wallpaper", "පසුබිම් රූපය"), "Wallpaper (ඩෙස්ක්ටොප් පසුබිම) නමිනි.", "Wallpaper වේ.")
        17 -> Quintuple("වැඩසටහනක් නියෝජනය කරන කුඩා චිත්‍රක රූපය හඳුන්වන්නේ කෙසේද?", "Small pictorial representation of a program?", listOf("අයිකනය", "Icon"), "අයිකනයක් (Icon) නමිනි.", "Icon වේ.")
        18 -> Quintuple("වින්ඩෝස් තිරයේ පහළම පිහිටි තීරුව කුමක්ද?", "Bottom bar on Windows screen?", listOf("කාර්ය තීරුව", "Taskbar"), "කාර්ය තීරුව (Taskbar) වේ.", "Taskbar වේ.")
        19 -> Quintuple("මකා දැමූ ගොනු තාවකාලිකව තැන්පත් වන ස්ථානය කුමක්ද?", "Place where deleted files go temporarily?", listOf("Recycle Bin", "කුණු බක්කිය"), "Recycle Bin වේ.", "Recycle Bin වේ.")
        20 -> Quintuple("Recycle Bin එකෙන් මකා දැමූ ගොනුවක් නැවත ලබාගත හැකිද?", "Can you restore from Recycle Bin?", listOf("ඔව්", "පුළුවන්", "Restore"), "ඔව්, Restore කර නැවත ලබාගත හැකිය.", "ඔව් වේ.")
        else -> Quintuple("Windows යනු මෙහෙයුම් පද්ධතියක්ද?", "Is Windows an OS?", listOf("ඔව්", "එසේය"), "ඔව්, මෙහෙයුම් පද්ධතියකි.", "ඔව් වේ.")
      }

      // Set 8: කාර්යාලීය යෙදුම් (MS Word, Excel, PowerPoint)
      8 -> when (qIndex) {
        1 -> Quintuple("ලිපි ලේඛන සකස් කිරීමට භාවිත කරන ජනප්‍රිය මෘදුකාංගය කුමක්ද?", "Popular software for word processing and letters?", listOf("MS Word", "Word", "මයික්‍රොසොෆ්ට් වර්ඩ්"), "Microsoft Word වේ.", "MS Word වේ.")
        2 -> Quintuple("ගණනය කිරීම් සහ ප්‍රස්ථාර සඳහා භාවිත කරන පැතුරුම්පත් මෘදුකාංගය කුමක්ද?", "Spreadsheet software for calculations and graphs?", listOf("MS Excel", "Excel"), "Microsoft Excel වේ.", "MS Excel වේ.")
        3 -> Quintuple("ඉදිරිපත් කිරීම් (Presentations) සකස් කිරීමට භාවිත කරන මෘදුකාංගය කුමක්ද?", "Software used for presentations and slides?", listOf("PowerPoint", "MS PowerPoint"), "Microsoft PowerPoint වේ.", "PowerPoint වේ.")
        4 -> Quintuple("පැතුරුම්පතක තිරස් පේළි හඳුන්වන්නේ කෙසේද?", "Horizontal lines in spreadsheet?", listOf("පේළි", "Rows"), "පේළි (Rows - අංක මඟින් දක්වයි).", "Rows වේ.")
        5 -> Quintuple("පැතුරුම්පතක සිරස් තීරු හඳුන්වන්නේ කෙසේද?", "Vertical lines in spreadsheet?", listOf("තීරු", "Columns"), "තීරු (Columns - අකුරු මඟින් දක්වයි).", "Columns වේ.")
        6 -> Quintuple("පේළියක් සහ තීරුවක් ඡේදනය වන කුඩා කොටුව හඳුන්වන්නේ කෙසේද?", "Intersection of row and column?", listOf("සෛලය", "Cell"), "සෛලයක් (Cell) නමිනි.", "Cell වේ.")
        7 -> Quintuple("Excel හි සෛලයක අගයන් එකතු කිරීමට භාවිත කරන සරල ශ්‍රිතය කුමක්ද?", "Function used to add numbers in Excel?", listOf("SUM", "=SUM"), "SUM ශ්‍රිතය (=SUM) වේ.", "SUM වේ.")
        8 -> Quintuple("Excel හි සාමාන්‍යය සෙවීමට භාවිත කරන ශ්‍රිතය කුමක්ද?", "Function to find average in Excel?", listOf("AVERAGE", "=AVERAGE"), "AVERAGE ශ්‍රිතය වේ.", "AVERAGE වේ.")
        9 -> Quintuple("Excel හි උපරිම අගය සෙවීමට භාවිත කරන ශ්‍රිතය කුමක්ද?", "Function to find max value in Excel?", listOf("MAX", "=MAX"), "MAX ශ්‍රිතය වේ.", "MAX වේ.")
        10 -> Quintuple("Excel හි අවම අගය සෙවීමට භාවිත කරන ශ්‍රිතය කුමක්ද?", "Function to find min value in Excel?", listOf("MIN", "=MIN"), "MIN ශ්‍රිතය වේ.", "MIN වේ.")
        11 -> Quintuple("Excel හි සූත්‍රයක් (Formula) ආරම්භ කරන අනිවාර්ය ලකුණ කුමක්ද?", "Symbol starting formula in Excel?", listOf("=", "සමාන ලකුණ"), "සමාන ලකුණ (=) වේ.", "සමාන ලකුණයි.")
        12 -> Quintuple("Word හි තෝරාගත් අකුරු තද කිරීමට (Bold) භාවිත කරන කෙටිමං යතුර කුමක්ද?", "Shortcut for Bold in Word?", listOf("Ctrl+B", "Ctrl B"), "Ctrl + B වේ.", "Ctrl + B වේ.")
        13 -> Quintuple("Word හි තෝරාගත් අකුරු ඇල කිරීමට (Italic) කෙටිමං යතුර කුමක්ද?", "Shortcut for Italic in Word?", listOf("Ctrl+I", "Ctrl I"), "Ctrl + I වේ.", "Ctrl + I වේ.")
        14 -> Quintuple("Word හි අකුරු යටින් ඉරක් ඇඳීමට (Underline) කෙටිමං යතුර කුමක්ද?", "Shortcut for Underline in Word?", listOf("Ctrl+U", "Ctrl U"), "Ctrl + U වේ.", "Ctrl + U වේ.")
        15 -> Quintuple("ලේඛනයක් පිටපත් කිරීමට (Copy) කෙටිමං යතුර කුමක්ද?", "Shortcut to Copy?", listOf("Ctrl+C", "Ctrl C"), "Ctrl + C වේ.", "Ctrl + C වේ.")
        16 -> Quintuple("පිටපත් කළ දෙයක් ඇලවීමට (Paste) කෙටිමං යතුර කුමක්ද?", "Shortcut to Paste?", listOf("Ctrl+V", "Ctrl V"), "Ctrl + V වේ.", "Ctrl + V වේ.")
        17 -> Quintuple("ලේඛනයක් සුරැකීමට (Save) කෙටිමං යතුර කුමක්ද?", "Shortcut to Save?", listOf("Ctrl+S", "Ctrl S"), "Ctrl + S වේ.", "Ctrl + S වේ.")
        18 -> Quintuple("PowerPoint හි එක් තිරයක් හඳුන්වන්නේ Slide ලෙසද Cell ලෙසද?", "One screen in PowerPoint called Slide or Cell?", listOf("Slide", "ස්ලයිඩ්", "කදාව"), "Slide (කදාව) නමිනි.", "Slide වේ.")
        19 -> Quintuple("මුද්‍රණය කිරීමට පෙර ලේඛනය පරීක්ෂා කර බැලීම කුමක් නමින්ද?", "Checking document before printing?", listOf("Print Preview", "මුද්‍රණ පෙරදසුන"), "Print Preview (මුද්‍රණ පෙරදසුන) නමිනි.", "Print Preview වේ.")
        20 -> Quintuple("ලේඛනයක් මුද්‍රණය කිරීමට (Print) කෙටිමං යතුර කුමක්ද?", "Shortcut to Print?", listOf("Ctrl+P", "Ctrl P"), "Ctrl + P වේ.", "Ctrl + P වේ.")
        else -> Quintuple("Word ලේඛනයක පෙරනිමි දිගුව .docx ද?", "Default extension of Word is .docx?", listOf("ඔව්", "එසේය"), "ඔව්, .docx වේ.", "ඔව් වේ.")
      }

      // Set 9: පරිගණක ජාල & අන්තර්ජාලය (Networking & Web)
      9 -> when (qIndex) {
        1 -> Quintuple("කුඩා ප්‍රදේශයක (නිවසක හෝ පාසලක) පරිගණක සම්බන්ධ කරන ජාලය කුමක්ද?", "Network in small area like school or home?", listOf("LAN", "Local Area Network"), "LAN (Local Area Network) වේ.", "LAN වේ.")
        2 -> Quintuple("ලොව පුරා විසිරී ඇති විශාලතම පරිගණක ජාලය කුමක්ද?", "Largest network spreading worldwide?", listOf("අන්තර්ජාලය", "Internet", "WAN"), "අන්තර්ජාලය (Internet / WAN) වේ.", "අන්තර්ජාලයයි.")
        3 -> Quintuple("WAN යන්නෙහි සම්පූර්ණ නම කුමක්ද?", "What does WAN stand for?", listOf("Wide Area Network"), "Wide Area Network වේ.", "WAN වේ.")
        4 -> Quintuple("WWW යන්නෙහි සම්පූර්ණ තේරුම කුමක්ද?", "What does WWW stand for?", listOf("World Wide Web"), "World Wide Web වේ.", "WWW වේ.")
        5 -> Quintuple("අන්තර්ජාලයේ වෙබ් අඩවි බැලීමට භාවිත කරන මෘදුකාංගය කුමක්ද?", "Software to view websites?", listOf("බ්‍රවුසරය", "Web Browser", "Chrome"), "වෙබ් බ්‍රවුසරය (Web Browser) වේ.", "Web browser වේ.")
        6 -> Quintuple("ජනප්‍රිය වෙබ් බ්‍රවුසරයකට උදාහරණයක් පවසන්න.", "Example of popular web browser?", listOf("Google Chrome", "Chrome", "Firefox", "Edge"), "Google Chrome හෝ Firefox වේ.", "Chrome වේ.")
        7 -> Quintuple("වෙබ් අඩවි සෙවීමට භාවිත කරන සෙවුම් යන්ත්‍රයකට (Search Engine) උදාහරණයක් පවසන්න.", "Example of search engine?", listOf("Google", "ගූගල්", "Bing", "Yahoo"), "Google (ගූගල්) වේ.", "Google වේ.")
        8 -> Quintuple("වෙබ් අඩවියක අද්විතීය අන්තර්ජාල ලිපිනය හඳුන්වන්නේ කෙසේද?", "Unique website internet address?", listOf("URL"), "URL (Uniform Resource Locator) වේ.", "URL වේ.")
        9 -> Quintuple("ජාලයක ඇති සෑම පරිගණකයකටම හිමි අනන්‍ය අංකය කුමක්ද?", "Unique numerical address for every computer on network?", listOf("IP ලිපිනය", "IP Address", "IP"), "IP ලිපිනය (IP Address) වේ.", "IP ලිපිනයයි.")
        10 -> Quintuple("වෙබ් පිටු නිර්මාණය සඳහා භාවිත කරන මූලික භාෂාව කුමක්ද?", "Core language used to build web pages?", listOf("HTML"), "HTML වේ.", "HTML වේ.")
        11 -> Quintuple("HTML යන්නෙහි සම්පූර්ණ නම කුමක්ද?", "What does HTML stand for?", listOf("HyperText Markup Language"), "HyperText Markup Language වේ.", "HTML වේ.")
        12 -> Quintuple("විද්‍යුත් තැපෑල හඳුන්වන කෙටි නම කුමක්ද?", "Short name for Electronic Mail?", listOf("Email", "ඊමේල්"), "Email වේ.", "Email වේ.")
        13 -> Quintuple("ඊමේල් ලිපිනයක නම සහ සේවාදායකයා වෙන් කරන සංකේතය කුමක්ද?", "Symbol separating name and domain in email?", listOf("@", "ඇට්", "at"), "@ (At sign) වේ.", "@ ලකුණයි.")
        14 -> Quintuple("රැහැන් රහිතව අන්තර්ජාලය සම්බන්ධ කරන ජනප්‍රිය තාක්ෂණය කුමක්ද?", "Popular wireless internet technology?", listOf("Wi-Fi", "වයිෆයි"), "Wi-Fi වේ.", "Wi-Fi වේ.")
        15 -> Quintuple("කෙටි දුරක් තුළ උපකරණ රැහැන් රහිතව සම්බන්ධ කරන තාක්ෂණය කුමක්ද?", "Short range wireless technology?", listOf("බ්ලූටූත්", "Bluetooth"), "බ්ලූටූත් (Bluetooth) වේ.", "Bluetooth වේ.")
        16 -> Quintuple("අන්තර්ජාලයට පරිගණකයක් සම්බන්ධ කිරීමට දුරකථන හෝ ෆයිබර් මාර්ගය හා සම්බන්ධ කරන උපාංගය කුමක්ද?", "Device connecting home network to ISP?", listOf("මොඩමයක්", "Modem", "රවුටරය", "Router"), "මොඩමයක් (Modem) හෝ රවුටරයක් වේ.", "Router / Modem වේ.")
        17 -> Quintuple("වෙබ් පිටුවක තවත් පිටුවකට සම්බන්ධ වන සබැඳිය හඳුන්වන්නේ කෙසේද?", "Clickable link leading to another page?", listOf("හයිපර්ලින්ක්", "Hyperlink", "Link"), "හයිපර්ලින්ක් (Hyperlink) නමිනි.", "Hyperlink වේ.")
        18 -> Quintuple("වෙබ් අඩවියක මුල්ම ප්‍රධාන පිටුව හඳුන්වන්නේ කෙසේද?", "First main page of a website?", listOf("Home page", "මුල් පිටුව"), "මුල් පිටුව (Home Page) නමිනි.", "Home page වේ.")
        19 -> Quintuple("HTTPS හි ඇති 'S' අකුරෙන් අදහස් වන්නේ කුමක්ද?", "What does 'S' in HTTPS mean?", listOf("Secure", "ආරක්ෂිත"), "Secure (ආරක්ෂිත) යන්නයි.", "Secure වේ.")
        20 -> Quintuple("අන්තර්ජාලයෙන් ගොනුවක් අපේ පරිගණකයට ලබාගැනීම කුමක් නමින්ද?", "Getting file from internet to local computer?", listOf("Download", "බාගත කිරීම"), "Download (බාගත කිරීම) නමිනි.", "Download වේ.")
        else -> Quintuple("අපේ පරිගණකයෙන් ගොනුවක් අන්තර්ජාලයට යැවීම Upload ද?", "Sending file to internet is Upload?", listOf("ඔව්", "එසේය"), "ඔව්, Upload කිරීමයි.", "ඔව් වේ.")
      }

      // Set 10: තොරතුරු ආරක්ෂාව & සදාචාරය (Security & Ethics)
      10 -> when (qIndex) {
        1 -> Quintuple("පරිගණකයට හානි කිරීමට හිතාමතා සාදන අනිෂ්ට වැඩසටහන් හඳුන්වන්නේ කෙසේද?", "Malicious programs created to harm computers?", listOf("වයිරස", "Virus", "මැල්වෙයා", "Malware"), "පරිගණක වයිරස (Virus / Malware) නමිනි.", "වයිරස වේ.")
        2 -> Quintuple("පරිගණක වයිරස විනාශ කිරීමට සහ ආරක්ෂා වීමට භාවිත කරන මෘදුකාංග කුමක්ද?", "Software to destroy viruses and protect system?", listOf("ඇන්ටිවයිරස්", "Antivirus"), "ඇන්ටිවයිරස් (Antivirus) මෘදුකාංග වේ.", "Antivirus වේ.")
        3 -> Quintuple("ජනප්‍රිය ඇන්ටිවයිරස් මෘදුකාංගයකට උදාහරණයක් පවසන්න.", "Example of popular antivirus software?", listOf("Kaspersky", "Avast", "Norton", "Windows Defender"), "Kaspersky, Avast හෝ Windows Defender වේ.", "Defender / Avast වේ.")
        4 -> Quintuple("අනවසරයෙන් ජාලයට ඇතුළුවීම වළක්වන ආරක්ෂක පවුර කුමක්ද?", "Security wall preventing unauthorized network access?", listOf("ෆයර්වෝල්", "Firewall"), "ෆයර්වෝල් (Firewall) වේ.", "Firewall වේ.")
        5 -> Quintuple("අනවසරයෙන් වෙනත් අයෙකුගේ පරිගණක පද්ධතියකට ඇතුළු වන පුද්ගලයා කවුද?", "Person illegally breaking into computer systems?", listOf("හැකර්", "Hacker"), "හැකර් (Hacker) නමිනි.", "Hacker වේ.")
        6 -> Quintuple("ශක්තිමත් මුරපදයක (Strong Password) අවම වශයෙන් අකුරු කීයක් තිබිය යුතුද?", "Minimum recommended length of strong password?", listOf("8", "8ක්", "අටක්"), "අවම වශයෙන් අක්ෂර 8ක් හෝ ඊට වැඩි විය යුතුය.", "8ක් හෝ ඊට වැඩියි.")
        7 -> Quintuple("මුරපදයක් සාදන විට අංක, සංකේත සහ කැපිටල් අකුරු මිශ්‍ර කළ යුතුද?", "Should password mix numbers, symbols and capital letters?", listOf("ඔව්", "එසේය"), "ඔව්, ආරක්ෂාව වැඩිවේ.", "ඔව් වේ.")
        8 -> Quintuple("ව්‍යාජ වෙබ් අඩවි හෝ ඊමේල් මඟින් මුරපද සොරකම් කිරීමේ ප්‍රයෝගය කුමක්ද?", "Tricking users to steal passwords via fake emails?", listOf("ෆිෂින්", "Phishing"), "ෆිෂින් (Phishing) ප්‍රහාර නමිනි.", "Phishing වේ.")
        9 -> Quintuple("අපේ මුරපදය (Password) මිතුරන් සමඟ බෙදාගත යුතුද?", "Should you share your password with friends?", listOf("නැත", "නැහැ"), "නැත, රහසිගතව තබාගත යුතුය.", "නැත.")
        10 -> Quintuple("වැදගත් දත්ත නැතිවීම වළක්වා ගැනීමට වෙනත් තැනක පිටපතක් තබා ගැනීම කුමක්ද?", "Keeping copy of important data elsewhere?", listOf("බැකප්", "Backup", "උපස්ථ"), "බැකප් කිරීම (Backup / උපස්ථ) නමිනි.", "Backup වේ.")
        11 -> Quintuple("අන්තර්ජාලය හරහා අනවශ්‍ය ලෙස එන ප්‍රචාරක ඊමේල් හඳුන්වන්නේ කෙසේද?", "Unwanted spam advertising emails?", listOf("ස්පෑම්", "Spam"), "ස්පෑම් (Spam) ඊමේල් නමිනි.", "Spam වේ.")
        12 -> Quintuple("වෙනත් අයෙකුගේ නිර්මාණයක් අවසරයකින් තොරව සොරකම් කිරීම නීති විරෝධීද?", "Is stealing someone's software creation illegal?", listOf("ඔව්", "එසේය"), "ඔව්, ප්‍රකාශන හිමිකම් (Copyright) උල්ලංඝනයකි.", "ඔව් වේ.")
        13 -> Quintuple("මෘදුකාංග නීතිවිරෝධී ලෙස හොරෙන් පිටපත් කිරීම හඳුන්වන්නේ කෙසේද?", "Illegal copying of software?", listOf("මෘදුකාංග කොල්ලය", "Software Piracy"), "මෘදුකාංග මුහුදු කොල්ලය (Software Piracy) නමිනි.", "Software piracy වේ.")
        14 -> Quintuple("අන්තර්ජාලය ඔස්සේ අන් අයට තර්ජනය කිරීම හෝ බියවැද්දීම කුමක් නමින්ද?", "Threatening or bullying others online?", listOf("සයිබර් හිරිහැර", "Cyberbullying"), "සයිබර් හිරිහැර (Cyberbullying) නමිනි.", "Cyberbullying වේ.")
        15 -> Quintuple("පරිගණක භාවිතයේදී නිවැරදි ඉරියව්වෙන් වාඩිවීම වැදගත්ද?", "Is maintaining proper posture at computer important?", listOf("ඔව්", "එසේය"), "ඔව්, ශාරීරික සෞඛ්‍යයට ඉතා වැදගත් වේ.", "ඔව් වේ.")
        16 -> Quintuple("පරිගණක අපද්‍රව්‍ය (E-waste) පරිසරයට බැහැර කිරීමෙන් හානි සිදුවේද?", "Does dumping electronic waste harm environment?", listOf("ඔව්", "එසේය"), "ඔව්, විෂ රසායන පසට සහ ජලයට එකතු වේ.", "ඔව් වේ.")
        17 -> Quintuple("අන් අයගේ ඊමේල් හෝ පණිවිඩ හොරෙන් කියවීම සදාචාරාත්මකද?", "Is secretly reading other's messages ethical?", listOf("නැත", "නැහැ"), "නැත, එය සදාචාර විරෝධී වේ.", "නැත.")
        18 -> Quintuple("බැංකු ගිණුම්වල OTP අංකය වෙනත් අයට ලබාදිය යුතුද?", "Should you share your bank OTP with anyone?", listOf("නැත", "නැහැ"), "නැත, කිසිවිටෙක ලබානොදිය යුතුය.", "නැත.")
        19 -> Quintuple("ද්වි-සාධක සහතික කිරීම හඳුන්වන්නේ කුමන කෙටි නමින්ද?", "Two Factor Authentication abbreviation?", listOf("2FA"), "2FA (Two-Factor Authentication) නමිනි.", "2FA වේ.")
        20 -> Quintuple("පරිගණක වයිරසයකට පරිගණක දෘඩාංග භෞතිකව අනුභව කළ හැකිද?", "Can a virus physically eat hardware?", listOf("නැත", "නැහැ"), "නැත, හානි කරන්නේ මෘදුකාංග සහ දත්ත වලට පමණි.", "නැත.")
        else -> Quintuple("අන්තර්ජාලයේ ආරක්ෂිතව සිටීම වැදගත්ද?", "Is staying safe on internet important?", listOf("ඔව්", "එසේය"), "ඔව්, ඉතා වැදගත් වේ.", "ඔව් වේ.")
      }
      else -> when (qIndex) {
        1 -> Quintuple("ද්විමය (Binary) සංඛ්‍යා පද්ධතියේ පාදය කීයද?", "Base of Binary?", listOf("2", "දෙක"), "2 (දෙක) වේ.", "පාදය 2යි.")
        else -> Quintuple("අන්තර්ජාලයේ ආරක්ෂිතව සිටීම වැදගත්ද?", "Is staying safe on internet important?", listOf("ඔව්", "එසේය"), "ඔව්, ඉතා වැදගත් වේ.", "ඔව් වේ.")
      }
    }
  }

  // ==============================================================================
  // GRADE 11 O/L ICT BANK (100% GRADE 11 SYLLABUS - SHORT, ACCURATE & DIRECT)
  // ==============================================================================
  private fun getGrade11Question(setNum: Int, qIndex: Int, theme: String): Quintuple<String, String, List<String>, String, String> {
    return when (setNum) {
      // Set 1: සංඛ්‍යා පද්ධති (Binary, Octal, Hexadecimal)
      1 -> when (qIndex) {
        1 -> Quintuple("ද්විමය (Binary) සංඛ්‍යා පද්ධතියේ පාදය කීයද?", "Base of Binary number system?", listOf("2", "දෙක"), "2 (දෙක) වේ.", "පාදය 2යි (0 සහ 1).")
        2 -> Quintuple("අෂ්ටමය (Octal) සංඛ්‍යා පද්ධතියේ පාදය කීයද?", "Base of Octal number system?", listOf("8", "අට"), "8 (අට) වේ.", "පාදය 8යි (0 සිට 7).")
        3 -> Quintuple("ෂඩ්දශමය (Hexadecimal) සංඛ්‍යා පද්ධතියේ පාදය කීයද?", "Base of Hexadecimal number system?", listOf("16", "දහසය"), "16 (දහසය) වේ.", "පාදය 16යි (0-9 සහ A-F).")
        4 -> Quintuple("ෂඩ්දශමය පද්ධතියේ 'A' අකුරෙන් නිරූපණය වන දශමය අගය කීයද?", "Decimal value represented by 'A' in hex?", listOf("10", "දහය"), "10 (දහය) වේ.", "A යනු 10 වේ.")
        else -> Quintuple("බයිටයකට (1 Byte) අඩංගු බිටු (Bits) සංඛ්‍යාව කීයද?", "Number of bits in 1 byte?", listOf("8", "අටක්", "8ක්"), "බිටු 8කි (8 bits).", "බිටු 8කි.")
      }

      // Set 2: දත්ත සමුදාය කළමනාකරණය (DBMS)
      2 -> when (qIndex) {
        1 -> Quintuple("දත්ත සමුදායක වගුවක තනි පේළියක් හඳුන්වන්නේ කෙසේද?", "Single row in a database table?", listOf("රෙකෝඩය", "Record", "පේළිය"), "රෙකෝඩයක් (Record / Row / Tuple) නමිනි.", "Record වේ.")
        2 -> Quintuple("දත්ත සමුදායක වගුවක තනි සිරස් තීරුවක් හඳුන්වන්නේ කෙසේද?", "Single column in a database table?", listOf("ක්ෂේත්‍රය", "Field", "තීරුව"), "ක්ෂේත්‍රයක් (Field / Column / Attribute) නමිනි.", "Field වේ.")
        3 -> Quintuple("වගුවක එක් එක් රෙකෝඩය අනන්‍යව හඳුනාගැනීමට යොදාගන්නා යතුර කුමක්ද?", "Key uniquely identifying each record in a table?", listOf("ප්‍රාථමික යතුර", "Primary Key"), "ප්‍රාථමික යතුර (Primary Key) වේ.", "Primary Key වේ.")
        else -> Quintuple("වගු දෙකක් අතර සම්බන්ධතාවක් ගොඩනැගීමට යොදාගන්නා යතුර කුමක්ද?", "Key used to establish relationship between two tables?", listOf("විදේශ යතුර", "Foreign Key"), "විදේශ යතුර (Foreign Key) වේ.", "Foreign Key වේ.")
      }

      // Set 3: HTML මූලික ටැග & වෙබ් පිටු ව්‍යුහය
      3 -> when (qIndex) {
        1 -> Quintuple("HTML ලේඛනයක ප්‍රධාන කොටස් දෙක මොනවාද?", "Two main sections of an HTML document?", listOf("head සහ body", "හිස සහ බඳ"), "<head> සහ <body> කොටස් දෙකයි.", "head සහ body වේ.")
        2 -> Quintuple("වෙබ් පිටුවක බ්‍රවුසරයේ දිස්වන අන්තර්ගතය ලියන්නේ කුමන ටැගය තුළද?", "Tag containing visible web page content?", listOf("body", "<body>"), "<body> ටැගය තුළය.", "body ටැගයයි.")
        3 -> Quintuple("HTML හි විශාලතම ප්‍රධාන මාතෘකාව සඳහා භාවිත කරන ටැගය කුමක්ද?", "Tag for largest heading in HTML?", listOf("h1", "<h1>"), "<h1> ටැගය වේ.", "h1 වේ.")
        else -> Quintuple("වෙබ් පිටුවක හයිපර්ලින්ක් (Hyperlink) එකක් යෙදීමට භාවිත කරන ටැගය කුමක්ද?", "Anchor tag used for hyperlinks in HTML?", listOf("a", "<a>", "anchor"), "<a> (Anchor) ටැගය වේ.", "<a> ටැගයයි.")
      }

      // Set 4: CSS මඟින් වෙබ් පිටු හැඩගැන්වීම
      4 -> when (qIndex) {
        1 -> Quintuple("CSS යන්නෙහි සම්පූර්ණ නම කුමක්ද?", "Full meaning of CSS?", listOf("Cascading Style Sheets"), "Cascading Style Sheets වේ.", "Cascading Style Sheets වේ.")
        2 -> Quintuple("CSS භාවිත කරන්නේ වෙබ් පිටුවක කුමක් සඳහාද?", "What is CSS used for on web pages?", listOf("හැඩගැන්වීම", "විලාසිතා", "Styling"), "වෙබ් පිටුවේ පෙනුම හා හැඩගැන්වීම් (Styling) සඳහාය.", "හැඩගැන්වීමයි.")
        else -> Quintuple("අකුරුවල වර්ණය වෙනස් කිරීමට භාවිත කරන CSS ගුණය කුමක්ද?", "CSS property to change font color?", listOf("color"), "color ගුණය (property) වේ.", "color වේ.")
      }

      // Set 5: ඇල්ගොරිතම සංකල්පය
      5 -> when (qIndex) {
        1 -> Quintuple("ගැටලුවක් විසඳීම සඳහා ඇති පියවරෙන් පියවර උපදෙස් මාලාව කුමක්ද?", "Step-by-step instructions to solve a problem?", listOf("ඇල්ගොරිතමය", "Algorithm"), "ඇල්ගොරිතමය (Algorithm) නමිනි.", "ඇල්ගොරිතමයයි.")
        else -> Quintuple("පරිගණක භාෂාවකට සමාන ඉංග්‍රීසි වචනවලින් ලියන ඇල්ගොරිතම නිරූපණ ක්‍රමය කුමක්ද?", "Algorithm representation using plain English-like code?", listOf("ව්‍යාජ කේත", "Pseudocode"), "ව්‍යාජ කේත (Pseudocode) නමිනි.", "Pseudocode වේ.")
      }

      // Set 6: ගැලීම් සටහන් (Flowchart)
      6 -> when (qIndex) {
        1 -> Quintuple("ගැලීම් සටහනක ආරම්භය හා අවසානය දැක්වීමට යොදාගන්නා සංකේතය කුමක්ද?", "Flowchart symbol for Start and End?", listOf("ඉලිප්සය", "Oval", "Ellipse"), "ඉලිප්සාකාර (Oval / Ellipse) සංකේතයයි.", "ඉලිප්සයයි.")
        2 -> Quintuple("දත්ත ආදානය හෝ ප්‍රතිදානය දැක්වීමට යොදාගන්නා සංකේතය කුමක්ද?", "Flowchart symbol for Input and Output?", listOf("සමාන්තරාස්‍රය", "Parallelogram"), "සමාන්තරාස්‍රය (Parallelogram) වේ.", "සමාන්තරාස්‍රයයි.")
        3 -> Quintuple("ගණනය කිරීමක් හෝ සැකසුමක් දැක්වීමට යොදාගන්නා සංකේතය කුමක්ද?", "Flowchart symbol for processing?", listOf("සෘජුකෝණාස්‍රය", "Rectangle"), "සෘජුකෝණාස්‍රය (Rectangle) වේ.", "සෘජුකෝණාස්‍රයයි.")
        else -> Quintuple("තීරණයක් ගැනීම (Decision / කොන්දේසිය) දැක්වීමට යොදාගන්නා සංකේතය කුමක්ද?", "Flowchart symbol for decision?", listOf("රොම්බසය", "Rhombus", "Diamond"), "රොම්බසය (Diamond / Rhombus) වේ.", "රොම්බසයයි.")
      }

      // Set 7: ක්‍රමලේඛන විචල්‍ය & දත්ත වර්ග
      7 -> when (qIndex) {
        1 -> Quintuple("පූර්ණ සංඛ්‍යා ගබඩා කිරීමට භාවිත කරන දත්ත වර්ගය කුමක්ද?", "Data type for whole numbers (integers)?", listOf("Integer", "int"), "Integer (int) වේ.", "Integer වේ.")
        2 -> Quintuple("දශම සහිත සංඛ්‍යා ගබඩා කිරීමට භාවිත කරන දත්ත වර්ගය කුමක්ද?", "Data type for decimal floating-point numbers?", listOf("Float", "Real", "Double"), "Float (හෝ Real) වේ.", "Float වේ.")
        else -> Quintuple("True හෝ False යන අගයන් දෙකෙන් එකක් පමණක් ගබඩා කරන දත්ත වර්ගය කුමක්ද?", "Data type holding only True or False?", listOf("Boolean", "bool"), "Boolean වේ.", "Boolean වේ.")
      }

      // Set 8: පාලන ව්‍යුහ (Control Structures)
      8 -> when (qIndex) {
        1 -> Quintuple("ක්‍රමලේඛනයක කොන්දේසියක් මත තීරණ ගැනීම හඳුන්වන පාලන ව්‍යුහය කුමක්ද?", "Control structure for decision making based on conditions?", listOf("වරණය", "Selection", "IF-ELSE"), "වරණය (Selection / IF-THEN-ELSE) වේ.", "වරණයයි.")
        else -> Quintuple("යම් ප්‍රකාශන කොටසක් නැවත නැවත ක්‍රියාත්මක කිරීම හඳුන්වන පාලන ව්‍යුහය කුමක්ද?", "Control structure repeating a block of statements?", listOf("පුනර්කරණය", "Iteration", "Loop"), "පුනර්කරණය (Iteration / Looping) වේ.", "ලූප හෙවත් පුනර්කරණයයි.")
      }

      // Set 9: පද්ධති සංවර්ධන ජීවන චක්‍රය (SDLC)
      9 -> when (qIndex) {
        1 -> Quintuple("SDLC යන්නෙහි සම්පූර්ණ නම කුමක්ද?", "Full meaning of SDLC?", listOf("System Development Life Cycle"), "System Development Life Cycle (පද්ධති සංවර්ධන ජීවන චක්‍රය) වේ.", "SDLC වේ.")
        else -> Quintuple("SDLC හි පළමු අදියර කුමක්ද?", "First phase of SDLC?", listOf("අවශ්‍යතා හඳුනාගැනීම", "අවශ්‍යතා විශ්ලේෂණය", "Identification"), "ගැටලුව හඳුනාගැනීම හා අවශ්‍යතා නිර්ණය කිරීමයි.", "අවශ්‍යතා විශ්ලේෂණයයි.")
      }

      // Set 10: විද්‍යුත් වාණිජ්‍යය & නීති
      else -> when (qIndex) {
        1 -> Quintuple("ව්‍යාපාරිකයෙකු පාරිභෝගිකයෙකුට භාණ්ඩ අලෙවි කිරීම හඳුන්වන කෙටි නම කුමක්ද?", "Business to Consumer e-commerce model?", listOf("B2C"), "B2C (Business-to-Consumer) වේ.", "B2C වේ.")
        2 -> Quintuple("පාරිභෝගිකයන් අතරම සිදුවන (උදා: ikman.lk) විද්‍යුත් වාණිජ්‍ය ආකෘතිය කුමක්ද?", "Consumer to Consumer e-commerce model?", listOf("C2C"), "C2C (Consumer-to-Consumer) වේ.", "C2C වේ.")
        else -> Quintuple("ශ්‍රී ලංකාවේ පරිගණක අපරාධ වැළැක්වීම සඳහා සම්මත කළ පනත කුමක්ද?", "Sri Lankan act to prevent computer offenses?", listOf("පරිගණක අපරාධ පනත", "Computer Crimes Act"), "2007 අංක 24 දරන පරිගණක අපරාධ පනත වේ.", "පරිගණක අපරාධ පනතයි.")
      }
    }
  }
}

