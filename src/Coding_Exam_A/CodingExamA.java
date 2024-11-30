package Coding_Exam_A;

import java.awt.Color;

import javax.swing.JOptionPane;

import org.jointheleague.graphical.robot.Robot;

public class CodingExamA {
	public static void main(String[] args) {
		/*
		 * Write a program that asks the user for three pieces of information.
		 * 1. How many robots
		 * 2. The color of the shapes
		 * 3. How many sides each shape will have
		 * 
		 * Once the information has been collected, the program will then make the requested number of robots
		 * each draw the requested shape in the requested color. The robots should execute at the same time so 
		 * Threads will need to be used. Arrange the robots so that the shapes do not overlap.
		 * For full credit, define the Thread functions using lambdas.
		 * 
		 * See the Coding_Exam_A_Demo.jar for an example of what the finished product should look like.
		 */
		
		String num = JOptionPane.showInputDialog("How many robots?");
		String color = JOptionPane.showInputDialog("What color? (rgb)");
		String sides = JOptionPane.showInputDialog("How many sides");
		
		int robs = Integer.parseInt(num);
		int sidenum = Integer.parseInt(sides);
		
		Thread[] thred = new Thread[robs] ;
		for (int i = 0; i < robs; i++) {
			int counter = 50+(i*100);
			thred[i] = new Thread(() -> {
				Robot rob = new Robot();
				rob.moveTo(counter, 250);
				rob.setPenWidth(2);
				rob.penDown();
				rob.setSpeed(20);
				rob.hide();
				
				
				if (color.equalsIgnoreCase("red")) {
					rob.setPenColor(Color.red);
				} else if (color.equalsIgnoreCase("green")) {
					rob.setPenColor(Color.green);
				} else if (color.equalsIgnoreCase("blue")) {
					rob.setPenColor(Color.blue);
				}
				
				for ( int k = 0; k<sidenum; k++) {
					int turn = 360/sidenum;
					rob.move(20);
					rob.turn(turn);
				}
					
			});
		}
		
		for (int i = 0; i < thred.length; i++) {
			thred[i].start();
		}
		
		
		
		
		

	}
}

