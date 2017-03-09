package org.treeleafj.xdoc.boot;

import org.springframework.context.annotation.Bean;

/**
 * @author leaf
 * @date 2017-03-09 15:29
 */
public class XDocConfiguration {

    @Bean
    public XDocController xDocController() {
        return new XDocController();
    }
}
