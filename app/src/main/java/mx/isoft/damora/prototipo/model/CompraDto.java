package mx.isoft.damora.prototipo.model;

import java.util.Date;

/**
 * Created by Icom_JP on 2019-11-21.
 * Description:
 */
public class CompraDto {
    private Date fecha;
    private String tipoCombustible;
    private String turno;

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getTipoCombustible() {
        return tipoCombustible;
    }

    public void setTipoCombustible(String tipoCombustible) {
        this.tipoCombustible = tipoCombustible;
    }

    public String getTurno() {
        return turno;
    }

    public void setTurno(String turno) {
        this.turno = turno;
    }

    @Override
    public String toString() {
        return "CompraDto{" +
                "fecha='" + fecha + '\'' +
                ", tipoCombustible='" + tipoCombustible + '\'' +
                ", turno='" + turno + '\'' +
                '}';
    }
}
