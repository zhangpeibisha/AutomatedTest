package org.nix.service.product.info;


public class TestThirdInterface {
	
//	public static WebClient client = null;
//
//	public static String secret_key = "c5fkK157lBsy91uC";
//
//	public static final String baseUrl = "http://t.openapi.yum.com.cn/couponTrans/rest/couponTrans/";
//
//	//1发放  2核销 3撤销  4冲正  5对账 6动态折扣券
//	private static int flag = 6;
//
//	@SuppressWarnings("unchecked")
//	public static void main(String[] args) {
//
//		client = WebClient.create(baseUrl,CouponUtils.getCustomizeJsonStyle());
//
//		client.accept(MediaType.APPLICATION_JSON).type(MediaType.APPLICATION_JSON);
//
//		client.path("invoke");
//
//		CommonParamIn in = getParam();
//
//		try{
//			Response response = client.post(in);
//
//			System.err.println("---------consume----status---------------"+response.getStatus());
//
//			if(response.getStatus()==200){
//				CommonParamOut out = response.readEntity(CommonParamOut.class);
//
//				System.out.println("out:======================"+out.toString());
//
//				switch (flag){
//
//				case 1:
//					byte[] decryptResult1 = EncodeAES.decrypt(Base64.decodeBase64(out.getParam()), secret_key);
//					System.out.println("decode JSONString:"+new String(decryptResult1));
//
//					JSONObject jsonObj = JSONObject.fromObject(new String(decryptResult1));
//					PlaceCouponOut result1 = (PlaceCouponOut)CouponUtils.jsonString2Object(new String(decryptResult1),PlaceCouponOut.class);
//					//数组单独转换
//					List<CouponInfo> list = jsonString2List(jsonObj.getString("couponInfos"),CouponInfo.class);
//
//					result1.setCouponInfos(list);
//
//					System.out.println("decode param:"+result1.toString());
//
//					break;
//
//				case 2:
//					byte[] decryptResult2 = EncodeAES.decrypt(Base64.decodeBase64(out.getParam()), secret_key);
//					UseCouponOut result2 = (UseCouponOut)CouponUtils.jsonString2Object(new String(decryptResult2),UseCouponOut.class);
//					System.out.println("decode param:"+result2);
//					break;
//
//				case 3:
//					byte[] decryptResult3 = EncodeAES.decrypt(Base64.decodeBase64(out.getParam()), secret_key);
//					CancelCouponCodeOut result3 = (CancelCouponCodeOut)CouponUtils.jsonString2Object(new String(decryptResult3),CancelCouponCodeOut.class);
//					System.out.println("decode param:"+result3);
//					break;
//
//				case 4:
//					byte[] decryptResult4 = EncodeAES.decrypt(Base64.decodeBase64(out.getParam()), secret_key);
//					CorrectCouponOut result4 = (CorrectCouponOut)CouponUtils.jsonString2Object(new String(decryptResult4),CorrectCouponOut.class);
//					System.out.println("decode param:"+result4);
//					break;
//
//				case 5:
//					byte[] decryptResult5 = EncodeAES.decrypt(Base64.decodeBase64(out.getParam()), secret_key);
//					CouponReportOut result5 = (CouponReportOut)CouponUtils.jsonString2Object(new String(decryptResult5),CouponReportOut.class);
//					JSONObject jsonObj5 = JSONObject.fromObject(new String(decryptResult5));
//					List<CouponStatus> list5 = jsonString2List(jsonObj5.getString("couponStatus"),CouponStatus.class);
//
//					result5.setCouponStatus(list5);
//
//					System.out.println("decode param:"+result5);
//					break;
//
//				case 6:
//					byte[] decryptResult6 = EncodeAES.decrypt(Base64.decodeBase64(out.getParam()), secret_key);
//					System.out.println("decode JSONString:"+new String(decryptResult6));
//
//					JSONObject jsonObj6 = JSONObject.fromObject(new String(decryptResult6));
//					PlaceCouponOut result6 = (PlaceCouponOut)CouponUtils.jsonString2Object(new String(decryptResult6),PlaceCouponOut.class);
//					//数组单独转换
//					List<CouponInfo> list2 = jsonString2List(jsonObj6.getString("couponInfos"),CouponInfo.class);
//
//					result6.setCouponInfos(list2);
//
//					System.out.println("decode param:"+result6.toString());
//
//					break;
//
//				}
//
//
//			}
//
//		}catch(Exception e){
//			e.printStackTrace();
//		}
//	}
//
//	@SuppressWarnings({ "unchecked", "rawtypes" })
//	public static List jsonString2List(String jsonString, Class pojoCalss) {
//
//		JSONArray ary = JSONArray.fromObject(jsonString);
//
//		Collection<Object> list = JSONArray.toCollection(ary, pojoCalss);
//
//		List<Object> result = new ArrayList<Object>();
//
//		result.addAll(list);
//
//		return result;
//	}
//
//	public static CommonParamIn getParam(){
//
//		String in = "";
//
//		switch (flag){
//
//		case 1:
//			in = CouponUtils.object2JsonString(getParam1()).toString();
//			break;
//
//		case 2:
//			in = CouponUtils.object2JsonString(getParam2()).toString();
//			break;
//
//		case 3:
//			in = CouponUtils.object2JsonString(getParam3()).toString();
//			break;
//
//		case 4:
//			in = CouponUtils.object2JsonString(getParam4()).toString();
//			break;
//
//		case 5:
//			in = CouponUtils.object2JsonString(getParam5()).toString();
//			break;
//
//		case 6:
//			in = CouponUtils.object2JsonString(getParam6()).toString();
//			break;
//
//		}
//
//		String param = Base64.encodeBase64String(EncodeAES.encrypt(in, secret_key));
//
//		CommonParamIn cc = new CommonParamIn();
//
//		cc.setInterfaceName(String.valueOf(flag));
//		cc.setParam(param);
//		cc.setRemark("nopic");
//		cc.setEncrypt("true");
//		cc.setChannelId("220009");
//
//		System.out.println("CommonParamIn:"+cc.toString());
//
//		return cc;
//	}
//
//	public static PlaceCouponIn getParam1(){
//
//		PlaceCouponIn in = new PlaceCouponIn();
//		in.setActivityId("EBUYTEST0001");
//		in.setTransactionID(GetRandom.randomNum(32));
//		List<String> list = new ArrayList<String>();
//		list.add("test20160218");
//		in.setUserCodes(list);
//		in.setTransTime(new Date());
//		in.setChannelId("220009");
//		String key = "f34bf9c911994e17950eaae5cbf710a0";
//		in.setSignature(CouponUtils.getMd5Upper(in.toString()+key, null));
//
//		System.out.println(in.toString()+key);
//		System.out.println(in.getSignature());
//
//		return in;
//	}
//
//	public static UseCouponIn getParam2(){
//
//		UseCouponIn in = new UseCouponIn();
//
//		in.setCouponCode("P2U5BTSZ2D927Z74A");
//		in.setOrderId(GetRandom.randomStrNum(32));
//		in.setOrderAmount(-1);
//		in.setUserCode("test20160218");
//		in.setMerchantPosId("231312");
//
//		in.setTransactionID(GetRandom.randomNum(32));
//
//		in.setTransType(1);
//		in.setTransTime(new Date());
//		in.setChannelId("220009");
//		String key = "f34bf9c911994e17950eaae5cbf710a0";
//		in.setSignature(CouponUtils.getMd5Upper(in.toString()+key, null));
//
//		System.out.println(in.toString());
//		System.out.println(in.getSignature());
//
//		return in;
//	}
//
//	public static CancelCouponCodeIn getParam3(){
//
//		CancelCouponCodeIn in = new CancelCouponCodeIn();
//		List<String> couponCodes = new ArrayList<String>();
//		couponCodes.add("EBZTZ447R423");
//		in.setCouponCodes(couponCodes);
//		in.setTransactionID(GetRandom.randomNum(32));
//
//		in.setTransType(1);
//		in.setTransTime(new Date());
//		in.setChannelId("220009");
//		String key = "f34bf9c911994e17950eaae5cbf710a0";
//		in.setSignature(CouponUtils.getMd5Upper(in.toString()+key, null));
//
//		System.out.println(in.toString());
//
//		System.out.println(in.getSignature());
//
//		return in;
//	}
//
//	public static CorrectCouponIn getParam4(){
//
//		CorrectCouponIn in = new CorrectCouponIn();
//		in.setOriginalTransactionId("74873558275674716887116748167613");
//		in.setTransactionID(GetRandom.randomNum(32));
//
//		in.setTransType(1);
//		in.setTransTime(new Date());
//		in.setChannelId("220009");
//		String key = "f34bf9c911994e17950eaae5cbf710a0";
//		in.setSignature(CouponUtils.getMd5Upper(in.toString()+key, null));
//
//		System.out.println(in.toString());
//		System.out.println(in.getSignature());
//
//		return in;
//	}
//
//	public static CouponReportIn getParam5(){
//
//		CouponReportIn in = new CouponReportIn();
//		List<String> couponCodes = new ArrayList<String>();
//		couponCodes.add("4Y56XPA2P4U468MF2");
//		in.setCouponCodes(couponCodes);
//
//		in.setChannelId("220009");
//		String key = "f34bf9c911994e17950eaae5cbf710a0";
//		in.setSignature(CouponUtils.getMd5Upper(in.toString()+key, null));
//
//		return in;
//	}
//
//	public static PlaceCouponVIn getParam6(){
//
//		PlaceCouponVIn in = new PlaceCouponVIn();
//		in.setActivityId("EBUYTEST0001");
//		in.setTransactionID(GetRandom.randomNum(32));
//		List<String> list = new ArrayList<String>();
//		list.add("Tst1234");
//		in.setUserCodes(list);
//
//		in.setSalePrice(300);
//		in.setDiscount(200);
//
//		in.setTransTime(new Date());
//		in.setChannelId("220009");
//		String key = "f34bf9c911994e17950eaae5cbf710a0";
//		in.setSignature(CouponUtils.getMd5Upper(in.toString()+key, null));
//
//		System.out.println(in.toString()+key);
//		System.out.println(in.getSignature());
//
//		return in;
//	}

}
