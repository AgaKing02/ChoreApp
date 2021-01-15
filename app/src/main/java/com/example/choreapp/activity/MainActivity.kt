package com.example.choreapp.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.choreapp.R
import com.example.choreapp.data.ChoreDatabaseHandler
import com.example.choreapp.model.Chore

class MainActivity : AppCompatActivity() {
    var dbHandler:ChoreDatabaseHandler?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        dbHandler= ChoreDatabaseHandler(this)
        var chore= Chore()
        chore.choreName="Clean Room"
        chore.assignedTo="James"
        chore.assignedBy="Carlos"

        dbHandler!!.createChore(chore)

        var chores:Chore=dbHandler!!.readChore(1)
        Log.d("Item:", chores.choreName!!)

    }
}