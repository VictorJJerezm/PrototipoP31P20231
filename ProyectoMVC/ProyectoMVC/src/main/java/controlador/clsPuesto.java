/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;
import java.util.List;
import modelo.daoPuesto;
/**
 *
 * @author visitante
 */
public class clsPuesto {
    private int CodigoPuesto;
    private String NombrePueto;
    private String EstatusPuesto;

    public int getCodigoPuesto() {
        return CodigoPuesto;
    }

    public void setCodigoPuesto(int CodigoPuesto) {
        this.CodigoPuesto = CodigoPuesto;
    }

    public String getNombrePueto() {
        return NombrePueto;
    }

    public void setNombrePueto(String NombrePueto) {
        this.NombrePueto = NombrePueto;
    }

    public String getEstatusPuesto() {
        return EstatusPuesto;
    }

    public void setEstatusPuesto(String EstatusPuesto) {
        this.EstatusPuesto = EstatusPuesto;
    }

    public clsPuesto(int CodigoPuesto, String NombrePueto) {
        this.CodigoPuesto = CodigoPuesto;
        this.NombrePueto = NombrePueto;
    }

    public clsPuesto(int CodigoPuesto, String NombrePueto, String EstatusPuesto) {
        this.CodigoPuesto = CodigoPuesto;
        this.NombrePueto = NombrePueto;
        this.EstatusPuesto = EstatusPuesto;
    }

    public clsPuesto(int CodigoPuesto) {
        this.CodigoPuesto = CodigoPuesto;
    }

    public clsPuesto() {
    }
    //Metodos de acceso a la capa controlador
    public clsPuesto getBuscarInformacionPuestoPorNombre(clsPuesto puesto)
    {
        daoPuesto daopuesto = new daoPuesto();
        return daopuesto.consultaPuestoPorNombre(puesto);
    }
    public clsPuesto getBuscarInformacionPuestoPorId(clsPuesto puesto)
    {
        daoPuesto daopuesto = new daoPuesto();
        return daopuesto.consultaPuestoPorId(puesto);
    }    
    public List<clsPuesto> getListadoPuesto()
    {
        daoPuesto daopuesto = new daoPuesto();
        List<clsPuesto> listadoPuesto = daopuesto.consultaPuesto();
        return listadoPuesto;
    }
    public int setBorrarPuesto(clsPuesto puesto)
    {
        daoPuesto daopuesto = new daoPuesto();
        return daopuesto.borrarPuesto(puesto);
    }          
    public int setIngresarPuesto(clsPuesto puesto)
    {
        daoPuesto daopuesto = new daoPuesto();
        return daopuesto.ingresaPuestos(puesto);
    }              
    public int setModificarPuesto(clsPuesto puesto)
    {
        daoPuesto daopuesto = new daoPuesto();
        return daopuesto.actualizaPuestos(puesto);
        
    }              
}

