package com.heavenclash.hyper.world;

public class World {
	//	private Vector2i antPos;
	//	private byte direction = 0;

	private boolean[][] worldMatrix;

	public World(int width, int height) {
		this.worldMatrix = new boolean[width][height];
		for(int x = 0; x < width; x++)
			for(int y = 0; y < height; y++)
				this.worldMatrix[x][y] = false;
		//		this.antPos = new Vector2i(width/2, height/2);
	}

	public boolean isTileOn(int x, int y) {
		if(x < 0 || y < 0 || x >= worldMatrix.length || y >= worldMatrix[0].length)
			return false;
		return this.worldMatrix[x][y];
	}

	public void setTileOn(int x, int y, boolean on) {
		if(x < 0 || y < 0 || x >= worldMatrix.length || y >= worldMatrix[0].length)
			return;
		worldMatrix[x][y] = on;
	}

	public void update() {
		//		int x = antPos.x, y = antPos.y;
		//		this.setTileOn(x, y, !this.isTileOn(x, y));
		//		if(this.isTileOn(x, y))
		//			direction++;
		//		else
		//			direction--;
		//
		//		if(direction == -1)
		//			direction = 3;
		//		if(direction == 4)
		//			direction = 0;
		//
		//		switch(direction) {
		//		case 0:
		//			antPos.y++;
		//			break;
		//		case 1:
		//			antPos.x++;
		//			break;
		//		case 2:
		//			antPos.y--;
		//			break;
		//		case 3:
		//			antPos.x--;
		//			break;
		//		}
		boolean[][] clone = new boolean[worldMatrix.length][worldMatrix[0].length];
		for(int x = 0; x < worldMatrix.length; x++) for(int y = 0; y < worldMatrix[0].length; y++) {
			int i = getTilesAroundOn(x, y);
			clone[x][y] = (i == 3 || (isTileOn(x, y) && i == 2));
		}
		for(int x = 0; x < worldMatrix.length; x++)
			for(int y = 0; y < worldMatrix[0].length; y++)
				setTileOn(x, y, clone[x][y]);
	}

	private int getTilesAroundOn(int x, int y) {
		int j = 0;
		for(int x1 = x-1; x1 <= x+1; x1++)
			for(int y1 = y-1; y1 <= y+1; y1++)
				if(isTileOn(x1, y1) && !(x1 == x && y1 == y))
					j++;
		return j;
	}
}
