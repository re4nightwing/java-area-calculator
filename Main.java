import java.util.Scanner;
public class Main
{
	public static void main(String[] args) {
	    Scanner userIn = new Scanner(System.in);
        while(true){
		    System.out.println("What would you like to do? Enter the number.");
		    System.out.println(" 1.Circle \n 2.Square \n 3.Triangle \n 4.Rectangle\n 5.Quit");
		    System.out.print("Enter Your selection: ");

            int userSelection = userIn.nextInt();
            
            if(userSelection >= 1 & userSelection <= 5){
                Shape shape = createShapeFromUserInput(userIn ,userSelection);
                if (shape != null) {
                    System.out.println("The area is equal to: " + String.valueOf(shape.getArea()));
                }
            } else{
               System.out.println("Invalid input.Try again!");
            }
		}
	}
	
	private static Shape createShapeFromUserInput(Scanner userInput, int userSelection) {
	    switch (userSelection) {
            case 1:
                double radius = askUserValue("radius", "Circle", userInput);

                return new Circle(radius);
            case 2:
                double sideLength = askUserValue("side length", "Square", userInput);

                return new Square(sideLength);
            case 3:
                double height = askUserValue("height", "Triangle", userInput);
                double base = askUserValue("base", "Triangle", userInput);

                return new Triangle(height, base);
            case 4:
                double length = askUserValue("length", "Rectangle", userInput);
                double width = askUserValue("width", "Rectangle", userInput);

                return new Rectangle(length, width);
            case 5:
                System.out.println("Quiting....");
                System.exit(0);
        }

        return null;
	}
	
	private static double askUserValue(String valueName, String userInput, Scanner userIn) {
        System.out.print(String.format("Please enter the %s of your %s: ", valueName, userInput.toString().toLowerCase()));

        return userIn.nextDouble();
    }
    
    private interface Shape {
        double getArea();
    }

    private static class Circle implements Shape {
        double radius;

        public Circle(double radius) {
            this.radius = radius;
        }

        @Override
        public double getArea() {
            return Math.PI * this.radius * this.radius;
        }
    }

    private static class Triangle implements Shape {
        double height;
        double base;

        public Triangle(double height, double base) {
            this.height = height;
            this.base = base;
        }

        @Override
        public double getArea() {
            return 0.5 * this.height * this.base;
        }
    }

    private static class Rectangle implements Shape {
        double length;
        double width;

        public Rectangle(double length, double width) {
            this.length = length;
            this.width = width;
        }

        @Override
        public double getArea() {
            return this.length * this.width;
        }
    }

    private static class Square extends Rectangle {
        public Square(double sideLength) {
            super(sideLength, sideLength);
        }
    }
}
