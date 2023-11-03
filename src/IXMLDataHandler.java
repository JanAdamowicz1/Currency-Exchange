public interface IXMLDataHandler {
    void setFilePath(String filePath);
    void fetchDataFromXML() throws Exception;
    IDataDownloader getDataDownloader();
    IXMLParser getXmlParser();
}