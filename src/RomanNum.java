public class RomanNum {
    private  String key;
    private  int value;
//    (900,"CM"),(1000,"M")
    public static RomanNum[] values = new RomanNum[]{new RomanNum("I", 1), new RomanNum("II", 2), new RomanNum("III", 3), new RomanNum("IV", 4),
            new RomanNum("V", 5), new RomanNum("VI", 6), new RomanNum("VII", 7), new RomanNum("VIII", 8), new RomanNum("IX", 9), new RomanNum("X", 10),
            new RomanNum("XL", 40), new RomanNum("L", 50), new RomanNum("XC", 90),
            new RomanNum("C", 100)};
    public RomanNum(String key, int value){
        this.key = key;
        this.value = value;
    }
    public  String getKey(){
        return key;
    }
    public  int getValue(){
        return value;
    }
    public static RomanNum[] getValues(){
        return values;
    }
    static int toInt(String key) { // перевод из римской в арабскую систему счисления
        for (RomanNum element: values) {
            if(element.getKey().equals(key)){
                return element.getValue();
            }
        }
        return 0;
    }
    public static String toRomanNumbers(int value){ // метод для перевода из Арабских чисел в Римские
        String result = "";
        int i = 8;
        while(value > 0){
            while(values[i].getValue() > value){
                i--;
            }
            result += values[i].getKey();
            value -= values[i].getValue();
        }
        return result;
    }
}
