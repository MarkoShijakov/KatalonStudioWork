import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.By as By
import org.openqa.selenium.Keys as Keys
import org.openqa.selenium.WebDriver as WebDriver
import org.openqa.selenium.WebElement as WebElement
import java.text.*
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory

WebUI.openBrowser(GlobalVariable.URL)

CustomKeywords.'navigation.browserNavigation.goToSearchCarsPage'()

WebUI.verifyElementPresent(findTestObject('Search cars Page/Search input fld'), 1)

WebUI.setText(findTestObject('Search cars Page/Search input fld'), 'Langhorne')

WebUI.sendKeys(findTestObject('Search cars Page/Search input fld'), Keys.chord(Keys.ENTER))

WebUI.click(findTestObject('Search cars Page/Sort by/Sort by DropDown'))

WebUI.click(findTestObject('Search cars Page/Sort by/Nearest to you'))

WebDriver driver = DriverFactory.getWebDriver()

ArrayList<WebElement> cityNames = driver.findElements(By.cssSelector('.dealership-name.text-overflow-ellipsis'))

for (int i = 0; i < 10; i++) {
    String currentCityName = cityNames.get(i).getText()

    WebUI.verifyEqual(currentCityName, 'Langhorne')
}

WebUI.closeBrowser()

