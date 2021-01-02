package infrastructure.xmlGenerator;


import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.*;
import java.util.List;

public class Part1BNodeTag {
    static final String context = "context";
    static final String entity = "entity";
    static final String identifier = "identifier";
    static final String period = "period";
    static final String startDate = "startDate";
    static final String endDate = "endDate";
    static final String instant = "instant";
    static final String scenario = "scenario";
    static final String explicitMember = "explicitMember";
    DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();

    public void read() {
        DocumentBuilder dBuilder = null;

        {
            try {
                dBuilder = dbFactory.newDocumentBuilder();
            } catch (ParserConfigurationException e) {
                e.printStackTrace();
            }
        }

        Document doc = null;


        File xml = new File("./template/SSM_FS-MPERS_128 879-A_20180331.xml");
        SAXReader reader = new SAXReader();
        try {
            doc = reader.read(xml);

        } catch (DocumentException e) {
            e.printStackTrace();
        }
        List<Element> n = doc.getRootElement().elements();

        doc.selectSingleNode("//ssmt-dei:CompanyRegistrationNumber").setText("1245113");
        System.out.print(doc.selectSingleNode("//ssmt-dei:CompanyRegistrationNumber").getStringValue());
        OutputFormat format = OutputFormat.createPrettyPrint();
        XMLWriter writer;
        try {
            OutputStream outputStream = new FileOutputStream(xml);
            writer = new XMLWriter(outputStream, format);
            writer.write(doc);
            writer.close();
            outputStream.close();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
