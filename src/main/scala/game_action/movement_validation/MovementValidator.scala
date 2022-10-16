package game_action.movement_validation:
  
  import game_action.GameAction
  import game_action.pre_movement_validation.PostMovementValidator
  import game_data.GameData
  import game_interruption.GameInterruption
  
  trait MovementValidator extends GameAction :
    def act(gameData: GameData): Either[GameData, GameInterruption]