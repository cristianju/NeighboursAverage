import java.util.Scanner;

public class NeighboursAverage {

	/*
	 * Neighbours average (Media Vecinilor): Using a row of real numbers to generate
	 * another row of real numbers where each element is arithmetic mean between it
	 * and the neighboring elements.
	 */

	public static void main(String args[]) {
		System.out
				.println("This program calculates the average of the neighbors" + " from a series of real numbers.\n");
		System.out.println("Initial string:\n" + "v[0], v[1], v[2]");
		System.out.println("Result string:\n" + "vr[0], vr[1], vr[2]");
		System.out.println("where vr[0] = (v[0]+v[1])/2, " + "vr[1] = (v[0]+v[2])/2, vr[2] = (v[1]+v[2])/2");
		System.out.println("");

		Scanner s = new Scanner(System.in);
		int n;
		System.out.println("Enter the length of the vector: ");
		n = readNum(s);
		System.out.println("Check point 02 !!! n = " + n);
		
		double[] v = new double[n];

		System.out.println("Enter vector`s elements: \n");
		for (int i = 0; i < v.length; i++) {
			v[i] = readVect(s);
		}

		System.out.println("\nInitial string(vector):");
		printVector(v);

		System.out.println();
		System.out.println("\nResult string(vector):");
		medVec(v);
		printVector(medVec(v));

		s.close();
	}

	public static int readNum(Scanner s) {
		if (!s.hasNextInt()) {
			System.out.println("The row length must be a number!");
			System.out.println("Re-enter row`s length: ");
			s.next();
			return readNum(s);
		}
			
		int n = s.nextInt();
		if (n <= 0) {
				System.out.println();
				System.out.println("n has to be greater than zero!");
				System.out.print("Re-type n: ");
				//s.next();
				return readNum(s);
		}
		return n;
	}

	public static int readVect(Scanner s) {
		if (!s.hasNextInt()) {
			System.out.println("The element must be a number!");
			System.out.println("Re-enter the element: ");
			s.next();
			return readVect(s);
		}
		int n = s.nextInt();
		return n;
	}

	public static double[] medVec(double vm[]) {
		double vr[] = new double[vm.length];
		vr[0] = (vm[0] + vm[1]) / 2;
		int f = vm.length - 1;
		vr[f] = (vm[f - 1] + vm[f]) / 2;

		for (int i = 1; i < vm.length - 1; i++) {
			vr[i] = (vm[i - 1] + vm[i] + vm[i + 1]) / 3;
		}
		return vr;
	}

	public static void printVector(double[] v) {
		System.out.print("{");
		for (int i = 0; i < v.length - 1; i++) {
			System.out.print(v[i] + ", ");
		}
		System.out.print(v[v.length - 1] + "}");
	}

}