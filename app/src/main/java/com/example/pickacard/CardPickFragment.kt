package com.example.pickacard

import android.content.Intent
import android.content.res.Resources
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.fragment.app.Fragment
import java.util.*

class CardPickFragment : Fragment() {
    private var cards: Vector<Card> = Vector<Card>()
    private var cards_idxs: MutableMap<Card, Int> = mutableMapOf<Card, Int>()
    private var selected_cards: Vector<Card> = Vector<Card>()
    private lateinit var card_layout: LinearLayout
    private lateinit var card_layout_02: LinearLayout
    private lateinit var card_layout_03: LinearLayout
    private val wanted_cards: Int = 9


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        cards
        val root: View = inflater.inflate(R.layout.activity_cardslideshow_layout, container, false)
        card_layout = root.findViewById(R.id.card_layout)
        card_layout_02 = root.findViewById(R.id.card_layout_02)
        card_layout_03 = root.findViewById(R.id.card_layout_03)
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        for (i in 0..wanted_cards)
        {
            var new_card: Card = CardFactory.newRandomCard(requireContext())

            new_card.setOnClickListener {
                new_card.reverseCard()
            }


            cards.add(new_card)
            card_layout.addView(new_card)

        }

        super.onViewCreated(view, savedInstanceState)
    }
}