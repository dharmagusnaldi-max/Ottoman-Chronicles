package com.example

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.animation.Crossfade
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.model.GamePhase
import com.example.ui.components.CivilizationAnalysisScreen
import com.example.ui.components.CoverScreen
import com.example.ui.components.EndingRecapScreen
import com.example.ui.components.InstructionsMapScreen
import com.example.ui.components.JsonEngineDialog
import com.example.ui.components.LevelMapScreen
import com.example.ui.components.PlayScreen
import com.example.ui.theme.MyApplicationTheme
import com.example.viewmodel.GameViewModel

class MainActivity : ComponentActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    enableEdgeToEdge()
    setContent {
      MyApplicationTheme {
        Surface(
          modifier = Modifier.fillMaxSize(),
          color = MaterialTheme.colorScheme.background
        ) {
          OttomanChroniclesApp()
        }
      }
    }
  }
}

@Composable
fun OttomanChroniclesApp(
  viewModel: GameViewModel = viewModel(),
  modifier: Modifier = Modifier
) {
  val uiState by viewModel.uiState.collectAsState()

  Crossfade(
    targetState = uiState.currentPhase,
    animationSpec = tween(350),
    label = "game_phase_crossfade",
    modifier = modifier.fillMaxSize()
  ) { phase ->
    when (phase) {
      GamePhase.COVER -> {
        CoverScreen(
          onStartAdventure = { viewModel.startAdventure() },
          onShowInstructions = { viewModel.showInstructions() },
          onOpenCivilizationAnalysis = { viewModel.openCivilizationAnalysis() }
        )
      }

      GamePhase.INTRO -> {
        com.example.ui.components.IntroStoryScreen(
          onContinueStory = { viewModel.continueStory() },
          onBackToCover = { viewModel.backToCover() }
        )
      }

      GamePhase.INSTRUCTIONS -> {
        InstructionsMapScreen(
          onGoToLevelMap = { viewModel.goToLevelMap() },
          onBack = { viewModel.backToCover() }
        )
      }

      GamePhase.LEVEL_MAP -> {
        LevelMapScreen(
          levels = viewModel.levels,
          currentScore = uiState.score,
          currentStreak = uiState.streak,
          fragmentsCount = uiState.wisdomFragments.size,
          onSelectLevel = { levelId -> viewModel.startLevel(levelId) },
          onStartPlay = { viewModel.startPlaying() },
          onBack = { viewModel.showInstructions() },
          onOpenCivilizationAnalysis = { viewModel.openCivilizationAnalysis() }
        )
      }

      GamePhase.PLAYING -> {
        PlayScreen(
          question = viewModel.currentQuestion,
          questionIndex = uiState.currentQuestionIndex,
          totalQuestions = viewModel.questions.size,
          selectedOption = uiState.selectedOption,
          isSubmitted = uiState.isSubmitted,
          isCorrect = uiState.isCorrect,
          currentScore = uiState.score,
          currentStreak = uiState.streak,
          fragmentsCollectedCount = uiState.wisdomFragments.size,
          onSelectOption = { opt -> viewModel.selectOption(opt) },
          onSubmitAnswer = { viewModel.submitAnswer() },
          onNextQuestion = { viewModel.nextQuestion() },
          onOpenLevelMap = { viewModel.goToLevelMap() },
          onOpenJsonEngine = { viewModel.toggleJsonEngine(true) }
        )
      }

      GamePhase.CIVILIZATION_ANALYSIS -> {
        CivilizationAnalysisScreen(
          pillars = viewModel.pillars,
          selectedPillarId = uiState.selectedPillarId,
          onSelectPillar = { pillarId -> viewModel.selectPillar(pillarId) },
          onBack = {
            if (uiState.currentQuestionIndex > 0) {
              viewModel.startPlaying()
            } else {
              viewModel.backToCover()
            }
          }
        )
      }

      GamePhase.ENDING -> {
        EndingRecapScreen(
          finalScore = uiState.score,
          maxStreak = uiState.maxStreak,
          userAnswers = uiState.userAnswers,
          questions = viewModel.questions,
          earnedBadge = viewModel.getEarnedBadge(),
          wisdomFragments = uiState.wisdomFragments,
          expandedReviewId = uiState.reviewExpandedQuestionId,
          onToggleReviewAccordion = { id -> viewModel.toggleReviewAccordion(id) },
          onRestartGame = { viewModel.restartGame() },
          onOpenCivilizationAnalysis = { viewModel.openCivilizationAnalysis() },
          onOpenJsonEngine = { viewModel.toggleJsonEngine(true) }
        )
      }
    }
  }

  // Live Game Master Logic Engine Inspector Modal
  if (uiState.isJsonEngineOpen) {
    JsonEngineDialog(
      jsonContent = viewModel.getEngineJsonString(),
      onDismiss = { viewModel.toggleJsonEngine(false) }
    )
  }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
  Text(text = "Ottoman Chronicles: $name", modifier = modifier)
}

@Preview(showBackground = true)
@Composable
fun OttomanAppPreview() {
  MyApplicationTheme {
    OttomanChroniclesApp()
  }
}
