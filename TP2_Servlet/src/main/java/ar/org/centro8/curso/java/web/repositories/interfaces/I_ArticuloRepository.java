package ar.org.centro8.curso.java.web.repositories.interfaces;

import ar.org.centro8.curso.java.web.entities.Articulo;
import ar.org.centro8.curso.java.web.enums.TipoArticulo;
import ar.org.centro8.curso.java.web.enums.EspecieRecomendada;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public interface I_ArticuloRepository {
    void save(Articulo articulo);
    void remove(Articulo articulo);
    void update(Articulo articulo);
   
    
      default Articulo getById(int id) {
        return getAll()
                .stream()
                .filter(c -> c.getId() == id)
                .findFirst()
                .orElse(new Articulo());
    }
 List<Articulo>getAll();
    
 default List<Articulo> getLikeNombreArticulo(String nombreArticulo) {
        if (nombreArticulo == null) {
            return new ArrayList();
        }
        return getAll()
                .stream()
                .filter(c -> c.getNombre() != null
                && c.getNombre().toLowerCase().contains(nombreArticulo.toLowerCase()))
                .collect(Collectors.toList());
    }
  default Articulo getByTipoArticulo(TipoArticulo tipoArticulo) {
        if (tipoArticulo == null) {
            return new Articulo();
        }
        return getAll()
                .stream()
                .filter(a -> a.getTipoArticulo() != null && a.getTipoArticulo() == tipoArticulo)
                .findAny()
                .orElse(new Articulo());
    }
  default List<Articulo> getByActivo(boolean activo) {
        return getAll()
                .stream()
                .filter(a -> a.isActivo() == activo)
                .collect(Collectors.toList());
    }
   default List<Articulo>getLikeEspecieRecomendada(EspecieRecomendada especieRecomendada){
        if(especieRecomendada==null) return new ArrayList();
        return getAll()
                .stream()
                .filter(a->a.getEspecieRecomendada().equals(especieRecomendada))
                .collect(Collectors.toList());
    }
}

