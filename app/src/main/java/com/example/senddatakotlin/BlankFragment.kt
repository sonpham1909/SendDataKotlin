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


class BlankFragment : Fragment() {
    private lateinit var viewModel: SharedViewModel;

    private lateinit var edittext2: EditText
    private lateinit var Btn_send: Button

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_1, container, false);
        // Inflate the layout for this fragment
        viewModel = ViewModelProvider(requireActivity()).get(SharedViewModel::class.java);
        edittext2 = view.findViewById(R.id.edt_email);
        Btn_send = view.requireViewById(R.id.btn_send)

//Set data
        viewModel.selected.observe(viewLifecycleOwner, Observer{item ->
            edittext2.setText("$item")
        })

        //nạp dữ liệu
        Btn_send.setOnClickListener(View.OnClickListener {
            viewModel.selected.value= edittext2.text.toString()
        })

        return view;
    }


}