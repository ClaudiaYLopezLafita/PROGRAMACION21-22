package com.company.DOM.Ejemplos.Ejem08;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Ejem08 {
    public static void main(String[] args) {

        List<Persona> list = new ArrayList<>();

        list.add(new Persona(1,"Claudia",28));
        list.add(new Persona(2,"Andrea",20));
        list.add(new Persona(3,"Manuel",32));
        list.add(new Persona(4,"Carlos",28));

        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder db = null;

        try {
            db = dbf.newDocumentBuilder();

            //No parseo ningún fichero XML existente, creamos uno nuevo
            Document doc = db.newDocument();

            //Creo el elemento raíz ya que está vacío
            Element root = doc.createElement("personas");

            for (Persona p: list) {
                Element persona = doc.createElement("persona");
                Element nombre = doc.createElement("nombre");
                Element edad = doc.createElement("edad");

                persona.setAttribute("id", Integer.toString(p.getId()));

                nombre.setTextContent(p.getNombre());
                edad.setTextContent(String.valueOf(p.getEdad()));

                persona.appendChild(nombre);
                persona.appendChild(edad);
                root.appendChild(persona);
            }

            // PROCEDEMOS A VOLCAR TODAS LAS MODIFICACIONES, TODO ÉL ARBOL AL FICHERO

            //Obtenemos el objeto transformer
            TransformerFactory tf = TransformerFactory.newInstance();
            Transformer transformer = tf.newTransformer();

            //Configuración del transformer
            //Podéis ver toda la lista de propiedes aquí
            // https://docs.oracle.com/javase/7/docs/api/javax/xml/transform/OutputKeys.html
            transformer.setOutputProperty( OutputKeys.INDENT, "yes" );
            transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");
            transformer.setOutputProperty( OutputKeys.OMIT_XML_DECLARATION, "no" );
            transformer.setOutputProperty( OutputKeys.METHOD, "xml" );
            transformer.setOutputProperty("http://www.oracle.com/xml/is-standalone", "yes");

            //Creación del origen DOMSource
            DOMSource origenDOM = new DOMSource(root);

            //Creación del fichero que va a ser mi destino
            File nuevoPersonas = new File("pruebaPersonaXML.xml");
            StreamResult destino = new StreamResult(nuevoPersonas);

            //Hacemos la transformación que en nuestro caso es la escritura
            transformer.transform(origenDOM,destino);


        } catch (ParserConfigurationException e) {

        } catch (TransformerConfigurationException e) {

        } catch (TransformerException e) {

        }
    }
}
