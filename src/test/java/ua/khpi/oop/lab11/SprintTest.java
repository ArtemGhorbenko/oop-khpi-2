package ua.khpi.oop.lab11;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ua.khpi.oop.lab11.model.Developer;
import ua.khpi.oop.lab11.model.Task;
import ua.khpi.oop.lab11.service.Sprint;

import static org.junit.jupiter.api.Assertions.*;

class SprintTest {
    private Sprint sprint;
    private Developer dev1;
    private Task task1;

    @BeforeEach
    void setUp() {
        sprint = new Sprint();
        dev1 = new Developer("D-01", "Олексій");
        task1 = new Task("T-01", "Тестове завдання");
    }

    @Test
    void shouldNotAllowDuplicateDevelopers() {
        sprint.addDeveloper(dev1);
        Developer duplicate = new Developer("D-01", "Інше Імя");

        assertThrows(IllegalArgumentException.class, () -> sprint.addDeveloper(duplicate));
        assertEquals(1, sprint.getTeam().size());
    }

    @Test
    void shouldProcessQueueAndMoveToList() {
        sprint.addDeveloper(dev1);
        sprint.addTaskToBacklog(task1);

        assertEquals(1, sprint.getBacklog().size());
        assertEquals(0, sprint.getActiveTasks().size());

        Task assigned = sprint.assignNextTask(dev1);

        assertEquals(task1, assigned);
        assertEquals(dev1, assigned.getAssignee());
        assertEquals(0, sprint.getBacklog().size());
        assertEquals(1, sprint.getActiveTasks().size());
    }

    @Test
    void shouldRemoveTaskOnComplete() {
        sprint.addDeveloper(dev1);
        sprint.addTaskToBacklog(task1);
        sprint.assignNextTask(dev1);

        boolean completed = sprint.completeTask("T-01");

        assertTrue(completed);
        assertEquals(0, sprint.getActiveTasks().size());
    }
}