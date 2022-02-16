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

        posts.add(Post(R.drawable.im_10,"Sarvarbek Khalmatov",R.drawable.im_10))
        posts.add(Post(R.drawable.im_10,"Sherzod Jo`rabekov",R.drawable.im_10))
        posts.add(Post(R.drawable.ic_baseline_account_circle_24,"Tohir Rahmatullayev",R.drawable.im_10))
        posts.add(Post(R.drawable.ic_baseline_account_circle_24,"Sherzod Jo`rabekov",R.drawable.im_10))
        posts.add(Post(R.drawable.ic_baseline_account_circle_24,"Sarvarbek Khalmatov",R.drawable.im_10))
        posts.add(Post(R.drawable.ic_baseline_account_circle_24,"Tohir Rahmatullayev",R.drawable.im_10))

        return posts
    }
}