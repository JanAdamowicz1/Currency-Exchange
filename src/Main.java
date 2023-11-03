import java.util.Locale;
public class Main {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Singleton singleton = Singleton.getInstance();
        try {
            singleton.getXmlDataHandler().setFilePath("https://www.nbp.pl/kursy/xml/lasta.xml");
            singleton.getXmlDataHandler().fetchDataFromXML();
            singleton.getUserInterface().start();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}