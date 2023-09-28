package modelo;

import java.util.Date;

public class Servico {
    private String tipoServico;
    private Date dataMarcada;

    public Servico(String tipoServico, Date dataMarcada) {
        this.tipoServico = tipoServico;
        this.dataMarcada = dataMarcada;
    }

    public String getTipoServico() {
        return tipoServico;
    }

    public void setTipoServico(String tipoServico) {
        this.tipoServico = tipoServico;
    }

    public Date getDataMarcada() {
        return dataMarcada;
    }

    public void setDataMarcada(Date dataMarcada) {
        this.dataMarcada = dataMarcada;
    }
}
