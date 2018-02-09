package com.yjy;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//开启刷新
@RefreshScope
@RestController

@RequestMapping("/yjyapi")
public class YjyApi {
    @Value("${myblog.name}")
    private String name;
    @Value("${myblog.url}")
    private String url;
    @Value("${myblog.location}")
    private String location;
    @RequestMapping("/getRemoteGit")
    public  String getRemoteGit()
    {
        // http://localhost:8091/yjyapi/getRemoteGit
        return "从Github仓库中获取得到我博客信息：【"+location+","+","+url+","+name+"】";
    }

}
