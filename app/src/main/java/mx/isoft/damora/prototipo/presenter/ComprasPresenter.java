package mx.isoft.damora.prototipo.presenter;

import android.app.Activity;

import java.util.Date;

import mx.isoft.damora.prototipo.model.CompraDto;
import mx.isoft.damora.prototipo.utils.VariablesSesion;

/**
 * Created by Icom_JP on 2019-11-24.
 * Description:
 */
public class ComprasPresenter {
    private final Activity view;

    public ComprasPresenter(Activity view) {
        this.view = view;
    }

    /**
     * TODO: llenado temporal, debería llenarse desde base de datos
     */
    public void llenarLista(){
        CompraDto resultadoDto=new CompraDto();
        resultadoDto.setFecha(new Date());
        resultadoDto.setTipoCombustible("Magna");
        resultadoDto.setTurno("Mat");
        VariablesSesion.resultadoDtoList.add(resultadoDto);
        resultadoDto=new CompraDto();
        resultadoDto.setFecha(new Date());
        resultadoDto.setTipoCombustible("Premium");
        resultadoDto.setTurno("Vespertino");
        VariablesSesion.resultadoDtoList.add(resultadoDto);
        resultadoDto=new CompraDto();
        resultadoDto.setFecha(new Date());
        resultadoDto.setTipoCombustible("Premium");
        resultadoDto.setTurno("Nocturno");
        VariablesSesion.resultadoDtoList.add(resultadoDto);
    }
}
