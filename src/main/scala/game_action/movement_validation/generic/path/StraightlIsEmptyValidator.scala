package game_action.movement_validation.generic.path:

  import game_action.movement_validation.MovementValidator
  import game_action.movement_validation.generic.ToPositionIsEmptyValidator
  import game_action.movement_validation.generic.movement.MovementIsStraightValidator
  import game_data.GameData
  import game_data.board.Coordinate
  import game_data.movement.Movement
  import game_interruption.GameInterruption
  import game_interruption.movement_validation.PathIsNotEmpty

  case class StraightlIsEmptyValidator() extends MovementValidator:
    val toPositionIsEmptyValidator: ToPositionIsEmptyValidator = ToPositionIsEmptyValidator()
    val movementIsStraight: MovementIsStraightValidator = MovementIsStraightValidator()
    def act(gameData: GameData): Either[GameData, GameInterruption] =
      movementIsStraight.act(gameData) match
        case Left(gameData) =>
          val movement = gameData.movement
          val to = movement.to
          val from = movement.from
          val vector = movement.vector()
          val maxValsAndFunctio = if (to.x == 0) (vector.y,(i: Int) => Coordinate(to.x, to.y + i))
          else (vector.x, (i: Int) => Coordinate(to.x + i, to.y))
          if ((1 to maxValsAndFunctio._1).forall(i => toPositionIsEmptyValidator.act(GameData(gameData.board, Movement(from, maxValsAndFunctio._2(i), movement.player), gameData.turns)).isLeft)) Left(gameData)
          else Right(PathIsNotEmpty(gameData))
        case Right(moveIsInvalid) => Right(moveIsInvalid)