package core;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class Map extends JPanel {
	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		Graphics2D g2d = (Graphics2D) g;

		g2d.setColor(Color.blue);

		
    BufferedImage img = null;
    try {
        img = ImageIO.read(new File("background.jpg"));
    } catch (IOException e) {
    }
    ImageObserver observer = null;
	g2d.drawImage(img, 0, 0, observer);

		 
		for(int i = 0; i<=40;i++){
			Data.X_Coordinates[i]=(Data.getCountryCoord()[i][0]);
			Data.Y_Coordinates[i]=(Data.getCountryCoord()[i][1]);

		}
		for (int i = 0; i <= 40; i++) {
			Dimension size = getSize();
			int w = size.width ;
			int h = size.height;

			g2d.setColor(Color.BLUE);
			int x = Data.X_Coordinates[i] % w;
			int y = Data.Y_Coordinates[i] % h;
			
			g2d.draw3DRect(x, y-10, 5, 5, true);



			switch (Data.CONTINENT_IDS[i]){
			case 0:g2d.setColor(Color.RED) ;
			break;
			case 1:g2d.setColor(Color.GREEN) ;
			break;
			case 2:g2d.setColor(Color.CYAN) ;
			break;
			case 3:g2d.setColor(Color.ORANGE) ;
			break;
			case 4:g2d.setColor(Color.GRAY) ;
			break;
			case 5:g2d.setColor(Color.MAGENTA) ;
			break;
			}
			if (i>0){
				if (Data.CONTINENT_IDS[i] == Data.CONTINENT_IDS[i-1]){
					g2d.drawLine(Data.X_Coordinates[i-1], Data.Y_Coordinates[i-1]-10, Data.X_Coordinates[i], Data.Y_Coordinates[i]-10);
				}
			}	

			
			
			
			
			g.setFont(new Font("default", Font.BOLD, 12));
			
			if (Data.COUNTRY_NAMES[i].compareTo("E Australia") == 0 || Data.COUNTRY_NAMES[i].compareTo("W Australia") == 0){
				g2d.drawString(Data.COUNTRY_NAMES[i], x-70, y+2);
			}
			
			else if (Data.COUNTRY_NAMES[i].compareTo("New Guinea") == 0){
				g2d.drawString(Data.COUNTRY_NAMES[i], x-30, y-10);
			}
			else{
			g2d.drawString(Data.COUNTRY_NAMES[i], x+8, y+2);
			}
			//g2d.drawPolyline(CONTINENT_VALUES, CONTINENT_VALUES, 6);
			
			


		}

	}
}
