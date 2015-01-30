package br.com.moge.calculadora;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;


public class MainActivity extends ActionBarActivity {
    private TextView mostraCalc;
    private String[] numeros;
    private String[] operadores;
    private String exibeCalc;
    private ArrayList<String> execOperacao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mostraCalc = (TextView) findViewById(R.id.visualizar);
        numeros = new String[10];
        operadores = new String[10];
        execOperacao = new ArrayList<String>();
    }


    public void setNumber(View v){

        Button b = (Button) v;
        String buttonText = b.getText().toString();

        for(int i =0; i<10; i++){

            if(numeros[i] == null){
                Toast.makeText(this,"numero vazio"+i,Toast.LENGTH_SHORT).show();
                numeros[i] = buttonText;
                break;
            }else{
                Toast.makeText(this,"numero não vazio"+i,Toast.LENGTH_SHORT).show();
                if(operadores[i] == null){
                    Toast.makeText(this,"operador vazio"+i,Toast.LENGTH_SHORT).show();
                    numeros[i] +=buttonText;

                    break;

                }else{
                    Toast.makeText(this,"operador não vazio"+i,Toast.LENGTH_SHORT).show();
                    if(numeros[i+1] == null){

                        numeros[i+1] =buttonText;
                        break;
                    }

                }

            }

        }

        setMostraCalc();

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
                if(i > 0){
                    Toast.makeText(this,"entrou no "+i+" maior que 0", Toast.LENGTH_SHORT).show();
                    if(numeros[i] !=null){
                        String result = resultadoOperacao(numeros[0],numeros[1],operadores[0]);
                        numeros[0] = result;
                        numeros[1] = null;
                        operadores[0] = buttonText;
                        break;

                    }
                }else if(operadores[i] == null){
                    Toast.makeText(this,"operador vazio"+i, Toast.LENGTH_SHORT).show();

                    operadores[i] = buttonText;
                    break;
                }

            }

        }

        setMostraCalc();
    }

    public void setMostraCalc(){
        exibeCalc = "";
        for(int i=0; i<10; i++){

            if(numeros[i] != null){
                exibeCalc += numeros[i];

                if(operadores[i] != null){
                    exibeCalc += operadores[i];
                }else{

                    break;
                }
            }else{
                break;
            }
        }

        mostraCalc.setText(exibeCalc);
    }
    /*
    public void efetuaOperador(){
        execOperacao = new ArrayList<String>();
        String[] tempOpPrioridade = new String[10];
        boolean balance = false;
        while(balance == false){

            for(int i=0; i< 10; i++){

                switch (operadores[i]){
                    case "-":break;
                    case "+":break;
                    default:
                        execOperacao.add(numeros[i]);
                        execOperacao.add(operadores[i]);
                        execOperacao.add(numeros[i+1]);
                        break;

                }

            }
        }

        double resultado = 0;
        for(int i=0; i< execOperacao.size(); i++){

            if(i == 0){
                resultado = resultadoOperacao(execOperacao[i], execOperacao[i+2], execOperacao[i+1]);
            }else{

                resultado = resultadoOperacao(resultado, execOperacao[i+2], execOperacao[i+1]);
            }


        }

    }

*/
    //explicando val1 = indice[i]
    //val2 = indice[i+2]
    //operator = indice[i+1]
    public String resultadoOperacao(String val1, String val2, String operator)
    {
        double result = 0;
        double[] var = new double[2];
        var[0] = Double.parseDouble(val1);
        var[1] = Double.parseDouble(val2);

        switch (operator){
            case "+": result = var[0]+var[1];break;
            case "-": result = var[0]-var[1];break;
            case "*": result = var[0]*var[1];break;
            case "/": result = var[0]/var[1];break;

        }

        Toast.makeText(this, "resultado "+result,Toast.LENGTH_LONG);
        return String.valueOf(result);
    }
}
