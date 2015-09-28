/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.baihe.analysis.zk;

import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.curator.RetryPolicy;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.apache.zookeeper.CreateMode;

/**
 *
 * @author jasstion
 */
public class AnalysisZkOperation implements ZkOperation {

    final static ResourceBundle appBundle = ResourceBundle.getBundle("baihe-analysis");
    ;
    private CuratorFramework client = null;

    public AnalysisZkOperation() {
        super();
        RetryPolicy retryPolicy = new ExponentialBackoffRetry(1000, 3);
        client = CuratorFrameworkFactory.newClient(appBundle.getString("zkserver"), retryPolicy);
        client.start();
    }

    @Override
    public byte[] getData(String nodePath) {
        byte[] result = null;

        try {
            result = client.getData().forPath(nodePath);
        } catch (Exception ex) {
            Logger.getLogger(AnalysisZkOperation.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;

    }

    @Override
    public void setData(String nodePath, byte[] value) {
        try {
            client.setData().forPath(nodePath, value);
        } catch (Exception ex) {
            Logger.getLogger(AnalysisZkOperation.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize(); //To change body of generated methods, choose Tools | Templates.
        client.close();
    }

    @Override
    public void createNode(String nodePath, byte[] data, CreateMode mode) {

        try {
            client.create().withMode(CreateMode.PERSISTENT).forPath(nodePath, data);
        } catch (Exception ex) {
            Logger.getLogger(AnalysisZkOperation.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public void deleteNode(String nodePath) {

        try {
            client.delete().forPath(nodePath);
        } catch (Exception ex) {
            Logger.getLogger(AnalysisZkOperation.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
