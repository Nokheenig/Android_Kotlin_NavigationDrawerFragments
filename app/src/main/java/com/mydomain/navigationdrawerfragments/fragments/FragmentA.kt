package com.mydomain.navigationdrawerfragments.fragments

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.Fragment
import com.mydomain.navigationdrawerfragments.R

class FragmentA : Fragment() {
    private lateinit var editText: EditText
    private lateinit var sendButton: Button
    private lateinit var listener: FragmentAListener
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_a, container, false)
        editText = view.findViewById(R.id.edit_text_a)
        sendButton = view.findViewById(R.id.send_button_a)
        sendButton.setOnClickListener {
            listener.sendFromA(editText.text.toString())
        }
        return view
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is FragmentAListener) {
            listener = context
        } else {
            throw RuntimeException(context.toString() +
            " you must implement FragmentAListener")
        }
    }

    fun updateText(input: String) {
        editText.setText(input)
    }

    interface FragmentAListener {
        fun sendFromA(input: String)
    }
}