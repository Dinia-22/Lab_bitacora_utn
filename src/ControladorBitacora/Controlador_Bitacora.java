/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ControladorBitacora;

//import Salidad_Llegadas.Modelo.Bitacora;

import BitacoraModelo.Bitacora;
import VehiculoModelo.Vehículo;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author Dinia Alvarado
 */
public class Controlador_Bitacora {
    
    private Connection conexion;

    private Statement sentencias;
    private ResultSet datos;

    public void conectar() {
        try {
            this.conexion = DriverManager.getConnection("jdbc:mysql://localhost/vehiculos?useServerPrepStmts=true", "root", "");
            this.sentencias = this.conexion.createStatement();

//            FrameConfi confi = new FrameConfi();
//            confi.setVisible(true);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, " Error al conectar");
            //System.out.println(" Error al conectar");
        }
    }

    public void create( Bitacora bit) {
        try {

            this.sentencias.executeUpdate("insert into bitacora values(null,'"+ bit.getPlaca() +"','"+ bit.getDestino()+"')",Statement.RETURN_GENERATED_KEYS);
            this.datos = this.sentencias.getGeneratedKeys();
            if (datos.next()) {
                System.out.println(datos.getInt(1));
                System.out.println(" se agrego de manera exitosa");

            }
        } catch (SQLException ex) {
            System.out.println("Error al agregar");
        }

    }
    
      public String buscar(String placa) {
        try {
            this.datos = this.sentencias.executeQuery("select * from bitacora where placa=" + placa +"'");//jala todos los registros que el id diga
            if (datos.next()) {
                System.out.println(datos.getInt(1));
                System.out.println(datos.getString(2));
                System.out.println(datos.getString(3));
            } else {
                System.out.println("fin de los datos");
            }
        } catch (SQLException ex) {
            System.out.println("error en el read");
        }
        return null;
    }

    public boolean update(Bitacora bit) {
        try {
            this.sentencias.executeUpdate("update  bitacora set fechallegada='" + bit.getFechaLlegada() + "',horallegada='" + bit.getHoraLlegada() + "'where kfinal=" + bit.getKfinal());
            return true;
        } catch (SQLException ex) {
            System.out.println("Error en update");
            return false;
        }
    }
    
    

    
}
