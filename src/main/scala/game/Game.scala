package game:

  import game_action.movement_validation.MovementValidator
  import game_action.post_movement_validation.PostMovementValidator
  import game_action.pre_movement_validation.PreMovementValidator
  import game_data.GameData
  import game_interruption.GameInterruption

  trait Game(preMovementValidator: PreMovementValidator, movementValidator: MovementValidator, postMovementValidator: PostMovementValidator):
    def play(gameData: GameData): Either[GameData, GameInterruption] = {
      val preMovementDataOrInterruption = preMovementValidator.act(gameData)
      preMovementDataOrInterruption match
        case Right(x) => Right(x)
        case Left(value) =>
          val dataOrInterruption = movementValidator.act(value)
          dataOrInterruption match
          case Right(x) => Right(x)
          case Left(value) =>
            println(value.board)
            postMovementValidator.act(GameData(value.board,value.movement,value.turns))
    }


