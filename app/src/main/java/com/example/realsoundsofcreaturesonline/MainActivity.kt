package com.example.realsoundsofcreaturesonline

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.realsoundsofcreaturesonline.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    var binding : ActivityMainBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding?.root)
        val array = ArrayList<Animal>()
        array.add(Animal("elephant", R.raw.elephant_audio, R.drawable.elephant, R.drawable.elephant_intent))
        array.add(Animal("alligator", R.raw.alligator_audio, R.drawable.alligator, R.drawable.alligator_intent))
        array.add(Animal("cat", R.raw.cat_audio, R.drawable.cat, R.drawable.cat_intent))
        array.add(Animal("cow", R.raw.cow_audio, R.drawable.cow, R.drawable.cow_intent))
        array.add(Animal("dog", R.raw.dog_audio, R.drawable.dog, R.drawable.dog_intent))
        array.add(Animal("horse", R.raw.horse_audio, R.drawable.horse, R.drawable.horse_intent))
        array.add(Animal("lion", R.raw.lion_audio, R.drawable.lion, R.drawable.lion_intent))
        array.add(Animal("pigeon", R.raw.pigeon_audio, R.drawable.pigeon, R.drawable.pigeon_intent))
        array.add(Animal("penguin", R.raw.penguin_audio, R.drawable.pinguin, R.drawable.pinguin_intent))
        array.add(Animal("wolf", R.raw.wolf_audio, R.drawable.wolf, R.drawable.wolf_intent))
        val adapter = RecyclerAdapter(array, this)
        binding?.recyclerView?.layoutManager = LinearLayoutManager(this)
        binding?.recyclerView?.adapter = adapter
        binding?.recyclerView?.addItemDecoration(DividerItemDecoration(this, DividerItemDecoration.VERTICAL))
        adapter.setOnClickListener(object : RecyclerAdapter.setOnItemClickListener
        {
            override fun onItemClick(position: Int) {
                val intent = Intent(this@MainActivity, SoundAnimalActivity::class.java).apply {
                    putExtra("animalImage", array[position].imageIntent)
                    putExtra("animalVoice", array[position].sound)
                }
                startActivity(intent)
            }
        })

    }

    override fun onDestroy() {
        super.onDestroy()
        binding = null
    }
}