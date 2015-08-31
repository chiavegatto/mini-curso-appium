package com.qualityplus.appium;

import static org.junit.Assert.assertEquals;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import junit.framework.Assert;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

public class CalcIMCTest {
protected AndroidDriver<MobileElement> driver;
	
	@Test
	public void calculaIMCComLocalizadorID() throws MalformedURLException{
		File appFile = new File("apk/calculaIMC.apk");
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, MobilePlatform.ANDROID);
		capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Android Emulator");
		capabilities.setCapability(MobileCapabilityType.APP, appFile);
		driver = new AndroidDriver<MobileElement> (new URL("http://127.0.0.1:4723/wd/hub"), capabilities);

		driver.findElement(By.id("com.example.calculaimc:id/edittext_peso")).sendKeys("80");
		driver.findElement(By.id("com.example.calculaimc:id/edittext_altura")).sendKeys("1.59");
		driver.findElement(By.id("com.example.calculaimc:id/button_calcular")).click();
		Assert.assertEquals("31.644317867172973", driver.findElement(By.id("com.example.calculaimc:id/edittext_calculoIMC")).getText());
	}
	
	@Test
	public void calculaIMCComLocalizadorClassName() throws MalformedURLException{
		File appFile = new File("apk/calculaIMC.apk");
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, MobilePlatform.ANDROID);
		capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Android Emulator");
		capabilities.setCapability(MobileCapabilityType.APP, appFile);
		driver = new AndroidDriver<MobileElement> (new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
		
		driver.findElements(By.className("android.widget.EditText")).get(0).sendKeys("80");
		driver.findElements(By.className("android.widget.EditText")).get(1).sendKeys("1.59");
		driver.findElement(By.className("android.widget.Button")).click();
		Assert.assertEquals("31.644317867172973", driver.findElement(By.className("android.widget.EditText")).getText());
	}
	
	@Test
	public void calculaIMCComLocalizadorXpath() throws MalformedURLException{
		File appFile = new File("apk/calculaIMC.apk");
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, MobilePlatform.ANDROID);
		capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Android Emulator");
		capabilities.setCapability(MobileCapabilityType.APP, appFile);
		driver = new AndroidDriver<MobileElement> (new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
		
		driver.findElement(By.xpath("//android.widget.EditText")).sendKeys("80");
		driver.findElement(By.xpath("//android.widget.LinearLayout/android.widget.EditText[2]")).sendKeys("1.59");
		driver.findElement(By.xpath("//android.widget.LinearLayout/android.widget.Button[@text='Calcular']")).click();
		
	}
	
	@Test
	public void calculaIMCComLocalizadorAccessibilityI() throws MalformedURLException{
		File appFile = new File("apk/calculaIMC.apk");
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, MobilePlatform.ANDROID);
		capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Android Emulator");
		capabilities.setCapability(MobileCapabilityType.APP, appFile);
		driver = new AndroidDriver<MobileElement> (new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
		
		driver.findElementByAccessibilityId("peso").sendKeys("80");
		driver.findElementByAccessibilityId("altura").sendKeys("1.59");
		driver.findElementByAccessibilityId("botao_calcular").click();
		
	}


	@Before
	public void iniciarTestes() throws MalformedURLException{}
	
	@After
	public void finalizarTestes(){
		driver.quit();
	}
}
