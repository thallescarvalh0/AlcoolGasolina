package br.edu.ifsp.scl.sdm.alcoolgasolina

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import br.edu.ifsp.scl.sdm.alcoolgasolina.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private var precoAlcool:String = ""
    private var precoGasolina:String = ""


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (savedInstanceState != null){
            precoAlcool = savedInstanceState.getStringArrayList("Alcool").toString()
            precoGasolina = savedInstanceState.getStringArrayList("Gasolina").toString()

        }
        else{
            precoAlcool = ""
            precoGasolina = ""
        }
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.btnCalcular.setOnClickListener {
            precoAlcool = binding.edtValorAlcool.text.toString()
            precoGasolina = binding.edtValorGasolina.text.toString()

            if ((precoAlcool != "") && (precoGasolina != "")){
                calcularMelhorPreco(precoAlcool,precoGasolina )
            }
        }
    }

    override fun onSaveInstanceState(outState: Bundle, outPersistentState: PersistableBundle) {
        super.onSaveInstanceState(outState, outPersistentState)
        outState.putString("Alcool", precoAlcool)
        outState.putString("Gasolina", precoGasolina)

    }

    fun calcularMelhorPreco(precoAlcool: String, precoGasolina:String){
        val valorAlcool = precoAlcool.toDouble()
        val valorGasolina = precoGasolina.toDouble()

        if (valorAlcool / valorGasolina >= 0.7){
            binding.tvResultado.setText("Melhor utilizar Gasolina")
        }else{
            binding.tvResultado.setText("Melhor utilizar Alcool")
        }
    }
}
