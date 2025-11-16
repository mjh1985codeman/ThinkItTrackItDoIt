package com.mh.taskmanager.service;

import com.mh.taskmanager.dto.GoalRequestDTO;
import com.mh.taskmanager.dto.GoalResponseDTO;
import com.mh.taskmanager.mapper.GoalMapper;
import com.mh.taskmanager.model.Goal;
import com.mh.taskmanager.repository.GoalRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GoalService {

    private final GoalRepository goalRepository;

    public GoalService(GoalRepository goalRepository) {
        this.goalRepository = goalRepository;
    }

    public List<GoalResponseDTO> getAllGoals() {
        return goalRepository.findAll()
                .stream()
                .map(GoalMapper::toDTO)
                .toList();
    }

    public GoalResponseDTO getGoal(Long id) {
        Goal goal = goalRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Goal not found"));

        return GoalMapper.toDTO(goal);
    }

    public GoalResponseDTO createGoal(GoalRequestDTO request) {
        Goal goal = GoalMapper.fromDTO(request);
        goalRepository.save(goal);
        return GoalMapper.toDTO(goal);
    }

    public GoalResponseDTO updateGoal(Long id, GoalRequestDTO request) {
        Goal goal = goalRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Goal not found"));

        GoalMapper.updateEntity(goal, request);
        goalRepository.save(goal);

        return GoalMapper.toDTO(goal);
    }

    public void deleteGoal(Long id) {
        goalRepository.deleteById(id);
    }

    // Utility for other services
    public Goal findGoalEntity(Long id) {
        if (id == null)
            return null;

        return goalRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Goal not found"));
    }
}
