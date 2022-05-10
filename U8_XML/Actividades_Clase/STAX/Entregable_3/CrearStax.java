package com.company.STAX.Entregable_3;

import com.company.DOM.Actividades.Entregable_1.Perro;

import javax.xml.stream.XMLEventFactory;
import javax.xml.stream.XMLEventWriter;
import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.*;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

public class CrearStax {
    public static void main(String[] args) {
        Perro2 p1 = new Perro2("Toby", "Cahiche", 12);
        Perro2 p2 = new Perro2("Pochi", "Pastor Aleman", 3);
        Perro2 p3 = new Perro2("Kody", "Bulldog", 9);
        Perro2 p4 = new Perro2("Procopio", "Boxer", 6);
        Perro2 p5 = new Perro2("Pancho", "Chihuahua", 2);

        // Creamos un ArrayListt para los perros y que no servirá como bucle para crear el XML
        List<Perro2> perroList = new ArrayList<>();

        perroList.add(p1);
        perroList.add(p2);
        perroList.add(p3);
        perroList.add(p4);
        perroList.add(p5);

        //Creo el objeto que me va a servir para escribir
        XMLOutputFactory xmlOutputFactory = XMLOutputFactory.newInstance();
        XMLEventWriter xmlWriter = null;
        try {
            xmlWriter = xmlOutputFactory.createXMLEventWriter(new FileOutputStream("perros_nuevos.xml"));
            //Creo el objeto que me va a servir para crear los eventos
            XMLEventFactory eventFactory = XMLEventFactory.newInstance();

            //Creo el evento de principio de documento y lo escribo con el objeto escritor
            StartDocument startDocument = eventFactory.createStartDocument();
            xmlWriter.add(startDocument);

            //Creo el evento para introducir el salto de línea y el de salto de línea con tabulador
            //Los usaré para maquetar el fichero correctamente (aunque no son estrictamente necesarios)
            Characters saltoDeLinea = eventFactory.createCharacters("\n");
            Characters saltoDeLineaTab = eventFactory.createCharacters("\n\t");
            Characters tabulador = eventFactory.createCharacters("\t");
            xmlWriter.add(saltoDeLinea);

            //Creo el evento necesario para crear la etiqueta raíz pedidos
            StartElement perrosStartElement = eventFactory.createStartElement("","","Perros");
            xmlWriter.add(perrosStartElement);
            xmlWriter.add(saltoDeLineaTab);

            int longitud = 0; // controlar si es el último de los pedidos ya que querré diferente salida

            for (Perro2 p:perroList) {
                //Creo todas las etiquetas de apertura  que va a tener cada uno de los pedidos
                StartElement perroStart = eventFactory.createStartElement("","","Perro");
                StartElement nombreStart = eventFactory.createStartElement("","","Nombre");
                StartElement razaStart = eventFactory.createStartElement("","","Raza");
                StartElement edadStart = eventFactory.createStartElement("","","Edad");

                Attribute id = eventFactory.createAttribute("Id",Integer.toString(p.getId()));

                //Creo todas las etiquetas de cierre que va a tener cada uno de los pedidos
                EndElement perroEnd = eventFactory.createEndElement("","","Perro");
                EndElement nombreEnd = eventFactory.createEndElement("","","Nombre");
                EndElement razaEnd = eventFactory.createEndElement("","","Raza");
                EndElement edadEnd = eventFactory.createEndElement("","","Edad");

                //Creo los contenidos
                Characters nombre = eventFactory.createCharacters(p.getNombre());
                Characters raza  = eventFactory.createCharacters(p.getRaza());
                Characters edad = eventFactory.createCharacters(Double.toString(p.getEdad()));

                // Añado los elemetos uno a uno ordenadamente

                xmlWriter.add(perroStart);
                xmlWriter.add(id);

                xmlWriter.add(saltoDeLineaTab);

                xmlWriter.add(nombreStart);
                xmlWriter.add(nombre);
                xmlWriter.add(nombreEnd);
                xmlWriter.add(saltoDeLineaTab);

                xmlWriter.add(razaStart);
                xmlWriter.add(raza);
                xmlWriter.add(razaEnd);
                xmlWriter.add(saltoDeLineaTab);

                xmlWriter.add(edadStart);
                xmlWriter.add(edad);
                xmlWriter.add(edadEnd);
                xmlWriter.add(saltoDeLineaTab);

                xmlWriter.add(perroEnd);

                if (longitud == perroList.size() - 1) {
                    xmlWriter.add(saltoDeLinea);
                } else {
                    xmlWriter.add(saltoDeLineaTab);
                }
                longitud++;

            }

            //Creo el evento necesario para cerrar la etiqueta raíz pedidos
            EndElement pedidosEndElement = eventFactory.createEndElement("","","pedidos");
            xmlWriter.add(pedidosEndElement);
            xmlWriter.add(saltoDeLinea);



            //Creo el evento de finalización del documento y lo escribo con el objeto escritor
            EndDocument endDocument = eventFactory.createEndDocument();
            xmlWriter.add(endDocument);

        } catch (XMLStreamException e) {
            throw new RuntimeException(e);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }



    }
}
