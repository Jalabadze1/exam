package com.example.fingamocdaa

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Toast
import com.google.android.gms.tasks.OnCompleteListener
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_sec.*
import kotlinx.android.synthetic.main.activity_update_pass.*

class UpdatePassActivity : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_update_pass)

        auth=FirebaseAuth.getInstance()


        back.setOnClickListener {
            auth.signOut()
            val intent= Intent(this,MainActivity::class.java)
            startActivity(intent)

        }

        changepassword.setOnClickListener {

            var password:String=password_txt.text.toString()

            if (TextUtils.isEmpty(password)) {

                Toast.makeText(this, "Please enter password", Toast.LENGTH_LONG).show()

            } else {

                auth.currentUser?.updatePassword(password)
                    ?.addOnCompleteListener(this, OnCompleteListener { task ->
                        if (task.isSuccessful) {

                            Toast.makeText(this, "Password changes successfully", Toast.LENGTH_LONG)
                                .show()
                            finish()

                        } else {

                            Toast.makeText(this, "password not changed", Toast.LENGTH_LONG)
                                .show()

                        }
                    })

            }


        }

    }
}
