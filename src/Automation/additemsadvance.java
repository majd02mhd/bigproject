package Automation;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class additemsadvance extends Mytestcases {
	@Test
	public void AddRandomProducts () {
	  java.util.List<String> outOfStockNames = new ArrayList<>();

	   // نكرر العملية لإضافة 10 منتجات كمثال
	        for (int i = 0; i < 10; i++) {

	            // جلب كل المنتجات من الصفحة
	        	java.util.List<WebElement> allItems = driver.findElements(By.className("prdocutname"));

	            // فلترة لإزالة المنتجات Out of Stock
	        	java.util.List<WebElement> availableItems = new ArrayList<>();
	            for (WebElement item : allItems) {
	                if (!outOfStockNames.contains(item.getText())) {
	                    availableItems.add(item);
	                }
	            }

	            // إذا ما في منتجات متاحة توقف
	            if (availableItems.isEmpty()) {
	                System.out.println("ما بقي منتجات متاحة!");
	                break;
	            }

	            // اختيار عنصر عشوائي
	            int randomIndex = rand.nextInt(availableItems.size());
	            WebElement item = availableItems.get(randomIndex);
	            String itemName = item.getText();
	            item.click();

	            // تحقق إذا المنتج Out of Stock
	            while (driver.getPageSource().contains("Out of Stock")) {
	                System.out.println("المنتج Out of Stock، اختيار جديد...");
	                outOfStockNames.add(itemName); // خزّن الاسم

	                driver.navigate().back(); // ارجع للصفحة الرئيسية

	                // تحديث المنتجات بعد العودة
	                allItems = driver.findElements(By.className("prdocutname"));

	                // فلترة جديدة
	                availableItems.clear();
	                for (WebElement it : allItems) {
	                    if (!outOfStockNames.contains(it.getText())) {
	                        availableItems.add(it);
	                    }
	                }

	                // إذا ما في منتجات متاحة توقف
	                if (availableItems.isEmpty()) {
	                    System.out.println("ما بقي منتجات متاحة بعد إزالة Out of Stock!");
	                    break;
	                }

	                // اختيار عنصر جديد
	                randomIndex = rand.nextInt(availableItems.size());
	                item = availableItems.get(randomIndex);
	                itemName = item.getText();
	                item.click();
	            }

	            // إذا ما في منتجات متاحة بعد الفلترة توقف
	            if (availableItems.isEmpty()) {
	                break;
	            }

	            // إضافة المنتج للسلة
	            WebElement addToCartBtn = driver.findElement(By.cssSelector(".cart"));
	            addToCartBtn.click();

	            // العودة للصفحة الرئيسية
	            driver.navigate().to(url);
	            
	        }
	    System.out.println(outOfStockNames);
}
}
