package com.example.stockcontrol_mvp.ui.home

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.widget.Toast
import com.example.stockcontrol_mvp.App
import com.example.stockcontrol_mvp.R
import com.example.stockcontrol_mvp.model.StockData
import com.example.stockcontrol_mvp.ui.home.di.DaggerHomeComponent
import com.example.stockcontrol_mvp.ui.home.di.HomeModule
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class MainActivity : AppCompatActivity(), HomeContract.View {

    private val stockAdapter = StockAdapter()
    @Inject
    lateinit var homePresenter: HomeContract.Presenter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        DaggerHomeComponent.builder()
            .appComponent((application as App).getComponent())
            .homeModule(HomeModule(this))
            .build()
            .inject(this)

        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = stockAdapter

        btnGainers.setOnClickListener {
            homePresenter.getStockDetails(symbol = String())
        }


        btnGoQuote.setOnClickListener{
            val intent = Intent(this, SecondActivity::class.java)
            startActivity(intent)
        }

    }

    override fun showResults(result: List<StockData>) {
        stockAdapter.setData(result)
    }

    override fun showError(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show()

    }




     /*       btnStartAnotherActivity.setOnClickListener {
            val intent = Intent(this, AnotherActivity::class.java)
            // start your next activity
            startActivity(intent)
        }

}*/

}
