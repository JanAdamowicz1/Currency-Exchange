import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.InputStream;

public class XMLParser implements IXMLParser {
    private ICurrencyCollection currencyCollection;

    public XMLParser(ICurrencyCollection currencyCollection) {
        this.currencyCollection = currencyCollection;
    }

    @Override
    public void parseXMLData(InputStream stream) throws Exception {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(stream);
            doc.getDocumentElement().normalize();

            NodeList nodeList = doc.getElementsByTagName("pozycja");

            for (int i = 0; i < nodeList.getLength(); i++) {
                Element element = (Element) nodeList.item(i);
                String name = element.getElementsByTagName("nazwa_waluty").item(0).getTextContent();
                double converter = Double.parseDouble(element.getElementsByTagName("przelicznik").item(0).getTextContent());
                String code = element.getElementsByTagName("kod_waluty").item(0).getTextContent();
                double rate = Double.parseDouble(element.getElementsByTagName("kurs_sredni").item(0).getTextContent().replace(",", "."));

                currencyCollection.addCurrency(name, converter, code, rate);
            }
            currencyCollection.addCurrency("polski złoty", 1, "PLN", 1);
        } finally {
            if (stream != null) {
                stream.close();
            }
        }
    }
}