package com.example.choreapp.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import android.widget.Button
import android.widget.TextView
import com.example.choreapp.R
import com.example.choreapp.data.ChoreDatabaseHandler
import com.example.choreapp.model.Chore

class MainActivity : AppCompatActivity() {
    var dbHandler: ChoreDatabaseHandler? = null
    var enterChore: TextView? = null;
    var assignedBy: TextView? = null;
    var assignedTo: TextView? = null;
    var saveAChore: Button? = null;


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        enterChore = findViewById(R.id.editTextTextPersonName) as TextView
        assignedBy = findViewById(R.id.assignedBy) as TextView
        assignedTo = findViewById(R.id.assignedTo) as TextView
        saveAChore = findViewById(R.id.saveChore) as Button



        dbHandler = ChoreDatabaseHandler(this)

        saveAChore!!.setOnClickListener {
            if (!TextUtils.isEmpty(enterChore!!.text.toString()) &&
                !TextUtils.isEmpty(assignedBy!!.text.toString()) &&
                !TextUtils.isEmpty(assignedTo!!.text.toString())
            ) {
                var chore = Chore()
                chore.choreName = enterChore!!.text.toString()
                chore.assignedTo = assignedTo!!.text.toString()
                chore.assignedBy = assignedTo!!.text.toString()

                dbHandler!!.createChore(chore)
                Log.d("Created after typing", chore.choreName!!)

//                var chores: Chore = dbHandler!!.readChore(1)
//                Log.d("Item:", chores.choreName!!)

            }
        }


    }
}