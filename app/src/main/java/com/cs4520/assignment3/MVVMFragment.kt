package com.cs4520.assignment3

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.cs4520.assignment3.databinding.MvvmFragmentBinding

class MVVMFragment : Fragment (R.layout.mvvm_fragment) {

    private var _binding: MvvmFragmentBinding? = null
    private val binding get() = _binding!!

    private lateinit var viewModel: CalculatorViewModel
    private lateinit var viewModelFactory: CalculatorViewModelFactory

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = MvvmFragmentBinding.inflate(inflater, container, false)
        //we start with no information, so we enter empty string
        viewModelFactory = CalculatorViewModelFactory("", "", null)
        viewModel = ViewModelProvider(this, viewModelFactory)[CalculatorViewModel::class.java]

        //update the result
        viewModel.readResult.observe(viewLifecycleOwner, Observer {
            if(viewModel.getResult() != "null"){
                val string = "Result: "
                binding.mvvmResult.text = string.plus(viewModel.getResult())
            }
        })

        binding.mvvmNum1.listenChanges { viewModel.changeNum1(binding.mvvmNum1.text.toString()) }
        binding.mvvmNum2.listenChanges { viewModel.changeNum2(binding.mvvmNum2.text.toString()) }

        //toast message
        viewModel.status.observe(viewLifecycleOwner, Observer {
            if(viewModel.status.value == true) {
                viewModel.status.value = null
                val text = "Invalid entry."
                val duration = Toast.LENGTH_SHORT

                val toast = Toast.makeText(this.activity, text, duration)
                toast.show()
            }
        })

        binding.mvvmAdd.setOnClickListener {
            viewModel.add()
            binding.mvvmNum1.setText("")
            binding.mvvmNum2.setText("")
        }

        binding.mvvmSubtract.setOnClickListener {
            viewModel.subtract()
            binding.mvvmNum1.setText("")
            binding.mvvmNum2.setText("")
        }

        binding.mvvmMultiply.setOnClickListener {
            viewModel.multiply()
            binding.mvvmNum1.setText("")
            binding.mvvmNum2.setText("")
        }

        binding.mvvmDivide.setOnClickListener {
            viewModel.divide()
            binding.mvvmNum1.setText("")
            binding.mvvmNum2.setText("")
        }

        return binding.root
    }

    private fun EditText.listenChanges(textChanged: (String) -> Unit) {
        addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
                //updates the text
                textChanged(s.toString())
            }
        })
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}