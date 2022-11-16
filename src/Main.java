import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static javax.print.attribute.standard.MediaSizeName.A;

public class Main {

    /**
     * Створені регулярні вирази, за якими перевіряється рядок, виводиться true-співпадає, false-не співпадає
     * @param string
     */
    public static void listOfRegex(String string){
        Pattern p1 = Pattern.compile("a.b");
        Pattern p2 = Pattern.compile("ab+a");
        Pattern p3 = Pattern.compile("ab?a");
        Pattern p4 = Pattern.compile("a.*a");
        Pattern p5 = Pattern.compile("\\d+[а-яА-Я]+");
        Pattern p6 = Pattern.compile("#[0-9a-fA-F]{6}");
        Pattern p7 = Pattern.compile("(\\d{1,3}\\.){3}\\d{1,3}");
        Pattern p8 = Pattern.compile("[\\w-]+\\.java");
        Pattern p9 = Pattern.compile("[\\w$]\\w+");
        Pattern p10 = Pattern.compile("[A-ZА-Я][a-zа-я]+\\s([A-ZА-Я]\\.){2}");

        Matcher matcher1 = p1.matcher(string);
        Matcher matcher2 = p2.matcher(string);
        Matcher matcher3 = p3.matcher(string);
        Matcher matcher4 = p4.matcher(string);
        Matcher matcher5 = p5.matcher(string);
        Matcher matcher6 = p6.matcher(string);
        Matcher matcher7 = p7.matcher(string);
        Matcher matcher8 = p8.matcher(string);
        Matcher matcher9 = p9.matcher(string);
        Matcher matcher10 = p10.matcher(string);

        System.out.println(matcher1.matches());
        System.out.println(matcher2.matches());
        System.out.println(matcher3.matches());
        System.out.println(matcher4.matches());
        System.out.println(matcher5.matches());
        System.out.println(matcher6.matches());
        System.out.println(matcher7.matches());
        System.out.println(matcher8.matches());
        System.out.println(matcher9.matches());
        System.out.println(matcher10.matches());
    }

    /**
     * Виводить слова, що скаладються із 4 латинських літер
     * @param string
     */
    public static void fourLetters(String string) {
        Pattern pattern = Pattern.compile("[a-zA-Z]{4}");
        String[] words = string.split(" ");
        for (String word : words) {
            Matcher matcher = pattern.matcher(word);
            if (matcher.matches()) {
                System.out.print(word + " ");
            }
        }
    }

    /**
     * Виводить слво, в якому латинські літери замінені
     * на відповідні їм лутери кирилиці
     * @param word
     */
    public static void toCyrillic(String word) {
        String changedWord="";
        String[] latin= {"A", "a", "B", "b", "C","c","D", "d","E","e","F","f",
        "G", "g", "H", "h", "I", "i", "J", "j", "K", "k", "L","l", "M", "m",
        "N", "n", "O", "o", "P", "p", "Q", "q", "R", "r", "S", "s", "T", "t",
        "U", "u", "V", "v", "W", "w", "X", "x", "Y", "y", "Z", "z"};
        String[] cyrillic= {"А", "а", "Б", "б", "Ц","ц","Д", "д","Е","е","Ф","ф",
                "Г", "г", "Х", "х", "И", "и", "Дж", "Дж", "K", "к", "Л","л", "M", "м",
                "Н", "н", "O", "o", "П", "п", "Кью", "кью", "Р", "р", "С", "с", "T", "т",
                "У", "у", "В", "в", "В", "в", "Икс", "Икс", "Й", "й", "З", "з"};

        for(int i=0; i<word.length(); i++){
            String stringWord = "";
            stringWord += word.charAt(i);
            int n=0;
            while(n<latin.length){
                if(stringWord.equals(latin[n])){
                    changedWord+=cyrillic[n];
                    break;
                }
                n++;
            }
        }
        System.out.println(changedWord);
    }

    /**
     * Знаходить слова рядка, що складаються лише з латинських символів
     * @param string
     * @return кількість слів, що містять тільки латинські символи
     */
    public static int latinSymbols(String string) {
        int wordsNumber = 0;
        Pattern pattern = Pattern.compile("[A-Za-z]+");
        String[] words = string.split(" ");
        for (String word : words) {
            Matcher matcher = pattern.matcher(word);
            if (matcher.matches()) {
                wordsNumber++;
            }
        }
        return wordsNumber;
    }

    /**
     * Знаходить слова, які складаються лише з цифр
     * @param string
     * @return кількість слів із цифр
     */
    public static int onlyNumbers(String string) {
        int wordsNumber = 0;
        Pattern pattern = Pattern.compile("\\d+");
        String[] words = string.split(" ");
        for (String word : words) {
            Matcher matcher = pattern.matcher(word);
            if (matcher.matches()) {
                wordsNumber++;
            }
        }
        return wordsNumber;
    }

    /**
     * Знаходить слова, які складаються із цифр,
     * серед яких знаходить паліндроми - числа,
     * що однаково читаються з обох сторін.
     * Записує знайдені паліндроми у рядок
     * @param string
     * @return рядок поліндромів
     */
    public static String palindrome(String string){
        StringBuilder palindromeNumber = new StringBuilder();
        Pattern pattern = Pattern.compile("\\d+");
        String[] words = string.split(" ");
        for (String word : words) {
            Matcher matcher = pattern.matcher(word);
            String reversWord = "";
            if (matcher.matches()) {
                for(int i=word.length()-1; i>=0; i--){
                    reversWord+=word.charAt(i);
                }
            }
            if(word.equals(reversWord) && word.length()>1){
                palindromeNumber.append(word).append(" ");
            }
        }
        return palindromeNumber.toString();
    }

    /**
     * "Точка входу" додатку
     * Викликає створені методи, зчитує рядки та виводить результати
     * @param args
     */
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        System.out.println("Enter your string: ");
        String string = input.nextLine();
        System.out.print("The words consisting of 4 letters: ");
        fourLetters(string);
        System.out.print("\nEnter your word:");
        String word = input.nextLine();
        toCyrillic(word);
        System.out.print("\nNumber of words containing only Latin alphabet: " + latinSymbols(string));
        System.out.print("\nNumber of words containing only numbers: " + onlyNumbers(string));
        System.out.print("\nPalindromes: ");
        System.out.print(palindrome(string));
    }
}