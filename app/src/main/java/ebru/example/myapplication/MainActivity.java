package ebru.example.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toolbar;

public class MainActivity extends AppCompatActivity {
    private Button sms;
    private Button k_sms;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

      sms=(Button) findViewById(R.id.button_sms);
      k_sms=(Button) findViewById(R.id.button_kisa);

       sms.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Intent i=new Intent(getApplicationContext(),MainActivity2.class);
               startActivity(i);
               finish();
           }
       });

      k_sms.setOnClickListener(new View.OnClickListener() {
       @Override
       public void onClick(View v) {
        Intent i=new Intent(getApplicationContext(),Main3Activity3.class);
        startActivity(i);
        finish();
    }
});






}}
