package com.example.myapplication

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.SimpleItemAnimator
import com.example.myapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val redeemData = listOf(
            Redeem(
                "iPhone or iPad ",
                listOf(
                    "Copy the code that you will receive after the transaction.",
                    "Copy the code that you will receive after the transaction.",
                    "Copy the code that you will receive after the transaction.",
                    "Copy the code that you will receive after the transaction.",
                    "Copy the code that you will receive after the transaction.",
                    "Copy the code that you will receive after the transaction.",
                    "Copy the code that you will receive after the transaction.",
                    "Copy the code that you will receive after the transaction.",
                    "Copy the code that you will receive after the transaction.",
                    "Copy the code that you will receive after the transaction.",
                    "Copy the code that you will receive after the transaction.",
                    "Copy the code that you will receive after the transaction.",
                    "Copy the code that you will receive after the transaction.",
                    "Copy the code that you will receive after the transaction.",
                    "Tap on the sign-in button or on the profile.",
                    "Tap Redeem Gift Card/Code.",
                    "Tap on Enter Code Manually and enter the code."

                )
            ),
            Redeem(
                "Mac device",
                listOf(
                    "Copy the code that you will receive after the transaction.",
                    "Tap on the sign-in button or on the profile.",
                    "Tap Redeem Gift Card/Code.",
                    "Tap on Enter Code Manually and enter the code."
                )
            ),
            Redeem(
                "Android device",
                listOf(
                    "Copy the code that you will receive after the transaction.",
                    "Tap on the sign-in button or on the profile.",
                    "Tap Redeem Gift Card/Code.",
                    "Tap on Enter Code Manually and enter the code."
                )
            )
        )
        binding.redeemStepsTitle.text = "How to Redeem App Store Code ?"
        binding.redeemStepsSubtitle.text = "Follow the instructions below for your device to redeem the App Store code you purchased."
        binding.sectionRecyclerView.layoutManager = LinearLayoutManager(this)
        binding.sectionRecyclerView.adapter = RedeemSectionAdapter(redeemData)
//        (binding.sectionRecyclerView.itemAnimator as SimpleItemAnimator).supportsChangeAnimations = false
//        binding.sectionRecyclerView.setHasFixedSize(true)
    }
}