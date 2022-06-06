/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.util.ArrayList;

/**
 *
 * @author josem
 */
public class Programador {

    public static int eliminarProgramador(String dni) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public static int actualizarDatos(String dni, String nombre, String titulo, String idiomas, String estudios, String cargo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public static Boolean registrarProgramador(Programador programador) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    private String dni;
    private String nombre;
    private String titulo;
    private String idiomas;
    private String estudios;
    private String cargo;
    private ArrayList<Proyecto>proyecto;

    public Programador(String dni, String nombre, String titulo, String idiomas, String estudios, String cargo) {
        this.dni = dni;
        this.nombre = nombre;
        this.titulo = titulo;
        this.idiomas = idiomas;
        this.estudios = estudios;
        this.cargo = cargo;
        proyecto = new ArrayList <Proyecto>();
    }

    public String getDni() {
        return dni;
    }

    public String getNombre() {
        return nombre;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getIdiomas() {
        return idiomas;
    }

    public String getEstudios() {
        return estudios;
    }

    public String getCargo() {
        return cargo;
    }
    public ArrayList <Proyecto> getProyecto(){
        return proyecto;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setIdiomas(String idiomas) {
        this.idiomas = idiomas;
    }

    public void setEstudios(String estudios) {
        this.estudios = estudios;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }
    
    public void setProyecto(ArrayList<Proyecto>proyecto){
        this.proyecto= proyecto;
    }
    
    
}
