package com.example.github

import android.app.Person
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Adapter
import android.widget.EditText
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import java.util.*

class MainActivity : AppCompatActivity() {

    private val random: Int  get() = Random().nextInt(9)

    private lateinit var personAdaptor: personAdaptor

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        initRecyclerView()



    }

    val reposForUser1 = listOf(
        Repository(name = "HelloWorld", description = "I'll be a next Hokage of this programming world", lang = "Kotlin", userName = "User2"),
        Repository(name = "Cells", description = "I have got a new arm", lang = "Cobol", userName = "User1")
    )
    val reposForUser2 = listOf(
        Repository(name = "OldKey", description = "I want to know what are this cellar contains", lang = "Kotlin", userName = "User1"),
        Repository(name = "Sea", description = "I'll kill all titans and go to the sea, witch contains salt", lang = "Java", userName = "User2")
    )


    var allPersonList = mutableListOf<User>()

    private fun initRecyclerView(){
        personAdaptor= personAdaptor()
/*        personAdaptor.addPerson(User1)
        personAdaptor.addPerson(User2)*/

        val personlist: RecyclerView = findViewById(R.id.personList) as RecyclerView

        with(personlist){
            this.layoutManager=LinearLayoutManager(context)
            this.adapter = personAdaptor
            this.setHasFixedSize(true)
        }



        for(i in 1..20) {
            personAdaptor.addPerson(
                User(
                    getRandomName(),
                    getRandomDescription(),
                    reposForUser1,
                    getRandomAvatar()
                )
            )
        }
        personAdaptor.resetList()

       /* for(i in 1..5) {
            allPersonList.add(
                User(
                    getRandomName(),
                    getRandomDescription(),
                    reposForUser1,
                    getRandomAvatar()
                )
            )
        }*/
        //personAdaptor.resetList(allPersonList)

    }

private fun getRandomName() = resources.getStringArray(R.array.names)[random]
private fun getRandomDescription() = resources.getStringArray(R.array.descriptions)[random]
private fun getRandomAvatar() = random


    var personFilterList = mutableListOf<User>()

    fun search(view: View) {
        personAdaptor.resetList()
        personFilterList.clear()

        val text: EditText = findViewById(R.id.editTextSearch) as EditText

        if( personAdaptor.personList.size!=0){
            for(i in personAdaptor.personList){
                if (i.name.contains(text.text, ignoreCase = true) or i.description.contains(text.text, ignoreCase = true))
                    personFilterList.add(i)
                println("iii "+i.name+" "+text.text+" "+i.name.contains(text.text, ignoreCase = true))
            }
            personAdaptor.setList(personFilterList)
        }



/*        text.setOnClickListener {
            text.setText(getString(R.string.name))
        }*/
    }


}







