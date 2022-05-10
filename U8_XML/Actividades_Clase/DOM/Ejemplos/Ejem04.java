package com.company.DOM.Ejemplos;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;

/*
Obtener por pantalla los comentarios que nos encontremos en el xml
 */
public class Ejem04 {
    public static void main(String[] args) {
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        String s="";
        try {
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document doc = db.parse(new File("alumnos.xml"));

            // Obtener el elemento raiz
            Element root = doc.getDocumentElement();
            NodeList nlEdad = doc.getElementsByTagName("Edad");
            NodeList nl2 = root.getChildNodes();

            // hijos
            System.out.println("Nodos hijos del documento: "
                    +doc.getChildNodes().getLength());
            System.out.println("Nodos del nodo raiz del documento: "
                    +root.getChildNodes().getLength());

            System.out.println("Comentario: ");
            for (int i = 0; i < nl2.getLength() ; i++) {
                if (root.getChildNodes().item(i).getNodeType()== Node.COMMENT_NODE){
                    System.out.println(root.getChildNodes().item(i));
                }
            }

        }  catch (Exception e) {

        }
    }
}
