package dk.stbn.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button minKnap, menuknap;
    TextView hello;
    EditText tal;

    MinSingleton a = MinSingleton.app;



    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        System.out.println("hejsa");
        menuknap = findViewById(R.id.menubutton);
        menuknap.setOnClickListener(this);
        minKnap = findViewById(R.id.hejknap);
        minKnap.setOnClickListener(this);
        hello = findViewById(R.id.hello);

        hello.setOnClickListener(v -> {
            hello.append(".");
        });


        tal = findViewById(R.id.talgæt);
    }

    @Override
    public void onClick(View v) {
        if (v == menuknap){

            Intent i = new Intent(this, Menu.class);
            String brugerinput = tal.getText().toString();
            i.putExtra("input", brugerinput);
            startActivity(i);
            //finish();
        }
        else if(v == minKnap) {

            hello.setText("Velkommen!");
            String gættetTal = tal.getText().toString();
            int gættetTalInt = Integer.parseInt(gættetTal);
            System.out.println("Der blev gættet på " + gættetTalInt);
            a.spil.gæt(gættetTalInt);
            if (a.spil.gættetRigtigt()){
                hello.setText("Du gættede rigtigt, tillykke!");
            }
            else if (a.spil.gættetVarForHøjt()){
                hello.setText("Dit gæt var for højt, prøv igen");
            }
            else{
                hello.setText("Dit gæt var for lavt, prøv igen");
            }


        }


    }

    @Override
    protected void onStop() {
        Toast.makeText(this,"stoppet", Toast.LENGTH_LONG).show();
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        Toast.makeText(this,"lukket", Toast.LENGTH_LONG).show();
        super.onDestroy();
    }
}