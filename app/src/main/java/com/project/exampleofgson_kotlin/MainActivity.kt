package com.project.exampleofgson_kotlin

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.gson.Gson
import com.project.exampleofgson_kotlin.databinding.ActivityMainBinding
import java.lang.StringBuilder

class MainActivity : AppCompatActivity() {

    val TAG = "MainActivity"
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.button.setOnClickListener {


            val gson = Gson()

            val employee1 = Employee("Dicky", "211", "DickyAlifya@hahay.com")
            val json = gson.toJson(employee1)
            binding.stringData1.text = StringBuilder("Json String").append(json)

            val jsonString = "{\"mAge\":\"211\",\"mEmail\":\"DickyAlifya@hahay.com\",\"mFirstName\":\"Dicky\"}"
            val employee2 = gson.fromJson(jsonString, Employee::class.java)
            binding.stringData2.text = StringBuilder(" Employee: " + employee2.mFirstName + " Age " + employee2.mAge + " Email " + employee2.mEmail)

        }

    }
}