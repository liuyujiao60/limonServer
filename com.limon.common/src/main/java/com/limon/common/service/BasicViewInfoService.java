package com.limon.common.service;

import com.limon.common.dao.BasicViewInfoMapper;
import com.limon.common.entity.BasicViewInfo;
import com.limon.common.typecast.BasicViewInfoVoTypeCast;
import com.limon.common.viewobject.BasicViewInfoVo;
import com.limon.common.viewobject.DateVo;
import com.limon.core.common.IdGenarator;
import com.limon.core.request.Page;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class BasicViewInfoService {

    @Resource
    private BasicViewInfoMapper basicViewInfoMapper;

    @Resource
    private BasicViewInfoVoTypeCast basicViewInfoVoTypeCast;

    public BasicViewInfoVo saveBasicViewInfo(BasicViewInfoVo basicViewInfoVo){

        BasicViewInfo basicViewInfo=basicViewInfoVoTypeCast.VO_ENTITY.apply(basicViewInfoVo);

        basicViewInfo.setId(IdGenarator.getStringId());
        basicViewInfo.setCreateTime(System.currentTimeMillis());
        basicViewInfoMapper.insert(basicViewInfo);

        basicViewInfoVo.setCreateTime(new DateVo(basicViewInfo.getCreateTime()));
        basicViewInfoVo.setId(basicViewInfo.getId());

        return basicViewInfoVo;
    }

    public BasicViewInfoVo getBasicViewInfoById(String id){
        BasicViewInfo basicViewInfo=basicViewInfoMapper.getBasicViewInfoById(id);

        BasicViewInfoVo basicViewInfoVo=basicViewInfoVoTypeCast.ENTITY_VO.apply(basicViewInfo);

        return basicViewInfoVo;
    }

    public List<BasicViewInfoVo> getBasicViewInfoByCategoryId(String categoryId, Page page){
        List<BasicViewInfoVo> result=new ArrayList<>();
        List<BasicViewInfo> basicViewInfoList= StringUtils.isNotEmpty(categoryId)?
                basicViewInfoMapper.getBasicViewInfoByCategoryId(categoryId,page):basicViewInfoMapper.getBasicViewInfoList(page);

        basicViewInfoList.stream().forEach(basicViewInfo -> {
            BasicViewInfoVo basicViewInfoVo=basicViewInfoVoTypeCast.ENTITY_VO.apply(basicViewInfo);

            result.add(basicViewInfoVo);
        });


        return result;
    }
}
