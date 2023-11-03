public class Currency implements ICurrency{
    private String name;
    private double converter;
    private String code;
    private double rate;

    public Currency(String name, double converter, String code, double rate){
        this.name = name;
        this.converter = converter;
        this.code = code;
        this.rate = rate;
    }

    @Override
    public String getName(){
        return name;
    }
    @Override
    public double getConverter(){
        return converter;
    }
    @Override
    public String getCode(){
        return code;
    }
    @Override
    public double getRate(){
        return rate;
    }
}
