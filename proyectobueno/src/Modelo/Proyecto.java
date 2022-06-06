package Modelo;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author josem
 */
public class Proyecto {

    public static Boolean registrarProyecto(Proyecto proyecto) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public static int eliminarProyecto(String codigo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public static int actualizarDatos(String codigo, String tema, String duracion) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    private String codigo;
    private String tema;
    private String duracion;
    private ArrayList <Trabajo> trabajos;

    public Proyecto (){ }
    
    
    public Proyecto(String codigo, String tema, String duracion, ArrayList<Trabajo> trabajos) {
        this.codigo = codigo;
        this.tema = tema;
        this.duracion = duracion;
        trabajos = new ArrayList <Trabajo>();     
    }

    public String getCodigo() {
        return codigo;
    }

    public String getTema() {
        return tema;
    }

    public String getDuracion() {
        return duracion;
    }

    public ArrayList<Trabajo> getTrabajos() {
        return trabajos;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public void setTema(String tema) {
        this.tema = tema;
    }

    public void setDuracion(String duracion) {
        this.duracion = duracion;
    }

    public void setTrabajos(ArrayList<Trabajo> trabajos) {
        this.trabajos = trabajos;
    }
    
   public boolean Registra (Proyecto trabajos) throws SQLException {
        return false;
       
   }
    
    
}
