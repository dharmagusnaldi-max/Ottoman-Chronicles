package com.example.ui.components

import androidx.compose.foundation.Image
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
import androidx.compose.material.icons.filled.HourglassTop
import androidx.compose.material.icons.filled.MenuBook
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
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.R
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
fun IntroStoryScreen(
  onContinueStory: () -> Unit,
  onBackToCover: () -> Unit,
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
            Color(0xFF0A0F1D)
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

      // Top Header Info
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
              imageVector = Icons.Default.HourglassTop,
              contentDescription = null,
              tint = OttomanGold,
              modifier = Modifier.size(16.dp)
            )
            Text(
              text = "FASE 2: LATAR BELAKANG NARASI",
              style = MaterialTheme.typography.labelSmall,
              color = OttomanGoldLight,
              fontWeight = FontWeight.Bold
            )
          }
        }

        Text(
          text = "Anatolia • Abad ke-13",
          style = MaterialTheme.typography.labelSmall,
          color = ParchmentMuted
        )
      }

      Spacer(modifier = Modifier.height(16.dp))

      // Visual Story Banner Card
      Card(
        shape = RoundedCornerShape(20.dp),
        colors = CardDefaults.cardColors(containerColor = OttomanNavyCard),
        border = androidx.compose.foundation.BorderStroke(1.dp, OttomanGoldDark.copy(alpha = 0.5f)),
        modifier = Modifier.fillMaxWidth()
      ) {
        Column(modifier = Modifier.fillMaxWidth()) {
          Box(
            modifier = Modifier
              .fillMaxWidth()
              .height(150.dp)
          ) {
            Image(
              painter = painterResource(id = R.drawable.img_anatolia_dawn),
              contentDescription = "Pemandangan Perkemahan Anatolia",
              contentScale = ContentScale.Crop,
              modifier = Modifier.fillMaxSize()
            )
            Box(
              modifier = Modifier
                .fillMaxSize()
                .background(
                  Brush.verticalGradient(
                    colors = listOf(Color.Transparent, OttomanNavyCard)
                  )
                )
            )
          }

          Column(modifier = Modifier.padding(18.dp)) {
            Row(
              verticalAlignment = Alignment.CenterVertically,
              horizontalArrangement = Arrangement.spacedBy(10.dp)
            ) {
              Box(
                modifier = Modifier
                  .size(36.dp)
                  .clip(CircleShape)
                  .background(OttomanGold.copy(alpha = 0.2f))
                  .border(1.dp, OttomanGold, CircleShape),
                contentAlignment = Alignment.Center
              ) {
                Icon(
                  imageVector = Icons.Default.MenuBook,
                  contentDescription = null,
                  tint = OttomanGold,
                  modifier = Modifier.size(20.dp)
                )
              }
              Column {
                Text(
                  text = "Sang Penjaga Kronik Berbisik:",
                  style = MaterialTheme.typography.labelMedium,
                  color = OttomanGoldLight
                )
                Text(
                  text = "Panggilan Melintasi Lorong Waktu",
                  style = MaterialTheme.typography.titleMedium,
                  color = ParchmentText,
                  fontWeight = FontWeight.Bold,
                  fontFamily = FontFamily.Serif
                )
              }
            }

            Spacer(modifier = Modifier.height(14.dp))

            Text(
              text = "Sebuah kilatan cahaya takdir menarikmu dari abad ke-21 menuju dataran berbatu Anatolia tahun 1299 Masehi.\n\n" +
                  "Di hadapanmu berkibar panji suku Kayi pimpinan Osman I. Daulah Utsmaniyah baru saja menancapkan tiang-tiang fondasinya di tengah badai kekacauan runtuhnya Kesultanan Seljuk Rum.\n\n" +
                  "Namun, perjalanan 600 tahun sejarah yang agung ini terancam pudar dari ingatan generasi masa depan jika fragmen-fragmen kebijaksanaannya tidak disatukan kembali.",
              style = MaterialTheme.typography.bodyMedium.copy(
                fontSize = 14.5.sp,
                lineHeight = 22.sp
              ),
              color = ParchmentText
            )

            Spacer(modifier = Modifier.height(14.dp))

            // Objective Card
            Surface(
              shape = RoundedCornerShape(12.dp),
              color = OttomanNavyDark.copy(alpha = 0.8f),
              border = androidx.compose.foundation.BorderStroke(1.dp, OttomanEmerald.copy(alpha = 0.5f)),
              modifier = Modifier.fillMaxWidth()
            ) {
              Column(modifier = Modifier.padding(12.dp)) {
                Text(
                  text = "🎯 MISI UTAMA PENJELAJAH:",
                  style = MaterialTheme.typography.labelMedium,
                  color = OttomanEmerald,
                  fontWeight = FontWeight.Bold
                )
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                  text = "Taklukkan 15 tantangan sejarah, kumpulkan 15 Fragmen Kebijaksanaan, pecahkan 4 pilar analisis peradaban, dan raih gelar kehormatan 'Master of Ottoman History'.",
                  style = MaterialTheme.typography.bodySmall.copy(lineHeight = 18.sp),
                  color = ParchmentMuted
                )
              }
            }
          }
        }
      }

      Spacer(modifier = Modifier.height(24.dp))

      // Navigation Buttons
      Column(
        modifier = Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(10.dp)
      ) {
        Button(
          onClick = onContinueStory,
          shape = RoundedCornerShape(16.dp),
          colors = ButtonDefaults.buttonColors(
            containerColor = OttomanGold,
            contentColor = OttomanNavyDark
          ),
          modifier = Modifier
            .fillMaxWidth()
            .height(52.dp)
            .testTag("continue_story_button")
        ) {
          Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
          ) {
            Text(
              text = "LANJUTKAN CERITA",
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
          onClick = onBackToCover,
          shape = RoundedCornerShape(16.dp),
          border = androidx.compose.foundation.BorderStroke(1.dp, OttomanNavyBorder),
          colors = ButtonDefaults.outlinedButtonColors(
            contentColor = ParchmentMuted
          ),
          modifier = Modifier
            .fillMaxWidth()
            .height(48.dp)
            .testTag("back_to_cover_button")
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
              text = "KEMBALI KE COVER",
              style = MaterialTheme.typography.bodyMedium
            )
          }
        }
      }
    }
  }
}
