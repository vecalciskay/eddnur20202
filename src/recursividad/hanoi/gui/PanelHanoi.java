package recursividad.hanoi.gui;

import java.awt.Dimension;
import java.awt.Graphics;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.JPanel;

import recursividad.hanoi.Hanoi;

public class PanelHanoi extends JPanel implements PropertyChangeListener {

	private Hanoi modelo;

	public PanelHanoi(Hanoi m) {
		modelo = m;
	}	
	
	@Override
	public Dimension getPreferredSize() {
		return new Dimension(600, 400);
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);

		if (modelo != null) {
			IDibujo dibujo = new DibujoHanoi(modelo);
			dibujo.dibujar(g);
		}
	}

	@Override
	public void propertyChange(PropertyChangeEvent evt) {
		this.repaint();
	}
}
