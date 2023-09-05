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
import org.apache.commons.lang3.StringUtils
import com.kms.katalon.core.util.KeywordUtil

//login

WebUI.openBrowser('https://develop.trueprofit-web.pages.dev/dashboard')

WebUI.setText(input_email, 'triettm@firegroup.io')

WebUI.setEncryptedText(input_password, '4aUHZLRHJF4=')

WebUI.click(btn_sign_in)

//select store 182

WebUI.click(div_select_store)

WebUI.click(span_select_store_182)

//select date range
WebUI.waitForElementPresent(date_range, 5)

WebUI.click(date_range)

WebUI.sendKeys(input_start_date, Keys.chord(Keys.CONTROL, 'a'))
WebUI.setText(input_start_date,'Aug 10, 2023')

WebUI.sendKeys(input_end_date, Keys.chord(Keys.CONTROL, 'a'))
WebUI.setText(input_end_date,'Aug 10, 2023')

WebUI.sendKeys(input_end_date, Keys.chord(Keys.ENTER))

//get data from webapp

def cogs, handling_fee, shipping_cost, ad_spend, transaction_fee, custom_spend, tax_paid, total_cost_app_tinh

def grosssale, discount, refund, tax, shippingcharged, revenue

def total_cost_tu_cong

cogs = WebUI.getText(cogs_data)

ad_spend = WebUI.getText(ad_spend_data)

transaction_fee = WebUI.getText(transaction_data)

custom_spend = WebUI.getText(custom_spend_data)

tax_paid = WebUI.getText(tax_paid_data)

shipping_cost = WebUI.getText(shipping_cost_data)

handling_fee = WebUI.getText(handling_fee_data)

total_cost_app_tinh = WebUI.getText(total_cost_data)

//convert string to float

def extractedValue = cogs.substring(cogs.indexOf('$') + 1)
def chuyenkieuso_COGS = extractedValue.toString().replace(',','').toFloat()


def extractedValue2 = ad_spend.substring(ad_spend.indexOf('$') + 1)
def chuyenkieuso_adSpend = extractedValue2.toString().replace(',','').toFloat()


def extractedValue3 = transaction_fee.substring(transaction_fee.indexOf('$') + 1)
def chuyenkieuso_transactionFee = extractedValue3.toString().replace(',','').toFloat()


def extractedValue4 = custom_spend.substring(custom_spend.indexOf('$') + 1)
def chuyenkieuso_customSpend = extractedValue4.toString().replace(',','').toFloat()

def extractedValue5 = tax_paid.substring(tax_paid.indexOf('$') + 1)
def chuyenkieuso_taxPaid = extractedValue5.toString().replace(',','').toFloat()

def extractedValue6 = shipping_cost.substring(shipping_cost.indexOf('$') + 1)
def chuyenkieuso_shippingCost = extractedValue6.toString().replace(',','').toFloat()

def extractedValue7 = handling_fee.substring(handling_fee.indexOf('$') + 1)
def chuyenkieuso_handlingFee = extractedValue7.toString().replace(',','').toFloat()


def extractedValue8 = total_cost_app_tinh.substring(total_cost_app_tinh.indexOf('$') + 1)
def chuyenkieuso_totalcostapptinh = extractedValue8.toString().replace(',','').toFloat()

//compare total cost

total_cost_tu_cong = chuyenkieuso_COGS + chuyenkieuso_adSpend + chuyenkieuso_transactionFee + chuyenkieuso_customSpend + chuyenkieuso_taxPaid + chuyenkieuso_shippingCost + chuyenkieuso_handlingFee
println 'adSpend = '+chuyenkieuso_adSpend
println 'transaction = '+chuyenkieuso_transactionFee
println 'custom_spend = '+chuyenkieuso_customSpend
println 'tax_paid = '+chuyenkieuso_taxPaid
println 'shipping_cost = '+chuyenkieuso_shippingCost
println 'handling_fee = '+chuyenkieuso_handlingFee
println 'total_cost_tu_tinh = '+total_cost_tu_cong.toFloat().round(2) 
println 'total_cost_app_tinh = '+chuyenkieuso_totalcostapptinh

if (total_cost_tu_cong.toFloat().round(2)==chuyenkieuso_totalcostapptinh)
	{
		println 'True'
	}
else
	println 'False'	

//println totalcost = cogs + ad_spend