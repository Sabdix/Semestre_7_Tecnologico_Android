package ModeloBD;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Parcel;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author sabdi
 */
public class ModeloBD extends SQLiteOpenHelper{

    public ModeloBD(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String qry = "CREATE TABLE users("
                + "id INTEGER PRIMARY KEY AUTOINCREMENT,"
                + "nombre TEXT NOT NULL,"
                + "password TEXT NOT NULL,"
                + "ultimo_acceso TEXT NOT NULL)";
        db.execSQL(qry);
        
        qry = "INSERT INTO users VALUES(1, 'Sabdi', 'JohnMcarthy', 'Hoy')";
        db.execSQL(qry);
        qry = "INSERT INTO users(nombre, password, ultimo_acceso) VALUES('Alondra', 'alondra', 'hoy')";
        db.execSQL(qry);
        qry = "INSERT INTO users(nombre, password, ultimo_acceso) VALUES('Balta', 'palomo', 'hoy')";
        db.execSQL(qry);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {}
    
    public String logIn(String usuario, String pass) throws Exception {
        SQLiteDatabase db = this.getWritableDatabase();
        String qry = "SELECT * FROM users WHERE nombre='"+usuario+"' AND password='"+pass+"'";
        Cursor miCursor = db.rawQuery(qry, null);
        miCursor.moveToFirst();
        String resultado = miCursor.getString(3);
        db.close();
        return resultado;
    }
    
    public void actualizarFecha(String usuario) throws Exception {
        SQLiteDatabase db = this.getWritableDatabase();
        Date fecha = new Date();
        String qry = "UPDATE users  SET ultimo_acceso='"+fecha.toString()+"' WHERE nombre='"+usuario+"'";
        db.execSQL(qry);
        db.close();
    }
    
}
