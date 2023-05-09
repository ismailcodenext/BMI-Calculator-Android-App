package com.ismail.bmicalculatorandhealthtips;

import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    EditText edWeight, edHeightFit, edHeightInch;
    Button resultBtn, healthTipsBtn;

    TextView tvDisplay;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



            ////--------------------------------------------------
            edWeight = findViewById(R.id.edWeight);
            edHeightFit = findViewById(R.id.edHeightFit);
            edHeightInch = findViewById(R.id.edHeightInch);
            resultBtn = findViewById(R.id.resultBtn);
           /// tvDisplay = findViewById(R.id.tvDisplay);
           /// healthTipsBtn = findViewById(R.id.healthTipsBtn);

            resultBtn.setOnClickListener(new View.OnClickListener() {
                @Override

                public void onClick(View view) {

                    if( (edWeight.length() > 0) && (edHeightFit.length() > 0) && (edHeightInch.length() > 0) ){

                        /////-------------
                        float weight, heightFit, heightInch ;
                        double totalHeight, bmiResult;

                        String SWeight = edWeight.getText().toString();
                        weight = Float.parseFloat(SWeight);

                        String SHeightFit = edHeightFit.getText().toString();
                        heightFit = Float.parseFloat(SHeightFit);

                        String SHeightInch = edHeightInch.getText().toString();
                        heightInch = Float.parseFloat(SHeightInch);

                        totalHeight = (heightFit * 0.3048) + (heightInch * 0.025);

                        bmiResult = weight / (totalHeight * totalHeight);

                        DecimalFormat bmiResultD = new DecimalFormat("0.00");
                        String bmiFinalResult= bmiResultD.format(bmiResult);

                        if( bmiResult <= 18.5){
                            ///  tvDisplay.setText("Your BMI Index Result Is: "+ bmiFinalResult + "\nand UNDERWEIGHT"+"\nYou need to Health Tips"+ "\n Please CLick Health Tips Button And Learn More:");

                            new AlertDialog.Builder(MainActivity.this)
                                    .setTitle("BMI Index Result")
                                    .setMessage("BMI Index = "+bmiFinalResult+"\nResult is: UNDER WEIGHT"+"\nYou need to Health Tips"+ "\n Please CLick Health Tips Button And Learn More:")
                                    .setCancelable(false)
                                    .setNegativeButton("Okay", new DialogInterface.OnClickListener() {
                                        @Override
                                        public void onClick(DialogInterface dialogInterface, int i) {

                                        }
                                    })

                                    .setPositiveButton("Health Tips", new DialogInterface.OnClickListener() {
                                        @Override
                                        public void onClick(DialogInterface dialogInterface, int i) {
                                            Intent healthPageIntent = new Intent(MainActivity.this, HealthTips.class);
                                            startActivity(healthPageIntent);
                                        }
                                    })

                                    .show();


                        } else if (bmiResult >= 18.5 && bmiResult <=24.9) {
                            ///  tvDisplay.setText("Your BMI Index Result Is: "+ bmiFinalResult + "\nand Normal Weight"+"\nThank You");

                            new AlertDialog.Builder(MainActivity.this)
                                    .setTitle("BMI Index Result")
                                    .setMessage("Result is: Normal Weight"+"\nThank You")
                                    .setCancelable(false)
                                    .setNegativeButton("Okay", new DialogInterface.OnClickListener() {
                                        @Override
                                        public void onClick(DialogInterface dialogInterface, int i) {

                                        }
                                    })

                                    .show();

                        } else if (bmiResult >= 25 && bmiResult <=29.9) {
                            ///   tvDisplay.setText("Your BMI Index Result Is: "+ bmiFinalResult + "\nand Overweight"+"\nThank You");
                            new AlertDialog.Builder(MainActivity.this)
                                    .setTitle("BMI Index Result")
                                    .setMessage("Result is: Over weight"+"\nYou need to Health Tips"+ "\nPlease CLick Health Tips Button And Learn More:")
                                    .setCancelable(false)
                                    .setNegativeButton("Okay", new DialogInterface.OnClickListener() {
                                        @Override
                                        public void onClick(DialogInterface dialogInterface, int i) {

                                        }
                                    })
                                    .setPositiveButton("Health Tips", new DialogInterface.OnClickListener() {
                                        @Override
                                        public void onClick(DialogInterface dialogInterface, int i) {
                                            Intent healthPageIntent = new Intent(MainActivity.this, HealthTips.class);
                                            startActivity(healthPageIntent);
                                        }
                                    })

                                    .show();
                        } else if(bmiResult >= 30) {
                            /// tvDisplay.setText("Your BMI Index Result Is: "+ bmiFinalResult + "\nand Obisity"+"\nThank You");
                            new AlertDialog.Builder(MainActivity.this)
                                    .setTitle("BMI Index Result")
                                    .setMessage("Result is: Obisity"+"\nYou need to Health Tips"+ "\n Please CLick Health Tips Button And Learn More:")
                                    .setCancelable(false)
                                    .setNegativeButton("Okay", new DialogInterface.OnClickListener() {
                                        @Override
                                        public void onClick(DialogInterface dialogInterface, int i) {

                                        }
                                    })

                                    .setPositiveButton("Health Tips", new DialogInterface.OnClickListener() {
                                        @Override
                                        public void onClick(DialogInterface dialogInterface, int i) {
                                            Intent healthPageIntent = new Intent(MainActivity.this, HealthTips.class);
                                            startActivity(healthPageIntent);
                                        }
                                    })

                                    .show();
                        }
                        ////---------------

                        ///     else {
                        /// Toast.makeText(MainActivity.this, "Please input all fields", Toast.LENGTH_SHORT).show();
                        ////     }


                        ///    }


                    }else {
                        Toast.makeText(MainActivity.this, "Please input all fields", Toast.LENGTH_SHORT).show();
                            }







                }
            });





            ///------------------------

     /*       healthTipsBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent healthPageIntent = new Intent(MainActivity.this, HealthTips.class);
                    startActivity(healthPageIntent);
                }
            });   */

            ////--------------------------------------------------


       /* else {
            new AlertDialog.Builder(MainActivity.this)
                    .setTitle("Alert Box")
                    .setMessage("Please input all fields")
                    .setCancelable(false)
                    .setNegativeButton("Okay", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {

                        }
                    })

                    .show();
        }  */



    }
}