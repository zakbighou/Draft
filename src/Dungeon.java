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

