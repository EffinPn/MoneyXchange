    package com.example.ae2_androidavanzado.interfaz

    import android.widget.Button
    import android.widget.Toast
    import androidx.appcompat.app.AppCompatActivity
    import androidx.recyclerview.widget.LinearLayoutManager
    import androidx.recyclerview.widget.RecyclerView
    import com.example.ae2_androidavanzado.R
    import com.example.ae2_androidavanzado.model.TuplaHistorial

    class UIHistorial(private val activity: AppCompatActivity, private val historial: MutableList<TuplaHistorial>) {

        val botonBH: Button = activity.findViewById(R.id.botonHistoriahst)
        val botonBC: Button = activity.findViewById(R.id.convertirBannercnv)
        val recycler: RecyclerView = activity.findViewById(R.id.recycler)

        init {

            botonesHistorial()
            configurarRecycler()
        }

        fun botonesHistorial() {
            botonBC.setOnClickListener {
                activity.setContentView(R.layout.activity_main)
                UI(activity)
            }
            botonBH.setOnClickListener {
                Toast.makeText(activity, "Ya estás aquí", Toast.LENGTH_SHORT).show()
            }
        }

        fun configurarRecycler(){
            recycler.adapter = HistorialAdapter(historial)
            recycler.layoutManager = LinearLayoutManager(activity)

        }

    }