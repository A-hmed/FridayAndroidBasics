package com.route.friday_basics_c41;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Objects;

public class CalculatorActivity extends AppCompatActivity {
    TextView resultTv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);
        resultTv = findViewById(R.id.resultTv);
    }

    public void onDigitClick(View view) {

        Button clickedButton = (Button) view;
        if (clickedButton.getText().toString().equals(".") &&
                resultTv.getText().toString().contains(".")) return;
            resultTv.append(clickedButton.getText());
    }

    String lhs = "";
    String savedOperator = "";

    public void onOperatorClick(View view) {
        Button newOperator = (Button) view;
        if (savedOperator.isEmpty()) {
            lhs = resultTv.getText().toString();
        } else {
            lhs = calculate(lhs, savedOperator, resultTv.getText().toString());
        }
        savedOperator = newOperator.getText().toString();
        resultTv.setText("");
        Log.e("onOperatorClick", "savedOperator = " + savedOperator + ", lhs = " + lhs);
    }

    public void onEqualClick(View view) {
        if (lhs.isEmpty() || savedOperator.isEmpty()) return;
        resultTv.setText(calculate(lhs, savedOperator, resultTv.getText().toString()));
        lhs = "";
        savedOperator = "";
    }

    String calculate(String lhs, String operator, String rhs) {

        double n1 = Double.parseDouble(lhs);
        double n2 = Double.parseDouble(rhs);
        if (Objects.equals(operator, "+")) {
            return n1 + n2 + "";
        } else if (Objects.equals(operator, "-")) {
            return n1 - n2 + "";
        } else if (Objects.equals(operator, "*")) {
            return n1 * n2 + "";
        } else {
            return n1 / n2 + "";
        }
    }
}