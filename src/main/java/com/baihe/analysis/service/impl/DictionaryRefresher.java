/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.baihe.analysis.service.impl;

import org.wltea.analyzer.dic.Dictionary;
import org.wltea.analyzer.dic.IKMatchOperation;
import org.wltea.analyzer.dic.MatchOperation;
import org.wltea.analyzer.dic.WordsLoader;

/**
 *
 * @author jasstion
 */
public class DictionaryRefresher {

    public DictionaryRefresher() {
        super();
    }
    

    public void reload() {
        WordsLoader wordsLoader = new MongoWordsLoader();
        MatchOperation matchOperation = new IKMatchOperation();

        Dictionary dictionary = new Dictionary(wordsLoader, matchOperation);
        Dictionary.setDictionary(dictionary);
    }

}
