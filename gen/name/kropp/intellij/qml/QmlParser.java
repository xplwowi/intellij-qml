// This is a generated file. Not intended for manual editing.
package name.kropp.intellij.qml;

import com.intellij.lang.PsiBuilder;
import com.intellij.lang.PsiBuilder.Marker;
import static name.kropp.intellij.qml.psi.QmlTypes.*;
import static com.intellij.lang.parser.GeneratedParserUtilBase.*;
import com.intellij.psi.tree.IElementType;
import com.intellij.lang.ASTNode;
import com.intellij.psi.tree.TokenSet;
import com.intellij.lang.PsiParser;
import com.intellij.lang.LightPsiParser;

@SuppressWarnings({"SimplifiableIfStatement", "UnusedAssignment"})
public class QmlParser implements PsiParser, LightPsiParser {

  public ASTNode parse(IElementType t, PsiBuilder b) {
    parseLight(t, b);
    return b.getTreeBuilt();
  }

  public void parseLight(IElementType t, PsiBuilder b) {
    boolean r;
    b = adapt_builder_(t, b, this, null);
    Marker m = enter_section_(b, 0, _COLLAPSE_, null);
    r = parse_root_(t, b);
    exit_section_(b, 0, m, t, r, true, TRUE_CONDITION);
  }

  protected boolean parse_root_(IElementType t, PsiBuilder b) {
    return parse_root_(t, b, 0);
  }

  static boolean parse_root_(IElementType t, PsiBuilder b, int l) {
    return qml(b, l + 1);
  }

  /* ********************************************************** */
  // string|boolean|number|identifier|value
  public static boolean argument(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "argument")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, ARGUMENT, "<argument>");
    r = consumeToken(b, STRING);
    if (!r) r = boolean_$(b, l + 1);
    if (!r) r = number(b, l + 1);
    if (!r) r = consumeToken(b, IDENTIFIER);
    if (!r) r = consumeToken(b, VALUE);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // identifier
  public static boolean attribute(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "attribute")) return false;
    if (!nextTokenIs(b, IDENTIFIER)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, IDENTIFIER);
    exit_section_(b, m, ATTRIBUTE, r);
    return r;
  }

  /* ********************************************************** */
  // (attribute ':')? attribute_value ';'?
  public static boolean attribute_assignment(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "attribute_assignment")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, ATTRIBUTE_ASSIGNMENT, "<attribute assignment>");
    r = attribute_assignment_0(b, l + 1);
    r = r && attribute_value(b, l + 1);
    r = r && attribute_assignment_2(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // (attribute ':')?
  private static boolean attribute_assignment_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "attribute_assignment_0")) return false;
    attribute_assignment_0_0(b, l + 1);
    return true;
  }

  // attribute ':'
  private static boolean attribute_assignment_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "attribute_assignment_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = attribute(b, l + 1);
    r = r && consumeToken(b, COLON);
    exit_section_(b, m, null, r);
    return r;
  }

  // ';'?
  private static boolean attribute_assignment_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "attribute_assignment_2")) return false;
    consumeToken(b, SEMICOLON);
    return true;
  }

  /* ********************************************************** */
  // method_call|method_body|item|value+
  static boolean attribute_value(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "attribute_value")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = method_call(b, l + 1);
    if (!r) r = method_body(b, l + 1);
    if (!r) r = item(b, l + 1);
    if (!r) r = attribute_value_3(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // value+
  private static boolean attribute_value_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "attribute_value_3")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, VALUE);
    while (r) {
      int c = current_position_(b);
      if (!consumeToken(b, VALUE)) break;
      if (!empty_element_parsed_guard_(b, "attribute_value_3", c)) break;
    }
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  public static boolean block_comment(PsiBuilder b, int l) {
    Marker m = enter_section_(b);
    exit_section_(b, m, BLOCK_COMMENT, true);
    return true;
  }

  /* ********************************************************** */
  // '{' (property_definition|signal_definition|attribute_assignment|method_attribute)* '}'
  public static boolean body(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "body")) return false;
    if (!nextTokenIs(b, LBRACE)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, LBRACE);
    r = r && body_1(b, l + 1);
    r = r && consumeToken(b, RBRACE);
    exit_section_(b, m, BODY, r);
    return r;
  }

  // (property_definition|signal_definition|attribute_assignment|method_attribute)*
  private static boolean body_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "body_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!body_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "body_1", c)) break;
    }
    return true;
  }

  // property_definition|signal_definition|attribute_assignment|method_attribute
  private static boolean body_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "body_1_0")) return false;
    boolean r;
    r = property_definition(b, l + 1);
    if (!r) r = signal_definition(b, l + 1);
    if (!r) r = attribute_assignment(b, l + 1);
    if (!r) r = method_attribute(b, l + 1);
    return r;
  }

  /* ********************************************************** */
  // 'true'|'false'
  static boolean boolean_$(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "boolean_$")) return false;
    if (!nextTokenIs(b, "", FALSE, TRUE)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, TRUE);
    if (!r) r = consumeToken(b, FALSE);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // string
  public static boolean filename(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "filename")) return false;
    if (!nextTokenIs(b, STRING)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, STRING);
    exit_section_(b, m, FILENAME, r);
    return r;
  }

  /* ********************************************************** */
  // 'import' (module version? | filename) ('as' qualifier)?
  public static boolean import_$(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "import_$")) return false;
    if (!nextTokenIs(b, KEYWORD_IMPORT)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, KEYWORD_IMPORT);
    r = r && import_1(b, l + 1);
    r = r && import_2(b, l + 1);
    exit_section_(b, m, IMPORT, r);
    return r;
  }

  // module version? | filename
  private static boolean import_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "import_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = import_1_0(b, l + 1);
    if (!r) r = filename(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // module version?
  private static boolean import_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "import_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = module(b, l + 1);
    r = r && import_1_0_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // version?
  private static boolean import_1_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "import_1_0_1")) return false;
    version(b, l + 1);
    return true;
  }

  // ('as' qualifier)?
  private static boolean import_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "import_2")) return false;
    import_2_0(b, l + 1);
    return true;
  }

  // 'as' qualifier
  private static boolean import_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "import_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, KEYWORD_AS);
    r = r && qualifier(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // import*
  public static boolean imports(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "imports")) return false;
    Marker m = enter_section_(b, l, _NONE_, IMPORTS, "<imports>");
    while (true) {
      int c = current_position_(b);
      if (!import_$(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "imports", c)) break;
    }
    exit_section_(b, l, m, true, false, null);
    return true;
  }

  /* ********************************************************** */
  // list|object|string|boolean|number|identifier|value
  static boolean item(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "item")) return false;
    boolean r;
    r = list(b, l + 1);
    if (!r) r = object(b, l + 1);
    if (!r) r = consumeToken(b, STRING);
    if (!r) r = boolean_$(b, l + 1);
    if (!r) r = number(b, l + 1);
    if (!r) r = consumeToken(b, IDENTIFIER);
    if (!r) r = consumeToken(b, VALUE);
    return r;
  }

  /* ********************************************************** */
  // ('{' javascript '}'|'var'|'['|']'|'('|')'|','|':'|';'|'?'|'|'|string|identifier|number|value|boolean)*
  public static boolean javascript(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "javascript")) return false;
    Marker m = enter_section_(b, l, _COLLAPSE_, JAVASCRIPT, "<javascript>");
    while (true) {
      int c = current_position_(b);
      if (!javascript_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "javascript", c)) break;
    }
    exit_section_(b, l, m, true, false, null);
    return true;
  }

  // '{' javascript '}'|'var'|'['|']'|'('|')'|','|':'|';'|'?'|'|'|string|identifier|number|value|boolean
  private static boolean javascript_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "javascript_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = javascript_0_0(b, l + 1);
    if (!r) r = consumeToken(b, KEYWORD_VAR);
    if (!r) r = consumeToken(b, LBRACKET);
    if (!r) r = consumeToken(b, RBRACKET);
    if (!r) r = consumeToken(b, LPAREN);
    if (!r) r = consumeToken(b, RPAREN);
    if (!r) r = consumeToken(b, COMMA);
    if (!r) r = consumeToken(b, COLON);
    if (!r) r = consumeToken(b, SEMICOLON);
    if (!r) r = consumeToken(b, QMARK);
    if (!r) r = consumeToken(b, PIPE);
    if (!r) r = consumeToken(b, STRING);
    if (!r) r = consumeToken(b, IDENTIFIER);
    if (!r) r = number(b, l + 1);
    if (!r) r = consumeToken(b, VALUE);
    if (!r) r = boolean_$(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // '{' javascript '}'
  private static boolean javascript_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "javascript_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, LBRACE);
    r = r && javascript(b, l + 1);
    r = r && consumeToken(b, RBRACE);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  public static boolean line_comment(PsiBuilder b, int l) {
    Marker m = enter_section_(b);
    exit_section_(b, m, LINE_COMMENT, true);
    return true;
  }

  /* ********************************************************** */
  // '[' item? (',' item)* ']'
  public static boolean list(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "list")) return false;
    if (!nextTokenIs(b, LBRACKET)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, LBRACKET);
    r = r && list_1(b, l + 1);
    r = r && list_2(b, l + 1);
    r = r && consumeToken(b, RBRACKET);
    exit_section_(b, m, LIST, r);
    return r;
  }

  // item?
  private static boolean list_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "list_1")) return false;
    item(b, l + 1);
    return true;
  }

  // (',' item)*
  private static boolean list_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "list_2")) return false;
    while (true) {
      int c = current_position_(b);
      if (!list_2_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "list_2", c)) break;
    }
    return true;
  }

  // ',' item
  private static boolean list_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "list_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COMMA);
    r = r && item(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // identifier
  public static boolean method(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "method")) return false;
    if (!nextTokenIs(b, IDENTIFIER)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, IDENTIFIER);
    exit_section_(b, m, METHOD, r);
    return r;
  }

  /* ********************************************************** */
  // 'function' method '(' (parameter ',')* parameter? ')' method_body
  public static boolean method_attribute(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "method_attribute")) return false;
    if (!nextTokenIs(b, KEYWORD_FUNCTION)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, KEYWORD_FUNCTION);
    r = r && method(b, l + 1);
    r = r && consumeToken(b, LPAREN);
    r = r && method_attribute_3(b, l + 1);
    r = r && method_attribute_4(b, l + 1);
    r = r && consumeToken(b, RPAREN);
    r = r && method_body(b, l + 1);
    exit_section_(b, m, METHOD_ATTRIBUTE, r);
    return r;
  }

  // (parameter ',')*
  private static boolean method_attribute_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "method_attribute_3")) return false;
    while (true) {
      int c = current_position_(b);
      if (!method_attribute_3_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "method_attribute_3", c)) break;
    }
    return true;
  }

  // parameter ','
  private static boolean method_attribute_3_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "method_attribute_3_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = parameter(b, l + 1);
    r = r && consumeToken(b, COMMA);
    exit_section_(b, m, null, r);
    return r;
  }

  // parameter?
  private static boolean method_attribute_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "method_attribute_4")) return false;
    parameter(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // '{' javascript '}'
  public static boolean method_body(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "method_body")) return false;
    if (!nextTokenIs(b, LBRACE)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, LBRACE);
    r = r && javascript(b, l + 1);
    r = r && consumeToken(b, RBRACE);
    exit_section_(b, m, METHOD_BODY, r);
    return r;
  }

  /* ********************************************************** */
  // method '(' (argument ',')* argument? ')'
  public static boolean method_call(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "method_call")) return false;
    if (!nextTokenIs(b, IDENTIFIER)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = method(b, l + 1);
    r = r && consumeToken(b, LPAREN);
    r = r && method_call_2(b, l + 1);
    r = r && method_call_3(b, l + 1);
    r = r && consumeToken(b, RPAREN);
    exit_section_(b, m, METHOD_CALL, r);
    return r;
  }

  // (argument ',')*
  private static boolean method_call_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "method_call_2")) return false;
    while (true) {
      int c = current_position_(b);
      if (!method_call_2_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "method_call_2", c)) break;
    }
    return true;
  }

  // argument ','
  private static boolean method_call_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "method_call_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = argument(b, l + 1);
    r = r && consumeToken(b, COMMA);
    exit_section_(b, m, null, r);
    return r;
  }

  // argument?
  private static boolean method_call_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "method_call_3")) return false;
    argument(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // identifier
  public static boolean module(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "module")) return false;
    if (!nextTokenIs(b, IDENTIFIER)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, IDENTIFIER);
    exit_section_(b, m, MODULE, r);
    return r;
  }

  /* ********************************************************** */
  // integer|float
  static boolean number(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "number")) return false;
    if (!nextTokenIs(b, "", FLOAT, INTEGER)) return false;
    boolean r;
    r = consumeToken(b, INTEGER);
    if (!r) r = consumeToken(b, FLOAT);
    return r;
  }

  /* ********************************************************** */
  // type body
  public static boolean object(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "object")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, OBJECT, "<object>");
    r = type(b, l + 1);
    r = r && body(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // identifier
  public static boolean parameter(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "parameter")) return false;
    if (!nextTokenIs(b, IDENTIFIER)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, IDENTIFIER);
    exit_section_(b, m, PARAMETER, r);
    return r;
  }

  /* ********************************************************** */
  // 'pragma' 'Singleton'
  public static boolean pragma(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "pragma")) return false;
    if (!nextTokenIs(b, KEYWORD_PRAGMA)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, KEYWORD_PRAGMA, KEYWORD_SINGLETON);
    exit_section_(b, m, PRAGMA, r);
    return r;
  }

  /* ********************************************************** */
  // identifier
  public static boolean property(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "property")) return false;
    if (!nextTokenIs(b, IDENTIFIER)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, IDENTIFIER);
    exit_section_(b, m, PROPERTY, r);
    return r;
  }

  /* ********************************************************** */
  // 'default'? 'readonly'? 'property' ('alias'|'var'|type) property (':' attribute_value)?
  public static boolean property_definition(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "property_definition")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, PROPERTY_DEFINITION, "<property definition>");
    r = property_definition_0(b, l + 1);
    r = r && property_definition_1(b, l + 1);
    r = r && consumeToken(b, KEYWORD_PROPERTY);
    r = r && property_definition_3(b, l + 1);
    r = r && property(b, l + 1);
    r = r && property_definition_5(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // 'default'?
  private static boolean property_definition_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "property_definition_0")) return false;
    consumeToken(b, KEYWORD_DEFAULT);
    return true;
  }

  // 'readonly'?
  private static boolean property_definition_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "property_definition_1")) return false;
    consumeToken(b, KEYWORD_READONLY);
    return true;
  }

  // 'alias'|'var'|type
  private static boolean property_definition_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "property_definition_3")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, KEYWORD_ALIAS);
    if (!r) r = consumeToken(b, KEYWORD_VAR);
    if (!r) r = type(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (':' attribute_value)?
  private static boolean property_definition_5(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "property_definition_5")) return false;
    property_definition_5_0(b, l + 1);
    return true;
  }

  // ':' attribute_value
  private static boolean property_definition_5_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "property_definition_5_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COLON);
    r = r && attribute_value(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // pragma? imports object
  static boolean qml(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "qml")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = qml_0(b, l + 1);
    r = r && imports(b, l + 1);
    r = r && object(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // pragma?
  private static boolean qml_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "qml_0")) return false;
    pragma(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // identifier
  public static boolean qualifier(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "qualifier")) return false;
    if (!nextTokenIs(b, IDENTIFIER)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, IDENTIFIER);
    exit_section_(b, m, QUALIFIER, r);
    return r;
  }

  /* ********************************************************** */
  // identifier
  public static boolean signal(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "signal")) return false;
    if (!nextTokenIs(b, IDENTIFIER)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, IDENTIFIER);
    exit_section_(b, m, SIGNAL, r);
    return r;
  }

  /* ********************************************************** */
  // 'signal' signal ('(' (signal_parameter ',')* signal_parameter? ')')?
  public static boolean signal_definition(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "signal_definition")) return false;
    if (!nextTokenIs(b, KEYWORD_SIGNAL)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, KEYWORD_SIGNAL);
    r = r && signal(b, l + 1);
    r = r && signal_definition_2(b, l + 1);
    exit_section_(b, m, SIGNAL_DEFINITION, r);
    return r;
  }

  // ('(' (signal_parameter ',')* signal_parameter? ')')?
  private static boolean signal_definition_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "signal_definition_2")) return false;
    signal_definition_2_0(b, l + 1);
    return true;
  }

  // '(' (signal_parameter ',')* signal_parameter? ')'
  private static boolean signal_definition_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "signal_definition_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, LPAREN);
    r = r && signal_definition_2_0_1(b, l + 1);
    r = r && signal_definition_2_0_2(b, l + 1);
    r = r && consumeToken(b, RPAREN);
    exit_section_(b, m, null, r);
    return r;
  }

  // (signal_parameter ',')*
  private static boolean signal_definition_2_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "signal_definition_2_0_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!signal_definition_2_0_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "signal_definition_2_0_1", c)) break;
    }
    return true;
  }

  // signal_parameter ','
  private static boolean signal_definition_2_0_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "signal_definition_2_0_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = signal_parameter(b, l + 1);
    r = r && consumeToken(b, COMMA);
    exit_section_(b, m, null, r);
    return r;
  }

  // signal_parameter?
  private static boolean signal_definition_2_0_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "signal_definition_2_0_2")) return false;
    signal_parameter(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // ('var'|type) parameter
  public static boolean signal_parameter(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "signal_parameter")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, SIGNAL_PARAMETER, "<signal parameter>");
    r = signal_parameter_0(b, l + 1);
    r = r && parameter(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // 'var'|type
  private static boolean signal_parameter_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "signal_parameter_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, KEYWORD_VAR);
    if (!r) r = type(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // 'double'|'real'|identifier
  public static boolean type(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "type")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, TYPE, "<type>");
    r = consumeToken(b, KEYWORD_DOUBLE);
    if (!r) r = consumeToken(b, KEYWORD_REAL);
    if (!r) r = consumeToken(b, IDENTIFIER);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // float
  public static boolean version(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "version")) return false;
    if (!nextTokenIs(b, FLOAT)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, FLOAT);
    exit_section_(b, m, VERSION, r);
    return r;
  }

}
