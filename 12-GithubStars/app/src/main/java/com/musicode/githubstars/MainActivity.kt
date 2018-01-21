package com.musicode.githubstars

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.musicode.githubstars.model.Project
import kotlinx.android.synthetic.main.activity_main.*
import okhttp3.*
import org.json.JSONArray
import java.io.IOException

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        search_button.setOnClickListener {
            search()
        }
    }

    private fun search() {
        val text = text_value.text.toString().trim()
        if (text == "") {
            toast("please input user name")
            return
        }

        val client = OkHttpClient()
        val request = Request.Builder()
                .url("https://api.github.com/users/${text}/starred")
                .build()

        client.newCall(request).enqueue(object: Callback {
            override fun onFailure(call: Call?, e: IOException?) {
                toast("get data failed")
            }

            override fun onResponse(call: Call?, response: Response?) {

                val responseString = response?.body()?.string()
                val json = JSONArray(responseString)

                val projects = ArrayList<Project>()

                for (i in 0..(json.length() - 1)) {
                    val item = json.getJSONObject(i)

                    val owner = item.getJSONObject("owner")
                    val ownerName = owner.get("login").toString()
                    val avatarURL = owner.get("avatar_url").toString()
                    val projectName = item.get("name").toString()
                    val description = item.get("description").toString()
                    val starCount = item.get("stargazers_count").toString().toInt()
                    val forkCount = item.get("forks_count").toString().toInt()

                    val project = Project(
                            projectName,
                            description,
                            avatarURL,
                            starCount,
                            forkCount,
                            ownerName
                    )

                    projects.add(project)

                }

                val intent = Intent(this@MainActivity, ProjectListActivity::class.java)

                val bundle = Bundle()
                bundle.putParcelableArrayList("projects", projects)
                intent.putExtras(bundle)

                startActivity(intent)
            }

        })

    }

    private fun toast(msg: String) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
    }
}
