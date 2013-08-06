package ego

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
