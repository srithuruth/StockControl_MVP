package com.example.stockcontrol_mvp.ui.home.di

import com.example.stockcontrol_mvp.network.stockService
import com.example.stockcontrol_mvp.ui.home.HomeContract
import com.example.stockcontrol_mvp.ui.home.HomePresenter
import dagger.Module
import dagger.Provides

@Module
class HomeModule(private val view: HomeContract.View){

    @HomeScope
    @Provides
    fun provideHomePresenter(stockService: stockService)
    : HomeContract.Presenter{
        return HomePresenter(stockService, view)
    }
}