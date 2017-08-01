package com.rsa;


/**
 *@author yunlong.liu
 *@date 2017年7月31日
 *@time 下午6:04:26
 *@description 
 */
public class RSATester1 {
	    static String publicKey="MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCRRnY9EvF3nUhQ/FU4zauaEKCcO65Vpy5vHPCxFYnCXYaTQ97vuZ/9LPEAjGo8kJQJwOYmq4bbiPpe+ecMMqwhMg+K2cZuxVY6nHW9bGT3O9hW96OW8Ra2Kcdd56j6sR1AoTsX0AaopJLzvWzmOPbBH3E2BE7ByCiXfKEgRfRY9QIDAQAB"; //自己是公钥
	    static String privateKey="MIICdQIBADANBgkqhkiG9w0BAQEFAASCAl8wggJbAgEAAoGBAJFGdj0S8XedSFD8VTjNq5oQoJw7rlWnLm8c8LEVicJdhpND3u+5n/0s8QCMajyQlAnA5iarhtuI+l755wwyrCEyD4rZxm7FVjqcdb1sZPc72Fb3o5bxFrYpx13nqPqxHUChOxfQBqikkvO9bOY49sEfcTYETsHIKJd8oSBF9Fj1AgMBAAECgYBT43BbjBjLjZM40L0VdA5nhLp5/SyKYWO63edPGrTV+9O+Li8KFxJ/y/fO7UZbetFBYJaGNf5Fvy90sLHupUQnd3NaBtRLcYdj6iJaxi8FwBWkz0ynL136TzalpAw4Xs7RjbouyxR7U33Ew7U9TPH2i8MG5BvTqbnId1Vg9Ao48QJBANMULcbhbAt8rrcPKd0ab5qdUqlasFiKjXHhwRakvKlHSmUnoOvdZbkZD5XjXdN0DgX0MSeyxnubgvF+gmIBlWMCQQCwMToZeytvxYpe2cj/HI7VWWW8pXNvW06lb8RpbJqaqRHGx4juQkYxr3cZUWggyXzquICo9qEFg0wdLyuBN7PHAkBrjqXA6Q84T0FsMILhkt35yF7dw0OG6psmw6WzlyA3lgc3wljCt59lEXsaorAl1sZqjEMb+oIfbF/uFMv1it8HAkA6wX/NhYybrnWRYfEsWfqr3S8XNNmE9h8I/neybHw2PVFnR507TzCXWxtNfx9JZ8fXgoWtUumpq/pS9Sr94XR7AkAtgAvwNCm2r1OR0IItJEg/tuaOd85NXdOXkMv+mUGOWPe783hMpEnULLSQQiyArmtFZEWoS1ucwWlJyNnRcaeS"; //自己的私钥
	    
	    static String publicKey2="MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCsk2b7UaLMLrUqPvv3+8/gJ6PH/zRq4FJcDMlXEOQubDF+zJ58zNc0UeRqLY/A7IxBpHagLgjdjFSshtIdAudOm3mjSrTTZP9a7EFHRhnq3rMFDG6gBfshuz8gfihT1IMJrY5zXfDu57KqR2tWFiB60PR38QRfMM2o/s/TYLfldQIDAQAB"; //对方的公钥
	    static String privateKey2="MIICdQIBADANBgkqhkiG9w0BAQEFAASCAl8wggJbAgEAAoGBAKyTZvtRoswutSo++/f7z+Ano8f/NGrgUlwMyVcQ5C5sMX7MnnzM1zRR5Gotj8DsjEGkdqAuCN2MVKyG0h0C506beaNKtNNk/1rsQUdGGereswUMbqAF+yG7PyB+KFPUgwmtjnNd8O7nsqpHa1YWIHrQ9HfxBF8wzaj+z9Ngt+V1AgMBAAECgYBzlOGTDtD++YVifv6YzvEhysq5pyX/MrBWcEXk5y48HUBlETxQj4zOwM4/grZV2tfxGupMS6iqYVNQnZdZ0NkDQ3paD4XxVXuQL00di7VYkBz7bNeJk8mobg5jo1JrKVQaJhtf8wiM6WFoBnfxSeoe9g+HFovDzRT+dYz47nooIQJBAPGeIXPYTs3SWVFkZHxhsV6U8hTXfujRGWUyVEPBdERsSWgvsN8O1WzzGWYlhna7lA4xoL8azONwUzrYqrJvipkCQQC22S7JgtcfMWfjTg1ahTgQIgT7byDoa7Wlgt02sq33RIhHcAXxzpotRm/gFsNDwmySWYBbQMfkD/uoeZpPZTc9AkAhSo6Fbbp99YvFATYvRS6xP4iTgpXD8nuzS9n8c/1XKCx9JIUUVvDlUCGhx23dkj72LbReYIz2kZWGODBc4a2RAkAOv3m8mycKxwtgFB2TnYcmFfhc51u6I2XlUabSEJtjhE2RpYF1PXrGCBZh9rQNNRNYwotN0O3OgVOFBTnjCYDpAkAY6EaladZS8Nbgg1ELGz7H4ZDb3ILb47OikzsniacQy8La7ICARz/VotLkO5lJe1ClF8G6+32FLQpcY2PqJ8q4"; //对方的私钥

	 
	    
	    static void testHttpSign1() throws Exception {
	    	
	        String param = "id=1&name=张三&age=kkkk";
	        System.out.println("原始数据：" + param);
	        
	        byte[] encodedData = RSAUtils.encryptByPublicKey(param.getBytes(), publicKey2);
	        System.out.println("甲方用乙方的公钥加密后：" + encodedData);
	      
	        String base64Str= Base64Utils.encode(encodedData);
	        System.out.println("甲方传送的数据："+base64Str);
	        
	        String sign = RSAUtils.sign(encodedData, privateKey);
	        System.out.println("甲方用自己的私钥签名后sign：" + sign);
	        
	        boolean status = RSAUtils.verify(Base64Utils.decode(base64Str), publicKey, sign);
	        System.out.println("乙方用甲方的公钥进行签名验证结果：" + status);
	        
	        byte[] decodedData = RSAUtils.decryptByPrivateKey(encodedData, privateKey2);
	        System.out.println("乙方用自己的私钥解密后：" + new String(decodedData));
	    }
	    
	   
	    
	    
	    
	    static void testHttpSign2() throws Exception {
	    	
	    	
	        String param = "id=1&name=张三&age=kkkk";
	        System.out.println("原始数据：" + param);
	        
	        byte[] encodedData = RSAUtils.encryptByPublicKey(param.getBytes("utf-8"), publicKey2);
	        //System.out.println("甲方用乙方的公钥加密后：" + encodedData);
	      
	        //对传入的数据进行64进制转换，以字符串的形式进行传输
	        String base64Str= Base64Utils.encode(encodedData);
	        System.out.println("甲方传送的数据："+base64Str);
	        
	        //对传输的消息取摘要
	        String md5Str=MD5Util.MD5(param); //对消息取摘要
	        
	        //根据摘要生成签名；本来也是可以直接对加密后的消息生成签名，不过因为消息的的字节数过大生成签名耗时较长，2、消息可能被篡改
	        String sign = RSAUtils.sign(md5Str.getBytes("utf-8"), privateKey);
	        System.out.println("甲方用自己的私钥签名后sign：" + sign);
	        
	        
	        //乙方用自己的密钥进行解密
	        byte[] decodedData = RSAUtils.decryptByPrivateKey(Base64Utils.decode(base64Str), privateKey2);
	       // System.out.println("乙方用自己的私钥解密后：" + decodedData);
	        //获得接收到的字符串
	        String param1=new String(decodedData);
	        
	        System.out.println("乙方收到的数据：" + param1);
	        //根据接收到的消息生成摘要
	        String md5Str1=MD5Util.MD5(param1); 
	        //根据摘要摘要进行签名验证
	        boolean status = RSAUtils.verify(md5Str1.getBytes("utf-8"), publicKey, sign);
	        System.out.println("乙方用甲方的公钥进行签名验证结果：" + status);
	        
	    }
	    
	    
	    public static void main(String[] args) {
	    	
	    	try {
	    		testHttpSign2();
			} catch (Exception e) {
				e.printStackTrace();
			}
	    	
		}
	    
}
