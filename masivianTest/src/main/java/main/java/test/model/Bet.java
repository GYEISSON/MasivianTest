package main.java.test.model;
public class Bet {
	private int userId;
	private byte expectedNumber;
	private char color;
	private short value;

	public Bet(int user, byte number, char color, short value) {
		this.userId = user;
		this.expectedNumber = number;
		this.color = color;
		this.value = value;
	}
	public short getValue() {
		
		return value;
	}
	public void setValue(short value) {
		this.value = value;
	}
	public byte getExpectedNumber() {
		
		return expectedNumber;
	}
	public void setExpectedNumber(byte expectedNumber) {
		this.expectedNumber = expectedNumber;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public char getColor() {
		return color;
	}
	public void setColor(char color) {
		this.color = color;
	}
}
