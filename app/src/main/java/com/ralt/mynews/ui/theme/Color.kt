package com.ralt.mynews.ui.theme

import androidx.compose.ui.graphics.Color

val TechColor = Color(0xFF1565C0)
val WorldColor = Color(0xFF2E7D32)
val FrenchColor = Color(0xFF1565C0)
val LocalColor = Color(0xFFE65100)
val FinanceColor = Color(0xFFB388FF)
val LinuxColor = Color(0xFFBDBDBD)

fun categoryColor(category: String): Color = when (category.lowercase()) {
    "tech" -> TechColor
    "world" -> WorldColor
    "french" -> FrenchColor
    "local" -> LocalColor
    "finance" -> FinanceColor
    "linux" -> LinuxColor
    else -> Color.Gray
}
