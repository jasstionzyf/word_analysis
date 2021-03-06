/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.yufei.analysis.entity;

import com.yufei.pfw.entity.Entity;
import org.springframework.data.mongodb.core.index.Indexed;

/**
 *
 * @author jasstion
 */
public class TermType extends Entity<Long> {

    @Indexed(unique = true)
    private String type = null;
    private String description = null;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public TermType() {
        super();
    }

}
