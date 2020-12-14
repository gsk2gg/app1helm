import java.util.*;
import java.lang.*;
import java.io.*;
import java.lang.management.ManagementFactory;
import java.lang.management.OperatingSystemMXBean;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class Test
{
	public static void main (String args[]) throws java.lang.Exception
	{
		try {
		    while (true) {
		        System.out.println("Date:" + new Date());
		        Thread.sleep(5 * 1000); //5 sec
				printUsage();
		    }		    
		} catch(Exception e) {
		    e.printStackTrace();
		} 
	}
	
	
	private static void printUsage() {
	  OperatingSystemMXBean operatingSystemMXBean = ManagementFactory.getOperatingSystemMXBean();
	  for (Method method : operatingSystemMXBean.getClass().getDeclaredMethods()) {
		method.setAccessible(true);
		if (method.getName().startsWith("get")
			&& Modifier.isPublic(method.getModifiers())) {
				Object value;
			try {
				value = method.invoke(operatingSystemMXBean);
			} catch (Exception e) {
				value = e;
			} // try
			System.out.println(method.getName() + " = " + value);
		} // if
	  } // for
	}
}
