package chenxd.tbplugin.entity;

import org.nutz.dao.entity.annotation.Table;

/*
 * µÍ∆ÃªÓ∂Ø
 * @author Administrator
 *
 */
@Table("t_shop_activity")
public class ShopActivity {

	private String shopid;
	private String activityId;
	private long addtime;
	
	public String getShopid() {
		return shopid;
	}

	public void setShopid(String shopid) {
		this.shopid = shopid;
	}

	public String getActivityId() {
		return activityId;
	}

	public void setActivityId(String activityId) {
		this.activityId = activityId;
	}

	public long getAddtime() {
		return addtime;
	}

	public void setAddtime(long addtime) {
		this.addtime = addtime;
	}

}
