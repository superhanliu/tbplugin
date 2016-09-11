package chenxd.tbplugin.module.admin;

import java.util.Map;

import org.nutz.ioc.loader.annotation.Inject;
import org.nutz.mvc.annotation.At;
import org.nutz.mvc.annotation.By;
import org.nutz.mvc.annotation.Filters;
import org.nutz.mvc.annotation.Ok;
import org.nutz.mvc.filter.CheckSession;

import chenxd.tbplugin.dao.AdminConfigDao;
import chenxd.tbplugin.entity.AdminConfig;

/**
 * ≈‰÷√
 * @author Administrator
 *
 */
@Filters(@By(type=CheckSession.class, args={"login", "/admin/login.html"}))
@At("/config")
public class ConfigModule {

	@Inject
	private AdminConfigDao adminConfigDao;
	
	@At("/list")
	@Ok("json")
	public Map<String,AdminConfig> list(){
		Map<String,AdminConfig> m = adminConfigDao.getAll(true);
		return m;
	}
	
	@At("/update")
	@Ok("void")
	public void update(String key,String val){
		adminConfigDao.update(key, val);
	}
}
