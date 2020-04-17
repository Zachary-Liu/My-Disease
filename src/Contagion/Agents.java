package Contagion;

// Comment
import java.util.Random;
public class Agents {
	
	private int x;
	private int y;
	private double beta;
	private double gamma;
	private int walkBackTime;
	private int numOfIterations;
	private boolean walkBack;
	enum State{
		Infected,
		Cured,
		Healthy
	}
	private State state;
	private Random rand = new Random();
	public Agents(State state,int x, int y, double beta, double gamma, int numOfIterations, int walkBackTime, boolean walkback ){
		this.x = x;
		this.y = y;
		this.beta = beta;
		this.gamma = gamma;
		this.state = state;
		this.numOfIterations = numOfIterations;
		this.walkBackTime = walkBackTime;
		this.walkBack = walkBack;
	}
	public State getState(){
		return this.state;
	}
	public int getX(){
		return this.x;
	}
	public int getY(){
		return this.y;
	}
	public double getBeta(){
		return this.beta;
	}
	public double getGamma(){
		return this.gamma;
	}
	public int getIteration() {
		return this.numOfIterations;
	}
	public int getWalkBackTime() {
		return this.walkBackTime;
	}
	public boolean getWalkBack() {
		return this.walkBack;
	}
	public void setX(int newX){
		this.x = newX;
	}
	public void setY(int newY){
		this.y = newY;
	}
	public void setState(State newState) {
		this.state = newState;
	}
	public void setIteration(int newIteration) {
		this.numOfIterations = newIteration;
	}
	public void setWalkBack (boolean NewwalkBack) {
		this.walkBack = NewwalkBack;
	}
	public boolean infect() {
		if (Math.random()<beta) {
			return true;
		}
		else {
			return false;
		}
	}
	public boolean cure() {
		if (Math.random()<gamma) {
			return true;
		}
		else {
			return false;
		}
	}
	
	

}
