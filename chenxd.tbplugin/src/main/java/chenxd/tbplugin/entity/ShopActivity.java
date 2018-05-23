package chenxd.tbplugin.entity;

import org.nutz.dao.entity.annotation.ColDefine;
import org.nutz.dao.entity.annotation.Table;

/*
 * 店铺活动
 * @author Administrator
 *
 */
@Table("t_shop_activity")
public class ShopActivity {

	private String shopid;
	private String activityId;
	private long addtime;
	@ColDefine(width=500)
	private String activityContent;
	
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
