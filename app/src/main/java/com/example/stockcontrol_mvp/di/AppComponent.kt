package com.example.stockcontrol_mvp.di

import com.example.stockcontrol_mvp.network.stockService
import dagger.Component
import javax.inject.Singleton


@Component(modules = [NetworkModule::class])
@Singleton
interface AppComponent {
    fun stockService(): stockService
}