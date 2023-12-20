public class Hero extends DynamicThings {
    private static Hero instance;

    private Hero(int x, int y, int width, int height, double speedX, double speedY) {
        super(x, y, width, height, (int) speedX, (int) speedY);
    }
    public static Hero getInstance(int x, int y, int width, int height, double speedX, double speedY) {
        if (instance == null) {
            instance = new Hero(x, y, width, height, speedX, speedY);
        }
        return instance;
    }
    public static void main(String[] args) {
        // Créer une instance du héros
        Hero hero1 = Hero.getInstance(0, 0, 30, 30, 2.0, 2.0);

        // Essayez de créer une deuxième instance du héros (cela devrait renvoyer la même instance)
        Hero hero2 = Hero.getInstance(0, 0, 30, 30, 2.0, 2.0);

        // Vérifier si ce sont les mêmes instances
        System.out.println(hero1 == hero2);  // Cela devrait afficher true si les 2 instances pointent vers le même objet, false sinon
    }

    // Ajoutez les méthodes spécifiques au héros si nécessaire
}
