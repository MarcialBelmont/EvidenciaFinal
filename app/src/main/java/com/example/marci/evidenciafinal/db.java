package com.example.marci.evidenciafinal;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class db extends SQLiteOpenHelper {

    private static final String NOMBRE_BD="CURP";
    private static final int VERSION_BD=1;
    private static final String TABLA_CURP="CREATE TABLE CURP(CodigodeVerificacion TEXT PRIMARY KEY, PrimerApellido TEXT, SegundoApellido TEXT, Nombre TEXT, Genero TEXT, FechadeNacimiento TEXT, EntidadFederativadeNacimiento TEXT)";

    public db(Context context) {
        super(context, NOMBRE_BD, null, VERSION_BD);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(TABLA_CURP);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int il) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS "+TABLA_CURP);
        sqLiteDatabase.execSQL(TABLA_CURP);
    }

    public void agregarDatos(String codigodeverificacion, String primerapellido, String segundoapellido, String nombre, String genero, String fechadenacimiento, String entidadfederativadenacimiento){
        SQLiteDatabase bd=getWritableDatabase();
        if(bd!=null){
            bd.execSQL("INSERT INTO CURP VALUES('"+codigodeverificacion+"','"+primerapellido+"','"+segundoapellido+"','"+nombre+"','"+genero+"','"+fechadenacimiento+"','"+entidadfederativadenacimiento+"')");
            bd.close();
        }
    }
}
