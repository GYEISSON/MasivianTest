package main.java.test.model;
public class Roulette {
	private int id;
	private boolean open; 
	public Roulette(int id) {
		this.id =id;
		this.open = true;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void open() {
		this.open = true;
	}	
	public boolean isOpen() {
		return open;
	}
	public void close() {
		this.open = false;
	}
}
