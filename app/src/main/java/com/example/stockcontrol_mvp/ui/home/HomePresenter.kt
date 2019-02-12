package com.example.stockcontrol_mvp.ui.home

import com.example.stockcontrol_mvp.model.StockData
import com.example.stockcontrol_mvp.network.stockService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HomePresenter(
    private val stockService: stockService,
    private val view: HomeContract.View
) : HomeContract.Presenter {


    override fun getStockDetails(symbol: String) {
        stockService.getStockDetails("").enqueue(object : Callback<List<StockData>> {


            override fun onFailure(call: Call<List<StockData>>, t: Throwable) {
                view.showError("Please try again")
            }

            override fun onResponse(call: Call<List<StockData>>, response: Response<List<StockData>>) {
                if (response.isSuccessful) {
                    view.showResults(response.body() ?: emptyList())
                } else {
                    view.showError("An unknown error occur")
                }


            }

        })
    }

}