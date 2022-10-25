package game_interruption.game_end_validation
  
  import game_data.GameData
  import game_interruption.GameInterruption
  
  case class KingWasEaten(gameData: GameData) extends GameEnd, GameInterruption(gameData: GameData):
    def getMessage:String =
      s"No piece in from coordinate: ${gameData.movement.to}"