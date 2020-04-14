package Contagion;

import java.util.*;

public class Board {
	private int boardX;
	private int boardY;
	private int agentNum;
	private double gamma;
	private double beta;
	private boolean walkback;
	Random rand = new Random();
	ArrayList<Agents> agentList = new ArrayList<Agents>();	
	ArrayList<Agents> healthyAgentList = new ArrayList<Agents>();
	ArrayList<Agents> curedAgentList = new ArrayList<Agents>();
	ArrayList<Agents> infectedAgentList = new ArrayList<Agents>();
		public Board(int boardX, int boardY, int agentNum, double gamma, double beta, int numOfIterations, int walkBackTime, boolean walkback ){
			this.boardX = boardX;
			this.boardY = boardY;
			this.agentNum = agentNum;
			this.gamma = gamma;
			this.beta = beta;
			this.walkback = walkback;
			
			for (int i =0; i<agentNum; i++) {
				int x = rand.nextInt(boardX);
				int y = rand.nextInt(boardY);
				
				// infected boi

				System.out.println(i +": "+ (int)(agentNum*0.95));
				if (i >= (int)(agentNum*0.95)){
					agentList.add(new Agents(Agents.State.Infected, x, y, beta, gamma,0,rand.nextInt(200), false));
					
				}
				
				agentList.add(new Agents(Agents.State.Healthy, x, y, beta, gamma,0,rand.nextInt(200),false));
			}
		}
	
		/*public void walk(){
			for (Agents a:agentList) {
				
				int direction = rand.nextInt(4);
				if (a.getY() == boardY) {
					int newdirection = rand.nextInt(3);
					if (newdirection <= 0){
						a.setY(a.getY()+5);
					}
					if (newdirection == 1){
						a.setX(a.getX()-1);
					}
					if (newdirection == 2){
						a.setX(a.getX()+1);
					}
				}
				if (a.getY() == 0) {
					int newdirection = rand.nextInt(3);
					if (newdirection == 0){
						a.setY(a.getY()+1);
					}
					if (newdirection == 1){
						a.setX(a.getX()-1);
					}
					if (newdirection == 2){
						a.setX(a.getX()+1);
					}
				}
				if (a.getX() >= boardX) {
					int newdirection = rand.nextInt(3);
					if (newdirection == 0){
						a.setY(a.getY()-1);
					}
					if (newdirection == 1){
						a.setY(a.getY()+1);
					}
					if (newdirection == 2){
						a.setX(a.getX()-1);
					}
				}
				if (a.getX() <= 0) {
					int newdirection = rand.nextInt(3);
					if (newdirection == 0){
						a.setY(a.getY()-1);
					}
					if (newdirection == 1){
						a.setY(a.getY()+1);
					}
					if (newdirection == 2){
						a.setX(a.getX()+1);
					}
				}
				else if (direction == 0){
					a.setY(a.getY()-1);
				}
				else if (direction == 1){
					a.setY(a.getY()+1);
				}
				else if (direction == 2){
					a.setX(a.getX()-1);
				}
				else if (direction == 3){
					a.setX(a.getX()+1);
				}
			}
		}
		
		*/
		
		public void walk(){
			for (Agents a:agentList) {
				int direction = rand.nextInt(4);
				if (a.getIteration()>=a.getWalkBackTime()) {
					if(a.getX()>(boardX/2)){
						a.setX(a.getX()-((rand.nextInt(10)-4)));
					}
					if(a.getX()<(boardX/2)){
						a.setX(a.getX()+((rand.nextInt(10)-4)));
					}
					if(a.getY()>(boardY/2)){
						a.setY(a.getY()-((rand.nextInt(10)-4)));
					}
					if(a.getY()<(boardY/2)){
						a.setY(a.getY()+((rand.nextInt(10)-4)));
					}
					if(((Math.abs((a.getX())-(boardX/2)))< 0) && ((Math.abs((a.getY())-(boardY/2)))< 0)){
						a.setIteration(0);
						a.setWalkBack(true);
						
					}
				}
				else if (a.getWalkBack()) {
					if(a.getX()>(boardX/2)){
						a.setX(a.getX()+2);
					}
					if(a.getX()<(boardX/2)){
						a.setX(a.getX()-2);
					}
					if(a.getY()>(boardY/2)){
						a.setY(a.getY()+2);
					}
					if(a.getY()<(boardY/2)){
						a.setY(a.getY()-2);
					}
				}
				else if (a.getY() == boardY) {
					int newdirection = rand.nextInt(3);
					if (newdirection <= 0){
						a.setY(a.getY()+5);
					}
					if (newdirection == 1){
						a.setX(a.getX()-1);
					}
					if (newdirection == 2){
						a.setX(a.getX()+1);
					}
				}
				else if (a.getY() == 0) {
					int newdirection = rand.nextInt(3);
					if (newdirection == 0){
						a.setY(a.getY()+1);
					}
					if (newdirection == 1){
						a.setX(a.getX()-1);
					}
					if (newdirection == 2){
						a.setX(a.getX()+1);
					}
				}
				else if (a.getX() >= boardX) {
					int newdirection = rand.nextInt(3);
					if (newdirection == 0){
						a.setY(a.getY()-1);
					}
					if (newdirection == 1){
						a.setY(a.getY()+1);
					}
					if (newdirection == 2){
						a.setX(a.getX()-1);
					}
				}
				else if (a.getX() <= 0) {
					int newdirection = rand.nextInt(3);
					if (newdirection == 0){
						a.setY(a.getY()-1);
					}
					if (newdirection == 1){
						a.setY(a.getY()+1);
					}
					if (newdirection == 2){
						a.setX(a.getX()+1);
					}
				}
				else if (direction == 0){
					a.setY(a.getY()-(rand.nextInt(5)));
				}
				else if (direction == 1){
					a.setY(a.getY()+(rand.nextInt(5)));
				}
				else if (direction == 2){
					a.setX(a.getX()-(rand.nextInt(5)));
				}
				else if (direction == 3){
					a.setX(a.getX()+(rand.nextInt(5)));
				}
				a.setIteration(a.getIteration()+1);
			}
		}
		
		
		public ArrayList<Agents> getHealthyAgents(){
			ArrayList<Agents> tempHealthyList = new ArrayList<Agents>();
			for (Agents a: agentList) {
				if (a.getState()== Agents.State.Healthy) {
					tempHealthyList.add(a);
				}
			}
			return tempHealthyList;
		}
		public ArrayList<Agents> getInfectedAgents(){
			ArrayList<Agents> tempInfectedList = new ArrayList<Agents>();
			for (Agents a: agentList) {
				if (a.getState()== Agents.State.Infected) {
					tempInfectedList.add(a);
					
				}
			}
			return tempInfectedList;

		}
		public ArrayList<Agents> getCuredAgents(){
			ArrayList<Agents> tempCuredList = new ArrayList<Agents>();
			for (Agents a: agentList) {
				if (a.getState()== Agents.State.Cured) {
					tempCuredList.add(a);
					
				}
			}
			return tempCuredList;

		}
		
		public ArrayList<Agents> getAllAgents(){
			return agentList;
		}
		
		
		public void infectCure() {
			ArrayList<Agents> infectedAgentsList = getInfectedAgents();
			ArrayList<Agents> healthyAgentsList = getHealthyAgents();
			
			for (Agents i:infectedAgentsList) {
				for (Agents h: healthyAgentsList) {
					if ((Math.abs(i.getX()-h.getX())<=1)&&(Math.abs(i.getY()-h.getY())<=1)){
						if(h.infect()) {
							h.setState(Agents.State.Infected);
						}
					}
				}
				if(i.cure()) {
					i.setState(Agents.State.Cured);
				}
			}
		}
		public int anyInfected() {
			int infectedAgentCounter = 0;
			for(Agents a:agentList) {
				if(a.getState()== Agents.State.Infected) {
					infectedAgentCounter++;
				}
			}
			return infectedAgentCounter;
		}
		
		
		
}


