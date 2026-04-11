package ua.khpi.oop.lab04;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class RoomTest {
    private Room room;
    private Guest guest;

    @BeforeMethod
    public void setUp() {
        room = new Room("101");
        guest = new Guest("G-01", "Олег");
    }

    @Test(groups = {"smoke", "domain"})
    public void testInitialState() {
        Assert.assertEquals(room.getRoomNumber(), "101");
        Assert.assertTrue(room.isAvailable());
        Assert.assertNull(room.getCurrentGuest());
    }

    @Test(groups = "domain")
    public void testBookRoom() {
        room.bookBy(guest);
        Assert.assertFalse(room.isAvailable());
        Assert.assertEquals(room.getCurrentGuest(), guest);
    }

    @Test(expectedExceptions = IllegalStateException.class, groups = "negative")
    public void testBookAlreadyBookedRoom() {
        room.bookBy(guest);
        Guest guest2 = new Guest("G-02", "Іван");
        room.bookBy(guest2); // Має викинути помилку
    }

    @DataProvider(name = "invalidRoomNumbers")
    public Object[][] invalidRoomNumbers() {
        return new Object[][] { {null}, {""}, {"   "} };
    }

    @Test(dataProvider = "invalidRoomNumbers", expectedExceptions = IllegalArgumentException.class, groups = "negative")
    public void testCreateRoomWithInvalidNumber(String invalidNumber) {
        new Room(invalidNumber); // Має викинути помилку
    }
}