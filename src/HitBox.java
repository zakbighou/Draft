import java.awt.*;


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

    public int getY() {
        return (int) y;
    }

    public int getX() {
        return (int) x;
    }
}