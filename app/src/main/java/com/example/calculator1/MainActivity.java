package com.example.calculator1;



import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText number1, number2;
    private TextView result;
    private Button buttonAdd, buttonSubtract, buttonMultiply, buttonDivide;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Bind UI elements
        number1 = findViewById(R.id.number1);
        number2 = findViewById(R.id.number2);
        result = findViewById(R.id.result);

        buttonAdd = findViewById(R.id.buttonAdd);
        buttonSubtract = findViewById(R.id.buttonSubtract);
        buttonMultiply = findViewById(R.id.buttonMultiply);
        buttonDivide = findViewById(R.id.buttonDivide);

        // Set click listeners for buttons
        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                performOperation("+");
            }
        });

        buttonSubtract.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                performOperation("-");
            }
        });

        buttonMultiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                performOperation("*");
            }
        });

        buttonDivide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                performOperation("/");
            }
        });
    }

    // Perform the operation based on the operator passed
    private void performOperation(String operator) {
        String input1 = number1.getText().toString();
        String input2 = number2.getText().toString();

        if (!input1.isEmpty() && !input2.isEmpty()) {
            double num1 = Double.parseDouble(input1);
            double num2 = Double.parseDouble(input2);
            double output = 0;

            switch (operator) {
                case "+":
                    output = num1 + num2;
                    break;
                case "-":
                    output = num1 - num2;
                    break;
                case "*":
                    output = num1 * num2;
                    break;
                case "/":
                    if (num2 != 0) {
                        output = num1 / num2;
                    } else {
                        result.setText("Error: Division by zero");
                        return;
                    }
                    break;
            }

            result.setText("Result: " + output);
        } else {
            result.setText("Please enter both numbers");
        }
    }
}
