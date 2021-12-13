package ar.org.centro8.curso.java.web.test;

import ar.org.centro8.curso.java.web.entities.Articulo;
import ar.org.centro8.curso.java.web.entities.Cliente;
import ar.org.centro8.curso.java.web.entities.Direccion;
import ar.org.centro8.curso.java.web.enums.EspecieRecomendada;
import ar.org.centro8.curso.java.web.enums.TipoArticulo;
import ar.org.centro8.curso.java.web.enums.TipoDocumento;
import ar.org.centro8.curso.java.web.interfaces.connectors.Connector;
import ar.org.centro8.curso.java.web.repositories.interfaces.I_ArticuloRepository;
import ar.org.centro8.curso.java.web.repositories.interfaces.I_ClienteRepository;
import ar.org.centro8.curso.java.web.repositories.jdbc.ArticuloRepository;
import ar.org.centro8.curso.java.web.repositories.jdbc.ClienteRepository;
import ar.org.centro8.curso.java.web.repositories.list.ClienteRepositoryFactory;

public class TestRepository {
    public static void main(String[] args) {
        //I_ClienteRepository cr=ClienteRepositoryFactory.getClienteRepository();
        I_ClienteRepository cr=new ClienteRepository(Connector.getConnection());
        
        //cr.save(new Cliente("Juan1", "Perez", "2005/05/05", TipoDocumento.DNI, "1221111", "222222", "nada@nada", new Direccion("Viel", 10, "", "", "", "1111", "CABA", "CABA", "Argentina"), ""));
        //cr.save(new Cliente("Laura2", "Mendez", "2005/05/05", TipoDocumento.DNI, "1331112", "222222", "nada@nada", new Direccion("Viel", 10, "", "", "", "1111", "CABA", "CABA", "Argentina"), ""));
        //cr.save(new Cliente("Jose3", "Gomez", "2005/05/05", TipoDocumento.DNI, "1441113", "222222", "nada@nada", new Direccion("Viel", 10, "", "", "", "1111", "CABA", "CABA", "Argentina"), ""));
        //cr.save(new Cliente("Ana4", "Lopez", "2005/05/05", TipoDocumento.DNI, "1551114", "222222", "nada@nada", new Direccion("Viel", 10, "", "", "", "1111", "CABA", "CABA", "Argentina"), ""));
       /* 
        cr.getAll().forEach(System.out::println);
        System.out.println("=================================");
        cr.getLikeApellido("go").forEach(System.out::println);
        System.out.println("================================="); */
            I_ArticuloRepository ar = new ArticuloRepository(Connector.getConnection());
        ar.save(new Articulo("Basken Plus", "Medicamento para Gatos", TipoArticulo.MEDICAMENTO, EspecieRecomendada.FELINO, 200, 1000, 15, 8, 15, "Oferta! ", true));
        ar.save(new Articulo("Sueter pequeño para Gato", "Sueter vestir un Gato o Gata", TipoArticulo.PRENDA, EspecieRecomendada.FELINO, 100, 800, 20, 10, 30, null, false));
        ar.save(new Articulo("Raton atado a palo", "Raton peluche atado a un palo para Gatos", TipoArticulo.JUGUETE, EspecieRecomendada.FELINO, 200, 1200, 15, 10, 20, "5 diferentes colores disponibles! ", true));
        ar.save(new Articulo("Goldfish TETRA", "Alimento para peces hecho por TETRA", TipoArticulo.ALIMENTO, EspecieRecomendada.PEZ, 50, 350, 20, 10, 30,null, false));
        ar.getAll().forEach(System.out::println);
        System.out.println("=================================");
        ar.getLikeNombreArticulo("Su").forEach(System.out::println);
        System.out.println("*=================================");
        System.out.println(ar.getById(3));
        System.out.println("=================================");
        ar.getByActivo(true).forEach(System.out::println);
        System.out.println("=================================");
        
        
          ar.remove(ar.getById(5));
          ar.remove(ar.getById(6));
          ar.remove(ar.getById(8));
          ar.remove(ar.getById(9));
          ar.remove(ar.getById(10));
          ar.remove(ar.getById(11));
          ar.remove(ar.getById(12));
          ar.remove(ar.getById(13));
          ar.remove(ar.getById(14));
          ar.remove(ar.getById(15));
          ar.remove(ar.getById(16));
          ar.remove(ar.getById(17));
          ar.remove(ar.getById(18));
          ar.remove(ar.getById(19));
          ar.remove(ar.getById(20));
          ar.remove(ar.getById(21));
          ar.remove(ar.getById(22));
          ar.remove(ar.getById(23));
          ar.remove(ar.getById(24));
          ar.remove(ar.getById(27));
          ar.remove(ar.getById(29));
          ar.remove(ar.getById(37));
          ar.remove(ar.getById(38));
          ar.remove(ar.getById(39));
          ar.remove(ar.getById(40));
          ar.remove(ar.getById(49));
          ar.remove(ar.getById(50));
          ar.remove(ar.getById(51));
          ar.remove(ar.getById(52));
          ar.remove(ar.getById(53));
          ar.remove(ar.getById(54));
          ar.remove(ar.getById(55));
          ar.remove(ar.getById(56));
          ar.remove(ar.getById(57));
       
//         Articulo a=ar.getById(4);
//        a.setActivo(true);
//        ar.update(a);
//        System.out.println("=================================");
//        System.out.println("Consulta por nombre");
//        ar.getLikeNombreArticulo("Goldfish").forEach(System.out::println);
//        
    }
}
