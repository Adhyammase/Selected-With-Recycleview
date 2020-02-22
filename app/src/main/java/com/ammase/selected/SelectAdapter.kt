package com.ammase.selected

import android.content.Context
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_list.view.*

class SelectAdapter (val items: List<SelectModel>, val mContext: Context) :
    RecyclerView.Adapter<SelectAdapter.ViewHolder>(){

    var activePosition = -1

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(mContext).inflate(R.layout.item_list, parent, false))
    }

    override fun getItemCount() = items.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindUI(items[position])

        holder.btn_layout.setOnClickListener {
            val tempActive = activePosition
            if(tempActive == position){
                activePosition = -1
                notifyItemChanged(position)
            }else{
                if(tempActive != -1) notifyItemChanged(tempActive)
                activePosition = position
                notifyItemChanged(position)
            }

            toast(items[position].name)
        }

        if (activePosition == position) {
            holder.btn_layout.setBackgroundColor(Color.parseColor("#F9BEA5"))
        } else {
            holder.btn_layout.setBackgroundColor(Color.parseColor("#F2ECFF"))
        }

    }

    inner class ViewHolder (view: View) : RecyclerView.ViewHolder(view) {
        val btn_layout: LinearLayout = view.layout_select
        fun bindUI(data: SelectModel) = with(itemView) {
            text_select.text = data.name

        }

    }


    fun toast(message: String) {
        Toast.makeText(mContext, message, Toast.LENGTH_SHORT).show()
    }

}