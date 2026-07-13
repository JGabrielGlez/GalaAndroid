package com.drgabo.galaandroid.feature.appointments.data.remote.mappers

import com.drgabo.galaandroid.feature.appointments.data.remote.dto.ThemeId as ThemeIdDto
import com.drgabo.galaandroid.feature.appointments.domain.models.ThemeId

fun ThemeIdDto.toDomain(): ThemeId {
    return when (this) {
        ThemeIdDto.neutral -> ThemeId.NEUTRAL
        ThemeIdDto.estetica -> ThemeId.ESTETICA
        ThemeIdDto.barberia -> ThemeId.BARBERIA
        ThemeIdDto.barberia_laton -> ThemeId.BARBERIA_LATON
        ThemeIdDto.salud -> ThemeId.SALUD
    }
}
