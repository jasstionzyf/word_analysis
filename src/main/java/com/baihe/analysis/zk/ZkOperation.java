/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.baihe.analysis.zk;

import org.apache.zookeeper.CreateMode;

/**
 *
 * @author jasstion
 */
public interface ZkOperation {

    public byte[] getData(String nodePath);

    public void setData(String nodePath, byte[] value);

    public void createNode(String nodePath, byte[] data, CreateMode mode);

    public void deleteNode(String nodePath);

}
