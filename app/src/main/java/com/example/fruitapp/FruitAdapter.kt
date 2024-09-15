package com.example.fruitapp

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.RecyclerView
import com.example.fruitapp.databinding.FruitItemBinding

class FruitAdapter(private val frutList: ArrayList<Fruit>) :
    RecyclerView.Adapter<FruitAdapter.MyViewHolder>() {
    var onClick: ((Fruit) -> Unit)? = null

    class MyViewHolder(val binding: FruitItemBinding) : RecyclerView.ViewHolder(binding.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {

        val view = FruitItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MyViewHolder(view)
    }

    override fun getItemCount(): Int {
        return frutList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.binding.apply {
            fruitName.text = frutList[position].frutName
            fruitQnt.text = "Quntity:" + frutList[position].fruitQnt.toString()
            fruitPrice.text = "Price:$" + frutList[position].fruitPrice.toString()
            fruitImg.setImageResource(frutList[position].fruitImg)

        }

        holder.itemView.setOnClickListener {
            onClick?.invoke(frutList[position])


        }

        holder.itemView.setOnClickListener {
            AlertDialog.Builder(holder.itemView.context)
                .setTitle("Delete Fruit item")
                .setMessage("Are you sure you want to delete this item")
            frutList.removeAt(position)
            notifyItemRemoved(position)




        }
    }
}