package hw11;

import java.lang.reflect.Array;
import java.lang.reflect.Field;

public class reflectToString {

    public static String objToString(Object obj) throws IllegalAccessException {
        Class unknownClass = obj.getClass();
        String className = unknownClass.getSimpleName();
        Field[] allFields = unknownClass.getDeclaredFields();
        StringBuilder sb = new StringBuilder();
        sb.append("\n").append(className).append(" fields:").append("\n\n");
        for (Field field : allFields){
            field.setAccessible(true);
            Exclude annotation = field.getAnnotation(Exclude.class);
            if (annotation == null || annotation.exclude().equals(Exclude.Define.NO)){
                sb.append(field.getType().getSimpleName())
                        .append(" ")
                        .append(field.getName())
                        .append(": ");
                if (field.getType().isArray()){
                    Object array = field.get(obj);
                    int length = Array.getLength(array);
                    sb.append("[");
                    for (int i = 0; i < length; i++){
                        sb.append(Array.get(array, i));
                        if (i != length - 1){
                            sb.append(", ");
                        }
                    }
                    sb.append("]");
                }
                else{
                    sb.append(field.get(obj));
                }
                sb.append("\n");
                field.setAccessible(false);
            }
        }
        return new String(sb);
    }
}
