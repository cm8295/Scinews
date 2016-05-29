package gov.lct.util;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;
import gov.lct.model.Tupload;
/**
 * 处理json字符串工具类
 * @author chenming
 *
 */
public class JSONUtil {
	/**
	 * 将list列表转为json字符串
	 * @param list 用户列表
	 * @return json字符串
	 */
	public static String listUserToJsonString(List<Tupload> list){
		StringBuilder sb = new StringBuilder();
		int len = list.size();
		sb.append("{\"total\":"+len+",\"rows\":[");


		for(int i=0;i<len;i++){
			Tupload tupload = list.get(i);
			sb.append("{\"file1\":\""+tupload.getFile1()+"\",");
			sb.append("\"file2\":\""+tupload.getFile2()+"\",");
			sb.append("\"file3\":\""+tupload.getFile3()+"\",");
			sb.append("\"file4\":\""+tupload.getFile4()+"\",");
			sb.append("\"file5\":\""+tupload.getFile5()+"\",");
			sb.append("\"file6\":\""+tupload.getFile6()+"\",");
			sb.append("\"file7\":\""+tupload.getFile7()+"\",");
			sb.append("\"file8\":\""+tupload.getFile8()+"\",");
			sb.append("\"file9\":\""+tupload.getFile9()+"\",");
			sb.append("\"file10\":\""+tupload.getFile10()+"\",");
			sb.append("\"file11\":\""+tupload.getFile11()+"\",");
			sb.append("\"file12\":\""+tupload.getFile12()+"\",");
			sb.append("\"file13\":\""+tupload.getFile13()+"\",");
			sb.append("\"file14\":\""+tupload.getFile14()+"\",");
			//sb.append("\"suggestion\":\""+tupload.getSuggestion()+"\",");
			sb.append("\"loginname\":\""+tupload.getLoginname()+"\"}");
			if(i<len-1){
				sb.append(",");
			}
		}	

		sb.append("]}");
		return sb.toString();
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static String listToJsonString(List list, int len){
		StringBuilder sb = new StringBuilder();		
		sb.append("{\"total\":"+len+",\"rows\":[");
		if(list.size()>0){
			Object item = list.get(0);
			Field[] field = item.getClass().getDeclaredFields();
			int listLen = list.size();
			for(int i=0;i<listLen;i++){
				Object p = list.get(i);
				Class c = p.getClass();
				sb.append("{");
				for(int j = 0;j<field.length;j++){
					String aName = field[j].getName();
					
					try {
						Method method = c.getDeclaredMethod("get"+aName.substring(0,1).toUpperCase()+aName.substring(1));
						String value = "";
						Object value1 = method.invoke(p);
						if(value1!=null){
							value = method.invoke(p).toString().replace("\n", " ");
						}
						sb.append("\""+aName+"\":\""+ value +"\"");
					} catch (SecurityException e) {
						e.printStackTrace();
					} catch (NoSuchMethodException e) {
						e.printStackTrace();
					} catch (IllegalArgumentException e) {
						e.printStackTrace();
					} catch (IllegalAccessException e) {
						e.printStackTrace();
					} catch (InvocationTargetException e) {
						e.printStackTrace();
					}
					if(j<field.length-1){
						sb.append(",");
					}
				}
				sb.append("}");
				if(i<listLen-1){
					sb.append(",");
				}
			}	
		}

		sb.append("]}");
		return sb.toString();		
	}
}