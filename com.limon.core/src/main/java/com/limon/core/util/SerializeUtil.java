package com.limon.core.util;

import com.alibaba.fastjson.JSONObject;

public class SerializeUtil {
	
	public static <T extends Object> String serializeObject(T t){
        String str = JSONObject.toJSONString(t);
        return str;
    }
	
	public static <T extends Object> Object deserializeObject(String value,T t){
		if(value==null|| "".equals(value)) {
            return null;
        }
        if(t instanceof String){
            return new String(value);
        }else if(t instanceof Short){
            return new Short(value);
        }else if(t instanceof Integer){
            return new Integer(value);
        }else if(t instanceof Long){
            return new Long(value);
        }else if(t instanceof Float){
            return new Float(value);
        }else if(t instanceof Double){
            return new Double(value);
        }else if(t instanceof Boolean){
            return new Boolean(value);
        }else if(t instanceof Object) {
            try {
            	return (T) JSONObject.parseObject(value, t.getClass());
            } catch (Exception e) {
                return null;
            }
        }
        return null;
	}

}
