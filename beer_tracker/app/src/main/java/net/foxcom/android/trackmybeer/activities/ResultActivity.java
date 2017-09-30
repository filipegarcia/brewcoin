package net.foxcom.android.trackmybeer.activities;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import net.foxcom.android.trackmybeer.R;
import net.foxcom.android.trackmybeer.classes.ScanResult;

import org.eazegraph.lib.charts.PieChart;
import org.eazegraph.lib.models.PieModel;

import mehdi.sakout.fancybuttons.FancyButton;
import timber.log.Timber;

public class ResultActivity extends AppCompatActivity {

    private TextView idView;
    private PieChart pieChart;
    private FancyButton historyButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);

        this.idView = (TextView) findViewById(R.id.result_id);

        pieChart = (PieChart) findViewById(R.id.result_piechart);
        historyButton = (FancyButton) findViewById(R.id.buttonHistory);


        ScanResult result = (ScanResult) getIntent().getSerializableExtra("result");
        this.idView.setText("EAN " + result.getPayload());

        createIngredientChart(result.getPayload());

        historyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Timber.d("button pressed");
                Intent intent = new Intent(view.getContext(), HistoryActivity.class);
                view.getContext().startActivity(intent);
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    private void createIngredientChart(String ean) {
        pieChart.addPieSlice(new PieModel("Carbohydrates (g)", 15, Color.parseColor("#FE6DA8")));
        pieChart.addPieSlice(new PieModel("Water (g)", 70, Color.parseColor("#56B7F1")));
        pieChart.addPieSlice(new PieModel("Sugar (g)", 10, Color.parseColor("#CDA67F")));
        pieChart.startAnimation();
    }

}
