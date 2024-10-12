package com.example.lab_week_06

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.lab_week_06.model.CatBreed
import com.example.lab_week_06.model.CatModel
import com.example.lab_week_06.model.Gender

class MainActivity : AppCompatActivity() {
    private val recyclerView: RecyclerView by lazy {
        findViewById(R.id.recycler_view)
    }
    private val catAdapter by lazy {
        CatAdapter(layoutInflater, GlideImageLoader(this), object:
            CatAdapter.OnClickListener {
            override fun onItemClick(cat: CatModel) = showSelectionDialog(cat)
        })
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recyclerView.adapter = catAdapter
        recyclerView.layoutManager = LinearLayoutManager(this,
            LinearLayoutManager.VERTICAL, false)
        val itemTouchHelper = ItemTouchHelper(catAdapter.swipeToDeleteCallback)
        itemTouchHelper.attachToRecyclerView(recyclerView)
        catAdapter.setData(
            listOf(
                CatModel(
                    Gender.Male,
                    CatBreed.BalineseJavanese,
                    "Fred",
                    "Silent and deadly",
                    "https://cdn2.thecatapi.com/images/7dj.jpg"
                ),
                CatModel(
                    Gender.Female,
                    CatBreed.ExoticShorthair,
                    "Wilma",
                    "Cuddly assassin",
                    "https://cdn2.thecatapi.com/images/egv.jpg"
                ),
                CatModel(
                    Gender.Unknown,
                    CatBreed.AmericanCurl,
                    "Curious George",
                    "Award winning investigator",
                    "https://cdn2.thecatapi.com/images/bar.jpg"
                ),
                CatModel(
                    Gender.Male,
                    CatBreed.Bengal,
                    "Tigger",
                    "Playful and energetic",
                    "https://cdn2.thecatapi.com/images/bne.jpg"
                ),
                CatModel(
                    Gender.Female,
                    CatBreed.Birman,
                    "Snowflake",
                    "Gentle and affectionate",
                    "https://cdn2.thecatapi.com/images/bir.jpg"
                ),
                CatModel(
                    Gender.Male,
                    CatBreed.Bombay,
                    "Midnight",
                    "Mysterious and sleek",
                    "https://cdn2.thecatapi.com/images/bom.jpg"
                ),
                CatModel(
                    Gender.Female,
                    CatBreed.BritishShorthair,
                    "Duchess",
                    "Elegant and refined",
                    "https://cdn2.thecatapi.com/images/bsl.jpg"
                ),
                CatModel(
                    Gender.Unknown,
                    CatBreed.Burmese,
                    "Copper",
                    "Social and talkative","https://cdn2.thecatapi.com/images/bur.jpg"
                ),
                CatModel(
                    Gender.Male,
                    CatBreed.Chartreux,
                    "Smokey",
                    "Quiet and independent",
                    "https://cdn2.thecatapi.com/images/cha.jpg"
                ),
                CatModel(
                    Gender.Female,
                    CatBreed.DevonRex,
                    "Pixie",
                    "Mischievous and playful",
                    "https://cdn2.thecatapi.com/images/dvr.jpg"
                )
            )
        )
    }

    private fun showSelectionDialog(cat: CatModel) {
        AlertDialog.Builder(this)
            .setTitle("Cat Selected")
            .setMessage("You have selected cat ${cat.name}")
            .setPositiveButton("OK") { _, _ -> }.show()
    }
}