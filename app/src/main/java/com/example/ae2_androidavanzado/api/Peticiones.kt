package com.example.ae2_androidavanzado.api

import android.app.*
import android.content.Context
import com.example.ae2_androidavanzado.interfaz.UI
import kotlinx.coroutines.*
import retrofit2.Retrofit
import retrofit2.Response
import retrofit2.converter.gson.GsonConverterFactory

class Peticiones(private val context: Context) {

    private val key = "c303c7c45d42e298654681dcfaf563f8"

    private fun getRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://api.exchangerate.host/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    fun conversor(monedaOrigen: String, monedaDestino: String, cantidad: Double) {

        CoroutineScope(Dispatchers.IO).launch {
            val call = getRetrofit().create(APITasaCambios::class.java).convertir(key, monedaOrigen, monedaDestino, cantidad)
            val respuesta = call.body()
            (context as? Activity)?.runOnUiThread {
                if (call.isSuccessful) {
                    val cambio = respuesta?.result ?: 0.00
                    val ui = UI(context as Activity)
                    ui.mostrarCambio(cambio)
                } else {
                    println("Error")
                }
            }
        }
    }


}