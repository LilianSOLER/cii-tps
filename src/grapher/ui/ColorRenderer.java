package grapher.ui;

import javax.swing.*;
import javax.swing.table.TableCellRenderer;
import java.awt.*;

public class ColorRenderer implements TableCellRenderer {
	@Override
	public Component getTableCellRendererComponent(JTable jTable, Object o, boolean b, boolean b1, int i, int i1) {
		JLabel label = new JLabel();
		label.setOpaque(true);
		label.setBackground((Color) o);
		return label;
	}
}
