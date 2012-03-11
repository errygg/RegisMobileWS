package edu.regis.service;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import edu.regis.ws.services.FacultySvc;
import edu.regis.ws.models.Faculty;
 
public class App 
{
    public static void main( String[] args )
    {
    	ApplicationContext appContext = 
    	  new ClassPathXmlApplicationContext("config/BeanLocations.xml");
 
    	FacultySvc facultySvc = (FacultySvc)appContext.getBean("facultySvc");
 
    	/** insert **/
    	Faculty faculty = new Faculty();
    	faculty.setFirstName("John");
    	faculty.setLastName("Doe");
    	facultySvc.save(faculty);
 
    	/** select **/
    	//Stock stock2 = stockBo.findByStockCode("7668");
    	//System.out.println(stock2);
 
    	/** update **/
    	//stock2.setStockName("HAIO-1");
    	//stockBo.update(stock2);
 
    	/** delete **/
    	//stockBo.delete(stock2);
 
    	System.out.println("Done");
    }
}
