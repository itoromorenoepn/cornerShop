package `is`.epn.cornershop

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_metod_pay.*

class metod_pay : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_metod_pay)
        imageVisa.setOnClickListener{
            val intento2 = Intent(this, form_pay::class.java)
            startActivity(intento2)
        }
        imageMaster.setOnClickListener{
            val intento2 = Intent(this, form_pay::class.java)
            startActivity(intento2)
        }
    }
}
