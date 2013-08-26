package liquibase.ext.hibernate.database;

import org.hibernate.HibernateException;
import org.hibernate.cfg.Configuration;
import org.hibernate.dialect.Dialect;

import java.sql.Types;

public class HibernateGenericDialect extends Dialect {
    private Dialect realDialect;

    public HibernateGenericDialect(Configuration cfg) throws Exception {
        String dialectClass = cfg.getProperty("hibernate.dialect");
        if (dialectClass == null) {
            dialectClass = cfg.getProperty("dialect");
        }

        realDialect = (Dialect) Class.forName(dialectClass).newInstance();
    }

    @Override
    public String getTypeName(int code, long length, int precision, int scale) throws HibernateException {
		return realDialect.getTypeName(code, length, precision, scale);
	}
}
