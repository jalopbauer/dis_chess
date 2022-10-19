package game_integration:

  import edu.austral.dissis.chess.gui.{BoardSize, InitialState}
  import game_data.GameData

  case class InitialStateFactory():
    val miPiecesToChessPiece: MiPiecesToChessPiece = MiPiecesToChessPiece()
    val myPieceColorToPlayerColor: MyPieceColorToPlayerColor = MyPieceColorToPlayerColor()
    def create(gameData:GameData): InitialState =
      new InitialState(new BoardSize(8,8)
        , miPiecesToChessPiece.transform(gameData.board.getPieces)
        , myPieceColorToPlayerColor.transform(gameData.movement.player.color))
