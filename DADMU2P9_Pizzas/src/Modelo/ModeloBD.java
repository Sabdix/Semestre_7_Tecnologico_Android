
package Modelo;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import java.util.ArrayList;

/**
 *
 * @author sabdi
 */
public class ModeloBD extends SQLiteOpenHelper {

    public ModeloBD(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String qry = "CREATE TABLE usuarios("
                + "id INTEGER PRIMARY KEY AUTOINCREMENT, "
                + "nombre TEXT NOT NULL, "
                + "score INT NOT NULL)";
        db.execSQL(qry);
    }
    
    public ArrayList<Usuario> listarScore() {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor miCursor;
        ArrayList <Usuario> usuarios = new ArrayList<Usuario>();
        String qry = "SELECT * FROM usuarios";
        miCursor = db.rawQuery(qry, null);
        while(miCursor.moveToNext()) {
            Usuario u = new Usuario();
            u.setId(miCursor.getInt(0));
            u.setNombre(miCursor.getString(1));
            u.setScore(miCursor.getInt(2));
            usuarios.add(u);
        }
        db.close();
        return usuarios;
    }
    
    public void setUsuario(String nombre, int score) {
        SQLiteDatabase db = this.getWritableDatabase();
        String qry = "";
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {}
    
}
