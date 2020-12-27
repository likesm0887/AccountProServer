package XMLGenerator;

import org.w3c.dom.Document;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;

public abstract class XMLGenerator {
//    public static void main(String[] args) {
//
//        try {
//            generateXML();
//        } catch (TransformerException e) {
//            e.printStackTrace();
//        }
//    }

    public abstract void generateXML();

    protected Document createDocument()  {
        try {
            return DocumentBuilderFactory
                    .newInstance()
                    .newDocumentBuilder()
                    .newDocument();
        } catch (ParserConfigurationException e) {
            throw new RuntimeException("Create document failed");
        }
    }

    protected void createXMLFile(Document document) {
        Transformer transformer = createTransformer();
        DOMSource domSource = new DOMSource(document);
        StreamResult streamResult = new StreamResult(new File("./output/test.xml"));
        try {
            transformer.transform(domSource, streamResult);
        } catch (TransformerException e) {
            throw new RuntimeException("Transform dom to file failed");
        }
    }

    private Transformer createTransformer() {
        Transformer transformer = null;
        try {
            transformer = TransformerFactory.newInstance().newTransformer();
        } catch (TransformerConfigurationException e) {
            throw new RuntimeException("Create transformer factory failed");
        }
        transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
        transformer.setOutputProperty(OutputKeys.INDENT, "yes");
        return transformer;
    }

}
