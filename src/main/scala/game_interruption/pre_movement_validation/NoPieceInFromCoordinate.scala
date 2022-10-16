package game_interruption.pre_movement_validation:
  
  import game_data.GameData
  import game_interruption.GameInterruption
  
    case class NoPieceInFromCoordinate(gameData: GameData) extends GameInterruption(gameData: GameData):
      def getMessage:String =
        s"No piece in from coordinate: ${gameData.movement.to}"

