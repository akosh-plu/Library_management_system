package com.example.unit_converter

import android.graphics.Color
import android.media.Image
import android.os.Bundle
import android.provider.MediaStore.Images
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    lateinit var containerRl:ConstraintLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        containerRl = findViewById(R.id.main)

            val btn : Button = findViewById(R.id.button)
            btn.setOnClickListener(){
                containerRl.background  = resources.getDrawable(R.drawable.ca2)
            }
        }

}

