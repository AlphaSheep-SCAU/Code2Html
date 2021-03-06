package View;

import Eggs.Game;
import com.sun.deploy.uitoolkit.impl.fx.HostServicesFactory;
import com.sun.javafx.application.HostServicesDelegate;
import javafx.application.Application;
import javafx.application.HostServices;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Separator;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Modality;
import javafx.stage.Stage;


/**
 * Created by cdzos on 2017/5/7.
 */
public class AboutStage extends Stage {

    private Scene mainScene;
    private VBox mainPane;

    private Application app;

    public static String AboutContent = "组员：\n" +
            "陈度中\n" +
            "曾敏洋\n" +
            "陈广鹏\n";

    public AboutStage(Application app) {
        super();
        this.app = app;

        mainPane = new VBox();
        mainPane.setAlignment(Pos.TOP_CENTER);
        mainPane.setPadding(new Insets(24, 20, 5, 20));

        Text title = new Text("源代码转换程序");
        title.setTextAlignment(TextAlignment.CENTER);
        title.setFont(new Font(36));
        title.prefWidth(480);

        Hyperlink hyperLink = new Hyperlink("https://github.com/ChannelOne/Code2Html");
        hyperLink.setOnAction(event -> {
            HostServicesDelegate hostServices = HostServicesFactory.getInstance(app);
            hostServices.showDocument("https://github.com/ChannelOne/Code2Html");
        });

        Text content = new Text(AboutContent);
        content.setFont(new Font(18));

        Image logo = new Image(getClass().getResourceAsStream("/image/c2html.png"));
        ImageView logoView = new ImageView(logo);
        logoView.setFitWidth(200);
        logoView.setFitHeight(200);
        logoView.setOnMouseClicked((MouseEvent e) -> {
            if(e.getClickCount() == 2){
                Game game = new Game();
                try {
                    game.start(this);
                } catch (Exception e1) {
                    e1.printStackTrace();
                }
            }
        });

        mainPane.getChildren().addAll(logoView , new Text() , title, hyperLink, content);
        mainScene = new Scene(mainPane, 480, 420);

        // content.wrappingWidthProperty().bind(mainPane.widthProperty().divide(3));

        initModality(Modality.APPLICATION_MODAL);
        setTitle("关于");
        getIcons().add(new Image(getClass().getResourceAsStream("/image/c2html.png")));
        setScene(mainScene);
        setResizable(false);
    }

}
