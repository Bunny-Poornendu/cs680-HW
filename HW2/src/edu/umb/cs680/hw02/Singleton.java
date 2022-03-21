package edu.umb.cs680.hw02;

public class Singleton {
	private Singleton() {};
	private static Singleton instance = null;
	
	public static Singleton getInstance() {
		if(instance == null) {
			instance = new Singleton();
		}
		return instance;
	}

}
