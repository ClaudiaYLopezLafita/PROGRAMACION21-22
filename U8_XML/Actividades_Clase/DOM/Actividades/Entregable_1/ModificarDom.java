package com.company.DOM.Actividades.Entregable_1;

import org.w3c.dom.*;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;

public class ModificarDom {
    public static void main(String[] args) {
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        try {
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document doc = db.parse(new File("perrosXML.xml"));
            Node root = doc.getDocumentElement();

    // 1. Añadir un comentario antes de cada hijo etiqueta Perro -- insertBefore
            Comment comentario = doc.createComment("COMENTARIO AÑADIDO DESDE DOM");

            for (int i = 0; i < doc.getElementsByTagName("Perro").getLength(); i++) {
                Element perroTag= (Element) doc.getElementsByTagName("Perro").item(i);
                root.insertBefore(comentario,perroTag);
            }
            /*
            OJO SOLO APARECE EN LA ULTIMA ETIQUETA PERRO
             */

    /*2. Añadir un nueva etiqueta hija (nueva perro) como último hijo. -- appendChild
            1. Creamos las etiquetas
            2. Rellenamos las etiquetas
             */
            Element perro = doc.createElement("Perro");
            perro.setAttribute("Id","5");

            Element nombre = doc.createElement("Nombre");
            nombre.setTextContent("Chapi");

            Element raza = doc.createElement("Raza");
            raza.setTextContent("GOlden");

            Element edad = doc.createElement("Edad");
            edad.setTextContent("10");

            /*Unimos las etiquetas al arbol*/
            Text saltoLinea = doc.createTextNode("\n");
            perro.appendChild(saltoLinea);
            perro.appendChild(nombre);
            perro.appendChild(saltoLinea);
            perro.appendChild(raza);
            perro.appendChild(saltoLinea);
            perro.appendChild(edad);
            perro.appendChild(saltoLinea);

            root.appendChild(perro);

    // 3. Crear un nuevo nodo etiqueta (nueva perro) -- mediante clonacion
    //y reemplazar la primera etiqueta hija por ese nodo creado.

            NodeList nl = doc.getElementsByTagName("Perro");
            Node node = nl.item(nl.getLength()-1);
            Element clon = (Element) node.cloneNode(true);

            clon.setAttribute("Id","6");

            root.appendChild(clon);
            Element primerPerro= (Element) doc.getElementsByTagName("Perro").item(0);
            root.replaceChild(clon,primerPerro);

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
            File nuevoPersonas = new File("dom_modificado.xml");
            StreamResult destino = new StreamResult(nuevoPersonas);

            //Hacemos la transformación que en nuestro caso es la escritura
            transformer.transform(origenDOM,destino);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
