package gov.lct.util;

import java.io.UnsupportedEncodingException;
import java.util.ResourceBundle;

/**
 * 功能：属性文件操作工具类
 * 
 * 版本:1.0
 * 
 * 开发者:向彬
 * 
 * 开发地点：四川成都科分院文献情报中心信息技术部
 * 
 * 开发(最近修改)时间： 2012-7-9[下午3:20:37]
 */
public class PropUtil {

	/**
	 * 获取中文解析值
	 * 
	 * @param key
	 * @return
	 * @throws UnsupportedEncodingException
	 */
	public static String getParseKey(String cfgPath, String key)
			throws UnsupportedEncodingException {
		return new String(PropUtil.getString(cfgPath, key).getBytes(
				"ISO-8859-1"), "UTF-8");
	}

	/**
	 * 根据属性文件路径的键读取值
	 * 
	 * @param propPath
	 * @param key
	 * @return
	 */
	private static String getString(String propPath, String key) {
		try {
			return ResourceBundle.getBundle(propPath).getString(key).trim();
		} catch (Exception e) {
			return '!' + key + '!';
		}
	}
}
