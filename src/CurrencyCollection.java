import java.util.HashMap;
import java.util.Map;

public class CurrencyCollection implements ICurrencyCollection {
    private Map<String, ICurrency> currencies;

    public CurrencyCollection(){
        this.currencies = new HashMap<>();
    }
    @Override
    public Map<String, ICurrency> getCurrencies() {
        return currencies;
    }

    @Override
    public ICurrency getCurrencyByCode(String code) {
        return currencies.get(code);
    }

    @Override
    public void addCurrency(String name, double converter, String code, double rate) {
        ICurrency currency = new Currency(name, converter, code, rate);
        currencies.put(code, currency);
    }
    @Override
    public void removeCurrency(ICurrency currency) {
        currencies.remove(currency.getCode());
    }

    @Override
    public void showCurrencies(){
        for (ICurrency currency: currencies.values()){
            System.out.println(currency.getName() + " (" + currency.getCode() + ")");
            System.out.println("Converter: " + currency.getConverter());
            System.out.println("Rate: " + currency.getRate());
            System.out.println();
        }
    }
}
