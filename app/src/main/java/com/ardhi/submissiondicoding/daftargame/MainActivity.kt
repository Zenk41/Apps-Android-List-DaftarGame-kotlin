package com.ardhi.submissiondicoding.daftargame

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_game_detail.*
import kotlinx.android.synthetic.main.activity_game_detail.tv_item_name
import kotlinx.android.synthetic.main.item_row_game.*

class MainActivity : AppCompatActivity() {
    private lateinit var rvGame: RecyclerView
    private var list: ArrayList<Game> = arrayListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val actionbar = supportActionBar
        actionbar!!.title="Daftar Game"

        rvGame = findViewById(R.id.rv_game)
        rvGame.setHasFixedSize(true)

        list.addAll(GameData.listData)
        showRecyclerList()
    }
    private fun showSelectedGame(game:Game){
        val pindahIntent = Intent(this@MainActivity, GameDetail::class.java)
        pindahIntent.putExtra("extra_photo",game.photo)
        pindahIntent.putExtra("extra_name",game.name)
        pindahIntent.putExtra("extra_pengembang",game.pengembang)
        pindahIntent.putExtra("extra_rating",game.rating)
        pindahIntent.putExtra("extra_genre",game.genre)
        pindahIntent.putExtra("extra_platform",game.platform)
        pindahIntent.putExtra("extra_detail",game.detail)
        startActivity(pindahIntent)

    }
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_about, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        setMode(item.itemId)
        return super.onOptionsItemSelected(item)
    }
    private fun showRecyclerList() {
        rvGame.layoutManager = LinearLayoutManager(this)
        val listGameAdapter = ListGameAdapter(list)
        rvGame.adapter = listGameAdapter

        listGameAdapter.setOnItemClickCallback(object : ListGameAdapter.OnItemClickCallback {
            override fun onItemClicked(data: Game) {

                showSelectedGame(data)
            }
        })
    }
    private fun setMode(selectedMode: Int) {
        when (selectedMode) {
            R.id.aboutMe -> {
                val pindahIntent = Intent(this@MainActivity, about::class.java)
                startActivity(pindahIntent)
            }
        }
    }
}

