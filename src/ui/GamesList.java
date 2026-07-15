package ui;

import app.Main;
import model.Game;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JPanel;
import java.awt.GridBagConstraints;

public class GamesList extends JInternalFrame {
	private static final long serialVersionUID = 6376047769180646261L;
	
	// Panel ListGames
	private JTextField txtSearchGame = new JTextField();
	private JLabel lblMyGames = new JLabel("Mis juegos");
	private JButton btnFilter = new JButton("F"); //TO DO: poner icono de filtro
	private JList<Game> jlistGames = new JList<>();
	private DefaultListModel<Game> model = new DefaultListModel<>();
	
	
	public GamesList() {
		setSize(800, 600);
		GridBagConstraints gbcListGames = new GridBagConstraints();
		JPanel pnlListGames = new JPanel();
		jlistGames.setModel(model);
		jlistGames.setCellRenderer(new GameRenderer());
		
		for(Game game : Main.repository.games_list) {
			model.addElement(game);
		}

		add(jlistGames);
		//pack();
		setVisible(true);
	}
}