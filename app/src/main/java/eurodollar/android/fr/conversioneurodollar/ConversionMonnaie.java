package eurodollar.android.fr.conversioneurodollar;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class ConversionMonnaie extends AppCompatActivity {

    EditText text;
    LinearLayout ll;
    TextView text_results;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        text = (EditText) findViewById(R.id.editText);
        ll = (LinearLayout) findViewById(R.id.linear_layout);
    }

    public void myClickHandler(View view) {
        switch (view.getId()) {
            case R.id.button:
                RadioButton euroButton = (RadioButton) findViewById(R.id.radioButtonE);
                RadioButton dollarButton = (RadioButton) findViewById(R.id.radioButtonD);
                if (text.getText().length() == 0) {
                    Toast.makeText(this, "Please enter a valid number",
                            Toast.LENGTH_LONG).show();
                    return;
                }

                float inputValue = Float.parseFloat(text.getText().toString());
                // Creation du nouvel objet TextView qui permettra d'afficher les resultats
                TextView text_results = new TextView(this);


                if (euroButton.isChecked()) {
                    text.setText(String
                            .valueOf(convertDollarToEuro(inputValue)));
                    // Change le texte affiche par la TextView
                    text_results.setText(String
                            .valueOf(convertDollarToEuro(inputValue)));
                    euroButton.setChecked(false);
                    dollarButton.setChecked(true);
                } else {
                    text.setText(String
                            .valueOf(convertEuroToDollar(inputValue)));
                    text_results.setText(String
                            .valueOf(convertEuroToDollar(inputValue)));
                    dollarButton.setChecked(false);
                    euroButton.setChecked(true);
                }
                // Rajoute l'element precedement cree et configuré au Linear_Layout
                ll.addView(text_results);
                break;

            case R.id.quit:
                finish();
                break;

        }
    }

    // Convertir Dollar à Euro
    private float convertDollarToEuro(float dollar) {
        return (float)(dollar/1.2);
    }

    // Convertir Euro à Dollar
    private float convertEuroToDollar(float euro) {
        return (float)(euro*1.2);
    }
}

