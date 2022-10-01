package com.example.abrahamalfredbabu_mapd711_ex1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import com.example.abrahamalfredbabu_mapd711_ex1.databinding.ActivityMainBinding
import com.example.abrahamalfredbabu_mapd711_ex1.databinding.ActivityResultBinding

class ResultActivity : AppCompatActivity() {

    private lateinit var binding: ActivityResultBinding

    var color = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        binding = ActivityResultBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.fullNameResult.text = intent.getStringExtra("fullName")
        binding.provinceResult.text = intent.getStringExtra("province")
        binding.qualificationResult.text = intent.getStringExtra("qualification")
        binding.hobbyResult.text = intent.getStringExtra("hobby")
        binding.dreamJobResult.text = intent.getStringExtra("dreamJob")
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.activity_result_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(item.itemId == R.id.settings){
            if(!color) {
                binding.fullNameResult.setTextColor(getColor(R.color.deep_sea))
                binding.provinceResult.setTextColor(getColor(R.color.vibrant_red))
                binding.qualificationResult.setTextColor(getColor(R.color.orange_orange))
                binding.hobbyResult.setTextColor(getColor(R.color.mango_orange))
                binding.dreamJobResult.setTextColor(getColor(R.color.quartz_beige))
                color = true
            }else {
                binding.fullNameResult.setTextColor(getColor(R.color.black))
                binding.provinceResult.setTextColor(getColor(R.color.black))
                binding.qualificationResult.setTextColor(getColor(R.color.black))
                binding.hobbyResult.setTextColor(getColor(R.color.black))
                binding.dreamJobResult.setTextColor(getColor(R.color.black))
                color = false
            }
        }
        return true
    }
}