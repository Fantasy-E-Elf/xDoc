package org.treeleafj.xdoc.boot;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.treeleafj.xdoc.XDoc;
import org.treeleafj.xdoc.model.ApiModule;
import org.treeleafj.xdoc.spring.SpringXDocOutputImpl;
import org.treeleafj.xdoc.utils.ApiModulesHolder;

import javax.annotation.PostConstruct;
import java.io.ByteArrayOutputStream;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author leaf
 * @date 2017-03-09 15:36
 */
@RequestMapping("xdoc")
public class XDocController {

    private Logger log = LoggerFactory.getLogger(XDocController.class);

    @Autowired
    private XDocProperties xDocProperties;

    private List<ApiModule> apiModules;

    @PostConstruct
    public void init() {
        if (!xDocProperties.isEnable()) {
            return;
        }
        log.info("开始启动XDoc");

        ByteArrayOutputStream out = new ByteArrayOutputStream();
        String path = xDocProperties.getSourcePath();

        if (StringUtils.isBlank(path)) {
            path = ".";//默认为当前目录
        }

        List<String> paths = Arrays.asList(path.split(","));

        log.debug("源码路径:{}", paths);

        try {
            SpringXDocOutputImpl output = new SpringXDocOutputImpl(out, null);
            XDoc xDoc = new XDoc(paths, output);
            xDoc.build();
            log.info("启动XDoc完成");

            this.apiModules = ApiModulesHolder.getCurrentApiModules();
        } catch (Exception e) {
            log.error("启动XDoc失败,生成接口文档失败", e);
        }
    }

    /**
     * 获取所有文档api
     *
     * @return 系统所有文档接口的数据(json格式)
     */
    @ResponseBody
    @RequestMapping("apis")
    Object apis() {
        Map<String, Object> model = new HashMap<>();
        model.put("title", xDocProperties.getTitle());
        model.put("apiModules", apiModules);
        return JSON.toJSONString(model, new SerializerFeature[]{SerializerFeature.DisableCircularReferenceDetect});
    }

    /**
     * 重新构建文档
     *
     * @return 文档页面
     */
    @RequestMapping("rebuild")
    String rebuild() {
        init();
        return "redirect:index.html";
    }
}
