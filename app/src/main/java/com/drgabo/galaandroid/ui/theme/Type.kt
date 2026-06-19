package com.drgabo.galaandroid.ui.theme

import com.drgabo.galaandroid.R
import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp


val MonstserratFamily = FontFamily(
    Font(R.font.montserrat_black, FontWeight.Black),
    Font(R.font.montserrat_bold, FontWeight.Bold),
    Font(R.font.montserrat_medium, FontWeight.Medium),
    Font(R.font.montserrat_regular, FontWeight.Normal),
    Font(R.font.montserrat_semi_bold, FontWeight.SemiBold)
)

// Set of Material typography styles to start with
val Typography = Typography(

    displayLarge = Typography().displayLarge.copy(fontFamily = MonstserratFamily),
    displayMedium = Typography().displayMedium.copy(fontFamily = MonstserratFamily),
    displaySmall = Typography().displaySmall.copy(fontFamily = MonstserratFamily),


    headlineLarge = Typography().headlineLarge.copy(fontFamily = MonstserratFamily),
    headlineMedium = Typography().headlineMedium.copy(fontFamily = MonstserratFamily),
    headlineSmall = Typography().headlineSmall.copy(fontFamily = MonstserratFamily),


    titleLarge = Typography().titleLarge.copy(fontFamily = MonstserratFamily),
    titleMedium = Typography().titleMedium.copy(fontFamily = MonstserratFamily),
    titleSmall = Typography().titleSmall.copy(fontFamily = MonstserratFamily),


    bodyLarge = Typography().bodyLarge.copy(fontFamily = MonstserratFamily),
    bodyMedium = Typography().bodyMedium.copy(fontFamily = MonstserratFamily),
    bodySmall = Typography().bodySmall.copy(fontFamily = MonstserratFamily),


    labelLarge = Typography().labelLarge.copy(fontFamily = MonstserratFamily),
    labelMedium = Typography().labelMedium.copy(fontFamily = MonstserratFamily),
    labelSmall = Typography().labelSmall.copy(fontFamily = MonstserratFamily),


    )
