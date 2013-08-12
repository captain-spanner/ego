package ego

//
//	Copyright(C) 2013 Bruce Ellis. All rights reserved.
//	No unauthorized commercial use permitted.
//

import (
	"go/ast"
)

type Func struct {
	Orig *ast.FuncDecl
	Body []*Stmt
	Load interface {}
}

func cvtFunc(o *ast.FuncDecl) *Func {
	f := new(Func)
	f.Orig = o
	v := o.Body.List
	b := make([]*Stmt, len(v))
	for i, s := range v {
		b[i] = cvtStmt(s)
	}
	return f
}
