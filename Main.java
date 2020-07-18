package assignment5;


import java.io.File;
import java.io.FilenameFilter;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.nio.IntBuffer;
import java.util.ArrayList;
import java.util.List;

import javafx.application.Application;
import javafx.scene.Parent;
import javafx.fxml.FXMLLoader;


import assignment5.Critter;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import jdk.nashorn.internal.ir.Assignment;

public class Main extends Application{    
 


	public void start(Stage primaryStage) throws Exception{                
        GridPane gridPane = new GridPane();
        File f = new File("C:\\Programming Assignment 5/src/assignment5"); 
        FilenameFilter filter = new FilenameFilter() { 
        Class<?> myCritter;
        Class<?> myclass;
        Object o;
    	
        public boolean accept(File f, String name) 
        { 
        	try {
        			name = name.replace(".java","");
        		 	myCritter= Class.forName("assignment5."+ name);
        		 	o = myCritter.newInstance();
	 				if( o instanceof Critter) {
	 					return true;
	 				}
	 				else {
	 					return false;
	 				}
	 				
				} 
				catch(Exception e) {		
					return false;
				}
		}  
        };
        
        // Get all the names of the files present 
        // in the given directory 
        String[] files = f.list(filter); 

        System.out.println("Files are:"); 

        // Display the names of the files 
        for (int i = 0; i < files.length; i++) { 
            System.out.println(files[i]); 
        }
        
        
 // Create a Critter: Button, Text field and  drop down        
        //add button 
        Button addbtn = new Button();
        addbtn.setText("Add Critter");
        //critter count text field
        TextField critterCount = new TextField();
        
        //drop down 
        ComboBox<String> critterList = new ComboBox<String>();
        critterList.setValue("Clover");
        for(int i =0; i< files.length; i++) {
        	String Cname= files[i].toString().replace(".java", "");
        	critterList.getItems().add(Cname);
        }
        System.out.println(critterList.toString());
        gridPane.add(critterList, 0, 0);
        gridPane.add(addbtn, 1,0);
	    addbtn.setOnAction(new EventHandler<ActionEvent>() {
	 		// updating the counter.
	            @Override
	            public void handle(ActionEvent event) {
	            	
	            }
	        });
 //for Animate
	    //animate button
	    Button animate = new Button();
	    animate.setText("Animate");
	    //start animate button 
	    Button start = new Button();
	    start.setText("Start Animation");
	    //stop animate button 
	    Button stop = new Button();
	    stop.setText("Stop Animation");
	    //animate speed drop down menu
	    ComboBox<String> SpeedList = new ComboBox<String>();
	    SpeedList.getItems().add("2");
	    SpeedList.getItems().add("5");
	    SpeedList.getItems().add("10");
	    SpeedList.getItems().add("20");
	    SpeedList.getItems().add("50");
	    SpeedList.getItems().add("100");
//Quit
	    Button quit = new Button();
	    quit.setText("quit");
//Clear World
	    Button clear = new Button();
	    clear.setText("Clear World");
//Step
	    Button step = new Button();
	    step.setText("Step");
	    TextField stepCount = new TextField();
	    start.setText("1");
	    
	    
	     Scene scene = new Scene(gridPane, 300, 250);

	     primaryStage.setTitle("Critters");
	     primaryStage.setScene(scene);
	     primaryStage.show();
		 
             
        	   
	}
	
public static void main(String[] args) {      
	  
	launch(args); 
  
}
}
	
