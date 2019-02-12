package com.example.stockcontrol_mvp.ui.home.di

import com.example.stockcontrol_mvp.di.AppComponent
import com.example.stockcontrol_mvp.ui.home.MainActivity
import dagger.Component

@Component(dependencies = [AppComponent::class], modules = [HomeModule::class])
@HomeScope
interface HomeComponent {
    fun inject(mainActivity: MainActivity)
}