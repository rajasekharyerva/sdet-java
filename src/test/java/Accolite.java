public class Accolite {
    public static void main(String[] args) {

        /*WebDriver driver = new ChromeDriver();
        WebElement dropdownWE = driver.findElement(By.xpath("//dropdown"));
        Select dropdwonSelect = new Select(dropdownWE);
        List<WebElement> dropdownList = dropdwonSelect.getOptions();
        ArrayList<String> options = new ArrayList<>();
        //Check Size
        if (dropdownList.size() == 10) {
            for (WebElement element : dropdownList) {
                options.add(element.getText());
                System.out.println(element.getText());

            }
        } else {
            System.out.println("Elements not equal 10");
        }

        Wait<WebDriver> fluentWait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(30))
                .pollingEvery(Duration.ofSeconds(5))
                .ignoring(NoSuchElementException.class);*/


        //Input: abcd e
        //output: edcb a

        String input = "abcd e";
        int start = 0;
        int end = input.length() - 1;
        char[] charArray = input.toCharArray();
        for (int i = start; i < end; i++) {
            char ch = input.charAt(i);
            if (charArray[start] == ' ') {
                start++;
            }
            if (charArray[end] == ' ') {
                end--;
            }
            charArray[start] = charArray[end];
            charArray[end] = ch;
            start++;
            end--;
        }

        String output = "";
        for (char ch : charArray) {
            output = output + ch;
        }
        System.out.println(output);
    }
}