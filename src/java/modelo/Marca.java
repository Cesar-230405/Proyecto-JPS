/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.sql.ResultSet;
import java.util.HashMap;

/**
 *
 * @author Cesar
 */


public class Marca {
    private int idMarca;
    private String marca;
    private Conexion1 cn;

    // Constructor vacío
    public Marca() {}

    // Constructor con parámetros
    public Marca(int idMarca, String marca) {
        this.idMarca = idMarca;
        this.marca = marca;
    }

    // Getters y Setters
    public int getIdMarca() {
        return idMarca;
    }

    public void setIdMarca(int idMarca) {
        this.idMarca = idMarca;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }
    public HashMap drop_sangre(){
            HashMap<String,String> drop = new HashMap();
            try{
                cn = new Conexion1();
                String query = "SELECT idMarca as id,Marca FROM marcas;";
                cn.abrir_conexion();
                ResultSet consulta = cn.conexionDB.createStatement().executeQuery(query);
                while (consulta.next()){
                    drop.put(consulta.getString("id"), consulta.getString("Marca"));
                }
                cn.cerrar_conexion();
            }catch(Exception ex){
                System.out.println(ex.getMessage());
            }
            return drop;
        }
}
