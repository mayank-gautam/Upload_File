package com.mayankgautam.uploadfile;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.mayankgautam.myapplication.UploadFile;

public class MainActivity extends AppCompatActivity {

    Uri uri;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.selectButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(UploadFile.selectDocument(MainActivity.this,MainActivity.this)){
                    Intent intent = new Intent();
                    intent.setType("pdf/docs/ppt");
                    intent.setAction(Intent.ACTION_GET_CONTENT);
                    startActivityForResult(intent,2);
                }else{
                    Toast.makeText(MainActivity.this, "Please Provide permission", Toast.LENGTH_SHORT).show();
                }
            }
        });


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==2 && resultCode== RESULT_OK){
            if(data!=null && data.getData()!=null){
                uri = data.getData();
                Toast.makeText(this, ""+uri, Toast.LENGTH_SHORT).show();
            }else{
                Toast.makeText(this, "Please select File", Toast.LENGTH_SHORT).show();
            }
        }
    }
}