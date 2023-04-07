package com.arvioj.threads

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }

    override fun onResume() {
        super.onResume()
        val txtCount = findViewById<TextView>(R.id.textView2)
        /*
        Thread {
           while (true) {
               for (x in 1..10) {
                   runOnUiThread { txtCount.text = x.toString() }
                   Thread.sleep(1000)
               }
           }
        }.start()
    }
    */
        Toast.makeText(this, "Iniciando cuenta...",Toast.LENGTH_SHORT).show()
        object : CountDownTimer(10000, 1000) {
            override fun onTick(millisUntilFinished: Long) {
                txtCount.text = ("Second remaining: " + millisUntilFinished / 1000)
            }

            override fun onFinish() {
                txtCount.text = "Done!"
                Toast.makeText(this@MainActivity, "Cuenta terminada...",Toast.LENGTH_SHORT).show()
            }
        }.start()
    }
}