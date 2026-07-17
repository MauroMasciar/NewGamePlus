package ui;

import model.Games;
import util.Utils;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.ListCellRenderer;

public class GameRenderer extends JPanel implements ListCellRenderer<Games> {
	private static final long serialVersionUID = 7936054548862174386L;
	private JLabel lblIcon = new JLabel();
	private JLabel lblName = new JLabel();
	private JLabel lblTime = new JLabel();
	
	public GameRenderer() {
		setLayout(new BorderLayout(10, 10));
		JPanel text = new JPanel();
		text.setLayout(new BoxLayout(text, BoxLayout.Y_AXIS));
		lblName.setFont(new Font("Segoe UI", Font.BOLD, 15));
		lblTime.setFont(new Font("Segoe UI", Font.PLAIN, 12));

		text.add(lblName);
		text.add(lblTime);

        add(lblIcon, BorderLayout.WEST);
        add(text, BorderLayout.CENTER);
        setOpaque(true);
        text.setOpaque(false);
	}

	@Override
	public Component getListCellRendererComponent(JList<? extends Games> list, Games game, int index, boolean selected, boolean hasFocus) {
		lblName.setText(game.getName());
		lblTime.setText(Utils.getTotalHoursFromSeconds((int)game.getTimePlayed(),false));

        if(selected) {
            setBackground(new Color(35,92,180));
        } else {
            setBackground(list.getBackground());
        }

        return this;
    }
}