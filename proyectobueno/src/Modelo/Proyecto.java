package Modelo;

import Controlador.Controlador;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.LinkedList;
import javax.swing.JOptionPane;

/**
 *
 * @author josem
 */
public class Proyecto {

    private static Proyecto instance = null;
    private static Conexion conexion;

    public static Proyecto getInstance() {
        if (instance == null) {
            conexion = new Conexion("proyecto19", "root", "", "localhost");
            instance = new Proyecto();
        }
        return instance;
    }

    public LinkedList<Proyecto> obtenerFullProyectos() throws SQLException {
        System.out.println("AQUITAMBIEN");
        ResultSet rset = conexion.ejecutarSelect("SELECT * FROM proyecto");
        LinkedList<Proyecto> proyectos = new LinkedList<Proyecto>();
        while (rset.next()) {
            String codigo = rset.getString("codigo");
            String tema = rset.getString("tema");
            String duracion = rset.getString("duracion");
            Proyecto proyecto = new Proyecto(codigo, tema, duracion);
            proyectos.add(proyecto);
        }
        return proyectos;
    }

    public static Boolean registrarProyecto(Proyecto proyecto) {

        try {
            Controlador.getInstance().conectar();

            String consulta = "INSERT INTO proyecto(codigo, tema, duracion)" + "VALUES('" + proyecto.getCodigo() + "','" + proyecto.getTema() + "','" + proyecto.getDuracion() + "')";

            Statement stmt = Controlador.getConnection().connection.createStatement();
            int filas_afectadas = stmt.executeUpdate(consulta);
            JOptionPane.showMessageDialog(null, "Proyecto registrado");

            return true;
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Ya existe un Proyecto con ese codigo.");
            return false;

        } finally {
            try {
                Controlador.getInstance().desconectar();
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
        }
    }

    public static int eliminarProyecto(String codigo) {
        String consulta = " DELETE * FROM proyecto  WHERE codigo='" + codigo + "';";

        int filas_afectadas = 0;

        try {
            Controlador.getInstance().conectar();
            Statement stmt = Controlador.getConnection().connection.createStatement();
            filas_afectadas = stmt.executeUpdate(consulta);

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "No se ha podido borrar.");
        } finally {
            try {
                Controlador.getInstance().desconectar();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "");
            }
        }
        return filas_afectadas;
    }

    public static int actualizarDatos(String codigo, String tema, String duracion) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    private String codigo;
    private String tema;
    private String duracion;
    private ArrayList<Trabajo> trabajos;

    public Proyecto() {
    }

    public Proyecto(String codigo, String tema, String duracion) {
        this.codigo = codigo;
        this.tema = tema;
        this.duracion = duracion;
        trabajos = new ArrayList<Trabajo>();
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

    public boolean Registra(Proyecto trabajos) throws SQLException {
        return false;

    }

}
