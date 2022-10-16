package game_interruption.pre_movement_validation:

  import game_data.GameData
  import game_interruption.GameInterruption

    case class CannotPlayPieceFromDifferentColor(gameData: GameData) extends GameInterruption(gameData: GameData):
      def getMessage:String =
        s"Piece in from position not your color: ${gameData.movement.from}"

