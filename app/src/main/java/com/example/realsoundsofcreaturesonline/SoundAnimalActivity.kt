package com.example.realsoundsofcreaturesonline

import android.content.Intent
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import com.example.realsoundsofcreaturesonline.databinding.ActivitySoundAnimalBinding

class SoundAnimalActivity : AppCompatActivity() {

    private var binding : ActivitySoundAnimalBinding? = null
    private lateinit var player: MediaPlayer
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySoundAnimalBinding.inflate(layoutInflater)
        setContentView(binding?.root)
        var sound = 0
        var image = 0
        val intent = intent.apply {
            image = getIntExtra("animalImage", R.drawable.elephant_intent)
            sound = getIntExtra("animalVoice", R.raw.elephant_audio)
        }


        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        player = MediaPlayer.create(this, sound)
        binding?.imageAnimal?.setImageResource(image)
        binding?.button?.setOnClickListener {
            player.start()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        binding = null
        player.stop()
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home)
        {
            val intent = Intent(this@SoundAnimalActivity, MainActivity::class.java)
            startActivity(intent)
        }
        return super.onOptionsItemSelected(item)
    }
}