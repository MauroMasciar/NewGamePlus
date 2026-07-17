package ui;

import app.Main;
import controller.PlayingController;
import model.Games;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JTextField;
import javax.swing.JPanel;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GamesList extends JInternalFrame implements ActionListener {
	private static final long serialVersionUID = 6376047769180646261L;
	JDesktopPane desktopPane;
	
	// Panel ListGames
	private JTextField txtSearchGame = new JTextField();
	private JLabel lblMyGames = new JLabel("Mis juegos");
	private JButton btnFilter = new JButton("F"); //TO DO: poner icono de filtro
	private JButton btnLaunch = new JButton("Lanzar");
	private JList<Games> jlistGames = new JList<>();
	private DefaultListModel<Games> model = new DefaultListModel<>();
	
	
	public GamesList(JDesktopPane desktopPane) {
		this.desktopPane = desktopPane;
		setSize(800, 600);
		GridBagConstraints gbcListGames = new GridBagConstraints();
		JPanel pnlListGames = new JPanel();
		jlistGames.setModel(model);
		jlistGames.setCellRenderer(new GameRenderer());
		
		for(Games game : Main.gameRepository.games_list) {
			model.addElement(game);
		}

		pnlListGames.setLayout(new FlowLayout());
		pnlListGames.add(btnLaunch);
		pnlListGames.add(jlistGames);

		add(pnlListGames);

		btnLaunch.addActionListener(this);
		
		//pack();
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == btnLaunch) {
			try {
				@SuppressWarnings("unused")
				PlayingController pc = new PlayingController(jlistGames.getSelectedValue(), desktopPane);
			} catch (NullPointerException ex) {
				ex.printStackTrace();
			}
		}
	}
}