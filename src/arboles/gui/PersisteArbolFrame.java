package arboles.gui;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import arboles.ArbolAritmetico;

public class PersisteArbolFrame extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel expresionField;
	
	public PersisteArbolFrame() {
		init();
	}

	private void init() {
		JMenuBar menuBar = new JMenuBar();
		
		JMenu menu = new JMenu("Expresiones");		
		menuBar.add(menu);
		
		JMenuItem menuItem = new JMenuItem("Cargar expresion");
		menuItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				cargarExpresion_clicked();
			}
		});
		
		menu.add(menuItem);		
		
		this.setJMenuBar(menuBar);
		
		// Label para la expresion y su evaluacion
		expresionField = new JLabel("         -- Ninguna expresion --               ");
		
		this.getContentPane().setLayout(new BorderLayout());
		this.getContentPane().add(expresionField, BorderLayout.CENTER);
		
		this.pack();
	}

	protected void cargarExpresion_clicked() {
		//Create a file chooser
		final JFileChooser fc = new JFileChooser();
		//In response to a button click:
		int returnVal = fc.showOpenDialog(this);
		
		if (returnVal == JFileChooser.APPROVE_OPTION) {
            File file = fc.getSelectedFile();
            try {
				List<String> lineas = Files.readAllLines(file.toPath());
				
				ArbolAritmetico arbol = new ArbolAritmetico(lineas.get(0));

				expresionField.setText(arbol.toString());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        } else {
        	
        }
	}

	public static void main(String[] args) {
		PersisteArbolFrame w = new PersisteArbolFrame();
		w.setVisible(true);
	}
}
