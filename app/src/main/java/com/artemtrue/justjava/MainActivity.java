package com.artemtrue.justjava;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import java.text.NumberFormat;

/**
 * This app displays an order form to order coffee.
 */
public class MainActivity extends ActionBarActivity {

    int quantity = 0;
    String thanks = "Thank You!";
    String enteredName = "";
    String kolichestvo = "Quantity: ";
    String addWhippedCream = "Add whipped cream? ";
    String addChocolate = "Add Chocolate? ";
    int price = 0;
    String hasWhippedCream;

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
        int price = calculatePrice();

        //Берем введенное имя и выводим его в строке заказа
        EditText nameInputField = (EditText) findViewById(R.id.name_input_field);
        enteredName = "Name: " + nameInputField.getText().toString();

        String priceMessage = createOrderSummary(price);
        displayMessage(priceMessage);
    }

    public void increaseValue(View view) {

        //display(quantity + 1);
        quantity = quantity + 1;
        displayQuantity(quantity);
    }

    public void decreaseValue(View view) {

        //display(quantity - 1);
        quantity = quantity - 1;
        if(quantity <= 0)
        {
            quantity = 0;
        }
        displayQuantity(quantity);
    }

    /**
     * This method displays the given quantity value on the screen.
     */
    private void displayQuantity(int number) {
        TextView quantityTextView = (TextView) findViewById(
                R.id.quantity_text_view);
        quantityTextView.setText("" + number);
    }

    /* private void displayPrice(int number) {
        TextView priceTextView = (TextView) findViewById(R.id.price_text_view);
        priceTextView.setText(NumberFormat.getCurrencyInstance().format(number));
    } */

    private void displayMessage(String message) {
        TextView orderSummaryTextView = (TextView) findViewById(R.id.order_summary_text_view);
        orderSummaryTextView.setText(message);
    }

    private int calculatePrice() {
        price = quantity * 5;
        return price;
    }


    public String createOrderSummary(int price) {

        CheckBox whippedCream = (CheckBox) findViewById(R.id.whip_checkbox);
        CheckBox chocolate = (CheckBox) findViewById(R.id.choco_checkbox);

        boolean whippedCreamChecked = whippedCream.isChecked();
        boolean chocolateChecked = chocolate.isChecked();

        //делает вывод whipped cream true, если стоит чек
        if(whippedCream.isChecked())
        {
            String priceMessage = enteredName + "\n"
                    + addWhippedCream + whippedCreamChecked + "\n"
                    + addChocolate + chocolateChecked + "\n"
                    + kolichestvo + quantity +
                    "\nTotal: $" + price +
                    "\n" + thanks;
            return priceMessage;
        }

        //делает вывод chocolate true, если стоит чек
        if(chocolate.isChecked())
        {
            String priceMessage = enteredName + "\n"
                    + addWhippedCream + whippedCreamChecked + "\n"
                    + addChocolate + chocolateChecked + "\n"
                    + kolichestvo + quantity +
                    "\nTotal: $" + price +
                    "\n" + thanks;
            return priceMessage;
        }

        //выводит для whipped cream и chocolate false, если не стоят чеки
        String priceMessage = enteredName + "\n"
                + addWhippedCream + whippedCreamChecked + "\n"
                + addChocolate + chocolateChecked + "\n"
                + kolichestvo + quantity +
                "\nTotal: $" + price +
                "\n" + thanks;

        return priceMessage;


        /**По курсу Udacity:
         *
         * boolean hasWhippedCream = whippedCream.isChecked();
         *String priceMessage = name + "\n" + addWhippedCream + whippedCream + "\n" + kolichestvo + quantity + "\nTotal: $" + price + "\n" + thanks;
         * */
    }
}