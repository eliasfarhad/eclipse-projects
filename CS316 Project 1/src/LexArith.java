/**
 * Name: S M Farhad
 * CS 316 Project 1
 * Yukawa, Keitaro

Instruction to run this program:

The .zip file has two classes in it. It is possible to run the program (using the .zip file) from the Command Prompt.
Simply type:

java –jar Farhad.zip input.txt output.txt

Farhad.zip is the name of the zipped file. input.txt is the name of the input text file which is used to test the program (your text file may
have a different name). output.txt is the file where the output will be printed (again you may give it a different name). To see the output,
simply open the output.txt file.

If the above method doesn't work, You may open the .zip file, get the source code and run the program in an IDE. In that case you should have
two text files called input.txt (as a test file) and and an empty output.txt file under the same project folder.

⟨lowercase letter⟩ → a | b | ... | z 
⟨uppercase letter⟩ → A | B | ... | Z 
⟨letter⟩ → ⟨lowercase letter⟩ | ⟨uppercase letter⟩ 
⟨digit⟩ → 0 | 1 | ... | 9 
⟨var⟩ → ⟨uppercase letter⟩ {⟨letter⟩ | ⟨digit⟩} 
⟨functor⟩ → ⟨lowercase letter⟩ {⟨letter⟩ | ⟨digit⟩} 
⟨int⟩ → [+|−] {⟨digit⟩}+ 
⟨float⟩ → [+|−] ( {⟨digit⟩}+ "." {⟨digit⟩}  |  "." {⟨digit⟩}+  ) 
⟨floatE⟩ → ⟨float⟩ (e|E) [+|−] {⟨digit⟩}+ 
⟨if⟩ → ":−" 
⟨add⟩ → + 
⟨sub⟩ → − 
⟨mul⟩ → * 
⟨div⟩ → / 
⟨lt⟩ → "<" 
⟨le⟩ → "=<" 
⟨gt⟩ → ">" 
⟨ge⟩ → ">=" 
⟨eq⟩ → "=" 
⟨neq⟩ → "\=" 
⟨LParen⟩ → "(" 
⟨RParen⟩ → ")" 
⟨LBracket⟩ → "[" 
⟨RBracket⟩ → "]" 
⟨bar⟩ → "|" 
⟨comma⟩ → "," 
⟨period⟩ → "." 

This class implements a DFA that will accept the above tokens.

The DFA states are represented by the Enum type "State".
The DFA has the following 10 final states represented by enum-type literals:

state     token accepted

Add       +
Int     
Sub       -
Mul       *
Div       /
LParen    (
RParen    )
LBracket  [
RBracket  ]
Lt        <
Gt        >
Ge        =
Eq        =
Le        <
Neq       =
Bar       |
Var       
Functor
Period    .
Float
If
FloatE
Comma     ,
Keyword_is

The DFA also uses the following 7 non-final states:

state      string recognized

Start      the empty string
Backslash  
Colon
AddSubPeriod
Is
E
EPlusMinus

The function "driver" operates the DFA. 
The function "nextState" returns the next state given the current state and the input character.

To recognize a different token set, modify the following:

  enum type "State" and function "isFinal"
  function "nextState" 

The functions "driver", "getToken" remain the same.

**/

public abstract class LexArith extends IO {
   
    public enum State { 
      // non-final states     ordinal number

       Start,             // 0
       Backslash,         // 1
       AddSubPeriod,      // 2
       Colon,             // 3
       E,                 // 4
       EPlusMinus,        // 5
       Is,                // 6

     // final states
       Add,                // 7
       Sub,                // 8
       Int,                // 9
       Mul,                // 10
       Div,                // 11
       LParen,             // 12
       RParen,             // 13
       LBracket,           // 14
       RBracket,           // 15
           
       Lt,                 // 16
       Gt,                 // 17
       Ge,                 // 18
       Eq,                 // 19
       Le,                 // 20
       Neq,                // 21
       
       Bar,              // 22
       Var,              // 23
       Functor,          // 24
       
       
       Period,           // 25
       Float,            // 26
       FloatE,           // 27
       If,               // 28
       Comma,            // 29
       Keyword_is,       // 30
       
       UNDEF;

       private boolean isFinal()
       {
           return ( this.compareTo(State.Add) >= 0 );  
       }   
    }

    // By enumerating the non-final states first and then the final states,
    // test for a final state can be done by testing if the state's ordinal number
    // is greater than or equal to that of Id.

    // The following variables of "IO" class are used:

    //   static int a; the current input character
    //   static char c; used to convert the variable "a" to the char type whenever necessary

    public static String t; // holds an extracted token
    public static State state; // the current state of the FA

    private static int driver() {

    // This is the driver of the FA. 
    // If a valid token is found, assigns it to "t" and returns 1.
    // If an invalid token is found, assigns it to "t" and returns 0.
    // If end-of-stream is reached without finding any non-whitespace character, returns -1.
 
        State nextSt; // the next state of the FA

        t = "";
        state = State.Start;

        if ( Character.isWhitespace((char) a) )
            a = getChar(); // get the next non-whitespace character
        if ( a == -1 ) // end-of-stream is reached
            return -1;

        while ( a != -1 ) // do the body if "a" is not end-of-stream
        {
            c = (char) a;
            nextSt = nextState( state, c );
            if ( nextSt == State.UNDEF ) // The FA will halt.
            {
                if ( state.isFinal() )
                    return 1; // valid token extracted
                else // "c" is an unexpected character
                {
                    t = t+c;
                    a = getNextChar();
                    return 0; // invalid token found
                }
            }
            else // The FA will go on.
            {
                state = nextSt;
                t = t+c;
                a = getNextChar();
            }
        }

        // end-of-stream is reached while a token is being extracted

        if ( state.isFinal() )
            return 1; // valid token extracted
        else
            return 0; // invalid token found
    } // end driver

    public static void getToken() {

    // Extract the next token using the driver of the FA.
    // If an invalid token is found, issue an error message.

        int i = driver();
        if ( i == 0 )
            displayln(t + " : Lexical Error, invalid token");
    }

    private static State nextState(State s, char c) {

    // Returns the next state of the FA given the current state and input char;
    // if the next state is undefined, UNDEF is returned.

        switch (state) {
        
        case Start:
            if (Character.isUpperCase(c)) 
                return State.Var;
            else if (c == 'i')
               return State.Is;
            else if (Character.isLowerCase(c)) 
               return State.Functor; 
            else if (Character.isDigit(c))
                return State.Int;
            else if (c == '+')
                return State.Add;
            else if (c == '-')
                return State.Sub;
            else if (c == '.')
               return State.Period;
            else if (c == '*')
                return State.Mul;
            else if (c == '/')
                return State.Div;
            else if (c == ',')
               return State.Comma;
            else if (c == '(')
                return State.LParen;
            else if (c == ')')
                return State.RParen;
            else if (c == ':')
               return State.Colon;
            else if (c == '|')
               return State.Bar;
            else if (c == '=')
               return State.Eq;
            else if (c == '>')
               return State.Gt;
            else if (c == '<')
               return State.Lt;
            else if (c == '[')
               return State.LBracket;
            else if (c == ']')
               return State.RBracket;
            else if (c == '\\')
               return State.Backslash;
            else
                return State.UNDEF;
            
        case Var:
           if (Character.isLetterOrDigit(c))
              return State.Var;
            else
                return State.UNDEF;
           
        case Functor:
           if (Character.isLetterOrDigit(c))
              return State.Functor;
            else
                return State.UNDEF;
           
        case Is:
           if (c == 's')
              return State.Keyword_is;
           else if (Character.isLetterOrDigit(c))
              return State.Functor;
            else
                return State.UNDEF;
           
        case Keyword_is:
           if (Character.isLetterOrDigit(c))
              return State.Functor;
           else
              return State.UNDEF;

        case Int:
            if (Character.isDigit(c) )
                return State.Int;
            else if (c == '.')
                return State.Float;
            else
                return State.UNDEF;
            
        case Period:
            if (Character.isDigit(c) )
                return State.Float;
            else
                return State.UNDEF;
            
        case Float:
            if (Character.isDigit(c) )
                return State.Float;
            else if (c == 'e' || c == 'E')
                return State.E;
            else
                return State.UNDEF;
            
        case E:
            if (Character.isDigit(c) )
                return State.FloatE;
            else if (c == '+' || c == '-')
                return State.EPlusMinus;
            else
                return State.UNDEF;
            
        case EPlusMinus:
            if (Character.isDigit(c) )
                return State.FloatE;
            else
                return State.UNDEF;
            
        case FloatE:
            if (Character.isDigit(c) )
                return State.FloatE;
            else
                return State.UNDEF;
            
        case Add:
           if (Character.isDigit(c))
              return State.Int;
           else if (c == '.')
              return State.AddSubPeriod;
           else
              return State.UNDEF;
           
        case Sub:
           if (Character.isDigit(c))
              return State.Int;
           else if (c == '.')
              return State.AddSubPeriod;
           else
              return State.UNDEF;
           
        case Gt:
           if (c == '=')
              return State.Ge;
           else 
              return State.UNDEF;
           
        case Eq:
           if (c == '<')
              return State.Le;
           else
              return State.UNDEF;
           
        case Backslash:
           if (c == '=')
              return State.Neq;
           else
              return State.UNDEF;
           
        case Colon:
           if (c == '-')
              return State.If;
           else 
              return State.UNDEF;
           
        case AddSubPeriod:
           if (Character.isDigit(c))
              return State.Float;
           else
              return State.UNDEF;
            
        default:
            return State.UNDEF;
        }
    } // end nextState

    public static void main(String argv[])

    {       
        // argv[0]: input file containing source code using tokens defined above
        // argv[1]: output file displaying a list of the tokens 

        setIO( argv[0], argv[1] );
        
        int i;

        while ( a != -1 ) // while "a" is not end-of-stream
        {
            i = driver(); // extract the next token
            if ( i == 1 )
                displayln( t + "   : " + state.toString() );
            else if ( i == 0 )
                displayln(t + " : Lexical Error, invalid token");
        } 

        closeIO();
    }
} 