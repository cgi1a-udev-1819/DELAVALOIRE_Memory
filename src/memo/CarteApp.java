package memo;

import java.awt.Component;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.LinkedList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JToggleButton;
import javax.swing.SwingUtilities;



public class CarteApp extends FrameForDemoMaker {

    private ImageIcon dosCarte = ResourceUtility.loadImage("Image/dos.png");
	private EtatMemoire state = new EtatMemoire();
    private static final int ROW_COUNT = 4;
    private static final int COLUMN_COUNT = 6;
    private Jeu jeu = new Jeu();

    public CarteApp() throws IOException{
        super("Mémoire");
        setDefaultBounds(100,100,900,600);
    }

    @Override
    public void init(JFrame frame) {
    	Container cp = frame.getContentPane();
    	int rows = ROW_COUNT;
    	int cols = COLUMN_COUNT;
    	cp.setLayout(new GridLayout(rows, cols));

    	LinkedList<ImageIcon> pioche = jeu.creerPioche();
    	while(!pioche.isEmpty())
    	{
    		cp.add(createButton(pioche.pop()));
    	}
    	
    	
    }
    
    private Component createButton(ImageIcon pop) {
    	ImageIcon imageIcon = pop ; // Récupération depuis la pioche
    	JToggleButton button = new JToggleButton(dosCarte);
    	button.setSelectedIcon(imageIcon);
    	button.setDisabledIcon(imageIcon);
    	button.setDisabledSelectedIcon(imageIcon);
    	button.putClientProperty("carte", imageIcon.getDescription());

    	button.addActionListener(new ActionListener() {
    	  @Override
    	  public void actionPerformed(ActionEvent e) {
    		  state.nouveauBoutonSelectionne(button);
    	  }
    	});
    	return button;
	}

	public JComponent createButton(int rows, int cols) {
        JButton button = new JButton(dosCarte);
        return button;
    }
    
    public static void main(String[] args) throws IOException {
        CarteApp example = new CarteApp();
        SwingUtilities.invokeLater(example);
    }
}