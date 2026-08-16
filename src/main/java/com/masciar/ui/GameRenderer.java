package com.masciar.ui;

import com.masciar.model.Game;
import com.masciar.service.HistoryService;
import com.masciar.util.DateUtils;
import com.masciar.util.TimeUtils;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.ListCellRenderer;

public class GameRenderer extends JPanel implements ListCellRenderer<Game> {
	private JLabel lblIcon = new JLabel();
	private JLabel lblName = new JLabel();
	private JLabel lblInfo = new JLabel();

	public GameRenderer() {
		setLayout(new BorderLayout(10, 10));
		JPanel text = new JPanel();
		text.setLayout(new BoxLayout(text, BoxLayout.Y_AXIS));
		lblName.setFont(new Font("Segoe UI", Font.BOLD, 15));
		lblInfo.setFont(new Font("Segoe UI", Font.PLAIN, 12));

		text.add(lblName);
		text.add(lblInfo);

		add(lblIcon, BorderLayout.WEST);
		add(text, BorderLayout.CENTER);
		setOpaque(true);
		text.setOpaque(false);
	}

	@Override
	public Component getListCellRendererComponent(JList<? extends Game> list, Game game, int index, boolean selected,
			boolean hasFocus) {
		HistoryService historyService = new HistoryService();
		lblName.setText(game.getName());
		String lastSessionDate = DateUtils.formatDateFromString(game.getLastPlayed(), 2);
		if (!lastSessionDate.equals("01/01/1900"))
			lblInfo.setText(TimeUtils.getTotalHoursFromSeconds((int) game.getTimePlayed(), false) + " | " + lastSessionDate
					+ " | ("
					+ TimeUtils.getTotalHoursFromSeconds(historyService.getLastSessionTimeFromGame(game.getId()), false)
					+ ")");
		else
			lblInfo.setText(TimeUtils.getTotalHoursFromSeconds((int) game.getTimePlayed(), false));

		if (selected) {
			setBackground(new Color(35, 92, 180));
		} else {
			setBackground(list.getBackground());
		}
		
		return this;
	}
}