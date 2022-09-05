package com.example.pickacard

import android.text.TextUtils.substring


enum class Suit(val z: Char)
{
    WANDS('w'),
    CUPS('c'),
    SWORDS('s'),
    PENTACLES('p');

    fun getSuitLetter() : Char
    {
        return z
    }

    fun getSuitName() : String
    {
        return when (this) {
            WANDS ->
                "Wands"
            CUPS ->
                "Cups"
            SWORDS ->
                "Swords"
            PENTACLES ->
                "Pentacles"
        }
    }
}

class Arcana(val arcana: ArcanaType, val suit: Suit, val value: Int)
{
    enum class ArcanaType(val z: Char)
    {
        MAJOR_ARCANA('z'),
        MINOR_ARCANA('a');

        fun getArcanaLetter() : Char
        {
            return z
        }
    }

    constructor(suit: Suit, value: Int) : this(ArcanaType.MINOR_ARCANA, suit, value)
    constructor(value: Int) : this(ArcanaType.MAJOR_ARCANA, Suit.WANDS, value)

    fun show() : String
    {
        val suitletter = suit.getSuitLetter()
        val arcanatypeletter = arcana.getArcanaLetter()
        val value = value.toString()

        return when(arcana) {
            ArcanaType.MINOR_ARCANA ->
                "$arcanatypeletter$suitletter$value"
            ArcanaType.MAJOR_ARCANA ->
                "$arcanatypeletter$value"
        }
    }

    fun getTitle() : String
    {
        return when (value)
        {
            0 -> "Ace"
            10 -> "Page"
            11 -> "Knight"
            12 -> "Queen"
            13 -> "King"

            else -> (value+1).toString()
        }
    }
}

object ArcanaFactory
{
    private const val max_minorarcana: Int = 13
    private const val max_majorarcana: Int = 21

    fun newRandomArcana() : Arcana {
        var arcanatype: Arcana.ArcanaType = Arcana.ArcanaType.MAJOR_ARCANA

        if ((0..1).random() == 0) {
            arcanatype = Arcana.ArcanaType.MINOR_ARCANA
        }

        if (arcanatype == Arcana.ArcanaType.MAJOR_ARCANA)
        {
            val arcanavalue: Int = (0..max_majorarcana).random()

            return Arcana(arcanavalue)
        } else {
            val arcanavalue: Int = (0..max_minorarcana).random()
            val arcanasuit: Suit = Suit.values().random()

            return Arcana(arcanasuit, arcanavalue)
        }
    }

    fun StringtoArcana(str: String) : Arcana
    {
        if(str[0] == 'z')
        {
            return Arcana(str.substring(1, str.length).toInt())
        } else {
            val suit: Suit? = Suit.values().associateBy(Suit::z)[str[1]]

            return Arcana(suit!!, str.substring(2, str.length).toInt())
        }
    }
}