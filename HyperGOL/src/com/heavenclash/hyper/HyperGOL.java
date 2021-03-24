package com.heavenclash.hyper;

import com.heavenclash.hyper.io.MouseHandler;
import com.heavenclash.hyper.render.Renderer;
import com.heavenclash.hyper.world.World;

import java.awt.BorderLayout;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JSlider;

public class HyperGOL implements ActionListener {
	public static final int WORLD_WIDTH = 150, WORLD_HEIGHT = 80, TILE_SIZE = 10;

	private JFrame window;
	private JButton button;
	private JSlider fps;

	private Renderer canvas;

	private World world;

	private boolean running;

	public HyperGOL() {
		this.init();
	}

	private void init() {
		this.window = new JFrame("HyperGol");
		this.window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.window.setSize(WORLD_WIDTH*TILE_SIZE+20, WORLD_HEIGHT*TILE_SIZE+80);

		this.window.setLocationRelativeTo(null);
		this.window.setResizable(false);

		this.world = new World(WORLD_WIDTH, WORLD_HEIGHT);
		this.canvas = new Renderer(world);

		this.window.setContentPane(canvas);

		BorderLayout layout = new BorderLayout();
		this.window.setLayout(layout);

		this.button = new JButton("Lancer animation");
		this.button.addActionListener(this);

		this.fps = new JSlider();
		this.fps.setMinimum(1);
		this.fps.setMaximum(500);

		this.window.add(button, BorderLayout.SOUTH);
		this.window.add(fps, BorderLayout.NORTH);

		this.window.addMouseListener(new MouseHandler(this));

		this.window.setVisible(true);
	}

	public void onMouseClicked(Point point) {
		point.x -= 10;
		point.y -= 47;
		point.x /= TILE_SIZE;
		point.y /= TILE_SIZE;
		world.setTileOn(point.x, point.y, !world.isTileOn(point.x, point.y));
	}

	public void repaint() {
		this.canvas.repaint();
		this.window.repaint();
	}

	public void update() {
		if(running)
			world.update();
		this.repaint();
	}

	public int getFrameRate() {
		return this.fps.getValue();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		running = !running;
		if(running)
			this.button.setText("Pause");
		else
			this.button.setText("Reprendre");
	}
}
