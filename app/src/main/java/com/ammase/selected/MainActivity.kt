package com.ammase.selected

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val list = listOf(
            SelectModel (1, "Kotlin"),
            SelectModel (1, "Java"),
            SelectModel (1, "Flutter"),
            SelectModel (1, "Python"),
            SelectModel (1, "Golan"),
            SelectModel (1, "Php")
        )

        val mainAd = SelectAdapter(list, this)

        recyclerView.apply {
            layoutManager = GridLayoutManager(context, 2)
            adapter = mainAd
        }
    }
}
