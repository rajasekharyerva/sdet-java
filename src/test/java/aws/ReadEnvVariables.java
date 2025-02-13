package aws;

public class ReadEnvVariables {
    public static void main(String[] args) {
        System.out.println(System.getenv("AWS_ACCESS_KEY_ID"));
        System.out.println("dlsc");
        System.out.println("tests");
//        for (String env : System.getenv().keySet()) {
//            System.out.println(env + ": " + System.getenv(env));
//        }
    }
}