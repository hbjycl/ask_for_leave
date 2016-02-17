/**
 * 
 */
package cn.com.leave.util;

import net.sf.json.JSONObject;

/**
 * @author wxp
 *
 * @DateTime 2015年12月2日 上午10:46:22
 */
public class DataUtil {

    public static JSONObject getError(String message) {
	JSONObject data = new JSONObject();
	data.put("rc", 1);
	data.put("message", message);
	return data;
    }

    public static JSONObject getSuccess() {
	JSONObject data = new JSONObject();
	data.put("rc", 0);
	return data;
    }
    
    public static JSONObject getData(Object object) {
    	JSONObject data = new JSONObject();
    	data.put("rc", 0);
    	data.put("data", object);
    	return data;
        }
}
