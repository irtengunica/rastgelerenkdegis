package com.example.okul.rastgelerenkdegis;

import android.graphics.Color;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;

import java.util.Random;


public class MainActivity extends ActionBarActivity {
    RelativeLayout rl;
    Button btnD,btnY;
    SeekBar sbRed,sbGreen,sbBlue;
    TextView txtRed,txtGreen,txtBlue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rl=(RelativeLayout) findViewById(R.id.rlZemin);//nesnenin zemin rengini yakala
        btnD=(Button) findViewById(R.id.btnRenkDegis);
        btnY=(Button) findViewById(R.id.btnNew);
        sbRed=(SeekBar) findViewById(R.id.sbRed);
        sbGreen=(SeekBar) findViewById(R.id.sbGreen);
        sbBlue=(SeekBar) findViewById(R.id.sbBlue);
        sbRed.setOnSeekBarChangeListener(new KaydirmaOlayTutucu());
        sbGreen.setOnSeekBarChangeListener(new KaydirmaOlayTutucu());
        sbBlue.setOnSeekBarChangeListener(new KaydirmaOlayTutucu());
        txtRed=(TextView) findViewById(R.id.txtRed);
        txtGreen=(TextView) findViewById(R.id.txtGreen);
        txtBlue=(TextView) findViewById(R.id.txtBlue);

       /* sbRed.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        };*/
        //tek bir i� ise bu yol tercih edilir
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void btnRenkDegisClick(View view) {
        int renk = RenkGetir();
        rl.setBackgroundColor(renk);
        btnD.setBackgroundColor(RenkGetir());
        btnY.setBackgroundColor(RenkGetir());



    }

    private int RenkGetir() {
        Random rnd=new Random();//rastgele sayy üretme
        int red=rnd.nextInt(255);
        int green=rnd.nextInt(255);
        int blue=rnd.nextInt(255);
        return Color.rgb(red, green, blue);
    }//sag tuş refactor/extract/method otomatik metod oluştur.

    public void btnYeniClick(View deneme){

    }
    public class KaydirmaOlayTutucu implements  SeekBar.OnSeekBarChangeListener
    {

        @Override
        public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
            int kirmizi=sbRed.getProgress();
            int yesil=sbGreen.getProgress();
            int mavi=sbBlue.getProgress();
            rl.setBackgroundColor(Color.rgb(kirmizi,yesil,mavi));
            txtRed.setText("Kırmızı " + kirmizi);
            txtGreen.setText("Yeşil " + yesil);
            txtBlue.setText("Mavi "+ mavi);
        }

        @Override
        public void onStartTrackingTouch(SeekBar seekBar) {

        }

        @Override
        public void onStopTrackingTouch(SeekBar seekBar) {

        }
    }


}
