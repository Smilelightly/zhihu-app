package com.scs.soft.zhihu.api.service;

import com.scs.soft.zhihu.api.entity.Special;

import java.util.List;
import java.util.Map;

/**
 * @author ABC
 * @date 2020/1/16 12:34
 */
public interface SpecialService {
    /**
     * 查询所有专题
     * @return
     */
    List<Map> selectAll();
    /**
     * 查询最新专题
     */
    List<Special> selectRecent();
}
