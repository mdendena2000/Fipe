package com.example.fipe.activities;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.fipe.R;
import com.example.fipe.model.Dados;

public class MainActivity extends AppCompatActivity {

    TextView isOnline;
    Button btnCarros, btnMotos, btnCaminhoes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        isOnline = (TextView) findViewById(R.id.isOnline);
        btnCarros = (Button) findViewById(R.id.btnCarros);
        btnMotos = (Button) findViewById(R.id.btnMotos);
        btnCaminhoes = (Button) findViewById(R.id.btnCaminhoes);

        if (isOnline()) {
            isOnline.setText("Online - Dados Online");
        } else {
            isOnline.setText("Offline - Dados Local");
        }

        btnCarros.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, MarcaActivity.class);
                intent.putExtra("vehicleType", "carros");
                Dados.getInstance().setIdBrand("carros");
                startActivity(intent);
            }
        });

        btnMotos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, MarcaActivity.class);
                intent.putExtra("vehicleType", "motos");
                Dados.getInstance().setIdBrand("motos");
                startActivity(intent);
            }
        });

        btnCaminhoes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, MarcaActivity.class);
                intent.putExtra("vehicleType", "caminhoes");
                Dados.getInstance().setIdBrand("caminhoes");
                startActivity(intent);
            }
        });

    }

    public boolean isOnline() {
        ConnectivityManager manager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        return manager.getActiveNetworkInfo() != null &&
                manager.getActiveNetworkInfo().isConnectedOrConnecting();
    }
}
