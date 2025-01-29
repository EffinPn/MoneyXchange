package com.example.ae2_androidavanzado.api

import android.app.*
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import com.example.ae2_androidavanzado.interfaz.UI
import kotlinx.coroutines.*
import retrofit2.Retrofit
import retrofit2.Response
import retrofit2.converter.gson.GsonConverterFactory

//La clase que hará las consultas a la API, le paso activity porque la necesito para usar runOnuiThread
class Peticiones(private val activity: AppCompatActivity, private val ui: UI) {

    /*La APIKey. Utilicé ExchangeRate. Destacar que yo he usado sólo algunas monedas para este proyecto, pero tiene muchas más.*/
    private val key = ""

    //Configuración de Retrofit
    private fun getRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://api.exchangerate.host/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    //Método para hacer la solicitud de conversión, la API ofrece más posibilidades, pero para la app sólo hace falta este.
    fun conversor(monedaOrigen: String, monedaDestino: String, cantidad: Double) {
        //Inicio de la corrutina
        CoroutineScope(Dispatchers.IO).launch {
            //Llamamos al método convertir de la Interfaz
            val call = getRetrofit().create(APITasaCambios::class.java)
                .convertir(key, monedaOrigen, monedaDestino, cantidad)
            //Con body() sacamos la parte que nos interesa de la respuesta
            val respuesta = call.body()
            /*Como la respuesta de la API viene de un suspend fun (hilo secundario), no podemos actualizar la UI desde ese hilo,
            con esto volvemos al hilo principal y desde ahí actualizamos.*/
            activity.runOnUiThread {
                if (call.isSuccessful) {
                    //Obtención de respuesta, result viene del data class RespuestaCambio.
                    val cambio = respuesta?.result ?: 0.00
                    //Se lo pasamos a la UI.
                    ui.mostrarCambio(cambio)
                } else {
                    println("Error: ${call.errorBody()?.string()} ?: Error desconocido")
                }
            }
        }
    }
}

