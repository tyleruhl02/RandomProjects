package HighSchool.AP.Game_of_Life;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.collections.*;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.*;
import java.util.*;

public class LifeController extends Application {
    private static final double TIME_INTERVAL = .02;
  
    private ObservableList<String> fileListOptions;
    private Label generationLabel = new Label();
    private ComboBox<String> fileListBox;
    private Button runPauseButton;
    private Button stepButton;
    private Button resetCountButton;
    private Life life;
    private boolean running;
    private Canvas canvas;
    
    public static void main(String[] args) {
      launch(args);
    }

    private ObservableList<String> getFileListOptions() {
      ObservableList<String> list = FXCollections.observableArrayList();
      
      File dir = new File("src\\HighSchool.AP\\Game_of_Life\\");
      File[] fileList = dir.listFiles();

      for (File f : fileList) {
        if (f.isFile()) {
          String name = f.getName();
          String extension = name.substring(name.length()-3).toLowerCase();
          if (extension.equals("txt")) {
            list.add("src\\HighSchool.AP\\Game_of_Life\\" + f.getName());
          }
        }
      }
      Collections.sort(list);
      return list;
    }
    
    @Override
    public void init() throws Exception {
        super.init();
        fileListOptions = getFileListOptions();
        fileListBox = new ComboBox<>(fileListOptions);
        fileListBox.setValue(fileListOptions.get(0));
        runPauseButton = new Button("Run / Pause");
        stepButton = new Button("Step");
        resetCountButton = new Button("Reset Gen Count");
        life = new Life(fileListOptions.get(0));
        running = true;
    }

    @Override
    public void start(Stage stage) {
        BorderPane bPane = new BorderPane();
        canvas = new Canvas(500, 500);
        
        bPane.setTop(generationLabel);
        
        HBox hbox = new HBox(8);
        hbox.getChildren().addAll(fileListBox, runPauseButton, stepButton, resetCountButton);
        bPane.setBottom(hbox);
        
        bPane.setCenter(canvas);

        stepButton.setOnAction(new EventHandler<ActionEvent>() {
          @Override public void handle(ActionEvent e) {
            life.passTime();
            updateBoard();
          }
        });

       
        runPauseButton.setOnAction(new EventHandler<ActionEvent>() {
          @Override public void handle(ActionEvent e) {
            running = ! running;
          }
        });

        resetCountButton.setOnAction(new EventHandler<ActionEvent>() {
          @Override public void handle(ActionEvent e) {
            life.resetGeneration();
            generationLabel.setText(fileListBox.getValue() + "; Generation: " + life.getGeneration());
          }
        });
        
        fileListBox.valueProperty().addListener((ov, oldValue, newValue) -> {
                life = new Life((String)newValue);
                updateBoard();
            }
        );
        
        canvas.addEventHandler(MouseEvent.MOUSE_CLICKED, 
        new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent t) {   
              if (t.getClickCount() == 1){
                GraphicsContext gc = canvas.getGraphicsContext2D();
                double w = gc.getCanvas().getWidth();
                double h = gc.getCanvas().getHeight();
                double x = t.getX();
                double y = t.getY();
                
                int c = (int) (Life.MAX_COLUMNS * x/w);
                int r = (int) (Life.MAX_ROWS * y/h);
                
                life.toggleGridValue(r,c);
                updateBoard();
              }
            }
        });
        
        Timeline timeline = new Timeline(
                new KeyFrame(Duration.seconds(TIME_INTERVAL), e -> {
                    if(!running)
                      return;
                    life.passTime();
                    updateBoard();
                }));
        timeline.setAutoReverse(true);
        timeline.setCycleCount(Timeline.INDEFINITE);

        stage.setTitle("Life");
        stage.setScene(new Scene(bPane));
        stage.show();

        timeline.play();
    }
    
    public void updateBoard(){
      GraphicsContext gc = canvas.getGraphicsContext2D();
      double w = gc.getCanvas().getWidth();
      double h = gc.getCanvas().getHeight();
      double cw = w / Life.MAX_COLUMNS;
      double ch = h / Life.MAX_ROWS;
      
      gc.setFill(Color.CORNSILK);
      gc.fillRect(0, 0, w, h);
      
      gc.setFill(Color.FORESTGREEN);
      
      for (int i = 0; i < Life.MAX_ROWS; i++) {
        for (int j = 0; j < Life.MAX_COLUMNS; j++) {
          if (life.isAlive (i, j)) {
            double y = ch * i;
            double x = cw * j;
            gc.fillRect(x, y, cw, ch);
          }
        }
      }
      generationLabel.setText(fileListBox.getValue() + "; Generation: " + life.getGeneration());
    }
    
    
}