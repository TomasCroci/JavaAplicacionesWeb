package TP2ServletCliente;

import ar.org.centro8.curso.java.web.entities.Cliente;
import ar.org.centro8.curso.java.web.entities.Articulo;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.IOException;
import java.lang.reflect.Type;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;

public class TP2_ServletCliente {

    public static void main(String[] args) throws Exception{
        
        String server="http://localhost:8089/server";
        String url;  
        
        
        /*System.out.println("****************************************************");
        System.out.println("-- Server ");
        System.out.println("****************************************************");
        url=server;
        System.out.println(responseBody(url));
        
        System.out.println("****************************************************");
        System.out.println("-- ClientesAlta 1");
        System.out.println("****************************************************");
        url=server+"/ClientesAlta?nombre=Juan&apellido=Perez&fenaci=2005/05/05&tipoDocumento=DNI&numeroDocumento=1111915&telefono=222222&email=nada@nada&calle=Viel&numero=10&piso=x&depto=x&codigoPostal=1111&ciudad=CABA&provincia=CABA&pais=Argentina&comentarios=x";
        System.out.println(responseBody(url));
        
        System.out.println("****************************************************");
        System.out.println("-- ClientesAlta 2");
        System.out.println("****************************************************");
        url=server+"/ClientesAlta?nombre=Ana&apellido=Garcia&fenaci=2005/05/05&tipoDocumento=DNI&numeroDocumento=1111815&telefono=222222&email=nada@nada&calle=Viel&numero=10&piso=x&depto=x&codigoPostal=1111&ciudad=CABA&provincia=CABA&pais=Argentina&comentarios=x";
        System.out.println(responseBody(url));
        
        System.out.println("****************************************************");
        System.out.println("-- ClientesAlta 3");
        System.out.println("****************************************************");
        url=server+"/ClientesAlta?nombre=Lorena&apellido=Broca&fenaci=2005/05/05&tipoDocumento=DNI&numeroDocumento=1117115&telefono=222222&email=nada@nada&calle=Viel&numero=10&piso=x&depto=x&codigoPostal=1111&ciudad=CABA&provincia=CABA&pais=Argentina&comentarios=x";
        System.out.println(responseBody(url));
        
        System.out.println("****************************************************");
        System.out.println("-- ClientesAlta 4");
        System.out.println("****************************************************");
        url=server+"/ClientesAlta?nombre=Jose&apellido=Gomez&fenaci=2005/05/05&tipoDocumento=DNI&numeroDocumento=1111615&telefono=222222&email=nada@nada&calle=Viel&numero=10&piso=x&depto=x&codigoPostal=1111&ciudad=CABA&provincia=CABA&pais=Argentina&comentarios=x";
        System.out.println(responseBody(url));

        System.out.println("****************************************************");
        System.out.println("-- ClientesAll ");
        System.out.println("****************************************************");
        url=server+"/ClientesAll";
        System.out.println(responseBody(url));
        
        System.out.println("****************************************************");
        System.out.println("-- ClientesLikeApellido ");
        System.out.println("****************************************************");
        url=server+"/LikeApellido?apellido=Me";
        System.out.println(responseBody(url));
        
        System.out.println("*******************************************");
        System.out.println("*******************************************");
        url=server+"/ClientesAll";
        Type listType=new TypeToken<List<Cliente>>(){}.getType();
        List<Cliente>listCli=new Gson().fromJson(responseBody(url), listType);
        listCli.forEach(System.out::println);
        ¨*/
        System.out.println("****************************************************");
        System.out.println("-- Server ");
        System.out.println("****************************************************");
        url=server;
        System.out.println(responseBody(url));
        
        System.out.println("****************************************************");
        System.out.println("-- ArticulosAlta 1");
        System.out.println("****************************************************");
        url=server+"/ArticulosAlta?nombre=BaskenPlus&descripcion=MedicamentoParaGatos&tipo=MEDICAMENTO&especieRecomendada=FELINO&costo=200&precio=1000&stock=15&stockMinimo=8&stockMaximo=15&comentario=Oferta&activo=true";
        System.out.println(responseBody(url));
        
        System.out.println("****************************************************");
        System.out.println("-- ArticulosAlta 2");
        System.out.println("****************************************************");
        url=server+"/ArticulosAlta?nombre=Sueter&descripcion=SueterParaGatos&tipo=PRENDA&especieRecomendada=FELINO&costo"
                + "=100&precio=800&stock=20&stockMinimo=10&stockMaximo=30&comentario=null&activo=false";
        System.out.println(responseBody(url));
        
        System.out.println("****************************************************");
        System.out.println("-- ArticulosAll");
        System.out.println("****************************************************");
        url=server+"/ArticulosAll";
        System.out.println(responseBody(url));
        
        System.out.println("****************************************************");
        System.out.println("-- ArticulosLikeNombre");
        System.out.println("****************************************************");
        url=server+"/ArticulosLikeNombre?nombre=su";
        System.out.println(responseBody(url));
        
        System.out.println("****************************************************");
        System.out.println("-- ArticulosLikeEspecie");
        System.out.println("****************************************************");
        url=server+"/ArticulosLikeEspecie?especieRecomendada=FELINO";
        System.out.println(responseBody(url));
        
        System.out.println("****************************************************");
        System.out.println("--ArticulosActivos");
        System.out.println("****************************************************");
        url=server+"/ArticulosActivos?activo=true";
        System.out.println(responseBody(url));
        
        System.out.println("****************************************************");
        System.out.println("--ArticulosByTipoArticulo");
        System.out.println("****************************************************");
        url=server+"/ArticulosByTipoArticulo?tipo=ACCESORIO";
        System.out.println(responseBody(url));
               
        System.out.println("*******************************************");
        System.out.println("*******************************************");
        
    }
    
    private static String responseBody(String url) throws InterruptedException, IOException {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest
                .newBuilder()
                .uri(URI.create(url))
                .build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        if(response.statusCode()==200){
            System.out.println("\033[32mstatus: "+response.statusCode()+"\033[0m");
        }else{
            System.out.println("\033[31mstatus: "+response.statusCode()+"\033[0m");
        }
        response.headers().map().forEach((k, v) -> System.out.println(k + " " + v));
        return response.body();
    }
}
