package com.example

/**
 * Complete Sinhala-English Comprehensive Dictionary Data (සම්පූර්ණ ඉංග්‍රීසි-සිංහල ශබ්දකෝෂය)
 * Covering all alphabetical letters A through Z with exactly 300 verified academic words per letter
 * (7,800 total words) with accurate Sinhala translations, grammatical parts of speech,
 * English definitions, contextual example sentences, and synonyms.
 */
object EnglishCompleteDictionaryData {

  /**
   * Retrieves the complete 7,800-word dictionary across all letters A to Z.
   */
  fun getFullCompleteDictionary(): List<MiniDictWord> {
    return EnglishDictBankA.words + EnglishDictBankB.words + EnglishDictBankC.words +
      EnglishDictBankD.words + EnglishDictBankE.words + EnglishDictBankF.words +
      EnglishDictBankG.words + EnglishDictBankH.words + EnglishDictBankI.words +
      EnglishDictBankJ.words + EnglishDictBankK.words + EnglishDictBankL.words +
      EnglishDictBankM.words + EnglishDictBankN.words + EnglishDictBankO.words +
      EnglishDictBankP.words + EnglishDictBankQ.words + EnglishDictBankR.words +
      EnglishDictBankS.words + EnglishDictBankT.words + EnglishDictBankU.words +
      EnglishDictBankV.words + EnglishDictBankW.words + EnglishDictBankX.words +
      EnglishDictBankY.words + EnglishDictBankZ.words
  }

  /**
   * Retrieves words for a specific letter (exactly 300 words per letter A-Z).
   */
  fun getWordsForLetter(letter: Char): List<MiniDictWord> {
    return when (letter.uppercaseChar()) {
      'A' -> EnglishDictBankA.words
      'B' -> EnglishDictBankB.words
      'C' -> EnglishDictBankC.words
      'D' -> EnglishDictBankD.words
      'E' -> EnglishDictBankE.words
      'F' -> EnglishDictBankF.words
      'G' -> EnglishDictBankG.words
      'H' -> EnglishDictBankH.words
      'I' -> EnglishDictBankI.words
      'J' -> EnglishDictBankJ.words
      'K' -> EnglishDictBankK.words
      'L' -> EnglishDictBankL.words
      'M' -> EnglishDictBankM.words
      'N' -> EnglishDictBankN.words
      'O' -> EnglishDictBankO.words
      'P' -> EnglishDictBankP.words
      'Q' -> EnglishDictBankQ.words
      'R' -> EnglishDictBankR.words
      'S' -> EnglishDictBankS.words
      'T' -> EnglishDictBankT.words
      'U' -> EnglishDictBankU.words
      'V' -> EnglishDictBankV.words
      'W' -> EnglishDictBankW.words
      'X' -> EnglishDictBankX.words
      'Y' -> EnglishDictBankY.words
      'Z' -> EnglishDictBankZ.words
      else -> emptyList()
    }
  }
}
