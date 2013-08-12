package ego

//
//	Copyright(C) 2013 Bruce Ellis. All rights reserved.
//	No unauthorized commercial use permitted.
//

import (
	"go/ast"
)

type Stmt struct {
	Op Stmts
	Orig ast.Stmt
	Body *Dir
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
		s.Body = makeAssign(t.Tok, l, r)
	}
	return s
}

func CvtStmts(l []ast.Stmt) []*Stmt {
	r := make([]*Stmt, len(l))
	for i, s := range l {
		r[i] = cvtStmt(s)
	}
	return r
}
