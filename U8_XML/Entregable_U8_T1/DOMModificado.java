package com.company.ENTREGABLE;

import org.w3c.dom.*;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;

public class DOMModificado {
    public static void main(String[] args) {

        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();

        try {
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document doc = db.parse(new File("entregableXML.xml"));

            Element root = doc.getDocumentElement();
            NodeList nl = doc.getElementsByTagName("alumno");

            //1. Añadimos una nueva etiqueca a cada alumno

            for (int i = 0; i < nl.getLength(); i++) {
                Element instituto = doc.createElement("instituto");
                instituto.setTextContent("IES ALIXAR");
                nl.item(i).appendChild(instituto);
            }

            //2. Añadimos un nievo alumno -- clone

            Element alumno = doc.createElement("alumno");
            alumno.setAttribute("dni","88888888X");

            Element nombre = doc.createElement("nombre");
            nombre.setTextContent("Luis");

            Element apellido = doc.createElement("apellido");
            apellido.setTextContent("Ruiz");

            Element direccion = doc.createElement("direccion");
            direccion.setTextContent("Allí");

            Element instituto = doc.createElement("instituto");
            instituto.setTextContent("IES ALIXAR");

            Text saltoLinea = doc.createTextNode("\n");
            alumno.appendChild(saltoLinea);
            alumno.appendChild(nombre);
            alumno.appendChild(saltoLinea);
            alumno.appendChild(apellido);
            alumno.appendChild(saltoLinea);
            alumno.appendChild(direccion);
            alumno.appendChild(saltoLinea);
            alumno.appendChild(instituto);
            alumno.appendChild(saltoLinea);

            root.appendChild(alumno);

            TransformerFactory tf = TransformerFactory.newInstance();
            Transformer transformer = tf.newTransformer();

            transformer.setOutputProperty( OutputKeys.INDENT, "yes" );
            transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");
            transformer.setOutputProperty( OutputKeys.OMIT_XML_DECLARATION, "no" );
            transformer.setOutputProperty( OutputKeys.METHOD, "xml" );
            transformer.setOutputProperty("http://www.oracle.com/xml/is-standalone", "yes");

            DOMSource origenDOM = new DOMSource(root);

            File nuevoPersonas = new File("alumnos_modificado.xml");
            StreamResult destino = new StreamResult(nuevoPersonas);

            transformer.transform(origenDOM,destino);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }


        /*
         Element perro = doc.createElement("Perro");
            perro.setAttribute("Id","5");

            Element nombre = doc.createElement("Nombre");
            nombre.setTextContent("Chapi");

            Element raza = doc.createElement("Raza");
            raza.setTextContent("GOlden");

            Element edad = doc.createElement("Edad");
            edad.setTextContent("10");
         */
    }
}
