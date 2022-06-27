package com.example.notesapp2

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView


class NoteListAdapter(private val context: Context, private val listener : IfNoteAdapter) : RecyclerView.Adapter< NoteListAdapter.NoteViewHolder>() {
     private  val listOfNotes = ArrayList<Note>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder {
      val viewHolder =  NoteViewHolder.create(parent)
        viewHolder.deleteImg.setOnClickListener {
            listener.onItemClicked(listOfNotes[viewHolder.adapterPosition])
        }
        viewHolder.itemView.setOnClickListener {
            val intent = Intent(context, TitleItem::class.java)
            Toast.makeText(context,listOfNotes[viewHolder.adapterPosition].title, Toast.LENGTH_SHORT).show()
           intent.putExtra("titleItem", listOfNotes[viewHolder.adapterPosition].title)
            intent.putExtra("descItem", listOfNotes[viewHolder.adapterPosition].desc)
            context.startActivity(intent)
        }

//        viewHolder.setOnClickListener {
//            val intent = Intent(context, TitleItem::class.java)
//            intent.putExtra("titleItem", current.title)
//            intent.putExtra("descItem", current.desc)
//            context.startActivity(intent)
//        }
        return viewHolder
    }

    override fun onBindViewHolder(holder: NoteViewHolder, position: Int) {
        val current = listOfNotes[position]
        holder.bind(current.title)

    }
    fun updateList(wordList : List<Note>){
        listOfNotes.clear()
        listOfNotes.addAll(wordList)
        notifyDataSetChanged()
    }

    class NoteViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val wordItemView: TextView = itemView.findViewById(R.id.textView)
         val deleteImg : ImageView = itemView.findViewById(R.id.delete)

        fun bind(text: String?) {
            wordItemView.text = text
        }

        companion object {
            fun create(parent: ViewGroup): NoteViewHolder {
                val view: View = LayoutInflater.from(parent.context)
                    .inflate(R.layout.recyclerview_item, parent, false)
//                view.setOnClickListener {
////                    var intent = Intent()
////                    intent.putExtra("titleItem",listOfNotes[viewHolder.adapterPosition])
//                }
                return NoteViewHolder(view)
            }


        }
    }



    override fun getItemCount(): Int {

        return listOfNotes.size
    }
}




interface IfNoteAdapter{
    fun onItemClicked(note:Note)
}

