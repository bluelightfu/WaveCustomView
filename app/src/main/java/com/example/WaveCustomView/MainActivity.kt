package com.example.WaveCustomView

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.SeekBar

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val siri= findViewById<SiriVisualView>(R.id.siriView)
        val seekbar = findViewById<SeekBar>(R.id.seekbar)

        siri.apply {
            updateSpeaking(true)
            updateViewColor(Color.BLACK)
            updateAmplitude( seekbar.progress.toFloat())
            updateSpeed(-0.05f)
        }
        seekbar.setOnSeekBarChangeListener(object:SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(p0: SeekBar?, p1: Int, p2: Boolean) {
                siri.updateAmplitude(seekbar.progress/100F)
            }

            override fun onStartTrackingTouch(p0: SeekBar?) {
            }

            override fun onStopTrackingTouch(p0: SeekBar?) {
            }
        })
    }
}