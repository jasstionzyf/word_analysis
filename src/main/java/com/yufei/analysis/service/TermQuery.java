/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.yufei.analysis.service;

import com.yufei.analysis.entity.Term;
import com.google.common.collect.Maps;
import com.yufei.entity.query.AbstractQuery;
import java.util.List;
import java.util.Map;

/**
 *
 * @author jasstion
 */
public class TermQuery extends AbstractQuery<TermQueryInfo, Term> {

    public TermQuery(TermQueryInfo queryInfo) {
        super(queryInfo);
    }

    @Override
    public void query() {
        int skip=(getCurrentPage()-1)*getPageSize();
        int limit=getPageSize();
        String matchedText = queryInfo.getText();
        Long type = queryInfo.getType();
        Map<String, Object> params = Maps.newHashMap();
        if(type!=null&&type>0){
          params.put("type:=", type);  
        }
        if(matchedText!=null&&matchedText.length()>0){
           params.put("text:like", matchedText);
        }
        
       
        params.put("skip", skip);
        params.put("limit", limit);
        long count=Constants.mps.count(params, Term.class);
        List<Term> terms = Constants.mps.query(params, Term.class);
        setSearchResult(terms);
        queryInfo.setTotalcount((int)count);
        

    }

}
