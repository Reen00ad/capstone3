package com.example.capstone3.Repository;

import com.example.capstone3.Model.Branch;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BranchRepository extends JpaRepository<Branch,Integer> {
    Branch findBranchById(Integer id);
}
