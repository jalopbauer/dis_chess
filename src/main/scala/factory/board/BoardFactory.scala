package factory.board:

  import game_data.board.Board

  trait BoardFactory:
    def createBoard(): Board
