package com.Array;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Test {
    public static void printSpiralMatrix(int rowNum,int  colNum,int[][] A) {
        
        
        Point topLeft = new Point(0, 0);
        Point topRight = new Point(0, colNum - 1);
        Point bottomRight = new Point(rowNum - 1, colNum - 1);
        Point bottomLeft = new Point(rowNum - 1, 0);
        while(topLeft.X <= bottomRight.X && bottomLeft.Y <= topRight.Y) {
            for (int i = topLeft.Y; i<= topRight.Y; i++) {
            	System.out.println(A[topLeft.X][i]);
            }
            for (int i = topRight.X+1; i <= bottomRight.X; i++) {
             	System.out.println(A[i][topRight.Y]);
            }
            if (!topLeft.equals(bottomLeft) && !topLeft.equals(topRight)) {
                for (int i = bottomRight.Y-1; i >= bottomLeft.Y; i--) {
                	System.out.println(A[bottomRight.X][i]);
                }
                for (int i = bottomLeft.X-1; i > topLeft.X; i--) {
                	System.out.println(A[i][bottomLeft.Y]);
                }
            }
           topLeft = topLeft.getPoint(1,1);
            topRight = topRight.getPoint(1,-1);
            bottomRight = bottomRight.getPoint(-1,-1);
            bottomLeft = bottomLeft.getPoint(-1,1);
        }
    }
    public static void readArrayMatrix(int[][] A,int cols) {
    int row=0;
	int col=0;

	
	try {
		Scanner scan=new Scanner(new File("testing.txt"));
		while(scan.hasNextLine()){
			Scanner scancol=new Scanner(scan.nextLine());
			col=0;
			while(scancol.hasNextInt()){
				A[row][col]=scancol.nextInt();
				col++;
			}
			row++;
		}
		 printSpiralMatrix(row,col,A);
	}catch(FileNotFoundException e){
		
	}
    }
    public static void main(String[] args) {

    	int row=0;
    	int col=0;
    	try {
			Scanner scan=new Scanner(new File("testing.txt"));
			while(scan.hasNextLine()){
				row++;
				Scanner scancol=new Scanner(scan.nextLine());
				col=0;
				while(scancol.hasNextInt()){
					scancol.nextInt();
					col++;
				}
			}
			int[][] A=new int[row][col];
			readArrayMatrix(A,col);
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
    }
}
class Point {
    int X;
    int Y;
    public Point(int X, int Y) {
        this.X = X;
        this.Y = Y;
    }
    public Point getPoint(int x, int y) {
        return new Point(this.X+x, this.Y+y);
    }
    public boolean equals(Point P) {
        return this.X == P.X && this.Y == P.Y;
    }
}

