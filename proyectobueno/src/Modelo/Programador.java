/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Controlador.Controlador;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author josem
 */
public class Programador {

    
    public static int eliminarProgramador(String dni) {
        String consulta = " DELETE * FROM programador  WHERE dni='" + dni + "';";

        int filas_afectadas = 0;

        try {
            Controlador.getInstance().conectar();
            Statement stmt = Controlador.getConnection().connection.createStatement();
            filas_afectadas = stmt.executeUpdate(consulta);

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "No se ha podido llevar a cabo.");
        } finally {
            try {
                Controlador.getInstance().desconectar();
            } catch (Exception ex) {
            }
        }
        return filas_afectadas;
    }

    public static int actualizarDatos(String dni, String nombre, String titulo, String idiomas, String estudios, String cargo) {
        String consulta = " UPDATE programador SET nombre ='" + nombre + "', titulo='" + titulo + "' idiomas ='" + idiomas + "', estudios='" + estudios + "', cargo='" + cargo + "' WHERE dni='" + dni + "';";

        int filas_afectadas = 0;

        try {
            Controlador.getInstance().conectar();
            Statement stmt = Controlador.getConnection().connection.createStatement();
            filas_afectadas = stmt.executeUpdate(consulta);

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "No se ha podido llevar a cabo.");
        } finally {
            try {
                Controlador.getInstance().desconectar();
            } catch (Exception ex) {
            }
        }

        return filas_afectadas;
    }

    public static Boolean registrarProgramador(Programador programador) {

        try {
            Controlador.getInstance().conectar();

            String consulta = "INSERT INTO programador(dni, nombre, titulo, idiomas, estudios, cargo)" + "VALUES('" + programador.getDni() + "','" + programador.getNombre() + "','" + programador.getTitulo() + "','" + programador.getIdiomas() + "','" + programador.getEstudios() + "','" + programador.getCargo() + "')";

            Statement stmt = Controlador.getConnection().connection.createStatement();
            int filas_afectadas = stmt.executeUpdate(consulta);
            JOptionPane.showMessageDialog(null, "Programador registrado");

            return true;
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Ya existe un Progrmador con ese DNI.");
            return false;

        } finally {
            try {
                Controlador.getInstance().desconectar();
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
        }

    }
    private String dni;
    private String nombre;
    private String titulo;
    private String idiomas;
    private String estudios;
    private String cargo;
    private ArrayList<Proyecto> proyecto;

    public Programador(String dni, String nombre, String titulo, String idiomas, String estudios, String cargo) {
        this.dni = dni;
        this.nombre = nombre;
        this.titulo = titulo;
        this.idiomas = idiomas;
        this.estudios = estudios;
        this.cargo = cargo;
        proyecto = new ArrayList<Proyecto>();
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

    public ArrayList<Proyecto> getProyecto() {
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

    public void setProyecto(ArrayList<Proyecto> proyecto) {
        this.proyecto = proyecto;
    }

    
}
