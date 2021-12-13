package ar.org.centro8.curso.java.web.repositories.jdbc;

import ar.org.centro8.curso.java.web.entities.Articulo;
import ar.org.centro8.curso.java.web.enums.EspecieRecomendada;
import ar.org.centro8.curso.java.web.enums.TipoArticulo;
import ar.org.centro8.curso.java.web.repositories.interfaces.I_ArticuloRepository;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ArticuloRepository implements I_ArticuloRepository{

    private Connection conn;

    public ArticuloRepository(Connection conn) {
        this.conn = conn;
    }
    
    @Override
    public void save(Articulo articulo) {
        if(articulo == null) return;
        String sqlDireccion="insert into articulos"
                + "(nombre,descripcion,tipo,especieRecomendada,costo,precio,stock,stockMinimo,stockMaximo,comentarios,activo) "
                + "values(?,?,?,?,?,?,?,?,?,?,?)";
        
        try (PreparedStatement ps=conn.prepareStatement(sqlDireccion,PreparedStatement.RETURN_GENERATED_KEYS)){
            ps.setString(1, articulo.getNombre());
            ps.setString(2, articulo.getDescripcion());
            ps.setString(3, articulo.getTipoArticulo()+"");
            ps.setString(4, articulo.getEspecieRecomendada()+"");
            ps.setDouble(5, articulo.getCosto());
            ps.setDouble(6, articulo.getPrecio());
            ps.setInt(7, articulo.getStock());
            ps.setInt(8, articulo.getStockMinimo());
            ps.setInt(9, articulo.getStockMaximo());
            ps.setString(10, articulo.getComentarios());
            ps.setBoolean(11, articulo.isActivo());
            ps.execute();
            
            ResultSet rs=ps.getGeneratedKeys();
            if(rs.next()) 
                articulo.setId(rs.getInt(1));
            
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @Override
    public void remove(Articulo articulo) {
        if(articulo == null) return;
        try (PreparedStatement ps=conn.prepareStatement("delete from articulos where id=?")){
            ps.setInt(1, articulo.getId());
            ps.execute();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @Override
    public void update(Articulo articulo) {
        if(articulo == null) return;
        try (PreparedStatement ps=conn.prepareStatement(
			"update articulos set "
                                + "nombre=?,descripcion=?,tipo=?,especieRecomendada=?,costo=?,precio=?,stock=?,stockMinimo=?,stockMaximo=?,comentarios=?,activo=?"
                                + "where id=?"
		)){
			ps.setString(1,articulo.getNombre());
			ps.setString(2,articulo.getDescripcion());
			ps.setString(3,articulo.getTipoArticulo()+"");
			ps.setString(4,articulo.getEspecieRecomendada()+"");
			ps.setDouble(5,articulo.getCosto());
			ps.setDouble(6,articulo.getPrecio());
			ps.setInt(7,articulo.getStock());
			ps.setInt(8,articulo.getStockMinimo());
			ps.setInt(9,articulo.getStockMaximo());
			ps.setString(10,articulo.getComentarios());
			ps.setBoolean(11,articulo.isActivo());
			ps.setInt(12,articulo.getId());
			ps.execute();
		} catch (Exception e) {
			System.out.println(e);
		}
    }

    @Override
    public List<Articulo> getAll() {
        List <Articulo> list = new ArrayList();
        String sqlConsultarV="select * from articulos;";
        try (ResultSet rs=conn.createStatement().executeQuery(sqlConsultarV)){
            while(rs.next()){
                list.add(new Articulo(
                        rs.getInt("id"),
                        rs.getString("nombre"),
                        rs.getString("descripcion"),
                        TipoArticulo.valueOf(rs.getString("tipo")),
                        EspecieRecomendada.valueOf(rs.getString("especieRecomendada")),
                        rs.getDouble("costo"),
                        rs.getDouble("precio"),
                        rs.getInt("stock"),
                        rs.getInt("stockMinimo"),
                        rs.getInt("stockMaximo"),
                        rs.getString("comentarios"),
                        rs.getBoolean("activo")
                ));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return list;
    }
    
}
