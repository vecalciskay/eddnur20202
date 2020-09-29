package listas.gui;

import java.awt.Dimension;
import java.awt.Graphics;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.JPanel;

import listas.Lista;
import listas.model.ObjetosEscritorio;

public class ListaPanel extends JPanel implements PropertyChangeListener {

	private Lista<ObjetosEscritorio> lista;
	
	public ListaPanel(Lista<ObjetosEscritorio> l) {
		lista = l;
	}
	
	@Override
	public Dimension getPreferredSize() {
		// TODO Auto-generated method stub
		return new Dimension(500,400);
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		int y = 20;
		for(ObjetosEscritorio o : lista) {
			g.drawString(o.getNombre(), 100, y);
			y+=30;
		}
	}

	@Override
	public void propertyChange(PropertyChangeEvent evt) {
		this.repaint();
	}
}
