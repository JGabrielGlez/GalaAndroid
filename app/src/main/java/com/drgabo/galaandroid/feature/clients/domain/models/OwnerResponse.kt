package com.drgabo.galaandroid.feature.clients.domain.models

import com.drgabo.galaandroid.data.domain.models.OwnerBusinessSummary
import com.drgabo.galaandroid.data.domain.models.OwnerDashboardRealtime

import com.drgabo.galaandroid.feature.clients.data.remote.dto.SegmentDto

data class OwnerResponse(
    val businessSummary: OwnerBusinessSummary,
    val segment: Segment,
    val query: String,
    val clients: List<OwnerClientListItem>,
    val selectedClient:OwnerClientListItem? = null,
    val realtime: OwnerDashboardRealtime
)