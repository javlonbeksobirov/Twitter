package com.b12game.twitter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.RecoverySystem
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.b12game.twitter.adapter.FeedAdapter
import com.b12game.twitter.adapter.StoryAdapter
import com.b12game.twitter.model.Post
import com.b12game.twitter.model.Story

class MainActivity : AppCompatActivity() {
    lateinit var recyclerFeed : RecyclerView
    lateinit var recyclerStory : RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initViews()
    }

    private fun initViews() {
        recyclerFeed = findViewById(R.id.recyclerFeed)
        recyclerStory = findViewById(R.id.recyclerStory)

        recyclerFeed.layoutManager = LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false)
        refreshPosts(getPosts())

        recyclerStory.layoutManager = LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false)
        refreshStories(getStories())
    }

    private fun refreshStories(stories: ArrayList<Story>) {
        val adapter = StoryAdapter(this,stories)
        recyclerStory.adapter = adapter
    }


    private fun refreshPosts(posts: ArrayList<Post>) {
        val adapter = FeedAdapter(this,posts)
        recyclerFeed.adapter = adapter
    }

    private fun getStories(): ArrayList<Story> {
        var stories :ArrayList<Story> = ArrayList()
        stories.add(Story(R.drawable.im_10,"Sarvar"))
        stories.add(Story(R.drawable.im_10,"Sherzod"))
        stories.add(Story(R.drawable.im_10,"Tohir"))
        stories.add(Story(R.drawable.im_10,"Sherzod"))
        stories.add(Story(R.drawable.im_10,"Sarvar"))
        stories.add(Story(R.drawable.im_10,"Sherzod"))
        stories.add(Story(R.drawable.im_10,"Tohir"))
        stories.add(Story(R.drawable.im_10,"Sarvar"))
        stories.add(Story(R.drawable.im_10,"Tohir"))
        return stories

    }


    private fun getPosts(): ArrayList<Post> {
        var posts :ArrayList<Post> = ArrayList()
        posts.add(Post(R.drawable.im_10,"Sarvarbek Khalmatov","https://images.unsplash.com/photo-1638913974023-cef988e81629?ixlib=rb-1.2.1&ixid=MnwxMjA3fDF8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=870&q=80"))
        posts.add(Post(R.drawable.im_10,"Sherzod Jo`rabekov","https://images.unsplash.com/photo-1638913974023-cef988e81629?ixlib=rb-1.2.1&ixid=MnwxMjA3fDF8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=870&q=80"))
        posts.add(Post(R.drawable.im_10,"Sherzod Jo`rabekov","https://images.unsplash.com/photo-1645008558160-c7e4affd16d8?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=387&q=80"))
        posts.add(Post(R.drawable.im_10,"Sherzod Jo`rabekov","https://images.unsplash.com/photo-1640622842223-e1e39f4bf627?ixlib=rb-1.2.1&ixid=MnwxMjA3fDF8MHxlZGl0b3JpYWwtZmVlZHw0MHx8fGVufDB8fHx8&auto=format&fit=crop&w=500&q=60"))
        return posts
    }
}