package br.com.raynerweb.viewpagerexample

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.widget.AppCompatButton
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Adapter

class ViewAdapter(val texts: List<String>) :
    Adapter<ViewAdapter.MyViewHolder>() {

    var collapsed = false;

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.view_page, parent, false)
        return MyViewHolder(view)
    }

    override fun getItemCount(): Int = texts.size

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(text = texts[position])
    }

    inner class MyViewHolder(itemView: View) :
        RecyclerView.ViewHolder(itemView) {
        val big: TextView = itemView.findViewById(R.id.big)
        val small: TextView = itemView.findViewById(R.id.small)
        val button: AppCompatButton = itemView.findViewById(R.id.btn_toggle)


        fun bind(text: String) {
            big.text = text
            small.text = text

            if (!collapsed) {
                big.visibility = View.VISIBLE
                small.visibility = View.GONE
            } else {
                small.visibility = View.VISIBLE
                big.visibility = View.GONE
            }
            button.setOnClickListener {
                collapsed = !collapsed
                notifyDataSetChanged()
            }
        }

    }

}

