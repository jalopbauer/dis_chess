package game:

  import game_action.movement_validation.MovementValidator
  import game_action.post_movement_validation.PostMovementValidator
  import game_action.pre_movement_validation.PreMovementValidator
  import game_interruption.GameInterruption

  case class Game(preMovementValidator: PreMovementValidator, movementValidator: MovementValidator, postMovementValidator: PostMovementValidator):



