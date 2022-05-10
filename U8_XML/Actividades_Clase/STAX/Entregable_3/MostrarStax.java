package com.company.STAX.Entregable_3;

import javax.xml.namespace.QName;
import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;

public class MostrarStax {
    public static void main(String[] args) {
        ArrayList<Perro2> perro2s = new ArrayList<>();
        Perro2 perroActual = null;
        String tagActual="";

        //Obtenemos el lector de XML
        XMLInputFactory xmlInputFactory = XMLInputFactory.newInstance();
        try {
            XMLEventReader xmlReader = xmlInputFactory.createXMLEventReader(new FileInputStream("perrosXML.xml"));

            //Recorro la lista de eventos. Soy yo el que los va obteniendo PULL con nextEvent()
            while (xmlReader.hasNext()){
                XMLEvent xmlEvent = xmlReader.nextEvent();

                //Si es un evento de apertura de etiqueta
                if (xmlEvent.isStartElement()) {

                    //Obtengo la información de la etiqueta
                    StartElement startTag = xmlEvent.asStartElement();

                    //Inicio la apertura de la etiqueta pero no lo cierro por si tiene atributos
                    System.out.print("<"+ startTag.getName().getLocalPart());

                    //Dependiendo de el nombre la etiqueta
                    //Establezco tagActual al nombre de la etiqueta que he detectado
                    String tagName = startTag.getName().getLocalPart();
                    switch (tagName) {
                        case "Perro" :

                            //Empieza un pedido tengo que crear el objeto para añadirlo
                            //posteriormente al ArrayList
                            perroActual = new Perro2();
                            tagActual = "Perro";

                            //Es la única etiqueta que tiene atributos
                            //Si tuviera varios
                            //Iterator it = startTag.getAttributes();
                            //Tendría que recorrerlo como hemos hecho hasta ahora
                            Attribute id = startTag.getAttributeByName(new QName("Id"));

                            perroActual.setId(Integer.valueOf(id.getValue()));

                            System.out.print(" "+id.getName()+"=\""+id.getValue()+"\"");
                            break;

                        case "Nombre" :
                            //Establezco cuál es la etiqueta que estoy tratando
                            tagActual = "Nombre";
                            break;

                        case "Raza" :
                            //Establezco cuál es la etiqueta que estoy tratando
                            tagActual = "Raza";
                            break;

                        case "Edad" :
                            //Establezco cuál es la etiqueta que estoy tratando
                            tagActual = "Edad";
                            break;
                    }

                    //Cierro la etiqueta de apertura
                    System.out.print(">");

                } else if (xmlEvent.isEndElement()) {

                    //Si he recibido el evento de fin de una etiqueta
                    //Muestro la etiqueta de cierre
                    EndElement endtag = xmlEvent.asEndElement();
                    System.out.println("<\\" + endtag.getName().getLocalPart()+">");

                    //Si estoy cerrando pedido ya tengo el pedido relleno lo añado a la lista
                    if (endtag.getName().getLocalPart().equals("Perro")) {
                        perro2s.add(perroActual);
                    }

                    //Ya no estoy dentro de ninguna de las etiquetas
                    tagActual = "";

                } else if (xmlEvent.isStartDocument()) {
                    System.out.println("Comienzo del parseado del documento");

                } else if (xmlEvent.isEndDocument()) {
                    System.out.println("Fin del parseado del documento");

                } else if (xmlEvent.isCharacters()) {

                    //Estoy en un nodo de texto
                    Characters texto = xmlEvent.asCharacters();

                    //No es un salto de línea Estoy suponiendo que el texto de las etiquetas nodo no lleva un salto
                    // de línea
                    if (!texto.getData().contains("\n")) {
                        System.out.print(texto.getData());
                    }

                    //Añado el texto de dentro de las etiquetas al objeto que estoy creando (perroActual)
                    if (!tagActual.equals("")) {
                        switch (tagActual) {
                            case "Nombre" :
                                perroActual.setNombre(texto.getData());
                                break;
                            case "Raza" :
                                perroActual.setRaza(texto.getData());
                                break;
                            case "Edad" :
                                perroActual.setEdad(Integer.valueOf(texto.getData()));
                                break;
                        }
                    }
                }

            }

            } catch (XMLStreamException ex) {
            throw new RuntimeException(ex);
        } catch (FileNotFoundException ex) {
            throw new RuntimeException(ex);
        }

        System.out.println(perro2s);
    }
}
