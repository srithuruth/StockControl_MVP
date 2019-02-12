package com.example.stockcontrol_mvp.network

import com.example.stockcontrol_mvp.model.StockData
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path


interface stockService{
    @GET(END_POINT)

    fun getStockDetails(@Path("symbol")symbol: String): Call<List<StockData>>
}