package com.example

import android.content.Context
import androidx.test.core.app.ApplicationProvider
import org.junit.Assert.assertEquals
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config

@RunWith(RobolectricTestRunner::class)
@Config(sdk = [36])
class ExampleRobolectricTest {

  @Test
  fun `read string from context`() {
    val context = ApplicationProvider.getApplicationContext<Context>()
    val appName = context.getString(R.string.app_name)
    assertEquals("O/L Guru", appName)
  }

  @Test
  fun `verify quiz sets have distinct questions across all 10 sets`() {
    val scienceData = QuizRepository.getQuizDataForSubject("10", "විද්‍යාව")
    val scienceSets = scienceData.quiz_sets
    assertEquals(10, scienceSets.size)

    val allScienceQuestions = scienceSets.flatMap { it.questions.map { q -> q.question_text } }
    assertEquals(100, allScienceQuestions.size)
    // Every question in science must be distinct (no duplicates)
    assertEquals(100, allScienceQuestions.toSet().size)

    val geoData = QuizRepository.getQuizDataForSubject("10", "භූගෝල විද්‍යාව")
    val geoSets = geoData.quiz_sets
    assertEquals(10, geoSets.size)
    val allGeoQuestions = geoSets.flatMap { it.questions.map { q -> q.question_text } }
    assertEquals(100, allGeoQuestions.size)
    assertEquals(100, allGeoQuestions.toSet().size)

    // Verify Science and Geography have 0 intersection (strictly separated)
    val overlap = allScienceQuestions.toSet().intersect(allGeoQuestions.toSet())
    assertEquals(0, overlap.size)
  }

  @Test
  fun `verify syllabus chapters are correctly loaded from new data providers`() {
    val scienceChapters = ChapterRepository.getChaptersForSubject("10", "Science", "science")
    // Based on AudioChapterScienceMathData, science grade 10 has 6 chapters
    assertEquals(6, scienceChapters.size)
    assertEquals("1 වන පරිච්ඡේදය: ජීවීන්ගේ ලක්ෂණ හා සෛලීය සංවිධානය", scienceChapters[0].title)

    val historyChapters = ChapterRepository.getChaptersForSubject("11", "History", "history")
    // Based on AudioChapterHumanitiesData, history grade 11 has 5 chapters
    assertEquals(5, historyChapters.size)
    assertEquals("1 වන පරිච්ඡේදය: යුරෝපීය ජාතීන්ගේ ආගමනය (පෘතුගීසි හා ලන්දේසි පාලනය)", historyChapters[0].title)
  }
}
