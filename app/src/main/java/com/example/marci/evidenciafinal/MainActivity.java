package com.example.marci.evidenciafinal;

import android.content.Intent;
import android.graphics.Bitmap;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText edtCodigodeVerificacion,edtPrimerApellido,edtSegundoApellido,edtNombre,edtGenero,edtFechadeNacimiento,edtEntidadFederativadeNacimiento;
    Button btnSubirDatos;

    static final int REQUEST_IMAGE_CAPTURE = 1;
    private ImageView mImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtCodigodeVerificacion=(EditText)findViewById(R.id.editText11);
        edtPrimerApellido=(EditText)findViewById(R.id.editText12);
        edtSegundoApellido=(EditText)findViewById(R.id.editText13);
        edtNombre=(EditText)findViewById(R.id.editText14);
        edtGenero=(EditText)findViewById(R.id.editText);
        edtFechadeNacimiento=(EditText)findViewById(R.id.editText16);
        edtEntidadFederativadeNacimiento=(EditText)findViewById(R.id.editText15);
        btnSubirDatos=(Button)findViewById(R.id.button2);

        mImageView = findViewById(R.id.image);

        final db db=new db(getApplicationContext());

        btnSubirDatos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                db.agregarDatos(edtCodigodeVerificacion.getText().toString(),edtPrimerApellido.getText().toString(),edtSegundoApellido.getText().toString(),edtNombre.getText().toString(), edtGenero.getText().toString(),edtFechadeNacimiento.getText().toString(),edtEntidadFederativadeNacimiento.getText().toString());
                Toast.makeText(getApplicationContext(),"Se agregaron tus datos correctamente",Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void button(View view) {
        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
            startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {
            Bundle extras = data.getExtras();
            Bitmap imageBitmap = (Bitmap) extras.get("data");
            mImageView.setImageBitmap(imageBitmap);
        }
    }
}

