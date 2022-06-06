package Controlador;

import Modelo.Conexion;
import Modelo.Programador;
import Modelo.Proyecto;
import Modelo.TableModelProyecto;
import java.sql.SQLException;
import Vista.VistaPrincipal;
import java.util.LinkedList;

/**
 *
 * @author Alex
 */
public class ControladorProyecto {
    private VistaPrincipal vista1 = new VistaPrincipal();
    private  Proyecto proyecto = new Proyecto();
    private static ControladorProyecto instance = null;
    private static Conexion conexion;
    private TableModelProyecto tablaproyecto;
    public static ControladorProyecto getInstance() {
        if (instance == null) {
            conexion = new Conexion("localhost","root","","control_proyecto");
            instance = new ControladorProyecto();
        }

        return instance;
    }
    
    public void cargarFullProyectosProgramador() throws SQLException{
        // return Proyecto.
        System.out.println("AQUILLEGA");
        LinkedList<Proyecto> prueba = Proyecto.getInstance().obtenerFullProyectos();
        TableModelProyecto tablaproyecto = new TableModelProyecto(prueba);
        vista1.refrescarTabla(tablaproyecto);
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
