package katafy.katas.fizzbuzz;

public class DeciBuzzer implements FizzBuzzer {

    @Override
    public String fizzBuzz(String number) {
        String outString = "";

        if (number.isEmpty()){
            return "";
        }
        if (Integer.parseInt(number) % 3 == 0){
            outString += "fizz";
        }
        if (Integer.parseInt(number) % 5 == 0){
            outString += "buzz";
        }
        if (outString.isEmpty()){
            outString += number;
        }

        return outString;


//        if (Integer.parseInt(number) % 3 == 0 && Integer.parseInt(number) % 5 == 0) {
//            return "fizzbuzz";
//        } else if (Integer.parseInt(number) % 3 == 0) {
//            return "fizz";
//        } else if (Integer.parseInt(number) % 5 == 0) {
//            return "buzz";
//        } else {
//            return number;
//        }
    }
}
