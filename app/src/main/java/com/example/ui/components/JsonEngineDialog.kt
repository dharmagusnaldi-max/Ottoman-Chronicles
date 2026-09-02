package com.example.ui.components

import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Code
import androidx.compose.material.icons.filled.ContentCopy
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
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
fun JsonEngineDialog(
  jsonContent: String,
  onDismiss: () -> Unit
) {
  val context = LocalContext.current

  Dialog(onDismissRequest = onDismiss) {
    Card(
      shape = RoundedCornerShape(20.dp),
      colors = CardDefaults.cardColors(containerColor = OttomanNavyCard),
      border = androidx.compose.foundation.BorderStroke(1.5.dp, Color(0xFF38BDF8)),
      modifier = Modifier
        .fillMaxWidth()
        .padding(vertical = 16.dp)
    ) {
      Column(
        modifier = Modifier
          .fillMaxWidth()
          .padding(16.dp)
      ) {

        // Dialog Title Row
        Row(
          modifier = Modifier.fillMaxWidth(),
          horizontalArrangement = Arrangement.SpaceBetween,
          verticalAlignment = Alignment.CenterVertically
        ) {
          Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(8.dp)
          ) {
            Icon(
              imageVector = Icons.Default.Code,
              contentDescription = null,
              tint = Color(0xFF38BDF8),
              modifier = Modifier.size(22.dp)
            )
            Column {
              Text(
                text = "Game Master Logic Engine",
                style = MaterialTheme.typography.titleMedium,
                color = Color.White,
                fontWeight = FontWeight.Bold
              )
              Text(
                text = "Structured JSON Output Turn State",
                style = MaterialTheme.typography.labelSmall,
                color = Color(0xFF38BDF8),
                fontSize = 11.sp
              )
            }
          }

          IconButton(onClick = onDismiss) {
            Icon(
              imageVector = Icons.Default.Close,
              contentDescription = "Tutup",
              tint = ParchmentMuted
            )
          }
        }

        Spacer(modifier = Modifier.height(10.dp))

        // JSON Code Container
        Surface(
          shape = RoundedCornerShape(12.dp),
          color = Color(0xFF070B14),
          border = androidx.compose.foundation.BorderStroke(1.dp, OttomanNavyBorder),
          modifier = Modifier
            .fillMaxWidth()
            .heightIn(min = 180.dp, max = 340.dp)
        ) {
          Box(
            modifier = Modifier
              .fillMaxWidth()
              .verticalScroll(rememberScrollState())
              .horizontalScroll(rememberScrollState())
              .padding(12.dp)
          ) {
            Text(
              text = jsonContent,
              fontFamily = FontFamily.Monospace,
              fontSize = 11.5.sp,
              lineHeight = 17.sp,
              color = Color(0xFF7DD3FC)
            )
          }
        }

        Spacer(modifier = Modifier.height(12.dp))

        // Action Buttons
        Row(
          modifier = Modifier.fillMaxWidth(),
          horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
          OutlinedButton(
            onClick = {
              val clipboard = context.getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
              val clip = ClipData.newPlainText("Game Engine JSON", jsonContent)
              clipboard.setPrimaryClip(clip)
              Toast.makeText(context, "JSON berhasil disalin ke clipboard!", Toast.LENGTH_SHORT).show()
            },
            shape = RoundedCornerShape(12.dp),
            border = androidx.compose.foundation.BorderStroke(1.dp, Color(0xFF38BDF8)),
            colors = ButtonDefaults.outlinedButtonColors(contentColor = Color(0xFF38BDF8)),
            modifier = Modifier
              .weight(1f)
              .height(44.dp)
          ) {
            Icon(
              imageVector = Icons.Default.ContentCopy,
              contentDescription = null,
              modifier = Modifier.size(16.dp)
            )
            Spacer(modifier = Modifier.width(6.dp))
            Text("Salin JSON", style = MaterialTheme.typography.bodySmall, fontWeight = FontWeight.Bold)
          }

          Button(
            onClick = onDismiss,
            shape = RoundedCornerShape(12.dp),
            colors = ButtonDefaults.buttonColors(
              containerColor = OttomanGold,
              contentColor = OttomanNavyDark
            ),
            modifier = Modifier
              .weight(1f)
              .height(44.dp)
          ) {
            Text("Tutup", style = MaterialTheme.typography.bodySmall, fontWeight = FontWeight.Bold)
          }
        }
      }
    }
  }
}
