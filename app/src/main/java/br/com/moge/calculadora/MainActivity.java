package br.com.moge.calculadora;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class MainActivity extends ActionBarActivity {
    private TextView mostraCalc;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mostraCalc = (TextView) findViewById(R.id.visualizar);
    }


    public void setNumber(View v){

        Button b = (Button)v;
        String buttonText = b.getText().toString();


    }
    public void onClick(View v) {
        // 1) Possibly check for instance of first

        Button b = (Button)v;
        String buttonText = b.getText().toString();

        mostraCalc.setText(buttonText);
    }
}
