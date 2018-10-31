package com.cmy.www.responsebundle1031;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity implements View.OnClickListener {

    TextView textViewReturnValue2;
    EditText editTextSaveValue2;
    String editTextSaveValue2String;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        Button button = findViewById(R.id.buttonSecond);
        button.setOnClickListener(this);
        textViewReturnValue2 = findViewById(R.id.textViewReturnValues2);

        Bundle bundle = getIntent().getExtras();

        editTextSaveValue2 = findViewById(R.id.editTextSaveValue2);
        editTextSaveValue2.setText(bundle.getString("Save1", "No Data"));
    }

    @Override
    public void onClick(View v) {

        editTextSaveValue2String = editTextSaveValue2.getText().toString();
        Bundle bundle = new Bundle();
        bundle.putString("Save2", editTextSaveValue2String);
        Intent intent = new Intent(this, ThirdActivity.class);
        intent.putExtras(bundle);
        startActivityForResult(intent,1000);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {

    }

    @Override
    public void  finish(){
        Intent intent = new Intent();
        Bundle bundle = new Bundle();
        bundle.putString("Result1", editTextSaveValue2String);
        intent.putExtras(bundle);
        setResult(1000, intent);
        super.finish();
    }

}
