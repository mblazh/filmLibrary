package com.group.app;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import java.io.File;

public class AddingMovieStage extends Stage {

    Text titleLabel = new Text("Title:");
    TextField titleText = new TextField();
    Text directorLabel = new Text("Directed By:");
    TextField directorText = new TextField();
    Text genreLabel = new Text("Genre:");
    TextField genreText = new TextField();
    Text runtimeLabel = new Text("Runtime (min):");
    SpinnerValueFactory<Integer> valueFactory =
            new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 300, 0);
    Spinner<Integer> spinner = new Spinner<Integer>();
    Button addfile = new Button("Add");
    FileChooser fileChooser = new FileChooser();
    ChoiceBox GenreBox = new ChoiceBox();
    Button addbutton = new Button("Finish");
    GridPane gridPane = new GridPane();
    Scene scene = new Scene(gridPane);
    DatePicker premieredate = new DatePicker();
    Text preimieredateLabel = new Text("Premiere Date:");
    Text MovieFileLabel = new Text("Movie File:");
    Text AboutMovieLabel = new Text("About a movie:");
    TextArea AboutMovieArea = new TextArea();

    AddingMovieStage() {

        addfile.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(final ActionEvent e) {

                File file = fileChooser.showOpenDialog(new Stage());
                if (file != null) {
                    String path = file.getPath();
                    System.out.println(path);}}} );

        addbutton.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(final ActionEvent e) {

                System.out.println(titleText.getText());







            }});


        spinner.setValueFactory(valueFactory);
        spinner.setEditable(true);

        fileChooser.setTitle("Open Resource File");
        GenreBox.getItems().addAll
                ("Action","Adventure","Comedy","Crime","Drama","Fantasy","Historical","Horror","Romance",                               "ScienceFiction","Thriller");

        AboutMovieArea.setPrefSize(300,200);
        AboutMovieArea.setWrapText(true);

        gridPane.setMinSize(100, 500);
        gridPane.setPadding(new Insets(10, 10, 10, 10));
        gridPane.setVgap(5);
        gridPane.setHgap(5);
        gridPane.setAlignment(Pos.TOP_CENTER);
        gridPane.add(titleLabel, 0, 0);
        gridPane.add(titleText, 1, 0);
        gridPane.add(directorLabel, 0, 1);
        gridPane.add(directorText, 1, 1);
        gridPane.add(genreLabel, 0, 2);
        gridPane.add(runtimeLabel, 0, 3);
        gridPane.add(spinner,1,3);
        gridPane.add(GenreBox, 1, 2);
        gridPane.add(addbutton, 2, 50);
        gridPane.add(preimieredateLabel,0,4);
        gridPane.add(premieredate,1,4);
        gridPane.add(MovieFileLabel,0,5);
        gridPane.add(addfile,1,5);
        gridPane.add(AboutMovieLabel,0,7);
        gridPane.add(AboutMovieArea,1,8);

        titleLabel.setStyle("-fx-font: normal bold 15px 'serif' ");
        directorLabel.setStyle("-fx-font: normal bold 15px 'serif' ");
        genreLabel.setStyle("-fx-font: normal bold 15px 'serif' ");
        runtimeLabel.setStyle("-fx-font: normal bold 15px 'serif' ");
        preimieredateLabel.setStyle("-fx-font: normal bold 15px 'serif' ");
        AboutMovieLabel.setStyle("-fx-font: normal bold 15px 'serif' ");
        MovieFileLabel.setStyle("-fx-font: normal bold 15px 'serif' ");

        gridPane.setStyle("-fx-background-color: BEIGE;");

        this.setTitle("Adding movie");
        this.setScene(scene);
        this.setResizable(false);
        this.show();
    }




}