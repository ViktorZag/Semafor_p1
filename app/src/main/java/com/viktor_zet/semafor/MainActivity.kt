package com.viktor_zet.semafor

import android.app.Activity
import android.os.Bundle
import android.widget.ImageButton
import android.widget.ImageView
import java.util.*

class MainActivity : Activity() {

    var imageView: ImageView? = null
    var button: ImageButton? = null
    var timer: Timer? = null
    var isBtnClicked = false
    var counter = 0
    val images = intArrayOf(
        R.drawable.traffic_light_red,
        R.drawable.traffic_light_yellow,
        R.drawable.traffic_light_green
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }

    fun onBtnClicked(view: android.view.View) {
        imageView = findViewById(R.id.img)
        button = findViewById(R.id.btn)
        view as ImageButton
        if (isBtnClicked) {
            imageView?.setImageResource(R.drawable.traffic_light_red)
            view.setImageResource(R.drawable.start)
            timer?.cancel()
            isBtnClicked = false
            counter = 0
        } else {
            view.setImageResource(R.drawable.stop)
            isBtnClicked = true
            startStop()
        }
    }

    fun startStop() {
        timer = Timer()
        timer?.schedule(object : TimerTask() {
            override fun run() {
                runOnUiThread {
                    imageView?.setImageResource(images[counter])
                    counter++
                    if (counter == 3) counter = 0
                }
            }
        }, 0, 1000)
    }

}

