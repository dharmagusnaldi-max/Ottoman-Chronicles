package com.example.ui.components

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.slideInVertically
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.automirrored.filled.ArrowForward
import androidx.compose.material.icons.filled.AutoAwesome
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Code
import androidx.compose.material.icons.filled.Lightbulb
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Map
import androidx.compose.material.icons.filled.Send
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.model.Question
import com.example.model.QuizOption
import com.example.ui.theme.OttomanEmerald
import com.example.ui.theme.OttomanEmeraldDark
import com.example.ui.theme.OttomanGold
import com.example.ui.theme.OttomanGoldContainer
import com.example.ui.theme.OttomanGoldDark
import com.example.ui.theme.OttomanGoldLight
import com.example.ui.theme.OttomanNavy
import com.example.ui.theme.OttomanNavyBorder
import com.example.ui.theme.OttomanNavyCard
import com.example.ui.theme.OttomanNavyDark
import com.example.ui.theme.OttomanRuby
import com.example.ui.theme.OttomanRubyDark
import com.example.ui.theme.ParchmentMuted
import com.example.ui.theme.ParchmentText

@Composable
fun PlayScreen(
  question: Question,
  questionIndex: Int,
  totalQuestions: Int,
  selectedOption: Char?,
  isSubmitted: Boolean,
  isCorrect: Boolean?,
  currentScore: Int,
  currentStreak: Int,
  fragmentsCollectedCount: Int,
  onSelectOption: (Char) -> Unit,
  onSubmitAnswer: () -> Unit,
  onNextQuestion: () -> Unit,
  onOpenLevelMap: () -> Unit,
  onOpenJsonEngine: () -> Unit,
  modifier: Modifier = Modifier
) {
  val progress = (questionIndex + 1).toFloat() / totalQuestions.toFloat()

  Box(
    modifier = modifier
      .fillMaxSize()
      .background(
        Brush.verticalGradient(
          colors = listOf(
            OttomanNavyDark,
            OttomanNavy,
            Color(0xFF090E1E)
          )
        )
      )
  ) {
    Column(
      modifier = Modifier
        .fillMaxSize()
        .statusBarsPadding()
        .navigationBarsPadding()
        .verticalScroll(rememberScrollState())
        .padding(horizontal = 18.dp, vertical = 14.dp),
      verticalArrangement = Arrangement.SpaceBetween
    ) {

      // TOP BAR: Progress, Level Header & Stats
      Column(modifier = Modifier.fillMaxWidth()) {
        Row(
          modifier = Modifier.fillMaxWidth(),
          horizontalArrangement = Arrangement.SpaceBetween,
          verticalAlignment = Alignment.CenterVertically
        ) {
          OutlinedButton(
            onClick = onOpenLevelMap,
            shape = RoundedCornerShape(12.dp),
            border = androidx.compose.foundation.BorderStroke(1.dp, OttomanNavyBorder),
            colors = ButtonDefaults.outlinedButtonColors(contentColor = ParchmentMuted),
            modifier = Modifier
              .height(38.dp)
              .testTag("play_back_to_map_button")
          ) {
            Icon(
              imageVector = Icons.Default.Map,
              contentDescription = null,
              tint = OttomanGold,
              modifier = Modifier.size(16.dp)
            )
            Spacer(modifier = Modifier.width(6.dp))
            Text("Peta", style = MaterialTheme.typography.labelSmall)
          }

          // Gamification Chips
          Row(
            horizontalArrangement = Arrangement.spacedBy(6.dp),
            verticalAlignment = Alignment.CenterVertically
          ) {
            if (currentStreak >= 2) {
              Surface(
                shape = RoundedCornerShape(50),
                color = OttomanRuby.copy(alpha = 0.25f),
                border = androidx.compose.foundation.BorderStroke(1.dp, OttomanRuby)
              ) {
                Text(
                  text = "🔥 ${currentStreak}x Kombo",
                  style = MaterialTheme.typography.labelSmall,
                  color = Color(0xFFFF8A9E),
                  fontWeight = FontWeight.Bold,
                  modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp)
                )
              }
            }

            Surface(
              shape = RoundedCornerShape(50),
              color = OttomanNavyCard,
              border = androidx.compose.foundation.BorderStroke(1.dp, OttomanGoldDark)
            ) {
              Row(
                modifier = Modifier.padding(horizontal = 10.dp, vertical = 4.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(4.dp)
              ) {
                Icon(
                  imageVector = Icons.Default.Star,
                  contentDescription = null,
                  tint = OttomanGold,
                  modifier = Modifier.size(14.dp)
                )
                Text(
                  text = "$currentScore Pts",
                  style = MaterialTheme.typography.labelMedium,
                  color = OttomanGoldLight,
                  fontWeight = FontWeight.Bold
                )
              }
            }

            // Engine Inspector Trigger
            Surface(
              shape = RoundedCornerShape(50),
              color = OttomanNavyCard,
              border = androidx.compose.foundation.BorderStroke(1.dp, Color(0xFF38BDF8).copy(alpha = 0.7f)),
              modifier = Modifier.clickable(onClick = onOpenJsonEngine)
            ) {
              Row(
                modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(4.dp)
              ) {
                Icon(
                  imageVector = Icons.Default.Code,
                  contentDescription = "Inspect JSON Engine",
                  tint = Color(0xFF38BDF8),
                  modifier = Modifier.size(14.dp)
                )
                Text(
                  text = "JSON",
                  style = MaterialTheme.typography.labelSmall,
                  color = Color(0xFF38BDF8),
                  fontWeight = FontWeight.Bold
                )
              }
            }
          }
        }

        Spacer(modifier = Modifier.height(10.dp))

        // Progress Bar
        Column {
          Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
          ) {
            Text(
              text = "Tantangan ${questionIndex + 1} dari $totalQuestions",
              style = MaterialTheme.typography.labelSmall,
              color = OttomanGoldLight,
              fontWeight = FontWeight.SemiBold
            )
            Text(
              text = "${(progress * 100).toInt()}% Selesai",
              style = MaterialTheme.typography.labelSmall,
              color = ParchmentMuted
            )
          }
          Spacer(modifier = Modifier.height(4.dp))
          LinearProgressIndicator(
            progress = { progress },
            modifier = Modifier
              .fillMaxWidth()
              .height(6.dp)
              .clip(RoundedCornerShape(3.dp)),
            color = OttomanGold,
            trackColor = OttomanNavyBorder,
            strokeCap = StrokeCap.Round
          )
        }
      }

      Spacer(modifier = Modifier.height(14.dp))

      // 1. HEADER & LOCATION / ERA
      Card(
        shape = RoundedCornerShape(14.dp),
        colors = CardDefaults.cardColors(containerColor = OttomanNavyCard),
        border = androidx.compose.foundation.BorderStroke(1.dp, OttomanNavyBorder),
        modifier = Modifier.fillMaxWidth()
      ) {
        Row(
          modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 12.dp, vertical = 8.dp),
          verticalAlignment = Alignment.CenterVertically,
          horizontalArrangement = Arrangement.SpaceBetween
        ) {
          Column {
            Text(
              text = question.levelName.uppercase(),
              style = MaterialTheme.typography.labelSmall,
              color = OttomanGold,
              fontWeight = FontWeight.Bold,
              letterSpacing = 0.5.sp
            )
            Row(
              verticalAlignment = Alignment.CenterVertically,
              horizontalArrangement = Arrangement.spacedBy(4.dp)
            ) {
              Icon(
                imageVector = Icons.Default.LocationOn,
                contentDescription = null,
                tint = ParchmentMuted,
                modifier = Modifier.size(13.dp)
              )
              Text(
                text = question.locationEra,
                style = MaterialTheme.typography.bodySmall,
                color = ParchmentMuted,
                fontSize = 11.5.sp
              )
            }
          }

          if (question.analysisPillar != null) {
            Surface(
              shape = RoundedCornerShape(6.dp),
              color = Color(0xFFA78BFA).copy(alpha = 0.2f),
              border = androidx.compose.foundation.BorderStroke(1.dp, Color(0xFFA78BFA))
            ) {
              Text(
                text = "Pilar Analisis",
                style = MaterialTheme.typography.labelSmall,
                color = Color(0xFFA78BFA),
                fontSize = 10.sp,
                modifier = Modifier.padding(horizontal = 6.dp, vertical = 2.dp)
              )
            }
          }
        }
      }

      Spacer(modifier = Modifier.height(12.dp))

      // 2. VISUAL & NARRATIVE CARD
      Card(
        shape = RoundedCornerShape(18.dp),
        colors = CardDefaults.cardColors(containerColor = OttomanNavyDark.copy(alpha = 0.9f)),
        border = androidx.compose.foundation.BorderStroke(1.2.dp, OttomanGoldDark.copy(alpha = 0.6f)),
        modifier = Modifier.fillMaxWidth()
      ) {
        Column(modifier = Modifier.fillMaxWidth()) {
          if (question.imageResId != null) {
            Box(
              modifier = Modifier
                .fillMaxWidth()
                .height(120.dp)
            ) {
              Image(
                painter = painterResource(id = question.imageResId),
                contentDescription = "Ilustrasi Sejarah",
                contentScale = ContentScale.Crop,
                modifier = Modifier.fillMaxSize()
              )
              Box(
                modifier = Modifier
                  .fillMaxSize()
                  .background(
                    Brush.verticalGradient(
                      colors = listOf(Color.Transparent, OttomanNavyDark.copy(alpha = 0.95f))
                    )
                  )
              )
            }
          }

          Column(modifier = Modifier.padding(14.dp)) {
            Text(
              text = "📜 ALUR NARASI SINEMATIK:",
              style = MaterialTheme.typography.labelSmall,
              color = OttomanGoldLight,
              fontWeight = FontWeight.Bold,
              letterSpacing = 1.sp
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
              text = question.narrative,
              style = MaterialTheme.typography.bodyMedium.copy(
                fontSize = 13.5.sp,
                lineHeight = 20.sp,
                fontStyle = androidx.compose.ui.text.font.FontStyle.Italic
              ),
              color = ParchmentText
            )
          }
        }
      }

      Spacer(modifier = Modifier.height(12.dp))

      // 3. PERTANYAAN TANTANGAN
      Card(
        shape = RoundedCornerShape(18.dp),
        colors = CardDefaults.cardColors(containerColor = OttomanNavyCard),
        border = androidx.compose.foundation.BorderStroke(1.dp, OttomanNavyBorder),
        modifier = Modifier.fillMaxWidth()
      ) {
        Column(modifier = Modifier.padding(16.dp)) {
          Text(
            text = "TANTANGAN SEJARAH:",
            style = MaterialTheme.typography.labelSmall,
            color = OttomanGold,
            fontWeight = FontWeight.Bold
          )
          Spacer(modifier = Modifier.height(6.dp))
          Text(
            text = question.questionText,
            style = MaterialTheme.typography.titleMedium.copy(
              fontSize = 15.sp,
              lineHeight = 22.sp,
              fontWeight = FontWeight.Bold
            ),
            color = ParchmentText
          )
        }
      }

      Spacer(modifier = Modifier.height(12.dp))

      // 4. OPSI JAWABAN (A, B, C, D)
      Column(
        modifier = Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(8.dp)
      ) {
        question.options.forEach { option ->
          OptionItemView(
            option = option,
            isSelected = selectedOption == option.id,
            isSubmitted = isSubmitted,
            isCorrectAnswer = isSubmitted && option.id == question.correctOption,
            isWrongSelected = isSubmitted && selectedOption == option.id && option.id != question.correctOption,
            onClick = { onSelectOption(option.id) }
          )
        }
      }

      Spacer(modifier = Modifier.height(14.dp))

      // 5. EDUKASI FEEDBACK CARD (SETELAH SUBMIT)
      AnimatedVisibility(
        visible = isSubmitted,
        enter = fadeIn() + slideInVertically()
      ) {
        Card(
          shape = RoundedCornerShape(16.dp),
          colors = CardDefaults.cardColors(
            containerColor = if (isCorrect == true) OttomanEmeraldDark.copy(alpha = 0.35f) else OttomanRubyDark.copy(alpha = 0.35f)
          ),
          border = androidx.compose.foundation.BorderStroke(
            1.5.dp,
            if (isCorrect == true) OttomanEmerald else OttomanRuby
          ),
          modifier = Modifier.fillMaxWidth()
        ) {
          Column(modifier = Modifier.padding(14.dp)) {
            Row(
              verticalAlignment = Alignment.CenterVertically,
              horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
              Icon(
                imageVector = if (isCorrect == true) Icons.Default.CheckCircle else Icons.Default.Close,
                contentDescription = null,
                tint = if (isCorrect == true) OttomanEmerald else OttomanRuby,
                modifier = Modifier.size(22.dp)
              )
              Text(
                text = if (isCorrect == true) "JAWABAN TEPAT! (+100 Poin)" else "KURANG TEPAT! (Jawaban Benar: [${question.correctOption}])",
                style = MaterialTheme.typography.titleSmall,
                color = if (isCorrect == true) OttomanEmerald else Color(0xFFFF8A9E),
                fontWeight = FontWeight.Bold
              )
            }

            Spacer(modifier = Modifier.height(8.dp))

            Text(
              text = question.explanation,
              style = MaterialTheme.typography.bodyMedium.copy(fontSize = 13.5.sp, lineHeight = 20.sp),
              color = ParchmentText
            )

            Spacer(modifier = Modifier.height(10.dp))

            // Historical Insight Box
            Surface(
              shape = RoundedCornerShape(10.dp),
              color = OttomanNavyDark.copy(alpha = 0.7f),
              border = androidx.compose.foundation.BorderStroke(1.dp, OttomanGoldDark.copy(alpha = 0.4f)),
              modifier = Modifier.fillMaxWidth()
            ) {
              Row(
                modifier = Modifier.padding(10.dp),
                verticalAlignment = Alignment.Top,
                horizontalArrangement = Arrangement.spacedBy(8.dp)
              ) {
                Icon(
                  imageVector = Icons.Default.Lightbulb,
                  contentDescription = null,
                  tint = OttomanGold,
                  modifier = Modifier.size(16.dp)
                )
                Column {
                  Text(
                    text = "Hikmah Sejarah & Keteladanan:",
                    style = MaterialTheme.typography.labelSmall,
                    color = OttomanGoldLight,
                    fontWeight = FontWeight.Bold
                  )
                  Text(
                    text = question.historicalInsight,
                    style = MaterialTheme.typography.bodySmall,
                    color = ParchmentMuted,
                    fontSize = 12.sp
                  )
                }
              }
            }
          }
        }
      }

      Spacer(modifier = Modifier.height(16.dp))

      // NAVIGATION / SUBMIT ACTION BUTTON
      Column(
        modifier = Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(8.dp)
      ) {
        if (!isSubmitted) {
          Button(
            onClick = onSubmitAnswer,
            enabled = selectedOption != null,
            shape = RoundedCornerShape(16.dp),
            colors = ButtonDefaults.buttonColors(
              containerColor = OttomanGold,
              contentColor = OttomanNavyDark,
              disabledContainerColor = OttomanNavyCard,
              disabledContentColor = ParchmentMuted.copy(alpha = 0.5f)
            ),
            modifier = Modifier
              .fillMaxWidth()
              .height(52.dp)
              .testTag("submit_answer_button")
          ) {
            Row(
              verticalAlignment = Alignment.CenterVertically,
              horizontalArrangement = Arrangement.Center
            ) {
              Icon(
                imageVector = Icons.Default.Send,
                contentDescription = null,
                modifier = Modifier.size(18.dp)
              )
              Spacer(modifier = Modifier.width(8.dp))
              Text(
                text = "KIRIM JAWABAN",
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.Bold
              )
            }
          }
        } else {
          Button(
            onClick = onNextQuestion,
            shape = RoundedCornerShape(16.dp),
            colors = ButtonDefaults.buttonColors(
              containerColor = if (questionIndex == totalQuestions - 1) OttomanEmerald else OttomanGold,
              contentColor = OttomanNavyDark
            ),
            modifier = Modifier
              .fillMaxWidth()
              .height(52.dp)
              .testTag("next_question_button")
          ) {
            Row(
              verticalAlignment = Alignment.CenterVertically,
              horizontalArrangement = Arrangement.Center
            ) {
              Text(
                text = if (questionIndex == totalQuestions - 1) "SELESAIKAN & LIHAT REKAP SKOR" else "LANJUT KE TANTANGAN BERIKUTNYA",
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.Bold
              )
              Spacer(modifier = Modifier.width(8.dp))
              Icon(
                imageVector = Icons.AutoMirrored.Filled.ArrowForward,
                contentDescription = null,
                modifier = Modifier.size(20.dp)
              )
            }
          }
        }
      }
    }
  }
}

@Composable
private fun OptionItemView(
  option: QuizOption,
  isSelected: Boolean,
  isSubmitted: Boolean,
  isCorrectAnswer: Boolean,
  isWrongSelected: Boolean,
  onClick: () -> Unit
) {
  val backgroundColor = when {
    isCorrectAnswer -> OttomanEmeraldDark.copy(alpha = 0.4f)
    isWrongSelected -> OttomanRubyDark.copy(alpha = 0.4f)
    isSelected -> OttomanGoldContainer
    else -> OttomanNavyCard
  }

  val borderColor = when {
    isCorrectAnswer -> OttomanEmerald
    isWrongSelected -> OttomanRuby
    isSelected -> OttomanGold
    else -> OttomanNavyBorder
  }

  val pillColor = when {
    isCorrectAnswer -> OttomanEmerald
    isWrongSelected -> OttomanRuby
    isSelected -> OttomanGold
    else -> OttomanNavyBorder
  }

  val pillTextColor = when {
    isCorrectAnswer || isWrongSelected -> Color.White
    isSelected -> OttomanNavyDark
    else -> ParchmentMuted
  }

  Card(
    shape = RoundedCornerShape(14.dp),
    colors = CardDefaults.cardColors(containerColor = backgroundColor),
    border = androidx.compose.foundation.BorderStroke(1.2.dp, borderColor),
    modifier = Modifier
      .fillMaxWidth()
      .clickable(enabled = !isSubmitted, onClick = onClick)
      .testTag("option_${option.id}")
  ) {
    Row(
      modifier = Modifier
        .fillMaxWidth()
        .padding(horizontal = 12.dp, vertical = 12.dp),
      verticalAlignment = Alignment.CenterVertically,
      horizontalArrangement = Arrangement.spacedBy(12.dp)
    ) {
      Box(
        modifier = Modifier
          .size(32.dp)
          .clip(CircleShape)
          .background(pillColor),
        contentAlignment = Alignment.Center
      ) {
        Text(
          text = "${option.id}",
          style = MaterialTheme.typography.labelLarge,
          color = pillTextColor,
          fontWeight = FontWeight.Bold
        )
      }

      Text(
        text = option.text,
        style = MaterialTheme.typography.bodyMedium.copy(
          fontSize = 13.5.sp,
          lineHeight = 19.sp,
          fontWeight = if (isSelected || isCorrectAnswer) FontWeight.SemiBold else FontWeight.Normal
        ),
        color = if (isCorrectAnswer) Color.White else if (isWrongSelected) Color(0xFFFF8A9E) else ParchmentText,
        modifier = Modifier.weight(1f)
      )
    }
  }
}
