package ebru.example.myapplication;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity4 extends AppCompatActivity {
    private Button anasayfa;
    private TextView numara;
    private TextView mesaj;
    public  static final String shared_prefs="";
    public  static final String kaydedilen1="";
    public  static final String kaydedilen2="";
    private  String text1;
    private String text2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();


                anasayfa=(Button) findViewById(R.id.anasayfa);
                numara=(TextView) findViewById(R.id.numara);
                mesaj=(TextView) findViewById(R.id.ileti);




                anasayfa.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent i=new Intent(getApplicationContext(),MainActivity.class);  //anasayfaya yonlendirme
                        startActivity(i);
                        finish();
                    }
                });
            }
        });

        verileri_yukle();
        guncelle();

        //uygulama kapatilip acildiginda sifirlanmis durumda gorunur
    }


    public void verileri_yukle(){

        SharedPreferences sharedPreferences=getSharedPreferences(shared_prefs,MODE_PRIVATE);
        text1=sharedPreferences.getString(kaydedilen1,"");
        text2=sharedPreferences.getString(kaydedilen2,"");



    }

    public void guncelle(){

        numara.setText(text1);
        mesaj.setText(text2);
    }


}
