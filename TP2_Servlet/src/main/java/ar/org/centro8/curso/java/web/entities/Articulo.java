
package ar.org.centro8.curso.java.web.entities;
import ar.org.centro8.curso.java.web.enums.EspecieRecomendada;
import ar.org.centro8.curso.java.web.enums.TipoArticulo;

public class Articulo {
    private int id;
    private String nombre;
    private String descripcion;
    private TipoArticulo tipoArticulo;
    private EspecieRecomendada especieRecomendada;
    private double costo;
    private double precio;
    private int stock;
    private int stockMinimo;
    private int stockMaximo;
    private String comentarios;
    private boolean activo;

public Articulo() {   
}
 public Articulo(String nombre, String descripcion, TipoArticulo tipoArticulo, EspecieRecomendada especieRecomendada, double costo, double precio, int stock, int stockMinimo, int stockMaximo, String comentarios, boolean activo) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.tipoArticulo = tipoArticulo;
        this.especieRecomendada = especieRecomendada;
        this.costo = costo;
        this.precio = precio;
        this.stock = stock;
        this.stockMinimo = stockMinimo;
        this.stockMaximo = stockMaximo;
        this.comentarios = comentarios;
        this.activo = activo;
    }
 public Articulo(int id, String nombre, String descripcion, TipoArticulo tipoArticulo, EspecieRecomendada especieRecomendada, double costo, double precio, int stock, int stockMinimo, int stockMaximo, String comentarios, boolean activo) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.tipoArticulo = tipoArticulo;
        this.especieRecomendada = especieRecomendada;
        this.costo = costo;
        this.precio = precio;
        this.stock = stock;
        this.stockMinimo = stockMinimo;
        this.stockMaximo = stockMaximo;
        this.comentarios = comentarios;
        this.activo = activo;
    }

    @Override
    public String toString() {
        return "Articulo{" + "id=" + id + ", nombre=" + nombre + ", descripcion=" + descripcion + ", tipoArticulo=" + tipoArticulo + ", especieRecomendada=" + especieRecomendada + ", costo=" + costo + ", precio=" + precio + ", stock=" + stock + ", stockMinimo=" + stockMinimo + ", stockMaximo=" + stockMaximo + ", comentarios=" + comentarios + ", activo=" + activo + '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public TipoArticulo getTipoArticulo() {
        return tipoArticulo;
    }

    public void setTipoArticulo(TipoArticulo tipoArticulo) {
        this.tipoArticulo = tipoArticulo;
    }

    public EspecieRecomendada getEspecieRecomendada() {
        return especieRecomendada;
    }

    public void setEspecieRecomendada(EspecieRecomendada especieRecomendada) {
        this.especieRecomendada = especieRecomendada;
    }

    public double getCosto() {
        return costo;
    }

    public void setCosto(double costo) {
        this.costo = costo;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public int getStockMinimo() {
        return stockMinimo;
    }

    public void setStockMinimo(int stockMinimo) {
        this.stockMinimo = stockMinimo;
    }

    public int getStockMaximo() {
        return stockMaximo;
    }

    public void setStockMaximo(int stockMaximo) {
        this.stockMaximo = stockMaximo;
    }

    public String getComentarios() {
        return comentarios;
    }

    public void setComentarios(String comentarios) {
        this.comentarios = comentarios;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }    

}

