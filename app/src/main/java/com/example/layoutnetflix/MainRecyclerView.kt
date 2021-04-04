package com.example.layoutnetflix

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso

class MainRecyclerView (val viewModel: MainViewModel, val arraylist: ArrayList<User>) : RecyclerView.Adapter<MainRecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainRecyclerView.ViewHolder {
        val root = LayoutInflater.from(parent.context).inflate(R.layout.item_user,parent,false)
        return ViewHolder(root)
    }

    override fun onBindViewHolder(holder: MainRecyclerView.ViewHolder, position: Int) {
        holder.bind(arraylist[position])
    }

    override fun getItemCount(): Int {
        return arraylist.size
    }

    inner class ViewHolder (item: View) : RecyclerView.ViewHolder(item) {
        var image = item.findViewById<ImageView>(R.id.img_user)
        var name = item.findViewById<TextView>(R.id.tv_name)
        var card = item.findViewById<CardView>(R.id.card_user)

        fun bind(user: User) {
            name.text = user.name
            if (arraylist.size == 1) { //Mudar essa logica pro size ser igual a 0 e mostrar para add perfil
                Picasso.get().load(R.drawable.img_add_user).into(image)
                card.setOnClickListener {
                    itemView.context.startActivity(Intent(this.itemView.context, NewUserActivity::class.java))
                }
            } else {
                Picasso.get().load(R.drawable.img_user).into(image)

                if (user.name.contains("Novo")) {
                    card.setOnClickListener {
                        itemView.context.startActivity(Intent(this.itemView.context, NewUserActivity::class.java))
                    }
                }
            }
        }

    }

}