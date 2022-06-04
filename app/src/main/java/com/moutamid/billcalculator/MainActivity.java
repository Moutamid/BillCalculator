package com.moutamid.billcalculator;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.moutamid.billcalculator.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding b;

    int tipAmount = 0;
    int splitAmount = 0;

    Button calculateBtn, clearBtn;
    TextView totalPerPersonTv, totalBillTv, totalTipTv;
    LinearLayout resultLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        b = ActivityMainBinding.inflate(getLayoutInflater());
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        setContentView(b.getRoot());

        calculateBtn = b.calculateBtn;
        clearBtn = b.clearBtn;
        totalPerPersonTv = b.totalperpersonTv;
        totalBillTv = b.totalBillTv;
        totalTipTv = b.totalTipTv;
        resultLayout = b.resultLayout;

        b.choosetip10.setOnClickListener(view -> {

            b.choosetip10.setBackgroundResource(R.color.grey);
            b.choosetip15.setBackgroundResource(R.color.purple_500);
            b.choosetip20.setBackgroundResource(R.color.purple_500);

            tipAmount = 10;

        });

        b.choosetip15.setOnClickListener(view -> {

            b.choosetip10.setBackgroundResource(R.color.purple_500);
            b.choosetip15.setBackgroundResource(R.color.grey);
            b.choosetip20.setBackgroundResource(R.color.purple_500);

            tipAmount = 15;

        });

        b.choosetip20.setOnClickListener(view -> {

            b.choosetip10.setBackgroundResource(R.color.purple_500);
            b.choosetip15.setBackgroundResource(R.color.purple_500);
            b.choosetip20.setBackgroundResource(R.color.grey);

            tipAmount = 20;

        });

        b.minusBtn.setOnClickListener(view -> {

            if (splitAmount != 0) {
                splitAmount--;
                b.splitCountTv.setText(splitAmount);
            }

        });

        b.plusBtn.setOnClickListener(view -> {
            splitAmount++;
            b.splitCountTv.setText(splitAmount);
        });

        calculateBtn.setOnClickListener(view -> {

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

            totalBillTv.setText("$" + finalTotalBill + "");

            totalTipTv.setText("$" + finalTip + "");

            totalPerPersonTv.setText("$" + finalSplitAmount + "");

            resultLayout.setVisibility(View.VISIBLE);

        });

        b.clearBtn.setOnClickListener(view -> {
            tipAmount = 0;
            splitAmount = 0;
            b.choosetip10.setBackgroundResource(R.color.purple_500);
            b.choosetip15.setBackgroundResource(R.color.purple_500);
            b.choosetip20.setBackgroundResource(R.color.purple_500);

            b.enteryourbill.setText("");
            b.splitCountTv.setText("0");

            totalBillTv.setText("$0.0");

            totalTipTv.setText("$0.0");

            totalPerPersonTv.setText("$0.0");

            resultLayout.setVisibility(View.GONE);
        });

    }

    @Override
    public void onConfigurationChanged(@NonNull Configuration newConfig) {
        super.onConfigurationChanged(newConfig);

        // Checks the orientation of the screen
        if (newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE) {
            b.calculationLayout1.setVisibility(View.GONE);
            b.calculationLayout2.setVisibility(View.VISIBLE);

            calculateBtn = b.calculateBtn2;
            clearBtn = b.clearBtn2;
            totalPerPersonTv = b.totalperpersonTv2;
            totalBillTv = b.totalBillTv2;
            totalTipTv = b.totalTipTv2;
            resultLayout = b.resultLayout;

        } else if (newConfig.orientation == Configuration.ORIENTATION_PORTRAIT) {
            b.calculationLayout2.setVisibility(View.GONE);
            b.calculationLayout1.setVisibility(View.VISIBLE);

            calculateBtn = b.calculateBtn;
            clearBtn = b.clearBtn;
            totalPerPersonTv = b.totalperpersonTv;
            totalBillTv = b.totalBillTv;
            totalTipTv = b.totalTipTv;
            resultLayout = b.resultLayout2;
        }
    }
}