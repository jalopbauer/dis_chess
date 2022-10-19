package game_integration:

  import edu.austral.dissis.chess.gui.Position
  import game_data.board.Coordinate

  case class MyCoordinateToPosition():
    def transform(coordinate:Coordinate):Position =
      new Position(coordinate.y,coordinate.x)

    def reverse(position: Position): Coordinate =
      new Coordinate(position.getColumn, position.getRow)