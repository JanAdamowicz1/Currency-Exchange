public interface ICurrencyConverter {
    void setInputCurrency(ICurrency inputCurrency);
    void setOutputCurrency(ICurrency outputCurrency);
    void setValue(double value);
    double convert();
}