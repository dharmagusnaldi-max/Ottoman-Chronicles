package com.example.model

enum class GamePhase {
  COVER,
  INTRO,
  INSTRUCTIONS,
  LEVEL_MAP,
  PLAYING,
  CIVILIZATION_ANALYSIS,
  ENDING
}

data class QuizOption(
  val id: Char,
  val text: String
)

data class Question(
  val id: Int,
  val levelId: Int,
  val levelName: String,
  val levelSubtitle: String,
  val locationEra: String,
  val narrative: String,
  val questionText: String,
  val options: List<QuizOption>,
  val correctOption: Char,
  val explanation: String,
  val historicalInsight: String,
  val wisdomFragmentTitle: String,
  val analysisPillar: String? = null,
  val imageResId: Int? = null
)

data class LevelProgress(
  val levelId: Int,
  val title: String,
  val subtitle: String,
  val questionRange: String,
  val totalQuestions: Int,
  val iconName: String,
  val isUnlocked: Boolean = false,
  val isCompleted: Boolean = false,
  val scoreEarned: Int = 0
)

data class BadgeReward(
  val id: String,
  val title: String,
  val subtitle: String,
  val description: String,
  val iconSymbol: String,
  val minScore: Int,
  val unlocked: Boolean = false
)

data class CivilizationPillar(
  val id: String,
  val title: String,
  val questionPrompt: String,
  val historicalAnalysis: String,
  val studentRelevance: String,
  val keyTakeaway: String
)

data class GameEngineOutput(
  val turnNumber: Int,
  val headerLocation: String,
  val visualNarrative: String,
  val question: String,
  val options: Map<String, String>,
  val userAnswer: String?,
  val isCorrect: Boolean?,
  val educationalFeedback: String,
  val currentScore: Int,
  val currentStreak: Int,
  val wisdomFragmentsCount: Int,
  val activePhase: String
)
