
package ModeloBd;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import java.util.ArrayList;

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
        String qry = "CREATE TABLE tutoriales("
                + "id INTEGER PRIMARY KEY AUTOINCREMENT, "
                + "titulo TEXT NOT NULL, "
                + "descripcion TEXT NOT NULL, "
                + "cantidad_videos TEXT)";
        db.execSQL(qry);
        
        qry = "INSERT INTO tutoriales VALUES (1, 'Cambiar fondo a Windows', "
                + "'1\n" +
"Haga clic en el escritorio de Windows 7 y seleccione \"Personalizar\".\n" +
"2\n" +
"Haga clic en la opción \"fondo de escritorio\" en la parte inferior de la ventana \"personalización\" para abrir la galería de fondo de escritorio.\n" +
"3\n" +
"Seleccione un fondo de escritorio y haga clic en \"Guardar cambios\" para aplicarlo.\n" +
"4\n" +
"Si deseas leer más artículos parecidos a Cómo cambiar el fondo del escritorio en Windows 7, te recomendamos que entres en nuestra categoría de Ordenadores.\n" +
"Consejos\n" +
"Puede utilizar el botón \"Examinar\" en la parte superior de la galería del fondo del escritorio para seleccionar una imagen en el disco duro.', 'false, 27')";
        db.execSQL(qry);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public ArrayList<Tutorial> listarTutoriales() throws Exception {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor miCursor;
        ArrayList <Tutorial> usuarios = new ArrayList<Tutorial>();
        
        String qry = "SELECT * FROM tutoriales";
        
        miCursor = db.rawQuery(qry, null);
        while(miCursor.moveToNext()) {
            Tutorial u = new Tutorial();
            u.setId(miCursor.getInt(0));
            u.setTitulo(miCursor.getString(1));
            u.setContenido(miCursor.getString(2));
            usuarios.add(u);
        }
        db.close();
        return usuarios;
    }
    
    public String getCount() {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor miCursor;
        
        String qry = "SELECT cantidad_videos FROM tutoriales WHERE id=1";
        
        miCursor = db.rawQuery(qry, null);
        miCursor.moveToFirst();
        db.close();
        return miCursor.getString(0);
    }
    
    public void setCount(String nuevo) throws Exception {
        SQLiteDatabase db = this.getWritableDatabase();
        String qry = "UPDATE tutoriales SET cantidad_videos='"+nuevo+"' "
                + "WHERE id=1";
        db.execSQL(qry);
        db.close();
    }
    
}
