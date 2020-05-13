package Q1_07_Rotate_Matrix;

import CommonMethods.*;

//Given an image represented by an N*N matrix, where each pixel in the image is 4 bytes. Write a method to rotate the image by 90 degrees.
public class Solution {


	public static boolean rotate(int[][] matrix) {
		if (matrix.length == 0 || matrix.length != matrix[0].length) return false; // Not a square
		int n = matrix.length;
		
		for (int layer = 0; layer < n / 2; layer++) {
			int first = layer;
			int last = n - 1 - layer;
			for(int i = first; i < last; i++) {
				int offset = i - first;
				int top = matrix[first][i]; // save top

				// left -> top
				matrix[first][i] = matrix[last-offset][first]; 			

				// bottom -> left
				matrix[last-offset][first] = matrix[last][last - offset]; 

				// right -> bottom
				matrix[last][last - offset] = matrix[i][last]; 

				// top -> right
				matrix[i][last] = top; // right <- saved top
			}
		}
		return true;
	}


	public static void main(String[] args) {
		int[][] matrix = CommonMethods.randomMatrix(3, 3, 0, 9);
		CommonMethods.printMatrix(matrix);
		rotate(matrix);
		System.out.println();
		CommonMethods.printMatrix(matrix);
	}

}
