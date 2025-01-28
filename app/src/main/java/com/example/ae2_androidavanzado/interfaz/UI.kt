package com.example.ae2_androidavanzado.interfaz


import android.app.Activity
import android.widget.*
import com.example.ae2_androidavanzado.R
import com.example.ae2_androidavanzado.api.Peticiones
import com.example.ae2_androidavanzado.model.TuplaHistorial


class UI(private val activity: Activity) {

    val botonConvertir: Button = activity.findViewById(R.id.botonConvertir)
    val resultadoConvertir: TextView = activity.findViewById(R.id.resultado)
    val spinnerOrigen: Spinner = activity.findViewById(R.id.spinnerOrigen)
    val spinnerDestino: Spinner = activity.findViewById(R.id.spinnerDestino)
    val inputUser: EditText = activity.findViewById(R.id.inputCantidad)
    val historial: MutableList<TuplaHistorial> = mutableListOf()



    init {
        cargarSpinner()
        botonListo()
    }
    fun cargarSpinner(){

        val adapter = ArrayAdapter.createFromResource(
            activity,
            R.array.spinner_items,
            android.R.layout.simple_spinner_item
        )
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_item)
        spinnerOrigen.adapter = adapter
        spinnerDestino.adapter = adapter
    }

    fun botonListo(){

        botonConvertir.setOnClickListener{
            val origen = spinnerOrigen.selectedItem.toString()
            val destino = spinnerDestino.selectedItem.toString()
            val input = inputUser.text.toString()
            if(input.isBlank()){
                Toast.makeText(activity,"Introduce una cantidad válida", Toast.LENGTH_SHORT).show()
            }
            
            val cantidad = input.toDouble()
            val peticion = Peticiones(activity)
            peticion.conversor(origen, destino, cantidad)

        }


    }
    fun mostrarCambio(valor: Double){

        val origen = spinnerOrigen.selectedItem.toString()
        val destino = spinnerDestino.selectedItem.toString()
        val input = inputUser.text.toString()
        val cantidad = input.toDouble()
        val tupla: TuplaHistorial = TuplaHistorial(origen, destino, cantidad, valor)
        historial.add(tupla)
        resultadoConvertir.text = valor.toString() + destino
    }
}