package com.example.matt.myfirstapp;

/**
 * Created by Matt on 5/06/2015.
 */
public class CardBut {
    private String myColour;
    private int myValue;

    public CardBut( String colour, int number )
    {
        myColour = colour;
        myValue = number;
    }

    public String name()
    {
        return myColour + " " + myValue;
    }
}
