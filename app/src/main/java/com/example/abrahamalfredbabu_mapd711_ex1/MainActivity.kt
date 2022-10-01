package com.example.abrahamalfredbabu_mapd711_ex1

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.RadioButton
import android.widget.Spinner
import androidx.core.view.get
import com.example.abrahamalfredbabu_mapd711_ex1.databinding.ActivityMainBinding
import android.content.Intent as Intent1

class MainActivity : AppCompatActivity() {

    // declaration for binding
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //setting up view binding
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        // declaring all the required  variables
        var province: String = ""

        // Loading up the province spinner with data
        binding.provinceDropDown.adapter = ArrayAdapter.createFromResource(
            this,
            R.array.provinces_array,
            android.R.layout.simple_spinner_dropdown_item
        )

        //setting an item selected listener on the drop down (spinner)
        binding.provinceDropDown.onItemSelectedListener = object: AdapterView.OnItemSelectedListener{
            override fun onItemSelected(parent: AdapterView<*>, view: View?, pos: Int, id: Long) {
                province = binding.provinceDropDown.getItemAtPosition(pos).toString()
                println(province)
            }
            override fun onNothingSelected(parent: AdapterView<*>) {}
        }

        // Mapping action for send button
        binding.sendButton.setOnClickListener {

            //getting the selected radio button
            val selectedId = binding.qualificationRadioGroup.checkedRadioButtonId
            val selectedButton = findViewById<RadioButton>(selectedId)

            // creating new intent and loading data onto to navigate to new activity
            val newIntent = Intent1(this, ResultActivity::class.java).apply{
                putExtra("fullName", binding.fullNameTextBox.text.toString())
                putExtra("province", province)
                putExtra("qualification", selectedButton.text.toString())
                putExtra("hobby", binding.hobbyTextBox.text.toString())
                putExtra("dreamJob", binding.dreamJobTextBox.text.toString())
            }
            startActivity(newIntent)

        }

    }
}