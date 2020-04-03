/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ControladorBitacora;

//import Salidad_Llegadas.Modelo.Bitacora;
import BitacoraModelo.Bitacora;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
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
            //JOptionPane.showMessageDialog(null, " Error al conectar");
            System.out.println(" Error al conectar");
        }
    }

    public void create(Bitacora bit) {
        try {
            PreparedStatement sentencia;
            sentencia = conexion.prepareStatement("insert bitacora values(null,?,?,?,?,?,?,?,?,?)");
           
            sentencia.setString(1, bit.getPlaca());
            sentencia.setString(2,bit.getProvincia());
            sentencia.setString(3, bit.getDestino());
            sentencia.setInt(4,bit.getFechaSalida());
            sentencia.setInt(5, bit.getHoraSalida());
            sentencia.setInt(6, bit.getKinicial());
            sentencia.setInt(7, bit.getFechaLlegada());
            sentencia.setInt(8, bit.getHoraLlegada());
            sentencia.setInt(9, bit.getKfinal());
        
            sentencia.execute();

        } catch (SQLException ex) {
            Logger.getLogger(Controlador_Bitacora.class.getName()).log(Level.SEVERE, null, ex);
        }

       
        

    }

    public String buscar(String placa) {
        try {
            this.datos = this.sentencias.executeQuery("select * from bitacora where placa=" + placa + "'");//jala todos los registros que el id diga
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
