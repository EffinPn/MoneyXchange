package com.example.ae2_androidavanzado.interfaz

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.ae2_androidavanzado.R
import com.example.ae2_androidavanzado.model.Simbolos
import com.example.ae2_androidavanzado.model.TuplaHistorial

class HistorialAdapter(private val historial: List<TuplaHistorial>) :
    RecyclerView.Adapter<HistorialAdapter.HistorialViewHolder>() {

    /* Enlazamos las variables con los elementos del XML, en este caso tuplas_historial,
    donde cada variable es un textview con datos.
     */
    class HistorialViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val monedaOrigenDestino: TextView = itemView.findViewById(R.id.monedaOrigenDestino)
        val cantidadOrigen: TextView = itemView.findViewById(R.id.cantidadOrigen)
        val cantidadDestino: TextView = itemView.findViewById(R.id.cantidadDestino)
    }

    // Inflamos el diseño de cada fila, con esto enlazamos el XML que da el formato con el recycler.
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HistorialViewHolder {
        val vista = LayoutInflater.from(parent.context)
            .inflate(R.layout.tuplas_historial, parent, false)
        return HistorialViewHolder(vista)
    }

    // Rellenamos los datos de cada fila con un elemento de historial.
    override fun onBindViewHolder(holder: HistorialViewHolder, position: Int) {
        val item = historial[position]
        holder.monedaOrigenDestino.text = "${item.monedaOrigen} -> ${item.monedaDestino}"
        holder.cantidadOrigen.text = "Cantidad inicial: ${item.cantidadOrigen} ${Simbolos.mapaSimbolos[item.monedaOrigen]}"
        holder.cantidadDestino.text = "Convertido a: ${item.cantidadDestino} ${Simbolos.mapaSimbolos[item.monedaDestino]}"
    }

    // Cantidad total de elementos
    override fun getItemCount(): Int {
        return historial.size
    }
}
