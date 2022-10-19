package game_integration:

  import edu.austral.dissis.chess.gui.NewGameState
  import game_data.GameData
  import game_data.turn.Turn

  case class NewGameStateGenerator():
    val miPiecesToChessPiece: MiPiecesToChessPiece = MiPiecesToChessPiece()
    val myPieceColorToPlayerColor: MyPieceColorToPlayerColor = MyPieceColorToPlayerColor()
    def generate(gameData: GameData): NewGameState =
      val player = myPieceColorToPlayerColor.transform(gameData.movement.player.color)
      new NewGameState(miPiecesToChessPiece.transform(gameData.board.getPieces),player)