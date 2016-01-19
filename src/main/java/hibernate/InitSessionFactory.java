package hibernate;

import javax.security.auth.login.AppConfigurationEntry;
import javax.security.auth.login.Configuration;

/**
 * Project: HibernateTutorial
 * FileName: InitSessionFactory
 * Date: 2016-01-19
 * Time: 오전 11:13
 * Author: redfo
 * Note:
 * To change this template use File | Settings | File Templates.
 */
public class InitSessionFactory {
    private static org.hibernate.SessionFactory sessionFactory;
    private InitSessionFactory(){

    }
    static {
        final Configuration cfg = new Configuration() {
            @Override
            public AppConfigurationEntry[] getAppConfigurationEntry(String name) {
                return new AppConfigurationEntry[0];
            }
        };

    }

}
