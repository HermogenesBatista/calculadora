package br.com.moge.calculadora;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends ActionBarActivity {
    private TextView mostraCalc;
    private String[] numeros;
    private String[] operadores;
    private String exibeCalc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mostraCalc = (TextView) findViewById(R.id.visualizar);
        numeros = new String[10];
        operadores = new String[10];
    }


    public void setNumber(View v){

        Button b = (Button) v;
        String buttonText = b.getText().toString();

        for(int i =0; i<10; i++){

            if(numeros[i] == null){
                Toast.makeText(this,"numero vazio"+i,Toast.LENGTH_SHORT).show();
                numeros[i] = buttonText;
                exibeCalc = numeros[i];
                break;
            }else{
                Toast.makeText(this,"numero não vazio"+i,Toast.LENGTH_SHORT).show();
                if(operadores[i] == null){
                    Toast.makeText(this,"operador vazio"+i,Toast.LENGTH_SHORT).show();
                    numeros[i] +=buttonText;
                    exibeCalc = numeros[i];
                    break;
                }else{
                    Toast.makeText(this,"operador não vazio"+i,Toast.LENGTH_SHORT).show();
                    if(numeros[i+1] == null){

                        numeros[i+1] =buttonText;
                        exibeCalc = numeros[i]+operadores[i]+numeros[i+1];
                        break;
                    }

                }

            }

        }

        mostraCalc.setText(exibeCalc);

    }

    public void setOperador(View v) {
        // 1) Possibly check for instance of first

        Button b = (Button)v;
        String buttonText = b.getText().toString();

        for(int i =0; i<10; i++){

            if(numeros[i] == null){
                Toast.makeText(this,"numero vazio"+i,Toast.LENGTH_SHORT).show();
                break;
            }else{
                Toast.makeText(this,"numero não vazio"+i, Toast.LENGTH_SHORT).show();
                if(operadores[i] == null){
                    Toast.makeText(this,"operador vazio"+i, Toast.LENGTH_SHORT).show();
                    operadores[i] = buttonText;
                    exibeCalc = numeros[i]+operadores[i];
                    break;
                }else{
                    Toast.makeText(this,"operador não vazio"+i, Toast.LENGTH_SHORT).show();
                    if(numeros[i+1] == null){
                        operadores[i+1] +=buttonText;
                        exibeCalc += numeros[i+1]+operadores[1];

                    }

                }

            }

        }

        mostraCalc.setText(exibeCalc);
    }
}
