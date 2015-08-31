package com.qualityplus.appium;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

public class ClickCoordenadas {
	protected AndroidDriver<MobileElement> driver;
	
	@Before
	public void iniciarTestes() throws MalformedURLException{
		File appFile = new File("apk/Consumo-Gasolina.apk");
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, MobilePlatform.ANDROID);
		capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Android Emulator");
		capabilities.setCapability(MobileCapabilityType.APP, appFile);
		driver = new AndroidDriver<MobileElement> (new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
	}
	
	@Test
	public void clickCoordenadaBotaoCalcular(){
		System.out.println(driver.findElement(By.id("br.com.consumogasolina:id/action_opcoes")).getLocation().getX());
		System.out.println(driver.findElement(By.id("br.com.consumogasolina:id/action_opcoes")).getLocation().getY());
		driver.tap(1,912,75, 1);
		System.out.println(driver.findElementByAndroidUIAutomator("new UiSelector().text(\"Adicionar Abastecimento\")").getLocation().getX());
		System.out.println(driver.findElementByAndroidUIAutomator("new UiSelector().text(\"Adicionar Abastecimento\")").getLocation().getY());
		//driver.findElement(By.xpath("//android.widget.TextView[@text='Adicionar Abastecimento']")).click();
		driver.tap(1,404,254, 1);
		//zoom em uma coordenada
		driver.pinch(300, 200);
		//driver.swipe(startx, starty, endx, endy, duration);
		driver.swipe(500, 1, 500, 1000, 300);
		
	}
}
