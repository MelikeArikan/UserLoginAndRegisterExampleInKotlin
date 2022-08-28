package com.melikearikan.kelimelendik

import android.app.ProgressDialog
import android.content.Context
import android.content.DialogInterface
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.os.CountDownTimer
import android.os.SystemClock
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import java.util.concurrent.TimeUnit


class MainActivity : AppCompatActivity() {

    lateinit var sharedPreferences: SharedPreferences
    var kullaniciAdi ="melike"
    var kullaniciŞifre="hakan"
    var sayac = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        sharedPreferences = this.getSharedPreferences("com.melikearikan.kelimelendik", Context.MODE_PRIVATE)
        sharedPreferences.edit().putString("saklananAd",kullaniciAdi).apply()
        var kullaniciKaydedilen = sharedPreferences.getString("saklananAd","")
        if (kullaniciKaydedilen != null)
            Toast.makeText(this@MainActivity,"hoşgeldin ${kullaniciKaydedilen}",Toast.LENGTH_SHORT).show()
        else
            Toast.makeText(this,"hoş geldiniz.",Toast.LENGTH_LONG).show()
    }
    fun girisYapiniz(view:View) {

        var girilenİsim = editText.text.toString()
        var girilenSifre = editTextPassword.text.toString()

        if (editText.text.length == 0 && girilenSifre != "") {
            Toast.makeText(this, "lütfen kullanıcı adınızı giriniz.", Toast.LENGTH_SHORT).show()
        } else if (girilenSifre == "" && editText.text.length != 0) {
            Toast.makeText(this, "lütfen şifrenizi giriniz.", Toast.LENGTH_SHORT).show()
        } else if (girilenSifre == "" && girilenİsim == "") {
            Toast.makeText(
                this,
                "lütfen kullanıcı adınızı ve şifrenizi giriniz.",
                Toast.LENGTH_SHORT
            ).show()
        } else if (girilenİsim != "" && girilenSifre != "") {

            if (girilenİsim == kullaniciAdi && girilenSifre != kullaniciŞifre) {
                var isimSifreUyari = AlertDialog.Builder(this)
                isimSifreUyari.setTitle("şifrenizi yanlış girdiniz!")
                isimSifreUyari.setMessage("giriş yapabilmek için şifrenizi doğru girmelisiniz.tekrardan denemek ister misiniz?")
                isimSifreUyari.setPositiveButton(
                    "evet",
                    DialogInterface.OnClickListener { dialogInterface, i -> })
                isimSifreUyari.setNegativeButton(
                    "hayır",
                    DialogInterface.OnClickListener { dialogInterface, i -> })
                isimSifreUyari.show()
                editText.setText("")
                editTextPassword.setText("")
                sayac++
            } else if (girilenİsim != kullaniciAdi && girilenSifre == kullaniciŞifre) {
                var isimSifreUyari = AlertDialog.Builder(this)
                isimSifreUyari.setTitle("kullanıcı adınız hatalı.")
                isimSifreUyari.setMessage("giriş yapabilmeniz için kullanıcı adınızı doğru girmelisiniz.Tekrar denemek ister misiniz?")
                isimSifreUyari.setPositiveButton(
                    "evet",
                    DialogInterface.OnClickListener { dialogInterface, i -> })
                isimSifreUyari.setNegativeButton(
                    "hayır",
                    DialogInterface.OnClickListener { dialogInterface, i -> })
                isimSifreUyari.show()
                editText.setText("")
                editTextPassword.setText("")
                sayac++
            } else if (girilenİsim != kullaniciAdi && girilenSifre != kullaniciŞifre) {
                var isimSifreUyari = AlertDialog.Builder(this)
                isimSifreUyari.setTitle("kullanıcı adı ve şifre hatalı!")
                isimSifreUyari.setMessage("giriş yapmak için kullanıcı adınızı ve şifrenizi doğru girmeniz gerekir,bir daha denemek ister misiniz?")
                isimSifreUyari.setPositiveButton(
                    "evet",
                    DialogInterface.OnClickListener { dialogInterface, i -> })
                isimSifreUyari.setNegativeButton(
                    "hayır",
                    DialogInterface.OnClickListener { dialogInterface, i -> })
                isimSifreUyari.show()
                editText.setText("")
                editTextPassword.setText("")
                sayac++
            } else if (girilenİsim == kullaniciAdi && girilenSifre == kullaniciŞifre) {
                var hakan = "melike"
                var intent = Intent(applicationContext, kelimelendik2::class.java)
                intent.putExtra("kullanici", hakan)
                startActivity(intent)
                finish()
            }
        }
       if (sayac == 3){
           object :CountDownTimer(15000,1000){
               override fun onTick(p0: Long) {
                   textView5.text = "3 kere yanlış bilgi girdiğiniz için ${p0/1000} saniye beklemek zorundasınız."
                    //editText.setText("")
                    //editTextPassword.setText("")
                   editText.isEnabled= false
                   editTextPassword.isEnabled = false
                   button4.isEnabled = false
                   button5.isEnabled= false
               }
               override fun onFinish() {
                   textView5.text = ""
                   Toast.makeText(this@MainActivity,"bilgilerinizi tekrardan deneyebilirisiniz.",Toast.LENGTH_SHORT).show()
               }
           }.start()
       }
    }
    fun kaydet(view: View){
        var intent = Intent(applicationContext,MainActivity2::class.java)
        startActivity(intent)
        finish()
    }
}
