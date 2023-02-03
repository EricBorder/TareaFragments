package com.example.tareafragments.ui.main

import android.content.pm.ActivityInfo
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.example.tareafragments.R

class SumaFragment : Fragment() {

    companion object {
        fun newInstance() = SumaFragment()
    }

    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        // TODO: Use the ViewModel
        val miModelo by viewModels<MainViewModel>()

        miModelo.liveRandom.observe(
            this,
            Observer(
                fun(random: Int) {
                    var tvRandom: TextView? = view?.findViewById(R.id.sumaRandom1)
                    tvRandom?.setText("$random")

                }
            )

        )
        miModelo.liveRandom2.observe(
            this,
            Observer(
                fun(random2: Int) {
                    var tvRandom2: TextView? = view?.findViewById(R.id.sumaRandom2)
                    tvRandom2?.setText("$random2")

                }
            )

        )

        miModelo.liveResultado.observe(
            this,
            Observer(
                fun(resultado: Int) {
                    var tvResultado: TextView? = view?.findViewById(R.id.sumaResultado)
                    tvResultado?.setText("$resultado")

                }
            )
        )

    }

    override fun onCreateView(

        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val view: View = inflater.inflate(R.layout.fragment_suma, container, false)
        val botonMulti: Button? = view.findViewById(R.id.suma)
        val resultadoText: TextView? = view.findViewById(R.id.sumaResultado)

        botonMulti?.setOnClickListener {
            viewModel.hacerSuma()
            resultadoText?.text = viewModel.resultado.toString()
        }
        return view

    }


}