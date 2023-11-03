public class Singleton {
    private static Singleton instance = null;
    private ICurrencyCollection currencyCollection;
    private ICurrencyConverter currencyConverter;
    private IUserInterface userInterface;
    private IXMLDataHandler xmlDataHandler;

    private Singleton(){
        currencyCollection = new CurrencyCollection();
        currencyConverter = new CurrencyConverter();
        userInterface = new UserInterface(currencyCollection, currencyConverter);
        xmlDataHandler = new XMLDataHandler(currencyCollection);
    }

    public static Singleton getInstance(){
        if(instance == null){
            instance = new Singleton();
        }
        return instance;
    }

    public ICurrencyCollection getCurrencyCollection() {
        return this.currencyCollection;
    }

    public ICurrencyConverter getCurrencyConverter(){
        return this.currencyConverter;
    }

    public IUserInterface getUserInterface(){
        return this.userInterface;
    }

    public IXMLDataHandler getXmlDataHandler(){
        return this.xmlDataHandler;
    }

    public IDataDownloader getDataDownloader() {
        return this.xmlDataHandler.getDataDownloader();
    }

    public IXMLParser getXmlParser() {
        return this.xmlDataHandler.getXmlParser();
    }
}
