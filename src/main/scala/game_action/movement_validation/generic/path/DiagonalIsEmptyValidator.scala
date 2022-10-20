package game_action.movement_validation.generic.path:

  import game_action.movement_validation.MovementValidator
  import game_action.movement_validation.generic.ToPositionIsEmptyValidator
  import game_action.movement_validation.generic.movement.MovementIsDiagonalValidator
  import game_data.GameData
  import game_data.board.Coordinate
  import game_data.movement.Movement
  import game_interruption.GameInterruption
  import game_interruption.movement_validation.PathIsNotEmpty

  case class DiagonalIsEmptyValidator() extends MovementValidator:
    val toPositionIsEmptyValidator: ToPositionIsEmptyValidator = ToPositionIsEmptyValidator()
    val movementIsDiagonal: MovementIsDiagonalValidator = MovementIsDiagonalValidator()
    def act(gameData: GameData): Either[GameData, GameInterruption] =
      movementIsDiagonal.act(gameData) match
        case Left(gameData) =>
          val movement = gameData.movement
          val from = movement.from
          val to = movement.to
          val vector = to.vector(from)
          if ((1 to vector.x).forall(i => toPositionIsEmptyValidator.act(GameData(gameData.board, Movement(from, Coordinate(to.x + i, to.y + i), movement.player), gameData.turns)).isRight)) Left(gameData)
          else Right(PathIsNotEmpty(gameData))
        case Right(moveIsInvalid) => Right(moveIsInvalid)
