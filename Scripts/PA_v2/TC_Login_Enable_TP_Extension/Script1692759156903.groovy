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

import ch.qos.logback.core.net.SocketConnector.ExceptionHandler
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys
import java.lang.Number
import java.util.logging.Handler

import org.apache.commons.lang3.StringUtils
import com.kms.katalon.core.util.KeywordUtil
import java.awt.Robot as Robot
import java.awt.event.KeyEvent as KeyEvent



WebUI.openBrowser('https://develop.trueprofit-web.pages.dev/product-analytics/spf')

WebUI.setText(input_email, 'triettm+560@fireapps.vn')

WebUI.setEncryptedText(input_password, '4aUHZLRHJF4=')

WebUI.click(btn_sign_in)

if (WebUI.verifyElementPresent(btn_go_enable_extension, 5,FailureHandling.OPTIONAL))
{
	WebUI.click(btn_go_enable_extension)
	
	WebUI.waitForElementPresent(spf_input_email, 10)
	
	WebUI.setText(spf_input_email,'triettm@firegroup.io')
	
	WebUI.click(spf_btn_continue)
	
	WebUI.setEncryptedText(spf_input_password,'SHOv9eUx7z94fag7HkGf4g==')
	
	WebUI.click(spf_btn_login)
	
	WebUI.waitForElementPresent(btn_enable_tp_extension, 10)
	
	WebUI.click(btn_enable_tp_extension)
	
	WebUI.click(btn_save)
	
	Robot robot = new Robot()
	robot.keyPress(KeyEvent.VK_CONTROL)
	robot.keyPress(KeyEvent.VK_T)
	robot.keyRelease(KeyEvent.VK_CONTROL)
	robot.keyRelease(KeyEvent.VK_T)
	
	WebUI.switchToWindowIndex(1)
	WebUI.navigateToUrl('https://develop.trueprofit-web.pages.dev/product-analytics/spf')
	
	
}
else
	WebUI.click(btn_bundling)
	
	
	
	


