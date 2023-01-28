package utils;

public enum App {
    APIDEMO("io.appium.android.apis","io.appium.android.apis.ApiDemos"),
    CALCULATOR("com.google.android.calculator","com.android.calculator2.Calculator"),
    BLAETTER("de.cominto.blaetterkatalog.example","de.cominto.blaetterkatalog.android.cfl.presentation.view.activity.cfl.FeedDetailActivity");


    public String appPackage;
    public String appActivitiy;


    App(String appPackage, String appActivitiy) {
        this.appPackage = appPackage;
        this.appActivitiy = appActivitiy;
    }
}
