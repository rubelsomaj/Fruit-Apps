package com.example.fruitapp

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.fruitapp.databinding.ActivityDetailBinding

class DetailActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding=ActivityDetailBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val name = intent.getStringExtra("name")
        val price = intent.getDoubleExtra("Price",23.0)
        val qnt = intent.getIntExtra("quantity",0)
        val img = intent.getIntExtra("image",22)
        val desc= intent.getStringExtra("desc")

        binding.apply {

            fruitName.text = name
            fruitPrice.text =  "Price:" +price.toString()
            fruitQnt.text ="quntity:" + qnt.toString()
            fruitImg.setImageResource(img)
            fruitDesc.text= desc
        }

    }
}