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


WebUI.openBrowser('https://develop.trueprofit-web.pages.dev/user-sign-in?callbackPath=%2Fdashboard')

WebUI.setText(input_email, 'triettm@firegroup.io')

WebUI.setEncryptedText(input_password, '4aUHZLRHJF4=')

WebUI.click(btn_sign_in)

WebUI.click(span_calculation)

WebUI.click(span_custom_spend)

WebUI.click(btn_create_cost)

WebUI.setText(input_name_custom_cost,'test2023_09_05_3')

WebUI.setText(input_amount,'15')

WebUI.click(span_one_time)

WebUI.click(btn_confirm_create)

WebUI.click(span_dashboard)

WebUI.click(a_dashboard)

def value_custom_cost, value_custom_cost_chart

value_custom_cost = WebUI.getText(h6_custom_cost)

value_custom_cost_chart = WebUI.getText(span_custom_cost_chart)


println 'Custom cost in overview ='+value_custom_cost
println 'Custom cost in cost breakdown ='+value_custom_cost_chart


if (value_custom_cost == value_custom_cost_chart)
{
	println 'Custom cost trên overview và cost breakdown là bằng nhau'
	
}
else
	println 'Custom cost trên overview và cost breakdown là khác nhau'




