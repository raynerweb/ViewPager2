package br.com.raynerweb.viewpagerexample

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_page.*

class PageFragment(val listener: () -> Unit) : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ) = inflater.inflate(R.layout.fragment_page, container, false)

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        arguments?.let {
            val text = it.getString(EXTRA_TEXT)
            big.text = text
            small.text = text
            val active = it.getBoolean(EXTRA_ACTIVE, false)

            if (!active) {
                big.visibility = View.VISIBLE
                small.visibility = View.GONE
            } else {
                big.visibility = View.GONE
                small.visibility = View.VISIBLE
            }
        }
        btn_toggle.setOnClickListener {
            listener.invoke()
        }
    }


    companion object {
        const val EXTRA_TEXT = "EXTRA_TEXT"
        const val EXTRA_ACTIVE = "EXTRA_ACTIVE"

        @JvmStatic
        fun newInstance(text: String, active: Boolean, listener: () -> Unit) =
            PageFragment(listener).apply {
                arguments = Bundle().apply {
                    putString(EXTRA_TEXT, text)
                    putBoolean(EXTRA_ACTIVE, active)
                }
            }
    }
}
