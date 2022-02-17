package com.b12game.twitter.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.b12game.twitter.R
import com.b12game.twitter.model.Post
import com.bumptech.glide.Glide
import com.google.android.material.imageview.ShapeableImageView

class FeedAdapter(var context: Context, var items: ArrayList<Post>): RecyclerView.Adapter<RecyclerView.ViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_feed_post,parent,false)
        return FeedViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val feed = items[position]

        if(holder is FeedViewHolder){
            var iv_profile = holder.iv_profile
            Glide.with(context).load(feed.photo).into(holder.iv_post)
            var tv_fullname = holder.tv_fullname

            iv_profile.setImageResource(feed.profile)
            tv_fullname.text = feed.fullname
        }
    }

    override fun getItemCount(): Int {
       return items.size
    }

    class FeedViewHolder(view: View): RecyclerView.ViewHolder(view){
        var iv_profile: ShapeableImageView
        var iv_post : ShapeableImageView
        var tv_fullname : TextView

        init {
            iv_profile = view.findViewById(R.id.iv_profile)
            iv_post = view.findViewById(R.id.iv_post)
            tv_fullname = view.findViewById(R.id.tv_fullname)
        }

    }

}