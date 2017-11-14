package com.Model;

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
        String qry = "CREATE TABLE usuarios(";
        qry += "id INTEGER PRIMARY KEY AUTOINCREMENT,";
        qry += "nick TEXT NOT NULL)";
        
        db.execSQL(qry);
        
        qry = "INSERT INTO usuarios VALUES(1, 'Sabdi')";
        db.execSQL(qry);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        
    }
    
    public void guardarusuario(Usuario usuario) {
        SQLiteDatabase db = this.getWritableDatabase();
        
        String qry = "INSERT INTO usuarios(nick) VALUES ('";
        qry += usuario.getNick() + "')";
        db.execSQL(qry);
        db.close();
    }
    
    public void eliminarUsuario(String nick) {
        SQLiteDatabase db = this.getWritableDatabase();
        String qry = "DELETE FROM usuarios WHERE nick='"+nick+"'";
        db.execSQL(qry);
        db.close();
    }
    
    public ArrayList<Usuario> listarUsuarios() throws Exception{
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor miCursor;
        ArrayList <Usuario> usuarios = new ArrayList<Usuario>();
        
        String qry = "SELECT * FROM usuarios ORDER BY nick COLLATE NOCASE ASC";
        
        miCursor = db.rawQuery(qry, null);
        while(miCursor.moveToNext()) {
            Usuario u = new Usuario();
            u.setId(miCursor.getInt(0));
            u.setNick(miCursor.getString(1));
            usuarios.add(u);
        }
        db.close();
        return usuarios;
    }
    
    public void modificarRegistro(String nick, String nNick) {
        SQLiteDatabase db = this.getWritableDatabase();
        String qry = "UPDATE usuarios SET nick='"+nNick+"' "
                + "WHERE nick='"+nick+"'";
        db.execSQL(qry);
        db.close();
    }
    
    public ArrayList<Usuario> buscarUsuario(String nick) throws Exception {
        ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
        
        SQLiteDatabase db = this.getWritableDatabase();
        
        String qry = "SELECT * FROM usuarios WHERE nick LIKE '%";
        qry += nick.trim() + "%'";
        
        Cursor miCursor = db.rawQuery(qry, null);
        
        while(miCursor.moveToNext()) {
            Usuario usuario = new Usuario();
            usuario.setId(miCursor.getInt(1));
            usuario.setNick(miCursor.getString(1));
            
            usuarios.add(usuario);
        }
        db.close();
        
        return usuarios;
        
    }
    
}
