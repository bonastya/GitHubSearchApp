package com.example.github

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

var imagesList = mutableListOf<Int>(R.drawable.img1, R.drawable.img2,R.drawable.img3, R.drawable.img4,R.drawable.img5, R.drawable.img6,R.drawable.img7, R.drawable.img8,R.drawable.img9, R.drawable.img10,R.drawable.img11)

class PersonViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
    fun bind (person: User){
        with(itemView){
            person.run {
                val nametextView: TextView = findViewById(R.id.nameTextView) as TextView
                val descriptiontextView: TextView = findViewById(R.id.descriptionTextView) as TextView
                val avatarImageView: ImageView = findViewById(R.id.AvatarImageView) as ImageView
                nametextView.text = name
                descriptiontextView.text = description
                avatarImageView.setImageResource(imagesList[avatarNumber])
                //Glide.with(context).load("https://i.pravatar.cc/150?img=1").into(avatarImageView)

            }
        }
    }
}