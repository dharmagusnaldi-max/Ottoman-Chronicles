package com.example.ui.components

import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
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
import androidx.compose.material.icons.filled.AutoAwesome
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.PlayArrow
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
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
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
import com.example.ui.theme.OttomanGold
import com.example.ui.theme.OttomanGoldDark
import com.example.ui.theme.OttomanGoldLight
import com.example.ui.theme.OttomanNavy
import com.example.ui.theme.OttomanNavyBorder
import com.example.ui.theme.OttomanNavyCard
import com.example.ui.theme.OttomanNavyDark
import com.example.ui.theme.OttomanNavySurface
import com.example.ui.theme.OttomanRuby
import com.example.ui.theme.ParchmentMuted
import com.example.ui.theme.ParchmentText

@Composable
fun CoverScreen(
  onStartAdventure: () -> Unit,
  onShowInstructions: () -> Unit,
  onOpenCivilizationAnalysis: () -> Unit,
  modifier: Modifier = Modifier
) {
  val infiniteTransition = rememberInfiniteTransition(label = "crest_pulse")
  val pulseScale by infiniteTransition.animateFloat(
    initialValue = 0.96f,
    targetValue = 1.04f,
    animationSpec = infiniteRepeatable(
      animation = tween(2200, easing = FastOutSlowInEasing),
      repeatMode = RepeatMode.Reverse
    ),
    label = "pulse"
  )

  Box(
    modifier = modifier
      .fillMaxSize()
      .background(
        Brush.verticalGradient(
          colors = listOf(
            OttomanNavyDark,
            OttomanNavy,
            Color(0xFF070B16)
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
      horizontalAlignment = Alignment.CenterHorizontally,
      verticalArrangement = Arrangement.SpaceBetween
    ) {

      // Top Tag
      Surface(
        shape = RoundedCornerShape(50),
        color = OttomanNavyCard,
        border = androidx.compose.foundation.BorderStroke(1.dp, OttomanNavyBorder),
        modifier = Modifier.padding(top = 4.dp)
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
            modifier = Modifier.size(14.dp)
          )
          Text(
            text = "THE GREAT EMPIRE AWAITS",
            style = MaterialTheme.typography.labelSmall.copy(
              letterSpacing = 2.sp,
              fontWeight = FontWeight.SemiBold
            ),
            color = OttomanGold
          )
        }
      }

      Spacer(modifier = Modifier.height(12.dp))

      // Hero Card with Image and Golden Accents
      Card(
        shape = RoundedCornerShape(24.dp),
        colors = CardDefaults.cardColors(containerColor = OttomanNavyCard),
        border = androidx.compose.foundation.BorderStroke(1.dp, OttomanNavyBorder),
        elevation = CardDefaults.cardElevation(defaultElevation = 8.dp),
        modifier = Modifier
          .fillMaxWidth()
          .shadow(16.dp, RoundedCornerShape(24.dp), ambientColor = OttomanGold.copy(alpha = 0.25f))
      ) {
        Column(
          modifier = Modifier.fillMaxWidth(),
          horizontalAlignment = Alignment.CenterHorizontally
        ) {
          Box(
            modifier = Modifier
              .fillMaxWidth()
              .height(170.dp)
          ) {
            Image(
              painter = painterResource(id = R.drawable.img_hero_banner),
              contentDescription = "Panorama Istanbul Utsmaniyah",
              contentScale = ContentScale.Crop,
              modifier = Modifier.fillMaxSize()
            )
            Box(
              modifier = Modifier
                .fillMaxSize()
                .background(
                  Brush.verticalGradient(
                    colors = listOf(
                      Color.Transparent,
                      OttomanNavyCard.copy(alpha = 0.8f),
                      OttomanNavyCard
                    )
                  )
                )
            )

            // Centered App Emblem
            Box(
              modifier = Modifier
                .align(Alignment.BottomCenter)
                .size(76.dp)
                .scale(pulseScale)
                .clip(CircleShape)
                .background(OttomanNavyDark)
                .border(2.dp, OttomanGold, CircleShape),
              contentAlignment = Alignment.Center
            ) {
              Image(
                painter = painterResource(id = R.drawable.img_app_icon),
                contentDescription = "Emblem Ottoman",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                  .size(70.dp)
                  .clip(CircleShape)
              )
            }
          }

          Spacer(modifier = Modifier.height(10.dp))

          // Titles
          Column(
            modifier = Modifier.padding(horizontal = 16.dp, vertical = 6.dp),
            horizontalAlignment = Alignment.CenterHorizontally
          ) {
            Text(
              text = "OTTOMAN CHRONICLES",
              style = MaterialTheme.typography.headlineMedium.copy(
                fontSize = 25.sp,
                letterSpacing = 2.sp,
                fontWeight = FontWeight.Bold,
                fontFamily = FontFamily.Serif
              ),
              color = Color.White,
              textAlign = TextAlign.Center
            )

            // Elegant Gold Divider
            Box(
              modifier = Modifier
                .padding(vertical = 6.dp)
                .width(48.dp)
                .height(2.dp)
                .background(OttomanGold, RoundedCornerShape(1.dp))
            )

            Text(
              text = "Conquest of Wisdom",
              style = MaterialTheme.typography.titleMedium.copy(
                fontSize = 16.sp,
                fontStyle = androidx.compose.ui.text.font.FontStyle.Italic,
                letterSpacing = 1.sp
              ),
              color = OttomanGold,
              textAlign = TextAlign.Center
            )

            Spacer(modifier = Modifier.height(6.dp))

            Text(
              text = "Jelajahi fajar Anatolia 1299 M, taklukkan Konstantinopel 1453 M, dan petik hikmah peradaban Utsmaniyah untuk pelajar masa kini.",
              style = MaterialTheme.typography.bodyMedium.copy(
                fontSize = 13.sp,
                lineHeight = 19.sp
              ),
              color = ParchmentMuted,
              textAlign = TextAlign.Center,
              modifier = Modifier.padding(horizontal = 8.dp)
            )
          }

          Spacer(modifier = Modifier.height(6.dp))

          // Key Highlights Chips
          Row(
            modifier = Modifier
              .fillMaxWidth()
              .padding(horizontal = 12.dp, vertical = 6.dp),
            horizontalArrangement = Arrangement.SpaceEvenly
          ) {
            InfoFeaturePill("15 Soal", "Sejarah Lengkap")
            InfoFeaturePill("5 Level", "Alur Naratif")
            InfoFeaturePill("4 Pilar", "Analisis Siswa")
          }

          Spacer(modifier = Modifier.height(12.dp))
        }
      }

      Spacer(modifier = Modifier.height(16.dp))

      // Navigation Actions
      Column(
        modifier = Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(10.dp)
      ) {
        Button(
          onClick = onStartAdventure,
          shape = RoundedCornerShape(16.dp),
          colors = ButtonDefaults.buttonColors(
            containerColor = OttomanGold,
            contentColor = OttomanNavyDark
          ),
          elevation = ButtonDefaults.buttonElevation(defaultElevation = 6.dp),
          modifier = Modifier
            .fillMaxWidth()
            .height(52.dp)
            .testTag("start_adventure_button")
        ) {
          Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
          ) {
            Icon(
              imageVector = Icons.Default.PlayArrow,
              contentDescription = null,
              modifier = Modifier.size(22.dp)
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text(
              text = "MULAI PETUALANGAN",
              style = MaterialTheme.typography.titleMedium,
              fontWeight = FontWeight.Bold,
              letterSpacing = 1.sp
            )
          }
        }

        Button(
          onClick = onShowInstructions,
          shape = RoundedCornerShape(16.dp),
          colors = ButtonDefaults.buttonColors(
            containerColor = OttomanNavyCard,
            contentColor = ParchmentText
          ),
          border = androidx.compose.foundation.BorderStroke(1.dp, OttomanNavyBorder),
          modifier = Modifier
            .fillMaxWidth()
            .height(48.dp)
            .testTag("instructions_button")
        ) {
          Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
          ) {
            Icon(
              imageVector = Icons.Default.Info,
              contentDescription = null,
              tint = OttomanGold,
              modifier = Modifier.size(18.dp)
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text(
              text = "PETUNJUK PERMAINAN",
              style = MaterialTheme.typography.bodyLarge,
              fontWeight = FontWeight.SemiBold
            )
          }
        }

        OutlinedButton(
          onClick = onOpenCivilizationAnalysis,
          shape = RoundedCornerShape(16.dp),
          border = androidx.compose.foundation.BorderStroke(1.dp, OttomanNavyBorder),
          colors = ButtonDefaults.outlinedButtonColors(
            contentColor = ParchmentMuted
          ),
          modifier = Modifier
            .fillMaxWidth()
            .height(44.dp)
            .testTag("civilization_analysis_button")
        ) {
          Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
          ) {
            Icon(
              imageVector = Icons.Default.School,
              contentDescription = null,
              tint = OttomanGoldLight,
              modifier = Modifier.size(16.dp)
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text(
              text = "Eksplorasi Analisis Peradaban",
              style = MaterialTheme.typography.bodyMedium,
              fontWeight = FontWeight.Normal
            )
          }
        }
      }

      Spacer(modifier = Modifier.height(10.dp))

      // Bottom Status Indicator Card
      Surface(
        shape = RoundedCornerShape(16.dp),
        color = OttomanNavySurface,
        border = androidx.compose.foundation.BorderStroke(1.dp, OttomanNavyBorder),
        modifier = Modifier.fillMaxWidth()
      ) {
        Row(
          modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 14.dp, vertical = 10.dp),
          verticalAlignment = Alignment.CenterVertically,
          horizontalArrangement = Arrangement.SpaceBetween
        ) {
          Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(10.dp)
          ) {
            Box(
              modifier = Modifier
                .size(32.dp)
                .background(OttomanGold.copy(alpha = 0.15f), CircleShape),
              contentAlignment = Alignment.Center
            ) {
              Icon(
                imageVector = Icons.Default.AutoAwesome,
                contentDescription = null,
                tint = OttomanGold,
                modifier = Modifier.size(16.dp)
              )
            }
            Column {
              Text(
                text = "GLOBAL RANK",
                style = MaterialTheme.typography.labelSmall.copy(
                  fontSize = 9.sp,
                  letterSpacing = 1.sp
                ),
                color = ParchmentMuted
              )
              Text(
                text = "Level 0 • Novice Sejarah",
                style = MaterialTheme.typography.labelMedium.copy(
                  fontWeight = FontWeight.Bold
                ),
                color = Color.White
              )
            }
          }
          Text(
            text = "STEP 1/15",
            style = MaterialTheme.typography.labelSmall.copy(
              letterSpacing = 1.sp,
              fontWeight = FontWeight.Bold
            ),
            color = OttomanGold
          )
        }
      }
    }
  }
}

@Composable
private fun InfoFeaturePill(title: String, subtitle: String) {
  Column(
    horizontalAlignment = Alignment.CenterHorizontally,
    modifier = Modifier
      .background(OttomanNavy.copy(alpha = 0.7f), RoundedCornerShape(10.dp))
      .border(1.dp, OttomanNavyBorder, RoundedCornerShape(10.dp))
      .padding(horizontal = 10.dp, vertical = 6.dp)
  ) {
    Text(
      text = title,
      style = MaterialTheme.typography.labelLarge,
      color = OttomanGoldLight,
      fontWeight = FontWeight.Bold
    )
    Text(
      text = subtitle,
      style = MaterialTheme.typography.labelSmall,
      color = ParchmentMuted,
      fontSize = 10.sp
    )
  }
}
