package com.heavenclash.hyper;

public class Main {
	public static void main(String[] args) {
		double lastFrameTime = getTimeSeconds();
		HyperGOL instance = new HyperGOL();

		while(true) {
			int frameRate = instance.getFrameRate();
			while(lastFrameTime + 1.0f/frameRate <= getTimeSeconds()) {
				instance.update();
				lastFrameTime += 1.0f/frameRate;
			}
			instance.repaint();
		}
	}

	public static double getTimeSeconds() {
		return (double)System.nanoTime() / 1000000000;
	}
}
