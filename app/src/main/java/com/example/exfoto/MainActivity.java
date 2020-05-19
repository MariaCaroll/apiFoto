package com.example.exfoto;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
Button btfoto;
ImageView imFoto;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        retiraFoto();
    }
    private void retiraFoto(){
        btfoto=(Button)findViewById(R.id.btnFoto);
        imFoto = (ImageView)findViewById(R.id.imagem);

        btfoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(intent, 0);
            }
        });
    }
    @Override
    protected void  onActivityResult(int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode, resultCode, data);
        Bundle  bundle = data.getExtras();
        if(data !=null){
            Bitmap bitmap  =(Bitmap)bundle.get("data");
            imFoto.setImageBitmap(bitmap);
        }
    }
}
