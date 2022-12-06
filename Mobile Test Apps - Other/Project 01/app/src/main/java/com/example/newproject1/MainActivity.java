package com.example.newproject1;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.newproject1.Data.Message;

public class MainActivity extends AppCompatActivity {

    EditText Editmessage;
    Button btnsend;
    Message Msg;
    String Msag;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Editmessage = findViewById(R.id.Edit_message);
        btnsend = findViewById(R.id.btn_send);
        Msg = new Message();
    }

    public void DisplayMessage(View view){

        // 1
        //Msg.setMessage(Editmessage.getText().toString());
        //Toast.makeText(this,Msg.getMessage(),Toast.LENGTH_LONG).show();

        //2
        Msag = Editmessage.getText().toString();
        Toast.makeText(this,Msag, Toast.LENGTH_SHORT).show();
    }
}