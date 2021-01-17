package ebru.example.myapplication;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;
//KISA MESAJ SAYFASI
public class Main3Activity3 extends AppCompatActivity {
    public String mesaj = "";
    public  static final String shared_prefs="";
    public  static final String kaydedilen1="";
    public  static final String kaydedilen2="";
    private  String text1;
    private String text2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        ImageButton acil=(ImageButton) findViewById(R.id.acil);
        ImageButton ucak=(ImageButton) findViewById(R.id.ucak);
        ImageButton mesajat=(ImageButton) findViewById(R.id.mesajat);
        ImageButton uygundegil=(ImageButton) findViewById(R.id.uygundegil);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show(); }});

                Button gonder = (Button) findViewById(R.id.button_gonder);
                final EditText numara = (EditText) findViewById(R.id.editText_numara);

                acil.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        mesaj="Acil işim var,sana sonra döneceğim.";
                        Toast.makeText(getApplicationContext(), mesaj, Toast.LENGTH_SHORT).show();

                    }
                });

        ucak.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mesaj="Uçaktayım.İnince arayacağım.";
                Toast.makeText(getApplicationContext(), mesaj, Toast.LENGTH_SHORT).show();

            }
        });

        uygundegil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mesaj="Şuan mesaj atacak veya telefonla konuşacak bir durumda değilim,müsait olunca sana döneceğim.";
                Toast.makeText(getApplicationContext(), mesaj, Toast.LENGTH_SHORT).show();

            }
        });

        mesajat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mesaj="Açamıyorum telefonunu mesaj atabilirsin.";
                Toast.makeText(getApplicationContext(), mesaj, Toast.LENGTH_SHORT).show();

            }
        });






        gonder.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if(mesaj=="")
                            Toast.makeText(getApplicationContext(), "Lutfen Durum Seciniz!", Toast.LENGTH_SHORT).show();
                        MesajGonder(numara.getText().toString(), mesaj);
                        //kullaniciya geri bildirim
                        Toast.makeText(getApplicationContext(), "Sms Başarıyla Gönderildi!", Toast.LENGTH_LONG).show();
                        numara.setText("");
                    }
                    });
                }


            private void MesajGonder(String no,String msj){

                SmsManager msjManager=SmsManager.getDefault();
                msjManager.sendTextMessage(no,null,msj,null,null);
            }


}
