package edu.hbuas.campustodo.service;

import edu.hbuas.campustodo.model.Priority;
import edu.hbuas.campustodo.model.Task;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class TaskServiceTest {

    @Test
    void shouldAddTask() {
        TaskService service = new TaskService();

        var task = service.addTask("完成需求评审");

        assertEquals(1L, task.getId());
        assertEquals("完成需求评审", task.getTitle());
        assertFalse(task.isCompleted());
        assertEquals(1, service.listAll().size());
    }

    @Test
    void shouldRejectBlankTitle() {
        TaskService service = new TaskService();

        assertThrows(IllegalArgumentException.class,
                () -> service.addTask("   "));
    }

    @Test
    void shouldCompleteTask() {
        TaskService service = new TaskService();
        service.addTask("完成需求评审");

        service.completeTask(1L);

        assertTrue(service.listAll().get(0).isCompleted());
    }

    @Test
    void shouldRejectUnknownTaskId() {
        TaskService service = new TaskService();

        assertThrows(IllegalArgumentException.class,
                () -> service.completeTask(999L));
    }

    @Test
    void shouldRejectDuplicateCompletion() {
        TaskService service = new TaskService();
        service.addTask("完成需求评审");
        service.completeTask(1L);

        assertThrows(IllegalStateException.class,
                () -> service.completeTask(1L));
    }

    @Test
    void shouldAssignMediumPriorityByDefault() {
        TaskService service = new TaskService();

        Task task = service.addTask("编写实验报告");

        assertEquals(Priority.MEDIUM, task.getPriority());
    }

    @Test
    void shouldReturnEmptyListWhenNoTaskMatchesPriority() {
        TaskService service = new TaskService();

        List<Task> highTasks = service.filterByPriority(Priority.HIGH);

        assertNotNull(highTasks);
        assertTrue(highTasks.isEmpty());
    }

    @Test
    void shouldFilterTasksByPriority() {
        TaskService service = new TaskService();
        service.addTask("高优先级任务", Priority.HIGH);
        service.addTask("默认中优先级任务");
        service.addTask("低优先级任务", Priority.LOW);

        List<Task> highTasks = service.filterByPriority(Priority.HIGH);
        List<Task> mediumTasks = service.filterByPriority(Priority.MEDIUM);
        List<Task> lowTasks = service.filterByPriority(Priority.LOW);

        assertEquals(1, highTasks.size());
        assertEquals("高优先级任务", highTasks.get(0).getTitle());
        assertEquals(1, mediumTasks.size());
        assertEquals("默认中优先级任务", mediumTasks.get(0).getTitle());
        assertEquals(1, lowTasks.size());
        assertEquals("低优先级任务", lowTasks.get(0).getTitle());
        assertEquals(3, service.listAll().size());

    }
}
