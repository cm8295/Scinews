package gov.lct.util;

public class StringProcess {
	
	/*
	 * 处理字符串中null
	 * 
	 * author:chenming
	 * 2016.05.15
	 * 
	 * */
	public static String getString(String str){
		try {  
            if (str == null)  
                return "";  
            else  
                return str.toString().trim();  
        } catch (NullPointerException npe) {  
            return "";  
        }  
	}

}
