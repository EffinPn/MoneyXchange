package com.example.ae2_androidavanzado.model

//Data class para manejar la respuesta dela API con RetroFit
data class TasaCambios(val success: Boolean, val source: String, val quotes: Map<String, Double>)
