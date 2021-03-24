package com.heavenclash.hyper.io;

import com.heavenclash.hyper.HyperGOL;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MouseHandler implements MouseListener {
	private HyperGOL instance;

	public MouseHandler(HyperGOL instance) {
		this.instance = instance;
	}

	@Override
	public void mouseEntered(MouseEvent e) {	}

	@Override
	public void mouseExited(MouseEvent e) {		}

	@Override
	public void mousePressed(MouseEvent e) {
		instance.onMouseClicked(e.getPoint());
	}

	@Override
	public void mouseReleased(MouseEvent e) {	}

	@Override
	public void mouseClicked(MouseEvent e) {	}
}
