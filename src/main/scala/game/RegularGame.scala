package game:

  import game_action.movement_validation.exposed.RegularBoardPiecesMovementValidator
  import game_action.post_movement_invalidation.CheckValidator
  import game_action.post_movement_validation.CrownPawn
  import game_action.pre_movement_validation.DefaultPreMovementValidator
  import game_action.game_end_validation.CheckMateValidation
  case class RegularGame() extends Game(
    DefaultPreMovementValidator(), RegularBoardPiecesMovementValidator(), CrownPawn(), CheckValidator(), CheckMateValidation()
  )
