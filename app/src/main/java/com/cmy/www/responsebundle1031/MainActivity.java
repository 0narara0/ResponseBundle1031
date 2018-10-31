package com.cmy.www.responsebundle1031;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    TextView textViewReturnValues1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button = findViewById(R.id.buttonFirst);
        button.setOnClickListener(this);
        textViewReturnValues1 = findViewById(R.id.textViewReturnValues1);
    }

    @Override
    public void onClick(View v) {

        EditText editTextSaveValue1 = findViewById(R.id.editTextSaveValue1);
        String editTextSaveValue1String = editTextSaveValue1.getText().toString();

        Bundle bundle = new Bundle();
        bundle.putString("Save1", editTextSaveValue1String);
        Intent intent = new Intent(this, SecondActivity.class);
        intent.putExtras(bundle);
        startActivityForResult(intent, 1000);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if(data.hasExtra("Result1")){
            textViewReturnValues1.setText(data.getStringExtra("Result1"));
        }
    }
}
