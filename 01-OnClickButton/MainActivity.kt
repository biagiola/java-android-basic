package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.method.ScrollingMovementMethod
import android.util.Log
import android.view.View
import android.widget.EditText
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private var userInput: EditText? = null
    private var textView: TextView? = null
    private var button: Button? = null
    private val TEXT_CONTENTS = "TextContents"

    override fun onCreate(savedInstanceState: Bundle?) {

        Log.d(TAG, "onCreate: in")

        super.onCreate(savedInstanceState)
        setContentView(R.layout.note_layout)

        userInput = findViewById(R.id.editText)
        textView = findViewById(R.id.textView)
        button = findViewById(R.id.addButton)

        userInput!!.setText("")
        textView!!.text = ""
        textView!!.movementMethod = ScrollingMovementMethod()

        val ourOnClickListener = View.OnClickListener {
            var result = userInput!!.text.toString()
            result = result + "\n"
            textView!!.append(result)
            userInput!!.setText("")
        }
        button!!.setOnClickListener(ourOnClickListener)

        Log.d(TAG, "onCreate: out")

    }

    override fun onStart() {
        Log.d(TAG, "onStart: in")
        super.onStart()
        Log.d(TAG, "onStart: out")
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        Log.d(TAG, "onRestoreInstanceState: in")
        super.onRestoreInstanceState(savedInstanceState)

        //we retrieve the value that was store in the bundle for our text context
        val savedString = savedInstanceState.getString(TEXT_CONTENTS)
        textView!!.text = savedString
        Log.d(TAG, "onRestoreInstanceState: out")
    }

    override fun onRestart() {
        Log.d(TAG, "onRestart: in")
        super.onRestart()
        Log.d(TAG, "onRestart: out")
    }

    override fun onSaveInstanceState(outState: Bundle) {
        Log.d(TAG, "onSaveInstanceState: in")
        //saving the current value of the text video into the bundle
        outState.putString(TEXT_CONTENTS, textView!!.text.toString())
        super.onSaveInstanceState(outState)
        Log.d(TAG, "onSaveInstanceState: out")
    }

    override fun onPause() {
        Log.d(TAG, "onPause: in")
        super.onPause()
        Log.d(TAG, "onPause: out")
    }

    override fun onResume() {
        Log.d(TAG, "onResume: in")
        super.onResume()
        Log.d(TAG, "onResume: out")
    }

    override fun onStop() {
        Log.d(TAG, "onStop: in")
        super.onStop()
        Log.d(TAG, "onStop: out")
    }

    companion object {
        private val TAG = "MainActivity"
    }
}

