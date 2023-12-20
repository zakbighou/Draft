import java.awt.*;
import java.awt.image.BufferedImage;

public class HitBox {
    private double x;
    private double y;
    private double width;
    private double height;

    // Constructeur
    public HitBox(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    // Méthode pour vérifier l'intersection avec une autre HitBox
    public boolean intersect(HitBox anotherHitBox) {
        double xOverlap = Math.min(x + width, anotherHitBox.x + anotherHitBox.width) - Math.max(x, anotherHitBox.x);
        double yOverlap = Math.min(y + height, anotherHitBox.y + anotherHitBox.height) - Math.max(y, anotherHitBox.y);

        return xOverlap > 0 && yOverlap > 0;
    }


    public static void main(String[] args) {
        HitBox hitBox1 = new HitBox(0, 0, 4, 10);
        HitBox hitBox2 = new HitBox(5, -5, 10, 10);

        boolean intersection = hitBox1.intersect(hitBox2);

        System.out.println("Les rectangles se touchent : " + hitBox1.intersect(hitBox2));
        System.out.println("Les rectangles se touchent : " + hitBox2.intersect(hitBox1));
    }

    private static boolean checkIntersection(Rectangle rect1, Rectangle rect2) {
        return rect1.intersects(rect2);


    }


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

        // Ajoutez ici d'autres méthodes nécessaires pour charger et accéder aux images des tuiles
    }
    public class Dungeon {
        private final char[][] dungeonArray;
        private final int height;
        private final int width;
        private final TileManager tileManager;

        // Constructeur
        public Dungeon(int height, int width, TileManager tileManager) {
            this.height = height;
            this.width = width;
            this.tileManager = tileManager;

            // Initialisation du tableau du donjon
            dungeonArray = new char[height][width];
            initializeDungeonArray();
        }

        // Méthode d'initialisation du tableau du donjon
        private void initializeDungeonArray() {
            for (int i = 0; i < height; i++) {
                for (int j = 0; j < width; j++) {
                    // Mettre 'W' aux bords et ' ' à l'intérieur
                    if (i == 0 || i == height - 1 || j == 0 || j == width - 1) {
                        dungeonArray[i][j] = 'W';
                    } else {
                        dungeonArray[i][j] = ' ';
                    }
                }
            }
        }

        // Méthode d'affichage du donjon dans la console avec la position du héros
        public void displayDungeonInConsole(HitBox hero) {
            for (int i = 0; i < height; i++) {
                for (int j = 0; j < width; j++) {
                    // Mettre 'H' à la position du héros
                    if (isHeroPosition(hero, i, j)) {
                        System.out.print("H");
                    } else {
                        System.out.print(dungeonArray[i][j]);
                    }
                }
                System.out.println(); // Nouvelle ligne après chaque ligne du donjon
            }
        }

        // Méthode pour vérifier si la position correspond à celle du héros
        private boolean isHeroPosition(HitBox hero, int row, int col) {
            int tileHeight = tileManager.getHeight();
            int tileWidth = tileManager.getWidth();

            // Calculer la position du héros dans le tableau du donjon
            int heroRow = hero.getY() / tileHeight;
            int heroCol = hero.getX() / tileWidth;

            return row == heroRow && col == heroCol;
        }
    }

    private int getY() {
    }

    public class AnimatedThings extends Things {
        // Ajoutez ici les attributs spécifiques à l'animation
        public AnimatedThings(int x, int y, int width, int height) {
            super(x, y, width, height);
            // Initialisation des attributs spécifiques à l'animation
        }
        // Ajoutez ici les méthodes spécifiques à l'animation
    }
    public class Things {
        private int x;
        private int y;
        private int width;
        private int height;

        public Things(int x, int y, int width, int height) {
        }
        // Constructeur    public Things(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

}

