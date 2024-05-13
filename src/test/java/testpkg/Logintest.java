package testpkg;

import java.security.PublicKey;
import java.time.Duration;
import java.util.List;

import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import Basepkg.Baseclass;
import pagepkg.Sausedemologin;
import Utilities.Excelutilities;

public class Logintest extends Baseclass{
	@Test
	public void verifyLoginWithValidCred () throws Exception

	{
		Sausedemologin p1 = new Sausedemologin(driver);

	// Reading the data from excel file by the specified path

	            String xl = "E:\\sample2.xlsx";

	            String Sheet = "Sheet1";

	            int rowCount = Excelutilities.getRowCount(xl, Sheet);

	            for (int i=1;i<=rowCount;i++)

	            {
	            	  driver.navigate().refresh();

	                        String UserName=Excelutilities.getCellValue(xl, Sheet, i, 0);
                               System.out.println("username---"+UserName);
	                        String Pwd=Excelutilities.getCellValue(xl, Sheet, i, 1);
                             System.out.println("password---"+Pwd);
	                        //Passing Username and password as parameters
	                        p1.setvalues(UserName, Pwd);
	                  	
                         //Submitting the data by clicking on login button   
	                       
	                      
                             p1.clickLoginBtn();
                                                          
                     		
	                        
	                        
	                        String expectedurl="https://www.saucedemo.com/v1/inventory.html";
	          			  String actualurl= driver.getCurrentUrl();
	          			  
	          			     if(actualurl.equals(expectedurl))
	          			     {
	          			    	System.out.println("pass");
	          			     }else
	          			     {
	          			    	System.out.println("fail");
	          			     }
	                         

	                
	          			     
	            }
	            
	           
	           
	          
	            
}
	@Test(priority = 2)
	public void addtpcart() throws Exception
	{
	    
        List<WebElement> pElements=driver.findElements(By.xpath("/html/body/div/div[2]/div[2]/div/div[2]/div/div/div[3]/button"));
		for(WebElement xElement : pElements)

		{
			
			String txtString=xElement.getText();
			
			if(txtString.equalsIgnoreCase("Add to Cart"))
			{
				xElement.click();
				
				
			}
			
			
			
		
		}

		
	}


	@Test(priority = 3)
	public void cartclick() throws Exception
	{
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
		driver.findElement(By.xpath("/html/body/div/div[2]/div[1]/div[2]/a")).click();
		driver.findElement(By.xpath("/html/body/div/div[2]/div[3]/div/div[2]/a[2]")).click();
	
		driver.findElement(By.xpath("//*[@id=\"first-name\"]")).sendKeys("Arya ");
		driver.findElement(By.xpath("//*[@id=\"last-name\"]")).sendKeys("Raju");
		driver.findElement(By.xpath("//*[@id=\"postal-code\"]")).sendKeys("34567");
		driver.findElement(By.xpath("/html/body/div/div[2]/div[3]/div/form/div[2]/input")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("/html/body/div/div[1]/div/div[3]/div/button")).click();
		driver.findElement(By.xpath("/html/body/div/div[1]/div/div[2]/div[1]/nav/a[3]")).click();
		
	}


	

}
