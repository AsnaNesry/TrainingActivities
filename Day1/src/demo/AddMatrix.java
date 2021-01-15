package demo;

import java.util.Scanner;

public class AddMatrix {

	int row, col;
	int i, j;

	Scanner sc = new Scanner(System.in);

	void calculateSum() {

		try {
			System.out.print(" Enter the no of rows for the matrix :");
			row = sc.nextInt();

			System.out.print(" Enter the no of columns for the matrix :");
			col = sc.nextInt();

			int a[][] = new int[row][col];
			System.out.print(" Enter the first matrix :");
			for (i = 0; i < row; i++) {
				for (j = 0; j < col; j++) {

					a[i][j] = sc.nextInt();

				}
			}

			int b[][] = new int[row][col];
			System.out.print(" Enter the second matrix :");
			for (i = 0; i < row; i++) {
				for (j = 0; j < col; j++) {

					b[i][j] = sc.nextInt();

				}
			}

			System.out.println("sum of given two matrix is: ");
			int c[][] = new int[row][col];

			for (i = 0; i < row; i++) {
				for (j = 0; j < col; j++) {

					c[i][j] = a[i][j] + b[i][j];
					System.out.println(c[i][j]);
					System.out.println("  ");

				}
				System.out.println("\n");
			}
		} catch (NegativeArraySizeException e) {
			System.out.println("You cannot enter negative number as row or column");
		}

	}

}
