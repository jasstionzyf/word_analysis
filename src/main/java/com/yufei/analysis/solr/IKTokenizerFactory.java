/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.yufei.analysis.solr;

import java.io.Reader;
import java.util.Map;
import org.apache.lucene.analysis.Tokenizer;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.analysis.standard.StandardTokenizer;
import org.apache.lucene.analysis.util.TokenizerFactory;
import org.apache.lucene.util.AttributeSource;

/**
 *
 * @author jasstion
 */
public class IKTokenizerFactory extends TokenizerFactory {

    /**
     * Creates a new StandardTokenizerFactory
     */
    public IKTokenizerFactory(Map<String, String> args) {
        super(args);
        assureMatchVersion();

    }

    @Override
    public Tokenizer create(AttributeSource.AttributeFactory factory, Reader input) {
        //StandardTokenizer tokenizer = new StandardTokenizer(luceneMatchVersion, factory, input); 
        IKTokenizer tokenizer = new IKTokenizer(input, true);
        return tokenizer;
    }
}
