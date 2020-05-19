package com.zwb.utils;

import com.zwb.vo.ResultVO;

import javax.persistence.criteria.CriteriaBuilder;

/**
 * @Desc:
 * @Author: zwb
 * @CreateTime: 2020/5/19 14:56
 **/
public class ResultVOUtil {

    public static ResultVO success(Object object){
        ResultVO resultVO = new ResultVO();
        resultVO.setData(object);
        resultVO.setCode(0);
        resultVO.setMsg("成功");
        return resultVO;
    }

    public static ResultVO success(){
        return  success(null);
    }

    public static ResultVO error(Integer code,String msg){
        ResultVO resultVO = new ResultVO();
        resultVO.setCode(code);
        resultVO.setMsg(msg);
        return resultVO;
    }
}
