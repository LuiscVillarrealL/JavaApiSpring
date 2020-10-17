package com.pruebatecnica.app.excepciones;

import java.util.Date;



public class DetallesDeErrores {
    private Date fecha;
    private String mensaje;
    private String detalles;

    public DetallesDeErrores(Date fecha, String mensaje, String detalles) {
        super();
        this.fecha = fecha;
        this.mensaje = mensaje;
        this.detalles = detalles;
    }

    public Date getfecha() {
        return fecha;
    }

    public String getmensaje() {
        return mensaje;
   }

    public String getdetalles() {
       return detalles;
   }
}