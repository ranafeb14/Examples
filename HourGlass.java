package com.rana.hackerrank;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class HourGlass {

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		int arr[][] = new int[6][6];
		int sum = Integer.MIN_VALUE;
		
		try {
			Scanner sc = new Scanner(new File("/home/ranap/workspace/Examples/src/com/rana/hackerrank/input2.txt"));

			while(sc.hasNextLine()) {
				for (int i = 0; i < 6; i++) {
					for (int j = 0; j < 6; j++) {
						arr[i][j] = sc.nextInt();
					}
				}
			}
			
			for (int i = 0; i < 4; i++) {
				for (int j = 0; j < 4; j++) {
					int sum_x = 0;
					//int sub_arr[][] = new int[3][3];
					
					for (int x = 0; x < 3; x++) {
						for (int y = 0; y<3;y++) {
							System.out.print(arr[x+i][y+j]+" ");
							if(!(x==1&&y==0 || x==1&&y==2)) {
								sum_x += arr[x+i][y+j];
							}
							
							//sub_arr[x][y] = arr[x+i][y+j];
						}
						System.out.println("");
						
					}
					
					System.out.println("----------");
					System.out.println(sum_x);
					if(sum_x>sum) {
						sum = sum_x;
					}
					
				}
				// System.out.println("************");
			}
			System.out.println("Hour Glass max"+sum);


		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
