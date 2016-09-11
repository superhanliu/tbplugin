package chenxd.tbplugin.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.nutz.dao.impl.NutDao;
import org.nutz.ioc.loader.annotation.Inject;
import org.nutz.ioc.loader.annotation.IocBean;

import chenxd.tbplugin.entity.AdminConfig;

@IocBean
public class AdminConfigDao {
	
	@Inject
	private NutDao dao;
	private Map<String,AdminConfig> map = null;
	
	private void checkCache(){
		if(map==null){
			map = new HashMap<String,AdminConfig>();
			List<AdminConfig> list = dao.query(AdminConfig.class, null);
			for(AdminConfig ac:list){
				map.put(ac.getKey(), ac);
			}
		}
	}
	public Map<String,AdminConfig> getAll(boolean exceptUserPwd){
		checkCache();
		
		if(exceptUserPwd){
			Map<String,AdminConfig> m2 = new HashMap<String,AdminConfig>();
			for(Entry<String,AdminConfig> e:map.entrySet()){
				if(e.getKey().equals(AdminConfig.key_admin_user) || e.getKey().equals(AdminConfig.key_admin_pwd)){
					continue;
				}
				m2.put(e.getKey(),e.getValue());
			}
			return m2;
		}
		
		return map;
	}
	
	public void update(String key,String val){
		AdminConfig ac = new AdminConfig();
		ac.setKey(key);
		ac.setVal(val);
		
		dao.update(ac);
		map.put(ac.getKey(), ac);
	}
	
	public String getVal(String key){
		checkCache();
		AdminConfig ac = map.get(key);
		return ac==null?null:ac.getVal();
	}
}
