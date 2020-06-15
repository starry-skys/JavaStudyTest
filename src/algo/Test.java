package algo;

import com.alibaba.fastjson.JSONObject;

import java.util.HashMap;
import java.util.StringTokenizer;

public class Test {

    public static  void main(String[] args)  throws Exception {
        HashMap<String,Object> map = new HashMap<>();
        map.put("a","aa");
        map.put("b","bb");
        JSONObject jsonObject = new JSONObject();
        String params = "aa|bb|cc";
        StringTokenizer stringTokenizer = new StringTokenizer(params,"\\|");
        System.out.println(stringTokenizer.nextToken());
        while (stringTokenizer.hasMoreElements()){
            Object e = stringTokenizer.nextElement();
            System.out.println(e + "--");
        }


    }
}
