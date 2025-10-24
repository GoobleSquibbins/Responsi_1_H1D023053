package com.example.responsi1mobileh1d023053

import com.example.responsi1mobileh1d023053.data.model.TeamResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface FootballApiService {
    @GET("teams/{id}")
    fun getTeam(@Path("id") teamId: Int): Call<TeamResponse>
}
