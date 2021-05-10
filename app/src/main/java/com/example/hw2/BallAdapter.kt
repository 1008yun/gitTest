package com.example.hw2
import android.content.Intent
import android.os.Bundle
import android.text.Layout
import android.view.LayoutInflater
import android.view.TextureView
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView


class BallAdapter (val ballList:List<Balls>):RecyclerView.Adapter<BallAdapter.ViewHolder>(){
    inner class ViewHolder(view:View):RecyclerView.ViewHolder(view){
        val ballImage: ImageView = view.findViewById(R.id.imageView)
        val ballName : TextView = view.findViewById(R.id.textView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view  = LayoutInflater.from(parent.context).inflate(R.layout.my_layout,parent,false)
        val viewHolder = ViewHolder(view)
        viewHolder.itemView.setOnClickListener{
            //Toast.makeText(parent.context,ballList[viewHolder.adapterPosition].name, Toast.LENGTH_SHORT).show()
            it.findNavController().navigate(R.id.action_firstFragment_to_secondFragment)  //跳轉頁面
            Toast.makeText(parent.context,ballList[viewHolder.adapterPosition].name, Toast.LENGTH_SHORT).show()

            val bundle = Bundle()
            bundle.putString("DATA", ballList[viewHolder.adapterPosition].name.toLowerCase())
            view.findNavController().navigate(R.id.secondFragment, bundle)
            //val fragment = FirstFragment()
            //fragment.arguments = bundle

            //Toast.makeText(parent.context,ballList[viewHolder.adapterPosition].imageId, Toast.LENGTH_SHORT).show()
            //val bundle = Bundle()
            //bundle.putString("args", ballList[viewHolder.adapterPosition].name)


        }
        return viewHolder
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val ball = ballList[position]
        holder.ballImage.setImageResource(ball.imageId)
        holder.ballName.text = ball.name
    }
    override fun getItemCount():Int{
        return ballList.size
    }
}