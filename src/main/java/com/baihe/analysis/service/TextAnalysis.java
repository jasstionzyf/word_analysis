/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.baihe.analysis.service;

import com.baihe.analysis.entity.Term;
import java.util.List;

/**
 *
 * @author jasstion
 */
public interface TextAnalysis {
    public List<Term> extractDirtyWords(String inputText);
    
}
