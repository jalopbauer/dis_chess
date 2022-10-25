package factory.board

import factory.board.board_piece_map.*
import game_data.board.RegularBoard

  case class OtherBoardExampleFactory() extends BoardFactory :
      def createBoard(): RegularBoard =
        val pieces =
          RegularPawnsFactory().createPieces()
          ++
            RegularKnightsFactory().createPieces()
          ++ RegularQueensFactory().createPieces()
          ++ RegularKingsFactory().createPieces()
          ++ EmptyPositionsFactory().createPieces()
        RegularBoard(pieces)
