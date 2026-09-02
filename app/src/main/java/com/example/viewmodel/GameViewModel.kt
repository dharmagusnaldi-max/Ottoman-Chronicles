package com.example.viewmodel

import androidx.lifecycle.ViewModel
import com.example.data.QuizRepository
import com.example.model.BadgeReward
import com.example.model.CivilizationPillar
import com.example.model.GameEngineOutput
import com.example.model.GamePhase
import com.example.model.LevelProgress
import com.example.model.Question
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

data class GameUiState(
  val currentPhase: GamePhase = GamePhase.COVER,
  val currentQuestionIndex: Int = 0,
  val selectedOption: Char? = null,
  val isSubmitted: Boolean = false,
  val isCorrect: Boolean? = null,
  val score: Int = 0,
  val streak: Int = 0,
  val maxStreak: Int = 0,
  val userAnswers: Map<Int, Char> = emptyMap(),
  val wisdomFragments: List<String> = emptyList(),
  val isJsonEngineOpen: Boolean = false,
  val selectedPillarId: String = "pillar_a",
  val reviewExpandedQuestionId: Int? = null
)

class GameViewModel : ViewModel() {

  private val _uiState = MutableStateFlow(GameUiState())
  val uiState: StateFlow<GameUiState> = _uiState.asStateFlow()

  val questions: List<Question> = QuizRepository.questions
  val levels: List<LevelProgress> = QuizRepository.levels
  val pillars: List<CivilizationPillar> = QuizRepository.civilizationPillars

  val currentQuestion: Question
    get() = questions.getOrElse(_uiState.value.currentQuestionIndex) { questions.first() }

  fun startAdventure() {
    _uiState.update { it.copy(currentPhase = GamePhase.INTRO) }
  }

  fun showInstructions() {
    _uiState.update { it.copy(currentPhase = GamePhase.INSTRUCTIONS) }
  }

  fun backToCover() {
    _uiState.update { it.copy(currentPhase = GamePhase.COVER) }
  }

  fun continueStory() {
    _uiState.update { it.copy(currentPhase = GamePhase.INSTRUCTIONS) }
  }

  fun goToLevelMap() {
    _uiState.update { it.copy(currentPhase = GamePhase.LEVEL_MAP) }
  }

  fun startLevel(levelId: Int) {
    val targetIndex = questions.indexOfFirst { it.levelId == levelId }
    val newIndex = if (targetIndex >= 0) targetIndex else 0
    _uiState.update {
      it.copy(
        currentPhase = GamePhase.PLAYING,
        currentQuestionIndex = newIndex,
        selectedOption = null,
        isSubmitted = false,
        isCorrect = null
      )
    }
  }

  fun startPlaying() {
    _uiState.update {
      it.copy(
        currentPhase = GamePhase.PLAYING,
        currentQuestionIndex = 0,
        selectedOption = null,
        isSubmitted = false,
        isCorrect = null
      )
    }
  }

  fun selectOption(optionChar: Char) {
    if (_uiState.value.isSubmitted) return
    _uiState.update { it.copy(selectedOption = optionChar) }
  }

  fun submitAnswer() {
    val state = _uiState.value
    if (state.selectedOption == null || state.isSubmitted) return

    val question = currentQuestion
    val correct = (state.selectedOption == question.correctOption)
    val pointsForQuestion = if (correct) 100 else 0
    val streakBonus = if (correct && state.streak >= 1) 25 else 0
    val totalGain = pointsForQuestion + streakBonus

    val newStreak = if (correct) state.streak + 1 else 0
    val newMaxStreak = maxOf(state.maxStreak, newStreak)

    val newFragments = if (correct && !state.wisdomFragments.contains(question.wisdomFragmentTitle)) {
      state.wisdomFragments + question.wisdomFragmentTitle
    } else {
      state.wisdomFragments
    }

    _uiState.update {
      it.copy(
        isSubmitted = true,
        isCorrect = correct,
        score = it.score + totalGain,
        streak = newStreak,
        maxStreak = newMaxStreak,
        userAnswers = it.userAnswers + (question.id to state.selectedOption),
        wisdomFragments = newFragments
      )
    }
  }

  fun nextQuestion() {
    val state = _uiState.value
    val nextIdx = state.currentQuestionIndex + 1

    if (nextIdx < questions.size) {
      _uiState.update {
        it.copy(
          currentQuestionIndex = nextIdx,
          selectedOption = null,
          isSubmitted = false,
          isCorrect = null
        )
      }
    } else {
      // Completed all 15 questions -> Go to Ending & Recap
      _uiState.update {
        it.copy(
          currentPhase = GamePhase.ENDING,
          selectedOption = null,
          isSubmitted = false,
          isCorrect = null
        )
      }
    }
  }

  fun openCivilizationAnalysis(pillarId: String = "pillar_a") {
    _uiState.update {
      it.copy(
        currentPhase = GamePhase.CIVILIZATION_ANALYSIS,
        selectedPillarId = pillarId
      )
    }
  }

  fun selectPillar(pillarId: String) {
    _uiState.update { it.copy(selectedPillarId = pillarId) }
  }

  fun restartGame() {
    _uiState.value = GameUiState(currentPhase = GamePhase.COVER)
  }

  fun toggleJsonEngine(isOpen: Boolean) {
    _uiState.update { it.copy(isJsonEngineOpen = isOpen) }
  }

  fun toggleReviewAccordion(questionId: Int) {
    _uiState.update {
      it.copy(
        reviewExpandedQuestionId = if (it.reviewExpandedQuestionId == questionId) null else questionId
      )
    }
  }

  fun getEarnedBadge(): BadgeReward {
    return QuizRepository.getBadgeForScore(_uiState.value.score)
  }

  fun getEngineOutput(): GameEngineOutput {
    val state = _uiState.value
    val question = currentQuestion
    val optionsMap = question.options.associate { "${it.id}" to it.text }

    val feedback = if (state.isSubmitted) {
      if (state.isCorrect == true) {
        "BENAR! +100 Poin. ${question.explanation}"
      } else {
        "KURANG TEPAT. Jawaban benar: [${question.correctOption}]. ${question.explanation}"
      }
    } else {
      "Menunggu aksi pemain..."
    }

    return GameEngineOutput(
      turnNumber = state.currentQuestionIndex + 1,
      headerLocation = "${question.levelName} | ${question.locationEra}",
      visualNarrative = question.narrative,
      question = question.questionText,
      options = optionsMap,
      userAnswer = state.selectedOption?.toString(),
      isCorrect = state.isCorrect,
      educationalFeedback = feedback,
      currentScore = state.score,
      currentStreak = state.streak,
      wisdomFragmentsCount = state.wisdomFragments.size,
      activePhase = state.currentPhase.name
    )
  }

  fun getEngineJsonString(): String {
    val out = getEngineOutput()
    val optionsFormatted = out.options.entries.joinToString(",\n    ") { """"${it.key}": "${it.value.replace("\"", "\\\"")}"""" }
    
    return """
{
  "game_title": "Ottoman Chronicles: Conquest of Wisdom",
  "engine_state": "OTTMAN_LOGIC_ENGINE_V1.0",
  "turn_number": ${out.turnNumber},
  "phase": "${out.activePhase}",
  "header_location": "${out.headerLocation.replace("\"", "\\\"")}",
  "visual_narrative": "${out.visualNarrative.replace("\"", "\\\"")}",
  "challenge_question": "${out.question.replace("\"", "\\\"")}",
  "options": {
    $optionsFormatted
  },
  "player_input": {
    "selected_option": ${if (out.userAnswer != null) "\"${out.userAnswer}\"" else "null"},
    "is_correct": ${out.isCorrect}
  },
  "educational_feedback": "${out.educationalFeedback.replace("\"", "\\\"")}",
  "gamification": {
    "score": ${out.currentScore},
    "streak": ${out.currentStreak},
    "fragments_collected": ${out.wisdomFragmentsCount}
  }
}
""".trimIndent()
  }
}
