import java.util.Map;

public interface ICurrencyCollection {
    Map<String, ICurrency> getCurrencies();
    ICurrency getCurrencyByCode(String code);
    void addCurrency(String name, double converter, String code, double rate);
    void removeCurrency(ICurrency currency);
    void showCurrencies();
}
