/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.yufei.analysis.service;

import com.yufei.entity.query.BaseQueryInfo;

/**
 *
 * @author jasstion
 */
public class TermQueryInfo extends BaseQueryInfo{
    //模糊查询
    private String text=null;
    private Long type=-1l;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Long getType() {
        return type;
    }

    public void setType(Long type) {
        this.type = type;
    }

    
    

  
   
    
}
