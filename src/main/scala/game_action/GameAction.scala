package game_action:

  import game_data.GameData
  import game_interruption.GameInterruption

  trait GameAction():
    def act(gameData: GameData): Either[GameData, GameInterruption]
