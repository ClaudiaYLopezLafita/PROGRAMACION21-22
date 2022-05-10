package com.company.STAX.Ejemplos.Ejem03;

import javax.xml.stream.XMLEventFactory;
import javax.xml.stream.XMLEventWriter;
import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.*;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

public class Ejem03 {
    public static void main(String[] args) {

        Modulo m1 = new Modulo("LM", "Lenguaje de Marca", 4);
        Modulo m2 = new Modulo("PG", "Programacion", 8);
        Modulo m3 = new Modulo("BD", "Base de Datos", 6);
        Modulo m4 = new Modulo("SI", "Sistema Informaticos", 6);
        Modulo m5 = new Modulo("FOL", "Formacion y Orientacion Laboral", 3);
        Modulo m6 = new Modulo("ENDES", "Entorno de Desarrollo", 3);

        List<Modulo> modulosList = new ArrayList<>();

        modulosList.add(m1);
        modulosList.add(m2);
        modulosList.add(m3);
        modulosList.add(m4);
        modulosList.add(m5);
        modulosList.add(m6);

        XMLOutputFactory xmlOutputFactory = XMLOutputFactory.newInstance();
        try {
            XMLEventWriter writer = xmlOutputFactory.createXMLEventWriter(new
                    FileOutputStream("ciclos.xml"));

            XMLEventFactory event= XMLEventFactory.newInstance();

            // 1. Abrimos el documento para poder empezar a escribir
            StartDocument startDocument = event.createStartDocument();
            writer.add(startDocument);

            //2. Para que quede tabulado y con los saltos de estructura de un xml cremos
            // los saltos de linea y la tabulacion
            Characters saltoDeLinea = event.createCharacters("\n");
            Characters saltoDeLineaTab = event.createCharacters("\n\t");
            Characters tabulador = event.createCharacters("\t");
            writer.add(saltoDeLinea);

            //3.Creo el evento necesario para crear la etiqueta raíz pedidos
            StartElement ciclosEtiquetaRaiz = event.createStartElement("","","ciclos");
            writer.add(ciclosEtiquetaRaiz);
            writer.add(saltoDeLineaTab);

            int longitud =0;

            //4. vamos creados las etiquetas hijas recorriendo el array list de modulos
            for (Modulo m:modulosList) {
                //1.abrimos la etiquetas
                StartElement moduloStart = event.createStartElement("","","modulo");
                StartElement nombreStart = event.createStartElement("","","nombre");
                StartElement horaStart = event.createStartElement("","","horas");

                //2. Creo el atribudo cod
                Attribute cod = event.createAttribute("cod", m.getCódigo());

                //2. cerramos las etiquetas
                EndElement moduloEnd = event.createEndElement("","","modulo");
                EndElement nombreEnd = event.createEndElement("","","nombre");
                EndElement horasEnd = event.createEndElement("","","horas");

                //3. Se obtiene los contenidos de las etiquetas
                Characters nombre = event.createCharacters(m.getNombre());
                Characters horas  = event.createCharacters(Integer.toString(m.getHoras()));

                //4. Vamos añadiendo las etiquetas y los contenidos al writer en el orden "correcto"

                writer.add(moduloStart);

                // añadimos el atributo a la etiqueta
                writer.add(cod);

                //añadimos el sato de linea y la tabulacion
                writer.add(saltoDeLineaTab);
                writer.add(tabulador);

                // vamos añadiendo ordenadamente las etiquetas, contenido y salto de lienas para
                // estructurar correctamente le xml
                writer.add(nombreStart);
                writer.add(nombre);
                writer.add(nombreEnd);
                writer.add(saltoDeLineaTab);
                writer.add(tabulador);
            }

        } catch (XMLStreamException e) {

        } catch (FileNotFoundException e) {

        }
    }
}
