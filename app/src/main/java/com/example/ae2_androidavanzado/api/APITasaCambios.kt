package com.example.ae2_androidavanzado.api

import com.example.ae2_androidavanzado.model.RespuestaCambio
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query
import java.sql.Date

//Esta interfaz es la que usará retrofit para construir las queries.
interface APITasaCambios {

    @GET("convert")
    suspend fun convertir(
        @Query("access_key") key: String,
        @Query("from") from: String,
        @Query("to") to: String,
        @Query("amount") amount: Double
    ): Response<RespuestaCambio>
    /*Sería como poner en el navegador
    https://api.exchangerate.host/convert?access_key=KEY&from=EUR&to=GBP&amount=100
    Sólo queda cambiar los valores para efectuar la consulta.
     */




    //Métodos que corresponderían a otros endpoints, pero que no he necesitado en la app. Los dejo porque no descarto mejorarla en el futuro.

    /* @GET("historical")
     suspend fun historico(
         @Query("date") date: Date
     )

         @GET("live")
     suspend fun getLive(): TasaCambios*/

}