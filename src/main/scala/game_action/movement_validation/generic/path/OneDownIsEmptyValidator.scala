package game_action.movement_validation.generic.path:

  import game_action.movement_validation.MovementValidator
  import game_action.movement_validation.generic.ToPositionIsEmptyValidator
  import game_data.GameData
  import game_data.board.Coordinate
  import game_data.movement.Movement
  import game_interruption.GameInterruption
  import game_interruption.movement_validation.MoveIsInvalid

  case class OneDownIsEmptyValidator() extends MovementValidator:
    val toPositionIsEmptyValidator: ToPositionIsEmptyValidator = ToPositionIsEmptyValidator()
    def act(gameData: GameData): Either[GameData, GameInterruption] =
      toPositionIsEmptyValidator.act(GameData(
        gameData.board
        , Movement(gameData.movement.from,Coordinate(gameData.movement.to.x,gameData.movement.to.y-1), gameData.movement.player)
        , gameData.turns
      ))





