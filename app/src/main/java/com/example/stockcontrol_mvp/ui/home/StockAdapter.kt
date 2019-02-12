package com.example.stockcontrol_mvp.ui.home

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.stockcontrol_mvp.R
import com.example.stockcontrol_mvp.model.StockData

class StockAdapter : RecyclerView.Adapter<StockAdapter.StockViewHolder>(){

    private val data =  arrayListOf<StockData>()
    fun setData(data: List<StockData>){
        this.data.clear()
        this.data.addAll(data)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StockAdapter.StockViewHolder {
        val rootView = LayoutInflater.from(parent.context).inflate(R.layout.item_activity, parent, false)
        return StockViewHolder(rootView)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(viewHolder: StockViewHolder, position: Int) {
        viewHolder.bind(data[position])
    }

    class StockViewHolder(private val rootView: View): RecyclerView.ViewHolder(rootView){

        fun bind(data: StockData){
            val tvSymbol = rootView.findViewById<TextView>(R.id.tvSymbol)
            tvSymbol.text=data.symbol
        }
    }



}