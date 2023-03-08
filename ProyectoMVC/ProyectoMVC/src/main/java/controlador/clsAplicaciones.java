/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;
import java.util.List;
import modelo.daoAplicaciones;
/**
 *
 * @author visitante
 */
public class clsAplicaciones {
    private int IdAplicacion;
    private String NombreAplicacion;
    private String EstatusAplicacion;

    public int getIdAplicacion() {
        return IdAplicacion;
    }

    public void setIdAplicacion(int IdAplicacion) {
        this.IdAplicacion = IdAplicacion;
    }

    public String getNombreAplicacion() {
        return NombreAplicacion;
    }

    public void setNombreAplicacion(String NombreAplicacion) {
        this.NombreAplicacion = NombreAplicacion;
    }

    public String getEstatusAplicacion() {
        return EstatusAplicacion;
    }

    public void setEstatusAplicacion(String EstatusAplicacion) {
        this.EstatusAplicacion = EstatusAplicacion;
    }

    public clsAplicaciones(int IdAplicacion, String NombreAplicacion) {
        this.IdAplicacion = IdAplicacion;
        this.NombreAplicacion = NombreAplicacion;
    }

    public clsAplicaciones(int IdAplicacion, String NombreAplicacion, String EstatusAplicacion) {
        this.IdAplicacion = IdAplicacion;
        this.NombreAplicacion = NombreAplicacion;
        this.EstatusAplicacion = EstatusAplicacion;
    }

    public clsAplicaciones(int IdAplicacion) {
        this.IdAplicacion = IdAplicacion;
    }

    public clsAplicaciones() {
    }


    //Metodos de acceso a la capa controlador
    public clsAplicaciones getBuscarInformacionAplicacionesPorNombre(clsAplicaciones aplicaciones)
    {
        daoAplicaciones daoaplicaciones = new daoAplicaciones();
        return daoaplicaciones.consultaAplicionesPorNombre(aplicaciones);//.consultaAplicacionesPorNombre(aplicaciones);
    }
    public clsAplicaciones getBuscarInformacionAplicacionesPorId(clsAplicaciones aplicaciones)
    {
        daoAplicaciones daoaplicaciones = new daoAplicaciones();
        return daoaplicaciones.consultaAplicacionesPorId(aplicaciones);
    }    
    public List<clsAplicaciones> getListadoAplicaciones()
    {
        daoAplicaciones daoaplicaciones = new daoAplicaciones();
        List<clsAplicaciones> listadoAplicaciones = daoaplicaciones.consultaAplicaciones();
        return listadoAplicaciones;
    }
    public int setBorrarAplicaciones(clsAplicaciones aplicaciones)
    {
        daoAplicaciones daoaplicaciones = new daoAplicaciones();
        return daoaplicaciones.borrarAplicaciones(aplicaciones);
    }          
    public int setIngresarAplicaciones(clsAplicaciones aplicaciones)
    {
        daoAplicaciones daoaplicaciones = new daoAplicaciones();
        return daoaplicaciones.ingresaAplicaciones(aplicaciones);
    }              
    public int setModificarAplicaciones(clsAplicaciones aplicaciones)
    {
        daoAplicaciones daoaplicaciones = new daoAplicaciones();
        return daoaplicaciones.actualizaAplicaciones(aplicaciones);
    }              
}

