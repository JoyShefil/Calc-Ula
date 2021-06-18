package com.example.spidertask1;

import android.graphics.Color;
import android.os.Bundle;
import android.os.Vibrator;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
    Button button1LF, button2SF, backbtn, button3, PSbtn, bCalc, button, checkbtn, button2,  button4;
    LinearLayout L2, L3;
    FrameLayout FL1;
    TextView SPI, textView2, textView7, textView;
    EditText cValue, cValue2, lValue;
    double speed,l,speed1,lorentz,l1,h,m,s,k;
    double c= 300000000;
    Calendar calender;
    SimpleDateFormat formatTimeh,formatTimem, formatTimes,formatTime;
    String name;
    Thread t;
    Vibrator vibrator;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button1LF= findViewById(R.id.button1LF);
        button2SF= findViewById(R.id.button2SF);
        L2= findViewById(R.id.L2);
        FL1= findViewById(R.id.FL1);
        SPI= findViewById(R.id.SPI);
        backbtn= findViewById(R.id.backbtn);
        button3= findViewById(R.id.button3);
        L3= findViewById(R.id.L3);
        PSbtn= findViewById(R.id.PSbtn);
        bCalc= findViewById(R.id.bCalc);
        cValue= findViewById(R.id.cValue);
        textView2= findViewById(R.id.textView2);
        button= findViewById(R.id.button);
        textView7= findViewById(R.id.textView7);
        cValue2= findViewById(R.id.cValue2);
        lValue= findViewById(R.id.lValue);
        checkbtn= findViewById(R.id.checkbtn);
        button2= findViewById(R.id.button2);
        formatTimeh= new SimpleDateFormat("KK");
        formatTimem=new SimpleDateFormat("mm");
        formatTimes=new SimpleDateFormat("ss");
        formatTime= new SimpleDateFormat("KK:mm:ss");
        textView= findViewById(R.id.textView);
        button4= findViewById(R.id.button4);
        vibrator= (Vibrator)getSystemService(VIBRATOR_SERVICE);


        button1LF.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                button1LF.setVisibility(View.INVISIBLE);
                button2SF.setVisibility(View.INVISIBLE);
                FL1.setVisibility(View.INVISIBLE);
                L2.setVisibility(View.VISIBLE);
                SPI.setVisibility(View.INVISIBLE);
                L3.setVisibility(View.INVISIBLE);
                button4.setVisibility(View.INVISIBLE);
                textView.setVisibility(View.INVISIBLE);
            }
        });

        backbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                button1LF.setVisibility(View.VISIBLE);
                button2SF.setVisibility(View.VISIBLE);
                FL1.setVisibility(View.VISIBLE);
                L2.setVisibility(View.INVISIBLE);
                SPI.setVisibility(View.INVISIBLE);
                L3.setVisibility(View.INVISIBLE);
                button4.setVisibility(View.INVISIBLE);
            }
        });

        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SPI.setVisibility(View.INVISIBLE);
                textView.setVisibility(View.INVISIBLE);
                button4.setVisibility(View.INVISIBLE);

            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                button1LF.setVisibility(View.INVISIBLE);
                button2SF.setVisibility(View.INVISIBLE);
                FL1.setVisibility(View.INVISIBLE);
                L2.setVisibility(View.VISIBLE);
                SPI.setVisibility(View.INVISIBLE);
                L3.setVisibility(View.INVISIBLE);
                textView.setVisibility(View.INVISIBLE);
                button4.setVisibility(View.INVISIBLE);

            }
        });
        PSbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                button1LF.setVisibility(View.INVISIBLE);
                button2SF.setVisibility(View.INVISIBLE);
                FL1.setVisibility(View.INVISIBLE);
                L2.setVisibility(View.INVISIBLE);
                SPI.setVisibility(View.INVISIBLE);
                L3.setVisibility(View.VISIBLE);
                textView.setVisibility(View.INVISIBLE);
                button4.setVisibility(View.INVISIBLE);
            }
        });

        bCalc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!cValue.getText().toString().equals("")){
                    speed=Double.parseDouble(cValue.getText().toString());

                    if(speed<c){
                        l= 1 / Math.sqrt(1- ((speed*speed)/(c*c)));
                        l= new Double(Double.valueOf((new DecimalFormat("#.############")).format(l)));
                        textView2.setText("Lorentz Value = " + l);
                    }else {
                        displayToast();
                    }
                }else {
                    displayToast2();
                }
            }
        });

        checkbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (cValue2.getText().toString().equals("")){
                    displayToast2();
                } else
                    if (!cValue2.getText().toString().equals("") && lValue.getText().toString().equals("")){
                        displayToast3();
                    } else
                        if (!cValue2.getText().toString().equals("") && !lValue.getText().toString().equals("")){

                            speed1= Double.parseDouble(cValue2.getText().toString());
                            lorentz= Double.parseDouble(lValue.getText().toString());
                            if (speed1!=c){

                           l1=  1 / Math.sqrt(1- ((speed1*speed1)/(c*c)));
                            l1= new Double(Double.valueOf((new DecimalFormat("#.############")).format(l1)));

                            if(speed1<c && lorentz==l1){
                                textView7.setVisibility(View.VISIBLE);
                                textView7.setText("Your Calculated Lorentz Value is Correct!");
                                L3.setBackgroundColor(Color.GREEN);
                            } else
                                if (speed1<c && lorentz!=l1){
                                    textView7.setVisibility(View.VISIBLE);
                                    textView7.setText("Your Calculated Lorentz Value is Wrong!" + "\n"+
                                            "Lorentz Value For Your Entered Velocity is:" + "\n"+
                                            "Lorentz Value= " + l1);
                                    L3.setBackgroundColor(Color.RED);
                                    vibrator.vibrate(500);

                                } else {
                                            displayToast();
                                        }} else {
                                displayToast();
                            }

                            } else if (cValue2.getText().toString().equals("") && !lValue.getText().toString().equals("")) {
                            displayToast3();
                        } else {
                            displayToast();
                        }

            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView2.setText("");
                cValue.setText("");
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cValue2.setText("");
                lValue.setText("");
                textView7.setText("");
                L3.setBackgroundColor(Color.parseColor("#03DAC5"));
                textView7.setVisibility(View.INVISIBLE);
            }
        });
        button2SF.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SPI.setVisibility(View.VISIBLE);
                textView.setVisibility(View.VISIBLE);
                button4.setVisibility(View.VISIBLE);

               t=new Thread(){
                    @Override
                    public void run() {
                        while (!isInterrupted()) {
                                try {
                                    Thread.sleep(1);

                                    runOnUiThread(new Runnable() {
                                        @Override
                                        public void run() {
                                            calender = Calendar.getInstance();
                                            h = Double.parseDouble(formatTimeh.format(calender.getTime()));
                                            m = Double.parseDouble(formatTimem.format(calender.getTime()));
                                            s = Double.parseDouble(formatTimes.format(calender.getTime()));
                                            name = formatTime.format(calender.getTime());
                                            double fact = 1;
                                            for (int i = 1; i <= h; i++) {
                                                fact = fact * i;
                                            }

                                            k = fact / ((m * m * m) + s);
                                            textView.setText("SPI Factor: " + String.format("%.12f", k));
                                            SPI.setText("Time " + name);
                                        }
                                    });
                                } catch (InterruptedException e) {
                                    e.printStackTrace();
                                }
                            }
                        }
                    };
                t.start();


                    }
            });
        }


    private void displayToast() {
        Toast.makeText(MainActivity.this,"Invalid Input",Toast.LENGTH_SHORT).show();
    }

    private void displayToast2() {
        Toast.makeText(MainActivity.this,"Enter Speed",Toast.LENGTH_SHORT).show();
    }

    private void displayToast3() {
        Toast.makeText(MainActivity.this, "Enter Calculated Lorentz Value", Toast.LENGTH_SHORT).show();
    }

}
