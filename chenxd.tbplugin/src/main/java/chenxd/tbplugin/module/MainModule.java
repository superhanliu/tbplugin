package chenxd.tbplugin.module;

import org.nutz.ioc.loader.annotation.IocBean;
import org.nutz.mvc.annotation.IocBy;
import org.nutz.mvc.annotation.Modules;
import org.nutz.mvc.annotation.SetupBy;
import org.nutz.mvc.ioc.provider.ComboIocProvider;

/**
 * ²å¼þÖ÷Ä£¿é
 * @author Administrator
 *
 */
@IocBy(type=ComboIocProvider.class, args={
		"*org.nutz.ioc.loader.json.JsonLoader","ioc.js",
		"*org.nutz.ioc.loader.annotation.AnnotationIocLoader","chenxd.tbplugin.module",
		"*org.nutz.ioc.loader.annotation.AnnotationIocLoader","chenxd.tbplugin.filter"
		})
@Modules(scanPackage=true)
@SetupBy(PluginAppSetup.class)
@IocBean(name="mainModule")
public class MainModule {

}
