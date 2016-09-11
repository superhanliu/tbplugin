package chenxd.tbplugin.service;

import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.nutz.http.Header;
import org.nutz.http.Http;
import org.nutz.http.Request;
import org.nutz.http.Response;
import org.nutz.http.Sender;
import org.nutz.ioc.loader.annotation.IocBean;

import chenxd.tbplugin.entity.ShopActivity;

@IocBean
public class HttpService {

	public List<ShopActivity> getShopActivityList(String url){
		Response resp = Http.get(url);
		String html = resp.getContent();
		List<ShopActivity> list = new ArrayList<ShopActivity>();
		
		Document doc = Jsoup.parse(html);
		
		Elements eles = doc.getElementsByTag("a");
		for(int i=0;i<eles.size();i++){
			Element ele = eles.get(i);
			String href = ele.attr("href");
			if(href!=null){
				String activityId = getParmValue(href,"activity_id=");
				if(activityId==null)
					activityId = getParmValue(href,"activityId=");
				
				if(activityId==null)
					continue;
				
				String sellerId = getParmValue(href,"sellerId=");
				if(sellerId==null)
					continue;
				
				ShopActivity sa = new ShopActivity();
				sa.setShopid(sellerId);
				sa.setActivityId(activityId);
				sa.setAddtime(System.currentTimeMillis());
				list.add(sa);
			}
		}
		return list;
	}
		
	public String getCoupon(String sellerId,String activityId){
		String url="https://shop.m.taobao.com/shop/coupon.htm?&sellerId="+sellerId+"&activityId="+activityId;
		Request r= Request.get(url);
		Header h = Header.create();
		h.set("User-Agent", "Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/47.0.2526.80 Safari/537.36 Core/1.47.640.400 QQBrowser/9.4.8309.400");
//		h.set("host","shop.m.taobao.com");
		r.setHeader(h);
		Response resp = Sender.create(r).send();
		
		String html = resp.getContent();
		
		Document doc = Jsoup.parse(html);
		Elements couponDivs = doc.select("div.coupon-info");
		if(couponDivs.size()>0){
			Element ele = couponDivs.get(0);
			System.out.println(ele.text());
			return ele.text();
		}
		return null;
	}
	
	private String getParmValue(String href,String posStr){
		int idx =  href.indexOf(posStr);
		if(idx!=-1){
			int idx2 = href.indexOf("&",idx);
			return idx2==-1?href.substring(idx+posStr.length()):href.substring(idx+posStr.length(),idx2);
		}
		return null;
	}
	
	public static void main(String[] a){
		HttpService hs = new HttpService();
//		hs.getCoupon("2234110902","54f7b2f3dc5e42a897234dd06791060d");
		
		String url="http://baicai.manmanbuy.com/Default_New.aspx?DA=1&action=Pull-downLoad&zcid=0&ipage=1&protype=0&key=&classpy=jujia&orderby=id";
		List<ShopActivity> list = hs.getShopActivityList(url);
		for(ShopActivity sa:list){
			System.out.println("µÍ∆ÃªÓ∂Ø£∫"+sa.getShopid()+":"+sa.getActivityId());
			String res = hs.getCoupon(sa.getShopid(),sa.getActivityId());
			System.out.println(res);
		}
	}
}
