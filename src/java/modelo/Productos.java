/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;
import java.sql.ResultSet;
import java.util.HashMap;
import java.sql.PreparedStatement;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Cesar
 */
public class Productos{
    private int id_producto;
    private String producto, descripcion, imagen, costo, venta, existencia, fi;
    private int id_Marca;
    private Conexion1 cn;

    public Productos() {
      
    }

    public Productos(int id_producto, String producto, String descripcion, String imagen, String costo, String venta, String existencia, String fi, int id_Marca) {
        this.id_producto = id_producto;
        this.producto = producto;
        this.descripcion = descripcion;
        this.imagen = imagen;
        this.costo = costo;
        this.venta = venta;
        this.existencia = existencia;
        this.fi = fi;
        this.id_Marca = id_Marca;
    }

    
    
    public int getId_producto() {
        return id_producto;
    }

    public void setId_producto(int id_producto) {
        this.id_producto = id_producto;
    }

    public String getProducto() {
        return producto;
    }

    public void setProducto(String producto) {
        this.producto = producto;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public String getCosto() {
        return costo;
    }

    public void setCosto(String costo) {
        this.costo = costo;
    }

    public String getVenta() {
        return venta;
    }

    public void setVenta(String venta) {
        this.venta = venta;
    }

    public String getExistencia() {
        return existencia;
    }

    public void setExistencia(String existencia) {
        this.existencia = existencia;
    }

    public String getFi() {
        return fi;
    }

    public void setFi(String fi) {
        this.fi = fi;
    }
    
    public HashMap drop_sangre(){
            HashMap<String,String> drop = new HashMap();
            try{
                cn = new Conexion1();
                String query = "SELECT idProducto as id,producto FROM productos;";
                cn.abrir_conexion();
                ResultSet consulta = cn.conexionDB.createStatement().executeQuery(query);
                while (consulta.next()){
                    drop.put(consulta.getString("id"), consulta.getString("producto"));
                }
                cn.cerrar_conexion();
            }catch(Exception ex){
                System.out.println(ex.getMessage());
            }
            return drop;
        }
    
    public DefaultTableModel leer(){
    DefaultTableModel tabla = new DefaultTableModel();
    try{
        cn = new Conexion1();
        cn.abrir_conexion();
            String query = "Select e.idProducto as idProducto, e.producto, e.idmarca, e.descripcion, e.imagen, e.precio_costo, e.precio_venta, e.existencia, e.fecha_ingreso FROM puntoventa_bd.productos as e, puntoventa_bd.marcas as p WHERE e.idmarca = p.idmarca;";
            ResultSet consulta = cn.conexionDB.createStatement().executeQuery(query);
            String encabezado[] = {"id","Producto","Marcas","descripcion","imagen","Precio en costo","Precio en venta","existencia","fecha de ingreso"};
            tabla.setColumnIdentifiers(encabezado);
            String datos[] = new String[9];
            while (consulta.next()){
                datos[0]=consulta.getString("idProducto");
                datos[1]=consulta.getString("producto");
                datos[2]=consulta.getString("idMarca");
                datos[3]=consulta.getString("descripcion");
                datos[4]=consulta.getString("imagen");
                datos[5]=consulta.getString("precio_costo");
                datos[6]=consulta.getString("precio_venta");
                datos[7]=consulta.getString("existencia");
                datos[8]=consulta.getString("fecha_ingreso");
                tabla.addRow(datos);
            }
        cn.cerrar_conexion();
    }catch(Exception ex){
        System.out.println(ex.getMessage());
    }
    return tabla;
    }
    
    public int agregar(){
        int retorno = 0;
    try{
        PreparedStatement parametro;
        cn= new Conexion1();
        String query="INSERT INTO puntoventa_bd.productos(producto,idmarca,descripcion,imagen,precio_costo,precio_venta,existencia,fecha_ingreso) VALUES (?, ?, ?, ?, ?, ?, ?, ?);";
        cn.abrir_conexion();
        parametro = (PreparedStatement)cn.conexionDB.prepareStatement(query);
        parametro.setString(1, this.getProducto());
        parametro.setInt(2, this.getId_Marca());
        parametro.setString(3, this.getDescripcion());
        parametro.setString(4, this.getImagen());
        parametro.setString(5, this.getCosto());
        parametro.setString(6, this.getVenta());
        parametro.setString(7, this.getExistencia());
        parametro.setString(8, this.getFi());
        retorno=parametro.executeUpdate();
        cn.cerrar_conexion();
    }catch(Exception ex){
        System.out.println("Error al agregar el empleado"+ex.getMessage());
        retorno=0;
    }
    return retorno;
    }
    
    public int modificar(){
        int retorno = 0;
    try{
        PreparedStatement parametro;
        cn= new Conexion1();
        String query="Update puntoventa_bd.productos set producto=?,idmarca=?,descripcion=?,imagen=?,precio_costo=?,precio_venta=?,existencia=?,fecha_ingreso=? where idProducto = ?;";
        cn.abrir_conexion();
        parametro = (PreparedStatement)cn.conexionDB.prepareStatement(query);
        parametro.setString(1, this.getProducto());
        parametro.setInt(2, this.getId_Marca());
        parametro.setString(3, this.getDescripcion());
        parametro.setString(4, this.getImagen());
        parametro.setString(5, this.getCosto());
        parametro.setString(6, this.getVenta());
        parametro.setString(7, this.getExistencia());
        parametro.setString(8, this.getFi());
        parametro.setInt(9, this.getId_producto()); 
        retorno=parametro.executeUpdate();
        cn.cerrar_conexion();
    }catch(Exception ex){
        System.out.println("Error al agregar el empleado"+ex.getMessage());
        retorno=0;
    }
    return retorno;
    }
    
    public int eliminar(){
        int retorno = 0;
    try{
        PreparedStatement parametro;
        cn= new Conexion1();
        String query="delete from puntoventa_bd.productos  where idProducto = ?;";
        cn.abrir_conexion();
        parametro = (PreparedStatement)cn.conexionDB.prepareStatement(query);
        parametro.setInt(1, this.getId_producto());
        retorno=parametro.executeUpdate();
        cn.cerrar_conexion();
    }catch(Exception ex){
        System.out.println("Error al agregar el empleado"+ex.getMessage());
        retorno=0;
    }
    return retorno;
    }

    public int getId_Marca() {
        return id_Marca;
    }

    public void setId_Marca(int id_Marca) {
        this.id_Marca = id_Marca;
    }
}
