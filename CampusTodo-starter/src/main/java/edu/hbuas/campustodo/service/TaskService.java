package edu.hbuas.campustodo.service;

import edu.hbuas.campustodo.model.Priority;
import edu.hbuas.campustodo.model.Task;

import java.util.ArrayList;
import java.util.List;

/**
 * 任务应用服务。学生将在功能分支中逐步扩展该类。
 */
public class TaskService {
    private final List<Task> tasks = new ArrayList<>();
    private long nextId = 1;

    public Task addTask(String title) {
        Task task = new Task(nextId++, title);
        tasks.add(task);
        return task;
    }

    /**
     * 新增指定优先级的任务。
     */
    public Task addTask(String title, Priority priority) {
        Task task = new Task(nextId++, title, priority);
        tasks.add(task);
        return task;
    }

    public List<Task> listAll() {
        return List.copyOf(tasks);
    }

    /**
     * 按优先级筛选任务；没有匹配任务时返回空列表。
     */
    public List<Task> filterByPriority(Priority priority) {
        if (priority == null) {
            return List.of();
        }
        return tasks.stream()
                .filter(task -> task.getPriority() == priority)
                .toList();
    }
}
