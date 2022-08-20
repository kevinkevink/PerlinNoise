import java.util.Random;
public class PerlinNoise {

    private int base; //distance between basePoints, how big you want the spaces in the grid to be
    private int amplitude;
    private int seed;

    public PerlinNoise(int base, int amplitude, int seed){
        this.base = base;
        this.amplitude = amplitude;
        this.seed = seed;
    }

    public int generateHeight(int pos){
        int backPoint =  pos - (pos % base);
        Random backRandom = new Random(backPoint + seed);
        int frontPoint = backPoint + base;
        Random frontRandom = new Random(frontPoint + seed);
        int backToPos = pos - backPoint;
        int randomBack = backRandom.nextInt(amplitude);
        int randomFront = frontRandom.nextInt(amplitude);
        double backWeight = easeCurve((1 - ((double)backToPos / base)));
        double frontWeight = easeCurve(((double)backToPos / base));
        return (int)(randomBack * backWeight + randomFront * frontWeight) / 2;
    }
    private double easeCurve(double num){
        return 6 * Math.pow(num, 5) - 15 * Math.pow(num, 4) + 10 * Math.pow(num, 3);
    }


}
