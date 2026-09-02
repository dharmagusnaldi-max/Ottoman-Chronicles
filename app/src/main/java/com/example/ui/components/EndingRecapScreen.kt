package com.example.ui.components

import androidx.compose.animation.AnimatedVisibility
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
import androidx.compose.material.icons.filled.AutoAwesome
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Code
import androidx.compose.material.icons.filled.EmojiEvents
import androidx.compose.material.icons.filled.ExpandLess
import androidx.compose.material.icons.filled.ExpandMore
import androidx.compose.material.icons.filled.Lightbulb
import androidx.compose.material.icons.filled.Replay
import androidx.compose.material.icons.filled.School
import androidx.compose.material.icons.filled.Star
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
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.R
import com.example.model.BadgeReward
import com.example.model.Question
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
fun EndingRecapScreen(
  finalScore: Int,
  maxStreak: Int,
  userAnswers: Map<Int, Char>,
  questions: List<Question>,
  earnedBadge: BadgeReward,
  wisdomFragments: List<String>,
  expandedReviewId: Int?,
  onToggleReviewAccordion: (Int) -> Unit,
  onRestartGame: () -> Unit,
  onOpenCivilizationAnalysis: () -> Unit,
  onOpenJsonEngine: () -> Unit,
  modifier: Modifier = Modifier
) {
  val correctCount = questions.count { q -> userAnswers[q.id] == q.correctOption }
  val accuracy = if (questions.isNotEmpty()) (correctCount * 100) / questions.size else 0

  Box(
    modifier = modifier
      .fillMaxSize()
      .background(
        Brush.verticalGradient(
          colors = listOf(
            OttomanNavyDark,
            OttomanNavy,
            Color(0xFF060A14)
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

      // TOP HEADER
      Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
      ) {
        Surface(
          shape = RoundedCornerShape(50),
          color = OttomanNavyCard,
          border = androidx.compose.foundation.BorderStroke(1.dp, OttomanGold)
        ) {
          Row(
            modifier = Modifier.padding(horizontal = 14.dp, vertical = 6.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(6.dp)
          ) {
            Icon(
              imageVector = Icons.Default.AutoAwesome,
              contentDescription = null,
              tint = OttomanGold,
              modifier = Modifier.size(16.dp)
            )
            Text(
              text = "FASE 5: REKAP SKOR, LEGACY & BADGE",
              style = MaterialTheme.typography.labelSmall,
              color = OttomanGoldLight,
              fontWeight = FontWeight.Bold
            )
          }
        }

        Spacer(modifier = Modifier.height(12.dp))

        Text(
          text = "PENAKLUKAN KEBIJAKSANAAN",
          style = MaterialTheme.typography.headlineSmall.copy(
            fontFamily = FontFamily.Serif,
            fontWeight = FontWeight.ExtraBold,
            letterSpacing = 1.sp
          ),
          color = OttomanGold,
          textAlign = TextAlign.Center
        )
        Text(
          text = "Ekspedisi 15 Tantangan Sejarah Daulah Utsmaniyah Telah Tuntas!",
          style = MaterialTheme.typography.bodySmall,
          color = ParchmentMuted,
          textAlign = TextAlign.Center
        )
      }

      Spacer(modifier = Modifier.height(16.dp))

      // 1. BADGE & SCORE CARD
      Card(
        shape = RoundedCornerShape(24.dp),
        colors = CardDefaults.cardColors(containerColor = OttomanNavyCard),
        border = androidx.compose.foundation.BorderStroke(1.5.dp, OttomanGold),
        elevation = CardDefaults.cardElevation(defaultElevation = 8.dp),
        modifier = Modifier
          .fillMaxWidth()
          .shadow(12.dp, RoundedCornerShape(24.dp), ambientColor = OttomanGold)
      ) {
        Column(
          modifier = Modifier
            .fillMaxWidth()
            .padding(18.dp),
          horizontalAlignment = Alignment.CenterHorizontally
        ) {
          Box(
            modifier = Modifier
              .size(72.dp)
              .clip(CircleShape)
              .background(
                Brush.radialGradient(
                  listOf(OttomanGold.copy(alpha = 0.3f), Color.Transparent)
                )
              )
              .border(2.dp, OttomanGold, CircleShape),
            contentAlignment = Alignment.Center
          ) {
            Text(text = earnedBadge.iconSymbol, fontSize = 34.sp)
          }

          Spacer(modifier = Modifier.height(10.dp))

          Text(
            text = earnedBadge.title,
            style = MaterialTheme.typography.titleLarge.copy(
              fontFamily = FontFamily.Serif,
              fontWeight = FontWeight.Bold
            ),
            color = OttomanGold,
            textAlign = TextAlign.Center
          )

          Text(
            text = earnedBadge.subtitle,
            style = MaterialTheme.typography.labelMedium,
            color = OttomanGoldLight,
            textAlign = TextAlign.Center
          )

          Spacer(modifier = Modifier.height(6.dp))

          Text(
            text = earnedBadge.description,
            style = MaterialTheme.typography.bodySmall,
            color = ParchmentMuted,
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(horizontal = 8.dp)
          )

          Spacer(modifier = Modifier.height(16.dp))

          // Key Stats Grid
          Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
          ) {
            ScoreStatItem("SKOR TOTAL", "$finalScore", OttomanGold)
            ScoreStatItem("AKURASI", "$accuracy%", OttomanEmerald)
            ScoreStatItem("KOMBO MAKS", "${maxStreak}x", Color(0xFFFF8A9E))
            ScoreStatItem("FRAGMEN", "${wisdomFragments.size}/15", Color(0xFF60A5FA))
          }
        }
      }

      Spacer(modifier = Modifier.height(14.dp))

      // 2. RINGKASAN REFLEKTIF: NILAI KETELADANAN UNTUK SISWA MASA KINI
      Card(
        shape = RoundedCornerShape(20.dp),
        colors = CardDefaults.cardColors(containerColor = OttomanNavyDark),
        border = androidx.compose.foundation.BorderStroke(1.2.dp, OttomanGoldDark.copy(alpha = 0.7f)),
        modifier = Modifier.fillMaxWidth()
      ) {
        Column(modifier = Modifier.padding(16.dp)) {
          Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(8.dp)
          ) {
            Icon(
              imageVector = Icons.Default.School,
              contentDescription = null,
              tint = OttomanGold,
              modifier = Modifier.size(22.dp)
            )
            Text(
              text = "Refleksi Keteladanan untuk Pelajar Abad 21",
              style = MaterialTheme.typography.titleMedium,
              color = OttomanGold,
              fontWeight = FontWeight.Bold
            )
          }

          Spacer(modifier = Modifier.height(10.dp))

          ReflectivePoint(
            number = "1",
            title = "Literasi Multidisiplin (Mehmed II)",
            content = "Mencontoh Sultan Mehmed II yang menguasai 7 bahasa dan sains untuk memimpin perubahan zaman secara cerdas dan berwawasan luas."
          )
          ReflectivePoint(
            number = "2",
            title = "Supremasi Hukum & Keadilan (Suleiman I)",
            content = "Menjunjung tinggi kejujuran akademik, anti-korupsi, dan aturan yang adil untuk seluruh lapisan masyarakat."
          )
          ReflectivePoint(
            number = "3",
            title = "Karya Bernilai Kemanusiaan (Mimar Sinan)",
            content = "Menciptakan karya teknik dan sains yang bermanfaat abadi bagi masyarakat dengan mengedepankan etika dan estetika."
          )
          ReflectivePoint(
            number = "4",
            title = "Jiwa Filantropi & Empati Sosial (Sistem Wakaf)",
            content = "Menumbuhkan empati aktif untuk membantu sesama, merawat fasilitas umum, dan menjaga harmoni dalam keragaman."
          )
        }
      }

      Spacer(modifier = Modifier.height(14.dp))

      // 3. DAFTAR REVIEW SOAL & PEMBAHASAN
      Card(
        shape = RoundedCornerShape(18.dp),
        colors = CardDefaults.cardColors(containerColor = OttomanNavyCard),
        border = androidx.compose.foundation.BorderStroke(1.dp, OttomanNavyBorder),
        modifier = Modifier.fillMaxWidth()
      ) {
        Column(modifier = Modifier.padding(16.dp)) {
          Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
          ) {
            Text(
              text = "Review 15 Tantangan & Pembahasan",
              style = MaterialTheme.typography.titleMedium,
              color = ParchmentText,
              fontWeight = FontWeight.Bold
            )
            Text(
              text = "$correctCount/$totalQuestions Benar",
              style = MaterialTheme.typography.labelSmall,
              color = OttomanGoldLight
            )
          }

          Spacer(modifier = Modifier.height(10.dp))

          questions.forEach { q ->
            val isUserCorrect = userAnswers[q.id] == q.correctOption
            val isExpanded = expandedReviewId == q.id

            ReviewQuestionRow(
              question = q,
              userChoice = userAnswers[q.id],
              isCorrect = isUserCorrect,
              isExpanded = isExpanded,
              onToggle = { onToggleReviewAccordion(q.id) }
            )
          }
        }
      }

      Spacer(modifier = Modifier.height(20.dp))

      // 4. ACTION BUTTONS
      Column(
        modifier = Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(10.dp)
      ) {
        Button(
          onClick = onRestartGame,
          shape = RoundedCornerShape(16.dp),
          colors = ButtonDefaults.buttonColors(
            containerColor = OttomanGold,
            contentColor = OttomanNavyDark
          ),
          modifier = Modifier
            .fillMaxWidth()
            .height(52.dp)
            .testTag("play_again_button")
        ) {
          Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
          ) {
            Icon(
              imageVector = Icons.Default.Replay,
              contentDescription = null,
              modifier = Modifier.size(20.dp)
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text(
              text = "MAIN LAGI",
              style = MaterialTheme.typography.titleMedium,
              fontWeight = FontWeight.Bold
            )
          }
        }

        OutlinedButton(
          onClick = onOpenCivilizationAnalysis,
          shape = RoundedCornerShape(16.dp),
          border = androidx.compose.foundation.BorderStroke(1.2.dp, OttomanEmerald),
          colors = ButtonDefaults.outlinedButtonColors(
            contentColor = OttomanEmerald
          ),
          modifier = Modifier
            .fillMaxWidth()
            .height(48.dp)
            .testTag("ending_open_analysis_button")
        ) {
          Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
          ) {
            Icon(
              imageVector = Icons.Default.School,
              contentDescription = null,
              modifier = Modifier.size(18.dp)
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text(
              text = "Eksplorasi Mendalam 4 Pilar Analisis Peradaban",
              style = MaterialTheme.typography.bodyMedium,
              fontWeight = FontWeight.SemiBold
            )
          }
        }

        OutlinedButton(
          onClick = onOpenJsonEngine,
          shape = RoundedCornerShape(16.dp),
          border = androidx.compose.foundation.BorderStroke(1.dp, Color(0xFF38BDF8).copy(alpha = 0.8f)),
          colors = ButtonDefaults.outlinedButtonColors(
            contentColor = Color(0xFF38BDF8)
          ),
          modifier = Modifier
            .fillMaxWidth()
            .height(44.dp)
            .testTag("ending_open_json_engine_button")
        ) {
          Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
          ) {
            Icon(
              imageVector = Icons.Default.Code,
              contentDescription = null,
              modifier = Modifier.size(16.dp)
            )
            Spacer(modifier = Modifier.width(6.dp))
            Text(
              text = "Inspeksi State JSON Game Master Logic Engine",
              style = MaterialTheme.typography.bodySmall
            )
          }
        }
      }
    }
  }
}

@Composable
private fun ScoreStatItem(label: String, value: String, valueColor: Color) {
  Column(
    horizontalAlignment = Alignment.CenterHorizontally,
    modifier = Modifier
      .background(OttomanNavyDark.copy(alpha = 0.8f), RoundedCornerShape(12.dp))
      .padding(horizontal = 10.dp, vertical = 8.dp)
  ) {
    Text(
      text = value,
      style = MaterialTheme.typography.titleMedium,
      color = valueColor,
      fontWeight = FontWeight.Bold
    )
    Text(
      text = label,
      style = MaterialTheme.typography.labelSmall,
      color = ParchmentMuted,
      fontSize = 9.sp
    )
  }
}

@Composable
private fun ReflectivePoint(number: String, title: String, content: String) {
  Row(
    modifier = Modifier
      .fillMaxWidth()
      .padding(vertical = 4.dp),
    horizontalArrangement = Arrangement.spacedBy(10.dp)
  ) {
    Box(
      modifier = Modifier
        .size(24.dp)
        .clip(CircleShape)
        .background(OttomanGold.copy(alpha = 0.2f))
        .border(1.dp, OttomanGold, CircleShape),
      contentAlignment = Alignment.Center
    ) {
      Text(
        text = number,
        style = MaterialTheme.typography.labelSmall,
        color = OttomanGold,
        fontWeight = FontWeight.Bold
      )
    }

    Column(modifier = Modifier.weight(1f)) {
      Text(
        text = title,
        style = MaterialTheme.typography.labelMedium,
        color = OttomanGoldLight,
        fontWeight = FontWeight.Bold
      )
      Text(
        text = content,
        style = MaterialTheme.typography.bodySmall,
        color = ParchmentText,
        fontSize = 12.sp,
        lineHeight = 17.sp
      )
    }
  }
}

@Composable
private fun ReviewQuestionRow(
  question: Question,
  userChoice: Char?,
  isCorrect: Boolean,
  isExpanded: Boolean,
  onToggle: () -> Unit
) {
  Column(
    modifier = Modifier
      .fillMaxWidth()
      .padding(vertical = 4.dp)
      .clip(RoundedCornerShape(10.dp))
      .background(OttomanNavyDark.copy(alpha = 0.7f))
      .border(1.dp, if (isCorrect) OttomanEmerald.copy(alpha = 0.4f) else OttomanRuby.copy(alpha = 0.4f), RoundedCornerShape(10.dp))
      .clickable(onClick = onToggle)
      .padding(10.dp)
  ) {
    Row(
      modifier = Modifier.fillMaxWidth(),
      verticalAlignment = Alignment.CenterVertically,
      horizontalArrangement = Arrangement.SpaceBetween
    ) {
      Row(
        modifier = Modifier.weight(1f),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(8.dp)
      ) {
        Icon(
          imageVector = if (isCorrect) Icons.Default.CheckCircle else Icons.Default.Close,
          contentDescription = null,
          tint = if (isCorrect) OttomanEmerald else OttomanRuby,
          modifier = Modifier.size(18.dp)
        )
        Text(
          text = "Soal ${question.id}: ${question.levelSubtitle}",
          style = MaterialTheme.typography.bodySmall,
          color = ParchmentText,
          fontWeight = FontWeight.SemiBold
        )
      }

      Icon(
        imageVector = if (isExpanded) Icons.Default.ExpandLess else Icons.Default.ExpandMore,
        contentDescription = null,
        tint = ParchmentMuted,
        modifier = Modifier.size(18.dp)
      )
    }

    AnimatedVisibility(visible = isExpanded) {
      Column(
        modifier = Modifier
          .fillMaxWidth()
          .padding(top = 8.dp)
      ) {
        Text(
          text = question.questionText,
          style = MaterialTheme.typography.bodySmall,
          color = ParchmentMuted,
          fontSize = 12.sp
        )
        Spacer(modifier = Modifier.height(4.dp))
        Text(
          text = "Pilihanmu: [${userChoice ?: '-'}] • Kunci Jawaban: [${question.correctOption}]",
          style = MaterialTheme.typography.labelSmall,
          color = if (isCorrect) OttomanEmerald else Color(0xFFFF8A9E),
          fontWeight = FontWeight.Bold
        )
        Spacer(modifier = Modifier.height(4.dp))
        Text(
          text = question.explanation,
          style = MaterialTheme.typography.bodySmall,
          color = ParchmentText,
          fontSize = 11.5.sp,
          lineHeight = 16.sp
        )
      }
    }
  }
}

private const val totalQuestions = 15
