package game_interruption.pre_movement_validation:
  
  import game_data.GameData
  import game_interruption.GameInterruption
  
    case class ToCoordinateIsInvalid(gameData: GameData) extends GameInterruption(gameData: GameData):
      def getMessage:String =
        s"From coordinate is invalid: ${gameData.movement.to}"

