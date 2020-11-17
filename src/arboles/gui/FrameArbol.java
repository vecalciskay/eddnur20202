package arboles.gui;

import java.awt.BorderLayout;

import javax.swing.JFrame;

import arboles.Arbol;

public class FrameArbol extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Arbol<String> modelo;
	
	public FrameArbol() {
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		this.init();
		
		this.pack();
	}

	private void init() {

		modelo = crearArbol();
		
		PanelArbol panel = new PanelArbol(modelo);
		
		this.getContentPane().setLayout(new BorderLayout());
		this.getContentPane().add(panel, BorderLayout.CENTER);
	}

	private Arbol<String> crearArbol() {
		Arbol<String> arbol = new Arbol<String>();
		
		arbol.insertar("X", "X", null);
		
		arbol.insertar("M", "M", "X");
		arbol.insertar("A", "A", "X");
		arbol.insertar("C", "C", "X");
		
		arbol.insertar("D", "D", "M");
		arbol.insertar("P", "P", "M");
		arbol.insertar("R", "R", "M");
		arbol.insertar("H", "H", "A");
		arbol.insertar("L", "L", "A");
		
		return arbol;
	}
	
	public static void main(String[] args) {
		FrameArbol win = new FrameArbol();
		win.setVisible(true);
	}
}
