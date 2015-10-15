/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.baihe.analysis.service.impl;

import com.baihe.analysis.entity.Term;
import com.baihe.analysis.entity.TermType;
import com.baihe.analysis.service.Constants;
import com.baihe.analysis.service.IWordsOperation;
import com.baihe.analysis.service.TermQuery;
import com.baihe.analysis.service.TermQueryInfo;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.yufei.utils.FileUtil;
import java.util.List;
import java.util.Map;
import org.wltea.analyzer.core.CorpusType;

/**
 *
 * @author jasstion
 */
public class WordsOperation implements IWordsOperation{


    @Override
    public void removeTerm(long id) {
        Map<String,Object> paras=Maps.newHashMap();
        paras.put("_id=",id);
            Constants.mps.removeAll(paras, Term.class);
        
    }

    @Override
    public void addTerm(Term term) {
        Constants.mps.save(term);
    }

    @Override
    public List<Term> listTerms(TermQueryInfo queryInfo) {
        List<Term> terms=null;
        
        TermQuery termQuery=new TermQuery(queryInfo);
        termQuery.query();
        terms=termQuery.getSearchResult();
        return terms;
    }
     public static void main(String[] args) {
        IWordsOperation wordsOperation = new WordsOperation();
        String message = "/data/ik_Analyzer/dic/message.dic";
        String nickname = "/data/ik_Analyzer/dic/nickname.dic";
        String selfintroduce = "/data/ik_Analyzer/dic/selfintroduce.dic";
        List<String> worList=FileUtil.readLines(message);
        for (String word : worList) {
            Term term=new Term(String.valueOf(CorpusType.MESSAGE),word.trim()
            );
            wordsOperation.addTerm(term);
        }
        worList=FileUtil.readLines(nickname);
        for (String word : worList) {
            Term term=new Term(String.valueOf(CorpusType.NICKNAME),word.trim()
            );
            wordsOperation.addTerm(term);
        }
        worList=FileUtil.readLines(selfintroduce);
        for (String word : worList) {
            Term term=new Term(String.valueOf(CorpusType.SELFINTRODUCE),word.trim()
            );
            wordsOperation.addTerm(term);
        }
        
    }

    @Override
    public void addTermType(TermType termType) {
        Constants.mps.save(termType);
    }

    @Override
    public List<TermType> getTermTypes() {
        List<TermType> termTypes=Lists.newArrayList();
        Map<String,Object> params=null;
        termTypes=Constants.mps.query(params, TermType.class);
        
        return termTypes;
    }
}
