import java.io.InputStream;

public class XMLDataHandler implements IXMLDataHandler {
    private String filePath;
    private ICurrencyCollection currencyCollection;
    private IDataDownloader dataDownloader;
    private IXMLParser xmlParser;

    public XMLDataHandler(ICurrencyCollection currencyCollection) {
        this.currencyCollection = currencyCollection;
        this.dataDownloader = new DataDownloader();
        this.xmlParser = new XMLParser(currencyCollection);
    }

    @Override
    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    @Override
    public void fetchDataFromXML() throws Exception {
        InputStream stream = dataDownloader.downloadData(filePath);
        xmlParser.parseXMLData(stream);
    }

    @Override
    public IDataDownloader getDataDownloader() {
        return this.dataDownloader;
    }

    @Override
    public IXMLParser getXmlParser() {
        return this.xmlParser;
    }
}
