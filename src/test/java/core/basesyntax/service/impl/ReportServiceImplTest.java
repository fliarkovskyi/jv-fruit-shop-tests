package core.basesyntax.service.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.model.Fruit;
import core.basesyntax.service.ReportService;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ReportServiceImplTest {
    private static ReportService reportService;

    @Before
    public void setUp() throws Exception {
        reportService = new ReportServiceImpl();
    }

    @Test
    public void getReport_checkDate_ok() {
        Storage.storage.put(new Fruit("banana"), 152);
        Storage.storage.put(new Fruit("apple"), 90);
        String expect =
                "fruit,quantity"
                        + System.lineSeparator()
                        + "banana,152"
                        + System.lineSeparator()
                        + "apple,90"
                        + System.lineSeparator();
        String actual = reportService.getReport();
        Assert.assertEquals(expect, actual);
    }

    @After
    public void tearDown() throws Exception {
        Storage.storage.clear();
    }
}
