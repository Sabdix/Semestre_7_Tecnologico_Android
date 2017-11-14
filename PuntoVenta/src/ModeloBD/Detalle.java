/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModeloBD;

/**
 *
 * @author sabdi
 */
public class Detalle {
    private int id;
    private int iD_producto;
    private int id_factura;
    private String id_producto;
    private int cantidad;
    private int precio;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_factura() {
        return id_factura;
    }

    public void setId_factura(int id_factura) {
        this.id_factura = id_factura;
    }

    public String getId_producto() {
        return id_producto;
    }

    public void setId_producto(String id_producto) {
        this.id_producto = id_producto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }
    
    @Override
    public String toString() {
        return "id:"+id+" idProducto: "+ iD_producto + " idFactura: "+ id_factura + " Cantidad: "+ cantidad +" Precio: "+ precio;
    }
    
    public int getiD_producto() {
        return iD_producto;
    }

    public void setiD_producto(int iD_producto) {
        this.iD_producto = iD_producto;
    }
    
}
