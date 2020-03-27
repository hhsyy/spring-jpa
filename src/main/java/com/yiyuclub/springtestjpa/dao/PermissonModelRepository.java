package com.yiyuclub.springtestjpa.dao;

import com.yiyuclub.springtestjpa.models.PermissonModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface PermissonModelRepository extends JpaRepository<PermissonModel, Integer>, JpaSpecificationExecutor<PermissonModel> {

}