package uaslp.objetos.parcial2.labs;

import java.lang.reflect.Modifier;
import java.util.LinkedList;
import java.util.List;

abstract class Figure{
   private static int figuresCreated;
   private final String name;

   protected Figure(String name){
       this.name = name;
       figuresCreated ++;
   }

   public abstract float getArea();

   public abstract float getPerimeter();

   public final String getName(){
       return name;
   }
   public static int getFiguresCreated(){
       return figuresCreated;
   }
}

class Circle extends Figure{

    private float radio;

    public Circle(){
        super("Circulo"); //Hace referencia a la clase
    /*
    Solamente se pude llamar como la primera
    instruccion en el contructor
    De la clase hijo
    */
    }

    public Circle(float radio){
        super("Circulo");
        this.radio = radio;
    }

    public float getArea(){
       return (float)(Math.PI * radio * radio);
   }
   public float getPerimeter(){
       return (float)(Math.PI * radio * 2);
   }
   //Alt+insert para set and get

    public float getRadio() {
        return radio;
    }

    public void setRadio(float radio) {
        this.radio = radio;
    }
}

class Rectangle extends Figure{
    private float base;
    private float height;

    public Rectangle(){
        super("Rectángulo");
    }

    public Rectangle(float base, float height){
        super("Rectángulo");

        this.base = base;
        this.height = height;
    }

    public float getArea(){
        return base * height;
    }
    public float getPerimeter(){
        return 2 * base + 2 * height;
    }

    public float getBase() {
        return base;
    }

    public void setBase(float base) {
        this.base = base;
    }

    public float getHeight() {
        return height;
    }

    public void setHeight(float height) {
        this.height = height;
    }
}

class Polygon extends Figure{

    private float apotema;
    private int sidesCount;
    private float sideLength;

    public Polygon(){
        super("Poligono");
    }

    public Polygon(float apotema, int sidesCount, float sideLength){
        super("Poligono");

        this.apotema = apotema;
        this.sideLength = sideLength;
        this.sidesCount = sidesCount;
    }

    public float getArea(){
        return getPerimeter() * apotema / 2;
    }
    public float getPerimeter(){
        return sidesCount * sideLength;
    }

    public float getApotema() {
        return apotema;
    }

    public void setApotema(float apotema) {
        this.apotema = apotema;
    }

    public int getSidesCount() {
        return sidesCount;
    }

    public void setSidesCount(int sidesCount) {
        this.sidesCount = sidesCount;
    }

    public float getSideLength() {
        return sideLength;
    }

    public void setSideLength(float sideLength) {
        this.sideLength = sideLength;
    }
}

public  class Main {

    public  static void main(String[] args) {
        //circlesTest();
        //rectanglesTest();
        //polygonTest();

        List<Figure> figureList = new LinkedList<>();

        figureList.add(new Polygon(4, 5, 6.3f));
        figureList.add(new Polygon(4.5f, 8, 3.9f));

        figureList.add(new Rectangle(4, 5));
        figureList.add(new Rectangle(4.5f, 9.6f));

        figureList.add(new Circle(5.3f));
        figureList.add(new Circle(10.6f));

        //POLIMORFISMO
        for(Figure figure: figureList){
            System.out.println(figure.getName() + ", Area: " + figure.getArea() + ", Perimetro: " + figure.getPerimeter());
        }

        if(Modifier.isAbstract(Figure.class.getModifiers())){
            System.out.println("Figure es abstracta");
        }

        System.out.println("Se generaron: " + Figure.getFiguresCreated() + " figuras");
    }
    /*Salida del programa:
    Polígono, Area: 63.0, Perímetro: 31.5
    Polígono, Area: 70.200005, Perímetro: 31.2
    Rectángulo, Area: 20.0, Perímetro: 18.0
    Rectángulo, Area: 43.2, Perímetro: 28.2
    Círculo, Area: 88.247345, Perímetro: 33.300884
    Círculo, Area: 352.98938, Perímetro: 66.60177
    Figure es abstracta
    Se generaron: 6 figuras
    */


    private static void polygonTest() {
        List<Polygon> polygonList = new LinkedList<>();

        //Renombrar Shif + fn + f6
        polygonList.add(new Polygon(4, 5, 6.3f));
        polygonList.add(new Polygon(4.5f, 8, 3.9f));

        for(Polygon polygon: polygonList){
            System.out.println(polygon.getName() + ", Area: " + polygon.getArea() + ", Perimetro: " + polygon.getPerimeter());
        }
    }

    private static void rectanglesTest() {
        List<Rectangle> rectangleList = new LinkedList<>();

        Rectangle rectangle1 = new Rectangle(4, 5);
        Rectangle rectangle2 = new Rectangle(4.5f, 9.6f);

        rectangleList.add(new Rectangle(4, 5));
        rectangleList.add(new Rectangle(4.5f, 9.6f));

        for(Rectangle rectangle: rectangleList){
            System.out.println(rectangle.getName() + ", Area: " + rectangle.getArea() + ", Perimetro: " + rectangle.getPerimeter());
        }
    }

    private static void circlesTest() {
        List<Circle> circleList = new LinkedList<>();

        Circle circle1 = new Circle();
        circle1.setRadio(5.3f); //5.3 es double, 5.3f es flotante

        Circle circle2 = new Circle(10.6f);

        circleList.add(circle1);
        circleList.add(circle2);

        for(Circle circle: circleList){
            System.out.println(circle.getName() + ", Area: " + circle.getArea() + ", Perimetro: " + circle.getPerimeter());
        }
    }
}
