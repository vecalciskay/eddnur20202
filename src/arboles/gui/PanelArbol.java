package arboles.gui;

import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JPanel;

import arboles.Arbol;

public class PanelArbol extends JPanel {

	private Arbol<String> modelo;
	
	public PanelArbol(Arbol<String> m) {
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
			modelo.dibujar(g, 10, 10);
		}
	}
}
