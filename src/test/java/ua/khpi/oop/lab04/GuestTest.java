package ua.khpi.oop.lab04;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class GuestTest {

    @Test(groups = "smoke")
    public void testGuestCreation() {
        Guest guest = new Guest("G-99", "Марія");
        Assert.assertEquals(guest.getGuestId(), "G-99");
        Assert.assertEquals(guest.getFullName(), "Марія");
    }

    @DataProvider(name = "invalidGuestData")
    public Object[][] invalidGuestData() {
        return new Object[][] {
                {null, "Ім'я"},
                {"G-01", null},
                {"", ""},
                {"   ", "Ім'я"}
        };
    }

    @Test(dataProvider = "invalidGuestData", expectedExceptions = IllegalArgumentException.class, groups = "negative")
    public void testGuestCreationWithInvalidData(String id, String name) {
        new Guest(id, name);
    }
}