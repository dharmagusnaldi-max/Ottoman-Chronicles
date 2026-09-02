package com.example

import com.example.data.QuizRepository
import com.example.model.GamePhase
import com.example.viewmodel.GameViewModel
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Test

class ExampleUnitTest {

  private lateinit var viewModel: GameViewModel

  @Before
  fun setUp() {
    viewModel = GameViewModel()
  }

  @Test
  fun testQuizRepositoryContent() {
    val questions = QuizRepository.questions
    assertEquals(15, questions.size)

    val pillars = QuizRepository.civilizationPillars
    assertEquals(4, pillars.size)

    val levels = QuizRepository.levels
    assertEquals(5, levels.size)
  }

  @Test
  fun testGameFlowScoringAndStreak() {
    // Initial State
    assertEquals(GamePhase.COVER, viewModel.uiState.value.currentPhase)
    assertEquals(0, viewModel.uiState.value.score)
    assertEquals(0, viewModel.uiState.value.streak)

    // Start Play
    viewModel.startPlaying()
    assertEquals(GamePhase.PLAYING, viewModel.uiState.value.currentPhase)

    // Answer Q1 correctly
    val q1 = viewModel.currentQuestion
    viewModel.selectOption(q1.correctOption)
    viewModel.submitAnswer()

    assertTrue(viewModel.uiState.value.isSubmitted)
    assertEquals(true, viewModel.uiState.value.isCorrect)
    assertEquals(100, viewModel.uiState.value.score)
    assertEquals(1, viewModel.uiState.value.streak)
    assertEquals(1, viewModel.uiState.value.wisdomFragments.size)

    // Next Question
    viewModel.nextQuestion()
    assertEquals(1, viewModel.uiState.value.currentQuestionIndex)

    // Answer Q2 correctly with streak bonus
    val q2 = viewModel.currentQuestion
    viewModel.selectOption(q2.correctOption)
    viewModel.submitAnswer()

    // 100 base + 25 combo bonus
    assertEquals(225, viewModel.uiState.value.score)
    assertEquals(2, viewModel.uiState.value.streak)
  }

  @Test
  fun testJsonEngineStructuredOutput() {
    val json = viewModel.getEngineJsonString()
    assertNotNull(json)
    assertTrue(json.contains("\"game_title\": \"Ottoman Chronicles: Conquest of Wisdom\""))
    assertTrue(json.contains("\"phase\""))
    assertTrue(json.contains("\"visual_narrative\""))
    assertTrue(json.contains("\"gamification\""))
  }
}
