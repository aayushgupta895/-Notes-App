package com.example.notesapp2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.activity.viewModels
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity(),IfWordAdapter {
    lateinit var fab : FloatingActionButton
    private val emptyString = ""

    private  val notesViewModel : NoteViewModel by viewModels{
    NoteViewModel.NoteViewModelFactory((application as NotesApplication).repository)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val activityLauncher : ActivityResultLauncher<Intent> = registerForActivityResult(
            ActivityResultContracts.StartActivityForResult()
        ) { result ->
             if(result.resultCode==2){
                 val intent = result.data
                 if(intent!=null){
                 val title =  intent.getStringExtra("title")
                 val description = intent.getStringExtra("description")
                     if(title!=emptyString) {
                         notesViewModel.insert(Note(title.toString(),description.toString()))
                     }
                     else {
                         Toast.makeText(this,"enter the title",Toast.LENGTH_SHORT).show()
                     }
                 }
             }

        }
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerview)
        fab = findViewById(R.id.fab)
        val adapter = NoteListAdapter(this)
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this)
        notesViewModel.allNotes.observe(this,  { list->
            list?.let {
                adapter.updateList(it)
            }
            })
        fab.setOnClickListener{
            val intent = Intent(this@MainActivity,NoteActivity::class.java)
            activityLauncher.launch(intent)

        }


            }

    override fun onItemClicked(note: Note) {
        notesViewModel.delete(note)
    }

}