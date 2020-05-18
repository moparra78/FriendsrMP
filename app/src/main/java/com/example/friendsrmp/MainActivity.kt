package com.example.friendsrmp

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.friendsrmp.Main2Activity.Companion.FRIEND_EXTRA
import com.example.friendsrmp.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), Adaptador1.PeopleListener {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        //val binding: ActivityMainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val friends = mutableListOf<Main3Activity>(
            Main3Activity(
                "Homero",
                "Homero Simpson fue criado en la granja de sus padres, asistió a la Escuela Secundaria de Springfield donde se enamoró de Marge Bouvier. Trabaja en la planta de energía nuclear de Springfield en el sector 7-G, como inspector de seguridad. Es amante de las rosquillas y la cerveza Duff.",
                R.drawable.homero,
                0F
            )
        )
        friends.add(
            Main3Activity(
                    "Marge",
                    "Marge Bouvier Simpson fue criada en una zona rural de la Norteamérica sureña. Se dedica a ama de casa a tiempo completo. Suele estar todo el día en casa, limpiando, cocinando o cuidando de Maggie y por regla general no sale más que para hacer las compras.",
                    R.drawable.marge,
                    0F
                )
            )
        friends.add(
            Main3Activity(
                    "Bart",
                    "Bart Simpson es un niño al que poco le gusta estudiar, asiste con regularidad a la escuela. Prefiere pasar su tiempo libre fuera de casa, desatendiendo sus tareas escolares, socializándose con sus amigos, planeando bromas o travesuras. Es hábil con la patineta y en hacer grafitis con spray.",
                    R.drawable.bart,
                    0F
                )
            )
        friends.add(
            Main3Activity(
                    "Lisa",
                    "Lisa Simpson es una sobresaliente estudiante de primaria. A veces no se relaciona con los niños de la escuela y eso hace que se concentre más en el estudio. Le encanta leer, escribir sus pensamientos más profundos en un diario y realizar tareas escolares casi de nivel universitario.",
                    R.drawable.lisa,
                    0F
                )
            )
        friends.add(
            Main3Activity(
                    "Maggie",
                    "Maggie Simpson es una bebé desatendida en una familia disfuncional, ha tenido que desarrollar una forzada autosuficiencia. Siente un gran apego por su madre, en contraste con su padre, quien le presta muy poca atención. Secretamente es muy hábil con las armas.",
                    R.drawable.maggie,
                    0F
                )
            )
        friends.add(
            Main3Activity(
                    "Abraham",
                    "Abraham Simpson es el abuelo de la familia, pasa la mayor parte de su tiempo en el hogar de jubilados de Springfield, hace cosas típicas de ancianos como escribir cartas de protesta a organizaciones, mirar por la ventana, retrasar colas con quejidos, estar pendiente del teléfono y esperar visitas.",
                    R.drawable.abbe,
                    0F
                )
            )

        val adapter = Adaptador1(friends)
        adapter.setOnFriendListener(this)
        binding.lista.adapter = adapter
    }

    override fun onFriendClick(friend: Main3Activity) {
        super.onFriendClick(friend)
        val intent = Intent(this, Main2Activity::class.java)
        intent.putExtra(FRIEND_EXTRA, friend)
        startActivityForResult(intent, Main2Activity.DETAIL_CODE)

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == Main2Activity.DETAIL_CODE && resultCode == Activity.RESULT_OK) {
            data?.let {
                if (it.hasExtra(FRIEND_EXTRA)) {
                    val updateFriend = it.getParcelableExtra(FRIEND_EXTRA) as Main3Activity
                    updateFriendAtRecycler(updateFriend)
                    Toast.makeText(
                        applicationContext,
                        "Se actualizo a ${updateFriend.name}",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
        }
    }

    private fun updateFriendAtRecycler(updateFriend: Main3Activity) {
        (lista.adapter as Adaptador1).updatePerson(friend = updateFriend)
    }
}

    /*
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }*/
//}
