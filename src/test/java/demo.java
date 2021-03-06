import jdk.nashorn.internal.parser.JSONParser;
import org.testng.annotations.Test;

import java.util.HashMap;

/**
 * 测试类
 */
public class demo {

    /**
     *  将数据的key按
     * 签名测试
     */
    @Test
    public void testSign () {
        String content = "{\"customerName\":\"齐天大圣\",\"customerMobile\":\"1810201123\",\"houseType\":1,\"carType\":2,\"money\":1000000,\"month\":12,\"zoneId\":10086,\"age\":30," +
                "\"salaryBankPublic\":5100000,\"salaryBankPrivate\":1,\"isFund\":1,\"isSecurity\":1,\"creditCard\":2,\"isBuyInsurance\":1,\"weixinLoanAmount\":4100000,\"alipayLoanAmount\":0}";
        String sceret = "sd6FSsbyvxw1f";
        try {
            HashMap<String, String> map = new HashMap<>();
            map.put("customerName","齐天大圣");
            map.put("customerMobile","1810201123");
            map.put("houseType","1");
            map.put("carType","2");
            map.put("money","1000000");
            map.put("month","12");
            map.put("zoneId","10086");
            map.put("age","30");
            map.put("sex","2");
            map.put("salaryBankPublic","5100000");
            map.put("salaryBankPrivate","1");
            map.put("isFund","1");
            map.put("isSecurity","1");
            map.put("creditCard","2");
            map.put("isBuyInsurance","1");
            map.put("weixinLoanAmount","4100000");
            map.put("alipayLoanAmount","0");
            String sign = SignUtils.sign(map, sceret);
            System.out.println("sign:"+sign);
            //BBD9E396ED5BFEB73F7EAAD4129B96E6
        } catch (Exception e) {
            e.printStackTrace();
        }
  }

    /**
     * 测试API
     */
    @Test
  public void testApi () {
      String url = "http://api.haidaikj.com/api/push2";
  //    String url = "http://localhost:7080/api/push2";
      String content  = "{\"appKey\": \"hdkj\",\"sign\": \"3CB57AE3489115CC8AEFF4F045C1F1BB\",\"data\": {\"customerName\":\"齐天大圣\",\"customerMobile\":\"1810201123\",\"houseType\":1,\"carType\":2,\"money\":1000000,\"month\":12,\"zoneId\":10086,\"age\":30,\"sex\":2,\"salaryBankPublic\":5100000,\"salaryBankPrivate\":1,\"isFund\":1,\"isSecurity\":1,\"creditCard\":2,\"isBuyInsurance\":1,\"weixinLoanAmount\":4100000,\"alipayLoanAmount\":0}}";
      String res = HttpUtils.sendPost(url, content);
      System.out.println("返回结果："+res);
  }


    /**
     * 获取数据
     */
    @Test
    public void testGetDataApi() {

        String sceret = "sd6FSsbyvxw1f";
        String appKey = "hdkj";

         String url = "http://api.haidaikj.com/api/miniInfo";
     //   String url = "http://localhost:7080/api/miniInfo";
        HashMap<String, String> map = new HashMap<>();
        map.put("appKey", appKey);
        map.put("did","100001");
        String sign = SignUtils.sign(map, sceret);
        map.put("sign", sign);
        System.out.println("sign:"+sign);
        String res = HttpUtils.sendGet(url, map);
        System.out.println("返回结果：" + res);
    }

    /**
     * 申请退款
     */
    @Test
    public void testRefundApi() {

        String sceret = "sd6FSsbyvxw1f";
        String appKey = "hdkj";

        String url = "http://api.haidaikj.com/api/refund";
        //   String url = "http://localhost:7080/api/miniInfo";
        HashMap<String, String> map = new HashMap<>();
        map.put("appKey", appKey);
        map.put("did","100001");
        String sign = SignUtils.sign(map, sceret);
        map.put("sign", sign);
        System.out.println("sign:"+sign);
        String res = HttpUtils.sendGet(url, map);
        System.out.println("返回结果：" + res);
    }


    @Test
    public void test () {

        int[] arr = new int[]{1,3,1,4,2};
        int taget = 0;
        int j = 0;
        for (int i=0;i<arr.length-1;i++) {
            if ( taget<(arr[i]+arr[i+1]) ) {
                j = i;
            }
        }
        System.out.println(">>>>j:"+j);

    }
}
