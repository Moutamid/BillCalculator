package com.moutamid.billcalculator;

import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import com.moutamid.billcalculator.databinding.ActivityMainBinding;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding b;

    int tipAmount = 0;
    int splitAmount = 0;

    int tipAmount2 = 0;
    int splitAmount2 = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        b = ActivityMainBinding.inflate(getLayoutInflater());
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        setContentView(b.getRoot());

        initVerticalLayout();
        initHorizontalLayout();

    }

    private void initVerticalLayout() {

        b.choosetip10.setOnClickListener(view -> {

            b.choosetip10.setBackgroundColor(getResources().getColor(R.color.grey));
            b.choosetip15.setBackgroundColor(getResources().getColor(R.color.purple_500));
            b.choosetip20.setBackgroundColor(getResources().getColor(R.color.purple_500));

            tipAmount = 10;

        });

        b.choosetip15.setOnClickListener(view -> {

            b.choosetip10.setBackgroundColor(getResources().getColor(R.color.purple_500));
            b.choosetip15.setBackgroundColor(getResources().getColor(R.color.grey));
            b.choosetip20.setBackgroundColor(getResources().getColor(R.color.purple_500));

            tipAmount = 15;

        });

        b.choosetip20.setOnClickListener(view -> {

            b.choosetip10.setBackgroundColor(getResources().getColor(R.color.purple_500));
            b.choosetip15.setBackgroundColor(getResources().getColor(R.color.purple_500));
            b.choosetip20.setBackgroundColor(getResources().getColor(R.color.grey));

            tipAmount = 20;

        });

        b.minusBtn.setOnClickListener(view -> {

            if (splitAmount != 0) {
                splitAmount--;
                b.splitCountTv.setText(splitAmount + "");
            }

        });

        b.plusBtn.setOnClickListener(view -> {
            splitAmount++;
            b.splitCountTv.setText(splitAmount + "");
        });

        b.calculateBtn.setOnClickListener(view -> {

            if (b.enteryourbill.getText().toString().isEmpty() || b.enteryourbill.getText().toString().equals("0")) {
                Toast.makeText(this, "Please enter bill amount!", Toast.LENGTH_SHORT).show();
                return;
            }
            if (tipAmount == 0) {
                Toast.makeText(this, "Please choose your tip!", Toast.LENGTH_SHORT).show();
                return;
            }
            if (splitAmount == 0) {
                Toast.makeText(this, "Please add split amount!", Toast.LENGTH_SHORT).show();
                return;
            }

            double currentBill = Double.parseDouble(b.enteryourbill.getText().toString());

            double finalTip = (double) (currentBill * (tipAmount / 100.0f));

            double finalTotalBill = currentBill + finalTip;

            double finalSplitAmount = finalTotalBill / splitAmount;

            b.totalBillTv.setText("$" + new DecimalFormat("##.##").format(finalTotalBill) + "");

            b.totalTipTv.setText("$" + new DecimalFormat("##.##").format(finalTip) + "");

            b.totalperpersonTv.setText("$" + new DecimalFormat("##.##").format(finalSplitAmount) + "");

            b.resultLayout.setVisibility(View.VISIBLE);

        });

        b.clearBtn.setOnClickListener(view -> {
            tipAmount = 0;
            splitAmount = 0;
            b.choosetip10.setBackgroundColor(getResources().getColor(R.color.purple_500));
            b.choosetip15.setBackgroundColor(getResources().getColor(R.color.purple_500));
            b.choosetip20.setBackgroundColor(getResources().getColor(R.color.purple_500));

            b.enteryourbill.setText("");
            b.splitCountTv.setText("0");

            b.totalBillTv.setText("$0.0");

            b.totalTipTv.setText("$0.0");

            b.totalperpersonTv.setText("$0.0");

            b.resultLayout.setVisibility(View.GONE);
        });

    }

    private void initHorizontalLayout() {

        b.choosetip102.setOnClickListener(view -> {

            b.choosetip102.setBackgroundColor(getResources().getColor(R.color.grey));
            b.choosetip152.setBackgroundColor(getResources().getColor(R.color.purple_500));
            b.choosetip202.setBackgroundColor(getResources().getColor(R.color.purple_500));

            tipAmount2 = 10;

        });

        b.choosetip152.setOnClickListener(view -> {

            b.choosetip102.setBackgroundColor(getResources().getColor(R.color.purple_500));
            b.choosetip152.setBackgroundColor(getResources().getColor(R.color.grey));
            b.choosetip202.setBackgroundColor(getResources().getColor(R.color.purple_500));

            tipAmount2 = 15;

        });

        b.choosetip202.setOnClickListener(view -> {

            b.choosetip102.setBackgroundColor(getResources().getColor(R.color.purple_500));
            b.choosetip152.setBackgroundColor(getResources().getColor(R.color.purple_500));
            b.choosetip202.setBackgroundColor(getResources().getColor(R.color.grey));

            tipAmount2 = 20;

        });

        b.minusBtn2.setOnClickListener(view -> {

            if (splitAmount2 != 0) {
                splitAmount2--;
                b.splitCountTv2.setText(splitAmount2 + "");
            }

        });

        b.plusBtn2.setOnClickListener(view -> {
            splitAmount2++;
            b.splitCountTv2.setText(splitAmount2 + "");
        });

        b.calculateBtn2.setOnClickListener(view -> {

            if (b.enteryourbill2.getText().toString().isEmpty() || b.enteryourbill2.getText().toString().equals("0")) {
                Toast.makeText(this, "Please enter bill amount!", Toast.LENGTH_SHORT).show();
                return;
            }
            if (tipAmount2 == 0) {
                Toast.makeText(this, "Please choose your tip!", Toast.LENGTH_SHORT).show();
                return;
            }
            if (splitAmount2 == 0) {
                Toast.makeText(this, "Please add split amount!", Toast.LENGTH_SHORT).show();
                return;
            }

            double currentBill2 = Double.parseDouble(b.enteryourbill2.getText().toString());

            double finalTip2 = (double) (currentBill2 * (tipAmount2 / 100.0f));

            double finalTotalBill2 = currentBill2 + finalTip2;

            double finalSplitAmount2 = finalTotalBill2 / splitAmount2;

            b.totalBillTv2.setText("$" + new DecimalFormat("##.##").format(finalTotalBill2) + "");

            b.totalTipTv2.setText("$" + new DecimalFormat("##.##").format(finalTip2) + "");

            b.totalperpersonTv2.setText("$" + new DecimalFormat("##.##").format(finalSplitAmount2) + "");

            b.resultLayout2.setVisibility(View.VISIBLE);

        });

        b.clearBtn2.setOnClickListener(view -> {
            tipAmount2 = 0;
            splitAmount2 = 0;
            b.choosetip102.setBackgroundColor(getResources().getColor(R.color.purple_500));
            b.choosetip152.setBackgroundColor(getResources().getColor(R.color.purple_500));
            b.choosetip202.setBackgroundColor(getResources().getColor(R.color.purple_500));

            b.enteryourbill2.setText("");
            b.splitCountTv2.setText("0");

            b.totalBillTv2.setText("$0.0");

            b.totalTipTv2.setText("$0.0");

            b.totalperpersonTv2.setText("$0.0");
        });

    }

    @Override
    public void onConfigurationChanged(@NonNull Configuration newConfig) {
        super.onConfigurationChanged(newConfig);

        // Checks the orientation of the screen
        if (newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE) {
            b.potraitLayout.setVisibility(View.GONE);
            b.landscapeLayout.setVisibility(View.VISIBLE);

        } else if (newConfig.orientation == Configuration.ORIENTATION_PORTRAIT) {
            b.potraitLayout.setVisibility(View.VISIBLE);
            b.landscapeLayout.setVisibility(View.GONE);
        }
    }
}