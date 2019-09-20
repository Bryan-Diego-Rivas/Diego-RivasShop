package com.example.diego_rivasshop;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class CheckoutActivity extends AppCompatActivity {

    private double subtotal;
    private double tps;
    private double tvq;
    private double total;
    private TextView subtotalView = findViewById(R.id.subtotal_text);
    private TextView tpsView = findViewById(R.id.tps_text);
    private TextView tvqView = findViewById(R.id.tvq_text);
    private TextView totalView = findViewById(R.id.total_text);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkout);
        Intent intent = getIntent();

        subtotal = intent.getDoubleExtra("subtotal", subtotal);
        tps = intent.getDoubleExtra("tps", tps);
        tvq = intent.getDoubleExtra("tvq", tvq);
        total = intent.getDoubleExtra("total", total);

        tpsView.setText(Double.toString(tps));
        tvqView.setText(Double.toString(tvq));
        subtotalView.setText(Double.toString(subtotal));
        tpsView.setText(Double.toString(tps));
    }
}
