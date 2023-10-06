package dis_chess.board.response

import dis_chess.board.ChessBoard
import dis_chess.chessPiece.ChessPiece
import dis_chess.position.Position

class ValidMoveResponse<T: Position>(fromChessPiece: ChessPiece?, toChessPieceOptional: ChessBoard<T>) : MoveResponse<T>
