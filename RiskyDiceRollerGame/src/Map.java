/* This class holds the look of the game map and logic to update map tiles */
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.*;

public class Map extends JPanel{
    private 
    /* Other ints will be needed this is a proof of concept */
    final int backgroundTile = 0;
    final int landTile = 1;

    public void loadMap() {
        // a multidimensional array of tiles (1 represents a clickable tile, 0 represents a background tile)
        int[][] tileMap = {
            {1, 1, 1, 1, 0, 0, 0, 0, 1, 1, 1, 1, 0},
            {0, 1, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0},
            {0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 1, 1, 0}
        }; 
    }

    /* Takes in a single int and returns the corresponding map tile, will be useful to draw the different images from the above array */
    public String convertIntToFile(int mapTile){
        switch(mapTile){
            case 0:
            return "tileTest.jpg";
            case 1:
            return "File Name For 1";
            case 2:
            return "File Name For 2";
        }
        return null;
    }

    /*  */
    public void buildTile(int mapTile) {
        BufferedImage tile; // a single tile image
        String fileName = convertIntToFile(mapTile); // takes in the int from the multidimensional array and returns the name of the corresponding file
        try {
            tile = ImageIO.read(new File(fileName)); // turns the file into a usable image
            System.out.println(tile);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("This is an exception LMAO");
        }
    }

    /* This method handles changing a single image within the 2D array for dynamic repainting */
    public void updateTile(int row, int col, int newTile){

    }
}
