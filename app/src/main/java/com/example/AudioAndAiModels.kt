package com.example

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.speech.RecognitionListener
import android.speech.RecognizerIntent
import android.speech.SpeechRecognizer
import android.speech.tts.TextToSpeech
import android.widget.Toast
import androidx.compose.animation.*
import androidx.compose.animation.core.*
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import com.example.ui.theme.*
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import java.util.Locale

// --------------------------------------------------
// 1. DATA MODELS & JSON SCHEMA FOR CHAPTERS & AUDIO
// --------------------------------------------------

data class ChapterItem(
  val chapter_id: Int,
  val title: String,
  val page_start: Int,
  val page_end: Int,
  val audio_note_url: String,
  val audio_duration: String,
  val summary_bullets: List<String>,
  val read_aloud_text: String
)

data class SubjectHubData(
  val grade: String,
  val subject: String,
  val short_notes_pdf_url: String,
  val chapters: List<ChapterItem>,
  val quiz_sets: List<QuizSet>
)


// --------------------------------------------------
// 2. CHAPTER REPOSITORY (100+ Pages Indexed Data)
// --------------------------------------------------

object ChapterRepository {

  fun getSubjectHubData(grade: String, subjectName: String, pdfUrl: String = ""): SubjectHubData {
    val norm = normalizeSubjectKey(subjectName)
    val chapters = getChaptersForSubject(grade, subjectName, norm)
    val quizData = QuizRepository.getQuizDataForSubject(grade, subjectName, pdfUrl)

    return SubjectHubData(
      grade = grade,
      subject = subjectName,
      short_notes_pdf_url = if (pdfUrl.isNotBlank() && !pdfUrl.contains("1sample_100page_notes")) pdfUrl else "https://drive.google.com/file/d/1V3y65z_15X6zjruQ_I11WhG4EOfDHGm-/preview",
      chapters = chapters,
      quiz_sets = quizData.quiz_sets
    )
  }

  fun getChaptersForSubject(grade: String, subjectName: String, norm: String): List<ChapterItem> {
    return when (norm) {
      "science" -> AudioChapterScienceMathData.getScienceChapters(grade)
      "math" -> AudioChapterScienceMathData.getMathChapters(grade)
      "history" -> AudioChapterHumanitiesData.getHistoryChapters(grade)
      "sinhala" -> AudioChapterHumanitiesData.getSinhalaChapters(grade)
      "buddhism" -> AudioChapterHumanitiesData.getBuddhismChapters(grade)
      "geography" -> AudioChapterHumanitiesData.getGeographyChapters(grade)
      "ict" -> AudioChapterAppliedData.getIctChapters(grade)
      "commerce" -> AudioChapterAppliedData.getCommerceChapters(grade)
      "health" -> AudioChapterAppliedData.getHealthChapters(grade)
      "agriculture" -> AudioChapterAppliedData.getAgriChapters(grade)
      "english" -> AudioChapterAppliedData.getEnglishChapters(grade)
      else -> AudioChapterAppliedData.getElectiveChapters(norm, subjectName)
    }
  }

  // Deep-index search function that searches the 100+ page syllabus
  fun searchPdfIndex(query: String, chapters: List<ChapterItem>): List<SearchResultItem> {
    if (query.isBlank()) return emptyList()
    val cleanQuery = query.trim().lowercase()

    val results = mutableListOf<SearchResultItem>()
    for (ch in chapters) {
      val titleMatch = ch.title.lowercase().contains(cleanQuery)
      val bulletMatches = ch.summary_bullets.filter { it.lowercase().contains(cleanQuery) }
      val textMatch = ch.read_aloud_text.lowercase().contains(cleanQuery)

      if (titleMatch || bulletMatches.isNotEmpty() || textMatch) {
        val snippet = when {
          bulletMatches.isNotEmpty() -> bulletMatches.first()
          textMatch -> ch.read_aloud_text.take(90) + "..."
          else -> ch.title
        }
        results.add(
          SearchResultItem(
            chapter = ch,
            targetPage = ch.page_start,
            matchSnippet = snippet,
            matchType = if (titleMatch) "පරිච්ඡේද මාතෘකාව" else "සටහන් අන්තර්ගතය"
          )
        )
      }
    }
    return results
  }
}

data class SearchResultItem(
  val chapter: ChapterItem,
  val targetPage: Int,
  val matchSnippet: String,
  val matchType: String
)
