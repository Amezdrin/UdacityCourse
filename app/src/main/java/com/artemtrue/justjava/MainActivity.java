package com.artemtrue.justjava;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.TextView;

import java.text.NumberFormat;

/**
 * This app displays an order form to order coffee.
 */
public class MainActivity extends ActionBarActivity {

    int quantity = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * This method is called when the order button is clicked.
     */
    public void submitOrder(View view) {
        /** по клику на кнопку Order вызывается этот метод, который вызывает
         * метод display в котором в текствью пихается текст и, в итоге, отображается 1 */
        //display(quantity);
        displayPrice(quantity * 5);
    }

    public void increaseValue(View view) {

        //display(quantity + 1);
        quantity = quantity + 1;
        display(quantity);
    }

    public void decreaseValue(View view) {

        //display(quantity - 1);
        quantity = quantity - 1;
        if(quantity <= 0)
        {
            quantity = 0;
        }
        display(quantity);
    }

    /**
     * This method displays the given quantity value on the screen.
     */
    private void display(int number) {
        TextView quantityTextView = (TextView) findViewById(
                R.id.quantity_text_view);
        quantityTextView.setText("" + number);
    }

    private void displayPrice(int number) {
        TextView priceTextView = (TextView) findViewById(R.id.price_text_view);
        priceTextView.setText(NumberFormat.getCurrencyInstance().format(number));
    }
}