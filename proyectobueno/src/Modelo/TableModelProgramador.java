/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author josem
 */
import Controlador.Controlador;
import Controlador.ControladorProgramador;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;

import javax.swing.table.AbstractTableModel;
/**
 *
 * @author MEDAC
 */
public  class TableModelProgramador extends AbstractTableModel {
    private static final String[] columnNames = { "","","",""};
    
    private final LinkedList<Proyecto> list;

    
    public TableModelProgramador() {
    list = new LinkedList<>();
        
    }
    public Proyecto getValueAt(int rowIndex) {
        return list.get(rowIndex);
    }

    
    public void cargarProgramadores(String programador) throws SQLException, Exception {
        // Obtiene la lista de programadores de la BD
        ArrayList<Proyecto> proyectos = ControladorProgramador.getInstance().obtenerProgramador(programador);
        System.out.println(proyectos.size());
        // Borra el contenido anterior y añade el nuevo.
        list.clear();
        list.addAll(proyectos);
        // Notifica a la vista que el contenido ha cambiado para que se refresque.
        fireTableDataChanged();
    }
    
      @Override
    public int getColumnCount() {
        return columnNames.length;
    }
    @Override
    public String getColumnName(int column) {
        return columnNames[column];
    }
    @Override
    public int getRowCount() {
        return list.size();
    }
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0:
                return list.get(rowIndex).getDni();
            case 1:
                return list.get(rowIndex).getNombre();
            
            case 2:
                return list.get(rowIndex).getTitulo();
            case 3:
                return list.get(rowIndex).getIdiomas();
            case 4:
                return list.get(rowIndex).getEstudios();
            case 5:
                return list.get(rowIndex).getCargo();
                
            case 6:
                return list.get(rowIndex).getProgramador();
}

    
