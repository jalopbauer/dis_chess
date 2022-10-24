package game:

  import game_action.movement_validation.MovementValidator
  import game_action.movement_validation.exposed.RegularBoardPiecesMovementValidator
  import game_action.post_movement_invalidation.CheckValidator
  import game_action.post_movement_validation.{CrownPawn, PostMovementValidator}
  import game_action.pre_movement_validation.{DefaultPreMovementValidator, PreMovementValidator}

  case class RegularGame() extends Game(
    DefaultPreMovementValidator(), RegularBoardPiecesMovementValidator(), CrownPawn(), CheckValidator()
  )
