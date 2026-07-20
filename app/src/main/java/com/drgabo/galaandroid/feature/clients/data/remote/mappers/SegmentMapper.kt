package com.drgabo.galaandroid.feature.clients.data.remote.mappers

import com.drgabo.galaandroid.feature.clients.data.remote.dto.SegmentDto
import com.drgabo.galaandroid.feature.clients.domain.models.Segment

fun SegmentDto.toDomain(): Segment = when (this){
    SegmentDto.FREQUENT-> Segment.FREQUENT
    SegmentDto.ALL-> Segment.ALL
    SegmentDto.NEW-> Segment.NEW
}