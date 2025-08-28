
import java.awt.Graphics;

import java.awt.LayoutManager;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class ImagePanel extends JPanel {
    private final ImageIcon backgroundIcon;

    public ImagePanel(ImageIcon icon, LayoutManager layout) {
        super(layout);
        this.backgroundIcon = icon;
        setOpaque(false);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (backgroundIcon != null) {
            g.drawImage(backgroundIcon.getImage(), 0, 0, getWidth(), getHeight(), this);
        }
    }
}
