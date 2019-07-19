package com.example.grupos;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    protected EditText edtNumero1, edtNumero2;
    protected Button btnDo;
    protected RadioGroup rBtnGrupo;
    protected RadioButton rBtnSumar,rBtnRestar,rBtnMultiplicar,rBtnDividir;
    protected TextView tvResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtNumero1 = findViewById(R.id.edtNumero1);
        edtNumero2 = findViewById(R.id.edtNumero2);

        rBtnGrupo = findViewById(R.id.rBtnGrupo);
        rBtnSumar = findViewById(R.id.rBtnSumar);
        rBtnRestar = findViewById(R.id.rBtnRestar);
        rBtnMultiplicar = findViewById(R.id.rBtnMultiplicar);
        rBtnDividir = findViewById(R.id.rBtnDividir);

        btnDo = findViewById(R.id.btnDo);

        tvResultado = findViewById(R.id.tvResultado);

        View.OnClickListener cl = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                operar();
            }
        };

        btnDo.setOnClickListener(cl);
    }

    public void operar()
    {
        String strNumero1 = edtNumero1.getText().toString();
        String strNumero2 = edtNumero2.getText().toString();
        int nNumero1 = Integer.parseInt(strNumero1);
        int nNumero2 = Integer.parseInt(strNumero2);

        int operacion = rBtnGrupo.getCheckedRadioButtonId();
        int total = 0;
        if(rBtnSumar.isChecked())
        {
            total = nNumero1+nNumero2;
        }
        else if(rBtnRestar.isChecked())
        {
            total = nNumero1-nNumero2;
        }
        else if(rBtnMultiplicar.isChecked())
        {
            total = nNumero1*nNumero2;
        }
        else if(rBtnDividir.isChecked())
        {
            total = nNumero1/nNumero2;
        }
        else
        {
            total = -1;
        }


        tvResultado.setText(String.valueOf(total));
    }
}
