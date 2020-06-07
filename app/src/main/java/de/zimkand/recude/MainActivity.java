package de.zimkand.recude;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button = findViewById((R.id.button));
        button.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        EditText etZaehler = findViewById(R.id.zaehler);
        EditText etNenner = findViewById(R.id.nenner);
        String sz = etZaehler.getText().toString();
        String sn = etNenner.getText().toString();
        if (sz.length() == 0 | sn.length() == 0)
            return;
        int z = Integer.parseInt(sz);
        int n = Integer.parseInt(sn);
        // Größten gemeinsamen Teiler mit Euklid Formel bestimmen
        if (z*n != 0){
            int rest;
            int ggt = Math.abs(z);
            int divisor = Math.abs(n);
            do{
                rest = ggt % divisor;
                ggt = divisor;
                divisor = rest;
            } while (rest > 0);
        z = z/ggt;
        n = n/ggt;
        }

        etZaehler.setText(Integer.toString(z));
        etNenner.setText(Integer.toString(n));
    }
}