public class CurrencyConverter implements ICurrencyConverter {

    private ICurrency inputCurrency;
    private ICurrency outputCurrency;
    private double value;

    @Override
    public void setInputCurrency(ICurrency inputCurrency){
        this.inputCurrency = inputCurrency;
    }
    @Override
    public void setOutputCurrency(ICurrency outputCurrency){
        this.outputCurrency = outputCurrency;
    }
    @Override
    public void setValue(double value){
        this.value = value;
    }
    @Override
    public double convert(){
        if (inputCurrency == null || outputCurrency == null) {
            throw new IllegalStateException("The input and output currency must be set.");
        }
        double inputRate = inputCurrency.getRate() / inputCurrency.getConverter();
        double outputRate = outputCurrency.getRate() / outputCurrency.getConverter();
        return (value * inputRate) / outputRate;
    }
}
