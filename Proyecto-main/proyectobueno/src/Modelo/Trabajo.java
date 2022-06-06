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
public class Trabajo {
    private String cargo;
    private Programador programador;

    public Trabajo(String cargo, Programador programador) {
        this.cargo = cargo;
        this.programador = programador;
    }

    public String getCargo() {
        return cargo;
    }

    public Programador getProgramador() {
        return programador;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public void setProgramador(Programador programador) {
        this.programador = programador;
    }
    
}
