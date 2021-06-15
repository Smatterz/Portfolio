package com.example.matt.myfirstapp;

import android.graphics.Color;

/**
 * Created by Matt on 4/06/2015.
 */
public class Card {
    public String myColour;
    public int intColour;
    public int myValue;

    public Card( String colour, int number )
    {
        myColour = colour;
        myValue = number;

        if (colour == "Red")
        {
        intColour = Color.RED;
        }

        if (colour == "Blue")
        {
            intColour = Color.BLUE;
        }

        if (colour == "Green")
        {
            intColour = Color.GREEN;
        }

        if (colour == "Yellow")
        {
            intColour = Color.YELLOW;
        }
    }

    public String name()
    {
        return myColour + " " + myValue;
    }
}
