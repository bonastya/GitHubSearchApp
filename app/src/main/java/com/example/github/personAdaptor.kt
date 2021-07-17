package com.example.github

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView



class personAdaptor: RecyclerView.Adapter<PersonViewHolder>(){

    var personList = mutableListOf<User>()
    var allPersonList = mutableListOf<User>()

    fun setList(personlist: MutableList<User>){
        personList.clear()
        for (i in personlist){
            personList.add(i)}
        notifyDataSetChanged()
    }

    fun resetList(){
        personList.clear()
        for (i in allPersonList){
        personList.add(i)}
        notifyDataSetChanged()
    }

    fun addPerson(person:User){
        allPersonList.add(person)
        notifyDataSetChanged()
    }



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PersonViewHolder {
        val itemView: View = LayoutInflater.from(parent.context).inflate(R.layout.item_user, parent, false)
        return PersonViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: PersonViewHolder, position: Int) {
        holder.bind(personList[position])
    }

    override fun getItemCount()= personList.size



}