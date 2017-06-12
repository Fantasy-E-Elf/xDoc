package org.treeleafj.xdoc.spring.format;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import org.apache.commons.io.IOUtils;
import org.treeleafj.xdoc.model.ApiModule;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by leaf on 2017/3/18 0018.
 */
public class HtmlForamt implements Format {
    @Override
    public String format(List<ApiModule> list) {
        InputStream in = HtmlForamt.class.getResourceAsStream("html.vm");
        if (in != null) {
            try {
                String s = IOUtils.toString(in, "utf-8");

                Map<String, Object> model = new HashMap<>();
                model.put("title", "接口文档");
                model.put("apiModules", list);

                return s.replace("_apis_json", JSON.toJSONString(model, new SerializerFeature[]{SerializerFeature.DisableCircularReferenceDetect}));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        IOUtils.closeQuietly(in);
        return "";
    }

    @Override
    public String format(ApiModule apiModule) {
        List<ApiModule> list = new ArrayList<>();
        list.add(apiModule);
        return format(list);
    }
}
