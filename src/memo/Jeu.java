package memo;

import java.io.IOException;
import java.util.Collections;
import java.util.LinkedList;

import javax.swing.ImageIcon;

public class Jeu {
    private ImageIcon[][] figures = loadImages();
    private static final int rows = 4;
    private static final int cols = 3;
    public Jeu() throws IOException {
    	int index = 1;
    	for (int i = 0; i < rows; i++) {
    		for (int j = 0; j < cols; j++) {
    			figures[i][j].setDescription(""+index++);
    		}
    	}
    }
    
    public ImageIcon[][] loadImages() throws IOException {
        ImageIcon[][] images = ResourceUtility.splitImageIcon(ResourceUtility.loadBufferedImage("Image/butterfly2.png"), rows, cols);
		return images;
        
    }

	public LinkedList<ImageIcon> creerPioche() {
			LinkedList<ImageIcon> list = new LinkedList<>();
			for (int k = 0; k < 2; k++) {
				for (int i = 0; i < rows ; i++) {
					for (int j = 0; j < cols; j++) {
						list.push(figures[i][j]);
					}
				}	
			}
				
			Collections.shuffle(list);
		return list;
	}

    

}