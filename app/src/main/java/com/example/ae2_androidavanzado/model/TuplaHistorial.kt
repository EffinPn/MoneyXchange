package com.example.ae2_androidavanzado.model

//Objeto que representa cada conversión hecha
data class TuplaHistorial(val monedaOrigen: String,
                          val monedaDestino: String,
                          val cantidadOrigen: Double,
                          val cantidadDestino: Double){}
