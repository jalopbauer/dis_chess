package game:

  import game_action.movement_validation.MovementValidator
  import game_action.movement_validation.exposed.RegularBoardMovementValidator
  import game_action.post_movement_validation.{CrownPawn, KingWasEatenValidator, PostMovementValidator}
  import game_action.pre_movement_validation.{DefaultPreMovementValidator, PreMovementValidator}

  case class RegularGame() extends Game(
    DefaultPreMovementValidator(), RegularBoardMovementValidator(), CrownPawn()
  )
