package com.example.friendsrmp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Parcelable
import kotlinx.android.parcel.Parcelize


@Parcelize
data class Main3Activity(val name: String, val description: String, val photo: Int, var score: Float) :
    Parcelable {
}

/*class Main3Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3)
    }
}*/
