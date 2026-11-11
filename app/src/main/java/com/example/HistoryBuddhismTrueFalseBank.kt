package com.example

object HistoryBuddhismTrueFalseBank {
  fun getHistoryQuestion(grade: Int, number: Int, batchIndex: Int, topicIndex: Int): TrueFalseTopicContent {
    val items = listOf(
      TrueFalseTopicContent(
        unitName = "අනුරාධපුර යුගය හා වාරි ශිෂ්ටාචාරය",
        statement = if (batchIndex % 2 == 0) "කාලා වැව සහ යෝධ ඇළ (ජය ගඟ) කරවන ලද්දේ ධාතුසේන රජතුමා විසිනි."
                    else "මහසෙන් රජතුමා විසින් කරවන ලද විශාලතම ස්තූපය රුවන්වැලි මහා සෑයයි.",
        isTrue = batchIndex % 2 == 0,
        justification = if (batchIndex % 2 == 0) "ධාතුසේන රජු කලා වැව තනවා මයිල 54 ක් දුර තිසා වැවට ජලය ගෙන යාමට යෝධ ඇළ හැදුවේය."
                        else "මහසෙන් රජු කරවූයේ ජේතවනාරාමයයි. රුවන්වැලි මහා සෑය කරවන ලද්දේ දුටුගැමුණු රජතුමා විසිනි.",
        examTrap = "යෝධ ඇළේ සැතපුමකට බැස්ම අඟල් 6 කි. එය අසමසම ඉංජිනේරු නිර්මාණයකි."
      ),
      TrueFalseTopicContent(
        unitName = "දුටුගැමුණු රජු හා එක්සේසත් කිරීම",
        statement = if (batchIndex % 2 == 0) "රුවන්වැලි සෑය, මිරිසවැටිය සහ ලෝවාමහාපාය කරවන ලද්දේ දුටුගැමුණු රජතුමා විසිනි."
                    else "එළාර රජු පරාජය කර ලංකාව එක්සේසත් කළේ වළගම්බා රජතුමාය.",
        isTrue = batchIndex % 2 == 0,
        justification = if (batchIndex % 2 == 0) "දුටුගැමුණු රජතුමා රට එක්සේසත් කර අනුරාධපුරයේ මෙම මහා විහාර සංකීර්ණ ඉදිකළේය."
                        else "එළාර රජු පරාජය කර රට එක්සේසත් කළේ දුටුගැමුණු රජුය. වළගම්බා රජු සත් ද්‍රවිඩයන් පරදා අභයගිරිය කරවීය.",
        examTrap = "ලෝවාමහාපාය මහල් 9 කින් සමන්විත වූ සංඝාවාසයකි."
      ),
      TrueFalseTopicContent(
        unitName = "පොළොන්නරු රාජධානිය හා මහා පරාක්‍රමබාහු",
        statement = if (batchIndex % 2 == 0) "'අහසින් වැටෙන එකදු දිය බිඳක්වත් මුහුදට නොයැවිය යුතුය' යන උදාර සංකල්පය ප්‍රකාශ කළේ මහා පරාක්‍රමබාහු රජුය."
                    else "පොළොන්නරුවේ ගල් විහාරයේ සමාධි හා සැතපෙන පිළිම නෙළවන ලද්දේ නිශ්ශංකමල්ල රජු විසිනි.",
        isTrue = batchIndex % 2 == 0,
        justification = if (batchIndex % 2 == 0) "පරාක්‍රම සමුද්‍රය නිර්මාණය කරමින් රට සහලින් ස්වයංපෝෂිත කළේ මහා පරාක්‍රමබාහු රජුය."
                        else "ගල් විහාරය (උත්තරාරාමය) කරවන ලද්දේද මහා පරාක්‍රමබාහු රජතුමා විසිනි.",
        examTrap = "පොළොන්නරුවේ පළමු රජු පළමුවන විජයබාහු රජු වේ (සොළීන් පරදවා රට නිදහස් කළේය)."
      ),
      TrueFalseTopicContent(
        unitName = "මහනුවර යුගය හා සෙංකඩගල රාජධානිය",
        statement = if (batchIndex % 2 == 0) "දන්ත ධාතූන් වහන්සේ සෙංකඩගල නුවරට වැඩමවා පළමුව දළදා මාළිගාවක් ඉදිකළේ පළමුවන විමලධර්මසූරිය රජුය."
                    else "සිංහලේ අවසාන රජු ලෙස සැලකෙන්නේ කීර්ති ශ්‍රී රාජසිංහ රජතුමාය.",
        isTrue = batchIndex % 2 == 0,
        justification = if (batchIndex % 2 == 0) "දන්ත ධාතුව මහනුවරට ගෙනැවිත් රාජ්‍යත්වයේ සංකේතය තහවුරු කළේ පළමුවන විමලධර්මසූරිය රජුය."
                        else "ලංකාවේ අවසන් රජු ශ්‍රී වික්‍රම රාජසිංහ රජතුමාය. ඔහු 1815 දී ඉංග්‍රීසීන්ගේ සිරකරුවෙකු විය.",
        examTrap = "කීර්ති ශ්‍රී රාජසිංහ රජු වැලිවිට අසරණ සරණ සරණංකර හිමියන්ගේ සහයෙන් උපසම්පදාව යළි පිහිටුවීය."
      ),
      TrueFalseTopicContent(
        unitName = "යටත් විජිත යුගය හා 1815 උඩරට ගිවිසුම",
        statement = if (batchIndex % 2 == 0) "1815 මාර්තු 02 වන දින මහනුවර මඟුල් මඩුවේදී උඩරට ගිවිසුම අත්සන් කිරීමෙන් මුළු ලංකාවම බ්‍රිතාන්‍ය කිරීටයට යටත් විය."
                    else "1818 වෙල්ලස්ස නිදහස් අරගලයට නායකත්වය දුන්නේ පුරන් අප්පු සහ ගොන්ගාලේගොඩ බණ්ඩාය.",
        isTrue = batchIndex % 2 == 0,
        justification = if (batchIndex % 2 == 0) "උඩරට ප්‍රධානීන් සහ බ්‍රිතාන්‍ය ආණ්ඩුකාර රොබට් බ්‍රවුන්රිග් අතර උඩරට ගිවිසුම අත්සන් කෙරිණි."
                        else "1818 අරගලයට නායකත්වය දුන්නේ කැප්පෙටිපොළ දිසාවයි. පුරන් අප්පු නායකත්වය දුන්නේ 1848 මාතලේ කැරැල්ලටය.",
        examTrap = "1818 සහ 1848 නිදහස් අරගල දෙකේ නායකයන් පටලවා නොගන්න."
      )
    )
    val gradeOffset = when (grade) {
      9 -> 0
      10 -> 2
      11 -> 4
      else -> 0
    }
    val safeIndex = (number - 1 + gradeOffset) % items.size
    val base = items[safeIndex]
    val isAlt = ((number - 1) / items.size) % 2 == 1
    if (!isAlt) return base
    return TrueFalseTopicContent(
      unitName = base.unitName,
      statement = "ප්‍රශ්න අංක ${number}: ${base.unitName} - ${base.statement}",
      isTrue = base.isTrue,
      justification = base.justification,
      examTrap = base.examTrap
    )
  }

  fun getBuddhismQuestion(grade: Int, number: Int, batchIndex: Int, topicIndex: Int): TrueFalseTopicContent {
    val items = listOf(
      TrueFalseTopicContent(
        unitName = "සිදුහත් චරිතය හා බුද්ධත්වය",
        statement = if (batchIndex % 2 == 0) "සිදුහත් තවුසාණන් වෙසක් පුර පසළොස්වක පොහෝ දින බුද්ධගයාවේ ජය ශ්‍රී මහා බෝධි මූලයේදී සම්මා සම්බුද්ධත්වයට පත්විය."
                    else "සිදුහත් කුමරු ගිහිගෙය අත්හැර අභිනිෂ්ක්‍රමණය කළේ වෙසක් පොහෝ දිනකය.",
        isTrue = batchIndex % 2 == 0,
        justification = if (batchIndex % 2 == 0) "චතුරාර්ය සත්‍යය අවබෝධ කරගනිමින් වෙසක් පුන් පොහෝ දින බුද්ධත්වයට පත්විය."
                        else "මහාභිනිෂ්ක්‍රමණය සිදුවූයේ ඇසළ පුර පසළොස්වක පොහෝ දිනකය.",
        examTrap = "උපත, බුදුවීම, පිරිනිවන්පෑම යන තෙමඟුලම වෙසක් පුන් පොහෝ දින සිදුවිය."
      ),
      TrueFalseTopicContent(
        unitName = "ප්‍රථම ධර්ම දේශනාව හා පස්වග තවුසන්",
        statement = if (batchIndex % 2 == 0) "බුදුරජාණන් වහන්සේගේ ප්‍රථම ධර්ම දේශනාව බරණැස ඉසිපතන මිගදායේදී දේශනා කළ ධම්මචක්කප්පවත්තන සූත්‍රයයි."
                    else "ධම්මචක්කප්පවත්තන සූත්‍රය ශ්‍රවණය කර ප්‍රථමයෙන් සෝවාන් ඵලයට පත්වූයේ අස්සජී තවුසාණන්ය.",
        isTrue = batchIndex % 2 == 0,
        justification = if (batchIndex % 2 == 0) "ඇසළ පුන් පොහෝ දින පස්වග මහණුන් උදෙසා දම්සක් පැවතුම් සූත්‍රය දේශනා කළ සේක."
                        else "ප්‍රථමයෙන් ධර්මය අවබෝධ කර සෝවාන් වූයේ කොණ්ඩඤ්ඤ තවුසාණන්ය ('අඤ්ඤාසි වත භෝ කොණ්ඩඤ්ඤෝ').",
        examTrap = "පස්වග තවුසන් රහත් වූයේ අනත්තලක්ඛණ සූත්‍රය ශ්‍රවණය කිරීමෙනි."
      ),
      TrueFalseTopicContent(
        unitName = "චතුරාර්ය සත්‍යය හා ආර්ය අෂ්ටාංගික මාර්ගය",
        statement = if (batchIndex % 2 == 0) "දුක්ඛ නිරෝධ ගාමිණී පටිපදාව හෙවත් දුක නැති කිරීමේ මාර්ගය ආර්ය අෂ්ටාංගික මාර්ගය (මධ්‍යම ප්‍රතිපදාව) වේ."
                    else "ආර්ය අෂ්ටාංගික මාර්ගයේ අංග 10 ක් අඩංගු වේ.",
        isTrue = batchIndex % 2 == 0,
        justification = if (batchIndex % 2 == 0) "සම්මා දිට්ඨි, සම්මා සංකප්ප ආදී අංග 8 කින් සමන්විත මධ්‍යම ප්‍රතිපදාව නිවනට මඟයි."
                        else "ආර්ය අෂ්ටාංගික මාර්ගයේ අංග 8 ක් අඩංගු වන අතර ඒවා සීල, සමාධි, ප්‍රඥා ත්‍රිශික්ෂාවට අයත් වේ.",
        examTrap = "අන්ත දෙක: කාමසුඛල්ලිකානුයෝගය (අධික සැප) සහ අත්තකිලමථානුයෝගය (ශරීරයට දැඩි දුක් දීම)."
      ),
      TrueFalseTopicContent(
        unitName = "ත්‍රිපිටකය හා ධර්ම සංගායනා",
        statement = if (batchIndex % 2 == 0) "ප්‍රථම ධර්ම සංගායනාව බුදුරදුන් පිරිනිවී තෙමසකින් රජගහනුවර සප්තපණ්ණී ගුහාද්වාරයේදී පැවැත්විණි."
                    else "ත්‍රිපිටකය ප්‍රථම වරට ග්‍රන්ථාරූඪ කරන ලද්දේ භාරතයේ අශෝක රජුගේ කාලයේදීය.",
        isTrue = batchIndex % 2 == 0,
        justification = if (batchIndex % 2 == 0) "අජාසත් රජුගේ දායකත්වයෙන් මහා කාශ්‍යප මහ රහතන් වහන්සේගේ ප්‍රධානත්වයෙන් පැවැත්විණි."
                        else "ත්‍රිපිටකය ග්‍රන්ථාරූඪ කරන ලද්දේ ශ්‍රී ලංකාවේ මාතලේ අලුවිහාරයේදී වළගම්බා රජු දවසය.",
        examTrap = "පළමු සංගායනාවේදී විනය උපාලි තෙරුන්ගෙන්ද, ධර්මය ආනන්ද තෙරුන්ගෙන්ද විචාරන ලදී."
      ),
      TrueFalseTopicContent(
        unitName = "මහින්දාගමනය හා ශ්‍රී ලංකා ශාසන ඉතිහාසය",
        statement = if (batchIndex % 2 == 0) "මිහිඳු මහ රහතන් වහන්සේ පොසොන් පුන් පොහෝ දින මිහින්තලයට වැඩම කර දේවානම්පියතිස්ස රජුට චූලහත්ථිපදෝපම සූත්‍රය දේශනා කළහ."
                    else "සංඝමිත්තා මහරහත් තෙරණිය ලංකාවට වැඩම කළේ වෙසක් පුන් පොහෝ දිනකය.",
        isTrue = batchIndex % 2 == 0,
        justification = if (batchIndex % 2 == 0) "පොසොන් පොහෝ දින මිහිඳු මාහිමියන් වැඩමවීමෙන් ලක්දිව බුදුසසුන නිල වශයෙන් පිහිටුවන ලදී."
                        else "සංඝමිත්තා තෙරණිය ජය ශ්‍රී මහා බෝධි දක්ෂිණ ශාඛාව රැගෙන වැඩම කළේ උඳුවප් පුන් පොහෝ දිනකය.",
        examTrap = "මිහිඳු හිමියන් රජුගේ බුද්ධිය පරීක්ෂා කළේ අඹ ගස සහ ඥාතීන් මුල් කරගෙනය."
      )
    )
    val bGradeOffset = when (grade) {
      9 -> 0
      10 -> 2
      11 -> 4
      else -> 0
    }
    val safeIndex = (number - 1 + bGradeOffset) % items.size
    val base = items[safeIndex]
    val isAlt = ((number - 1) / items.size) % 2 == 1
    if (!isAlt) return base
    return TrueFalseTopicContent(
      unitName = base.unitName,
      statement = "ප්‍රශ්න අංක ${number}: ${base.unitName} - ${base.statement}",
      isTrue = base.isTrue,
      justification = base.justification,
      examTrap = base.examTrap
    )
  }
}
