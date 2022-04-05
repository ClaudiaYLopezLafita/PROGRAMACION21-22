package com.company.FicherosBinarios.Complementarios.Ejer09.Maquinaria;

import com.company.FicherosBinarios.Complementarios.Ejer08.Cliente;
import com.company.FicherosBinarios.Complementarios.Ejer09.Personal.Especialidad;
import com.company.FicherosBinarios.Complementarios.Ejer09.Personal.Mecanico;

import java.util.Arrays;
import java.util.Scanner;

public class GestionVagones {

    Vagone[] vagones;

    public GestionVagones() {
        this.vagones = new Vagone[0];
    }

    public Vagone[] getVagones() {
        return vagones;
    }

    public void setVagones(Vagone[] vagones) {
        this.vagones = vagones;
    }


}
