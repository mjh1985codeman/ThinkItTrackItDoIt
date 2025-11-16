package com.mh.taskmanager.repository;

import com.mh.taskmanager.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface TaskRepository extends JpaRepository<Task, Long> {
    List<Task> findByGoalIdOrderBySortOrderAsc(Long goalId);

    List<Task> findAllByOrderBySortOrderAsc();

}
