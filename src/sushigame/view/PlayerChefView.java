package sushigame.view;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSlider;
import javax.swing.JTextField;

import comp401sushi.AvocadoPortion;
import comp401sushi.EelPortion;
import comp401sushi.IngredientPortion;
import comp401sushi.Nigiri;
import comp401sushi.Plate;
import comp401sushi.RedPlate;
import comp401sushi.Roll;
import comp401sushi.Sashimi;
import comp401sushi.SeaweedPortion;
import comp401sushi.Sushi;
import comp401sushi.*;

public class PlayerChefView extends JPanel implements ActionListener {

	private List<ChefViewListener> listeners;
	private Sushi kmp_roll;
	private Sushi crab_sashimi;
	private Sushi eel_nigiri;
	private int belt_size;
	private JSlider goldPrice;
	private JSlider placement;
	private JSlider avocado;
	private JSlider crab;
	private JSlider eel;
	private JSlider rice;
	private JSlider seaweed;
	private JSlider shrimp;
	private JSlider tuna;
	private JSlider yellowtail;
	private JRadioButton redButton;
	private JRadioButton greenButton;
	private JRadioButton blueButton;
	private JRadioButton goldButton;
	private JRadioButton tunaButton;
	private JRadioButton yellowTailButton;
	private JRadioButton eelButton;
	private JRadioButton crabButton;
	private JRadioButton shrimpButton;
	private JRadioButton sashimiButton;
	private JRadioButton nigiriButton;
	private JRadioButton rollButton;
	private JButton makeSushi;
	private JPanel colorPanel;
	private JPanel flavorPanel;
	private JPanel typePanel;
	private JTextField name;
	private ButtonGroup colors;
	private ButtonGroup flavors;
	private ButtonGroup types;
	
	
	public PlayerChefView(int belt_size) {
		this.belt_size = belt_size;
		listeners = new ArrayList<ChefViewListener>();

		setLayout(new GridLayout(0,2));
		
		redButton = new JRadioButton("Red");
		greenButton = new JRadioButton("Green");
		blueButton = new JRadioButton("Blue");
		goldButton = new JRadioButton("Gold");
		tunaButton = new JRadioButton("Tuna");
		yellowTailButton = new JRadioButton("YellowTail");
		eelButton = new JRadioButton("Eel");
		crabButton = new JRadioButton("Crab");
		shrimpButton = new JRadioButton("Shrimp");
		sashimiButton = new JRadioButton("Sashimi");
		nigiriButton = new JRadioButton("Nigiri");
		rollButton = new JRadioButton("Roll");
		
		colorPanel = new JPanel();
		
		colors = new ButtonGroup();
		colors.add(redButton);
		colors.add(greenButton);
		colors.add(blueButton);
		colors.add(goldButton);
		
		colorPanel.setLayout(new GridLayout(1,4));
		colorPanel.add(redButton);
		colorPanel.add(greenButton);
		colorPanel.add(blueButton);
		colorPanel.add(goldButton);
		
		add(new JLabel("Select plate color: "));
		add(colorPanel);
		
		types = new ButtonGroup();
		types.add(sashimiButton);
		types.add(nigiriButton);
		types.add(rollButton);
		
		typePanel = new JPanel();
		
		typePanel.setLayout(new GridLayout(1,2));
		
		typePanel.add(sashimiButton);
		typePanel.add(nigiriButton);
		typePanel.add(rollButton);
		
		add(new JLabel("Select type of sushi: "));
		add(typePanel);
		
		flavors = new ButtonGroup();
		flavors.add(tunaButton);
		flavors.add(yellowTailButton);
		flavors.add(eelButton);
		flavors.add(crabButton);
		flavors.add(shrimpButton);
		
		flavorPanel = new JPanel();
		
		flavorPanel.setLayout(new GridLayout(1,5));
		flavorPanel.add(tunaButton);
		flavorPanel.add(yellowTailButton);
		flavorPanel.add(eelButton);
		flavorPanel.add(crabButton);
		flavorPanel.add(shrimpButton);
		
		add(new JLabel("If Sashimi or Nigiri, select flavor: "));
		add(flavorPanel);
		
		add(new JLabel("Choose the amount"));
		add(new JLabel("<html><body><br></body></html>"));
		add(new JLabel("avocado"));
		avocado = new JSlider(JSlider.HORIZONTAL, 0, 150, 0);
		avocado.setPaintLabels(true);
		Hashtable<Integer, JLabel> avocadoSlider = new Hashtable();
		avocadoSlider.put(new Integer(0), new JLabel("0.00oz"));
		avocadoSlider.put(new Integer(30), new JLabel("0.30oz"));
		avocadoSlider.put(new Integer(60), new JLabel("0.60oz"));
		avocadoSlider.put(new Integer(90), new JLabel("0.90oz"));
		avocadoSlider.put(new Integer(120), new JLabel("1.20oz"));
		avocadoSlider.put(new Integer(150), new JLabel("1.50oz"));
		avocado.setLabelTable(avocadoSlider);
		add(avocado);
		
		add(new JLabel("crab"));
		crab = new JSlider(JSlider.HORIZONTAL, 0, 150, 0);
		crab.setPaintLabels(true);
		Hashtable<Integer, JLabel> crabSlider = new Hashtable();
		crabSlider.put(new Integer(0), new JLabel("0.00oz"));
		crabSlider.put(new Integer(30), new JLabel("0.30oz"));
		crabSlider.put(new Integer(60), new JLabel("0.60oz"));
		crabSlider.put(new Integer(90), new JLabel("0.90oz"));
		crabSlider.put(new Integer(120), new JLabel("1.20oz"));
		crabSlider.put(new Integer(150), new JLabel("1.50oz"));
		crab.setLabelTable(crabSlider);
		add(crab);
		
		add(new JLabel("eel"));
		eel = new JSlider(JSlider.HORIZONTAL, 0, 150, 0);
		eel.setPaintLabels(true);
		Hashtable<Integer, JLabel> eelSlider = new Hashtable();
		eelSlider.put(new Integer(0), new JLabel("0.00oz"));
		eelSlider.put(new Integer(30), new JLabel("0.30oz"));
		eelSlider.put(new Integer(60), new JLabel("0.60oz"));
		eelSlider.put(new Integer(90), new JLabel("0.90oz"));
		eelSlider.put(new Integer(120), new JLabel("1.20oz"));
		eelSlider.put(new Integer(150), new JLabel("1.50oz"));
		eel.setLabelTable(eelSlider);
		add(eel);
		
		add(new JLabel("shrimp"));
		shrimp = new JSlider(JSlider.HORIZONTAL, 0, 150, 0);
		shrimp.setPaintLabels(true);
		Hashtable<Integer, JLabel> shrimpSlider = new Hashtable();
		shrimpSlider.put(new Integer(0), new JLabel("0.00oz"));
		shrimpSlider.put(new Integer(30), new JLabel("0.30oz"));
		shrimpSlider.put(new Integer(60), new JLabel("0.60oz"));
		shrimpSlider.put(new Integer(90), new JLabel("0.90oz"));
		shrimpSlider.put(new Integer(120), new JLabel("1.20oz"));
		shrimpSlider.put(new Integer(150), new JLabel("1.50oz"));
		shrimp.setLabelTable(shrimpSlider);
		add(shrimp);
		
		add(new JLabel("yellowTail"));
		yellowtail = new JSlider(JSlider.HORIZONTAL, 0, 150, 0);
		yellowtail.setPaintLabels(true);
		Hashtable<Integer, JLabel> yellowtailSlider = new Hashtable();
		yellowtailSlider.put(new Integer(0), new JLabel("0.00oz"));
		yellowtailSlider.put(new Integer(30), new JLabel("0.30oz"));
		yellowtailSlider.put(new Integer(60), new JLabel("0.60oz"));
		yellowtailSlider.put(new Integer(90), new JLabel("0.90oz"));
		yellowtailSlider.put(new Integer(120), new JLabel("1.20oz"));
		yellowtailSlider.put(new Integer(150), new JLabel("1.50oz"));
		yellowtail.setLabelTable(yellowtailSlider);
		add(yellowtail);
		
		add(new JLabel("tuna"));
		tuna = new JSlider(JSlider.HORIZONTAL, 0, 150, 0);
		tuna.setPaintLabels(true);
		Hashtable<Integer, JLabel> tunaSlider = new Hashtable();
		tunaSlider.put(new Integer(0), new JLabel("0.00oz"));
		tunaSlider.put(new Integer(30), new JLabel("0.30oz"));
		tunaSlider.put(new Integer(60), new JLabel("0.60oz"));
		tunaSlider.put(new Integer(90), new JLabel("0.90oz"));
		tunaSlider.put(new Integer(120), new JLabel("1.20oz"));
		tunaSlider.put(new Integer(150), new JLabel("1.50oz"));
		tuna.setLabelTable(tunaSlider);
		add(tuna);
		
		add(new JLabel("rice"));
		rice = new JSlider(JSlider.HORIZONTAL, 0, 150, 0);
		rice.setPaintLabels(true);
		Hashtable<Integer, JLabel> riceSlider = new Hashtable();
		riceSlider.put(new Integer(0), new JLabel("0.00oz"));
		riceSlider.put(new Integer(30), new JLabel("0.30oz"));
		riceSlider.put(new Integer(60), new JLabel("0.60oz"));
		riceSlider.put(new Integer(90), new JLabel("0.90oz"));
		riceSlider.put(new Integer(120), new JLabel("1.20oz"));
		riceSlider.put(new Integer(150), new JLabel("1.50oz"));
		rice.setLabelTable(riceSlider);
		add(rice);
		
		add(new JLabel("seaweed"));
		seaweed = new JSlider(JSlider.HORIZONTAL, 0, 150, 0);
		seaweed.setPaintLabels(true);
		Hashtable<Integer, JLabel> seaweedSlider = new Hashtable();
		seaweedSlider.put(new Integer(0), new JLabel("0.00oz"));
		seaweedSlider.put(new Integer(30), new JLabel("0.30oz"));
		seaweedSlider.put(new Integer(60), new JLabel("0.60oz"));
		seaweedSlider.put(new Integer(90), new JLabel("0.90oz"));
		seaweedSlider.put(new Integer(120), new JLabel("1.20oz"));
		seaweedSlider.put(new Integer(150), new JLabel("1.50oz"));
		seaweed.setLabelTable(seaweedSlider);
		add(seaweed);
		
		add(new JLabel("goldPrice"));
		goldPrice = new JSlider(JSlider.HORIZONTAL, 500, 1000, 500);
		goldPrice.setPaintLabels(true);
		Hashtable<Integer, JLabel> goldPriceSlider = new Hashtable();
		goldPriceSlider.put(new Integer(500), new JLabel("$5"));
		goldPriceSlider.put(new Integer(1000), new JLabel("$10"));
		goldPrice.setLabelTable(goldPriceSlider);
		add(goldPrice);
		goldPrice.setSnapToTicks(true);
		
		add(new JLabel("placement"));
		placement = new JSlider(JSlider.HORIZONTAL, 0, belt_size, 0);
		placement.setPaintLabels(true);
		Hashtable<Integer, JLabel> placementSlider = new Hashtable();
		placementSlider.put(new Integer(0), new JLabel("0"));
		placementSlider.put(new Integer(belt_size), new JLabel(""));
		placementSlider.put(new Integer(belt_size / 2), new JLabel(new Integer(belt_size/2).toString()));
		placementSlider.put(new Integer(belt_size), new JLabel(new Integer(belt_size).toString()));
		placement.setLabelTable(placementSlider);
		add(placement);
		placement.setSnapToTicks(true);
		
		
		add(new JLabel("Click here to make sushi"));
		makeSushi = new JButton("Make the Sushi");
		makeSushi.setActionCommand("make sushi");
		makeSushi.addActionListener(this);
		add(makeSushi);
		
		add(new JLabel("Enter name for roll"));
		name = new JTextField(15);
		add(name);
		name.addActionListener(this);
		
		kmp_roll = new Roll("KMP Roll", new IngredientPortion[] {new EelPortion(1.0), new AvocadoPortion(0.5), new SeaweedPortion(0.2)});
		crab_sashimi = new Sashimi(Sashimi.SashimiType.CRAB);
		eel_nigiri = new Nigiri(Nigiri.NigiriType.EEL);
		
	}

	public void registerChefListener(ChefViewListener cl) {
		listeners.add(cl);
	}

	private void makeRedPlateRequest(Sushi plate_sushi, int plate_position) {
		for (ChefViewListener l : listeners) {
			l.handleRedPlateRequest(plate_sushi, plate_position);
		}
	}

	private void makeGreenPlateRequest(Sushi plate_sushi, int plate_position) {
		for (ChefViewListener l : listeners) {
			l.handleGreenPlateRequest(plate_sushi, plate_position);
		}
	}

	private void makeBluePlateRequest(Sushi plate_sushi, int plate_position) {
		for (ChefViewListener l : listeners) {
			l.handleBluePlateRequest(plate_sushi, plate_position);
		}
	}
	
	private void makeGoldPlateRequest(Sushi plate_sushi, int plate_position, double price) {
		for (ChefViewListener l : listeners) {
			l.handleGoldPlateRequest(plate_sushi, plate_position, price);
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		switch (e.getActionCommand()) {
		case "make sushi":
			if(rollButton.isSelected()) {
				List<IngredientPortion> ingredients_list = new ArrayList<IngredientPortion>();
				if(((double) avocado.getValue()) / 100.0 > 0) {
					ingredients_list.add(new AvocadoPortion(avocado.getValue() / 100.0));
				}
				if(((double) crab.getValue()) / 100.0 > 0) {
					ingredients_list.add(new CrabPortion(crab.getValue() / 100.0));
				}
				if(((double) eel.getValue()) / 100.0 > 0) {
					ingredients_list.add(new EelPortion(eel.getValue() / 100.0));
				}
				if(((double) shrimp.getValue()) / 100.0 > 0) {
					ingredients_list.add(new ShrimpPortion(shrimp.getValue() / 100.0));
				}
				if(((double) tuna.getValue()) / 100.0 > 0) {
					ingredients_list.add(new TunaPortion(tuna.getValue() / 100.0));
				}
				if(((double) yellowtail.getValue()) / 100.0 > 0) {
					ingredients_list.add(new YellowtailPortion(yellowtail.getValue() / 100.0));
				}
				if(((double) rice.getValue()) / 100.0 > 0) {
					ingredients_list.add(new RicePortion(rice.getValue() / 100.0));
				}
				if(((double) seaweed.getValue()) / 100.0 > 0) {
					ingredients_list.add(new SeaweedPortion(seaweed.getValue() / 100.0));
				}
				IngredientPortion[] ings = new IngredientPortion[ingredients_list.size()];
				ings = ingredients_list.toArray(ings);
				Roll roll = new Roll(name.getText(), ings);
				if(redButton.isSelected()) {
					makeRedPlateRequest(roll, placement.getValue());
				} else if(greenButton.isSelected()) {
					makeGreenPlateRequest(roll, placement.getValue());
				} else if(blueButton.isSelected()) {
					makeBluePlateRequest(roll, placement.getValue());
				} else if(goldButton.isSelected()) {
					makeGoldPlateRequest(roll, placement.getValue(), goldPrice.getValue());
				}
				colors.clearSelection();
				flavors.clearSelection();
				types.clearSelection();
			} else if(sashimiButton.isSelected()) {
				Sashimi sashimi = null;
				if(tunaButton.isSelected()) {
					sashimi = new Sashimi(Sashimi.SashimiType.TUNA);
				} else if(crabButton.isSelected()) {
					sashimi = new Sashimi(Sashimi.SashimiType.CRAB);
				} else if(eelButton.isSelected()) {
					sashimi = new Sashimi(Sashimi.SashimiType.EEL);
				} else if(shrimpButton.isSelected()) {
					sashimi = new Sashimi(Sashimi.SashimiType.SHRIMP);
				} else if(yellowTailButton.isSelected()) {
					sashimi = new Sashimi(Sashimi.SashimiType.YELLOWTAIL);
				}
				
				if(redButton.isSelected()) {
					makeRedPlateRequest(sashimi, placement.getValue());
				} else if(greenButton.isSelected()) {
					makeGreenPlateRequest(sashimi, placement.getValue());
				} else if(blueButton.isSelected()) {
					makeBluePlateRequest(sashimi, placement.getValue());
				} else if(goldButton.isSelected()) {
					makeGoldPlateRequest(sashimi, placement.getValue(), goldPrice.getValue());
				}
				colors.clearSelection();
				flavors.clearSelection();
				types.clearSelection();
				
			} else if(nigiriButton.isSelected()) {
				Nigiri nigiri = null;
				if(tunaButton.isSelected()) {
					nigiri = new Nigiri(Nigiri.NigiriType.TUNA);
				} else if(crabButton.isSelected()) {
					nigiri = new Nigiri(Nigiri.NigiriType.CRAB);
				} else if(eelButton.isSelected()) {
					nigiri = new Nigiri(Nigiri.NigiriType.EEL);
				} else if(shrimpButton.isSelected()) {
					nigiri = new Nigiri(Nigiri.NigiriType.SHRIMP);
				} else if(yellowTailButton.isSelected()) {
					nigiri = new Nigiri(Nigiri.NigiriType.YELLOWTAIL);
				}
				
				if(redButton.isSelected()) {
					makeRedPlateRequest(nigiri, placement.getValue());
				} else if(greenButton.isSelected()) {
					makeGreenPlateRequest(nigiri, placement.getValue());
				} else if(blueButton.isSelected()) {
					makeBluePlateRequest(nigiri, placement.getValue());
				} else if(goldButton.isSelected()) {
					makeGoldPlateRequest(nigiri, placement.getValue(), goldPrice.getValue());
				}
				colors.clearSelection();
				flavors.clearSelection();
				types.clearSelection();
				
			}
		}
	}
}
	
