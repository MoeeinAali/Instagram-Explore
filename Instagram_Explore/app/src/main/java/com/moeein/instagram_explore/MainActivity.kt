package com.moeein.instagram_explore

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.ImageView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.moeein.instagram_explore.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    @SuppressLint("DiscouragedApi")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val url = listOf(
            "https://dunijet.ir/YaghootAndroidFiles/ExplorePics/img1.png",
            "https://dunijet.ir/YaghootAndroidFiles/ExplorePics/img2.png",
            "https://dunijet.ir/YaghootAndroidFiles/ExplorePics/img3.png",
            "https://dunijet.ir/YaghootAndroidFiles/ExplorePics/img4.png",
            "https://dunijet.ir/YaghootAndroidFiles/ExplorePics/img5.png",
            "https://dunijet.ir/YaghootAndroidFiles/ExplorePics/img6.png",
            "https://dunijet.ir/YaghootAndroidFiles/ExplorePics/img7.png",
            "https://dunijet.ir/YaghootAndroidFiles/ExplorePics/img8.png",
            "https://dunijet.ir/YaghootAndroidFiles/ExplorePics/img9.png",
            "https://dunijet.ir/YaghootAndroidFiles/ExplorePics/img10.png",
            "https://dunijet.ir/YaghootAndroidFiles/ExplorePics/img11.png",
            "https://dunijet.ir/YaghootAndroidFiles/ExplorePics/img12.png",
            "https://dunijet.ir/YaghootAndroidFiles/ExplorePics/img13.png",
            "https://dunijet.ir/YaghootAndroidFiles/ExplorePics/img14.png",
            "https://dunijet.ir/YaghootAndroidFiles/ExplorePics/img15.png",
            "https://dunijet.ir/YaghootAndroidFiles/ExplorePics/img16.png",
            "https://dunijet.ir/YaghootAndroidFiles/ExplorePics/img17.png",
            "https://dunijet.ir/YaghootAndroidFiles/ExplorePics/img18.png"
        )

        if (NetworkChecker(this).isInternetConnected) {

            val glide = Glide.with(this)
            url.forEachIndexed { index, element ->
                val imageName = "img${index + 1}"
                val resId = binding.root.resources.getIdentifier(
                    imageName,
                    "id",
                    binding.root.context.packageName
                )

                if (resId != 0) {
                    val imageView = binding.root.findViewById<ImageView>(resId)
                    glide
                        .load(element)
                        .placeholder(R.drawable.img_loading)
                        .error(R.drawable.img_error)
                        .into(imageView)
                }

            }

        } else {
            Toast.makeText(this, "No Internet!!!", Toast.LENGTH_SHORT).show()
        }


    }
}