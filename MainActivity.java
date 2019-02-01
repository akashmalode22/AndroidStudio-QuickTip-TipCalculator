package com.example.quicktip;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    TextView tipTotalTextView;
    TextView totalTextView;
    EditText billEditText;
    Button tenPercentButton, fifteenPercentButton, twentyPercentButton;
    EditText tipPercentage;
    Button calculateButton;
    TextView tipTotalTextView2;
    TextView totalText2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        // All of this is to connect the UI stuff to the back-end code
        tipTotalTextView = (TextView) findViewById(R.id.TipTotalTextView);
        totalTextView = (TextView) findViewById(R.id.TotalTextView);

        billEditText = (EditText) findViewById(R.id.BillEditText);

        tenPercentButton = (Button) findViewById(R.id.tenButton);
        fifteenPercentButton = (Button) findViewById(R.id.fifteenButton);
        twentyPercentButton = (Button) findViewById(R.id.twentyButton);

        tipPercentage = (EditText) findViewById(R.id.tipEnterEditText);
        calculateButton = (Button) findViewById(R.id.CalculateTipButton);
        tipTotalTextView2 = (TextView) findViewById(R.id.tipTotalTextView2);
        totalText2 = (TextView) findViewById(R.id.totalTextView2);
        // End-of connecting things together

        // Button Activation

        tenPercentButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calcTotal(0.1);
            }
        });

        fifteenPercentButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calcTotal(0.15);
            }
        });

        twentyPercentButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calcTotal(0.2);
            }
        });

        // Entering Tip Percentage Manually
        calculateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Extract Percentage from Edit Text
                Double percentage = Double.valueOf(tipPercentage.getText().toString());

                // calcTotal (Entered Percentage)
                Double billTotal = Double.valueOf(billEditText.getText().toString());
                Double tipTotal = (billTotal * percentage)/100.0f; // Need to divide by 100 because percentage entered is
                                                                   // whole numbers

                // Display Tip Total
                tipTotalTextView2.setText("Tip : $" + String.format("%.2f", tipTotal));

                // Calculate Total after Tip
                Double total = billTotal + tipTotal;

                // Display Total after Tip
                totalText2.setText("Total : $" + String.format("%.2f", total));

            }
        });



    }

    void calcTotal(Double tipPercent){
        // Extract Bill Total from Edit Text
        Double billTotal = Double.valueOf(billEditText.getText().toString());

        // Calculate Tip
        Double tipTotal = billTotal * tipPercent;

        // Display Tip


        tipTotalTextView.setText("Tip : $" + String.format("%.2f", tipTotal));

        // Calculate Total
        Double billTotalAfterTip = billTotal + tipTotal;

        // Display Total
        totalTextView.setText("Total : $" + String.format("%.2f", billTotalAfterTip));
    }



}
