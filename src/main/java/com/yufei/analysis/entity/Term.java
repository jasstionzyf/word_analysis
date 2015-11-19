/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.yufei.analysis.entity;

import com.yufei.pfw.entity.Entity;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.index.CompoundIndex;
import org.springframework.data.mongodb.core.index.CompoundIndexes;
import org.springframework.data.mongodb.core.index.Indexed;

/**
 *
 * @author jasstion
 */
@CompoundIndexes({
    @CompoundIndex(name = "type_text", def = "{'type': 1, 'text': 1}", unique = true)
})
public class Term extends Entity<Long> {

    public Term() {
    }
    //词的用途类别， 比如： 消息词， 昵称词以及自我介绍词

    @Indexed(unique = false)
    private Long type = -1l;
    private String text = null;
    @Transient
    private int start = -1;
    @Transient
    private int end = -1;

    @Override
    public String toString() {
        return "Term{" + "type=" + type + ", text=" + text + ", start=" + start + ", end=" + end + '}';
    }

    public Term(Long type, String text) {
        super();
        this.text = text;
        this.type = type;
    }

    public Long getType() {
        return type;
    }

    public void setType(Long type) {
        this.type = type;
    }

 
    

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getEnd() {
        return end;
    }

    public void setEnd(int end) {
        this.end = end;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

}
