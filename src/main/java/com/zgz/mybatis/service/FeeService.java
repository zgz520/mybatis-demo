package com.zgz.mybatis.service;

import com.zgz.mybatis.mapper.FeeMapper;
import com.zgz.mybatis.pojo.Fee;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author zgz
 * @version V1.0.0
 * @date 2020/5/14 21:44
 */
@Service
public class FeeService {

    private final FeeMapper feeMapper;

    public FeeService(FeeMapper feeMapper) {
        this.feeMapper = feeMapper;
    }

    public List<Fee> findByFeeDate(String feeDate) {
        return feeMapper.findByFeeDate(feeDate);
    }
}
