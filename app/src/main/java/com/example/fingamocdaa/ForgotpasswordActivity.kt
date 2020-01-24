package com.example.fingamocdaa

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Toast
import com.google.android.gms.tasks.OnCompleteListener
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_forgotpassword.*
import kotlinx.android.synthetic.main.activity_update_pass.*

class ForgotpasswordActivity : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_forgotpassword)

        auth=FirebaseAuth.getInstance()
        backkk.setOnClickListener {
            var intent=Intent(this,SecActivity::class.java)
            startActivity(intent)
        }

        changepass.setOnClickListener {
            val email: String = gmail_txt.text.toString()

            if (TextUtils.isEmpty(email)) {

                Toast.makeText(this, "Please enter email id", Toast.LENGTH_LONG).show()

            } else {

                auth.sendPasswordResetEmail(email)
                    .addOnCompleteListener(this, OnCompleteListener { task ->
                        if (task.isSuccessful) {
                            Toast.makeText(this, "Reset link sent to your email", Toast.LENGTH_LONG)
                                .show()
                        } else {
                            Toast.makeText(this, "Unable to send reset mail", Toast.LENGTH_LONG)
                                .show()
                        }
                    })

            }



        }
    }
}
