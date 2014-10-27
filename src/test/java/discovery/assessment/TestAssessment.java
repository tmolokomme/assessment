package discovery.assessment;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import org.junit.Test;

public class TestAssessment {

    @Test
    public void run() {
        try {
            /* you are allowed to add code here */

            JAXBContext jc_elist = JAXBContext.newInstance(EntityList.class);
            Unmarshaller unmarshaller_list = jc_elist.createUnmarshaller();
            File list_xml = new File("src/test/resources/discovery/assessment/entity-list.xml");
            EntityList entityList = (EntityList) unmarshaller_list.unmarshal(list_xml);

            JAXBContext jc_eInfo = JAXBContext.newInstance(EntityInfo.class);
            Unmarshaller info_unmarshaller = jc_eInfo.createUnmarshaller();
            File info_xml = new File("src/test/resources/discovery/assessment/entity-info.xml");
            EntityInfo entityInfo = (EntityInfo) info_unmarshaller.unmarshal(info_xml);

            Set<Long> treeSet = new TreeSet<Long>();
            Set<String> infoSet = new TreeSet<String>();
            List<EntityInfo.Entity> entities = new ArrayList<EntityInfo.Entity>();
            if (entityInfo != null) {
                entities = entityInfo.getEntity();
            }
            if (entityList != null) {
                List<Long> numbers = entityList.getEntityNo();
                for (long num : numbers) {
                    treeSet.add(num);
                }
                System.out.println();
                System.out.println(" --------------EXISTING ENTITIES REPORT-----------------");
                System.out.println("|NUMBER\t\tNAME\t\tSURNAME\t\t\t|");
                
                int size = treeSet.size();
                Long[] arr = new Long[size];
                for (Long currNo : treeSet) {
                    arr[--size] = currNo;
                }
                                
                for (Long currNo : arr) {
                    
                    if (entityInfo != null) {
                        
                        for (EntityInfo.Entity e : entities) {
                            if (e.getNo() == currNo) {
                                System.out.printf("|%d\t\t%s\t\t%s\t\t\t|\n", e.getNo(), e.getName(), e.getSurname());
                            }
                        }
                    }
                }
                System.out.println("|                                                       |");
                System.out.println("|______________END OF ENTITIES REPORT___________________|\n");
                
                System.out.println("************************");
                for (EntityInfo.Entity e : entities) {
                   infoSet.add(e.getName() + " " + e.getSurname());
                }
                for (String fullName: infoSet) {
                    System.out.println(fullName);
                }
                System.out.println("************************\n");
            }

        } catch (JAXBException ex) {
            Logger.getLogger(TestAssessment.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
