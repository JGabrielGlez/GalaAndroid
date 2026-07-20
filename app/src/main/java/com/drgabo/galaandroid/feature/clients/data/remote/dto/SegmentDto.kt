package com.drgabo.galaandroid.feature.clients.data.remote.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable


@Serializable
enum class SegmentDto {
    @SerialName("all")
    ALL,

    @SerialName("frequent")
    FREQUENT,

    @SerialName("new")
    NEW
}