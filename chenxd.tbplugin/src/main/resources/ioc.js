var ioc = {
	ds : {
		type : "org.apache.commons.dbcp.BasicDataSource",
		events : {
			depose : "close"//,
			//create : 'com.bestniu.db.H2DbIocCreateEvent',// startup h2 db
			//depose : 'com.bestniu.db.H2DbIocDeposeEvent'// stop h2 db
		},
		fields : {
			driverClassName : 'com.mysql.jdbc.Driver',
			url : 'jdbc:mysql://127.0.0.1:3306/tbplugin?useUnicode=true&characterEncoding=GBK&zeroDateTimeBehavior=convertToNull&transformedBitIsBoolean=true',
			username : 'root',
			password : 'chenxd',
			initialSize : 5,
			maxActive : 20,
			testOnReturn : true,
			validationQuery : "select 1"
		}
	},

	dao : {
		type : "org.nutz.dao.impl.NutDao",
		fields : {
			dataSource : {
				refer : 'ds'
			}
		},
		events : {
			create : 'com.bestniu.paint.db.CreateTableIocEvent'// create table
																// if needed
		}
	}
};
