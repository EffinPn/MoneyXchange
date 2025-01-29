package com.example.ae2_androidavanzado.interfaz


import android.app.Activity
import android.content.Intent
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.*
import com.example.ae2_androidavanzado.R
import com.example.ae2_androidavanzado.api.Peticiones
import com.example.ae2_androidavanzado.model.ListaHistorial
import com.example.ae2_androidavanzado.model.ListaHistorial.historial
import com.example.ae2_androidavanzado.model.Simbolos
import com.example.ae2_androidavanzado.model.TuplaHistorial


class UI(private val activity: AppCompatActivity) {

    //Enlazamos las variables con los elementos del XML
    val botonConvertir: Button = activity.findViewById(R.id.botonConvertir)
    val botonBannerHistorial: Button = activity.findViewById(R.id.botonHistoria)
    val botonBannerConversor: Button = activity.findViewById(R.id.convertirBanner)
    val botonReset: Button = activity.findViewById(R.id.botonReset)
    val resultadoConvertir: TextView = activity.findViewById(R.id.resultado)
    val spinnerOrigen: Spinner = activity.findViewById(R.id.spinnerOrigen)
    val spinnerDestino: Spinner = activity.findViewById(R.id.spinnerDestino)
    val inputUser: EditText = activity.findViewById(R.id.inputCantidad)

    //init para ejecutar estos métodos en cuanto se abra la app
    init {
        cargarSpinner()
        botonesPrincipal()
    }

    //Método para cargar el array con las monedas en los spinners, como son intercambiables, ambos reciben el mismo adapter.
    fun cargarSpinner() {

        val adapter = ArrayAdapter.createFromResource(
            activity,
            R.array.spinner_items,
            android.R.layout.simple_spinner_item
        )
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_item)
        spinnerOrigen.adapter = adapter
        spinnerDestino.adapter = adapter
    }

    //Método para establecer los listeners de los botones
    fun botonesPrincipal() {

        botonConvertir.setOnClickListener {
            val origen = spinnerOrigen.selectedItem.toString()
            val destino = spinnerDestino.selectedItem.toString()
            val input = inputUser.text.toString()
            if (input.isBlank()) {
                Toast.makeText(activity, "Introduce una cantidad válida", Toast.LENGTH_SHORT).show()
            }

            val cantidad = input.toDouble()
            //Llamada a Peticiones, pasándole esta activity y clase como parámetros
            val peticion = Peticiones(activity, this)
            peticion.conversor(origen, destino, cantidad)
        }
        botonReset.setOnClickListener {
            resultadoConvertir.text = ""
            inputUser.text.clear()
            spinnerOrigen.setSelection(0)
            spinnerDestino.setSelection(0)
        }
        botonBannerConversor.setOnClickListener {
            Toast.makeText(activity, "Ya estás aquí", Toast.LENGTH_SHORT).show()
        }
        botonBannerHistorial.setOnClickListener {
            activity.setContentView(R.layout.historial)
            UIHistorial(activity)
        }

    }

    /*Método que es llamado por el conversor de peticiones, toma los datos, crea una tupla de
    Tuplahistorial y los añade al Singleton historial de ListaHistorial, por último muestra el resultado de la conversión*/
    fun mostrarCambio(valor: Double) {

        val origen = spinnerOrigen.selectedItem.toString()
        val destino = spinnerDestino.selectedItem.toString()
        val input = inputUser.text.toString()
        val cantidad = input.toDouble()
        val tupla: TuplaHistorial = TuplaHistorial(origen, destino, cantidad, valor)
        historial.add(tupla)
        resultadoConvertir.text = "${valor} ${Simbolos.mapaSimbolos[destino]}"

    }
}