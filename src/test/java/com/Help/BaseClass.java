package com.Help;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;

import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import org.openqa.selenium.Alert;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	public static WebDriver d;
	public static Actions ac;
	public static Robot r;
	public static Select s;
	public static Alert a;

	public static void chromeBrowser() {
		WebDriverManager.chromedriver().setup();
		d = new ChromeDriver();
	}

	public static void firefoxBrowes() {
		WebDriverManager.firefoxdriver().setup();
		d = new FirefoxDriver();
	}

	public static void edgeBrower() {
		WebDriverManager.edgedriver().setup();
		d = new EdgeDriver();
	}

	public static void urlLaunch(String url) {
		d.get(url);
	}

	public static void getDateAndTime() {
		Date d = new Date();
		System.out.println(d);

	}

	public static String pageTitle() {
		String t = d.getTitle();
		return t;
	}

	public static String currentUrl() {
		String t = d.getCurrentUrl();
		return t;
	}

	public static String getText(WebElement e) {
		String t = e.getText();
		return t;
	}

	public static String getAttribute(WebElement e) {
		String t = e.getAttribute("value");
		return t;
	}

	public static void maxWindow() {
		d.manage().window().maximize();
	}

	public static void minWindow() {
		d.manage().window().minimize();
	}

	public static void passValues(WebElement e, String k) {
		e.sendKeys(k);
	}

	public static void click(WebElement e) {
		e.click();
	}

	public static void rightClick(WebElement e) {
		ac = new Actions(d);
		ac.contextClick(e).perform();
	}

	public static void doubleClick(WebElement e) {
		ac = new Actions(d);
		ac.doubleClick(e).perform();
	}

	public static void mouseHover(WebElement e) {
		ac = new Actions(d);
		ac.moveToElement(e).perform();
	}

	public static void dragAndDrop(WebElement src, WebElement des) {
		ac = new Actions(d);
		ac.dragAndDrop(src, des).perform();
	}

	public static void actionsSendKeys(WebElement e, String k) {
		ac = new Actions(d);
		ac.sendKeys(e, k).perform();
	}

	public static void keyDown(WebElement e) {
		ac = new Actions(d);
		ac.keyDown(e, Keys.SHIFT).perform();
	}

	public static void keyup(WebElement e) {
		ac = new Actions(d);
		ac.keyUp(e, Keys.SHIFT).perform();
	}

	public static void actionsClick(WebElement e) {
		ac = new Actions(d);
		ac.click(e).perform();
	}

	public static void copy() throws AWTException {
		r = new Robot();
		r.keyPress(KeyEvent.VK_CONTROL);
		r.keyPress(KeyEvent.VK_C);

		r.keyRelease(KeyEvent.VK_C);
		r.keyRelease(KeyEvent.VK_CONTROL);
	}

	public static void cut() throws AWTException {
		r = new Robot();
		r.keyPress(KeyEvent.VK_CONTROL);
		r.keyPress(KeyEvent.VK_X);

		r.keyRelease(KeyEvent.VK_X);
		r.keyRelease(KeyEvent.VK_CONTROL);
	}

	public static void paste() throws AWTException {
		r = new Robot();
		r.keyPress(KeyEvent.VK_CONTROL);
		r.keyPress(KeyEvent.VK_V);

		r.keyRelease(KeyEvent.VK_V);
		r.keyRelease(KeyEvent.VK_CONTROL);
	}

	public static void enter() throws AWTException {
		r = new Robot();
		r.keyPress(KeyEvent.VK_ENTER);

		r.keyRelease(KeyEvent.VK_ENTER);
	}

	public static void screenShot(String k) throws IOException {
		TakesScreenshot t = (TakesScreenshot) d;
		File ss = t.getScreenshotAs(OutputType.FILE);
		File dest = new File("C:\\Users\\Ram\\eclipse-workspace\\Maven\\ScreenShot\\" + k + ".png");
		FileUtils.copyFile(ss, dest);
	}

	public static void waitImplicit(long l) {
		d.manage().timeouts().implicitlyWait(Duration.ofSeconds(l));
	}

	public static void setAttribute(String k, WebElement e) {
		JavascriptExecutor js = (JavascriptExecutor) d;
		js.executeScript("arguments [0] .setAttribute ( 'value', '" + k + "')", e);
	}

	public static String getAttribute(String k, WebElement e) {
		JavascriptExecutor js = (JavascriptExecutor) d;
		Object executeScript = js.executeScript("return arguments [0] .getAttribute ( 'value', '" + k + "')", e);
		String p = (String) executeScript;
		return p;
	}

	public static void clickjavascript(WebElement e) {
		JavascriptExecutor js = (JavascriptExecutor) d;
		js.executeScript("arguments [l0 .click()", e);
	}

	public static void Scrolldown(WebElement e) {
		JavascriptExecutor js = (JavascriptExecutor) d;
		js.executeScript("arguments [0] .scrollIntoView(true)", e);
	}

	public static void ScrollUp(WebElement e) {
		JavascriptExecutor js = (JavascriptExecutor) d;
		js.executeScript("arguments [0] .scrollIntoView(false)", e);
	}

	public static void acceptAlert() {
		a = d.switchTo().alert();
		a.accept();
	}

	public static void dismissAlert() {
		a = d.switchTo().alert();
		a.dismiss();
	}

	public static void sendKeysAlert(String k) {
		a = d.switchTo().alert();
		a.sendKeys(k);
		a.accept();
	}

	public static void getTextAlert() {
		a = d.switchTo().alert();
		System.out.println(a.getText());
	}

	public static void size(WebElement e) {
		System.out.println(e.getSize());
	}

	public static void frame(WebElement e) {
		d.switchTo().frame(e);
	}

	public static void frame(int index) {
		d.switchTo().frame(index);
	}

	public static void frame(String name) {
		d.switchTo().frame(name);
	}

	public static void mainFrame() {
		d.switchTo().defaultContent();
	}

	public static void parentFrame() {
		d.switchTo().parentFrame();
	}

	public static void isMultiple(WebElement e) {
		s = new Select(e);
		if (s.isMultiple()) {
			System.out.println("Yes it is multi drop down");
		} else {
			System.out.println("No it is not nulti drop down ");
		}
	}

	public static void selectByIndex(WebElement e, int index) {
		s = new Select(e);
		s.selectByIndex(index);
	}

	public static void selectByValue(WebElement e, String value) {
		s = new Select(e);
		s.selectByValue(value);
	}

	public static void selectByText(WebElement e, String text) {
		s = new Select(e);
		s.selectByVisibleText(text);
	}

	public static void deselectByIndex(WebElement e, int index) {
		s = new Select(e);
		s.deselectByIndex(index);
	}

	public static void deselectByValue(WebElement e, String value) {
		s = new Select(e);
		s.deselectByValue(value);
	}

	public static void deselectByText(WebElement e, String text) {
		s = new Select(e);
		s.deselectByVisibleText(text);
	}

	public static void deselectAll(WebElement e) {
		s = new Select(e);
		s.deselectAll();
	}

	public static void getOptions(WebElement e) {
		s = new Select(e);
		List<WebElement> options = s.getOptions();
		for (WebElement o : options) {
			System.out.println(o.getText());
		}
	}

	public static void getAllSelectedOptions(WebElement e) {
		s = new Select(e);
		List<WebElement> allSelectedOptions = s.getAllSelectedOptions();
		for (WebElement o : allSelectedOptions) {
			System.out.println(o.getText());

		}
	}

	public static void getFirstSelectedOption(WebElement e) {
		s = new Select(e);
		WebElement o = s.getFirstSelectedOption();
		System.out.println(o.getText());
	}

	public static void windowHandle() {
		String parent = d.getWindowHandle();
		Set<String> all = d.getWindowHandles();
		for (String eachId : all) {
			if (!parent.equals(eachId)) {

				d.switchTo().window(eachId);

			}
		}
	}

	public static void fetchTable(List<WebElement> e) {
		for (WebElement all : e) {
			System.out.println(all.getText());
		}
	}

	public static void fetchEvenTable(List<WebElement> e) {
		for (int i = 0; i < e.size(); i = i + 2) {
			WebElement w = e.get(i);
			System.out.println(w.getText());

		}

	}

	public static String readExcel(String fName, String shName, int rowNo, int cellNo) throws IOException {
		File f = new File("C:\\Users\\Ram\\eclipse-workspace\\Facebook\\External\\" + fName + ".xlsx");
		FileInputStream fi = new FileInputStream(f);
		Workbook b = new XSSFWorkbook(fi);
		Sheet s = b.getSheet(shName);
		Row r = s.getRow(rowNo);
		Cell c = r.getCell(cellNo);
		int type = c.getCellType();
		String val;
		if (type == 1) {
			val = c.getStringCellValue();
		} else if (DateUtil.isCellDateFormatted(c)) {
			Date date = c.getDateCellValue();
			SimpleDateFormat sim = new SimpleDateFormat("dd-MM-yyyy");
			val = sim.format(date);

		} else {
			double n = c.getNumericCellValue();
			long l = (long) n;
			val = String.valueOf(l);
		}

		return val;
	}

	public static void createExcel(String fName, String shName, int rowNo, int cellNo, String value)
			throws IOException {
		File f = new File("C:\\Users\\Ram\\eclipse-workspace\\Facebook\\External\\" + fName + ".xlsx");
		Workbook b = new XSSFWorkbook();
		Sheet c = b.createSheet(shName);
		Row r = c.createRow(rowNo);
		Cell cc = r.createCell(cellNo);
		cc.setCellValue(value);
		FileOutputStream fi = new FileOutputStream(f);
		b.write(fi);
		System.out.println("successfully updated.......");

	}

	public static String updateExcel(String fName, String shName, String value, String chvalue) throws IOException {
		File f = new File("C:\\Users\\Ram\\eclipse-workspace\\Facebook\\External\\" + fName + ".xlsx");
		FileInputStream fi = new FileInputStream(f);
		Workbook b = new XSSFWorkbook(fi);
		Sheet s = b.getSheet(shName);

		for (int i = 0; i < s.getPhysicalNumberOfRows(); i++) {
			Row rr = s.getRow(i);

			for (int j = 0; j < rr.getPhysicalNumberOfCells(); j++) {
				Cell cc = rr.getCell(j);
				int type = cc.getCellType();
				String val;
				if (type == 1) {
					val = cc.getStringCellValue();
				} else if (DateUtil.isCellDateFormatted(cc)) {
					Date date = cc.getDateCellValue();
					SimpleDateFormat sim = new SimpleDateFormat("dd-MM-yyyy");
					val = sim.format(date);

				} else {
					double n = cc.getNumericCellValue();
					long l = (long) n;
					val = String.valueOf(l);
				}

				if (val.startsWith(value)) {
					cc.setCellValue(chvalue);
				}
				return val;
			}
		}
		FileOutputStream ff = new FileOutputStream(f);
		b.write(ff);
		System.out.println("successfully updated.......");
		return value;

	}
}
