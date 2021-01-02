package com.accountProServer.AccountProServer.repository;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URI;
import java.net.URISyntaxException;

public class DocumentRepository {
    private final String TEMPLATE_PATH = "./template/SSM_FS-MPERS_128 879-A_20180331.xml";
    private Document document;
    private final File xml;

    public DocumentRepository(String templatePath) {
        SAXReader reader = new SAXReader();

        try {

            xml = new File(templatePath);
            document = reader.read(xml);
        } catch ( DocumentException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    public void modifyElement(String tagName, String attribute, String value) {
        ((Element) document.selectSingleNode("//" + tagName)).attribute(attribute).setText(value);
    }

    public void modifyElement(String tagName, String value) {
        document.selectSingleNode("//" + tagName).setText(value);
    }

    public Element select(String xpath) {
        return (Element) document.selectSingleNode(xpath);
    }

    public void save() {
        OutputFormat format = OutputFormat.createPrettyPrint();
        XMLWriter writer;
        try {
            OutputStream outputStream = new FileOutputStream(xml);
            writer = new XMLWriter(outputStream, format);
            writer.write(document);
            writer.close();
            outputStream.close();
        } catch (IOException e) {
            throw new RuntimeException("can't save XML");
        }
    }

}
