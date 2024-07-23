package com.example.unit_converter

import android.graphics.Color
import android.media.Image
import android.os.Bundle
import android.provider.MediaStore.Images
import android.provider.SyncStateContract.Columns
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.firebase.Firebase
import com.google.firebase.firestore.firestore
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {
    lateinit var containerRl:ConstraintLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        val fs = Firebase.firestore

        fs.collection("books").document().set(mapOf("name" to "My fav book"))
        }



}

