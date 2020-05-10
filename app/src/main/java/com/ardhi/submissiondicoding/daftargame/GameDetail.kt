package com.ardhi.submissiondicoding.daftargame

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import kotlinx.android.synthetic.main.activity_game_detail.*

class GameDetail : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game_detail)
        val actionbar = supportActionBar
        actionbar!!.title = "Detail Game"
        actionbar.setDisplayHomeAsUpEnabled(true)

        val tvSetName = findViewById<TextView>(R.id.tv_item_name)
        val imgSetPhoto = findViewById<ImageView>(R.id.img_item_photo)
        val tvPengembang = findViewById<TextView>(R.id.tv_item_pengembang)
        val tvRating = findViewById<TextView>(R.id.tv_item_rating)
        val tvGenre = findViewById<TextView>(R.id.tv_item_genre)
        val tvPlatform = findViewById<TextView>(R.id.tv_item_platform)
        val tvDetail = findViewById<TextView>(R.id.tv_item_detail)
        val tvButton = findViewById<Button>(R.id.btn_set_favorite)

        val tName  = intent.getStringExtra(EXTRA_NAME)
        val tImg = intent.getIntExtra(EXTRA_PHOTO,0)
        val tPengembang = intent.getStringExtra(EXTRA_PENGEMBANG)
        val tRating = intent.getStringExtra(EXTRA_RATING)
        val tGenre = intent.getStringExtra(EXTRA_GENRE)
        val tPlatform = intent.getStringExtra(EXTRA_PLATFORM)
        val tDetail = intent.getStringExtra(EXTRA_DETAIL)

        tvSetName.text = tName
        Glide.with(this)
            .load(tImg)
            .apply(RequestOptions())
            .into(imgSetPhoto)
        tvPengembang.text = tPengembang
        tvRating.text = tRating
        tvGenre.text = tGenre
        tvPlatform.text = tPlatform
        tvDetail.text = tDetail

        tvButton.setOnClickListener{
            Toast.makeText(this,"Game Favoriteku Adalah "+ tName +", Yang di kembangkan Oleh : " + tPengembang,Toast.LENGTH_SHORT).show()}
    }
    companion object {
            const val EXTRA_NAME = "extra_name"
            const val EXTRA_PHOTO = "extra_photo"
            const val EXTRA_PENGEMBANG = "extra_pengembang"
            const val EXTRA_RATING = "extra_rating"
            const val EXTRA_GENRE = "extra_genre"
            const val EXTRA_PLATFORM = "extra_platform"
            const val EXTRA_DETAIL = "extra_detail"
        }
        override fun onSupportNavigateUp(): Boolean {
            onBackPressed()
            return true
    }
}