package com.example.responsi1mobileh1d023053

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.DialogFragment
import com.example.responsi1mobileh1d023053.data.model.PlayerResponse
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class PlayerInfoFragment(private val player: PlayerResponse) : BottomSheetDialogFragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_player_info, container, false)

        val tvName = view.findViewById<TextView>(R.id.TVPlayerName)
        val tvDateOfBirth = view.findViewById<TextView>(R.id.TVDob)
        val tvNationality = view.findViewById<TextView>(R.id.TVNat)
        val tvPosition = view.findViewById<TextView>(R.id.TVPos)

        tvName.text = player.name
        tvPosition.text = "Position: ${player.position}"
        tvNationality.text = "Nationality: ${player.nationality}"
        tvDateOfBirth.text = "DOB: ${player.dateOfBirth}"

        return view
    }

    override fun onStart() {
        super.onStart()
        dialog?.window?.setLayout(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.WRAP_CONTENT
        )
    }
}
