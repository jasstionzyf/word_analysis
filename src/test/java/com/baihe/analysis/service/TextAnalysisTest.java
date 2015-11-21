/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.baihe.analysis.service;

import com.yufei.analysis.service.TextAnalysis;
import com.yufei.analysis.service.impl.TextAnalysisImpl;
import com.yufei.analysis.entity.Term;
import com.yufei.analysis.service.Constants;
import java.util.List;
import java.util.Map;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;


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

        String input = "赵宇飞毛泽东邓小平哪一起去吃饭高级餐厅卖淫一起去工作吧顺便大篮球赵宇赵宇飞赵国飞机";

        TextAnalysis textProcess = new TextAnalysisImpl();
        List<Term> result = textProcess.extractDirtyWords(input);
        for (Term result1 : result) {
            System.out.println(result1.toString() + "\n");
        }
//        
//        
//        
//        String text="女人";
    }

    public static void main(String[] args) {

//        TermType termType = new TermType();
//        termType.setType("鞋子品牌");
//        termType.setDescription("");
//        Long typeId = Constants.mps.save(termType);
//        // Aokang/奥康  Septwolves/七匹狼  木林森
//        Term term1 = new Term(typeId, "奥康");
//        Term term2 = new Term(typeId, "木林森");
//        Term term3 = new Term(typeId, "七匹狼");
//        Constants.mps.save(term2);
//        Constants.mps.save(term3);
//                Constants.mps.save(term1);
       
        
        String input = "七匹狼毛泽东邓小平哪奥康一起去吃饭高级餐木林森厅卖";

        TextAnalysis textProcess = new TextAnalysisImpl();
        List<Term> result = textProcess.extractDirtyWords(input);
        for (Term result1 : result) {
            System.out.println(result1.toString() + "\n");
        }

    }

}
