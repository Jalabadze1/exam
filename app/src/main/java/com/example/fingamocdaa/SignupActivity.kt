package com.example.fingamocdaa

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.android.gms.tasks.OnCompleteListener
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_signup.*
import kotlinx.android.synthetic.main.activity_signup.email_txt
import kotlinx.android.synthetic.main.activity_signup.password_txt

class SignupActivity : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)

        auth=FirebaseAuth.getInstance()

        signUpBtn.setOnClickListener {
            var e:String=email_txt.text.toString()
            var p: String=password_txt.text.toString()

            auth.createUserWithEmailAndPassword(e,p).addOnCompleteListener(this, OnCompleteListener { task ->
                if(task.isSuccessful){
                    Toast.makeText(this,"Successfully Registred",Toast.LENGTH_LONG).show()

                    var intent=Intent(this,SecActivity::class.java)
                    startActivity(intent)
                    finish()
                }
                else{
                    Toast.makeText(this,"Registration Failed",Toast.LENGTH_LONG).show()
                }
            })

        }

        loginBtn.setOnClickListener {
            var intent=Intent(this,MainActivity::class.java)
            startActivity(intent)
            finish()
        }


    }
}
