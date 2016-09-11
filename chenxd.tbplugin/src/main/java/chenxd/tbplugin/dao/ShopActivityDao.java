package chenxd.tbplugin.dao;

import java.util.List;

import org.nutz.dao.Cnd;
import org.nutz.dao.impl.NutDao;
import org.nutz.ioc.loader.annotation.Inject;
import org.nutz.ioc.loader.annotation.IocBean;

import chenxd.tbplugin.entity.ShopActivity;

@IocBean
public class ShopActivityDao {
	@Inject
	private NutDao dao;
	
	public List<ShopActivity> listByShopId(String shopId){
		return dao.query(ShopActivity.class, Cnd.where("shopId", "=", shopId).desc("addtime"));
	}
	
	public void saveBatch(List<ShopActivity> list){
		for(ShopActivity sa:list){
			int cnt = dao.count(ShopActivity.class, Cnd.where("shopId", "=", sa.getShopid()).and("activityId", "=", sa.getActivityId()));
			if(cnt>0){
				dao.update(sa);
			}else{
				dao.insert(sa);
			}
		}
	}
}
