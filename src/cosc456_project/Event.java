
package cosc456_project;

public class Event {
    private static Event instance;
    
    private Event(){
        
    }
    
    public static Event getInstance(){
        if (instance == null){
            instance = new Event();
        }
        return instance;
    }
}
