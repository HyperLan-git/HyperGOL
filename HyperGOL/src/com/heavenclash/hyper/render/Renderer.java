package com.heavenclash.hyper.render;

import com.heavenclash.hyper.HyperGOL;
import com.heavenclash.hyper.world.World;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

public class Renderer extends JPanel {
	private static final long serialVersionUID = 2210981533584680095L;
	private World world;

	public Renderer(World world) {
		this.world = world;
	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);
		g.setColor(Color.WHITE);
		g.fillRect(0, 20, g.getClipBounds().width, g.getClipBounds().height-50);
		g.setColor(Color.BLACK);
		for(int x = 0; x < HyperGOL.WORLD_WIDTH; x++)
			for(int y = 0; y < HyperGOL.WORLD_HEIGHT; y++) {
				int windowX = x*HyperGOL.TILE_SIZE + 5,
						windowY = y*HyperGOL.TILE_SIZE + 20;
				g.drawRect(windowX, windowY, HyperGOL.TILE_SIZE, HyperGOL.TILE_SIZE);
				if(world.isTileOn(x, y))
					g.fillRect(windowX, windowY, HyperGOL.TILE_SIZE, HyperGOL.TILE_SIZE);
			}
	}
}
