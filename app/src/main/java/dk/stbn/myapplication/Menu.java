package dk.stbn.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Menu extends AppCompatActivity implements View.OnClickListener {
    TextView gæt;
    EditText nyMaximum;
    Button gem;
    MinSingleton a = MinSingleton.app;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        gæt = findViewById(R.id.tekst);
        nyMaximum = findViewById(R.id.nyMax);
        gem = findViewById(R.id.button);
        gem.setOnClickListener(this);

        String brugerinput2 = getIntent().getStringExtra("input");

        gæt.setText(brugerinput2);











    }

    @Override
    protected void onDestroy() {

        super.onDestroy();
    }

    @Override
    public void onClick(View v) {
        int max = Integer.parseInt(nyMaximum.getText().toString());
        a.spil.setMax(max);
    }
}