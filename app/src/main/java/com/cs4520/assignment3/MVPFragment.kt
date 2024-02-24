package com.cs4520.assignment3

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.cs4520.assignment3.databinding.MvpFragmentBinding

class MVPFragment : Fragment(R.layout.mvp_fragment), MVPContract.View {
    private var _binding: MvpFragmentBinding? = null
    private val binding get() = _binding!!

    var presenter: Presenter? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = MvpFragmentBinding.inflate(inflater, container, false)
        presenter = Presenter(this)

        binding.mvpAdd.setOnClickListener{
            presenter!!.OnAddClick(binding.mvpNum1.text.toString(), binding.mvpNum2.text.toString())
        }
        binding.mvpSubtract.setOnClickListener{
            presenter!!.OnSubtractClick(binding.mvpNum1.text.toString(), binding.mvpNum2.text.toString())
        }
        binding.mvpDivide.setOnClickListener {
            presenter!!.OnDivideClick(binding.mvpNum1.text.toString(), binding.mvpNum2.text.toString())
        }
        binding.mvpMultiply.setOnClickListener {
            presenter!!.OnMultiplyClick(binding.mvpNum1.text.toString(), binding.mvpNum2.text.toString())
        }

        return binding.root
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun ShowToast() {
        val text = "Invalid entry."
        val duration = Toast.LENGTH_SHORT

        val toast = Toast.makeText(this.activity, text, duration)
        toast.show()
    }

    override fun ShowResult(result: Float) {
        binding.mvpResult.text = result.toString()
    }
}