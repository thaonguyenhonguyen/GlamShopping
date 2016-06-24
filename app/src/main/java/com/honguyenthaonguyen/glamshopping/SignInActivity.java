package com.honguyenthaonguyen.glamshopping;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;
import android.widget.ViewFlipper;

public class SignInActivity extends AppCompatActivity {

    ViewFlipper viewflipper;
    ImageButton  imageButtonSignInWithFB;
    Button imageButtonSignIn;
    EditText editTextEmailAddress, editTextPassword;
    public DbHelper db;
    public Session session;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);
        //getSupportActionBar().hide();

        db = new DbHelper(this);
        session = new Session(this);

        imageButtonSignIn = (Button) findViewById(R.id.imageButtonLogin);
        imageButtonSignInWithFB = (ImageButton) findViewById(R.id.imageButtonLoginWithFB);

        editTextEmailAddress = (EditText) findViewById(R.id.editTextEmailAddress);
        editTextPassword = (EditText) findViewById(R.id.editTextEmailPassword);

        viewflipper =(ViewFlipper) findViewById(R.id.viewflipper);
        viewflipper.setInAnimation(getApplicationContext(),android.R.anim.fade_in);
        viewflipper.setOutAnimation(getApplicationContext(),android.R.anim.fade_out);
        viewflipper.setAutoStart(true);
        viewflipper.setFlipInterval(2000);

        if(session.loggedin()){
            startActivity(new Intent(SignInActivity.this, MainActivity.class));
            finish();
        }

        imageButtonSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                login();
            }
        });

        imageButtonSignInWithFB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent intent = new Intent(getApplicationContext(),MainActivity.class);
//                startActivity(intent);
                Toast.makeText(getApplicationContext(), "Ban da dang nhap bang FB", Toast.LENGTH_SHORT).show();
            }
        });
    }
    private void login(){
        String email = editTextEmailAddress.getText().toString();
        String password = editTextPassword.getText().toString();

        if (db.getUser(email,password)){
            session.setLoggedin(true);
            startActivity(new Intent(SignInActivity.this, MainActivity.class));
            finish();
        }else {
            Toast.makeText(getApplicationContext(), "Wrong Username/Password", Toast.LENGTH_SHORT).show();
        }
    }
}
