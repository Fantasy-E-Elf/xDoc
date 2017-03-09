package org.treeleafj.xdoc.model;

import org.treeleafj.xdoc.tag.DocTag;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by leaf on 2017/3/4.
 */
public class DocTags {

    private List<DocTag> list;

    public DocTags() {
    }

    public DocTags(List<DocTag> list) {
        this.list = list;
    }

    public DocTag getTag(String name) {
        for (int i = 0; i < list.size(); i++) {
            DocTag docTag = list.get(i);
            if (docTag.getName().equals(name)) {
                return docTag;
            }
        }
        return null;
    }

    public List<DocTag> getTags(String name) {
        List<DocTag> docTags = new ArrayList<DocTag>();
        for (int i = 0; i < list.size(); i++) {
            DocTag docTag = list.get(i);
            if (docTag.getName().equals(name)) {
                docTags.add(docTag);
            }
        }
        return docTags;
    }

    public List<DocTag> getList() {
        return list;
    }

    public void setList(List<DocTag> list) {
        this.list = list;
    }
}
