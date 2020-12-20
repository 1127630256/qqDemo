package com.qq.util;
import java.util.Collection;
import java.util.Map;
import java.util.Objects;

public class EmptyUtil {

    public static boolean isEmpty(Object obj){
        if (Objects.isNull(obj)) return true;
        if (obj instanceof CharSequence){
            CharSequence charSequence = (CharSequence) obj;
            return charSequence.length() == 0;
        }
        if (obj instanceof Collection){
            Collection collection = (Collection) obj;
            return collection.size() == 0;
        }
        if (obj instanceof Map){
            return ((Map)obj).isEmpty();
        }
        if (obj instanceof Object[]){
            Object[] objects = (Object[]) obj;
            return objects.length == 0;
        }
        return false;
    }

    public static  boolean nonEmpty(Object obj){
        return !isEmpty(obj);
    }
}
