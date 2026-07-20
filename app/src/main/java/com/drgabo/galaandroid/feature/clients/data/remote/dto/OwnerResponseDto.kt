package com.drgabo.galaandroid.feature.clients.data.remote.dto

import com.drgabo.galaandroid.data.dto.OwnerBusinessSummaryDto
import com.drgabo.galaandroid.data.dto.OwnerDashboardRealtimeDto
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class OwnerResponseDto(
    val businessSummaryDto: OwnerBusinessSummaryDto,
    val segment: SegmentDto,
    val query: String,
    val clients: List<OwnerClientListItemDto>,
    val selectedClient:OwnerClientListItemDto? = null,
    val realtime: OwnerDashboardRealtimeDto
)

/*
*
export type OwnerClientsResponse = {
  businessSummary: OwnerBusinessSummaryDto;
  segment: "all" | "frequent" | "new";
  query: string;
  clients: OwnerClientListItemDto[];
  selectedClient?: OwnerClientListItemDto | null;
  realtime: OwnerDashboardRealtimeDto;
};
*/