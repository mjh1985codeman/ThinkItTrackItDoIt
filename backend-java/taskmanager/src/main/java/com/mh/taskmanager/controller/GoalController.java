package com.mh.taskmanager.controller;

import com.mh.taskmanager.dto.GoalRequestDTO;
import com.mh.taskmanager.dto.GoalResponseDTO;
import com.mh.taskmanager.service.GoalService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/goals")
@CrossOrigin(origins = "*") // allow frontend
public class GoalController {

    private final GoalService goalService;

    public GoalController(GoalService goalService) {
        this.goalService = goalService;
    }

    @GetMapping
    public List<GoalResponseDTO> getAllGoals() {
        return goalService.getAllGoals();
    }

    @GetMapping("/{id}")
    public GoalResponseDTO getGoal(@PathVariable Long id) {
        return goalService.getGoal(id);
    }

    @PostMapping
    public GoalResponseDTO createGoal(@RequestBody GoalRequestDTO request) {
        return goalService.createGoal(request);
    }

    @PutMapping("/{id}")
    public GoalResponseDTO updateGoal(@PathVariable Long id, @RequestBody GoalRequestDTO request) {
        return goalService.updateGoal(id, request);
    }

    @DeleteMapping("/{id}")
    public void deleteGoal(@PathVariable Long id) {
        goalService.deleteGoal(id);
    }
}
