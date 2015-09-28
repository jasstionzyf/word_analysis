/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.baihe.analysis.zk;

import org.apache.curator.RetryPolicy;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.framework.recipes.cache.ChildData;
import org.apache.curator.framework.recipes.cache.NodeCache;
import org.apache.curator.framework.recipes.cache.NodeCacheListener;
import org.apache.curator.framework.recipes.cache.PathChildrenCache;
import org.apache.curator.framework.recipes.cache.PathChildrenCacheEvent;
import org.apache.curator.framework.recipes.cache.PathChildrenCacheListener;
import org.apache.curator.framework.recipes.cache.PathChildrenCacheMode;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author jasstion
 */
public class ExecutorTest {
    
    public ExecutorTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of main method, of class Executor.
     */
    @Test
    public void testMain() {
    }

    /**
     * Test of process method, of class Executor.
     */
    @Test
    public void testProcess() {
    }

    /**
     * Test of run method, of class Executor.
     */
    @Test
    public void testRun() throws Exception {
//         String hostPort = "172.16.10.26:2181";//args[0];
//        String znode = "/dic";//args[1];
//        String filename = "/data/zk.log";//args[2];
//        String exec[] = {"echo","action again"};//new String[args.length - 3];
//        try {
//            new Executor(hostPort, znode, filename, exec).run();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
        
       
//        byte[] data="finishReload".getBytes();
//        zk.create(dictionaryNodePath, data, null, CreateMode.EPHEMERAL);
    final      String dictionaryNodePath = "/dic";
         RetryPolicy retryPolicy =  new ExponentialBackoffRetry(1000, 3);
final CuratorFramework client = CuratorFrameworkFactory.newClient("localhost:2181", retryPolicy);
client.start();
final NodeCache nodeCache=new NodeCache(client, dictionaryNodePath);
nodeCache.getListenable().addListener(new NodeCacheListener() {

             @Override
             public void nodeChanged() throws Exception {
                 ChildData value=nodeCache.getCurrentData();
                 
                System.out.print(new String(value.getData())+"\n");
                 
             }
         });
nodeCache.start();
        while (true) {     
            Thread.currentThread().sleep(10*1000);
            
        }
       
       

        
       //  zkc.close();
    }

    /**
     * Test of closing method, of class Executor.
     */
    @Test
    public void testClosing() {
    }

    /**
     * Test of exists method, of class Executor.
     */
    @Test
    public void testExists() {
    }
    
}
