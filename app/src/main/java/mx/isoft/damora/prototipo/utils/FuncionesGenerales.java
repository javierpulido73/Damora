package mx.isoft.damora.prototipo.utils;

import android.text.format.DateFormat;

import java.util.Date;

/**
 * Created by Icom_JP on 2019-11-24.
 * Description:
 */
public class FuncionesGenerales {

    /**
     * Función encargada de formatear un Date al formato DD/MM/YYYY
     * @param date
     * @return
     */
    public static String formatearFecha(final Date date){
        return DateFormat.format("dd/MM/yyy", date).toString();
    }
}
