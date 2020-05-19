package br.com.raynerweb.viewpagerexample

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val lista = listOf("Pagina 1", "Pagina 2", "Pagina 3", "Pagina 4")

        viewpager.orientation = ViewPager2.ORIENTATION_HORIZONTAL
        viewpager.adapter = BannerViewPagerAdapter(fragmentActivity = this).apply {
            texts = lista
        }
    }

    class BannerViewPagerAdapter(fragmentActivity: FragmentActivity) :
        FragmentStateAdapter(fragmentActivity) {

        var texts = listOf<String>()
        var collapsed = false

        override fun getItemCount(): Int = texts.size

        override fun createFragment(position: Int): Fragment =
            PageFragment.newInstance(texts[position], collapsed) {
                collapsed = !collapsed
                notifyDataSetChanged()
            }

    }
}
