package com.company.DOM.Ejemplos.Ejem07;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

/*
Leer el fichero y crear una ArrayList con toda la informacion de la persona:
id, dni, nombre, edad.
 */
public class Ejem07 {
    public static void main(String[] args) {
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        List<Persona> personas=new ArrayList<>();
        try {
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document doc = db.parse(new File("persona.xml"));

            NodeList nl = doc.getElementsByTagName("persona");

            for (int i = 0; i < nl.getLength(); i++) {
                int id=0, edad=0;
                String nombre="", dni="";

                NodeList nl2 = nl.item(i).getChildNodes();
                for (int j = 0; j < nl2.getLength(); j++) {
                    if (nl2.item(j).getNodeType()==Node.ELEMENT_NODE){
                        Element tag = (Element) nl2.item(j);
                        if (tag.getTagName().equals("nombre")){
                            nombre = tag.getTextContent();
                        }else {
                            edad = Integer.parseInt(tag.getTextContent());
                        }
                    }
                }
                personas.add(new Persona(edad,id,dni,nombre));
            }

            System.out.println(personas);
        } catch (Exception e) {

        }
    }
}
