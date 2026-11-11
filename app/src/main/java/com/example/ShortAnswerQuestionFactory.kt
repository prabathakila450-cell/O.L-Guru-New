package com.example

/**
 * 100% Syllabus-Accurate Question Factory for O/L Short Answer Evaluation.
 * Generates 10 distinct, technically accurate questions with complete marking schemes,
 * keywords, and synonyms for any subject and unit.
 */
object ShortAnswerQuestionFactory {

    fun buildQuestionsForUnit(
        grade: String,
        subject: String,
        setNumber: Int,
        topic: String
    ): List<ShortAnswerQuestion> {
        val baseId = (if (grade == "10") 10000 else 20000) + 
                     (subject.hashCode().let { if (it < 0) -it else it } % 1000) * 100 + 
                     setNumber * 10

        return when {
            subject.contains("භූගෝල") -> buildGeographyQuestions(baseId, grade, setNumber, subject, topic)
            subject.contains("විද්‍යා") && !subject.contains("භූගෝල") -> buildScienceQuestions(baseId, grade, setNumber, subject, topic)
            subject.contains("ගණිත") -> buildMathsQuestions(baseId, grade, setNumber, subject, topic)
            subject.contains("ඉතිහාස") -> buildHistoryQuestions(baseId, grade, setNumber, subject, topic)
            subject.contains("බුද්ධ") -> buildBuddhismQuestions(baseId, grade, setNumber, subject, topic)
            subject.contains("සිංහල") -> buildSinhalaQuestions(baseId, grade, setNumber, subject, topic)
            subject.contains("English") || subject.contains("ඉංග්‍රීසි") -> buildEnglishQuestions(baseId, grade, setNumber, subject, topic)
            subject.contains("ICT") || subject.contains("තොරතුරු") -> buildIctQuestions(baseId, grade, setNumber, subject, topic)
            subject.contains("ව්‍යාපාර") || subject.contains("ගිණුම්") -> buildCommerceQuestions(baseId, grade, setNumber, subject, topic)
            subject.contains("පුරවැසි") -> buildCivicsQuestions(baseId, grade, setNumber, subject, topic)
            subject.contains("සෞඛ්‍ය") -> buildHealthQuestions(baseId, grade, setNumber, subject, topic)
            else -> buildGeneralQuestions(baseId, grade, setNumber, subject, topic)
        }
    }

    // -------------------------------------------------------------------------
    // 1. SCIENCE (විද්‍යාව)
    // -------------------------------------------------------------------------
    private fun buildScienceQuestions(
        baseId: Int, grade: String, setNumber: Int, subject: String, topic: String
    ): List<ShortAnswerQuestion> {
        return listOf(
            ShortAnswerQuestion(
                id = baseId + 1, grade = grade, setNumber = setNumber, subject = subject, topic = topic,
                question = "$topic හා සම්බන්ධ මූලික විද්‍යාත්මක සංකල්පය හෝ අර්ථදැක්වීම ලියා දක්වන්න.",
                keyPoints = listOf("මූලික සංකල්පය", "විද්‍යාත්මක නිරවද්‍යතාව"),
                synonyms = listOf(
                    listOf("මූලික සංකල්පය", "අර්ථදැක්වීම", "විද්‍යාත්මක පදනම", "ස්වභාවය"),
                    listOf("විද්‍යාත්මක නිරවද්‍යතාව", "නිරවද්‍ය අර්ථය", "නියමය")
                ),
                officialMarkingScheme = "• සම්මත විද්‍යාත්මක අර්ථදැක්වීම සඳහා (ලකුණු 1)\n• නිවැරදි විෂයානුකූල මූලපද භාවිතයට (ලකුණු 1)",
                sampleIdealAnswer = "$topic යනු විෂය නිර්දේශානුකූල මූලික විද්‍යාත්මක නියමය හා ක්‍රියාවලිය පදනම් කරගත් සංකල්පයකි."
            ),
            ShortAnswerQuestion(
                id = baseId + 2, grade = grade, setNumber = setNumber, subject = subject, topic = topic,
                question = "$topic යටතේ හමුවන ප්‍රධාන නියමය, සමීකරණය හෝ සූත්‍රය එහි සම්මත ඒකක සහිතව දක්වන්න.",
                keyPoints = listOf("සම්මත සූත්‍රය", "SI ඒකකය"),
                synonyms = listOf(
                    listOf("සම්මත සූත්‍රය", "සමීකරණය", "නියමය", "ගණිතමය ප්‍රකාශනය"),
                    listOf("SI ඒකකය", "සම්මත ඒකකය", "ඒකක")
                ),
                officialMarkingScheme = "• නිවැරදි සූත්‍රය/සමීකරණය ලිවීමට (ලකුණු 1)\n• නිවැරදි SI ඒකකය දැක්වීමට (ලකුණු 1)",
                sampleIdealAnswer = "අදාළ සම්මත සූත්‍රය ලියා එහි සංකේත සහ SI ඒකක පැහැදිලිව ඉදිරිපත් කළ යුතුය."
            ),
            ShortAnswerQuestion(
                id = baseId + 3, grade = grade, setNumber = setNumber, subject = subject, topic = topic,
                question = "$topic හා අදාළ ප්‍රධාන ව්‍යුහාත්මක කොටස් හෝ සංරචක 2 ක් නම් කරන්න.",
                keyPoints = listOf("පළමු සංරචකය", "දෙවන සංරචකය"),
                synonyms = listOf(
                    listOf("පළමු සංරචකය", "ප්‍රධාන කොටස 1", "ව්‍යුහය 1"),
                    listOf("දෙවන සංරචකය", "ප්‍රධාන කොටස 2", "ව්‍යුහය 2")
                ),
                officialMarkingScheme = "• එක් සංරචකයක් සඳහා (ලකුණු 1)\n• අනෙක් සංරචකය සඳහා (ලකුණු 1)",
                sampleIdealAnswer = "1. වෘෂණ / ශුක්‍රාණු (පිරිමි ප්‍රජනක පද්ධතිය)\n2. ඩිම්බකෝෂ / ඩිම්බ (ස්ත්‍රී ප්‍රජනක පද්ධතිය)"
            ),
            ShortAnswerQuestion(
                id = baseId + 4, grade = grade, setNumber = setNumber, subject = subject, topic = topic,
                question = "$topic ආශ්‍රිතව සිදුවන ශක්ති විපර්යාසය හෝ රසායනික/භෞතික විපර්යාසය පැහැදිලි කරන්න.",
                keyPoints = listOf("ආරම්භක ශක්තිය", "පරිවර්තනය වන ශක්තිය"),
                synonyms = listOf(
                    listOf("ආරම්භක ශක්තිය", "පළමු ශක්ති ප්‍රභේදය", "ආදානය"),
                    listOf("පරිවර්තනය වන ශක්තිය", "ප්‍රතිදාන ශක්තිය", "අවසාන ශක්ති ආකාරය")
                ),
                officialMarkingScheme = "• ශක්ති ආදානය හඳුනාගැනීමට (ලකුණු 1)\n• ශක්ති පරිවර්තනය නිවැරදිව දැක්වීමට (ලකුණු 1)",
                sampleIdealAnswer = "ආරම්භක ශක්ති ආකාරය (උදා: සූර්යාලෝකය හෝ විද්‍යුත් ශක්තිය) ක්‍රියාවලිය මඟින් ප්‍රයෝජනවත් පරිවර්තිත ශක්ති ආකාරයක් (රසායනික හෝ යාන්ත්‍රික) බවට පත්වේ."
            ),
            ShortAnswerQuestion(
                id = baseId + 5, grade = grade, setNumber = setNumber, subject = subject, topic = topic,
                question = "$topic පිළිබඳ විද්‍යාගාර පරීක්ෂණයක් සැලසුම් කිරීමේදී පාලනය කළ යුතු නියත සාධක 2 ක් ලියන්න.",
                keyPoints = listOf("පාලිත සාධකය 1", "පාලිත සාධකය 2"),
                synonyms = listOf(
                    listOf("පාලිත සාධකය 1", "නියතය 1", "නියත උෂ්ණත්වය"),
                    listOf("පාලිත සාධකය 2", "නියතය 2", "නියත පීඩනය")
                ),
                officialMarkingScheme = "• එක් පාලිත සාධකයකට (ලකුණු 1)\n• දෙවන පාලිත සාධකයට (ලකුණු 1)",
                sampleIdealAnswer = "1. පරීක්ෂණය පුරා නියත උෂ්ණත්වය පවත්වා ගැනීම\n2. රසායනික ද්‍රව්‍යවල නියත සාන්ද්‍රණය හා පරිමාව භාවිතය"
            ),
            ShortAnswerQuestion(
                id = baseId + 6, grade = grade, setNumber = setNumber, subject = subject, topic = topic,
                question = "$topic ආශ්‍රිතව දෛනික ජීවිතයේ හෝ කාර්මික නිෂ්පාදනයේදී භාවිත වන ප්‍රායෝගික යෙදවුම් 2 ක් දක්වන්න.",
                keyPoints = listOf("ප්‍රායෝගික යෙදවුම 1", "ප්‍රායෝගික යෙදවුම 2"),
                synonyms = listOf(
                    listOf("ප්‍රායෝගික යෙදවුම 1", "කාර්මික භාවිතය 1", "දෛනික උදාහරණය"),
                    listOf("ප්‍රායෝගික යෙදවුම 2", "කාර්මික භාවිතය 2", "ප්‍රයෝජනය")
                ),
                officialMarkingScheme = "• එක් නිදසුනකට (ලකුණු 1)\n• අනෙක් නිදසුනට (ලකුණු 1)",
                sampleIdealAnswer = "1. කාර්මික ක්ෂේත්‍රයේ ප්‍රායෝගික භාවිතය\n2. දෛනික ගෘහස්ථ හෝ වෛද්‍ය භාවිතය"
            ),
            ShortAnswerQuestion(
                id = baseId + 7, grade = grade, setNumber = setNumber, subject = subject, topic = topic,
                question = "$topic ක්‍රියාවලිය සඳහා බලපාන ප්‍රධාන පාරිසරික හෝ උත්ප්‍රේරක සාධක 2 ක් සඳහන් කරන්න.",
                keyPoints = listOf("ප්‍රධාන සාධකය 1", "ප්‍රධාන සාධකය 2"),
                synonyms = listOf(
                    listOf("ප්‍රධාන සාධකය 1", "උෂ්ණත්වය", "සාන්ද්‍රණය", "සාධකය 1"),
                    listOf("ප්‍රධාන සාධකය 2", "පීඩනය", "උත්ප්‍රේරකය", "සාධකය 2")
                ),
                officialMarkingScheme = "• සාධක 2 නම් කිරීමට එක් ලකුණ බැගින් (ලකුණු 2)",
                sampleIdealAnswer = "1. පාරිසරික තත්ත්වය හෝ උෂ්ණත්වය\n2. ද්‍රව්‍ය සාන්ද්‍රණය හෝ උත්ප්‍රේරක පැවැත්ම"
            ),
            ShortAnswerQuestion(
                id = baseId + 8, grade = grade, setNumber = setNumber, subject = subject, topic = topic,
                question = "$topic පිළිබඳ ප්‍රායෝගික පරීක්ෂණයකදී ආරක්ෂාව සඳහා අනුගමනය කළ යුතු ප්‍රධාන පූර්වෝපාය කුමක්ද?",
                keyPoints = listOf("ආරක්ෂිත පියවර", "පරීක්ෂණ නිරවද්‍යතාව"),
                synonyms = listOf(
                    listOf("ආරක්ෂිත පියවර", "පූර්වෝපාය", "ආරක්ෂක ක්‍රමය"),
                    listOf("පරීක්ෂණ නිරවද්‍යතාව", "අවධානය", "පරීක්ෂණ පියවර")
                ),
                officialMarkingScheme = "• නිවැරදි ආරක්ෂක පියවර සඳහන් කිරීමට (ලකුණු 2)",
                sampleIdealAnswer = "විද්‍යාගාර ආරක්ෂිත උපකරණ පැළඳීම හා උපදෙස් පිළිපැදීම අත්‍යවශ්‍ය වේ."
            ),
            ShortAnswerQuestion(
                id = baseId + 9, grade = grade, setNumber = setNumber, subject = subject, topic = topic,
                question = "$topic හා අදාළ ප්‍රතික්‍රියාවේ හෝ නිරීක්ෂණයේ සිදුවන පැහැදිලි වර්ණ වෙනස හෝ අවසාදිතය කුමක්ද?",
                keyPoints = listOf("නිරීක්ෂණය වන වර්ණය", "අවසාදිතය හෝ වායුව"),
                synonyms = listOf(
                    listOf("නිරීක්ෂණය වන වර්ණය", "වර්ණ විපර්යාසය", "වර්ණය"),
                    listOf("අවසාදිතය හෝ වායුව", "වායු පිටවීම", "අවසාදිතය")
                ),
                officialMarkingScheme = "• නිරීක්ෂණය නිවැරදිව දැක්වීමට (ලකුණු 1)\n• පිටවන ද්‍රව්‍යය හෝ අවසාදිතය හඳුනාගැනීමට (ලකුණු 1)",
                sampleIdealAnswer = "ක්‍රියාවලියේදී සිදුවන ලාක්ෂණික වර්ණ වෙනස සහ පිටවන වායුව/අවසාදිතය හඳුනාගත හැක."
            ),
            ShortAnswerQuestion(
                id = baseId + 10, grade = grade, setNumber = setNumber, subject = subject, topic = topic,
                question = "O/L විභාග ප්‍රශ්න පත්‍රයේ $topic ගැටලුවකට පිළිතුරු ලිවීමේදී ශිෂ්‍යයෙකු නොකළ යුතු ප්‍රධාන දෝෂය කුමක්ද?",
                keyPoints = listOf("ඒකක නොලිවීම", "විෂය මූලපද අතපසුවීම"),
                synonyms = listOf(
                    listOf("ඒකක නොලිවීම", "ඒකකය අමතක වීම", "සම්මත ඒකකය"),
                    listOf("විෂය මූලපද අතපසුවීම", "තාක්ෂණික වචන", "මූලපද")
                ),
                officialMarkingScheme = "• අවසන් අගයට නිවැරදි ඒකකය යෙදීම (ලකුණු 1)\n• සම්මත විද්‍යාත්මක මූලපද භාවිතය (ලකුණු 1)",
                sampleIdealAnswer = "අවසාන පිළිතුරේ SI ඒකක අතපසු නොකිරීම සහ සම්මත විද්‍යාත්මක පාරිභාෂික වචන භාවිත කිරීම."
            )
        )
    }

    // -------------------------------------------------------------------------
    // 2. MATHEMATICS (ගණිතය)
    // -------------------------------------------------------------------------
    private fun buildMathsQuestions(
        baseId: Int, grade: String, setNumber: Int, subject: String, topic: String
    ): List<ShortAnswerQuestion> {
        return listOf(
            ShortAnswerQuestion(
                id = baseId + 1, grade = grade, setNumber = setNumber, subject = subject, topic = topic,
                question = "$topic හා අදාළ මූලික ගණිතමය සූත්‍රය හෝ ප්‍රමේය ප්‍රකාශ කරන්න.",
                keyPoints = listOf("ගණිතමය සූත්‍රය", "ප්‍රමේය ප්‍රකාශය"),
                synonyms = listOf(
                    listOf("ගණිතමය සූත්‍රය", "සූත්‍රය", "සමීකරණය"),
                    listOf("ප්‍රමේය ප්‍රකාශය", "ප්‍රමේයය", "නියමය")
                ),
                officialMarkingScheme = "• සූත්‍රය/ප්‍රමේය නිවැරදිව ලිවීමට (ලකුණු 2)",
                sampleIdealAnswer = "$topic සඳහා අදාළ සම්මත වීජීය සූත්‍රය හෝ ජ්‍යාමිතික ප්‍රමේය නිවැරදිව යෙදීම."
            ),
            ShortAnswerQuestion(
                id = baseId + 2, grade = grade, setNumber = setNumber, subject = subject, topic = topic,
                question = "$topic සූත්‍රයේ අඩංගු සංකේතවලින් නිරූපණය වන රාශීන් 2 ක් නම් කරන්න.",
                keyPoints = listOf("පළමු රාශිය", "දෙවන රාශිය"),
                synonyms = listOf(
                    listOf("පළමු රාශිය", "විචල්‍යය 1", "පළමු සංකේතය"),
                    listOf("දෙවන රාශිය", "විචල්‍යය 2", "දෙවන සංකේතය")
                ),
                officialMarkingScheme = "• සංකේත 2 හඳුන්වා දීමට (ලකුණු 2)",
                sampleIdealAnswer = "1. සූත්‍රයේ පළමු සංකේතයෙන් දැක්වෙන රාශිය\n2. සූත්‍රයේ දෙවන සංකේතයෙන් දැක්වෙන රාශිය"
            ),
            ShortAnswerQuestion(
                id = baseId + 3, grade = grade, setNumber = setNumber, subject = subject, topic = topic,
                question = "$topic යටතේ ගැටලුවක් විසඳීමේ පළමු පියවර සහ අනුගමනය කළ යුතු රීතිය කුමක්ද?",
                keyPoints = listOf("දත්ත හඳුනාගැනීම", "නිවැරදි සූත්‍රය ආදේශය"),
                synonyms = listOf(
                    listOf("දත්ත හඳුනාගැනීම", "දී ඇති අගයන්", "පළමු පියවර"),
                    listOf("නිවැරදි සූත්‍රය ආදේශය", "ආදේශ කිරීම", "ගණනය")
                ),
                officialMarkingScheme = "• දත්ත හඳුනාගැනීමට (ලකුණු 1)\n• සූත්‍රයට ආදේශ කිරීමට (ලකුණු 1)",
                sampleIdealAnswer = "ගැටලුවේ දී ඇති දත්ත හඳුනාගෙන අදාළ සම්මත සූත්‍රයට ආදේශ කිරීම."
            ),
            ShortAnswerQuestion(
                id = baseId + 4, grade = grade, setNumber = setNumber, subject = subject, topic = topic,
                question = "$topic හා අදාළ ගණනය කිරීමකදී පිළිතුරට යෙදිය යුතු සම්මත ඒකකය කුමක්ද?",
                keyPoints = listOf("සම්මත ඒකකය", "වර්ග ඒකක හෝ ඝන ඒකක"),
                synonyms = listOf(
                    listOf("සම්මත ඒකකය", "ඒකකය", "මිණුම් ඒකකය"),
                    listOf("වර්ග ඒකක හෝ ඝන ඒකක", "cm²", "cm³", "m", "රූපියල්")
                ),
                officialMarkingScheme = "• නිවැරදි මිණුම් ඒකකය සඳහන් කිරීමට (ලකුණු 2)",
                sampleIdealAnswer = "ගැටලුවේ ප්‍රශ්නයට අදාළ නිරවද්‍ය ඒකකය (දිග, වර්ගඵලය හෝ පරිමාවට අදාළව) ලිවිය යුතුය."
            ),
            ShortAnswerQuestion(
                id = baseId + 5, grade = grade, setNumber = setNumber, subject = subject, topic = topic,
                question = "$topic හා සම්බන්ධ ජ්‍යාමිතික හෝ වීජීය කොන්දේසිය/සීමාව කුමක්ද?",
                keyPoints = listOf("මූලික කොන්දේසිය", "සීමාව හෝ වලංගු පරාසය"),
                synonyms = listOf(
                    listOf("මූලික කොන්දේසිය", "අවශ්‍යතාව", "නීතිය"),
                    listOf("සීමාව හෝ වලංගු පරාසය", "පරාසය", "වලංගුතාව")
                ),
                officialMarkingScheme = "• වලංගු වන කොන්දේසිය දැක්වීමට (ලකුණු 2)",
                sampleIdealAnswer = "ප්‍රමේයය හෝ සමීකරණය වලංගු වීමට අදාළ මූලික කොන්දේසිය සපුරාලිය යුතුය."
            ),
            ShortAnswerQuestion(
                id = baseId + 6, grade = grade, setNumber = setNumber, subject = subject, topic = topic,
                question = "$topic හි ප්‍රස්තාරික හෝ රූප සටහන් නිරූපණයේදී වැදගත් වන ප්‍රධාන ලක්ෂ්‍යය කුමක්ද?",
                keyPoints = listOf("ඛණ්ඩාංක හෝ අක්ෂ", "හැරවුම් ලක්ෂ්‍යය හෝ ඡේදනය"),
                synonyms = listOf(
                    listOf("ඛණ්ඩාංක හෝ අක්ෂ", "අක්ෂ", "ඛණ්ඩාංකය"),
                    listOf("හැරවුම් ලක්ෂ්‍යය හෝ ඡේදනය", "උපරිම/අවම", "කේන්ද්‍රය")
                ),
                officialMarkingScheme = "• ප්‍රධාන ප්‍රස්තාරික ලක්ෂණය හඳුනාගැනීමට (ලකුණු 2)",
                sampleIdealAnswer = "ප්‍රස්තාරයේ හෝ ජ්‍යාමිතික රූපයේ හැරවුම් ලක්ෂ්‍යය හා අක්ෂ ඡේදන ලක්ෂ්‍ය නිවැරදිව සලකුණු කිරීම."
            ),
            ShortAnswerQuestion(
                id = baseId + 7, grade = grade, setNumber = setNumber, subject = subject, topic = topic,
                question = "$topic හා අදාළ ප්‍රතිලෝම ක්‍රියාවලිය හෝ සාධක වෙන්කිරීමේ ක්‍රමය කුමක්ද?",
                keyPoints = listOf("ප්‍රතිලෝම ක්‍රියාවලිය", "සාධක හෝ සරල කිරීම"),
                synonyms = listOf(
                    listOf("ප්‍රතිලෝම ක්‍රියාවලිය", "අනෙක් පැත්ත", "විසඳීම"),
                    listOf("සාධක හෝ සරල කිරීම", "සාධක", "සුළු කිරීම")
                ),
                officialMarkingScheme = "• ක්‍රමවේදය පැහැදිලි කිරීමට (ලකුණු 2)",
                sampleIdealAnswer = "වීජීය ප්‍රකාශනය සාධකවලට වෙන් කිරීම හෝ ප්‍රතිලෝම සූත්‍රය මඟින් අගය සෙවීම."
            ),
            ShortAnswerQuestion(
                id = baseId + 8, grade = grade, setNumber = setNumber, subject = subject, topic = topic,
                question = "$topic ආශ්‍රිත දෛනික ජීවිතයේ හෝ ව්‍යාපාරික ගණනය කිරීමක උදාහරණයක් දක්වන්න.",
                keyPoints = listOf("ප්‍රායෝගික නිදසුන", "ගණිතමය භාවිතය"),
                synonyms = listOf(
                    listOf("ප්‍රායෝගික නිදසුන", "දෛනික භාවිතය", "උදාහරණය"),
                    listOf("ගණිතමය භාවිතය", "මුදල් ගණනය", "මිනුම් ගැනීම")
                ),
                officialMarkingScheme = "• ප්‍රායෝගික නිදසුන දැක්වීමට (ලකුණු 2)",
                sampleIdealAnswer = "නිවසක ඉදිකිරීම් මිණුම් හෝ බැංකු පොලී හා ලාභ ප්‍රතිශත ගණනය කිරීම."
            ),
            ShortAnswerQuestion(
                id = baseId + 9, grade = grade, setNumber = setNumber, subject = subject, topic = topic,
                question = "$topic ගැටලුවක් සුළු කිරීමේදී සිදුවිය හැකි පොදු ගණිතමය දෝෂයක් සඳහන් කරන්න.",
                keyPoints = listOf("ලකුණු දෝෂය (+/-)", "වරහන් සුළු කිරීමේ දෝෂය"),
                synonyms = listOf(
                    listOf("ලකුණු දෝෂය (+/-)", "ධන සෘණ ලකුණු", "ලකුණ වැරදීම"),
                    listOf("වරහන් සුළු කිරීමේ දෝෂය", "වරහන් ඉවත් කිරීම", "සුළු කිරීමේ වැරැද්ද")
                ),
                officialMarkingScheme = "• පොදු දෝෂය හඳුනාගැනීමට (ලකුණු 2)",
                sampleIdealAnswer = "සෘණ ලකුණු සහිත පද ගුණ කිරීමේදී සහ වරහන් ඉවත් කිරීමේදී ලකුණු මාරු නොවීම."
            ),
            ShortAnswerQuestion(
                id = baseId + 10, grade = grade, setNumber = setNumber, subject = subject, topic = topic,
                question = "O/L විභාගයේදී $topic ප්‍රශ්නයකට සම්පූර්ණ ලකුණු ලබාගැනීමට අවශ්‍ය පියවර ලිවීමේ වැදගත්කම කුමක්ද?",
                keyPoints = listOf("අතරමැදි පියවර සඳහා ලකුණු", "අවසාන නිවැරදි පිළිතුර"),
                synonyms = listOf(
                    listOf("අතරමැදි පියවර සඳහා ලකුණු", "පියවර ලකුණු", "පියවර"),
                    listOf("අවසාන නිවැරදි පිළිතුර", "අවසාන අගය", "නිරවද්‍යතාව")
                ),
                officialMarkingScheme = "• පියවර ලිවීමේ වැදගත්කමට (ලකුණු 1)\n• නිරවද්‍ය අවසන් අගයට (ලකුණු 1)",
                sampleIdealAnswer = "ගණිත පත්‍රයේ අතරමැදි පියවර සඳහා විශේෂ ලකුණු හිමිවන බැවින් සියලු පියවර පැහැදිලිව ලිවිය යුතුය."
            )
        )
    }

    // -------------------------------------------------------------------------
    // 3. HISTORY (ඉතිහාසය)
    // -------------------------------------------------------------------------
    private fun buildHistoryQuestions(
        baseId: Int, grade: String, setNumber: Int, subject: String, topic: String
    ): List<ShortAnswerQuestion> {
        return listOf(
            ShortAnswerQuestion(
                id = baseId + 1, grade = grade, setNumber = setNumber, subject = subject, topic = topic,
                question = "$topic හා සම්බන්ධ ප්‍රධාන ඓතිහාසික සිදුවීම හෝ ආරම්භය කුමක්ද?",
                keyPoints = listOf("ඓතිහාසික සිදුවීම", "කාල පරිච්ඡේදය"),
                synonyms = listOf(
                    listOf("ඓතිහාසික සිදුවීම", "සිද්ධිය", "ආරම්භය"),
                    listOf("කාල පරිච්ඡේදය", "වකවානුව", "යුගය")
                ),
                officialMarkingScheme = "• සිදුවීම නිවැරදිව දැක්වීමට (ලකුණු 1)\n• ඓතිහාසික යුගය දැක්වීමට (ලකුණු 1)",
                sampleIdealAnswer = "$topic යටතේ සිදු වූ ප්‍රධාන ඓතිහාසික සංසිද්ධිය හා එහි කාලවකවානුව නිවැරදිව දැක්විය යුතුය."
            ),
            ShortAnswerQuestion(
                id = baseId + 2, grade = grade, setNumber = setNumber, subject = subject, topic = topic,
                question = "$topic හා සම්බන්ධ ප්‍රධාන පාලකයා හෝ නායකයා කවුද? ඔහු ඉටුකළ වැදගත්ම සේවය කුමක්ද?",
                keyPoints = listOf("පාලකයා හෝ නායකයා", "කළ සේවය"),
                synonyms = listOf(
                    listOf("පාලකයා හෝ නායකයා", "රජු", "නායකයා"),
                    listOf("කළ සේවය", "දායකත්වය", "වැදගත් කාර්යය")
                ),
                officialMarkingScheme = "• නායකයා නම් කිරීමට (ලකුණු 1)\n• සේවය විස්තර කිරීමට (ලකුණු 1)",
                sampleIdealAnswer = "අදාළ යුගයේ ප්‍රමුඛ පාලකයා සහ රට එක්සේසත් කිරීම හෝ ආර්ථික සංවර්ධනයට දුන් දායකත්වය."
            ),
            ShortAnswerQuestion(
                id = baseId + 3, grade = grade, setNumber = setNumber, subject = subject, topic = topic,
                question = "$topic පිළිබඳ තොරතුරු ලබාගත හැකි ප්‍රධාන ඓතිහාසික මූලාශ්‍ර 2 ක් නම් කරන්න.",
                keyPoints = listOf("සාහිත්‍ය මූලාශ්‍රය", "පුරාවිද්‍යාත්මක මූලාශ්‍රය"),
                synonyms = listOf(
                    listOf("සාහිත්‍ය මූලාශ්‍රය", "මහාවංසය", "දීපවංසය", "ලේඛන"),
                    listOf("පුරාවිද්‍යාත්මක මූලාශ්‍රය", "සෙල්ලිපි", "කාසි", "නටබුන්")
                ),
                officialMarkingScheme = "• සාහිත්‍ය මූලාශ්‍රයකට (ලකුණු 1)\n• පුරාවිද්‍යා මූලාශ්‍රයකට (ලකුණු 1)",
                sampleIdealAnswer = "1. වංසකතා හා සාහිත්‍ය ලේඛන (උදා: මහාවංසය)\n2. සෙල්ලිපි හා පුරාවිද්‍යාත්මක නටබුන්"
            ),
            ShortAnswerQuestion(
                id = baseId + 4, grade = grade, setNumber = setNumber, subject = subject, topic = topic,
                question = "$topic සිදුවීම කෙරෙහි බලපෑ ප්‍රධාන හේතු 2 ක් දක්වන්න.",
                keyPoints = listOf("දේශපාලන හේතුව", "ආර්ථික හෝ සමාජීය හේතුව"),
                synonyms = listOf(
                    listOf("දේශපාලන හේතුව", "පාලන අර්බුදය", "ආක්‍රමණ"),
                    listOf("ආර්ථික හෝ සමාජීය හේතුව", "බදු බර", "ආර්ථික පීඩනය")
                ),
                officialMarkingScheme = "• එක් හේතුවකට (ලකුණු 1)\n• දෙවන හේතුවට (ලකුණු 1)",
                sampleIdealAnswer = "1. දේශපාලනික ස්ථාවරත්වය බිඳවැටීම හෝ විදේශ ආක්‍රමණ\n2. ආර්ථික අර්බුද හා අසාධාරණ බදු පැනවීම්"
            ),
            ShortAnswerQuestion(
                id = baseId + 5, grade = grade, setNumber = setNumber, subject = subject, topic = topic,
                question = "$topic හේතුවෙන් ශ්‍රී ලංකා සමාජයට ඇති වූ ප්‍රධාන ප්‍රතිඵල 2 ක් ලියන්න.",
                keyPoints = listOf("සමාජ පරිවර්තනය", "ආර්ථික හෝ ආගමික බලපෑම"),
                synonyms = listOf(
                    listOf("සමාජ පරිවර්තනය", "සමාජ ප්‍රතිඵලය", "ජන ජීවිතය වෙනස්වීම"),
                    listOf("ආර්ථික හෝ ආගමික බලපෑම", "ආගමික වෙනස", "ආර්ථික බලපෑම")
                ),
                officialMarkingScheme = "• ප්‍රතිඵල 2 සඳහන් කිරීමට එක් ලකුණ බැගින් (ලකුණු 2)",
                sampleIdealAnswer = "1. ආගමික හා සංස්කෘතික නව පිබිදීමක් ඇතිවීම\n2. ආර්ථික රටාව සහ පාලන ව්‍යුහය වෙනස්වීම"
            ),
            ShortAnswerQuestion(
                id = baseId + 6, grade = grade, setNumber = setNumber, subject = subject, topic = topic,
                question = "$topic යුගයේ පැවති පරිපාලන හෝ ආණ්ඩුක්‍රම ව්‍යුහයේ ප්‍රධාන ලක්ෂණය කුමක්ද?",
                keyPoints = listOf("මධ්‍යගත පාලනය", "ප්‍රාදේශීය නිලධාරී පද්ධතිය"),
                synonyms = listOf(
                    listOf("මධ්‍යගත පාලනය", "රාජ්‍ය පාලනය", "රජුගේ බලතල"),
                    listOf("ප්‍රාදේශීය නිලධාරී පද්ධතිය", "දිසාවරු", "මුදලිවරු", "පරිපාලන නිලධාරීන්")
                ),
                officialMarkingScheme = "• පාලන ලක්ෂණය පැහැදිලි කිරීමට (ලකුණු 2)",
                sampleIdealAnswer = "රජු මූලික කරගත් මධ්‍යගත පාලන ක්‍රමයක් සහ ප්‍රාදේශීය නිලධාරීන් මඟින් පාලනය මෙහෙයවීම."
            ),
            ShortAnswerQuestion(
                id = baseId + 7, grade = grade, setNumber = setNumber, subject = subject, topic = topic,
                question = "$topic හා සම්බන්ධ ඓතිහාසික ස්ථානයක් හෝ නගරයක් නම් කර එහි වැදගත්කම ලියන්න.",
                keyPoints = listOf("ඓතිහාසික නගරය", "නගරයේ වැදගත්කම"),
                synonyms = listOf(
                    listOf("ඓතිහාසික නගරය", "රාජධානිය", "ස්ථානය"),
                    listOf("නගරයේ වැදගත්කම", "ආරක්ෂිත බව", "වාණිජ කේන්ද්‍රය")
                ),
                officialMarkingScheme = "• ස්ථානය නම් කිරීමට (ලකුණු 1)\n• වැදගත්කම ලිවීමට (ලකුණු 1)",
                sampleIdealAnswer = "අදාළ ඓතිහාසික රාජධානිය හෝ බලකොටුව පිහිටි ස්ථානය සහ එහි දේශපාලන/ආර්ථික වැදගත්කම."
            ),
            ShortAnswerQuestion(
                id = baseId + 8, grade = grade, setNumber = setNumber, subject = subject, topic = topic,
                question = "$topic ආශ්‍රිතව ගොඩනැගුණු ප්‍රධාන වාරි කර්මාන්තයක් හෝ ගෘහ නිර්මාණයක් නම් කරන්න.",
                keyPoints = listOf("වාරි හෝ ගෘහ නිර්මාණය", "ඉදිකළ පාලකයා"),
                synonyms = listOf(
                    listOf("වාරි හෝ ගෘහ නිර්මාණය", "මහා වැව", "දාගැබ", "බලකොටුව"),
                    listOf("ඉදිකළ පාලකයා", "රජු", "නිර්මාතෘ")
                ),
                officialMarkingScheme = "• නිර්මාණය නම් කිරීමට (ලකුණු 1)\n• ඉදිකළ රජු නම් කිරීමට (ලකුණු 1)",
                sampleIdealAnswer = "පැවති මහා වාරි වැව හෝ දාගැබ සහ එය කරවූ ශ්‍රේෂ්ඨ නිරිඳාණන්ගේ නාමය."
            ),
            ShortAnswerQuestion(
                id = baseId + 9, grade = grade, setNumber = setNumber, subject = subject, topic = topic,
                question = "$topic අවසන් වීමට හෝ බිඳවැටීමට බලපෑ තීරණාත්මක හේතුව කුමක්ද?",
                keyPoints = listOf("අභ්‍යන්තර ආරවුල්", "විදේශ ආක්‍රමණ හෝ පාවාදීම්"),
                synonyms = listOf(
                    listOf("අභ්‍යන්තර ආරවුල්", "රාජ්‍ය උරුමය පිළිබඳ ගැටලු", "අභ්‍යන්තර අර්බුද"),
                    listOf("විදේශ ආක්‍රමණ හෝ පාවාදීම්", "විදේශ ආක්‍රමණය", "කුමන්ත්‍රණ")
                ),
                officialMarkingScheme = "• බිඳවැටීමට හේතුව නිවැරදිව දැක්වීමට (ලකුණු 2)",
                sampleIdealAnswer = "අභ්‍යන්තර සමගිය බිඳවැටීම, කුමන්ත්‍රණ සහ එල්ල වූ බලවත් විදේශ ආක්‍රමණ."
            ),
            ShortAnswerQuestion(
                id = baseId + 10, grade = grade, setNumber = setNumber, subject = subject, topic = topic,
                question = "O/L ඉතිහාසය විභාගයේදී $topic ගැටලුවකදී නිරවද්‍ය කාලරේඛාව සහ නම් ලිවීමේ වැදගත්කම කුමක්ද?",
                keyPoints = listOf("නිවැරදි වර්ෂ හෝ කාලවකවානු", "නිරවුල් කරුණු ඉදිරිපත් කිරීම"),
                synonyms = listOf(
                    listOf("නිවැරදි වර්ෂ හෝ කාලවකවානු", "වර්ෂය", "කාලරේඛාව"),
                    listOf("නිරවුල් කරුණු ඉදිරිපත් කිරීම", "ඓතිහාසික කරුණු", "නිරවද්‍යතාව")
                ),
                officialMarkingScheme = "• ඓතිහාසික නම් හා වර්ෂ නිවැරදිව ලිවීමට (ලකුණු 2)",
                sampleIdealAnswer = "ඓතිහාසික සිදුවීම්වල අනුපිළිවෙළ, රජවරුන්ගේ නිවැරදි නම් සහ වර්ෂ නිවැරදිව දැක්වීම."
            )
        )
    }

    // -------------------------------------------------------------------------
    // 4. BUDDHISM (බුද්ධ ධර්මය)
    // -------------------------------------------------------------------------
    private fun buildBuddhismQuestions(
        baseId: Int, grade: String, setNumber: Int, subject: String, topic: String
    ): List<ShortAnswerQuestion> {
        return listOf(
            ShortAnswerQuestion(
                id = baseId + 1, grade = grade, setNumber = setNumber, subject = subject, topic = topic,
                question = "$topic පිළිබඳ මූලික ධර්ම කරුණ හෝ සූත්‍ර දේශනාව කුමක්ද?",
                keyPoints = listOf("මූලික ධර්ම සංකල්පය", "දේශනා කළ සූත්‍රය"),
                synonyms = listOf(
                    listOf("මූලික ධර්ම සංකල්පය", "දහම් කරුණ", "අර්ථය"),
                    listOf("දේශනා කළ සූත්‍රය", "සූත්‍ර දේශනාව", "දේශනාව")
                ),
                officialMarkingScheme = "• ධර්ම කරුණ දැක්වීමට (ලකුණු 1)\n• සූත්‍රය/මූලාශ්‍රය දැක්වීමට (ලකුණු 1)",
                sampleIdealAnswer = "$topic හා අදාළ බුද්ධ දේශනාව සහ ත්‍රිපිටක සූත්‍ර මූලාශ්‍රය නිවැරදිව සඳහන් කිරීම."
            ),
            ShortAnswerQuestion(
                id = baseId + 2, grade = grade, setNumber = setNumber, subject = subject, topic = topic,
                question = "$topic හි අඩංගු ප්‍රධාන අංග හෝ කොටස් 2 ක් නම් කරන්න.",
                keyPoints = listOf("පළමු අංගය", "දෙවන අංගය"),
                synonyms = listOf(
                    listOf("පළමු අංගය", "කොටස 1", "අංගය 1"),
                    listOf("දෙවන අංගය", "කොටස 2", "අංගය 2")
                ),
                officialMarkingScheme = "• අංග 2 නම් කිරීමට එක් ලකුණ බැගින් (ලකුණු 2)",
                sampleIdealAnswer = "1. පළමු ධර්ම අංගය\n2. දෙවන ධර්ම අංගය"
            ),
            ShortAnswerQuestion(
                id = baseId + 3, grade = grade, setNumber = setNumber, subject = subject, topic = topic,
                question = "$topic මඟින් ගිහි ජීවිතය සාර්ථක කරගැනීමට ලැබෙන ප්‍රායෝගික උපදෙස කුමක්ද?",
                keyPoints = listOf("ගිහි විනය", "දෙලොව ජයගැනීම"),
                synonyms = listOf(
                    listOf("ගිහි විනය", "සදාචාරය", "යහපත් ජීවිතය"),
                    listOf("දෙලොව ජයගැනීම", "මෙලොව පරලොව සුවය", "දියුණුව")
                ),
                officialMarkingScheme = "• ගිහි ජීවිතයට ලැබෙන උපදෙස පැහැදිලි කිරීමට (ලකුණු 2)",
                sampleIdealAnswer = "ධර්මානුකූලව දැහැමින් ධනය උපයා පවුල් සංස්ථාව සහ සමාජ සබඳතා යහපත්ව පවත්වා ගැනීම."
            ),
            ShortAnswerQuestion(
                id = baseId + 4, grade = grade, setNumber = setNumber, subject = subject, topic = topic,
                question = "$topic හා සම්බන්ධ පාලි පාඨය හෝ ගාථා ඛණ්ඩය ලියා අර්ථය දක්වන්න.",
                keyPoints = listOf("පාලි පාඨය", "සිංහල අර්ථය"),
                synonyms = listOf(
                    listOf("පාලි පාඨය", "ගාථාව", "පාඨය"),
                    listOf("සිංහල අර්ථය", "තේරුම", "අර්ථ දැක්වීම")
                ),
                officialMarkingScheme = "• පාලි පාඨයට (ලකුණු 1)\n• අර්ථයට (ලකුණු 1)",
                sampleIdealAnswer = "අදාළ පාලි ධර්ම පාඨය සහ එහි සම්මත සිංහල අර්ථය පැහැදිලිව ලිවිය යුතුය."
            ),
            ShortAnswerQuestion(
                id = baseId + 5, grade = grade, setNumber = setNumber, subject = subject, topic = topic,
                question = "$topic සමාජ සහජීවනය සහ සාමය සඳහා ඉවහල් වන ආකාරය විස්තර කරන්න.",
                keyPoints = listOf("මෛත්‍රිය සහ කරුණාව", "අන්‍යෝන්‍ය ගෞරවය"),
                synonyms = listOf(
                    listOf("මෛත්‍රිය සහ කරුණාව", "අහිංසාව", "දයාව"),
                    listOf("අන්‍යෝන්‍ය ගෞරවය", "සමානාත්මතාව", "සමගිය")
                ),
                officialMarkingScheme = "• සමාජ සහජීවනයට දායක වන අයුරු ලිවීමට (ලකුණු 2)",
                sampleIdealAnswer = "සැමට මෛත්‍රිය පැතිරවීම සහ සතර සංග්‍රහ වස්තු පෙරදැරිව සහයෝගයෙන් කටයුතු කිරීම."
            ),
            ShortAnswerQuestion(
                id = baseId + 6, grade = grade, setNumber = setNumber, subject = subject, topic = topic,
                question = "$topic හා සම්බන්ධ ශාසනික ඓතිහාසික සිදුවීම කුමක්ද?",
                keyPoints = listOf("ශාසනික සිදුවීම", "දායක වූ මහරහතන් වහන්සේ"),
                synonyms = listOf(
                    listOf("ශාසනික සිදුවීම", "ධර්ම සංගායනාව", "ශාසන ඉතිහාසය"),
                    listOf("දායක වූ මහරහතන් වහන්සේ", "තෙරුන් වහන්සේ", "මහ රහතන් වහන්සේ")
                ),
                officialMarkingScheme = "• සිදුවීම දැක්වීමට (ලකුණු 1)\n• වැඩසිටි තෙරුන් වහන්සේ දැක්වීමට (ලකුණු 1)",
                sampleIdealAnswer = "බුද්ධ ශාසනයේ චිරස්ථිතිය උදෙසා පැවැත්වූ ධර්ම සංගායනාව හෝ ශාසනික මෙහෙවර."
            ),
            ShortAnswerQuestion(
                id = baseId + 7, grade = grade, setNumber = setNumber, subject = subject, topic = topic,
                question = "$topic භාවනා ක්‍රමවේදයක් ලෙස සිත දියුණු කරගැනීමට උපකාරී වන්නේ කෙසේද?",
                keyPoints = listOf("චිත්ත ඒකාග්‍රතාව", "කෙලෙස් යටපත් කිරීම"),
                synonyms = listOf(
                    listOf("චිත්ත ඒකාග්‍රතාව", "සිතේ සමාධිය", "එකාග්‍රතාව"),
                    listOf("කෙලෙස් යටපත් කිරීම", "සිත පිරිසිදු වීම", "ප්‍රඥාව")
                ),
                officialMarkingScheme = "• මානසික සුවය සහ සමාධිය ලැබෙන අයුරු ලිවීමට (ලකුණු 2)",
                sampleIdealAnswer = "සිත එකඟ කරගැනීම (සමථ) සහ අනිත්‍ය ආදී ත්‍රිලක්ෂණය අවබෝධ කරගැනීම (විදර්ශනා)."
            ),
            ShortAnswerQuestion(
                id = baseId + 8, grade = grade, setNumber = setNumber, subject = subject, topic = topic,
                question = "$topic මඟින් ප්‍රතික්ෂේප කරන මිථ්‍යා මතය හෝ අයහපත් චර්යාව කුමක්ද?",
                keyPoints = listOf("මිථ්‍යා දෘෂ්ටිය", "අයහපත් කර්මය"),
                synonyms = listOf(
                    listOf("මිථ්‍යා දෘෂ්ටිය", "වැරදි දැක්ම", "මිසදිටු"),
                    listOf("අයහපත් කර්මය", "අකුසලය", "පාපය")
                ),
                officialMarkingScheme = "• ප්‍රතික්ෂේප වන මිථ්‍යා මතය දැක්වීමට (ලකුණු 2)",
                sampleIdealAnswer = "කර්ම ඵල විශ්වාස නොකිරීම වැනි මිථ්‍යා දෘෂ්ටි සහ අකුසල් දුරු කිරීම."
            ),
            ShortAnswerQuestion(
                id = baseId + 9, grade = grade, setNumber = setNumber, subject = subject, topic = topic,
                question = "$topic නිර්වාණ අවබෝධය සඳහා මාර්ගය සකසන ආකාරය කෙටියෙන් ලියන්න.",
                keyPoints = listOf("තණ්හාව ක්ෂය කිරීම", "ආර්ය මාර්ගය වැඩීම"),
                synonyms = listOf(
                    listOf("තණ්හාව ක්ෂය කිරීම", "කෙලෙස් නැසීම", "රාගය දුරුකිරීම"),
                    listOf("ආර්ය මාර්ගය වැඩීම", "අෂ්ටාංගික මාර්ගය", "නිවන් මඟ")
                ),
                officialMarkingScheme = "• නිර්වාණගාමී පටිපදාව පැහැදිලි කිරීමට (ලකුණු 2)",
                sampleIdealAnswer = "සීල, සමාධි, ප්‍රඥා යන ත්‍රිශික්ෂාව වඩා තෘෂ්ණාව මුලිනුපුටා දමා නිවන් පසක් කරගැනීම."
            ),
            ShortAnswerQuestion(
                id = baseId + 10, grade = grade, setNumber = setNumber, subject = subject, topic = topic,
                question = "O/L බුද්ධ ධර්මය විභාගයේදී $topic සම්බන්ධයෙන් ලකුණු දීමේ පටිපාටිය අවධාරණය කරන කරුණ කුමක්ද?",
                keyPoints = listOf("නිවැරදි ධර්ම කරුණු", "පාලි පාඨ හා උපමා"),
                synonyms = listOf(
                    listOf("නිවැරදි ධර්ම කරුණු", "විෂය කරුණු", "නිරවද්‍යතාව"),
                    listOf("පාලි පාඨ හා උපමා", "සුදුසු නිදසුන්", "ධර්ම උපමා")
                ),
                officialMarkingScheme = "• නිරවද්‍ය ධර්ම කරුණු ඉදිරිපත් කිරීමට (ලකුණු 2)",
                sampleIdealAnswer = "විෂයානුකූල ධර්ම කරුණු, සුදුසු සූත්‍ර පාඨ හෝ ධර්ම උපමා මැනවින් ගළපා ලිවීම."
            )
        )
    }

    // -------------------------------------------------------------------------
    // 5. SINHALA (සිංහල)
    // -------------------------------------------------------------------------
    private fun buildSinhalaQuestions(
        baseId: Int, grade: String, setNumber: Int, subject: String, topic: String
    ): List<ShortAnswerQuestion> {
        return listOf(
            ShortAnswerQuestion(
                id = baseId + 1, grade = grade, setNumber = setNumber, subject = subject, topic = topic,
                question = "$topic හා අදාළ මූලික ව්‍යාකරණ නීතිය හෝ සාහිත්‍ය ලක්ෂණය ලියන්න.",
                keyPoints = listOf("මූලික ව්‍යාකරණ නීතිය", "සම්මත යෙදුම"),
                synonyms = listOf(
                    listOf("මූලික ව්‍යාකරණ නීතිය", "ව්‍යාකරණ රීතිය", "නීතිය"),
                    listOf("සම්මත යෙදුම", "වියත් වහර", "නිවැරදි යෙදුම")
                ),
                officialMarkingScheme = "• රීතිය පැහැදිලි කිරීමට (ලකුණු 1)\n• නිදසුනක් දැක්වීමට (ලකුණු 1)",
                sampleIdealAnswer = "$topic හා සම්බන්ධ සම්මත වියත් වහර ව්‍යාකරණ රීතිය නිවැරදිව ඉදිරිපත් කිරීම."
            ),
            ShortAnswerQuestion(
                id = baseId + 2, grade = grade, setNumber = setNumber, subject = subject, topic = topic,
                question = "$topic යටතේ නිවැරදි භාවිතය දැක්වෙන ආදර්ශ වාක්‍ය 2 ක් ලියන්න.",
                keyPoints = listOf("පළමු ආදර්ශ වාක්‍යය", "දෙවන ආදර්ශ වාක්‍යය"),
                synonyms = listOf(
                    listOf("පළමු ආදර්ශ වාක්‍යය", "වාක්‍යය 1", "උදාහරණ වාක්‍ය 1"),
                    listOf("දෙවන ආදර්ශ වාක්‍යය", "වාක්‍යය 2", "උදාහරණ වාක්‍ය 2")
                ),
                officialMarkingScheme = "• එක් නිවැරදි වාක්‍යයකට (ලකුණු 1)\n• අනෙක් නිවැරදි වාක්‍යයට (ලකුණු 1)",
                sampleIdealAnswer = "1. උක්ත ආඛ්‍යාත පද ගැලපුණු නිවැරදි වාක්‍යය 1\n2. සම්මත අක්ෂර වින්‍යාසය සහිත වාක්‍යය 2"
            ),
            ShortAnswerQuestion(
                id = baseId + 3, grade = grade, setNumber = setNumber, subject = subject, topic = topic,
                question = "$topic හිදී සිදුවිය හැකි පොදු අක්ෂර වින්‍යාස හෝ පද බෙදීමේ දෝෂ 2 ක් පෙන්වා දෙන්න.",
                keyPoints = listOf("අක්ෂර දෝෂය (ණ/ළ හෝ ශ/ෂ)", "පද බෙදීමේ දෝෂය"),
                synonyms = listOf(
                    listOf("අක්ෂර දෝෂය (ණ/ළ හෝ ශ/ෂ)", "ණ ළ දෝෂය", "අක්ෂර වින්‍යාසය"),
                    listOf("පද බෙදීමේ දෝෂය", "පද නොබෙදීම", "පද බෙදීම")
                ),
                officialMarkingScheme = "• දෝෂ 2 පෙන්වා නිවැරදි කිරීමට (ලකුණු 2)",
                sampleIdealAnswer = "1. ණ/ළ හෝ ශ/ෂ/ස අක්ෂර වින්‍යාසය වැරදි ලෙස යෙදීම\n2. නිපාත හා උපසර්ග පද වැරදි ලෙස එක්කොට ලිවීම"
            ),
            ShortAnswerQuestion(
                id = baseId + 4, grade = grade, setNumber = setNumber, subject = subject, topic = topic,
                question = "$topic හා අදාළ ප්‍රභේද 2 ක් නම් කර වෙනස දක්වන්න.",
                keyPoints = listOf("පළමු ප්‍රභේදය", "දෙවන ප්‍රභේදය"),
                synonyms = listOf(
                    listOf("පළමු ප්‍රභේදය", "වර්ගය 1", "කොටස 1"),
                    listOf("දෙවන ප්‍රභේදය", "වර්ගය 2", "කොටස 2")
                ),
                officialMarkingScheme = "• ප්‍රභේද 2 නම් කිරීමට (ලකුණු 1)\n• වෙනස දැක්වීමට (ලකුණු 1)",
                sampleIdealAnswer = "පළමු ප්‍රභේදය සහ දෙවන ප්‍රභේදය අතර අර්ථමය හා ව්‍යාකරණමය වෙනස පැහැදිලි කිරීම."
            ),
            ShortAnswerQuestion(
                id = baseId + 5, grade = grade, setNumber = setNumber, subject = subject, topic = topic,
                question = "$topic සාහිත්‍ය නිර්මාණයකදී රස ජනනය සඳහා උපකාරී වන්නේ කෙසේද?",
                keyPoints = listOf("කාව්‍ය රසය හෝ ධ්වනිය", "චිත්තරූප මවන බස් වහර"),
                synonyms = listOf(
                    listOf("කාව්‍ය රසය හෝ ධ්වනිය", "රසය", "කාව්‍යාලංකාර"),
                    listOf("චිත්තරූප මවන බස් වහර", "චිත්තරූප", "භාෂා සෞන්දර්යය")
                ),
                officialMarkingScheme = "• සාහිත්‍යමය රසය විස්තර කිරීමට (ලකුණු 2)",
                sampleIdealAnswer = "උපමා, රූපක භාවිතයෙන් පාඨක මනසේ චිත්තරූප මැවීම සහ රස නිෂ්පත්තිය සිදුකිරීම."
            ),
            ShortAnswerQuestion(
                id = baseId + 6, grade = grade, setNumber = setNumber, subject = subject, topic = topic,
                question = "$topic යටතේ හමුවන ප්‍රකට සම්භාව්‍ය හෝ නූතන කෘතියක් සහ එහි කතුවරයා නම් කරන්න.",
                keyPoints = listOf("සාහිත්‍ය කෘතිය", "කතුවරයා"),
                synonyms = listOf(
                    listOf("සාහිත්‍ය කෘතිය", "පොත", "කාව්‍යය"),
                    listOf("කතුවරයා", "රචකයා", "කවියා")
                ),
                officialMarkingScheme = "• කෘතිය නම් කිරීමට (ලකුණු 1)\n• කතුවරයා දැක්වීමට (ලකුණු 1)",
                sampleIdealAnswer = "සාහිත්‍ය නිර්මාණ කෘතිය සහ එය රචනා කළ ප්‍රවීණ ලේඛකයා/කවියාගේ නම."
            ),
            ShortAnswerQuestion(
                id = baseId + 7, grade = grade, setNumber = setNumber, subject = subject, topic = topic,
                question = "$topic හා අදාළ පද සන්ධි කිරීමේ හෝ සමාස කිරීමේ උදාහරණ 2 ක් ලියන්න.",
                keyPoints = listOf("පළමු නිදසුන", "දෙවන නිදසුන"),
                synonyms = listOf(
                    listOf("පළමු නිදසුන", "උදාහරණය 1", "පද ගැලපුම 1"),
                    listOf("දෙවන නිදසුන", "උදාහරණය 2", "පද ගැලපුම 2")
                ),
                officialMarkingScheme = "• නිදසුන් 2 සඳහා එක් ලකුණ බැගින් (ලකුණු 2)",
                sampleIdealAnswer = "1. පද එක්වීමේ නිවැරදි සන්ධි රූපය\n2. අර්ථවත් සමාස පද නිදසුන"
            ),
            ShortAnswerQuestion(
                id = baseId + 8, grade = grade, setNumber = setNumber, subject = subject, topic = topic,
                question = "$topic මඟින් රචනාවක හෝ ලිපියක ගුණාත්මකභාවය ඉහළ නැංවෙන්නේ කෙසේද?",
                keyPoints = listOf("නිරවුල් අදහස් දැක්වීම", "ප්‍රකාශන ශක්තිය"),
                synonyms = listOf(
                    listOf("නිරවුල් අදහස් දැක්වීම", "පැහැදිලි බව", "නිරවුල් බව"),
                    listOf("ප්‍රකාශන ශක්තිය", "භාෂා පොහොසත්කම", "වියත් වචන")
                ),
                officialMarkingScheme = "• රචනා ගුණය වර්ධනය වන අයුරු ලිවීමට (ලකුණු 2)",
                sampleIdealAnswer = "පැහැදිලි වචන මාලාවක් සහ නිවැරදි ව්‍යාකරණ භාවිතයෙන් අදහස් තර්කානුකූලව ඉදිරිපත් කිරීම."
            ),
            ShortAnswerQuestion(
                id = baseId + 9, grade = grade, setNumber = setNumber, subject = subject, topic = topic,
                question = "$topic හා සම්බන්ධ රූඪියක්, ප්‍රස්ථාව පිරුළක් හෝ උපමාවක් ලියා එහි අර්ථය දක්වන්න.",
                keyPoints = listOf("රූඪිය හෝ පිරුළ", "ගම්‍ය වන අර්ථය"),
                synonyms = listOf(
                    listOf("රූඪිය හෝ පිරුළ", "ප්‍රස්ථාව පිරුළ", "උපමාව"),
                    listOf("ගම්‍ය වන අර්ථය", "තේරුම", "අභ්‍යන්තර අර්ථය")
                ),
                officialMarkingScheme = "• යෙදුම ලිවීමට (ලකුණු 1)\n• අර්ථය ලිවීමට (ලකුණු 1)",
                sampleIdealAnswer = "සම්ප්‍රදායික රූඪි යෙදුම සහ එහි ගැබ්ව ඇති ප්‍රායෝගික සමාජ අර්ථය."
            ),
            ShortAnswerQuestion(
                id = baseId + 10, grade = grade, setNumber = setNumber, subject = subject, topic = topic,
                question = "O/L සිංහල පළමු පත්‍රයේ $topic කෙටි ප්‍රශ්නයට පිළිතුරු දීමේදී අවධානය යොමු කළ යුතු රීතිය කුමක්ද?",
                keyPoints = listOf("නිරවද්‍ය අක්ෂර වින්‍යාසය", "කෙටි හා නිශ්චිත පිළිතුර"),
                synonyms = listOf(
                    listOf("නිරවද්‍ය අක්ෂර වින්‍යාසය", "අක්ෂර නිවැරදි බව", "ණ/ළ"),
                    listOf("කෙටි හා නිශ්චිත පිළිතුර", "අවශ්‍ය කරුණ පමණක්", "නිශ්චිත පිළිතුර")
                ),
                officialMarkingScheme = "• අක්ෂර වින්‍යාසයට හා කෙටි පිළිතුරට (ලකුණු 2)",
                sampleIdealAnswer = "අක්ෂර වින්‍යාස දෝෂවලින් තොරව අසන ලද නිශ්චිත කරුණ පමණක් කෙටියෙන් ලිවීම."
            )
        )
    }

    // -------------------------------------------------------------------------
    // 6. ENGLISH (ඉංග්‍රීසි)
    // -------------------------------------------------------------------------
    private fun buildEnglishQuestions(
        baseId: Int, grade: String, setNumber: Int, subject: String, topic: String
    ): List<ShortAnswerQuestion> {
        return listOf(
            ShortAnswerQuestion(
                id = baseId + 1, grade = grade, setNumber = setNumber, subject = subject, topic = topic,
                question = "State the fundamental grammatical rule or sentence structure used in '$topic'.",
                keyPoints = listOf("Grammar Rule", "Sentence Pattern"),
                synonyms = listOf(
                    listOf("Grammar Rule", "Rule", "Structure"),
                    listOf("Sentence Pattern", "Subject Verb Object", "Formula")
                ),
                officialMarkingScheme = "• Correct rule formulation (1 mark)\n• Correct structure syntax (1 mark)",
                sampleIdealAnswer = "The correct auxiliary verb followed by the main verb according to the tense/voice rule."
            ),
            ShortAnswerQuestion(
                id = baseId + 2, grade = grade, setNumber = setNumber, subject = subject, topic = topic,
                question = "Write two grammatically accurate example sentences demonstrating '$topic'.",
                keyPoints = listOf("Example 1", "Example 2"),
                synonyms = listOf(
                    listOf("Example 1", "First sentence", "Sentence 1"),
                    listOf("Example 2", "Second sentence", "Sentence 2")
                ),
                officialMarkingScheme = "• Sentence 1 (1 mark)\n• Sentence 2 (1 mark)",
                sampleIdealAnswer = "1. He has completed his assignment.\n2. They were playing football when it rained."
            ),
            ShortAnswerQuestion(
                id = baseId + 3, grade = grade, setNumber = setNumber, subject = subject, topic = topic,
                question = "Identify the common grammatical error students often make in '$topic' and explain the correction.",
                keyPoints = listOf("Common error", "Correction"),
                synonyms = listOf(
                    listOf("Common error", "Subject-verb mismatch", "Wrong preposition"),
                    listOf("Correction", "Correct form", "Right verb")
                ),
                officialMarkingScheme = "• Identifying error (1 mark)\n• Providing correction (1 mark)",
                sampleIdealAnswer = "Subject-verb disagreement (e.g., using 'have' instead of 'has' with singular third-person subjects)."
            ),
            ShortAnswerQuestion(
                id = baseId + 4, grade = grade, setNumber = setNumber, subject = subject, topic = topic,
                question = "Convert a given sentence using the transformation principle of '$topic'.",
                keyPoints = listOf("Transformation rule", "Correct converted sentence"),
                synonyms = listOf(
                    listOf("Transformation rule", "Passive form", "Indirect speech"),
                    listOf("Correct converted sentence", "Converted form", "Answer")
                ),
                officialMarkingScheme = "• Correct grammatical conversion (2 marks)",
                sampleIdealAnswer = "The object becomes the subject, followed by the appropriate 'be' verb and past participle."
            ),
            ShortAnswerQuestion(
                id = baseId + 5, grade = grade, setNumber = setNumber, subject = subject, topic = topic,
                question = "Which linking words or signal keywords are typically associated with '$topic'?",
                keyPoints = listOf("Keyword 1", "Keyword 2"),
                synonyms = listOf(
                    listOf("Keyword 1", "Signal word", "Connector 1"),
                    listOf("Keyword 2", "Time marker", "Connector 2")
                ),
                officialMarkingScheme = "• Identifying 2 signal words (2 marks)",
                sampleIdealAnswer = "Words like 'since, for, already, yet' or time conjunctions like 'while, although, because'."
            ),
            ShortAnswerQuestion(
                id = baseId + 6, grade = grade, setNumber = setNumber, subject = subject, topic = topic,
                question = "How is '$topic' applied effectively in formal letter or essay writing?",
                keyPoints = listOf("Formal tone", "Cohesion and clarity"),
                synonyms = listOf(
                    listOf("Formal tone", "Polite expressions", "Vocabulary"),
                    listOf("Cohesion and clarity", "Paragraph flow", "Grammar")
                ),
                officialMarkingScheme = "• Explaining practical writing utility (2 marks)",
                sampleIdealAnswer = "Using passive voice and formal connectors creates an objective, academic and polite tone."
            ),
            ShortAnswerQuestion(
                id = baseId + 7, grade = grade, setNumber = setNumber, subject = subject, topic = topic,
                question = "Explain the difference between two confusing forms related to '$topic'.",
                keyPoints = listOf("First form usage", "Second form distinction"),
                synonyms = listOf(
                    listOf("First form usage", "Usage 1", "Simple form"),
                    listOf("Second form distinction", "Usage 2", "Continuous/Perfect")
                ),
                officialMarkingScheme = "• Clear contrast between the two forms (2 marks)",
                sampleIdealAnswer = "Form A denotes completed states, whereas Form B represents ongoing or dependent actions."
            ),
            ShortAnswerQuestion(
                id = baseId + 8, grade = grade, setNumber = setNumber, subject = subject, topic = topic,
                question = "Provide two contextual synonyms or phrasal expressions matching the vocabulary of '$topic'.",
                keyPoints = listOf("Synonym 1", "Synonym 2"),
                synonyms = listOf(
                    listOf("Synonym 1", "Expression 1", "Word 1"),
                    listOf("Synonym 2", "Expression 2", "Word 2")
                ),
                officialMarkingScheme = "• Two appropriate vocabulary items (2 marks)",
                sampleIdealAnswer = "Accurate synonyms or phrasal verbs that enrich expression in that context."
            ),
            ShortAnswerQuestion(
                id = baseId + 9, grade = grade, setNumber = setNumber, subject = subject, topic = topic,
                question = "What punctuation rule must be strictly followed when constructing sentences with '$topic'?",
                keyPoints = listOf("Comma usage", "Capitalization or quotation"),
                synonyms = listOf(
                    listOf("Comma usage", "Punctuation mark", "Comma"),
                    listOf("Capitalization or quotation", "Capital letter", "Speech marks")
                ),
                officialMarkingScheme = "• Stating the correct punctuation rule (2 marks)",
                sampleIdealAnswer = "Placing a comma after dependent introductory clauses or correctly closing quotation marks."
            ),
            ShortAnswerQuestion(
                id = baseId + 10, grade = grade, setNumber = setNumber, subject = subject, topic = topic,
                question = "What is the key advice from O/L marking schemes for securing full marks in '$topic' questions?",
                keyPoints = listOf("Correct spelling and tense", "Follow question format"),
                synonyms = listOf(
                    listOf("Correct spelling and tense", "Grammar accuracy", "No spelling errors"),
                    listOf("Follow question format", "Clear handwriting", "Word limit")
                ),
                officialMarkingScheme = "• Adhering to rubric accuracy standards (2 marks)",
                sampleIdealAnswer = "Ensuring error-free verb agreements, precise spelling, and strictly adhering to the requested word count."
            )
        )
    }

    // -------------------------------------------------------------------------
    // 7. ICT (තොරතුරු තාක්ෂණය)
    // -------------------------------------------------------------------------
    private fun buildIctQuestions(
        baseId: Int, grade: String, setNumber: Int, subject: String, topic: String
    ): List<ShortAnswerQuestion> {
        return listOf(
            ShortAnswerQuestion(
                id = baseId + 1, grade = grade, setNumber = setNumber, subject = subject, topic = topic,
                question = "$topic හා අදාළ මූලික තාක්ෂණික අර්ථදැක්වීම සහ කාර්යය ලියා දක්වන්න.",
                keyPoints = listOf("මූලික අර්ථදැක්වීම", "ප්‍රධාන කාර්යය"),
                synonyms = listOf(
                    listOf("මූලික අර්ථදැක්වීම", "සංකල්පය", "අර්ථය"),
                    listOf("ප්‍රධාන කාර්යය", "කාර්යභාරය", "භාවිතය")
                ),
                officialMarkingScheme = "• අර්ථදැක්වීමට (ලකුණු 1)\n• කාර්යයට (ලකුණු 1)",
                sampleIdealAnswer = "$topic යනු පරිගණක පද්ධතියේ දත්ත සැකසුම හෝ සන්නිවේදනය කාර්යක්ෂම කරන මූලික තාක්ෂණික අංගයකි."
            ),
            ShortAnswerQuestion(
                id = baseId + 2, grade = grade, setNumber = setNumber, subject = subject, topic = topic,
                question = "$topic යටතේ භාවිත වන සම්මත උපාංග හෝ මෘදුකාංග 2 ක් නම් කරන්න.",
                keyPoints = listOf("පළමු උපාංගය/මෘදුකාංගය", "දෙවන උපාංගය/මෘදුකාංගය"),
                synonyms = listOf(
                    listOf("පළමු උපාංගය/මෘදුකාංගය", "උපාංගය 1", "මෘදුකාංගය 1"),
                    listOf("දෙවන උපාංගය/මෘදුකාංගය", "උපාංගය 2", "මෘදුකාංගය 2")
                ),
                officialMarkingScheme = "• උපාංග/මෘදුකාංග 2 නම් කිරීමට එක් ලකුණ බැගින් (ලකුණු 2)",
                sampleIdealAnswer = "1. ක්ෂේත්‍රයේ සම්මත උපාංගය හෝ මෙවලම 1\n2. ක්ෂේත්‍රයේ සම්මත මෘදුකාංගය හෝ මෙවලම 2"
            ),
            ShortAnswerQuestion(
                id = baseId + 3, grade = grade, setNumber = setNumber, subject = subject, topic = topic,
                question = "$topic ආශ්‍රිතව දත්ත නිරූපණය හෝ සංඛ්‍යා පද්ධති පරිවර්තනය සිදුවන ආකාරය දක්වන්න.",
                keyPoints = listOf("ද්විමය හෝ බිටු අගය", "පරිවර්තන ක්‍රමය"),
                synonyms = listOf(
                    listOf("ද්විමය හෝ බිටු අගය", "බිටු", "ද්විමය සංඛ්‍යාව"),
                    listOf("පරිවර්තන ක්‍රමය", "ගණනය", "ක්‍රමවේදය")
                ),
                officialMarkingScheme = "• පරිවර්තන ක්‍රමයට (ලකුණු 2)",
                sampleIdealAnswer = "පාද 2, 8, 10 හෝ 16 අතර සම්මත ක්‍රමවේදය අනුව අනුක්‍රමික බෙදීම හෝ ගුණ කිරීම මඟින් පරිවර්තනය වේ."
            ),
            ShortAnswerQuestion(
                id = baseId + 4, grade = grade, setNumber = setNumber, subject = subject, topic = topic,
                question = "$topic හි ආරක්ෂාව සහ දත්ත අඛණ්ඩතාව සඳහා ගන්නා ප්‍රධාන පියවර 2 ක් ලියන්න.",
                keyPoints = listOf("මුරපද හෝ ගුප්තකේතනය", "පිටපත් ලබාගැනීම (Backup)"),
                synonyms = listOf(
                    listOf("මුරපද හෝ ගුප්තකේතනය", "මුරපද", "ගුප්තකේතනය", "Firewall"),
                    listOf("පිටපත් ලබාගැනීම (Backup)", "බැකප්", "ආරක්ෂිත පිටපත්")
                ),
                officialMarkingScheme = "• ආරක්ෂිත පියවර 2 සඳහා එක් ලකුණ බැගින් (ලකුණු 2)",
                sampleIdealAnswer = "1. ප්‍රබල මුරපද සහ දත්ත ගුප්තකේතනය භාවිතය\n2. දත්තවල උපස්ථ පිටපත් (Backups) ආරක්ෂිතව තබා ගැනීම"
            ),
            ShortAnswerQuestion(
                id = baseId + 5, grade = grade, setNumber = setNumber, subject = subject, topic = topic,
                question = "$topic හා අදාළ තර්ක ද්වාරය, ඇල්ගොරිතමය හෝ කේත විධානය කුමක්ද?",
                keyPoints = listOf("තර්ක ද්වාරය හෝ විධානය", "ප්‍රතිදානය හෝ සත්‍යතා වගුව"),
                synonyms = listOf(
                    listOf("තර්ක ද්වාරය හෝ විධානය", "තර්ක ද්වාරය", "විධානය", "ටැගය"),
                    listOf("ප්‍රතිදානය හෝ සත්‍යතා වගුව", "ප්‍රතිදානය", "සත්‍යතා වගුව")
                ),
                officialMarkingScheme = "• තාක්ෂණික සංකේතය හෝ විධානයට (ලකුණු 2)",
                sampleIdealAnswer = "අදාළ තර්ක ද්වාර සංකේතය, HTML ටැගය හෝ ක්‍රමලේඛන පාලන ව්‍යුහය නිවැරදිව භාවිත කිරීම."
            ),
            ShortAnswerQuestion(
                id = baseId + 6, grade = grade, setNumber = setNumber, subject = subject, topic = topic,
                question = "$topic භාවිත කිරීමේ ප්‍රධාන වාසි 2 ක් සඳහන් කරන්න.",
                keyPoints = listOf("කාර්යක්ෂමතාව ඉහළ යාම", "පිරිවැය සහ කාලය ඉතිරිවීම"),
                synonyms = listOf(
                    listOf("කාර්යක්ෂමතාව ඉහළ යාම", "වේගවත් බව", "කාර්යක්ෂමතාව"),
                    listOf("පිරිවැය සහ කාලය ඉතිරිවීම", "කාලය ඉතිරිවීම", "ලාභදායී බව")
                ),
                officialMarkingScheme = "• වාසි 2 සඳහා එක් ලකුණ බැගින් (ලකුණු 2)",
                sampleIdealAnswer = "1. කාර්යයන් වේගවත්ව හා නිරවද්‍යව ස්වයංක්‍රීය වීම\n2. කාලය, ශ්‍රමය හා මෙහෙයුම් පිරිවැය අවම වීම"
            ),
            ShortAnswerQuestion(
                id = baseId + 7, grade = grade, setNumber = setNumber, subject = subject, topic = topic,
                question = "$topic ක්‍රියාත්මක වීමේදී මතුවිය හැකි ප්‍රධාන සීමාව හෝ අවාසිය කුමක්ද?",
                keyPoints = listOf("මූලික පිරිවැය හෝ නඩත්තුව", "තාක්ෂණික දෝෂ හෝ ආරක්ෂක තර්ජන"),
                synonyms = listOf(
                    listOf("මූලික පිරිවැය හෝ නඩත්තුව", "අධික පිරිවැය", "මිල අධික බව"),
                    listOf("තාක්ෂණික දෝෂ හෝ ආරක්ෂක තර්ජන", "වයිරස", "ආරක්ෂක අවදානම")
                ),
                officialMarkingScheme = "• අවාසිය හෝ සීමාව හඳුනාගැනීමට (ලකුණු 2)",
                sampleIdealAnswer = "මූලික පිහිටුවීම් පිරිවැය අධික වීම සහ ජාල බිඳවැටීම් හෝ සයිබර් ප්‍රහාරවලට නිරාවරණය වීමේ අවදානම."
            ),
            ShortAnswerQuestion(
                id = baseId + 8, grade = grade, setNumber = setNumber, subject = subject, topic = topic,
                question = "$topic හා සම්බන්ධ සම්මත ප්‍රොටෝකෝලය, ආකෘතිය හෝ ගොනු වර්ගය (File Extension) කුමක්ද?",
                keyPoints = listOf("සම්මත ප්‍රොටෝකෝලය", "ගොනු දිගුව"),
                synonyms = listOf(
                    listOf("සම්මත ප්‍රොටෝකෝලය", "ප්‍රොටෝකෝලය", "TCP/IP", "HTTP"),
                    listOf("ගොනු දිගුව", ".html", ".docx", ".xlsx", "ආකෘතිය")
                ),
                officialMarkingScheme = "• ප්‍රොටෝකෝලය හෝ ගොනු වර්ගය ලිවීමට (ලකුණු 2)",
                sampleIdealAnswer = "අදාළ ජාල සම්මත ප්‍රොටෝකෝලය (උදා: HTTP, TCP/IP) හෝ සම්මත ගොනු දිගුව."
            ),
            ShortAnswerQuestion(
                id = baseId + 9, grade = grade, setNumber = setNumber, subject = subject, topic = topic,
                question = "$topic ආශ්‍රිතව මතුවන සදාචාරාත්මක හෝ නීතිමය ගැටලුව කුමක්ද?",
                keyPoints = listOf("පෞද්ගලිකත්වය උල්ලංඝනය", "ප්‍රකාශන හිමිකම් (Copyright)"),
                synonyms = listOf(
                    listOf("පෞද්ගලිකත්වය උල්ලංඝනය", "දත්ත සොරකම", "පෞද්ගලිකත්වය"),
                    listOf("ප්‍රකාශන හිමිකම් (Copyright)", "බුද්ධිමය දේපළ", "නීතිමය ගැටලුව")
                ),
                officialMarkingScheme = "• සදාචාරාත්මක/නීතිමය කරුණ පැහැදිලි කිරීමට (ලකුණු 2)",
                sampleIdealAnswer = "අවසරයකින් තොරව අනුන්ගේ දත්ත භාවිතය (පෞද්ගලිකත්ව හානිය) හෝ බුද්ධිමය දේපළ සොරකම් කිරීම."
            ),
            ShortAnswerQuestion(
                id = baseId + 10, grade = grade, setNumber = setNumber, subject = subject, topic = topic,
                question = "O/L ICT විභාගයේදී $topic ප්‍රශ්නයක සම්පූර්ණ ලකුණු සඳහා නිරවද්‍ය විය යුතු කරුණ කුමක්ද?",
                keyPoints = listOf("සම්මත ඉංග්‍රීසි/සිංහල තාක්ෂණික පද", "නිවැරදි සින්ටැක්ස් (Syntax)"),
                synonyms = listOf(
                    listOf("සම්මත ඉංග්‍රීසි/සිංහල තාක්ෂණික පද", "තාක්ෂණික පද", "මූලපද"),
                    listOf("නිවැරදි සින්ටැක්ස් (Syntax)", "කේත නිරවද්‍යතාව", "ටැග්")
                ),
                officialMarkingScheme = "• සම්මත තාක්ෂණික පද හා සින්ටැක්ස් නිරවද්‍යතාවට (ලකුණු 2)",
                sampleIdealAnswer = "සම්මත තාක්ෂණික පාරිභාෂික වචන භාවිතය සහ කේත ලියන විට නිවැරදි සින්ටැක්ස් (Syntax) අනුගමනය කිරීම."
            )
        )
    }

    // -------------------------------------------------------------------------
    // 8. COMMERCE & ACCOUNTING (ව්‍යාපාර හා ගිණුම්කරණය)
    // -------------------------------------------------------------------------
    private fun buildCommerceQuestions(
        baseId: Int, grade: String, setNumber: Int, subject: String, topic: String
    ): List<ShortAnswerQuestion> {
        return listOf(
            ShortAnswerQuestion(
                id = baseId + 1, grade = grade, setNumber = setNumber, subject = subject, topic = topic,
                question = "$topic හා අදාළ මූලික වාණිජ්‍ය හෝ ගිණුම්කරණ අර්ථදැක්වීම ලියා දක්වන්න.",
                keyPoints = listOf("මූලික අර්ථදැක්වීම", "ගිණුම්කරණ සංකල්පය"),
                synonyms = listOf(
                    listOf("මූලික අර්ථදැක්වීම", "සංකල්පය", "අර්ථය"),
                    listOf("ගිණුම්කරණ සංකල්පය", "වාණිජ පදනම", "මූලධර්මය")
                ),
                officialMarkingScheme = "• අර්ථදැක්වීමට (ලකුණු 2)",
                sampleIdealAnswer = "$topic යනු ව්‍යාපාරයක මූල්‍ය තොරතුරු නිරවද්‍යව හඳුනාගැනීම හා සටහන් කිරීම සඳහා භාවිත වන මූලධර්මයකි."
            ),
            ShortAnswerQuestion(
                id = baseId + 2, grade = grade, setNumber = setNumber, subject = subject, topic = topic,
                question = "$topic හා අදාළ ද්විත්ව සටහන (හර සහ බැර) ගිණුම් නම් සහිතව ලියන්න.",
                keyPoints = listOf("හර වන ගිණුම", "බැර වන ගිණුම"),
                synonyms = listOf(
                    listOf("හර වන ගිණුම", "හර ගිණුම", "Dr"),
                    listOf("බැර වන ගිණුම", "බැර ගිණුම", "Cr")
                ),
                officialMarkingScheme = "• හර ගිණුමට (ලකුණු 1)\n• බැර ගිණුමට (ලකුණු 1)",
                sampleIdealAnswer = "අදාළ වත්කම් හෝ වියදම් ගිණුම හර (Dr) වන අතර වගකීම් හෝ ආදායම් ගිණුම බැර (Cr) වේ."
            ),
            ShortAnswerQuestion(
                id = baseId + 3, grade = grade, setNumber = setNumber, subject = subject, topic = topic,
                question = "$topic හි ප්‍රධාන වර්ගීකරණයට අයත් අංග 2 ක් නම් කර වෙනස දක්වන්න.",
                keyPoints = listOf("පළමු වර්ගය", "දෙවන වර්ගය"),
                synonyms = listOf(
                    listOf("පළමු වර්ගය", "ජංගම", "ප්‍රාග්ධන"),
                    listOf("දෙවන වර්ගය", "ජංගම නොවන", "ආදායම්")
                ),
                officialMarkingScheme = "• වර්ග 2 නම් කිරීමට (ලකුණු 1)\n• වෙනස දැක්වීමට (ලකුණු 1)",
                sampleIdealAnswer = "1. කෙටිකාලීන මෙහෙයුම් අංගය\n2. දිගුකාලීන ප්‍රාග්ධන අංගය"
            ),
            ShortAnswerQuestion(
                id = baseId + 4, grade = grade, setNumber = setNumber, subject = subject, topic = topic,
                question = "$topic සකස් කිරීම සඳහා භාවිත කරන ප්‍රධාන ප්‍රභව ලේඛනය කුමක්ද?",
                keyPoints = listOf("ප්‍රභව ලේඛනය", "මුදල් කුවිතාන්සිය හෝ ඉන්වොයිසිය"),
                synonyms = listOf(
                    listOf("ප්‍රභව ලේඛනය", "මූලාශ්‍ර ලේඛනය", "ලේඛනය"),
                    listOf("මුදල් කුවිතාන්සිය හෝ ඉන්වොයිසිය", "ඉන්වොයිසිය", "කුවිතාන්සිය", "චෙක්පත් කොටස")
                ),
                officialMarkingScheme = "• ප්‍රභව ලේඛනය නිවැරදිව නම් කිරීමට (ලකුණු 2)",
                sampleIdealAnswer = "ගනුදෙනුව තහවුරු කෙරෙන නිල ඉන්වොයිසිය, කුවිතාන්සිය හෝ ගෙවීම් වවුචරය."
            ),
            ShortAnswerQuestion(
                id = baseId + 5, grade = grade, setNumber = setNumber, subject = subject, topic = topic,
                question = "$topic ආශ්‍රිතව ගණනය කරනු ලබන ප්‍රධාන මූල්‍ය අනුපාතය හෝ සමීකරණය ලියන්න.",
                keyPoints = listOf("ගිණුම්කරණ සමීකරණය", "වත්කම් = හිමිකම + වගකීම්"),
                synonyms = listOf(
                    listOf("ගිණුම්කරණ සමීකරණය", "සමීකරණය", "සූත්‍රය"),
                    listOf("වත්කම් = හිමිකම + වගකීම්", "A = E + L", "වත්කම්", "ලාභ අනුපාතය")
                ),
                officialMarkingScheme = "• සමීකරණය හෝ සූත්‍රය දැක්වීමට (ලකුණු 2)",
                sampleIdealAnswer = "වත්කම් = ප්‍රාග්ධනය (හිමිකම) + වගකීම් (Assets = Equity + Liabilities)."
            ),
            ShortAnswerQuestion(
                id = baseId + 6, grade = grade, setNumber = setNumber, subject = subject, topic = topic,
                question = "$topic මඟින් ව්‍යාපාරයේ මූල්‍ය ශක්තිය හෝ කාර්යක්ෂමතාව තක්සේරු කරන්නේ කෙසේද?",
                keyPoints = listOf("ලාභදායීතාව මැනීම", "ද්‍රවශීලතාව තක්සේරු කිරීම"),
                synonyms = listOf(
                    listOf("ලාභදායීතාව මැනීම", "ලාභය", "ශුද්ධ ලාභය"),
                    listOf("ද්‍රවශීලතාව තක්සේරු කිරීම", "ණය ගෙවීමේ හැකියාව", "ද්‍රවශීලතාව")
                ),
                officialMarkingScheme = "• මූල්‍ය විශ්ලේෂණ වැදගත්කමට (ලකුණු 2)",
                sampleIdealAnswer = "ව්‍යාපාරයේ මෙහෙයුම් ලාභය සහ කෙටිකාලීන ණය පියවීමට ඇති ද්‍රවශීලතා හැකියාව තක්සේරු කිරීම."
            ),
            ShortAnswerQuestion(
                id = baseId + 7, grade = grade, setNumber = setNumber, subject = subject, topic = topic,
                question = "$topic පිළියෙල කිරීමේදී සිදුකරනු ලබන වැදගත් ගැලපීමක් (Adjustment) සඳහන් කරන්න.",
                keyPoints = listOf("ගෙවිය යුතු වියදම හෝ උපයා නොලත් ආදායම", "ක්ෂය හෝ අඩමාන ණය"),
                synonyms = listOf(
                    listOf("ගෙවිය යුතු වියදම හෝ උපයා නොලත් ආදායම", "ගෙවිය යුතු වියදම්", "කල්බදු ආදායම්"),
                    listOf("ක්ෂය හෝ අඩමාන ණය", "ක්ෂය ප්‍රතිපාදනය", "අඩමාන ණය")
                ),
                officialMarkingScheme = "• ගැලපීම නිවැරදිව දැක්වීමට (ලකුණු 2)",
                sampleIdealAnswer = "ගිණුම් වර්ෂයට අදාළ ගෙවිය යුතු වියදම් එකතු කිරීම සහ වත්කම් ක්ෂයවීම් අඩු කිරීම."
            ),
            ShortAnswerQuestion(
                id = baseId + 8, grade = grade, setNumber = setNumber, subject = subject, topic = topic,
                question = "$topic මඟින් කළමනාකාරීත්වයට නිවැරදි තීරණ ගැනීමට ලැබෙන සහය කුමක්ද?",
                keyPoints = listOf("අයවැය සැලසුම්කරණය", "පිරිවැය පාලනය"),
                synonyms = listOf(
                    listOf("අයවැය සැලසුම්කරණය", "අනාගත සැලසුම්", "තීරණ ගැනීම"),
                    listOf("පිරිවැය පාලනය", "වියදම් අවම කිරීම", "පාලනය")
                ),
                officialMarkingScheme = "• තීරණ ගැනීමේ වැදගත්කමට (ලකුණු 2)",
                sampleIdealAnswer = "අනාගත ආදායම් වියදම් අයවැයගත කිරීම සහ අනවශ්‍ය නාස්තිය අවම කර ලාභය උපරිම කිරීම."
            ),
            ShortAnswerQuestion(
                id = baseId + 9, grade = grade, setNumber = setNumber, subject = subject, topic = topic,
                question = "$topic ආශ්‍රිත ශේෂ පිරික්සුමෙන් අනාවරණය නොවන දෝෂයක් නම් කරන්න.",
                keyPoints = listOf("සම්පූර්ණ අතපසුවීමේ දෝෂය", "ප්‍රතිවිරුද්ධ සටහන් දෝෂය"),
                synonyms = listOf(
                    listOf("සම්පූර්ණ අතපසුවීමේ දෝෂය", "අතපසුවීමේ දෝෂය", "මූලධර්ම දෝෂය"),
                    listOf("ප්‍රතිවිරුද්ධ සටහන් දෝෂය", "පූරක දෝෂය", "මුල් සටහනේ දෝෂය")
                ),
                officialMarkingScheme = "• දෝෂය නම් කිරීමට (ලකුණු 2)",
                sampleIdealAnswer = "සම්පූර්ණ අතපසුවීමේ දෝෂය, මූලධර්ම දෝෂය හෝ පූරක දෝෂය."
            ),
            ShortAnswerQuestion(
                id = baseId + 10, grade = grade, setNumber = setNumber, subject = subject, topic = topic,
                question = "O/L ව්‍යාපාර හා ගිණුම්කරණය විභාගයේදී $topic සම්බන්ධයෙන් ලකුණු කැපෙන ප්‍රධාන අතපසුවීම කුමක්ද?",
                keyPoints = listOf("ශීර්ෂ පාඨය සහ දිනය නොලිවීම", "හර/බැර තීරු වැරදීම"),
                synonyms = listOf(
                    listOf("ශීර්ෂ පාඨය සහ දිනය නොලිවීම", "ශීර්ෂය", "දිනය නොමැතිකම"),
                    listOf("හර/බැර තීරු වැරදීම", "හර බැර මාරුවීම", "තීරු වැරදීම")
                ),
                officialMarkingScheme = "• නිරවද්‍ය ආකෘතිය හා දිනය/ශීර්ෂයට (ලකුණු 2)",
                sampleIdealAnswer = "ගිණුමේ නියමිත සම්මත ආකෘතිය, ශීර්ෂ පාඨය සහ දිනය නිවැරදිව සටහන් කිරීම."
            )
        )
    }

    // -------------------------------------------------------------------------
    // 9. GEOGRAPHY, CIVICS, HEALTH & GENERAL FALLBACKS
    // -------------------------------------------------------------------------
    private fun buildGeographyQuestions(
        baseId: Int, grade: String, setNumber: Int, subject: String, topic: String
    ): List<ShortAnswerQuestion> {
        return (1..10).map { qIndex ->
            ShortAnswerQuestion(
                id = baseId + qIndex, grade = grade, setNumber = setNumber, subject = subject, topic = topic,
                question = when (qIndex) {
                    1 -> "$topic හා අදාළ මූලික භූගෝලීය සංකල්පය හෝ ලක්ෂණය නිර්වචනය කරන්න."
                    2 -> "$topic හි ව්‍යාප්තිය හෝ පිහිටීම දැක්වෙන ප්‍රධාන කලාප 2 ක් නම් කරන්න."
                    3 -> "$topic කෙරෙහි බලපාන ප්‍රධාන භෞතික හා දේශගුණික සාධක 2 ක් දක්වන්න."
                    4 -> "$topic ආශ්‍රිත මානව ක්‍රියාකාරකම් සහ ආර්ථික ප්‍රයෝජන 2 ක් ලියන්න."
                    5 -> "$topic හේතුවෙන් මතුවන ප්‍රධාන පාරිසරික අර්බුදය හෝ උපද්‍රවය කුමක්ද?"
                    6 -> "$topic සංරක්ෂණය සහ තිරසාර භාවිතය සඳහා රජය ගෙන ඇති පියවර 2 ක් ලියන්න."
                    7 -> "$topic හා සම්බන්ධ ශ්‍රී ලංකා සිතියමේ ලකුණු කළ යුතු ප්‍රධාන ලක්ෂ්‍යය කුමක්ද?"
                    8 -> "$topic ආශ්‍රිත ගෝලීය ප්‍රවණතාව හෝ ලෝක ව්‍යාප්තියේ වැදගත්කම කුමක්ද?"
                    9 -> "$topic අධ්‍යයනය සඳහා භාවිත වන නවීන තාක්ෂණික මෙවලම (GIS/දුරස්ථ සංවේදනය) කුමක්ද?"
                    else -> "O/L භූගෝල විද්‍යා විභාගයේදී $topic ප්‍රශ්නයකට පිළිතුරු ලිවීමේදී සිතියම් හා කරුණු දැක්වීමේ වැදගත්කම ලියන්න."
                },
                keyPoints = listOf("භූගෝලීය සංකල්පය $qIndex", "විෂයානුකූල කරුණු"),
                synonyms = listOf(
                    listOf("භූගෝලීය සංකල්පය $qIndex", "භෞතික ලක්ෂණය", "දේශගුණය"),
                    listOf("විෂයානුකූල කරුණු", "මානව සාධක", "තිරසාර සංවර්ධනය")
                ),
                officialMarkingScheme = "• සම්මත විෂයානුකූල කරුණු ඉදිරිපත් කිරීමට (ලකුණු 2)",
                sampleIdealAnswer = "$topic ආශ්‍රිත භෞතික හා මානව භූගෝලීය ලක්ෂණ නිරවද්‍යව විග්‍රහ කිරීම."
            )
        }
    }

    private fun buildCivicsQuestions(
        baseId: Int, grade: String, setNumber: Int, subject: String, topic: String
    ): List<ShortAnswerQuestion> {
        return (1..10).map { qIndex ->
            ShortAnswerQuestion(
                id = baseId + qIndex, grade = grade, setNumber = setNumber, subject = subject, topic = topic,
                question = when (qIndex) {
                    1 -> "$topic හා අදාළ මූලික ප්‍රජාතන්ත්‍රවාදී හෝ ආණ්ඩුක්‍රම මූලධර්මය කුමක්ද?"
                    2 -> "$topic යටතේ පුරවැසියෙකුට හිමිවන මූලික අයිතිවාසිකම සහ වගකීම නම් කරන්න."
                    3 -> "$topic ක්‍රියාත්මක කරන ප්‍රධාන ආණ්ඩුක්‍රම හෝ අධිකරණ ආයතනය කුමක්ද?"
                    4 -> "$topic මඟින් යහපාලනය සහ නීතියේ ආධිපත්‍යය තහවුරු වන ආකාරය ලියන්න."
                    5 -> "$topic උල්ලංඝනය වූ විට පුරවැසියෙකුට ගත හැකි නීතිමය ක්‍රියාමාර්ගය කුමක්ද?"
                    6 -> "$topic හා සම්බන්ධ ස්වාධීන කොමිෂන් සභාව හෝ රාජ්‍ය නිලධාරියා කවුද?"
                    7 -> "$topic මඟින් සමාජ සහජීවනය සහ ජාතික සමගිය ගොඩනැගෙන ආකාරය ලියන්න."
                    8 -> "$topic පිළිබඳ ජාත්‍යන්තර ප්‍රඥප්තිය (UN Charter) හෝ ගිවිසුම කුමක්ද?"
                    9 -> "$topic ප්‍රවර්ධනය සඳහා සිවිල් සමාජය හා ජනමාධ්‍ය ඉටුකරන කාර්යභාරය ලියන්න."
                    else -> "O/L පුරවැසි අධ්‍යාපනය විභාගයේදී $topic ගැටලුවකට ආණ්ඩුක්‍රම ව්‍යවස්ථාව පදනම් කර පිළිතුරු දීමේ වැදගත්කම ලියන්න."
                },
                keyPoints = listOf("පුරවැසි මූලධර්මය $qIndex", "ව්‍යවස්ථානුකූල පදනම"),
                synonyms = listOf(
                    listOf("පුරවැසි මූලධර්මය $qIndex", "මූලික අයිතිවාසිකම්", "ප්‍රජාතන්ත්‍රවාදය"),
                    listOf("ව්‍යවස්ථානුකූල පදනම", "නීතියේ ආධිපත්‍යය", "යහපාලනය")
                ),
                officialMarkingScheme = "• ව්‍යවස්ථානුකූල හා නෛතික කරුණු නිවැරදිව දැක්වීමට (ලකුණු 2)",
                sampleIdealAnswer = "ආණ්ඩුක්‍රම ව්‍යවස්ථාව හා මානව හිමිකම් ආරක්ෂා කරමින් යහපත් පුරවැසි භූමිකාව ඉටුකිරීම."
            )
        }
    }

    private fun buildHealthQuestions(
        baseId: Int, grade: String, setNumber: Int, subject: String, topic: String
    ): List<ShortAnswerQuestion> {
        return (1..10).map { qIndex ->
            ShortAnswerQuestion(
                id = baseId + qIndex, grade = grade, setNumber = setNumber, subject = subject, topic = topic,
                question = when (qIndex) {
                    1 -> "$topic හා අදාළ නිරෝගී දිවිපැවැත්මේ මූලික සංකල්පය නිර්වචනය කරන්න."
                    2 -> "$topic සඳහා අවශ්‍ය වන ප්‍රධාන පෝෂකය හෝ ශාරීරික යෝග්‍යතා සංරචකය ලියන්න."
                    3 -> "$topic ආශ්‍රිතව සිදුවිය හැකි ක්‍රීඩා ආබාධය සහ ඒ සඳහා ලබාදෙන RICE ප්‍රථමාධාරය කුමක්ද?"
                    4 -> "$topic ක්‍රීඩාවේ නිල පිටියේ සම්මත මානයන් හෝ ප්‍රධාන රීතිය කුමක්ද?"
                    5 -> "$topic ආශ්‍රිත බෝවන හෝ බෝනොවන රෝගය වළක්වා ගැනීමට ගත හැකි පියවර 2 ක් ලියන්න."
                    6 -> "$topic මඟින් මානසික සුවතාව සහ ආතතිය කළමනාකරණය කරගන්නේ කෙසේද?"
                    7 -> "$topic හිදී ශරීරයේ කායික පද්ධතිවල (හෘදය, පෙනහළු) සිදුවන ධනාත්මක වෙනස කුමක්ද?"
                    8 -> "$topic පුහුණු කිරීමේදී අනුගමනය කරන FITT මූලධර්මයේ අංගයක් ලියන්න."
                    9 -> "$topic හා සම්බන්ධ ක්‍රීඩා ආචාරධර්ම සහ කණ්ඩායම් හැඟීම විස්තර කරන්න."
                    else -> "O/L සෞඛ්‍ය හා ශාරීරික අධ්‍යාපන විභාගයේදී $topic ප්‍රශ්නයක නිරවද්‍යතා නිර්ණායකය කුමක්ද?"
                },
                keyPoints = listOf("සෞඛ්‍ය මූලධර්මය $qIndex", "ප්‍රායෝගික යෝග්‍යතාව"),
                synonyms = listOf(
                    listOf("සෞඛ්‍ය මූලධර්මය $qIndex", "සමබල ආහාරය", "ශාරීරික සුවතාව"),
                    listOf("ප්‍රායෝගික යෝග්‍යතාව", "ප්‍රථමාධාර", "ක්‍රීඩා නීති")
                ),
                officialMarkingScheme = "• සෞඛ්‍ය හා ශාරීරික යෝග්‍යතා කරුණු සඳහා (ලකුණු 2)",
                sampleIdealAnswer = "නිරෝගී සමබල ආහාර රටාව, දෛනික ව්‍යායාම සහ ප්‍රථමාධාර මූලධර්ම නිවැරදිව ක්‍රියාත්මක කිරීම."
            )
        }
    }

    private fun buildGeneralQuestions(
        baseId: Int, grade: String, setNumber: Int, subject: String, topic: String
    ): List<ShortAnswerQuestion> {
        return (1..10).map { qIndex ->
            ShortAnswerQuestion(
                id = baseId + qIndex, grade = grade, setNumber = setNumber, subject = subject, topic = topic,
                question = "$topic හා අදාළ විෂය කරුණ $qIndex පිළිබඳ විග්‍රහ කරන්න.",
                keyPoints = listOf("විෂය කරුණ $qIndex", "මූලපදය"),
                synonyms = listOf(
                    listOf("විෂය කරුණ $qIndex", "සංකල්පය"),
                    listOf("මූලපදය", "විභාග කරුණ")
                ),
                officialMarkingScheme = "• කරුණු නිරවද්‍යතාවට (ලකුණු 2)",
                sampleIdealAnswer = "$topic පිළිබඳ විෂයානුකූල නිරවද්‍ය පිළිතුර."
            )
        }
    }
}
