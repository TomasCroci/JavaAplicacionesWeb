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
        System.out.println("****************************************************");
        cr.getLikeApellido("go").forEach(System.out::println);
        System.out.println("****************************************************"); */
            I_ArticuloRepository ar = new ArticuloRepository(Connector.getConnection());
        ar.save(new Articulo("Basken Plus", "Medicamento para Gatos", TipoArticulo.MEDICAMENTO, EspecieRecomendada.FELINO, 200, 1000, 15, 8, 15, "Oferta!!", true));
        ar.save(new Articulo("Sueter pequeño para Gato", "Sueter vestir un Gato o Gata", TipoArticulo.PRENDA, EspecieRecomendada.FELINO, 100, 800, 20, 10, 30,null, false));
        ar.save(new Articulo("Raton atado a palo", "Raton peluche atado a un palo para Gatos", TipoArticulo.JUGUETE, EspecieRecomendada.FELINO, 200, 1200, 15, 10, 20, "5 diferentes colores disponibles!", true));
        ar.save(new Articulo("Goldfish TETRA", "Alimento para peces hecho por TETRA", TipoArticulo.ALIMENTO, EspecieRecomendada.PEZ, 50, 350, 20, 10, 30, null, false));
        ar.getAll().forEach(System.out::println);
        System.out.println("------------------------------");
        ar.getLikeNombreArticulo("Su").forEach(System.out::println);
        System.out.println("-------------------------------");
        System.out.println(ar.getById(15));
        System.out.println("------------------------------");
        ar.getByActivo(true).forEach(System.out::println);
        System.out.println("------------------------------");
        
        
    }
}