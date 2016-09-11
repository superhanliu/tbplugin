package chenxd.tbplugin.module.client;

import javax.servlet.http.HttpSession;

import org.nutz.ioc.loader.annotation.Inject;
import org.nutz.mvc.annotation.At;
import org.nutz.mvc.annotation.Ok;

import chenxd.tbplugin.dao.AdminConfigDao;
import chenxd.tbplugin.entity.AdminConfig;

/**
 * ÓÃ»§Ä£¿é
 * @author Administrator
 *
 */
public class UserModule {
	
	@Inject
	private AdminConfigDao adminConfigDao;
	
	@At("/user/login")
	@Ok("raw")
	public String login(String user,String pwd,HttpSession session){
		String ac1 = adminConfigDao.getVal(AdminConfig.key_admin_user);
		String ac2 = adminConfigDao.getVal(AdminConfig.key_admin_pwd);
		
		if(ac1.equals(user)&&ac2.equals(pwd)){
			session.setAttribute("login",true);
			return "success";
		}
		return "fail";
	}
}
