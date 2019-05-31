package com.example.slidingdrawer;

import android.app.Activity;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.SlidingDrawer;
import android.widget.Toast;


public class MainActivity extends Activity implements CompoundButton.OnCheckedChangeListener, View.OnClickListener, SlidingDrawer.OnDrawerOpenListener {
    SlidingDrawer sd ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sliding);
        Button h1 = findViewById(R.id.handle1);
        Button h2 = findViewById(R.id.handle2);
        Button h3 = findViewById(R.id.handle3);
        Button h4 = findViewById(R.id.handle4);
        CheckBox cb =  findViewById(R.id.cbslide);
        cb.setOnCheckedChangeListener(this);
        sd = findViewById(R.id.slidingD);
        sd.setOnDrawerOpenListener(this);
        h1.setOnClickListener(this);
        h2.setOnClickListener(this);
        h3.setOnClickListener(this);
        h4.setOnClickListener(this);
    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked)
    {
        // TODO Auto-generated method stub
        if(buttonView.isChecked())
        {
            sd.lock();
            Toast.makeText(getApplicationContext(),"Sliding Drawer is Locked ",Toast.LENGTH_SHORT).show();
        }
        else
        {
            sd.unlock();
            Toast.makeText(getApplicationContext(),"Sliding Drawer is Unlocked ", Toast.LENGTH_SHORT).show();
        }

    }

    @Override
    public void onClick(View arg0) {
        // TODO Auto-generated method stub
        switch(arg0.getId())
        {
            case R.id.handle1:
                sd.open();
                Toast.makeText(getApplicationContext(),"Sliding Drawer is Open ",Toast.LENGTH_SHORT).show();
                break;
            case R.id.handle2:

                Toast.makeText(getApplicationContext(),"Sliding Drawer is button no function ",Toast.LENGTH_SHORT).show();
                break;
            case R.id.handle3:
                sd.toggle();
                Toast.makeText(getApplicationContext(),"Sliding Drawer is in Toggle ",Toast.LENGTH_SHORT).show();
                break;
            case R.id.handle4:
                sd.close();
                Toast.makeText(getApplicationContext(),"Sliding Drawer is Closed ", Toast.LENGTH_SHORT).show();
                break;

        }
    }

    @Override
    public void onDrawerOpened() {
        // TODO Auto-generated method stub
        MediaPlayer mp = MediaPlayer.create(this,R.raw.explosion);
        mp.start();
    }


}