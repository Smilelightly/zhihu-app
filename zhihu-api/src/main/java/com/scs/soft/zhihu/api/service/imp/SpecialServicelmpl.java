package com.scs.soft.zhihu.api.service.imp;

import com.scs.soft.zhihu.api.entity.Special;
import com.scs.soft.zhihu.api.mapper.SpecialMapper;
import com.scs.soft.zhihu.api.service.SpecialService;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * @author ABC
 * @date 2020/1/16 10:45
 */
public class SpecialServicelmpl implements SpecialService {
    @Resource
    private SpecialMapper specialMapper;

    @Override
    public List<Map> selectAll() {
        return specialMapper.selectAll() ;
    }

    @Override
    public List<Special> selectRecent() {
        return specialMapper.selectRecent();
    }
}
