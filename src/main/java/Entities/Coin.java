package Entities;


public class Coin {

    BRLUSD BRLUSD;

    public Double getBRLUSD() {
        return BRLUSD.high;
    }

    @Override
    public String toString() {
        return "Coin{" +
                "BRLUSD=" + BRLUSD +
                '}';
    }
}
class BRLUSD{

    protected Double high;

    public Double getHigh() {
        return high;
    }

}
