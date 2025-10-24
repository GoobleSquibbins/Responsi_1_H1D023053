package com.example.responsi1mobileh1d023053

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.responsi1mobileh1d023053.data.model.PlayerResponse
import com.example.responsi1mobileh1d023053.data.model.TeamResponse
import com.example.responsi1mobileh1d023053.databinding.ActivityPlayerListBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class PlayerList : AppCompatActivity() {
    private lateinit var binding: ActivityPlayerListBinding
    private lateinit var adapter: PlayerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityPlayerListBinding.inflate(layoutInflater)
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(binding.main) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Setup RecyclerView
        adapter = PlayerAdapter(emptyList())
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        binding.recyclerView.adapter = adapter

        // For testing: Add some dummy players
//        val dummyPlayers = listOf(
//            PlayerResponse(1, "Lionel Messi", "Forward", "1987-06-24", "Argentina"),
//            PlayerResponse(2, "Kylian Mbappé", "Forward", "1998-12-20", "France"),
//            PlayerResponse(3, "Kevin De Bruyne", "Midfielder", "1991-06-28", "Belgium")
//        )
//
//       adapter.setData(dummyPlayers)
        loadPlayers()
    }

    private fun loadPlayers() {
        RetrofitClient.instance.getTeam(498).enqueue(object : Callback<TeamResponse> {
            override fun onResponse(call: Call<TeamResponse>, response: Response<TeamResponse>) {
                if (response.isSuccessful) {
                    val team = response.body()
                    team?.let {
                        adapter.setData(it.squad)
                    }
                } else {
                    Log.e("PlayerList", "Error: ${response.code()}")
                }
            }

            override fun onFailure(call: Call<TeamResponse>, t: Throwable) {
                Log.e("PlayerList", "Failed to load players: ${t.message}")
            }
        })
    }

}
