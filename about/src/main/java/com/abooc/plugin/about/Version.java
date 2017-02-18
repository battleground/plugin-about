package com.abooc.plugin.about;

/**
 * 目前只支持 fir.im
 * <p>
 * {
 * "name": "fir.im",
 * "version": "1.0",
 * "changelog": "更新日志",
 * "versionShort": "1.0.5",
 * "build": "6",
 * "installUrl": "http://download.fir.im/v2/app/install/xxxxxxxxxxxxxxxxxxxx?download_token=xxxxxxxxxxxxxxxxxxxxxxxxxxxx",
 * "install_url": "http://download.fir.im/v2/app/install/xxxxxxxxxxxxxxxx?download_token=xxxxxxxxxxxxxxxxxxxxxxxxxxxx",   # 新增字段
 * "update_url": "http://fir.im/fir",  # 新增字段
 * "binary": {
 * "fsize": 6446245
 * }
 * }
 * Created by dayu on 2017/2/18.
 */
public class Version {
    public String name;
    public String version;
    public String changelog;
    public String versionShort;
    public String build;
    public String installUrl;
    public String install_url;
    public String update_url;
    public Object binary;
}
