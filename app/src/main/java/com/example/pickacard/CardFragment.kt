package com.example.pickacard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment

class CardFragment() : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.card_layout, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val card: Card = view.findViewById(R.id.card2)
        card.arcana = ArcanaFactory.StringtoArcana(arguments?.getString("arcana")!!)
        card.showCard()

        var title: TextView = view.findViewById(R.id.card_title)
        title.setText(card.title())

        super.onViewCreated(view, savedInstanceState)
    }
}

object CardFragmentFactory
{
    fun newInstance(arcana_str: String?) : CardFragment {
        val args = Bundle()
        args.putString("arcana", arcana_str)

        val fragment = CardFragment()
        fragment.arguments = args
        return fragment
    }
}