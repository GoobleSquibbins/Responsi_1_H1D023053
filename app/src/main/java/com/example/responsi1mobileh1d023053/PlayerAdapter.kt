package com.example.responsi1mobileh1d023053

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.responsi1mobileh1d023053.data.model.PlayerResponse
import com.example.responsi1mobileh1d023053.databinding.ListPlayerBinding

class PlayerAdapter(
    private var players: List<PlayerResponse>
) : RecyclerView.Adapter<PlayerAdapter.PlayerViewHolder>() {

    inner class PlayerViewHolder(val binding: ListPlayerBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlayerViewHolder {
        val binding = ListPlayerBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return PlayerViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PlayerViewHolder, position: Int) {
        val player = players[position]
        holder.binding.apply {
            plName.text = player.name
            plNat.text = player.nationality

            // Change background color based on position
            val colorRes = when (player.position.lowercase()) {
                "goalkeeper" -> R.color.yellow
                "defence" -> R.color.blue
                "midfield" -> R.color.green
                "offence" -> android.R.color.holo_red_light
                else -> android.R.color.darker_gray
            }
            root.setBackgroundResource(colorRes)
        }

        holder.binding.root.setOnClickListener {
            val fragment = PlayerInfoFragment(player)
            (holder.itemView.context as AppCompatActivity)
                .supportFragmentManager
                .let { fm -> fragment.show(fm, "player_info") }
        }
    }


    override fun getItemCount(): Int = players.size

    fun setData(newPlayers: List<PlayerResponse>) {
        players = newPlayers
        notifyDataSetChanged()
    }
}
