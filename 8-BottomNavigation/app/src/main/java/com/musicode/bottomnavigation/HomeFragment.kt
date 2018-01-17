package com.musicode.bottomnavigation

import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater!!.inflate(R.layout.fragment_home, container, false)
    }


    override fun onStart() {
        super.onStart()
        home_button.setOnClickListener {
            val intent = Intent(activity, Home2Activity::class.java)
            startActivity(intent)
        }
    }
}
