/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.yufei.analysis.service.impl;

import com.yufei.analysis.entity.Term;
import com.yufei.analysis.service.Constants;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import java.util.Iterator;
import org.wltea.analyzer.dic.Word;
import org.wltea.analyzer.dic.WordsLoader;

/**
 *
 * @author jasstion
 */
public class MongoWordsLoader implements WordsLoader {

    @Override
    public Iterable<Word> load() {
        final DBCursor cursor = Constants.mps.getMongoTemplate().getDb().getCollection(Constants.mps.getMongoTemplate().getCollectionName(Term.class)).find();

        Iterable<Word> iterable;
        iterable = new Iterable<Word>() {
            
            @Override
            public Iterator<Word> iterator() {
                return new Iterator<Word>() {

                    @Override
                    public boolean hasNext() {
                        return cursor.hasNext();
                    }

                    @Override
                    public Word next() {
                        Word word = null;
                        DBObject db = cursor.next();
                        try {
                            word = new Word((String) db.get("text"),(Long)db.get("type"));
                        } catch (Exception e) {
                            //ingore error
                        }

                        return word;
                    }

                    @Override
                    public void remove() {
                        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                    }
                };
            }
        };

        return iterable;
    }

}
