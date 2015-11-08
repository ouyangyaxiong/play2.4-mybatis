package module;

import javax.sql.DataSource;

import models.Product;
import module.domain.Computer;
import module.domain.ComputerDao;
import module.domain.mapper.ComputerMapper;
import module.domain.mapper.ProductMapper;

import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;
import org.mybatis.guice.MyBatisModule;

import play.db.Database;
import service.module.UserMapper;

import com.google.inject.Inject;
import com.google.inject.Provider;
import com.google.inject.Singleton;
import com.google.inject.name.Names;

public class Dependencies extends MyBatisModule {

	// @Override
	// protected void initialize() {
	//
	// final Properties properties = new Properties();
	//
	// String driver = play.Configuration.root()
	// .getString("db.default.driver");
	//
	// String url = play.Configuration.root().getString("db.default.url");
	//
	// String user = play.Configuration.root().getString("db.default.user");
	//
	// String password = play.Configuration.root().getString(
	// "db.default.password");
	//
	// properties.setProperty("mybatis.environment.id", "demo1");
	//
	// properties.setProperty("JDBC.driver", driver);
	//
	// properties.setProperty("JDBC.url", url);
	//
	// properties.setProperty("JDBC.username", user);
	// System.out.println("数据库设置"+user);
	// properties.setProperty("JDBC.password", password);
	//
	// properties.setProperty("JDBC.autoCommit", "false");
	//
	// bindDataSourceProviderType(PooledDataSourceProvider.class);
	//
	// bindTransactionFactoryType(JdbcTransactionFactory.class);
	//
	// addMapperClasses("module.domain.mapper");
	//
	// bind(ComputerDao.class).to(Computer.class);
	//
	// Names.bindProperties(this.binder(), properties);
	//
	// }
	protected void initialize() {
		environmentId("development");
		bindConstant().annotatedWith(
				Names.named("mybatis.configuration.failFast")).to(true);
		bindDataSourceProviderType(PlayDataSourceProvider.class);
		bindTransactionFactoryType(JdbcTransactionFactory.class);
		addMapperClass(ComputerMapper.class);
		addMapperClass(UserMapper.class);
		addMapperClass(ProductMapper.class);
		bind(ComputerDao.class).to((Class<? extends ComputerDao>) Computer.class);
	}

	@Singleton
	public static class PlayDataSourceProvider implements Provider<DataSource> {
		final Database db;

		@Inject
		public PlayDataSourceProvider(final Database db) {
			this.db = db;
		}

		@Override
		public DataSource get() {
			return db.getDataSource();
		}

	}
}
