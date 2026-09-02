package com.example.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
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
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.EmojiEvents
import androidx.compose.material.icons.filled.Layers
import androidx.compose.material.icons.filled.Map
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
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
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
fun InstructionsMapScreen(
  onGoToLevelMap: () -> Unit,
  onBack: () -> Unit,
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
            Color(0xFF080C18)
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
            border = androidx.compose.foundation.BorderStroke(1.dp, OttomanNavyBorder)
          ) {
            Row(
              modifier = Modifier.padding(horizontal = 12.dp, vertical = 6.dp),
              verticalAlignment = Alignment.CenterVertically,
              horizontalArrangement = Arrangement.spacedBy(6.dp)
            ) {
              Icon(
                imageVector = Icons.Default.Map,
                contentDescription = null,
                tint = OttomanGold,
                modifier = Modifier.size(16.dp)
              )
              Text(
                text = "FASE 3: PETUNJUK & SISTEM GAME",
                style = MaterialTheme.typography.labelSmall,
                color = OttomanGoldLight,
                fontWeight = FontWeight.Bold
              )
            }
          }
        }

        Spacer(modifier = Modifier.height(12.dp))

        Text(
          text = "Panduan Penaklukan Kebijaksanaan",
          style = MaterialTheme.typography.headlineSmall.copy(
            fontFamily = FontFamily.Serif,
            fontWeight = FontWeight.Bold
          ),
          color = OttomanGold
        )
        Text(
          text = "Pahami aturan main, mekanisme skor, alur level, dan hierarki lencana.",
          style = MaterialTheme.typography.bodyMedium,
          color = ParchmentMuted
        )
      }

      Spacer(modifier = Modifier.height(16.dp))

      // Section 1: Aturan Main & Scoring
      Card(
        shape = RoundedCornerShape(18.dp),
        colors = CardDefaults.cardColors(containerColor = OttomanNavyCard),
        border = androidx.compose.foundation.BorderStroke(1.dp, OttomanNavyBorder),
        modifier = Modifier.fillMaxWidth()
      ) {
        Column(modifier = Modifier.padding(16.dp)) {
          Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(8.dp)
          ) {
            Icon(
              imageVector = Icons.Default.Star,
              contentDescription = null,
              tint = OttomanGold,
              modifier = Modifier.size(20.dp)
            )
            Text(
              text = "Sistem Poin & Evaluasi",
              style = MaterialTheme.typography.titleMedium,
              color = ParchmentText,
              fontWeight = FontWeight.Bold
            )
          }

          Spacer(modifier = Modifier.height(10.dp))

          RuleRow(
            icon = "✨",
            title = "+100 Poin per Jawaban Benar",
            desc = "Setiap tantangan sejarah yang terjawab tepat memberikan 100 poin langsung."
          )
          RuleRow(
            icon = "🔥",
            title = "Bonus Streak Kombo (+25 Poin)",
            desc = "Menjawab benar 2 kali atau lebih berturut-turut mengaktifkan bonus kombo!"
          )
          RuleRow(
            icon = "📜",
            title = "Koleksi 15 Fragmen Kebijaksanaan",
            desc = "Setiap jawaban benar membuka fragmen hikmah keteladanan Utsmaniyah."
          )
        }
      }

      Spacer(modifier = Modifier.height(12.dp))

      // Section 2: Struktur 5 Level Game
      Card(
        shape = RoundedCornerShape(18.dp),
        colors = CardDefaults.cardColors(containerColor = OttomanNavyCard),
        border = androidx.compose.foundation.BorderStroke(1.dp, OttomanGoldDark.copy(alpha = 0.5f)),
        modifier = Modifier.fillMaxWidth()
      ) {
        Column(modifier = Modifier.padding(16.dp)) {
          Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(8.dp)
          ) {
            Icon(
              imageVector = Icons.Default.Layers,
              contentDescription = null,
              tint = OttomanGoldLight,
              modifier = Modifier.size(20.dp)
            )
            Text(
              text = "Alur 4 Level & Final Challenge",
              style = MaterialTheme.typography.titleMedium,
              color = ParchmentText,
              fontWeight = FontWeight.Bold
            )
          }

          Spacer(modifier = Modifier.height(10.dp))

          LevelSummaryBadge("Level 1", "Fajar Anatolia", "5 Soal Pemahaman Awal (1299 M)", OttomanEmerald)
          LevelSummaryBadge("Level 2", "Penaklukan & Ekspansi", "4 Soal Timeline Sejarah & 1453 M", OttomanGold)
          LevelSummaryBadge("Level 3", "Tokoh-Tokoh Besar", "3 Soal Biografi Osman, Mehmed II, Suleiman, Sinan", Color(0xFF60A5FA))
          LevelSummaryBadge("Level 4", "Analisis Peradaban", "2 Soal Pendidikan, Hukum, Pemerintahan & Wakaf", Color(0xFFA78BFA))
          LevelSummaryBadge("Final", "Nilai Keteladanan", "1 Soal Ujian Sintesis untuk Siswa Abad 21", Color(0xFFF43F5E))
        }
      }

      Spacer(modifier = Modifier.height(12.dp))

      // Section 3: Badge Kehormatan
      Card(
        shape = RoundedCornerShape(18.dp),
        colors = CardDefaults.cardColors(containerColor = OttomanNavyCard),
        border = androidx.compose.foundation.BorderStroke(1.dp, OttomanNavyBorder),
        modifier = Modifier.fillMaxWidth()
      ) {
        Column(modifier = Modifier.padding(16.dp)) {
          Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(8.dp)
          ) {
            Icon(
              imageVector = Icons.Default.EmojiEvents,
              contentDescription = null,
              tint = OttomanGold,
              modifier = Modifier.size(20.dp)
            )
            Text(
              text = "Gelar & Lencana Penghargaan",
              style = MaterialTheme.typography.titleMedium,
              color = ParchmentText,
              fontWeight = FontWeight.Bold
            )
          }

          Spacer(modifier = Modifier.height(8.dp))

          BadgeItemRow("👑", "Master of Ottoman History", "Skor 1300+ poin (Puncak Kebijaksanaan)")
          BadgeItemRow("📜", "Grand Vizier of Wisdom", "Skor 1100 - 1299 poin")
          BadgeItemRow("⚔️", "Sultan of Strategy", "Skor 800 - 1099 poin")
          BadgeItemRow("🛡️", "Guardian of Anatolia", "Skor < 800 poin")
        }
      }

      Spacer(modifier = Modifier.height(20.dp))

      // Navigation Actions
      Column(
        modifier = Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(10.dp)
      ) {
        Button(
          onClick = onGoToLevelMap,
          shape = RoundedCornerShape(16.dp),
          colors = ButtonDefaults.buttonColors(
            containerColor = OttomanGold,
            contentColor = OttomanNavyDark
          ),
          modifier = Modifier
            .fillMaxWidth()
            .height(52.dp)
            .testTag("enter_level_map_button")
        ) {
          Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
          ) {
            Text(
              text = "MASUK KE MAP LEVEL",
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

        OutlinedButton(
          onClick = onBack,
          shape = RoundedCornerShape(16.dp),
          border = androidx.compose.foundation.BorderStroke(1.dp, OttomanNavyBorder),
          colors = ButtonDefaults.outlinedButtonColors(
            contentColor = ParchmentMuted
          ),
          modifier = Modifier
            .fillMaxWidth()
            .height(48.dp)
            .testTag("instructions_back_button")
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
              text = "KEMBALI",
              style = MaterialTheme.typography.bodyMedium
            )
          }
        }
      }
    }
  }
}

@Composable
private fun RuleRow(icon: String, title: String, desc: String) {
  Row(
    modifier = Modifier
      .fillMaxWidth()
      .padding(vertical = 4.dp),
    horizontalArrangement = Arrangement.spacedBy(10.dp)
  ) {
    Text(text = icon, fontSize = 16.sp)
    Column {
      Text(
        text = title,
        style = MaterialTheme.typography.labelMedium,
        color = OttomanGoldLight,
        fontWeight = FontWeight.Bold
      )
      Text(
        text = desc,
        style = MaterialTheme.typography.bodySmall,
        color = ParchmentMuted
      )
    }
  }
}

@Composable
private fun LevelSummaryBadge(tag: String, title: String, desc: String, accentColor: Color) {
  Row(
    modifier = Modifier
      .fillMaxWidth()
      .padding(vertical = 4.dp)
      .background(OttomanNavyDark.copy(alpha = 0.6f), RoundedCornerShape(8.dp))
      .padding(8.dp),
    verticalAlignment = Alignment.CenterVertically,
    horizontalArrangement = Arrangement.spacedBy(10.dp)
  ) {
    Surface(
      shape = RoundedCornerShape(6.dp),
      color = accentColor.copy(alpha = 0.2f),
      border = androidx.compose.foundation.BorderStroke(1.dp, accentColor)
    ) {
      Text(
        text = tag,
        style = MaterialTheme.typography.labelSmall,
        color = accentColor,
        fontWeight = FontWeight.Bold,
        modifier = Modifier.padding(horizontal = 6.dp, vertical = 2.dp)
      )
    }
    Column {
      Text(
        text = title,
        style = MaterialTheme.typography.bodyMedium,
        color = ParchmentText,
        fontWeight = FontWeight.SemiBold
      )
      Text(
        text = desc,
        style = MaterialTheme.typography.labelSmall,
        color = ParchmentMuted
      )
    }
  }
}

@Composable
private fun BadgeItemRow(icon: String, title: String, desc: String) {
  Row(
    modifier = Modifier
      .fillMaxWidth()
      .padding(vertical = 4.dp),
    verticalAlignment = Alignment.CenterVertically,
    horizontalArrangement = Arrangement.spacedBy(10.dp)
  ) {
    Text(text = icon, fontSize = 20.sp)
    Column {
      Text(
        text = title,
        style = MaterialTheme.typography.labelMedium,
        color = OttomanGold,
        fontWeight = FontWeight.Bold
      )
      Text(
        text = desc,
        style = MaterialTheme.typography.labelSmall,
        color = ParchmentMuted
      )
    }
  }
}
