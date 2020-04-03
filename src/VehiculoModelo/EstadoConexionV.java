/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VehiculoModelo;

import VehiculoControlador.controladorVehiculo;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author Adriel Chavarría B
 */
public class EstadoConexionV {

    static Statement sentencia;
    static ResultSet resultado;
    controladorVehiculo consulta = new controladorVehiculo();

    public void consultaEstadoV() {
        consulta.conectar();

    }

    public static Vehículo filtarlista(int id, String placa, String descripcion) {
        Vehículo r = null;
        String q = "SELECT * FROM vehiculo" +"WHERE placa="+placa+ " WHERE descripcion='" + descripcion + "'";
        try {
            resultado = sentencia.executeQuery(q);
            System.out.println("Correcto");
        } catch (Exception e) {
            System.out.println(" No Correcto");
        }
        r = asignar();
        return r;

    }

    public static Vehículo asignar() {
        Vehículo r = null;
        String placa, descripcion;
        int id;
        try {
            if (resultado.last()) {
                id = resultado.getInt("id");
                placa = resultado.getString("placa");
                descripcion = resultado.getString("descripcion");
                r = new Vehículo(id, placa, descripcion);
            }
        } catch (Exception e) {
        }

        return r;
    }
}
