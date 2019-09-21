package com.example.diego_rivasshop;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;

public class MenuActivity extends AppCompatActivity {

    private final double AMETHYST_PRICE= 137.52;
    private final double RUBY_PRICE = 515.7;
    private final double YELLOW_DIAMOND_PRICE = 10000;
    private final double SAPPHIRE_PRICE = 429.75;
    private final double PHOSPHOPHYLLITE_PRICE = 800;
    private final double TPS_PERCENTAGE = .05;
    private final double TVQ_PERCENTAGE = .09975;

    private int amethystAmoount = 0;
    private int rubyAmount = 0;
    private int yellowDiamondAmont = 0;
    private int sapphireAmount = 0;
    private int phosphophylliteAmount = 0;
    private double subtotal;
    private double tps;
    private double tvq;
    private double total;
    private TextView amethystView;
    private TextView rubyView;
    private TextView yellowDiamondView;
    private TextView sapphireView;
    private TextView phosphophylliteView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        amethystView = findViewById(R.id.amethyst_amount_text);
        rubyView = findViewById(R.id.ruby_amount_text);
        yellowDiamondView = findViewById(R.id.yellow_diamond_amount_text);
        sapphireView = findViewById(R.id.sapphire_amount_text);
        phosphophylliteView = findViewById(R.id.phosphophyllite_amount_text);

        //Restoring values
        if (savedInstanceState != null) {
            //Retrieving values
            amethystAmoount = savedInstanceState.getInt("amethystCount");
            rubyAmount = savedInstanceState.getInt("rubyCount");
            yellowDiamondAmont = savedInstanceState.getInt("yellowDiamondCount");
            sapphireAmount = savedInstanceState.getInt("sapphireCount");
            phosphophylliteAmount = savedInstanceState.getInt("phosphophylliteCount");

            //Setting values to text views
            amethystView.setText(String.valueOf(amethystAmoount));
            rubyView.setText(String.valueOf(rubyAmount));
            yellowDiamondView.setText(String.valueOf(yellowDiamondAmont));
            sapphireView.setText(String.valueOf(sapphireAmount));
            phosphophylliteView.setText(String.valueOf(phosphophylliteAmount));
        }
    }

    /**
     * Method that launch CheckoutActivity
     * @param view Current view
     */
    public void launchCheckoutActivity(View view) {
        Intent intent = new Intent(this, CheckoutActivity.class);
        intent.putExtra("sub", subtotal);
        intent.putExtra("tps", tps);
        intent.putExtra("tvq", tvq);
        intent.putExtra("total", total);
        startActivity(intent);
    }

    /**
     * Method adds 1 item to the cart each time the button "add" is clicked
     * @param view the view that is being clicked
     */
    public void addItemAll(View view) {
        if (view.equals(findViewById(R.id.add_amethyst_button))) {
            amethystAmoount++;
            subtotal += AMETHYST_PRICE;
            amethystView.setText(Integer.toString(amethystAmoount));
        }
        if (view.equals(findViewById(R.id.add_ruby_button))) {
            rubyAmount++;
            subtotal += RUBY_PRICE;
            rubyView.setText(Integer.toString(rubyAmount));
        }
        if (view.equals(findViewById(R.id.add_yellow_diamond_button))) {
            yellowDiamondAmont++;
            subtotal += YELLOW_DIAMOND_PRICE;
            yellowDiamondView.setText(Integer.toString(yellowDiamondAmont));
        }
        if (view.equals(findViewById(R.id.add_sapphire_button))) {
            sapphireAmount++;
            subtotal += SAPPHIRE_PRICE;
            sapphireView.setText(Integer.toString(sapphireAmount));
        }
        if (view.equals(findViewById(R.id.add_phosphophyllite_button))) {
            phosphophylliteAmount++;
            subtotal += PHOSPHOPHYLLITE_PRICE;
            phosphophylliteView.setText(Integer.toString(phosphophylliteAmount));
        }
        calculateTotal();
    }

    /**
     * Removes an item from the cart each time the button "remove" is clicked
     * @param view the view being clicked
     */
    public void removeItemAll(View view) {
        if (view.equals(findViewById(R.id.remove_amethyst_button)))
            if (amethystAmoount > 0 )  {
                amethystAmoount--;
                subtotal -= AMETHYST_PRICE;
                amethystView.setText(Integer.toString(amethystAmoount));
            }
        if (view.equals(findViewById(R.id.remove_ruby_button)))
            if (rubyAmount > 0 ) {
                rubyAmount--;
                subtotal -= RUBY_PRICE;
                rubyView.setText(Integer.toString(rubyAmount));
            }
        if (view.equals(findViewById(R.id.remove_yellow_diamond_button)))
            if (yellowDiamondAmont > 0 ) {
                yellowDiamondAmont--;
                subtotal -= YELLOW_DIAMOND_PRICE;
                yellowDiamondView.setText(Integer.toString(yellowDiamondAmont));
            }
        if (view.equals(findViewById(R.id.remove_sapphire_button)))
            if (sapphireAmount > 0 ) {
                sapphireAmount--;
                subtotal -= SAPPHIRE_PRICE;
                sapphireView.setText(Integer.toString(sapphireAmount));
            }
        if (view.equals(findViewById(R.id.remove_phosphophyllite_button)))
            if (phosphophylliteAmount > 0 ) {
                phosphophylliteAmount--;
                subtotal -= PHOSPHOPHYLLITE_PRICE;
                phosphophylliteView.setText(Integer.toString(phosphophylliteAmount));
            }
        calculateTotal();
    }

    /**
     * Method that calculates the total price with the taxes
     * @return the total price with taxes
     */
    public void calculateTotal() {
        tps = subtotal * TPS_PERCENTAGE;
        tvq = subtotal * TVQ_PERCENTAGE;
        total = subtotal + tps + tvq;
    }

    /**
     * Method that saves the values when screen goes to landscape
     * @param outState the save state
     */
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        //Saving the values
        outState.putInt("amethystCount", amethystAmoount);
        outState.putInt("rubyCount", rubyAmount);
        outState.putInt("yellowDiamondCount", yellowDiamondAmont);
        outState.putInt("sapphireCount", sapphireAmount);
        outState.putInt("phosphophylliteCount", phosphophylliteAmount);
    }

}
