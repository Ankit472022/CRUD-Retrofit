package com.app.retrofit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val recyclerAdapter = RecyclerAdapter(this)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = recyclerAdapter

        val apiInterface = ApiInterface.create().getUsers()

        apiInterface.enqueue(object : retrofit2.Callback<User>
        {
            override fun onResponse(call: Call<User>, response: Response<User>) {
                if (response.body() != null)
                {
                    println(response.body())
                    recyclerAdapter.setUserListItems(response.body()!!.data)
                }
                else{
                    showError("no data")
                }
            }
            override fun onFailure(call: Call<User>, t: Throwable) {
                showError(t.toString())
                Log.e("MainActivity", t.message!!)
            }
        })

    }

    fun showError(msg: String){
        Toast.makeText(this, msg, Toast.LENGTH_LONG).show()
    }
}