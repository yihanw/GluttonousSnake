import java.awt.Color;
import javax.swing.JPanel;

public class SquarePanel extends JPanel{
	
	private static final long serialVersionUID = 1L;

	public SquarePanel(Color myColor){
		this.setBackground(myColor);
	}
	
	public void ChangeColor(Color myColor){
		this.setBackground(myColor);
		this.repaint();
	}
	
}