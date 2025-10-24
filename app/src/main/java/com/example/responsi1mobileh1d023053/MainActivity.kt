package com.example.responsi1mobileh1d023053

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.responsi1mobileh1d023053.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initLayout()
        initListener()
    }

    private fun initLayout() {
        binding.layoutHist.let {
            it.imgIcon.setImageResource(R.drawable.soccer_ball_variant)
            it.tvLayout.setText("Club History")
        }

        binding.layoutCoach.let {
            it.imgIcon.setImageResource(R.drawable.manager)
            it.tvLayout.setText("Head Coach")
        }

        binding.layoutPlayers.let {
            it.imgIcon.setImageResource(R.drawable.group)
            it.tvLayout.setText("Team Squad")
        }
    }


    private fun initListener(){
        binding.layoutHist.root.setOnClickListener {
            val intent = Intent(this, ClubHistory::class.java)
            startActivity(intent)
        }
        binding.layoutCoach.root.setOnClickListener {
            val intent = Intent(this, CoachInfo::class.java)
            startActivity(intent)
        }
        binding.layoutPlayers.root.setOnClickListener {
            val intent = Intent(this, PlayerList::class.java)
            startActivity(intent)
        }
    }
}