package com.mydomain.navigationdrawerfragments.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.Fragment
import com.mydomain.navigationdrawerfragments.R

class FragmentB(private val listener: FragmentBListener) : Fragment() {
    private lateinit var editText: EditText
    private lateinit var sendButton: Button
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_b, container, false)
        editText = view.findViewById(R.id.edit_text_b)
        sendButton = view.findViewById(R.id.send_button_b)
        sendButton.setOnClickListener {
            listener.sendFromB(editText.text.toString())
        }
        return view
    }

    fun updateText(input: String) {
        editText.setText(input)
    }

    interface FragmentBListener {
        fun sendFromB(input: String)
    }
}