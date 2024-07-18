package com.example.senddatakotlin

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider


class BlankFragment2 : Fragment() {
    private lateinit var edittext2:EditText

    private lateinit var viewModel: SharedViewModel
    private lateinit var Btn_update: Button
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_2, container, false)
        // Inflate the layout for this fragment
        viewModel = ViewModelProvider(requireActivity()).get(SharedViewModel::class.java);

         edittext2 = view.findViewById(R.id.edt_email1);
        Btn_update = view.requireViewById(R.id.btn_update)


        viewModel.selected.observe(viewLifecycleOwner, Observer{item ->
            edittext2.setText("$item")
        })
        Btn_update.setOnClickListener(View.OnClickListener {
            viewModel.selected.value= edittext2.text.toString()
        })



        return view;
    }


}