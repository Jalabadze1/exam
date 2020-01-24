package com.example.fingamocdaa

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Toast
import com.google.android.gms.tasks.OnCompleteListener
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var auth:FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        auth=FirebaseAuth.getInstance()

        forgotpass.setOnClickListener {
            var intent=Intent(this,ForgotpasswordActivity::class.java)
            startActivity(intent)
        }

        login_btn.setOnClickListener {

            val e: String=email_txt.text.toString()
            val p: String=password_txt.text.toString()
            if (TextUtils.isEmpty(e) || TextUtils.isEmpty(p)) {

                Toast.makeText(this, "Please fill all the fields", Toast.LENGTH_LONG)
                    .show()

            } else {

                auth.signInWithEmailAndPassword(e,p).addOnCompleteListener(this, OnCompleteListener { task ->

                    if (task.isSuccessful){
                        Toast.makeText(this,"Logged In",Toast.LENGTH_LONG).show()
                        var intent=Intent(this,SecActivity::class.java)
                        startActivity(intent)
                        finish()
                    }
                    else{
                        Toast.makeText(this,"Logged Failed",Toast.LENGTH_LONG).show()
                    }
                })

            }

        }
        signup_btn.setOnClickListener {

            var intent=Intent(this,SignupActivity::class.java)
            startActivity(intent)
        }




    }
}
