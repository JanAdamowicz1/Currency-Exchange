import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

public class DataDownloader implements IDataDownloader {
    @Override
    public InputStream downloadData(String filePath) throws Exception {
        URL url = new URL(filePath);
        URLConnection connection = url.openConnection();
        return connection.getInputStream();
    }
}