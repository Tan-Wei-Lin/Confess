package cfsprj;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Post implements Comparable<Post>{
    
    private String id;
    private String cfsCtnt;
    private String date;
    private Date currentDate;
   
    //empty constructor for Post class
    public Post(){
        id = null;
        cfsCtnt = null;
        date = null;
        currentDate = null;
    }
    
    //Constructor without id
    public Post(String ctnt){
        cfsCtnt = ctnt;
        currentDate = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd h:mm a");
        date = dateFormat.format(currentDate);
    }
    
    //Constructor with id
    public Post(String id, String cfsCtnt){
        this.id=id;
        this.cfsCtnt = cfsCtnt;
        currentDate = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd h:mm a");
        date = dateFormat.format(currentDate);
    }
    
    //setter and getter
    public Date getcurrentDate(){
        return currentDate;
    }
    
    public void setCurrentDate(Date date){
        this.currentDate= date;
    }
    
    public String getDate(){
        return date;
    }
    
    public void setDate(String date){
        this.date = date;
    }
    
    public String getID(){
        return id;
    }
    
    public void setID(String ID){
        this.id = ID;
    }
    
    public String getCtnt(){
        return cfsCtnt;
    }
    
    public void setCtnt(String content){
        this.cfsCtnt=content;
    }
    
    @Override
    public String toString() {
        int idNum = Integer.parseInt(id.substring(2));
        return String.format("#DS%05d \n[%s]\n\n%s", idNum, date, cfsCtnt);
    }
    
    //arrange post according to their ID
    @Override
    public int compareTo(Post o) {
        if (convertId(id) > convertId(o.id))
            return 1;
        else if (convertId(id) < convertId(o.id))
            return -1;
        return 0;
    }
    
    //convert id from string to int so that it can be compared in the compareTo method
    private int convertId (String id){
        String convId = id.substring(3);//Substring(3) to remove the first 3 letter (UMC in the beginning of post ID)
        return Integer.parseInt(convId);
    }
    
}
