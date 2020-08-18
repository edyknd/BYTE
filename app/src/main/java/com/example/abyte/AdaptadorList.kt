package com.example.abyte

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.abyte.models.Datos


class AdaptadorList(val items:ArrayList<Datos> ,val context:Context): RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_list, parent, false)
        return ItemHolder(itemView)
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val itemValue = items[position]
        (holder as ItemHolder).bind(itemValue, position)
    }



    inner class ItemHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        var txtfecha:TextView? = itemView.findViewById(R.id.txtfecha)
        var txtDescription: TextView? = itemView.findViewById(R.id.txtDescripcion)
        var txtmonto :TextView? = itemView.findViewById(R.id.txtmMonto)

        fun bind(item:Datos, position:Int){
            txtfecha?.text = item.date
            txtDescription?.text = item.description
            if (item.type!!.contentEquals("DEBIT"))
            {
                txtmonto?.text = "$ - ${item.amount}"
                txtmonto?.setTextColor(ContextCompat.getColor(context,R.color.debit))
            }else {
                txtmonto?.text = "$ ${item.amount}"
                txtmonto?.setTextColor(ContextCompat.getColor(context,R.color.credit))
            }

        }
    }
}