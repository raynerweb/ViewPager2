package br.com.raynerweb.viewpagerexample

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.PagerSnapHelper
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val lista = listOf("Pagina 1", "Pagina 2", "Pagina 3", "Pagina 4")

        val pageSnapHelper = PagerSnapHelper()
        pageSnapHelper.attachToRecyclerView(recycler)
        recycler.addItemDecoration(LinePagerIndicatorDecoration())
        recycler.adapter = ViewAdapter(lista)
        recycler.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
    }

}
