package Controlador;

import Modelo.Conexion;
import Modelo.Programador;
import java.sql.SQLException;

/**
 *
 * @author Alex
 */
public class ControladorProgramador {
       
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



    public Boolean registrarProgramador(Programador programador){
        
        return Programador.registrarProgramador(programador);
    }
    
    public int eliminarProgramador(String dni) throws SQLException{
    
    return Programador.eliminarProgramador(dni);   
    }
    
    public int actualizarProgramador(String dni, String nombre, String titulo, String idiomas, String estudios, String cargo){
    
        return Programador.actualizarDatos(dni, nombre, titulo, idiomas, estudios, cargo);
    }
    
  
    
}
