package com.example.responsi1mobileh1d023053.data.model

data class TeamResponse(
    val id: Int,
    val name:String,
    val shortName:String,
    val coach: CoachResponse,
    val squad: List<PlayerResponse>
)

data class PlayerResponse(
    val id: Int,
    val name: String,
    val position: String,
    val dateOfBirth: String,
    val nationality: String
)

data class CoachResponse(
    val id: Int,
    val firstName: String,
    val lastName: String,
    val name: String,
    val dateOfBirth: String,
    val nationality: String
)

