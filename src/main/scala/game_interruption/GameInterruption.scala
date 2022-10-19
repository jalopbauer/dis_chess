package game_interruption:
  
  import game_data.GameData
  
  trait GameInterruption(gameData: GameData):
    def getMessage:String

    def getGameData: GameData =
      gameData
