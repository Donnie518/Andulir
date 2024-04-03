package org.andulir.parser.entity;

import javax.xml.bind.annotation.XmlElement;


public class ParameterMapping {
    private String type;
    private String value;

    @XmlElement
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @XmlElement
    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

}