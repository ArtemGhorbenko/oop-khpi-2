package ua.khpi.oop.lab04;

import org.testng.Assert;
import org.testng.annotations.Test;

public class StandardRoomTest {
    @Test(groups = "domain")
    public void testStandardRoomInheritance() {
        StandardRoom stdRoom = new StandardRoom("102", true, 2);
        Assert.assertTrue(stdRoom.isAvailable());
        Assert.assertEquals(stdRoom.getRoomNumber(), "102");
    }
}