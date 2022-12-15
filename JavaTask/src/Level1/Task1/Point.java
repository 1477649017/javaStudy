package Level1.Task1;
import java.util.Scanner;
public class Point {
    public int x;
    public int y;

    public Point(int x, int y){
        this.x = x;
        this.y = y;
    }
    //展示对象坐标值信息
    public void showPoint(){
        System.out.println("(" + this.x + "," + this.y +")");
    }

    public static Point getMiddle(Point p1, Point p2){
        //求取中点坐标值
        int x = (p1.x + p2.x) / 2;
        int y = (p1.y + p2.y) / 2;
        return new Point(x, y);
    }

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入第一个点的坐标：");
        int x1 = scanner.nextInt();
        int y1 = scanner.nextInt();
        Point p1 = new Point(x1, y1);
        System.out.println("请输入第二个点的坐标：");
        int x2 = scanner.nextInt();
        int y2 = scanner.nextInt();
        Point p2 = new Point(x2, y2);
        System.out.println("第一个点的坐标：");
        p1.showPoint();
        System.out.println("第二个点的坐标：");
        p2.showPoint();
        System.out.println("两点构成的线段的中点的坐标：");
        Point middle = getMiddle(p1, p2);
        middle.showPoint();
    }
}
