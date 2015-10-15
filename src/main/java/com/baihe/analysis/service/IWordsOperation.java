/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.baihe.analysis.service;

import com.baihe.analysis.entity.Term;
import com.baihe.analysis.entity.TermType;
import java.util.List;

/**
 *
 * @author jasstion
 */
public interface IWordsOperation {


    public void removeTerm(long id);

    public void addTerm(Term term);
    public void addTermType(TermType termType);
    
    public List<TermType> getTermTypes();
    

    public List<Term> listTerms(TermQueryInfo queryInfo);

}
