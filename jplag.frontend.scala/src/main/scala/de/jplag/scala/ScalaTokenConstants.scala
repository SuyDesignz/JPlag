package de.jplag.scala

import de.jplag.TokenConstants

/**
 * This Java-compatible enumeration stores the possible types of tokens.
 */
object ScalaTokenConstants extends Enumeration with TokenConstants {

  val FileEnd: Value = Value(TokenConstants.FILE_END, "<EOF>")
  val SeparatorToken: Value = Value(TokenConstants.SEPARATOR_TOKEN, "--------")
  val Package: Value = Value("PACKAGE")
  val Import: Value = Value("IMPORT")
  val ClassBegin: Value = Value("CLASS{")
  val ClassEnd: Value = Value("}CLASS")
  val MethodDef: Value = Value("METHOD")
  val MethodBegin: Value = Value("METHOD{")
  val MethodEnd: Value = Value("}METHOD")
  val VariableDefinition: Value = Value("VAR_DEF")
  val DoWhile: Value = Value("DO-WHILE")
  val DoWhileEnd: Value = Value("END-DO-WHILE")
  val DoBodyBegin: Value = Value("DO{")
  val DoBodyEnd: Value = Value("}DO")
  val While: Value = Value("WHILE")
  val WhileBodyBegin: Value = Value("WHILE{")
  val WhileBodyEnd: Value = Value("}WHILE")
  val For: Value = Value("FOR")
  val ForBodyBegin: Value = Value("FOR{")
  val ForBodyEnd: Value = Value("}FOR")
  val CaseStatement: Value = Value("CASE")
  val CaseBegin: Value = Value("CASE{")
  val CaseEnd: Value = Value("}CASE")
  val TryBegin: Value = Value("TRY{")
  val CatchBegin: Value = Value("CATCH{")
  val CatchEnd: Value = Value("}CATCH")
  val Finally: Value = Value("FINALLY")
  val If: Value = Value("IF")
  val IfBegin: Value = Value("IF{")
  val IfEnd: Value = Value("}IF")
  val Else: Value = Value("ELSE")
  val ElseBegin: Value = Value("ELSE{")
  val ElseEnd: Value = Value("}ELSE")
  val Return: Value = Value("RETURN")
  val Throw: Value = Value("THROW")
  val NewCreationBegin: Value = Value("NEW{")
  val NewCreationEnd: Value = Value("}NEW")
  val Apply: Value = Value("APPLY")
  val Assign: Value = Value("ASSIGN")
  val TraitBegin: Value = Value("TRAIT{")
  val TraitEnd: Value = Value("}TRAIT")
  val ConstructorBegin: Value = Value("CONSTR{")
  val ConstructorEnd: Value = Value("}CONSTR")
  val MatchBegin: Value = Value("MATCH{")
  val MatchEnd: Value = Value("}MATCH")
  val Guard: Value = Value("GUARD")
  val ObjectBegin: Value = Value("OBJECT{")
  val ObjectEnd: Value = Value("}OBJECT")
  val Macro: Value = Value("MACRO")
  val MacroBegin: Value = Value("MACRO{")
  val MacroEnd: Value = Value("}MACRO")
  val Type: Value = Value("TYPE")

  val FunctionBegin: Value = Value("FUNC{")
  val FunctionEnd: Value = Value("}FUNC")
  val PartialFunctionBegin: Value = Value("PFUNC{")
  val PartialFunctionEnd: Value = Value("}PFUNC")

  val Yield: Value = Value("YIELD")

  val Parameter: Value = Value("PARAM")
  val Argument: Value = Value("ARG")
  val NewObject: Value = Value("NEW()")
  val SelfType: Value = Value("SELF")
  val TypeParameter: Value = Value("T_PARAM")
  val TypeArgument: Value = Value("T_ARG")
  val BlockStart: Value = Value("{")
  val BlockEnd: Value = Value("}")
  val EnumGenerator: Value = Value("ENUMERATE")
  val Member: Value = Value("MEMBER")

  def numberOfTokens() : Int = maxId
}

