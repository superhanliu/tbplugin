package chenxd.tbplugin.dao;

import org.nutz.dao.impl.NutDao;
import org.nutz.ioc.IocEventTrigger;

import chenxd.tbplugin.entity.AdminConfig;
import chenxd.tbplugin.entity.ShopActivity;

public class CreateTableIocEvent implements IocEventTrigger<NutDao>{

	@Override
	public void trigger(NutDao obj) {
		obj.create(AdminConfig.class, false);
		obj.create(ShopActivity.class, false);
	}

}
