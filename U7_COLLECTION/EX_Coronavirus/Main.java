package com.company.EX_Coronavirus;

import java.util.Collections;

public class Main {
    public static void main(String[] args) {

        Medico m1 = new Medico("Manuel", "Gomez Angulo",14785,"H.V.Macarena");
        Medico m2 = new Medico("Beatriz", "Lopez Hermoso",98765,"H.V.del Rocio");
        Medico m4 = new Medico("Rafael", "Lopez-Palanco",159632,"H.V.Valme");
        Medico m5 = new Medico("Teresa", "Lafita Gordillo",74123,"H.Cruz Roja");

        Paciente p1 = new Paciente("Daniel",23, 75.2, true, m5, "CD-19");
        Paciente p2 = new Paciente("Carla",56, 89.2, false, m5, "CD-omicron");
        Paciente p3 = new Paciente("Sara",68, 56.2, true, m2, "CD-19");
        Paciente p4 = new Paciente("Pepa",65, 45.2, true, m2, "CD-omega");
        Paciente p5 = new Paciente("Manuel",12, 99.2, false, m1, "CD-19");
        Paciente p6 = new Paciente("Claudia",65, 102.2, true, m4, "CD-omicron");
        Paciente p7 = new Paciente("Andrea",89, 75.2, false, m5, "CD-19");
        Paciente p8 = new Paciente("JK",26,58.3, false, m5, "CD-omega");

        Coronavirus cv = new Coronavirus();

//        cv.addPaciente("CD-19", p1);
//        cv.addPaciente("CD-19", p3);
//        cv.addPaciente("CD-19", p5);
//        cv.addPaciente("CD-19", p7);
//        cv.addPaciente("CD-omicron", p2);
//        cv.addPaciente("CD-omicron", p6);
//        cv.addPaciente("CD-omega", p4);

        cv.cargarPacientes();

        cv.addPaciente("CD-omega",p8);

        cv.pacientesPorEdad("CD-19");

        cv.darDeAltaPaciente(p7);
        cv.pacientesPorPeso("CD-omega");

        cv.pacientesDeUnDoctor(98765);

        cv.guardarPacientes();
    }
}
