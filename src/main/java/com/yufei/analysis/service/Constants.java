/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.yufei.analysis.service;

import com.yufei.pfw.service.MongodbPfwService;
import com.yufei.pfw.service.PfwServiceFactory;

/**
 *
 * @author jasstion
 */
public class Constants {
       public final static MongodbPfwService mps = (MongodbPfwService) PfwServiceFactory.getMongoPfwService("analysis");

    
}
