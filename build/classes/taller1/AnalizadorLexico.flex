/* Sección de declaraciones de JFlex */
%%
%public
%class AnalizadorLexico
%{
 
 /* Código personalizado */
 
 // Se agregó una propiedad para verificar si existen tokens pendientes
 private boolean _existenTokens = false;
 
 public boolean existenTokens(){
 return this._existenTokens;
 }
 
%}
 
 /* Al utilizar esta instrucción, se le indica a JFlex que devuelva objetos del tipo TokenPersonalizado */
%type TokenPersonalizado
 
%init{
 /* Código que se ejecutará en el constructor de la clase */
%init}
 
%eof{
 
 /* Código a ejecutar al finalizar el análisis, en este caso cambiaremos el valor de una variable bandera */
 this._existenTokens = false;
 
%eof}
 
/* Inicio de Expresiones regulares */
 
 Letra = [A-Za-z]
 Digito5 = [0-5]
 Digito6 = [6-9]

 SaltoDeLinea = \n|\r|\r\n
 
 Cedula2 = {Digito5} | {Digito6}
 Cedula = {Cedula2}{Cedula2}{Cedula2}{Cedula2}{Cedula2}+
 
 Punto = "."
 Espacio = " "

 Alfanumerico2 = {Letra} | {Digito5} | {Digito6}
 Alfanumerico = {Letra} {Alfanumerico2}*

 Dominio2 = "com"|"net"|"edu"|"co"
 Dominio3 = {Punto} {Dominio2}
 Dominio = {Dominio3}+ 

 Correo = {Alfanumerico} {Arroba} {Alfanumerico} {Dominio}



Arroba = "@"

 Palabra = {Letra} {Letra}*

 Nota = {Digito5} {Punto} {Digito5} | {Digito5} {Punto} {Digito6}

 NombreCompuesto = {Palabra} {Espacio} {Palabra} | {Palabra}

 

 
 
 
/* Finaliza expresiones regulares */
 
%%
/* Finaliza la sección de declaraciones de JFlex */
 
/* Inicia sección de reglas */
 
// Cada regla está formada por una {expresión} espacio {código}
 
{Letra} {
 TokenPersonalizado t = new TokenPersonalizado(yytext(), "Letra");
 this._existenTokens = true;
 return t;
}

{Arroba} {
 TokenPersonalizado t = new TokenPersonalizado(yytext(), "Arroba");
 this._existenTokens = true;
 return t;
}

{Punto} {
 TokenPersonalizado t = new TokenPersonalizado(yytext(), "Punto");
 this._existenTokens = true;
 return t;
}

{Palabra} {
 TokenPersonalizado t = new TokenPersonalizado(yytext(), "Palabra");
 this._existenTokens = true;
 return t;
}

{Nota} {
 TokenPersonalizado t = new TokenPersonalizado(yytext(), "Nota");
 this._existenTokens = true;
 return t;
}

{NombreCompuesto} {
 TokenPersonalizado t = new TokenPersonalizado(yytext(), "NombreCompuesto");
 this._existenTokens = true;
 return t;
}

{Espacio} {
 TokenPersonalizado t = new TokenPersonalizado(yytext(), "Espacio");
 this._existenTokens = true;
 return t;
}

{Digito6} {
 TokenPersonalizado t = new TokenPersonalizado(yytext(), "Digito6");
 this._existenTokens = true;
 return t;
}


{Digito5} {
 TokenPersonalizado t = new TokenPersonalizado(yytext(), "Digito5");
 this._existenTokens = true;
 return t;
}



{Dominio} {
 TokenPersonalizado t = new TokenPersonalizado(yytext(), "Dominio");
 this._existenTokens = true;
 return t;
}


{Cedula} {
 TokenPersonalizado t = new TokenPersonalizado(yytext(), "Cedula");
 this._existenTokens = true;
 return t;
}


{Correo} {
 TokenPersonalizado t = new TokenPersonalizado(yytext(), "Correo");
 this._existenTokens = true;
 return t;
}

{SaltoDeLinea} {
 TokenPersonalizado t = new TokenPersonalizado("Enter", "NUEVA_LINEA");
 this._existenTokens = true;
 return t;
}



/*
{Numero} {
 TokenPersonalizado t = new TokenPersonalizado(yytext(), "NUMERO");
 this._existenTokens = true;
 return t;
}
 
{Palabra} {
 TokenPersonalizado t = new TokenPersonalizado(yytext(), "PALABRA");
 this._existenTokens = true;
 return t;
}
 
{Simbolo} {
 TokenPersonalizado t = new TokenPersonalizado(yytext(), "SIMBOLO");
 this._existenTokens = true;
 return t;
}
 
{Espacio} {
 // Ignorar cuando se ingrese un espacio
}
 
{SaltoDeLinea} {
 TokenPersonalizado t = new TokenPersonalizado("Enter", "NUEVA_LINEA");
 this._existenTokens = true;
 return t;
}
*/