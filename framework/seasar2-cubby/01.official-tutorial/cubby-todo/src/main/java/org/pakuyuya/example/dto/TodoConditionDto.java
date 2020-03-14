package org.pakuyuya.example.dto;

import java.io.Serializable;
import java.util.Date;

import org.seasar.cubby.internal.util.StringUtils;

public class TodoConditionDto implements Serializable {
    private static final long serialVersionUID = 1L;

    private String keyword;
    private Integer typeId;
    private Date limitDate;

    public String getKeyword() {
        return keyword;
    }
    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }
    public boolean hasKeyword() {
        return StringUtils.isNotBlank(keyword);
    }
    public Integer getTypeId() {
        return typeId;
    }
    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }
    public boolean hasTypeId() {
        return typeId != null;
    }
    public Date getLimitDate() {
        return limitDate;
    }
    public void setLimitDate(Date limitDate) {
        this.limitDate = limitDate;
    }
    public boolean hasLimitDate() {
        return limitDate != null;
    }
}
