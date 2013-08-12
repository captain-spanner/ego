package ego

//
//	Copyright(C) 2013 Bruce Ellis. All rights reserved.
//	No unauthorized commercial use permitted.
//

import (
	"go/ast"
	"go/token"
)

type Expr struct {
	Op Exprs
	Orig ast.Expr
	Left, Right *Expr
	Data interface {}
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
	switch e := o.(type) {
	case *ast.BadExpr:
		_ = e
		Bomb("BadExpr")

	case *ast.Ident:
		_ = e

	case *ast.BinaryExpr:
		_ = e

	case *ast.StarExpr:
		_ = e

	case *ast.UnaryExpr:
		_ = e

	case *ast.BasicLit:
		_ = e

	case *ast.FuncLit:
		_ = e

	case *ast.ParenExpr:
		_ = e

	case *ast.SelectorExpr:
		_ = e

	case *ast.TypeAssertExpr:
		_ = e

	case *ast.IndexExpr:
		_ = e

	case *ast.SliceExpr:
		_ = e

	case *ast.CallExpr:
		_ = e

	default:
		Bomb("Unknown Expr")
	}
	return x
}

func cvtExprs(v []ast.Expr) []*Expr {
	r := make([]*Expr, len(v))
	for i, o := range v {
		r[i] = cvtExpr(o)
	}
	return r
}

func makeAssign(t token.Token, l, r []*Expr) *Dir {
	return nil
}
