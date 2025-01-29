    package com.example.ae2_androidavanzado.interfaz

    import android.widget.Button
    import android.widget.Toast
    import androidx.appcompat.app.AppCompatActivity
    import androidx.recyclerview.widget.LinearLayoutManager
    import androidx.recyclerview.widget.RecyclerView
    import com.example.ae2_androidavanzado.R
    import com.example.ae2_androidavanzado.model.ListaHistorial.historial
    import com.example.ae2_androidavanzado.model.TuplaHistorial

    class UIHistorial(private val activity: AppCompatActivity) {

        //Enlazamos las variables con los elementos del XML
        val botonBH: Button = activity.findViewById(R.id.botonHistoriahst)
        val botonBC: Button = activity.findViewById(R.id.convertirBannercnv)
        val recycler: RecyclerView = activity.findViewById(R.id.recycler)

        //init para ejecutar estos métodos en cuanto se abra la app
        init {
            botonesHistorial()
            configurarRecycler()
        }

        //Método que prepara los listeners, estos botones son para cambiar de pantalla.
        fun botonesHistorial() {
            botonBC.setOnClickListener {
                activity.setContentView(R.layout.activity_main)
                UI(activity)
            }
            botonBH.setOnClickListener {
                Toast.makeText(activity, "Ya estás aquí", Toast.LENGTH_SHORT).show()
            }
        }

        //Configuramos el recycler con el adapter, pasándole ListaHistorial.historial, y le decimos qué layout va a usar.
        fun configurarRecycler(){
            recycler.adapter = HistorialAdapter(historial)
            recycler.layoutManager = LinearLayoutManager(activity)

        }

    }