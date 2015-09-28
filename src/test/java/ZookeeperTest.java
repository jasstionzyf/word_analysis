/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.baihe.analysis.zk.AnalysisZkOperation;
import com.baihe.analysis.zk.ZkOperation;
import org.apache.zookeeper.CreateMode;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author jasstion
 */
public class ZookeeperTest {

    public ZookeeperTest() {
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
     * Test of main method, of class Zookeeper.
     */
    @Test
    public void testMain() throws Exception {
        ZkOperation zkOperation = new AnalysisZkOperation();
        String dictionaryNodePath = "/dic";
////        ZkConnector zkc = new ZkConnector();
////        zkc.connect("localhost:2181");
////        ZooKeeper zk = zkc.getZooKeeper();
//////        byte[] data="finishReload".getBytes();
//////        zk.create(dictionaryNodePath, data, null, CreateMode.EPHEMERAL);
////        Stat stat = zk.exists(dictionaryNodePath, false);
////        zk.setData(dictionaryNodePath, "false".getBytes(), stat.getVersion());
////        System.out.print(stat.getAversion());
////        zkc.closeao=
        byte[] data = "false".getBytes();
//        zkOperation.deleteNode(dictionaryNodePath);
        //zkOperation.createNode(dictionaryNodePath, data, CreateMode.PERSISTENT);
        zkOperation.setData(dictionaryNodePath, "cehgn1234".getBytes());
        System.out.print(new String(zkOperation.getData(dictionaryNodePath)));

    }

}
