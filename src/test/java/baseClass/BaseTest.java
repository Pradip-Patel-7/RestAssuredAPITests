package baseClass;

import java.util.Properties;

import org.testng.annotations.BeforeSuite;

import io.restassured.RestAssured;
import util.ConfigReader;

public class BaseTest {
	public Properties prop;
	private ConfigReader configReader;

	@BeforeSuite
	public void getProperty() {
		configReader = new ConfigReader();
		prop = configReader.init_prop();

		RestAssured.baseURI = prop.getProperty("baseURI");
	}

}
