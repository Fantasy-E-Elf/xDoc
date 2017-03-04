package org.treeleafj.xdoc.model;

import lombok.Data;

import java.lang.reflect.Method;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * 接口信息
 *
 * @author leaf
 * @date 2017-03-03 11:09
 */
@Data
public class ApiAction {

    /**
     * 接口方法名称
     */
    private String name;

    /**
     * 接口方法
     */
    private Method method;

    /**
     * 接口的描述
     */
    private String comment;

    /**
     * 方法上标注的注解
     */
    private DocTags docTags;
}
