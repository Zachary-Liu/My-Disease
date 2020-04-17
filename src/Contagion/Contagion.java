package Contagion;
import java.awt.*;
import java.util.ArrayList;

import javax.swing.*;

public class Contagion extends JPanel {
	static int boardX = 1500;
	static int boardY = 800;
	static int agentNum = 10000;
	static int diseasedNum = 1;
	static double gamma = 0.00000001;
	static double beta = 0.00001582;
	static int iteration = 0;
	static int numOfIterations;
	static int walkBackTime;
	static boolean walkBack;
	static ArrayList<Integer> healthyHistory = new ArrayList<Integer>();
	static ArrayList<Integer> infectedHistory = new ArrayList<Integer>();
	static ArrayList<Integer> curedHistory = new ArrayList<Integer>();
	static Board diseaseBoard = new Board (boardX, boardY, agentNum, gamma, beta, numOfIterations, walkBackTime, walkBack );
	static JFrame window = new JFrame("d = " + boardX +","+boardY + " " + "beta = " + beta +" " + "gamma = " + gamma +
			"Infected: " + diseaseBoard.getInfectedAgents().size() + "Cured: " + diseaseBoard.getCuredAgents().size() + 
			"Healthy:" + diseaseBoard.getHealthyAgents().size());
	public static void main (String[]args) {
		
		new Contagion().graphicInit();
		while (true) {
			diseasedNum = diseaseBoard.anyInfected();
			diseaseBoard.walk();
			iteration++;
			diseaseBoard.infectCure();
			window.setTitle(("d = " + boardX +","+boardY + " " + "beta = " + beta +" " + "gamma = " + gamma +
					"Infected: " + diseaseBoard.getInfectedAgents().size() + "Cured: " + diseaseBoard.getCuredAgents().size() + 
					"Healthy:" + diseaseBoard.getHealthyAgents().size()));
			
			try {
				Thread.sleep(100);
			}
			catch (Exception e) {
				
			}
			healthyHistory.add(diseaseBoard.getHealthyAgents().size());
			infectedHistory.add(diseaseBoard.getInfectedAgents().size());
			curedHistory.add(diseaseBoard.getCuredAgents().size());
			plotInit();
			
			
		}
	}
	static void plotInit() {
		Graph graph = new Graph();
		
	}
	
	void graphicInit() {
		setPreferredSize( new Dimension(boardX,boardY +100));
		
		
		window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		window.add(this);
		window.pack();
		window.setLocationRelativeTo(null);
		window.setVisible(true);
	}
	
	
		
	
	
	
	private void drawCircle(Graphics2D g2, double x, double y, double diam) {
		int x1 = (int) (1 * x);
		int y1 = (int) (1 * y);
		g2.fillOval((int) (x1 - diam / 2), boardY - (int) (y1 + diam / 2), (int) diam, (int) diam);
		
	}
	public void paint(Graphics g) {
		super.paint(g);
		Graphics2D g2 = (Graphics2D) g;
		int agentcounter = 0;
		for (Agents a: diseaseBoard.getAllAgents()) {
			agentcounter++;
			if(agentcounter%1000 == 0) {
			}
			if (a.getState()==Agents.State.Healthy) {
				g.setColor(Color.BLUE);
			}
			if (a.getState()==Agents.State.Cured) {
				g.setColor(Color.GREEN);
			}
			if (a.getState()==Agents.State.Infected) {
				g.setColor(Color.RED);
			}
			drawCircle(g2,a.getX(),a.getY(),7);
			
		}
		repaint();
	}

}
