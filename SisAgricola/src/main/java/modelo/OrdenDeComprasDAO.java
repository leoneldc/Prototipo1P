

package modelo;

import controlador.OrdenDeCompras;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

 /**
 * @author H. Leonel Dominguez C.
 * @github https://github.com/leoneldc
 */

public class OrdenDeComprasDAO {

    private static final String SQL_INSERT = "INSERT into SolicitudDeCompra(codigo_producto,codigo_solicitante,cantidad_solicitud,estatus_producto) values(?,?,?,?)";
    private static final String SQL_DELETE = "DELETE from SolicitudDeCompra where codigo_solicitud = ?";
    private static final String SQL_UPDATE = "UPDATE SolicitudDeCompra SET cantidad_solicitud=? WHERE codigo_solicitud=?";
    private static final String SQL_SELECT = "SELECT * FROM SolicitudDeCompra";
    
    Connection conn = null;
    PreparedStatement stmt = null;
    ResultSet rs = null;
    
    public List<OrdenDeCompras> select() {
        OrdenDeCompras orden = null;
        List<OrdenDeCompras> listado = new ArrayList<OrdenDeCompras>();
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {
                String asignacion = rs.getString(1);
                String producto = rs.getString(2);
                String usuario = rs.getString(3);
                String existencia = rs.getString(4);
                String estado = rs.getString(5);
                orden = new OrdenDeCompras();
                orden.setAsignacion(asignacion);
                orden.setProducto(producto);
                orden.setUsuario(usuario);
                orden.setCantidad(existencia);
                orden.setEstado(estado);
                listado.add(orden);
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return listado;
    }
    
    public int insert(OrdenDeCompras asignacion) {
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, asignacion.getProducto());
            stmt.setString(2, asignacion.getUsuario());
            stmt.setString(3, asignacion.getCantidad());
            stmt.setString(4, asignacion.getEstado());
            //System.out.println("ejecutando query:" + SQL_INSERT);
            rows = stmt.executeUpdate();
            //System.out.println("Registros afectados:" + rows);
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return rows;
    }
        
    public int delete(OrdenDeCompras asignacion) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setString(1, asignacion.getAsignacion());
            //System.out.println(stmt);
            rows = stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return rows;
    }
    
    public int update(OrdenDeCompras asignacion) {
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setString(1, asignacion.getCantidad());
            stmt.setString(2, asignacion.getAsignacion());
//          System.out.println(stmt);
            rows = stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return rows;
    }
}
