package com.melikearikan.kelimelendik

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.view.View
import kotlinx.android.synthetic.main.activity_kelimelendik2.*

class kelimelendik2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_kelimelendik2)

        var intent = intent
        var alinanVeri = intent.getStringExtra("kullanici")
        textView2.text= "hoş geldin,${alinanVeri}"

        object : CountDownTimer(10000,1000){
            override fun onTick(p0: Long) {
                textView4.text= "kalan süre: ${p0 /1000}"
            }

            override fun onFinish() {
                textView4.text = "sisteme hoş geldiniz <3"
            }

        }.start()
    }
    fun cikis(view: View){
        var intent2 = Intent(applicationContext,MainActivity::class.java)
        startActivity(intent2)
    }

}