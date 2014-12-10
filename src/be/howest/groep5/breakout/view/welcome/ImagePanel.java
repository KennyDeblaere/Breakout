package be.howest.groep5.breakout.view.welcome;

/**
 * Created by Blackhat on 5/12/2014.
 */
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class ImagePanel extends JPanel{

    private BufferedImage image;

    public ImagePanel() {
        try {
            image = ImageIO.read(new File("src\\be\\howest\\groep5\\breakout\\Pictures\\Icon.jpg"));
        } catch (IOException ex) {
            System.out.println("Foto kan niet worden ingeladen...");
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(image, 0, 0, null); // see javadoc for more info on the parameters
    }

}