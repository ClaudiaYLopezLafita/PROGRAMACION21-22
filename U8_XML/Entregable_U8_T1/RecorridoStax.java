package com.company.ENTREGABLE;

import javax.sound.midi.Soundbank;
import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.Characters;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class RecorridoStax {
    public static void main(String[] args) {
        XMLEventReader reader=null;
        Scanner sc = new Scanner(System.in);

        try {
            XMLInputFactory xmlInputFactory = XMLInputFactory.newInstance();
            reader = xmlInputFactory.createXMLEventReader(new FileInputStream("entregableXML.xml"));

            int numAlumnos=0;
            int alumnosDirec=0;
            String tagActual="";

            System.out.println("Indica una dirección");
            String direccion = sc.nextLine();

            while (reader.hasNext()){
                XMLEvent event = reader.nextEvent();

                if (event.isStartElement()){

                    StartElement start = event.asStartElement();
                    tagActual=start.getName().getLocalPart();

                    if (tagActual.equals("alumno")){
                        numAlumnos++;
                    }
                } else if (event.isCharacters()){
                    Characters contenido = event.asCharacters();

                    if (tagActual.equals("direccion")){
                        if (contenido.getData().equals(direccion)){
                            alumnosDirec++;
                        }
                    }
                }
            }

            System.out.println("La cantidad de alumnos con la direccion ["+direccion+"] son: "+alumnosDirec);
            System.out.println("La cantidad de alumnos del archivo XML es: "+numAlumnos);

        } catch (XMLStreamException e) {
            throw new RuntimeException(e);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
