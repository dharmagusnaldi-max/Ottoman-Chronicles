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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.AutoAwesome
import androidx.compose.material.icons.filled.Lightbulb
import androidx.compose.material.icons.filled.School
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
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.model.CivilizationPillar
import com.example.ui.theme.OttomanEmerald
import com.example.ui.theme.OttomanGold
import com.example.ui.theme.OttomanGoldDark
import com.example.ui.theme.OttomanGoldLight
import com.example.ui.theme.OttomanNavy
import com.example.ui.theme.OttomanNavyBorder
import com.example.ui.theme.OttomanNavyCard
import com.example.ui.theme.OttomanNavyDark
import com.example.ui.theme.ParchmentMuted
import com.example.ui.theme.ParchmentText

@Composable
fun CivilizationAnalysisScreen(
  pillars: List<CivilizationPillar>,
  selectedPillarId: String,
  onSelectPillar: (String) -> Unit,
  onBack: () -> Unit,
  modifier: Modifier = Modifier
) {
  val activePillar = pillars.find { it.id == selectedPillarId } ?: pillars.first()

  Box(
    modifier = modifier
      .fillMaxSize()
      .background(
        Brush.verticalGradient(
          colors = listOf(
            OttomanNavyDark,
            OttomanNavy,
            Color(0xFF090D1A)
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

      // Header
      Column {
        Row(
          modifier = Modifier.fillMaxWidth(),
          horizontalArrangement = Arrangement.SpaceBetween,
          verticalAlignment = Alignment.CenterVertically
        ) {
          Surface(
            shape = RoundedCornerShape(50),
            color = OttomanNavyCard,
            border = androidx.compose.foundation.BorderStroke(1.dp, OttomanEmerald)
          ) {
            Row(
              modifier = Modifier.padding(horizontal = 12.dp, vertical = 6.dp),
              verticalAlignment = Alignment.CenterVertically,
              horizontalArrangement = Arrangement.spacedBy(6.dp)
            ) {
              Icon(
                imageVector = Icons.Default.School,
                contentDescription = null,
                tint = OttomanEmerald,
                modifier = Modifier.size(16.dp)
              )
              Text(
                text = "ANALISIS PERADABAN 4 PILAR",
                style = MaterialTheme.typography.labelSmall,
                color = OttomanGoldLight,
                fontWeight = FontWeight.Bold
              )
            }
          }
        }

        Spacer(modifier = Modifier.height(12.dp))

        Text(
          text = "Kajian Kritis Sejarah & Relevansi Pelajar",
          style = MaterialTheme.typography.headlineSmall.copy(
            fontFamily = FontFamily.Serif,
            fontWeight = FontWeight.Bold
          ),
          color = OttomanGold
        )
        Text(
          text = "Eksplorasi 4 pertanyaan esensial analisis peradaban Daulah Utsmaniyah.",
          style = MaterialTheme.typography.bodyMedium,
          color = ParchmentMuted
        )
      }

      Spacer(modifier = Modifier.height(16.dp))

      // Tab Buttons (Pilar A, B, C, D)
      Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(6.dp)
      ) {
        pillars.forEach { pillar ->
          val isSelected = pillar.id == selectedPillarId
          val label = when (pillar.id) {
            "pillar_a" -> "Pilar A"
            "pillar_b" -> "Pilar B"
            "pillar_c" -> "Pilar C"
            else -> "Pilar D"
          }

          Box(
            modifier = Modifier
              .weight(1f)
              .clip(RoundedCornerShape(12.dp))
              .background(if (isSelected) OttomanGold else OttomanNavyCard)
              .border(
                1.dp,
                if (isSelected) OttomanGoldDark else OttomanNavyBorder,
                RoundedCornerShape(12.dp)
              )
              .clickable { onSelectPillar(pillar.id) }
              .padding(vertical = 10.dp),
            contentAlignment = Alignment.Center
          ) {
            Text(
              text = label,
              style = MaterialTheme.typography.labelMedium,
              color = if (isSelected) OttomanNavyDark else ParchmentText,
              fontWeight = FontWeight.Bold
            )
          }
        }
      }

      Spacer(modifier = Modifier.height(16.dp))

      // Active Pillar Detail Card
      Card(
        shape = RoundedCornerShape(20.dp),
        colors = CardDefaults.cardColors(containerColor = OttomanNavyCard),
        border = androidx.compose.foundation.BorderStroke(1.5.dp, OttomanGoldDark.copy(alpha = 0.8f)),
        modifier = Modifier.fillMaxWidth()
      ) {
        Column(modifier = Modifier.padding(18.dp)) {
          Text(
            text = activePillar.title,
            style = MaterialTheme.typography.titleMedium.copy(
              fontFamily = FontFamily.Serif,
              fontWeight = FontWeight.Bold
            ),
            color = OttomanGold
          )

          Spacer(modifier = Modifier.height(10.dp))

          // Question Prompt Box
          Surface(
            shape = RoundedCornerShape(12.dp),
            color = OttomanNavyDark.copy(alpha = 0.8f),
            border = androidx.compose.foundation.BorderStroke(1.dp, OttomanNavyBorder),
            modifier = Modifier.fillMaxWidth()
          ) {
            Column(modifier = Modifier.padding(12.dp)) {
              Text(
                text = "Pertanyaan Analisis:",
                style = MaterialTheme.typography.labelSmall,
                color = OttomanGoldLight,
                fontWeight = FontWeight.Bold
              )
              Spacer(modifier = Modifier.height(4.dp))
              Text(
                text = activePillar.questionPrompt,
                style = MaterialTheme.typography.bodyMedium.copy(
                  fontWeight = FontWeight.SemiBold,
                  fontSize = 13.5.sp,
                  lineHeight = 19.sp
                ),
                color = ParchmentText
              )
            }
          }

          Spacer(modifier = Modifier.height(14.dp))

          // Historical Analysis
          Text(
            text = "📚 Analisis Historis Peradaban:",
            style = MaterialTheme.typography.labelMedium,
            color = OttomanEmerald,
            fontWeight = FontWeight.Bold
          )
          Spacer(modifier = Modifier.height(4.dp))
          Text(
            text = activePillar.historicalAnalysis,
            style = MaterialTheme.typography.bodyMedium.copy(
              fontSize = 13.5.sp,
              lineHeight = 21.sp
            ),
            color = ParchmentText
          )

          Spacer(modifier = Modifier.height(14.dp))

          // Student Relevance
          Text(
            text = "🎓 Relevansi & Keteladanan Siswa Abad 21:",
            style = MaterialTheme.typography.labelMedium,
            color = OttomanGoldLight,
            fontWeight = FontWeight.Bold
          )
          Spacer(modifier = Modifier.height(4.dp))
          Text(
            text = activePillar.studentRelevance,
            style = MaterialTheme.typography.bodyMedium.copy(
              fontSize = 13.5.sp,
              lineHeight = 21.sp
            ),
            color = ParchmentText
          )

          Spacer(modifier = Modifier.height(14.dp))

          // Key Takeaway
          Surface(
            shape = RoundedCornerShape(12.dp),
            color = OttomanEmerald.copy(alpha = 0.15f),
            border = androidx.compose.foundation.BorderStroke(1.dp, OttomanEmerald),
            modifier = Modifier.fillMaxWidth()
          ) {
            Row(
              modifier = Modifier.padding(12.dp),
              verticalAlignment = Alignment.CenterVertically,
              horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
              Icon(
                imageVector = Icons.Default.Lightbulb,
                contentDescription = null,
                tint = OttomanEmerald,
                modifier = Modifier.size(20.dp)
              )
              Text(
                text = activePillar.keyTakeaway,
                style = MaterialTheme.typography.bodySmall.copy(
                  fontWeight = FontWeight.Bold,
                  lineHeight = 18.sp
                ),
                color = Color.White
              )
            }
          }
        }
      }

      Spacer(modifier = Modifier.height(20.dp))

      // Back Action Button
      OutlinedButton(
        onClick = onBack,
        shape = RoundedCornerShape(16.dp),
        border = androidx.compose.foundation.BorderStroke(1.2.dp, OttomanGold),
        colors = ButtonDefaults.outlinedButtonColors(contentColor = OttomanGoldLight),
        modifier = Modifier
          .fillMaxWidth()
          .height(50.dp)
          .testTag("civilization_back_button")
      ) {
        Row(
          verticalAlignment = Alignment.CenterVertically,
          horizontalArrangement = Arrangement.Center
        ) {
          Icon(
            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
            contentDescription = null,
            modifier = Modifier.size(18.dp)
          )
          Spacer(modifier = Modifier.width(8.dp))
          Text(
            text = "KEMBALI KE PERJALANAN",
            style = MaterialTheme.typography.bodyLarge,
            fontWeight = FontWeight.Bold
          )
        }
      }
    }
  }
}
