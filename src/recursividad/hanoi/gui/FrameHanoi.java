package recursividad.hanoi.gui;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import recursividad.hanoi.Hanoi;

public class FrameHanoi extends JFrame {
	
	private Hanoi modelo;

	public FrameHanoi() {
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		this.init();
		
		this.pack();
	}

	private void init() {
		modelo = new Hanoi();
		try {
			modelo.inicial(3, 0);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		PanelHanoi pnlJPanel = new PanelHanoi(modelo);
		modelo.addObservador(pnlJPanel);
		
		this.getContentPane().setLayout(new BorderLayout());
		this.getContentPane().add(pnlJPanel, BorderLayout.CENTER);
		
		JButton comenzarButton = new JButton("Comenzar");
		comenzarButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				comenzarButton_clicked();
			}
		});
		
		this.getContentPane().add(comenzarButton, BorderLayout.SOUTH);
	}

	protected void comenzarButton_clicked() {
		Thread thread = new Thread(new Runnable() {
			
			@Override
			public void run() {
				modelo.resolver(0, 2, 1, 500);
			}
		});
		
		thread.start();	
	}

}
