package edu.hbuas.campustodo.service;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
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
}
