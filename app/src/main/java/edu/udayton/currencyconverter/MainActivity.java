package edu.udayton.currencyconverter;

import android.app.Activity;
import android.os.Bundle;
import android.text.Editable;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

import java.text.DecimalFormat;


public class MainActivity extends Activity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
         double usdentered,converted;

         //linking layout
        setContentView(R.layout.activity_main);
        final Button btncalculate = (Button) findViewById(R.id.btncalculate);
        final EditText usd=(EditText) findViewById(R.id.usd);
        final RadioButton radioButton=(RadioButton) findViewById(R.id.euros);
        final RadioButton radioButton2=(RadioButton) findViewById(R.id.mexicanpesos);
        final RadioButton radioButton3=(RadioButton) findViewById(R.id.canadian);
        final TextView txtResult=(TextView) findViewById(R.id.txtResult);
        final DecimalFormat outputformat =new DecimalFormat("#.#");
        View.OnClickListener btncalculateListener = new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                double amount, converted;
                final double Euro,Pesos,Cad;
                Editable usdentered = usd.getText();
                String usdenteredString=usdentered.toString();
                String convertRadGroup=txtResult.getText().toString();

                try
                {
                    amount = Double.parseDouble(usdenteredString);
                    String outputString= "";
                    if(amount<100000) {

                        if (radioButton.isChecked()) {
                            //Euro = usd * 0.89;
                            converted = amount * 0.88977;
                            outputString = outputformat.format(converted) + " Euros";

                        } else if (radioButton2.isChecked()) {
                            converted = amount * 22.2944;
                            outputString = outputformat.format(converted) + " Pesos";
                        } else {
                            converted = amount * 1.36043;
                            outputString = outputformat.format(converted) + " CAD";

                        }


                    }
                    else {
                        outputString ="Invalid Amount. Please Enter Correct Amount";
                    }
                    txtResult.setText(outputString);
            }
                catch(Exception e)
                {
                    Log.e(e.getMessage(), e.toString());
                }

                }
        };
        btncalculate.setOnClickListener(btncalculateListener);
    } // end oncreate method
}// end mainactivity class
