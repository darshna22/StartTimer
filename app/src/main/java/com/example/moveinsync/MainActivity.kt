package com.example.moveinsync

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.moveinsync.view.CountDownViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val viewModel = ViewModelProvider(this).get(CountDownViewModel::class.java)
        bt_start_timer.setOnClickListener { viewModel.starTimer() }
        bt_stop_timer.setOnClickListener { viewModel.stopTimer() }

        viewModel.countValue.observe(this, Observer {
            tv_timer_time.text = it.toString()
        })


    }
}