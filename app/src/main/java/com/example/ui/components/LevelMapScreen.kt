package com.example.ui.components

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
import androidx.compose.material.icons.filled.AutoAwesome
import androidx.compose.material.icons.filled.Castle
import androidx.compose.material.icons.filled.EmojiEvents
import androidx.compose.material.icons.filled.Flag
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material.icons.filled.School
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.filled.WbSunny
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
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
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.model.LevelProgress
import com.example.ui.theme.OttomanEmerald
import com.example.ui.theme.OttomanGold
import com.example.ui.theme.OttomanGoldDark
import com.example.ui.theme.OttomanGoldLight
import com.example.ui.theme.OttomanNavy
import com.example.ui.theme.OttomanNavyBorder
import com.example.ui.theme.OttomanNavyCard
import com.example.ui.theme.OttomanNavyDark
import com.example.ui.theme.OttomanRuby
import com.example.ui.theme.ParchmentMuted
import com.example.ui.theme.ParchmentText

@Composable
fun LevelMapScreen(
  levels: List<LevelProgress>,
  currentScore: Int,
  currentStreak: Int,
  fragmentsCount: Int,
  onSelectLevel: (Int) -> Unit,
  onStartPlay: () -> Unit,
  onBack: () -> Unit,
  onOpenCivilizationAnalysis: () -> Unit,
  modifier: Modifier = Modifier
) {
  Box(
    modifier = modifier
      .fillMaxSize()
      .background(
        Brush.verticalGradient(
          colors = listOf(
            OttomanNavyDark,
            OttomanNavy,
            Color(0xFF090D1C)
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
        .padding(horizontal = 20.dp, vertical = 16.dp),
      verticalArrangement = Arrangement.SpaceBetween
    ) {

      // Top Bar & Score Stat
      Column {
        Row(
          modifier = Modifier.fillMaxWidth(),
          horizontalArrangement = Arrangement.SpaceBetween,
          verticalAlignment = Alignment.CenterVertically
        ) {
          Surface(
            shape = RoundedCornerShape(50),
            color = OttomanNavyCard,
            border = androidx.compose.foundation.BorderStroke(1.dp, OttomanGoldDark)
          ) {
            Row(
              modifier = Modifier.padding(horizontal = 12.dp, vertical = 6.dp),
              verticalAlignment = Alignment.CenterVertically,
              horizontalArrangement = Arrangement.spacedBy(6.dp)
            ) {
              Icon(
                imageVector = Icons.Default.Flag,
                contentDescription = null,
                tint = OttomanGold,
                modifier = Modifier.size(16.dp)
              )
              Text(
                text = "PETA PERJALANAN LEVEL",
                style = MaterialTheme.typography.labelSmall,
                color = OttomanGoldLight,
                fontWeight = FontWeight.Bold
              )
            }
          }

          // Stats Pill
          Row(horizontalArrangement = Arrangement.spacedBy(6.dp)) {
            Surface(
              shape = RoundedCornerShape(50),
              color = OttomanNavyCard,
              border = androidx.compose.foundation.BorderStroke(1.dp, OttomanNavyBorder)
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
          }
        }

        Spacer(modifier = Modifier.height(14.dp))

        Text(
          text = "Jalur Penaklukan 1299 - Abad 21",
          style = MaterialTheme.typography.headlineSmall.copy(
            fontFamily = FontFamily.Serif,
            fontWeight = FontWeight.Bold
          ),
          color = OttomanGold
        )
        Text(
          text = "Pilih level untuk memulai atau langsung tekan Mulai Ekspedisi.",
          style = MaterialTheme.typography.bodyMedium,
          color = ParchmentMuted
        )
      }

      Spacer(modifier = Modifier.height(16.dp))

      // Level Cards List
      Column(
        modifier = Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(12.dp)
      ) {
        levels.forEachIndexed { index, level ->
          LevelNodeCard(
            level = level,
            stepNumber = index + 1,
            isLast = index == levels.size - 1,
            onClick = { onSelectLevel(level.levelId) }
          )
        }
      }

      Spacer(modifier = Modifier.height(20.dp))

      // Action Buttons
      Column(
        modifier = Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(10.dp)
      ) {
        Button(
          onClick = onStartPlay,
          shape = RoundedCornerShape(16.dp),
          colors = ButtonDefaults.buttonColors(
            containerColor = OttomanGold,
            contentColor = OttomanNavyDark
          ),
          modifier = Modifier
            .fillMaxWidth()
            .height(52.dp)
            .testTag("start_expedition_button")
        ) {
          Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
          ) {
            Icon(
              imageVector = Icons.Default.PlayArrow,
              contentDescription = null,
              modifier = Modifier.size(24.dp)
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text(
              text = "MULAI DARI TANTANGAN 1",
              style = MaterialTheme.typography.titleMedium,
              fontWeight = FontWeight.Bold
            )
          }
        }

        Row(
          modifier = Modifier.fillMaxWidth(),
          horizontalArrangement = Arrangement.spacedBy(10.dp)
        ) {
          OutlinedButton(
            onClick = onOpenCivilizationAnalysis,
            shape = RoundedCornerShape(16.dp),
            border = androidx.compose.foundation.BorderStroke(1.dp, OttomanEmerald.copy(alpha = 0.7f)),
            colors = ButtonDefaults.outlinedButtonColors(
              contentColor = OttomanEmerald
            ),
            modifier = Modifier
              .weight(1f)
              .height(48.dp)
          ) {
            Icon(
              imageVector = Icons.Default.School,
              contentDescription = null,
              modifier = Modifier.size(16.dp)
            )
            Spacer(modifier = Modifier.width(6.dp))
            Text(
              text = "4 Pilar Analisis",
              style = MaterialTheme.typography.bodySmall,
              fontWeight = FontWeight.SemiBold
            )
          }

          OutlinedButton(
            onClick = onBack,
            shape = RoundedCornerShape(16.dp),
            border = androidx.compose.foundation.BorderStroke(1.dp, OttomanNavyBorder),
            colors = ButtonDefaults.outlinedButtonColors(
              contentColor = ParchmentMuted
            ),
            modifier = Modifier
              .weight(1f)
              .height(48.dp)
          ) {
            Icon(
              imageVector = Icons.AutoMirrored.Filled.ArrowBack,
              contentDescription = null,
              modifier = Modifier.size(16.dp)
            )
            Spacer(modifier = Modifier.width(6.dp))
            Text(
              text = "Kembali",
              style = MaterialTheme.typography.bodySmall
            )
          }
        }
      }
    }
  }
}

@Composable
private fun LevelNodeCard(
  level: LevelProgress,
  stepNumber: Int,
  isLast: Boolean,
  onClick: () -> Unit
) {
  val iconVector: ImageVector = when (level.levelId) {
    1 -> Icons.Default.WbSunny
    2 -> Icons.Default.Castle
    3 -> Icons.Default.EmojiEvents
    4 -> Icons.Default.School
    else -> Icons.Default.AutoAwesome
  }

  val accentColor = when (level.levelId) {
    1 -> OttomanEmerald
    2 -> OttomanGold
    3 -> Color(0xFF60A5FA)
    4 -> Color(0xFFA78BFA)
    else -> OttomanRuby
  }

  Card(
    shape = RoundedCornerShape(16.dp),
    colors = CardDefaults.cardColors(containerColor = OttomanNavyCard),
    border = androidx.compose.foundation.BorderStroke(1.2.dp, if (isLast) OttomanGold else OttomanNavyBorder),
    modifier = Modifier
      .fillMaxWidth()
      .clickable(onClick = onClick)
      .testTag("level_card_${level.levelId}")
  ) {
    Row(
      modifier = Modifier
        .fillMaxWidth()
        .padding(14.dp),
      verticalAlignment = Alignment.CenterVertically,
      horizontalArrangement = Arrangement.spacedBy(14.dp)
    ) {
      Box(
        modifier = Modifier
          .size(46.dp)
          .clip(CircleShape)
          .background(accentColor.copy(alpha = 0.2f))
          .border(1.5.dp, accentColor, CircleShape),
        contentAlignment = Alignment.Center
      ) {
        Icon(
          imageVector = iconVector,
          contentDescription = null,
          tint = accentColor,
          modifier = Modifier.size(24.dp)
        )
      }

      Column(modifier = Modifier.weight(1f)) {
        Row(
          verticalAlignment = Alignment.CenterVertically,
          horizontalArrangement = Arrangement.spacedBy(6.dp)
        ) {
          Text(
            text = level.title,
            style = MaterialTheme.typography.titleSmall,
            color = if (isLast) OttomanGold else ParchmentText,
            fontWeight = FontWeight.Bold
          )
        }
        Text(
          text = level.subtitle,
          style = MaterialTheme.typography.bodySmall,
          color = ParchmentMuted,
          fontSize = 11.5.sp
        )
        Spacer(modifier = Modifier.height(2.dp))
        Text(
          text = "${level.questionRange} • ${level.totalQuestions} Soal",
          style = MaterialTheme.typography.labelSmall,
          color = accentColor,
          fontWeight = FontWeight.SemiBold
        )
      }

      Icon(
        imageVector = Icons.Default.PlayArrow,
        contentDescription = null,
        tint = OttomanGoldLight,
        modifier = Modifier.size(20.dp)
      )
    }
  }
}
