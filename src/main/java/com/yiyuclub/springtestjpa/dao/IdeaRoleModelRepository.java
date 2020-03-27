package com.yiyuclub.springtestjpa.dao;

import com.yiyuclub.springtestjpa.models.IdeaRoleModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface IdeaRoleModelRepository extends JpaRepository<IdeaRoleModel, Integer>, JpaSpecificationExecutor<IdeaRoleModel> {

}