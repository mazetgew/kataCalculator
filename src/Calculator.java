import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Calculator {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        String result = calc(scanner.nextLine());
        System.out.println(result);
    }
    public static String calc(String input){
        String result;
        String [] task = input.split(" ");
        boolean system;
        try {
            int a = Integer.parseInt(task[0]);
            int b = Integer.parseInt(task[2]);
            system = true;
        } catch (Exception e){
            system = false;
        }
        if (system){
            try {
                int a = Integer.parseInt(task[0]);
                int b = Integer.parseInt(task[2]);
                if (!(a > 0 && a < 11) || !(b > 0 && b < 11)) {
                    try{
                        throw new Exception();
                    } catch (Exception zn){
                        throw new RuntimeException(zn);
                    }
                } else {
                    result = calculate(task[1], a, b);
                }
            } catch (Exception e) {
                System.out.println("Выражение должно быть в формате a + b, в одной системе исчисления и от 1 до 10 включительно!");
                throw new RuntimeException(e);
            }
        } else {
            try {
                int a = inArabian(task[0]);
                int b = inArabian(task[2]);
                if (!(a > 0 && a < 11) || !(b > 0 && b < 11)) {
                    try{
                        throw new Exception();
                    } catch (Exception zn){
                        throw new RuntimeException(zn);
                    }
                } else {
                    result = calculate(task[1], a, b);
                }
            } catch (Exception e){
                System.out.println("Выражение должно быть в формате a + b, в одной системе исчисления от I до X включительно!");
                throw new RuntimeException(e);
            }
            if (Integer.parseInt(result)>0){
                result = inRoman(result);
            } else {
                try {
                    throw new Exception();
                } catch (Exception negative){
                    System.out.println("Недопустимое значение результата!");
                    throw new RuntimeException(negative);
                }
            }
        }
        return result;
    }
    public static String calculate(String operation, int a, int b){
        String result;
        switch (operation) {
            case "+":
                result = String.valueOf(a + b);
                break;
            case "-":
                result = String.valueOf(a - b);
                break;
            case "*":
                result = String.valueOf(a * b);
                break;
            case "/":
                result = String.valueOf(a / b);
                break;
            default:
                System.out.println("Такой операции не существует, допустимые операции : +, -, *, /");
                try {
                    throw new Exception();
                } catch (Exception op) {
                    throw new RuntimeException(op);
                }
        }
        return result;
    }
    public static int inArabian(String inRom){
        int inArab;
        switch(inRom) {
            case "I" :
                inArab = 1;
                break;
            case "II" :
                inArab = 2;
                break;
            case "III" :
                inArab = 3;
                break;
            case "IV" :
                inArab = 4;
                break;
            case "V" :
                inArab = 5;
                break;
            case "VI" :
                inArab = 6;
                break;
            case "VII" :
                inArab = 7;
                break;
            case "VIII" :
                inArab = 8;
                break;
            case "IX" :
                inArab = 9;
                break;
            case "X" :
                inArab = 10;
                break;
            default:
                try {
                    throw new Exception();
                } catch (Exception notRom) {
                    throw new RuntimeException(notRom);
                }
        }
        return inArab;
    }
    public static String inRoman(String inArab){
        StringBuilder inRom = new StringBuilder();
        Map<Integer , String> roman = new HashMap<>();
        roman.put(0 , "");
        roman.put(1 , "I");
        roman.put(2 , "II");
        roman.put(3 , "III");
        roman.put(4 , "IV");
        roman.put(5 , "V");
        roman.put(6 , "VI");
        roman.put(7 , "VII");
        roman.put(8 , "VIII");
        roman.put(9 , "IX");
        roman.put(10 , "X");
        roman.put(20 , "XX");
        roman.put(30 , "XXX");
        roman.put(40 , "XL");
        roman.put(50 , "L");
        roman.put(60, "LX");
        roman.put(70 , "LXX");
        roman.put(80 , "LXXX");
        roman.put(90 , "XC");
        roman.put(100 , "C");
        String [] difArab = String.valueOf(inArab).split("");
        Integer [] intArab = new Integer[difArab.length];
        for (int i = 0; i < difArab.length; i++ ){
            intArab[i] = Integer.parseInt(difArab[i]);
        }
        int mn = 1;
        for (var i = intArab.length - 1; i >= 0; i--){
            intArab[i] = intArab[i] * mn;
            mn = mn * 10;
        }
        for (int x : intArab){
            inRom.append(roman.get(x));
        }
        return inRom.toString();
    }
}