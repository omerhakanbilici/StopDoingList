import model.StopDoingItem;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import service.StopDoingService;

import static org.junit.Assert.*;

/**
 * Created by omerhakanbilici on 23.02.2014.
 * StopDoingList
 */

@ContextConfiguration({"classpath:application-context.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class StopDoingServiceTest {

    @Autowired
    StopDoingService stopDoingService;

    @Test
    public void testGet(){

        StopDoingItem stopDoingItem = stopDoingService.get("1");
        assertNotNull(stopDoingItem);

    }

    @Test
    public void testDiffItems(){

        StopDoingItem stopDoingItem1 = stopDoingService.get("1");
        StopDoingItem stopDoingItem2 = stopDoingService.get("2");
        assertNotEquals(stopDoingItem1, stopDoingItem2);

    }

    @Test
    public void testSaveItem(){

        int listSize = stopDoingService.list().size();
        int listSizeAfterSave;

        StopDoingItem stopDoingItem = new StopDoingItem();
        stopDoingItem.setItem("Feeling sexy");
        stopDoingItem.setStopped(false);

        stopDoingService.save(stopDoingItem);

        listSizeAfterSave = stopDoingService.list().size();
        assertNotEquals(listSize, listSizeAfterSave);
        assertEquals((listSize + 1), listSizeAfterSave);

    }

    @Test
    public void testDeleteItem(){

        int listSize = stopDoingService.list().size();
        int listSizeAfterDelete;

        if (listSize!=0){
            StopDoingItem stopDoingItem = stopDoingService.list().get(0);

            String itemId = stopDoingItem.getId();
            stopDoingService.remove(itemId);

            listSizeAfterDelete = stopDoingService.list().size();

            assertNull(stopDoingService.get(itemId));
            assertNotEquals(listSize, listSizeAfterDelete);

            assertEquals((listSize-1), listSizeAfterDelete);
        }

    }


}
