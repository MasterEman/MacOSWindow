import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class macOSWindow extends Application {

	public static void main(String[] args) {
		launch();
	}

	// Default window size
	int windowWidth = 200;
	int windowHeight = 170;

	@SuppressWarnings("all")
	public void start(Stage window) throws Exception {
		
		Group root = new Group();
		
		Rectangle bg = new Rectangle(windowWidth, windowHeight);
		bg.setFill(Color.WHITE);
		bg.setArcHeight(10);
		bg.setArcWidth(10);
		
		// Navigation Bar --------------------
		
		Rectangle bar = new Rectangle(windowWidth, 20);
		bar.setFill(Color.LIGHTGREY);
		bar.setArcHeight(10);
		bar.setArcWidth(10);
		
		Circle xCir = new Circle(10, 10, 7);
		xCir.setFill(Color.INDIANRED);
		xCir.setStroke(Color.BLACK);
		xCir.setStrokeWidth(1);
		xCir.setOnMouseEntered(e -> {
			xCir.setFill(Color.RED);
		});
		xCir.setOnMouseExited(e -> {
			xCir.setFill(Color.INDIANRED);
		});
		xCir.setOnMouseClicked(e -> {
			window.setIconified(true);
			System.exit(0);
		});
		
		Circle miCir = new Circle(30, 10, 7);
		miCir.setFill(Color.LIGHTYELLOW);
		miCir.setStroke(Color.BLACK);
		miCir.setStrokeWidth(1);
		miCir.setOnMouseEntered(e -> {
			miCir.setFill(Color.YELLOW);
		});
		miCir.setOnMouseExited(e -> {
			miCir.setFill(Color.LIGHTYELLOW);
		});
		miCir.setOnMouseClicked(e -> {
			window.setIconified(true);
		});
		
		Circle maCir = new Circle(50, 10, 7);
		maCir.setFill(Color.LIGHTGREEN);
		maCir.setStroke(Color.BLACK);
		maCir.setStrokeWidth(1);
		maCir.setOnMouseEntered(e -> {
			maCir.setFill(Color.GREEN);
		});
		maCir.setOnMouseExited(e -> {
			maCir.setFill(Color.LIGHTGREEN);
		});
		maCir.setOnMouseClicked(e -> {
			if (window.isMaximized()) {
				window.setMaximized(false);
				bg.setWidth(windowWidth);
				bg.setHeight(windowHeight);
				bar.setWidth(windowWidth);
			} else {
				window.setMaximized(true);
				bg.setWidth(window.getWidth());
				// 40 = windows taskbar height
				//bg.setHeight(window.getHeight() - 40);
				bg.setHeight(window.getHeight());
				bar.setWidth(window.getWidth());
			}
		});
	
		// --------------------
		
		root.getChildren().add(bg);
		
		root.getChildren().add(bar);
		root.getChildren().addAll(miCir, maCir, xCir);
		
		Scene mainScene = new Scene(root, windowWidth, windowHeight);
		mainScene.setFill(Color.TRANSPARENT);
		
		// --------------------
		
		window.initStyle(StageStyle.TRANSPARENT);
		window.setAlwaysOnTop(true);
		window.setScene(mainScene);
		window.setTitle("");
		window.show();
	}
}
