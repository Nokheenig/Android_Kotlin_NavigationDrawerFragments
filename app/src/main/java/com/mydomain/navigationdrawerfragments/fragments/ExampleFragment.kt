package com.mydomain.navigationdrawerfragments.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.mydomain.navigationdrawerfragments.R

private const val ARGS_TEXT = "argsText"
private const val  ARGS_NUMBER = "argsNumber"

class ExampleFragment : Fragment() {
    private var name = ""
    private var age = -1

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view  = inflater.inflate(R.layout.example_fragment, container, false)
        val textView: TextView = view.findViewById(R.id.textview)

        arguments?.let {
            name = it.getString(ARGS_TEXT, "Default name")
            age = it.getInt(ARGS_NUMBER, -1)
        }

        textView.text = name + "\n" + age.toString()
        return view
    }

    companion object {
        fun newInstance(text: String, number: Int) =
            ExampleFragment().apply {
                arguments = Bundle().apply {
                    putString(ARGS_TEXT, text)
                    putInt(ARGS_NUMBER, number)
                }
            }
    }
}