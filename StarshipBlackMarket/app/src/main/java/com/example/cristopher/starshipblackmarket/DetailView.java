package com.example.cristopher.starshipblackmarket;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.text.NumberFormat;
import java.util.Locale;

public class DetailView extends AppCompatActivity {

    Ship detailShip;
    NumberFormat currencyFormat = NumberFormat.getInstance(Locale.getDefault());

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_view);

        Intent it = getIntent();
        if (it != null){
            Bundle params = it.getExtras();
            if (params != null){

                TextView txtShipManufacturer = (TextView)findViewById(R.id.txtShipManufacturer);
                TextView txtShipTitle = (TextView)findViewById(R.id.txtShipModel);
                TextView txtShipSpeed = (TextView)findViewById(R.id.txtShipSpeed);
                TextView txtShipValue = (TextView)findViewById(R.id.txtShipValue);
                ImageView imgShip = (ImageView)findViewById(R.id.shipImg);

                detailShip = (Ship) getIntent().getSerializableExtra("detailShip");
                txtShipManufacturer.setText(detailShip.getManufacturer());
                txtShipTitle.setText(detailShip.getModel());
                txtShipSpeed.setText(detailShip.getSpeed());
                txtShipValue.setText("C$ " + currencyFormat.format(detailShip.getValue()));
                imgShip.setImageResource(detailShip.getImage());
            }
        }

        ImageButton floatButton = (ImageButton)findViewById(R.id.btnCart);
        floatButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(DetailView.this, "Comprado: " + detailShip.getModel(), Toast.LENGTH_SHORT).show();

                Intent resultIntent = new Intent();
                resultIntent.putExtra("shipCart",detailShip);
                setResult(Activity.RESULT_OK, resultIntent);
                finish();
            }
        });
    }
}
