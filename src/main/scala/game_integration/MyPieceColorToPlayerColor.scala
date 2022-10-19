package game_integration:

  import edu.austral.dissis.chess.gui.PlayerColor
  import game_data.piece.PieceColor

  case class MyPieceColorToPlayerColor():
    def transform(color:PieceColor):PlayerColor =
      color match
        case PieceColor.WHITE => PlayerColor.WHITE
        case PieceColor.BLACK => PlayerColor.BLACK