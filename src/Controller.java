
public class Controller {
    private BSTDict idBST = new BSTDict(true);
    private BSTDict keywordBST = new BSTDict(false);
    private BSTDict costBST = new BSTDict(false);
    private BSTDict dateBST = new BSTDict(false);
    
    public boolean insert(Seminar newSeminar) {
        
        boolean found = idBST.find(newSeminar.id()) != null;
        
        if (found) {
            System.out.println("Insert FAILED - There is already a record with ID " + newSeminar.id());
        }
        else {
         // insert object in id tree
            idBST.insert(newSeminar.id(), newSeminar);
            
            // insert seminar for each keyword in keyword tree
            String[] keywordList = newSeminar.keywords();
            for (String key : keywordList) {
                keywordBST.insert(key, newSeminar);
            }
            
            // insert in cost tree
            costBST.insert(newSeminar.cost(), newSeminar);
            
            // insert in dateBST
            dateBST.insert(newSeminar.date(), newSeminar);
            
            System.out.println("Successfully inserted record with ID " + newSeminar.id());
            System.out.println(newSeminar.toString());
            
            return true; 
        }
        
        return false;
        
    }
    
    public void search(String type, String searchKey) {
        
        switch(type) {
        case "ID":
            int idNumber = Integer.parseInt(searchKey);
            Object[] found = idBST.find(idNumber);
            System.out.println("Seminars matching ID " + idNumber + ":");
            if (found == null) {
                return;
            }
            for (Object obj : found) {
                if (obj != null) {
                    KVPair object = (KVPair)obj;
                    Seminar sem = (Seminar) object.value();
                    System.out.println(sem.toString());
                }
            }
            break;
        case "cost":
            int costNum = Integer.parseInt(searchKey);
            Object[] costSems = costBST.find(costNum);
            System.out.println("Seminars matching cost " + costNum + ":");
            if (costSems == null) {
                return;
            }
            for (Object obj : costSems) {
                if (obj != null) {
                    KVPair object = (KVPair)obj;
                    Seminar sem = (Seminar) object.value();
                    System.out.println(sem.toString());
                }
            }
            break;
        case "date":
            
            Object[] dateSems = dateBST.find(searchKey);
            System.out.println("Seminars matching date " + searchKey + ":");
            if (dateSems == null) {
                return;
            }
            for (Object obj : dateSems) {
                if (obj != null) {
                    KVPair object = (KVPair)obj;
                    Seminar sem = (Seminar) object.value();
                    System.out.println(sem.toString());
                }
            }
            break;
        case "keyword":
            Object[] keywordSems = keywordBST.find(searchKey);
            System.out.println("Seminars matching keyword " + searchKey + ":");
            if (keywordSems == null) {
                return;
            }
            for (Object obj : keywordSems) {
                if (obj != null) {
                    KVPair object = (KVPair)obj;
                    Seminar sem = (Seminar) object.value();
                    System.out.println(sem.toString());
                }
            }
            break;
        }
    }
    
    public void remove(int id) {
        Object removed = idBST.remove(id);
        if (removed != null) {
            System.out.println("Record with ID " + id + " successfully deleted from the database");
        }
        else {
            System.out.println("Delete FAILED - there is no record with ID " + id);
        }
    }
}
