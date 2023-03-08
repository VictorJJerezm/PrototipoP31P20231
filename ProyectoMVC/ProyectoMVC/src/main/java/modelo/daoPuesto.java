/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import controlador.clsPuesto;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author visitante
 */
public class daoPuesto {

    private static final String SQL_SELECT = "SELECT codigo_puesto, nombre_puesto, estatus_puesto FROM sin1.puesto";
    private static final String SQL_INSERT = "INSERT INTO sin1.puesto(nombre_puesto, estatus_puesto) VALUES(?, ?)";
    private static final String SQL_UPDATE = "UPDATE sin1.puesto SET nombre_puesto=?, estatus_puesto=? WHERE codigo_puesto = ?";
    private static final String SQL_DELETE = "DELETE FROM sin1.puesto WHERE codigo_puesto=?";
    private static final String SQL_SELECT_NOMBRE = "SELECT codigo_puesto, nombre_puesto, estatus_puesto FROM sin1.puesto WHERE nombre_puesto = ?";
    private static final String SQL_SELECT_ID = "SELECT codigo_puesto, nombre_puesto, estatus_puesto FROM sin1.puesto WHERE codigo_puesto = ?";    

    public List<clsPuesto> consultaPuesto() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        List<clsPuesto> puesto = new ArrayList<>();
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("codigo_puesto");
                String nombre = rs.getString("nombre_puesto");
                String estatus = rs.getString("estatus_puesto");
                clsPuesto puestos = new clsPuesto();
                puestos.setCodigoPuesto(id);
                puestos.setNombrePueto(nombre);
                puestos.setEstatusPuesto(estatus);
                puesto.add(puestos);
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return puesto;
    }

    public int ingresaPuestos(clsPuesto puesto) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, puesto.getNombrePueto());
            stmt.setString(2, puesto.getEstatusPuesto());

            System.out.println("ejecutando query:" + SQL_INSERT);
            rows = stmt.executeUpdate();
            System.out.println("Registros afectados:" + rows);
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        return rows;
    }

    public int actualizaPuestos(clsPuesto puesto) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            System.out.println("ejecutando query: " + SQL_UPDATE);
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setString(1, puesto.getNombrePueto());
            stmt.setString(2, puesto.getEstatusPuesto());
            stmt.setInt(3, puesto.getCodigoPuesto());

            rows = stmt.executeUpdate();
            System.out.println("Registros actualizado:" + rows);

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        return rows;
    }

    public int borrarPuesto(clsPuesto puesto) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = Conexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_DELETE);
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, puesto.getCodigoPuesto());
            rows = stmt.executeUpdate();
            System.out.println("Registros eliminados:" + rows);
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        return rows;
    }

    public clsPuesto consultaPuestoPorNombre(clsPuesto puesto) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = Conexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_SELECT_NOMBRE + " objeto recibido: " + puesto);
            stmt = conn.prepareStatement(SQL_SELECT_NOMBRE);
            //stmt.setInt(1, aplicaiones.getIdAplicacion());            
            stmt.setString(1, puesto.getNombrePueto());
            rs = stmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("codigo_puesto");
                String nombre = rs.getString("nombre_puesto");
                String estatus = rs.getString("estatus_puesto");

                //pueato = new clsPuesto();
                puesto.setCodigoPuesto(id);
                puesto.setNombrePueto(nombre);
                puesto.setEstatusPuesto(estatus);
                System.out.println(" registro consultado: " + puesto);                
            }
            //System.out.println("Registros buscado:" + persona);
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        //return personas;  // Si se utiliza un ArrayList
        return puesto;
    }
    public clsPuesto consultaPuestoPorId(clsPuesto puesto) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = Conexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_SELECT_NOMBRE + " objeto recibido: " + puesto);
            stmt = conn.prepareStatement(SQL_SELECT_ID);
            stmt.setInt(1, puesto.getCodigoPuesto());            
            //stmt.setString(1, puesto.getNombrePueto());
            rs = stmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("codigo_puesto");
                String nombre = rs.getString("nombre_puesto");
                String estatus = rs.getString("estatus_puesto");

                //puesto = new clsPuesto();
                puesto.setCodigoPuesto(id);
                puesto.setNombrePueto(nombre);
                puesto.setEstatusPuesto(estatus);
                System.out.println(" registro consultado: " + puesto);                
            }
            //System.out.println("Registros buscado:" + persona);
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        //return personas;  // Si se utiliza un ArrayList
        return puesto;
    }   
}
