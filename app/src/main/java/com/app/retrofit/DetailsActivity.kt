package com.app.retrofit

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

class DetailsActivity : AppCompatActivity() {

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)

        val tvFirstName: TextView = findViewById(R.id.uFirstName)
        val tvLastName: TextView = findViewById(R.id.uLastName)
        val tvEmail: TextView = findViewById(R.id.userEmail)
        val image: ImageView = findViewById(R.id.imageViewD)

        val data : Data? = intent.getParcelableExtra("user")


        tvFirstName.text = "First Name : ${data!!.first_name}"
        tvLastName.text = "Last Name : ${data.last_name}"
        tvEmail.text = "Email : ${data.email}"
        Glide.with(this).load(data.avatar)
            .apply(RequestOptions().centerCrop())
            .into(image)
    }
}