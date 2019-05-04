public class Problem16 {
    public static void main(String[] args) {
        System.out.println(new Problem16().pow(2.5,-2));
    }

    double pow(double base,int exponent){
        boolean negetive = exponent < 0;
        if(new BigDecimal(exponent).compareTo(new BigDecimal(0.0))==0) return 0;
        if(exponent==0) return (double)1;
        int e = Math.abs(exponent);
        double result = 1.0;
        result = powWithoutUnsiginedExponent(base,e);
        return negetive ? 1.0 / result : result;
    }
    double powWithoutUnsiginedExponent(double base,int exponent){
        if(exponent == 0) return 1;
        if(exponent == 1) return base;
        double result = 0.0;
        int e1 = exponent >> 1,e2 = exponent -e1;
        result = powWithoutUnsiginedExponent(base,e1) * powWithoutUnsiginedExponent(base,e2);
        return result;
    }
}