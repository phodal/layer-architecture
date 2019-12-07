package com.phodal.layer.application.infrastructure.persistence;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@Mapper
public interface BlogMapper {
    Optional<BlogPO> findById(@Param("id") String id);
}
