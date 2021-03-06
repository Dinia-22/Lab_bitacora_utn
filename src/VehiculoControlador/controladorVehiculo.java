/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VehiculoControlador;

//import Grafica.FrameConfi;
import Grafica.FrameConfi;
import VehiculoModelo.Vehículo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author juan1
 */
public class controladorVehiculo {

    private Connection conexion;
    private Statement sentencias;
    private ResultSet datos;
    //ArrayList<String>filtroL=new ArrayList<String>();

  
    public void conectar() {
        try {
            this.conexion = DriverManager.getConnection("jdbc:mysql://localhost/vehiculo?useServerPrepStmts=true", "root", "");
            this.sentencias = this.conexion.createStatement();
            //FrameConfi confi = new FrameConfi();
            //confi.setVisible(true);
        } catch (SQLException ex) {
            //JOptionPane.showMessageDialog(null, " Error al conectar");
            System.out.println(" Error al conectar");
        }
    }

    public boolean create(Vehículo auto) {
        
        try {
            this.sentencias.executeUpdate("insert into vehiculo values(null,'" + auto.getPlaca() + "','" + auto.getDescripcion() + "')", Statement.RETURN_GENERATED_KEYS);
            this.datos = this.sentencias.getGeneratedKeys();
            if (datos.next()) {
                System.out.println(datos.getInt(1));
                System.out.println(datos.getInt(2));
                System.out.println(" se agrego de manera exitosa");
                return true;
            }           
        } catch (SQLException ex) {
            System.out.println("Error al agregar");
        }
        return false;
    }

    public String buscar(Vehículo auto) {
        try {
            this.datos = this.sentencias.executeQuery("select * from vehiculo where placa=" + auto);//jala todos los registros que el id diga
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

    public boolean update(Vehículo auto) {
        try {
            this.sentencias.executeUpdate("update vehiculo set placa='" + auto.getPlaca() + "' ,descripcion='" + auto.getDescripcion() + "' where id=" + auto.getId());
            return true;
        } catch (SQLException ex) {
            System.out.println("Error en update");
            return false;
        }
    }
    
    public boolean delete(Vehículo auto){
        try {
            this.sentencias.executeUpdate("delete from vehiculo where id="+auto.getId());
            return true;
        } catch (SQLException ex) {
            System.out.println("error en delete ");
            return false;
        }
    }
    
    


}
