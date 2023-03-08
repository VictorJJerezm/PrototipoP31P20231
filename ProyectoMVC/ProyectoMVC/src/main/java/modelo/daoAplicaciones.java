/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import controlador.clsAplicaciones;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author visitante
 */
public class daoAplicaciones {

    private static final String SQL_SELECT = "SELECT aplid, aplnombre, aplestatus FROM tbl_aplicaciones";
    private static final String SQL_INSERT = "INSERT INTO tbl_aplicaciones(aplnombre, aplestatus) VALUES(?, ?)";
    private static final String SQL_UPDATE = "UPDATE tbl_aplicaciones SET aplnombre=?, aplestatus=? WHERE aplid = ?";
    private static final String SQL_DELETE = "DELETE FROM tbl_aplicaciones WHERE aplid=?";
    private static final String SQL_SELECT_NOMBRE = "SELECT aplid, aplnombre, aplestatus FROM tbl_aplicaiones WHERE aplnombre = ?";
    private static final String SQL_SELECT_ID = "SELECT aplid, aplnombre, aplestatus FROM tbl_aplicaciones WHERE aplid = ?";    

    public List<clsAplicaciones> consultaAplicaciones() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        List<clsAplicaciones> aplicaciones = new ArrayList<>();
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("aplid");
                String nombre = rs.getString("aplnombre");
                String estatus = rs.getString("aplestatus");
                clsAplicaciones aplicacion = new clsAplicaciones();
                aplicacion.setIdAplicacion(id);
                aplicacion.setNombreAplicacion(nombre);
                aplicacion.setEstatusAplicacion(estatus);
                aplicaciones.add(aplicacion);
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return aplicaciones;
    }

    public int ingresaAplicaciones(clsAplicaciones aplicaciones) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, aplicaciones.getNombreAplicacion());
            stmt.setString(2, aplicaciones.getEstatusAplicacion());

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

    public int actualizaAplicaciones(clsAplicaciones aplicaciones) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            System.out.println("ejecutando query: " + SQL_UPDATE);
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setString(1, aplicaciones.getNombreAplicacion());
            stmt.setString(2, aplicaciones.getEstatusAplicacion());
            stmt.setInt(3, aplicaciones.getIdAplicacion());

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

    public int borrarAplicaciones(clsAplicaciones aplicaciones) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = Conexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_DELETE);
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, aplicaciones.getIdAplicacion());
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

    public clsAplicaciones consultaAplicionesPorNombre(clsAplicaciones aplicaciones) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = Conexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_SELECT_NOMBRE + " objeto recibido: " + aplicaciones);
            stmt = conn.prepareStatement(SQL_SELECT_NOMBRE);
            //stmt.setInt(1, aplicaiones.getIdAplicacion());            
            stmt.setString(1, aplicaciones.getNombreAplicacion());
            rs = stmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("aplid");
                String nombre = rs.getString("aplnombre");
                String estatus = rs.getString("aplcontrasena");

                //aplicaciones = new clsAplicaciones();
                aplicaciones.setIdAplicacion(id);
                aplicaciones.setNombreAplicacion(nombre);
                aplicaciones.setEstatusAplicacion(estatus);
                System.out.println(" registro consultado: " + aplicaciones);                
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
        return aplicaciones;
    }
    public clsAplicaciones consultaAplicacionesPorId(clsAplicaciones aplicaciones) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = Conexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_SELECT_NOMBRE + " objeto recibido: " + aplicaciones);
            stmt = conn.prepareStatement(SQL_SELECT_ID);
            stmt.setInt(1, aplicaciones.getIdAplicacion());            
            //stmt.setString(1, aplicaciones.getNombreAplicaciones());
            rs = stmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("aplid");
                String nombre = rs.getString("aplnombre");
                String estatus = rs.getString("aplestatus");

                //aplicaciones = new clsAplicaciones();
                aplicaciones.setIdAplicacion(id);
                aplicaciones.setNombreAplicacion(nombre);
                aplicaciones.setEstatusAplicacion(estatus);
                System.out.println(" registro consultado: " + aplicaciones);                
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
        return aplicaciones;
    }   
}
