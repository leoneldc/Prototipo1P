package modelo;

import controlador.Productos;
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
public class ProductosDAO {
    
    public static String codigoProducto, nombreProducto;
    private static final String SQL_INSERT = "INSERT into Productos(nombre_producto,marca_producto,existencia_producto,estatus_producto) values(?,?,?,?)";
    private static final String SQL_DELETE = "DELETE from Productos where codigo_producto = ?";
    private static final String SQL_UPDATE = "UPDATE Productos SET nombre_producto=?, marca_producto=?, existencia_producto=?, estatus_producto=? WHERE codigo_producto=?";
    Connection conn = null;
    PreparedStatement stmt = null;
    ResultSet rs = null;
    
    public List<Productos> select() {
        String SQL_SELECT = "SELECT * FROM Productos WHERE codigo_producto LIKE '%" + codigoProducto + "%' OR nombre_producto LIKE '%" + nombreProducto + "%'";
        Productos productos = null;
        List<Productos> listado = new ArrayList<Productos>();
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {
                String id = rs.getString(1);
                String nombre = rs.getString(2);
                String marca = rs.getString(3);
                String existencia = rs.getString(4);
                String estado = rs.getString(5);
                productos = new Productos();
                productos.setId(id);
                productos.setNombre(nombre);
                productos.setMarca(marca);
                productos.setExistencia(existencia);
                productos.setEstado(estado);
                listado.add(productos);
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
    
    public int insert(Productos producto) {
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, producto.getNombre());
            stmt.setString(2, producto.getMarca());
            stmt.setString(3, producto.getExistencia());
            stmt.setString(4, producto.getEstado());
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
    
    public int delete(Productos producto) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setString(1, producto.getId());
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
    
    public int update(Productos producto) {
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setString(1, producto.getNombre());
            stmt.setString(2, producto.getMarca());
            stmt.setString(3, producto.getExistencia());
            stmt.setString(4, producto.getEstado());
            stmt.setString(5, producto.getId());
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
