package com.example.cristopher.starshipblackmarket;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Locale;

public class ReportView extends AppCompatActivity {

    public static final int PURGE_MEMORIES_PLS = 666;
    NumberFormat currencyFormat = NumberFormat.getInstance(Locale.getDefault());

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_report_view);

        Intent it = getIntent();
        if (it != null){
            Bundle params = it.getExtras();
            if (params != null){

                //OLD STRING USE
                //ArrayList<String> shipCart = (ArrayList<String>)getIntent().getSerializableExtra("shipCart");

                ArrayList<Ship> shipCart = (ArrayList<Ship>)getIntent().getSerializableExtra("shipCart");
                ArrayList<String> shipModels = new ArrayList<>();
                Float totalValue = (float)0.0;

                for (Ship sh : shipCart ){
                    shipModels.add(sh.getModel());
                    totalValue += sh.getValue();
                }

                ListView cartList = (ListView)findViewById(R.id.cartList);
                ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,shipModels);
                cartList.setAdapter(arrayAdapter);

                TextView txtCartTotal = (TextView)findViewById(R.id.txtCartTotal);
                txtCartTotal.setText("Valor Total: C$ " + currencyFormat.format(totalValue));

            }
        }
        Button btnLimpar = (Button)findViewById(R.id.btnEmptyCart);
        btnLimpar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent resultIntent = new Intent();
                resultIntent.putExtra("limparLista",PURGE_MEMORIES_PLS);
                setResult(Activity.RESULT_OK, resultIntent);
                finish();
            }
        });
    }
}
