package com.example.homework312;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView result;
    private TextView txtoutputResult;
    private TextView btn_00;
    private TextView btn_01;
    private TextView btn_02;
    private TextView btn_03;
    private TextView btn_04;
    private TextView btn_05;
    private TextView btn_06;
    private TextView btn_07;
    private TextView btn_08;
    private TextView btn_09;
    private TextView btn_dot;
    private TextView btn_c;
    private TextView btn_back;
    private TextView btn_percent;

    private TextView btn_division;
    private TextView btn_multiplication;
    private TextView btn_minus;
    private TextView btn_plus;
    private TextView btn_equal;

    private boolean initDefault = false;
    float firstarg=0;
    String outputResult="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        btn_00.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addResult("0");
            }
        });
        btn_01.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addResult("1");
            }
        });
        btn_02.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addResult("2");
            }
        });
        btn_03.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addResult("3");
            }
        });
        btn_04.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addResult("4");
            }
        });
        btn_05.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addResult("5");
            }
        });
        btn_06.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addResult("6");
            }
        });
        btn_07.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addResult("7");
            }
        });
        btn_08.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addResult("8");
            }
        });
        btn_09.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addResult("9");
            }
        });
        btn_dot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addResult(".");
            }
        });
        btn_c.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    result.setText("0");
                    initDefault=false;
                    firstarg=0;
                    outputResult="";
                    txtoutputResult.setText("");
            }
        });
        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String resultText;
                resultText = result.getText().toString();
                if(initDefault){
                    resultText = resultText.substring(0,resultText.length()-1);
                    result.setText(resultText);
                }
                if(resultText.length()==0){
                    result.setText("0");
                    initDefault=false;
                    firstarg=0;
                }
            }
        });
        btn_plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculate("+");
            }
        });
        btn_minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculate("-");
            }
        });
        btn_division.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculate("/");
            }
        });
        btn_multiplication.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculate("*");
            }
        });
        btn_equal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculate("end");
            }
        });
    }
    //добавляем цифры
    private void addResult(String value){
        String resultText;
        resultText = result.getText().toString();
        if(!initDefault){
            resultText="";
            initDefault=true;
        }
        resultText += value;
        result.setText(resultText);
    }

    private void calculate(String operation) {
        String resultText;
        resultText = result.getText().toString();

        if(!operation.equals("end")){
            resultText+=operation;
            result.setText(resultText);
        }

        String operators[] = resultText.split("([0-9]*[.])?[0-9]+");
        String operands[] = resultText.split("[\\+\\*\\-\\/]");
        double agregate = Double.parseDouble(operands[0]);
        if(operands.length>1){
            for (int i = 1; i < operands.length; i++) {
                switch (operators[i]) {
                    case "+":
                        agregate = agregate+Double.parseDouble(operands[i]);
                        break;
                    case "-":
                        agregate = agregate-Double.parseDouble(operands[i]);
                        break;
                    case "/":
                        agregate = agregate/Double.parseDouble(operands[i]);
                        break;
                    case "*":
                        agregate = agregate*Double.parseDouble(operands[i]);
                        break;
                }
            }
        }

        //выводим результат операции. Если результат - целое число, то после запятой данные не выводим
        String str_result = Double.toString(agregate);
        String strarray[] = str_result.split("\\.");
        if (!strarray[1].equals("0")) {
            str_result=strarray[0] + "." + strarray[1];
        } else {
            str_result=strarray[0];
        }
        if(operation.equals("end")) {
            txtoutputResult.setText("");
            result.setText(str_result);
        }else{
            txtoutputResult.setText(str_result);
        }

    }
    private void initView(){
        result = findViewById(R.id.result);
        txtoutputResult = findViewById(R.id.txtoutputResult);

        btn_c = findViewById(R.id.txt_c);
        btn_back = findViewById(R.id.txt_back);
        btn_percent = findViewById(R.id.txt_percent);
        btn_division = findViewById(R.id.txt_division);
        btn_multiplication= findViewById(R.id.txt_multiplication);
        btn_minus = findViewById(R.id.txt_minus);
        btn_plus = findViewById(R.id.txt_plus);
        btn_equal= findViewById(R.id.txt_equal);

        btn_00=findViewById(R.id.txt00);
        btn_01=findViewById(R.id.txt01);
        btn_02=findViewById(R.id.txt02);
        btn_03=findViewById(R.id.txt03);
        btn_04=findViewById(R.id.txt04);
        btn_05=findViewById(R.id.txt05);
        btn_06=findViewById(R.id.txt06);
        btn_07=findViewById(R.id.txt07);
        btn_08=findViewById(R.id.txt08);
        btn_09=findViewById(R.id.txt09);
        btn_dot=findViewById(R.id.txt_dot);

    }

}
