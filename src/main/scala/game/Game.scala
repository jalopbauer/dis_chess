package game:

  import game_action.game_end_validation.GameEndValidator
  import game_action.movement_validation.MovementValidator
  import game_action.post_movement_invalidation.{CheckValidator, PostMovementInvalidator}
  import game_action.post_movement_validation.PostMovementValidator
  import game_action.pre_movement_validation.PreMovementValidator
  import game_data.GameData
  import game_data.piece.PieceColor
  import game_data.turn.Turn
  import game_interruption.GameInterruption

  trait Game(preMovementValidator: PreMovementValidator, movementValidator: MovementValidator, postMovementValidator: PostMovementValidator, postMovementInvalidator: PostMovementInvalidator, gameEndValidator: GameEndValidator):
//    Esto esta horrible, se que esta mal, no lo voy a cambiar hay un patron 
//    para esto pero ya la cague en todo el programa entoncess...... de baja

    def play(gameData: GameData): Either[GameData, GameInterruption] = {
      preMovementValidator.act(gameData) match
        case Right(x) => Right(x)
        case Left(value) =>
          movementValidator.act(value) match
          case Right(x) => Right(x)
          case Left(value) =>
            postMovementValidator.act(GameData(value.board,value.movement,value.turns)) match
              case Right(x) => Right(x)
              case Left(postMovementValidatorGameData) =>
                val movement = postMovementValidatorGameData.movement
                val tuple = postMovementValidatorGameData.board.makeMovement(movement)
                val newGameData = GameData(tuple._1
                  , movement
                  , postMovementValidatorGameData.turns
                    .appended(Turn(tuple._2, movement)))
                postMovementInvalidator.act(newGameData) match
                  case Right(x) => Right(x)
                  case Left(_) =>
                    gameEndValidator.act(newGameData) match
                      case Right(x) => Right(x)
                      case Left(value) =>Left(value)

    }


