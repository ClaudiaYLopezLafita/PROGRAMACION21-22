package com.company.STAX.Ejemplos;

import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.Characters;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

/*
Solicitar por pantalla el nombre de un producto e indicar en cuantos pedidos está.
OJO CON LOS SALTOS DE LINEA.
 */
public class Ejem02 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Indica el nombre de producto de interes: ");
        String nameProduct = sc.nextLine();

        XMLEventReader reader=null;

        try {

            XMLInputFactory xmlInputFactory = XMLInputFactory.newInstance();
            reader = xmlInputFactory.createXMLEventReader(new FileInputStream("pedidos.xml"));
            Integer cantidad =0;
            String tagActual="";

            while (reader.hasNext()){

                XMLEvent xmlEvent = reader.nextEvent();

                if (xmlEvent.isStartElement()){

                    StartElement start = xmlEvent.asStartElement();
                    tagActual=start.getName().getLocalPart(); // con cada aprtura le indicuamos cual es

                }else if (xmlEvent.isCharacters()){
                    Characters contenido = xmlEvent.asCharacters();

                    if (tagActual.equals("nombreProducto") && !contenido.getData().contains("\n")){
                        if (contenido.getData().equals(nameProduct)) {
                            cantidad++;
                        }
                    }
                }
            }
            System.out.println("El producto "+nameProduct+" está en "+cantidad+" pedidos.");

        } catch (XMLStreamException e) {
            e.getMessage();
        } catch (FileNotFoundException e) {

        }

    }
}
