package imagenes;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileFilter;

import imagenes.operaciones.ConvertirGris;


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
		
		// Menu
		JMenuBar bar = new JMenuBar();
		this.setJMenuBar(bar);
		
		JMenu menu = new JMenu("Archivo");
		bar.add(menu);
		
		JMenuItem item = new JMenuItem("Cargar Imagen");
		item.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				menuArchivo_cargarImagen();
			}
		});
		menu.add(item);
		
		menu = new JMenu("Operaciones");
		bar.add(menu);
		
		item = new JMenuItem("Convertir a Gris");
		item.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				menuOperaciones_convertirGris();
			}
		});
		menu.add(item);
		
		menu = new JMenu("Fractales");
		bar.add(menu);
		
		item = new JMenuItem("Mandelbrot");
		item.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				menuFractales_mandelbrot();
			}
		});
		menu.add(item);
	}

	protected void menuFractales_mandelbrot() {
		modelo.mandelbrot(600,400);
	}

	protected void menuOperaciones_convertirGris() {
		ConvertirGris accionConvertirGris = new ConvertirGris();
		accionConvertirGris.ejecutarCambios(modelo);
	}

	protected void menuArchivo_cargarImagen() {
		JFileChooser inputFile = new JFileChooser();
		inputFile.setFileFilter(new FileFilter() {

			@Override
			public String getDescription() {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public boolean accept(File f) {
				if (f.isDirectory()) {
					return true;
				}
				String extension = f.getAbsolutePath().substring(f.getAbsolutePath().length() - 4);
				extension = extension.toLowerCase();
				return extension.equals(".jpg") || extension.equals(".gif") || extension.equals(".png");
			}
		});
		inputFile.showOpenDialog(this);

		if (inputFile.getSelectedFile() == null) {
			JOptionPane.showMessageDialog(this, "Debe elegir una imagen");
			return;
		}

		BufferedImage img = null;
		try {
			img = ImageIO.read(inputFile.getSelectedFile());
		} catch (IOException e) {
			;
		}

		modelo.setImagen(img);
	}

	protected void dibujarButton_clicked() {
	}
}
