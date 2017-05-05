package com.rana.hackerrank;

public class Staircase {
	public static void main(String[] args) {
		int n = 6;

		/*		
		######
		#####
		####
		###
		##
		#

		 */
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n-i; j++) {
				System.out.print("#");
			}
			System.out.println();
		}


		/*
			      #
			     ##
			    ###
			   ####
			  #####
			 ######

		 */		

		for (int i = 0; i < n; i++) {
			for (int j = 1; j <= n; j++) {
				if(j<n-i) {
					System.out.print(" ");
				}
				else{
					System.out.print("#");
				}

			}
			System.out.println();
		}

	}
}

