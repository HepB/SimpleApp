package com.github.hepb.simpleapp.ui

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.RecyclerView
import com.github.hepb.simpleapp.R
import kotlinx.android.synthetic.main.activity_main.detailsList

class MainActivity : AppCompatActivity() {

    private lateinit var objectsRecycler: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        objectsRecycler = detailsList
    }
}
