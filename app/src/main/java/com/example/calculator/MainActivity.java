package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    //Initializing buttons, editTexts and Textboxes
    Button Add;
    Button Subtract;
    Button Multiply;
    Button Divide;

    EditText numberInput1;
    EditText numberInput2;

    TextView opText;
    TextView ansText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Initializing buttons, editTexts and Textboxes
        Add = findViewById(R.id.add_btn);
        Subtract = findViewById(R.id.subtract_btn);
        Multiply = findViewById(R.id.multiply_btn);
        Divide = findViewById(R.id.divide_btn);

        numberInput1 = findViewById(R.id.numInput1);
        numberInput2 = findViewById(R.id.numInput2);

        opText = findViewById(R.id.opText);
        ansText = findViewById(R.id.ansText);

        //Disabled the keyboard so the only input is via the buttons
        numberInput1.setShowSoftInputOnFocus(false);
        numberInput2.setShowSoftInputOnFocus(false);
    }

    //Gets the text of the button that was clicked and appends it to the EditText boxes
    public void onClickNumButton(View v)
    {
        boolean focusInput1 = numberInput1.isFocused();
        boolean focusInput2 = numberInput2.isFocused();

        Button b = (Button)v;
        String buttonText = b.getText().toString();

        if (focusInput1 && !focusInput2)
        {
            numberInput1.append(buttonText);
        } else if (!focusInput1 && focusInput2)
        {
            numberInput2.append(buttonText);
        }
        else
        {
            Toast.makeText(this, "Please select an input box", Toast.LENGTH_SHORT).show();
        }
    }

    //Where all the equations are computed
    public void onCLickEquationButton(View v)
    {
        int sum;
        int input1 = Integer.parseInt(numberInput1.getText().toString());
        int input2 = Integer.parseInt(numberInput2.getText().toString());

        if (opText.getText() == Add.getText())
        {
            sum = input1 + input2;
            ansText.setText(String.format(String.valueOf(sum)));
        }
        else if (opText.getText() == Subtract.getText())
        {
            sum = input1 - input2;
            ansText.setText(String.format(String.valueOf(sum)));
        }
        else if (opText.getText() == Multiply.getText())
        {
            sum = input1 * input2;
            ansText.setText(String.format(String.valueOf(sum)));
        }
        else if (opText.getText() == Divide.getText())
        {
            sum = input1 / input2;
            ansText.setText(String.format(String.valueOf(sum)));
        }
    }

    //Changes the operation of equation based on the button
    public void onClickOpButton(View v)
    {
        int btnID = v.getId();
        switch (btnID) {
            case R.id.add_btn:
                opText.setText(Add.getText());
                break;
            case R.id.subtract_btn:
                opText.setText(Subtract.getText());
                break;

            case R.id.multiply_btn:
                opText.setText(Multiply.getText());
                break;

            case R.id.divide_btn:
                opText.setText(Divide.getText());
                break;
        }
    }

    //Cleared the text from all the textboxes
    public void onClickClearButton (View v)
    {
        numberInput1.getText().clear();
        numberInput2.getText().clear();
        ansText.setText("");
    }

    //Removes one number
    public void onClickBackButton (View v)
    {
        String wordInput1 = numberInput1.getText().toString();
        String wordInput2 = numberInput2.getText().toString();
        if (numberInput1.isFocused())
        {
            int input = numberInput1.getText().length();
            if (input > 0)
            {
                numberInput1.setText(wordInput1.substring(0, input-1));
            }
        } else if (numberInput2.isFocused())
        {
            int input = numberInput2.getText().length();
            if (input > 0)
            {
                numberInput2.setText(wordInput2.substring(0, input-1));
            }
        }
    }
}
