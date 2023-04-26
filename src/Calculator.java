import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        insert_number();
    }
    public static void insert_number()
    {
        Scanner scanner = new Scanner(System.in);

        System.out.print("insert an operation to be performed : ");
        String saisies = scanner.nextLine();

        try {
            int result = calculate(saisies);
            System.out.println("Result : " + result);
        } catch (IllegalArgumentException e) {
            System.out.println("Error : " + e.getMessage());
        }
    }

    public static int calculate(String input) {
        String message = "please insert a non-zero number";
        String[] tokens = input.split(" ");
        int a,b,c ;
        a=b=c= 0;

        if (tokens.length != 3 && tokens.length != 5) {
            throw new IllegalArgumentException("invalid operation");
        }
        try{
        a = Integer.parseInt(tokens[0]);
        b = Integer.parseInt(tokens[2]);
        c = 0;

        if (tokens.length == 5) {
            c = Integer.parseInt(tokens[4]);
        }
        }
        catch(NumberFormatException e){
        System.out.println("invalid number");

        }
        if (a < 0 || a > 10 || b < 0 || b > 10 || c < 0 || c > 10) {
            System.out.println("invalid number (must be between 0 and 10 inclusive)");
            System.exit(0);
        }
        switch (tokens[1]) {
            case "+":
                if (tokens.length == 3) {
                    return a + b;
                } else {
                    switch (tokens[3]) {
                        case "+":
                            return a + b + c;
                        case "-":
                            return a + b - c;
                        case "*":
                            return a + (b * c);
                        case "/":
                            if (c == 0) {
                                System.out.println("error : " +message);
                                insert_number();
                            } else {
                                return a + (b / c);
                            }
                    }
                }
            case "-":
                if (tokens.length == 3) {
                    return a - b;
                } else {
                    switch (tokens[3]) {
                        case "+":
                            return a - b + c;
                        case "-":
                            return a - b - c;
                        case "*":
                            return a - (b * c);
                        case "/":
                            if (c == 0) {
                                System.out.println("error : " +message);
                                insert_number();
                            } else {
                                return a - (b / c);
                            }
                    }
                }
            case "*":
                if (tokens.length == 3) {
                    return a * b;
                } else {
                    switch (tokens[3]) {
                        case "+":
                            return (a * b) + c;
                        case "-":
                            return (a * b) - c;
                        case "*":
                            return a * b * c;
                        case "/":
                            if (c == 0) {
                                System.out.println("error : " +message);
                                insert_number();
                            } else {
                                return a * (b / c);
                            }
                    }
                }
            case "/":
                if ((a == 0) && (b == 0) && (c == 0)) {
                    System.out.println("please insert a non-zero number");
                    insert_number();
                } else if ((a == 0) || (b != 0) || (c != 0)) {
                    return 0;
                } else {
                    if (tokens.length == 3) {
                        return a * b;
                    } else {
                        switch (tokens[3]) {
                            case "/" :
                                return a / b / c;
                            case "*" :
                                return (a / b) * c;
                            case "+" :
                                return (a / b) + c;
                            case "-" :
                                return (a / b) - c;
                        }
                    }
                }
            default:
                throw new IllegalArgumentException("invalid operation");
        }
    }
}