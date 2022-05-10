package com.company.DOM.Actividades.Entregable_1;

import com.company.DOM.Ejemplos.Ejem08.Persona;
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

public class Main {
    public static void main(String[] args) {

        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();

        // Los perros llevan un identificador que corresponderá con un atributo
        //Construimos los cinco perros que formaran parte de nuestro XML
        Perro p1 = new Perro("Toby", "Cahiche", 12);
        Perro p2 = new Perro("Pochi", "Pastor Aleman", 3);
        Perro p3 = new Perro("Kody", "Bulldog", 9);
        Perro p4 = new Perro("Procopio", "Boxer", 6);
        Perro p5 = new Perro("Pancho", "Chihuahua", 2);

        // Creamos un ArrayListt para los perros y que no servirá como bucle para crear el XML
        List<Perro> perroList = new ArrayList<>();

        perroList.add(p1);
        perroList.add(p2);
        perroList.add(p3);
        perroList.add(p4);
        perroList.add(p5);

        try {
            DocumentBuilder db = dbf.newDocumentBuilder();

            // creamos el docuemnto XML - no le pasamos nada porque es desde cero
            Document doc = db.newDocument();

            // Creamos el NODO RAIZ y lo colgamos del documento
            Element root = doc.createElement("Perros");
            doc.appendChild(root);

            //BUCLE PARA QUE LO HAGA CON CADA PERRO
            for (Perro p:perroList) {

                // etiqueta perro (hija del nodo raiz)
                Element perroTag = doc.createElement("Perro");
                //añadimos el atributo a la etiquete hija Nv1
                perroTag.setAttribute("Id",Integer.toString(p.getId()));

                //Creamos la etiqueta nombre y rellenamo contenido
                Element nombre = doc.createElement("Nombre");
                nombre.setTextContent(p.getNombre());
                //Creamos la etiqueta raza y rellenamo contenido
                Element raza = doc.createElement("Raza");
                raza.setTextContent(p.getRaza());
                //Creamos la etiqueta edad y rellenamo contenido
                Element edad = doc.createElement("Edad");
                edad.setTextContent(Integer.toString(p.getEdad()));

                // añadimos las etiquetas nietas a la etiqueta hija "Perro"
                perroTag.appendChild(nombre);
                perroTag.appendChild(raza);
                perroTag.appendChild(edad);

                // Añadimos las etiqetas
                root.appendChild(perroTag);
            }


            // PROCEDEMOS A VOLCAR TODAS LAS MODIFICACIONES, TODO ÉL ARBOL AL FICHERO

            //Obtenemos el objeto transformer
            TransformerFactory tf = TransformerFactory.newInstance();
            Transformer transformer = tf.newTransformer();

            //Configuración del transformer
            //Podéis ver toda la lista de propiedes aquí
            // https://docs.oracle.com/javase/7/docs/api/javax/xml/transform/OutputKeys.html
            transformer.setOutputProperty(OutputKeys.INDENT, "yes" );
            transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");
            transformer.setOutputProperty( OutputKeys.OMIT_XML_DECLARATION, "no" );
            transformer.setOutputProperty( OutputKeys.METHOD, "xml" );
            transformer.setOutputProperty("http://www.oracle.com/xml/is-standalone", "yes");

            //Creación del origen DOMSource
            DOMSource origenDOM = new DOMSource(root);

            //Creación del fichero que va a ser mi destino
            File nuevoPersonas = new File("perrosXML.xml");
            StreamResult destino = new StreamResult(nuevoPersonas);

            //Hacemos la transformación que en nuestro caso es la escritura
            transformer.transform(origenDOM,destino);

        } catch (ParserConfigurationException e) {
            throw new RuntimeException(e);
        } catch (TransformerConfigurationException e) {
            throw new RuntimeException(e);
        } catch (TransformerException e) {
            throw new RuntimeException(e);
        }


    }
}
