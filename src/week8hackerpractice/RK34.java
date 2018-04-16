package week8hackerpractice;

public class RK34 {
	  public static void main(String[] arg) {
      	double[] x = {2.0000, 6.1946, 14.843, 33.677, 75.339};
      	double[] kk1 = new double[4];
      	double[] kk2 = new double[4];
      	double[] kk3 = new double[4];
      	double[] kk4 = new double[4];
      	double[] rk4 = new double[4];
      	double[] E = new double[4];
      	double[] he = new double[5];
      	he[0] = 1;
      	double t = 0;
      	double h = 1;
      	for(int i = 0; i < 4; i++) {
  			kk1[i] = k1(x[i], t, h);
  			kk2[i] = k2(x[i], t, h);
  			kk3[i] = k3(x[i], t, h);
  			kk4[i] = k4(x[i], t, h);
  			rk4[i] = x[i] + (7 * kk1[i] + 6 * kk2[i] + 8 * kk3[i] + 3 * kk4[i]) / 24;
  			E[i] = (-5 * kk1[i] + 6 * kk2[i] + 8 * kk3[i] - 9 * kk4[i]) / 72;
  			he[i + 1] = he[i] * Math.pow(Math.pow(10, -7) * (rk4[i] + Math.pow(10, -4)), 1 / 3);
  			t++;
  		}
  		System.out.format("%8s%25s%25s%25s%25s%25s", "t", "Xtrue", "Xrk4", "error(%)", "estimated error", "Time Steps");
  		System.out.println("");
  		System.out.format("%8s%25s%25s%25s%25s%25s", 0, x[0], " ", " ", " ", he[0]);
  		System.out.println("");
  		for(int i = 0; i < 4; i++) {
  			System.out.format("%8s%25s%25s%25s%25s%25s", i + 1, x[i + 1], rk4[i], Math.abs((rk4[i] - x[i + 1]) * 100 / x[i + 1]), E[i], he[i + 1]);
  			System.out.println("");
  		}
  		
  }
	public static double f(double x, double t) {
		return 4 * Math.exp(0.8 * t) - 0.5 * x;
	}
	public static double k1(double x, double t, double h) {
		return f(x, t);
	}
	public static double k2(double x, double t, double h) {
		return f(x + k1(x, t, h) * h / 2, t + h / 2);
	}
	public static double k3(double x, double t, double h) {
		return f(x + 3 * k2(x, t, h) * h / 4, t + 3 * h / 4);
	}
	public static double k4(double x, double t, double h) {
		return f(x + k3(x, t, h) * h, t + h);
	}
}
