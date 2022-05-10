package com.company.DOM.Actividades.Entregable_1;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class RecorridoDOM {

    public static void numNodosHijos(){
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        String s="";
        try {
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document doc = db.parse(new File("perrosXML.xml"));

            // Obtener el elemento raiz
            Element root = doc.getDocumentElement();

            // hijo NODO
            System.out.println("Nodos hijos del documento: "
                    +doc.getChildNodes().getLength());

            // HIJOS DEL NODO
            System.out.println("Nodos hijos del elemento raíz:"+root.getChildNodes().getLength()+"!!!!!");

            // OBTENEMOS LA LISTA CON LOS NODOS
            NodeList nl = root.getChildNodes();

            System.out.println("Información de los Nodos");

            for (int i = 0; i < nl.getLength() ; i++) {
                System.out.println("Tipo del Nodo:"+nl.item(i).getNodeType());
                System.out.println("-------------------------------------------------");
            }

        }  catch (Exception e) {

        }
    }

    public static void mostrarXMLDom(){
        try {

            //Cargo el Fichero XML en Memoria
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document doc = db.parse(new File("perrosXML.xml"));

            //Cojo directamente las etiquetas persona
            NodeList nl = doc.getElementsByTagName("Perro");

            System.out.println("En este fichero tengo "+nl.getLength()+" etiquetas Perro");


            //Voy a tratar cada una de estas etiquetas persona
            for (int i = 0; i < nl.getLength() ; i++) {
                Node nodo = nl.item(i);
                Element e = (Element) nl.item(i);
                System.out.println("Estoy en una etiqueta: "+e.getTagName());

                if (nodo.getNodeType() == Node.ELEMENT_NODE) {

                    if (nodo.hasChildNodes()) {

                        System.out.println("Y esta etiqueta tiene a su vez "+nodo.getChildNodes().getLength()+" nodos hijos");

                        NodeList listaInterior = nodo.getChildNodes();

                        for (int j = 0; j < listaInterior.getLength(); j++) {

                            if  (listaInterior.item(j).getNodeType() == Node.ELEMENT_NODE) {
                                Element eHijo = (Element) listaInterior.item(j);
                                System.out.println("Uno de los nodos hijos es la etiqueta "+eHijo.getTagName());
                                System.out.println("Cuyo contenido es: "+eHijo.getTextContent());
                            }
                        }
                    }
                }
            }

        } catch (ParserConfigurationException | SAXException | IOException e) {
            System.out.println(e.getStackTrace());
        }
    }

    public static void mostrarContenidoEtiqueta(String etiqueta){

        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();

        try {
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document doc = db.parse(new File("perrosXML.xml"));

            // obtenemos las lista de todos los nodos del documento.
            NodeList nl = doc.getDocumentElement().getChildNodes();
            int contador=0;

            System.out.println("Contenido de la etiqueta "+etiqueta+": ");
            for (int i = 0; i < nl.getLength(); i++) {
                if (nl.item(i).getNodeType()== Node.ELEMENT_NODE){
                    // nueva lista de nodos que son de tipo etiqueta
                    NodeList ml2 = nl.item(i).getChildNodes();
                    for (int j = 0; j < ml2.getLength(); j++) {
                        if (ml2.item(j).getNodeType()==Node.ELEMENT_NODE){
                            Element nieto = (Element) ml2.item(j);
                            if (nieto.getTagName().equals(etiqueta)) {
                                contador++;
                                System.out.println(nieto.getTextContent());
                            }
                        }
                    }
                }
            }

            if (contador==0){
                System.out.println("No hay ocurrencias de esta etiqueta");
            }
        } catch (Exception e) {

        }

    }

}
