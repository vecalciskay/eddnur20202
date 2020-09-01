package imagenes;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;


public class FRameImagen extends JFrame {
	private Imagen modelo;

	public FRameImagen() {
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		this.init();
		
		this.pack();
	}

	private void init() {
		modelo = new Imagen(600,400);
		try {
			modelo.inicializar();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		PanelImagen pnlJPanel = new PanelImagen(modelo);
		modelo.addObservador(pnlJPanel);
		
		this.getContentPane().setLayout(new BorderLayout());
		this.getContentPane().add(pnlJPanel, BorderLayout.CENTER);
		
		JButton comenzarButton = new JButton("Dibujar");
		comenzarButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				dibujarButton_clicked();
			}
		});
		
		this.getContentPane().add(comenzarButton, BorderLayout.SOUTH);
	}

	protected void dibujarButton_clicked() {
	}
}
