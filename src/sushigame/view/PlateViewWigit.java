package sushigame.view;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import comp401sushi.IngredientPortion;
import comp401sushi.Plate;
import sushigame.model.Belt;

import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class PlateViewWigit extends JPanel implements MouseListener{
	private Belt belt;
	private JLabel type;
	private JLabel chef;
	private JLabel color;
	private JLabel ingredients;
	private JLabel name;
	private JLabel age;
	private JFrame frame;
	private String stuff;
	private JOptionPane pane;
	private String information;
	private JLabel label;
	
	

	public PlateViewWigit(Belt belt) {
		label = new JLabel();
		this.belt = belt;
		type = new JLabel();
		chef = new JLabel();
		color = new JLabel();
		ingredients = new JLabel();
		name = new JLabel();
		age = new JLabel();
		
		stuff = "<html>";
		information = "<html>";
		addMouseListener(this);
		add(label);
		setLayout(new GridLayout(1,1));
		this.frame = new JFrame();
	}
	
	public void setInfo(Plate p, int i) {
		color.setText(p.getColor().toString());
		type.setText(p.getContents().getClass().toString());
		chef.setText(p.getChef().getName());
		name.setText(p.getContents().getName());
		IngredientPortion[] portions = p.getContents().getIngredients();
		String[] strings = new String[portions.length];
		for (int j = 0; j < portions.length; j++) {
			strings[j] = portions[j].getName() + ", " + portions[j].getAmount() + " ounces";
		}
		for (int j = 0; j < strings.length; j++) {
			stuff = "<html>" + strings[j] + "<br>" + "</html>";
		}
		ingredients.setText(stuff);
		Integer holder;
		holder = belt.getAgeOfPlateAtPosition(i);
		age.setText(holder + " rotation");
		information = "<html>" + color.getText() + "<br>" + type.getText() + "<br>" + chef.getText() + "<br>" + name.getText() + "<br>" + age.getText() + "<br>" + ingredients.getText() + "</html>";
		pane = new JOptionPane(information);
		
		label.setText(chef.getText() + "'s " + name.getText());
	}
	
	public void clearLabels() {
		label.setText("");
		color.setText("");
		type.setText("");
		name.setText("");
		ingredients.setText("");
		chef.setText("");
		age.setText("");
		information = "<html>";
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		pane.showMessageDialog(frame, information);
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}
