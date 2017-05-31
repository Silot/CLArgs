
package args;

import java.io.File;
import java.io.StringWriter;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 *
 * @author mitsikeli
 * Namlis Apostolos 3655
 */
public class MyArgs {

    Scanner sc = new Scanner(System.in);
   
    private String option; //option for help
    private String phrase; //user input

    /**
     * 
     * @param enable if the youres wants to see the options the constractor 
     * with a boolean parameter true enables tha. Else leave empty.
     */
    public MyArgs(boolean enable) {
        
        if(enable == true)
            WhoAmI();
            getHelp();
            System.out.println("Ready: ");
            option = sc.nextLine();
           
    }
    
    /**
     * Default constructor
     */
    public MyArgs(){
        option = sc.nextLine();
    }

   /**
    *@return Help as a string.
    * @throws java.lang.RuntimeException if an unexpected option is encountered during parsing.
    *
    */
    public  String getHelp(){
        StringWriter out = new StringWriter();
        Help(out);
        return out.toString();
    }

    /**
     * 
     * @param out 
     * Contains the options
     */
    private  void Help(StringWriter out) {
        System.out.println("Options: \n "
                + "\t -pwd, --Print Working Directory \n"
                + "\t -md , --Make Directory  \n"
                + "\t -rd , --Remove Directory \n "
                + "\t -eh , --Echo Horisontaly  e.x -e Hello World!\n"
                + "\t -ev , --Echo Vertically \n"
                + "\t -w, Print Who Am I"
                + "\t -x, --Exit");
    }
  
    /**
     * Set of options for the user to choose and perform
     */
    public void start() {
    
    //options 
        
       if(option.equals("--help"))
           getHelp();
       if(option.equals("-pwd"))
         PrintWorkingDirectory();
       else if(option.equals("-md"))
        MakeDirectory();
       else if(option.equals("-rd"))
        RemoveDirectory();
       else if(option.equals("-eh")) 
        EchoH();
       else if(option.equals("-ev")) 
        EchoV();
       else if(option.equals("-e"))
        Exit();
        else
       System.out.println("Input Error !");
       
    }
    
    /**
     * Prints Hello and the pc name
     */
    public void WhoAmI(){
         System.out.println("Hello " + System.getProperty("user.name"));
    }
    
    /**
     * prints the current working directory
     */
   public void PrintWorkingDirectory() {

        System.out.println("Working Directory = " + System.getProperty("user.dir"));

    }
   
   /**
    * prints the current working directory 
    * @return the current working directory
    */
    public String getPrintWorkingDirectory() {
        
       
        String user = System.getProperty("user.dir"); //get user
        String userDirectory = "Working Directory " + user; //make a string to print
        
        return userDirectory;
   
    
    }

    /**
     * Prints horizontally whatever the user wants to
     */
    public void EchoH() {
        phrase = sc.nextLine();
        System.out.println(phrase);
    }
    
    /**
     * Prints horizontally whatever the user wants to
     * @param input The phrase the user wants to print given as a parameter
     */
    public void EchoH(String input) {
        System.out.println(input);
    }
    
    /**
     * 
     * @param in The phrase the user wants to print given as a parameter
     * @return The pgrase
     */
    public String getEchoH(String in){ 
       return in; 
    }

    /**
     * Prints vertically whatever the user wants to
     */
    public void EchoV() {
        phrase = sc.nextLine();
        StringTokenizer st = new StringTokenizer(phrase); //Tokenize the iinput
        while (st.hasMoreTokens()) {
            System.out.println(st.nextToken());
        }
    }
    
    /**
     * Creates a new directory 
     * The user choose the path and the name for the new directory
     */
    public void MakeDirectory() {
   
        String path; //file path
        String name = null; //file name
        System.out.println("Select the path for the directory to create ");

        path = sc.nextLine();
        System.out.println("Give a name for your directory");
        name = sc.nextLine();

        File f = null;
        boolean bool = false; 

        try {
           
            f = new File(path + "/" + name);

            // create
            bool = f.mkdir();

            // print
            if (bool == true) {
                System.out.println("Directory created? " + bool);
            } else {
                System.out.println("Path does not exist !");
            }
        } catch (Exception e) {
            // if any error occurs
            e.printStackTrace();
        }
   
    }

    /**
     * Removes o choosen directory 
     * The user choose the path and the name for the new directory
     */
    public void RemoveDirectory() {
        String path = null; // file path
        String name = null; //filename
        String file = path + "/" + name; //path and name
        System.out.println("Select the path for the directory to delete ");

        path = sc.nextLine();
        System.out.println("Give a name for your directory");
        name = sc.nextLine();

        File f = null;
        boolean bool = false; //check file 

        try {
           
            f = new File(path + "/" + name);

            // delete
            bool = f.delete();

            // print
            if (bool == true) {
                System.out.println("Directory Deleted? " + bool);
            } else {
                System.out.println("Path or name does not exist !");
            }
        } catch (Exception e) {
            // if any error occurs
            e.printStackTrace();
        }
    }

    /**
     * Quit the parser
     */
    private void Exit() {
        System.exit(0);
    }
}
