package Controlador;

import Modelo.Conexion;
import Modelo.Programador;
import Modelo.Proyecto;
import java.sql.SQLException;

/**
 *
 * @author Alex
 */
public class ControladorProyecto {
     static Programador programador;
    static ControladorProgramador instance = null;
    static Conexion conexion;

    public static ControladorProgramador getInstance() {
        if (instance == null) {
            conexion = new Conexion("localhost","root","","control_proyecto");
            instance = new ControladorProgramador();
        }

        return instance;
    }



    public Boolean registrarProyecto(Proyecto proyecto){
        
        return Proyecto.registrarProyecto(proyecto);
    }
    
    public int eliminarProyecto(String codigo) throws SQLException{
    
    return Proyecto.eliminarProyecto(codigo);   
    }
    
    public int actualizarProyecto(String codigo, String tema, String duracion){
    
        return Proyecto.actualizarDatos(codigo, tema, duracion);
    }
    
}
