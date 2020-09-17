package imagenes.operaciones;

import imagenes.Imagen;

public class ConvertirGris implements IOperacion {

	
	
	@Override
	public void ejecutarCambios(Imagen img) {
		for (int i = 0; i < img.getAncho(); i++) {
			for (int j = 0; j < img.getAlto(); j++) {
				int colorOriginal = img.getPixel(i, j);
				
				int rojo = (0x00ff0000 & colorOriginal) >> 16;
				int verde = (0x0000ff00 & colorOriginal) >> 8;
				int azul = 0x000000ff & colorOriginal;
				
				int gris = (rojo+verde+azul)/3; 
				
				int colorFinal = (gris << 16) | (gris << 8) | gris;
				
				img.setPixel(colorFinal, i, j);
			}
		}
	}

	
}
