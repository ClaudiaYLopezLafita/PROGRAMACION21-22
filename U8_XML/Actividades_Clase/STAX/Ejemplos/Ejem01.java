package com.company.STAX.Ejemplos;

import javax.sql.rowset.spi.XmlReader;
import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.Characters;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

/*
Realizar un programa que nos indique la suma total de todos los pedidos.
 */
public class Ejem01 {
    public static void main(String[] args) {

        XMLEventReader reader=null;

        try {

            XMLInputFactory xmlInputFactory = XMLInputFactory.newInstance();
            reader = xmlInputFactory.createXMLEventReader(new FileInputStream("pedidos.xml"));

            double total = 0;
            int precioActual=0;
            int cantidadActual=0;
            String tagActual="";

            while (reader.hasNext()){

                XMLEvent xmlEvent = reader.nextEvent();

                if (xmlEvent.isStartElement()){

                    StartElement start = xmlEvent.asStartElement();
                    tagActual=start.getName().getLocalPart(); // con cada aprtura le indicuamos cual es

                }else if (xmlEvent.isCharacters()){
                    Characters contenido = xmlEvent.asCharacters();

                    if (tagActual.equals("precio") && !contenido.getData().contains("\n")){

                        precioActual = Integer.parseInt(contenido.getData());

                    } else if (tagActual.equals("cantidad") && !contenido.getData().contains("\n")) {

                        cantidadActual=Integer.parseInt(contenido.getData());
                        total+=(precioActual*cantidadActual);
                        tagActual="";
                    }
                }
            }
            System.out.println("La suma total de los pedidos es: "+total+"€");

        } catch (XMLStreamException e) {
            e.getMessage();
        } catch (FileNotFoundException e) {

        }

    }
}
