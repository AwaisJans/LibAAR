package com.example.splashscrrenrequestexample.model
import com.google.gson.annotations.SerializedName


data class DashboardResponse(
    @SerializedName("dashboard")
    val dashboard: List<DashboardItem>
)