package org.leaf.anno.doc;

import lombok.Data;

import java.util.List;

/**
 * @author leaf
 * @date 2017-03-03 12:14
 */
@Data
public class VOField {

    private String typeName;

    private String name;

    private String type;

    private String comment;

    private List<VOField> voFields;

}
