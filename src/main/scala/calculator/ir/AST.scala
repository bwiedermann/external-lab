package calculator.ir

/**
 * -----------
 * Grammar
 * -----------
 * 
 *                   n ∈ 𝒵 
 * 
 *       e ∈ Expr ::= e + t | e - t | t
 *       t ∈ Term ::= t * f | t / f | f
 *       f ∈ Fact ::= n | ( e )
 *  
 */

sealed abstract class AST

sealed abstract class Expr extends AST
case class Plus(left: Expr, right: Term) extends Expr
case class Sub(left: Expr, right: Term) extends Expr

sealed abstract class Term extends Expr
case class Mult(left: Expr, right: Fact) extends Term
case class Div(left: Expr, right: Fact) extends Term

sealed abstract class Fact extends Term
case class Num(n: Int) extends Fact
case class Paren(e: Expr) extends Fact
