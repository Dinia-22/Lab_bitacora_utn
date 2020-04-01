/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VehiculoControlador;

import VehiculoModelo.Vehículo;

/**
 *
 * @author juan1
 */
public class main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        controladorVehiculo control = new controladorVehiculo();
        Vehículo prueba = new Vehículo ();
        control.conectar();
        control.create(prueba);
        //System.out.println("");
        //System.out.println(control.create(prueba));
        //control.buscar(prueba);
    }

}
