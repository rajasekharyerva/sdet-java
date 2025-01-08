package multi_thread;

import com.aventstack.extentreports.ExtentReports;

public class ExtentManager {

    private static ThreadLocal<ExtentReports> extentReports = new ThreadLocal<>();

    public static ExtentReports getExtentReports() {
        return extentReports.get();
    }

    public static void setExtentReports(ExtentReports extent) {
        extentReports.set(extent);
    }

    public static void removeExtentReports() {
        extentReports.remove();
    }
}

