/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.baihe.analysis.service.impl;

import com.baihe.analysis.entity.Term;
import com.baihe.analysis.service.Constants;
import com.baihe.analysis.service.IWordsOperation;
import com.baihe.analysis.service.TermQueryInfo;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.yufei.utils.FileUtil;
import java.util.List;
import java.util.Map;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.wltea.analyzer.core.CorpusType;

/**
 *
 * @author jasstion
 */
public class WordsOperationTest {

    public WordsOperationTest() {
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
     * Test of removeTerm method, of class WordsOperation.
     */
    @Test
    public void testRemoveTerm() {
        Map<String, Object> queryMap = Maps.newHashMap();
        List<Long> list=Lists.newArrayList();
        list.add(1978100L);
        list.add(1983239L);
        queryMap.put("id:in", list);
        queryMap.put("type:=", "3");
        Constants.mps.removeAll(queryMap, Term.class);
    }

    /**
     * Test of addTerm method, of class WordsOperation.
     */
    @Test
    public void testAddTerm() {
//          IWordsOperation wordsOperation = new WordsOperation();
//        String message = "/data/ik_Analyzer/dic/message.dic";
//        String nickname = "/data/ik_Analyzer/dic/nickname.dic";
//        String selfintroduce = "/data/ik_Analyzer/dic/selfintroduce.dic";
//        List<String> worList=FileUtil.readLines(message);
//        for (String word : worList) {
//            Term term=new Term(CorpusType.MESSAGE.toString(),word.trim()
//            );
//            wordsOperation.addTerm(term);
//        }
//        worList=FileUtil.readLines(nickname);
//        for (String word : worList) {
//            Term term=new Term(CorpusType.NICKNAME.toString(),word.trim()
//            );
//            wordsOperation.addTerm(term);
//        }
//        worList=FileUtil.readLines(selfintroduce);
//        for (String word : worList) {
//            Term term=new Term(CorpusType.SELFINTRODUCE.toString(),word.trim()
//            );
//            wordsOperation.addTerm(term);
//        }
//        IWordsOperation wordsOperation = new WordsOperation();
//        List<Term> terms = Lists.newArrayList();
//        terms.add(new Term("3", "赵宇飞"));
//        terms.add(new Term("2", "篮球"));
//        terms.add(new Term("2", "赵国"));
//        terms.add(new Term("3", "飞机"));
//        for (Term term : terms) {
//            wordsOperation.addTerm(term);
//
//        }
//        TermQueryInfo queryInfo=new TermQueryInfo();
//        queryInfo.setCount(30);
//        queryInfo.setCpn(1);
//        queryInfo.setText("赵");
//       
//        List<Term> resultList=wordsOperation.listTerms(queryInfo);
//        for (Term term : resultList) {
//            System.out.print(term.toString()+"\n");
//            
//        }
    }

    /**
     * Test of listTerms method, of class WordsOperation.
     */
    @Test
    public void testListTerms() {
    }

}
