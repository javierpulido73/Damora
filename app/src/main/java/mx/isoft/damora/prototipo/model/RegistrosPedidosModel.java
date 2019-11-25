package mx.isoft.damora.prototipo.model;

import java.util.List;

/**
 * Created by Icom_JP on 2019-11-24.
 * Description:
 */
public class RegistrosPedidosModel {
    private List<CompraDto> compraDtos;

    public RegistrosPedidosModel(List<CompraDto> compraDtos) {
        this.compraDtos = compraDtos;
    }

    public List<CompraDto> getCompraDtos() {
        return compraDtos;
    }

    public void setCompraDtos(List<CompraDto> compraDtos) {
        this.compraDtos = compraDtos;
    }

    @Override
    public String toString() {
        return "RegistrosPedidosModel{" +
                "compraDtos=" + compraDtos +
                '}';
    }
}
