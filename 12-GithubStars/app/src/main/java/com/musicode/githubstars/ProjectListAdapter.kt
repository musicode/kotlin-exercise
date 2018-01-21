package com.musicode.githubstars

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.musicode.githubstars.model.Project
import kotlinx.android.synthetic.main.project_list_item.view.*
import java.util.ArrayList

class ProjectListAdapter(val projects: ArrayList<Project>): RecyclerView.Adapter<ProjectListAdapter.ViewHolder>() {

    override fun onBindViewHolder(holder: ViewHolder?, position: Int) {
        holder?.bindProject(projects[position])
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent?.context).inflate(R.layout.project_list_item, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return projects.size
    }

    class ViewHolder(val view: View): RecyclerView.ViewHolder(view) {

        fun bindProject(project: Project) {
            view.name_view.text = project.projectName
            view.desc_view.text = project.description
            view.star_text.text = project.starCount.toString()
            view.fork_text.text = project.forkCount.toString()
            view.user_text.text = project.username
        }

    }
}