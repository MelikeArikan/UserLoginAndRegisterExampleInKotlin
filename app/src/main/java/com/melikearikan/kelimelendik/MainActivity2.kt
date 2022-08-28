package com.melikearikan.kelimelendik

import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main2.*

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        Toast.makeText(this,"lütfen bilgilerinizi doğru giriniz.dilerseniz yardım kutucuklarından yardım alabilirsiniz.",Toast.LENGTH_LONG).show()
    }
    fun kaydet(view: View){
        var hataSayar = 0

        var isim = editText2.text.toString()
        if (isim.length<10 && isim.length !=0){
            var isimKarakter = AlertDialog.Builder(this@MainActivity2)
            isimKarakter.setTitle("kullanıcı adınız en az 10 karakter olmalıdır.")
            isimKarakter.setMessage("tekrardan kullanıcı adınızı belirleyiniz.")
            isimKarakter.setPositiveButton("tamam",DialogInterface.OnClickListener { dialogInterface, i ->
                editText2.setText("")
            })
            isimKarakter.show()
            hataSayar++
        }
        if (isim.length == 0){
            Toast.makeText(this,"lütfen kullanıcı adınızı giriniz.",Toast.LENGTH_SHORT).show()
            hataSayar++
        }

        var sifre = editTextPassword2.text.toString()
        println(isim)
        if (sifre.length == 0){
            Toast.makeText(this,"lütfen şifre bilgisini giriniz.",Toast.LENGTH_SHORT).show()
            hataSayar++
        }
        if (sifre.length<10){
            var sifreKarakter = AlertDialog.Builder(this@MainActivity2)
            sifreKarakter.setTitle("şifreniz en az 10 karakterden oluşabilir.")
            sifreKarakter.setMessage("tekrardan şifre oluşturmak ister misiniz.")
            sifreKarakter.setPositiveButton("evet",DialogInterface.OnClickListener { dialogInterface, i ->
                editTextPassword2.setText("")
            })
            sifreKarakter.show()
            hataSayar++
        }

        var sifre2 = editTextPassword3.text.toString()
        if (sifre2.length == 0){
            Toast.makeText(this,"şifre alanları boş bırakılamaz.",Toast.LENGTH_SHORT).show()
            hataSayar++
        }
        if (sifre != sifre2){
            var sifreTekrar = AlertDialog.Builder(this@MainActivity2)
            sifreTekrar.setTitle("şifreleriniz birbirinden farklı,lütfen tekrardan deneyiniz.")
            sifreTekrar.setPositiveButton("anladım",DialogInterface.OnClickListener { dialogInterface, i ->
                editTextPassword2.setText("")
                editTextPassword3.setText("")
            })
            sifreTekrar.show()
            hataSayar++
        }

        var mailAdresi = editTextEmailAddress.text.toString()
        if (mailAdresi.length == 0 ){
            Toast.makeText(this,"lütfen mail adresi bilginizi giriniz.",Toast.LENGTH_SHORT).show()
            hataSayar++
        }
        var mailListem = arrayListOf<Any>()
        var indeks1 = 0
        for (i in mailAdresi){
            mailListem.add(indeks1,i)
            indeks1++
        }
        var sayEt = 0
        for (i in mailListem){
            if (i == '@'){
                sayEt++
            }
        }
        if (sayEt == 0){
            Toast.makeText(this,"@ sembolünü mail adresinizi girerken yazmak zorundasınız, yazmadığınız için geçersiz e-mail adresi giriniz.",Toast.LENGTH_LONG).show()
            editTextEmailAddress.setText("")
            hataSayar++
        }

        var noListem = arrayListOf<Any>()
        var indeks = 0
        var telefonNO = editTextPhone.text.toString()
        for (i in telefonNO){
            noListem.add(indeks,i)
            indeks++
        }
        if (noListem.get(0) == '0'){
            println("hakan")
            Toast.makeText(this,"lütfen telefon numaranızın başına 0 eklemeden 10 hane olacak şekilde yazınız.",Toast.LENGTH_LONG).show()
            hataSayar++
            editTextPhone.setText("")
        }
        if (telefonNO.length == 0){
            Toast.makeText(this,"lütfen telefon numaranızı giriniz.",Toast.LENGTH_SHORT).show()
            hataSayar++
            editTextPhone.setText("")
        }
        if (telefonNO.length<10){
            Toast.makeText(this,"telefon numaranızı eksik yazdınız,lütfen doğru yazınız.",Toast.LENGTH_SHORT).show()
            hataSayar++
            editTextPhone.setText("")
        }
        if (telefonNO.length>10){
            Toast.makeText(this,"telefon numaranız 10 haneli olmalıdır,lütfen telefon numaranızı doğru yazınız.",Toast.LENGTH_SHORT).show()
            hataSayar++
            editTextPhone.setText("")
        }
        if (hataSayar == 0){
            Toast.makeText(this,"tebrikler kaydoldunuz...",Toast.LENGTH_SHORT).show()

        }
    }

    fun isimHelp(view: View){
        var isimHelp = AlertDialog.Builder(this@MainActivity2)
        isimHelp.setTitle("kullanıcı adınızı oluştururken şu kurallara dikkat ediniz:")
        isimHelp.setMessage("kullanıcı adını belirlemek zorundasınız ve kullanıcı adınız en az 10 karakterden oluşmalıdır. ")
        isimHelp.setPositiveButton("anladım",DialogInterface.OnClickListener { dialogInterface, i ->  })
        isimHelp.show()
    }

    fun sifreHelp(view: View){
        var sifreHelp = AlertDialog.Builder(this@MainActivity2)
        sifreHelp.setTitle("şifre oluşturuken şu kurallara dikkat ediniz:")
        sifreHelp.setMessage("şifre oluşturmak zorundasınız ve şifreniz en az 10 karakterden  oluşmalıdır.")
        sifreHelp.setPositiveButton("anladım.",DialogInterface.OnClickListener { dialogInterface, i ->  })
        sifreHelp.show()
    }

    fun sifre2Help(view: View){
        var sifre2Help = AlertDialog.Builder(this@MainActivity2)
        sifre2Help.setTitle("şifrelerinizin aynı olmasına dikkat ediniz.")
        sifre2Help.setPositiveButton("anladım.",DialogInterface.OnClickListener { dialogInterface, i ->  })
        sifre2Help.show()
    }

    fun mailHelp(view: View){
        var mailHelp = AlertDialog.Builder(this)
        mailHelp.setTitle("lütfen geçerli mail adresinizi giriniz")
        mailHelp.setPositiveButton("anladım.",DialogInterface.OnClickListener { dialogInterface, i ->  })
        mailHelp.show()
    }

    fun telefonHelp(view: View){
        var telefonHelp = AlertDialog.Builder(this)
        telefonHelp.setTitle("lütfen telefon numaranızı başında sıfır olmadan 10 hane olacak şekilde giriniz.")
        telefonHelp.setPositiveButton("anladım.",DialogInterface.OnClickListener { dialogInterface, i ->  })
        telefonHelp.show()
    }

    fun giriseDon(view: View){
        var intent = Intent(applicationContext,MainActivity::class.java)
        startActivity(intent)
        finish()

    }
}

























