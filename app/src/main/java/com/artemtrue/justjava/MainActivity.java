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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /** метод для увеличения количества чашек */
    public void increaseValue(View view) {

        quantity = quantity + 1;
        displayQuantity(quantity);
    }

    /** метод для уменьшения количества чашек */
    public void decreaseValue(View view) {

        quantity = quantity - 1;
        if(quantity <= 0)
        {
            quantity = 0;
        }
        displayQuantity(quantity);
    }

    /** вывод на экран количества чашек для заказа */
    private void displayQuantity(int number) {
        TextView quantityTextView = (TextView) findViewById(
                R.id.quantity_text_view);
        quantityTextView.setText("" + number);
    }

    /** расчет стоимости заказа (кол-во * цену за чашку) */
    private int calculatePrice() {
        price = quantity * 5;
        return price;
    }

    /** метод формирует саммари заказа */
    public String createOrderSummary(int price, boolean whippedCreamChecked, boolean chocolateChecked, String enteredName) {

        //выводит для whipped cream и chocolate false, если не стоят чеки
        String priceMessage = enteredName + "\n"
                + addWhippedCream + whippedCreamChecked + "\n"
                + addChocolate + chocolateChecked + "\n"
                + kolichestvo + quantity +
                "\nTotal: $" + price +
                "\n" + thanks;

        return priceMessage;
    }

    public void submitOrder(View view) {
        /** по клику на кнопку Order вызывается этот метод, который вызывает
         * метод display в котором в текствью пихается текст и, в итоге, отображается 1 */
        int price = calculatePrice();

        CheckBox whippedCream = (CheckBox) findViewById(R.id.whip_checkbox);
        CheckBox chocolate = (CheckBox) findViewById(R.id.choco_checkbox);

        //берем состояния чекбоксов и кладём их в переменные
        boolean whippedCreamChecked = whippedCream.isChecked();
        boolean chocolateChecked = chocolate.isChecked();

        //Берем введенное имя и выводим его в строке заказа
        EditText nameInputField = (EditText) findViewById(R.id.name_input_field);
        enteredName = "Name: " + nameInputField.getText().toString();

        String priceMessage = createOrderSummary(price, whippedCreamChecked, chocolateChecked, enteredName);
        displayMessage(priceMessage);
    }

    /** вывод всего заказа на экран */
    private void displayMessage(String message) {
        TextView orderSummaryTextView = (TextView) findViewById(R.id.order_summary_text_view);
        orderSummaryTextView.setText(message);
    }

}