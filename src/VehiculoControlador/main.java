/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VehiculoControlador;

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
        control.conectar();
        control.create("nissan","rojo");
  
        
        System.out.println(control.create("nissan","rojo"));
    }

}
