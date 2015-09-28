/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.baihe.analysis.service;

import com.baihe.analysis.service.impl.TextAnalysisImpl;
import com.baihe.analysis.entity.Term;
import com.baihe.analysis.service.impl.MongoWordsLoader;
import com.baihe.analysis.service.impl.WordsOperation;
import com.yufei.utils.FileUtil;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.wltea.analyzer.core.CorpusType;
import org.wltea.analyzer.dic.Dictionary;
import org.wltea.analyzer.dic.IKMatchOperation;
import org.wltea.analyzer.dic.MatchOperation;
import org.wltea.analyzer.dic.WordsLoader;

/**
 *
 * @author jasstion
 */
public class TextAnalysisTest {
    
    public TextAnalysisTest() {
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
     * Test of extractDirtyWords method, of class TextProcessImpl.
     */
    @Test
    public void testExtractDirtyWords() {
       
        String input="赵宇飞毛泽东邓小平哪一起去吃饭高级餐厅卖淫一起去工作吧顺便大篮球赵宇赵宇飞赵国飞机";
        
       TextAnalysis textProcess=new  TextAnalysisImpl();
       List<Term> result=textProcess.extractDirtyWords(input);
        for (Term result1 : result) {
            System.out.println(result1.toString()+"\n");
        }
//        
//        
//        
//        String text="女人";
    }
    public static void main(String[] args) {
         
        String input="毛泽东邓小平哪一起去吃饭高级餐厅卖淫一起去工作吧顺便大篮球赵宇赵宇飞赵国飞机";
        
       TextAnalysis textProcess=new  TextAnalysisImpl();
       List<Term> result=textProcess.extractDirtyWords(input);
        for (Term result1 : result) {
            System.out.println(result1.toString()+"\n");
        }
 
//        String analysisUrl="http://analysis.baihe.com/inner/analysis/checkTextIsValid.json";
//         Map<String, Object> params = new HashMap<String, Object>();
//            Map<String, Object> originalParams = new HashMap<String, Object>();
//            originalParams.put("text", "我是一个有点小任性~小脾气的人!但是，㊣绝不会无理取闹!喜欢有责任心、有上进心、不花心的男人");
//            originalParams.put("textType", "2");
//            params.put("params", JSON.toJSONString(originalParams));
//
//           String result=HttpUtils.executeWithHttpV3(analysisUrl, 2*1000, 2*1000, 2*1000, 3, params);
//            JSONObject jsonObject = JSON.parseObject(result);
//            System.out.print(jsonObject.getJSONObject("data").getJSONArray("invalidWords").toString());
    }
    
   
    
}
