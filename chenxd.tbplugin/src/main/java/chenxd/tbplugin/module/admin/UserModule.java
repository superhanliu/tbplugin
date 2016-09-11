package chenxd.tbplugin.module.admin;

import javax.servlet.http.HttpSession;

import org.nutz.ioc.loader.annotation.Inject;
import org.nutz.mvc.annotation.At;
import org.nutz.mvc.annotation.By;
import org.nutz.mvc.annotation.Filters;
import org.nutz.mvc.annotation.Ok;
import org.nutz.mvc.filter.CheckSession;

import chenxd.tbplugin.dao.AdminConfigDao;

/**
 * ÓÃ»§Ä£¿é
 * @author Administrator
 *
 */
@Filters(@By(type=CheckSession.class, args={"login", "/admin/login.html"}))
public class UserModule {
	
	@Inject
	private AdminConfigDao adminConfigDao;
		
	@At("/user/logout")
	@Ok("raw")
	public String logout(HttpSession session){
		session.removeAttribute("login");
		return "success";
	}
}
