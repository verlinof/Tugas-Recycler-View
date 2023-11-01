package com.example.tugasrecyclerview

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.tugasrecyclerview.databinding.ActivityPahlawanDetailBinding

class PahlawanDetail : AppCompatActivity() {

    private lateinit var binding: ActivityPahlawanDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPahlawanDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val bundle = intent.extras
        val namaPahlawan =bundle!!.getString("nama pahlawan")
        val bioPahlawan =bundle!!.getString("bio pahlawan")
        val gambarPahlawan = bundle!!.getInt("gambar pahlawan")

        with(binding) {
            tvNamaPahlawan.text = namaPahlawan
            tvBioPahlawan.text = bioPahlawan
            ivPahlawan.setImageResource(gambarPahlawan)

            btnBack.setOnClickListener{
                var intent = Intent(this@PahlawanDetail, MainActivity::class.java)
                startActivity(intent)
            }
        }
    }
}