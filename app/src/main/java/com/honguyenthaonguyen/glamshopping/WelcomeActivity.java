package com.honguyenthaonguyen.glamshopping;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class WelcomeActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        //getSupportActionBar().hide();
        Thread timerThread = new Thread() {

            public void run()
            {
                try
                {
                    sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                finally
                {
                    Intent intent = new Intent(getApplicationContext(),LoginActivity.class);
                    startActivity(intent);
                }
            }
        };
        timerThread.start();
        }
    protected  void onPause()
    {
        super.onPause();
        finish();
    }
    }

