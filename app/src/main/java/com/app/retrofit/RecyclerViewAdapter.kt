package com.app.retrofit

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

class RecyclerAdapter(private val context: Context) : RecyclerView.Adapter<RecyclerAdapter.MyViewHolder>() {

    private var userList : List<Data> = listOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {

        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_view,parent,false)
        return MyViewHolder(view)
    }

    override fun getItemCount(): Int {
        return userList.size
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        holder.tvUserName.text = "${userList[position].first_name} ${userList[position].last_name}"
        Glide.with(context).load(userList[position].avatar)
            .apply(RequestOptions().centerCrop())
            .into(holder.image)

        holder.ll1.setOnClickListener{
            context.startActivity(Intent(context,DetailsActivity::class.java).putExtra("user",userList[position]))
        }
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setUserListItems(userList : List<Data>)
    {
        this.userList = userList
        notifyDataSetChanged()
    }

    class MyViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView!!) {

        val tvUserName: TextView = itemView!!.findViewById(R.id.userName)
        val image: ImageView = itemView!!.findViewById(R.id.imageView)
        var ll1 : LinearLayout = itemView!!.findViewById(R.id.ll1)

    }
}