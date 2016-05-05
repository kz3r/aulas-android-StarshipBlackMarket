package com.example.cristopher.starshipblackmarket;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Locale;

public class MasterView extends AppCompatActivity {

    public static final int PURGE_MEMORIES_PLS = 666;

    ListView shipList;

    ArrayList<Ship> shipCart = new ArrayList<>();
    ArrayList<Ship> shipArray = new ArrayList<>();

    NumberFormat currencyFormat = NumberFormat.getInstance(Locale.getDefault());

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_master_view);

        shipArray.add(new Ship("T-65 X-Wing","Incom Corporation", "1.050 km/h", R.drawable.xwing,(float)150000.00));
        shipArray.add(new Ship("Millenium Falcon","Corellian Eng. Corp.", "800 km/h", R.drawable.milleniumwhite,(float)1250000.00));
        shipArray.add(new Ship("TIE Fighter", "Sienar Fleet Systems", "1.200 km/h", R.drawable.tiefighter, (float) 235000.00));
        shipArray.add(new Ship("TIE Interceptor", "Sienar Fleet Systems", "1.250 km/h", R.drawable.tieinterceptor, (float) 255000.00));
        shipArray.add(new Ship("TIE Advanced","Sienar Fleet Systems", "1.200 km/h", R.drawable.tieadvanced,(float)315000.00));
        shipArray.add(new Ship("IG-2000","Trilon Inc", "220 km/h", R.drawable.ig2000,(float)650000.00));
        shipArray.add(new Ship("Marauder Corvette","Republic Sienar Systems", "850 km/h", R.drawable.maraudercorvette,(float)7930000.00));
        shipArray.add(new Ship("RZ-1 A-Wing","Incom Corporation", "1.300 km/h", R.drawable.rz1a,(float)175000.00));
        shipArray.add(new Ship("E-Wing", "FreiTek Inc", "1.300 km/h", R.drawable.ewing, (float) 160000.00));
        shipArray.add(new Ship("Slave I", "Kuat Systems Eng.", "1.000 km/h", R.drawable.slave1, (float) 726500.00));


        ListCell adapter = new ListCell(MasterView.this, shipArray);// shipTitle,shipValue,shipImg);
        shipList = (ListView)findViewById(R.id.shipList);

        assert shipList != null;
        shipList.setAdapter(adapter);
        shipList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //Toast.makeText(MasterView.this, "Selecionado: " + shipArray.get(position).getModel(),Toast.LENGTH_SHORT).show();

                Intent it = new Intent(MasterView.this, DetailView.class);
                //Bundle params = new Bundle();
                //params.putString("shipTitle", shipTitle[+position]);
                //params.putInt("shipImg", shipImg[+position]);
                Ship detailShip = shipArray.get(position);
                it.putExtra("detailShip", detailShip);
                startActivityForResult(it, 27);
            }

        });

        Button btnReport = (Button)findViewById(R.id.btnReport);
        btnReport.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent reportIt = new Intent(MasterView.this, ReportView.class);
                Bundle params = new Bundle();
                //reportIt.putStringArrayListExtra("shipCart", shipCart);
                reportIt.putExtra("shipCart", shipCart);
                startActivityForResult(reportIt, 28);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode){
            case (27) :{
                if (resultCode == Activity.RESULT_OK){
                    Ship onCartShip = (Ship)data.getSerializableExtra("shipCart");
                    shipCart.add(onCartShip);
                }
                break;
            }
            case (28) :{
                if (resultCode == Activity.RESULT_OK){
                    int limparLista = (int)data.getIntExtra("limparLista",0);
                    if (limparLista == PURGE_MEMORIES_PLS){
                        shipCart.clear();
                    }
                }
                break;
            }
        }
    }

    public class ListCell extends ArrayAdapter<Ship> {

        private final Activity context;
        private final ArrayList<String> shipTitle;
        private final ArrayList<String> shipValue;
        private final ArrayList<Integer> shipImg;

        //public ListCell(Activity context, String[] shipTitle, String[] shipValue, Integer[] shipImg) {
        public ListCell(Activity context, ArrayList<Ship> shipList) {
            super(context, R.layout.shiplist_cell, shipList);

            ArrayList<String> shTitle = new ArrayList<>();
            ArrayList<String> shValue = new ArrayList<>();
            ArrayList<Integer> shImg = new ArrayList<>();

            for( Ship sh : shipList) {
                shTitle.add(sh.getModel());
                //shValue.add(Float.toString(sh.getValue()));
                shValue.add(currencyFormat.format(sh.getValue()));
                shImg.add(sh.getImage());
            }


            this.context = context;
            this.shipTitle = shTitle;
            this.shipValue = shValue;
            this.shipImg = shImg;
        }

        @Override
        public View getView(int position, View view, ViewGroup parent){
            LayoutInflater inflater = context.getLayoutInflater();
            View rowView = inflater.inflate(R.layout.shiplist_cell, null, true);
            TextView txtTitle = (TextView) rowView.findViewById(R.id.shipTitle);
            TextView txtValue = (TextView) rowView.findViewById(R.id.shipValue);
            ImageView shipImgId = (ImageView) rowView.findViewById(R.id.shipImg);

            txtTitle.setText(shipTitle.get(position));
            txtValue.setText("C$ " + shipValue.get(position));
            shipImgId.setImageResource(shipImg.get(position));

            return rowView;
        }
    }
}
