package br.edu.iff.pooa20181.trabalho012_2018_1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity  implements View.OnClickListener{

    private Spinner cargo;
    private ArrayAdapter<CharSequence> adapter;
    private EditText hsExtras, qtdeFaltas, qtdeFilhos;
    private Button btnCalcular;
    private TextView saida;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cargo = (Spinner) findViewById(R.id.combobox);
        adapter = ArrayAdapter.createFromResource(this,R.array.cargo,R.layout.support_simple_spinner_dropdown_item);
        cargo.setAdapter(adapter);

        hsExtras = (EditText)findViewById(R.id.edtHsExtras);
        qtdeFaltas = (EditText)findViewById(R.id.edtQtdeFaltas);
        qtdeFilhos = (EditText) findViewById(R.id.edtQtdeFilhos);

        saida = (TextView) findViewById(R.id.tvSaida);
        saida.setVisibility(View.INVISIBLE);

        btnCalcular.setOnClickListener(this);
    }

    public void onClick(View view){

        String elemento = cargo.getSelectedItem().toString();
        Double salario = 0.00;
        Double horasExtras = Double.parseDouble(hsExtras.getText().toString());
        Double faltas = Double.parseDouble(qtdeFaltas.getText().toString());
        Double filhos = Double.parseDouble(qtdeFilhos.getText().toString());
        Double proventos, descontos;

        if(elemento.equals("Gerente"))
            salario = 2000.00;
        if(elemento.equals("Supervisor"))
            salario = 900.00;
        if(elemento.equals("Servente"))
            salario = 300.00;

        proventos = salario + horasExtras + filhos;
        descontos = faltas + proventos*0.1;
        horasExtras *= salario / 120;
        faltas *= salario / 30;
        filhos *= salario * 0.03;
        salario = proventos - descontos;

        saida.setText("Proventos: reais"+proventos+" \nDescontos: "+descontos+" reais \nSalario Liquido: "+salario+" reias \n");
        saida.setVisibility(View.VISIBLE);

    }
}
