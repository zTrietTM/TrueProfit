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


WebUI.openBrowser('https://develop.trueprofit-web.pages.dev/cost/order-cost')

WebUI.setText(input_email, 'triettm+560@fireapps.vn')

WebUI.setEncryptedText(input_password, '4aUHZLRHJF4=')

WebUI.click(btn_sign_in)

WebUI.sendKeys(input_start_date, Keys.chord(Keys.CONTROL, 'a'))
WebUI.setText(input_start_date,'Aug 31, 2023')

WebUI.sendKeys(input_end_date, Keys.chord(Keys.CONTROL, 'a'))
WebUI.setText(input_end_date,'Aug 31, 2023')

WebUI.sendKeys(input_end_date, Keys.chord(Keys.ENTER))

def before_trans_fee, after_trans_fee

before_trans_fee = WebUI.getText(span_trans_before)

def extractedValue1 = before_trans_fee.substring(before_trans_fee.indexOf('₫') + 1)
def chuyenkieuso_trans_fee_before = extractedValue1.toString().replace(',','').toFloat()

GlobalVariable.before_trans = chuyenkieuso_trans_fee_before


WebUI.click(span_calculation)
WebUI.click(span_transaction_fee)


WebUI.sendKeys(input_transaction_1, Keys.chord(Keys.CONTROL, 'a'))
WebUI.setText(input_transaction_1, '1.5')

WebUI.sendKeys(input_transaction_2, Keys.chord(Keys.CONTROL, 'a'))
WebUI.setText(input_transaction_2, '2.5')

WebUI.sendKeys(input_transaction_3, Keys.chord(Keys.CONTROL, 'a'))
WebUI.setText(input_transaction_3, '3.5')

WebUI.click(btn_save)

def trans1, trans2, trans3

trans1 = WebUI.getAttribute(input_transaction_1, 'value')
def chuyenkieuso_trans_1 = trans1.replace(',','').toFloat()

trans2 = WebUI.getAttribute(input_transaction_2, 'value')
def chuyenkieuso_trans_2 = trans2.replace(',','').toFloat()

trans3 = WebUI.getAttribute(input_transaction_3, 'value')
def chuyenkieuso_trans_3 = trans3.replace(',','').toFloat()

GlobalVariable.trans_1 = chuyenkieuso_trans_1
GlobalVariable.trans_2 = chuyenkieuso_trans_2
GlobalVariable.trans_3 = chuyenkieuso_trans_3


WebUI.click(btn_recalculate)

WebUI.click(span_calculation)
WebUI.click(span_order_cost)

WebUI.sendKeys(input_start_date, Keys.chord(Keys.CONTROL, 'a'))
WebUI.setText(input_start_date,'Aug 31, 2023')

WebUI.sendKeys(input_end_date, Keys.chord(Keys.CONTROL, 'a'))
WebUI.setText(input_end_date,'Aug 31, 2023')

WebUI.sendKeys(input_end_date, Keys.chord(Keys.ENTER))


after_trans_fee = WebUI.getText(span_trans_before)

def extractedValue2 = after_trans_fee.substring(after_trans_fee.indexOf('₫') + 1)
def chuyenkieuso_trans_fee_after = extractedValue2.toString().replace(',','').toFloat()

println 'Transaction fee truoc do la: '+GlobalVariable.before_trans
println 'Transaction fee sau do la: '+chuyenkieuso_trans_fee_after


if(chuyenkieuso_trans_fee_after != GlobalVariable.before_trans)
	println 'Da recalculate transaction fee'
else
	println 'Chua recalculate transaction fee'


def TransactionFee_tutinh, revenueOrder, TransactionFee_apptinh
revenueOrder = WebUI.getText(span_revenue)

def extractedValue3 = revenueOrder.substring(revenueOrder.indexOf('₫') + 1)
def chuyenkieuso_revenue = extractedValue3.toString().replace(',','').toFloat()

TransactionFee_tutinh = GlobalVariable.trans_1 + ((GlobalVariable.trans_2+GlobalVariable.trans_3)*chuyenkieuso_revenue)/100

println 'Transaction fee tu tinh = '+Math.round(TransactionFee_tutinh)
println 'Transaction fee app tinh = '+chuyenkieuso_trans_fee_after

if (Math.round(TransactionFee_tutinh) == chuyenkieuso_trans_fee_after)
println 'Recalcule dung'
else
println 'Recalculate sai'





