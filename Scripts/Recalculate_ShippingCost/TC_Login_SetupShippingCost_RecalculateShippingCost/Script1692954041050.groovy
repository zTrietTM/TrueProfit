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
import org.openqa.selenium.Keys as Keys

WebUI.openBrowser('https://develop.trueprofit-web.pages.dev/cost/shipping')

WebUI.setText(input_email, 'triettm+560@fireapps.vn')

WebUI.setEncryptedText(input_password, '4aUHZLRHJF4=')

WebUI.click(btn_sign_in)

WebUI.click(btn_edit_shipping_cost)

WebUI.sendKeys(input_cost_quantity, Keys.chord(Keys.CONTROL, 'a'))
WebUI.setText(input_cost_quantity, '8')

WebUI.click(btn_save_cost)

WebUI.click(btn_recalculate_shipping_cost)

def before_shipping_cost, after_shipping_cost

before_shipping_cost = WebUI.getText(div_before_shipping_cost)

def extractedValue1 = before_shipping_cost.substring(before_shipping_cost.indexOf('₫') + 1)
def chuyenkieuso_shipping_cost_before = extractedValue1.toString().replace(',','').toFloat()

GlobalVariable.before_shipping_cost = chuyenkieuso_shipping_cost_before

WebUI.click(span_calculation)

WebUI.click(span_order_cost)

WebUI.click(div_date_range)

WebUI.sendKeys(input_start_date, Keys.chord(Keys.CONTROL, 'a'))
WebUI.setText(input_start_date,'Aug 24, 2023')

WebUI.sendKeys(input_end_date, Keys.chord(Keys.CONTROL, 'a'))
WebUI.setText(input_end_date,'Aug 24, 2023')

WebUI.sendKeys(input_end_date, Keys.chord(Keys.ENTER))

WebUI.waitForElementPresent(div_after_shipping_cost, 5)

after_shipping_cost = WebUI.getText(div_after_shipping_cost)

def extractedValue2 = after_shipping_cost.substring(after_shipping_cost.indexOf('₫') + 1)
def chuyenkieuso_shipping_cost_after = extractedValue2.toString().replace(',','').toFloat()

println 'Shipping cost setup la: '+GlobalVariable.before_shipping_cost
println 'Shipping cost sau khi recalculate: '+chuyenkieuso_shipping_cost_after


if(chuyenkieuso_shipping_cost_after == GlobalVariable.before_shipping_cost)
	println 'Da recalculate shipping cost'
else
	println 'Chua recalculate shipping cost'













