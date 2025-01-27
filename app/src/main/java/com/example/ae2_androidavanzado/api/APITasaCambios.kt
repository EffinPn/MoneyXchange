package com.example.ae2_androidavanzado.api

import com.example.ae2_androidavanzado.model.RespuestaCambio
import com.example.ae2_androidavanzado.model.TasaCambios
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query
import java.sql.Date

interface APITasaCambios {
    @GET("live")
    suspend fun getLive(): TasaCambios

        @GET("convert")
        suspend fun convertir(
            @Query("from") from: String,
            @Query("to") to: String,
            @Query("amount") amount: Double): Response<RespuestaCambio>

    @GET("historical")
    suspend fun historico(
        @Query("date") date: Date
    )

}