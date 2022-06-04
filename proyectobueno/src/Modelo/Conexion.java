/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Calendar;
import java.util.TimeZone;

/**
 *
 * @author josem
 */
public class Conexion {

    String host;
    String usuario;
    String pass;
    String bd;
    Connection connection = null;

    public Conexion(String hostJunco, String usuario, String pass, String bd) {
        this.host = host;//"192.168.0.117"
        this.usuario = usuario;//""
        this.pass = pass;//""
        this.bd = bd;//"proyecto "

    }
    //Conecta con la base de datos

    public void conectar() throws SQLException {
        Calendar now = Calendar.getInstance();
        TimeZone zonahoraria = now.getTimeZone();
        this.connection = (Connection) DriverManager.getConnection(
                "jdbc:mysql://" + this.host + "/" + this.bd + "?user=" + this.usuario + "&password=" + this.pass
                + "&useLegacyDatetimeCode=false&serverTimeZone=" + zonahoraria.getID());
        System.out.println("Conectado");
    }

    //Desconectta con la base de datos
    public void desconectar() throws SQLException {
        if (this.connection != null && connection.isClosed()) {
            this.connection.close();

            System.out.println("Desconecto");

        }

    }

    public int ejecutarInsertDeleteUpdate(String consulta) throws SQLException {
        Statement stmt = connection.createStatement();
        int filas_afectadas = stmt.executeUpdate(consulta);

        return filas_afectadas;
    }

    /**
     * Sirve para realizar Selects
     *
     * @param consulta
     * @return
     * @throws SQLException
     */
    public ResultSet ejecutarSelect(String consulta) throws SQLException {
        Statement stmt = connection.createStatement();
        ResultSet resultado = stmt.executeQuery(consulta);

        return resultado;
    }

}
