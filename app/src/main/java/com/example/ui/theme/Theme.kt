package com.example.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val OttomanColorScheme = darkColorScheme(
  primary = OttomanGold,
  onPrimary = OttomanNavyDark,
  primaryContainer = OttomanGoldContainer,
  onPrimaryContainer = OttomanGoldLight,
  secondary = OttomanEmerald,
  onSecondary = Color.White,
  secondaryContainer = OttomanEmeraldDark,
  onSecondaryContainer = Color.White,
  tertiary = OttomanRuby,
  onTertiary = Color.White,
  tertiaryContainer = OttomanRubyDark,
  onTertiaryContainer = Color.White,
  background = OttomanNavyDark,
  onBackground = ParchmentText,
  surface = OttomanNavySurface,
  onSurface = ParchmentText,
  surfaceVariant = OttomanNavyCard,
  onSurfaceVariant = ParchmentMuted,
  outline = OttomanNavyBorder,
  outlineVariant = OttomanGoldDark.copy(alpha = 0.4f)
)

private val LightOttomanColorScheme = lightColorScheme(
  primary = OttomanGoldDark,
  onPrimary = Color.White,
  primaryContainer = OttomanGoldLight.copy(alpha = 0.4f),
  onPrimaryContainer = OttomanNavyDark,
  secondary = OttomanEmeraldDark,
  onSecondary = Color.White,
  secondaryContainer = OttomanEmerald.copy(alpha = 0.3f),
  onSecondaryContainer = OttomanNavyDark,
  tertiary = OttomanRuby,
  onTertiary = Color.White,
  background = Color(0xFFFAF7F2),
  onBackground = OttomanNavyDark,
  surface = Color(0xFFFFFFFF),
  onSurface = OttomanNavyDark,
  surfaceVariant = Color(0xFFF0EAE1),
  onSurfaceVariant = Color(0xFF4A453E),
  outline = Color(0xFFD6C8B5)
)

@Composable
fun MyApplicationTheme(
  darkTheme: Boolean = true, // Default to rich cinematic dark theme
  dynamicColor: Boolean = false,
  content: @Composable () -> Unit,
) {
  val colorScheme = if (darkTheme) OttomanColorScheme else LightOttomanColorScheme
  MaterialTheme(
    colorScheme = colorScheme,
    typography = Typography,
    content = content
  )
}
