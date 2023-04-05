package com.example.testvisible

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.View.VISIBLE
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.core.view.isVisible
import kotlin.system.measureTimeMillis

class MainActivity : AppCompatActivity(R.layout.activity_main) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val text = findViewById<View>(R.id.textView)
        val withCheckButton = findViewById<View>(R.id.button)
        val withoutCheckButton = findViewById<View>(R.id.button2)

        withCheckButton.setOnClickListener {
            val time = measureTimeMillis {
                repeat(LIMIT) {
                    if (!text.isVisible) {
                        text.visibility = VISIBLE
                    }
                }
            }
            showMessage(timeCount = time)
        }

        withoutCheckButton.setOnClickListener {
            val time = measureTimeMillis {
                repeat(LIMIT) {
                    text.visibility = VISIBLE
                }
            }
            showMessage(timeCount = time)
        }
    }

    private fun showMessage(timeCount: Long) {
        Toast.makeText(this, "Заняло времени: $timeCount", Toast.LENGTH_SHORT).show()
    }

    companion object {
        const val LIMIT = 1_000_000
    }
}