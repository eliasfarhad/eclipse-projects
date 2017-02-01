public abstract class Parser extends LexAnalyzer {
    
   static boolean errorSignal = false;
     
    public static Clauses clauses() {
    //⟨clauses⟩ → ⟨clause⟩ | ⟨clause⟩ ⟨clauses⟩ 
       
        Clause clause = clause();
        
        if (state == State.Functor) {
            Clauses clauses =clauses();
            return new MultipleClauses(clause, clauses);
        }
        else
            return clause;
    }
    
    public static Clause clause()
    //⟨clause⟩ → ⟨head⟩ [ ":−" ⟨atomic formulas⟩ ] "." 
    {
        Head head = head();
        if(state == State.If) {
            getToken();
            AtomicFormulas atFormula = atomicformulas();
            
            if(state == State.Period) { 
               getToken();
               return new Clause(head, atFormula);
            }
            else
               errorMsg(4);
        }     
        return null;
    }
    
    public static Head head()
    //⟨head⟩ → ⟨functor⟩ [ "(" ⟨terms⟩ ")" ] 
    
    {
        if(state == State.Functor )
        {
            String functor = t;
            getToken();
            
            if(state == State.LParen)
            {
                getToken();
                Terms term = terms();
                if(state == State.RParen)
                {
                    getToken();
                    return new Head(functor, term);
                }
                else errorMsg(1);
                
            }
        }
        else errorMsg(11);
        
        return null;
    }
    
    public static AtomicFormulas atomicformulas()
    
    //⟨atomic formulas⟩ → ⟨atomic formula⟩ | ⟨atomic formula⟩ "," ⟨atomic formulas⟩ 
    {
        
        AtomicFormula atFormula = atomicformula();
        Single_AtomicFormula sinAtFormula = new Single_AtomicFormula(atFormula);
        if(state == State.Comma)
        {
            getToken();
            AtomicFormulas atFormulas = atomicformulas();
            return new MultipleAtomic(sinAtFormula, atFormulas);
        }
        else return sinAtFormula;
    }
    
    public static AtomicFormula atomicformula()
    //⟨atomic formula⟩ → ⟨functor⟩ [ "(" ⟨terms⟩ ")" ] | ⟨built-in relation⟩
    {
        if(state == State.Functor)
        {
            String st = t;
            getToken();
            if(state == State.LParen)
            {
                getToken();
                Terms t = terms();
                if(state == State.RParen)
                {   getToken();
                    return new AtomicFunctor(st, t);
                }
                else errorMsg(1);
            }
            return new AtomicFunctor(st);
        }
        else 
        {   getToken();
            Built_In_Relation built_in_relation = built_in_relation();
            return built_in_relation;
        }
    }
    
    public static Term term()
    //⟨term⟩ → ⟨var or number⟩ | ⟨functor or list term⟩ 
    {
        if(state ==State.Var || state == State.Int || state == State.Float || state == State.FloatE)
        {   getToken();
            Var_Or_Number varOrNum = var_or_number();
            return varOrNum;
        }
        else{
            getToken();
            Functor_Or_List_Term funOrList = functor_or_list_term();
            return funOrList;
        }
        
    }
    
    public static Terms terms()
    //⟨terms⟩ → ⟨term⟩ | ⟨term⟩ "," ⟨terms⟩ 
    {
        
        Term tr =term();
        if(state == State.Comma)
        {
            getToken();
            Terms tms = terms();
            return new MultipleTerm(tr, tms);
        }
        
        else return tr;
        
        
    }

    
    public static Number_p number_p()
    //⟨number⟩ → ⟨int⟩ | ⟨float⟩ | ⟨floatE⟩ 
    {
        if(state == State.Int)
        {
            Integer num = new Integer(Integer.parseInt(t));
            getToken();
            return new Int(num);
        }
        else if(state == State.Float)
        {
            float fNum =Float.parseFloat(t);
            getToken();
            return new floatP(fNum);
        }
        return null;

    }
    
    public static Var_Or_Number var_or_number()
    //⟨var or number⟩ → ⟨var⟩ | ⟨number⟩ 
    {
        if(state == State.Var)
        {
            String st = t;
            getToken();
            return new Var(st);
        }
        else 
        {   Number_p numP = number_p(); 
            return numP;
         }
    }
    
    
    
    
    public static Functor_Or_List_Term functor_or_list_term()
    //⟨functor or list term⟩ → ⟨functor⟩ [ "(" ⟨terms⟩ ")" ] | ⟨list⟩ 
    {
        if(state == State.Functor)
        {
            String st = t;
            getToken();
            
            if(state == State.LParen)
            {   getToken();
                Terms tms = terms();
                if(state==State.RParen)
                {
                    getToken();
                    return new ListFunctor(st, tms);
                }
                else errorMsg(1);
            }
            return new ListFunctor(st);
        }
        else {
            
            getToken();
            List list = list();
            return list;
            
        }
    }
    
    public static List list()
    //⟨list⟩ → "[" [ ⟨terms⟩ ] "]"  |  "[" ⟨term⟩ "|" ( ⟨var⟩ | ⟨list⟩ ) "]" 
    {
        getToken();
            switch (state)
            {
            
            case Var:
                getToken();
                Term tm1 = term();
                if(state == State.Bar)
                {   getToken();
                    if(state ==State.Var)
                    {   String v1 = t;
                        getToken();
                      if(state== State.RBracket)
                      {
                          getToken();
                          return new ListTermVar(tm1, v1);
                      }
                      else errorMsg(7);
                    }
                    else{
                        List list = list();
                          if(state== State.RBracket)
                          {
                              getToken();
                              return new ListTermVar(tm1, list);
                          }
                          else errorMsg(7);
                    }
                }
                else{
                    if(state== State.RBracket)
                      {
                          getToken();
                          return new ListTerms(tm1);
                      }
                      else errorMsg(7);
                    
                }
            
            case Functor:   
                getToken();
                Term tm2 = term();
                if(state == State.Bar)
                {   getToken();
                    if(state ==State.Var)
                    {   String v1 = t;
                        getToken();
                      if(state== State.RBracket)
                      {
                          getToken();
                          return new ListTermVar(tm2, v1);
                      }
                      else errorMsg(7);
                    }
                    else{
                        List list = list();
                          if(state== State.RBracket)
                          {
                              getToken();
                              return new ListTermVar(tm2, list);
                          }
                          else errorMsg(7);
                    }
                }
                else{
                    if(state== State.RBracket)
                      {
                          getToken();
                          return new ListTerms(tm2);
                      }
                      else errorMsg(7);
                    
                }
                
            case Int:
                getToken();
                Term tm3 = term();
                if(state == State.Bar)
                {   getToken();
                    if(state ==State.Var)
                    {   String v1 = t;
                        getToken();
                      if(state== State.RBracket)
                      {
                          getToken();
                          return new ListTermVar(tm3, v1);
                      }
                      else errorMsg(7);
                    }
                    else{
                        List list = list();
                          if(state== State.RBracket)
                          {
                              getToken();
                              return new ListTermVar(tm3, list);
                          }
                          else errorMsg(7);
                    }
                }
                else{
                    if(state== State.RBracket)
                      {
                          getToken();
                          return new ListTerms(tm3);
                      }
                      else errorMsg(7);
                    
                }
                
            case Float: case FloatE:
                getToken();
                Term tm4 = term();
                if(state == State.Bar)
                {   getToken();
                    if(state ==State.Var)
                    {   String v1 = t;
                        getToken();
                      if(state== State.RBracket)
                      {
                          getToken();
                          return new ListTermVar(tm4, v1);
                      }
                      else errorMsg(7);
                    }
                    else{
                        List list = list();
                          if(state== State.RBracket)
                          {
                              getToken();
                              return new ListTermVar(tm4, list);
                          }
                          else errorMsg(7);
                    }
                }
                else{
                    if(state== State.RBracket)
                      {
                          getToken();
                          return new ListTerms(tm4);
                      }
                      else errorMsg(7);
                    
                }
            default:    
            
                if(state == State.RBracket)
                {
                    getToken();
                    return new ListTerms();
                }
                else errorMsg(7);   
             return null;
            }
            
        }
        
public static Built_In_Relation built_in_relation() 
{
    if(state == State.Var)
    {
        String v = t;
        getToken();
        
        if(state == State.Keyword_is)
        {
            getToken();
            Arith_Exp ae = arith_exp();
            return new Var1(v, ae);
        }
        else errorMsg(12);
        
        if(state == State.Lt || (state == State.Le) ||(state ==State.Gt) || (state==State.Ge))
        {
            getToken();
            Comp_Op_1 com1 =comp1();
            Var_Or_Number von =var_or_number();
            return new Var2(v, com1, von);
        }
        else errorMsg(14);
    
        if(state==State.Eq || state==State.Neq)
        {
               getToken();
               Comp_Op_2 com2 = comp2();
               Term tm = term();
               return new Var3(v, com2, tm);
        }
        else errorMsg(2);

    }
    else if(state ==State.Int || state ==State.Float || state ==State.FloatE)
    {
        getToken();
        Number_p nm = number_p();
        if(state == State.Lt || (state == State.Le) ||(state ==State.Gt) || (state==State.Ge))
        {
            getToken();
            Comp_Op_1 com1 =comp1();
            Var_Or_Number von =var_or_number();
            return new Number1(nm, com1, von);
        }
        else errorMsg(14);
    
        if(state==State.Eq || state==State.Neq)
        {
               getToken();
               Comp_Op_2 com2 = comp2();
               Term tm = term();
               return new Number2(nm, com2, tm);
        }
        else errorMsg(2);
    }
    
    else{
        Functor_Or_List_Term folt =functor_or_list_term();
        Comp_Op_2 com2 = comp2();
        Term tm = term();
        return new FunctorRelation(folt, com2, tm);
        
    }
    return null;
}
public static Arith_Exp arith_exp()

//⟨arith exp⟩ → ⟨var or number⟩ ⟨arith op⟩ ⟨var or number⟩ 
{
    if(state==State.Var ||state ==State.Int || state ==State.Float || state ==State.FloatE)
    {
        getToken();
        Var_Or_Number von = var_or_number();
        if(state==State.Add ||state==State.Sub ||state==State.Mul||state==State.Div)
        {
              getToken();
              Arith_Op ao = arith_op();
                if(state==State.Var ||state ==State.Int || state ==State.Float || state ==State.FloatE)
                {
                    getToken();
                    Var_Or_Number von1 = var_or_number();
                    return new Arith_Exp(von, ao, von1);
                }
                else errorMsg(15);
        }
        else errorMsg(13);
        
    }
    else errorMsg(15);
    return null;
}

public static Arith_Op arith_op()
{
   switch (t)
   {
   case "+":
       String add =t;
       getToken();
       return new Add(add);
       
   case "-":
       String sub =t;
       getToken();
       return new Minus(sub);
       
   case "*":
       String times =t;
       getToken();
       return new Times(times);
    
   case "/":
       String div = t;
       getToken();
       return new Divide(div);
    
   default:
       errorMsg(13);
       return null;
   }
    
}

public static Comp_Op_1 comp1()
{
   switch (state)
   {
   case Lt:
       String lt = t;
       getToken();
       return new Less(lt);
   case Le:
       String le = t;
       getToken();
       return new LessEqual(le);
   case Gt:
       String gt =t;
       getToken();
       return new Greater(gt);
   case Ge:
       String ge = t;
       getToken();
       return new GreaterEqual(ge);
   default:
       errorMsg(14);
       return null;
    
   }
    
}

public static Comp_Op_2 comp2() {
   
    if(state == State.Eq){
        String eq = t;
        getToken();
        return new Equal(eq);
    }
    else {
        String nq = t;
        getToken();
        return new NotEqual(nq);
    }   
}

    public static void errorMsg(int i) {
       errorSignal = true;
        
        display(t + " : Syntax Error, unexpected symbol where");

        switch (i) {
        
           case 1: displayln(" arith op or ) expected"); return;
           case 2: displayln(" = or \\= expected"); return;
           case 3: displayln(" :- expected"); return;
           case 4: displayln(" . expected"); return;
           case 5: displayln(" id expected"); return;
           case 6: displayln(" , expected"); return;
           case 7: displayln(" ] expected"); return;
           case 8: displayln(" | expected"); return;        
           case 9: displayln(" var expected"); return;
           case 10: displayln(" int, float, floatE expected"); return;
           case 11: displayln(" functor expected"); return;
           case 12: displayln(" is expected"); return;
           case 13: displayln(" +. -. *. or / expected"); return;
           case 14: displayln(" <, =<, >, or >= expected"); return;
           case 15: displayln(" var, int, float, floatE expecte"); return;  
        }
    }

    public static void main(String argv[])
    {
        // argv[0]: input file containing an assignment list
        // argv[1]: output file displaying the parse tree
        
        setIO( argv[0], argv[1]  );
        setLex();

        getToken();

        Clauses clauses = clauses(); // build a parse tree
        if ( ! t.isEmpty() )
            errorMsg(5);
        else if ( ! errorSignal )
            clauses.printParseTree(""); // print the parse tree in linearly indented form in argv[1] file

        closeIO();
    }
}

