package com.yinzifan.compare;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;


/**
 * @author yinzf2 2018/03/19 17:43:25
 */
public class Compare {
//    private static final Logger LOGGER = LoggerFactory.getLogger(Compare.class);
    public static <T> String diff(T t1, T t2, String... ignoreProperties)
            throws NoSuchMethodException, SecurityException, IllegalArgumentException, IllegalAccessException {
        
        List<String> ignorePropertiesList = Arrays.asList(ignoreProperties);
        Class<? extends Object> clz1 = t1.getClass();
        Class<? extends Object> clz2 = t2.getClass();
        String clazzName1 = clz1.getName();
        String clazzName2 = clz2.getName();
        if (!clazzName1.equals(clazzName2)) {
            throw new RuntimeException("cannot diff " + clazzName1 + " with " + clazzName2);
        }
        Field[] field1 = clz1.getDeclaredFields();
        for (int i = 0; i < field1.length; i++) {
            Field field = field1[i];
            String fieldName = field.getName();
            if (!ignorePropertiesList.contains(fieldName)) {
                field.setAccessible(true);
                Object v1 = field.get(t1);
                Object v2 = field.get(t2);
                if (v1 == null) {
                    if (v2 == null) {
                        continue;
                    } else if (!v2.equals(v1)) {
                        System.out.println("new value: " + v1 + ", old value: " + v2);
                    }
                } else if (!v1.equals(v2)) {
                    System.out.println("new value: " + v1 + ", old value: " + v2);
                }
            }
        }
        return null;
    }
    
    public static void foo(Map<String, Object> map ) {
        map.put("33", 33);
    }
    
    
    public static void main(String[] args) throws NoSuchMethodException, SecurityException, IllegalArgumentException, IllegalAccessException {
        
        String a = ",qwe,qweq,";
        System.out.println(Arrays.toString(a.split(",")));
        System.out.println(Arrays.toString(StringUtils.splitByCharacterType(a)));
        System.out.println(Arrays.toString(StringUtils.splitByWholeSeparator(a, ",")));
        System.out.println(Arrays.toString(StringUtils.split(a, ",")));
        System.out.println(Arrays.toString(StringUtils.splitByWholeSeparatorPreserveAllTokens(a, ",")));
        
//        boolean flag = DataFormat.stringArrayCompare(new String[]{"a", "e", "c", "b"}, new String[]{"a", "c", "b", "c"});
//        System.out.println(flag);
        
        
        
//        LocalDate d1 = LocalDate.now();
//        LocalDate d2 = LocalDate.parse("2018-04-18");
//        System.out.println(d1.compareTo(d2));
//        List<String> user = new ArrayList<>();
//        user.add("a");
//        user.add("b");
//        user.add("c");
//        user.add("d");
//        user.add("e");
//        user.add("f");
//        String[] array = user.stream().toArray(String[]::new);
//        System.out.println(Arrays.toString(array));
        
        
        
        
        
//        List<String> lists = new ArrayList<>(); 
//        lists.add("s");
//        lists.add("t");
//        lists.add("r");
//        lists.add("i");
//        lists.add("n");
//        lists.add("g");
//        lists.add("1");
//        String str1 = "string2";
//        char index = str1.charAt(str1.length()-1);
//        System.out.println(lists.get(index - '1'));
//        long starttime = System.currentTimeMillis();
//        long endtime = System.currentTimeMillis();
//        System.out.println("duration: "+ (endtime - starttime) + "s");
        
        /*Person p1 = new Person();
        Person p2 = new Person();
        p1.setName("zhangsan");
        p1.setAge(23);
         p1.setAddress("add");
         
         BeanMap beanMap = new BeanMap(p1);
//        BeanMap beanMap = BeanMap.create(p1);
        Set keySet = beanMap.keySet();
        for (Object object : keySet) {
            LOGGER.info("key : {}, value : {}", object, beanMap.get(object));
            System.out.println("key : " + object+ ", value: "+beanMap.get(object));
        }

         p2.setName("lisi");
        p2.setAge(24);
        p2.setAddress("add");
//        diff(p1, p2, "age");
        */
    }
    
    
}
