package com.example.ae2_androidavanzado.model

//Este objeto lo he tenido que crear para mantener la lista entre pantallas y que no se borrara al cambiar de una a otra.
object ListaHistorial {
    val historial = mutableListOf<TuplaHistorial>()
}