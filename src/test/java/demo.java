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
      String url = "http://47.111.185.141/data/api/push2";
     // String url = "http://localhost:7080/api/push2";
      String content  = "{\"appKey\": \"hdkj\",\"sign\": \"BBD9E396ED5BFEB73F7EAAD4129B96E6\",\"data\": {\"customerName\": \"齐天大圣\",\"customerMobile\": \"1810201123\",\"houseType\": 1,\"carType\": 2,\"money\": 1000000,\"month\": 12,\"zoneId\": 10086,\"age\": 30,\"salaryBankPublic\": 5100000,\"salaryBankPrivate\": 1,\"isFund\": 1,\"isSecurity\": 1,\"creditCard\": 2,\"isBuyInsurance\": 1,\"weixinLoanAmount\": 4100000,\"alipayLoanAmount\": 0}}";
      String res = HttpUtils.sendPost(url, content);
      System.out.println("返回结果："+res);
  }

}
