package com.example.fingamocdaa

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_sec.*

class SecActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sec)

        log_out_btn.setOnClickListener {
            var intent=Intent(this,MainActivity::class.java)
            startActivity(intent)
        }

        update_pass.setOnClickListener {
            val intent= Intent(this,UpdatePassActivity::class.java)
            startActivity(intent)
        }
    }
}
