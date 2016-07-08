package edu.niu.cs.z1759385.quadraticcalculator;
/*
CSCI 522 Android Development
Assignment      : Assignment-1
Programmer      : Anil Vishwanath Murahari(z1759385)
Purpose         : This application is to function as Quadratic equation calculator .
                  It has 3 input fields and returns x1 and x2 values.


 */

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class MainActivity extends Activity {
    //instance variables for TextView EditView and for storing the double variables
    private double valueA,valueB,valueC,discr,valueX1,valueX2;
    private EditText numAET,numBET,numCET;
    TextView x1TV,x2TV;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //connect the editview and textview objects to the screen
        numAET = (EditText)findViewById(R.id.editTextA);
        numBET = (EditText)findViewById(R.id.editTextB);
        numCET = (EditText)findViewById(R.id.editTextC);
        x1TV   = (TextView)findViewById(R.id.x1TextView);
        x2TV   = (TextView)findViewById(R.id.x2TextView);
       //create a button and connect it to screen
        Button gobtn = (Button)findViewById(R.id.btngo);
        gobtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            //check if the EDITTEXT is not having any string and throws message when nothing is entered
                if(numAET.getText().toString().matches("")){
                    Toast.makeText(v.getContext(),"Please enter a value",Toast.LENGTH_LONG).show();
                    return;
                }
                valueA = Double.parseDouble(numAET.getText().toString());
                //check if value of A is zero if it is zero throw a error message
                if(valueA == 0)
                {
                    Toast.makeText(v.getContext(),"a value cannot be zero",Toast.LENGTH_LONG).show();
                    return;
                }
                //if nothing is enetered in B and C set the values to zero
                if(numBET.getText().toString().matches("")){
                 valueB = 0;
                }
                else {
                    valueB = Double.parseDouble(numBET.getText().toString());
                }
//                    valueC = Double.parseDouble(numCET.getText().toString());

                if(numCET.getText().toString().matches("")){
                    valueC = 0;
                }
                else {
                    valueC = Double.parseDouble(numCET.getText().toString());
                }
                //find the discriminant
                discr = (valueB * valueB ) - (4 * valueA * valueC);
                //find the value of x1 and x2 using the formula and set the decimal point upto 2 decimals
                if(discr > 0)
                {
                    valueX1 = (-(valueB)+Math.sqrt((valueB*valueB)-4*valueA*valueC))/(2*valueA);
                    valueX2 = (-(valueB)-Math.sqrt((valueB*valueB)-4*valueA*valueC))/(2*valueA);
                    DecimalFormat df = new DecimalFormat("#.00");
                    x1TV.setText(df.format(valueX1).toString());
                    x2TV.setText(df.format(valueX2).toString());
                }
                //if the discriminant is only one value is present for x1. Assign the same to X2
                else if(discr == 0)
                {
                    valueX1 = (-(valueB)+Math.sqrt((valueB*valueB)-4*valueA*valueC))/(2*valueA);
                    DecimalFormat df = new DecimalFormat("#.00");
                    x1TV.setText(df.format(valueX1).toString());
                    x2TV.setText(df.format(valueX1).toString());
                }
                //if discriminant is negative both x1 and x2 are imaginary
                else
                {
                    x1TV.setText("Imaginary");
                    x2TV.setText("Imaginary");
                }
            }
        });
        //create a button and connect it to screen
        //clear the EditText when the clear button is clicked
        Button clearbtn = (Button)findViewById(R.id.btnclear);
        clearbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numAET.setText("");
                numBET.setText("");
                numCET.setText("");
                x1TV.setText("");
                x2TV.setText("");
            }
        });
    }
}
