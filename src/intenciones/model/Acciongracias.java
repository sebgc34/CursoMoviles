package intenciones.model;
// Generated 18/12/2018 11:00:59 AM by Hibernate Tools 4.3.1


import java.util.Date;

/**
 * Acciongracias generated by hbm2java
 */
public class Acciongracias  implements java.io.Serializable {


     private Integer id;
     private String accion;
     private String motivo;
     private Date fecha;
     private String misa;

    public Acciongracias() {
    }

    public Acciongracias(String accion, String motivo, Date fecha, String misa) {
       this.accion = accion;
       this.motivo = motivo;
       this.fecha = fecha;
       this.misa = misa;
    }
   
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    public String getAccion() {
        return this.accion;
    }
    
    public void setAccion(String accion) {
        this.accion = accion;
    }
    public String getMotivo() {
        return this.motivo;
    }
    
    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }
    public Date getFecha() {
        return this.fecha;
    }
    
    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
    public String getMisa() {
        return this.misa;
    }
    
    public void setMisa(String misa) {
        this.misa = misa;
    }




}


