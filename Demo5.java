package com.example.writtenexam;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson2.JSON;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * @projectName: written-exam
 * @package: com.example.writtenexam
 * @className: Demo5
 * @author: 杜博
 * @description: TODO
 * @date: 2022/12/7 10:52
 * @version: 1.0
 */
/*
* 把下面给出的扁平化json数据用递归的方式改写成组织树的形式
* */
public class Demo5 {
    /*
    * 思路： 
    * 1. 将json转为对象List
      2. 将List中所有元素存入map中，键为code，值为对象本身
      3. 遍历map,直至只有一个键值对
      4. 在遍历中取相相应的对象，通过当前遍历对象的parent找到map中对应key的对象，作为其父对象，然后删除录前遍历的键值对。
      5. 取出map中唯一的键值对中的对象
      6. 将该对象转为json字符串将json转为对象存入Map集合，用code做 key，
    * */
    public static void main(String[] args) {
        String src = "  [\n" +
                "    {\n" +
                "      \"id\": \"1\",\n" +
                "      \"name\": \"中国\",\n" +
                "      \"code\": \"110\",\n" +
                "      \"parent\": \"\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"id\": \"2\",\n" +
                "      \"name\": \"北京市\",\n" +
                "      \"code\": \"110000\",\n" +
                "      \"parent\": \"110\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"id\": \"3\",\n" +
                "      \"name\": \"河北省\",\n" +
                "      \"code\": \"130000\",\n" +
                "      \"parent\": \"110\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"id\": \"4\",\n" +
                "      \"name\": \"四川省\",\n" +
                "      \"code\": \"510000\",\n" +
                "      \"parent\": \"110\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"id\": \"5\",\n" +
                "      \"name\": \"石家庄市\",\n" +
                "      \"code\": \"130001\",\n" +
                "      \"parent\": \"130000\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"id\": \"6\",\n" +
                "      \"name\": \"唐山市\",\n" +
                "      \"code\": \"130002\",\n" +
                "      \"parent\": \"130000\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"id\": \"7\",\n" +
                "      \"name\": \"邢台市\",\n" +
                "      \"code\": \"130003\",\n" +
                "      \"parent\": \"130000\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"id\": \"8\",\n" +
                "      \"name\": \"成都市\",\n" +
                "      \"code\": \"510001\",\n" +
                "      \"parent\": \"510000\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"id\": \"9\",\n" +
                "      \"name\": \"简阳市\",\n" +
                "      \"code\": \"510002\",\n" +
                "      \"parent\": \"510000\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"id\": \"10\",\n" +
                "      \"name\": \"武侯区\",\n" +
                "      \"code\": \"51000101\",\n" +
                "      \"parent\": \"510001\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"id\": \"11\",\n" +
                "      \"name\": \"金牛区\",\n" +
                "      \"code\": \"51000102\",\n" +
                "      \"parent\": \"510001\"\n" +
                "    }\n" +
                "  ]";
        //1.转为对象
        List<Region> regions = JSONObject.parseArray(src, Region.class);
        //存入map，并使用code倒序排序
        Map<String,Region> map = new TreeMap<>((s1, s2)->s2.compareTo(s1));
        for (Region region : regions) {
            map.put(region.getCode(),region);
        }
        //遍历map
        while(map.size()>1){
            //取出一个code不为110的键值对
            for (Map.Entry<String, Region> entry : map.entrySet()) {
                if(!entry.getValue().getCode().equals("110")){
                    //取出其父元素的code
                    String key = entry.getValue().getParent();
                    //取出父元素
                    Region parent = map.get(key);
                    //将当前元素赋给父元素作为子元素
                    parent.getChildren().add(entry.getValue());
                    //删除当前元素
                    map.remove(entry.getKey());
                    break;
                }
            }
        }
        //取出110顶级元素
        Region area = map.get("110");
        //转为json
        String json = JSONObject.toJSONString(area);
        System.out.println(json);
        Region region = JSON.parseObject(json, Region.class);
        System.out.println("region = " + region.toString());
    }
}