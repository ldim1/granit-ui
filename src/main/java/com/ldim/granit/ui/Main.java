package com.ldim.granit.ui;

import com.ldim.granit.ui.model.Root;
import com.ldim.granit.ui.model.State;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.util.Duration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ImportResource;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * Created by ldim on 18.04.2017.
 */
@SpringBootApplication
@EnableScheduling
@ImportResource("classpath:/scheme/root.groovy")
public class Main extends Application {
    private static Logger log = LoggerFactory.getLogger(Main.class);

    private ConfigurableApplicationContext springContext;
    private Group rootNode;

    private Root root;

    public static void main(final String[] args) {
        Application.launch(args);
    }

    @Override
    public void init() throws Exception {
        springContext = SpringApplication.run(Main.class);
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/Main.fxml"));
        fxmlLoader.setControllerFactory(springContext::getBean);
        rootNode = fxmlLoader.load();
        root = (Root)springContext.getBean("root");
    }

    @Override
    public void start(Stage stage) throws Exception {
        State state = root.getState(3, 1);
        state.setValue(0);
        state.setChanged(true);
        root.getState(3, 11).setValue(1);
        root.getState(3, 129).setChanged(true);
        //root.getState(3, 11).setChanged(true);
        //rootNode.relocate(-300, -300);
        //rootNode.setScaleX(0.75);
        //rootNode.setScaleY(0.75);
        root.getController(3).render(rootNode);
        stage.setScene(new Scene(rootNode, 640, 480));
        stage.show();
        Timeline timeline = new Timeline(new KeyFrame(Duration.millis(300),
                t -> root.next()));
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();
        log.debug("{}", root.getState(3, 129));
    }

    @Override
    public void stop() throws Exception {
        springContext.close();
    }
}
