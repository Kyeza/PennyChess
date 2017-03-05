package pennyChess;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class PennyChess extends Application {
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		
		Platform.runLater(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				Insets mars_pads = new Insets(0, 0, 0, 0);
				GridPane chessboard = new GridPane();
				chessboard.setAlignment(Pos.CENTER);
				chessboard.setPadding(mars_pads);
				chessboard.setHgap(0);
				chessboard.setVgap(0);
				chessboard.setGridLinesVisible(true);
				chessboard.setStyle("-fx-background-color: white;");
				chessboard.setBorder(new Border(new BorderStroke(Color.DARKGREY, BorderStrokeStyle.SOLID, 
						CornerRadii.EMPTY, new BorderWidths(5))));

				Rectangle[][] squares = new Rectangle[8][8];
				
				for(int i = 0; i < squares.length ; i++){
					for(int j = 0; j < squares[i].length; j++){
						Rectangle square = new Rectangle(64, 64);
						if (((i % 2 == 0) && (j % 2 == 0)) || ((i % 2 == 1) && (j % 2 == 1))) {
							square.setFill(Color.WHITE);
						}else {
							square.setFill(Color.BLACK);
						}
						squares[i][j] = square;
					}
				}
				
				for(int i = 0; i < squares.length ; i++){
					for(int j = 0; j < squares[i].length; j++){
						chessboard.add(squares[i][j], j, i);
						GridPane.setMargin(squares[i][j], mars_pads);
					}
				}
				
				Scene scene = new Scene(chessboard, 500, 500);
				primaryStage.setTitle("PennyChess v0.0");
				primaryStage.setScene(scene);
				primaryStage.show();
			}
		});
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Application.launch(args);
	}

}
