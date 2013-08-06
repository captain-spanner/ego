package ego

import (
	"go/ast"
	"go/token"
)

type Expr struct {
	Op Exprs
	Orig ast.Expr
	Left, Right *Expr
	Load interface {}
}

type Exprs byte

const (
	Exxxx Exprs = iota
)

type Dir struct {
	Op Dirs
}

type Dirs byte

const (
	Dxxxx Dirs = iota
)

func cvtExpr(o ast.Expr) *Expr {
	x := new(Expr)
	x.Orig = o
	return x
}

func cvtExprs(v []ast.Expr) []*Expr {
	r := make([]*Expr, len(v))
	for i, o := range v {
		r[i] = cvtExpr(o)
	}
	return r
}

func makeAssign(t token.Token, l, r []*Expr) []*Dir {
	return nil
}
