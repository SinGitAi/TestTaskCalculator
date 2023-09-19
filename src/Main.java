import java.util.Scanner;

public class Main {
    public static int firstNumber;
    public static int secondNumber;
    public static String[] lineSplit;
    public static char[] expressionMas;
    public static String result; // итоговый результат

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);  // чтение с консоли строки
        String line = scanner.nextLine();
        scanner.close();
        lineSplit = line.split(" ");
        if(lineSplit.length != 3){ // проверка на верность выражения
            try{
                throw new Exception();
            }catch (Exception e){
                System.out.println("Ошибка: Неверное выражение");
                System.exit(0);
            }
        }

            if (firstNumber > 10 || secondNumber > 10) { // проверка чисел что они меньше 10
                try {
                    throw new Exception();
                } catch (Exception e) {
                    System.out.println("Ошибка: Число больше 10");
                    System.exit(0);
                }
            }
            System.out.println(calc(line));
    }

    public static String calc(String input) { // основной блок кода
        String operator = lineSplit[1];
        expressionMas = input.toCharArray();

        // проверка чисел на систему счисления
        if(!Character.isDigit(expressionMas[0]) && Character.isDigit(expressionMas[input.indexOf(operator) + 2]) || Character.isDigit(expressionMas[0]) && !Character.isDigit(expressionMas[input.indexOf(operator) + 2])){
            try {
                throw new IllegalArgumentException();
            }catch (IllegalArgumentException e){
                System.out.println("Ошибка: Числа в разный системах счисления");
                System.exit(0);
            }
        }

        // инизилизация переменных в зависимости от системы счисления
        if (numberSystem().equals("arab")) {
            try {
                firstNumber = Integer.parseInt(lineSplit[0]);
                secondNumber = Integer.parseInt(lineSplit[2]);
            } catch (NumberFormatException e) { // проверка чисел на целочисленность
                System.out.println("Ошибка: Числа не целые");
                System.exit(0);
            }

            switch (operator) {  // операции над числами
                case "+":
                    result = "" + (firstNumber + secondNumber);
                    break;
                case "-":
                    result = "" + (firstNumber - secondNumber);
                    break;
                case "*":
                    result = "" + (firstNumber * secondNumber);
                    break;
                case "/":
                    result = "" + (firstNumber / secondNumber);
                    break;
                default:
                    result = null;
                    break;
            }

        }else {
            firstNumber = RomanNum.toInt(lineSplit[0]);
            secondNumber = RomanNum.toInt(lineSplit[2]);
            int computation = 0;

            switch (operator) {// операции над числами
                case "+":
                    computation = firstNumber + secondNumber;
                    break;
                case "-":
                    computation = firstNumber - secondNumber;
                    break;
                case "*":
                    computation = firstNumber * secondNumber;
                    break;
                case "/":
                    computation = firstNumber / secondNumber;
                    break;
                default:
                    computation = 0;
                    break;
            }

            if(computation <= 0){ // проверка что число больше 0
                try {
                    throw new Exception();
                }catch (Exception e){
                    System.out.println("Ошибка: Число меньше, либо равно 0");
                    System.exit(0);
                }
            }else {
                result = RomanNum.toRomanNumbers(computation);
            }
        }
        return result;
    }

    public static String numberSystem(){ // метод для проверки системы счисления
        if(Character.isDigit(expressionMas[0])){
            return  "arab";
        }else{
            return  "rome";
        }

    }

}