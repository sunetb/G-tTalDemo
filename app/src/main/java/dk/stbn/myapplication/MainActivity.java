package dk.stbn.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button minKnap, menuknap;
    TextView hello;
    GætTal spil;
    EditText tal;

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
        hello.setOnClickListener(this);
        spil = new GætTal();
        tal = findViewById(R.id.talgæt);




    }

    @Override
    public void onClick(View v) {
        if (v == menuknap){
            Intent i = new Intent(this, Menu.class);
            startActivity(i);
        }
        if(v == minKnap) {

            hello.setText("Velkommen!");
            String gættetTal = tal.getText().toString();
            int gættetTalInt = Integer.parseInt(gættetTal);
            System.out.println("Der blev gættet på " + gættetTalInt);
            spil.gæt(gættetTalInt);
            if (spil.gættetRigtigt()){
                hello.setText("Du gættede rigtigt, tillykke!");
            }
            else if (spil.gættetVarForHøjt()){
                hello.setText("Dit gæt var for højt, prøv igen");
            }
            else{
                hello.setText("Dit gæt var for lavt, prøv igen");
            }


        }
        else if (v == hello){
            System.out.println("klik på textview");
            //gfg
        }

    }


}