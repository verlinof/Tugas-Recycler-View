package com.example.tugasrecyclerview

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.tugasrecyclerview.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var newPahlawanList: ArrayList<Pahlawan>
    lateinit var gambarPahlawan: Array<Int>
    lateinit var namaPahlawan: Array<String>
    lateinit var bioPahlawan: Array<String>
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        gambarPahlawan = arrayOf(
            R.drawable.pattimura,
            R.drawable.kartini,
            R.drawable.ki_hajar_dewantara,
            R.drawable.ahmad_yani,
            R.drawable.sultan_hasanudin
        )

        namaPahlawan = arrayOf(
            "Pattimura",
            "R.A Kartini",
            "Ki Hajar Dewantara",
            "Ahmad Yani",
            "Sultan Hasanudin"
        )

        bioPahlawan = arrayOf(
            getString(R.string.bio_pattimura),
            getString(R.string.bio_kartini),
            getString(R.string.bio_ki_hajar_dewantara),
            getString(R.string.bio_ahmad_yani),
            getString(R.string.bio_sultan_hasanuddin)
        )

        with(binding) {
            rvPahlawan.layoutManager = LinearLayoutManager(this@MainActivity);
            rvPahlawan.setHasFixedSize(true)

            newPahlawanList = arrayListOf<Pahlawan>()
            getUserData(newPahlawanList, rvPahlawan)
        }
    }

    private fun getUserData(list: ArrayList<Pahlawan>, recyclerView: RecyclerView) {
        for(i in gambarPahlawan.indices) {
            val pahlawan = Pahlawan(gambarPahlawan[i], namaPahlawan[i], bioPahlawan[i])
            newPahlawanList.add(pahlawan)
        }

        var adapter = PahlawanAdapter(list)
        recyclerView.adapter = adapter
        adapter.setOnItemClickListener(object : PahlawanAdapter.onItemClickListener{
            override fun onItemClick(position: Int) {
                val intent = Intent(this@MainActivity, PahlawanDetail::class.java)
                intent.putExtra("nama pahlawan", newPahlawanList[position].namaPahlawan)
                intent.putExtra("gambar pahlawan", newPahlawanList[position].gambarPahlawan)
                intent.putExtra("bio pahlawan", newPahlawanList[position].bioPahlawan)

                startActivity(intent)
            }

        })
    }

}