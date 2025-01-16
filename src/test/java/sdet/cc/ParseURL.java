package sdet.cc;

public class ParseURL {
    public static void main(String[] args) {
        String str = "https://abc.in/api/users?page=2";
        String[] stra = str.split("[:?/]+");
        for (String s : stra) {
            System.out.println(s);
        }
    }
}
