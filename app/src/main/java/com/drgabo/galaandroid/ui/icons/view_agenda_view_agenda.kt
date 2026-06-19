package com.drgabo.galaandroid.ui.icons

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathFillType
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.StrokeJoin
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp

@Suppress("CheckReturnValue")
public val view_agenda: ImageVector
  get() {
    if (_view_agenda != null) {
      return _view_agenda!!
    }
    _view_agenda =
      ImageVector.Builder(
          name = "view_agenda",
          defaultWidth = 24.dp,
          defaultHeight = 24.dp,
          viewportWidth = 24f,
          viewportHeight = 24f,
        )
        .apply {
          path(
            fill = SolidColor(Color.Black),
            fillAlpha = 1f,
            stroke = null,
            strokeAlpha = 1f,
            strokeLineWidth = 1f,
            strokeLineCap = StrokeCap.Butt,
            strokeLineJoin = StrokeJoin.Bevel,
            strokeLineMiter = 1f,
            pathFillType = PathFillType.Companion.NonZero,
          ) {
            moveTo(5f, 11f)
            quadTo(4.18f, 11f, 3.59f, 10.41f)
            reflectiveQuadTo(3f, 9f)
            verticalLineTo(5f)
            quadTo(3f, 4.17f, 3.59f, 3.59f)
            reflectiveQuadTo(5f, 3f)
            horizontalLineTo(19f)
            quadToRelative(0.83f, 0f, 1.41f, 0.59f)
            reflectiveQuadTo(21f, 5f)
            verticalLineTo(9f)
            quadToRelative(0f, 0.82f, -0.59f, 1.41f)
            reflectiveQuadTo(19f, 11f)
            horizontalLineTo(5f)
            close()
            moveTo(5f, 9f)
            horizontalLineTo(19f)
            verticalLineTo(5f)
            horizontalLineTo(5f)
            verticalLineTo(9f)
            close()
            moveTo(5f, 21f)
            quadTo(4.18f, 21f, 3.59f, 20.41f)
            reflectiveQuadTo(3f, 19f)
            verticalLineTo(15f)
            quadTo(3f, 14.18f, 3.59f, 13.59f)
            reflectiveQuadTo(5f, 13f)
            horizontalLineTo(19f)
            quadToRelative(0.83f, 0f, 1.41f, 0.59f)
            quadTo(21f, 14.18f, 21f, 15f)
            verticalLineToRelative(4f)
            quadToRelative(0f, 0.82f, -0.59f, 1.41f)
            reflectiveQuadTo(19f, 21f)
            horizontalLineTo(5f)
            close()
            moveTo(5f, 19f)
            horizontalLineTo(19f)
            verticalLineTo(15f)
            horizontalLineTo(5f)
            verticalLineToRelative(4f)
            close()
            moveTo(5f, 5f)
            verticalLineTo(9f)
            verticalLineTo(5f)
            close()
            moveTo(5f, 15f)
            verticalLineToRelative(4f)
            verticalLineTo(15f)
            close()
          }
        }
        .build()
    return _view_agenda!!
  }

private var _view_agenda: ImageVector? = null
