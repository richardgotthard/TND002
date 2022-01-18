package PartA;

public class Integrator {

	public static void main(String[] args) {

		double integral = 0.0;
		double error = 0.0;
		int intError = 0;
		int N = 1;
		int limit = 40;
		double F2 = 8.0 / 3.0;

		do {
			double deltaX = 2.0 / N;

			for (int j = 1; j < N + 1; j++) {

				double height = Math.pow(j * deltaX, 2);
				double area = height * deltaX;
				integral += area;

			}

			error = (integral - F2) / F2;
			error = Math.round(100.0 * error);
			intError = (int) error;

			writeToConsole(integral, intError);

			N++;
			integral = 0;
		}

		while (intError > limit);

	}

	public static void writeToConsole(double integ, double error) {
		System.out.println(String.format("the result is %.2f and error is %.1f percent.", integ, error));

	}
}
