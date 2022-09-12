package com.example.pickacard

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.fragment.app.Fragment
import java.util.*

class CardPickFragment : Fragment() {
    private var cards: Vector<Card> = Vector<Card>()
    private var selected_cards: Vector<Card> = Vector<Card>()
    private lateinit var card_layout: LinearLayout
    var wanted_cards: Int = 0


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        cards
        val root: View = inflater.inflate(R.layout.activity_cardslideshow_layout, container, false)
        card_layout = root.findViewById(R.id.card_layout)

        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        for (i in 1..wanted_cards)
        {
            var new_card: Card = CardFactory.newRandomCard(requireContext())

            val bruh = LinearLayout.LayoutParams(500, 2000)
            bruh.setMargins(-150, 0, -150, 0)


            new_card.layoutParams = bruh
            //new_card.getLayoutParams().width = 2;
            new_card.setPadding(0, 0, 0, 0)

            new_card.setOnClickListener {
                if (selected_cards.contains(new_card))
                {
                    // Deselect this card.

                    selected_cards.remove(new_card)
                } else {
                    // Select this card!

                    selected_cards.add(new_card)
                }

                if (selected_cards.size >= 3)
                {
                    val intent = Intent(context, CardShowHandActivity::class.java)
                    for (i in (0..selected_cards.size-1))
                    {
                        intent.putExtra(i.toString(), selected_cards[i].arcana.show())
                    }

                    startActivity(intent)
                }

                new_card.reverseCard()
            }


            new_card.reverseCard()
            cards.add(new_card)
            card_layout.addView(new_card)

        }

        super.onViewCreated(view, savedInstanceState)
    }
}