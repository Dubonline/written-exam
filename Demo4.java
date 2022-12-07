package com.example.writtenexam;

import com.alibaba.fastjson.JSONObject;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @projectName: written-exam
 * @package: com.example.writtenexam
 * @className: Demo4
 * @author: 杜博
 * @description: TODO
 * @date: 2022/12/7 10:52
 * @version: 1.0
 */
/*
* 对下面的 json 字符串 serial 相同的进行去重。
* 本题通过fastjson解析json，需要fastjson的依赖
* 本题通过fastjson解析json，需要fastjson的依赖
* 本题通过fastjson解析json，需要fastjson的依赖
* <dependency>
    <groupId>com.alibaba</groupId>
    <artifactId>fastjson</artifactId>
    <version>1.2.78</version>
  </dependency>
* */
public class Demo4 {
    public static void main(String[] args) {
        String src= "[{\n" +
                "    \"name\": \"张三\",\n" +
                "    \"serial\": \"0001\"\n" +
                "  }, {\n" +
                "    \"name\": \"李四\",\n" +
                "    \"serial\": \"0002\"\n" +
                "  }, {\n" +
                "    \"name\": \"王五\",\n" +
                "    \"serial\": \"0003\"\n" +
                "  }, {\n" +
                "    \"name\": \"王五2\",\n" +
                "    \"serial\": \"0003\"\n" +
                "  }, {\n" +
                "    \"name\": \"赵四\",\n" +
                "    \"serial\": \"0004\"\n" +
                "  }, {\n" +
                "    \"name\": \"小明\",\n" +
                "    \"serial\": \"005\"\n" +
                "  }, {\n" +
                "    \"name\": \"小张\",\n" +
                "    \"serial\": \"006\"\n" +
                "  }, {\n" +
                "    \"name\": \"小李\",\n" +
                "    \"serial\": \"006\"\n" +
                "  }, {\n" +
                "    \"name\": \"小李2\",\n" +
                "    \"serial\": \"006\"\n" +
                "  }, {\n" +
                "    \"name\": \"赵四2\",\n" +
                "    \"serial\": \"0004\"\n" +
                "  }]";
        //通过fastjson解析json，需要fastjson的依赖
        List<Student> students = JSONObject.parseArray(src, Student.class);
        //去重
        List<Student> newList = students.stream().distinct().collect(Collectors.toList());
        System.out.println(newList);
        //转为json
        String json = JSONObject.toJSONString(newList);
        System.out.println(json);
    }
}