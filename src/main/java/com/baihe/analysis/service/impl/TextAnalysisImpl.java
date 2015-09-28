/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.baihe.analysis.service.impl;

import com.baihe.analysis.entity.Term;
import com.baihe.analysis.service.TextAnalysis;
import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;
import org.apache.lucene.analysis.tokenattributes.CharTermAttribute;
import org.apache.lucene.analysis.tokenattributes.OffsetAttribute;
import org.apache.lucene.analysis.tokenattributes.TypeAttribute;
import org.slf4j.LoggerFactory;
import org.wltea.analyzer.core.Lexeme;
import org.wltea.analyzer.dic.Dictionary;
import org.wltea.analyzer.dic.IKMatchOperation;
import org.wltea.analyzer.dic.MatchOperation;
import org.wltea.analyzer.dic.WordsLoader;
import org.wltea.analyzer.lucene.IKTokenizer;

/**
 *
 * @author jasstion
 */
public class TextAnalysisImpl implements TextAnalysis {

    protected final static org.slf4j.Logger mLog = LoggerFactory.getLogger(TextAnalysisImpl.class);

    static {
        WordsLoader wordsLoader = new MongoWordsLoader();
        MatchOperation matchOperation = new IKMatchOperation();

        Dictionary dictionary = new Dictionary(wordsLoader, matchOperation);
        Dictionary.setDictionary(dictionary);
    }

    @Override
    public List<Term> extractDirtyWords(String inputText) {
        List<Term> dirtyWords = new ArrayList();
        IKTokenizer iKTokenizer = new IKTokenizer(new StringReader(inputText), true);
        try {
            while (iKTokenizer.incrementToken()) {
                CharTermAttribute charTermAttribute = iKTokenizer.getAttribute(CharTermAttribute.class);
                OffsetAttribute offsetAttribute = iKTokenizer.getAttribute(OffsetAttribute.class);
                TypeAttribute typeAttribute = iKTokenizer.getAttribute(TypeAttribute.class);
                String wordType = String.valueOf(Lexeme.TYPE_CNWORD);
                String currentType = typeAttribute.type();
                String currentType_1 = currentType.split("_")[0];
                if (currentType_1.equals(wordType)) {
                    Term term = new Term();
                    term.setText(charTermAttribute.toString());
                    term.setType(currentType);
                    term.setStart(offsetAttribute.startOffset());
                    term.setEnd(offsetAttribute.endOffset());
                    dirtyWords.add(term);
                }

            }
        } catch (IOException ex) {
            mLog.info("error when tokenizer," + ex.getMessage() + "");
        }
        return dirtyWords;

    }

}
