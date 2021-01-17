package ebru.example.myapplication;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity {
    Button gonder=(Button) findViewById(R.id.button_gonder);
    final EditText numara=(EditText) findViewById(R.id.editText_numara);
    final EditText mesaj=(EditText) findViewById(R.id.editText_mesaj);
    public  static final String shared_prefs="";
    public  static final String kaydedilen1="";
    public  static final String kaydedilen2="";
    private  String text1;
    private String text2;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });



        gonder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                verileri_kaydet(); // verileri diger sayfada kullanabilmek icin ekledik

               MesajGonder(numara.getText().toString(),mesaj.getText().toString());
                //kullaniciya geri bildirim
                Toast.makeText(getApplicationContext(),"Sms Başarıyla Gönderildi!",Toast.LENGTH_LONG).show();
                numara.setText("");
                mesaj.setText("");
            }
        });

    }

    private void MesajGonder(String no,String msj){
        //sms gonderebilmek icin kullanilmasi gereken kodlar
        SmsManager msjManager=SmsManager.getDefault();
        msjManager.sendTextMessage(no,null,msj,null,null);
    }


     public void verileri_kaydet(){

         SharedPreferences sharedPreferences=getSharedPreferences(shared_prefs,MODE_PRIVATE);
         SharedPreferences.Editor edit=sharedPreferences.edit();

         edit.putString(kaydedilen1,numara.getText().toString());
         edit.putString(kaydedilen2,mesaj.getText().toString());



         edit.apply();
         Toast.makeText(getApplicationContext(),"Sms Bilgileri Alindi!",Toast.LENGTH_SHORT).show();

     }



}
