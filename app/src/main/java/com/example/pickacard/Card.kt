package com.example.pickacard

import android.content.Context
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.AttributeSet
import android.view.ViewGroup
import android.view.ViewGroup.LayoutParams.WRAP_CONTENT
import android.widget.ImageView
import androidx.appcompat.widget.AppCompatImageView


class Card @JvmOverloads constructor(
           context: Context,
           attrs: AttributeSet? = null,
           defStyleAttr: Int = 0) : AppCompatImageView(context, attrs, defStyleAttr) {
    var arcana: Arcana = ArcanaFactory.newRandomArcana()
    var reversed = false

    init {
        layoutParams = ViewGroup.LayoutParams(WRAP_CONTENT, WRAP_CONTENT)
        scaleType = ScaleType.FIT_XY
        adjustViewBounds = true

        showCard()
    }

    fun showCard()
    {
        if (reversed)
        {
            val id: Int = resources.getIdentifier("back", "drawable", context.packageName)
            setImageResource(id)
        } else {
            showCard(arcana.show())
        }
    }

    fun showBack()
    {
        setImageResource(R.drawable.back)
    }

    fun showCard(arcana_str: String?)
    {
        val id: Int = resources.getIdentifier(arcana_str, "drawable", context.packageName)
        setImageResource(id)
    }

    fun title() : String
    {
        return when (arcana.arcana)
        {
            Arcana.ArcanaType.MAJOR_ARCANA ->
            {
                val minor_arcana_names = resources.getString(R.string.major_arcana_names)
                    .split(',')
                    .toTypedArray()

                minor_arcana_names[arcana.value]
            }

            else -> arcana.getTitle() + " of " + arcana.suit.getSuitName()
        }
    }

    fun reverseCard()
    {
        reversed = !reversed
        showCard()
    }
}

object CardFactory {
    fun newRandomCard(context: Context): Card {
        // Cards can start reversed or not reversed, so we should run the reverseCard() function
        val new_card = Card(context, null, 0)



        return new_card
    }
}