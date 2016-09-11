package chenxd.tbplugin.entity;

import org.nutz.dao.entity.annotation.ColDefine;
import org.nutz.dao.entity.annotation.Name;
import org.nutz.dao.entity.annotation.Table;

/**
 * π‹¿Ì≈‰÷√
 * 
 * @author Administrator
 *
 */
@Table("t_admin_config")
public class AdminConfig {
	public static final String key_url1 = "url1";
	public static final String key_url2 = "url2";
	public static final String key_url3 = "url3";
	public static final String key_url4 = "url4";
	public static final String key_url5 = "url5";
	public static final String key_url6 = "url6";
	public static final String key_url7 = "url7";
	public static final String key_logo = "logo";
	public static final String key_banner = "banner";
	public static final String key_ver = "ver";
	public static final String key_file = "fileurl";

	public static final String key_admin_user = "user";
	public static final String key_admin_pwd = "pwd";

	@ColDefine(width = 50)
	@Name
	private String key;
	
	@ColDefine(width = 500)
	private String val;

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getVal() {
		return val;
	}

	public void setVal(String val) {
		this.val = val;
	}

}
