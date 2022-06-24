package com.example.notesapp2

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

//class wordListAdapter : ListAdapter<word,WordViewHolder>(WordsComparator()) {
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WordViewHolder {
//       val view: View = LayoutInflater.from(parent.context).inflate(R.layout.recyclerview_item,parent,false)
//        return WordViewHolder(view)
//
//    }
//
//    override fun onBindViewHolder(holder: WordViewHolder, position: Int) {
//         val currentItem = getItemId(position)
//             holder.bind(currentItem.toString())
//    }
//
//    override fun getItemCount(): Int {
//
//    }
//
//
//}
//class WordViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
//    private val wordItemView : TextView = itemView.findViewById(R.id.textView)
//    fun bind(text:String?){
//        wordItemView.text = text
//    }
//}
//class WordsComparator : DiffUtil.ItemCallback<word>() {
//    override fun areItemsTheSame(oldItem: word, newItem: word): Boolean {
//        return oldItem === newItem
//    }
//
//    override fun areContentsTheSame(oldItem: word, newItem: word): Boolean {
//        return oldItem.word == newItem.word
//    }
//}
//}
class NoteListAdapter(private val listener : IfWordAdapter) : RecyclerView.Adapter< NoteListAdapter.NoteViewHolder>() {
     private  val listOfNotes = ArrayList<Note>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder {
      val viewHolder =  NoteViewHolder.create(parent)
        viewHolder.deleteImg.setOnClickListener {
            listener.onItemClicked(listOfNotes[viewHolder.adapterPosition])
        }
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

                return NoteViewHolder(view)
            }
        }
    }

//    class WordsComparator : DiffUtil.ItemCallback<word>() {
//        override fun areItemsTheSame(oldItem: word, newItem: word): Boolean {
//            return oldItem === newItem
//        }
//
//        override fun areContentsTheSame(oldItem: word, newItem: word): Boolean {
//            return oldItem.word == newItem.word
//        }
//    }

    override fun getItemCount(): Int {

        return listOfNotes.size
    }
}



interface IfWordAdapter{
    fun onItemClicked(note:Note)
}
