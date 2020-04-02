/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ControladorBitacora;

import BitacoraModelo.Bitacora;

/**
 *
 * @author Maria Paula
 */
public class NewMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        Bitacora h = new Bitacora();
        Controlador_Bitacora prueba = new Controlador_Bitacora();
        prueba.conectar();
        prueba.create(h);
        //prueba.buscar(" ABCD ");
        
        
        
        
        
    }
    
}
