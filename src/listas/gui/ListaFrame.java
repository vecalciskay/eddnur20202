package listas.gui;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import listas.Lista;
import listas.model.Mesa;
import listas.model.ObjetosEscritorio;
import listas.model.Silla;

public class ListaFrame extends JFrame{

	private Lista<ObjetosEscritorio> lista;
	
	public ListaFrame() {
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		this.init();
		
		this.pack();
	}

	private void init() {
		this.getContentPane().setLayout(new BorderLayout());
		
		lista = new Lista<ObjetosEscritorio>();
		
		ListaPanel panel = new ListaPanel(lista);
		this.getContentPane().add(panel, BorderLayout.CENTER);
		
		lista.observador(panel);
		
		JPanel botonesJPanel = new JPanel();
		botonesJPanel.setLayout(new BorderLayout());
		
		JButton btn = new JButton("Nueva Mesa");
		btn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				btnNuevaMesa();				
			}
		});
		
		botonesJPanel.add(btn, BorderLayout.NORTH);
		
		btn = new JButton("Nueva Silla");
		btn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				btnNuevaSilla();				
			}
		});
		
		botonesJPanel.add(btn, BorderLayout.CENTER);
		
		this.getContentPane().add(botonesJPanel, BorderLayout.EAST);
	}

	protected void btnNuevaSilla() {
		Silla silla = new Silla();
		lista.insertar(silla);
	}

	protected void btnNuevaMesa() {
		Mesa mesa = new Mesa();
		lista.insertar(mesa);
	}
}
