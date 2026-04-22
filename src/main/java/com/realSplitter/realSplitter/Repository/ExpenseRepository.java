package com.realSplitter.realSplitter.Repository;

import com.realSplitter.realSplitter.Model.GroupModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExpenseRepository extends JpaRepository<GroupModel,Long> {
}
