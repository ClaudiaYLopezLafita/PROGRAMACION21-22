package com.company.T3_JuegosDeportivos;

public class Judo extends Deporte{
    private Integer numTatamis;

    public Judo(String nombre, String nomPabellon, Integer numTatamis) {
        super(nombre, nomPabellon);
        this.numTatamis=numTatamis;
    }

    public Integer getNumTatamis() {
        return numTatamis;
    }

    public void setNumTatamis(Integer numTatamis) {
        this.numTatamis = numTatamis;
    }

    @Override
    public boolean addParticipante(Participante participante) {
        if (participante instanceof Judoka) {
            return super.addParticipante(participante);
        }
        return false;
    }

    @Override
    public String toString() {
        return super.toString() +
                "numTatamis=" + numTatamis +
                '}';
    }
}
