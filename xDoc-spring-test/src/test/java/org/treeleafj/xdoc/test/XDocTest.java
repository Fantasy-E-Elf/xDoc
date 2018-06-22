package org.treeleafj.xdoc.test;

import org.junit.Test;
import org.treeleafj.xdoc.XDoc;
import org.treeleafj.xdoc.spring.format.HtmlForamter;
import org.treeleafj.xdoc.spring.format.MarkdownFormater;
import org.treeleafj.xdoc.spring.framework.SpringWebFramework;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;

/**
 * Created by leaf on 2017/3/3 003.
 */
public class XDocTest {

    @Test
    public void buildMarkdown() throws Exception {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        String rootDir = System.getProperty("user.dir");
        XDoc xDoc = new XDoc(rootDir + "/src/main/java/org/treeleafj", new SpringWebFramework());
        xDoc.build(out, new MarkdownFormater());

        System.out.println(out.toString());
    }

    @Test
    public void buildHtml() throws Exception {
        FileOutputStream out = new FileOutputStream(new File("E:/api.html"));
        String rootDir = System.getProperty("user.dir");
        XDoc xDoc = new XDoc(rootDir + "/src/main/java/org/treeleafj", new SpringWebFramework());
        xDoc.build(out, new HtmlForamter());
    }
}