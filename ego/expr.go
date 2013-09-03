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

	unary_begin
	Euadd
	Eusub
	Enot
	unary_end

	binary_begin
	Eadd
	Esub
	Emul
	Equo
	Erem
	Eand
	Eor
	Exor
	Eshl
	Eshr
	Eand_not
	Eland
	Elor
	Eeql
	Elss
	Egtr
	Eneq
	Eleq
	Egeq
	binary_end

	Estar
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
		cmp := false
		shift := false
		switch e.Op {
		case token.ADD:
			x.Op = Eadd
		case token.SUB:
			x.Op = Esub
		case token.MUL:
			x.Op = Emul
		case token.QUO:
			x.Op = Equo
		case token.REM:
			x.Op = Erem
		case token.AND:
			x.Op = Eand
		case token.OR:
			x.Op = Eor
		case token.XOR:
			x.Op = Exor
		case token.SHL:
			x.Op = Eshl
			shift = true
		case token.SHR:
			x.Op = Eshr
			shift = true
		case token.AND_NOT:
			x.Op = Eand_not
		case token.LAND:
			x.Op = Eland
			cmp = true
		case token.LOR:
			x.Op = Elor
			cmp = true
		case token.EQL:
			x.Op = Eeql
			cmp = true
		case token.LSS:
			x.Op = Elss
			cmp = true
		case token.GTR:
			x.Op = Egtr
			cmp = true
		case token.NEQ:
			x.Op = Eneq
			cmp = true
		case token.LEQ:
			x.Op = Eleq
			cmp = true
		case token.GEQ:
			x.Op = Egeq
			cmp = true
		default:
			Bomb("BinaryExpr")
		}
		l := cvtExpr(e.X)
		r := cvtExpr(e.Y)
		x.Left = l
		x.Right = r
		_, _ = cmp, shift

	case *ast.StarExpr:
		x.Op = Estar
		l := cvtExpr(e.X)
		x.Left = l

	case *ast.UnaryExpr:
		switch e.Op {
		case token.ADD:
			x.Op = Euadd
		case token.SUB:
			x.Op = Eusub
		case token.NOT:
			x.Op = Enot
		default:
			Bomb("UnaryExpr")
		}
		l := cvtExpr(e.X)
		x.Left = l

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
