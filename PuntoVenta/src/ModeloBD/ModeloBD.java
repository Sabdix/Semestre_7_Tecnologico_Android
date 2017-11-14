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
        String qry = "CREATE TABLE producto("
                + "id INTEGER PRIMARY KEY AUTOINCREMENT,"
                + "nombre TEXT NOT NULL,"
                + "precio INTEGER NOT NULL,"
                + "stock INTEGER NOT NULL)";
        db.execSQL(qry);
        
        qry = "INSERT INTO producto VALUES(1, 'Age of Empires', '150', '10')";
        db.execSQL(qry);
        qry = "INSERT INTO producto(nombre, precio, stock) VALUES('Outlast', '120', '10')";
        db.execSQL(qry);
        qry = "INSERT INTO producto(nombre, precio, stock) VALUES('Skyrim', '160', '10')";
        db.execSQL(qry);
        
        qry = "CREATE TABLE factura("
            + "id INTEGER PRIMARY KEY AUTOINCREMENT,"
            + "fecha TEXT NOT NULL)";
        db.execSQL(qry);
        
        qry = "CREATE TABLE detalle("
            + "id INTEGER PRIMARY KEY AUTOINCREMENT, "
            + "id_factura INTEGER NOT NULL, "
            + "id_producto INTEGER NOT NULL, "
            + "cantidad INTEGER NOT NULL, "
            + "precio INTEGER NOT NULL,"
                + "FOREIGN KEY(id_factura) REFERENCES fatura(id),"
                + "FOREIGN KEY(id_producto) REFERENCES producto(id))";
        db.execSQL(qry);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {}
    
    public ArrayList<Producto> listarProductos() throws Exception {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor miCursor;
        ArrayList <Producto> productos = new ArrayList<Producto>();
        
        String qry = "SELECT * FROM producto";
        
        miCursor = db.rawQuery(qry, null);
        while(miCursor.moveToNext()) {
            Producto p = new Producto();
            p.setId(miCursor.getInt(0));
            p.setNombre(miCursor.getString(1));
            p.setPrecio(miCursor.getInt(2));
            p.setStock(miCursor.getInt(3));
            productos.add(p);
        }
        db.close();
        return productos;
    }
    
    public ArrayList<Venta> listarVentas() throws Exception {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor miCursor;
        ArrayList <Venta> ventas = new ArrayList<Venta>();
        
        String qry = "SELECT * FROM factura";
        
        miCursor = db.rawQuery(qry, null);
        while(miCursor.moveToNext()) {
            Venta p = new Venta();
            p.setId(miCursor.getInt(0));
            p.setFecha(miCursor.getString(1));
            ventas.add(p);
        }
        db.close();
        return ventas;
    }
    
    public ArrayList<Detalle> listarDetalle() throws Exception {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor miCursor;
        ArrayList <Detalle> detalles = new ArrayList<Detalle>();
        
        String qry = "SELECT detalle.id, producto.nombre, detalle.cantidad, detalle.precio, producto.id FROM producto "
                + "INNER JOIN detalle ON detalle.id_producto=producto.id"
                + " WHERE detalle.id_factura = (SELECT MAX(id) FROM factura)";
        
        miCursor = db.rawQuery(qry, null);
        while(miCursor.moveToNext()) {
            Detalle d = new Detalle();
            d.setId(miCursor.getInt(0));
            d.setId_producto(miCursor.getString(1));
            d.setCantidad(miCursor.getInt(2));
            d.setPrecio(miCursor.getInt(3));
            d.setiD_producto(miCursor.getInt(4));
            detalles.add(d);
        }
        db.close();
        return detalles;
    }
    
    public ArrayList<Detalle> listarFactura() throws Exception {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor miCursor;
        ArrayList <Detalle> detalles = new ArrayList<Detalle>();
        
        String qry = "SELECT * FROM detalle";
        
        miCursor = db.rawQuery(qry, null);
        while(miCursor.moveToNext()) {
            Detalle d = new Detalle();
            d.setId(miCursor.getInt(0));
            d.setId_factura(miCursor.getInt(1));
            d.setiD_producto(miCursor.getInt(2));
            d.setCantidad(miCursor.getInt(3));
            d.setPrecio(miCursor.getInt(4));
            detalles.add(d);
        }
        db.close();
        return detalles;
    }
    
    public void insertVenta() {
        SQLiteDatabase db = this.getWritableDatabase();
        Date fecha = new Date();
        String qry = "INSERT INTO factura(fecha) VALUES('"+fecha.toString()+"')";
        db.execSQL(qry);
        db.close();
    }
    
    public void cancelarVenta() {
        SQLiteDatabase db = this.getWritableDatabase();
        String qry = "DELETE FROM detalle WHERE id_factura=(SELECT MAX(id) FROM factura)";
        db.execSQL(qry);
        qry = "DELETE FROM factura WHERE id=(SELECT MAX(id) FROM factura)";
        db.execSQL(qry);
        db.close();

    }
    
    public void setDetalle(int id, int cantidad, int precio) throws Exception {
        SQLiteDatabase db = this.getWritableDatabase();
        String qry = "INSERT INTO detalle(id_factura, id_producto, cantidad, precio) "
                + "VALUES((SELECT MAX(id) FROM factura), '"+id+"', '"+cantidad+"', '"+(precio*cantidad)+"')";
        db.execSQL(qry);
        db.close();
    }
    
    public void deleteDetalle(int id) {
        SQLiteDatabase db = this.getWritableDatabase();
        String qry = "DELETE FROM detalle WHERE id="+id+"";
        db.execSQL(qry);
        db.close();
    }
    
    public void modificarProducto(int stock, int id) {
        SQLiteDatabase db = this.getWritableDatabase();
        String qry = "UPDATE producto SET stock=(stock - "+stock+") "
                + "WHERE id="+id;
        db.execSQL(qry);
        db.close();
    }
    
}
