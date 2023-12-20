import java.awt.image.BufferedImage;
public class TileManager {

        private final int height;
        private final int width;

        // Constructeur
        public TileManager(int height, int width) {
            this.height = height;
            this.width = width;
            // Ajoutez ici la logique de chargement des tuiles si nécessaire
        }

        // Getter pour la hauteur
        public int getHeight() {
            return height;
        }

        // Getter pour la largeur
        public int getWidth() {
            return width;
        }


    }

