package edu.sustech.xiangqi;

import edu.sustech.xiangqi.model.AbstractPiece;
import edu.sustech.xiangqi.model.ChessBoardModel;

import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class AutoWarning {
    public static AbstractPiece warningPiece(ChessBoardModel chessBoardModel, CurrentCamp camp) {//the camp refers to the user who is now to move the piece
        //todo
        List<AbstractPiece> myCampTotalLIst = new ArrayList<>();
        for (AbstractPiece abstractPiece : chessBoardModel.getPieces()) {
            if (abstractPiece.isRed() != camp.isRedTurn()) {
                continue;
            }
            myCampTotalLIst.add(abstractPiece);
        }
        for (AbstractPiece abstractPiece : myCampTotalLIst) {
            abstractPiece.setTotalMoveCount(pieceTotalMoveCount(chessBoardModel, abstractPiece, camp));
        }
        List<AbstractPiece> biggetTotalMoveLIst = new ArrayList<>();

       //todo find the biggest movecount and if the same just use randomly
       for (AbstractPiece abstractPiece : myCampTotalLIst) {
           abstractPiece.setTotalMoveCount(pieceTotalMoveCount(chessBoardModel, abstractPiece, camp));
       }
        int currentValue = 100;
        AbstractPiece generalOne = chessBoardModel.findGeneral(camp.isRedTurn());
        AbstractPiece generalTwo = chessBoardModel.findGeneral(!camp.isRedTurn());
        if (chessBoardModel.isInCheck(camp.isRedTurn())) {
            for (AbstractPiece abstractPiece : myCampTotalLIst) {
                 int value =  abstractPiece.getTotalMoveCount();
                 if  (value > currentValue) {
                     currentValue = value;
                     biggetTotalMoveLIst.clear();
                     biggetTotalMoveLIst.add(abstractPiece);
                 } else if (value == currentValue) {
                     biggetTotalMoveLIst.add(abstractPiece);
                 }
            }
        } else  {
            for (AbstractPiece abstractPiece : myCampTotalLIst) {
                if (abstractPiece.equals(generalOne) ||  abstractPiece.equals(generalTwo)) {continue;}
                int value =  abstractPiece.getTotalMoveCount();
                if  (value > currentValue) {
                    currentValue = value;
                    biggetTotalMoveLIst.clear();
                    biggetTotalMoveLIst.add(abstractPiece);
                }  else if (value == currentValue) {
                    biggetTotalMoveLIst.add(abstractPiece);
                }
            }
        }
        if (biggetTotalMoveLIst.isEmpty()) {
            // Handle case with no moves (e.g., stalemate or checkmate)
            return null;
        }
        if (biggetTotalMoveLIst.size() == 1) {
            return biggetTotalMoveLIst.get(0);
        } else {
            Random random = new Random();
            return biggetTotalMoveLIst.get(random.nextInt(biggetTotalMoveLIst.size()));
        }
    }

    public static int pieceTotalMoveCount(ChessBoardModel chessBoardModel, AbstractPiece abstractPiece, CurrentCamp currentCamp){
        //todo(value you need to deal with)
        int countValue = 0;
        for (int row = 0; row < chessBoardModel.getRows(); row++) {
            for (int col = 0; col < chessBoardModel.getCols(); col++) {
                AbstractPiece target = chessBoardModel.getPieceAt(row, col);
                if ( target != null && target.isRed() == abstractPiece.isRed()) {
                    continue;
                }
                if (abstractPiece.canMoveTo(row, col,chessBoardModel)) {
                    //simulate the move after the move
                      ChessBoardModel currentModel = chessBoardModel.deepCopy();
                      AbstractPiece currentPieceInCopy = currentModel.getPieceAt(abstractPiece.getRow(), abstractPiece.getCol());
                      AbstractPiece targetPieceInCopy = currentModel.getPieceAt(row, col);

                      if (targetPieceInCopy != null) {
                          currentModel.remove(targetPieceInCopy);
                      }
                      if (currentPieceInCopy != null) {
                          currentModel.movePieceForce(currentPieceInCopy,row,col);
                      }
                      boolean isSelfCheck = currentModel.isInCheck(currentCamp.isRedTurn());//the camp is who has move the piece
                      if (isSelfCheck) {
                          countValue = countValue;
                          continue;
                      } else {
                          if (target == null) {
                              countValue = countValue + 2;
                          }  else {
                              AbstractPiece generalOne = chessBoardModel.findGeneral(currentCamp.isRedTurn());
                              AbstractPiece generalTwo = chessBoardModel.findGeneral(!currentCamp.isRedTurn());
                              if (target == generalOne || target == generalTwo) {
                              countValue = countValue + 99999999;
                              } else {
                                  int value = target.getValue();
                                  countValue = countValue + value;
                              }
                          }
                      }
                }
            }
        }
        return countValue;
    }

    public static java.util.List<Point> chooseToMoveOrEat (ChessBoardModel chessBoardModel,AbstractPiece abstractPiece, CurrentCamp currentCamp, java.util.List<Point> autoMoves,java.util.List<Point> autoEats) {
        //todo(isincheck, the count value, return what?)
        autoMoves.clear();
        autoEats.clear();
        int eatCount = 0;
        int moveCount = 0;
        java.util.List<Point> chooseWhich = new java.util.ArrayList<>();
            for (int row = 0; row < chessBoardModel.getRows(); row++) {
                for (int col = 0; col < chessBoardModel.getCols(); col++) {
                    AbstractPiece target = chessBoardModel.getPieceAt(row, col);
                    if (target != null && target.isRed() == abstractPiece.isRed()) {
                        continue;
                    }
                    if (abstractPiece.canMoveTo(row, col, chessBoardModel)) {
                        ChessBoardModel currentModel = chessBoardModel.deepCopy();
                        AbstractPiece currentPieceInCopy = currentModel.getPieceAt(abstractPiece.getRow(), abstractPiece.getCol());
                        AbstractPiece targetPieceInCopy = currentModel.getPieceAt(row, col);

                        if (targetPieceInCopy != null) {
                            currentModel.remove(targetPieceInCopy);
                        }
                        if (currentPieceInCopy != null) {
                            currentModel.movePieceForce(currentPieceInCopy, row, col);
                        }
                        boolean isSelfCheck = currentModel.isInCheck(currentCamp.isRedTurn());//the camp is who has move the piece

                        if (isSelfCheck) {
                            continue;
                            //todo
                        } else {
                            //todo
                            if (target == null) {
                                moveCount = moveCount + 2;
                                autoMoves.add(new Point(row, col));
                            } else {
                                eatCount = eatCount + 5;
                                autoEats.add(new Point(row, col));
                            }
                        }
                    }

                }
            }
            //todo(choose which)
            if (moveCount > eatCount) {
                if (!autoMoves.isEmpty()) {
                    Random random = new Random();
                    Point bestMove = autoMoves.get(random.nextInt(autoMoves.size()));
                    chooseWhich.add(bestMove);
                }
            }
            if (eatCount >= moveCount) {
                if (!autoEats.isEmpty()) {
                List<AbstractPiece> myCampTotalLIst = new ArrayList<>();
                for (int i = 0; i < autoEats.size(); i++) {
                    Point currentPoint = autoEats.get(i);
                    int row = currentPoint.x;
                    int col = currentPoint.y;
                    myCampTotalLIst.add(chessBoardModel.getPieceAt(row, col));
                }

                List<AbstractPiece> theBestEatingLIst = new ArrayList<>();

                for (int i = 0; i <= 10000; i += 50) {
                    for (AbstractPiece currentPiece : myCampTotalLIst) {
                        if (currentPiece.getValue() == 10050 - i) {
                            theBestEatingLIst.add(currentPiece);
                        }
                    }
                    if (!theBestEatingLIst.isEmpty()) {
                        break;
                    }
                }
                if (theBestEatingLIst.size() == 1) {
                    AbstractPiece piece = theBestEatingLIst.get(0);
                    int row = piece.getRow();
                    int col = piece.getCol();
                    chooseWhich.add(new Point(row, col));
                } else {
                    Random random = new Random();
                    AbstractPiece piece = theBestEatingLIst.get(random.nextInt(theBestEatingLIst.size()));
                    int row = piece.getRow();
                    int col = piece.getCol();
                    chooseWhich.add(new Point(row, col));
                }
                }
            }
        return chooseWhich;
    }
}
