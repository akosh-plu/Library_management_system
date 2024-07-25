package com.example.unit_converter

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.google.firebase.Firebase
import com.google.firebase.firestore.firestore


@Composable
fun Mainscreen(){
    val fs = Firebase.firestore
    val list = remember {
        mutableStateOf(emptyList<Books>())
    }
    fs.collection("books").addSnapshotListener{ snapShot, exception ->

        list.value = snapShot?.toObjects(Books::class.java) ?: emptyList()


    }

    Column (
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.SpaceBetween

    )
    {
        LazyColumn(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.8f)
        ) {
            items(list.value) { book ->
                Card(modifier = Modifier
                    .fillMaxSize()
                    .padding(10.dp)) {
                    Text(text = "books",
                        modifier = Modifier.fillMaxSize().wrapContentWidth())
                }
            }
        }
        Spacer(modifier = Modifier.height(10.dp))
        Button(
            modifier = Modifier
                .fillMaxWidth()
                .padding(50.dp),

            colors = ButtonDefaults.outlinedButtonColors() ,
            onClick = {

                fs.collection("books")
                    .document().set(
                        Books(
                            "TestBook",
                            "A very first test book",
                            "5000tg",
                            "Not given",
                            "none url"
                        )
                    )
            }) {
            Text(text = "Add book")
        }
    }
}