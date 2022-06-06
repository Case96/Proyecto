/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Controlador.ControladorProyecto;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author josem
 */

    public class TableModelProyecto extends AbstractTableModel {
    private static final String[] columnNames = { "codigo", "tema","duracion"};
    private final LinkedList<Proyecto> list;

    
    public TableModelProyecto() {
        list = new LinkedList<>();
        
    }
    public Proyecto getValueAt(int rowIndex) {
        return list.get(rowIndex);
    }
    
     public  void cargarProyectosProgramador() throws SQLException, Exception {
        
        // Obtiene la lista de proyectos de la BD
        ArrayList<Proyecto> proyectos = ControladorProyecto.getInstance().obtenerProyectos();
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
                return list.get(rowIndex).getCodigo();
            case 1:
                return list.get(rowIndex).getTema();
            case 2:
                return list.get(rowIndex).getDuracion();
             }
        return null;
    }

    }


