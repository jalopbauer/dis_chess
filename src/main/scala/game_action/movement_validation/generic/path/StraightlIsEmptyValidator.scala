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
          val coordinateFunction =  if (vector.x == 0) (i: Int) => Coordinate(from.x, from.y + i)
                                    else (i: Int) => Coordinate(from.x  + i, from.y)
//          Tells if it is positive or negative
          val vectorSum = vector.x + vector.y
          val fromToRange =
            if (vectorSum>0) (1 until vectorSum).toList
            else (1 until vectorSum.abs).map(-_).toList
          if (vector.x == 1 || vector.y == 1) Left(gameData)
          else if (fromToRange.forall(i => {
            val coordinate = coordinateFunction(i)
            val dataOrInterruption = toPositionIsEmptyValidator.act(GameData(gameData.board, Movement(from, coordinate, movement.player), gameData.turns))
              dataOrInterruption.isLeft
            })) Left(gameData)
            else Right(PathIsNotEmpty(gameData))
        case Right(moveIsInvalid) => Right(moveIsInvalid)