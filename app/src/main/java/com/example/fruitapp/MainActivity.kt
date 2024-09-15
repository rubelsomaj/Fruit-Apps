package com.example.fruitapp

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.fruitapp.databinding.ActivityMainBinding
import com.example.fruitapp.FruitAdapter.MyViewHolder
import com.example.fruitapp.databinding.AddFruitLayoutBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding=ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.fruitRv.layoutManager=LinearLayoutManager(this)
        val fruit = ArrayList<Fruit>()

        fruit.add(Fruit("Apple",5,250.00,R.drawable.apple,"very good test"))
        fruit.add(Fruit("Banana",10,50.00,R.drawable.banana," good test"))
        fruit.add(Fruit("pineapple",5,60.00,R.drawable.r," good test"))
        fruit.add(Fruit("mango",41,550.00,R.drawable.mango," good test"))
        fruit.add(Fruit("orange",909,30.00,R.drawable.o," good test"))
        fruit.add(Fruit("ab",31,70.00, R.drawable.n," good test"))
        fruit.add(Fruit("pp",21,5550.00,R.drawable.piyara," good test"))
        fruit.add(Fruit("nk",5,5220.00,R.drawable.pp," good test"))
        fruit.add(Fruit("R",120,90.00,R.drawable.r," good test"))
        fruit.add(Fruit("K",0,30.00,R.drawable.m," good test"))
        fruit.add(Fruit("L",88,560.00,R.drawable.add," good test"))
        fruit.add(Fruit("M",56,230.00,R.drawable.banana," good test"))
        fruit.add(Fruit("N",12,40.00,R.drawable.i," good test"))
        fruit.add(Fruit("o",106,80.00,R.drawable.lichi," good test"))
        fruit.add(Fruit("P",120,890.00,R.drawable.k," good test"))
        fruit.add(Fruit("Q",17,50.00,R.drawable.o," good test"))
        fruit.add(Fruit("W",13,690.00,R.drawable.apple," good test"))
        fruit.add(Fruit("s",19,50.00,R.drawable.pp," good test"))
        fruit.add(Fruit("Z",11,90.00,R.drawable.n," good test"))

        var fruitAdapter = FruitAdapter(fruit)
        binding.fruitRv.adapter = fruitAdapter
        fruitAdapter.onClick= {
            val intent = Intent(this, DetailActivity::class.java)
            intent.putExtra("name", it.frutName)
            intent.putExtra("Price", it.fruitPrice)
            intent.putExtra("quantity", it.fruitQnt)
            intent.putExtra("desc", it.fruitDesc)
            intent.putExtra("image", it.fruitImg)
            startActivity(intent)
        }

            binding.addBtn.setOnClickListener {
               showFruitAddDialog()

            }

    }

    private fun showFruitAddDialog() {
        val dialogView = AddFruitLayoutBinding.inflate(layoutInflater)
        AlertDialog.Builder(this)
            .setTitle("Add Fruit")
            .setView(dialogView.root)
            .setPositiveButton("Add"){_,_ ->
                val name = dialogView.fruitNameEt.text.toString()



            }

    }


}
