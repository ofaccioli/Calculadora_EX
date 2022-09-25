package com.example.calculadora_ex;

import androidx.appcompat.app.AppCompatActivity;


import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.mozilla.javascript.Context;
import org.mozilla.javascript.Scriptable;

public class MainActivity extends AppCompatActivity {

    TextView resultado, total;

    Button btnZero, btnUm, btnDois, btnTres, btnQuatro, btnCinco, btnSeis, btnSete, btnOito, btnNove, btnPonto, btnDividir, btnSubtrair, btnSomar, btnMultiplicar, btnPorcento, btnApagar, btnParenteses;
    boolean parenteses = false;
    String conta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        Inicial();



    }

    public void Inicial(){
        resultado = findViewById(R.id.processar);
        total = findViewById(R.id.resultado);

        btnZero = findViewById(R.id.zero);
        btnUm = findViewById(R.id.um);
        btnDois = findViewById(R.id.dois);
        btnTres = findViewById(R.id.tres);
        btnQuatro = findViewById(R.id.quatro);
        btnCinco = findViewById(R.id.cinco);
        btnSeis = findViewById(R.id.seis);
        btnSete = findViewById(R.id.sete);
        btnOito = findViewById(R.id.oito);
        btnNove = findViewById(R.id.nove);


        btnSomar = findViewById(R.id.somar);
        btnMultiplicar = findViewById(R.id.multiplicar);
        btnSubtrair = findViewById(R.id.subtrair);
        btnParenteses = findViewById(R.id.parenteses);
        btnDividir = findViewById(R.id.dividir);
        btnPonto = findViewById(R.id.ponto);
        btnPorcento = findViewById(R.id.porcento);


        btnZero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                conta = resultado.getText().toString();
                resultado.setText(conta + "0");
            }
        });

        btnUm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                conta = resultado.getText().toString();
                resultado.setText(conta + "1");
            }
        });
        btnDois.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                conta = resultado.getText().toString();
                resultado.setText(conta + "2");
            }
        });
        btnTres.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                conta = resultado.getText().toString();
                resultado.setText(conta + "3");
            }
        });
        btnQuatro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                conta = resultado.getText().toString();
                resultado.setText(conta + "4");
            }
        });
        btnCinco.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                conta = resultado.getText().toString();
                resultado.setText(conta + "5");
            }
        });
        btnSeis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                conta = resultado.getText().toString();
                resultado.setText(conta + "6");
            }
        });
        btnSete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                conta = resultado.getText().toString();
                resultado.setText(conta + "7");
            }
        });
        btnOito.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                conta = resultado.getText().toString();
                resultado.setText(conta + "8");
            }
        });
        btnNove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                conta = resultado.getText().toString();
                resultado.setText(conta + "9");
            }
        });


        btnSomar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                conta = resultado.getText().toString();
                resultado.setText(conta + "+");
            }
        });

        btnMultiplicar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                conta = resultado.getText().toString();
                resultado.setText(conta + "x");
            }
        });
        btnDividir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                conta = resultado.getText().toString();
                resultado.setText(conta + "/");
            }
        });
        btnSubtrair.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                conta = resultado.getText().toString();
                resultado.setText(conta + "-");
            }
        });

        btnPorcento.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                conta = resultado.getText().toString();
                resultado.setText(conta + "%");
            }
        });
        btnPonto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                conta = resultado.getText().toString();
                resultado.setText(conta + ".");
            }
        });

        btnParenteses.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (parenteses){
                    conta = resultado.getText().toString();
                    resultado.setText(conta +")");
                    parenteses = false;

                }else {
                    conta = resultado.getText().toString();
                    resultado.setText(conta +"(");
                    parenteses = true;
                }
            }
        });




    }
    public void igual(View view) {


        conta = resultado.getText().toString();
        conta = conta.replaceAll("x", "*");
        conta = conta.replaceAll("%","/100");

        Context context = Context.enter();
        context.setOptimizationLevel(-1);

        String finalResut = "";

        try {
            Scriptable scriptable = context.initStandardObjects();
            finalResut = context.evaluateString(scriptable, conta, "javascript", 1, null).toString();


        }catch (Exception e){
            finalResut="0";

        }
        total.setText(finalResut);
    }


    public void limpar(View view) {

        resultado.setText("");
        total.setText("");
    }

    public void apagar(View view) {

        String string = resultado.getText().toString();

        if (string.length() >= 1){

            string = string.substring(0, string.length() - 1);
            resultado.setText(string);
        }else if (string.length() <1){
            resultado.setText("");

        }


    }


}