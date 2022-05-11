package com.company.ENTREGABLE.EJer01;

import org.w3c.dom.*;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Ejercicio1 {
    public static void main(String[] args) {

        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        List<Alumno> alumnoList = new ArrayList<>();

        try {
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document doc = db.parse(new File("entregableXML.xml"));

            Element root = doc.getDocumentElement();
            NodeList nl = doc.getElementsByTagName("alumno");

            for (int i = 0; i < nl.getLength(); i++) {
                Alumno a = new Alumno();

                Element e = (Element) nl.item(i);
                if (e.hasAttributes()) {

                    NamedNodeMap nodeMap = e.getAttributes();

                    for (int j = 0; j < nodeMap.getLength(); j++) {
                        Node node = nodeMap.item(j);
                        Attr atributo = e.getAttributeNode(node.getNodeName());
                        a.setDni(atributo.getValue());
                    }
                }

                NodeList nl2 = nl.item(i).getChildNodes();

                for (int j = 0; j < nl2.getLength(); j++) {
                    if (nl2.item(j).getNodeType() == Node.ELEMENT_NODE) {
                        if (nl2.item(j).getNodeName().equals("nombre")) {
                            a.setNombre(nl2.item(j).getTextContent());
                        } else if (nl2.item(j).getNodeName().equals("apellido")) {
                            a.setApellido(nl2.item(j).getTextContent());
                        } else if (nl2.item(j).getNodeName().equals("direccion")) {
                            a.setDireccion(nl2.item(j).getTextContent());
                        }
                    }
                }

                alumnoList.add(a);
            }
            Collections.sort(alumnoList);
            System.out.println(alumnoList);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}