package com.eugenio.calculadora;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button0,button1,button2,button3,button4,button5,button6,button7,button8,button9,
        buttonSuma,buttonResta,buttonIgual,buttonMult,buttonDiv,buttonPoint,buttonCl;

        TextView tvResult;

        button0 = findViewById(R.id.button0);
        button1 = findViewById(R.id.button1);
        button2 = findViewById(R.id.button2);
        button3 = findViewById(R.id.button3);
        button4 = findViewById(R.id.button4);
        button5 = findViewById(R.id.button5);
        button6 = findViewById(R.id.button6);
        button7 = findViewById(R.id.button7);
        button8 = findViewById(R.id.button8);
        button9 = findViewById(R.id.button9);
        buttonSuma = findViewById(R.id.buttonSuma);
        buttonResta = findViewById(R.id.buttonResta);
        buttonIgual = findViewById(R.id.buttonIgual);
        buttonMult = findViewById(R.id.buttonMult);
        buttonDiv = findViewById(R.id.buttonDiv);
        buttonPoint = findViewById(R.id.buttonPoint);
        buttonCl = findViewById(R.id.buttonCl);
        tvResult = findViewById(R.id.tvRes);


        button0.setOnClickListener(numeroPresionado("0", tvResult));
        button1.setOnClickListener(numeroPresionado("1", tvResult));
        button2.setOnClickListener(numeroPresionado("2", tvResult));
        button3.setOnClickListener(numeroPresionado("3", tvResult));
        button4.setOnClickListener(numeroPresionado("4", tvResult));
        button5.setOnClickListener(numeroPresionado("5", tvResult));
        button6.setOnClickListener(numeroPresionado("6", tvResult));
        button7.setOnClickListener(numeroPresionado("7", tvResult));
        button8.setOnClickListener(numeroPresionado("8", tvResult));
        button9.setOnClickListener(numeroPresionado("9", tvResult));
        buttonSuma.setOnClickListener(numeroPresionado("+", tvResult));
        buttonResta.setOnClickListener(numeroPresionado("-", tvResult));
        buttonMult.setOnClickListener(numeroPresionado("*", tvResult));
        buttonDiv.setOnClickListener(numeroPresionado("/", tvResult));
        buttonPoint.setOnClickListener(numeroPresionado(".", tvResult));
        buttonIgual.setOnClickListener(numeroPresionado("=", tvResult));
        buttonCl.setOnClickListener(numeroPresionado("cl", tvResult));



    }

    public View.OnClickListener numeroPresionado(final String s, final TextView resultado) {



        View.OnClickListener onClickListener = new View.OnClickListener() {

            String operador = "";
            int num1 = 0;
            int num2 = 0;
            int res = 0;

            @Override
            public void onClick(View view) {
                switch(view.getId()){
                    case R.id.button0:
                    case R.id.button1:
                    case R.id.button2:
                    case R.id.button3:
                    case R.id.button4:
                    case R.id.button5:
                    case R.id.button6:
                    case R.id.button7:
                    case R.id.button8:
                    case R.id.button9:
                        if(resultado.getText().charAt(0) == '0') {
                            resultado.setText(resultado.getText().toString().substring(1) + s);
                        }else{
                            resultado.setText(resultado.getText()+ s);
                        }

                        break;

                    case R.id.buttonSuma:

                        num1 = Integer.parseInt(resultado.getText().toString());
                        operador = "+";
                        resultado.setText("0");
                        break;

                    case R.id.buttonResta:
                        num1 = Integer.parseInt(resultado.getText().toString());
                        operador = "-";
                        resultado.setText("0");
                        break;

                    case R.id.buttonMult:

                        num1 = Integer.parseInt(resultado.getText().toString());
                        operador = "*";
                        resultado.setText("0");
                        num2 = Integer.parseInt(resultado.getText().toString());

                        break;
                    case R.id.buttonDiv:

                        num1 = Integer.parseInt(resultado.getText().toString());
                        operador = "/";
                        resultado.setText("0");
                        num2 = Integer.parseInt(resultado.getText().toString());

                        break;
                    case R.id.buttonIgual:
                        num2 = Integer.parseInt(resultado.getText().toString());
                        switch(operador){
                            case "+":

                                res = num1+num2;
                                break;
                            case "-":
                                res = num1-num2;
                                break;
                            case "*":
                                res = num1*num2;
                                break;
                            case "/":
                                res = num1/num2;
                                break;
                        }

                        resultado.setText(String.valueOf(res));

                        break;
                }
            }
        };

        return onClickListener;
    }



}