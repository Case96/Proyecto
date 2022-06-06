/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Conexion;

/**
 *
 * @author josem
 */
public class Controlador {
    private static Controlador instance = null;
    private static Conexion conexion;
    
    public static Controlador getInstance(){
        if (instance == null) {
            conexion = new Conexion ("localhost","root","","proyecto");
            instance = new Controlador();
        }
        return instance;   
    }
    
    public static Conexion getConexion(){
        if (instance == null){
            conexion = new Conexion ("localhost","root","","proyecto");
            instance = new Controlador();
        }
        return conexion;
    }
    
    //Conecta con la base de datos
    public void conectar() throws Exception {
        conexion.conectar();
        System.out.println("Conectado");
    }
    
    //Desconecta de la base de datos
    public void desconectar() throws Exception {
        conexion.desconectar();
        System.out.println("Desconectado");
    }
    
    
}
