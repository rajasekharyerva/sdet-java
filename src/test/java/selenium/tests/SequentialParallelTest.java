package selenium.tests;


import io.qameta.allure.Feature;
import org.testng.annotations.Test;

public class SequentialParallelTest {
    @Test
    @Feature("A")
    public void test1() throws InterruptedException {
        System.out.println("Test 1");
        Thread.sleep(1000);
    }
    @Test
    @Feature("A")
    public void test2() throws InterruptedException {
        System.out.println("Test 2");
        Thread.sleep(1000);
    }
    @Test
    @Feature("B")
    public void test3() throws InterruptedException {
        System.out.println("Test 3");
        Thread.sleep(1000);
    }
    @Test
    @Feature("B")
    public void test4() throws InterruptedException {
        System.out.println("Test 4");
        Thread.sleep(1000);
    }
}
