import java.io.InputStream;

public interface IDataDownloader {
    InputStream downloadData(String filePath) throws Exception;
}