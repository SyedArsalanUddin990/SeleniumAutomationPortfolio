import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.io.IOException;
import java.time.Duration;

public class LoginTest {
    public static void main(String[] args) throws IOException {
        // Path to Excel file
        String excelPath = "C:\\Users\\hp\\OneDrive\\Documents\\LoginData.xlsx";  // Update path
        String sheetName = "Sheet1";
        ExcelUtils.loadExcel(excelPath, sheetName);


        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();

        // Get total rows from Excel (skip header)
        int rowCount = ExcelUtils.getRowCount();
        System.out.println("Total Users: " + (rowCount - 1));

        // Loop through each record and perform login/logout
        for (int i = 1; i < rowCount; i++) {  // Start from row 1 (skip header)
            String username = ExcelUtils.getCellData(i, 0);
            String password = ExcelUtils.getCellData(i, 1);

            System.out.println("Logging in with User: " + username);

            // Open the login page (update URL)
            driver.get("http://127.0.0.1:5500/LoginTest.html");

            // Perform Login
            WebElement usernameField = driver.findElement(By.id("username"));
            WebElement passwordField = driver.findElement(By.id("password"));
            WebElement loginButton = driver.findElement(By.id("login"));

            usernameField.sendKeys(username);
            passwordField.sendKeys(password);
            loginButton.click();

            // Simulate a logout process (replace with actual logout button ID)
            try {
                Thread.sleep(3000);  // Wait for login
                WebElement logoutButton = driver.findElement(By.id("logout"));  // Add Logout Button in HTML
                logoutButton.click();
                System.out.println("User " + username + " logged out successfully.");
            } catch (Exception e) {
                System.out.println("Failed to logout for user: " + username);
            }
        }

        // Close browser and Excel
        driver.quit();
        ExcelUtils.closeExcel();
    }
}import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.io.IOException;
import java.time.Duration;

public class LoginTest {
    public static void main(String[] args) throws IOException {
        // Path to Excel file
        String excelPath = "C:\\Users\\hp\\OneDrive\\Documents\\LoginData.xlsx";  // Update path
        String sheetName = "Sheet1";
        ExcelUtils.loadExcel(excelPath, sheetName);


        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();

        // Get total rows from Excel (skip header)
        int rowCount = ExcelUtils.getRowCount();
        System.out.println("Total Users: " + (rowCount - 1));

        // Loop through each record and perform login/logout
        for (int i = 1; i < rowCount; i++) {  // Start from row 1 (skip header)
            String username = ExcelUtils.getCellData(i, 0);
            String password = ExcelUtils.getCellData(i, 1);

            System.out.println("Logging in with User: " + username);

            // Open the login page (update URL)
            driver.get("http://127.0.0.1:5500/LoginTest.html");

            // Perform Login
            WebElement usernameField = driver.findElement(By.id("username"));
            WebElement passwordField = driver.findElement(By.id("password"));
            WebElement loginButton = driver.findElement(By.id("login"));

            usernameField.sendKeys(username);
            passwordField.sendKeys(password);
            loginButton.click();

            // Simulate a logout process (replace with actual logout button ID)
            try {
                Thread.sleep(3000);  // Wait for login
                WebElement logoutButton = driver.findElement(By.id("logout"));  // Add Logout Button in HTML
                logoutButton.click();
                System.out.println("User " + username + " logged out successfully.");
            } catch (Exception e) {
                System.out.println("Failed to logout for user: " + username);
            }
        }

        // Close browser and Excel
        driver.quit();
        ExcelUtils.closeExcel();
    }
}