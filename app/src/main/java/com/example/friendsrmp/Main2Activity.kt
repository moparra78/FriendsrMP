package com.example.friendsrmp

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import com.example.friendsrmp.databinding.ActivityMain2Binding
import kotlinx.android.synthetic.main.activity_main2.*

class Main2Activity : AppCompatActivity() {
    private lateinit var friend: Main3Activity
    lateinit var binding: ActivityMain2Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMain2Binding.inflate(layoutInflater)
        setContentView(binding.root)
        if (intent.hasExtra(FRIEND_EXTRA)) {
            friend = intent.getParcelableExtra<Main3Activity>(FRIEND_EXTRA)
        }
        fillData()
        binding.calificacion.setOnRatingBarChangeListener { _, newScore, _ ->
            friend.score = newScore
            goBackToMain()
        }
    }

    fun fillData() {
        binding.calificacion.rating = friend.score
        binding.descripcion.text = friend.description
        binding.foto2.setImageResource(friend.photo)
    }

    fun goBackToMain() {
        val intent = Intent(this, MainActivity::class.java)
        intent.putExtra(FRIEND_EXTRA, friend)
        setResult(Activity.RESULT_OK, intent)
        finish()
    }

    companion object {
        const val DETAIL_CODE = 55
        const val FRIEND_EXTRA = "FRIEND"

    }
}


/*class Main2Activity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
    }
}*/
