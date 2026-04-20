package com.realSplitter.realSplitter;

import com.realSplitter.realSplitter.Model.RealObject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RealRepository extends JpaRepository<RealObject, Integer> {
}
