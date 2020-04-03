/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Graficas;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Adriel Chavarría B
 */
public class Ini {

    File ini = new File("C:\\Users\\Adriel Chavarría B\\Documents\\NetBeansProjects\\conf.ini");
    private Connection conexion;
    private Statement sentencias;
    private ResultSet datos;
    FileInputStream entrada;
    FileOutputStream salida;

    public String GuardarArchivo(File ini, String documento) {
        String mensaje = null;
        try {
            salida = new FileOutputStream(ini);
            byte[] bytxt = documento.getBytes();
            salida.write(bytxt);
            mensaje = "Archivo guardado";
        } catch (Exception e) {

        }
        return mensaje;
    }

    public void verificar() throws SQLException {
        if (!ini.exists()) {
            try {
                ini.createNewFile();
                this.conexion = DriverManager.getConnection("jdbc:mysql://localhost/?useServerPrepStmts=true", "root", "");
                this.sentencias = this.conexion.createStatement();
                

            } catch (IOException e) {
            }
        } else {
            System.out.println("Error");
        }
    }
}
