package com.example.helloworld

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    /*
     * savedInstanceState: avoid loose application state on screen rotation,
     * when app is sent to background, or screen is redraw
     * Bundle: previous state, if captured
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        //super inherit method from AppCompatActivity
        super.onCreate(savedInstanceState)
        // link Kotlin with layout
        // R: res directory
        // layout: layout directory
        // activity_main: xml layout file
        setContentView(R.layout.activity_main)

        // log info
        Log.i("lifeCycle", "1. onCreate")

        // Change text value
        val btnClickMe: Button = findViewById<Button>(R.id.button_click_me)
        val edtName: EditText = findViewById<EditText>(R.id.edit_name)
        val txvResult: TextView = findViewById(R.id.text_view_result)

        btnClickMe.setOnClickListener {
            val name: String = edtName.editableText.toString()
            txvResult.text = name
        }

        // Open other activities
        val btnOpenSite: Button = findViewById<Button>(R.id.open_site)
        val btnNextActivity: Button = findViewById<Button>(R.id.open_next_activity)

        btnOpenSite.setOnClickListener {
            val i = Intent(Intent.ACTION_VIEW, Uri.parse(
                    "http://dmenezesgabriel.github.io"))
            startActivity(i)
        }

        btnNextActivity.setOnClickListener {
            var i = Intent(this, NextActivity::class.java)
            startActivity(i)
        }
    }

    override fun onStart() {
        super.onStart()
        Log.i("lifeCycle", "2. onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.i("lifeCycle", "3. onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.i("lifeCycle", "4. onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.i("lifeCycle", "5. onStop")
    }

    override fun onRestart() {
        super.onRestart()
        Log.i("lifeCycle", "6. onRestart")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i("lifeCycle", "7. onDestroy")
        Log.i("lifecycle", "isFinishing: $isFinishing")
    }

    fun handleClickMe(view: View) {
        /*
        Defined at xml, have less priority than event listener, so will not be activated.
         */
        Toast.makeText(this, "Clicked", Toast.LENGTH_SHORT).show()
    }
}