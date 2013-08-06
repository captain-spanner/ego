package ego

import (
	"go/ast"
)

type Stmt struct {
	Op Stmts
	Orig ast.Stmt
	Subs []*Dir
	Load interface {}
}

type Stmts byte

const (
	Sxxxx Stmts = iota

	Sassign	
)

func cvtStmt(o ast.Stmt) *Stmt {
	s := new(Stmt)
	s.Orig = o
	switch t := o.(type) {
	case *ast.AssignStmt:
		s.Op = Sassign
		l := cvtExprs(t.Lhs)
		r := cvtExprs(t.Rhs)
		s.Subs = makeAssign(t.Tok, l, r)
	}
	return s
}
