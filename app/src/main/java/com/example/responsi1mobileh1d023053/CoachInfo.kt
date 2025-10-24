package com.example.responsi1mobileh1d023053

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.activity.enableEdgeToEdge
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.responsi1mobileh1d023053.data.model.TeamResponse
import com.example.responsi1mobileh1d023053.databinding.ActivityCoachInfoBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CoachInfo : AppCompatActivity() {

    private lateinit var binding: ActivityCoachInfoBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityCoachInfoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // ⬇️ This is where you call the API
        getTeamDetails()
    }

    private fun getTeamDetails() {
        RetrofitClient.instance.getTeam(498)
            .enqueue(object : Callback<TeamResponse> {
                override fun onResponse(
                    call: Call<TeamResponse>,
                    response: Response<TeamResponse>
                ) {
                    if (response.isSuccessful) {
                        val team = response.body()
                        val coach = team?.coach

                        binding.coachName.text = coach?.name ?: "Unknown"
                        binding.coachDob.text = coach?.dateOfBirth ?: "Unknown"
                        binding.coachNat.text = coach?.nationality ?: "Unknown"
                    } else {
                        binding.coachNat.text = "Error: ${response.code()}"
                    }
                }

                override fun onFailure(call: Call<TeamResponse>, t: Throwable) {
                    binding.coachName.text = "Failed: ${t.message}"
                }
            })
    }
}
