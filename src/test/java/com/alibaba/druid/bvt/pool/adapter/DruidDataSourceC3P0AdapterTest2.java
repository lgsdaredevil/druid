package com.alibaba.druid.bvt.pool.adapter;

import javax.sql.DataSource;

import junit.framework.Assert;
import junit.framework.TestCase;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceC3P0Adapter;
import com.alibaba.druid.stat.DruidDataSourceStatManager;

public class DruidDataSourceC3P0AdapterTest2 extends TestCase {

    public void test_0() throws Exception {
        Assert.assertEquals(0, DruidDataSourceStatManager.getInstance().getDataSourceList().size());

        DruidDataSourceC3P0Adapter dataSource = new DruidDataSourceC3P0Adapter();
        dataSource.setJdbcUrl("jdbc:mock:xxx");

        dataSource.setLogWriter(dataSource.getLogWriter());
        dataSource.setLoginTimeout(dataSource.getLoginTimeout());

        Assert.assertTrue(dataSource.isWrapperFor(DruidDataSourceC3P0Adapter.class));
        Assert.assertTrue(dataSource.isWrapperFor(DruidDataSource.class));
        Assert.assertTrue(dataSource.isWrapperFor(DataSource.class));
        Assert.assertFalse(dataSource.isWrapperFor(null));

        Assert.assertNotNull(dataSource.unwrap(DruidDataSourceC3P0Adapter.class));
        Assert.assertNotNull(dataSource.unwrap(DruidDataSource.class));
        Assert.assertNotNull(dataSource.unwrap(DataSource.class));
        Assert.assertNull(dataSource.unwrap(null));

        dataSource.setProperties(dataSource.getProperties());
        dataSource.setUser(dataSource.getUser());
        dataSource.setPassword(dataSource.getPassword());
        dataSource.setCheckoutTimeout(dataSource.getCheckoutTimeout());
        dataSource.setAutoCommitOnClose(dataSource.isAutoCommitOnClose());
        dataSource.setIdleConnectionTestPeriod(dataSource.getIdleConnectionTestPeriod());
        dataSource.setInitialPoolSize(dataSource.getInitialPoolSize());
        dataSource.setMaxIdleTime(dataSource.getMaxIdleTime());
        dataSource.setMaxPoolSize(dataSource.getMaxPoolSize());
        dataSource.setMinPoolSize(dataSource.getMinPoolSize());
        dataSource.setTestConnectionOnCheckout(dataSource.isTestConnectionOnCheckout());
        dataSource.setTestConnectionOnCheckin(dataSource.isTestConnectionOnCheckin());
        dataSource.setPreferredTestQuery(dataSource.getPreferredTestQuery());
        dataSource.setProxyFilters(dataSource.getProxyFilters());
        dataSource.getDataSourceName();
        dataSource.getNumConnections();
        dataSource.getNumIdleConnections();
        dataSource.getNumBusyConnections();
        dataSource.getNumUnclosedOrphanedConnections();
        dataSource.getNumConnectionsDefaultUser();
        dataSource.getNumIdleConnectionsDefaultUser();
        dataSource.getNumBusyConnectionsDefaultUser();
        dataSource.getMaxStatementsPerConnection();
        dataSource.getMaxStatements();
        dataSource.setUnreturnedConnectionTimeout(dataSource.getUnreturnedConnectionTimeout());
        dataSource.isDebugUnreturnedConnectionStackTraces();
        dataSource.setAcquireRetryAttempts(dataSource.getAcquireRetryAttempts());
        dataSource.setAcquireRetryDelay(dataSource.getAcquireRetryDelay());
        dataSource.setBreakAfterAcquireFailure(dataSource.isBreakAfterAcquireFailure());
        dataSource.isEnable();
        dataSource.shrink();
        dataSource.getWaitThreadCount();
        dataSource.getLockQueueLength();

        dataSource.close();
    }

    protected void tearDown() throws Exception {
        for (DruidDataSource dataSource : DruidDataSourceStatManager.getDruidDataSourceInstances()) {
            dataSource.close();
        }
    }
}
