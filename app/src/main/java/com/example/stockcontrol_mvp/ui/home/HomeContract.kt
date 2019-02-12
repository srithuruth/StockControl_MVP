package com.example.stockcontrol_mvp.ui.home

import com.example.stockcontrol_mvp.model.StockData

interface HomeContract{


    interface View{
        fun showResults(result: List<StockData>)
        fun showError(message: String)
    }

    interface Presenter{
        fun getStockDetails(symbol: String)
    }
}