package week8hackerpractice;

public class RK4 {
    public static void main(String[] arg) {
        	double[] x = {2.0000, 6.1946, 14.843, 33.677, 75.339};
        	double[] kk1 = new double[4];
        	double[] kk2 = new double[4];
        	double[] kk3 = new double[4];
        	double[] kk4 = new double[4];
        	double[] rk4 = new double[4];
        	double t = 0;
        	double h = 1;
        	for(int i = 0; i < 4; i++) {
    			kk1[i] = k1(x[i], t, h);
    			kk2[i] = k2(x[i], t, h);
    			kk3[i] = k3(x[i], t, h);
    			kk4[i] = k4(x[i], t, h);
    			rk4[i] = x[i] + (kk1[i] + 2 * kk2[i] + 2 * kk3[i] + kk4[i]) / 6;
    			t++;
    		}
    		System.out.format("%8s%20s%20s%20s%20s%20s%20s%20s", "t", "Xtrue", "k1", "k2", "k3", "k4", "Xrk4", "error(%)");
    		System.out.println("");
    		System.out.format("%8s%20s%20s%20s%20s%20s%20s%20s", 0, x[0], kk1[0], kk2[0], kk3[0], kk4[0], " ",  " ");
    		System.out.println("");
    		for(int i = 1; i < 4; i++) {
    			System.out.format("%8s%20s%20s%20s%20s%20s%20s%20s", i, x[i], kk1[i], kk2[i], kk3[i], kk4[i], rk4[i - 1], Math.abs((rk4[i - 1] - x[i]) * 100 / x[i]));
    			System.out.println("");
    		}
    		System.out.format("%8s%20s%20s%20s%20s%20s%20s%20s", "4", x[4], " ", " ", " ", " ", rk4[3], Math.abs((rk4[3] - x[4]) * 100 / x[4]));
    		
    }
	public static double f(double x, double t) {
		return 4 * Math.exp(0.8 * t) - 0.5 * x;
	}
	public static double k1(double x, double t, double h) {
		return f(x, t);
	}
	public static double k2(double x, double t, double h) {
		return f(x + k1(x, t, h) * h / 2, t + h/2);
	}
	public static double k3(double x, double t, double h) {
		return f(x + k2(x, t, h) * h / 2, t + h/2);
	}
	public static double k4(double x, double t, double h) {
		return f(x + k3(x, t, h) * h, t + h);
	}
}
