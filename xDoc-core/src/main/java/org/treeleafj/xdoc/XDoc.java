package org.treeleafj.xdoc;

import lombok.Setter;
import org.treeleafj.xdoc.model.ApiModule;
import org.treeleafj.xdoc.output.XDocOutput;
import org.treeleafj.xdoc.resolver.DocTagResolver;
import org.treeleafj.xdoc.resolver.javaparser.JavaParserDocTagResolver;
import org.treeleafj.xdoc.utils.FileUtils;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * XDoc主入口,核心处理从这里开始
 *
 * @author leaf
 * @date 2017-03-03 16:25
 */
public class XDoc {

    /**
     * 源码路径
     */
    private List<String> srcPaths;

    /**
     * 输出方式
     */
    private XDocOutput output;

    /**
     * 默认的java注释解析器实现
     *
     * @see org.treeleafj.xdoc.resolver.javaparser.JavaParserDocTagResolver
     */
    @Setter
    private DocTagResolver docTagResolver = new JavaParserDocTagResolver();

    /**
     * 构建XDoc对象
     *
     * @param srcPath 源码路径
     * @param output  输出方式
     */
    public XDoc(String srcPath, XDocOutput output) {
        List<String> srcPaths = new ArrayList(1);
        srcPaths.add(srcPath);
        this.srcPaths = srcPaths;
        this.output = output;
    }

    /**
     * 构建XDoc对象
     *
     * @param srcPaths 源码路径,支持多个
     * @param output   输出方式
     */
    public XDoc(List<String> srcPaths, XDocOutput output) {
        this.srcPaths = srcPaths;
        this.output = output;
    }

    /**
     * 构建接口文档
     */
    public List<ApiModule> build() {

        List<String> files = new ArrayList<>();
        for (String srcPath : this.srcPaths) {
            files.addAll(FileUtils.getAllJavaFiles(new File(srcPath)));
        }

        List<ApiModule> apiModules = this.docTagResolver.resolve(files);
        return this.output.output(apiModules);
    }
}
