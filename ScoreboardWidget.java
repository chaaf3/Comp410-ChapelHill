package sushigame.view;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.Comparator;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.SwingConstants;

import sushigame.model.Belt;
import sushigame.model.BeltEvent;
import sushigame.model.BeltObserver;
import sushigame.model.Chef;
import sushigame.model.SushiGameModel;

public class ScoreboardWidget extends JPanel implements BeltObserver, ActionListener {

	private SushiGameModel game_model;
	private JLabel display;
	private JRadioButton sortByConsumed;
	private JRadioButton sortByBallance;
	private JRadioButton sortBySpoiled;
	private JPanel options;
	private JButton sortButton;
	private ButtonGroup choices;
	
	public ScoreboardWidget(SushiGameModel gm) {
		game_model = gm;
		game_model.getBelt().registerBeltObserver(this);
		
		display = new JLabel();
		display.setVerticalAlignment(SwingConstants.TOP);
		setLayout(new BorderLayout());
		add(display, BorderLayout.CENTER);
		display.setText(makeScoreboardHTML());
		options = new JPanel();
		choices = new ButtonGroup();
		sortByConsumed = new JRadioButton("sort by consumed", true);
		sortByBallance = new JRadioButton("sort by ballance", false);
		sortBySpoiled = new JRadioButton("sort by Spoiled", false);
		sortButton = new JButton("sort");
		sortByConsumed.addActionListener(this);
		sortByBallance.addActionListener(this);
		sortBySpoiled.addActionListener(this);
		sortButton.addActionListener(this);
		choices.add(sortByConsumed);
		choices.add(sortByBallance);
		choices.add(sortBySpoiled);
		options.setLayout(new GridLayout(1, 4));
		options.add(sortByConsumed);
		options.add(sortByBallance);
		options.add(sortBySpoiled);
		options.add(sortButton);
		add(options, BorderLayout.PAGE_END);
	}

	private String makeScoreboardHTML() {
		String sb_html = "<html>";
		sb_html += "<h1>Scoreboard</h1>";

		// Create an array of all chefs and sort by balance.
		Chef[] opponent_chefs= game_model.getOpponentChefs();
		Chef[] chefs = new Chef[opponent_chefs.length+1];
		chefs[0] = game_model.getPlayerChef();
		for (int i=1; i<chefs.length; i++) {
			chefs[i] = opponent_chefs[i-1];
		}
		
//		if(sortByBallance.isSelected()) {
//			
//			Arrays.sort(chefs, new HighToLowBalanceComparator());
//		
//			for (Chef c : chefs) {
//				sb_html += c.getName() + " ($" + Math.round(c.getBalance()*100.0)/100.0 + ") <br>";
//			}
//		} else if (sortByConsumed.isSelected()) {
//			Arrays.sort(chefs, new HighToLowConsumedAmountComparator());
//			
//			for (Chef c : chefs) {
//				sb_html += c.getName() + " (Ounces " + Math.round(c.getConsumedAmount()*100.0)/100.0 + ") <br>";
//			}
//		} else if(sortBySpoiled.isSelected()) {
//			Arrays.sort(chefs, new LowToHighSpoiledAmountComparator());
//			
//			for (Chef c : chefs) {
//				sb_html += c.getName() + " (Ounces " + Math.round(c.getSpoiledAmount()*100.0)/100.0 + ") <br>";
//			}
//		}
		return sb_html;
	}

	public void refresh() {
		display.setText(makeScoreboardHTML());		
	}
	
	@Override
	public void handleBeltEvent(BeltEvent e) {
		if (e.getType() == BeltEvent.EventType.ROTATE) {
			refresh();
		}		
	}
	public void actionPerformed(ActionEvent event) {
		refresh();
	}

}
