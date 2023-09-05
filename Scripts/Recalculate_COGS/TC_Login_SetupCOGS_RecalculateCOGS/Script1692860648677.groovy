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

WebUI.openBrowser('https://develop.trueprofit-web.pages.dev/cost/cogs')

WebUI.setText(input_email, 'triettm+560@fireapps.vn')

WebUI.setEncryptedText(input_pasword, '4aUHZLRHJF4=')

WebUI.click(btn_sign_in)

WebUI.setText(input_product, 'The Complete Snowboard')

WebUI.click(div_product)

WebUI.click(div_cogs_product)

WebUI.setText(input_value_cogs, '290')

WebUI.click(btn_save)

def cogs_before

cogs_before = WebUI.getText(span_cogs_before)

def extractedValue1 = cogs_before.substring(cogs_before.indexOf('₫') + 1)
def chuyenkieuso_cogs_before = extractedValue1.toString().replace(',','').toFloat()

GlobalVariable.before_cogs = chuyenkieuso_cogs_before


WebUI.click(btn_recalculate_all_product)

WebUI.click(span_dashboard)

WebUI.click(span_product_analytics)

WebUI.setText(input_product_name, 'The Complete Snowboard')

WebUI.click(date_range)

WebUI.sendKeys(input_start_date, Keys.chord(Keys.CONTROL, 'a'))
WebUI.setText(input_start_date,'Aug 24, 2023')

WebUI.sendKeys(input_end_date, Keys.chord(Keys.CONTROL, 'a'))
WebUI.setText(input_end_date,'Aug 24, 2023')

WebUI.sendKeys(input_end_date, Keys.chord(Keys.ENTER))

WebUI.waitForElementPresent(div_unit_sold, 10)

def unitsold, cogs, cogsAfter

unitsold = WebUI.getText(div_unit_sold)

cogs = WebUI.getText(div_cogs)

def extractedValue = cogs.substring(cogs.indexOf('₫') + 1)
def chuyenkieuso_cogs = extractedValue.toString().replace(',','').toFloat()

def chuyenkieuso_unitsold = unitsold.toFloat()

cogsAfter = chuyenkieuso_unitsold * chuyenkieuso_cogs

println 'Unit sold = '+chuyenkieuso_unitsold
println 'Cogs duoc setup de recalculate = '+GlobalVariable.before_cogs
println 'Cogs sau khi nhan recalculate = '+cogsAfter

if(cogsAfter == GlobalVariable.before_cogs*chuyenkieuso_unitsold)
	println 'Da recalculate lai COGS'
else
	println 'Chua recalculate lai COGS'	


