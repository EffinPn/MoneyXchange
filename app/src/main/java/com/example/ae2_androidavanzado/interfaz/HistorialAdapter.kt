package com.example.ae2_androidavanzado.interfaz

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.ae2_androidavanzado.R
import com.example.ae2_androidavanzado.model.TuplaHistorial

class HistorialAdapter(private val historial: List<TuplaHistorial>) :
    RecyclerView.Adapter<HistorialAdapter.HistorialViewHolder>() {

    // ViewHolder que maneja las vistas de cada fila
    class HistorialViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val monedaOrigenDestino: TextView = itemView.findViewById(R.id.monedaOrigenDestino)
        val cantidadOrigen: TextView = itemView.findViewById(R.id.cantidadOrigen)
        val cantidadDestino: TextView = itemView.findViewById(R.id.cantidadDestino)
    }

    // Inflamos el diseño de cada fila
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HistorialViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.tuplas_historial, parent, false)
        return HistorialViewHolder(view)
    }

    // Rellenamos los datos de cada fila
    override fun onBindViewHolder(holder: HistorialViewHolder, position: Int) {
        val item = historial[position]
        holder.monedaOrigenDestino.text = "${item.monedaOrigen} -> ${item.monedaDestino}"
        holder.cantidadOrigen.text = "Cantidad Origen: ${item.cantidadOrigen}"
        holder.cantidadDestino.text = "Cantidad Destino: ${item.cantidadDestino}"
    }

    // Cantidad total de elementos
    override fun getItemCount(): Int {
        return historial.size
    }
}
