package basic;

public class ConvertToTitle {


    public String convertToTitle(int columnNumber) {
        StringBuilder sb = new StringBuilder();
        while (columnNumber > 0) {
            columnNumber = columnNumber - 1;
            sb.append((char) ('A' + columnNumber % 26));
            columnNumber = columnNumber / 26;
        }
        sb.reverse();
        return sb.toString();
    }

    public static void main(String[] args) {
        int number = 52;
        ConvertToTitle solution = new ConvertToTitle();
        String str = solution.convertToTitle(number);
        System.out.println(str);
    }

}
