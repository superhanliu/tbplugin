package chenxd.tbplugin.module.admin;

import java.util.List;

import org.nutz.ioc.loader.annotation.Inject;
import org.nutz.mvc.annotation.At;
import org.nutz.mvc.annotation.By;
import org.nutz.mvc.annotation.Filters;
import org.nutz.mvc.annotation.Ok;
import org.nutz.mvc.filter.CheckSession;

import chenxd.tbplugin.dao.ShopActivityDao;
import chenxd.tbplugin.entity.ShopActivity;
import chenxd.tbplugin.service.HttpService;

/**
 * 数据收集
 * @author Administrator
 *
 */
@Filters(@By(type=CheckSession.class, args={"login", "/admin/login.html"}))
public class PageCollectModule {

	@Inject
	private HttpService httpService;
	@Inject
	private ShopActivityDao shopActivityDao;
	
	@At("/admin/collect")
	@Ok("raw")
	public int collect(String url){
		List<ShopActivity> saList = httpService.getShopActivityList(url);
		shopActivityDao.saveBatch(saList);
		return saList.size();
	}
}
