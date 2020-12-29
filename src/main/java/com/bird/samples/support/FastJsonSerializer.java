package com.bird.samples.support;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.bird.core.json.JsonSerializer;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

/**
 * @author liuxx
 * @since 2020/12/28
 */
@Component
public class FastJsonSerializer implements JsonSerializer {
    /**
     * JSON 序列化
     *
     * @param object 对象
     * @return json
     */
    @Override
    public String serialize(Object object) {
        if (object == null) {
            return StringUtils.EMPTY;
        }
        return JSON.toJSONString(object, SerializerFeature.DisableCircularReferenceDetect);
    }
}
