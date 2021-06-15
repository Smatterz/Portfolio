package com.example.matt.myfirstapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import java.util.Random;
import android.graphics.Color;

public class MainActivity extends AppCompatActivity {

    //cards in opponent's hand, count of how many is left, assign count a text view
    static Card[] opHand = new Card [20];
    static int opLft = 7;
    static TextView dOHand = null;

    //cards in my hand, count of how many is left, assign cards array of text views
    static Card[] myHand = new Card [20];
    static int myLft = 7;
    static TextView[] choices = new TextView[20];

    //cards in deck, count of how many is left, assign count a text view
    static Card[] deck = new Card[80];
    static int cardsLft = deck.length;
    static TextView dkLeft = null;

    //the top card of the pile, assign it a text view
    static Card topCard = deck[0];
    static TextView top = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_screen);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void ShuffleDeck(Card[] deck)
    {
        int index;
        Card temp;
        Random random = new Random();
        for (int i = deck.length - 1; i > 0; i--) {
            index = random.nextInt(i + 1);
            temp = deck[index];
            deck[index] = deck[i];
            deck[i] = temp;
        }
    }

    public void onStartClick(View v)
    {
        ///move from start screen to in-game screen
        setContentView(R.layout.activity_main);

        System.out.println(Color.DKGRAY);

        //build the deck
        String[] colours = {"Red", "Blue", "Yellow", "Green"};

        int x = 0;
        for ( int i = 0 ; i < colours.length ; i++ ) {
            for ( int j = 0 ; j <= 9 ; j++ ) {
                deck[x] = new Card(colours[i], j);
                deck[x+1] = new Card(colours[i], j);
                x = x + 2;
            }
        }

        ShuffleDeck(deck);

        //Place the first card onto the top card of the pile
        top = (TextView)findViewById(R.id.topCard);
        cardsLft = cardsLft--;
        topCard = deck[79];
        top.setText(topCard.name());
        top.setTextColor(topCard.intColour);

        //create opponent's hand, maximum card limit of 20 cards each
        for (int i = 0 ; i < 7 ; i++) {
            opHand[i] = deck[cardsLft - 1 - i];
        }
        cardsLft = cardsLft - 7;

        //display number of opponent's cards
        dOHand = (TextView)findViewById(R.id.opHand);
        dOHand.setText(Integer.toString(opLft));

        // allocate card buttons on screen to usable variables
        choices[0] = (TextView)findViewById(R.id.card0);
        choices[1] = (TextView)findViewById(R.id.card1);
        choices[2] = (TextView)findViewById(R.id.card2);
        choices[3] = (TextView)findViewById(R.id.card3);
        choices[4] = (TextView)findViewById(R.id.card4);
        choices[5] = (TextView)findViewById(R.id.card5);
        choices[6] = (TextView)findViewById(R.id.card6);
        choices[7] = (TextView)findViewById(R.id.card7);
        choices[8] = (TextView)findViewById(R.id.card8);
        choices[9] = (TextView)findViewById(R.id.card9);
        choices[10] = (TextView)findViewById(R.id.card10);
        choices[11] = (TextView)findViewById(R.id.card11);
        choices[12] = (TextView)findViewById(R.id.card12);
        choices[13] = (TextView)findViewById(R.id.card13);
        choices[14] = (TextView)findViewById(R.id.card14);
        choices[15] = (TextView)findViewById(R.id.card15);
        choices[16] = (TextView)findViewById(R.id.card16);
        choices[17] = (TextView)findViewById(R.id.card17);
        choices[18] = (TextView)findViewById(R.id.card18);
        choices[19] = (TextView)findViewById(R.id.card19);

        //create my hand and display it on screen
        for (int i = 0 ; i < 7 ; i++) {
            myHand[i] = deck[cardsLft - 1 - i];
            choices[i].setText(myHand[i].name());
            choices[i].setBackgroundColor(myHand[i].intColour);
        }
        cardsLft = cardsLft - 7;

        for (int i = 7 ; i < 20 ; i++) {
            myHand[i] = new Card("",-1);
        }

        //display how many cards are left in the deck
        dkLeft = (TextView)findViewById(R.id.cardsLeft);
        dkLeft.setText(Integer.toString(cardsLft));

    }

    public void opponentTurn()
    {

    }

    public void pickupClick(View n) {
        int x = 0;
        int i = 0;
        while (x == 0) {
            if (myHand[i].myValue == -1) {
                myHand[i] = deck[deck.length - cardsLft];
                choices[i].setText(myHand[i].name());
                choices[i].setBackgroundColor(myHand[i].intColour);
                x++;
                cardsLft--;
            }
            i++;
        }
    }

    public void onCardClick(int cardnum) {
        if (myHand[cardnum].intColour == topCard.intColour || myHand[cardnum].myValue == topCard.myValue) {
            topCard = myHand[cardnum];
            top.setText(topCard.name());
            top.setTextColor(myHand[cardnum].intColour);
            choices[cardnum].setText("");
            choices[cardnum].setBackgroundColor(484848);
            myHand[cardnum] = new Card("",-1);
        }
    }

    //methods called for each button press
    public void onCard0Click(View c) {
        onCardClick(0);
    }

    public void onCard1Click(View c) {
        onCardClick(1);
    }

    public void onCard2Click(View c) {
        onCardClick(2);
    }

    public void onCard3Click(View c) {
        onCardClick(3);
    }

    public void onCard4Click(View c) {
        onCardClick(4);
    }

    public void onCard5Click(View c) {
        onCardClick(5);
    }

    public void onCard6Click(View c) {
        onCardClick(6);
    }

    public void onCard7Click(View c) {
        onCardClick(7);
    }

    public void onCard8Click(View c) {
        onCardClick(8);
    }

    public void onCard9Click(View c) {
        onCardClick(9);
    }

    public void onCard10Click(View c) {
        onCardClick(10);
    }

    public void onCard11Click(View c) {
        onCardClick(11);
    }

    public void onCard12Click(View c) {
        onCardClick(12);
    }

    public void onCard13Click(View c) {
        onCardClick(13);
    }

    public void onCard14Click(View c) {
        onCardClick(14);
    }

    public void onCard15Click(View c) {
        onCardClick(15);
    }

    public void onCard16Click(View c) {
        onCardClick(16);
    }

    public void onCard17Click(View c) {
        onCardClick(17);
    }

    public void onCard18Click(View c) {
        onCardClick(18);
    }

    public void onCard19Click(View c) {
        onCardClick(19);
    }


}

